/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.net.InetAddress;

/**
 * gboy.top cloud room link.
 *
 * The room itself is matched over HTTPS + WebSocket ({@link GbCloud}); the
 * game bytes then travel through the room's relay node using KCP over UDP
 * ({@link KcpChannel}) carrying the same GBoyLink frames the local Wi-Fi link
 * uses. The room creator plays as 1P, the joiner as 2P.
 */
public final class GBoyCloudLink {
    private static final long PEER_WAIT_MS = 120000;
    private static final long STEP_WAIT_MS = 20000;

    private final GBoyLink.Hooks hooks;
    private final Object sendLock = new Object();
    private volatile boolean closed;
    private volatile KcpChannel channel;
    private volatile GbCloud.Session session;
    private Thread worker;

    public GBoyCloudLink(GBoyLink.Hooks hooks) {
        this.hooks = hooks;
    }

    /** {@code roomId} empty or null creates a room, otherwise joins it. */
    public void start(final String user, final String password, final String roomId) {
        closed = false;
        Thread thread = new Thread(() -> {
            try {
                run(user, password, roomId);
            } catch (Exception e) {
                if (!closed) {
                    fail(message(e));
                }
            }
        }, "gboy-cloud");
        thread.setDaemon(true);
        thread.start();
        worker = thread;
    }

    public void sendReset() {
        KcpChannel current = channel;
        if (current != null && !closed) {
            current.send(GBoyFrames.frame(GBoyFrames.MSG_RESET));
        }
    }

    public void close() {
        closed = true;
        KcpChannel current = channel;
        channel = null;
        if (current != null) {
            current.close();
        }
        GbCloud.Session open = session;
        session = null;
        if (open != null) {
            open.close();
        }
        if (worker != null) {
            worker.interrupt();
        }
        hooks.onRemoteKeys(0);
    }

    // ---- session ----

    /**
     * When the room id begins with {@code NODE:} (1P) or {@code NODE2:} (2P) the
     * rest is read as {@code address:port} of a relay and the whole signalling
     * stage is skipped. {@code DBG:}/{@code DBGJ:} are the older spellings.
     *
     * Needed in practice: gboy.top hands the relay endpoint only to the room
     * creator, so the joining player has to type the host's relay in by hand.
     */
    private void run(String user, String password, String roomId) throws Exception {
        // "DBG:"/"DBGJ:" dial a hand-supplied relay (1P/2P) with no account.
        // "NODE:"/"NODE2:" are the same shortcut under a player-facing name:
        // gboy.top only returns the relay port to the host, so the guest has to
        // be handed "address:port" out of band.
        if (roomId != null && (roomId.startsWith("DBGJ:") || roomId.startsWith("NODE2:"))) {
            runDebug(roomId.substring(roomId.indexOf(':') + 1), false);
            return;
        }
        if (roomId != null && (roomId.startsWith("DBG:") || roomId.startsWith("NODE:"))) {
            runDebug(roomId.substring(roomId.indexOf(':') + 1), true);
            return;
        }
        boolean asHost = roomId == null || roomId.trim().isEmpty();
        status("正在登录 gboy.top…");
        String token = GbCloud.login(user, password);

        status("正在打开房间…");
        GbCloud.Session sig = new GbCloud.Session();
        session = sig;
        if (sig.insecureTls()) {
            // The room port serves an expired cert for another domain; the
            // protocol only works if the chain is ignored. Users should know.
            status("注意：gboy.top 联机端口证书已过期，已降级连接");
        }
        if (closed) {
            sig.close();
            return;
        }

        String room = roomId == null ? "" : roomId.trim();
        GbCloud.Node node;
        if (asHost) {
            sig.send(createJson(token));
            Thread.sleep(1200);
            // The first call creates the room; the second one answers with the
            // relay node the room was assigned.
            sig.send(createJson(token));
            node = waitForNode(sig, 12000);
            if (node == null) {
                throw new IOException("服务器没有返回中继节点");
            }
            // Creating a room does not put the host inside it - without this
            // join the room shows one player and the peer never pairs up.
            if (node.roomId != null && !node.roomId.isEmpty()) {
                sig.send(json("join_room", token, node.roomId));
                Thread.sleep(900);
            }
            sig.send(json("ready", token, null));
            status("房号 " + (node.roomId == null ? room : node.roomId)
                    + "\n中继 " + node
                    + "\n对方连不上时，让他在房号处输入 NODE2:" + node);
        } else {
            status("正在加入房间 " + room + "…");
            sig.send(json("join_room", token, room));
            Thread.sleep(1200);
            sig.send(json("query_room", token, room));
            sig.send(json("ready", token, null));
            // The server answers create_game_room (host side) with the relay,
            // but never pushes it to the joiner, so this usually stays null.
            node = waitForNode(sig, 8000);
            if (node == null) {
                throw new IOException("服务器没有把中继地址发给加入者（只发给房主）。"
                        + "请让对方把界面上的「中继 地址:端口」发给你，再用 NODE2:地址:端口 进入");
            }
        }

        status("正在连接中继节点 " + node + "…");
        KcpChannel link;
        try {
            link = KcpChannel.connect(InetAddress.getByName(node.address), node.port);
        } catch (IOException e) {
            // A local VPN/accelerator rewrites all UDP into its tunnel and the
            // relay handshake then never comes back, which looks like a dead
            // server. Say so instead of surfacing a bare timeout.
            throw new IOException(e.getMessage() + "（请检查网络；开着 VPN/加速器时请先关闭）");
        }
        channel = link;
        if (closed) {
            link.close();
            return;
        }
        status("中继已连通，等待对方…");

        String note = handshake(link, asHost);
        String text = asHost ? "云端联机已连接，你是 1P" : "云端联机已连接，你是 2P";
        status(note == null || note.isEmpty() ? text : note + "\n" + text);
        serve(link);
    }

