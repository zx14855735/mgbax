/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.util.ArrayDeque;

/**
 * The GBoy 26.10.18 link session, ported from the official client.
 *
 * <p>Reverse-engineered from {@code com.game.boy}: {@code Link} owns up to four
 * {@code Console} instances and {@code Link.runFrame(boolean)} advances them all
 * in one native call, so SIO never leaves the device. The frame loop in
 * {@code LADYaiT/D8MqeW.run()} broadcasts the local key mask to every peer once
 * every five frames (12 Hz at 60 fps, counter {@code B9tovu} initialised to 5),
 * and {@code LKpHwm4/B25kr6.AYUAbz(peer)} drains the peer's blocking queue,
 * selects the target console by the message type together with the peer's slot
 * number, and calls {@code Console.setKeys(int)}. Queue depth is the back-pressure
 * signal. Frames are built by {@code B25kr6.ARc23Z(short type, int size)} as
 * {@code allocate(size+6); putInt(size+2); putShort(type)}, which is exactly
 * {@link GBoyFrames}.</p>
 *
 * <p>This class is the protocol half of that design and is deliberately free of
 * Android and native dependencies: the frame loop calls {@link #onLocalFrame},
 * the network layer calls {@link #onFrameBody}, and each local console reads
 * {@link #keysForSlot}. Advancing the cores stays with the front end, because
 * the mGBA native link driver needs one execution thread per core.</p>
 */
public final class GBoyLinkSession {

    /** Official {@code Link} allocates its console list with capacity four. */
    public static final int MAX_CONSOLES = 4;
    /** {@code B9tovu} is set to 5 and decremented once per frame. */
    public static final int KEY_SEND_INTERVAL_FRAMES = 5;
    /** Beyond this many queued key frames the peer is ahead; drop the oldest. */
    public static final int BACKLOG_LIMIT = 2;
    /** Local handshake value of the socket transport ({@code type 1, int 6}). */
    public static final int SOCKET_HANDSHAKE_VALUE = 6;

    /** Sends one complete wire frame (length + type + payload). */
    public interface Transport {
        void send(byte[] frame);
    }

    /** Session-level events the front end has to act on. */
    public interface Events {
        /** A TYPE_RESET arrived: reset every local console. */
        void onReset();
        /** A TYPE_STATE arrived with the save-state blob. */
        void onState(byte[] state);
        /** The peer finished the handshake. */
        void onReady();
        /** Diagnostic text. */
        void onStatus(String text);
    }

    private final Transport transport;
    private final Events events;
    private final int localSlot;
    private final int playerCount;
    private final Object lock = new Object();
    private final ArrayDeque<Integer>[] pending;
    private final int[] currentKeys;

    private long frameNo;
    private int sampleCountdown = 1;
    private boolean ready;
    private int remoteCounter = -1;
    /** 官方 type 9 下发的速度倍率（1 / 2 / 4；-1 表示 0.5x）。-99 = 未收到。 */
    private int remoteSpeed = -99;
    /** 官方 type 3 带回的对端 RTT（毫秒），-1 = 还没收到。 */
    private int remoteRtt = -1;
    private int lastLocalKeys;
    /** 上一次真正发出去的按键掩码；边沿立即发送靠它判变化（-1 = 强制首帧）。 */
    private int lastSentKeys = -1;
    private int sentFrames;
    private long droppedFrames;
    /** 预先构造好的 type 2 自我介绍帧（socket 直连握手时跟在 type 1 后发）。 */
    private volatile byte[] nameFrame;

    @SuppressWarnings("unchecked")
    public GBoyLinkSession(Transport transport, Events events, int localSlot, int playerCount) {
        if (transport == null || events == null) {
            throw new IllegalArgumentException("transport and events are required");
        }
        if (localSlot < 1 || localSlot > MAX_CONSOLES) {
            throw new IllegalArgumentException("local slot out of range: " + localSlot);
        }
        if (playerCount < 2 || playerCount > MAX_CONSOLES) {
            throw new IllegalArgumentException("player count out of range: " + playerCount);
        }
        this.transport = transport;
        this.events = events;
        this.localSlot = localSlot;
        this.playerCount = playerCount;
        this.pending = new ArrayDeque[MAX_CONSOLES + 1];
        this.currentKeys = new int[MAX_CONSOLES + 1];
        for (int slot = 1; slot <= MAX_CONSOLES; ++slot) {
            pending[slot] = new ArrayDeque<>();
        }
    }

