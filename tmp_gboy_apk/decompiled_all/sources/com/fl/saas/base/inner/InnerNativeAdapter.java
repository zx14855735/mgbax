package com.fl.saas.base.inner;

import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.interfaces.AdValid;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface InnerNativeAdapter extends AdMaterial, BiddingResult, AdValid {
    @Override // com.fl.saas.base.bidding.BiddingResult
    void biddingResult(boolean z, int i, int i2, int i3);

    @Override // com.fl.saas.base.interfaces.AdMaterial
    AdMaterial.AdMaterialData getAdMaterialData();

    NativeAd getNativeAd();

    void innerDestroy(MixNativeHandler mixNativeHandler, NativeAd nativeAd);

    @Override // com.fl.saas.base.interfaces.AdValid
    boolean isValid();

    MixNativeHandler loadNativeHandler();
}
