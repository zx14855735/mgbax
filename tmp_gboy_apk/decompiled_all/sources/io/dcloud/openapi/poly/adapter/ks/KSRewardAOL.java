package io.dcloud.openapi.poly.adapter.ks;

import android.app.Activity;
import android.text.TextUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.Const;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class KSRewardAOL extends DCBaseAOLLoader implements KsLoadManager.RewardVideoAdListener, KsRewardVideoAd.RewardAdInteractionListener {

    /* renamed from: a, reason: collision with root package name */
    public KsRewardVideoAd f13991a;

    public KSRewardAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13991a != null) {
            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
            adExposureFailedReason.winEcpm = i;
            this.f13991a.reportAdExposureFailed(2, adExposureFailedReason);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        KsRewardVideoAd ksRewardVideoAd = this.f13991a;
        if (ksRewardVideoAd != null) {
            ksRewardVideoAd.setBidEcpm(i, i2);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getType() {
        return "ks";
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
        KSInit.getInstance().init(getActivity(), str);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        KsRewardVideoAd ksRewardVideoAd = this.f13991a;
        return ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        long j;
        String slotId = getSlotId();
        if (TextUtils.isEmpty(slotId)) {
            loadFail(-9999, "");
            return;
        }
        try {
            j = Long.parseLong(slotId);
        } catch (Exception unused) {
            j = 0;
        }
        if (j <= 0) {
            loadFail(-9999, "");
            return;
        }
        KsScene.Builder adNum = new KsScene.Builder(j).adNum(1);
        if (KSInit.getInstance().getPrivacyConfig() != null && !KSInit.getInstance().getPrivacyConfig().isCanUseSensor()) {
            adNum.setSensorType(-1);
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(getSlot().getUserId())) {
            hashMap.put("thirdUserId", getSlot().getUserId());
        }
        if (!TextUtils.isEmpty(getSlot().getExtra())) {
            hashMap.put("extraData", getSlot().getExtra());
        }
        if (hashMap.size() > 0) {
            adNum.rewardCallbackExtraData(hashMap);
        }
        try {
            KsAdSDK.getLoadManager().loadRewardVideoAd(adNum.build(), this);
        } catch (Exception unused2) {
            loadFail(-9999, "");
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
    public void onError(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onExtraRewardVerify(int i) {
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    public void onRequestResult(int i) {
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardStepVerify(int i, int i2) {
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(Map<String, Object> map) {
    }

    @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
    public void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
        if (list == null || list.size() <= 0) {
            loadFail(-40003, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        KsRewardVideoAd ksRewardVideoAd = list.get(0);
        this.f13991a = ksRewardVideoAd;
        ksRewardVideoAd.setRewardAdInteractionListener(this);
        if (isSlotSupportBidding()) {
            setBiddingECPM(this.f13991a.getECPM());
        }
        loadSuccess();
    }

    @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
    public void onRewardVideoResult(List<KsRewardVideoAd> list) {
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + "code:" + i + ";message:" + i2);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoSkipToEnd(long j) {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void show(Activity activity) {
        if (activity == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else if (isValid()) {
            this.f13991a.showRewardVideoAd(activity, new KsVideoPlayConfig.Builder().showLandscape(getSlot().getOrientation() != 1).build());
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        if (getVideoAdCallback() instanceof AOLLoader.RewVAOLInteractionListener) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("provider", Const.PROVIDER_TYPE_CHINA);
            } catch (JSONException unused) {
            }
            ((AOLLoader.RewVAOLInteractionListener) getVideoAdCallback()).onReward(jSONObject);
        }
    }
}
