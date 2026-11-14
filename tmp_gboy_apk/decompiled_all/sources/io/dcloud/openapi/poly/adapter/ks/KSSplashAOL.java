package io.dcloud.openapi.poly.adapter.ks;

import android.app.Activity;
import android.os.Looper;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.sigmob.sdk.videoplayer.AMqCpz;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.MainHandlerUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class KSSplashAOL extends DCBaseAOLLoader implements KsLoadManager.SplashScreenAdListener, KsSplashScreenAd.SplashScreenAdInteractionListener {

    /* renamed from: a, reason: collision with root package name */
    public KsSplashScreenAd f13992a;

    public KSSplashAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    public final /* synthetic */ void a(ViewGroup viewGroup) {
        viewGroup.addView(this.f13992a.getView(viewGroup.getContext(), this), new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13992a != null) {
            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
            adExposureFailedReason.winEcpm = i;
            this.f13992a.reportAdExposureFailed(2, adExposureFailedReason);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        KsSplashScreenAd ksSplashScreenAd = this.f13992a;
        if (ksSplashScreenAd != null) {
            ksSplashScreenAd.setBidEcpm(i);
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
        KsSplashScreenAd ksSplashScreenAd = this.f13992a;
        return ksSplashScreenAd != null && ksSplashScreenAd.isAdEnable();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        long j;
        try {
            j = Long.parseLong(getSlotId());
        } catch (Exception unused) {
            j = 0;
        }
        if (j == 0) {
            loadFail(-9999, "");
            return;
        }
        startLoadTime();
        try {
            KsScene.Builder builder = new KsScene.Builder(j);
            if (KSInit.getInstance().getPrivacyConfig() != null && !KSInit.getInstance().getPrivacyConfig().isCanUseSensor()) {
                builder.setSensorType(-1);
            }
            KsAdSDK.getLoadManager().loadSplashScreenAd(builder.build(), this);
        } catch (Exception unused2) {
            loadFail(-9999, "");
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i, String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + "code:" + i + ";message:" + str);
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogCancel() {
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogDismiss() {
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogShow() {
    }

    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
    public void onError(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
    public void onRequestResult(int i) {
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
    public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
        if (ksSplashScreenAd == null) {
            loadFail(-40003, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        this.f13992a = ksSplashScreenAd;
        if (isSlotSupportBidding()) {
            setBiddingECPM(ksSplashScreenAd.getECPM());
        }
        loadSuccess();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void showIn(ViewGroup viewGroup) {
        if (this.f13992a == null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
            return;
        }
        if (viewGroup == null) {
            getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            viewGroup.addView(this.f13992a.getView(viewGroup.getContext(), this), new ViewGroup.LayoutParams(-1, -1));
        } else {
            MainHandlerUtil.getMainHandler().post(new AMqCpz(this, 4, viewGroup));
        }
    }
}