    private static String json(String action, String token, String roomId) throws Exception {
        JSONObject object = new JSONObject();
        object.put("action", action);
        object.put("token", token);
        if (roomId != null && !roomId.isEmpty()) {
            object.put("room_id", roomId);
        }
        return object.toString();
    }

    /**
     * create_game_room without {@code game_name} is dropped in silence by the
     * room server (no error frame comes back), which looks exactly like a dead
     * socket. Name the room after the loaded ROM.
     */
    private String createJson(String token) throws Exception {
        JSONObject object = new JSONObject();
        object.put("action", "create_game_room");
        object.put("token", token);
        object.put("game_name", gameName());
        return object.toString();
    }

    private String gameName() {
        String path = hooks.romPath();
        if (path == null || path.isEmpty()) {
            return "mGBA";
        }
        int slash = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));
        String name = slash >= 0 ? path.substring(slash + 1) : path;
        int dot = name.lastIndexOf('.');
        if (dot > 0) {
            name = name.substring(0, dot);
        }
        return name.isEmpty() ? "mGBA" : name;
    }

    /** The node only shows up in some replies, so scan every frame for it. */
    private GbCloud.Node waitForNode(GbCloud.Session sig, long timeoutMs) throws IOException {
        long deadline = System.currentTimeMillis() + timeoutMs;
        while (System.currentTimeMillis() < deadline && !closed) {
            String text = sig.recv(1500);
            if (text == null) {
                continue;
            }
            GbCloud.trace("ws " + text);
            if (!text.contains("node_address")) {
                continue;
            }
            JSONObject object = GbCloud.lastJsonObject(text);
            String address = object.optString("node_address", null);
            int port = object.optInt("node_port", 0);
            String roomId = object.optString("room_id", null);
            if (address != null && !address.isEmpty() && port > 0) {
                return new GbCloud.Node(address, port, roomId);
            }
        }
        return null;
    }

    private String handshake(KcpChannel link, boolean asHost) throws IOException {
        String note = null;
        if (!asHost) {
            send(link, GBoyFrames.frameHello());
        }
        expectHello(link, asHost);

        byte[] info = GBoyFrames.romInfo(hooks.romPath());
        send(link, info);
        status("已交换游戏信息…");

        byte[] peer = expect(link, GBoyFrames.MSG_ROM_INFO, STEP_WAIT_MS);
        String mine = GBoyFrames.romHashOf(info);
        String theirs = GBoyFrames.romHashOf(peer);
        if (mine != null && theirs != null && !mine.equalsIgnoreCase(theirs)) {
            note = "注意：两边的游戏不一致，联机可能无法正常同步";
        }

        send(link, GBoyFrames.frame(GBoyFrames.MSG_READY));
        expect(link, GBoyFrames.MSG_READY, STEP_WAIT_MS);

        if (asHost) {
            expect(link, GBoyFrames.MSG_STATE, STEP_WAIT_MS);
            send(link, GBoyFrames.frameState(hooks.romPath()));
        } else {
            send(link, GBoyFrames.frameState(hooks.romPath()));
            expect(link, GBoyFrames.MSG_STATE, STEP_WAIT_MS);
        }
        note = appendNote(note, "已收到对方即时存档（本机继续用本机进度）");
        return note;
    }

    private void expectHello(KcpChannel link, boolean asHost) throws IOException {
        // The peer may still be on its way in, so the first frame can take a
        // while; KEYS/RESET from an earlier session are dropped.
        byte[] frame = expect(link, GBoyFrames.MSG_HELLO, PEER_WAIT_MS);
        if (GBoyFrames.valueOf(frame) != 6) {
            throw new IOException("联机大厅协议版本不符");
        }
        if (asHost) {
            send(link, GBoyFrames.frameHello());
        }
    }

    private static byte[] expect(KcpChannel link, int want, long timeoutMs) throws IOException {
        long deadline = System.currentTimeMillis() + timeoutMs;
        while (true) {
            byte[] frame = link.recv(Math.max(200, deadline - System.currentTimeMillis()));
            if (frame == null) {
                throw new IOException("等待对方超时");
            }
            int type = GBoyFrames.typeOf(frame);
            if (type == want) {
                return frame;
            }
            if (type != GBoyFrames.MSG_KEYS && type != GBoyFrames.MSG_RESET) {
                throw new IOException("对方不是联机大厅会话");
            }
        }
    }

    private void serve(KcpChannel link) {
        long lastSend = 0;
        while (!closed) {
            long now = System.currentTimeMillis();
            if (now - lastSend >= 83) {
                lastSend = now;
                link.send(GBoyFrames.frameKeys(hooks.localKeys()));
            }
            byte[] frame = link.recv(50);
            if (frame == null) {
                continue;
            }
            int type = GBoyFrames.typeOf(frame);
            if (type == GBoyFrames.MSG_KEYS) {
                hooks.onRemoteKeys(GBoyFrames.valueOf(frame));
            } else if (type == GBoyFrames.MSG_RESET) {
                hooks.onRemoteReset();
            }
        }
    }

    private void send(KcpChannel link, byte[] payload) throws IOException {
        synchronized (sendLock) {
            link.send(payload);
        }
    }

    private static String appendNote(String note, String extra) {
        if (note == null || note.isEmpty()) {
            return extra;
        }
        return note + "\n" + extra;
    }

    private void fail(String text) {
        GbCloud.trace("fail " + text);
        closed = true;
        hooks.onRemoteKeys(0);
        status(text);
    }

    private void status(final String text) {
        Log.d("GBOYLINK", "status: " + text);
        hooks.onStatus(text);
    }

    /** Skips signalling and connects straight to a hand-supplied relay. */
    private void runDebug(String nodeSpec, boolean asHost) throws Exception {
        int colon = nodeSpec.lastIndexOf(':');
        if (colon < 1) {
            throw new IOException("中继地址格式应为 地址:端口");
        }
        String host = nodeSpec.substring(0, colon);
        int port = Integer.parseInt(nodeSpec.substring(colon + 1));
        status("手动中继：直连 " + host + ":" + port + (asHost ? "（1P）" : "（2P）"));
        KcpChannel link = KcpChannel.connect(InetAddress.getByName(host), port);
        channel = link;
        if (closed) {
            link.close();
            return;
        }
        status("中继已连通，等待对方…");
        String note = handshake(link, asHost);
        String text = asHost ? "云端联机已连接，你是 1P（手动中继）" : "云端联机已连接，你是 2P（手动中继）";
        status(note == null || note.isEmpty() ? text : note + "\n" + text);
        serve(link);
    }

    private static String message(Exception e) {
        String text = e.getMessage();
        if (text == null || text.isEmpty()) {
            return "云端联机失败";
        }
        return text;
    }
}
