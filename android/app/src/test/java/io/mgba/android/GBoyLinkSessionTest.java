/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.util.ArrayList;
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
        readyHandshake();
        resetAndStateRoundTrip();
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
