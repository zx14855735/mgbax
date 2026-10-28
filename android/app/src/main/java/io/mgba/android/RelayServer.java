/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 独立中继服务器：原来要另跑一个 Python 进程干的活，现在直接装在 APK 里。
 *
 * 协议和 {@link RemoteLink.RelayHub} 完全一致（MGBA1 CREATE / JOIN → ROOM →
 * PEER → 裸字节镜像），所以模拟器里的「远程创建 / 远程加入」不用改，
 * 填这台设备的地址和端口就能用。
 *
 * 一台设备开中继、两台设备连进来时，连接关系是：
 *   1P 手机 ──┐
 *             ├── 中继设备 :8766 ── 裸字节镜像 ── 双方
 *   2P 手机 ──┘
 * 中继设备自己不打游戏也行，相当于一台随身服务器。
 */
final class RelayServer {

    /** 状态变化回调，用于刷新界面或前台通知。可能来自任意线程。 */
    interface Listener {
        void onStatus(String text);
    }

    private static final int PORT_SPAN = 8;

    private final RemoteLink.RelayHub hub = new RemoteLink.RelayHub();
    private final Set<Socket> sockets = Collections.synchronizedSet(new HashSet<Socket>());
    private final AtomicInteger connections = new AtomicInteger();

    private ServerSocket server;
    private Thread acceptor;
    private volatile int port;
    private volatile boolean running;

    synchronized boolean start(int preferredPort, Listener listener) {
        if (running) {
            return true;
        }
        int from = preferredPort > 0 ? preferredPort : RemoteLink.RELAY_PORT;
        IOException last = null;
        for (int candidate = from; candidate < from + PORT_SPAN && candidate <= 65535; ++candidate) {
            try {
                ServerSocket probe = new ServerSocket();
                probe.setReuseAddress(true);
                probe.bind(new InetSocketAddress(candidate));
                server = probe;
                port = candidate;
                break;
            } catch (IOException e) {
                // 端口被占用或被系统保留（Windows/部分 ROM 会预留成片端口），换下一个
                last = e;
            }
        }
        if (server == null) {
            report(listener, "中继无法启动：" + (last == null ? "端口被占用" : last.getMessage()));
            return false;
        }
        running = true;
        acceptor = new Thread(() -> acceptLoop(listener), "relay-accept");
        acceptor.setDaemon(true);
        acceptor.start();
        report(listener, statusText());
        return true;
    }

    synchronized void stop() {
        running = false;
        if (server != null) {
            try {
                server.close();
            } catch (IOException ignored) {
            }
            server = null;
        }
        synchronized (sockets) {
            for (Socket socket : new ArrayList<>(sockets)) {
                try {
                    socket.close();
                } catch (IOException ignored) {
                }
            }
            sockets.clear();
        }
        connections.set(0);
    }

    boolean isRunning() {
        return running;
    }

    int port() {
        return port;
    }

    /** 「端口 8766 · 房间 1 · 连接 2」，直接丢给界面或通知。 */
    String statusText() {
        if (!running) {
            return "中继未运行";
        }
        return "端口 " + port + " · 房间 " + hub.roomCount() + " · 连接 " + connections.get();
    }

    private void acceptLoop(Listener listener) {
        while (running) {
            Socket socket;
            try {
                socket = server.accept();
            } catch (IOException e) {
                break;   // stop() 关掉监听套接字，正常退出
            }
            sockets.add(socket);
            connections.incrementAndGet();
            report(listener, statusText());
            Thread worker = new Thread(() -> serve(socket, listener), "relay-peer");
            worker.setDaemon(true);
            worker.start();
        }
    }

    private void serve(Socket socket, Listener listener) {
        try {
            // handle() 内部会一直挂到这对玩家断开，所以连接数就是「在跑的对局数 ×2」
            hub.handle(socket);
        } finally {
            sockets.remove(socket);
            connections.decrementAndGet();
            try {
                socket.close();
            } catch (IOException ignored) {
            }
            report(listener, statusText());
        }
    }

    private static void report(Listener listener, String text) {
        if (listener != null) {
            try {
                listener.onStatus(text);
            } catch (RuntimeException ignored) {
            }
        }
    }
}
