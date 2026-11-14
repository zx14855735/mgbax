package com.fl.saas.base.inner;

import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.interfaces.AdValid;
import com.fl.saas.common.util.feature.Optional;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract /* synthetic */ class A2egSU {
    public static void A2egSU(InnerNativeAdapter innerNativeAdapter, boolean z, int i, int i2, int i3) {
        NativeAd nativeAd = innerNativeAdapter.getNativeAd();
        if (nativeAd instanceof BiddingResult) {
            ((BiddingResult) nativeAd).biddingResult(z, i, i2, i3);
        }
    }

    public static AdMaterial.AdMaterialData A4TApA(InnerNativeAdapter innerNativeAdapter) {
        NativeAd nativeAd = innerNativeAdapter.getNativeAd();
        if (nativeAd instanceof AdMaterial) {
            return ((AdMaterial) nativeAd).getAdMaterialData();
        }
        return null;
    }

    public static void A5SV6n(InnerNativeAdapter innerNativeAdapter, MixNativeHandler mixNativeHandler, NativeAd nativeAd) {
        Optional.ofNullable(mixNativeHandler).ifPresent(new KiXkPs.A2egSU(18));
        Optional.ofNullable(nativeAd).ifPresent(new KiXkPs.A2egSU(19));
    }

    public static boolean ADYaiT(InnerNativeAdapter innerNativeAdapter) {
        NativeAd nativeAd = innerNativeAdapter.getNativeAd();
        if (nativeAd == null) {
            return false;
        }
        if (nativeAd instanceof AdValid) {
            return ((AdValid) nativeAd).isValid();
        }
        return true;
    }
}
