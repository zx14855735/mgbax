/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.zip.Deflater;

/**
 * GBoy / My Boy “本地联机” Wi-Fi protocol.
 *
 * Plain TCP with big-endian framing: every packet is
 * {@code [u32 payload length][payload]}, and the payload starts with a
 * {@code u16} message type. Messages seen on the wire:
 *
 *   1 HELLO   payload is u16 type + u32 6; the client sends it first and the
 *             server echoes the same bytes back.
 *   2 ROMINFO u16 type + 32-byte ASCII MD5 of the ROM + u16 name length + name.
 *   3 READY   u16 type only, sent once the local console is loaded.
 *   4 KEYS    u16 type + u32 GBA key mask (same bit layout mGBA uses).
 *   5 RESET   u16 type only.
 *   6 STATE   u16 type + u32 size + zlib-compressed GBASTATE v4 image.
 *
 * After the handshake each side sends its key mask about every five frames
 * (~83 ms) and applies the mask it receives, so a GBoy handset drives the
 * remote player here the same way it would drive its own second console.
 */
public final class GBoyLink {
    public static final int DEFAULT_PORT = 6374;

    private static void trace(String text) {
        android.util.Log.i("GBoyLink", text);
    }

    // The frame layout lives in GBoyFrames so the gboy.top cloud link can
    // build the very same packets inside KCP.
    private static final int MSG_HELLO = GBoyFrames.MSG_HELLO;
    private static final int MSG_ROM_INFO = GBoyFrames.MSG_ROM_INFO;
    private static final int MSG_READY = GBoyFrames.MSG_READY;
    private static final int MSG_KEYS = GBoyFrames.MSG_KEYS;
    private static final int MSG_RESET = GBoyFrames.MSG_RESET;
    private static final int MSG_STATE = GBoyFrames.MSG_STATE;

    public interface Hooks {
        /** Absolute path of the currently loaded ROM, or null. */
        String romPath();

        /** Current local key mask. */
        int localKeys();

        /** Key mask received from the peer; 0 when the link drops. */
        void onRemoteKeys(int keys);

        void onStatus(String text);

        void onConnected(boolean asHost, String note);

        /** Peer asked for a console reset. */
        void onRemoteReset();
    }

    private final Hooks hooks;
    private final Object sendLock = new Object();
    private volatile boolean closed;
    private volatile Socket socket;
    private Thread pumpThread;

    public GBoyLink(Hooks hooks) {
        this.hooks = hooks;
    }

    /** Starts hosting on the given port; the peer connects to this device. */
    public void host(int port) {
        run(true, null, port);
    }

    /** Connects to a GBoy room that is already hosting. */
    public void join(String ip, int port) {
        run(false, ip, port);
    }

    /** Sends the reset notice to the peer (user pressed 复位). */
    public void sendReset() {
        Socket current = socket;
        if (current != null && !closed) {
            try {
                send(frame(MSG_RESET));
            } catch (IOException ignored) {
            }
        }
    }

    public void close() {
        trace("close() from UI");
        closed = true;
        Socket current = socket;
        socket = null;
        if (current != null) {
            try {
                current.close();
            } catch (IOException ignored) {
            }
        }
        if (pumpThread != null) {
            pumpThread.interrupt();
        }
        hooks.onRemoteKeys(0);
    }

    private void run(final boolean asHost, final String ip, final int port) {
        // A fresh session clears any previous close: 断开 followed by a new
        // join must work without recreating this object.
        closed = false;
        Socket stale = socket;
        socket = null;
        if (stale != null) {
            try {
                stale.close();
            } catch (IOException ignored) {
            }
        }
        Thread thread = new Thread(() -> {
            try {
                if (asHost) {
                    hostLoop(port);
                } else {
                    guestLoop(ip, port);
                }
            } catch (Exception e) {
                if (!closed) {
                    status(message(e));
                }
            }
        }, "gboy-link");
        thread.setDaemon(true);
        thread.start();
    }

