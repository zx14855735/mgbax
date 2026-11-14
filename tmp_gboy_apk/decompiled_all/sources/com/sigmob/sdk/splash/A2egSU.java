package com.sigmob.sdk.splash;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13653AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ c f13654AlLFFp;

    public /* synthetic */ A2egSU(c cVar, int i) {
        this.f13653AcNBzu = i;
        this.f13654AlLFFp = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13653AcNBzu) {
            case 0:
                this.f13654AlLFFp.e();
                break;
            default:
                this.f13654AlLFFp.d();
                break;
        }
    }
}
