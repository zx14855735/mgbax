package com.sigmob.sdk.nativead;

import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u implements t {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<com.sigmob.sdk.videoplayer.f> f13618a;
    private l b;

    public u(com.sigmob.sdk.videoplayer.f fVar) {
        this.f13618a = new WeakReference<>(fVar);
    }

    private com.sigmob.sdk.videoplayer.f k() {
        return this.f13618a.get();
    }

    @Override // com.sigmob.sdk.nativead.t
    public void a() {
        com.sigmob.sdk.videoplayer.f k = k();
        if (k == null) {
            return;
        }
        k.D();
    }

    @Override // com.sigmob.sdk.nativead.t
    public void b() {
        com.sigmob.sdk.videoplayer.f k = k();
        if (k == null) {
            return;
        }
        k.C();
    }

    @Override // com.sigmob.sdk.nativead.t
    public void c() {
        com.sigmob.sdk.videoplayer.f k = k();
        if (k == null) {
            return;
        }
        k.C();
    }

    @Override // com.sigmob.sdk.nativead.t
    public void d() {
        com.sigmob.sdk.videoplayer.f k = k();
        if (k == null) {
            return;
        }
        k.E();
    }

    @Override // com.sigmob.sdk.nativead.t
    public int e() {
        com.sigmob.sdk.videoplayer.f k = k();
        if (k == null || k.getDuration() == 0) {
            return 0;
        }
        return (int) (k.getDuration() / 1000);
    }

    @Override // com.sigmob.sdk.nativead.t
    public int f() {
        com.sigmob.sdk.videoplayer.f k = k();
        if (k == null || k.getCurrentPositionWhenPlaying() == 0) {
            return 0;
        }
        return (int) ((k.getCurrentPositionWhenPlaying() * 100) / k.getDuration());
    }

    @Override // com.sigmob.sdk.nativead.t
    public l g() {
        return this.b;
    }

    @Override // com.sigmob.sdk.nativead.t
    public void h() {
        com.sigmob.sdk.videoplayer.f k = k();
        if (k == null) {
            return;
        }
        k.d();
    }

    @Override // com.sigmob.sdk.nativead.t
    public void i() {
        com.sigmob.sdk.videoplayer.f fVar = this.f13618a.get();
        if (fVar != null) {
            fVar.a();
        }
        this.f13618a.clear();
        this.b = null;
    }

    @Override // com.sigmob.sdk.nativead.t
    public int j() {
        com.sigmob.sdk.videoplayer.f k = k();
        if (k == null) {
            return 0;
        }
        return (int) (k.getCurrentPositionWhenPlaying() / 1000);
    }

    public void a(int i) {
        com.sigmob.sdk.videoplayer.f k = k();
        if (k == null) {
            return;
        }
        k.setHolderImageResource(i);
    }

    @Override // com.sigmob.sdk.nativead.t
    public void a(l lVar) {
        this.b = lVar;
    }

    @Override // com.sigmob.sdk.nativead.t
    public void a(boolean z) {
        com.sigmob.sdk.videoplayer.f k = k();
        if (k == null) {
            return;
        }
        k.setSoundChange(z);
    }
}
