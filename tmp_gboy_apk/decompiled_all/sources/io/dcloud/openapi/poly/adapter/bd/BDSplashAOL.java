package io.dcloud.openapi.poly.adapter.bd;

import android.app.Activity;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.Const;
import io.dcloud.openapi.core.util.MainHandlerUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class BDSplashAOL extends DCBaseAOLLoader implements SplashInteractionListener {

    /* renamed from: a, reason: collision with root package name */
    public SplashAd f13936a;

    public BDSplashAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    public final /* synthetic */ void a(ViewGroup viewGroup) {
        this.f13936a.show(viewGroup);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        SplashAd splashAd = this.f13936a;
        if (splashAd != null) {
            splashAd.biddingFail(i3 == 2 ? "203" : i3 == 1 ? "100" : "900");
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        SplashAd splashAd = this.f13936a;
        if (splashAd != null) {
            splashAd.biddingSuccess(String.valueOf(i2));
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
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
        SplashAd splashAd = this.f13936a;
        return splashAd != null && splashAd.isReady();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void load() {
        this.f13936a = new SplashAd(getActivity(), getSlotId(), this);
        startLoadTime();
        this.f13936a.load();
    }

    @Override // com.baidu.mobads.sdk.api.SplashAdListener
    public void onADLoaded() {
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdCacheFailed() {
        loadFail(-1, "缓存物料失败");
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdCacheSuccess() {
        float parseInt;
        if (this.f13936a != null && isSlotSupportBidding()) {
            String eCPMLevel = this.f13936a.getECPMLevel();
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

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdClick() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdDismissed() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdExposed() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.baidu.mobads.sdk.api.SplashAdListener
    public void onAdFailed(String str) {
        loadFail(-1, str);
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdPresent() {
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onAdSkip() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
    public void onLpClosed() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public final void showIn(ViewGroup viewGroup) {
        if (viewGroup == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else if (!isValid()) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
            }
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f13936a.show(viewGroup);
        } else {
            MainHandlerUtil.getMainHandler().post(new A2egSU(this, viewGroup, 1));
        }
    }
}
