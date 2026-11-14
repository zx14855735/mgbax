package io.dcloud.openapi.poly.adapter.csj;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.Const;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class CSJRewardAOL extends DCBaseAOLLoader implements TTAdNative.RewardVideoAdListener, TTRewardVideoAd.RewardAdInteractionListener {

    /* renamed from: a, reason: collision with root package name */
    public TTRewardVideoAd f13957a;
    public String b;

    public CSJRewardAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
        if (this.f13957a != null) {
            this.f13957a = null;
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
        this.b = str;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        if (this.f13957a != null) {
            return !Const.TYPE_CSJ.equals(getType()) || this.f13957a.getExpirationTimestamp() > System.currentTimeMillis();
        }
        return false;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        CSJInit.getInstance().init(getActivity(), this.b, getType(), new TTAdSdk.InitCallback() { // from class: io.dcloud.openapi.poly.adapter.csj.CSJRewardAOL.1
            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int i, String str) {
                CSJRewardAOL.this.loadFail(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
                TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(CSJRewardAOL.this.getActivity());
                AdSlot.Builder orientation = new AdSlot.Builder().setCodeId(CSJRewardAOL.this.getSlotId()).setSupportDeepLink(true).setUserID("").setImageAcceptedSize(1080, 1920).setExpressViewAcceptedSize(720.0f, 1280.0f).setOrientation(CSJRewardAOL.this.getSlot().getOrientation() != 1 ? 2 : 1);
                if (!TextUtils.isEmpty(CSJRewardAOL.this.getSlot().getExtra())) {
                    orientation.setMediaExtra(CSJRewardAOL.this.getSlot().getExtra());
                    orientation.setMediationAdSlot(new MediationAdSlot.Builder().setExtraObject("gromoreExtra", CSJRewardAOL.this.getSlot().getExtra()).build());
                }
                if (!TextUtils.isEmpty(CSJRewardAOL.this.getSlot().getUserId())) {
                    orientation.setUserID(CSJRewardAOL.this.getSlot().getUserId());
                }
                CSJRewardAOL.this.startLoadTime();
                createAdNative.loadRewardVideoAd(orientation.build(), CSJRewardAOL.this);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onError(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardArrived(boolean z, int i, Bundle bundle) {
        if (getVideoAdCallback() instanceof AOLLoader.RewVAOLInteractionListener) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("provider", Const.PROVIDER_TYPE_CHINA);
                jSONObject.put("isValid", z);
            } catch (JSONException unused) {
            }
            ((AOLLoader.RewVAOLInteractionListener) getVideoAdCallback()).onReward(jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, AOLErrorUtil.getErrorMsg(-5100));
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void show(Activity activity) {
        if (activity == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else if (isValid()) {
            this.f13957a.showRewardVideoAd(activity);
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
        this.f13957a = tTRewardVideoAd;
        tTRewardVideoAd.setRewardAdInteractionListener(this);
        loadSuccess();
    }
}
