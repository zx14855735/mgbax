package com.fl.saas.base.widget;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10807AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ShakeView f10808AlLFFp;

    public /* synthetic */ A2egSU(ShakeView shakeView, int i) {
        this.f10807AcNBzu = i;
        this.f10808AlLFFp = shakeView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10807AcNBzu) {
            case 0:
                this.f10808AlLFFp.playAnimator();
                break;
            default:
                this.f10808AlLFFp.checkValidArea();
                break;
        }
    }
}
