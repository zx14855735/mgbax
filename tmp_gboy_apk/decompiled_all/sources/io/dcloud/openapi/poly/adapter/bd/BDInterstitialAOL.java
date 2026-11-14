package io.dcloud.openapi.poly.adapter.bd;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.Const;
import io.dcloud.openapi.core.util.MainHandlerUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class BDInterstitialAOL extends DCBaseAOLLoader implements ExpressInterstitialListener {

    /* renamed from: a, reason: collision with root package name */
    public ExpressInterstitialAd f13934a;

    public BDInterstitialAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    public final /* synthetic */ void a(Activity activity) {
        this.f13934a.show(activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        ExpressInterstitialAd expressInterstitialAd = this.f13934a;
        if (expressInterstitialAd != null) {
            expressInterstitialAd.biddingFail(i3 == 2 ? "203" : i3 == 1 ? "100" : "900");
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        ExpressInterstitialAd expressInterstitialAd = this.f13934a;
        if (expressInterstitialAd != null) {
            expressInterstitialAd.biddingSuccess(String.valueOf(i2));
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
        ExpressInterstitialAd expressInterstitialAd = this.f13934a;
        return expressInterstitialAd != null && expressInterstitialAd.isReady();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void load() {
        ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(getActivity(), getSlotId());
        this.f13934a = expressInterstitialAd;
        expressInterstitialAd.setLoadListener(this);
        this.f13934a.load();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onADExposed() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onADExposureFailed() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "广告展现标准不达标");
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onADLoaded() {
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onAdCacheFailed() {
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onAdCacheSuccess() {
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onAdClick() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onAdClose() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onAdFailed(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onLpClosed() {
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onNoAd(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onVideoDownloadFailed() {
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onVideoDownloadSuccess() {
        float parseInt;
        if (this.f13934a != null && isSlotSupportBidding()) {
            String eCPMLevel = this.f13934a.getECPMLevel();
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

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void show(Activity activity) {
        if (activity == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else if (isValid()) {
            MainHandlerUtil.getMainHandler().post(new A2egSU(this, activity, 0));
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }
}
