/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.security.MessageDigest;

/**
 * gboy.top cloud room link.
 *
 * The room itself is matched over HTTPS + WebSocket ({@link GbCloud}); the
 * game bytes then travel through the room's relay node using KCP over UDP
 * ({@link KcpChannel}) carrying the GBoy frames of {@link GBoyFrames}.
 *
 * <p>The exchange follows the official GBoy client exactly:</p>
 * <ol>
 *   <li>{@code send_message} with {@code uuid = "GAME_CODE,ROM_MD5"} - until
 *       the server sees this the websocket session is not bound to a game and
 *       the room server ignores the session.</li>
 *   <li>{@code create_game_room} twice: the first call creates the room and
 *       answers with the room id only, the second one answers with the room
 *       that already exists <em>together with the relay node</em>. Room id and
 *       node must be read from that second answer - mixing them silently
 *       connects to the relay of a different room.</li>
 *   <li>{@code join_room} + {@code ready}, then
 *       {@code update_room_settings} to put the room into multiplayer mode -
 *       the lobby shows {@code multiGame:1} only for rooms that are really
 *       running.</li>
 *   <li>over KCP: {@code HS} / {@code HK}, then the registration frame
 *       (type 1, ten byte body), the relay answers with type 3 and the player
 *       count, we answer with an empty type 3, the relay sends type 0 and we
 *       acknowledge with an empty type 1.</li>
 * </ol>
 */
public final class GBoyCloudLink {
    private static final String TAG = "GBoyLink";
    private static final long STEP_WAIT_MS = 20000;
    private static final long ROOM_WAIT_MS = 15000;
    private static final long KEY_INTERVAL_MS = 50;

    public interface Hooks {
        String romPath();

        /** Local key bitmask, GBA style. */
        int localKeys();

        void onRemoteKeys(int keys);

        void onStatus(String text);

        void onConnected(boolean asHost, String note);

        void onRemoteReset();
    }

    private final Hooks hooks;
    private final Object sendLock = new Object();
    private volatile boolean closed;
    private volatile KcpChannel channel;
    private volatile GbCloud.Session session;
    private final GBoyFrames.Reader reader = new GBoyFrames.Reader();
    /** Last key state received from the peer; only transitions are logged. */
    private int lastRxKeys = Integer.MIN_VALUE;
    private Thread worker;

