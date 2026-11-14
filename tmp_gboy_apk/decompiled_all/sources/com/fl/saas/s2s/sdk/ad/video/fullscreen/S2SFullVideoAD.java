package com.fl.saas.s2s.sdk.ad.video.fullscreen;

import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CacheListener;
import com.fl.saas.s2s.sdk.helper.OnYqAdListener;
import com.fl.saas.s2s.sdk.helper.S2sRequestHelper;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class S2SFullVideoAD {
    private final CacheListener mCacheListener;
    private final OnS2SFullVideoADListener mListener;
    private S2SFullVideoADManager manager;

    public S2SFullVideoAD(OnS2SFullVideoADListener onS2SFullVideoADListener, CacheListener cacheListener) {
        this.mListener = onS2SFullVideoADListener;
        this.mCacheListener = cacheListener;
    }

    public void destroy() {
        S2SFullVideoADManager s2SFullVideoADManager = this.manager;
        if (s2SFullVideoADManager != null) {
            s2SFullVideoADManager.destroy();
        }
    }

    public void loadAd(AdSource adSource) {
        S2sRequestHelper.getInstance().requestAd(1, adSource, new OnYqAdListener() { // from class: com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoAD.1
            @Override // com.fl.saas.s2s.sdk.helper.OnYqAdListener
            public void onAdFailed(YdError ydError) {
                if (S2SFullVideoAD.this.mListener == null || ydError == null || ydError.getCode() == 1001) {
                    return;
                }
                S2SFullVideoAD.this.mListener.onFullVideoAdFailed(ydError);
            }

            @Override // com.fl.saas.s2s.sdk.helper.OnYqAdListener
            public void onNativeAdReceived(List<AdInfoPoJo> list) {
                S2SFullVideoAD s2SFullVideoAD = S2SFullVideoAD.this;
                s2SFullVideoAD.manager = new S2SFullVideoADManager(s2SFullVideoAD.mCacheListener);
                S2SFullVideoAD.this.manager.init(list, S2SFullVideoAD.this.mListener);
            }
        });
    }
}
