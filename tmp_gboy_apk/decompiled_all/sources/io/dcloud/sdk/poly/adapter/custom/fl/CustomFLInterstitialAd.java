package io.dcloud.sdk.poly.adapter.custom.fl;

import android.app.Activity;
import android.text.TextUtils;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.ydsdk.YdInterstitial;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.interstitial.UniAdCustomInterstitialLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomFLInterstitialAd extends UniAdCustomInterstitialLoader {
    YdInterstitial ydInterstitial;

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void destroy() {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.destroy();
            this.ydInterstitial = null;
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public boolean isReady() {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        return ydInterstitial != null && ydInterstitial.isReady();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        String slotId = uniAdSlot.getSlotId();
        if (TextUtils.isEmpty(slotId)) {
            onLoadFail(330002, "posId无效");
            return;
        }
        YdInterstitial build = new YdInterstitial.Builder(activity).setKey(slotId).setInterstitialListener(new AdViewInterstitialListener() { // from class: io.dcloud.sdk.poly.adapter.custom.fl.CustomFLInterstitialAd.1
            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClick(String str) {
                CustomFLInterstitialAd.this.onAdClicked();
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClosed() {
                CustomFLInterstitialAd.this.onAdClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdDisplay() {
                CustomFLInterstitialAd.this.onAdShow();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                CustomFLInterstitialAd.this.onLoadFail(ydError.getCode(), ydError.getMsg());
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdReady() {
                if (CustomFLInterstitialAd.this.getBidType() == 1) {
                    CustomFLInterstitialAd customFLInterstitialAd = CustomFLInterstitialAd.this;
                    customFLInterstitialAd.setBidPrice(customFLInterstitialAd.ydInterstitial.getECPM());
                }
                CustomFLInterstitialAd.this.onLoadSuccess();
            }
        }).build();
        this.ydInterstitial = build;
        build.requestInterstitial();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidFail(int i, int i2) {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.biddingResultUpload(true, i, 0);
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidSuccess(int i, int i2) {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.biddingResultUpload(true, i, i2);
        }
    }

    @Override // io.dcloud.api.custom.type.interstitial.UniAdCustomInterstitialLoader
    public void show(Activity activity) {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.show(activity);
        }
    }
}
