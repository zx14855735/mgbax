package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.AlLFFp;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class d {
    private final AlLFFp aam;
    private final long aan = System.currentTimeMillis();

    public d(AlLFFp alLFFp) {
        this.aam = alLFFp;
    }

    public final String toString() {
        return "LifecycleStamp{mEvent=" + this.aam + ", mEventTimestamp=" + this.aan + '}';
    }

    public final AlLFFp tv() {
        return this.aam;
    }

    public final long tw() {
        return this.aan;
    }
}
