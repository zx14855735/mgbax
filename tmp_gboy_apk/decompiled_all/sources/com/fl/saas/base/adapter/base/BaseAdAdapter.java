package com.fl.saas.base.adapter.base;

import ADYaiT.CtFAbx;
import COJEAR.AZOQYO;
import android.app.Activity;
import android.content.Context;
import com.fl.saas.base.adapter.AdViewAdapter;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.bean.MaterialBean;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.manager.loader.AdViewManager;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.common.widget.h5.QuickAppHelper;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BaseAdAdapter<S extends AdViewListener> implements AdapterAPI, ReportEventListener {
    private WeakReference<Activity> activityRef;
    private AdViewAdapter mAdAdapter;
    private AdMaterial.AdMaterialData mAdMaterialData;
    protected AdSource mAdSource;
    private Context mContext;
    private long reqTime;
    private final String TAG = CommConstant.getObjTag(this);
    private boolean isCache = false;
    public boolean isSelect = false;
    private boolean isFailedCallBack = false;
    private boolean isReportExposure = false;

    public BaseAdAdapter() {
        createAdapter();
    }

    private void createAdapter() {
        if (this.mAdAdapter == null) {
            this.mAdAdapter = new AdViewAdapter();
        }
        AdSource adSource = this.mAdSource;
        if (adSource != null) {
            this.mAdAdapter.biddingRestAdSource(adSource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getActivityValid$0(Activity activity) {
        return !activity.isFinishing();
    }

    private void loadSuccessEvent() {
        LogcatUtil.d(this.TAG, "onLoadedEvent");
        this.mAdSource.responseTime = DeviceUtil.getBootTime() - this.reqTime;
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            adViewAdapter.onSuccess(this);
        }
    }

    private void reportMaterial() {
        AdMaterial.AdMaterialData materialData;
        if (!DeviceUtil.isContainMaterial(getAdSource().adv_id) || (materialData = getMaterialData()) == null) {
            return;
        }
        AdHttpUtils.getInstance().doPost(CommConstant.API.REPORT_MATERIAL, AdHttpUtils.reqObjToStr(new MaterialBean(getAdSource(), materialData)), new HttpCallbackStringListener() { // from class: com.fl.saas.base.adapter.base.BaseAdAdapter.1
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    BaseAdAdapter.this.mAdSource.creative_id = jSONObject.optString("creative_id");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void bindC2SBidECPM(Supplier<Integer> supplier) {
        int i;
        if (!getAdSource().isC2SBidAd || supplier == null) {
            return;
        }
        try {
            i = supplier.get().intValue();
        } catch (Exception e) {
            e.printStackTrace();
            LogcatUtil.e(this.TAG, "bindC2SBidECPM is exception, " + getAdSource());
            i = 0;
        }
        this.mAdSource.price = Math.max(i, 0);
    }

    public boolean canUseEcpm() {
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            return adViewAdapter.canUseEcpm();
        }
        return true;
    }

    public boolean changeReRequestCount() {
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            return adViewAdapter.changeReRequestCount();
        }
        return false;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public void clearCache() {
        this.isCache = false;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public void destroy() {
    }

    public void disposeError(ErrorInfo errorInfo) {
        LogcatUtil.d(this.TAG, "disposeError:" + errorInfo);
        if (this.isSelect && !this.isFailedCallBack) {
            this.isFailedCallBack = true;
            onAdFailed(YdError.create(errorInfo.code, errorInfo.errorType, errorInfo.msg));
        }
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            adViewAdapter.onFailed(this, errorInfo);
        }
    }

    public Activity getActivityOrNull() {
        WeakReference<Activity> weakReference = this.activityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Optional<Activity> getActivityValid() {
        return Optional.ofNullable(this.activityRef).map(new AZOQYO(7)).filter(new com.fl.saas.base.adapter.AZOQYO(12));
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public AdSource getAdSource() {
        return this.mAdSource;
    }

    public String getAppId() {
        return getAdSource().app_id;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getExt() {
        return this.mAdSource.getExt();
    }

    public abstract String getKey();

    /* JADX WARN: Multi-variable type inference failed */
    public AdMaterial.AdMaterialData getMaterialData() {
        AdMaterial.AdMaterialData adMaterialData = this.mAdMaterialData;
        if (adMaterialData != null) {
            return adMaterialData;
        }
        if (this instanceof AdMaterial) {
            this.mAdMaterialData = ((AdMaterial) this).getAdMaterialData();
        }
        return this.mAdMaterialData;
    }

    public String getPosId() {
        return getAdSource().tagid;
    }

    public WinAdInfo getWinInfo() {
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            return adViewAdapter.getWinInfo();
        }
        return null;
    }

    public abstract void handle(Activity activity);

    @Override // com.fl.saas.base.base.AdapterAPI
    public boolean isCache() {
        return this.isCache;
    }

    public boolean isCheckActivity() {
        return true;
    }

    public boolean isFullScreenInterstitial() {
        return getAdSource().isFullScreenInterstitial();
    }

    public boolean isReRequest() {
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            return adViewAdapter.isReRequest();
        }
        return false;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public void load() {
        try {
            Activity activityOrNull = getActivityOrNull();
            if (activityOrNull == null) {
                activityOrNull = DeviceUtil.getTopActivity();
            }
            if (this.mContext == null || (isCheckActivity() && activityOrNull == null)) {
                onAdFailed(YdError.create(ErrorCodeConstant.CONTEXT_ERROR, "adapter is not ready, context exception"));
                return;
            }
            long bootTime = DeviceUtil.getBootTime();
            this.reqTime = bootTime;
            AdSource adSource = this.mAdSource;
            if (adSource != null) {
                adSource.reqTime = bootTime;
            }
            onRequest();
            handle(activityOrNull);
        } catch (Exception e) {
            e.printStackTrace();
            onAdFailed(YdError.create(ErrorCodeConstant.CONTEXT_ERROR, "adapter is not ready, context exception"));
        }
    }

    public abstract void onAdFailed(YdError ydError);

    public void onClickedEvent() {
        LogcatUtil.d(this.TAG, "onClickedEvent");
        QuickAppHelper.getInstance().setAdSource(this.mAdSource);
        ReportHelper.getInstance().reportClick(this.mAdSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLoadedEvent() {
        AdSource adSource = this.mAdSource;
        if (adSource == null) {
            return;
        }
        if (adSource.isC2SBidAd && adSource.isFilterBidFloor()) {
            int price = this.mAdSource.getPrice();
            int i = this.mAdSource.bidfloor;
            if (price < i) {
                if (this instanceof BiddingResult) {
                    ((BiddingResult) this).biddingResult(false, i, 0, 0);
                }
                disposeError(new YdError(ErrorCodeConstant.PRICE_ERROR, "Bid below reserve price"));
                return;
            }
        }
        loadSuccessEvent();
    }

    public void onRequest() {
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            adViewAdapter.sendRequestMsg();
        }
    }

    public void onShowEvent() {
        if (this.isReportExposure) {
            return;
        }
        this.isReportExposure = true;
        LogcatUtil.d(this.TAG, "onShowEvent");
        ReportHelper.getInstance().reportDisplay(this.mAdSource);
        reportMaterial();
        ConfigHelper.getInstance().addShowCount();
    }

    @Override // com.fl.saas.base.base.AdapterAPI, com.fl.saas.base.adapter.base.ReportEventListener
    public void reportRequestShow() {
        ReportHelper.getInstance().reportRequestShow(this.mAdSource);
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public BaseAdAdapter<S> setAdAdapter(AdViewManager adViewManager) {
        createAdapter();
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            adViewAdapter.setAdViewManager(adViewManager);
        }
        return this;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public BaseAdAdapter<S> setAdSource(AdSource adSource) {
        if (this.isCache) {
            return this;
        }
        this.mAdSource = adSource;
        createAdapter();
        return this;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public void setCache() {
        this.isCache = true;
        this.activityRef = null;
        this.mAdAdapter = null;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public BaseAdAdapter<S> setContext(Context context) {
        if (!(context instanceof Activity)) {
            this.mContext = context;
            return this;
        }
        this.activityRef = new WeakReference<>((Activity) context);
        this.mContext = context.getApplicationContext();
        return this;
    }

    public void setECPM(int i) {
        this.mAdSource.price = Math.max(i, 0);
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        if (this.isSelect) {
            LogcatUtil.d(this.TAG, "multiple show");
        } else {
            this.isSelect = true;
            this.isCache = false;
        }
    }

    public void disposeError(YdError ydError) {
        LogcatUtil.d(this.TAG, "disposeError: " + ydError);
        if (this.isSelect) {
            if (this.isFailedCallBack) {
                return;
            }
            this.isFailedCallBack = true;
            onAdFailed(ydError);
            return;
        }
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.adv_id = CtFAbx.AZkASS("", this.mAdSource.adv_id, new StringBuilder());
        errorInfo.tagid = this.mAdSource.tagid;
        errorInfo.code = ydError.getCode();
        errorInfo.errorType = ydError.getErrorType();
        errorInfo.msg = ydError.getMsg();
        disposeError(errorInfo);
    }
}
