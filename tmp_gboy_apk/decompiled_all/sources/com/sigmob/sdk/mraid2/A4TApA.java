package com.sigmob.sdk.mraid2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13506AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ d f13507AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ String f13508AmA8tU;

    public /* synthetic */ A4TApA(d dVar, String str, int i) {
        this.f13506AcNBzu = i;
        this.f13507AlLFFp = dVar;
        this.f13508AmA8tU = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13506AcNBzu) {
            case 0:
                this.f13507AlLFFp.a(r0, this.f13508AmA8tU);
                break;
            default:
                this.f13507AlLFFp.f(this.f13508AmA8tU);
                break;
        }
    }
}
