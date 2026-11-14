package io.dcloud.sdk.poly.adapter.custom.yt;

import Dphsd2.AlLFFp;
import DuwtYk.A5SV6n;
import DuwtYk.AMqCpz;
import DyaChj.A2egSU;
import DyaChj.A4TApA;
import FSFw2u.AZkASS;
import GnQT2j.ARc23Z;
import HH6JFw.ADYaiT;
import android.app.Activity;
import android.graphics.Bitmap;
import com.alliance.ssp.ad.event.AdnTypeEnum;
import com.alliance.ssp.ad.event.CurrencyEnum;
import com.alliance.ssp.ad.event.LoseReasonEnum;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.interstitial.UniAdCustomInterstitialLoader;
import io.dcloud.sdk.poly.adapter.custom.yt.utils.ThreadUtils;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomYTInterstitialAd extends UniAdCustomInterstitialLoader {
    private static final String TAG = "CustomYTInterstitialAd";
    private A2egSU interstitialAd;
    private A5SV6n saAllianceAd;

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$destroy$2() {
        A2egSU a2egSU = this.interstitialAd;
        if (a2egSU != null) {
            ADYaiT aDYaiT = (ADYaiT) a2egSU;
            Bitmap bitmap = aDYaiT.f3351A5SV6n;
            if (bitmap != null && !bitmap.isRecycled()) {
                aDYaiT.f3351A5SV6n.recycle();
                aDYaiT.f3351A5SV6n = null;
            }
            AZkASS aZkASS = aDYaiT.f3352ADYaiT;
            if (aZkASS != null) {
                ARc23Z.A2egSU(aZkASS.f2718GJee0v.getDeeplink());
                if (aZkASS.f2740HieBYM != null) {
                    aZkASS.f2740HieBYM = null;
                }
                aZkASS.CtxOCS();
                aZkASS.Dphsd2();
                aZkASS.DaOi9o();
                aDYaiT.f3352ADYaiT = null;
            }
            this.interstitialAd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$load$0(UniAdSlot uniAdSlot, Activity activity) {
        AMqCpz aMqCpz = new AMqCpz();
        aMqCpz.f2478A2egSU = uniAdSlot.getSlotId();
        int i = DuwtYk.ARc23Z.f2485A2egSU;
        new EY4UKY.ARc23Z();
        EY4UKY.AMqCpz A2egSU2 = EY4UKY.ARc23Z.A2egSU(activity);
        this.saAllianceAd = A2egSU2;
        A2egSU2.A5SV6n(aMqCpz, 5, -1, new DyaChj.A5SV6n() { // from class: io.dcloud.sdk.poly.adapter.custom.yt.CustomYTInterstitialAd.1
            @Override // DuwtYk.A2egSU
            public void onError(int i2, String str) {
                CustomYTInterstitialAd.super.onLoadFail(i2, str);
            }

            @Override // DyaChj.A5SV6n
            public void onInterstitialAdLoad(A2egSU a2egSU) {
                if (a2egSU == null) {
                    CustomYTInterstitialAd.super.onLoadFail(36222424, "加载失败，广告为空");
                    return;
                }
                CustomYTInterstitialAd.this.interstitialAd = a2egSU;
                try {
                    if (CustomYTInterstitialAd.this.getBidType() == 1) {
                        CustomYTInterstitialAd customYTInterstitialAd = CustomYTInterstitialAd.this;
                        CustomYTInterstitialAd.super.setBidPrice(Integer.parseInt(((H0qugq.AZkASS) customYTInterstitialAd.interstitialAd).f3255A2egSU));
                    }
                } catch (Exception unused) {
                    String str = ((H0qugq.AZkASS) CustomYTInterstitialAd.this.interstitialAd).f3255A2egSU;
                }
                CustomYTInterstitialAd.super.onLoadSuccess();
                A2egSU a2egSU2 = CustomYTInterstitialAd.this.interstitialAd;
                A4TApA a4TApA = new A4TApA() { // from class: io.dcloud.sdk.poly.adapter.custom.yt.CustomYTInterstitialAd.1.1
                    @Override // DyaChj.A4TApA
                    public void onAdClick() {
                        CustomYTInterstitialAd.super.onAdClicked();
                    }

                    @Override // DyaChj.A4TApA
                    public void onAdDismiss() {
                        CustomYTInterstitialAd.super.onAdClosed();
                    }

                    @Override // DyaChj.A4TApA
                    public void onAdError(int i2, String str2) {
                        CustomYTInterstitialAd.super.onAdPlayError(i2, str2);
                    }

                    @Override // DyaChj.A4TApA
                    public void onAdShow() {
                        CustomYTInterstitialAd.super.onAdShow();
                    }

                    @Override // DyaChj.A4TApA
                    public void onSkippedVideo() {
                        CustomYTInterstitialAd.super.onAdSkip();
                    }
                };
                ADYaiT aDYaiT = (ADYaiT) a2egSU2;
                aDYaiT.getClass();
                synchronized (ADYaiT.AMqCpz) {
                    aDYaiT.f3350A4TApA = a4TApA;
                }
            }

            @Override // DuwtYk.A2egSU
            public void onResourceLoad() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$show$1(Activity activity) {
        A5SV6n a5SV6n = this.saAllianceAd;
        if (a5SV6n == null || activity == null) {
            return;
        }
        ((EY4UKY.AMqCpz) a5SV6n).A4TApA(5, activity, null);
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void destroy() {
        ThreadUtils.runOnUIThread(new com.fl.saas.common.crash.A2egSU(7, this));
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public boolean isReady() {
        return this.interstitialAd != null;
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        if (uniAdSlot == null || uniAdSlot.getSlotId() == null || uniAdSlot.getSlotId().isEmpty()) {
            super.onLoadFail(36222421, "posId无效");
        } else if (activity == null) {
            super.onLoadFail(36222422, "activity为空");
        } else {
            ThreadUtils.runOnThreadPool(new AlLFFp(12, this, uniAdSlot, activity));
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidFail(int i, int i2) {
        super.onBidFail(i, i2);
        HashMap hashMap = new HashMap();
        hashMap.put("biddingReason", Integer.valueOf(i2));
        A5SV6n a5SV6n = this.saAllianceAd;
        if (a5SV6n != null) {
            ((EY4UKY.AMqCpz) a5SV6n).ASJ6gh(i, CurrencyEnum.CNY, AdnTypeEnum.OTHER, LoseReasonEnum.OTHER, hashMap);
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidSuccess(int i, int i2) {
        super.onBidSuccess(i, i2);
        A5SV6n a5SV6n = this.saAllianceAd;
        if (a5SV6n != null) {
            ((EY4UKY.AMqCpz) a5SV6n).AYUAbz(i2, CurrencyEnum.CNY, AdnTypeEnum.OTHER);
        }
    }

    @Override // io.dcloud.api.custom.type.interstitial.UniAdCustomInterstitialLoader
    public void show(Activity activity) {
        ThreadUtils.runOnUIThreadByThreadPool(new com.sigmob.sdk.videoplayer.AMqCpz(this, 6, activity));
    }
}
