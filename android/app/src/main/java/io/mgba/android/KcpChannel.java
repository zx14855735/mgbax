/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * KCP over UDP - the transport gboy.top's cloud rooms use.
 *
 * The parameters and the byte order are taken from the official GBoy client
 * (see {@code .workbuddy/gboy/PROTOCOL.md}):
 *
 * <ul>
 *   <li>KCP header in <b>big endian</b>: conv, cmd, frg, wnd, ts, sn, una, len</li>
 *   <li>MTU 512, so MSS 488</li>
 *   <li>update interval 30 ms</li>
 *   <li>send and receive window 128</li>
 *   <li>the conversation id is a random positive int</li>
 * </ul>
 *
 * On top of that sits GBoy's own handshake: the client sends {@code "HS"},
 * the node answers {@code "HK"}, both retry three times with three seconds
 * in between. A one second {@code PING}/{@code PONG} heartbeat keeps the
 * session alive and {@code "DISC"} closes it.
 *
 * The KCP core itself is a straight port of the reference algorithm:
 * segmentation, ACK tracking, RTO retransmit, in-order receive with fragment
 * reassembly.
 */
final class KcpChannel implements GBoyCloudLink.Link {
    private static final String TAG = "GBoyKcp";

    static final byte[] HS = {'H', 'S'};
    static final byte[] HK = {'H', 'K'};
    static final byte[] PING = {'P', 'I', 'N', 'G'};
    static final byte[] PONG = {'P', 'O', 'N', 'G'};
    static final byte[] DISC = {'D', 'I', 'S', 'C'};

    /** Frame-level tracing for link debugging; keep it cheap (a few lines per second). */
    private static final boolean TRACE = true;

    private static final int OVERHEAD = 24;
    private static final int CMD_PUSH = 81;
    private static final int CMD_ACK = 82;
    private static final int CMD_WASK = 83;
    private static final int CMD_WINS = 84;

    /** Official GBoy parameters. */
    private static final int MTU = 512;
    private static final long INTERVAL_MS = 30;
    private static final int WND = 128;
    private static final int HANDSHAKE_TRIES = 3;
    private static final long HANDSHAKE_WAIT_MS = 3000;

    private final Kcp kcp;
    private final DatagramSocket socket;
    /** TCP transport: used when the relay is reached through a tunnel. */
    private final Socket stream;
    private InetAddress address;
    private final int port;
    private final LinkedBlockingQueue<byte[]> inbox = new LinkedBlockingQueue<byte[]>();
    private volatile boolean running = true;
    private volatile boolean handshakeDone;
    private volatile boolean dead;
    private final Thread thread;

    private KcpChannel(InetAddress address, int port, int conv) throws IOException {
        this.address = address;
        this.port = port;
        this.kcp = new Kcp(conv, MTU, INTERVAL_MS);
        this.socket = new DatagramSocket();
        this.socket.setSoTimeout(5);
        this.stream = null;
        this.thread = new Thread(this::loop, "lobby-kcp");
        this.thread.setDaemon(true);
        this.thread.start();
    }

    /**
     * TCP transport. Used when the relay is published through a TCP tunnel
     * (ssh -R / bore), because those cannot carry UDP. Each payload is framed
     * with a big-endian {@code u32} length so the stream stays message aligned.
     */
    private KcpChannel(InetAddress address, int port, boolean tcp) throws IOException {
        this.address = address;
        this.port = port;
        this.kcp = null;
        this.socket = null;
        Socket opened = new Socket();
        opened.connect(new java.net.InetSocketAddress(address, port), 8000);
        opened.setTcpNoDelay(true);
        opened.setSoTimeout(0);
        this.stream = opened;
        this.thread = new Thread(this::streamLoop, "lobby-tcp");
        this.thread.setDaemon(true);
        this.thread.start();
    }

    private KcpChannel(InetAddress address, int port) throws IOException {
        // GBoy picks the conversation id the same way: a random positive int.
        this(address, port, java.util.UUID.randomUUID().hashCode() & Integer.MAX_VALUE);
    }

    /** Opens a session with an explicit conversation id and completes HS/HK. */
    static KcpChannel connect(InetAddress address, int port, int conv) throws IOException {
        return connect(new KcpChannel(address, port, conv));
    }

