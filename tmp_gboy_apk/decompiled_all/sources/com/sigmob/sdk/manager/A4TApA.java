package com.sigmob.sdk.manager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13435AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ f f13436AlLFFp;

    public /* synthetic */ A4TApA(f fVar, int i) {
        this.f13435AcNBzu = i;
        this.f13436AlLFFp = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13435AcNBzu) {
            case 0:
                this.f13436AlLFFp.r();
                break;
            default:
                this.f13436AlLFFp.q();
                break;
        }
    }
}
