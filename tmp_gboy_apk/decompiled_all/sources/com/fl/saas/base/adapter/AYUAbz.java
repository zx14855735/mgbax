package com.fl.saas.base.adapter;

import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class AYUAbz implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10723A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ NativeAd f10724A4TApA;

    public /* synthetic */ AYUAbz(NativeAd nativeAd, int i) {
        this.f10723A2egSU = i;
        this.f10724A4TApA = nativeAd;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f10723A2egSU) {
            case 0:
                ((Consumer) obj).accept(this.f10724A4TApA);
                break;
            default:
                ((NativeLoadListener) obj).onNativeAdLoaded(this.f10724A4TApA);
                break;
        }
    }
}