    public GBoyCloudLink(Hooks hooks) {
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

    /** Asks the peer to reset its game. */
    public void sendReset() {
        KcpChannel current = channel;
        if (current != null && !closed) {
            current.send(GBoyFrames.frame(GBoyFrames.TYPE_RESET, 0));
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
        if (roomId != null && (roomId.startsWith("DBGJ:") || roomId.startsWith("NODE2:"))) {
            runManual(roomId.substring(roomId.indexOf(':') + 1), false);
            return;
        }
        if (roomId != null && (roomId.startsWith("DBG:") || roomId.startsWith("NODE:"))) {
            runManual(roomId.substring(roomId.indexOf(':') + 1), true);
            return;
        }
        boolean asHost = roomId == null || roomId.trim().isEmpty();
        status("正在登录 gboy.top…");
        String token = GbCloud.login(user, password);

        status("正在连接房间服务器…");
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

        // The server binds the websocket session to a game identity only after
        // an explicit send_message carrying "GAME_CODE,ROM_MD5"; without it the
        // room server ignores everything that follows.
        String uuid = gameUuid();
        status("正在上传游戏身份…");
        send(sig, sendMessage(token, uuid, "go"), 1200);

        Room room = new Room();
        if (asHost) {
            // Order matters and was verified against the live server: the relay
            // node is NOT part of the first create_game_room answer. It only
            // shows up once the room has been joined, marked ready and switched
            // to multiplayer by update_room_settings - from then on every
            // create_game_room call replies with "您已有房间" plus node_address.
            send(sig, json("leave_room", token, null), 1200);
            send(sig, createJson(token), 2500);
            waitForRoomId(sig, room, 5000);
            if (room.roomId == null || room.roomId.isEmpty()) {
                throw new IOException("服务器没有创建房间");
            }
            send(sig, json("join_room", token, room.roomId), 1500);
            send(sig, json("ready", token, null), 1200);
            send(sig, settingsJson(token, room.roomId), 1500);
            if (room.nodeAddress == null || room.nodePort <= 0) {
                // Ask again: the server now answers with the existing room and
                // the node it assigned to it.
                send(sig, createJson(token), 2500);
                waitForRoom(sig, room, ROOM_WAIT_MS);
            }
            if (room.nodeAddress == null || room.nodePort <= 0) {
                throw new IOException("服务器没有返回中继节点");
            }
        } else {
            status("正在加入房间 " + roomId.trim() + "…");
            send(sig, json("join_room", token, roomId.trim()), 1800);
            send(sig, json("ready", token, null), 1200);
            // The room server normally only tells the creator where the relay
            // lives, so keep watching the socket: some rooms push the node to
            // every member once the game starts.
            waitForRoom(sig, room, 6000);
            if (room.nodeAddress == null || room.nodePort <= 0) {
                throw new IOException("服务器没有把中继地址发给加入者（只发给房主）。"
                        + "请让对方把界面上的「中继 地址:端口」发给你，"
                        + "再用 NODE2:地址:端口 进入");
            }
        }

        status("正在连接中继节点 " + room.nodeAddress + ":" + room.nodePort + "…");
        KcpChannel link;
        try {
            link = KcpChannel.connect(InetAddress.getByName(room.nodeAddress), room.nodePort);
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

        handshake(link, room);
        String text = asHost ? "云端联机已连接，你是 1P" : "云端联机已连接，你是 2P";
        status("房号 " + (room.roomId == null ? "" : room.roomId)
                + "\n中继 " + room.nodeAddress + ":" + room.nodePort
                + "\n" + text);
        hooks.onConnected(asHost, null);
        serve(link);
    }

    /** Skips signalling and connects straight to a hand-supplied relay. */
    private void runManual(String nodeSpec, boolean asHost) throws Exception {
        Integer explicitConv = null;
        int hash = nodeSpec.indexOf('#');
        if (hash > 0) {
            explicitConv = Integer.decode(nodeSpec.substring(hash + 1).trim());
            nodeSpec = nodeSpec.substring(0, hash);
        }
        int colon = nodeSpec.lastIndexOf(':');
        if (colon < 1) {
            throw new IOException("中继地址格式应为 地址:端口");
        }
        String host = nodeSpec.substring(0, colon);
        int port = Integer.parseInt(nodeSpec.substring(colon + 1));
        status("手动中继：直连 " + host + ":" + port
                + (explicitConv == null ? "" : " conv=" + explicitConv)
                + (asHost ? "（1P）" : "（2P）"));
        KcpChannel link = explicitConv == null
                ? KcpChannel.connect(InetAddress.getByName(host), port)
                : KcpChannel.connect(InetAddress.getByName(host), port, explicitConv);
        channel = link;
        if (closed) {
            link.close();
            return;
        }
        Room room = new Room();
        room.nodeAddress = host;
        room.nodePort = port;
        room.playerCount = 2;
        handshake(link, room);
        status("云端联机已连接，你是 " + (asHost ? "1P" : "2P") + "（手动中继）");
        hooks.onConnected(asHost, null);
        serve(link);
    }

    // ---- official wire handshake ----

    /**
     * The cloud handshake of the official client:
     *
     * <pre>
     *   -&gt; type 1, body: int playerCount, short 0, int baseStateCount
     *   &lt;- type 3, body: int playerCount
     *   -&gt; type 3, body: empty            (the base states are loaded now)
     *   &lt;- type 0, body: int                (first key state of the peer)
     *   -&gt; type 1, body: empty             (acknowledgement)
     * </pre>
     */
    private void handshake(KcpChannel link, Room room) throws IOException {
        int players = Math.max(1, room.playerCount);
        link.send(GBoyFrames.registerFrame(players, room.baseStateCount));

        byte[] count = expect(link, GBoyFrames.TYPE_READY, STEP_WAIT_MS);
        int reported = GBoyFrames.intOf(count);
        if (reported > 0) {
            players = reported;
            Log.i(TAG, "relay reports " + players + " players");
        }
        status("已注册到中继，等待对方…");

        link.send(GBoyFrames.frame(GBoyFrames.TYPE_READY));
        expect(link, GBoyFrames.TYPE_KEYS, STEP_WAIT_MS);
        link.send(GBoyFrames.frame(GBoyFrames.TYPE_REGISTER));
        Log.i(TAG, "cloud handshake done, players=" + players);
    }

    /**
     * Reads frames until one of {@code type} shows up. The room server sends
     * the key state (type 0) before the handshake is finished, so unrelated
     * frames are remembered instead of being dropped.
     */
    private byte[] expect(KcpChannel link, int type, long timeoutMs) throws IOException {
        long deadline = System.currentTimeMillis() + timeoutMs;
        while (true) {
            byte[] body = pending();
            if (body != null) {
                if (GBoyFrames.typeOf(body) == type) {
                    return body;
                }
                handle(body);
                continue;
            }
            byte[] message = link.recv(Math.max(50, deadline - System.currentTimeMillis()));
            if (message == null) {
                if (System.currentTimeMillis() >= deadline) {
                    throw new IOException("等待中继回应超时");
                }
                continue;
            }
            reader.append(message, message.length);
        }
    }

    private byte[] pending() {
        return reader.next();
    }

    // ---- signalling diagnostic ----

    /**
     * Drives the room signalling from outside the UI so the gboy.top room
     * protocol can be mapped without guessing: mode {@code host} creates a room,
     * mode {@code join} joins {@code roomId}, and both then fire every candidate
     * action in {@code probes} and log whatever the server answers. Reached via
     * {@code am broadcast -a io.mgba.android.action.SIGNAL ...}.
     */
    void probe(final String mode, final String user, final String password,
               final String roomId, final String probes) {
        new Thread(() -> {
            GbCloud.Session sig = null;
            try {
                String token = GbCloud.login(user, password);
                GbCloud.trace("probe login ok");
                sig = new GbCloud.Session();
                session = sig;
                GbCloud.trace("probe ws ok tls=" + (sig.insecureTls() ? "loose" : "strict"));
                sig.send(sendMessage(token, gameUuid(), "go"));
                drain(sig, 1500);
                String room = roomId == null ? "" : roomId.trim();
                if ("host".equals(mode)) {
                    sig.send(json("leave_room", token, null));
                    drain(sig, 1200);
                    sig.send(createJson(token));
                    drain(sig, 2500);
                    sig.send(createJson(token));
                    drain(sig, 2500);
                } else {
                    sig.send(json("join_room", token, room));
                    drain(sig, 2000);
                    sig.send(json("ready", token, null));
                    drain(sig, 2000);
                }
                for (String raw : probes.split(",")) {
                    String action = raw.trim();
                    if (action.isEmpty()) {
                        continue;
                    }
                    JSONObject object = new JSONObject();
                    object.put("action", action);
                    object.put("token", token);
                    if (!room.isEmpty()) {
                        object.put("room_id", room);
                    }
                    if ("create_game_room".equals(action)) {
                        object.put("room_name", gameName());
                    } else if ("update_room_settings".equals(action)) {
                        object.put("multi_game", 1);
                        object.put("is_udp", 1);
                        object.put("sync_modes", 1);
                        object.put("game_speed", 100);
                        object.put("network_buffer", 100);
                    }
                    GbCloud.trace("probe >> " + object);
                    sig.send(object.toString());
                    drain(sig, 2500);
                }
                GbCloud.trace("probe done");
            } catch (Exception e) {
                GbCloud.trace("probe failed: " + e);
            } finally {
                if (sig != null) {
                    try {
                        sig.close();
                    } catch (Exception ignored) {
                        // best effort
                    }
                }
            }
        }, "gboy-signal-probe").start();
    }

    /** Logs everything the room server pushes for the next {@code ms}. */
    private void drain(GbCloud.Session sig, long ms) throws IOException {
        long end = System.currentTimeMillis() + ms;
        while (System.currentTimeMillis() < end) {
            String text = sig.recv(Math.max(200, Math.min(1000, end - System.currentTimeMillis())));
            if (text != null) {
                GbCloud.trace("ws " + text);
            }
        }
    }

    // ---- game loop ----

    private void serve(KcpChannel link) {
        long lastKey = 0;
        long lastFps = 0;
        int sentKeys = Integer.MIN_VALUE;
        while (!closed) {
            long now = System.currentTimeMillis();
            if (now - lastKey >= KEY_INTERVAL_MS) {
                int keys = hooks.localKeys();
                if (keys != sentKeys || now - lastKey >= 500) {
                    boolean changed = keys != sentKeys;
                    sentKeys = keys;
                    lastKey = now;
                    link.send(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, keys));
                    if (changed) {
                        Log.i(TAG, "tx keys=0x" + Integer.toHexString(keys));
                    }
                }
            }
            if (now - lastFps >= 1000) {
                lastFps = now;
                link.send(GBoyFrames.frame(GBoyFrames.TYPE_FPS, 60));
            }
            byte[] message = link.recv(50);
            if (message == null) {
                continue;
            }
            reader.append(message, message.length);
            byte[] body;
            while ((body = pending()) != null) {
                handle(body);
            }
        }
    }

    private void handle(byte[] body) {
        int type = GBoyFrames.typeOf(body);
        switch (type) {
            case GBoyFrames.TYPE_KEYS:
            case GBoyFrames.TYPE_KEYS_LOCAL: {
                int keys = GBoyFrames.intOf(body);
                if (keys != lastRxKeys) {
                    lastRxKeys = keys;
                    Log.i(TAG, "rx keys=0x" + Integer.toHexString(keys));
                }
                hooks.onRemoteKeys(keys);
                break;
            }
            case GBoyFrames.TYPE_RESET:
                hooks.onRemoteReset();
                break;
            case GBoyFrames.TYPE_EVENT:
                Log.i(TAG, "event " + GBoyFrames.intOf(body));
                break;
            default:
                Log.i(TAG, "rx type=" + type + " len=" + body.length);
                break;
        }
    }

    // ---- signalling helpers ----

    private static final class Room {
        String roomId;
        String nodeAddress;
        int nodePort;
        int playerCount = 2;
        int baseStateCount;
    }

    /** Sends a signalling frame and gives the server time to answer. */
    private static void send(GbCloud.Session sig, String json, long waitMs) throws IOException {
        sig.send(json);
        try {
            Thread.sleep(waitMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("连接被中断");
        }
    }

    /**
     * Scans the signalling stream for the room description. The node endpoint
     * shows up in the {@code create_game_room} answer, the player count in the
     * {@code player_joined} pushes.
     */
    private void waitForRoom(GbCloud.Session sig, Room room, long timeoutMs) throws IOException {
        long deadline = System.currentTimeMillis() + timeoutMs;
        while (System.currentTimeMillis() < deadline && !closed) {
            String text = sig.recv(1200);
            if (text == null) {
                continue;
            }
            GbCloud.trace("ws " + text);
            JSONObject object = GbCloud.lastJsonObject(text);
            if (object == null) {
                continue;
            }
            String type = object.optString("type", "");
            if ("create_game_room".equals(type)) {
                String roomId = object.optString("room_id", null);
                if (roomId != null && !roomId.isEmpty()) {
                    room.roomId = roomId;
                }
                String address = object.optString("node_address", null);
                int port = object.optInt("node_port", 0);
                if (address != null && !address.isEmpty() && port > 0) {
                    room.nodeAddress = address;
                    room.nodePort = port;
                }
                JSONArray base = object.optJSONArray("base_list");
                if (base != null) {
                    room.baseStateCount = base.length();
                }
            } else if ("player_joined".equals(type)) {
                JSONArray users = object.optJSONArray("users");
                if (users != null) {
                    int ready = 0;
                    for (int i = 0; i < users.length(); i++) {
                        JSONObject user = users.optJSONObject(i);
                        if (user == null) {
                            continue;
                        }
                        String name = user.optString("username", "");
                        if (name == null || name.isEmpty()) {
                            continue;
                        }
                        if (user.optInt("started", 0) != 0) {
                            ready++;
                        }
                    }
                    if (ready > 0) {
                        room.playerCount = ready;
                    }
                }
            } else if ("room_started".equals(type) || "game_started".equals(type)) {
                String address = object.optString("node_address", null);
                int port = object.optInt("node_port", 0);
                if (address != null && !address.isEmpty() && port > 0) {
                    room.nodeAddress = address;
                    room.nodePort = port;
                }
            }
            if (room.nodeAddress != null && room.nodePort > 0) {
                return;
            }
        }
    }

    /**
     * Reads until the room id is known (the relay node normally is not part of
     * that first answer). Used before join_room, which needs the id.
     */
    private void waitForRoomId(GbCloud.Session sig, Room room, long timeoutMs) throws IOException {
        long deadline = System.currentTimeMillis() + timeoutMs;
        while (System.currentTimeMillis() < deadline && !closed) {
            String text = sig.recv(1200);
            if (text == null) {
                continue;
            }
            GbCloud.trace("ws " + text);
            JSONObject object = GbCloud.lastJsonObject(text);
            if (object == null) {
                continue;
            }
            if ("create_game_room".equals(object.optString("type", ""))) {
                String roomId = object.optString("room_id", null);
                if (roomId != null && !roomId.isEmpty()) {
                    room.roomId = roomId;
                }
                String address = object.optString("node_address", null);
                int port = object.optInt("node_port", 0);
                if (address != null && !address.isEmpty() && port > 0) {
                    room.nodeAddress = address;
                    room.nodePort = port;
                }
            }
            if (room.roomId != null && !room.roomId.isEmpty()) {
                return;
            }
        }
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
     * The room settings the official client pushes when a room turns into a
     * multiplayer room: multiplayer mode on, UDP transport, key synchronisation
     * and a sane game speed.
     */
    private static String settingsJson(String token, String roomId) throws Exception {
        JSONObject object = new JSONObject();
        object.put("action", "update_room_settings");
        object.put("token", token);
        object.put("room_id", roomId);
        object.put("multi_game", 1);
        object.put("is_udp", 1);
        object.put("sync_modes", 1);
        object.put("game_speed", 100);
        object.put("network_buffer", 100);
        return object.toString();
    }

    private static String sendMessage(String token, String uuid, String message) throws Exception {
        JSONObject object = new JSONObject();
        object.put("action", "send_message");
        object.put("token", token);
        object.put("message", message);
        object.put("uuid", uuid);
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
        object.put("room_name", gameName());
        return object.toString();
    }

    private String gameName() {
        String path = hooks.romPath();
        if (path == null || path.isEmpty()) {
            return "mGBA";
        }
        int slash = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));
        String name = slash >= 0 ? path.substring(slash + 1) : path;
        int dot = name.indexOf('.');
        if (dot > 0) {
            name = name.substring(0, dot);
        }
        return name.isEmpty() ? "mGBA" : name;
    }

    /**
     * The game identity the room server expects: the four character game code
     * of the ROM header followed by the MD5 of the ROM, e.g.
     * {@code BPEE,55c9004420cd750f03192bc20569e1ab}.
     */
    private String gameUuid() {
        String path = hooks.romPath();
        if (path == null || path.isEmpty()) {
            return "BPEE,";
        }
        File rom = new File(path);
        if (!rom.isFile()) {
            return "BPEE,";
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] head = new byte[0xB0];
            long read = 0;
            try (InputStream in = new FileInputStream(rom)) {
                int n;
                while (read < head.length && (n = in.read(head, (int) read, head.length - (int) read)) > 0) {
                    read += n;
                }
                md.update(head, 0, (int) read);
                byte[] buffer = new byte[65536];
                while ((n = in.read(buffer)) > 0) {
                    md.update(buffer, 0, n);
                }
            }
            StringBuilder hex = new StringBuilder(32);
            for (byte b : md.digest()) {
                hex.append(Character.forDigit((b >> 4) & 0xF, 16));
                hex.append(Character.forDigit(b & 0xF, 16));
            }
            StringBuilder code = new StringBuilder(4);
            for (int i = 0xAC; i < 0xB0 && i < read; i++) {
                char c = (char) (head[i] & 0xFF);
                code.append(c >= 0x20 && c < 0x7F ? c : '0');
            }
            String prefix = code.length() == 4 ? code.toString() : "BPEE";
            return prefix + "," + hex;
        } catch (Exception e) {
            Log.w(TAG, "cannot read rom identity", e);
            return "BPEE,";
        }
    }

    private void fail(String text) {
        GbCloud.trace("fail " + text);
        closed = true;
        hooks.onRemoteKeys(0);
        status(text);
    }

    private void status(final String text) {
        Log.d(TAG, "status: " + text);
        hooks.onStatus(text);
    }

    private static String message(Exception e) {
        String text = e.getMessage();
        if (text == null || text.isEmpty()) {
            return "云端联机失败";
        }
        return text;
    }
}
