package com.fl.saas.base.manager;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.fl.saas.base.adapter.AZOQYO;
import com.fl.saas.base.adapter.AdViewFullVideoAdapter;
import com.fl.saas.base.base.builder.InnerFullVideoBuilder;
import com.fl.saas.base.interfaces.AdViewFullVideoListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdViewFullVideoManager extends BuilderLoadManager<InnerFullVideoBuilder<?>, AdViewFullVideoAdapter, AdViewFullVideoListener> {
    private boolean isRequestAd;

    public AdViewFullVideoManager() {
        super(AdType.FullVideo);
        this.isRequestAd = false;
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewFullVideoListener initProxyEventListener(InnerFullVideoBuilder<?> innerFullVideoBuilder) {
        final AdViewFullVideoListener eventListener = innerFullVideoBuilder.getEventListener();
        return new AdViewFullVideoListener() { // from class: com.fl.saas.base.manager.AdViewFullVideoManager.1
            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onAdClicked() {
                LogcatUtil.d("YdSDK-FullVideo", IAdInterListener.AdCommandType.AD_CLICK);
                AdViewFullVideoListener adViewFullVideoListener = eventListener;
                if (adViewFullVideoListener == null) {
                    return;
                }
                adViewFullVideoListener.onAdClicked();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d("YdSDK-FullVideo", "onAdFailed: " + ydError);
                AdViewFullVideoListener adViewFullVideoListener = eventListener;
                if (adViewFullVideoListener == null) {
                    return;
                }
                adViewFullVideoListener.onAdFailed(ydError);
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onPageDismiss() {
                LogcatUtil.d("YdSDK-FullVideo", "onAdClose");
                AdViewFullVideoListener adViewFullVideoListener = eventListener;
                if (adViewFullVideoListener == null) {
                    return;
                }
                adViewFullVideoListener.onPageDismiss();
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onVideoPlayStart() {
                LogcatUtil.d("YdSDK-FullVideo", "onAdShow");
                AdViewFullVideoListener adViewFullVideoListener = eventListener;
                if (adViewFullVideoListener == null) {
                    return;
                }
                adViewFullVideoListener.onVideoPlayStart();
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onVideoPrepared() {
                LogcatUtil.d("YdSDK-FullVideo", "onVideoPrepared");
                AdViewFullVideoListener adViewFullVideoListener = eventListener;
                if (adViewFullVideoListener == null) {
                    return;
                }
                adViewFullVideoListener.onVideoPrepared();
            }
        };
    }

    public boolean isReady() {
        return ((Boolean) getValidAdapter().map(new AZOQYO(23)).orElse(Boolean.FALSE)).booleanValue();
    }

    public void show() {
        if (!this.isRequestAd) {
            LogcatUtil.d("YdSDK-Video", "调用show()方法前，必须先调用requestAd()方法");
            onAdFailed(new YdError(ErrorCodeConstant.METHOD_ERROR, "未执行requestAd()方法"));
        } else if (isReady()) {
            getValidAdapter().ifPresent(new KiXkPs.A2egSU(26));
        } else {
            LogcatUtil.d("YdSDK-Video", "调用show()方法前，必须先检查isReady()状态，或者在onVideoPrepared()回调后调用");
            onAdFailed(new YdError(ErrorCodeConstant.METHOD_ERROR, "调用show()方法前，必须先检查isReady()状态，或者在onVideoPrepared()回调后调用"));
        }
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager, com.fl.saas.base.manager.api.ManagerAPI
    public void request(InnerFullVideoBuilder<?> innerFullVideoBuilder) {
        super.request((AdViewFullVideoManager) innerFullVideoBuilder);
        this.isRequestAd = true;
    }
}
