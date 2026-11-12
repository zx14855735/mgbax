/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

public final class AudioRateControlTest {
    private static final int TRACK = 2048;
    private static final int TARGET = TRACK / 2;

    public static void main(String[] args) {
        zeroAtTarget();
        positiveAboveTarget();
        negativeBelowTarget();
        clamped();
        smoothingConverges();
        fillingSkipsSmoothing();
        resetForgetsHistory();
        System.out.println("AudioRateControlTest ok");
    }

    private static void zeroAtTarget() {
        AudioRateControl control = new AudioRateControl(TRACK, TARGET);
        check(control.drift(TARGET, true) == 0f, "no correction at the target level");
    }

    private static void positiveAboveTarget() {
        // Above target means the queue is too full: the resampler must speed up
        // its input consumption so the device catches up.
        AudioRateControl control = new AudioRateControl(TRACK, TARGET);
        float drift = control.drift(TARGET + TRACK / 4, true);
        check(drift > 0f, "above target drains the queue");
    }

    private static void negativeBelowTarget() {
        AudioRateControl control = new AudioRateControl(TRACK, TARGET);
        float drift = control.drift(0, true);
        check(drift < 0f, "below target fills the queue");
    }

    private static void clamped() {
        AudioRateControl control = new AudioRateControl(TRACK, TARGET);
        check(control.drift(TARGET + TRACK, false) == AudioRateControl.MAX_DRIFT, "clamped high");
        check(control.drift(-TRACK, false) == -AudioRateControl.MAX_DRIFT, "clamped low");
    }

    private static void smoothingConverges() {
        AudioRateControl control = new AudioRateControl(TRACK, TARGET);
        int level = TARGET + TRACK / 8;
        control.drift(level, true);
        float first = control.drift(level, true);
        float later = first;
        for (int i = 0; i < 200; i++) {
            later = control.drift(level, true);
        }
        check(later > first, "steady measurement converges toward the error");
        check(later > 0f && later < AudioRateControl.MAX_DRIFT, "converged value stays gentle");
    }

    private static void fillingSkipsSmoothing() {
        // While the pipeline is still filling the level moves fast; tracking it
        // directly avoids lagging behind.
        AudioRateControl control = new AudioRateControl(TRACK, TARGET);
        float drift = control.drift(0, false);
        check(drift == -AudioRateControl.MAX_DRIFT, "fill-up uses the full correction");
    }

    private static void resetForgetsHistory() {
        // Task 3 fix: reset() must clear the smoothed estimate so a fresh speed
        // change re-locks without being pulled by the previous steady state.
        AudioRateControl control = new AudioRateControl(TRACK, TARGET);
        int level = TARGET + TRACK / 4;
        float converged = 0f;
        for (int i = 0; i < 200; i++) {
            converged = control.drift(level, true);
        }
        check(converged > 0f, "steady state corrected the queue");
        control.reset();
        float firstAfter = control.drift(level, true);
        check(firstAfter < converged, "reset drops the smoothed estimate back to the raw error");
        check(firstAfter > 0f, "reset still corrects in the same direction");
    }

    private static void check(boolean condition, String label) {
        if (!condition) {
            throw new AssertionError(label);
        }
    }
}
