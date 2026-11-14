package com.czhj.sdk.common.mta;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class PointEntityCrash extends PointEntitySuper {

    /* renamed from: a, reason: collision with root package name */
    private String f10563a;
    private long b = 0;

    public String getCrashMessage() {
        return this.f10563a;
    }

    public long getCrashTime() {
        return this.b;
    }

    public void setCrashMessage(String str) {
        this.f10563a = str;
    }

    public void setCrashTime(long j) {
        this.b = j;
    }
}
