/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Internet room tunnel for the existing GBA link cable.
 * Both phones open an outbound TCP connection to a relay and exchange the
 * same bytes as a direct LAN link. No accounts and no ads.
 */
public final class RemoteLink {
    static final int LINK_PORT = 18765;
    static final int RELAY_PORT = 8766;
    private static final String ALPHABET = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";

    public interface Hooks {
        void onStatus(String text);

        void onRoom(String code, String relayForPeer);

        boolean hostLink(int port);

        boolean joinLink(String host, int port);

        void closeLink();
    }

    private final Hooks hooks;
    private final Object gate = new Object();
    private int generation;
    private final ArrayList<Closeable> open = new ArrayList<>();

    public RemoteLink(Hooks hooks) {
        this.hooks = hooks;
    }

    public void create(String relayField, String localIp) {
        int gen = restart();
        new Thread(() -> runHost(gen, relayField, localIp), "remote-link").start();
    }

    public void join(String relayField, String code) {
        int gen = restart();
        new Thread(() -> runGuest(gen, relayField, code), "remote-link").start();
    }

    public void close() {
        restart();
    }

    private int restart() {
        ArrayList<Closeable> copy;
        synchronized (gate) {
            generation++;
            copy = new ArrayList<>(open);
            open.clear();
        }
        for (Closeable item : copy) {
            try {
                item.close();
            } catch (IOException ignored) {
            }
        }
        hooks.closeLink();
        synchronized (gate) {
            return generation;
        }
    }

    private boolean live(int gen) {
        synchronized (gate) {
            return gen == generation;
        }
    }

    private void track(int gen, Closeable item) throws IOException {
        synchronized (gate) {
            if (gen != generation) {
                try {
                    item.close();
                } catch (IOException ignored) {
                }
                throw new IOException("已断开");
            }
            open.add(item);
        }
    }

    private void runHost(int gen, String relayField, String localIp) {
        try {
            if (!live(gen)) {
                return;
            }
            if (!hooks.hostLink(LINK_PORT)) {
                status(gen, "本机联机端口被占用");
                return;
            }
            Endpoint relay = resolveRelay(gen, relayField, localIp);
            status(gen, "正在连接中继 " + relay.advertise);
            Socket relaySock = connect(relay.host, relay.port);
            track(gen, relaySock);
            tune(relaySock);
            writeLine(relaySock, "MGBA1 CREATE");
            String created = readLine(relaySock.getInputStream());
            String code = roomCode(created, "HOST");
            hooks.onRoom(code, relay.advertise);
            status(gen, "房间 " + code + "\n让对方把中继填成 " + relay.advertise + "\n房间号 " + code);
            String peer = readLine(relaySock.getInputStream());
            expect(peer, "MGBA1 PEER");
            if (!live(gen)) {
                return;
            }
            Socket local = connect("127.0.0.1", LINK_PORT);
            track(gen, local);
            tune(local);
            status(gen, "已接通中继，你是 1P");
            splice(local, relaySock);
            status(gen, "对方已断开");
            if (live(gen)) {
                hooks.closeLink();
            }
        } catch (Exception e) {
            if (live(gen)) {
                status(gen, explain(e));
                hooks.closeLink();
            }
        }
    }

