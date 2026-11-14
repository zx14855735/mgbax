package com.sigmob.sdk.newInterstitial;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13629AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ i f13630AlLFFp;

    public /* synthetic */ A2egSU(i iVar, int i) {
        this.f13629AcNBzu = i;
        this.f13630AlLFFp = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13629AcNBzu) {
            case 0:
                this.f13630AlLFFp.v();
                break;
            default:
                this.f13630AlLFFp.J();
                break;
        }
    }
}
