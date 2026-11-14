package com.sigmob.windad.rewardVideo;

import DaOi9o.AYUAbz;
import Dphsd2.AMqCpz;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.c;
import com.sigmob.sdk.videoAd.e;
import com.sigmob.sdk.videoAd.k;
import com.sigmob.sdk.videoAd.l;
import com.sigmob.sdk.videoAd.m;
import com.sigmob.windad.WindAdError;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WindRewardVideoAd extends c<e> implements k, l, m {
    protected WindRewardVideoAdListener m;

    public WindRewardVideoAd(WindRewardAdRequest windRewardAdRequest) {
        super(windRewardAdRequest, false, 1);
        setAdLoadListener(this);
    }

    @Override // com.sigmob.sdk.c
    public void a(l lVar) {
        if (((c) this).c == 0) {
            return;
        }
        h.f(((c) this).e.getPlacementId());
        ((e) ((c) this).c).a(new AYUAbz(this, 10, lVar));
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
        WindRewardVideoAdListener windRewardVideoAdListener = this.m;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdClicked(str);
    }

    @Override // com.sigmob.sdk.videoAd.m
    public void onAdClosed(String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.m;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdClosed(str);
    }

    @Override // com.sigmob.sdk.videoAd.k
    public void onAdLoadError(WindAdError windAdError, String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.m;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdLoadError(windAdError, str);
    }

    @Override // com.sigmob.sdk.videoAd.k
    public void onAdLoadSuccess(String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.m;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdLoadSuccess(str);
    }

    @Override // com.sigmob.sdk.videoAd.k
    public void onAdPreLoadFail(WindAdError windAdError, String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.m;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdPreLoadFail(str);
    }

    @Override // com.sigmob.sdk.videoAd.k
    public void onAdPreLoadSuccess(String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.m;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdPreLoadSuccess(str);
    }

    @Override // com.sigmob.sdk.videoAd.m
    public void onAdShow(String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.m;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdPlayStart(str);
    }

    @Override // com.sigmob.sdk.videoAd.m
    public void onAdShowError(WindAdError windAdError, String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.m;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdPlayError(windAdError, str);
    }

    @Override // com.sigmob.sdk.videoAd.m
    public void onVideoAdPlayComplete(String str) {
    }

    @Override // com.sigmob.sdk.videoAd.m
    public void onVideoAdPlayEnd(String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.m;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdPlayEnd(str);
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onVideoAdRewarded(WindRewardInfo windRewardInfo, String str) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.m;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdRewarded(windRewardInfo, str);
    }

    public void setWindRewardVideoAdListener(WindRewardVideoAdListener windRewardVideoAdListener) {
        this.m = windRewardVideoAdListener;
    }

    public boolean show(HashMap<String, String> hashMap) {
        return super.show(hashMap, this, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(l lVar, WindRewardInfo windRewardInfo, String str) {
        ((c) this).f13334a.post(new AMqCpz(lVar, windRewardInfo, this, str));
    }

    @Override // com.sigmob.sdk.c
    public e createAdManager() {
        return new e(false);
    }

    @Override // com.sigmob.sdk.c, com.sigmob.sdk.base.m
    public boolean loadAd(String str) {
        return super.loadAd(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(WindRewardInfo windRewardInfo, l lVar, String str) {
        T t = ((c) this).c;
        if (t != 0) {
            ((e) t).a("reward_callback", windRewardInfo.getOptions());
        }
        if (lVar != null) {
            SigmobLog.i("onVideoAdRewarded " + str);
            lVar.onVideoAdRewarded(windRewardInfo, str);
        }
    }
}
