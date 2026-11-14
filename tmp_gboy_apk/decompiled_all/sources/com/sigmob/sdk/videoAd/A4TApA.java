package com.sigmob.sdk.videoAd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13686AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ j f13687AlLFFp;

    public /* synthetic */ A4TApA(j jVar, int i) {
        this.f13686AcNBzu = i;
        this.f13687AlLFFp = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13686AcNBzu) {
            case 0:
                this.f13687AlLFFp.z();
                break;
            case 1:
                this.f13687AlLFFp.ab();
                break;
            case 2:
                this.f13687AlLFFp.X();
                break;
            case 3:
                this.f13687AlLFFp.Y();
                break;
            default:
                this.f13687AlLFFp.aa();
                break;
        }
    }
}
