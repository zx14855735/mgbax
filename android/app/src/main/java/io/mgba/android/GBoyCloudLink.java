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
    /** Public relay slots are recycled slowly; keep retrying for a while. */
    private static final long RELAY_WAIT_MS = 300000;
    /** How long to wait for the peer's first key state before starting anyway. */
    private static final long PEER_KEY_WAIT_MS = 4000;
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
    /** Re-broadcasts the relay endpoint to the room so the joiner can find it. */
    private volatile Thread advertiser;
    /** 会话信息：「重新连接中继」按钮复用它，不重建房间。 */
    private volatile String authToken;
    private volatile Room currentRoom;
    private volatile boolean hostRole;
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
        }, "lobby-cloud");
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
        if (advertiser != null) {
            advertiser.interrupt();
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
        status("正在登录联机大厅…");
        String token = GbCloud.login(user, password);

        status("正在连接房间服务器…");
        GbCloud.Session sig = new GbCloud.Session();
        session = sig;
        if (sig.insecureTls()) {
            // The room port serves an expired cert for another domain; the
            // protocol only works if the chain is ignored. Users should know.
            status("注意：联机大厅端口证书已过期，已降级连接");
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
            hostCreateRoom(sig, token, uuid, room);
            // gboy.top only tells the creator where the relay lives, so advertise
            // it to the room (over the lobby broadcast channel) for as long as the
            // link is up. The joiner reads it automatically and fills the relay in
            // itself - no manual NODE2: entry needed.
            startNodeAdvertiser(sig, token, uuid, room);
        } else {
            status("正在加入房间 " + roomId.trim() + "…");
            send(sig, json("join_room", token, roomId.trim()), 1800);
            send(sig, json("ready", token, null), 1200);
            // The room server normally only tells the creator where the relay
            // lives, so the host advertises it over the broadcast channel instead.
            // Watch for that for a generous window - the host keeps re-sending it.
            room.roomId = roomId.trim();
            waitForRoom(sig, room, roomId.trim(), 20000);
            if (room.nodeAddress == null || room.nodePort <= 0) {
                throw new IOException("未能自动获取对方的中继地址。"
                        + "请让房主把界面上的「中继 地址:端口」发给你，"
                        + "再用 NODE2:地址:端口 进入（房号框填 NODE2:地址:端口）");
            }
        }

        authToken = token;
        currentRoom = room;
        hostRole = asHost;
        connectRelay(sig, token, room, asHost);
    }

    /**
     * 连上中继并进入对战循环。房间与信令已经就绪，这里只负责数据通道，
     * 「重新连接中继」按钮也复用同一段逻辑。
     */
    private void connectRelay(final GbCloud.Session sig, final String token, final Room room,
                              final boolean asHost) throws IOException {
        status((asHost ? "房间已创建，房号 " : "已加入房间 ")
                + (room.roomId == null ? "" : room.roomId)
                + "\n中继 " + room.nodeAddress + ":" + room.nodePort
                + "\n正在连接中继节点，等待对方加入…");
        // 先问一次当前节点：公共节点会被服务器回收，房间还在但节点可能已经换了
        String fresh = currentNode(sig, token, room, asHost);
        if (fresh != null) {
            int colon = fresh.lastIndexOf(':');
            if (colon > 0) {
                try {
                    room.nodeAddress = fresh.substring(0, colon);
                    room.nodePort = Integer.parseInt(fresh.substring(colon + 1).trim());
                } catch (NumberFormatException ignored) {
                    // 保留原来的节点
                }
            }
        }
        final String currentRoom = room.roomId;
        final boolean creator = asHost;
        KcpChannel link = startRelayLink(room.nodeAddress, room.nodePort, room, new NodeQuery() {
            @Override
            public String query() {
                return currentNode(sig, token, room, creator);
            }
        });
        if (closed) {
            link.close();
            return;
        }
        String text = asHost ? "云端联机已连接，你是 1P" : "云端联机已连接，你是 2P";
        status("房号 " + (room.roomId == null ? "" : room.roomId)
                + "\n中继 " + room.nodeAddress + ":" + room.nodePort
                + "\n" + text);
        hooks.onConnected(asHost, null);
        serve(link);
    }

    /**
     * 问服务器（房主）或房主广播（加入方）当前的中继节点，返回 "地址:端口" 或 null。
     */
    private String currentNode(final GbCloud.Session sig, final String token, final Room room,
                               final boolean creator) {
        try {
            Room probe = new Room();
            if (creator) {
                // 房主直接问服务器当前的节点
                send(sig, createJson(token), 2000);
                waitForRoom(sig, probe, room.roomId, 8000);
            } else {
                // 加入方听房主的广播，节点换了就跟着换
                waitForRoom(sig, probe, room.roomId, 4000);
            }
            if (probe.nodeAddress == null || probe.nodePort <= 0) {
                return null;
            }
            return probe.nodeAddress + ":" + probe.nodePort;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 重新连接中继：不重建房间，直接重新解析节点并重连数据通道。
     * 房间还在、但节点被回收或对端掉线时用得上。
     */
    public void reconnectRelay() {
        final GbCloud.Session sig = session;
        final String token = authToken;
        final Room room = currentRoom;
        final boolean asHost = hostRole;
        if (sig == null || token == null || room == null) {
            status("还没有房间，请先点「云端创建」或「云端加入」");
            return;
        }
        // 关掉旧通道，让旧的 serve 循环退出
        KcpChannel old = channel;
        channel = null;
        if (old != null) {
            old.close();
        }
        status("正在重新连接中继…");
        new Thread(() -> {
            try {
                connectRelay(sig, token, room, asHost);
            } catch (Exception e) {
                if (!closed) {
                    fail(message(e));
                }
            }
        }, "lobby-reconnect").start();
    }

    /**
     * 建房并取到中继节点。
     *
     * 这里必须先把可能存在的「旧房间」解散掉再新建：服务器把房间绑在账号上，
     * 旧房间里的中继节点是公共节点池里会被回收的旧端口，拿它去连只会一直超时
     * （表现就是「中继没有回应」）。而 leave_room 只有在会话已经进过房间时才生效
     * （否则服务器回「您不在任何游戏房间中」），所以顺序是：
     *
     *   create_game_room（问出旧房号）→ join_room → leave_room（房主离开，房间解散）
     *   → create_game_room（全新房间 + 全新节点）→ join/ready/update_room_settings
     *   → create_game_room（再问一次，这次带回中继节点）
     */
    private void hostCreateRoom(GbCloud.Session sig, String token, String uuid, Room room)
            throws Exception {
        // 1) 先问一次当前房间（旧房间也要一并解散）
        send(sig, createJson(token), 2500);
        waitForRoomId(sig, room, 5000);
        if (room.roomId != null && !room.roomId.isEmpty()) {
            send(sig, json("join_room", token, room.roomId), 1500);
            send(sig, json("leave_room", token, null), 1500);
            // 房主离开时服务器会解散房间，等它把旧节点释放掉
            Thread.sleep(800);
        }
        // 2) 建一个全新的房间
        Room fresh = new Room();
        send(sig, createJson(token), 2500);
        waitForRoomId(sig, fresh, 6000);
        if (fresh.roomId == null || fresh.roomId.isEmpty()) {
            throw new IOException("服务器没有创建房间");
        }
        room.roomId = fresh.roomId;
        room.nodeAddress = null;
        room.nodePort = 0;
        // 3) 进房 + ready + 切成多人房间
        send(sig, json("join_room", token, room.roomId), 1500);
        send(sig, json("ready", token, null), 1200);
        send(sig, settingsJson(token, room.roomId), 1500);
        // 4) 再问一次：这时服务器会连同中继节点一起返回
        send(sig, createJson(token), 2500);
        waitForRoom(sig, room, null, ROOM_WAIT_MS);
        if (room.nodeAddress == null || room.nodePort <= 0) {
            throw new IOException("服务器没有返回中继节点");
        }
    }

    /**
     * 联机自检：在本机验证"登录 → 建房拿中继节点 → UDP/KCP 握手"全链路是否可达。
     * 与真实联机走完全相同的信令路径，但连上中继完成握手即结束（不进入对战 serve 循环），
     * 只用来判断"这台手机的网络能否云端联机"。真正的双机互传仍需两台不同 IP 设备实战。
     */
    public void selfTest(final String user, final String password) {
        final GBoyCloudLink self = this;
        new Thread(() -> {
            GbCloud.Session sig = null;
            KcpChannel link = null;
            try {
                self.status("自检：登录联机大厅…");
                String token = GbCloud.login(user, password);
                self.status("自检：连接房间服务器…");
                sig = new GbCloud.Session();
                if (sig.insecureTls()) {
                    self.status("自检：联机大厅端口证书已过期，已降级连接");
                }
                String uuid = self.gameUuid();
                self.send(sig, self.sendMessage(token, uuid, "go"), 1200);
                self.status("自检：创建房间…");
                Room room = new Room();
                self.hostCreateRoom(sig, token, uuid, room);
                // 让对方也能自动拿到中继节点（和真实对战完全一样的广播）
                self.startNodeAdvertiser(sig, token, uuid, room);
                self.status("✅ 信令自检通过\n房号 " + room.roomId
                        + "\n中继 " + room.nodeAddress + ":" + room.nodePort
                        + "\n正在等对方进入这个房间（公共节点要两端都接入才会应答）…");
                // 复用游戏用的 KCP over UDP 传输做真实握手。
                // 注意：只有自己一个人在房间里时，公共节点是不会应答的，
                // 所以这里一直等，等对方进来后自然会连上。
                link = self.startRelayLink(room.nodeAddress, room.nodePort, room, null);
                self.status("✅ 联机自检通过：\n房号 " + room.roomId
                        + "\n中继 " + room.nodeAddress + ":" + room.nodePort
                        + "\n信令与中继 UDP/KCP 均可达，本机可以云端联机对战。");
            } catch (Exception e) {
                if (!closed) {
                    self.status("❌ 联机自检失败：" + message(e)
                            + "\n常见原因：网络不通 / VPN 或加速器拦截 UDP / 账号问题。");
                }
            } finally {
                if (link != null) {
                    link.close();
                }
                if (sig != null) {
                    sig.close();
                }
            }
        }, "lobby-self-test").start();
    }

    /** Skips signalling and connects straight to a hand-supplied relay. */
    private void runManual(String nodeSpec, boolean asHost) throws Exception {
        Integer explicitConv = null;
        int hash = nodeSpec.indexOf('#');
        if (hash > 0) {
            explicitConv = Integer.decode(nodeSpec.substring(hash + 1).trim());
            nodeSpec = nodeSpec.substring(0, hash);
        }
        // "tcp:" switches to the framed TCP transport, which is what a TCP
        // tunnel (ssh -R / bore / ngrok) can carry; UDP tunnels are rare.
        boolean tcp = nodeSpec.regionMatches(true, 0, "tcp:", 0, 4);
        if (tcp) {
            nodeSpec = nodeSpec.substring(4);
        }
        int colon = nodeSpec.lastIndexOf(':');
        if (colon < 1) {
            throw new IOException("中继地址格式应为 地址:端口");
        }
        String host = nodeSpec.substring(0, colon);
        // Belt and braces: if the prefix survived the split (older entry paths
        // split on the last colon only), strip it here instead of failing with
        // "Unable to resolve host tcp:...".
        if (host.regionMatches(true, 0, "tcp:", 0, 4)) {
            tcp = true;
            host = host.substring(4);
        }
        int port = Integer.parseInt(nodeSpec.substring(colon + 1));
        status("手动中继：直连 " + host + ":" + port + (tcp ? "（TCP）" : "")
                + (explicitConv == null ? "" : " conv=" + explicitConv)
                + (asHost ? "（1P）" : "（2P）"));
        Room room = new Room();
        room.nodeAddress = host;
        room.nodePort = port;
        room.playerCount = 2;
        KcpChannel link;
        if (tcp) {
            // A tunnel endpoint is a plain TCP listener: no session table, no
            // silent drops, so the retry dance is unnecessary there.
            link = KcpChannel.connectTcp(InetAddress.getByName(host), port);
            channel = link;
            if (closed) {
                link.close();
                return;
            }
            sendRegister(link, room);
            handshake(link, room);
        } else if (explicitConv != null) {
            link = KcpChannel.connect(InetAddress.getByName(host), port, explicitConv);
            channel = link;
            if (closed) {
                link.close();
                return;
            }
            sendRegister(link, room);
            handshake(link, room);
        } else {
            link = startRelayLink(host, port, room, null);
            if (closed) {
                link.close();
                return;
            }
        }
        status("云端联机已连接，你是 " + (asHost ? "1P" : "2P") + "（手动中继）");
        hooks.onConnected(asHost, null);
        serve(link);
    }

    /**
     * Connects to the public relay and completes the GBoy handshake.
     *
     * - The very same session (one conversation id, one UDP port) is reused for
     *   every retry. The node keeps a tiny, slowly recycled session table, so
     *   a retry that builds a brand new session fills that table with half open
     *   leftovers and the node then silently drops the newcomer - the room
     *   looks permanently dead after one unlucky try.
     * - Public nodes usually answer only once the second player has joined, so
     *   the retries run for several minutes and the status tells the user that
     *   we are waiting for the opponent.
     * - A node can be recycled by the server at any time, so every 30 seconds
     *   we ask the room server for the current node and switch over when it
     *   changed.
     */
    private KcpChannel startRelayLink(String host, int port, Room room, NodeQuery query)
            throws IOException {
        IOException failure = null;
        long deadline = System.currentTimeMillis() + RELAY_WAIT_MS;
        long started = System.currentTimeMillis();
        long nextQuery = 0;
        long lastNotice = 0;
        String currentHost = host;
        int currentPort = port;
        KcpChannel link = null;
        boolean registered = false;
        while (!closed && System.currentTimeMillis() < deadline) {
            try {
                if (link == null) {
                    link = KcpChannel.open(java.net.InetAddress.getByName(currentHost), currentPort,
                            java.util.UUID.randomUUID().hashCode() & Integer.MAX_VALUE);
                    channel = link;
                    registered = false;
                }
                if (link.retryHandshake(3000)) {
                    if (!registered) {
                        sendRegister(link, room);
                        registered = true;
                    }
                    try {
                        handshake(link, room);
                        return link;
                    } catch (IOException e) {
                        // 已经连上中继，但对方还没注册：保留同一个会话继续等
                        failure = e;
                        Log.i(TAG, "relay handshake pending: " + e.getMessage());
                        sleepQuietly(1000);
                        continue;
                    }
                }
                // 节点可能被回收了，重新问一次服务器
                if (query != null && System.currentTimeMillis() >= nextQuery) {
                    nextQuery = System.currentTimeMillis() + 30000;
                    String fresh = query.query();
                    if (fresh != null) {
                        int colon = fresh.lastIndexOf(':');
                        if (colon > 0) {
                            String freshHost = fresh.substring(0, colon);
                            int freshPort = Integer.parseInt(fresh.substring(colon + 1).trim());
                            if (!freshHost.equals(currentHost) || freshPort != currentPort) {
                                status("中继节点已更新为 " + fresh + "，正在切换…");
                                link.close();
                                link = null;
                                channel = null;
                                currentHost = freshHost;
                                currentPort = freshPort;
                                room.nodeAddress = freshHost;
                                room.nodePort = freshPort;
                                continue;
                            }
                        }
                    }
                }
                if (System.currentTimeMillis() - lastNotice >= 5000) {
                    lastNotice = System.currentTimeMillis();
                    long waited = (System.currentTimeMillis() - started) / 1000;
                    status("房号 " + (room.roomId == null ? "" : room.roomId)
                            + "\n中继还没有回应（已等待 " + waited + " 秒）\n"
                            + "公共节点要等对方也进入房间才会应答，请把房号发给对方\n"
                            + "若对方已进房仍无回应，可能是网络拦截了 UDP（关闭 VPN/加速器，或改用移动数据）");
                }
                sleepQuietly(1000);
            } catch (IOException e) {
                failure = e;
                Log.i(TAG, "relay attempt failed: " + e.getMessage());
                if (link != null) {
                    link.close();
                    link = null;
                    channel = null;
                }
            }
        }
        String detail = failure == null ? "中继连接被取消" : failure.getMessage();
        throw new IOException(detail + "（开着 VPN/加速器时请先关闭）");
    }

    /** 等一会儿，被打断时安静退出。 */
    private static void sleepQuietly(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /** 重新向房间服务器询问当前的中继节点（公共节点会被回收）。 */
    private interface NodeQuery {
        /** @return "地址:端口"，取不到时返回 null。 */
        String query();
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
        byte[] count = expect(link, GBoyFrames.TYPE_READY, STEP_WAIT_MS);
        int reported = GBoyFrames.intOf(count);
        if (reported > 0) {
            Log.i(TAG, "relay reports " + reported + " players");
        }
        status("已注册到中继，等待对方…");

        link.send(GBoyFrames.frame(GBoyFrames.TYPE_READY));
        // The node only pushes the peer's first key state once a second player
        // has registered, so blocking on it would make the host time out while
        // it is simply waiting for an opponent. Treat it as optional.
        try {
            expect(link, GBoyFrames.TYPE_KEYS, PEER_KEY_WAIT_MS);
        } catch (IOException e) {
            Log.i(TAG, "peer key not ready yet, continuing: " + e.getMessage());
        }
        link.send(GBoyFrames.frame(GBoyFrames.TYPE_REGISTER));
        Log.i(TAG, "cloud handshake done");
    }

    /** Registers this console at the relay. Sent exactly once per session. */
    private void sendRegister(KcpChannel link, Room room) {
        int players = Math.max(1, room.playerCount);
        link.send(GBoyFrames.registerFrame(players, room.baseStateCount));
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
        }, "lobby-signal-probe").start();
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
        while (!closed && !link.isClosed()) {
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
    private void waitForRoom(GbCloud.Session sig, Room room, String roomId, long timeoutMs) throws IOException {
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
                String incomingRoomId = object.optString("room_id", null);
                if (incomingRoomId != null && !incomingRoomId.isEmpty()) {
                    room.roomId = incomingRoomId;
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
            } else if ("send_message".equals(type)) {
                // The host advertises its relay endpoint through the broadcast
                // channel as {"gboy_node":"address:port","room":"<roomId>"}. Pull it
                // out so the joiner can connect without manual NODE2: entry.
                String message = object.optString("message", null);
                if (message != null && message.indexOf("gboy_node") >= 0) {
                    try {
                        JSONObject marker = new JSONObject(message);
                        String node = marker.optString("gboy_node", null);
                        String tagged = marker.optString("room", null);
                        if (node != null && node.indexOf(':') > 0
                                && (tagged == null || tagged.isEmpty() || tagged.equals(roomId))) {
                            int colon = node.lastIndexOf(':');
                            String address = node.substring(0, colon);
                            int port = Integer.parseInt(node.substring(colon + 1));
                            if (port > 0) {
                                room.nodeAddress = address;
                                room.nodePort = port;
                                Log.i(TAG, "joiner received relay from host: " + node);
                            }
                        }
                    } catch (Exception ignored) {
                        // not our marker; ignore
                    }
                }
            }
            if (room.nodeAddress != null && room.nodePort > 0) {
                return;
            }
        }
    }

    /**
     * Keeps the host's signalling socket alive and re-broadcasts the relay
     * endpoint to the room so a joining player can fill it in automatically.
     *
     * <p>gboy.top hands the relay node only to the room creator, so a late or
     * slow joiner would otherwise have to type {@code NODE2:address:port} by
     * hand. The host therefore advertises it over the (lobby-wide) broadcast
     * channel as a JSON marker {@code {"gboy_node":"address:port","room":id}}.
     * The joiner's {@link #waitForRoom} parses that marker and connects without
     * any manual step.</p>
     *
     * <p>The same thread also drains the websocket (answering pings), which is
     * required because the host keeps its signalling session open for the whole
     * match and the server would otherwise time it out.</p>
     */
    private void startNodeAdvertiser(final GbCloud.Session sig, final String token,
                                     final String uuid, final Room room) {
        Thread t = new Thread(() -> {
            long last = 0;
            while (!closed) {
                try {
                    // Keep the websocket alive; recv() answers server pings.
                    sig.recv(1500);
                } catch (IOException e) {
                    if (!closed) {
                        Log.i(TAG, "node advertiser recv stopped: " + e.getMessage());
                    }
                    break;
                }
                long now = System.currentTimeMillis();
                if (now - last >= 2000) {
                    last = now;
                    // 节点可能被服务器回收并更换，所以每次都读房间里的最新节点
                    if (room.nodeAddress == null || room.nodePort <= 0) {
                        continue;
                    }
                    String node = room.nodeAddress + ":" + room.nodePort;
                    try {
                        JSONObject marker = new JSONObject();
                        marker.put("gboy_node", node);
                        if (room.roomId != null && !room.roomId.isEmpty()) {
                            marker.put("room", room.roomId);
                        }
                        JSONObject msg = new JSONObject();
                        msg.put("action", "send_message");
                        msg.put("token", token);
                        msg.put("uuid", uuid);
                        msg.put("message", marker.toString());
                        sig.send(msg.toString());
                        Log.i(TAG, "advertised relay " + node + " for room " + room.roomId);
                    } catch (IOException e) {
                        if (!closed) {
                            Log.i(TAG, "node advertiser send stopped: " + e.getMessage());
                        }
                        break;
                    } catch (Exception ignored) {
                        // JSON build failure is non-fatal; retry next tick
                    }
                }
            }
        }, "lobby-node-advertiser");
        t.setDaemon(true);
        t.start();
        advertiser = t;
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
        return GbCloud.lobby(text);
    }
}