    /**
     * Opens a session <em>without</em> the handshake, so the caller can retry on
     * the very same conversation id and UDP port.
     *
     * The relay keeps a tiny, slowly recycled session table. Every retry that
     * builds a brand new session fills that table with half open leftovers,
     * and once it is full the relay silently drops the newcomer - the room
     * then looks permanently dead. Retrying on one session avoids that.
     */
    static KcpChannel open(InetAddress address, int port, int conv) throws IOException {
        return new KcpChannel(address, port, conv);
    }

    /**
     * Re-sends {@code HS} on the current session and waits for {@code HK}.
     * Returns false when the relay stayed silent for the whole timeout.
     */
    boolean retryHandshake(long timeoutMs) throws IOException {
        long deadline = System.currentTimeMillis() + Math.max(timeoutMs, 1);
        while (System.currentTimeMillis() < deadline) {
            // 【裸 HS】中继的握手是裸数据报（2026-11-07 对新中继实测：裸 HS
            // 立刻回裸 HK；KCP 段承载的 HS 反而没有回应）。数据帧仍走 KCP。
            if (kcp != null) {
                rawDatagramSend(HS);
            } else {
                rawSend(HS);
            }
            long stepEnd = Math.min(deadline, System.currentTimeMillis() + 2000);
            while (System.currentTimeMillis() < stepEnd) {
                if (handshakeDone) {
                    return true;
                }
                if (dead) {
                    throw new IOException("中继连接中断");
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IOException("中继握手被中断");
                }
            }
        }
        return handshakeDone;
    }

    /** Opens a session with a random conversation id and completes HS/HK. */
    static KcpChannel connect(InetAddress address, int port) throws IOException {
        return connect(new KcpChannel(address, port));
    }

    /** Opens a TCP session (relay reached through a TCP tunnel) and does HS/HK. */
    static KcpChannel connectTcp(InetAddress address, int port) throws IOException {
        return connect(new KcpChannel(address, port, true));
    }

    private static KcpChannel connect(KcpChannel channel) throws IOException {
        try {
            boolean ok = false;
            for (int attempt = 0; attempt < HANDSHAKE_TRIES && !ok; attempt++) {
                channel.rawSend(HS);
                long deadline = System.currentTimeMillis() + HANDSHAKE_WAIT_MS;
                while (System.currentTimeMillis() < deadline) {
                    if (channel.handshakeDone) {
                        ok = true;
                        break;
                    }
                    if (channel.dead) {
                        throw new IOException("中继连接中断");
                    }
                    Thread.sleep(50);
                }
            }
            if (!ok) {
                channel.close();
                throw new IOException("中继握手超时（服务器未回应）");
            }
            return channel;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            channel.close();
            throw new IOException("中继握手被中断");
        }
    }

    /** Queues a payload; the pump thread transmits it. */
    @Override
    public void send(byte[] payload) {
        rawSend(payload);
    }

    /** Transport-agnostic send: UDP goes through KCP, TCP writes a framed blob. */
    private void rawSend(byte[] payload) {
        if (kcp != null) {
            kcp.send(payload);
            return;
        }
        rawDatagramSend(payload);
    }

    /** UDP send that bypasses KCP entirely: the relay's HS/HK control datagrams
     * are raw, not KCP segments (verified against the live relay 2026-11-07). */
    private void rawDatagramSend(byte[] payload) {
        try {
            socket.send(new DatagramPacket(payload, payload.length, address, port));
        } catch (IOException e) {
            Log.i(TAG, "raw datagram send failed " + e);
        }
    }

    private void streamLoop() {
        byte[] head = new byte[4];
        try {
            java.io.InputStream in = stream.getInputStream();
            while (running) {
                if (!readFully(in, head, 4)) {
                    break;
                }
                int length = getInt(head, 0);
                // TYPE_STATE carries a full GBA save-state blob (hundreds of
                // KiB); keep the same bound as GBoyFrames.Reader so a state
                // transfer does not tear down the stream.
                if (length <= 0 || length > GBoyFrames.MAX_FRAME_LENGTH) {
                    Log.i(TAG, "bad stream frame length " + length);
                    break;
                }
                byte[] body = new byte[length];
                if (!readFully(in, body, length)) {
                    break;
                }
                deliver(body);
            }
        } catch (IOException e) {
            if (running) {
                Log.i(TAG, "stream closed " + e);
            }
        }
        dead = true;
        running = false;
    }

