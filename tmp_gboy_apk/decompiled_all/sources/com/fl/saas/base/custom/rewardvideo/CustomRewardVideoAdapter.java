package com.fl.saas.base.custom.rewardvideo;

import ADYaiT.CtFAbx;
import Kce6Pf.A2egSU;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.base.adapter.AdViewVideoAdapter;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.custom.CustomLoadListener;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.base.widget.JsonUtil;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class CustomRewardVideoAdapter extends AdViewVideoAdapter implements BiddingResult {
    protected CustomRewardVideoEventListener mImpressionEventListener;
    protected CustomLoadListener mLoadListener;

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(boolean z, int i, int i2, int i3) {
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public final void handle(Activity activity) {
        LogcatUtil.d("YdSDK-Custom-Video", "handle");
        this.mLoadListener = new CustomLoadListener() { // from class: com.fl.saas.base.custom.rewardvideo.CustomRewardVideoAdapter.1
            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdDataLoaded() {
                LogcatUtil.d("YdSDK-Custom-Video", "onSplashAdSuccessLoad");
                CustomRewardVideoAdapter.this.onLoadedEvent();
            }

            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdLoadError(String str, String str2) {
                LogcatUtil.d("YdSDK-Custom-Video", "disposeError, " + str + "___" + str2);
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.adv_id = CtFAbx.AZkASS("", CustomRewardVideoAdapter.this.getAdSource().adv_id, new StringBuilder());
                errorInfo.tagid = CustomRewardVideoAdapter.this.getAdSource().tagid;
                errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
                errorInfo.msg = CtFAbx.AcNBzu(str, str2);
                CustomRewardVideoAdapter.this.disposeError(errorInfo);
            }
        };
        this.mImpressionEventListener = new CustomRewardVideoEventListener() { // from class: com.fl.saas.base.custom.rewardvideo.CustomRewardVideoAdapter.2
            @Override // com.fl.saas.base.custom.rewardvideo.CustomRewardVideoEventListener
            public void onReward() {
                CustomRewardVideoAdapter.this.onRewardEvent();
            }

            @Override // com.fl.saas.base.custom.rewardvideo.CustomRewardVideoEventListener
            public void onRewardedVideoAdClosed() {
                LogcatUtil.d("YdSDK-Custom-Video", "onADClose");
                CustomRewardVideoAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.base.custom.rewardvideo.CustomRewardVideoEventListener
            public void onRewardedVideoAdPlayClicked() {
                LogcatUtil.d("YdSDK-Custom-Video", "onADClick");
                CustomRewardVideoAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.base.custom.rewardvideo.CustomRewardVideoEventListener
            public void onRewardedVideoAdPlayEnd() {
                LogcatUtil.d("YdSDK-Custom-Video", "onVideoComplete");
                CustomRewardVideoAdapter.this.onVideoCompletedEvent();
            }

            @Override // com.fl.saas.base.custom.rewardvideo.CustomRewardVideoEventListener
            public void onRewardedVideoAdPlayFailed(String str, String str2) {
                CustomRewardVideoAdapter.this.onAdFailed(new YdError(ErrorCodeConstant.UNION_ERROR, CtFAbx.AlLFFp(str, "__", str2)));
            }

            @Override // com.fl.saas.base.custom.rewardvideo.CustomRewardVideoEventListener
            public void onRewardedVideoAdPlayStart() {
                LogcatUtil.d("YdSDK-Custom-Video", "onADShow");
                CustomRewardVideoAdapter.this.onShowEvent();
            }
        };
        HashMap hashMap = new HashMap();
        hashMap.put(MedProConst.AD_APPID, getAdSource().app_id);
        hashMap.put(MedProConst.AD_PLACEID, getAdSource().tagid);
        hashMap.put(MedProConst.AD_APPKEY, getAdSource().app_key);
        if (!TextUtils.isEmpty(getAdSource().customParameJson)) {
            hashMap.clear();
            hashMap.putAll(JsonUtil.jsonObjectToMap(getAdSource().customParameJson));
        }
        loadCustomNetworkAd(activity, hashMap, null);
    }

    public abstract void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2);

    public abstract void show(Activity activity);

    @Override // com.fl.saas.base.adapter.AdViewVideoAdapter
    public final void showRewardVideo() {
        LogcatUtil.d("YdSDK-Custom-Video", "showRewardVideo");
        getActivityValid().ifPresent(new A2egSU(6, this));
    }
}
