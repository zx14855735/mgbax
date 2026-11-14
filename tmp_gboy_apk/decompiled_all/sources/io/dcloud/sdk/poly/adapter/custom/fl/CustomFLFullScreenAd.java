package io.dcloud.sdk.poly.adapter.custom.fl;

import android.app.Activity;
import android.text.TextUtils;
import com.fl.saas.base.interfaces.AdViewFullVideoListener;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.ydsdk.YdFullVideo;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.full.UniAdCustomFullScreenVideoLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomFLFullScreenAd extends UniAdCustomFullScreenVideoLoader {
    YdFullVideo ydFullVideo;

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void destroy() {
        YdFullVideo ydFullVideo = this.ydFullVideo;
        if (ydFullVideo != null) {
            ydFullVideo.destroy();
            this.ydFullVideo = null;
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public boolean isReady() {
        YdFullVideo ydFullVideo = this.ydFullVideo;
        return ydFullVideo != null && ydFullVideo.isReady();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        String slotId = uniAdSlot.getSlotId();
        if (TextUtils.isEmpty(slotId)) {
            onLoadFail(330002, "posId无效");
            return;
        }
        YdFullVideo build = new YdFullVideo.Builder(activity).setKey(slotId).setVideoListener(new AdViewFullVideoListener() { // from class: io.dcloud.sdk.poly.adapter.custom.fl.CustomFLFullScreenAd.1
            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onAdClicked() {
                CustomFLFullScreenAd.this.onAdClicked();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                CustomFLFullScreenAd.this.onLoadFail(ydError.getCode(), ydError.getMsg());
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onPageDismiss() {
                CustomFLFullScreenAd.this.onAdClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onVideoPlayStart() {
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onVideoPrepared() {
                if (CustomFLFullScreenAd.this.getBidType() == 1) {
                    CustomFLFullScreenAd customFLFullScreenAd = CustomFLFullScreenAd.this;
                    customFLFullScreenAd.setBidPrice(customFLFullScreenAd.ydFullVideo.getECPM());
                }
                CustomFLFullScreenAd.this.onLoadSuccess();
            }
        }).build();
        this.ydFullVideo = build;
        build.requestFullVideo();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidFail(int i, int i2) {
        YdFullVideo ydFullVideo = this.ydFullVideo;
        if (ydFullVideo != null) {
            ydFullVideo.biddingResultUpload(false, i, 0);
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidSuccess(int i, int i2) {
        YdFullVideo ydFullVideo = this.ydFullVideo;
        if (ydFullVideo != null) {
            ydFullVideo.biddingResultUpload(true, i, i2);
        }
    }

    @Override // io.dcloud.api.custom.type.full.UniAdCustomFullScreenVideoLoader
    public void show(Activity activity) {
        YdFullVideo ydFullVideo = this.ydFullVideo;
        if (ydFullVideo != null) {
            ydFullVideo.show();
        }
    }
}
