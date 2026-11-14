package com.sigmob.sdk.videoAd;

import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.utils.o;
import com.sigmob.sdk.base.utils.q;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e extends com.sigmob.sdk.manager.f implements h {
    private static final int q = 0;
    private static final int r = 1;
    private static final int s = 2;
    private int t;
    private l u;
    private final boolean v;

    public e(boolean z) {
        this.v = z;
    }

    private void s(BaseAdUnit baseAdUnit) {
        if (q.b(baseAdUnit)) {
            String rvCallBackUrl = baseAdUnit.getRvCallBackUrl();
            if (o.b(rvCallBackUrl)) {
                AdTracker adTracker = new AdTracker(AdTracker.MessageType.TRACKING_URL, rvCallBackUrl, "reward_server", baseAdUnit.getRequestId());
                adTracker.setRetryNum(Integer.valueOf(baseAdUnit.getTrackingRetryNum()));
                com.sigmob.sdk.base.network.g.a(adTracker, baseAdUnit, false, true, true, new TrackManager.Listener() { // from class: com.sigmob.sdk.videoAd.e.1
                    @Override // com.czhj.sdk.common.track.TrackManager.Listener
                    public void onErrorResponse(AdTracker adTracker2, VolleyError volleyError) {
                        if (e.this.t == 1) {
                            e.this.a(2, Constants.FAIL, "1");
                        }
                    }

                    @Override // com.czhj.sdk.common.track.TrackManager.Listener
                    public void onSuccess(AdTracker adTracker2, NetworkResponse networkResponse) {
                        if (e.this.t == 1) {
                            e.this.a(2, "1", "1");
                        }
                    }
                });
                return;
            }
        }
        a(2, Constants.FAIL, Constants.FAIL);
    }

    @Override // com.sigmob.sdk.videoAd.h
    public void c(BaseAdUnit baseAdUnit, String str) {
        if (com.sigmob.sdk.manager.b.m(baseAdUnit)) {
            com.sigmob.sdk.base.common.h.g().e(baseAdUnit);
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_PLAY;
        windAdError.setMessage(str);
        a(windAdError, this.p);
        a(baseAdUnit, PointCategory.PLAY, this.k.getAdType(), this.g, this.k.getLoadId(), windAdError);
        SigmobLog.d("onVideoPlayFail() called");
    }

    @Override // com.sigmob.sdk.manager.b
    public void g() {
        if (com.sigmob.sdk.base.utils.e.b(this.m)) {
            for (BaseAdUnit baseAdUnit : this.m) {
                if (baseAdUnit != null) {
                    if (com.sigmob.sdk.manager.b.m(baseAdUnit)) {
                        com.sigmob.sdk.base.common.h.g().e(baseAdUnit);
                    }
                    com.sigmob.sdk.base.common.h.b(baseAdUnit);
                }
            }
        }
        this.m = null;
    }

    @Override // com.sigmob.sdk.manager.f
    public com.sigmob.sdk.mraid.i l() {
        return new g(this, this.v);
    }

    @Override // com.sigmob.sdk.manager.f
    public void n() {
        this.t = 0;
    }

    @Override // com.sigmob.sdk.manager.f
    public void o() {
        if (this.t == 1) {
            a(0, Constants.FAIL, "1");
        }
    }

    @Override // com.sigmob.sdk.manager.f
    public void p() {
        super.p();
        this.u = null;
    }

    @Override // com.sigmob.sdk.videoAd.h
    public void q(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onVideoSkip() called");
    }

    @Override // com.sigmob.sdk.videoAd.h
    public void r(BaseAdUnit baseAdUnit) {
        n(baseAdUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2) {
        this.t = i;
        if (this.u == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WindAds.TRANS_ID, this.h);
        hashMap.put(WindAds.SERVER_ARRIVED, str);
        hashMap.put(WindAds.REWARD_TYPE, str2);
        this.u.onVideoAdRewarded(new WindRewardInfo(true, hashMap), this.g);
    }

    @Override // com.sigmob.sdk.videoAd.h
    public void o(BaseAdUnit baseAdUnit) {
        SigmobLogger.d(this.f13439a, "onVideoComplete", new Object[0]);
        this.t = 1;
        if (q.b(this.p)) {
            this.p.onVideoAdPlayComplete(this.g);
        }
        s(baseAdUnit);
    }

    @Override // com.sigmob.sdk.videoAd.h
    public void p(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onVideoPlay() called");
    }

    public void a(l lVar) {
        this.u = lVar;
    }
}