    private void hostLoop(int port) throws IOException {
        ServerSocket server = new ServerSocket();
        server.setReuseAddress(true);
        server.bind(new InetSocketAddress(port), 1);
        status("联机大厅等待连接…\n端口 " + port + "，你是 1P");
        Socket accepted;
        try {
            accepted = server.accept();
        } finally {
            try {
                server.close();
            } catch (IOException ignored) {
            }
        }
        socket = accepted;
        tune(accepted);
        status("对方已接入，正在同步…");
        String note = handshake(accepted, true);
        session(accepted, true, null, port, note);
    }

    private void guestLoop(String ip, int port) throws IOException {
        status("正在连接 " + ip + ":" + port + "…");
        InetAddress address = InetAddress.getByName(ip);
        Socket current = new Socket();
        current.connect(new InetSocketAddress(address, port), 10000);
        socket = current;
        trace("connected " + current.getRemoteSocketAddress());
        tune(current);
        status("已连上，正在同步…");
        String note = handshake(current, false);
        session(current, false, ip, port, note);
    }

    private String handshake(Socket current, boolean asHost) throws IOException {
        String note = null;
        if (!asHost) {
            sendOn(current, frameHello());
        }
        expectHello(current, asHost);

        byte[] info = romInfo();
        sendOn(current, info);
        status("已交换游戏信息…");

        byte[] peer = nextFrame(current, MSG_ROM_INFO);
        if (peer.length < 34) {
            throw new IOException("对方不是联机大厅会话");
        }
        String peerHash = new String(peer, 2, 32, StandardCharsets.US_ASCII);
        String mine = new String(info, 2, 32, StandardCharsets.US_ASCII);
        if (!peerHash.equalsIgnoreCase(mine)) {
            note = "注意：两边的游戏不一致，联机可能无法正常同步";
        }

        sendOn(current, frame(MSG_READY));
        expectType(current, MSG_READY);

        if (asHost) {
            byte[] state = nextFrame(current, MSG_STATE);
            note = appendNote(note, "已收到对方即时存档（本机继续用本机进度）");
            sendOn(current, frameState());
        } else {
            sendOn(current, frameState());
            nextFrame(current, MSG_STATE);
            note = appendNote(note, "已收到对方即时存档（本机继续用本机进度）");
        }
        final String finalNote = note;
        return finalNote == null ? "" : finalNote;
    }

    private static String appendNote(String note, String extra) {
        if (note == null || note.isEmpty()) {
            return extra;
        }
        return note + "\n" + extra;
    }

    private void session(Socket current, boolean asHost, String peerIp, int port, String note) throws IOException {
        // The steady state has no handshake deadline: the peer may not even
        // have connected yet, and its key frames arrive at their own cadence.
        try {
            current.setSoTimeout(0);
        } catch (IOException ignored) {
        }
        String text = asHost ? "已连接，你是 1P" : "已连接，你是 2P";
        if (note != null && !note.isEmpty()) {
            text = note + "\n" + text;
        }
        status(text);
        Thread reader = new Thread(() -> readLoop(current), "gboy-read");
        reader.setDaemon(true);
        reader.start();
        pump(current);
    }

    private void readLoop(Socket current) {
        try {
            InputStream in = current.getInputStream();
            while (!closed) {
                byte[] frame = readFrame(in);
                int messageType = type(frame);
                if (messageType == MSG_KEYS && frame.length >= 6) {
                    int keys = ((frame[2] & 0xFF) << 24) | ((frame[3] & 0xFF) << 16)
                            | ((frame[4] & 0xFF) << 8) | (frame[5] & 0xFF);
                    hooks.onRemoteKeys(keys);
                } else if (messageType == MSG_RESET) {
                    hooks.onRemoteReset();
                }
            }
        } catch (Exception e) {
            drop("readLoop " + e);
        }
    }

