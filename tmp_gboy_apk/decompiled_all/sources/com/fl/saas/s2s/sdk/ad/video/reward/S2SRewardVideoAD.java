package com.fl.saas.s2s.sdk.ad.video.reward;

import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CacheListener;
import com.fl.saas.s2s.sdk.helper.OnYqAdListener;
import com.fl.saas.s2s.sdk.helper.S2sRequestHelper;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class S2SRewardVideoAD {
    private final CacheListener mCacheListener;
    private final OnS2SRewardVideoADListener mListener;
    private S2SRewardVideoADManager manager;

    public S2SRewardVideoAD(OnS2SRewardVideoADListener onS2SRewardVideoADListener, CacheListener cacheListener) {
        this.mListener = onS2SRewardVideoADListener;
        this.mCacheListener = cacheListener;
    }

    public void destroy() {
        S2SRewardVideoADManager s2SRewardVideoADManager = this.manager;
        if (s2SRewardVideoADManager != null) {
            s2SRewardVideoADManager.destroy();
        }
    }

    public void loadAd(AdSource adSource) {
        S2sRequestHelper.getInstance().requestAd(1, adSource, new OnYqAdListener() { // from class: com.fl.saas.s2s.sdk.ad.video.reward.S2SRewardVideoAD.1
            @Override // com.fl.saas.s2s.sdk.helper.OnYqAdListener
            public void onAdFailed(YdError ydError) {
                if (S2SRewardVideoAD.this.mListener == null || ydError == null || ydError.getCode() == 1001) {
                    return;
                }
                S2SRewardVideoAD.this.mListener.onRewardVideoAdFailed(ydError);
            }

            @Override // com.fl.saas.s2s.sdk.helper.OnYqAdListener
            public void onNativeAdReceived(List<AdInfoPoJo> list) {
                S2SRewardVideoAD s2SRewardVideoAD = S2SRewardVideoAD.this;
                s2SRewardVideoAD.manager = new S2SRewardVideoADManager(s2SRewardVideoAD.mCacheListener);
                S2SRewardVideoAD.this.manager.init(list, S2SRewardVideoAD.this.mListener);
            }
        });
    }
}
