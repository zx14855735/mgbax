package com.fl.saas.base.innterNative;

import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ARc23Z implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10788A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ long f10789A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ Object f10790A5SV6n;

    public /* synthetic */ ARc23Z(int i, long j, Object obj) {
        this.f10788A2egSU = i;
        this.f10790A5SV6n = obj;
        this.f10789A4TApA = j;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        NativeEventListener nativeEventListener = (NativeEventListener) obj;
        switch (this.f10788A2egSU) {
            case 0:
                ((BaseNativeAd.AnonymousClass3.AnonymousClass1.C02211) this.f10790A5SV6n).lambda$onAdVideoProgress$5(this.f10789A4TApA, nativeEventListener);
                break;
            default:
                ((BaseNativeAd) this.f10790A5SV6n).lambda$onAdVideoProgress$9(this.f10789A4TApA, nativeEventListener);
                break;
        }
    }
}
