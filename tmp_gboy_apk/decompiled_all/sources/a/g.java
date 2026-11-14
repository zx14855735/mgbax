package a;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.RewardItem;
import com.octopus.ad.RewardVideoAd;
import com.octopus.ad.RewardVideoAdListener;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.reward.UniAdCustomRewardLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g extends UniAdCustomRewardLoader {

    /* renamed from: a, reason: collision with root package name */
    public final String f7930a = getClass().getSimpleName();
    public RewardVideoAd b;

    public class a implements RewardVideoAdListener {
        public a() {
        }

        @Override // com.octopus.ad.RewardVideoAdListener
        public void onRewardVideoAdClicked() {
            String unused = g.this.f7930a;
            g.this.onAdClicked();
        }

        @Override // com.octopus.ad.RewardVideoAdListener
        public void onRewardVideoAdClosed() {
            String unused = g.this.f7930a;
            g.this.onAdClosed();
        }

        @Override // com.octopus.ad.RewardVideoAdListener
        public void onRewardVideoAdComplete() {
            String unused = g.this.f7930a;
            g.this.onAdPlayEnd();
        }

        @Override // com.octopus.ad.RewardVideoAdListener
        public void onRewardVideoAdFailedToLoad(int i) {
            String unused = g.this.f7930a;
            g.this.onLoadFail(i, String.valueOf(i));
        }

        @Override // com.octopus.ad.RewardVideoAdListener
        public void onRewardVideoAdLoaded() {
            String unused = g.this.f7930a;
            if (g.this.getBidType() == 1) {
                g gVar = g.this;
                gVar.setBidPrice(gVar.b.getPrice());
            }
            g.this.onLoadSuccess();
        }

        @Override // com.octopus.ad.RewardVideoAdListener
        public void onRewardVideoAdShown() {
            String unused = g.this.f7930a;
            g.this.onAdShow();
        }

        @Override // com.octopus.ad.RewardVideoAdListener
        public void onRewardVideoCached(boolean z) {
            String unused = g.this.f7930a;
        }

        @Override // com.octopus.ad.RewardVideoAdListener
        public void onRewarded(RewardItem rewardItem) {
            String unused = g.this.f7930a;
            rewardItem.getAmount();
            rewardItem.getType();
            g.this.onReward();
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void destroy() {
        RewardVideoAd rewardVideoAd = this.b;
        if (rewardVideoAd != null) {
            rewardVideoAd.destroy();
            this.b = null;
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public boolean isReady() {
        RewardVideoAd rewardVideoAd = this.b;
        return rewardVideoAd != null && rewardVideoAd.isValid();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        if (TextUtils.isEmpty(uniAdSlot.getSlotId())) {
            onLoadFail(MediationConstant.ErrorCode.ADN_INIT_FAIL, "SlotId is empty!");
            return;
        }
        this.b = new RewardVideoAd(activity, uniAdSlot.getSlotId(), new a());
        if (!TextUtils.isEmpty(uniAdSlot.getUserId())) {
            this.b.setUserId(Uri.encode(uniAdSlot.getUserId()));
        }
        if (!TextUtils.isEmpty(uniAdSlot.getExtra())) {
            this.b.setExtraData(Uri.encode(uniAdSlot.getExtra()));
        }
        this.b.openAdInNativeBrowser(true);
        this.b.loadAd();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidFail(int i, int i2) {
        RewardVideoAd rewardVideoAd = this.b;
        if (rewardVideoAd != null) {
            rewardVideoAd.sendLossNotice(i, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.OTHER);
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidSuccess(int i, int i2) {
        RewardVideoAd rewardVideoAd = this.b;
        if (rewardVideoAd != null) {
            rewardVideoAd.sendWinNotice(i2);
        }
    }

    @Override // io.dcloud.api.custom.type.reward.UniAdCustomRewardLoader
    public void show(Activity activity) {
        RewardVideoAd rewardVideoAd = this.b;
        if (rewardVideoAd == null || !rewardVideoAd.isValid()) {
            return;
        }
        this.b.show(activity);
    }
}
