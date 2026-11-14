package com.sigmob.sdk.downloader;

import android.os.SystemClock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    long f13429a;
    long b;
    long c;
    long d;
    long e;
    long f;

    private static String a(long j, boolean z) {
        return com.sigmob.sdk.downloader.core.c.a(j, z) + "/s";
    }

    public long b() {
        return SystemClock.uptimeMillis();
    }

    public synchronized void c() {
        long b = b();
        long j = this.b;
        long max = Math.max(1L, b - this.f13429a);
        this.b = 0L;
        this.f13429a = b;
        this.c = (long) ((j / max) * 1000.0f);
    }

    public long d() {
        c();
        return this.c;
    }

    public synchronized long e() {
        long b = b() - this.f13429a;
        if (b < 1000) {
            long j = this.c;
            if (j != 0) {
                return j;
            }
        }
        if (this.c == 0 && b < 500) {
            return 0L;
        }
        return d();
    }

    public synchronized long f() {
        long j;
        try {
            j = this.e;
            if (j == 0) {
                j = b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (long) ((this.f / Math.max(1L, j - this.d)) * 1000.0f);
    }

    public synchronized void g() {
        this.e = b();
    }

    public String h() {
        return m();
    }

    public String i() {
        return a(e(), true);
    }

    public String j() {
        return a(this.c, true);
    }

    public synchronized long k() {
        return b() - this.f13429a;
    }

    public String l() {
        return a(d(), false);
    }

    public String m() {
        return a(d(), true);
    }

    public String n() {
        return o();
    }

    public String o() {
        return a(f(), true);
    }

    public synchronized void a() {
        this.f13429a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
    }

    public synchronized void a(long j) {
        try {
            if (this.f13429a == 0) {
                long b = b();
                this.f13429a = b;
                this.d = b;
            }
            this.b += j;
            this.f += j;
        } catch (Throwable th) {
            throw th;
        }
    }
}
