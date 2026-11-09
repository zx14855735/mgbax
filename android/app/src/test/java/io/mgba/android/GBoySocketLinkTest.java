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
