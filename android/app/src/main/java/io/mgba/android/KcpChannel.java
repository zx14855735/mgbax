/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * KCP over UDP, the transport gboy.top's cloud rooms use.
 *
 * Reverse engineered from the GBoy client (see .workbuddy/gboy/PROTOCOL.md):
 * a session opens with a random conv, the client sends "HS" and expects "HK"
 * within three seconds (three attempts), then keeps a one-second PING/PONG
 * heartbeat. GBoyLink frames travel inside as KCP messages.
 *
 * The KCP core is a straight port of the reference algorithm: segmentation,
 * ACK tracking, RTO retransmit, in-order receive with fragment reassembly.
 */
final class KcpChannel {
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

    private final Kcp kcp;
    private final DatagramSocket socket;
    private final InetAddress address;
    private final int port;
    private final LinkedBlockingQueue<byte[]> inbox = new LinkedBlockingQueue<byte[]>();
    private volatile boolean running = true;
    private volatile boolean handshakeDone;
    private volatile boolean dead;
    private final Thread thread;

    private KcpChannel(InetAddress address, int port) throws IOException {
        this.address = address;
        this.port = port;
        // GBoy picks the conversation id the same way: a random positive int.
        int conv = java.util.UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
        this.kcp = new Kcp(conv, 1200, 10);
        this.socket = new DatagramSocket();
        this.socket.setSoTimeout(5);
        this.thread = new Thread(this::loop, "gboy-kcp");
        this.thread.setDaemon(true);
        this.thread.start();
    }

    /** Opens a session and completes the HS/HK handshake. */
    static KcpChannel connect(InetAddress address, int port) throws IOException {
        KcpChannel channel = new KcpChannel(address, port);
        try {
            boolean ok = false;
            for (int attempt = 0; attempt < 3 && !ok; attempt++) {
                channel.kcp.send(HS);
                long deadline = System.currentTimeMillis() + 3000;
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

    /** Queues a GBoyLink payload; the pump thread transmits it. */
    void send(byte[] payload) {
        kcp.send(payload);
    }

    /** Next payload from the peer, or null after {@code timeoutMs}. */
    byte[] recv(long timeoutMs) {
        try {
            return inbox.poll(timeoutMs, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    void close() {
        if (!running) {
            return;
        }
        running = false;
        try {
            kcp.send(DISC);
            flush();
        } catch (IOException ignored) {
        }
        try {
            socket.close();
        } catch (Exception ignored) {
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
                if (TRACE && data.length >= 24) {
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
            kcp.send(PONG);
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

    private static void putInt(byte[] out, int off, int value) {
        out[off] = (byte) value;
        out[off + 1] = (byte) (value >> 8);
        out[off + 2] = (byte) (value >> 16);
        out[off + 3] = (byte) (value >> 24);
    }

    private static void putShort(byte[] out, int off, int value) {
        out[off] = (byte) value;
        out[off + 1] = (byte) (value >> 8);
    }

    private static int getInt(byte[] in, int off) {
        return (in[off] & 0xFF) | ((in[off + 1] & 0xFF) << 8)
                | ((in[off + 2] & 0xFF) << 16) | ((in[off + 3] & 0xFF) << 24);
    }

    private static int getShort(byte[] in, int off) {
        return (in[off] & 0xFF) | ((in[off + 1] & 0xFF) << 8);
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
        int rmtWnd = 128;
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
            int free = 128 - rcvQueue.size() - rcvBuf.size();
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
            while (!sndQueue.isEmpty() && sndBuf.size() < 128) {
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
