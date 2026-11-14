package com.kwad.sdk.utils;

import android.os.SystemClock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bv {
    private long bgB;
    private long bgC;
    private boolean bgD;

    public bv() {
        reset();
    }

    private void reset() {
        this.bgB = 0L;
        this.bgC = -1L;
    }

    public final void Ud() {
        if (this.bgD && this.bgC < 0) {
            this.bgC = SystemClock.elapsedRealtime();
        }
    }

    public final void Ue() {
        if (this.bgD && this.bgC > 0) {
            this.bgB = (SystemClock.elapsedRealtime() - this.bgC) + this.bgB;
            this.bgC = -1L;
        }
    }

    public final long Uf() {
        if (!this.bgD) {
            return 0L;
        }
        this.bgD = false;
        if (this.bgC > 0) {
            this.bgB = (SystemClock.elapsedRealtime() - this.bgC) + this.bgB;
            this.bgC = -1L;
        }
        return this.bgB;
    }

    public final long getTime() {
        if (this.bgC <= 0) {
            return this.bgB;
        }
        return (SystemClock.elapsedRealtime() + this.bgB) - this.bgC;
    }

    public final void startTiming() {
        reset();
        this.bgD = true;
        this.bgC = SystemClock.elapsedRealtime();
    }
}
