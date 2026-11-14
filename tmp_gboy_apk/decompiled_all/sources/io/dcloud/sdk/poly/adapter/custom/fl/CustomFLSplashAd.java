package io.dcloud.sdk.poly.adapter.custom.fl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.ydsdk.YdSpread;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.splash.UniAdCustomSplashLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomFLSplashAd extends UniAdCustomSplashLoader {
    private SpreadLoadListener.SpreadAd mSpreadAd;
    private YdSpread mYdSpread;

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void destroy() {
        YdSpread ydSpread = this.mYdSpread;
        if (ydSpread != null) {
            ydSpread.destroy();
            this.mYdSpread = null;
        }
        if (this.mSpreadAd != null) {
            this.mSpreadAd = null;
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public boolean isReady() {
        SpreadLoadListener.SpreadAd spreadAd = this.mSpreadAd;
        if (spreadAd != null) {
            spreadAd.isAdReady();
        }
        SpreadLoadListener.SpreadAd spreadAd2 = this.mSpreadAd;
        return spreadAd2 != null && spreadAd2.isAdReady();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        String slotId = uniAdSlot.getSlotId();
        if (TextUtils.isEmpty(slotId)) {
            onLoadFail(330002, "posId无效");
            return;
        }
        YdSpread build = new YdSpread.Builder(activity).setKey(slotId).setAcceptedSize(uniAdSlot.getWidth(), uniAdSlot.getHeight()).setSpreadLoadListener(new SpreadLoadListener() { // from class: io.dcloud.sdk.poly.adapter.custom.fl.CustomFLSplashAd.2
            @Override // com.fl.saas.base.interfaces.SpreadLoadListener
            public void onADLoaded(SpreadLoadListener.SpreadAd spreadAd) {
                CustomFLSplashAd.this.mSpreadAd = spreadAd;
                if (CustomFLSplashAd.this.getBidType() == 1) {
                    CustomFLSplashAd customFLSplashAd = CustomFLSplashAd.this;
                    customFLSplashAd.setBidPrice(customFLSplashAd.mSpreadAd.getEcpm());
                }
                CustomFLSplashAd.this.onLoadSuccess();
            }
        }).setSpreadListener(new AdViewSpreadListener() { // from class: io.dcloud.sdk.poly.adapter.custom.fl.CustomFLSplashAd.1
            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdClick(String str) {
                CustomFLSplashAd.this.onAdClicked();
            }

            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdClose() {
                CustomFLSplashAd.this.onAdClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdDisplay() {
                CustomFLSplashAd.this.onAdShow();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                CustomFLSplashAd.this.onLoadFail(ydError.getCode(), ydError.getMsg());
            }
        }).build();
        this.mYdSpread = build;
        build.requestSpread();
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidFail(int i, int i2) {
        YdSpread ydSpread = this.mYdSpread;
        if (ydSpread != null) {
            ydSpread.biddingResultUpload(false, i, 0);
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void onBidSuccess(int i, int i2) {
        YdSpread ydSpread = this.mYdSpread;
        if (ydSpread != null) {
            ydSpread.biddingResultUpload(true, i, i2);
        }
    }

    @Override // io.dcloud.api.custom.type.splash.UniAdCustomSplashLoader
    public void show(ViewGroup viewGroup) {
        SpreadLoadListener.SpreadAd spreadAd = this.mSpreadAd;
        if (spreadAd != null) {
            spreadAd.show(viewGroup);
        }
    }
}
