package com.fl.saas.base.inner.template;

import android.app.Activity;
import android.view.View;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.adapter.AdViewTemplateAdapter;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.bidding.A4TApA;
import com.fl.saas.base.inner.InnerNativeAdapter;
import com.fl.saas.base.inner.template.InnerNativeTemplateAdapter;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class InnerNativeTemplateAdapter extends AdViewTemplateAdapter implements InnerNativeAdapter, AdChangeCacheData {
    private final String TAG = CommConstant.getObjTag(this);
    private MixNativeHandler handler;
    private NativeAd mNativeAd;

    /* renamed from: com.fl.saas.base.inner.template.InnerNativeTemplateAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(A4TApA.A2egSU(nativeAd, InnerNativeTemplateAdapter.this.handler));
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            InnerNativeTemplateAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeTemplateAdapter.this.bindC2SBidECPM(new Supplier() { // from class: com.fl.saas.base.inner.template.A2egSU
                @Override // com.fl.saas.common.util.feature.Supplier
                public final Object get() {
                    Integer lambda$onNativeAdLoaded$0;
                    lambda$onNativeAdLoaded$0 = InnerNativeTemplateAdapter.AnonymousClass1.this.lambda$onNativeAdLoaded$0(nativeAd);
                    return lambda$onNativeAdLoaded$0;
                }
            });
            InnerNativeTemplateAdapter.this.mNativeAd = nativeAd;
            InnerNativeTemplateAdapter.this.render(nativeAd);
        }
    }

    private void bindEvent(NativeAd nativeAd) {
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.base.inner.template.InnerNativeTemplateAdapter.2
            private boolean isReportExposure = false;

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                InnerNativeTemplateAdapter.this.onClickedEvent(0);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                InnerNativeTemplateAdapter.this.onClosedEvent(nativeAdView);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                InnerNativeTemplateAdapter.this.onAdFailed(ydError);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                if (this.isReportExposure) {
                    return;
                }
                this.isReportExposure = true;
                InnerNativeTemplateAdapter.this.onShowEvent(0);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(NativeAd nativeAd) {
        if (!nativeAd.isNativeExpress()) {
            LogcatUtil.d(this.TAG, "is not express ad");
            disposeError(YdError.create(ErrorCodeConstant.RENDER_ERROR, "is not express ad"));
            return;
        }
        bindEvent(nativeAd);
        NativeMaterial adMaterial = nativeAd.getAdMaterial();
        NativeAdView nativeAdView = new NativeAdView(getContext());
        nativeAd.renderAdContainer(nativeAdView, null);
        NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
        nativePrepareInfo.setActivity(getActivityOrNull());
        nativeAd.prepare(nativePrepareInfo);
        ArrayList arrayList = new ArrayList();
        View adMediaView = adMaterial.getAdMediaView();
        if (adMediaView == null) {
            LogcatUtil.d(this.TAG, "MediaView is empty");
            disposeError(YdError.create(ErrorCodeConstant.RENDER_ERROR, "MediaView is empty"));
        } else {
            ViewHelper.removeParent(adMediaView);
            nativeAdView.addView(adMediaView, ViewHelper.getMatchParent());
            arrayList.add(nativeAdView);
            onLoadedEvent(arrayList);
        }
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter, com.fl.saas.base.bidding.BiddingResult
    public final /* synthetic */ void biddingResult(boolean z, int i, int i2, int i3) {
        com.fl.saas.base.inner.A2egSU.A2egSU(this, z, i, i2, i3);
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        innerDestroy(this.handler, this.mNativeAd);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter, com.fl.saas.base.interfaces.AdMaterial
    public final /* synthetic */ AdMaterial.AdMaterialData getAdMaterialData() {
        return com.fl.saas.base.inner.A2egSU.A4TApA(this);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    public NativeAd getNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        this.handler = loadNativeHandler();
        this.handler.setContext(getContext()).setAdId(getAppId(), getPosId()).setAdSource(getAdSource()).setAdParams(new AdParams.Builder(getKey()).setExpressHeight(getHeight()).setExpressWidth(getWidth()).setExpressFullWidth().setExpressAutoHeight().build()).setLoadListener(new AnonymousClass1());
        this.handler.setAdStyle(NativeStyle.EXPRESS);
        this.handler.init();
        this.handler.load(activity);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    public final /* synthetic */ void innerDestroy(MixNativeHandler mixNativeHandler, NativeAd nativeAd) {
        com.fl.saas.base.inner.A2egSU.A5SV6n(this, mixNativeHandler, nativeAd);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter, com.fl.saas.base.interfaces.AdValid
    public final /* synthetic */ boolean isValid() {
        return com.fl.saas.base.inner.A2egSU.ADYaiT(this);
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, adSource);
        }
    }
}
