package io.dcloud.openapi.poly.adapter.ks;

import android.app.Activity;
import android.text.TextUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class KSFullScreenAOL extends DCBaseAOLLoader implements KsLoadManager.FullScreenVideoAdListener, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {

    /* renamed from: a, reason: collision with root package name */
    public KsFullScreenVideoAd f13986a;

    public KSFullScreenAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13986a != null) {
            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
            adExposureFailedReason.winEcpm = i;
            this.f13986a.reportAdExposureFailed(2, adExposureFailedReason);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f13986a;
        if (ksFullScreenVideoAd != null) {
            ksFullScreenVideoAd.setBidEcpm(i);
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
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f13986a;
        return ksFullScreenVideoAd != null && ksFullScreenVideoAd.isAdEnable();
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
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(builder.build(), this);
        } catch (Exception unused2) {
            loadFail(-9999, "");
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
    public void onError(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
    public void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list) {
        if (list == null || list.size() <= 0) {
            loadFail(-40003, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        KsFullScreenVideoAd ksFullScreenVideoAd = list.get(0);
        this.f13986a = ksFullScreenVideoAd;
        ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(this);
        if (isSlotSupportBidding()) {
            setBiddingECPM(this.f13986a.getECPM());
        }
        loadSuccess();
    }

    @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
    public void onFullScreenVideoResult(List<KsFullScreenVideoAd> list) {
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    public void onRequestResult(int i) {
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + "code:" + i + ";message:" + i2);
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void show(Activity activity) {
        if (isValid()) {
            this.f13986a.showFullScreenVideoAd(activity, new KsVideoPlayConfig.Builder().showLandscape(getSlot().getOrientation() != 1).build());
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }
}