    private void runGuest(int gen, String relayField, String code) {
        try {
            if (!live(gen)) {
                return;
            }
            String room = code == null ? "" : code.trim().toUpperCase();
            if (room.isEmpty()) {
                status(gen, "先填写房间号");
                return;
            }
            Endpoint relay = resolveRelay(gen, relayField, null);
            if (relay.embedded) {
                status(gen, "加入时要填写对方的中继地址");
                return;
            }
            status(gen, "正在加入房间 " + room);
            Socket relaySock = connect(relay.host, relay.port);
            track(gen, relaySock);
            tune(relaySock);
            writeLine(relaySock, "MGBA1 JOIN " + room);
            String joined = readLine(relaySock.getInputStream());
            if (joined.startsWith("MGBA1 ERR")) {
                throw new IOException(errText(joined));
            }
            roomCode(joined, "GUEST");
            String peer = readLine(relaySock.getInputStream());
            expect(peer, "MGBA1 PEER");
            if (!live(gen)) {
                return;
            }
            ServerSocket listen = new ServerSocket();
            listen.setReuseAddress(true);
            listen.bind(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 0));
            track(gen, listen);
            if (!hooks.joinLink("127.0.0.1", listen.getLocalPort())) {
                throw new IOException("本机联机连接失败");
            }
            Socket local = listen.accept();
            track(gen, local);
            tune(local);
            status(gen, "已接通中继，你是 2P");
            splice(local, relaySock);
            status(gen, "对方已断开");
            if (live(gen)) {
                hooks.closeLink();
            }
        } catch (Exception e) {
            if (live(gen)) {
                status(gen, explain(e));
                hooks.closeLink();
            }
        }
    }

    private Endpoint resolveRelay(int gen, String relayField, String localIp) throws IOException {
        String text = relayField == null ? "" : relayField.trim();
        if (!text.isEmpty()) {
            return Endpoint.parse(text);
        }
        if (localIp == null) {
            throw new IOException("加入时要填写对方的中继地址");
        }
        int port = startEmbedded(gen);
        String advertise = (localIp == null || localIp.isEmpty() || "0.0.0.0".equals(localIp))
                ? ("端口 " + port)
                : (localIp + ":" + port);
        return new Endpoint("127.0.0.1", port, advertise, true);
    }

    private int startEmbedded(int gen) throws IOException {
        IOException last = null;
        for (int port = RELAY_PORT; port < RELAY_PORT + 8; port++) {
            try {
                ServerSocket server = new ServerSocket();
                server.setReuseAddress(true);
                server.bind(new InetSocketAddress(port));
                track(gen, server);
                Thread thread = new Thread(() -> acceptLoop(gen, server), "link-relay");
                thread.start();
                return port;
            } catch (IOException e) {
                last = e;
            }
        }
        throw new IOException(last == null ? "中继端口被占用" : "中继端口被占用");
    }

    private void acceptLoop(int gen, ServerSocket server) {
        RelayHub hub = new RelayHub();
        while (live(gen)) {
            try {
                Socket socket = server.accept();
                tune(socket);
                track(gen, socket);
                new Thread(() -> hub.handle(socket), "link-room").start();
            } catch (IOException e) {
                return;
            }
        }
    }

    private static void splice(Socket left, Socket right) {
        Thread a = new Thread(() -> pump(left, right), "link-up");
        Thread b = new Thread(() -> pump(right, left), "link-down");
        a.start();
        b.start();
        try {
            a.join();
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
        try {
            b.join();
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }

    private static void pump(Socket src, Socket dst) {
        byte[] buf = new byte[8192];
        try {
            InputStream in = src.getInputStream();
            OutputStream out = dst.getOutputStream();
            int n;
            while ((n = in.read(buf)) >= 0) {
                if (n == 0) {
                    continue;
                }
                out.write(buf, 0, n);
                out.flush();
            }
        } catch (IOException ignored) {
        } finally {
            try {
                dst.shutdownOutput();
            } catch (IOException ignored) {
            }
        }
    }

    private void status(int gen, String text) {
        if (live(gen)) {
            hooks.onStatus(text);
        }
    }

    private static Socket connect(String host, int port) throws IOException {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port), 10000);
            return socket;
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException ignored) {
            }
            throw new IOException("连不上中继 " + host + ":" + port);
        }
    }

    private static void tune(Socket socket) throws IOException {
        socket.setTcpNoDelay(true);
        socket.setKeepAlive(true);
    }

    private static void writeLine(Socket socket, String line) throws IOException {
        socket.getOutputStream().write((line + "\n").getBytes(StandardCharsets.US_ASCII));
        socket.getOutputStream().flush();
    }

    static String readLine(InputStream in) throws IOException {
        byte[] buf = new byte[96];
        int n = 0;
        while (n < buf.length) {
            int b = in.read();
            if (b < 0) {
                throw new EOFException("中继已断开");
            }
            if (b == '\n') {
                return new String(buf, 0, n, StandardCharsets.US_ASCII).trim();
            }
            if (b != '\r') {
                buf[n++] = (byte) b;
            }
        }
        throw new IOException("中继返回异常");
    }

    private static String roomCode(String line, String role) throws IOException {
        String prefix = "MGBA1 ROOM ";
        if (line == null || !line.startsWith(prefix) || !line.endsWith(" " + role)) {
            throw new IOException(line != null && line.startsWith("MGBA1 ERR") ? errText(line) : "中继协议不匹配");
        }
        String rest = line.substring(prefix.length(), line.length() - role.length() - 1).trim();
        if (rest.isEmpty()) {
            throw new IOException("中继没有返回房间号");
        }
        return rest;
    }

    private static void expect(String line, String want) throws IOException {
        if (!want.equals(line)) {
            throw new IOException(line != null && line.startsWith("MGBA1 ERR") ? errText(line) : "中继协议不匹配");
        }
    }

    private static String errText(String line) {
        if (line.contains("NO_ROOM")) {
            return "没有这个房间";
        }
        if (line.contains("FULL")) {
            return "房间已满";
        }
        if (line.contains("TIMEOUT")) {
            return "等待对方超时";
        }
        return "中继拒绝了连接";
    }

    private static String explain(Exception e) {
        String message = e.getMessage();
        if (message == null || message.isEmpty() || "closed".equals(message)) {
            return "连接失败";
        }
        return message;
    }

    private static final class Endpoint {
        final String host;
        final int port;
        final String advertise;
        final boolean embedded;

        Endpoint(String host, int port, String advertise, boolean embedded) {
            this.host = host;
            this.port = port;
            this.advertise = advertise;
            this.embedded = embedded;
        }

        static Endpoint parse(String text) throws IOException {
            String host = text;
            int port = RELAY_PORT;
            int colon = text.lastIndexOf(':');
            if (colon > 0 && colon < text.length() - 1 && text.indexOf(':') == colon) {
                host = text.substring(0, colon).trim();
                try {
                    port = Integer.parseInt(text.substring(colon + 1).trim());
                } catch (NumberFormatException e) {
                    throw new IOException("中继端口无效");
                }
            }
            if (host.isEmpty() || port < 1 || port > 65535) {
                throw new IOException("中继地址无效");
            }
            return new Endpoint(host, port, host + ":" + port, false);
        }
    }

    static final class RelayHub {
        private final ConcurrentHashMap<String, Room> rooms = new ConcurrentHashMap<>();

        /** 当前存在的房间数，供「本机当中继」模式显示负载。 */
        int roomCount() {
            return rooms.size();
        }

        void handle(Socket socket) {
            try {
                String line = readLine(socket.getInputStream());
                if ("MGBA1 CREATE".equals(line)) {
                    host(socket);
                } else if (line.startsWith("MGBA1 JOIN ")) {
                    guest(socket, line.substring("MGBA1 JOIN ".length()).trim().toUpperCase());
                } else {
                    writeLine(socket, "MGBA1 ERR BAD");
                    socket.close();
                }
            } catch (IOException e) {
                try {
                    socket.close();
                } catch (IOException ignored) {
                }
            }
        }

        private void host(Socket socket) throws IOException {
            String code = newCode();
            Room room = new Room();
            room.host = socket;
            rooms.put(code, room);
            try {
                writeLine(socket, "MGBA1 ROOM " + code + " HOST");
                if (!room.guestArrived.await(15, TimeUnit.MINUTES)) {
                    writeLine(socket, "MGBA1 ERR TIMEOUT");
                    return;
                }
                writeLine(socket, "MGBA1 PEER");
                writeLine(room.guest, "MGBA1 PEER");
                splice(socket, room.guest);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                rooms.remove(code, room);
                room.finished.countDown();
                try {
                    socket.close();
                } catch (IOException ignored) {
                }
                if (room.guest != null) {
                    try {
                        room.guest.close();
                    } catch (IOException ignored) {
                    }
                }
            }
        }

        private void guest(Socket socket, String code) throws IOException {
            Room room = rooms.get(code);
            if (room == null) {
                writeLine(socket, "MGBA1 ERR NO_ROOM");
                socket.close();
                return;
            }
            if (!room.claim(socket)) {
                writeLine(socket, "MGBA1 ERR FULL");
                socket.close();
                return;
            }
            writeLine(socket, "MGBA1 ROOM " + code + " GUEST");
            room.guestArrived.countDown();
            try {
                room.finished.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private static String newCode() {
            StringBuilder code = new StringBuilder(6);
            for (int i = 0; i < 6; i++) {
                code.append(ALPHABET.charAt((int) (Math.random() * ALPHABET.length())));
            }
            return code.toString();
        }
    }

    static final class Room {
        Socket host;
        Socket guest;
        final CountDownLatch guestArrived = new CountDownLatch(1);
        final CountDownLatch finished = new CountDownLatch(1);

        synchronized boolean claim(Socket socket) {
            if (guest != null) {
                return false;
            }
            guest = socket;
            return true;
        }
    }
}
