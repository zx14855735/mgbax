/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

/**
 * Pure geometry of the portrait two-screen (DS-like) stage: the game runs on
 * the upper screen, the on-screen keys and menu live on the lower one. Kept
 * free of Android types so the split can be unit tested on the host.
 *
 * <p>Every method returns {@code {left, top, right, bottom}} in the stage's
 * coordinates.
 */
final class ScreenSplit {
    private ScreenSplit() {
    }

    /** Boundary between the upper (game) and lower (keys) screens. */
    static int half(int h) {
        return h / 2;
    }

    /**
     * A widget centered on the upper screen. Sizes larger than the screen are
     * clamped so the upper screen never spills into the lower one.
     */
    static int[] centerInTopHalf(int w, int h, int cw, int ch) {
        int half = half(h);
        int width = Math.min(Math.max(0, cw), Math.max(0, w));
        int height = Math.min(Math.max(0, ch), Math.max(0, half));
        int left = (w - width) / 2;
        int top = (half - height) / 2;
        return new int[]{left, top, left + width, top + height};
    }

    /** The whole lower screen; keys lay themselves out inside it. */
    static int[] bottomHalf(int w, int h) {
        int half = half(h);
        return new int[]{0, half, w, h};
    }

    /**
     * A widget anchored by margins against the split, such as the menu handle
     * next to START. It is clamped inside the lower screen.
     */
    static int[] offsetFromSplit(int w, int h, int leftMargin, int topMargin, int cw, int ch) {
        int half = half(h);
        int width = Math.max(0, cw);
        int height = Math.max(0, ch);
        int left = Math.min(Math.max(0, leftMargin), Math.max(0, w - width));
        int top = Math.min(Math.max(half, half + topMargin), Math.max(half, h - height));
        return new int[]{left, top, left + width, top + height};
    }
}
