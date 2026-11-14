package com.sigmob.windad.newInterstitial;

import com.sigmob.sdk.c;
import com.sigmob.sdk.newInterstitial.a;
import com.sigmob.sdk.videoAd.k;
import com.sigmob.sdk.videoAd.m;
import com.sigmob.windad.WindAdError;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WindNewInterstitialAd extends c<a> implements k, m {
    protected WindNewInterstitialAdListener m;

    public WindNewInterstitialAd(WindNewInterstitialAdRequest windNewInterstitialAdRequest) {
        super(windNewInterstitialAdRequest, false, 6);
        setAdLoadListener(this);
    }

    @Override // com.sigmob.sdk.c
    public void destroy() {
        this.m = null;
        super.destroy();
    }

    @Override // com.sigmob.sdk.c, com.sigmob.sdk.base.m
    public boolean loadAd() {
        return super.loadAd();
    }

    @Override // com.sigmob.sdk.videoAd.m
    public void onAdClicked(String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.m;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdClicked(str);
    }

    @Override // com.sigmob.sdk.videoAd.m
    public void onAdClosed(String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.m;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdClosed(str);
    }

    @Override // com.sigmob.sdk.videoAd.k
    public void onAdLoadError(WindAdError windAdError, String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.m;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdLoadError(windAdError, str);
    }

    @Override // com.sigmob.sdk.videoAd.k
    public void onAdLoadSuccess(String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.m;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdLoadSuccess(str);
    }

    @Override // com.sigmob.sdk.videoAd.k
    public void onAdPreLoadFail(WindAdError windAdError, String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.m;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdPreLoadFail(str);
    }

    @Override // com.sigmob.sdk.videoAd.k
    public void onAdPreLoadSuccess(String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.m;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdPreLoadSuccess(str);
    }

    @Override // com.sigmob.sdk.videoAd.m
    public void onAdShow(String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.m;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdShow(str);
    }

    @Override // com.sigmob.sdk.videoAd.m
    public void onAdShowError(WindAdError windAdError, String str) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.m;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdShowError(windAdError, str);
    }

    @Override // com.sigmob.sdk.videoAd.m
    public void onVideoAdPlayComplete(String str) {
    }

    @Override // com.sigmob.sdk.videoAd.m
    public void onVideoAdPlayEnd(String str) {
    }

    public void setWindNewInterstitialAdListener(WindNewInterstitialAdListener windNewInterstitialAdListener) {
        this.m = windNewInterstitialAdListener;
    }

    public boolean show(HashMap<String, String> hashMap) {
        return super.show(hashMap, this);
    }

    @Override // com.sigmob.sdk.c
    public a createAdManager() {
        return new a();
    }

    @Override // com.sigmob.sdk.c, com.sigmob.sdk.base.m
    public boolean loadAd(String str) {
        return super.loadAd(str);
    }
}
