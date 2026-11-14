package com.fl.saas.base.base;

import Cd8JRx.ADYaiT;
import android.os.Handler;
import android.os.Looper;
import com.czhj.sdk.common.Constants;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.interfaces.AdLoadEvent;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.util.ReflectHelper;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.ConfigUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.ydsdk.api.MediaExtraInfo;
import com.fl.saas.ydsdk.manager.YdConfig;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BaseAPI<T extends BaseBuilder<?>, S extends BuilderLoadManager<T, ?, ?>> implements MediaExtraInfo {
    protected final T builder;
    protected S manager;

    public BaseAPI(T t) {
        this.builder = t;
    }

    private S createManager() {
        API api = (API) ReflectHelper.getSupperAnnotations(API.class, getClass());
        if (api == null) {
            return null;
        }
        return (S) api.value().createManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reRequest$1() {
        S s = this.manager;
        if (s == null || s.isDestroy()) {
            return;
        }
        this.manager.selectBottomAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$request$0() {
        S s = this.manager;
        if (s == null || s.isDestroy()) {
            return;
        }
        this.manager.selectBottomAd();
    }

    private void loadFailed(YdError ydError) {
        T t = this.builder;
        if (t instanceof AdLoadEvent) {
            ((AdLoadEvent) t).onLoadFailed(ydError);
        } else {
            t.onAdFailed(ydError);
        }
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public void biddingResultUpload(boolean z, int i, int i2) {
        S s = this.manager;
        if (s != null) {
            s.biddingResultUpload(z, i, i2);
        }
    }

    public void destroy() {
        S s = this.manager;
        if (s != null) {
            s.destroy();
        }
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public AdInfo getAdInfo() {
        S s = this.manager;
        if (s == null) {
            return null;
        }
        return s.getAdInfo();
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public int getECPM() {
        S s = this.manager;
        if (s != null) {
            return s.getEcpm();
        }
        return 0;
    }

    public int getEcpm() {
        S s = this.manager;
        if (s != null) {
            return s.getEcpm();
        }
        return 0;
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public String getMaterialJson() {
        S s = this.manager;
        return s == null ? "" : s.getMaterialJson();
    }

    public String getReqId() {
        AdPlace adPlace;
        S s = this.manager;
        return (s == null || (adPlace = s.getAdPlace()) == null) ? "" : adPlace.req_id;
    }

    public void reRequest() {
        String concat;
        YdError create;
        try {
            if (YdConfig.isInit()) {
                T t = this.builder;
                if (t == null || !ConfigUtils.checkImpressFreq(t.getKey())) {
                    ReportHelper.getInstance().reportSDKInit();
                    T t2 = this.builder;
                    if (t2 != null && t2.isValid() && this.builder.getTimeout() >= 1000) {
                        new Handler(Looper.getMainLooper()).postDelayed(new A2egSU(this, 1), this.builder.getTimeout() - 20);
                    }
                    if (Constants.FAIL.equals(DeviceUtil.getNetworkType())) {
                        create = YdError.create(ErrorCodeConstant.NETWORK_ERROR, "无网络连接");
                    } else {
                        if (this.manager == null) {
                            this.manager = createManager();
                        }
                        if (this.manager == null) {
                            concat = "manager create error: ".concat(getClass().getSimpleName());
                        } else {
                            if (this.builder.isValid()) {
                                this.manager.request(this.builder);
                                return;
                            }
                            concat = "builder is invalid";
                        }
                        create = YdError.create(ErrorCodeConstant.METHOD_ERROR, concat);
                    }
                } else {
                    create = YdError.create(ErrorCodeConstant.FREQUENCY_ERROR, "Request too frequently");
                }
            } else {
                create = YdError.create(ErrorCodeConstant.INIT_ERROR, "Please initialize the SDK first");
            }
            loadFailed(create);
        } catch (Exception e) {
            e.printStackTrace();
            loadFailed(YdError.create(ErrorCodeConstant.METHOD_ERROR, "request has error" + e.getMessage()));
        }
    }

    public void request() {
        String concat;
        YdError create;
        try {
            if (YdConfig.isInit()) {
                T t = this.builder;
                if (t == null || !ConfigUtils.checkImpressFreq(t.getKey())) {
                    ReportHelper.getInstance().reportSDKInit();
                    T t2 = this.builder;
                    if (t2 != null && t2.isValid() && this.builder.getTimeout() >= 1000) {
                        new Handler(Looper.getMainLooper()).postDelayed(new A2egSU(this, 0), this.builder.getTimeout() - 20);
                    }
                    if (Constants.FAIL.equals(DeviceUtil.getNetworkType())) {
                        create = YdError.create(ErrorCodeConstant.NETWORK_ERROR, "无网络连接");
                    } else {
                        S createManager = createManager();
                        this.manager = createManager;
                        if (createManager != null) {
                            createManager.setAdReRequestListener(new ADYaiT(10, this));
                            if (this.builder.isValid()) {
                                this.manager.request(this.builder);
                                return;
                            }
                            concat = "builder is invalid";
                        } else {
                            concat = "manager create error: ".concat(getClass().getSimpleName());
                        }
                        create = YdError.create(ErrorCodeConstant.METHOD_ERROR, concat);
                    }
                } else {
                    create = YdError.create(ErrorCodeConstant.FREQUENCY_ERROR, "Request too frequently,Please check if the advertising space has frequency control set up.");
                }
            } else {
                create = YdError.create(ErrorCodeConstant.INIT_ERROR, "Please initialize the SDK first");
            }
            loadFailed(create);
        } catch (Exception e) {
            e.printStackTrace();
            loadFailed(YdError.create(ErrorCodeConstant.METHOD_ERROR, "request has error" + e.getMessage()));
        }
    }
}
