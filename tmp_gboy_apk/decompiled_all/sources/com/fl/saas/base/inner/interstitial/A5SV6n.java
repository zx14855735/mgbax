package com.fl.saas.base.inner.interstitial;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A5SV6n implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10752AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ InterstitialViewHelper f10753AlLFFp;

    public /* synthetic */ A5SV6n(InterstitialViewHelper interstitialViewHelper, int i) {
        this.f10752AcNBzu = i;
        this.f10753AlLFFp = interstitialViewHelper;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f10752AcNBzu) {
            case 0:
                this.f10753AlLFFp.lambda$createAdView$4(view);
                break;
            case 1:
                this.f10753AlLFFp.lambda$setViewType$11(view);
                break;
            case 2:
                this.f10753AlLFFp.lambda$setViewType$12(view);
                break;
            case 3:
                this.f10753AlLFFp.lambda$click$13(view);
                break;
            case 4:
                this.f10753AlLFFp.lambda$click$14(view);
                break;
            default:
                this.f10753AlLFFp.lambda$new$0(view);
                break;
        }
    }
}
