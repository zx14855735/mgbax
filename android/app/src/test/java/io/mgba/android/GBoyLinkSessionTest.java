/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Plain JVM test of the ported GBoy link session. */
public final class GBoyLinkSessionTest {

    private static final class Sink implements GBoyLinkSession.Transport {
        final List<byte[]> frames = new ArrayList<>();

        @Override
        public void send(byte[] frame) {
            frames.add(frame);
        }
    }

    private static final class Recorder implements GBoyLinkSession.Events {
        int resets;
        int readies;
        byte[] state;
        final List<String> status = new ArrayList<>();

        @Override
        public void onReset() {
            ++resets;
        }

        @Override
        public void onState(byte[] value) {
            state = value;
        }

        @Override
        public void onReady() {
            ++readies;
        }

        @Override
        public void onStatus(String text) {
            status.add(text);
        }
    }

    private static Sink sink;
    private static Recorder events;
    private static GBoyLinkSession session;

    public static void main(String[] args) {
        fiveFrameKeyCadence();
        keyFrameLayout();
        remoteKeysApplyImmediately();
        missingKeyFramesHoldLastMask();
        preReadyKeysAreDropped();
        slotTypedFrames();
        multiPlayerSendsSlotTypedFrames();
        multiPlayerRoutesKeysToOwnSlots();
        twoPlayerKeepsTypeKeys();
        mirrorSlotMapping();
        readyHandshake();
        resetAndStateRoundTrip();
        /* T-04 / V2：type 6 三语义互斥 + 11-15 协议号防漂移。 */
        typeSixStateFrameRoundTrip();
        typeSixRejectsRawSioBridgePacket();
        typeSixRejectsTruncatedAndIllegalLengths();
        protocolNumbersGuardAgainstReadyDrift();
        readerAcceptsLargeStateFrames();
        counterAndSpeed();
        latestMaskWinsWithoutQueueing();
        registrationAndSocketHandshake();
        speedPaceTable();
        rejectsBadConfiguration();
        System.out.println("GBoyLinkSessionTest ok");
    }

    private static void fresh() {
        sink = new Sink();
        events = new Recorder();
        session = new GBoyLinkSession(sink, events, 1, 2);
    }

