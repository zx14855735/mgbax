package io.mgba.android;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 直连（P2P）通道，与 PC 侧 {@code src/platform/qt/DirectLink.cpp} 使用<b>同一套
 * 线上协议</b>，两端可以互连（安卓↔安卓、安卓↔PC 都行）。
 *
 * <h3>为什么要它</h3>
 * 跨网联机目前只能走大厅的 {@code send_message} 隧道：一条消息要从本机到
 * gboy.top、再转发给对方，实测一个 SIO 回合（1P 发字 → 2P 回字）80-100 ms，
 * 尖峰能到 200 ms。联机线是严格一问一答，这段延迟直接变成游戏里的慢放。
 * 直连把服务器这一跳砍掉，实测同一场景降到 18-25 ms。
 *
 * <h3>怎么建链</h3>
 * 不需要任何额外的服务器，复用大厅 WebSocket 当信令：
 * <ol>
 *   <li>绑定一个临时 UDP 端口，向 STUN 问自己的公网映射地址；</li>
 *   <li>把「公网映射 + 各网卡地址」通过隧道标记发给对端，同时收对端的；</li>
 *   <li>双方朝对方所有候选地址发 PROBE 打洞，收到任何一个回应即双向可达；</li>
 *   <li>打通后互相确认（{@code s}/{@code s2}）再切过来；打不通就留在大厅隧道。</li>
 * </ol>
 *
 * <h3>可靠性</h3>
 * 联机线是 20 字节的小包，丢一个游戏就报「连接发生了错误」，所以自带一个
 * 极简可靠层：序号 + 累积确认（ackBits）+ 超时重传 + 去重排序。重传超时按
 * 实测 RTT 自适应，20-200 ms。
 *
 * <h3>报文格式</h3>
 * <pre>
 *   0   4  "MBLD"
 *   4   1  version = 1
 *   5   1  type: 1=PROBE 2=RESP 3=DATA 4=CTRL 5=BYE
 *   6   2  seq      (大端)
 *   8   2  ackSeq   (大端)
 *  10   4  ackBits  (大端)
 *  14   4  tag      (随机，仅用于日志追踪)
 *  18   .. payload
 * </pre>
 * PROBE 的 payload 是 4 字节大端时间戳，对端在 RESP 里原样带回，用来在还没
 * 有任何联机数据时就量出真实 RTT——这决定了要不要真的从隧道切过来。
 */
final class GBoyDirectLink implements GBoyCloudLink.Link {

    private static final String TAG = "GBoyDirectLink";

    private static final byte[] MAGIC = {'M', 'B', 'L', 'D'};
    private static final int VERSION = 1;
    private static final int HEADER_BYTES = 18;

    private static final int TYPE_PROBE = 1;
    private static final int TYPE_RESP = 2;
    private static final int TYPE_DATA = 3;
    private static final int TYPE_CTRL = 4;
    private static final int TYPE_BYE = 5;

    /** 打洞阶段探针间隔。 */
    private static final long PROBE_MS = 100;
    /** 连通后的保活间隔（同时维持 NAT 映射）。 */
    private static final long KEEPALIVE_MS = 1000;
    /** 连通后多久收不到任何包就判定直连已死，交给上层回落隧道。 */
    // 宝可梦进对战时会转场并加载双方队伍，游戏有几秒完全不发 SIO 字；
    // 6s 会把这段静默误判成掉线，导致两端一个回落隧道一个还在直连。
    private static final long IDLE_CLOSE_MS = 30000;
    /** STUN 最多等这么久；手机切网/无 STUN 出口时不要拖住开局。 */
    private static final int STUN_TIMEOUT_MS = 900;

    /** 一个候选地址。 */
    private static final class Candidate {
        final InetAddress address;
        final int port;

        Candidate(InetAddress address, int port) {
            this.address = address;
            this.port = port;
        }

        String text() {
            return address.getHostAddress() + ":" + port;
        }
    }

    /** 已发送、等待确认的数据包。 */
    private static final class Outgoing {
        final int seq;
        final byte[] payload;
        long firstSent;
        long lastSent;
        int tries;

        Outgoing(int seq, byte[] payload, long now) {
            this.seq = seq;
            this.payload = payload;
            this.firstSent = 0;
            this.lastSent = now;
            this.tries = 1;
        }
    }

    private DatagramSocket socket;
    private final int tag = new Random().nextInt();

