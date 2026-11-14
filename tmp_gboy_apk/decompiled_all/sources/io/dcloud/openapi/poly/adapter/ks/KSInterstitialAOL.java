package io.dcloud.openapi.poly.adapter.ks;

import android.app.Activity;
import android.text.TextUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class KSInterstitialAOL extends DCBaseAOLLoader implements KsLoadManager.InterstitialAdListener, KsInterstitialAd.AdInteractionListener {

    /* renamed from: a, reason: collision with root package name */
    public KsInterstitialAd f13990a;

    public KSInterstitialAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13990a != null) {
            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
            adExposureFailedReason.winEcpm = i;
            this.f13990a.reportAdExposureFailed(2, adExposureFailedReason);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        KsInterstitialAd ksInterstitialAd = this.f13990a;
        if (ksInterstitialAd != null) {
            ksInterstitialAd.setBidEcpm(i);
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
        return this.f13990a != null;
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
        try {
            KsScene.Builder builder = new KsScene.Builder(j);
            if (KSInit.getInstance().getPrivacyConfig() != null && !KSInit.getInstance().getPrivacyConfig().isCanUseSensor()) {
                builder.setSensorType(-1);
            }
            KsAdSDK.getLoadManager().loadInterstitialAd(builder.build(), this);
        } catch (Exception unused2) {
            loadFail(-9999, "");
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdClosed() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdShow() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
    public void onError(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
    public void onInterstitialAdLoad(List<KsInterstitialAd> list) {
        if (list == null || list.size() <= 0) {
            loadFail(-40003, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        KsInterstitialAd ksInterstitialAd = list.get(0);
        this.f13990a = ksInterstitialAd;
        ksInterstitialAd.setAdInteractionListener(this);
        if (isSlotSupportBidding()) {
            setBiddingECPM(this.f13990a.getECPM());
        }
        loadSuccess();
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onPageDismiss() {
    }

    @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
    public void onRequestResult(int i) {
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onSkippedAd() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayEnd() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + "code:" + i + ";message:" + i2);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayStart() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void show(Activity activity) {
        if (activity == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else if (isValid()) {
            this.f13990a.showInterstitialAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(getSlot().isVideoSoundEnable()).showLandscape(getSlot().getOrientation() != 1).build());
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }
}
