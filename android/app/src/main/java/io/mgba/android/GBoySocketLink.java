/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 官方 WiFi 直连，逐条对应 {@code KpHwm4/A2egSU.java}（服务端）与
 * {@code KpHwm4/AmA8tU.java}（客户端）。
 *
 * <p>官方在 {@code java.net.Socket} 外面套一层 {@code InputStream}/{@code OutputStream}，
 * 用 {@code 4 字节大端长度 + u16 type + payload} 的 GBoy 帧通信：</p>
 *
 * <ul>
 *   <li>客户端连接：{@code Socket.connect(host, port, 10000)}（AmA8tU:92）、
 *       {@code setSoTimeout(500)}（:93）、{@code setTcpNoDelay(true)}（:94）；</li>
 *   <li>服务端 accept：{@code setSoTimeout(500)} + {@code setTcpNoDelay(true)}
 *       （A2egSU:64-67）；</li>
 *   <li>读超时：{@code BTvldC/ADYaiT.java:79-101} 连续 8 次静默超时判对端
 *       不可达（500ms × 8）；</li>
 *   <li>断线重连：{@code AmA8tU.ARc23Z(Socket):263-272} 先写裸 10 字节
 *       {@code int32 6 + int16 100 + int32 rtt}，再进入读循环。</li>
 * </ul>
 *
 * <p>帧由 {@link GBoyFrames.Reader} 增量切分，收到的 body 交给
 * {@link GBoyLinkSession#onFrameBody(byte[])}；发送走队列，模拟线程永不阻塞在
 * socket 写上（队列满丢最旧一帧，与官方的背压一致）。</p>
 *
 * <p>纯 JDK socket，无 Android 依赖（除了日志），所以整套握手/按键交换可以在
 * 本机回环上跑 JVM 测试。</p>
 */
public final class GBoySocketLink implements GBoyLinkSession.Transport {

    private static final String TAG = "GBoySocketLink";

    /** Frames queued before back-pressure starts dropping the oldest. */
    public static final int OUTBOX_CAPACITY = 256;
    /** 官方 {@code AmA8tU.java:92} 的 10 秒连接超时。 */
    private static final int CONNECT_TIMEOUT_MS = 10000;
    /** 官方 {@code AmA8tU.java:93} / {@code A2egSU.java:65} 的 500ms 读超时。 */
    private static final int READ_TIMEOUT_MS = 500;
    /** 官方 {@code ADYaiT.java:88}：连续 8 次静默超时判对端不可达。 */
    private static final int SILENT_TIMEOUT_LIMIT = 8;
    /** 官方 {@code AmA8tU.java:107}：重连窗口 50 秒。 */
    private static final long RECONNECT_WINDOW_MS = 50000;
    /** 官方 {@code AmA8tU.java:114}：两次重试之间睡 2 秒。 */
    private static final long RECONNECT_DELAY_MS = 2000;
    private static final int READ_BUFFER = 2048;

    private final GBoyLinkSession session;
    private final GBoyFrames.Reader reader = new GBoyFrames.Reader();
    private final BlockingQueue<byte[]> outbox = new ArrayBlockingQueue<>(OUTBOX_CAPACITY);
    private final AtomicBoolean running = new AtomicBoolean();
    private final AtomicBoolean handshakeDone = new AtomicBoolean();
    private final AtomicLong received = new AtomicLong();

    private volatile Socket socket;
    private volatile InputStream input;
    private volatile OutputStream output;
    private volatile ServerSocket server;
    private volatile Thread acceptThread;
    private volatile Thread readThread;
    private volatile Thread writeThread;
    private volatile String lastError = "";
    /** 客户端模式记住对端，断线后按官方流程重连；服务端为 null。 */
    private volatile String peerHost;
    private volatile int peerPort;
    /** 最近一次 type 3 带回来的 RTT，重连握手包里要带出去（官方 -1 = 未知）。 */
    private volatile int lastRtt = -1;

    public GBoySocketLink(int localSlot, int playerCount, GBoyLinkSession.Events events) {
        session = new GBoyLinkSession(this, events, localSlot, playerCount);
    }

    public GBoyLinkSession session() {
        return session;
    }

    /**
     * Listens on {@code port} and accepts one peer. Pass 0 to let the OS pick a
     * free port; {@link #port()} reports the actual one. Non-blocking.
     *
     * <p>官方 {@code A2egSU.java:64-67}：accept 之后立刻 {@code setSoTimeout(500)}
     * 与 {@code setTcpNoDelay(true)}。</p>
     */
    public int startHost(int port) throws IOException {
        ServerSocket listener = new ServerSocket(port);
        server = listener;
        running.set(true);
        Thread accept = new Thread(() -> {
            try {
                Socket peer = listener.accept();
                peer.setSoTimeout(READ_TIMEOUT_MS);
                peer.setTcpNoDelay(true);
                if (running.get()) {
                    open(peer);
                } else {
                    peer.close();
                }
            } catch (IOException e) {
                if (running.get()) {
                    lastError = String.valueOf(e.getMessage());
                }
            }
        }, "gboy-socket-accept");
        accept.setDaemon(true);
        acceptThread = accept;
        accept.start();
        return listener.getLocalPort();
    }

    /**
     * Connects to the peer and sends the official registration frame
     * ({@code type 1, int 6}). Retries the connect on later drops like
     * {@code AmA8tU.A4TApA()} does, but the first attempt keeps the synchronous
     * contract callers and tests rely on.
     */
    public void startJoin(String host, int port) throws IOException {
        running.set(true);
        peerHost = host;
        peerPort = port;
        final Socket[] connected = new Socket[1];
        final IOException[] failure = new IOException[1];
        Thread connector = new Thread(() -> {
            Socket peer = new Socket();
            try {
                peer.connect(new InetSocketAddress(host, port), CONNECT_TIMEOUT_MS);
                // 官方 AmA8tU:93-94
                peer.setSoTimeout(READ_TIMEOUT_MS);
                peer.setTcpNoDelay(true);
                connected[0] = peer;
            } catch (IOException e) {
                failure[0] = e;
                try {
                    peer.close();
                } catch (IOException ignored) {
                }
            }
        }, "gboy-socket-connect");
        connector.setDaemon(true);
        connector.start();
        try {
            connector.join(CONNECT_TIMEOUT_MS + 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            running.set(false);
            throw new IOException("interrupted while connecting", e);
        }
        Socket peer = connected[0];
        if (peer == null) {
            running.set(false);
            throw failure[0] != null ? failure[0] : new IOException("connect timed out");
        }
        open(peer);
        session.sendSocketHandshake();
    }

    /** Attaches a live socket and starts the I/O threads (only once). */
    private synchronized void open(Socket peer) throws IOException {
        socket = peer;
        input = peer.getInputStream();
        output = peer.getOutputStream();
        if (readThread != null) {
            return;
        }
        Thread read = new Thread(this::pumpInput, "gboy-socket-read");
        Thread write = new Thread(this::pumpOutput, "gboy-socket-write");
        read.setDaemon(true);
        write.setDaemon(true);
        readThread = read;
        writeThread = write;
        read.start();
        write.start();
    }

    private void pumpInput() {
        byte[] buffer = new byte[READ_BUFFER];
        int silent = 0;
        while (running.get()) {
            Socket peer = socket;
            InputStream in = input;
            if (peer == null || in == null) {
                if (!reconnect()) {
                    break;
                }
                silent = 0;
                continue;
            }
            int n;
            try {
                n = in.read(buffer);
                silent = 0;
            } catch (SocketTimeoutException e) {
                // 官方 ADYaiT.A5SV6n:85-92：500ms 静默累计 8 次判对端不可达。
                // 只有客户端能重连，服务端断掉就没人再 accept 了，所以这里只对
                // 客户端执行「判死」，服务端继续等（避免暂停几秒就自断链路）。
                if (++silent >= SILENT_TIMEOUT_LIMIT) {
                    silent = 0;
                    if (peerHost != null) {
                        lastError = "连续 " + SILENT_TIMEOUT_LIMIT + " 次静默超时，判定对端不可达";
                        Log.w(TAG, lastError);
                        drop(peer);
                    }
                }
                continue;
            } catch (IOException e) {
                if (!running.get()) {
                    break;
                }
                lastError = String.valueOf(e.getMessage());
                drop(peer);
                if (!reconnect()) {
                    break;
                }
                silent = 0;
                continue;
            }
            if (n <= 0) {
                drop(peer);
                if (!reconnect()) {
                    break;
                }
                silent = 0;
                continue;
            }
            reader.append(buffer, n);
            byte[] body;
            while ((body = reader.next()) != null) {
                received.incrementAndGet();
                session.onFrameBody(body);
                if (GBoyFrames.typeOf(body) == GBoyFrames.TYPE_READY) {
                    lastRtt = GBoyFrames.intOf(body);
                }
                if (GBoyFrames.typeOf(body) == GBoyFrames.TYPE_REGISTER) {
                    boolean wasHost = server != null;
                    boolean first = handshakeDone.compareAndSet(false, true);
                    // Only the listening side answers; the joining side
                    // started the exchange. Both then consider it ready.
                    if (wasHost && first) {
                        session.sendSocketHandshake();
                    }
                }
            }
        }
    }

    private void pumpOutput() {
        while (running.get()) {
            try {
                byte[] frame = outbox.poll(200, TimeUnit.MILLISECONDS);
                if (frame == null) {
                    continue;
                }
                OutputStream out = output;
                Socket peer = socket;
                if (out == null || peer == null || peer.isClosed()) {
                    // 断线期间产生的按键帧直接丢弃：官方发送线程同样是写失败
                    // 就丢，重连后不重放旧帧（重放会让镜像核倒着走）。
                    continue;
                }
                out.write(frame);
                out.flush();
            } catch (IOException e) {
                if (running.get()) {
                    lastError = String.valueOf(e.getMessage());
                }
                Socket peer = socket;
                if (peer != null) {
                    drop(peer);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    /**
     * 官方断线重连：{@code AmA8tU.ARc23Z(Socket):263-272} 先写裸 10 字节
     * {@code int32 6 + int16 100 + int32 rtt}，再继续读循环。窗口 50 秒、
     * 每 2 秒重试一次（{@code AmA8tU:107/114}）。
     *
     * @return true = 已重连；false = 服务端模式或窗口耗尽。
     */
    private synchronized boolean reconnect() {
        String host = peerHost;
        int port = peerPort;
        if (host == null || host.isEmpty() || port <= 0) {
            return false;
        }
        long deadline = System.currentTimeMillis() + RECONNECT_WINDOW_MS;
        Log.i(TAG, "reconnecting to " + host + ":" + port);
        while (running.get() && System.currentTimeMillis() < deadline) {
            Socket peer = new Socket();
            try {
                peer.connect(new InetSocketAddress(host, port), CONNECT_TIMEOUT_MS);
                peer.setSoTimeout(READ_TIMEOUT_MS);
                peer.setTcpNoDelay(true);
                OutputStream out = peer.getOutputStream();
                // 官方 ARc23Z(Socket): 重连握手包，接收侧按 type 100 认。
                out.write(GBoyFrames.reconnectFrame(lastRtt));
                out.flush();
                socket = peer;
                input = peer.getInputStream();
                output = out;
                // 旧连接上可能残留半帧；不丢弃会把新流的第一帧切错位。
                reader.reset();
                handshakeDone.set(true);
                Log.i(TAG, "reconnected, sent type " + GBoyFrames.TYPE_RECONNECT
                        + " rtt=" + lastRtt);
                return true;
            } catch (IOException e) {
                lastError = String.valueOf(e.getMessage());
                try {
                    peer.close();
                } catch (IOException ignored) {
                }
                try {
                    Thread.sleep(RECONNECT_DELAY_MS);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
        }
        return false;
    }

    /** Detaches {@code peer} (if still current) and closes it. */
    private synchronized void drop(Socket peer) {
        if (socket == peer) {
            socket = null;
            input = null;
            output = null;
        }
        try {
            peer.close();
        } catch (IOException ignored) {
        }
    }

    /** Queues one complete wire frame. Never blocks the emulation thread. */
    @Override
    public void send(byte[] frame) {
        if (!running.get() || frame == null) {
            return;
        }
        if (!outbox.offer(frame)) {
            outbox.poll();
            outbox.offer(frame);
        }
    }

    public boolean isReady() {
        Socket s = socket;
        return handshakeDone.get() && s != null && s.isConnected() && !s.isClosed();
    }

    public boolean isConnected() {
        Socket s = socket;
        return s != null && s.isConnected() && !s.isClosed();
    }

    /** 链路已被主动关闭（供 {@link GBoyCloudLink#startTcp} 的生命周期循环用）。 */
    public boolean isClosed() {
        return !running.get();
    }

    public int port() {
        ServerSocket s = server;
        return s == null ? -1 : s.getLocalPort();
    }

    public String lastError() {
        return lastError;
    }

    public int queuedFrames() {
        return outbox.size();
    }

    /** Complete frame bodies received from the peer, for link diagnostics. */
    public long receivedFrames() {
        return received.get();
    }

    public void close() {
        running.set(false);
        ServerSocket listener = server;
        server = null;
        if (listener != null) {
            try {
                listener.close();
            } catch (IOException ignored) {
            }
        }
        Socket s = socket;
        socket = null;
        input = null;
        output = null;
        if (s != null) {
            try {
                s.close();
            } catch (IOException ignored) {
            }
        }
        outbox.clear();
        interrupt(acceptThread);
        interrupt(readThread);
        interrupt(writeThread);
    }

    private static void interrupt(Thread t) {
        if (t != null) {
            t.interrupt();
        }
    }
}
