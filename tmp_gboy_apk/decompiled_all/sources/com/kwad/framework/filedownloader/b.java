package com.kwad.framework.filedownloader;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.s;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b implements s.a, s.b {
    private long apk;
    private long apl;
    private long apm;
    private int apn;
    private int apo = 1000;
    private long mStartTime;

    @Override // com.kwad.framework.filedownloader.s.b
    public final void U(long j) {
        if (this.apo <= 0) {
            return;
        }
        if (this.apk != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.apk;
            if (uptimeMillis < this.apo && (this.apn != 0 || uptimeMillis <= 0)) {
                return;
            }
            int i = (int) ((j - this.apl) / uptimeMillis);
            this.apn = i;
            this.apn = Math.max(0, i);
        }
        this.apl = j;
        this.apk = SystemClock.uptimeMillis();
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void end(long j) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j2 = j - this.apm;
        this.apk = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis <= 0) {
            this.apn = (int) j2;
        } else {
            this.apn = (int) (j2 / uptimeMillis);
        }
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.apn;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void reset() {
        this.apn = 0;
        this.apk = 0L;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void start(long j) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.apm = j;
    }
}
