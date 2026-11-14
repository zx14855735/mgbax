package com.sigmob.sdk.downloader.core.breakpoint;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final long f13345a;
    private final long b;
    private final AtomicLong c;

    public a(long j, long j2) {
        this(j, j2, 0L);
    }

    public long a() {
        return this.c.get();
    }

    public long b() {
        return this.f13345a;
    }

    public long c() {
        return this.c.get() + this.f13345a;
    }

    public long d() {
        return this.b;
    }

    public long e() {
        long j = this.b;
        if (j == -1) {
            return -1L;
        }
        return (this.f13345a + j) - 1;
    }

    public void f() {
        this.c.set(0L);
    }

    public a g() {
        return new a(this.f13345a, this.b, this.c.get());
    }

    public String toString() {
        return "[" + this.f13345a + ", " + e() + ")-current:" + this.c;
    }

    public a(long j, long j2, long j3) {
        if (j < 0 || ((j2 < 0 && j2 != -1) || j3 < 0)) {
            throw new IllegalArgumentException();
        }
        this.f13345a = j;
        this.b = j2;
        this.c = new AtomicLong(j3);
    }

    public void a(long j) {
        this.c.addAndGet(j);
    }
}
