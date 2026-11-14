package com.fl.saas.base.inner.interstitial;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ADYaiT implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10754A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ InterstitialViewHelper f10755A4TApA;

    public /* synthetic */ ADYaiT(InterstitialViewHelper interstitialViewHelper, int i) {
        this.f10754A2egSU = i;
        this.f10755A4TApA = interstitialViewHelper;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f10754A2egSU) {
            case 0:
                this.f10755A4TApA.loadAdIcon((Bitmap) obj);
                break;
            default:
                this.f10755A4TApA.lambda$loadView$7((Drawable) obj);
                break;
        }
    }
}
