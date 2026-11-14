package io.dcloud.sdk.poly.adapter.custom.yt;

import Dphsd2.AlLFFp;
import DuwtYk.A5SV6n;
import DuwtYk.AMqCpz;
import DuwtYk.ARc23Z;
import ECyGFg.A2egSU;
import ECyGFg.A4TApA;
import H0qugq.AZkASS;
import android.app.Activity;
import android.text.TextUtils;
import com.alliance.ssp.ad.bean.RewardInfo;
import com.alliance.ssp.ad.event.AdnTypeEnum;
import com.alliance.ssp.ad.event.CurrencyEnum;
import com.alliance.ssp.ad.event.LoseReasonEnum;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.reward.UniAdCustomRewardLoader;
import io.dcloud.sdk.poly.adapter.custom.yt.utils.ThreadUtils;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomYTRewardAd extends UniAdCustomRewardLoader {
    private static final String TAG = "CustomYTRewardAd";
    private A2egSU rewardVideoAd;
    private A5SV6n saAllianceAd;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$destroy$2() {
        A2egSU a2egSU = this.rewardVideoAd;
        if (a2egSU != null) {
            a2egSU.getClass();
            this.rewardVideoAd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$load$0(UniAdSlot uniAdSlot, Activity activity) {
        AMqCpz aMqCpz = new AMqCpz();
        if (!TextUtils.isEmpty(uniAdSlot.getUserId())) {
            aMqCpz.f2482ARc23Z = uniAdSlot.getUserId();
        }
        if (!TextUtils.isEmpty(uniAdSlot.getExtra())) {
            aMqCpz.f2483ASJ6gh = uniAdSlot.getExtra();
        }
        aMqCpz.f2478A2egSU = uniAdSlot.getSlotId();
        int i = ARc23Z.f2485A2egSU;
        new EY4UKY.ARc23Z();
        EY4UKY.AMqCpz A2egSU2 = EY4UKY.ARc23Z.A2egSU(activity);
        this.saAllianceAd = A2egSU2;
        A2egSU2.A5SV6n(aMqCpz, 6, -1, new ECyGFg.A5SV6n() { // from class: io.dcloud.sdk.poly.adapter.custom.yt.CustomYTRewardAd.1
            @Override // DuwtYk.A2egSU
            public void onError(int i2, String str) {
                CustomYTRewardAd.super.onLoadFail(i2, str);
            }

            @Override // DuwtYk.A2egSU
            public void onResourceLoad() {
            }

            @Override // ECyGFg.A5SV6n
            public void onRewardVideoAdLoad(A2egSU a2egSU) {
                if (a2egSU == null) {
                    CustomYTRewardAd.super.onLoadFail(36222444, "加载失败，广告为空");
                    return;
                }
                CustomYTRewardAd.this.rewardVideoAd = a2egSU;
                try {
                    if (CustomYTRewardAd.this.getBidType() == 1) {
                        CustomYTRewardAd customYTRewardAd = CustomYTRewardAd.this;
                        CustomYTRewardAd.super.setBidPrice(Integer.parseInt(((AZkASS) customYTRewardAd.rewardVideoAd).f3255A2egSU));
                    }
                } catch (Exception unused) {
                    String str = ((AZkASS) CustomYTRewardAd.this.rewardVideoAd).f3255A2egSU;
                }
                CustomYTRewardAd.super.onLoadSuccess();
                A2egSU a2egSU2 = CustomYTRewardAd.this.rewardVideoAd;
                A4TApA a4TApA = new A4TApA() { // from class: io.dcloud.sdk.poly.adapter.custom.yt.CustomYTRewardAd.1.1
                    @Override // ECyGFg.A4TApA
                    public void onAdClick() {
                        CustomYTRewardAd.super.onAdClicked();
                    }

                    @Override // ECyGFg.A4TApA
                    public void onAdClose() {
                        CustomYTRewardAd.super.onAdClosed();
                    }

                    @Override // ECyGFg.A4TApA
                    public void onAdShow() {
                        CustomYTRewardAd.super.onAdShow();
                    }

                    @Override // ECyGFg.A4TApA
                    public void onRewardVerify(RewardInfo rewardInfo) {
                        CustomYTRewardAd.super.onReward();
                    }

                    @Override // ECyGFg.A4TApA
                    public void onVideoComplete() {
                        CustomYTRewardAd.super.onAdPlayEnd();
                    }

                    @Override // ECyGFg.A4TApA
                    public void onVideoError() {
                        CustomYTRewardAd.super.onAdPlayError(1, "激励视频发生错误");
                    }
                };
                HHLj6Q.A4TApA a4TApA2 = (HHLj6Q.A4TApA) a2egSU2;
                a4TApA2.getClass();
                synchronized (HHLj6Q.A4TApA.f3357A5SV6n) {
                    a4TApA2.f3358A4TApA = a4TApA;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$show$1(Activity activity) {
        A5SV6n a5SV6n = this.saAllianceAd;
        if (a5SV6n == null || activity == null) {
            return;
        }
        ((EY4UKY.AMqCpz) a5SV6n).A4TApA(6, activity, null);
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void destroy() {
        ThreadUtils.runOnUIThread(new com.fl.saas.common.crash.A2egSU(9, this));
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public boolean isReady() {
        return this.rewardVideoAd != null;
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        if (uniAdSlot == null || uniAdSlot.getSlotId() == null || uniAdSlot.getSlotId().isEmpty()) {
            super.onLoadFail(36222441, "posId无效");
        } else if (activity == null) {
            super.onLoadFail(36222442, "activity为空");
        } else {
            ThreadUtils.runOnThreadPool(new AlLFFp(14, this, uniAdSlot, activity));
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

    @Override // io.dcloud.api.custom.type.reward.UniAdCustomRewardLoader
    public void show(Activity activity) {
        ThreadUtils.runOnUIThreadByThreadPool(new com.sigmob.sdk.videoplayer.AMqCpz(this, 7, activity));
    }
}
