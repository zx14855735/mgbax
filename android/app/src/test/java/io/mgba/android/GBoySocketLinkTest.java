/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Plain JVM test: two links handshake and exchange frames over loopback TCP. */
public final class GBoySocketLinkTest {

    private static final class Recorder implements GBoyLinkSession.Events {
        volatile int readies;
        volatile int resets;
        volatile byte[] state;
        volatile Runnable onReadyAction;
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
            Runnable action = onReadyAction;
            if (action != null) {
                action.run();
            }
        }

        @Override
        public void onStatus(String text) {
            status.add(text);
        }
    }

    private static GBoySocketLink host;
    private static GBoySocketLink guest;
    private static Recorder hostEvents;
    private static Recorder guestEvents;

    public static void main(String[] args) throws Exception {
        try {
            handshakeOverLoopback();
            keyMaskReachesTheOtherConsole();
            continuousFramesReachPeer();
            stateAndResetRoundTrip();
            largeStateFrameRoundTrip();
            stateSentAfterHandshake();
            slotTypedKeysOverLoopback();
            closeReleasesBothSides();
            System.out.println("GBoySocketLinkTest ok");
        } finally {
            if (host != null) {
                host.close();
            }
            if (guest != null) {
                guest.close();
            }
        }
    }

    private static void handshakeOverLoopback() throws Exception {
        hostEvents = new Recorder();
        guestEvents = new Recorder();
        host = new GBoySocketLink(1, 2, hostEvents);
        int port = host.startHost(0);
        check(port > 0, "OS assigned a listening port");
        guest = new GBoySocketLink(2, 2, guestEvents);
        guest.startJoin("127.0.0.1", port);
        check(waitFor(() -> host.isReady() && guest.isReady(), 3000),
                "both sides complete the type-1/int-6 handshake");
        check(host.isConnected() && guest.isConnected(), "sockets connected");
        check(hostEvents.readies >= 1 && guestEvents.readies >= 1,
                "session ready callback fired on both sides");
    }

    private static void keyMaskReachesTheOtherConsole() {
        // Both sessions sample/broadcast immediately on frame 0, then every
        // fifth frame. Consume the guest's frame 0 before the host sends, so
        // the next sample point is exactly frame 5.
        guest.session().onLocalFrame(0, 0);
        host.session().onLocalFrame(0, 0xAB);
        check(waitFor(() -> guest.session().backlog(1) > 0, 3000),
                "key frame arrives over the socket");
        for (int f = 1; f <= 5; ++f) {
            guest.session().onLocalFrame(f, 0);
        }
        check(guest.session().keysForSlot(1) == 0xAB,
                "slot 1 receives the host's key mask at the 12 Hz sample point");
    }

    private static void continuousFramesReachPeer() {
        long receivedBefore = guest.receivedFrames();
        int sentBefore = host.session().sentFrames();
        // The emulation loop calls onLocalFrame once per rendered frame; 20
        // driven frames must produce exactly four 12 Hz broadcasts, and those
        // frames must actually cross the TCP link to the peer.
        for (int f = 20; f < 40; ++f) {
            host.session().onLocalFrame(f, 0x33);
        }
        check(host.session().sentFrames() - sentBefore == 4,
                "20 driven frames produce exactly 4 key broadcasts");
        check(waitFor(() -> guest.receivedFrames() - receivedBefore >= 4, 3000),
                "the 12 Hz key frames arrive over the TCP link");
    }

    private static void stateAndResetRoundTrip() {
        byte[] blob = {9, 8, 7, 6, 5, 4};
        host.session().sendState(blob);
        check(waitFor(() -> guestEvents.state != null, 3000),
                "TYPE_STATE arrives on the guest");
        check(Arrays.equals(guestEvents.state, blob), "save-state blob is intact");
        host.session().sendReset();
        check(waitFor(() -> guestEvents.resets == 1, 3000),
                "TYPE_RESET arrives on the guest");
        host.session().sendFps(59);
        check(waitFor(() -> guest.session().remoteFps() == 59, 3000),
                "TYPE_FPS is recorded by the peer session");
    }

    /**
     * A real GBA save-state is hundreds of KiB. The old 65535 cap in the frame
     * splitter rejected such frames and reset the stream, so TYPE_STATE never
     * arrived and every following byte was parsed as a bogus frame header.
     */
    private static void largeStateFrameRoundTrip() {
        byte[] blob = new byte[256 * 1024];
        for (int i = 0; i < blob.length; ++i) {
            blob[i] = (byte) (i * 31 + 7);
        }
        guestEvents.state = null;
        host.session().sendState(blob);
        check(waitFor(() -> guestEvents.state != null
                        && guestEvents.state.length == blob.length, 6000),
                "256 KiB TYPE_STATE crosses the TCP link intact");
        check(Arrays.equals(guestEvents.state, blob),
                "large save-state payload is byte-for-byte identical");
        // The stream must still be aligned after the large frame: a small
        // frame sent right afterwards has to decode normally.
        host.session().sendFps(61);
        check(waitFor(() -> guest.session().remoteFps() == 61, 3000),
                "stream stays aligned after a large state frame");
    }

    /**
     * The host sends its initial save state from the ready callback, not from
     * start(). This pins the official ordering: handshake first, then sync.
     */
    private static void stateSentAfterHandshake() throws Exception {
        Recorder hEvents = new Recorder();
        Recorder gEvents = new Recorder();
        GBoySocketLink h = new GBoySocketLink(1, 2, hEvents);
        final byte[] blob = {0x41, 0x42, 0x43, 0x44};
        hEvents.onReadyAction = () -> h.session().sendState(blob);
        int port = h.startHost(0);
        GBoySocketLink g = new GBoySocketLink(2, 2, gEvents);
        check(gEvents.state == null, "no state frame exists before the handshake");
        g.startJoin("127.0.0.1", port);
        check(waitFor(() -> gEvents.state != null, 3000),
                "state frame sent from onReady reaches the peer");
        check(hEvents.readies >= 1, "host reached ready before sending state");
        check(Arrays.equals(gEvents.state, blob),
                "handshake-triggered state payload is intact");
        h.close();
        g.close();
    }

    /**
     * 3/4 人会话里不同槽位的设备必须发不同 type 的键位帧，并且这些帧穿过
     * 真实 socket 后要落到对端对应的槽位。两人路径由其他用例覆盖。
     */
    private static void slotTypedKeysOverLoopback() throws Exception {
        Recorder hEvents = new Recorder();
        Recorder gEvents = new Recorder();
        GBoySocketLink h = new GBoySocketLink(1, 4, hEvents);
        int port = h.startHost(0);
        GBoySocketLink g = new GBoySocketLink(2, 4, gEvents);
        try {
            g.startJoin("127.0.0.1", port);
            check(waitFor(() -> h.isReady() && g.isReady(), 3000),
                    "4-player sessions complete the socket handshake");
            h.session().onLocalFrame(0, 0xA1);
            g.session().onLocalFrame(0, 0xB2);
            check(waitFor(() -> g.session().backlog(1) > 0
                            && h.session().backlog(2) > 0, 3000),
                    "slot-typed key frames cross the TCP link");
            for (int f = 1; f <= 5; ++f) {
                h.session().onLocalFrame(f, 0);
                g.session().onLocalFrame(f, 0);
            }
            check(g.session().keysForSlot(1) == 0xA1,
                    "slot 1 TYPE_KEYS reaches the peer's slot 1");
            check(h.session().keysForSlot(2) == 0xB2,
                    "slot 2 TYPE_INPUT_2 reaches the peer's slot 2");
        } finally {
            h.close();
            g.close();
        }
    }

    private static void closeReleasesBothSides() {
        host.close();
        guest.close();
        check(!host.isConnected() && !guest.isConnected(), "sockets closed");
        check(host.port() == -1, "listener released");
        check(host.queuedFrames() == 0 && guest.queuedFrames() == 0,
                "outbox drained");
    }

    private static boolean waitFor(BooleanSupplier condition, long timeoutMs) {
        long deadline = System.currentTimeMillis() + timeoutMs;
        while (System.currentTimeMillis() < deadline) {
            if (condition.get()) {
                return true;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return condition.get();
    }

    private interface BooleanSupplier {
        boolean get();
    }

    private static void check(boolean ok, String message) {
        if (!ok) {
            throw new AssertionError(message);
        }
    }
}
