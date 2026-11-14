package com.fl.saas.common.crash;

import com.fl.saas.config.utils.SensorUtil;
import com.sigmob.sdk.base.o;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaa0;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaeaaa;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.sdk.poly.adapter.custom.yt.CustomYTInterstitialAd;
import io.dcloud.sdk.poly.adapter.custom.yt.CustomYTNativeAd;
import io.dcloud.sdk.poly.adapter.custom.yt.CustomYTRewardAd;
import io.dcloud.sdk.poly.adapter.custom.yt.CustomYTSplashAd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10809AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f10810AlLFFp;

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f10809AcNBzu = i;
        this.f10810AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10809AcNBzu) {
            case 0:
                ((CrashHandler) this.f10810AlLFFp).lambda$uploadCrashLog$0();
                break;
            case 1:
                ((SensorUtil) this.f10810AlLFFp).unRegisterAccelerometer();
                break;
            case 2:
                ((o) this.f10810AlLFFp).al();
                break;
            case 3:
                ((aaaaaaa0) this.f10810AlLFFp).aaaaaaaa();
                break;
            case 4:
                ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.aaaaaaa0) this.f10810AlLFFp).aaaaaaca();
                break;
            case 5:
                ((aaaaeaaa) this.f10810AlLFFp).aaaaaaaa();
                break;
            case 6:
                ((DCBaseAOLLoader) this.f10810AlLFFp).aaaacaaa();
                break;
            case 7:
                ((CustomYTInterstitialAd) this.f10810AlLFFp).lambda$destroy$2();
                break;
            case 8:
                ((CustomYTNativeAd) this.f10810AlLFFp).lambda$destroy$0();
                break;
            case 9:
                ((CustomYTRewardAd) this.f10810AlLFFp).lambda$destroy$2();
                break;
            default:
                ((CustomYTSplashAd) this.f10810AlLFFp).lambda$destroy$2();
                break;
        }
    }
}
