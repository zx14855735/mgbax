package com.fl.saas.base.inner.interstitial;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ARc23Z implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10757AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ InterstitialViewHelper f10758AlLFFp;

    public /* synthetic */ ARc23Z(InterstitialViewHelper interstitialViewHelper, int i) {
        this.f10757AcNBzu = i;
        this.f10758AlLFFp = interstitialViewHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10757AcNBzu) {
            case 0:
                this.f10758AlLFFp.lambda$createAdView$6();
                break;
            default:
                this.f10758AlLFFp.lambda$new$2();
                break;
        }
    }
}
