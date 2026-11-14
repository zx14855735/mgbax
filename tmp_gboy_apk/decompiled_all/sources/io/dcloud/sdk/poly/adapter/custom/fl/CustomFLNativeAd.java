package io.dcloud.sdk.poly.adapter.custom.fl;

import android.app.Activity;
import android.view.View;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.exception.YdError;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomFLNativeAd extends UniAdCustomNativeAd {
    Activity activity;
    private boolean isPrepared;
    NativeAd mNativeAd;
    NativeAdView nativeAdView;

    public CustomFLNativeAd(Activity activity, NativeAd nativeAd) {
        this.mNativeAd = nativeAd;
        this.activity = activity;
    }

    private NativeAdView getNativeAdView() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null || !nativeAd.isNativeExpress()) {
            return null;
        }
        NativeAdView nativeAdView = new NativeAdView(this.activity);
        nativeAdView.addView(this.mNativeAd.getAdMaterial().getAdMediaView());
        return nativeAdView;
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void destroy() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.mNativeAd = null;
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public View getNativeAd() {
        if (this.nativeAdView == null) {
            NativeAdView nativeAdView = getNativeAdView();
            this.nativeAdView = nativeAdView;
            NativeAd nativeAd = this.mNativeAd;
            if (nativeAd != null && !this.isPrepared) {
                this.isPrepared = true;
                nativeAd.renderAdContainer(nativeAdView, null);
                NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
                nativePrepareInfo.setActivity(this.activity);
                this.mNativeAd.prepare(nativePrepareInfo);
            }
        }
        ViewHelper.removeParent(this.nativeAdView);
        return this.nativeAdView;
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void onBidFail(int i, int i2) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.biddingResultUpload(false, i, 0);
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void onBidSuccess(int i, int i2) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.biddingResultUpload(true, i, i2);
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void render() {
        if (this.nativeAdView == null) {
            this.nativeAdView = getNativeAdView();
        }
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null || this.nativeAdView == null) {
            onRenderFail(40003, "广告数据为空");
            return;
        }
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: io.dcloud.sdk.poly.adapter.custom.fl.CustomFLNativeAd.1
            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                CustomFLNativeAd.this.onAdClicked();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                CustomFLNativeAd.this.onAdClosed("");
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                CustomFLNativeAd.this.onAdShow();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
            }
        });
        if (!this.isPrepared) {
            this.isPrepared = true;
            this.mNativeAd.renderAdContainer(this.nativeAdView, null);
            NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
            nativePrepareInfo.setActivity(this.activity);
            this.mNativeAd.prepare(nativePrepareInfo);
        }
        onRenderSuccess();
    }
}