    private final List<Candidate> peerCandidates = new ArrayList<>();
    private final List<Candidate> sendTargets = new ArrayList<>();
    private volatile Candidate peer;
    private String peerText = "";
    private volatile boolean havePeer;
    private volatile boolean connected;
    private volatile boolean closed;
    private boolean punching;
    private long lastProbe;
    private long lastKeepalive;
    private long lastRecv;
    private int probeSeq;

    private int nextSeq;
    private final ArrayDeque<Outgoing> outgoing = new ArrayDeque<>();
    private final Map<Integer, byte[]> incoming = new HashMap<>();
    private int rcvNext;
    private boolean rcvStarted;
    private final ArrayDeque<byte[]> inbox = new ArrayDeque<>();

    private int ackSeq;
    private int ackBits;
    private boolean ackSeen;

    /**
     * 保护 {@link #outgoing} 的锁。{@code sio-bridge-out} 线程不断往里
     * {@code addLast}，而 {@code sio-bridge-in} 线程的 {@code recv()→pump()}
     * 既要遍历它做重传、又要重建它做确认——两条线程不串行化就会触发
     * {@code ConcurrentModificationException}，桥接收线程每帧都抛、一个字节
     * 也转发不出去，直连被看门狗判死、游戏报通信错误。
     */
    private final Object lock = new Object();

    private int rttUs;

    /** 绑定一个临时 UDP 端口。失败返回 false，调用方直接放弃直连。 */
    boolean bind() {
        if (socket != null) {
            return true;
        }
        try {
            DatagramSocket s = new DatagramSocket();
            s.setBroadcast(false);
            socket = s;
            return true;
        } catch (SocketException e) {
            Log.i(TAG, "bind failed: " + e.getMessage());
            return false;
        }
    }

    int localPort() {
        return socket == null ? 0 : socket.getLocalPort();
    }

    /**
     * 候选地址列表：公网映射排第一位（跨网只认它），后面是本机网卡 IPv4
     * （同局域网时最快，也覆盖"两台机器其实在同一个路由器后面"的情况）。
     * 会阻塞最多约 1 秒（STUN 超时）。
     */
    List<String> candidates() {
        List<String> out = new ArrayList<>();
        if (socket == null && !bind()) {
            return out;
        }
        List<String> local = new ArrayList<>();
        try {
            for (NetworkInterface nif : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (nif.isLoopback() || !nif.isUp()) {
                    continue;
                }
                for (InetAddress addr : Collections.list(nif.getInetAddresses())) {
                    if (addr.isLoopbackAddress() || addr.getAddress().length != 4) {
                        continue;
                    }
                    String text = addr.getHostAddress() + ":" + socket.getLocalPort();
                    if (!local.contains(text)) {
                        local.add(text);
                    }
                    if (local.size() >= 3) {
                        break;
                    }
                }
                if (local.size() >= 3) {
                    break;
                }
            }
        } catch (SocketException e) {
            Log.i(TAG, "enumerate interfaces failed: " + e.getMessage());
        }
        String mapped = stunLookup("stun.miwifi.com", 3478);
        if (mapped == null) {
            mapped = stunLookup("stun.l.google.com", 19302);
        }
        if (mapped != null) {
            out.add(mapped);
        }
        for (String text : local) {
            if (!out.contains(text)) {
                out.add(text);
            }
        }
        return out;
    }

