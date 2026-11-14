package com.sigmob.sdk.videoplayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13754AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ j f13755AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ int f13756AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ int f13757AzWtSf;

    public /* synthetic */ ADYaiT(j jVar, int i, int i2, int i3) {
        this.f13754AcNBzu = i3;
        this.f13755AlLFFp = jVar;
        this.f13756AmA8tU = i;
        this.f13757AzWtSf = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13754AcNBzu) {
            case 0:
                this.f13755AlLFFp.a(this.f13756AmA8tU, this.f13757AzWtSf);
                break;
            case 1:
                this.f13755AlLFFp.b(this.f13756AmA8tU, this.f13757AzWtSf);
                break;
            default:
                this.f13755AlLFFp.c(this.f13756AmA8tU, this.f13757AzWtSf);
                break;
        }
    }
}
