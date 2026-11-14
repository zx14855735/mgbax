package com.fl.saas.base.base;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10730AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ BaseAPI f10731AlLFFp;

    public /* synthetic */ A2egSU(BaseAPI baseAPI, int i) {
        this.f10730AcNBzu = i;
        this.f10731AlLFFp = baseAPI;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10730AcNBzu) {
            case 0:
                this.f10731AlLFFp.lambda$request$0();
                break;
            default:
                this.f10731AlLFFp.lambda$reRequest$1();
                break;
        }
    }
}
