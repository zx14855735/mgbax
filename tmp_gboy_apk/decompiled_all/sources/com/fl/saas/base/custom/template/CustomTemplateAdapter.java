package com.fl.saas.base.custom.template;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.fl.saas.base.adapter.AdViewTemplateAdapter;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.custom.CustomLoadListener;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.base.widget.JsonUtil;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class CustomTemplateAdapter extends AdViewTemplateAdapter implements BiddingResult {
    protected CustomTemplateEventListener mImpressionEventListener;
    protected CustomLoadListener mLoadListener;

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(boolean z, int i, int i2, int i3) {
    }

    public abstract List<View> getTemplateView();

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public final void handle(Activity activity) {
        this.mLoadListener = new CustomLoadListener() { // from class: com.fl.saas.base.custom.template.CustomTemplateAdapter.1
            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdDataLoaded() {
                LogcatUtil.d("YdSDK-Custom-Template", "onTemplateAdSuccessLoad");
                List<View> templateView = CustomTemplateAdapter.this.getTemplateView();
                if (templateView != null && !templateView.isEmpty()) {
                    CustomTemplateAdapter.this.onLoadedEvent(templateView);
                    return;
                }
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.adv_id = CtFAbx.AZkASS("", CustomTemplateAdapter.this.getAdSource().adv_id, new StringBuilder());
                errorInfo.tagid = CustomTemplateAdapter.this.getAdSource().tagid;
                errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
                errorInfo.msg = "custom template return null";
                CustomTemplateAdapter.this.disposeError(errorInfo);
            }

            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdLoadError(String str, String str2) {
                LogcatUtil.d("YdSDK-Custom-Template", "disposeError, " + str + "___" + str2);
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.adv_id = CtFAbx.AZkASS("", CustomTemplateAdapter.this.getAdSource().adv_id, new StringBuilder());
                errorInfo.tagid = CustomTemplateAdapter.this.getAdSource().tagid;
                errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
                errorInfo.msg = CtFAbx.AcNBzu(str, str2);
                CustomTemplateAdapter.this.disposeError(errorInfo);
            }
        };
        this.mImpressionEventListener = new CustomTemplateEventListener() { // from class: com.fl.saas.base.custom.template.CustomTemplateAdapter.2
            @Override // com.fl.saas.base.custom.template.CustomTemplateEventListener
            public void onTemplateAdClicked(int i) {
                LogcatUtil.d("YdSDK-Custom-Template", "onADClicked");
                CustomTemplateAdapter.this.onClickedEvent(i);
            }

            @Override // com.fl.saas.base.custom.template.CustomTemplateEventListener
            public void onTemplateAdClose(View view) {
                LogcatUtil.d("YdSDK-Custom-Template", "onADClosed");
                CustomTemplateAdapter.this.onClosedEvent(view);
            }

            @Override // com.fl.saas.base.custom.template.CustomTemplateEventListener
            public void onTemplateAdShow(int i) {
                LogcatUtil.d("YdSDK-Custom-Template", "onADExposure");
                CustomTemplateAdapter.this.onShowEvent(i);
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
}