    /**
     * Called by the emulation loop once per rendered frame. Every fifth frame it
     * samples one queued key mask for each remote console and broadcasts the
     * local mask; the four frames in between keep the last sampled mask, exactly
     * like the official 12 Hz cadence. Returns the frame to send, or null.
     */
    public byte[] onLocalFrame(long frame, int localKeys) {
        byte[] out = null;
        synchronized (lock) {
            frameNo = frame;
            lastLocalKeys = localKeys;
            currentKeys[localSlot] = localKeys;
            // 发送时机 = 5 帧心跳 ∪ 按键边沿。纯 5 帧采样会把 2 帧的短按吞掉
            // （命中率 2/5），对端镜像核的菜单推进因此一直落后一步，联机握手
            // 时两边不在同一子状态（实测 pc=0、主核永远发 0xB9A0 等待字）。
            boolean edge = localKeys != lastSentKeys;
            if (--sampleCountdown <= 0 || edge) {
                sampleCountdown = KEY_SEND_INTERVAL_FRAMES;
                lastSentKeys = localKeys;
                out = keyFrameForLocalSlot(localKeys);
                ++sentFrames;
            }
        }
        if (out != null) {
            transport.send(out);
        }
        return out;
    }

    /**
     * 第 index 个镜像核代表的全局槽位：跳过本机 localSlot 后的第 index 个。
     * localSlot == 1 时结果恒为 index + 2，与原来的固定映射一致。
     * 纯函数，PC / Android / iOS 三端的本机多核布局共用同一套规则。
     */
    public static int mirrorSlotFor(int localSlot, int playerCount, int index) {
        if (playerCount < 2 || playerCount > MAX_CONSOLES || localSlot < 1
                || localSlot > playerCount || index < 0 || index >= playerCount - 1) {
            return 0;
        }
        int seen = 0;
        for (int slot = 1; slot <= playerCount; ++slot) {
            if (slot == localSlot) {
                continue;
            }
            if (seen == index) {
                return slot;
            }
            ++seen;
        }
        return 0;
    }

    /**
     * 3/4 人时键位帧必须自带槽位：官方协议用 type 2 / 带 int 的 3 / 4 指定
     * 目标 console，TYPE_KEYS 只代表发送方自己占的 slot 1。若所有设备都发
     * TYPE_KEYS，接收侧只能按默认槽位落键，slot 3/4 的镜像核永远收不到按键。
     * 两人会话保持原来的 TYPE_KEYS，已验证的直连路径一字不动。
     */
    private byte[] keyFrameForLocalSlot(int keys) {
        if (playerCount <= 2 || localSlot == 1) {
            return GBoyFrames.frame(GBoyFrames.TYPE_KEYS, keys);
        }
        switch (localSlot) {
            case 2:
                return GBoyFrames.frame(GBoyFrames.TYPE_INPUT_2, keys);
            case 3:
                return GBoyFrames.frame(GBoyFrames.TYPE_INPUT_3, keys);
            case 4:
                return GBoyFrames.frame(GBoyFrames.TYPE_INPUT_4, keys);
            default:
                return GBoyFrames.frame(GBoyFrames.TYPE_KEYS, keys);
        }
    }

    /**
     * 3/4 人时 TYPE_KEYS 只由占 slot 1 的设备发出，其余槽位都走带槽位的
     * type；两人会话沿用历史的「本机是 2 号就认为对端是 1 号」规则。
     */
    private int defaultSenderSlot() {
        if (playerCount > 2) {
            /* 云端 4 核房间两端都把可见核放在 localSlot=1：裸 TYPE_KEYS 不带
             * 槽位，代表「对端那台设备」，必须落到 slot 2（本机 4 核里代表
             * 对端的那个镜像核）。返回 1 会把对端按键盖到自己的可见核上。 */
            return localSlot == 1 ? 2 : 1;
        }
        return localSlot == 2 ? 1 : 2;
    }

