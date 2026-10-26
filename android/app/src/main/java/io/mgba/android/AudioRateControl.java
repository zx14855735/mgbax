/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

/**
 * Dynamic rate control for the audio resampler.
 *
 * <p>The emulator produces samples against its own clock estimate while the
 * audio device consumes them against its crystal, so the two drift apart. This
 * class watches how many frames are queued in the playback buffer and returns a
 * tiny ratio adjustment (positive drains the queue, negative fills it) that the
 * resampler applies. Keeping the queue near its target avoids both underruns
 * (gaps) and overflow (dropped samples), at the cost of a pitch shift of at
 * most a fraction of a percent.
 */
final class AudioRateControl {
    /** Largest ratio adjustment; also covers a front end that cannot pace at full speed.
     * The fast loops (queue drift and pace estimate) only partly overlap, so the cap
     * needs headroom over the pace estimate's residual error: too small a cap lets
     * the queue swing to its edges (gaps below, shed samples above). */
    static final float MAX_DRIFT = 0.035f;
    /** Ratio adjustment per unit of normalized queue error. */
    private static final float GAIN = 0.08f;
    /** Smoothing of the queue measurement, which the device reports in coarse steps. */
    private static final float SMOOTHING = 0.12f;

    private final int trackFrames;
    private final int targetFrames;
    private float smoothedError;

    AudioRateControl(int trackFrames, int targetFrames) {
        this.trackFrames = Math.max(1, trackFrames);
        this.targetFrames = Math.max(0, Math.min(targetFrames, trackFrames));
    }

    /**
     * @param levelFrames queued playback frames (device buffer plus any local backlog)
     * @param steady false while the pipeline is still filling up, where the measurement
     *               is followed directly instead of being averaged
     * @return ratio adjustment for the resampler input rate
     */
    float drift(int levelFrames, boolean steady) {
        float error = (levelFrames - targetFrames) / (float) trackFrames;
        if (steady) {
            smoothedError += (error - smoothedError) * SMOOTHING;
        } else {
            smoothedError = error;
        }
        return clamp(smoothedError * GAIN, -MAX_DRIFT, MAX_DRIFT);
    }

    private static float clamp(float value, float min, float max) {
        return value < min ? min : (value > max ? max : value);
    }

    /** Forgets the smoothed queue measurement so a fresh speed change re-locks
     * without being pulled by the previous steady-state estimate. */
    void reset() {
        smoothedError = 0f;
    }
}
