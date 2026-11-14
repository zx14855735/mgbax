package io.dcloud.sdk.poly.adapter.custom.fl;

import android.app.Activity;
import android.text.TextUtils;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.base.manager.loader.ADYaiT;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.ydsdk.YdVideo;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.reward.UniAdCustomRewardLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomFLRewardAd extends UniAdCustomRewardLoader {
    YdVideo ydVideo;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$load$0(String str) {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void destroy() {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.destroy();
            this.ydVideo = null;
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public boolean isReady() {
        YdVideo ydVideo = this.ydVideo;
        return ydVideo != null && ydVideo.isReady();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        String slotId = uniAdSlot.getSlotId();
        if (TextUtils.isEmpty(slotId)) {
            onLoadFail(330002, "posId无效");
            return;
        }
        YdVideo.Builder builder = new YdVideo.Builder(activity);
        String userId = uniAdSlot.getUserId();
        String extra = uniAdSlot.getExtra();
        if (!TextUtils.isEmpty(userId)) {
            builder.setUserId(userId);
        }
        if (!TextUtils.isEmpty(extra)) {
            builder.setCustomData(extra);
        }
        builder.setAdViewVideoCheckListener(new ADYaiT(25));
        YdVideo build = builder.setKey(slotId).setVideoListener(new AdViewVideoListener() { // from class: io.dcloud.sdk.poly.adapter.custom.fl.CustomFLRewardAd.1
            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdClick(String str) {
                CustomFLRewardAd.this.onAdClicked();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdClose() {
                CustomFLRewardAd.this.onAdClosed();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                CustomFLRewardAd.this.onLoadFail(ydError.getCode(), ydError.getMsg());
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdShow() {
                CustomFLRewardAd.this.onAdShow();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onSkipVideo() {
                CustomFLRewardAd.this.onAdSkip();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoCompleted() {
                CustomFLRewardAd.this.onAdPlayEnd();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoPrepared() {
                if (CustomFLRewardAd.this.getBidType() == 1) {
                    CustomFLRewardAd customFLRewardAd = CustomFLRewardAd.this;
                    customFLRewardAd.setBidPrice(customFLRewardAd.ydVideo.getECPM());
                }
                CustomFLRewardAd.this.onLoadSuccess();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoReward(double d) {
                CustomFLRewardAd.this.onReward();
            }
        }).build();
        this.ydVideo = build;
        build.requestRewardVideo();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidFail(int i, int i2) {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.biddingResultUpload(false, i, 0);
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidSuccess(int i, int i2) {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.biddingResultUpload(true, i, i2);
        }
    }

    @Override // io.dcloud.api.custom.type.reward.UniAdCustomRewardLoader
    public void show(Activity activity) {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.show(activity);
        }
    }
}
