package com.fl.saas.base.custom.fullvideo;

import ADYaiT.CtFAbx;
import Kce6Pf.A2egSU;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.base.adapter.AdViewFullVideoAdapter;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.custom.CustomLoadListener;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.base.widget.JsonUtil;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class CustomFullVideoAdapter extends AdViewFullVideoAdapter implements BiddingResult {
    protected CustomFullVideoEventListener mImpressionEventListener;
    protected CustomLoadListener mLoadListener;

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public final void handle(Activity activity) {
        LogcatUtil.d("YdSDK-Custom-FullVideo", "handle");
        this.mLoadListener = new CustomLoadListener() { // from class: com.fl.saas.base.custom.fullvideo.CustomFullVideoAdapter.1
            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdDataLoaded() {
                LogcatUtil.d("YdSDK-Custom-FullVideo", "onSplashAdSuccessLoad");
                CustomFullVideoAdapter.this.onLoadedEvent();
            }

            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdLoadError(String str, String str2) {
                LogcatUtil.d("YdSDK-Custom-FullVideo", "disposeError, " + str + "___" + str2);
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.adv_id = CtFAbx.AZkASS("", CustomFullVideoAdapter.this.getAdSource().adv_id, new StringBuilder());
                errorInfo.tagid = CustomFullVideoAdapter.this.getAdSource().tagid;
                errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
                errorInfo.msg = CtFAbx.AcNBzu(str, str2);
                CustomFullVideoAdapter.this.disposeError(errorInfo);
            }
        };
        this.mImpressionEventListener = new CustomFullVideoEventListener() { // from class: com.fl.saas.base.custom.fullvideo.CustomFullVideoAdapter.2
            @Override // com.fl.saas.base.custom.fullvideo.CustomFullVideoEventListener
            public void onFullVideoAdClicked() {
                LogcatUtil.d("YdSDK-Custom-FullVideo", "onAdClicked");
                CustomFullVideoAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.base.custom.fullvideo.CustomFullVideoEventListener
            public void onFullVideoAdClose() {
                LogcatUtil.d("YdSDK-Custom-FullVideo", "onPageDismiss");
                CustomFullVideoAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.base.custom.fullvideo.CustomFullVideoEventListener
            public void onFullVideoAdShow() {
                LogcatUtil.d("YdSDK-Custom-FullVideo", "onVideoPlayStart");
                CustomFullVideoAdapter.this.onShowEvent();
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

    @Override // com.fl.saas.base.adapter.AdViewFullVideoAdapter
    public final void showRewardVideo() {
        super.showRewardVideo();
        LogcatUtil.d("YdSDK-Custom-FullVideo", "showRewardVideo");
        getActivityValid().ifPresent(new A2egSU(5, this));
    }
}
