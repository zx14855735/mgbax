package com.fl.saas.base.innterNative;

import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A4TApA implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10782A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ BaseNativeAd f10783A4TApA;

    public /* synthetic */ A4TApA(BaseNativeAd baseNativeAd, int i) {
        this.f10782A2egSU = i;
        this.f10783A4TApA = baseNativeAd;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f10782A2egSU) {
            case 0:
                this.f10783A4TApA.lambda$onAdClickedEvent$4((NativeEventListener) obj);
                break;
            case 1:
                this.f10783A4TApA.lambda$onAdImpressedEvent$3((NativeEventListener) obj);
                break;
            case 2:
                this.f10783A4TApA.lambda$onAdVideoStartEvent$7((NativeEventListener) obj);
                break;
            case 3:
                this.f10783A4TApA.lambda$onAdCloseEvent$6((NativeEventListener) obj);
                break;
            case 4:
                this.f10783A4TApA.lambda$onAdClickedEvent$5((NativeEventListener) obj);
                break;
            default:
                this.f10783A4TApA.lambda$onAdVideoEndEvent$8((NativeEventListener) obj);
                break;
        }
    }
}
