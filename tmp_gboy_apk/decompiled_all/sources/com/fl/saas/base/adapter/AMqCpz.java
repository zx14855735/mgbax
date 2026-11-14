package com.fl.saas.base.adapter;

import android.app.Activity;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class AMqCpz implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10719A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AdViewInterstitialAdapter f10720A4TApA;

    public /* synthetic */ AMqCpz(AdViewInterstitialAdapter adViewInterstitialAdapter, int i) {
        this.f10719A2egSU = i;
        this.f10720A4TApA = adViewInterstitialAdapter;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f10719A2egSU) {
            case 0:
                this.f10720A4TApA.lambda$closeInterstitialListener$10((Integer) obj);
                break;
            default:
                this.f10720A4TApA.lambda$showInterstitialAd$2((Activity) obj);
                break;
        }
    }
}
