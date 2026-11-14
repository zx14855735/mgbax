package com.fl.saas.base.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.base.inner.YdAdTempHelper;
import com.fl.saas.base.inner.spread.YdSpreadActivity;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.base.interfaces.ISplashEyeAd;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.sigmob.sdk.downloader.core.breakpoint.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AdViewSpreadAdapter extends BuilderLoadAdapter<InnerSpreadBuilder<?>, AdViewSpreadListener> {
    private boolean hasCallbackClose;
    private boolean isShow;
    private AdViewLoadListener mAdViewLoadListener;
    private View mView;
    private SpreadLoadListener.SpreadAd spreadAd;
    private final String TAG = CommConstant.getObjTag(this);
    private long adFillingTime = 0;
    private final int renderWidth = DeviceUtil.getMobileWidth();
    private int renderHeight = -1;

    public interface AdViewLoadListener {
        void AdViewLoad(ViewGroup viewGroup);
    }

    public class SpreadLoadAd implements SpreadLoadListener.SpreadAd {
        public SpreadLoadAd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$show$0() {
            if (AdViewSpreadAdapter.this.hasCallbackClose) {
                return;
            }
            AdViewSpreadAdapter.this.hasCallbackClose = true;
            AdViewSpreadAdapter.this.handleListenerEvent(new KiXkPs.A2egSU(12));
        }

        @Override // com.fl.saas.base.interfaces.AdMaterial
        public AdMaterial.AdMaterialData getAdMaterialData() {
            AdViewSpreadAdapter adViewSpreadAdapter = AdViewSpreadAdapter.this;
            return adViewSpreadAdapter instanceof AdMaterial ? adViewSpreadAdapter.getMaterialData() : AdMaterial.AdMaterialData.createEmpty(adViewSpreadAdapter.getAdSource().adv_id);
        }

        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
        public int getEcpm() {
            return AdViewSpreadAdapter.this.getAdSource().getECPM();
        }

        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
        public boolean isAdReady() {
            return (AdViewSpreadAdapter.this.isShow || AdViewSpreadAdapter.this.adFillingTime == 0 || DeviceUtil.getBootTime() - AdViewSpreadAdapter.this.adFillingTime >= 1800000) ? false : true;
        }

        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
        public void show(Activity activity, ViewGroup viewGroup) {
            if (AdViewSpreadAdapter.this.isShow) {
                return;
            }
            if (AdViewSpreadAdapter.this.getEventListener() instanceof AdViewSpreadListener) {
                DeviceUtil.postUIDelayed(6000L, new AZkASS(0, this));
            }
            AdViewSpreadAdapter.this.reportRequestShow();
            boolean z = true;
            AdViewSpreadAdapter.this.isShow = true;
            if (activity != null) {
                try {
                    AdViewSpreadAdapter.this.setContext((Context) activity);
                } catch (Exception e) {
                    e.printStackTrace();
                    AdViewSpreadAdapter.this.onAdFailed(new YdError(ErrorCodeConstant.RENDER_ERROR, e.getMessage()));
                    return;
                }
            }
            String str = AdViewSpreadAdapter.this.TAG;
            StringBuilder sb = new StringBuilder("spreadLoadListener show:");
            if (viewGroup != null) {
                z = false;
            }
            sb.append(z);
            LogcatUtil.d(str, sb.toString());
            AdViewSpreadAdapter.this.loadAdView(viewGroup);
        }

        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
        public void show(ViewGroup viewGroup) {
            Activity activityOrNull = AdViewSpreadAdapter.this.getActivityOrNull();
            if (activityOrNull == null) {
                activityOrNull = DeviceUtil.getTopActivity();
            }
            LogcatUtil.d(AdViewSpreadAdapter.this.TAG, "spreadLoadListener show:" + activityOrNull + AdViewSpreadAdapter.this.isShow);
            show(activityOrNull, viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(SpreadLoadListener spreadLoadListener) {
        spreadLoadListener.onADLoaded(loadSpreadAd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$1() {
        loadAdView((ViewGroup) getBuilderFieldOptional(new AZOQYO(6)).orElse(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdView(ViewGroup viewGroup) {
        LogcatUtil.d(this.TAG, "loadAdView");
        if (viewGroup == null) {
            onAdFailed(new YdError(ErrorCodeConstant.SPREAD_VIEW_GROUP_ERROR, "container is null"));
            return;
        }
        View view = this.mView;
        if (view == null) {
            AdViewLoadListener adViewLoadListener = this.mAdViewLoadListener;
            if (adViewLoadListener == null) {
                onAdFailed(new YdError(ErrorCodeConstant.RENDER_ERROR, "Ad filling Exception"));
                return;
            } else {
                adViewLoadListener.AdViewLoad(viewGroup);
                LogcatUtil.d(this.TAG, "viewGroup AdViewLoad");
                return;
            }
        }
        viewGroup.addView(view, ViewHelper.getMatchParent());
        LogcatUtil.d(this.TAG, "viewGroup getWidth" + viewGroup.getWidth());
        LogcatUtil.d(this.TAG, "viewGroup getHeight" + viewGroup.getHeight());
        LogcatUtil.d(this.TAG, "viewGroup addView");
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
    }

    public ViewGroup getContainer() {
        return (ViewGroup) getBuilderFieldOptional(new AZOQYO(6)).orElse(null);
    }

    public int getHeightDP() {
        return DeviceUtil.px2dip(getHeightPX());
    }

    public int getHeightPX() {
        int i = this.renderHeight;
        if (i > 0) {
            return i;
        }
        float floatValue = ((Float) getBuilderFieldOptional(new AZOQYO(5)).orElse(Float.valueOf(1.0f))).floatValue();
        int intValue = ((Integer) getBuilderFieldOptional(new AZOQYO(7)).orElse(0)).intValue();
        this.renderHeight = intValue <= 0 ? (int) (DeviceUtil.getMobileHeight() * floatValue) : DeviceUtil.dip2px(intValue);
        return this.renderHeight;
    }

    public float getScreenPercentage() {
        try {
            return ((Float) getBuilderFieldOptional(new AZOQYO(5)).orElse(Float.valueOf(1.0f))).floatValue();
        } catch (Exception unused) {
            return 1.0f;
        }
    }

    public ISplashEyeAd getSplashEyeAd() {
        return null;
    }

    public int getWidthDP() {
        return DeviceUtil.px2dip(this.renderWidth);
    }

    public int getWidthPX() {
        return this.renderWidth;
    }

    public boolean isAdReady() {
        return (this.isShow || this.adFillingTime == 0 || DeviceUtil.getBootTime() - this.adFillingTime >= 1800000) ? false : true;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    public SpreadLoadListener.SpreadAd loadSpreadAd() {
        LogcatUtil.d(this.TAG, "loadSpreadAd");
        if (this.spreadAd == null) {
            this.spreadAd = new SpreadLoadAd();
        }
        return this.spreadAd;
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter, com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.interfaces.AdViewListener
    public void onAdFailed(YdError ydError) {
        super.onAdFailed(ydError);
        this.hasCallbackClose = true;
        if (getEventListener() instanceof AdViewVideoListener) {
            YdAdTempHelper.getInstance().closeSpreadSpread(getAdSource().req_id);
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onClickedEvent() {
        super.onClickedEvent();
        AdViewListener eventListener = getEventListener();
        if (!(eventListener instanceof AdViewVideoListener)) {
            if (eventListener instanceof AdViewSpreadListener) {
                ((AdViewSpreadListener) eventListener).onAdClick("");
            }
        } else {
            AdViewVideoListener adViewVideoListener = (AdViewVideoListener) eventListener;
            adViewVideoListener.onAdClick("");
            if (getAdSource().reward_callback_option == 2) {
                adViewVideoListener.onVideoReward(getAdSource().getECPM());
            }
        }
    }

    public void onClosedEvent() {
        if (!this.isSelect || this.hasCallbackClose) {
            return;
        }
        this.hasCallbackClose = true;
        AdViewListener eventListener = getEventListener();
        if (!(eventListener instanceof AdViewVideoListener)) {
            if (eventListener instanceof AdViewSpreadListener) {
                ((AdViewSpreadListener) eventListener).onAdClose();
            }
        } else {
            AdViewVideoListener adViewVideoListener = (AdViewVideoListener) eventListener;
            adViewVideoListener.onAdClose();
            if (getAdSource().reward_callback_option == 1) {
                adViewVideoListener.onVideoReward(getAdSource().getECPM());
            }
            YdAdTempHelper.getInstance().closeSpreadSpread(getAdSource().req_id);
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onShowEvent() {
        super.onShowEvent();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onAdShow();
        } else if (eventListener instanceof AdViewSpreadListener) {
            ((AdViewSpreadListener) eventListener).onAdDisplay();
        }
    }

    public void onSpreadLoadedEvent(View view) {
        onSpreadLoadedEvent(view, null);
    }

    public void setSoundEnable(boolean z) {
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        LogcatUtil.d(this.TAG, "show");
        super.showAd();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            loadSpreadAd();
            ((AdViewVideoListener) eventListener).onVideoPrepared();
        } else if (eventListener instanceof AdViewSpreadListener) {
            getBuilderFieldOptional(new AZOQYO(8)).ifPresentOrElse(new A2egSU(4, this), new AZkASS(2, this));
        }
    }

    public void startActivityShow(Activity activity) {
        LogcatUtil.d(this.TAG, "startActivityShow");
        if (this.spreadAd == null || activity == null) {
            onAdFailed(new YdError(ErrorCodeConstant.NULL_ERROR, "展示广告失败"));
            return;
        }
        YdAdTempHelper.getInstance().setSpreadAd(this.spreadAd);
        Intent intent = new Intent(activity, (Class<?>) YdSpreadActivity.class);
        intent.putExtra(f.f13353a, getAdSource().req_id);
        activity.startActivity(intent);
    }

    public void onClickedEvent(String str) {
        super.onClickedEvent();
        AdViewListener eventListener = getEventListener();
        if (!(eventListener instanceof AdViewVideoListener)) {
            if (eventListener instanceof AdViewSpreadListener) {
                ((AdViewSpreadListener) eventListener).onAdClick(str);
            }
        } else {
            AdViewVideoListener adViewVideoListener = (AdViewVideoListener) eventListener;
            adViewVideoListener.onAdClick(str);
            if (getAdSource().reward_callback_option == 2) {
                adViewVideoListener.onVideoReward(getAdSource().getECPM());
            }
        }
    }

    public void onSpreadLoadedEvent(View view, AdViewLoadListener adViewLoadListener) {
        this.adFillingTime = DeviceUtil.getBootTime();
        this.mView = view;
        this.mAdViewLoadListener = adViewLoadListener;
        super.onLoadedEvent();
    }
}