    /**
     * 对端发一条 TYPE_READY 把会话推进到 ready。
     *
     * <p>11-16 起 {@link GBoyLinkSession} 与 PC {@code GBoyLinkSession.cpp:117}
     * 一样带 pre-ready 门：握手完成之前的按键帧整条丢弃。凡是「收到对端按键」
     * 的用例都必须先建 ready，否则测的是真实环境里不存在的状态。</p>
     */
    private static void peerReady(GBoyLinkSession target) {
        target.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_READY), 2);
    }

    private static void fiveFrameKeyCadence() {
        fresh();
        for (int f = 0; f < 20; ++f) {
            session.onLocalFrame(f, 0x10);
        }
        check(sink.frames.size() == 4, "20 frames produce 4 key broadcasts (12 Hz)");
        check(session.sentFrames() == 4, "send counter matches");
        check(session.frameNo() == 19, "frame number tracked");
    }

    private static void keyFrameLayout() {
        fresh();
        byte[] frame = session.onLocalFrame(0, 0x1234);
        check(frame != null, "first frame broadcasts immediately");
        check(frame.length == 10, "key frame is length+type+int = 10 bytes");
        check(GBoyFrames.getInt(frame, 0) == 6, "length field counts type + payload");
        check(GBoyFrames.getShort(frame, 4) == GBoyFrames.TYPE_KEYS, "type 0 key mask");
        check(GBoyFrames.getInt(frame, 6) == 0x1234, "key mask payload");
        check(session.lastLocalKeys() == 0x1234, "local keys recorded");
    }

    /** 11-13 起接收侧改为「最新即生效、不排队」，不再等 5 帧采样点。 */
    private static void remoteKeysApplyImmediately() {
        fresh();
        session.onLocalFrame(0, 0);
        peerReady(session); /* 键位帧只在握手后生效（PC :117 的 pre-ready 门） */
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, 0xAA), 2);
        check(session.keysForSlot(2) == 0xAA,
                "received keys apply immediately, no 5-frame sample point");
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, 0xBB), 2);
        check(session.keysForSlot(2) == 0xBB, "newest mask wins, nothing is queued");
        check(session.backlog(2) == 0, "latest-wins mode keeps no pending queue");
        for (int f = 1; f <= 10; ++f) {
            session.onLocalFrame(f, 0);
        }
        check(session.keysForSlot(2) == 0xBB, "mask is held until the next wire frame");
    }

    private static void missingKeyFramesHoldLastMask() {
        fresh();
        session.onLocalFrame(0, 0);
        peerReady(session);
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, 0x40), 2);
        for (int f = 1; f <= 5; ++f) {
            session.onLocalFrame(f, 0);
        }
        check(session.keysForSlot(2) == 0x40, "first mask applied");
        for (int f = 6; f <= 20; ++f) {
            session.onLocalFrame(f, 0);
        }
        check(session.keysForSlot(2) == 0x40, "no new frame keeps the held mask");
    }

    /**
     * KL-6 缺口 B · 与 PC {@code GBoyLinkSession.cpp:117} 对齐的 pre-ready 门。
     *
     * <p>握手完成之前的按键帧必须**整条丢弃**并留下可见诊断，不能当真实按键
     * 推入 —— 官方 type 0 在握手期那条是「初始节奏 / 速度信号」而不是按键，
     * 没有这道门时对端开局那条 0 会凭空按下 1/2/4 号键，两边在菜单里各多走
     * 一步。同一帧在握手之后必须照常生效：门挡的是「还没就绪」，不是永久丢弃。</p>
     */
    private static void preReadyKeysAreDropped() {
        fresh();
        check(!session.isReady(), "no handshake has happened yet");
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, 0xFF), 2);
        check(session.keysForSlot(2) == 0,
                "a pre-ready TYPE_KEYS frame is dropped instead of being pushed as real keys");
        check(events.status.contains("pre-ready key frame ignored"),
                "the drop is reported with the PC-identical status text");

        peerReady(session);
        check(session.isReady(), "TYPE_READY completes the handshake");
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, 0xFF), 2);
        check(session.keysForSlot(2) == 0xFF,
                "the very same key frame applies once the session is ready");
    }

    private static void slotTypedFrames() {
        Sink s = new Sink();
        Recorder e = new Recorder();
        GBoyLinkSession four = new GBoyLinkSession(s, e, 1, 4);
        four.onLocalFrame(0, 0);
        peerReady(four); /* 槽位键也走同一道 pre-ready 门（PC :117） */
        four.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_INPUT_2, 0x21), 2);
        /* 11-15 协议复核：type 3 是「就绪 + RTT」，slot 3 的按键改用
         * 自家扩展 TYPE_INPUT_3，避免把按键误当成握手帧。 */
        four.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_INPUT_3, 0x31), 3);
        four.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_INPUT_4, 0x41), 4);
        for (int f = 1; f <= 5; ++f) {
            four.onLocalFrame(f, 0);
        }
        check(four.keysForSlot(2) == 0x21, "INPUT_2 targets slot 2");
        check(four.keysForSlot(3) == 0x31, "INPUT_3 targets slot 3, not the READY handshake");
        check(four.keysForSlot(4) == 0x41, "INPUT_4 targets slot 4");
    }

    /** 3/4 人时每台设备必须发自带槽位的键位帧，否则对端无法区分来源。 */
    private static void multiPlayerSendsSlotTypedFrames() {
        int[] expected = {GBoyFrames.TYPE_KEYS, GBoyFrames.TYPE_INPUT_2,
                GBoyFrames.TYPE_INPUT_3, GBoyFrames.TYPE_INPUT_4};
        for (int slot = 1; slot <= 4; ++slot) {
            Sink s = new Sink();
            GBoyLinkSession dev = new GBoyLinkSession(s, new Recorder(), slot, 4);
            byte[] wire = dev.onLocalFrame(0, 0x100 + slot);
            check(wire != null, "slot " + slot + " broadcasts on frame 0");
            check(GBoyFrames.getShort(wire, 4) == expected[slot - 1],
                    "slot " + slot + " uses its slot-tagged frame type");
            check(GBoyFrames.getInt(wire, 6) == 0x100 + slot,
                    "slot " + slot + " carries its own key mask");
            if (slot == 3) {
                byte[] body = Arrays.copyOfRange(wire, 4, wire.length);
                check(GBoyFrames.payloadOf(body).length == 4,
                        "slot 3 INPUT_3 carries an int key mask");
            }
        }
    }

    /** 四台设备各占一个槽位时，每个槽位的按键都要落到正确的镜像核。 */
    private static void multiPlayerRoutesKeysToOwnSlots() {
        Sink[] sinks = new Sink[4];
        Recorder[] recorders = new Recorder[4];
        GBoyLinkSession[] devices = new GBoyLinkSession[4];
        int[] keys = {0x11, 0x22, 0x33, 0x44};
        for (int i = 0; i < 4; ++i) {
            sinks[i] = new Sink();
            recorders[i] = new Recorder();
            devices[i] = new GBoyLinkSession(sinks[i], recorders[i], i + 1, 4);
            /* 每台设备各自建 ready：pre-ready 门是按会话（设备）生效的，
             * 只给其中一台建门不会让其余三台收键。 */
            peerReady(devices[i]);
            devices[i].onLocalFrame(0, keys[i]);
        }
        for (int receiver = 0; receiver < 4; ++receiver) {
            for (int sender = 0; sender < 4; ++sender) {
                if (sender != receiver) {
                    devices[receiver].onWireFrame(sinks[sender].frames.get(0));
                }
            }
        }
        for (int f = 1; f <= 5; ++f) {
            for (int i = 0; i < 4; ++i) {
                devices[i].onLocalFrame(f, 0);
            }
        }
        for (int receiver = 0; receiver < 4; ++receiver) {
            for (int slot = 1; slot <= 4; ++slot) {
                if (slot != receiver + 1) {
                    check(devices[receiver].keysForSlot(slot) == keys[slot - 1],
                            "device " + (receiver + 1) + " routes slot " + slot + " keys");
                }
            }
            check(recorders[receiver].readies == 1,
                    "slot-typed key frames never fire onReady (only the explicit READY did)");
        }
    }

    /** 两人会话的发送帧与默认槽位必须保持原样，不影响已验证的直连。 */
    private static void twoPlayerKeepsTypeKeys() {
        Sink s = new Sink();
        GBoyLinkSession dev = new GBoyLinkSession(s, new Recorder(), 2, 2);
        byte[] wire = dev.onLocalFrame(0, 0x55);
        check(GBoyFrames.getShort(wire, 4) == GBoyFrames.TYPE_KEYS,
                "two-player device on slot 2 still sends TYPE_KEYS");
        Sink t = new Sink();
        GBoyLinkSession peer = new GBoyLinkSession(t, new Recorder(), 1, 2);
        peerReady(peer);
        peer.onWireFrame(wire);
        for (int f = 1; f <= 5; ++f) {
            peer.onLocalFrame(f, 0);
        }
        check(peer.keysForSlot(2) == 0x55, "two-player default sender slot unchanged");
    }

    /** 三端共用的镜像核槽位映射：跳过本机槽位后按顺序分配其余槽位。 */
    private static void mirrorSlotMapping() {
        check(GBoyLinkSession.mirrorSlotFor(1, 4, 0) == 2, "slot 1 device mirrors 2 first");
        check(GBoyLinkSession.mirrorSlotFor(1, 4, 1) == 3, "slot 1 device mirrors 3 second");
        check(GBoyLinkSession.mirrorSlotFor(1, 4, 2) == 4, "slot 1 device mirrors 4 third");
        check(GBoyLinkSession.mirrorSlotFor(2, 4, 0) == 1, "slot 2 device mirrors 1 first");
        check(GBoyLinkSession.mirrorSlotFor(2, 4, 1) == 3, "slot 2 device mirrors 3 second");
        check(GBoyLinkSession.mirrorSlotFor(2, 4, 2) == 4, "slot 2 device mirrors 4 third");
        check(GBoyLinkSession.mirrorSlotFor(3, 4, 0) == 1, "slot 3 device mirrors 1 first");
        check(GBoyLinkSession.mirrorSlotFor(3, 4, 1) == 2, "slot 3 device mirrors 2 second");
        check(GBoyLinkSession.mirrorSlotFor(3, 4, 2) == 4, "slot 3 device mirrors 4 third");
        check(GBoyLinkSession.mirrorSlotFor(4, 4, 0) == 1, "slot 4 device mirrors 1 first");
        check(GBoyLinkSession.mirrorSlotFor(4, 4, 1) == 2, "slot 4 device mirrors 2 second");
        check(GBoyLinkSession.mirrorSlotFor(4, 4, 2) == 3, "slot 4 device mirrors 3 third");
        check(GBoyLinkSession.mirrorSlotFor(2, 3, 0) == 1, "three-player slot 2 mirrors 1");
        check(GBoyLinkSession.mirrorSlotFor(2, 3, 1) == 3, "three-player slot 2 mirrors 3");
        check(GBoyLinkSession.mirrorSlotFor(1, 2, 0) == 2, "two-player device mirrors slot 2");
        check(GBoyLinkSession.mirrorSlotFor(1, 2, 1) == 0, "out of range index rejected");
        check(GBoyLinkSession.mirrorSlotFor(3, 2, 0) == 0, "out of range slot rejected");
        for (int slot = 1; slot <= 4; ++slot) {
            boolean[] seen = new boolean[5];
            for (int index = 0; index < 3; ++index) {
                int mapped = GBoyLinkSession.mirrorSlotFor(slot, 4, index);
                check(mapped >= 1 && mapped <= 4 && mapped != slot,
                        "mirror slot stays in range and skips the local slot");
                check(!seen[mapped], "mirror slot is unique for slot " + slot);
                seen[mapped] = true;
            }
        }
    }

    private static void readyHandshake() {
        /* first 判断的反面：什么都没 ready 时，注册帧必须由自己触发一次 onReady
         * （PC GBoyLinkSession.cpp:167-172 的 first = !m_ready 为 true）。 */
        fresh();
        check(!session.isReady(), "not ready before handshake");
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_REGISTER), 2);
        check(session.isReady(), "TYPE_REGISTER completes the handshake on its own");
        check(events.readies == 1, "the first registration fires onReady exactly once");

        /* first 判断的正面：已经 ready 之后对端重发注册帧，不得再触发 onReady。 */
        fresh();
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_READY), 2);
        check(session.isReady(), "TYPE_READY completes the handshake");
        check(events.readies == 1, "ready callback fired once");
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_REGISTER), 2);
        check(session.isReady(), "a repeated registration keeps the session ready");
        check(events.readies == 1,
                "REGISTER does not re-fire onReady once ready (first guard, PC :167-172)");
    }

    private static void resetAndStateRoundTrip() {
        fresh();
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_RESET, 0), 2);
        check(events.resets == 1, "TYPE_RESET resets the consoles");
        byte[] blob = {1, 2, 3, 4, 5};
        session.sendState(blob);
        byte[] wire = sink.frames.get(sink.frames.size() - 1);
        check(GBoyFrames.getShort(wire, 4) == GBoyFrames.TYPE_STATE, "state frame type 6");
        byte[] body = new byte[wire.length - 4];
        System.arraycopy(wire, 4, body, 0, body.length);
        byte[] decoded = GBoyLinkSession.stateOf(body);
        check(java.util.Arrays.equals(decoded, blob), "state blob round trip");
        session.onFrameBody(body, 2);
        check(java.util.Arrays.equals(events.state, blob), "TYPE_STATE delivered to front end");
        check(GBoyLinkSession.stateOf(new byte[]{0, 6, 0, 0, 0, 1}).length == 0,
                "truncated state is rejected");
    }

    /**
     * T-04 / V2 · type 6 语义①：{@code stateFrame -> stateOf} 往返。
     *
     * <p>帧构造与 C++ {@code GBoyFrames::stateFrame}
     * ({@code src/platform/qt/GBoyFrames.cpp:56-63}) 字节一致：
     * {@code u32 length = 2 + (4 + blob.length)}，body = {@code u16 6 +
     * u32 blob.length + blob}。经 {@link GBoyFrames.Reader} 拆帧后，
     * {@code stateOf(body)} 必须把 blob 原样还原；会话派发也不得顺带复位
     * （AC3 的协议层一半：复位只能由 type 5 触发）。</p>
     */
    private static void typeSixStateFrameRoundTrip() {
        byte[] blob = new byte[137];
        for (int i = 0; i < blob.length; ++i) {
            blob[i] = (byte) (i * 31 + 7);
        }
        byte[] payload = new byte[4 + blob.length];
        GBoyFrames.putInt(payload, 0, blob.length);
        System.arraycopy(blob, 0, payload, 4, blob.length);
        byte[] wire = GBoyFrames.frame(GBoyFrames.TYPE_STATE, payload);

        GBoyFrames.Reader reader = new GBoyFrames.Reader();
        reader.append(wire, wire.length);
        byte[] body = reader.next();
        check(body != null, "stateFrame is one complete frame");
        check(GBoyFrames.typeOf(body) == GBoyFrames.TYPE_STATE,
                "stateFrame keeps the TYPE_STATE (6) tag");
        byte[] decoded = GBoyLinkSession.stateOf(body);
        check(decoded.length == blob.length && Arrays.equals(decoded, blob),
                "stateFrame -> stateOf round trips the save blob byte for byte");

        fresh();
        session.onWireFrame(wire, 2);
        check(Arrays.equals(events.state, blob),
                "TYPE_STATE wire frame reaches the front end unchanged");
        check(events.resets == 0,
                "loading a type 6 state never resets a console (AC3 protocol half)");
        check(events.readies == 0,
                "a type 6 state frame is not a handshake frame");
    }

    /**
     * T-04 / V2 · type 6 语义②：path A 的 SIO 中继桥「借壳」type 6，
     * body 是 20 字节裸 netLink 包，没有 u32 长度头。前 4 字节是 netLink
     * magic（远大于剩余字节数），{@code stateOf()} 必须返回空，绝不能把
     * SIO 字节当成 savestate 灌进镜像核。判据对齐
     * {@code src/platform/qt/GBoyFrames.cpp:72-84} 的
     * {@code length > payload.size() - 4}。
     */
    private static void typeSixRejectsRawSioBridgePacket() {
        byte[] raw = new byte[20];
        Arrays.fill(raw, (byte) 0x01);
        byte[] wire = GBoyFrames.frame(GBoyFrames.TYPE_STATE, raw);
        byte[] body = Arrays.copyOfRange(wire, 4, wire.length);
        check(GBoyFrames.typeOf(body) == GBoyFrames.TYPE_STATE,
                "the borrowed bridge packet is tagged 6 but is not a state frame");
        byte[] rejected = GBoyLinkSession.stateOf(body);
        check(rejected != null && rejected.length == 0,
                "a bare 20-byte netLink packet is rejected by stateOf()");

        /* 换成真实感更强的 magic 头，尾部任意字节也必须一律拒绝。 */
        byte[] magic = new byte[20];
        GBoyFrames.putInt(magic, 0, 0x4D424C31); /* "MBL1" */
        for (int i = 4; i < magic.length; ++i) {
            magic[i] = (byte) i;
        }
        byte[] magicWire = GBoyFrames.frame(GBoyFrames.TYPE_STATE, magic);
        check(GBoyLinkSession.stateOf(
                Arrays.copyOfRange(magicWire, 4, magicWire.length)).length == 0,
                "a netLink magic header is rejected regardless of the trailing bytes");

        /* 无载荷的 type 6 空体、null body 同样不是 savestate。 */
        check(GBoyLinkSession.stateOf(
                new byte[]{0, (byte) GBoyFrames.TYPE_STATE}).length == 0,
                "a bare TYPE_STATE frame with no payload is rejected");
        check(GBoyLinkSession.stateOf(null).length == 0,
                "a null body is rejected without throwing");
    }

    /**
     * T-04 / V2 · type 6 语义②续：长度头越界 / 负数 / 截断都必须拒绝，
     * 而不是按声明长度去切 payload，更不能把半截存档灌进核心。
     */
    private static void typeSixRejectsTruncatedAndIllegalLengths() {
        byte[] over = new byte[2 + 4 + 2];
        GBoyFrames.putShort(over, 0, GBoyFrames.TYPE_STATE);
        GBoyFrames.putInt(over, 2, 9999);
        over[6] = 0x11;
        over[7] = 0x22;
        check(GBoyLinkSession.stateOf(over).length == 0,
                "an over-long length header is rejected, not used to slice the payload");

        byte[] negative = new byte[2 + 4];
        GBoyFrames.putShort(negative, 0, GBoyFrames.TYPE_STATE);
        GBoyFrames.putInt(negative, 2, -1);
        check(GBoyLinkSession.stateOf(negative).length == 0,
                "a negative (0xFFFFFFFF) length header is rejected");

        byte[] shortHeader = new byte[]{0, (byte) GBoyFrames.TYPE_STATE, 0, 0, 1};
        check(GBoyLinkSession.stateOf(shortHeader).length == 0,
                "a truncated 3-byte length header is rejected");

        byte[] truncated = new byte[2 + 4 + 3];
        GBoyFrames.putShort(truncated, 0, GBoyFrames.TYPE_STATE);
        GBoyFrames.putInt(truncated, 2, 8);
        check(GBoyLinkSession.stateOf(truncated).length == 0,
                "a state body truncated behind a valid header is rejected");

        byte[] zero = new byte[2 + 4];
        GBoyFrames.putShort(zero, 0, GBoyFrames.TYPE_STATE);
        GBoyFrames.putInt(zero, 2, 0);
        check(GBoyLinkSession.stateOf(zero).length == 0,
                "a declared zero-length state decodes to an empty blob without throwing");
    }

    /**
     * T-04 · 11-15 协议号防漂移。type 3 在握手期是「就绪 + RTT」，
     * slot 3 的按键帧是自家扩展 {@code TYPE_INPUT_3}；两者一旦同号，
     * 3/4 人房间里 slot 3 的按键会被当成握手帧（或握手被当成按键），
     * 症状是「第三个玩家永远不动 / 就绪回调乱触发」。
     * 官方号 3 / 5 / 6 锁死；自家扩展号锁当前三端快照，改号须三端同步。
     */
    private static void protocolNumbersGuardAgainstReadyDrift() {
        check(GBoyFrames.TYPE_KEYS == 0 && GBoyFrames.TYPE_REGISTER == 1
                        && GBoyFrames.TYPE_NAME == 2 && GBoyFrames.TYPE_READY == 3,
                "official numbers 0/1/2/3 stay stable");
        check(GBoyFrames.TYPE_RESET == 5 && GBoyFrames.TYPE_STATE == 6
                        && GBoyFrames.TYPE_SPEED == 9,
                "official numbers 5/6/9 stay stable (only 5 resets, 6 carries state)");
        check(GBoyFrames.TYPE_READY == 3,
                "TYPE_READY stays the official handshake value 3");
        check(GBoyFrames.TYPE_INPUT_2 == 11 && GBoyFrames.TYPE_INPUT_4 == 12
                        && GBoyFrames.TYPE_RESET_LEGACY == 13
                        && GBoyFrames.TYPE_KEYS_LOCAL == 14
                        && GBoyFrames.TYPE_COUNTER == 15
                        && GBoyFrames.TYPE_EVENT == 16
                        && GBoyFrames.TYPE_INPUT_3 == 17
                        && GBoyFrames.TYPE_RECONNECT == 100,
                "private extension numbers 11/12/13/14/15/16/17/100 stay stable");
        check(GBoyFrames.TYPE_INPUT_3 >= 11
                        && GBoyFrames.TYPE_INPUT_3 != GBoyFrames.TYPE_READY
                        && GBoyFrames.TYPE_INPUT_3 != GBoyFrames.TYPE_INPUT_2
                        && GBoyFrames.TYPE_INPUT_3 != GBoyFrames.TYPE_INPUT_4,
                "slot-3 keys never collide with the READY handshake or slots 2/4");

        /* 行为断言：INPUT_3 落 slot 3 且不触发握手；READY 触发握手且不落键。
         * 注意 pre-ready 门（PC :117）在握手之前会先挡掉这条键位帧，所以先断言
         * 「未握手时它既不落键、也不被当成握手帧」，建好 ready 再断言路由。 */
        Sink s = new Sink();
        Recorder e = new Recorder();
        GBoyLinkSession four = new GBoyLinkSession(s, e, 1, 4);
        four.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_INPUT_3, 0x3C), 3);
        check(!four.isReady() && e.readies == 0,
                "a slot-3 key frame never completes the READY handshake");
        check(four.keysForSlot(3) == 0,
                "a pre-ready slot-3 key frame is dropped (same pre-ready gate as type 0)");
        check(keysAreZero(four, 2, 4), "a dropped pre-ready slot-3 frame touches no slot");

        four.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_READY, 123), 2);
        check(four.isReady() && e.readies == 1,
                "TYPE_READY is the handshake frame (completes it exactly once)");

        four.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_INPUT_3, 0x3C), 3);
        check(four.keysForSlot(3) == 0x3C,
                "TYPE_INPUT_3 is the slot-3 key frame (routes the mask to slot 3)");
        check(keysAreZero(four, 2, 4), "TYPE_INPUT_3 touches no other slot");

        four.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_READY, 123), 2);
        check(e.readies == 1, "a repeated TYPE_READY never re-fires onReady");
        check(four.keysForSlot(3) == 0x3C,
                "the READY frame leaves the held slot-3 key mask untouched");
    }

    private static boolean keysAreZero(GBoyLinkSession target, int... slots) {
        for (int slot : slots) {
            if (target.keysForSlot(slot) != 0) {
                return false;
            }
        }
        return true;
    }

    private static void counterAndSpeed() {
        fresh();
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_COUNTER, 77), 2);
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_SPEED, 59), 2);
        check(session.remoteCounter() == 77, "counter recorded");
        check(session.remoteSpeed() == 59, "peer speed multiplier recorded");
        session.sendSpeed(2);
        byte[] wire = sink.frames.get(sink.frames.size() - 1);
        check(GBoyFrames.getShort(wire, 4) == GBoyFrames.TYPE_SPEED, "speed frame type 9");
    }

    /** 旧用例断言 5 帧队列 + 丢最老；新语义下 10 帧连发只留最后一帧。 */
    private static void latestMaskWinsWithoutQueueing() {
        fresh();
        session.onLocalFrame(0, 0);
        peerReady(session);
        for (int i = 1; i <= 10; ++i) {
            session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, i), 2);
        }
        check(session.keysForSlot(2) == 10, "newest mask overwrites all older masks");
        check(session.backlog(2) == 0, "no pending queue in latest-wins mode");
        check(session.droppedFrames() == 0, "nothing is dropped when there is no queue");
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, 0x77), 2);
        check(session.keysForSlot(2) == 0x77, "a later frame replaces the held mask");
        /* 11-13 修的真实缺陷：2 帧短按会被 12Hz 采样整块吞掉。按下与松开
         * 各来一帧，最新即生效保证两帧都不丢。 */
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, 0x01), 2);
        check(session.keysForSlot(2) == 0x01, "a 1-frame press applies immediately");
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, 0), 2);
        check(session.keysForSlot(2) == 0, "the matching release applies immediately too");
    }

    /** 官方 type 9：{@code 1e9/(speed*60)}，-1 = 0.5x；非法值返回 0（回落原节拍）。 */
    private static void speedPaceTable() {
        check(GBoyLinkSession.paceNanosForSpeed(1) == 16_666_666L, "1x -> 16.7ms");
        check(GBoyLinkSession.paceNanosForSpeed(-1) == 33_333_333L, "0.5x -> 33.3ms");
        check(GBoyLinkSession.paceNanosForSpeed(2) == 8_333_333L, "2x -> 8.3ms");
        check(GBoyLinkSession.paceNanosForSpeed(4) == 4_166_666L, "4x -> 4.2ms");
        check(GBoyLinkSession.paceNanosForSpeed(0) == 0L, "unset/invalid -> local pace");
        check(GBoyLinkSession.paceNanosForSpeed(3) == 0L, "3 is not an official speed");
    }

    private static void registrationAndSocketHandshake() {
        fresh();
        session.sendRegistration(3);
        byte[] reg = sink.frames.get(sink.frames.size() - 1);
        check(reg.length == 16, "cloud registration frame is 16 bytes");
        check(GBoyFrames.getShort(reg, 4) == GBoyFrames.TYPE_REGISTER, "registration type 1");
        int mark = sink.frames.size();
        session.sendSocketHandshake();
        check(sink.frames.size() == mark + 2,
                "socket handshake sends type 1 + type 3 when no identity is set");
        byte[] hs = sink.frames.get(mark);
        check(hs.length == 10 && GBoyFrames.getInt(hs, 6) == 6,
                "socket handshake is type 1 with int 6");
        byte[] ready = sink.frames.get(mark + 1);
        check(ready.length == 10
                        && GBoyFrames.getShort(ready, 4) == GBoyFrames.TYPE_READY
                        && GBoyFrames.getInt(ready, 6) == 0,
                "third handshake frame is the 10-byte type 3 (ARc23Z(3, 4))");
        session.sendReset();
        byte[] rst = sink.frames.get(sink.frames.size() - 1);
        check(GBoyFrames.getShort(rst, 4) == GBoyFrames.TYPE_RESET, "reset frame type 5");
    }

    /**
     * The frame splitter must accept bodies well beyond 64 KiB: a GBA
     * save-state is hundreds of KiB, and rejecting the frame used to wipe the
     * receive buffer and misparse everything that followed.
     */
    private static void readerAcceptsLargeStateFrames() {
        byte[] blob = new byte[256 * 1024];
        for (int i = 0; i < blob.length; ++i) {
            blob[i] = (byte) (i * 17 + 3);
        }
        byte[] payload = new byte[4 + blob.length];
        GBoyFrames.putInt(payload, 0, blob.length);
        System.arraycopy(blob, 0, payload, 4, blob.length);
        byte[] wire = GBoyFrames.frame(GBoyFrames.TYPE_STATE, payload);

        GBoyFrames.Reader reader = new GBoyFrames.Reader();
        byte[] body = null;
        for (int off = 0; off < wire.length;) {
            int n = Math.min(2048, wire.length - off);
            byte[] chunk = Arrays.copyOfRange(wire, off, off + n);
            reader.append(chunk, n);
            off += n;
            byte[] candidate = reader.next();
            if (candidate != null) {
                body = candidate;
            }
        }
        check(body != null, "reader emits a frame larger than 64 KiB");
        check(GBoyFrames.typeOf(body) == GBoyFrames.TYPE_STATE,
                "large frame keeps its TYPE_STATE tag");
        check(Arrays.equals(GBoyLinkSession.stateOf(body), blob),
                "large save-state payload decodes byte for byte");

        byte[] small = GBoyFrames.frame(GBoyFrames.TYPE_SPEED, 2);
        reader.append(small, small.length);
        byte[] next = reader.next();
        check(next != null && GBoyFrames.typeOf(next) == GBoyFrames.TYPE_SPEED
                        && GBoyFrames.intOf(next) == 2,
                "stream stays aligned after a large state frame");
    }

    private static void rejectsBadConfiguration() {
        Sink s = new Sink();
        Recorder e = new Recorder();
        boolean ok = false;
        try {
            new GBoyLinkSession(s, e, 5, 2);
        } catch (IllegalArgumentException expected) {
            ok = true;
        }
        check(ok, "invalid slot rejected");
        ok = false;
        try {
            new GBoyLinkSession(s, e, 1, 5);
        } catch (IllegalArgumentException expected) {
            ok = true;
        }
        check(ok, "player count above four rejected");
        check(session.keysForSlot(9) == 0 && session.backlog(0) == 0,
                "out of range slots are harmless");
        session.onFrameBody(null, 2);
        session.onFrameBody(new byte[]{1}, 2);
        check(true, "malformed bodies ignored");
    }

    private static void check(boolean ok, String message) {
        if (!ok) {
            throw new AssertionError(message);
        }
    }
}
