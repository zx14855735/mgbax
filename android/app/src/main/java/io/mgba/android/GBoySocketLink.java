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
    /** 键帧/控制帧的最大长度；超过它的帧（type 6 状态包）断线时不能丢。 */
    private static final int CONTROL_FRAME_MAX = 64;

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
     * Listens on {@code port} and accepts peers until {@link #close()}.
     * Pass 0 to let the OS pick a free port; {@link #port()} reports the actual
     * one. Non-blocking.
     *
     * <p>官方 {@code A2egSU.java:64-67}：accept 之后立刻 {@code setSoTimeout(500)}
     * 与 {@code setTcpNoDelay(true)}。</p>
     *
     * <p>与官方的一次性 accept 有一处有意扩展：这里循环 accept，对端掉线后
     * 新连接仍能接进来，否则客户端 {@code AmA8tU} 的 50 秒重连窗口会连到一个
     * 「TCP 握手成功但没人读」的监听 socket 上，表现为连上却永远收不到帧。
     * 退出条件只有 {@link #close()}；对端掉线不会结束 accept 线程。</p>
     */
    public int startHost(int port) throws IOException {
        ServerSocket listener = new ServerSocket(port);
        server = listener;
        running.set(true);
        final int boundPort = listener.getLocalPort();
        Thread accept = new Thread(() -> {
            try {
                while (running.get()) {
                    Socket peer = listener.accept();
                    peer.setSoTimeout(READ_TIMEOUT_MS);
                    peer.setTcpNoDelay(true);
                    if (!running.get()) {
                        peer.close();
                        break;
                    }
                    synchronized (this) {
                        // 已有活着的会话时拒绝第二路连接，避免把正在跑的对端
                        // 直接顶掉；只有旧 socket 已关闭（掉线）才接受重连。
                        if (socket != null && !socket.isClosed() && input != null) {
                            peer.close();
                            continue;
                        }
                    }
                    try {
                        attach(peer);
                    } catch (IOException e) {
                        // 某一个对端在 attach 期间就没了，不能因此结束整个监听。
                        lastError = String.valueOf(e.getMessage());
                        try {
                            peer.close();
                        } catch (IOException ignored) {
                        }
                    }
                }
            } catch (IOException e) {
                // close() 会关掉 listener 让 accept 抛异常；此时 running 已为 false。
                if (running.get()) {
                    lastError = String.valueOf(e.getMessage());
                }
            }
        }, "gboy-socket-accept");
        accept.setDaemon(true);
        acceptThread = accept;
        accept.start();
        return boundPort;
    }

    /**
     * Connects to the peer and sends the official registration frame
     * ({@code type 1, int 6}).
     *
     * <p>官方 {@code AmA8tU.A4TApA()} 的首次连接是<b>单次</b>：connect 失败时
     * {@code if (!f4332B9tovu) throw e}（95-98 行）直接抛出，不进入 2s/50s
     * 窗口；那个窗口只用于「曾经连上过、之后掉线」的重连（{@code ARc23Z}）。
     * 所以这里首次也只用 10 秒连接超时，失败立刻交给上层报错。</p>
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
            connector.interrupt();
            throw new IOException("interrupted while connecting", e);
        }
        Socket peer = connected[0];
        if (peer == null) {
            running.set(false);
            connector.interrupt();
            throw failure[0] != null ? failure[0] : new IOException("connect timed out");
        }
        attach(peer);
        session.sendSocketHandshake();
    }

    /**
     * Attaches a live socket (first connection or a re-accepted one) and starts
     * the I/O threads on first use.
     *
     * <p>重连时旧读线程可能正卡在已关闭的旧 socket 上，靠 {@link #drop} 的
     * {@code socket == peer} 身份比较避免它去清理新会话。新流上可能残留旧连接
     * 的半帧，必须 {@link GBoyFrames.Reader#reset()}，否则会被当新帧解析。</p>
     */
    private synchronized void attach(Socket peer) throws IOException {
        InputStream in = peer.getInputStream();
        OutputStream out = peer.getOutputStream();
        socket = peer;
        input = in;
        output = out;
        reader.reset();
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

    /** 服务端等 accept 线程挂上新 socket；最多睡 50ms，close() 会中断。 */
    private boolean awaitAcceptedSocket() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
        return running.get();
    }

    private void pumpInput() {
        byte[] buffer = new byte[READ_BUFFER];
        int silent = 0;
        while (running.get()) {
            Socket peer;
            InputStream in;
            // socket 与 stream 必须成对读取：重连/重 accept 时 attach() 会
            // 同时替换两者，分两次读可能把旧流配到新 socket 上。
            synchronized (this) {
                peer = socket;
                in = input;
            }
            if (peer == null || in == null) {
                // 服务端：accept 线程会挂上新连接，这里只等，不退出；客户端：
                // 按官方 AmA8tU 的 2s×50s 窗口重连。
                if (server != null) {
                    if (!awaitAcceptedSocket()) {
                        break;
                    }
                } else {
                    if (!reconnect()) {
                        // 重连窗口耗尽：置 closed，让上层生命周期循环能收尾。
                        running.set(false);
                        break;
                    }
                }
                silent = 0;
                continue;
            }
            int n;
            try {
                n = in.read(buffer);
                silent = 0;
            } catch (SocketTimeoutException e) {
                /* 官方 ADYaiT.A5SV6n:85-92：500ms 静默累计 8 次判对端不可达。
                 * 两端都要判死：服务端若不判死，半开连接（Wi-Fi 直接消失、没有
                 * FIN）会永远占着 socket，accept 循环就会一直把重连挡在门外。
                 * 判死后服务端回到等待新 socket，客户端进入 2s/50s 重连窗口。 */
                if (++silent >= SILENT_TIMEOUT_LIMIT) {
                    silent = 0;
                    lastError = "连续 " + SILENT_TIMEOUT_LIMIT + " 次静默超时，判定对端不可达";
                    Log.w(TAG, lastError);
                    drop(peer);
                }
                continue;
            } catch (IOException e) {
                if (!running.get()) {
                    break;
                }
                lastError = String.valueOf(e.getMessage());
                drop(peer);
                if (server == null && !reconnect()) {
                    running.set(false);
                    break;
                }
                silent = 0;
                continue;
            }
            if (n <= 0) {
                drop(peer);
                if (server == null && !reconnect()) {
                    running.set(false);
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
                int type = GBoyFrames.typeOf(body);
                if (type == GBoyFrames.TYPE_READY || type == GBoyFrames.TYPE_RECONNECT) {
                    // 两条路都带 RTT：type 3 是正常就绪，type 100 是重连握手。
                    lastRtt = GBoyFrames.intOf(body);
                }
                if (type == GBoyFrames.TYPE_REGISTER) {
                    boolean wasHost = server != null;
                    boolean first = handshakeDone.compareAndSet(false, true);
                    /* 只有监听端回声；客户端发起方不回声。官方 B25kr6:122-130：
                     * 首次发 type 1(6)；已在房内（重连走完整握手而非 type 100）
                     * 时，只有收到 type 1 且值为 6 才再回一次。 */
                    if (wasHost && (first
                            || GBoyFrames.intOf(body) == GBoyLinkSession.SOCKET_HANDSHAKE_VALUE)) {
                        session.sendSocketHandshake();
                    }
                }
            }
        }
    }

    private void pumpOutput() {
        while (running.get()) {
            Socket peer = null;
            try {
                byte[] frame = outbox.poll(200, TimeUnit.MILLISECONDS);
                if (frame == null) {
                    continue;
                }
                OutputStream out;
                synchronized (this) {
                    out = output;
                    peer = socket;
                }
                if (out == null || peer == null || peer.isClosed()) {
                    /* 断线期间的按键帧直接丢（官方发送线程同样是写失败就丢，
                     * 重放旧按键会让镜像核倒着走）。但整份 savestate（type 6，
                     * 几百 KiB）绝不能在断线窗口里丢：4 核房间重建后那头
                     * sendInitialState 可能正好落在断线重连的几秒里，丢了就
                     * 回到「两核不在同一幕」的老 bug。这里把它放回队列等重连。 */
                    if (frame.length > CONTROL_FRAME_MAX) {
                        if (!outbox.offer(frame)) {
                            outbox.poll();
                            outbox.offer(frame);
                        }
                    }
                    continue;
                }
                out.write(frame);
                out.flush();
            } catch (IOException e) {
                if (running.get()) {
                    lastError = String.valueOf(e.getMessage());
                }
                // 只清掉自己这一代 socket；期间若已重 accept，drop 的身份比较
                // 会让它成为 no-op，不会误关新会话。
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
