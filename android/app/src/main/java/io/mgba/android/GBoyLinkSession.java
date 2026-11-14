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
    private int remoteFps = -1;
    private int lastLocalKeys;
    /** 上一次真正发出去的按键掩码；边沿立即发送靠它判变化（-1 = 强制首帧）。 */
    private int lastSentKeys = -1;
    private int sentFrames;
    private long droppedFrames;

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
                return GBoyFrames.frame(GBoyFrames.TYPE_READY, keys);
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
            case GBoyFrames.TYPE_READY:
            case GBoyFrames.TYPE_INPUT_4: {
                // The official client reuses type 3: bare frame = handshake
                // READY, frame with an int = key mask for console slot 3.
                if (type == GBoyFrames.TYPE_READY
                        && GBoyFrames.payloadOf(body).length < 4) {
                    boolean first;
                    synchronized (lock) {
                        first = !ready;
                        ready = true;
                    }
                    if (first) {
                        events.onReady();
                    }
                    break;
                }
                int target = type == GBoyFrames.TYPE_INPUT_2 ? 2
                        : type == GBoyFrames.TYPE_READY ? 3 : 4;
                pushKeys(target, GBoyFrames.intOf(body));
                break;
            }
            case GBoyFrames.TYPE_REGISTER:
                synchronized (lock) {
                    ready = true;
                }
                events.onReady();
                break;
            case GBoyFrames.TYPE_RESET:
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
            case GBoyFrames.TYPE_FPS:
                synchronized (lock) {
                    remoteFps = GBoyFrames.intOf(body);
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

    /** Official socket handshake: type 1 carrying int 6. */
    public void sendSocketHandshake() {
        transport.send(GBoyFrames.frame(GBoyFrames.TYPE_REGISTER, SOCKET_HANDSHAKE_VALUE));
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

    public void sendFps(int fps) {
        transport.send(GBoyFrames.frame(GBoyFrames.TYPE_FPS, fps));
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

    public int remoteFps() {
        synchronized (lock) {
            return remoteFps;
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
