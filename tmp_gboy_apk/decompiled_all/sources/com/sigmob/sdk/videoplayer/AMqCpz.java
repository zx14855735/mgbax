package com.sigmob.sdk.videoplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.ViewGroup;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaa0;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa;
import io.dcloud.openapi.poly.adapter.ks.KSSplashAOL;
import io.dcloud.openapi.poly.adapter.sgm.SGMSplashAOL;
import io.dcloud.sdk.poly.adapter.custom.yt.CustomYTInterstitialAd;
import io.dcloud.sdk.poly.adapter.custom.yt.CustomYTRewardAd;
import io.dcloud.sdk.poly.adapter.custom.yt.CustomYTSplashAd;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AMqCpz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13758AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13759AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f13760AmA8tU;

    public /* synthetic */ AMqCpz(Object obj, int i, Object obj2) {
        this.f13758AcNBzu = i;
        this.f13759AlLFFp = obj;
        this.f13760AmA8tU = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13758AcNBzu) {
            case 0:
                ((j) this.f13759AlLFFp).a((MediaPlayer) this.f13760AmA8tU);
                break;
            case 1:
                ((aaaaaaa0) this.f13759AlLFFp).aaaaaaau((List) this.f13760AmA8tU);
                break;
            case 2:
                ((aaaaaaaa) this.f13759AlLFFp).aaaaaaaa((String) this.f13760AmA8tU);
                break;
            case 3:
                ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa) this.f13759AlLFFp).aaaaaaac((List) this.f13760AmA8tU);
                break;
            case 4:
                ((KSSplashAOL) this.f13759AlLFFp).a((ViewGroup) this.f13760AmA8tU);
                break;
            case 5:
                ((SGMSplashAOL) this.f13759AlLFFp).a((ViewGroup) this.f13760AmA8tU);
                break;
            case 6:
                ((CustomYTInterstitialAd) this.f13759AlLFFp).lambda$show$1((Activity) this.f13760AmA8tU);
                break;
            case 7:
                ((CustomYTRewardAd) this.f13759AlLFFp).lambda$show$1((Activity) this.f13760AmA8tU);
                break;
            default:
                ((CustomYTSplashAd) this.f13759AlLFFp).lambda$show$1((ViewGroup) this.f13760AmA8tU);
                break;
        }
    }
}
