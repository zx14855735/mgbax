package io.dcloud.sdk.poly.adapter.custom.yt;

import Dphsd2.AlLFFp;
import DuwtYk.A5SV6n;
import DuwtYk.AMqCpz;
import DuwtYk.ARc23Z;
import EGM26s.A2egSU;
import EGM26s.A4TApA;
import FdMWEC.AZkASS;
import FdMWEC.AcNBzu;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alliance.ssp.ad.event.AdnTypeEnum;
import com.alliance.ssp.ad.event.CurrencyEnum;
import com.alliance.ssp.ad.event.LoseReasonEnum;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.splash.UniAdCustomSplashLoader;
import io.dcloud.sdk.poly.adapter.custom.yt.utils.ThreadUtils;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomYTSplashAd extends UniAdCustomSplashLoader {
    private static final String TAG = "CustomYTSplashAd";
    private Activity activity;
    private A5SV6n saAllianceAd;
    private A2egSU splashAd;
    private ViewGroup viewGroup;

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$destroy$2() {
        A2egSU a2egSU = this.splashAd;
        if (a2egSU != null) {
            AcNBzu acNBzu = (AcNBzu) a2egSU;
            Bitmap bitmap = acNBzu.f2869A5SV6n;
            if (bitmap != null && !bitmap.isRecycled()) {
                acNBzu.f2869A5SV6n.recycle();
                acNBzu.f2869A5SV6n = null;
            }
            AZkASS aZkASS = acNBzu.f2870ADYaiT;
            if (aZkASS != null) {
                aZkASS.DaOi9o();
                aZkASS.CtxOCS();
                aZkASS.DjONCG();
                aZkASS.f2865IQ76hF = 7;
                acNBzu.f2870ADYaiT = null;
            }
            this.splashAd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$load$0(UniAdSlot uniAdSlot, Activity activity) {
        AMqCpz aMqCpz = new AMqCpz();
        aMqCpz.f2478A2egSU = uniAdSlot.getSlotId();
        int i = ARc23Z.f2485A2egSU;
        new EY4UKY.ARc23Z();
        EY4UKY.AMqCpz A2egSU2 = EY4UKY.ARc23Z.A2egSU(activity);
        this.saAllianceAd = A2egSU2;
        A2egSU2.A5SV6n(aMqCpz, 1, 3000, new EGM26s.A5SV6n() { // from class: io.dcloud.sdk.poly.adapter.custom.yt.CustomYTSplashAd.1
            @Override // DuwtYk.A2egSU
            public void onError(int i2, String str) {
                CustomYTSplashAd.super.onLoadFail(i2, str);
            }

            @Override // DuwtYk.A2egSU
            public void onResourceLoad() {
            }

            @Override // EGM26s.A5SV6n
            public void onSplashAdLoad(A2egSU a2egSU) {
                if (a2egSU == null) {
                    CustomYTSplashAd.super.onLoadFail(36222455, "加载失败，广告为空");
                    return;
                }
                CustomYTSplashAd.this.splashAd = a2egSU;
                try {
                    if (CustomYTSplashAd.this.getBidType() == 1) {
                        CustomYTSplashAd customYTSplashAd = CustomYTSplashAd.this;
                        CustomYTSplashAd.super.setBidPrice(Integer.parseInt(((H0qugq.AZkASS) customYTSplashAd.splashAd).f3255A2egSU));
                    }
                } catch (Exception unused) {
                    String str = ((H0qugq.AZkASS) CustomYTSplashAd.this.splashAd).f3255A2egSU;
                }
                CustomYTSplashAd.this.onLoadSuccess();
                A2egSU a2egSU2 = CustomYTSplashAd.this.splashAd;
                A4TApA a4TApA = new A4TApA() { // from class: io.dcloud.sdk.poly.adapter.custom.yt.CustomYTSplashAd.1.1
                    @Override // EGM26s.A4TApA
                    public void onAdClick() {
                        CustomYTSplashAd.super.onAdClicked();
                    }

                    @Override // EGM26s.A4TApA
                    public void onAdShow() {
                        CustomYTSplashAd.super.onAdShow();
                    }

                    @Override // EGM26s.A4TApA
                    public void onAdSkip() {
                        CustomYTSplashAd.this.removeAd();
                        CustomYTSplashAd.super.onAdSkip();
                    }

                    @Override // EGM26s.A4TApA
                    public void onAdTimeOver() {
                        CustomYTSplashAd.this.removeAd();
                        CustomYTSplashAd.super.onAdPlayEnd();
                    }
                };
                AcNBzu acNBzu = (AcNBzu) a2egSU2;
                acNBzu.getClass();
                synchronized (AcNBzu.AMqCpz) {
                    acNBzu.f2868A4TApA = a4TApA;
                }
            }

            public void onTimeOut() {
                CustomYTSplashAd.super.onLoadFail(36222454, "加载开屏广告超时");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$show$1(ViewGroup viewGroup) {
        if (this.activity == null) {
            viewGroup.removeAllViews();
            ((EY4UKY.AMqCpz) this.saAllianceAd).A4TApA(1, null, viewGroup);
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.activity);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ((EY4UKY.AMqCpz) this.saAllianceAd).A4TApA(1, null, frameLayout);
        viewGroup.removeAllViews();
        viewGroup.addView(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAd() {
        ViewGroup viewGroup = this.viewGroup;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void destroy() {
        ThreadUtils.runOnUIThread(new com.fl.saas.common.crash.A2egSU(10, this));
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public boolean isReady() {
        return this.splashAd != null;
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        if (uniAdSlot == null || uniAdSlot.getSlotId() == null || uniAdSlot.getSlotId().isEmpty()) {
            super.onLoadFail(36222451, "posId无效");
        } else if (activity == null) {
            super.onLoadFail(36222452, "activity为空");
        } else {
            this.activity = activity;
            ThreadUtils.runOnThreadPool(new AlLFFp(15, this, uniAdSlot, activity));
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

    @Override // io.dcloud.api.custom.type.splash.UniAdCustomSplashLoader
    public void show(ViewGroup viewGroup) {
        if (this.saAllianceAd == null || viewGroup == null) {
            return;
        }
        this.viewGroup = viewGroup;
        ThreadUtils.runOnUIThreadByThreadPool(new com.sigmob.sdk.videoplayer.AMqCpz(this, 8, viewGroup));
    }
}
