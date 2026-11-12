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
        remoteKeysSampledEveryFifthFrame();
        missingKeyFramesHoldLastMask();
        slotTypedFrames();
        multiPlayerSendsSlotTypedFrames();
        multiPlayerRoutesKeysToOwnSlots();
        twoPlayerKeepsTypeKeys();
        mirrorSlotMapping();
        readyHandshake();
        resetAndStateRoundTrip();
        readerAcceptsLargeStateFrames();
        counterAndFps();
        backPressureDropsOldest();
        registrationAndSocketHandshake();
        rejectsBadConfiguration();
        System.out.println("GBoyLinkSessionTest ok");
    }

    private static void fresh() {
        sink = new Sink();
        events = new Recorder();
        session = new GBoyLinkSession(sink, events, 1, 2);
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

    private static void remoteKeysSampledEveryFifthFrame() {
        fresh();
        session.onLocalFrame(0, 0);
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, 0xAA), 2);
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, 0xBB), 2);
        check(session.keysForSlot(2) == 0, "received keys wait for the sample point");
        for (int f = 1; f <= 5; ++f) {
            session.onLocalFrame(f, 0);
        }
        check(session.keysForSlot(2) == 0xAA, "first queued mask applied on frame 5");
        for (int f = 6; f < 10; ++f) {
            session.onLocalFrame(f, 0);
        }
        check(session.keysForSlot(2) == 0xAA, "mask held between sample points");
        session.onLocalFrame(10, 0);
        check(session.keysForSlot(2) == 0xBB, "second queued mask applied on frame 10");
    }

    private static void missingKeyFramesHoldLastMask() {
        fresh();
        session.onLocalFrame(0, 0);
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

    private static void slotTypedFrames() {
        Sink s = new Sink();
        Recorder e = new Recorder();
        GBoyLinkSession four = new GBoyLinkSession(s, e, 1, 4);
        four.onLocalFrame(0, 0);
        four.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_INPUT_2, 0x21), 2);
        four.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_READY, 0x31), 3);
        four.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_INPUT_4, 0x41), 4);
        for (int f = 1; f <= 5; ++f) {
            four.onLocalFrame(f, 0);
        }
        check(four.keysForSlot(2) == 0x21, "type 2 targets slot 2");
        check(four.keysForSlot(3) == 0x31, "type 3 targets slot 3 while running");
        check(four.keysForSlot(4) == 0x41, "type 4 targets slot 4");
    }

    /** 3/4 人时每台设备必须发自带槽位的键位帧，否则对端无法区分来源。 */
    private static void multiPlayerSendsSlotTypedFrames() {
        int[] expected = {GBoyFrames.TYPE_KEYS, GBoyFrames.TYPE_INPUT_2,
                GBoyFrames.TYPE_READY, GBoyFrames.TYPE_INPUT_4};
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
                        "slot 3 READY carries an int so it is not a handshake");
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
            check(recorders[receiver].readies == 0,
                    "slot 3 key frames never fire the READY handshake");
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
        fresh();
        check(!session.isReady(), "not ready before handshake");
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_READY), 2);
        check(session.isReady(), "TYPE_READY completes the handshake");
        check(events.readies == 1, "ready callback fired once");
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_REGISTER), 2);
        check(events.readies == 2, "registration also completes the handshake");
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

    private static void counterAndFps() {
        fresh();
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_COUNTER, 77), 2);
        session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_FPS, 59), 2);
        check(session.remoteCounter() == 77, "counter recorded");
        check(session.remoteFps() == 59, "peer fps recorded");
        session.sendFps(60);
        byte[] wire = sink.frames.get(sink.frames.size() - 1);
        check(GBoyFrames.getShort(wire, 4) == GBoyFrames.TYPE_FPS, "fps frame type 9");
    }

    private static void backPressureDropsOldest() {
        fresh();
        session.onLocalFrame(0, 0);
        for (int i = 1; i <= 10; ++i) {
            session.onWireFrame(GBoyFrames.frame(GBoyFrames.TYPE_KEYS, i), 2);
        }
        check(session.backlog(2) == GBoyLinkSession.BACKLOG_LIMIT,
                "queue capped at the back-pressure limit");
        check(session.droppedFrames() == 10 - GBoyLinkSession.BACKLOG_LIMIT,
                "oldest frames dropped");
        for (int f = 1; f <= 5; ++f) {
            session.onLocalFrame(f, 0);
        }
        check(session.keysForSlot(2) == 9, "newest surviving mask applied first");
    }

    private static void registrationAndSocketHandshake() {
        fresh();
        session.sendRegistration(3);
        byte[] reg = sink.frames.get(sink.frames.size() - 1);
        check(reg.length == 16, "cloud registration frame is 16 bytes");
        check(GBoyFrames.getShort(reg, 4) == GBoyFrames.TYPE_REGISTER, "registration type 1");
        session.sendSocketHandshake();
        byte[] hs = sink.frames.get(sink.frames.size() - 1);
        check(hs.length == 10 && GBoyFrames.getInt(hs, 6) == 6,
                "socket handshake is type 1 with int 6");
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

        byte[] small = GBoyFrames.frame(GBoyFrames.TYPE_FPS, 47);
        reader.append(small, small.length);
        byte[] next = reader.next();
        check(next != null && GBoyFrames.typeOf(next) == GBoyFrames.TYPE_FPS
                        && GBoyFrames.intOf(next) == 47,
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
