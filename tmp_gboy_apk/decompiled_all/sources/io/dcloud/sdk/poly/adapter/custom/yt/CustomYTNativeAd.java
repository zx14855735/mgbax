package io.dcloud.sdk.poly.adapter.custom.yt;

import DuwtYk.A5SV6n;
import DvK7DB.A2egSU;
import EQurEW.A4TApA;
import EY4UKY.AMqCpz;
import FOAO9d.AcNBzu;
import FOAO9d.AlLFFp;
import Fyurov.ASJ6gh;
import Fyurov.B4ZgIw;
import GJee0v.AZOQYO;
import GnQT2j.ARc23Z;
import HFjH17.ADYaiT;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alliance.ssp.ad.event.AdnTypeEnum;
import com.alliance.ssp.ad.event.CurrencyEnum;
import com.alliance.ssp.ad.event.LoseReasonEnum;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;
import io.dcloud.sdk.poly.adapter.custom.yt.utils.ThreadUtils;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomYTNativeAd extends UniAdCustomNativeAd {
    private static final String TAG = "CustomYTNativeAd";
    private Activity activity;
    public View expressView;
    private A5SV6n saAllianceAd;
    private A2egSU saExpressFeedAd;

    public CustomYTNativeAd(Activity activity, A2egSU a2egSU, A5SV6n a5SV6n) {
        this.activity = activity;
        this.saExpressFeedAd = a2egSU;
        this.saAllianceAd = a5SV6n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$destroy$0() {
        ASJ6gh aSJ6gh;
        A2egSU a2egSU = this.saExpressFeedAd;
        if (a2egSU != null) {
            int i = AZOQYO.f3039AcNBzu;
            AcNBzu acNBzu = ((AlLFFp) a2egSU).f2672ADYaiT;
            acNBzu.getClass();
            acNBzu.CtxOCS();
            ADYaiT aDYaiT = acNBzu.f2636H3v3Sq;
            if (aDYaiT != null) {
                aDYaiT.AlLFFp();
                acNBzu.f2636H3v3Sq = null;
            }
            B4ZgIw b4ZgIw = acNBzu.f2653I3bnmY;
            if (b4ZgIw != null) {
                b4ZgIw.ADYaiT();
                acNBzu.f2653I3bnmY = null;
            }
            LinearLayout linearLayout = acNBzu.f2608F32kj0;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
            FOAO9d.ASJ6gh aSJ6gh2 = acNBzu.f2659IYh8XG;
            if (aSJ6gh2 != null) {
                aSJ6gh2.removeCallbacksAndMessages(null);
                acNBzu.f2659IYh8XG = null;
            }
            Bitmap bitmap = acNBzu.f3199B7CMnp;
            if (bitmap != null && !bitmap.isRecycled()) {
                acNBzu.f3199B7CMnp.recycle();
                acNBzu.f3199B7CMnp = null;
            }
            A4TApA a4TApA = acNBzu.f2641HMGPfW;
            if (a4TApA != null) {
                a4TApA.f2491A2egSU.getViewTreeObserver().removeOnScrollChangedListener(a4TApA.f2492A4TApA);
                acNBzu.f2641HMGPfW = null;
            }
            GIi2tl.A2egSU a2egSU2 = acNBzu.GZqyMh;
            if (a2egSU2 != null && (aSJ6gh = a2egSU2.f3016BJ7GGh) != null) {
                aSJ6gh.ARc23Z();
            }
            acNBzu.f2668IzHBwY = 1;
            acNBzu.f2669J3EcKw = 1;
            if (acNBzu.H6qKiO != null) {
                acNBzu.H6qKiO = null;
            }
            if (acNBzu.f2642HPJABZ != null) {
                acNBzu.f2642HPJABZ = null;
            }
            if (acNBzu.f2648HieBYM != null) {
                acNBzu.f2648HieBYM = null;
                acNBzu.f2656IJPJ4E = false;
            }
            if (acNBzu.f2647Hdahpu != null) {
                acNBzu.f2647Hdahpu = null;
            }
            G58fqA.A2egSU a2egSU3 = acNBzu.f2658IQ76hF;
            if (a2egSU3 != null) {
                a2egSU3.A4TApA();
            }
            ARc23Z.A2egSU(acNBzu.f2622GEYgCP.getDeeplink());
            this.saExpressFeedAd = null;
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void destroy() {
        ThreadUtils.runOnUIThread(new com.fl.saas.common.crash.A2egSU(8, this));
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public View getNativeAd() {
        return this.expressView;
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void onBidFail(int i, int i2) {
        super.onBidFail(i, i2);
        HashMap hashMap = new HashMap();
        hashMap.put("biddingReason", Integer.valueOf(i2));
        A5SV6n a5SV6n = this.saAllianceAd;
        if (a5SV6n != null) {
            ((AMqCpz) a5SV6n).ASJ6gh(i, CurrencyEnum.CNY, AdnTypeEnum.OTHER, LoseReasonEnum.OTHER, hashMap);
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void onBidSuccess(int i, int i2) {
        super.onBidSuccess(i, i2);
        A5SV6n a5SV6n = this.saAllianceAd;
        if (a5SV6n != null) {
            ((AMqCpz) a5SV6n).AYUAbz(i2, CurrencyEnum.CNY, AdnTypeEnum.OTHER);
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void render() {
        FOAO9d.ASJ6gh aSJ6gh;
        A2egSU a2egSU = this.saExpressFeedAd;
        if (a2egSU == null) {
            return;
        }
        DvK7DB.A4TApA a4TApA = new DvK7DB.A4TApA() { // from class: io.dcloud.sdk.poly.adapter.custom.yt.CustomYTNativeAd.1
            @Override // DvK7DB.A4TApA
            public void onAdClick() {
                CustomYTNativeAd.this.onAdClicked();
            }

            @Override // DvK7DB.A4TApA
            public void onAdClose() {
                CustomYTNativeAd.this.onAdClosed("用户不感兴趣");
                View view = CustomYTNativeAd.this.expressView;
                if (view == null || view.getParent() == null) {
                    return;
                }
                ((ViewGroup) CustomYTNativeAd.this.expressView.getParent()).removeView(CustomYTNativeAd.this.expressView);
            }

            @Override // DvK7DB.A4TApA
            public void onAdShow() {
                CustomYTNativeAd.this.onAdShow();
            }

            @Override // DvK7DB.A4TApA
            public void onRenderFail(int i, String str) {
                CustomYTNativeAd.super.onRenderFail(i, str);
            }

            @Override // DvK7DB.A4TApA
            public void onRenderSuccess(View view) {
                CustomYTNativeAd.super.onRenderSuccess();
                CustomYTNativeAd.this.expressView = view;
            }
        };
        AlLFFp alLFFp = (AlLFFp) a2egSU;
        synchronized (AlLFFp.AMqCpz) {
            alLFFp.f2670A4TApA = a4TApA;
        }
        AcNBzu acNBzu = ((AlLFFp) this.saExpressFeedAd).f2672ADYaiT;
        if (acNBzu != null) {
            boolean z = acNBzu.G2rdQT;
            int i = AZOQYO.f3039AcNBzu;
            acNBzu.G16Pvp = true;
            if (z) {
                acNBzu.G16Pvp = false;
                acNBzu.DuwtYk(4, acNBzu.f2608F32kj0, 0, null);
            } else {
                if (acNBzu.f2599EdhSi6 != 2 || (aSJ6gh = acNBzu.f2659IYh8XG) == null) {
                    return;
                }
                aSJ6gh.sendEmptyMessageDelayed(0, 50L);
            }
        }
    }
}
