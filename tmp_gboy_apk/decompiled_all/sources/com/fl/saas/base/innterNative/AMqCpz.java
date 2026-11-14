package com.fl.saas.base.innterNative;

import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class AMqCpz implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10786A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ BaseNativeAd.AnonymousClass3.AnonymousClass1.C02211 f10787A4TApA;

    public /* synthetic */ AMqCpz(BaseNativeAd.AnonymousClass3.AnonymousClass1.C02211 c02211, int i) {
        this.f10786A2egSU = i;
        this.f10787A4TApA = c02211;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f10786A2egSU) {
            case 0:
                this.f10787A4TApA.lambda$onAdClicked$1((NativeEventListener) obj);
                break;
            case 1:
                this.f10787A4TApA.lambda$onAdClose$2((NativeEventListener) obj);
                break;
            case 2:
                this.f10787A4TApA.lambda$onAdImpressed$0((NativeEventListener) obj);
                break;
            case 3:
                this.f10787A4TApA.lambda$onAdVideoStart$3((NativeEventListener) obj);
                break;
            default:
                this.f10787A4TApA.lambda$onAdVideoEnd$4((NativeEventListener) obj);
                break;
        }
    }
}
