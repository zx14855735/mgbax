package com.fl.saas.base.inner.interstitial.coustomView;

import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10760AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ InterstitialVMHView f10761AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Drawable f10762AmA8tU;

    public /* synthetic */ A2egSU(InterstitialVMHView interstitialVMHView, Drawable drawable, int i) {
        this.f10760AcNBzu = i;
        this.f10761AlLFFp = interstitialVMHView;
        this.f10762AmA8tU = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10760AcNBzu) {
            case 0:
                this.f10761AlLFFp.lambda$setMediaView$1(this.f10762AmA8tU);
                break;
            default:
                this.f10761AlLFFp.lambda$setMediaView$2(this.f10762AmA8tU);
                break;
        }
    }
}
