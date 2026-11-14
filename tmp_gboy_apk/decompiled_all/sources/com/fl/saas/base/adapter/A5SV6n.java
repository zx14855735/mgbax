package com.fl.saas.base.adapter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A5SV6n implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10715AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AdViewInterstitialAdapter f10716AlLFFp;

    public /* synthetic */ A5SV6n(AdViewInterstitialAdapter adViewInterstitialAdapter, int i) {
        this.f10715AcNBzu = i;
        this.f10716AlLFFp = adViewInterstitialAdapter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10715AcNBzu) {
            case 0:
                this.f10716AlLFFp.closeInterstitialListener();
                break;
            case 1:
                this.f10716AlLFFp.lambda$onShowEvent$4();
                break;
            case 2:
                this.f10716AlLFFp.closeView();
                break;
            case 3:
                this.f10716AlLFFp.lambda$showInterstitialAd$3();
                break;
            case 4:
                this.f10716AlLFFp.lambda$showInterstitialAd$1();
                break;
            default:
                this.f10716AlLFFp.lambda$closeInterstitialListener$9();
                break;
        }
    }
}
