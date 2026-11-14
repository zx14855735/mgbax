package com.fl.saas.base.manager;

import android.app.Activity;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A4TApA implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10792A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f10793A4TApA;

    public /* synthetic */ A4TApA(int i, Object obj) {
        this.f10792A2egSU = i;
        this.f10793A4TApA = obj;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f10792A2egSU) {
            case 0:
                ((AdViewSpreadListener) obj).onAdClick((String) this.f10793A4TApA);
                break;
            case 1:
                ((AdViewSpreadListener) obj).onAdFailed((YdError) this.f10793A4TApA);
                break;
            case 2:
                ((AdViewInterstitialAdapter) obj).showInterstitialAd((Activity) this.f10793A4TApA);
                break;
            default:
                ((MixNativeManager) this.f10793A4TApA).lambda$bindAdapter$0((NativeAd) obj);
                break;
        }
    }
}
