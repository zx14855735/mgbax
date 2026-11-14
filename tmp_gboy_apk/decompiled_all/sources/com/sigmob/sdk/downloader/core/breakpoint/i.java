package com.sigmob.sdk.downloader.core.breakpoint;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i implements j {
    private static final String c = "BreakpointStoreOnSQLite";

    /* renamed from: a, reason: collision with root package name */
    protected final e f13355a;
    protected final h b;

    public i(Context context) {
        e eVar = new e(context.getApplicationContext());
        this.f13355a = eVar;
        this.b = new h(eVar.b(), eVar.a(), eVar.c());
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(int i) {
        return this.b.a(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public int b(com.sigmob.sdk.downloader.f fVar) {
        return this.b.b(fVar);
    }

    public j c() {
        return new l(this);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void d(int i) {
        this.b.d(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public c e(int i) {
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean f(int i) {
        if (!this.b.f(i)) {
            return false;
        }
        this.f13355a.a(i);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean g(int i) {
        if (!this.b.g(i)) {
            return false;
        }
        this.f13355a.b(i);
        return true;
    }

    public i(e eVar, h hVar) {
        this.f13355a = eVar;
        this.b = hVar;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar) {
        c a2 = this.b.a(fVar);
        this.f13355a.a(a2);
        return a2;
    }

    public void b() {
        this.f13355a.close();
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean c(int i) {
        return this.b.c(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar, c cVar) {
        return this.b.a(fVar, cVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public void b(int i) {
        this.b.b(i);
        this.f13355a.c(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public String a(String str) {
        return this.b.a(str);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(int i, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        this.b.a(i, aVar, exc);
        if (aVar == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
            this.f13355a.c(i);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(c cVar, int i, long j) {
        this.b.a(cVar, i, j);
        this.f13355a.a(cVar, i, cVar.b(i).a());
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a() {
        return false;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(c cVar) {
        boolean a2 = this.b.a(cVar);
        this.f13355a.b(cVar);
        String m = cVar.m();
        com.sigmob.sdk.downloader.core.c.b(c, "update " + cVar);
        if (cVar.d() && m != null) {
            this.f13355a.a(cVar.l(), m);
        }
        return a2;
    }
}
