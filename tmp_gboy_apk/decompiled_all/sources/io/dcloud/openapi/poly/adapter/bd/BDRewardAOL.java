package io.dcloud.openapi.poly.adapter.bd;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.Const;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class BDRewardAOL extends DCBaseAOLLoader implements RewardVideoAd.RewardVideoAdListener {

    /* renamed from: a, reason: collision with root package name */
    public RewardVideoAd f13935a;

    public BDRewardAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    public final /* synthetic */ void a() {
        this.f13935a.show();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        RewardVideoAd rewardVideoAd = this.f13935a;
        if (rewardVideoAd != null) {
            rewardVideoAd.biddingFail(i3 == 2 ? "203" : i3 == 1 ? "100" : "900");
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        RewardVideoAd rewardVideoAd = this.f13935a;
        if (rewardVideoAd != null) {
            rewardVideoAd.biddingSuccess(String.valueOf(i2));
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void destroy() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final String getType() {
        return Const.TYPE_BD;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void init(String str, String str2) {
        BDInit.getInstance().init(getActivity(), str);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final boolean isValid() {
        RewardVideoAd rewardVideoAd = this.f13935a;
        return rewardVideoAd != null && rewardVideoAd.isReady();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void load() {
        RewardVideoAd rewardVideoAd = new RewardVideoAd(getActivity(), getSlotId(), this);
        this.f13935a = rewardVideoAd;
        rewardVideoAd.setDownloadAppConfirmPolicy(1);
        this.f13935a.setShowDialogOnSkip(true);
        if (!TextUtils.isEmpty(getSlot().getUserId())) {
            this.f13935a.setUserId(getSlot().getUserId());
        }
        if (!TextUtils.isEmpty(getSlot().getExtra())) {
            this.f13935a.setExtraInfo(getSlot().getExtra());
        }
        this.f13935a.load();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClick() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClose(float f) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdFailed(String str) {
        loadFail(-1, str);
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdLoaded() {
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdShow() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdSkip(float f) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
    public void onRewardVerify(boolean z) {
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

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadFailed() {
        loadFail(-1, "缓存物料失败");
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadSuccess() {
        float parseInt;
        if (this.f13935a != null && isSlotSupportBidding()) {
            String eCPMLevel = this.f13935a.getECPMLevel();
            if (!TextUtils.isEmpty(eCPMLevel)) {
                try {
                    try {
                        parseInt = Float.parseFloat(eCPMLevel);
                    } catch (Exception unused) {
                        parseInt = Integer.parseInt(eCPMLevel);
                    }
                } catch (Exception unused2) {
                }
                setBiddingECPM((int) parseInt);
            }
            parseInt = -1.0f;
            setBiddingECPM((int) parseInt);
        }
        loadSuccess();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void playCompletion() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void show(Activity activity) {
        if (activity == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else if (isValid()) {
            MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.openapi.poly.adapter.bd.A4TApA
                @Override // java.lang.Runnable
                public final void run() {
                    BDRewardAOL.this.a();
                }
            });
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }
}
