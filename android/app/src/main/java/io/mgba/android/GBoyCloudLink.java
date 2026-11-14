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
import java.net.ServerSocket;
import java.net.Socket;
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
    /**
     * How long to knock on the UDP relay node before giving up on it. The
     * gboy.top node only answers once both players have registered, but its
     * ports have been dead server-side for a while, so after this window the
     * link falls back to the websocket tunnel and play proceeds anyway.
     */
    // 与 PC 侧同理：加入方 15~25 秒才能连上节点，12 秒窗口太短，一方先放弃
    // 就会永远退到高延迟的 WS 隧道。
    private static final long RELAY_WINDOW_MS = 15000;
    /** How long to wait for the peer's first key state before starting anyway. */
    private static final long PEER_KEY_WAIT_MS = 4000;
    private static final long KEY_INTERVAL_MS = 50;
    /** Tunnel hello markers are re-sent at this pace until the peer answers. */
    private static final long TUNNEL_HELLO_MS = 2000;
    /** 紧凑信封单条最大载荷：20 字节 → 40 hex，整条 84 字符 < 100 字符上限。 */
    private static final int TUNNEL_CHUNK_BYTES = 20;
    /** Local loopback ports for the SIO link bridge (分开控制模式). */
    private static final int SIO_PORT_BASE = 18765;
    private static final int SIO_PORT_TRIES = 8;

    /**
     * Minimal transport shared by the KCP relay and the websocket tunnel; the
     * handshake and the game loop run unchanged over either one.
     */
    interface Link {
        void send(byte[] frame);

        /** Next message, or null when nothing arrived in time. */
        byte[] recv(long timeoutMs);

        boolean isClosed();

        void close();
    }

    public interface Hooks {
        String romPath();

        /** The loaded core, for the SIO link driver (分开控制模式). */
        MgbaCore core();

        /** Local key bitmask, GBA style. */
        int localKeys();

        void onRemoteKeys(int keys);

        void onStatus(String text);

        void onConnected(boolean asHost, String note);

        /** The link is closing: stop the local mirror console and its thread. */
        void onDisconnected();

        /** TYPE_STATE blob from the peer, to be applied to the mirror console. */
        void onRemoteState(byte[] state);

        void onRemoteReset();
    }

    private final Hooks hooks;
    private final Object sendLock = new Object();
    private volatile boolean closed;
    private volatile KcpChannel channel;
    private volatile Link wsLink;
    private volatile java.net.Socket sioSock;
    private volatile GbCloud.Session session;
    /** Re-broadcasts the relay endpoint to the room so the joiner can find it. */
    private volatile Thread advertiser;
    /** 中继广告间隔。建房阶段 2 秒一次够用；进了隧道等待也不要停——加入方
     *  正是靠这条广播拿到中继地址的（停掉它就永远只能退回 100 字符的聊天
     *  隧道，实测两端 ±200ms 抖动、锁步互相 park 死）。改成 8 秒一次：
     *  既能被对方拿到，又不会被服务器判刷屏（2 秒连发 3 分钟会被 reset）。 */
    private volatile long advertiseIntervalMs = 2000;
    /** 会话信息：「重新连接中继」按钮复用它，不重建房间。 */
    private volatile String authToken;
    private volatile Room currentRoom;
    private volatile boolean hostRole;
    /** 房间信令要的游戏身份，重连中继时复用。 */
    private volatile String identity;
    /**
     * 本端隧道标记的随机身份：服务器若把 send_message 回显给发送者，
     * 靠它把自己的 hello/数据帧和对方的区分开（同一 ROM 的游戏身份相同，不能用它）。
     */
    private volatile String wsNonce;
    /** 对方已在隧道上打招呼；KCP 等待窗口里见到就不再等窗口超时。 */
    private volatile boolean tunnelPeerSeen;
    private final GBoyFrames.Reader reader = new GBoyFrames.Reader();
    /** Last key state received from the peer; only transitions are logged. */
    private int lastRxKeys = Integer.MIN_VALUE;
    private Thread worker;
    /** Ported GBoy session: 12 Hz key cadence, slot dispatch, state and reset. */
    private volatile GBoyLinkSession linkSession;
    /** Link currently served, used by the session's transport. */
    private volatile Link servingLink;
    /** When true the emulation loop drives key sends instead of the 50 ms timer. */
    private volatile boolean frameDriven;
    /**
     * Official layout: local multi-console link, network carries only keys.
     * Mutually exclusive with the legacy SIO bridge, which also binds the
     * visible core's link handle - running both would close the other one.
     */
    private volatile boolean officialMode;

    public void setOfficialMode(boolean on) {
        officialMode = on;
    }

    public boolean officialMode() {
        return officialMode;
    }
    private final GBoyLinkSession.Events sessionEvents = new GBoyLinkSession.Events() {
        @Override
        public void onReset() {
            Log.i(TAG, "rx TYPE_RESET (session)");
        }

        @Override
        public void onState(byte[] state) {
            Log.i(TAG, "rx TYPE_STATE " + state.length + " bytes");
            hooks.onRemoteState(state);
        }

        @Override
        public void onReady() {
            hooks.onStatus("对端就绪");
        }

        @Override
        public void onStatus(String text) {
            Log.i(TAG, text);
        }
    };

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
        linkSession = null;
        frameDriven = false;
        servingLink = null;
        // Stop the mirror core before the visible core's link is closed, so
        // its SIO wait cannot outlive the session.
        hooks.onDisconnected();
        KcpChannel current = channel;
        channel = null;
        if (current != null) {
            current.close();
        }
        Link tunnel = wsLink;
        wsLink = null;
        if (tunnel != null) {
            tunnel.close();
        }
        java.net.Socket sio = sioSock;
        sioSock = null;
        if (sio != null) {
            try {
                sio.close();
            } catch (IOException ignored) {
            }
        }
        MgbaCore core = hooks.core();
        if (core != null) {
            core.linkClose();
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
        identity = uuid;
        wsNonce = Long.toHexString(java.util.UUID.randomUUID().getMostSignificantBits());
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
                // 拿不到中继地址不再失败：数据阶段会自动走服务器隧道。
                status("未获取到对方的中继地址，将使用服务器隧道模式");
            }
        }

        authToken = token;
        currentRoom = room;
        hostRole = asHost;
        connectRelay(sig, token, uuid, room, asHost);
    }

    /**
     * 连上数据通道并进入对战循环。房间与信令已经就绪，这里只负责传输，
     * 「重新连接中继」按钮也复用同一段逻辑。
     *
     * 先给 UDP 中继节点一个短窗口；它不回应（服务端节点死了是常态）就
     * 自动切到 websocket 服务器隧道——双方都连着信令服务器，跨网也能通。
     */
    private void connectRelay(final GbCloud.Session sig, final String token, final String uuid,
                              final Room room, final boolean asHost) throws IOException {
        if (sig.isClosed()) {
            // 会话在等待期间被服务器掐掉（游戏进行中节点回收也会走到这里）：
            // 重开一条会话并重新绑定游戏身份，房间还在服务器上。
            status("信令连接已断开，正在重新连接…");
            GbCloud.Session fresh = new GbCloud.Session();
            session = fresh;
            try {
                send(fresh, sendMessage(token, uuid, "go"), 1200);
            } catch (IOException e) {
                throw e;
            } catch (Exception e) {
                throw new IOException(String.valueOf(e.getMessage()));
            }
        }
        status((asHost ? "房间已创建，房号 " : "已加入房间 ")
                + (room.roomId == null ? "" : room.roomId)
                + (room.nodeAddress == null ? "" : "\n中继 " + room.nodeAddress + ":" + room.nodePort)
                + "\n正在连接数据通道，等待对方…");
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
        KcpChannel link = null;
        // 中继只试一次。以前"握不上就解散房间重建拿新节点"的玩法有两个致命副作用：
        //   1) 房主重建房间会把已经在房间里等着的对方踢出去（服务器直接解散旧房间）；
        //   2) 房号变了，两端的隧道 hello 打的是各自的房号，配对因此永远对不上。
        // 公共节点时好时坏是常态，拿不到节点或节点不应答就直接走服务器隧道——
        // 隧道不依赖节点，跨网一定能通，只是延迟比中继高一点。
        if (room.nodeAddress != null && room.nodePort > 0) {
            final boolean creator = asHost;
            link = startRelayLink(room.nodeAddress, room.nodePort, room, uuid,
                    new NodeQuery() {
                        @Override
                        public String query() {
                            return currentNode(sig, token, room, creator);
                        }
                    }, RELAY_WINDOW_MS);
        } else {
            status("没有可用的中继地址，直接使用服务器隧道模式");
        }
        if (closed) {
            if (link != null) {
                link.close();
            }
            return;
        }
        if (link == null) {
            runTunnel(sig, token, uuid, room, asHost);
            return;
        }
        if (officialMode) {
            // No SIO bridge: the second console lives on this device and only
            // key masks travel over the relay. The session must be created
            // before the (asynchronous) onConnected callback starts the cores.
            ensureSession(link);
            status("云端联机已连接，你是 " + (asHost ? "1P" : "2P")
                    + "（本机多核，网络仅传按键）\n中继 "
                    + room.nodeAddress + ":" + room.nodePort);
            hooks.onConnected(asHost, null);
            serve(link);
            return;
        }
        // 官方 KCP 中继活着：SIO 分开控制模式直接把联机线字节过中继
        // （netLink 包封在 type-6 帧里），RTT 比 WS 隧道低 3-7 倍。
        Socket local = attachDriverLoopback(asHost);
        if (closed) {
            link.close();
            return;
        }
        sioSock = local;
        String text = asHost ? "云端联机已连接，你是 1P" : "云端联机已连接，你是 2P";
        status("SIO 链路已建立（官方中继，分开控制）\n"
                + "各自操作各自的画面，游戏内联机（交换/对战）走联机线\n"
                + "中继 " + room.nodeAddress + ":" + room.nodePort
                + "\n" + text);
        hooks.onConnected(asHost, null);
        startSioRelayBridge(link, local, sig, token, room, asHost);
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
        final String uuid = identity;
        if (sig == null || token == null || room == null || uuid == null) {
            status("还没有房间，请先点「云端创建」或「云端加入」");
            return;
        }
        // 关掉旧通道，让旧的 serve 循环退出；新连接要用全新的会话状态，
        // 否则帧号、按键队列和 slot 掩码会从上一条链路继承下来。
        linkSession = null;
        frameDriven = false;
        KcpChannel old = channel;
        channel = null;
        if (old != null) {
            old.close();
        }
        Link oldTunnel = wsLink;
        wsLink = null;
        if (oldTunnel != null) {
            oldTunnel.close();
        }
        status("正在重新连接数据通道…");
        new Thread(() -> {
            try {
                connectRelay(sig, token, uuid, room, asHost);
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
        waitForRoom(sig, room, null, ROOM_WAIT_MS, true);
        if (room.nodeAddress == null || room.nodePort <= 0) {
            // 节点拿不到不再中断建房：公共节点池经常不回包，隧道模式不需要节点。
            // 以前这里直接抛异常，一次没拿到就得从头再建一次房（连房号都变了）。
            status("未获取到中继节点，改用服务器隧道模式");
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
                // 所以这里一直等（不设隧道窗口），等对方进来后自然会连上。
                link = self.startRelayLink(room.nodeAddress, room.nodePort, room,
                        uuid, null, RELAY_WAIT_MS);
                if (link == null) {
                    self.status("❌ 联机自检失败：中继没有回应"
                            + "\n常见原因：网络不通 / VPN 或加速器拦截 UDP / 账号问题。");
                    return;
                }
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
            link = startRelayLink(host, port, room, null, null, RELAY_WAIT_MS);
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
     * - The node only answers once the second player has registered, so the
     *   first handshake waits for the opponent. {@code windowMs} bounds how
     *   long we knock with no answer at all: past it the caller falls back to
     *   the websocket tunnel (returns {@code null}). Once the node did answer
     *   (HK), we stay on it and keep waiting as before.
     * - A node can be recycled by the server at any time, so every 30 seconds
     *   we ask the room server for the current node and switch over when it
     *   changed. While waiting we also watch the signalling stream for the
     *   peer's tunnel hello - seeing it means the peer has given up on the
     *   node, so there is no point in finishing the window.
     *
     * @return the connected link, or {@code null} when the node never answered
     *         and the caller should use the websocket tunnel instead.
     */
    private KcpChannel startRelayLink(String host, int port, Room room, String uuid,
                                      NodeQuery query, long windowMs) throws IOException {
        long deadline = System.currentTimeMillis() + RELAY_WAIT_MS;
        long windowEnd = System.currentTimeMillis() + windowMs;
        long started = System.currentTimeMillis();
        long nextQuery = 0;
        long lastNotice = 0;
        long lastHello = 0;
        long firstTunnelPeer = 0;
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
                        // 短探测：节点回了 HK 但对方还没注册时，20 秒的阻塞会让本端
                        // 完全听不到信令——对方可能已经在隧道上打招呼，本端却要等到
                        // 5 分钟超时才动。这里几秒一探，然后照常打招呼/看对方动静。
                        handshake(link, room, 4000);
                        return link;
                    } catch (IOException e) {
                        // 已经连上中继，但对方还没注册：保留同一个会话继续等，
                        // 并落到下面继续打招呼、检查窗口
                        Log.i(TAG, "relay handshake pending: " + e.getMessage());
                    }
                }
                // 窗口内顺带在信令上打招呼并听对方的动静；
                // 对方已经在隧道上等我们了就不必等窗口超时
                long now = System.currentTimeMillis();
                if (now - lastHello >= TUNNEL_HELLO_MS) {
                    lastHello = now;
                    sendWsMarker(sig(), token(), uuid, "hello", room.roomId);
                }
                drainSignaling(120);
                if (tunnelPeerSeen) {
                    // 对端在隧道上发过 hello，只说明它的 hello 先到了，不代表它
                    // 不肯连中继：房主每 2 秒广播一次 node，加入方拿到广播后会
                    // 自己连上来。原来这里一见 hello 就关中继，两端互相礼让，
                    // 永远停在高延迟的 WS 隧道上（实测 95~215ms，节点只有 30~38ms）。
                    // 改成宽限窗口：窗口内对端连上中继就用中继，否则再退回隧道。
                    long now2 = System.currentTimeMillis();
                    if (firstTunnelPeer == 0) {
                        firstTunnelPeer = now2;
                        Log.i(TAG, "relay: peer hello on tunnel, grace window");
                    } else if (now2 - firstTunnelPeer > 8000) {
                        status("对方已在服务器隧道上等待，放弃直连中继");
                        link.close();
                        channel = null;
                        return null;
                    }
                }
                if (!closed && now >= windowEnd) {
                    status("中继节点没有回应，自动切换到服务器隧道模式");
                    link.close();
                    channel = null;
                    return null;
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
                            + "稍后将自动改用服务器隧道（跨网可联）");
                }
                sleepQuietly(1000);
            } catch (IOException e) {
                Log.i(TAG, "relay attempt failed: " + e.getMessage());
                if (link != null) {
                    link.close();
                    link = null;
                    channel = null;
                }
                if (System.currentTimeMillis() >= windowEnd) {
                    return null;
                }
            }
        }
        return null;
    }

    /** 当前信令会话；KCP 等待期间发隧道标记用。 */
    private GbCloud.Session sig() {
        return session;
    }

    private String token() {
        return authToken;
    }

    /**
     * 在信令广播上发一个隧道标记（hello/accept），数据帧由 {@link WsLink} 发。
     * 服务器挂了也不抛：KCP 尝试不该被信令问题打断，隧道阶段会显式处理。
     */
    private void sendWsMarker(GbCloud.Session sig, String token, String uuid,
                              String kind, String roomId) {
        try {
            JSONObject marker = new JSONObject();
            marker.put("gboy_ws", kind);
            if (roomId != null && !roomId.isEmpty()) {
                marker.put("room", roomId);
            }
            marker.put("from", wsNonce == null ? "" : wsNonce);
            // 能力协商：带 "c":1 表示"新版——能解十六进制、也认短键名信封"。
            // 不能再带 "e":"h"：13:41 那版看到对端 e:h 会把自己改发成超长 hex
            // 长信封（>100 字符），被服务器整条吞掉；新版靠 c:1 识别彼此，
            // 老版本一律回落 base64 长信封。
            marker.put("c", 1);
            sig.send(sendMessage(token, uuid, marker.toString()));
        } catch (Exception e) {
            Log.i(TAG, "ws marker send failed: " + e.getMessage());
        }
    }

    /**
     * 排空信令推送一小段（顺带回答服务器 ping）。看到对方的隧道 hello/accept
     * 就记进 {@link #tunnelPeerSeen}。
     */
    private void drainSignaling(long ms) {
        long end = System.currentTimeMillis() + ms;
        while (System.currentTimeMillis() < end) {
            String text;
            try {
                GbCloud.Session sig = session;
                if (sig == null) {
                    return;
                }
                text = sig.recv(Math.min(120, Math.max(20, end - System.currentTimeMillis())));
            } catch (IOException e) {
                return; // 会话断了；隧道阶段会重开
            }
            if (text == null) {
                return;
            }
            if (isTunnelMarker(text)) {
                tunnelPeerSeen = true;
            }
        }
    }

    /** 该推送是不是对方的隧道标记（hello/accept/数据帧都算；回显的自己不算）。 */
    private boolean isTunnelMarker(String text) {
        JSONObject object = GbCloud.lastJsonObjectOrNull(text);
        if (object == null || !"send_message".equals(object.optString("type", ""))) {
            return false;
        }
        String message = object.optString("message", null);
        // 新版数据帧是短键名信封（"w":"f"），没有 gboy_ws 键
        if (message == null || (message.indexOf("gboy_ws") < 0 && !message.contains("\"w\":\"f\""))) {
            return false;
        }
        JSONObject marker = GbCloud.lastJsonObjectOrNull(message);
        if (marker == null) {
            return false;
        }
        String from = marker.optString("from", "");
        if (from.isEmpty()) {
            from = marker.optString("o", "");
        }
        return from.isEmpty() || from.equals(wsNonce == null ? "" : wsNonce) == false;
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

    // ---- websocket tunnel ----

    /**
     * UDP 中继连不上时的数据通道：直接复用与信令服务器的 websocket 会话。
     * WS 是出站 TCP，不受 NAT/UDP 限制，跨网天然可用；代价是延迟略高。
     *
     * <p>配对时序：双方互发 hello（room 标记过滤），见到对方即回 accept。
     * 配对后进入<b>SIO 联机线模式（分开控制）</b>：按键不再通过网络合并，
     * 每台设备只控制自己的画面；两台设备的游戏通过 native 联机线驱动
     * （{@link MgbaCore#linkHost}/{@link MgbaCore#linkJoin}，本机 TCP 环回 +
     * 这条隧道透传字节）互联，游戏内交换/对战走真正的 SIO。</p>
     */
    private void runTunnel(GbCloud.Session sig, String token, String uuid, Room room,
                           boolean asHost) throws IOException {
        String tag = room.roomId == null ? "" : room.roomId;
        // 中继广告不能停：加入方靠这条广播拿中继地址，停掉就只能退回聊天
        // 隧道（单条 ≤100 字符，按键只能 20 字节切片发，延迟抖动 ±200ms，
        // 进程内锁步会互相 park 死）。这里只降频，避免被服务器判刷屏。
        advertiseIntervalMs = 8000;
        status("正在通过服务器隧道等待对方进入（跨网可联）…");
        WsLink link = new WsLink(sig, token, uuid, tag);
        wsLink = link;
        long deadline = System.currentTimeMillis() + RELAY_WAIT_MS;
        long lastNotice = 0;
        while (!closed && !link.isClosed() && !link.peerSeen()
                && System.currentTimeMillis() < deadline) {
            link.recv(1000);
            long now = System.currentTimeMillis();
            if (!link.peerSeen() && now - lastNotice >= 10000) {
                lastNotice = now;
                status("隧道已就绪，等待对方进入（房号 " + tag + "）…");
            }
        }
        if (closed) {
            return;
        }
        if (!link.peerSeen()) {
            throw new IOException(link.errorMessage() == null
                    ? "隧道等待对方超时" : link.errorMessage());
        }
        if (officialMode) {
            ensureSession(link);
            status("云端联机已连接，你是 " + (asHost ? "1P" : "2P")
                    + "（本机多核，服务器隧道）");
            hooks.onConnected(asHost, null);
            serve(link);
            return;
        }
        GBoyDirectLink direct = tryDirectLink(link, room);
        startSioBridge(direct != null ? direct : link, link, asHost);
        if (direct != null) {
            direct.close();
        }
    }

    /**
     * 直连（P2P）协商：拿 UDP 打洞换掉服务器中转那一跳。协议与 PC 侧
     * {@code DirectLink.cpp} 完全一致，安卓↔PC 也能互连。
     *
     * <p>标记都走隧道那条 send_message：{@code p}=我的候选地址，{@code s}=我
     * 已打通请切过来，{@code s2}=我同意，{@code s3}=放弃。协商是对称的——
     * 谁先打通谁先发 {@code s}，两边都表态才切，单条消息丢了下一轮能补上。</p>
     *
     * <p>返回 {@code null} 表示继续用隧道（对称 NAT、企业网、对端是老版本）。</p>
     */
    private GBoyDirectLink tryDirectLink(WsLink tunnel, Room room) {
        if (System.getenv("MGBAX_NO_DIRECT") != null) {
            return null;
        }
        GBoyDirectLink direct = new GBoyDirectLink();
        if (!direct.bind()) {
            return null;
        }
        java.util.List<String> mine = direct.candidates();
        Log.i(TAG, "[direct] me=" + wsNonce + " 候选 " + mine + " / 本地端口 " + direct.localPort());
        status("正在协商直连加速（P2P，避开服务器中转）…");

        long started = System.currentTimeMillis();
        long deadline = started + 9000;
        long lastAnnounce = 0;
        long lastSwitch = 0;
        long connectedAt = 0;
        int announceCount = 0;
        boolean peerCandidates = false;
        boolean peerWants = false;
        boolean peerAgreed = false;
        boolean switchSent = false;
        boolean approved = false;
        boolean aborted = false;
        try {
            while (!closed && System.currentTimeMillis() < deadline) {
                long now = System.currentTimeMillis();
                tunnel.recv(20);
                JSONObject marker;
                while ((marker = tunnel.pollControl()) != null) {
                    String kind = marker.optString("w", "");
                    if ("p".equals(kind)) {
                        if (!peerCandidates) {
                            String raw = marker.optString("a", "");
                            java.util.List<String> peer = new java.util.ArrayList<>();
                            for (String part : raw.split(",")) {
                                if (!part.trim().isEmpty()) {
                                    peer.add(part.trim());
                                }
                            }
                            if (!peer.isEmpty()) {
                                Log.i(TAG, "[direct] me=" + wsNonce + " 对端候选 " + peer);
                                direct.setPeerCandidates(peer);
                                direct.startPunching();
                                peerCandidates = true;
                            }
                        }
                    } else if ("s".equals(kind)) {
                        peerWants = true;
                        if (direct.isConnected()) {
                            sendDirectMarker(tunnel, room, "s2", "");
                        }
                    } else if ("s2".equals(kind)) {
                        peerAgreed = true;
                    } else if ("s3".equals(kind)) {
                        aborted = true;
                    }
                }
                if (aborted) {
                    break;
                }
                if (!peerCandidates && now - started > 6000) {
                    // 对端是老版本，不认识直连协商：不要拖住开局
                    aborted = true;
                    break;
                }
                // 候选公告一直发到决定切换为止：单条 send_message 可能因为对端
                // 当时正在做 STUN（几百毫秒不读 socket）而错过，只发一次就会
                // 双方僵住。每轮轮换候选顺序，内容不同，不会被当重复消息丢掉。
                if (now - started <= 4000 && now - lastAnnounce >= 600) {
                    lastAnnounce = now;
                    java.util.List<String> kept = new java.util.ArrayList<>(
                            mine.subList(0, Math.min(3, mine.size())));
                    if (kept.size() > 1) {
                        int rot = announceCount++ % kept.size();
                        for (int i = 0; i < rot; i++) {
                            kept.add(kept.remove(0));
                        }
                    }
                    StringBuilder joined = new StringBuilder();
                    for (String part : kept) {
                        if (joined.length() > 0) {
                            joined.append(',');
                        }
                        joined.append(part);
                    }
                    sendDirectMarker(tunnel, room, "p", joined.toString());
                }
                if (direct.isConnected()) {
                    if (connectedAt == 0) {
                        connectedAt = now;
                    }
                    // 双方都连通、且至少有一方表态过才真切换
                    if ((peerWants || peerAgreed) && now - connectedAt >= 150) {
                        approved = true;
                    }
                    // RTT 反而更差就留在隧道（例如一端挂着绕远的 VPN）
                    boolean better = direct.rttMs() <= 0 || direct.rttMs() < 150;
                    if (!approved && better && now - lastSwitch >= 500) {
                        lastSwitch = now;
                        switchSent = true;
                        sendDirectMarker(tunnel, room, "s", "");
                    }
                }
                if (approved) {
                    break;
                }
                direct.pump(peerCandidates ? 20 : 5);
            }
        } catch (Exception e) {
            Log.i(TAG, "[direct] 协商异常：" + e.getMessage());
        }
        if (!approved) {
            Log.i(TAG, "[direct] me=" + wsNonce + " 放弃直连：peerCandidates=" + peerCandidates
                    + " connected=" + direct.isConnected() + " switchSent=" + switchSent
                    + " peerWants=" + peerWants + " peerAgreed=" + peerAgreed
                    + " aborted=" + aborted);
            if (switchSent) {
                sendDirectMarker(tunnel, room, "s3", "");
            }
            direct.close();
            return null;
        }
        status("直连加速已启用（P2P " + direct.peerText() + "，RTT " + direct.rttMs() + " ms）\n"
                + "数据不再经过服务器中转，延迟比隧道低一个数量级");
        return direct;
    }

    /** 发一条直连协商标记；超过 100 字符先把房间标记去掉（服务器有长度上限）。 */
    private void sendDirectMarker(WsLink tunnel, Room room, String kind, String payload) {
        try {
            JSONObject marker = new JSONObject();
            marker.put("w", kind);
            marker.put("o", wsNonce == null ? "" : wsNonce);
            if (room != null && room.roomId != null && !room.roomId.isEmpty()) {
                marker.put("r", room.roomId);
            }
            if (payload != null && !payload.isEmpty()) {
                marker.put("a", payload);
            }
            if (marker.toString().length() > 94) {
                marker.remove("r");
            }
            tunnel.sendMarker(marker);
        } catch (Exception e) {
            Log.i(TAG, "direct marker failed: " + e.getMessage());
        }
    }

    /**
     * 分开控制的 SIO 数据阶段：把 native 联机线驱动（NetLink）的字节流原样
     * 搬过隧道。本机侧用 127.0.0.1 环回与驱动对接，native 完全不用改：
     *
     * <pre>
     *   1P: core.linkHost(P)        native 在本机监听 → app 连上去当客户端
     *   2P: app 监听 127.0.0.1:P    core.linkJoin("127.0.0.1", P) 连出来
     *   app 桥: 本地 socket 字节 ↔ WsLink('f' 标记 base64 块) ↔ 对端
     * </pre>
     *
     * <p>桥不解析内容——两端 NetLink 自己握手、自己控节奏；隧道有序可靠，
     * 固定 20 字节的 Packet 流原样到达。本机按键只进本机控制台，对方的
     * 输入经由 SIO 链路被对方的游戏看见（游戏的联机语义，不再是按键镜像）。</p>
     */
    /** 本机回环：把 native 联机线驱动挂到 127.0.0.1 的 TCP 对上，返回驱动侧套接字。 */
    private Socket attachDriverLoopback(boolean asHost) throws IOException {
        MgbaCore core = hooks.core();
        if (core == null) {
            throw new IOException("模拟核心未就绪");
        }
        Socket local = null;
        ServerSocket server = null;
        int port = 0;
        try {
            if (asHost) {
                for (int t = 0; t < SIO_PORT_TRIES && local == null; t++) {
                    port = SIO_PORT_BASE + t;
                    if (!core.linkHost(port)) {
                        continue;
                    }
                    try {
                        local = new Socket();
                        local.connect(new java.net.InetSocketAddress("127.0.0.1", port), 3000);
                    } catch (IOException e) {
                        core.linkClose();
                        local = null;
                    }
                }
            } else {
                for (int t = 0; t < SIO_PORT_TRIES; t++) {
                    port = SIO_PORT_BASE + t;
                    try {
                        server = new ServerSocket();
                        server.bind(new java.net.InetSocketAddress(
                                InetAddress.getByName("127.0.0.1"), port));
                        break;
                    } catch (IOException e) {
                        server = null;
                    }
                }
                if (server == null) {
                    throw new IOException("本机联机线端口被占用");
                }
                if (!core.linkJoin("127.0.0.1", port)) {
                    throw new IOException("无法启动本机联机线");
                }
                server.setSoTimeout(10000);
                local = server.accept(); // native linkJoin 会连进来
            }
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException ignored) {
                }
            }
        }
        if (local == null) {
            throw new IOException("本机联机线建立失败");
        }
        local.setTcpNoDelay(true);
        return local;
    }

    private void startSioBridge(Link link, WsLink tunnel, boolean asHost) throws IOException {
        Socket local = attachDriverLoopback(asHost);
        sioSock = local;
        status("SIO 链路已建立（分开控制）\n"
                + "各自操作各自的画面，对方按键不再进入你的游戏\n"
                + "游戏内联机（交换/对战）走联机线\n"
                + "云端联机已连接，你是 " + (asHost ? "1P" : "2P"));
        hooks.onConnected(asHost, null);
        final Socket sock = local;
        // 直连是"锦上添花"层：它断了不该让整局结束。active 指向当前真正在
        // 用的通道，直连被看门狗关掉时滑回服务器隧道，本地驱动那个 socket
        // 一直开着，对游戏来说只是变慢，不是断线。
        final java.util.concurrent.atomic.AtomicReference<Link> active =
                new java.util.concurrent.atomic.AtomicReference<>(link);
        Thread out = new Thread(() -> {
            byte[] buf = new byte[2048];
            try {
                java.io.InputStream in = sock.getInputStream();
                int n;
                while (!closed && (n = in.read(buf)) > 0) {
                    byte[] chunk = new byte[n];
                    System.arraycopy(buf, 0, chunk, 0, n);
                    active.get().send(chunk);
                }
            } catch (Exception ignored) {
                // 断线由守望线程统一收尾
            }
            closeSio();
        }, "sio-bridge-out");
        Thread in = new Thread(() -> {
            try {
                java.io.OutputStream os = sock.getOutputStream();
                while (!closed) {
                    try {
                        byte[] pkt = active.get().recv(100);
                        if (pkt != null && pkt.length > 0) {
                            os.write(pkt);
                            os.flush();
                        }
                    } catch (Exception e) {
                        // 直连 recv 的一次瞬时异常绝不能终结整局：以前这里
                        // 直接 closeSio()，会把本地驱动 socket 和隧道一起关掉，
                        // 守望线程随即判「联机线连接已断开」，而此时 PC 端往往
                        // 只是刚回落到隧道、还好好地在发帧。吞掉并短暂重试，
                        // 由守望线程统一做直连→隧道切换。
                        Log.i(TAG, "[sio-bridge] recv transient: " + e);
                        sleepQuietly(50);
                    }
                }
            } catch (Exception ignored) {
                // 只有本地 socket 本身不可用了才走到这里
            }
        }, "sio-bridge-in");
        out.setDaemon(true);
        in.setDaemon(true);
        out.start();
        in.start();
        // 走直连时隧道本身没人读，定期排空一下，别让服务器认为我们掉线
        // （大厅会踢掉不响应心跳的连接，而直连断开时要靠隧道继续玩）。
        if (tunnel != null) {
            Thread keepalive = new Thread(() -> {
                while (!closed) {
                    sleepQuietly(500);
                    if (closed) {
                        return;
                    }
                    if (active.get() != tunnel) {
                        try {
                            tunnel.recv(0);
                        } catch (Exception ignored) {
                            return;
                        }
                    }
                }
            }, "sio-tunnel-keepalive");
            keepalive.setDaemon(true);
            keepalive.start();
        }
        // 守望：任何一侧断开都收尾；直连先死就先回落隧道
        while (!closed && !sock.isClosed()) {
            if (active.get().isClosed()) {
                if (active.get() != tunnel && tunnel != null && !tunnel.isClosed()) {
                    Log.i(TAG, "[sio-bridge] 直连已断开，回落到服务器隧道");
                    status("直连已断开，已自动回落到服务器隧道\n联机不会中断，只是延迟会变高");
                    active.set(tunnel);
                    continue;
                }
                break;
            }
            sleepQuietly(1000);
        }
        if (!closed) {
            fail("联机线连接已断开");
        }
    }

    /**
     * SIO 分开控制模式走**官方 KCP 中继**时的桥：本地驱动的 netLink 包
     * （20 字节）逐个封进 type-6（STATE）帧经中继转发给对方——官方中继
     * 对 type 1..6 是透明转发，两条客户端之间它就是一条字节管道。
     * 相比 WS 隧道，官方中继（阿里云上海）的 RTT 低 3-7 倍。
     *
     * <p>房主侧顺带保留节点广播（新加入方要靠它拿中继地址），并监听对方的
     * 隧道 hello——对方的中继不可达时会切到 WS 隧道，本端跟随切换。</p>
     */
    private void startSioRelayBridge(final KcpChannel link, final Socket local,
                                     final GbCloud.Session sig, final String token,
                                     final Room room, final boolean asHost) {
        final GBoyFrames.Reader relayReader = new GBoyFrames.Reader();
        Thread out = new Thread(() -> {
            byte[] buf = new byte[2048];
            try {
                java.io.InputStream in = local.getInputStream();
                int n;
                while (!closed && (n = in.read(buf)) > 0) {
                    byte[] packet = new byte[n];
                    System.arraycopy(buf, 0, packet, 0, n);
                    link.send(GBoyFrames.frame(GBoyFrames.TYPE_STATE, packet));
                }
            } catch (Exception ignored) {
                // 断线由守望线程统一收尾
            }
            closeSio();
        }, "sio-relay-out");
        Thread in = new Thread(() -> {
            try {
                java.io.OutputStream os = local.getOutputStream();
                while (!closed) {
                    byte[] message = link.recv(200);
                    if (message == null) {
                        continue;
                    }
                    relayReader.append(message, message.length);
                    byte[] body;
                    while ((body = relayReader.next()) != null) {
                        if (GBoyFrames.typeOf(body) != GBoyFrames.TYPE_STATE) {
                            continue; // 中继的握手残留/心跳推送：忽略
                        }
                        byte[] packet = GBoyFrames.payloadOf(body);
                        if (packet.length > 0) {
                            os.write(packet);
                            os.flush();
                        }
                    }
                }
            } catch (Exception ignored) {
                // 同上
            }
            closeSio();
        }, "sio-relay-in");
        out.setDaemon(true);
        in.setDaemon(true);
        out.start();
        in.start();
        // 守望：对方的隧道 hello（切隧道）、断线。房主的节点广播由
        // startNodeAdvertiser 线程负责，这里只排空信令。
        long lastDrain = 0;
        while (!closed && !link.isClosed() && !local.isClosed()) {
            sleepQuietly(200);
            long now = System.currentTimeMillis();
            if (now - lastDrain >= 400) {
                lastDrain = now;
                drainSignaling(30);
                if (tunnelPeerSeen) {
                    // 对方的中继不可达，已切到 WS 隧道：本端跟随切换
                    status("对方中继不可达，切换到服务器隧道模式…");
                    closeSio();
                    link.close();
                    try {
                        runTunnel(sig, token, identity, room, asHost);
                    } catch (IOException e) {
                        if (!closed) {
                            fail(message(e));
                        }
                    }
                    return;
                }
            }
        }
        if (!closed) {
            fail("联机线连接已断开");
        }
    }

    /** 断开 SIO 侧：关本地 socket 与隧道，守望线程随后收尾。 */
    private void closeSio() {
        Socket s = sioSock;
        if (s != null) {
            try {
                s.close();
            } catch (IOException ignored) {
            }
        }
        Link t = wsLink;
        if (t != null) {
            t.close();
        }
    }

    /**
     * Tunnel transport over the room signalling websocket: every GBoy frame
     * travels as a base64 JSON marker in a {@code send_message} broadcast, the
     * same channel that already carries the relay advertisement. TCP ordered
     * and reliable, so no acks or retransmits are needed; the shared
     * {@link #reader} turns messages back into frames for {@link #expect} and
     * {@link #serve}.
     *
     * <p>All reads happen on the worker thread (the advertiser never touches
     * the socket), so the session stays single-consumer.</p>
     */
    /** 隧道载荷编码：只用 [0-9a-f]，绕开大厅的中文关键词过滤（见 WsLink.send）。 */
    private static String toHex(byte[] data) {
        final char[] digits = "0123456789abcdef".toCharArray();
        char[] out = new char[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            int v = data[i] & 0xFF;
            out[i * 2] = digits[v >>> 4];
            out[i * 2 + 1] = digits[v & 0x0F];
        }
        return new String(out);
    }

    /** 解码隧道载荷：新版十六进制、旧版 base64，两种都认，避免一边升级就断线。 */
    private static byte[] fromTunnelPayload(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }
        boolean hex = (text.length() % 2) == 0;
        for (int i = 0; i < text.length() && hex; i++) {
            char c = text.charAt(i);
            boolean ok = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
            if (!ok) {
                hex = false;
            }
        }
        if (hex) {
            byte[] out = new byte[text.length() / 2];
            for (int i = 0; i < out.length; i++) {
                out[i] = (byte) Integer.parseInt(text.substring(i * 2, i * 2 + 2), 16);
            }
            return out;
        }
        return android.util.Base64.decode(text, android.util.Base64.NO_WRAP);
    }

    private final class WsLink implements Link {
        private final GbCloud.Session sig;
        private final String token;
        private final String uuid;
        private final String roomTag;
        /**
         * Decoded frames waiting to be handed out. Own queue on purpose: the
         * shared {@link #reader} belongs to the serve/expect layer, which
         * appends whatever recv() returns - pre-appending here would double
         * every frame.
         *
         * 用并发队列：active 从直连切回隧道后，sio-bridge-in 线程与
         * sio-tunnel-keepalive 线程会并发调本对象的 recv()，两条线程同时
         * poll/demux 同一个队列会在 ArrayDeque 上触发 CME。
         */
        private final java.util.concurrent.ConcurrentLinkedQueue<byte[]> inbox =
                new java.util.concurrent.ConcurrentLinkedQueue<>();
        /**
         * 数据帧之外的控制标记（直连协商的 p/s/s2/s3）。单独排队，等
         * {@link #pollControl()} 取——它们不是联机线字节，混进 inbox 会让
         * 游戏收到垃圾。
         */
        private final java.util.concurrent.ConcurrentLinkedQueue<JSONObject> control =
                new java.util.concurrent.ConcurrentLinkedQueue<>();
        /**
         * 串行化 WebSocket 读取：同一时刻只允许一个线程调 sig.recv()，否则
         * 两条线程抢同一个底层连接会互相打乱帧流。
         */
        private final Object recvLock = new Object();
        private volatile boolean closed;
        private volatile boolean peerSeen;
        private volatile String error;
        /** 对端也是新版（hello/accept 里带 "c":1）：能解十六进制、认短键名信封。 */
        private volatile boolean peerCompact;
        /** 服务器拒收我们推流的次数（关键词过滤/限流），连挂三帧就收尾。 */
        private int refused;
        private long lastHello;
        private long lastAccept;
        /** 最近一次隧道帧发送时刻（毫秒），用于判定失败应答是否属于隧道帧。 */
        private long lastFrameSend;

        WsLink(GbCloud.Session sig, String token, String uuid, String roomTag) {
            this.sig = sig;
            this.token = token;
            this.uuid = uuid;
            this.roomTag = roomTag == null ? "" : roomTag;
        }

        boolean peerSeen() {
            return peerSeen;
        }

        String errorMessage() {
            return error;
        }

        /** 直接推一条自定义标记（直连协商用），走同一个 send_message 信道。 */
        void sendMarker(JSONObject marker) {
            if (closed) {
                return;
            }
            try {
                lastFrameSend = System.currentTimeMillis();
                sig.send(sendMessage(token, uuid, marker.toString()));
            } catch (Exception e) {
                Log.i(TAG, "marker send failed: " + e.getMessage());
            }
        }

        /** 取下一条控制标记，没有就返回 null。 */
        JSONObject pollControl() {
            return control.poll();
        }

        @Override
        public void send(byte[] frame) {
            if (closed) {
                return;
            }
            lastFrameSend = System.currentTimeMillis();
            // 两层服务器限制，信封必须同时绕开：
            // 1) 关键词过滤（"请勿发送违规内容。"）：随机 base64 迟早拼出 "sb"/"ass"
            //    片段，那一帧被吞、两端错位，游戏报「连接发生了错误」。十六进制只含
            //    [0-9a-f]，不可能命中含 s/b 等字母的词。
            // 2) 长度限制（"聊天内容超过100字符。"）：hex 是 40 字符，套长信封
            //    （gboy_ws/from/room 全拼出来）超过 100 字符，服务器整条拒收——
            //    13:41 那版就是这么全军覆没的。所以 hex 必须走短键名信封。
            // 短信封只在双方都是新版时使用（hello/accept 里的 "c":1 协商）：老版本
            // 只认长键名。老版本在场时退回 base64 长信封——能通，但保留关键词风险
            //（与老版本对老版本一致），这是唯一能让新旧互通的格式。
            try {
                JSONObject marker = new JSONObject();
                if (peerCompact) {
                    marker.put("w", "f");
                    if (!roomTag.isEmpty()) {
                        marker.put("r", roomTag);
                    }
                    marker.put("o", wsNonce == null ? "" : wsNonce);
                    // SIO 层可能一次吐出多帧拼在一起的载荷（实测两帧 40 字节 →
                    // 80 个 hex 字符 → 整条 124 字符被服务器拒收）。信道有序可靠，
                    // 按 20 字节切片分条发送，对端把字节按到达顺序喂回流式拆包器
                    // 即可无损还原。
                    for (int off = 0; off < frame.length; off += TUNNEL_CHUNK_BYTES) {
                        int end = Math.min(off + TUNNEL_CHUNK_BYTES, frame.length);
                        marker.put("d", toHex(java.util.Arrays.copyOfRange(frame, off, end)));
                        sig.send(sendMessage(token, uuid, marker.toString()));
                    }
                    return;
                }
                marker.put("gboy_ws", "f");
                if (!roomTag.isEmpty()) {
                    marker.put("room", roomTag);
                }
                marker.put("from", wsNonce == null ? "" : wsNonce);
                // base64 路径同样切片：多帧拼包时 28 字符会变 56，长信封也会破
                // 100。每片独立 base64，对端逐条解码后按顺序喂回流式拆包器。
                for (int off = 0; off < frame.length; off += TUNNEL_CHUNK_BYTES) {
                    int end = Math.min(off + TUNNEL_CHUNK_BYTES, frame.length);
                    marker.put("d", android.util.Base64.encodeToString(
                            java.util.Arrays.copyOfRange(frame, off, end),
                            android.util.Base64.NO_WRAP));
                    sig.send(sendMessage(token, uuid, marker.toString()));
                }
            } catch (Exception e) {
                closed = true;
                error = "服务器隧道发送失败：" + e.getMessage();
            }
        }

        @Override
        public byte[] recv(long timeoutMs) {
            byte[] frame = inbox.poll();
            if (frame != null) {
                return frame;
            }
            long deadline = System.currentTimeMillis() + Math.max(timeoutMs, 1);
            while (!closed && !sig.isClosed()) {
                long remaining = deadline - System.currentTimeMillis();
                if (remaining <= 0) {
                    return inbox.poll();
                }
                String text;
                // 同一时刻只允许一个线程读 WebSocket：sio-bridge-in 与
                // sio-tunnel-keepalive 都会调本方法，抢同一连接会打乱帧流。
                synchronized (recvLock) {
                    if (closed || sig.isClosed()) {
                        break;
                    }
                    maybeHello();
                    try {
                        text = sig.recv(Math.min(200, remaining));
                    } catch (IOException e) {
                        closed = true;
                        error = "服务器隧道连接中断：" + e.getMessage();
                        return inbox.poll();
                    }
                }
                if (text == null) {
                    continue;
                }
                demux(text);
                frame = inbox.poll();
                if (frame != null) {
                    return frame;
                }
            }
            if (!closed && sig.isClosed()) {
                closed = true;
                error = "服务器隧道连接中断";
            }
            return inbox.poll();
        }

        @Override
        public boolean isClosed() {
            return closed || sig.isClosed();
        }

        @Override
        public void close() {
            closed = true;
        }

        /** 在对方现身之前每 2 秒打一次招呼。 */
        private void maybeHello() {
            long now = System.currentTimeMillis();
            if (peerSeen || closed || now - lastHello < TUNNEL_HELLO_MS) {
                return;
            }
            lastHello = now;
            sendWsMarker(sig, token, uuid, "hello", roomTag);
        }

        /** 拆一帧信令推送：隧道数据进 reader，握手标记就地应答。 */
        private void demux(String text) {
            JSONObject object = GbCloud.lastJsonObjectOrNull(text);
            if (object != null && object.has("success") && !object.optBoolean("success", true)) {
                // 服务器拒收我们的推流（关键词过滤/长度限制/限流）：这一帧就丢了，
                // 联机线随即错位，游戏会报「连接发生了错误」。连挂三帧就带明确文案
                // 收尾。只统计紧跟在隧道帧发送之后 3 秒内的失败应答，免得用户手聊
                // 触发的错误误杀隧道。
                String err = object.optString("error", "");
                boolean ours = System.currentTimeMillis() - lastFrameSend < 3000;
                if (ours && (err.contains("违规") || err.contains("频繁") || err.contains("过快")
                        || err.contains("超过"))) {
                    Log.i(TAG, "tunnel push refused: " + err);
                    if (++refused >= 3 && !closed) {
                        closed = true;
                        error = "联机数据被大厅服务器过滤（" + err + "），请换个房间重试";
                    }
                }
                return;
            }
            if (object == null || !"send_message".equals(object.optString("type", ""))) {
                return; // 其它推送（player_joined 等）在数据阶段无关紧要
            }
            String message = object.optString("message", null);
            // 短信封数据帧没有 gboy_ws 键，只认它会把新版流量全漏掉；
            // 直连协商的 p/s/s2/s3 也没有 gboy_ws，所以这里只按 "w" 键放行。
            if (message == null || (message.indexOf("gboy_ws") < 0
                    && !message.contains("\"w\":\""))) {
                return;
            }
            Log.i(TAG, "tunnel push: " + message.substring(0,
                    Math.min(120, message.length()))
                    + (object.optBoolean("self", false) ? " (self)" : " (peer)"));
            JSONObject marker;
            try {
                marker = new JSONObject(message);
            } catch (Exception e) {
                return;
            }
            String kind = marker.optString("gboy_ws", "");
            if (kind.isEmpty()) {
                kind = marker.optString("w", "");
            }
            String tagged = marker.optString("room", "");
            if (tagged.isEmpty()) {
                tagged = marker.optString("r", "");
            }
            if (!roomTag.isEmpty() && !tagged.isEmpty() && !tagged.equals(roomTag)) {
                return; // 别的房间的流量
            }
            String from = marker.optString("from", "");
            if (from.isEmpty()) {
                from = marker.optString("o", "");
            }
            // 服务器会把自己的推送回显回来。直连协商的 o 只带自己 nonce 的前缀，
            // 所以两种比法都要认。
            String self = wsNonce == null ? "" : wsNonce;
            if (!from.isEmpty() && (from.equals(self) || self.startsWith(from))) {
                return;
            }
            // 对端标记带 "c":1 说明它也是新版：能解十六进制、也认短键名信封，
            // 之后改发 hex 短信封。老版本没有这个键，保持 base64 长信封。
            if (marker.optInt("c", 0) == 1) {
                peerCompact = true;
            }
            if ("f".equals(kind)) {
                try {
                    byte[] frame = fromTunnelPayload(marker.optString("d", ""));
                    if (frame != null && frame.length > 0) {
                        inbox.offer(frame);
                    }
                } catch (Exception e) {
                    Log.w(TAG, "bad tunnel frame", e);
                }
            } else if ("hello".equals(kind)) {
                peerSeen = true;
                long now = System.currentTimeMillis();
                if (now - lastAccept >= 1000) {
                    lastAccept = now;
                    sendWsMarker(sig, token, uuid, "accept", roomTag);
                }
            } else if ("accept".equals(kind)) {
                peerSeen = true;
            } else if (!kind.isEmpty()) {
                // 直连协商标记：交给 tryDirectLink 处理，别当成联机线字节
                control.offer(marker);
            }
        }
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
    private void handshake(Link link, Room room) throws IOException {
        handshake(link, room, STEP_WAIT_MS);
    }

    private void handshake(Link link, Room room, long waitMs) throws IOException {
        byte[] count = expect(link, GBoyFrames.TYPE_READY, waitMs);
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
    private void sendRegister(Link link, Room room) {
        int players = Math.max(1, room.playerCount);
        link.send(GBoyFrames.registerFrame(players, room.baseStateCount));
    }

    /**
     * Reads frames until one of {@code type} shows up. The room server sends
     * the key state (type 0) before the handshake is finished, so unrelated
     * frames are remembered instead of being dropped.
     */
    private byte[] expect(Link link, int type, long timeoutMs) throws IOException {
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

    /**
     * Called once per rendered frame by the emulation loop. The first call
     * switches key broadcasting from the legacy 50 ms timer to the official
     * five-frame cadence, so a front end that has not been wired up keeps the
     * old behaviour and the handshake still works.
     */
    public void onLocalFrame(long frame, int localKeys) {
        GBoyLinkSession s = linkSession;
        if (s == null) {
            return;
        }
        frameDriven = true;
        s.onLocalFrame(frame, localKeys);
    }

    /** Session used by the local multi-console driver, or null before serve(). */
    public GBoyLinkSession linkSession() {
        return linkSession;
    }

    private GBoyLinkSession newSession(Link link) {
        servingLink = link;
        return new GBoyLinkSession(frame -> {
            synchronized (sendLock) {
                Link current = servingLink;
                if (!closed && current != null) {
                    current.send(frame);
                }
            }
        /* 4 槽位会话：本机可见核 slot 1，3 个镜像核 slot 2/3/4。网络只传
         * 真人按键，对端按键进 slot 2，slot 3/4 恒 0 作为 NPC 陪位。 */
        }, sessionEvents, 1, 4);
    }

    /** The onConnected callback is posted to the UI thread, so the session has
     * to exist before it runs or the mirror console would see no keys. */
    private void ensureSession(Link link) {
        if (linkSession == null) {
            linkSession = newSession(link);
        } else {
            servingLink = link;
        }
    }

    private void serve(Link link) {
        ensureSession(link);
        long lastKey = 0;
        long lastFps = 0;
        int sentKeys = Integer.MIN_VALUE;
        while (!closed && !link.isClosed()) {
            long now = System.currentTimeMillis();
            if (!frameDriven && now - lastKey >= KEY_INTERVAL_MS) {
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
        GBoyLinkSession s = linkSession;
        if (s != null) {
            // Session handles slot dispatch, counter/fps, state and handshake.
            // The switch below stays as the compatibility path for the UI.
            s.onFrameBody(body);
        }
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
        waitForRoom(sig, room, roomId, timeoutMs, false);
    }

    /**
     * @param nodeRequired 房主建房最后一步必须拿到中继节点：此时房间里可能还飘着
     *     上一个（已经死掉的）客户端的隧道 hello 回显，如果照「见到对端 hello 就
     *     提前返回」的老逻辑收工，nodeAddress 会是空的，接着就抛
     *     「服务器没有返回中继节点」——实测就是这么翻车的。
     */
    private void waitForRoom(GbCloud.Session sig, Room room, String roomId, long timeoutMs,
                            boolean nodeRequired) throws IOException {
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
                // channel as {"gboy_node":"address:port","room":id}. Pull it
                // out so the joiner can connect without manual NODE2: entry.
                // A {"gboy_ws":"hello|accept"} marker instead means the peer is
                // already waiting on the websocket tunnel - remember that so
                // the relay window is cut short.
                String message = object.optString("message", null);
                // 新版数据帧是短键名信封（"w":"f"），没有 gboy_ws 键
                if (message != null && (message.indexOf("gboy_ws") >= 0
                        || message.contains("\"w\":\"f\""))) {
                    JSONObject marker = GbCloud.lastJsonObjectOrNull(message);
                    if (marker != null) {
                        String from = marker.optString("from", "");
                        if (from.isEmpty()) {
                            from = marker.optString("o", "");
                        }
                        if (from.isEmpty() || !from.equals(wsNonce == null ? "" : wsNonce)) {
                            tunnelPeerSeen = true;
                        }
                    }
                }
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
            // 对方已经在服务器隧道上等着了，节点不会再来，直接进入数据阶段。
            // 房主取节点这一步例外：残留的对端 hello 不能当成「节点不会再来」。
            if (tunnelPeerSeen && !nodeRequired) {
                return;
            }
        }
    }

    /**
     * Re-broadcasts the relay endpoint to the room so a joining player can
     * fill it in automatically.
     *
     * <p>gboy.top hands the relay node only to the room creator, so a late or
     * slow joiner would otherwise have to type {@code NODE2:address:port} by
     * hand. The host therefore advertises it over the (lobby-wide) broadcast
     * channel as a JSON marker {@code {"gboy_node":"address:port","room":id}}.
     * The joiner's {@link #waitForRoom} parses that marker and connects without
     * any manual step.</p>
     *
     * <p>This thread is send-only on purpose: the worker thread must stay the
     * only reader of the websocket, otherwise it would swallow tunnel markers
     * and game frames. Server pings are answered by the worker's own reads
     * ({@link #drainSignaling}, {@link WsLink#recv}).</p>
     */
    private void startNodeAdvertiser(final GbCloud.Session sig, final String token,
                                     final String uuid, final Room room) {
        Thread t = new Thread(() -> {
            long last = 0;
            while (!closed) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    break;
                }
                long now = System.currentTimeMillis();
                if (now - last < advertiseIntervalMs) {
                    continue;
                }
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
