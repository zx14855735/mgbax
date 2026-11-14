package io.dcloud.openapi.poly.adapter.ks;

import android.app.Activity;
import android.view.View;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.util.MainHandlerUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class KSDrawAOLEntry extends DCBaseAOL implements KsDrawAd.AdInteractionListener {

    /* renamed from: a, reason: collision with root package name */
    public KsDrawAd f13980a;

    public KSDrawAOLEntry(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    public final /* synthetic */ void a() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderSuccess();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13980a != null) {
            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
            adExposureFailedReason.winEcpm = i;
            this.f13980a.reportAdExposureFailed(2, adExposureFailedReason);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        KsDrawAd ksDrawAd = this.f13980a;
        if (ksDrawAd != null) {
            ksDrawAd.setBidEcpm(i);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
        if (this.f13980a != null) {
            this.f13980a = null;
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public View getExpressAdView(Activity activity) {
        KsDrawAd ksDrawAd = this.f13980a;
        if (ksDrawAd == null) {
            return null;
        }
        return ksDrawAd.getDrawView(activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getType() {
        return "ks";
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        return this.f13980a != null;
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdClicked() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClicked();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onAdShow() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShow();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayEnd() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onEnd();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayError() {
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayPause() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onPause();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayResume() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onResume();
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
    public void onVideoPlayStart() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onStart();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void render() {
        KsDrawAd ksDrawAd = this.f13980a;
        if (ksDrawAd != null) {
            ksDrawAd.setAdInteractionListener(this);
            MainHandlerUtil.getMainHandler().post(new A2egSU(this, 0));
        } else if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderFail();
        }
    }

    public void setAdEntry(KsDrawAd ksDrawAd) {
        this.f13980a = ksDrawAd;
    }
}
