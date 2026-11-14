package com.fl.saas.base.inner.interstitial;

import com.fl.saas.base.widget.RainTextureView;
import com.fl.saas.common.widget.InterceptClickLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ASJ6gh implements InterceptClickLayout.OnIntercept, RainTextureView.OnStatusListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ InterstitialViewHelper f10759AcNBzu;

    public /* synthetic */ ASJ6gh(InterstitialViewHelper interstitialViewHelper) {
        this.f10759AcNBzu = interstitialViewHelper;
    }

    @Override // com.fl.saas.common.widget.InterceptClickLayout.OnIntercept
    public boolean isIntercept(float f, float f2) {
        boolean lambda$setRainView$9;
        lambda$setRainView$9 = this.f10759AcNBzu.lambda$setRainView$9(f, f2);
        return lambda$setRainView$9;
    }

    @Override // com.fl.saas.base.widget.RainTextureView.OnStatusListener
    public void onStop() {
        this.f10759AcNBzu.lambda$setRainView$10();
    }
}
