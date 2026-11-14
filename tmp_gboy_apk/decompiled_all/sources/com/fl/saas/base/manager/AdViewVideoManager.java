package com.fl.saas.base.manager;

import android.app.Activity;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.fl.saas.base.adapter.AZOQYO;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
import com.fl.saas.base.adapter.AdViewVideoAdapter;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.base.builder.InnerVideoBuilder;
import com.fl.saas.base.interfaces.AdViewVideoCheckListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdViewVideoManager extends BuilderLoadManager<InnerVideoBuilder<?>, AdViewVideoAdapter, AdViewVideoListener> {
    private boolean isRequestAd;
    private boolean isVerifyDone;

    /* renamed from: com.fl.saas.base.manager.AdViewVideoManager$1, reason: invalid class name */
    public class AnonymousClass1 implements AdViewVideoListener {
        final /* synthetic */ AdViewVideoListener val$adViewAdInterface;
        final /* synthetic */ InnerVideoBuilder val$builder;
        final /* synthetic */ AdViewVideoCheckListener val$mCheckListener;

        public AnonymousClass1(InnerVideoBuilder innerVideoBuilder, AdViewVideoListener adViewVideoListener, AdViewVideoCheckListener adViewVideoCheckListener) {
            this.val$builder = innerVideoBuilder;
            this.val$adViewAdInterface = adViewVideoListener;
            this.val$mCheckListener = adViewVideoCheckListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAdShow$0() {
            AdViewVideoManager.this.isVerifyDone = true;
        }

        @Override // com.fl.saas.base.base.listener.InnerVideoListener
        public void onAdClick(String str) {
            LogcatUtil.d("YdSDK-Video", IAdInterListener.AdCommandType.AD_CLICK);
            AdViewVideoListener adViewVideoListener = this.val$adViewAdInterface;
            if (adViewVideoListener == null) {
                return;
            }
            adViewVideoListener.onAdClick(str);
        }

        @Override // com.fl.saas.base.base.listener.InnerVideoListener
        public void onAdClose() {
            LogcatUtil.d("YdSDK-Video", "onAdClose");
            AdViewVideoListener adViewVideoListener = this.val$adViewAdInterface;
            if (adViewVideoListener == null) {
                return;
            }
            adViewVideoListener.onAdClose();
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            LogcatUtil.d("YdSDK-Video", "onAdFailed: " + ydError);
            AdViewVideoListener adViewVideoListener = this.val$adViewAdInterface;
            if (adViewVideoListener == null) {
                return;
            }
            adViewVideoListener.onAdFailed(ydError);
        }

        @Override // com.fl.saas.base.base.listener.InnerVideoListener
        public void onAdShow() {
            LogcatUtil.d("YdSDK-Video", "onAdShow");
            AdapterAPI showAdapter = AdViewVideoManager.this.getShowAdapter();
            String userId = this.val$builder.getUserId();
            if (AdViewVideoManager.this.isServerVerify() && showAdapter != null) {
                LogcatUtil.d("YdSDK-Video", "reqVideoVerify");
                AdSource adSource = showAdapter.getAdSource();
                int price = adSource.getPrice();
                ConfigHelper.getInstance().reqVideoVerify(userId, this.val$builder.getCustomData(), DeviceUtil.appId, this.val$builder.getKey(), adSource.req_id, price + "", new A5SV6n(this));
            }
            AdViewVideoListener adViewVideoListener = this.val$adViewAdInterface;
            if (adViewVideoListener == null) {
                return;
            }
            adViewVideoListener.onAdShow();
        }

        @Override // com.fl.saas.base.base.listener.InnerVideoListener
        public void onSkipVideo() {
            LogcatUtil.d("YdSDK-Video", "onSkipVideo");
            AdViewVideoListener adViewVideoListener = this.val$adViewAdInterface;
            if (adViewVideoListener == null) {
                return;
            }
            adViewVideoListener.onSkipVideo();
        }

        @Override // com.fl.saas.base.base.listener.InnerVideoListener
        public void onVideoCompleted() {
            LogcatUtil.d("YdSDK-Video", "onVideoCompleted");
            AdViewVideoListener adViewVideoListener = this.val$adViewAdInterface;
            if (adViewVideoListener == null) {
                return;
            }
            adViewVideoListener.onVideoCompleted();
        }

        @Override // com.fl.saas.base.base.listener.InnerVideoListener
        public void onVideoPrepared() {
            LogcatUtil.d("YdSDK-Video", "onVideoPrepared");
            AdViewVideoListener adViewVideoListener = this.val$adViewAdInterface;
            if (adViewVideoListener == null) {
                return;
            }
            adViewVideoListener.onVideoPrepared();
        }

        @Override // com.fl.saas.base.base.listener.InnerVideoListener
        public void onVideoReward(double d) {
            AdViewVideoCheckListener adViewVideoCheckListener;
            LogcatUtil.d("YdSDK-Video", "onVideoReward:" + d);
            if (AdViewVideoManager.this.isServerVerify() && AdViewVideoManager.this.isVerifyDone && (adViewVideoCheckListener = this.val$mCheckListener) != null) {
                adViewVideoCheckListener.onVideoCheckReward(AdViewVideoManager.this.getReqId());
            }
            AdViewVideoListener adViewVideoListener = this.val$adViewAdInterface;
            if (adViewVideoListener == null) {
                return;
            }
            adViewVideoListener.onVideoReward(d);
        }
    }

    public AdViewVideoManager() {
        super(AdType.RewardVideo);
        this.isRequestAd = false;
        this.isVerifyDone = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isServerVerify() {
        return ((Boolean) Optional.ofNullable(getAdPlace()).map(new AZOQYO(28)).orElse(Boolean.FALSE)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isServerVerify$0(AdPlace adPlace) {
        return Boolean.valueOf(adPlace.server_verify);
    }

    public boolean isReady() {
        try {
            AdapterAPI showAdapter = getShowAdapter();
            if (showAdapter instanceof AdViewVideoAdapter) {
                return ((AdViewVideoAdapter) showAdapter).isVideoReady();
            }
            if (showAdapter instanceof AdViewInterstitialAdapter) {
                return ((AdViewInterstitialAdapter) showAdapter).isIntersReady();
            }
            if (showAdapter instanceof AdViewSpreadAdapter) {
                return ((AdViewSpreadAdapter) showAdapter).isAdReady();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public void show() {
        show(null);
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewVideoListener initProxyEventListener(InnerVideoBuilder<?> innerVideoBuilder) {
        return new AnonymousClass1(innerVideoBuilder, innerVideoBuilder.getEventListener(), innerVideoBuilder.getCheckListener());
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager, com.fl.saas.base.manager.api.ManagerAPI
    public void request(InnerVideoBuilder<?> innerVideoBuilder) {
        super.request((AdViewVideoManager) innerVideoBuilder);
        this.isRequestAd = true;
    }

    public void show(Activity activity) {
        if (!this.isRequestAd) {
            LogcatUtil.d("YdSDK-Video", "调用show()方法前，必须先调用requestAd()方法");
            onAdFailed(new YdError(ErrorCodeConstant.METHOD_ERROR, "未执行requestAd()方法"));
            return;
        }
        if (!isReady()) {
            LogcatUtil.d("YdSDK-Video", "调用show()方法前，必须先检查isReady()状态，或者在onVideoPrepared()回调后调用");
            onAdFailed(new YdError(ErrorCodeConstant.METHOD_ERROR, "调用show()方法前，必须先检查isReady()状态，或者在onVideoPrepared()回调后调用"));
            return;
        }
        try {
            AdapterAPI showAdapter = getShowAdapter();
            if (showAdapter instanceof AdViewVideoAdapter) {
                AdViewVideoAdapter adViewVideoAdapter = (AdViewVideoAdapter) showAdapter;
                if (activity == null) {
                    adViewVideoAdapter.showVideoAd();
                    return;
                } else {
                    adViewVideoAdapter.showVideoAd(activity);
                    return;
                }
            }
            if (showAdapter instanceof AdViewInterstitialAdapter) {
                AdViewInterstitialAdapter adViewInterstitialAdapter = (AdViewInterstitialAdapter) showAdapter;
                if (activity == null) {
                    activity = DeviceUtil.getTopActivity();
                }
                adViewInterstitialAdapter.showInterstitialAd(activity);
                return;
            }
            if (showAdapter instanceof AdViewSpreadAdapter) {
                AdViewSpreadAdapter adViewSpreadAdapter = (AdViewSpreadAdapter) showAdapter;
                if (activity == null) {
                    activity = DeviceUtil.getTopActivity();
                }
                adViewSpreadAdapter.startActivityShow(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