    /** Key mask the frame loop must inject into the console of {@code slot}. */
    public int keysForSlot(int slot) {
        if (slot < 1 || slot > playerCount) {
            return 0;
        }
        synchronized (lock) {
            return currentKeys[slot];
        }
    }

    /**
     * Handles one complete frame body (type followed by payload) from a peer.
     * {@code senderSlot} is the slot of the console owned by that peer; a bare
     * TYPE_KEYS frame therefore targets that slot, while TYPE_INPUT_2/3/4
     * target the slot named by the type when several consoles are in play.
     */
    public void onFrameBody(byte[] body, int senderSlot) {
        int type = GBoyFrames.typeOf(body);
        if (type < 0) {
            return;
        }
        switch (type) {
            case GBoyFrames.TYPE_KEYS:
            case GBoyFrames.TYPE_KEYS_LOCAL:
                pushKeys(senderSlot, GBoyFrames.intOf(body));
                break;
            case GBoyFrames.TYPE_INPUT_2:
            case GBoyFrames.TYPE_INPUT_3:
            case GBoyFrames.TYPE_INPUT_4: {
                int target = type == GBoyFrames.TYPE_INPUT_2 ? 2
                        : type == GBoyFrames.TYPE_INPUT_3 ? 3 : 4;
                pushKeys(target, GBoyFrames.intOf(body));
                break;
            }
            case GBoyFrames.TYPE_READY: {
                // 官方语义（握手期）：3 = 就绪 + RTT（int32）。
                boolean first;
                synchronized (lock) {
                    first = !ready;
                    ready = true;
                    if (GBoyFrames.payloadOf(body).length >= 4) {
                        remoteRtt = GBoyFrames.intOf(body);
                    }
                }
                if (first) {
                    events.onReady();
                }
                break;
            }
            case GBoyFrames.TYPE_NAME: {
                /* 官方 2（AZkASS:136）：32 字节定长 romHash + int16 长度 + ROM 名。
                 * 只用于显示对端身份，和核对 ROM 是否一致无关（官方此步不校验）。 */
                byte[] payload = GBoyFrames.payloadOf(body);
                if (payload.length >= 34) {
                    int len = ((payload[32] & 0xFF) << 8) | (payload[33] & 0xFF);
                    int end = 32;
                    for (int i = 0; i < 32; i++) {
                        if (payload[i] == 0) {
                            end = i;
                            break;
                        }
                    }
                    String hash = new String(payload, 0, end);
                    String romName = new String(payload, 34, Math.min(len, payload.length - 34));
                    events.onStatus("peer " + hash + " (" + romName + ")");
                }
                break;
            }
            case GBoyFrames.TYPE_REGISTER:
                synchronized (lock) {
                    ready = true;
                }
                events.onReady();
                break;
            case GBoyFrames.TYPE_RECONNECT: {
                /* 官方重连握手（AmA8tU.ARc23Z(Socket) 263-272）：裸 10 字节
                 * int32 6 + int16 100 + int32 rtt，在线上就是 type=100 的普通
                 * 帧。收到即代表对端重新接上了同一条会话，语义等同一次握手：
                 * 标记就绪并刷新 RTT，绝不能落到 default 被当成未知帧。 */
                boolean first;
                synchronized (lock) {
                    first = !ready;
                    ready = true;
                    remoteRtt = GBoyFrames.intOf(body);
                }
                if (first) {
                    events.onReady();
                }
                events.onStatus("peer reconnected, rtt=" + GBoyFrames.intOf(body));
                break;
            }
            case GBoyFrames.TYPE_RESET:
            case GBoyFrames.TYPE_RESET_LEGACY:
                // 官方 5 = 复位（EmulatorActivity.BmvVmW 发送，收端全核 reset）；
                // 13 是我们旧号，仅接收兼容，发送永远用 5。
                events.onReset();
                break;
            case GBoyFrames.TYPE_STATE:
                events.onState(stateOf(body));
                break;
            case GBoyFrames.TYPE_COUNTER:
                synchronized (lock) {
                    remoteCounter = GBoyFrames.intOf(body);
                }
                break;
            case GBoyFrames.TYPE_SPEED:
                /* 官方 9：模拟速度倍率（1 / -1=0.5x / 2 / 4），接收侧写
                 * AaHO0E.AZkASS 并重算帧闸。我们只记录，节拍仍由本机决定。 */
                synchronized (lock) {
                    remoteSpeed = GBoyFrames.intOf(body);
                }
                break;
            case GBoyFrames.TYPE_EVENT:
                events.onStatus("event " + GBoyFrames.intOf(body));
                break;
            default:
                events.onStatus("unknown frame type " + type);
                break;
        }
    }

