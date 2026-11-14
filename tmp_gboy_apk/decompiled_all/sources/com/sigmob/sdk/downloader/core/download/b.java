package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.exception.i;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    com.sigmob.sdk.downloader.core.cause.b f13387a;
    private boolean b;
    private boolean c;
    private long d;
    private final com.sigmob.sdk.downloader.f e;
    private final com.sigmob.sdk.downloader.core.breakpoint.c f;

    public b(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        this.e = fVar;
        this.f = cVar;
    }

    public com.sigmob.sdk.downloader.core.cause.b a() {
        return this.f13387a;
    }

    public com.sigmob.sdk.downloader.core.cause.b b() {
        com.sigmob.sdk.downloader.core.cause.b bVar = this.f13387a;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("No cause find with resumable: " + this.c);
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.b;
    }

    public long e() {
        return this.d;
    }

    public void f() {
        g g = com.sigmob.sdk.downloader.g.j().g();
        c g2 = g();
        g2.a();
        boolean c = g2.c();
        boolean d = g2.d();
        long b = g2.b();
        String e = g2.e();
        String f = g2.f();
        int g3 = g2.g();
        g.a(f, this.e, this.f);
        this.f.a(d);
        this.f.a(e);
        if (com.sigmob.sdk.downloader.g.j().a().g(this.e)) {
            throw com.sigmob.sdk.downloader.core.exception.b.f13395a;
        }
        com.sigmob.sdk.downloader.core.cause.b a2 = g.a(g3, this.f.i() != 0, this.f, e);
        boolean z = a2 == null;
        this.c = z;
        this.f13387a = a2;
        this.d = b;
        this.b = c;
        if (a(g3, b, z)) {
            return;
        }
        if (g.a(g3, this.f.i() != 0)) {
            throw new i(g3, this.f.i());
        }
    }

    public c g() {
        return new c(this.e, this.f);
    }

    public String toString() {
        return "acceptRange[" + this.b + "] resumable[" + this.c + "] failedCause[" + this.f13387a + "] instanceLength[" + this.d + "] " + super.toString();
    }

    public boolean a(int i, long j, boolean z) {
        return i == 416 && j >= 0 && z;
    }
}
