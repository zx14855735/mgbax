package com.kwad.sdk.core.network.idc.a;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private final long aKp;
    private volatile boolean aKq = false;

    public a(long j, boolean z) {
        this.aKp = j;
    }

    public final boolean JD() {
        return this.aKq;
    }

    public final long JE() {
        return this.aKp;
    }

    public final a bu(boolean z) {
        this.aKq = true;
        return this;
    }
}