    public void onFrameBody(byte[] body) {
        onFrameBody(body, defaultSenderSlot());
    }

    /**
     * Feeds a raw wire frame ({@code u32 length + u16 type + payload}), which is
     * what a socket or WebSocket transport actually hands over. The length is
     * validated before the body is dispatched, so a truncated or corrupt frame
     * cannot be mistaken for a key mask.
     */
    public void onWireFrame(byte[] wire, int senderSlot) {
        if (wire == null || wire.length < 6) {
            return;
        }
        int length = GBoyFrames.getInt(wire, 0);
        if (length < 2 || length > wire.length - 4) {
            return;
        }
        byte[] body = new byte[length];
        System.arraycopy(wire, 4, body, 0, length);
        onFrameBody(body, senderSlot);
    }

    public void onWireFrame(byte[] wire) {
        onWireFrame(wire, defaultSenderSlot());
    }

    /** 测试钩子：把同一按键掩码灌进指定槽位。
     *
     * 4 核/设备时本机只有可见核（slot1）有真人按键源，slot3/4 作 NPC 队位恒 0，
     * 于是它们永远停在柜台大厅、游戏也不放开走位（大竞技场要求 4 人就位）。
     * 广播 KEYS 时把掩码同步灌进 3/4，让 NPC 核跟着可见核走同一段对话。
     * 不灌 slot2：那是跨网对端真人，覆盖会吞掉对方的操作。 */
    public void injectKeysForSlot(int slot, int keys) {
        pushKeys(slot, keys);
    }

    private void pushKeys(int slot, int keys) {
        if (slot < 1 || slot > MAX_CONSOLES) {
            return;
        }
        // 「最新即生效」而不是排队：镜像核每帧都读一次 keysForSlot()，直接覆盖
        // 当前值既没有排队延迟，也不会漏掉任何按下沿（按下帧覆盖、松开帧再覆盖）。
        // 原来的 5 帧队列会让对端的边沿帧积压，镜像核拿到几帧前的按键。
        synchronized (lock) {
            currentKeys[slot] = keys;
        }
    }

    /** Official cloud registration: ten byte body, see GBoyFrames.registerFrame. */
    public void sendRegistration(int baseStateCount) {
        transport.send(GBoyFrames.registerFrame(playerCount, baseStateCount));
    }

    /**
     * 官方 type 2 自我介绍（{@code AZkASS:136}，双向、握手第 4 步）。
     * 云端中继/直连两条路都在 type 1 之后立刻发这一条。
     */
    public void sendName(String romHash, String romName) {
        byte[] frame = GBoyFrames.nameFrame(romHash, romName);
        nameFrame = frame;
        transport.send(frame);
    }

    /**
     * 预先绑定自我介绍帧：socket 直连的两端（服务端回声、客户端首发）都会在
     * {@link #sendSocketHandshake()} 里把 type 1 和紧随其后的 type 2 一起发出，
     * 顺序与官方 {@code 1 → 2 → 3 → 6} 一致。
     */
    public void setIdentity(byte[] nameFrame) {
        this.nameFrame = nameFrame;
    }