    /**
     * STUN binding request → XOR-MAPPED-ADDRESS，返回 "ip:port" 或 null。
     * 手机在移动数据 / 家用 NAT 后面时只有它能让对面找到我们。
     */
    private String stunLookup(String host, int port) {
        if (socket == null) {
            return null;
        }
        try {
            InetAddress server = InetAddress.getByName(host);
            byte[] request = new byte[20];
            put16(request, 0, 0x0001);
            put16(request, 2, 0);
            put32(request, 4, 0x2112A442);
            Random random = new Random();
            for (int i = 8; i < 20; i++) {
                request[i] = (byte) random.nextInt(256);
            }
            DatagramPacket packet = new DatagramPacket(request, request.length, server, port);
            socket.send(packet);

            long deadline = System.currentTimeMillis() + STUN_TIMEOUT_MS;
            byte[] buffer = new byte[512];
            while (System.currentTimeMillis() < deadline) {
                socket.setSoTimeout(100);
                DatagramPacket in = new DatagramPacket(buffer, buffer.length);
                try {
                    socket.receive(in);
                } catch (SocketTimeoutException e) {
                    continue;
                }
                int n = in.getLength();
                int off = in.getOffset();
                if (n < 20 || get16(buffer, off) != 0x0101) {
                    continue;
                }
                int offset = off + 20;
                int end = off + n;
                while (offset + 4 <= end) {
                    int type = get16(buffer, offset);
                    int length = get16(buffer, offset + 2);
                    if (offset + 4 + length > end) {
                        break;
                    }
                    if ((type == 0x0020 || type == 0x0001) && length >= 8) {
                        int valueOff = offset + 4;
                        int mappedPort = get16(buffer, valueOff + 2);
                        long address = get32(buffer, valueOff + 4) & 0xFFFFFFFFL;
                        if (type == 0x0020) {
                            mappedPort ^= 0x2112;
                            address ^= 0x2112A442L;
                        }
                        if (address == 0) {
                            continue;
                        }
                        String ip = ((address >> 24) & 0xFF) + "." + ((address >> 16) & 0xFF)
                                + "." + ((address >> 8) & 0xFF) + "." + (address & 0xFF);
                        return ip + ":" + mappedPort;
                    }
                    offset += 4 + length + ((length % 4) != 0 ? (4 - length % 4) : 0);
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "stun " + host + " failed: " + e.getMessage());
        }
        return null;
    }

    void setPeerCandidates(List<String> list) {
        peerCandidates.clear();
        for (String text : list) {
            Candidate candidate = parseCandidate(text);
            if (candidate != null) {
                peerCandidates.add(candidate);
            }
        }
        sendTargets.clear();
        sendTargets.addAll(peerCandidates);
    }

    private static Candidate parseCandidate(String text) {
        if (text == null) {
            return null;
        }
        int colon = text.lastIndexOf(':');
        if (colon <= 0) {
            return null;
        }
        try {
            int port = Integer.parseInt(text.substring(colon + 1).trim());
            if (port <= 0 || port > 65535) {
                return null;
            }
            InetAddress address = InetAddress.getByName(text.substring(0, colon).trim());
            if (address.getAddress().length != 4) {
                return null;
            }
            return new Candidate(address, port);
        } catch (Exception e) {
            return null;
        }
    }

    void startPunching() {
        if (socket == null) {
            return;
        }
        punching = true;
        lastProbe = 0;
    }

    boolean isConnected() {
        return connected;
    }

    int rttMs() {
        return (rttUs + 500) / 1000;
    }

    String peerText() {
        return peerText;
    }

    // ---- 发送 ----

    private void sendPacket(int type, int seq, byte[] payload, Candidate to) {
        if (socket == null || to == null) {
            return;
        }
        try {
            byte[] packet = new byte[HEADER_BYTES + (payload == null ? 0 : payload.length)];
            System.arraycopy(MAGIC, 0, packet, 0, 4);
            packet[4] = (byte) VERSION;
            packet[5] = (byte) type;
            put16(packet, 6, seq);
            put16(packet, 8, ackSeen ? ackSeq : 0);
            put32(packet, 10, ackSeen ? ackBits : 0);
            put32(packet, 14, tag);
            if (payload != null && payload.length > 0) {
                System.arraycopy(payload, 0, packet, HEADER_BYTES, payload.length);
            }
            socket.send(new DatagramPacket(packet, packet.length, to.address, to.port));
        } catch (IOException e) {
            Log.i(TAG, "send failed: " + e.getMessage());
        }
    }

    private void sendControl(Candidate to) {
        sendPacket(TYPE_CTRL, 0, null, to);
    }

    @Override
    public void send(byte[] payload) {
        if (closed || socket == null || payload == null || payload.length == 0) {
            return;
        }
        int seq;
        Candidate target;
        // 与 recv→pump→flushRetransmits/noteAck 串行化，避免并发改 outgoing。
        synchronized (lock) {
            seq = nextSeq;
            nextSeq = (nextSeq + 1) & 0xFFFF;
            outgoing.addLast(new Outgoing(seq, payload, now()));
            target = havePeer ? peer : null;
        }
        // 真正的 UDP 发送放到锁外：socket 发送本身线程安全，且不让 IO 阻塞
        // 接收线程的重传/确认节奏。
        if (target != null) {
            sendPacket(TYPE_DATA, seq, payload, target);
        }
    }

    // ---- 接收 ----

    @Override
    public byte[] recv(long timeoutMs) {
        byte[] ready = inbox.pollFirst();
        if (ready != null) {
            return ready;
        }
        long deadline = now() + Math.max(timeoutMs, 0);
        while (true) {
            long remaining = deadline - now();
            int slice = (int) (remaining > 20 ? 20 : (remaining > 0 ? remaining : 1));
            pump(slice);
            ready = inbox.pollFirst();
            if (ready != null) {
                return ready;
            }
            if (closed || now() >= deadline) {
                return inbox.pollFirst();
            }
        }
    }

    @Override
    public boolean isClosed() {
        return closed;
    }

    @Override
    public void close() {
        if (closed) {
            return;
        }
        if (socket != null && havePeer) {
            sendPacket(TYPE_BYE, 0, null, peer);
        }
        closed = true;
        punching = false;
        if (socket != null) {
            socket.close();
        }
    }

    /** 收包 + 定时重传 / 探活；返回本次是否读到有效包。 */
    boolean pump(int timeoutMs) {
        if (socket == null || closed) {
            sleepQuietly(timeoutMs);
            return false;
        }
        boolean got = readSocket(timeoutMs);
        long now = now();
        if (!connected && punching && !sendTargets.isEmpty()) {
            if (now - lastProbe >= PROBE_MS) {
                lastProbe = now;
                byte[] stamp = new byte[4];
                put32(stamp, 0, (int) (now & 0xFFFFFFFFL));
                for (Candidate candidate : sendTargets) {
                    sendPacket(TYPE_PROBE, ++probeSeq & 0xFFFF, stamp, candidate);
                }
            }
        } else if (connected && now - lastKeepalive >= KEEPALIVE_MS) {
            lastKeepalive = now;
            byte[] stamp = new byte[4];
            put32(stamp, 0, (int) (now & 0xFFFFFFFFL));
            sendPacket(TYPE_PROBE, 0, stamp, peer);
        }
        flushRetransmits(now);
        // 空闲看门狗：对端掉线（切基站、NAT 表被清、程序退出）时 UDP 不会
        // 报错，只会在重传里越耗越久。主动关掉，让上层回落服务器隧道。
        if (connected && lastRecv > 0 && now - lastRecv > IDLE_CLOSE_MS) {
            Log.i(TAG, "idle " + (now - lastRecv) + "ms, closing direct link");
            closed = true;
        }
        return got;
    }

    private boolean readSocket(int timeoutMs) {
        if (socket == null) {
            return false;
        }
        boolean got = false;
        byte[] buffer = new byte[2048];
        for (int guard = 0; guard < 32; guard++) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.setSoTimeout(Math.max(1, guard == 0 ? timeoutMs : 1));
                socket.receive(packet);
            } catch (SocketTimeoutException e) {
                break;
            } catch (IOException e) {
                return got;
            }
            Candidate from = new Candidate(packet.getAddress(), packet.getPort());
            handlePacket(packet.getData(), packet.getOffset(), packet.getLength(), from);
            got = true;
        }
        return got;
    }

    private void handlePacket(byte[] data, int off, int len, Candidate from) {
        if (len < HEADER_BYTES) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (data[off + i] != MAGIC[i]) {
                return;
            }
        }
        if ((data[off + 4] & 0xFF) != VERSION) {
            return;
        }
        int type = data[off + 5] & 0xFF;
        int seq = get16(data, off + 6);
        int ackSeq = get16(data, off + 8);
        int ackBits = get32(data, off + 10);
        byte[] payload = new byte[Math.max(0, len - HEADER_BYTES)];
        if (payload.length > 0) {
            System.arraycopy(data, off + HEADER_BYTES, payload, 0, payload.length);
        }

        if (type == TYPE_BYE) {
            closed = true;
            return;
        }
        if (type == TYPE_PROBE) {
            // 收到探针只代表"对端发出的包能到我们"，还不能断定反向也通，
            // 所以先回 RESP，连通判定留给 RESP/DATA。
            // payload 原样回带：里面是发方写的时间戳，用来在还没有任何联机
            // 数据时就量出真实往返时延。
            sendPacket(TYPE_RESP, seq, payload, from);
            return;
        }
        if (!connected && (type == TYPE_RESP || type == TYPE_DATA || type == TYPE_CTRL)) {
            connected = true;
            punching = false;
            peer = from;
            peerText = from.text();
            havePeer = true;
        }
        peer = from;
        havePeer = true;
        lastRecv = now();

        if (type == TYPE_RESP) {
            if (payload.length >= 4) {
                long sent = get32(payload, 0) & 0xFFFFFFFFL;
                long sample = ((System.currentTimeMillis() & 0xFFFFFFFFL) - sent) & 0xFFFFFFFFL;
                if (sample < 5000) {
                    int us = (int) (sample * 1000);
                    rttUs = rttUs != 0 ? (rttUs * 3 + us) / 4 : us;
                }
            }
            return;
        }

        noteAck(ackSeq, ackBits);

        if (type == TYPE_DATA) {
            noteReceived(seq);
            if (!rcvStarted) {
                rcvStarted = true;
                rcvNext = seq;
            }
            int delta = (short) (seq - rcvNext);
            if (delta >= 0 && !incoming.containsKey(seq)) {
                incoming.put(seq, payload);
            }
            while (incoming.containsKey(rcvNext)) {
                inbox.addLast(incoming.remove(rcvNext));
                rcvNext = (rcvNext + 1) & 0xFFFF;
            }
            // 立刻单独回一个控制包：联机线是一问一答，这个 ACK 直接决定
            // 下一回合多快能开始。
            sendControl(from);
        }
    }

    private void noteReceived(int seq) {
        if (!ackSeen) {
            ackSeen = true;
            ackSeq = seq;
            ackBits = 0;
            return;
        }
        int delta = (short) (seq - ackSeq);
        if (delta > 0) {
            ackBits = (delta >= 32) ? 0 : (ackBits << delta);
            if (delta <= 32) {
                ackBits |= (1 << (delta - 1));
            }
            ackSeq = seq;
        } else if (delta < 0 && -delta <= 32) {
            ackBits |= (1 << (-delta - 1));
        }
    }

    private void noteAck(int ackSeq, int ackBits) {
        synchronized (lock) {
            if (outgoing.isEmpty()) {
                return;
            }
            long now = now();
            ArrayDeque<Outgoing> keep = new ArrayDeque<>();
            while (!outgoing.isEmpty()) {
                Outgoing out = outgoing.pollFirst();
                int delta = (short) (ackSeq - out.seq);
                boolean acked = delta >= 0;
                if (!acked && -delta <= 32) {
                    acked = (ackBits & (1 << (-delta - 1))) != 0;
                }
                if (acked) {
                    if (out.firstSent > 0) {
                        int sample = (int) ((now - out.firstSent) * 1000);
                        rttUs = rttUs != 0 ? (rttUs * 3 + sample) / 4 : sample;
                    }
                    continue;
                }
                keep.addLast(out);
            }
            outgoing.clear();
            outgoing.addAll(keep);
        }
    }

    private void flushRetransmits(long now) {
        List<Outgoing> batch;
        Candidate target;
        // 取一份快照再遍历：遍历期间 sio-bridge-out 仍可能 addLast，快照保证
        // 这里不会触发 ConcurrentModificationException。
        synchronized (lock) {
            if (outgoing.isEmpty() || !havePeer) {
                return;
            }
            batch = new ArrayList<>(outgoing);
            target = peer;
        }
        int rto = rttUs != 0 ? Math.max(20, (rttUs / 1000) * 3 / 2) : 50;
        rto = Math.min(rto, 200);
        for (Outgoing out : batch) {
            if (now - out.lastSent < rto) {
                continue;
            }
            if (++out.tries > 40) {
                synchronized (lock) {
                    closed = true;
                }
                return;
            }
            if (target != null) {
                sendPacket(TYPE_DATA, out.seq, out.payload, target);
            }
            out.lastSent = now;
            if (out.firstSent == 0) {
                out.firstSent = now;
            }
        }
    }

    // ---- 小工具 ----

    private static long now() {
        return System.currentTimeMillis();
    }

    private static void sleepQuietly(long ms) {
        if (ms <= 0) {
            return;
        }
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }

    private static void put16(byte[] p, int off, int v) {
        p[off] = (byte) ((v >> 8) & 0xFF);
        p[off + 1] = (byte) (v & 0xFF);
    }

    private static void put32(byte[] p, int off, int v) {
        p[off] = (byte) ((v >> 24) & 0xFF);
        p[off + 1] = (byte) ((v >> 16) & 0xFF);
        p[off + 2] = (byte) ((v >> 8) & 0xFF);
        p[off + 3] = (byte) (v & 0xFF);
    }

    private static int get16(byte[] p, int off) {
        return ((p[off] & 0xFF) << 8) | (p[off + 1] & 0xFF);
    }

    private static int get32(byte[] p, int off) {
        return ((p[off] & 0xFF) << 24) | ((p[off + 1] & 0xFF) << 16)
                | ((p[off + 2] & 0xFF) << 8) | (p[off + 3] & 0xFF);
    }
}
