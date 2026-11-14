package com.fl.saas.base.custom.Interstitial;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.base.adapter.AZOQYO;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
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
public abstract class CustomInterstitialAdapter extends AdViewInterstitialAdapter implements BiddingResult {
    protected CustomInterstitialEventListener mImpressionEventListener;
    protected CustomLoadListener mLoadListener;

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(boolean z, int i, int i2, int i3) {
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public final void handle(Activity activity) {
        LogcatUtil.d("YdSDK-Custom-Interstitial", "handle");
        this.mLoadListener = new CustomLoadListener() { // from class: com.fl.saas.base.custom.Interstitial.CustomInterstitialAdapter.1
            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdDataLoaded() {
                LogcatUtil.d("YdSDK-Custom-Interstitial", "onSplashAdSuccessLoad");
                CustomInterstitialAdapter.this.onLoadedEvent();
            }

            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdLoadError(String str, String str2) {
                LogcatUtil.d("YdSDK-Custom-Interstitial", "disposeError, " + str + "___" + str2);
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.adv_id = CtFAbx.AZkASS("", CustomInterstitialAdapter.this.getAdSource().adv_id, new StringBuilder());
                errorInfo.tagid = CustomInterstitialAdapter.this.getAdSource().tagid;
                errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
                errorInfo.msg = CtFAbx.AcNBzu(str, str2);
                CustomInterstitialAdapter.this.disposeError(errorInfo);
            }
        };
        this.mImpressionEventListener = new CustomInterstitialEventListener() { // from class: com.fl.saas.base.custom.Interstitial.CustomInterstitialAdapter.2
            @Override // com.fl.saas.base.custom.Interstitial.CustomInterstitialEventListener
            public void onInterstitialAdClicked() {
                CustomInterstitialAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.base.custom.Interstitial.CustomInterstitialEventListener
            public void onInterstitialAdClose() {
                CustomInterstitialAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.base.custom.Interstitial.CustomInterstitialEventListener
            public void onInterstitialAdShow() {
                CustomInterstitialAdapter.this.onShowEvent();
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
        loadCustomNetworkAd(activity, hashMap, (Map) getBuilderFieldOptional(new AZOQYO(15)).orElse(null));
    }

    public abstract void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2);

    public abstract void show(Activity activity);

    @Override // com.fl.saas.base.adapter.AdViewInterstitialAdapter
    public final void showInterstitial(Activity activity) {
        show(activity);
    }
}