    /**
     * Official socket handshake: type 1 (int 6) → type 2 identity → type 3.
     *
     * <p>官方直连是硬读顺序 {@code 1 → 2 → 3 → 6}（{@code B25kr6.A4TApA:122-144}，
     * 每步 {@code getShort()} 校验、不符即 {@code return 2}）。第 3 帧是
     * {@code ARc23Z((short)3, 4)} 的 10 字节形态（type 3 + int32 0），不是
     * 「灌完存档」那种 6 字节空体（{@code AmA8tU:211}）。每次连接只发一次。</p>
     */
    public void sendSocketHandshake() {
        transport.send(GBoyFrames.frame(GBoyFrames.TYPE_REGISTER, SOCKET_HANDSHAKE_VALUE));
        byte[] identity = nameFrame;
        if (identity != null) {
            transport.send(identity);
        }
        transport.send(GBoyFrames.frame(GBoyFrames.TYPE_READY, 0));
    }

    /** TYPE_STATE = int length followed by the save-state blob. */
    public void sendState(byte[] state) {
        byte[] body = new byte[4 + (state == null ? 0 : state.length)];
        GBoyFrames.putInt(body, 0, state == null ? 0 : state.length);
        if (state != null) {
            System.arraycopy(state, 0, body, 4, state.length);
        }
        transport.send(GBoyFrames.frame(GBoyFrames.TYPE_STATE, body));
    }

    /** Extracts the save-state blob out of a TYPE_STATE body. */
    public static byte[] stateOf(byte[] body) {
        byte[] payload = GBoyFrames.payloadOf(body);
        if (payload.length < 4) {
            return new byte[0];
        }
        int length = GBoyFrames.getInt(payload, 0);
        if (length < 0 || length > payload.length - 4) {
            return new byte[0];
        }
        byte[] out = new byte[length];
        System.arraycopy(payload, 4, out, 0, length);
        return out;
    }

    public void sendReset() {
        transport.send(GBoyFrames.frame(GBoyFrames.TYPE_RESET, 0));
    }

    /** 官方 9：请求对端切换模拟速度（1 / -1=0.5x / 2 / 4）。 */
    public void sendSpeed(int speed) {
        transport.send(GBoyFrames.frame(GBoyFrames.TYPE_SPEED, speed));
    }

    /**
     * 官方 {@code AaHO0E.AYUAbz(float)} 的帧闸换算：{@code 1e9 / (speed*60)}。
     *
     * <p>payload 值域 {@code {1, -1, 2, 4}}，其中 {@code -1} 代表 0.5x
     * （{@code AYUAbz} 的 {@code if i <= 0 → 0.5f}）。其它值返回 0，调用方保持
     * 本地原始节拍（约 16.74ms），等价「未收到」。</p>
     */
    public static long paceNanosForSpeed(int value) {
        float factor;
        switch (value) {
            case 1:
                factor = 1f;
                break;
            case -1:
                factor = 0.5f;
                break;
            case 2:
                factor = 2f;
                break;
            case 4:
                factor = 4f;
                break;
            default:
                return 0L;
        }
        return (long) (1_000_000_000.0 / (factor * 60.0));
    }

    /** Slot of the console owned by this device (1..4). */
    public int localSlot() {
        return localSlot;
    }

    /** Number of consoles in this session (2..4). */
    public int playerCount() {
        return playerCount;
    }

    public long frameNo() {
        synchronized (lock) {
            return frameNo;
        }
    }

    public boolean isReady() {
        synchronized (lock) {
            return ready;
        }
    }

    public int remoteCounter() {
        synchronized (lock) {
            return remoteCounter;
        }
    }

    public int remoteSpeed() {
        synchronized (lock) {
            return remoteSpeed;
        }
    }

    public int lastLocalKeys() {
        synchronized (lock) {
            return lastLocalKeys;
        }
    }

    public int sentFrames() {
        synchronized (lock) {
            return sentFrames;
        }
    }

    public long droppedFrames() {
        synchronized (lock) {
            return droppedFrames;
        }
    }

    public int backlog(int slot) {
        if (slot < 1 || slot > MAX_CONSOLES) {
            return 0;
        }
        synchronized (lock) {
            return pending[slot].size();
        }
    }
}
