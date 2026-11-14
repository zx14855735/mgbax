package com.sigmob.sdk.downloader.core.breakpoint;

import com.sigmob.sdk.downloader.core.breakpoint.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    long f13359a;
    private final m b;

    public n(m.a aVar) {
        this(new m(aVar));
    }

    public void a() {
        this.b.a();
    }

    public void b(int i) {
        this.b.e(i);
        this.b.a(i, this.f13359a);
    }

    public void c(int i) {
        this.b.e(i);
        try {
            if (!this.b.a(i)) {
                this.b.b(i);
            }
        } finally {
            this.b.d(i);
        }
    }

    public void d(int i) {
        this.b.e(i);
        this.b.c(i);
    }

    public n(m mVar) {
        this.b = mVar;
        this.f13359a = 1500L;
    }

    public boolean a(int i) {
        return !this.b.a(i);
    }
}