    private static boolean readFully(java.io.InputStream in, byte[] buffer, int length)
            throws IOException {
        int done = 0;
        while (done < length) {
            int read = in.read(buffer, done, length - done);
            if (read < 0) {
                return false;
            }
            done += read;
        }
        return true;
    }

    /** Next payload from the peer, or null after {@code timeoutMs}. */
    @Override
    public byte[] recv(long timeoutMs) {
        try {
            return inbox.poll(timeoutMs, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    /** True once the channel was closed (the relay loop must stop). */
    @Override
    public boolean isClosed() {
        return !running;
    }

    @Override
    public void close() {
        // 这里原来第一行是 `if (!running) return;`。但 running 会被 loop() /
        // streamLoop() 在对端断开时自己置成 false —— 于是「对端先断、再关
        // 房间」这条路直接返回，下面的 socket.close() / stream.close() 一行都
        // 不执行，描述符就漏了。反复联机掉线会把 fd 耗尽（表现为之后连什么都
        // 失败），PC 端同源实现在这条路径上更严重（std::thread 仍 joinable，
        // 析构直接 terminate）。
        //
        // 现在只用 wasRunning 决定「要不要发 DISC」，关闭资源无条件执行。
        boolean wasRunning = running;
        running = false;
        if (wasRunning && kcp != null) {
            try {
                kcp.send(DISC);
                flush();
            } catch (IOException ignored) {
            }
            try {
                socket.close();
            } catch (Exception ignored) {
            }
        }
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception ignored) {
            }
        }
        thread.interrupt();
    }

    private static String hex(byte[] data, int max) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < Math.min(max, data.length); i++) {
            out.append(String.format("%02x", data[i]));
        }
        return out.toString();
    }

    private void flush() throws IOException {
        for (byte[] datagram : kcp.update(System.currentTimeMillis())) {
            socket.send(new DatagramPacket(datagram, datagram.length, address, port));
        }
    }

    private void loop() {
        byte[] buffer = new byte[2048];
        long lastPing = 0;
        while (running) {
            long now = System.currentTimeMillis();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet);
                byte[] data = Arrays.copyOf(packet.getData(), packet.getLength());
                // 【裸控制报】中继的 HS/HK/PING/PONG 是裸数据报（不是 KCP 段）：
                // 直接喂 kcp.input 会因为过不了 KCP 头解析而被静默丢弃。HK 必须
                // 在这里认领，否则握手永远完不成（2026-11-07 对新中继实测）。
                if (handleRawControl(data)) {
                    continue;
                }
                if (TRACE && data.length >= OVERHEAD) {
                    Log.d(TAG, "in cmd=" + (data[4] & 0xFF) + " sn=" + getInt(data, 12)
                            + " len=" + getInt(data, 20) + " size=" + data.length
                            + " conv=" + Integer.toHexString(getInt(data, 0)));
                }
                kcp.input(data);
            } catch (IOException ignored) {
                // receive timeout: fall through and keep the session alive
            }
            byte[] message;
            while ((message = kcp.recv()) != null) {
                deliver(message);
            }
            if (handshakeDone && now - lastPing >= 1000) {
                lastPing = now;
                kcp.send(PING);
            }
            try {
                flush();
            } catch (IOException e) {
                if (running) {
                    Log.i(TAG, "flush failed " + e);
                    dead = true;
                    running = false;
                }
                return;
            }
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    /** 裸控制报（HK/PING/PONG）识别与应答；返回 true 表示已消费、不要进 KCP。 */
    private boolean handleRawControl(byte[] data) {
        if (data.length == 0) {
            return false;
        }
        if (data.length == 2 && data[0] == 'H' && data[1] == 'K') {
            handshakeDone = true;
            return true;
        }
        if (Arrays.equals(data, PING)) {
            rawDatagramSend(PONG);
            return true;
        }
        if (Arrays.equals(data, PONG)) {
            return true;
        }
        return false;
    }

    private void deliver(byte[] message) {
        if (TRACE) {
            Log.d(TAG, "deliver " + message.length + "B " + hex(message, 8)
                    + " handshakeDone=" + handshakeDone);
        }
        if (Arrays.equals(message, HK)) {
            handshakeDone = true;
            return;
        }
        if (Arrays.equals(message, PING)) {
            rawSend(PONG);
            return;
        }
        if (Arrays.equals(message, PONG)) {
            return;
        }
        inbox.add(message);
    }

    // ---- KCP core ----

    private static final class Seg {
        int conv;
        int cmd;
        int frg;
        int wnd;
        int ts;
        int sn;
        int una;
        byte[] data;
        long resendts;
        long rto;
        int xmit;

        byte[] encode() {
            byte[] out = new byte[OVERHEAD + data.length];
            putInt(out, 0, conv);
            out[4] = (byte) cmd;
            out[5] = (byte) frg;
            putShort(out, 6, wnd);
            putInt(out, 8, ts);
            putInt(out, 12, sn);
            putInt(out, 16, una);
            putInt(out, 20, data.length);
            System.arraycopy(data, 0, out, OVERHEAD, data.length);
            return out;
        }
    }

    /** Big endian, exactly like the official client. */
    private static void putInt(byte[] out, int off, int value) {
        out[off] = (byte) (value >>> 24);
        out[off + 1] = (byte) (value >>> 16);
        out[off + 2] = (byte) (value >>> 8);
        out[off + 3] = (byte) value;
    }

    private static void putShort(byte[] out, int off, int value) {
        out[off] = (byte) (value >>> 8);
        out[off + 1] = (byte) value;
    }

    private static int getInt(byte[] in, int off) {
        return ((in[off] & 0xFF) << 24) | ((in[off + 1] & 0xFF) << 16)
                | ((in[off + 2] & 0xFF) << 8) | (in[off + 3] & 0xFF);
    }

    private static int getShort(byte[] in, int off) {
        return ((in[off] & 0xFF) << 8) | (in[off + 1] & 0xFF);
    }

    private static final class Kcp {
        final int conv;
        final int mss;
        final long intervalMs;
        final ArrayDeque<byte[]> sndQueue = new ArrayDeque<byte[]>();
        final ArrayList<Seg> sndBuf = new ArrayList<Seg>();
        final HashMap<Integer, Seg> rcvBuf = new HashMap<Integer, Seg>();
        final ArrayDeque<byte[]> rcvQueue = new ArrayDeque<byte[]>();
        final ArrayList<int[]> acks = new ArrayList<int[]>();
        int sndNxt;
        int rcvNxt;
        int sndUna;
        int rmtWnd = WND;
        long rto = 200;
        long nextUpdate;
        int deadLink = 64;
        int frgRemaining;
        ArrayList<byte[]> parts;
        boolean deadLinkLost;

        Kcp(int conv, int mtu, long intervalMs) {
            this.conv = conv;
            this.mss = mtu - OVERHEAD;
            this.intervalMs = intervalMs;
        }

        private int window() {
            int free = WND - rcvQueue.size() - rcvBuf.size();
            return free < 0 ? 0 : free;
        }

        synchronized void input(byte[] data) {
            if (data.length < OVERHEAD) {
                return;
            }
            int conv = getInt(data, 0);
            if (conv != this.conv) {
                return;
            }
            int cmd = data[4] & 0xFF;
            int frg = data[5] & 0xFF;
            int wnd = getShort(data, 6);
            int ts = getInt(data, 8);
            int sn = getInt(data, 12);
            int una = getInt(data, 16);
            int len = getInt(data, 20);
            if (len < 0 || len > data.length - OVERHEAD) {
                return;
            }
            byte[] payload = Arrays.copyOfRange(data, OVERHEAD, OVERHEAD + len);
            rmtWnd = wnd;
            ackUpTo(una - 1, -1);
            if (cmd == CMD_ACK) {
                ackUpTo(sn, ts);
            } else if (cmd == CMD_PUSH) {
                acks.add(new int[]{sn, ts});
                recvPush(sn, frg, payload);
            }
        }

        /** Drops everything the peer has acknowledged. */
        private void ackUpTo(int uptoSn, int exactTs) {
            if (exactTs >= 0) {
                for (int i = sndBuf.size() - 1; i >= 0; i--) {
                    Seg seg = sndBuf.get(i);
                    if (seg.sn == uptoSn && seg.ts == exactTs) {
                        sndBuf.remove(i);
                    }
                }
            }
            for (int i = sndBuf.size() - 1; i >= 0; i--) {
                if (sndBuf.get(i).sn <= uptoSn) {
                    sndBuf.remove(i);
                }
            }
            if (!sndBuf.isEmpty()) {
                sndUna = sndBuf.get(0).sn;
            } else {
                sndUna = sndNxt;
            }
        }

        private void recvPush(int sn, int frg, byte[] payload) {
            if (sn < rcvNxt) {
                return;
            }
            if (sn == rcvNxt) {
                deliver(sn, frg, payload);
                while (rcvBuf.containsKey(rcvNxt)) {
                    Seg seg = rcvBuf.remove(rcvNxt);
                    deliver(seg.sn, seg.frg, seg.data);
                }
            } else {
                Seg seg = new Seg();
                seg.sn = sn;
                seg.frg = frg;
                seg.data = payload;
                rcvBuf.put(sn, seg);
            }
        }

        private void deliver(int sn, int frg, byte[] payload) {
            if (frgRemaining == 0 && frg == 0) {
                rcvQueue.add(payload);
                rcvNxt = sn + 1;
                return;
            }
            if (frgRemaining == 0) {
                parts = new ArrayList<byte[]>();
                parts.add(payload);
                frgRemaining = frg;
            } else {
                parts.add(payload);
                frgRemaining--;
            }
            if (frgRemaining == 0 && parts != null) {
                int size = 0;
                for (byte[] part : parts) {
                    size += part.length;
                }
                byte[] whole = new byte[size];
                int off = 0;
                for (byte[] part : parts) {
                    System.arraycopy(part, 0, whole, off, part.length);
                    off += part.length;
                }
                rcvQueue.add(whole);
                parts = null;
            }
            rcvNxt = sn + 1;
        }

        synchronized void send(byte[] data) {
            if (data.length <= mss) {
                sndQueue.add(data);
                return;
            }
            int chunks = (data.length + mss - 1) / mss;
            for (int i = 0; i < chunks; i++) {
                int end = Math.min(data.length, (i + 1) * mss);
                sndQueue.add(Arrays.copyOfRange(data, i * mss, end));
            }
        }

        synchronized byte[] recv() {
            return rcvQueue.isEmpty() ? null : rcvQueue.poll();
        }

        synchronized List<byte[]> update(long now) {
            List<byte[]> out = new ArrayList<byte[]>();
            if (now < nextUpdate) {
                return out;
            }
            nextUpdate = now + intervalMs;
            for (int[] ack : acks) {
                Seg seg = new Seg();
                seg.conv = conv;
                seg.cmd = CMD_ACK;
                seg.sn = ack[0];
                seg.ts = ack[1];
                seg.wnd = window();
                seg.una = rcvNxt;
                seg.data = new byte[0];
                out.add(seg.encode());
            }
            acks.clear();
            while (!sndQueue.isEmpty() && sndBuf.size() < WND) {
                byte[] data = sndQueue.poll();
                Seg seg = new Seg();
                seg.conv = conv;
                seg.cmd = CMD_PUSH;
                seg.frg = 0;
                if (data.length == mss && !sndQueue.isEmpty()) {
                    seg.frg = Math.min(sndQueue.size(), 255);
                }
                seg.wnd = window();
                seg.ts = (int) (now & 0xFFFFFFFFL);
                seg.sn = sndNxt;
                seg.una = rcvNxt;
                seg.data = data;
                seg.resendts = now;
                seg.rto = rto;
                sndBuf.add(seg);
                sndNxt++;
            }
            int lost = 0;
            for (Seg seg : sndBuf) {
                boolean need;
                if (seg.xmit == 0) {
                    need = true;
                } else if (now >= seg.resendts) {
                    need = true;
                    seg.rto = Math.min(seg.rto * 2, 5000);
                    seg.resendts = now + seg.rto;
                } else {
                    need = false;
                }
                if (need) {
                    seg.xmit++;
                    seg.wnd = window();
                    seg.ts = (int) (now & 0xFFFFFFFFL);
                    seg.una = rcvNxt;
                    out.add(seg.encode());
                    if (seg.xmit >= deadLink) {
                        lost++;
                    }
                }
            }
            if (!sndBuf.isEmpty() && lost == sndBuf.size()) {
                deadLinkLost = true;
            }
            return out;
        }
    }
}