    private void pump(Socket current) {
        pumpThread = Thread.currentThread();
        try {
            while (!closed) {
                send(frameKeys(hooks.localKeys()));
                Thread.sleep(83);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            drop("pump " + e);
        }
    }

    private void drop(final String text) {
        trace("drop " + text);
        if (closed) {
            return;
        }
        closed = true;
        Socket current = socket;
        if (current != null) {
            try {
                current.close();
            } catch (IOException ignored) {
            }
        }
        hooks.onRemoteKeys(0);
        status(text);
    }

    // ---- wire helpers ----

    private static void tune(Socket current) throws IOException {
        current.setTcpNoDelay(true);
        current.setSoTimeout(15000);
    }

    /** Thread-safe send: the pump and the UI-triggered reset share the wire. */
    private void send(byte[] payload) throws IOException {
        Socket current = socket;
        if (current == null) {
            throw new IOException("未连接");
        }
        synchronized (sendLock) {
            sendOn(current, payload);
        }
    }

    private static void sendOn(Socket current, byte[] payload) throws IOException {
        OutputStream os = current.getOutputStream();
        int len = payload.length;
        os.write(new byte[]{
                (byte) (len >> 24), (byte) (len >> 16), (byte) (len >> 8), (byte) len
        });
        os.write(payload);
        os.flush();
    }

    private static byte[] frameHello() {
        return GBoyFrames.frameHello();
    }

    private static void expectHello(Socket current, boolean asHost) throws IOException {
        byte[] frame = nextFrame(current, MSG_HELLO);
        if (frame.length < 6) {
            throw new IOException("对方不是联机大厅会话");
        }
        int value = ((frame[2] & 0xFF) << 24) | ((frame[3] & 0xFF) << 16)
                | ((frame[4] & 0xFF) << 8) | (frame[5] & 0xFF);
        if (value != 6) {
            throw new IOException("联机大厅协议版本不符");
        }
        if (asHost) {
            sendOn(current, frameHello());
        }
    }

    private static void expectType(Socket current, int want) throws IOException {
        nextFrame(current, want);
    }

    /**
     * Reads frames until one of the wanted type shows up. The peer's key pump
     * keeps running while we are still shaking hands, so KEYS/RESET frames can
     * slip in; they are dropped here.
     */
    private static byte[] nextFrame(Socket current, int want) throws IOException {
        while (true) {
            byte[] frame = readFrame(current);
            int messageType = type(frame);
            if (messageType == want) {
                return frame;
            }
            if (messageType != MSG_KEYS && messageType != MSG_RESET) {
                throw new IOException("对方不是联机大厅会话");
            }
        }
    }

    private static int type(byte[] frame) {
        return GBoyFrames.typeOf(frame);
    }

    private static byte[] frame(int messageType) {
        return GBoyFrames.frame(messageType);
    }

    private static byte[] frameKeys(int keys) {
        return GBoyFrames.frameKeys(keys);
    }

    private static byte[] readFrame(Socket current) throws IOException {
        return readFrame(current.getInputStream());
    }

    private static byte[] readFrame(InputStream in) throws IOException {
        byte[] header = readFully(in, 4);
        int len = ((header[0] & 0xFF) << 24) | ((header[1] & 0xFF) << 16)
                | ((header[2] & 0xFF) << 8) | (header[3] & 0xFF);
        if (len < 0 || len > 32 * 1024 * 1024) {
            throw new IOException("数据异常");
        }
        return readFully(in, len);
    }

    private static byte[] readFully(InputStream in, int len) throws IOException {
        byte[] data = new byte[len];
        int off = 0;
        while (off < len) {
            int n = in.read(data, off, len - off);
            if (n < 0) {
                throw new EOFException("对方已断开");
            }
            off += n;
        }
        return data;
    }

    // ---- ROM identity + state synthesis ----

    /**
     * Builds the ROM_INFO payload: u16 type + 32-char lowercase MD5 of the ROM
     * + u16 name length + file name. GBoy's getRomHash is exactly the MD5 hex
     * of the ROM data, and the 16 bytes at ROM offset 0xA0 carry the
     * title+code it validates savestates against.
     */
    private byte[] romInfo() throws IOException {
        return GBoyFrames.romInfo(hooks.romPath());
    }

    private byte[] frameState() {
        return GBoyFrames.frameState(hooks.romPath());
    }

    private void status(final String text) {
        hooks.onStatus(text);
    }

    private static String message(Exception e) {
        String text = e.getMessage();
        if (text == null || text.isEmpty()) {
            return "联机大厅连接失败";
        }
        return text;
    }
}
