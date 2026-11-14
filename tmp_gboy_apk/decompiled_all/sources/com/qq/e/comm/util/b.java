package com.qq.e.comm.util;

import android.os.SystemClock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b {

    /* renamed from: A2egSU, reason: collision with root package name */
    public long f12983A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final StringBuilder f12984A4TApA = new StringBuilder();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public long f12985A5SV6n;

    public void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f12983A2egSU;
        this.f12985A5SV6n += elapsedRealtime;
        StringBuilder sb = this.f12984A4TApA;
        sb.append(elapsedRealtime);
        sb.append(",");
    }

    public void b() {
        a();
        c();
    }

    public void c() {
        this.f12983A2egSU = SystemClock.elapsedRealtime();
    }

    public String toString() {
        StringBuilder sb = this.f12984A4TApA;
        int length = sb.length();
        if (length <= 0) {
            return "";
        }
        StringBuilder deleteCharAt = sb.deleteCharAt(length - 1);
        deleteCharAt.append(":");
        deleteCharAt.append(this.f12985A5SV6n);
        return deleteCharAt.toString();
    }
}
