/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

public final class KeyLayoutTest {
    public static void main(String[] args) {
        dragSavesImmediately();
        dragKeepsOtherKeys();
        resetRestoresDefault();
        roundTrip();
        junkIsIgnored();
        clampCenterKeepsTheButtonOnScreen();
        scaleRoundTrip();
        scaleClamped();
        oldStringsStayCompatible();
        System.out.println("KeyLayoutTest ok");
    }

    private static void dragSavesImmediately() {
        KeyLayout layout = new KeyLayout();
        layout.place("a", 0.2f, 0.8f);
        float[] saved = layout.savedPoint("a");
        near(saved[0], 0.2f, "saved x");
        near(saved[1], 0.8f, "saved y");
        near(layout.resolved().get("a")[0], 0.2f, "resolved x");
    }

    private static void dragKeepsOtherKeys() {
        KeyLayout layout = new KeyLayout();
        layout.place("b", 0.1f, 0.2f);
        layout.place("a", 0.7f, 0.4f);
        near(layout.savedPoint("b")[0], 0.1f, "b stays put");
        near(layout.savedPoint("a")[1], 0.4f, "a saved");
        check(layout.savedPoint("dpad") == null, "dpad still default");
    }

    private static void resetRestoresDefault() {
        KeyLayout layout = new KeyLayout();
        layout.place("select", 0.4f, 0.6f);
        layout.place("start", 0.5f, 0.5f);
        layout.resetAll();
        check(layout.savedPoint("select") == null, "select cleared");
        check(layout.savedPoint("start") == null, "start cleared");
        check(layout.encode().isEmpty(), "encode is empty");
    }

    private static void roundTrip() {
        KeyLayout layout = new KeyLayout();
        layout.place("dpad", 0.15f, 0.72f);
        layout.place("r", -1f, 2f);
        KeyLayout again = KeyLayout.decode(layout.encode());
        near(again.savedPoint("dpad")[0], 0.15f, "dpad x");
        near(again.savedPoint("dpad")[1], 0.72f, "dpad y");
        near(again.savedPoint("r")[0], 0f, "r clamped low");
        near(again.savedPoint("r")[1], 1f, "r clamped high");
    }

    private static void junkIsIgnored() {
        KeyLayout layout = KeyLayout.decode("nope;a=bad;z=0.2,0.2;b=0.3,0.4");
        check(layout.savedPoint("a") == null, "bad number ignored");
        check(layout.savedPoint("z") == null, "unknown key ignored");
        near(layout.savedPoint("b")[0], 0.3f, "valid key kept");
    }

    private static void clampCenterKeepsTheButtonOnScreen() {
        near(KeyLayout.clampCenter(0f, 20f, 100f), 20f, "left edge");
        near(KeyLayout.clampCenter(99f, 20f, 100f), 80f, "right edge");
        near(KeyLayout.clampCenter(50f, 20f, 100f), 50f, "middle");
        near(KeyLayout.clampCenter(10f, 40f, 50f), 25f, "button wider than the view");
    }

    private static void scaleRoundTrip() {
        KeyLayout layout = new KeyLayout();
        layout.place("a", 0.2f, 0.8f);
        layout.setScale("a", 1.5f);
        layout.setScale("dpad", 0.8f);
        KeyLayout again = KeyLayout.decode(layout.encode());
        near(again.scaleFor("a"), 1.5f, "a scale kept");
        near(again.scaleFor("dpad"), 0.8f, "dpad scale kept");
        near(again.savedPoint("a")[0], 0.2f, "pos kept with scale");
        check(Math.abs(again.scaleFor("b") - 1f) < 0.001f, "default scale is 1");
    }

    private static void scaleClamped() {
        KeyLayout layout = new KeyLayout();
        layout.setScale("b", 10f);
        near(layout.scaleFor("b"), KeyLayout.MAX_SCALE, "scale clamped high");
        layout.setScale("b", 0.01f);
        near(layout.scaleFor("b"), KeyLayout.MIN_SCALE, "scale clamped low");
        layout.setScale("b", 1f);
        check(layout.encode().indexOf("b.s") < 0, "scale 1 not encoded");
    }

    private static void oldStringsStayCompatible() {
        KeyLayout layout = KeyLayout.decode("a=0.2000,0.8000;dpad=0.1500,0.7200");
        near(layout.savedPoint("a")[0], 0.2f, "old format kept");
        check(Math.abs(layout.scaleFor("a") - 1f) < 0.001f, "old format scale defaults");
    }

    private static void near(float actual, float expected, String label) {
        if (Math.abs(actual - expected) > 0.0001f) {
            throw new AssertionError(label + " expected " + expected + " but was " + actual);
        }
    }

    private static void check(boolean condition, String label) {
        if (!condition) {
            throw new AssertionError(label);
        }
    }
}
