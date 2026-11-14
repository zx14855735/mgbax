package com.sigmob.sdk.videoplayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A5SV6n implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13752AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ j f13753AlLFFp;

    public /* synthetic */ A5SV6n(j jVar, int i) {
        this.f13752AcNBzu = i;
        this.f13753AlLFFp = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13752AcNBzu) {
            case 0:
                this.f13753AlLFFp.k();
                break;
            case 1:
                this.f13753AlLFFp.n();
                break;
            case 2:
                this.f13753AlLFFp.p();
                break;
            case 3:
                this.f13753AlLFFp.o();
                break;
            case 4:
                this.f13753AlLFFp.q();
                break;
            case 5:
                this.f13753AlLFFp.l();
                break;
            default:
                this.f13753AlLFFp.m();
                break;
        }
    }
}
