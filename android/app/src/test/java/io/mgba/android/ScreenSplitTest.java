/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

/**
 * Host-side checks for the portrait two-screen split: the game must stay on
 * the upper screen, the keys must fill the lower one, and the menu handle must
 * never float over the game.
 */
public final class ScreenSplitTest {
    public static void main(String[] args) {
        halves();
        gameCenteredOnUpperScreen();
        oversizedGameClamped();
        keysUnderTheGame();
        handleHugsTheSplit();
        handleClampedInside();
        handleCenteredOnTheLowerScreen();
        System.out.println("ScreenSplitTest ok");
    }

    private static void halves() {
        check(ScreenSplit.half(2000) == 1000, "even split");
        check(ScreenSplit.half(1001) == 500, "odd split floors");
        int[] lower = ScreenSplit.bottomHalf(1000, 1001);
        check(lower[0] == 0 && lower[2] == 1000, "lower screen spans the width");
        check(lower[1] == 500 && lower[3] == 1001, "lower screen starts at the split and reaches the bottom");
    }

    private static void gameCenteredOnUpperScreen() {
        // A 240x160 game on a 1080x2200 stage: half = 1100, so the game is
        // centered with 190 pixels of bezel above and below.
        int[] box = ScreenSplit.centerInTopHalf(1080, 2200, 1080, 720);
        check(box[0] == 0 && box[2] == 1080, "game uses the full width");
        check(box[3] <= 1100, "game stays on the upper screen");
        check(box[1] == 190 && box[3] == 910, "game centered on the upper screen");
        int[] odd = ScreenSplit.centerInTopHalf(1000, 1001, 500, 240);
        check(odd[1] == 130, "odd heights center on the floored half");
    }

    private static void oversizedGameClamped() {
        int[] box = ScreenSplit.centerInTopHalf(1000, 2000, 1000, 1500);
        check(box[1] == 0 && box[3] == 1000, "oversized game is clamped to the upper screen");
    }

    private static void keysUnderTheGame() {
        int[] game = ScreenSplit.centerInTopHalf(1080, 2400, 1080, 720);
        int[] keys = ScreenSplit.bottomHalf(1080, 2400);
        check(keys[1] == 1200, "keys start exactly at the split");
        check(game[3] <= keys[1], "keys never cover the game");
    }

    private static void handleHugsTheSplit() {
        int[] handle = ScreenSplit.offsetFromSplit(1080, 2400, 700, 850, 200, 60);
        check(handle[0] == 700 && handle[2] == 900, "handle keeps its left margin");
        check(handle[1] == 2050 && handle[3] == 2110, "handle is offset below the split");
    }

    private static void handleClampedInside() {
        check(ScreenSplit.offsetFromSplit(1080, 2400, 900, -400, 200, 60)[1] == 1200,
                "handle never floats over the game");
        check(ScreenSplit.offsetFromSplit(1080, 2400, 900, 5000, 200, 60)[1] == 2400 - 60,
                "handle stays on screen");
        check(ScreenSplit.offsetFromSplit(1080, 2400, 5000, 0, 200, 60)[0] == 1080 - 200,
                "handle stays within the width");
        check(ScreenSplit.offsetFromSplit(1080, 2400, -300, 0, 200, 60)[0] == 0,
                "negative margin clamps to the left edge");
        // A margin left over from landscape is wider than the portrait stage;
        // it must not be able to grow the handle or push it off the screen.
        check(ScreenSplit.offsetFromSplit(540, 1200, 714, 12, 98, 42)[0] == 540 - 98,
                "stale landscape margin is clamped inside the stage");
    }

    private static void handleCenteredOnTheLowerScreen() {
        // Portrait: the stage centers the handle on the top edge of the lower
        // screen, a few pixels below the hinge (540x1200 test device).
        int[] handle = ScreenSplit.offsetFromSplit(540, 1200, (540 - 98) / 2, 12, 98, 42);
        check(handle[0] == 221 && handle[2] == 319, "handle is centered on the lower screen");
        check(handle[1] == 612 && handle[3] == 654, "handle sits just below the hinge");
        check(handle[1] >= ScreenSplit.bottomHalf(540, 1200)[1], "handle stays on the lower screen");
    }

    private static void check(boolean condition, String label) {
        if (!condition) {
            throw new AssertionError(label);
        }
    }
}
