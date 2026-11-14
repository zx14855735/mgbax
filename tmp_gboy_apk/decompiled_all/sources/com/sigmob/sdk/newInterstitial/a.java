package com.sigmob.sdk.newInterstitial;

import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.windad.WindAdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends com.sigmob.sdk.manager.f implements e {
    @Override // com.sigmob.sdk.newInterstitial.e
    public void c(BaseAdUnit baseAdUnit, String str) {
        SigmobLog.d("onAdShowFail");
        if (com.sigmob.sdk.manager.b.m(baseAdUnit)) {
            com.sigmob.sdk.base.common.h.g().e(baseAdUnit);
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_PLAY;
        windAdError.setMessage(str);
        a(windAdError, this.p);
        a(baseAdUnit, PointCategory.PLAY, this.k.getAdType(), this.g, this.k.getLoadId(), windAdError);
    }

    @Override // com.sigmob.sdk.manager.b
    public void g() {
        if (com.sigmob.sdk.base.utils.e.a(this.m)) {
            this.m = null;
            return;
        }
        BaseAdUnit e = e();
        if (com.sigmob.sdk.manager.b.m(e)) {
            com.sigmob.sdk.base.common.h.g().e(e);
        }
        this.m = null;
    }

    @Override // com.sigmob.sdk.manager.f
    public com.sigmob.sdk.mraid.i l() {
        return new f(this);
    }

    @Override // com.sigmob.sdk.newInterstitial.e
    public void o(BaseAdUnit baseAdUnit) {
        if (this.b == AdStatus.AdStatusClose) {
            return;
        }
        n(baseAdUnit);
    }

    @Override // com.sigmob.sdk.newInterstitial.e
    public void p(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onAdSkip");
    }

    @Override // com.sigmob.sdk.newInterstitial.e
    public void q(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onAdShow");
    }
}
