package io.dcloud.sdk.poly.adapter.custom.fl;

import android.app.Activity;
import android.view.View;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.config.exception.YdError;
import io.dcloud.api.custom.type.draw.UniAdCustomDrawAd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomFLDrawAd extends UniAdCustomDrawAd {
    Activity context;
    NativeAd mDrawAd;
    NativeAdView nativeAdView;

    public CustomFLDrawAd(Activity activity, NativeAd nativeAd) {
        this.mDrawAd = nativeAd;
        this.context = activity;
    }

    private NativeAdView getNativeAdView() {
        NativeAd nativeAd = this.mDrawAd;
        if (nativeAd == null || !nativeAd.isNativeExpress()) {
            return null;
        }
        NativeAdView nativeAdView = new NativeAdView(this.context);
        nativeAdView.addView(this.mDrawAd.getAdMaterial().getAdMediaView());
        return nativeAdView;
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void destroy() {
        NativeAd nativeAd = this.mDrawAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.mDrawAd = null;
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public View getNativeAd() {
        if (this.nativeAdView == null) {
            this.nativeAdView = getNativeAdView();
        }
        return this.nativeAdView;
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void onBidFail(int i, int i2) {
        NativeAd nativeAd = this.mDrawAd;
        if (nativeAd != null) {
            nativeAd.biddingResultUpload(false, i, 0);
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void onBidSuccess(int i, int i2) {
        NativeAd nativeAd = this.mDrawAd;
        if (nativeAd != null) {
            nativeAd.biddingResultUpload(true, i, i2);
        }
    }

    @Override // io.dcloud.api.custom.type.feed.UniAdCustomNativeAd
    public void render() {
        if (this.nativeAdView == null) {
            this.nativeAdView = getNativeAdView();
        }
        NativeAd nativeAd = this.mDrawAd;
        if (nativeAd == null || this.nativeAdView == null) {
            onRenderFail(40003, "广告数据为空");
            return;
        }
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: io.dcloud.sdk.poly.adapter.custom.fl.CustomFLDrawAd.1
            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                CustomFLDrawAd.this.onAdClicked();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                CustomFLDrawAd.this.onAdClosed("");
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                CustomFLDrawAd.this.onAdShow();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
                CustomFLDrawAd.this.onVideoPlayEnd();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
                CustomFLDrawAd.this.onVideoPlayStart();
            }
        });
        this.mDrawAd.renderAdContainer(this.nativeAdView, null);
        NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
        nativePrepareInfo.setActivity(this.context);
        this.mDrawAd.prepare(nativePrepareInfo);
        onRenderSuccess();
    }
}
