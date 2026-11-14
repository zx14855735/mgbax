package com.fl.saas.base.inner.spread;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeClickCallbackListener;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.inner.InnerNativeAdapter;
import com.fl.saas.base.inner.spread.coustomView.NativeSpreadView;
import com.fl.saas.base.innterNative.ActionView;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.interfaces.AdMaterialJson;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.exception.YdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class InnerNativeSpreadAdapter extends AdViewSpreadAdapter implements InnerNativeAdapter, AdMaterialJson, AdChangeCacheData {
    private final String TAG = CommConstant.getObjTag(this);
    private MixNativeHandler handler;
    private NativeAd mNativeAd;

    /* renamed from: com.fl.saas.base.inner.spread.InnerNativeSpreadAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(com.fl.saas.base.bidding.A4TApA.A2egSU(nativeAd, InnerNativeSpreadAdapter.this.handler));
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            InnerNativeSpreadAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(NativeAd nativeAd) {
            InnerNativeSpreadAdapter.this.bindC2SBidECPM(new A2egSU(this, nativeAd));
            InnerNativeSpreadAdapter.this.mNativeAd = nativeAd;
            InnerNativeSpreadAdapter.this.render(nativeAd);
        }
    }

    /* renamed from: com.fl.saas.base.inner.spread.InnerNativeSpreadAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements SpreadViewEvent {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoaded$0(NativeSpreadView nativeSpreadView, ViewGroup viewGroup) {
            View view;
            if (InnerNativeSpreadAdapter.this.mNativeAd instanceof ActionView) {
                view = ((ActionView) InnerNativeSpreadAdapter.this.mNativeAd).bindActionView(ActionView.Type.Spread);
                if (view != null) {
                    nativeSpreadView.getSelfView().addView(view);
                }
            } else {
                view = null;
            }
            nativeSpreadView.setViewType(InnerNativeSpreadAdapter.this.getAdSource().display_countdown == 1, InnerNativeSpreadAdapter.this.checkStyle(), InnerNativeSpreadAdapter.this.getAdSource().resp_area_ratio);
            nativeSpreadView.setClickAreaVisibility(InnerNativeSpreadAdapter.this.getAdSource().isHotSpot(), view);
            nativeSpreadView.setRainView(InnerNativeSpreadAdapter.this.getAdSource().isRedPackageRain());
            nativeSpreadView.show();
            NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
            nativePrepareInfo.setActivity(InnerNativeSpreadAdapter.this.getActivityOrNull());
            nativePrepareInfo.setCtaView(nativeSpreadView.getCATView());
            nativePrepareInfo.setClickView(nativeSpreadView.getClicks());
            InnerNativeSpreadAdapter.this.mNativeAd.prepare(nativePrepareInfo);
            viewGroup.addView(nativeSpreadView.getNativeAdView(), ViewHelper.getMatchParent());
        }

        @Override // com.fl.saas.base.inner.InnerViewLoaderEvent
        public void onAdFailed(YdError ydError) {
            InnerNativeSpreadAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.base.inner.spread.SpreadViewEvent
        public void onDismiss() {
            InnerNativeSpreadAdapter.this.onClosedEvent();
        }

        @Override // com.fl.saas.base.inner.InnerViewLoaderEvent
        public void onLoaded(NativeSpreadView nativeSpreadView) {
            InnerNativeSpreadAdapter.this.onSpreadLoadedEvent(null, new A2egSU(this, nativeSpreadView));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0093, code lost:
    
        if (com.fl.saas.common.util.StringUtils.containsField(r3, r4 + "") != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean checkStyle() {
        /*
            r23 = this;
            com.fl.saas.common.saas.bean.AdSource r0 = r23.getAdSource()
            java.lang.String r0 = r0.display_effective_count
            com.fl.saas.common.saas.bean.AdSource r1 = r23.getAdSource()
            int r1 = r1.close_button_interval
            com.fl.saas.common.saas.bean.AdSource r2 = r23.getAdSource()
            int r2 = r2.close_button_freq
            java.lang.String r3 = ","
            java.lang.String[] r3 = r0.split(r3)
            com.fl.saas.config.utils.SPUtil r4 = com.fl.saas.config.utils.SPUtil.getInstance()
            java.lang.String r5 = "value4"
            long r6 = r4.getLong(r5)
            com.fl.saas.config.utils.SPUtil r4 = com.fl.saas.config.utils.SPUtil.getInstance()
            java.lang.String r8 = "value5"
            int r4 = r4.getInt(r8)
            com.fl.saas.config.utils.SPUtil r9 = com.fl.saas.config.utils.SPUtil.getInstance()
            java.lang.String r10 = "value6"
            int r9 = r9.getInt(r10)
            com.fl.saas.config.utils.SPUtil r11 = com.fl.saas.config.utils.SPUtil.getInstance()
            java.lang.String r12 = "value7"
            long r13 = r11.getLong(r12)
            r15 = r6
            long r6 = com.fl.saas.config.utils.DeviceUtil.getBootTime()
            long r15 = r6 - r15
            long r13 = r6 - r13
            r11 = 1
            int r4 = r4 + r11
            com.fl.saas.config.utils.SPUtil r11 = com.fl.saas.config.utils.SPUtil.getInstance()
            r11.putInt(r8, r4)
            r18 = 86400000(0x5265c00, double:4.2687272E-316)
            r11 = 0
            r20 = 0
            int r22 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r22 > 0) goto L60
            int r18 = (r15 > r20 ? 1 : (r15 == r20 ? 0 : -1))
            if (r18 >= 0) goto L78
        L60:
            com.fl.saas.config.utils.SPUtil r4 = com.fl.saas.config.utils.SPUtil.getInstance()
            r4.putInt(r10, r11)
            com.fl.saas.config.utils.SPUtil r4 = com.fl.saas.config.utils.SPUtil.getInstance()
            r4.putLong(r5, r6)
            com.fl.saas.config.utils.SPUtil r4 = com.fl.saas.config.utils.SPUtil.getInstance()
            r5 = 1
            r4.putInt(r8, r5)
            r4 = 1
            r9 = 0
        L78:
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L95
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = ""
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.fl.saas.common.util.StringUtils.containsField(r3, r0)
            if (r0 == 0) goto Lb8
        L95:
            long r0 = (long) r1
            r3 = 60000(0xea60, double:2.9644E-319)
            long r0 = r0 * r3
            int r3 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r3 > 0) goto La3
            int r0 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1))
            if (r0 >= 0) goto Lb8
        La3:
            if (r9 >= r2) goto Lb8
            r17 = 1
            int r9 = r9 + 1
            com.fl.saas.config.utils.SPUtil r0 = com.fl.saas.config.utils.SPUtil.getInstance()
            r0.putInt(r10, r9)
            com.fl.saas.config.utils.SPUtil r0 = com.fl.saas.config.utils.SPUtil.getInstance()
            r0.putLong(r12, r6)
            return r17
        Lb8:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.inner.spread.InnerNativeSpreadAdapter.checkStyle():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(NativeAd nativeAd) {
        final SpreadViewHelper spreadViewHelper = new SpreadViewHelper(getContext(), nativeAd.getAdMaterial(), new AnonymousClass2());
        nativeAd.renderAdContainer(spreadViewHelper.getNativeAdView(), spreadViewHelper.getSelfView());
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.base.inner.spread.InnerNativeSpreadAdapter.3
            private boolean isReportExposure = false;

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                InnerNativeSpreadAdapter.this.onClickedEvent();
                spreadViewHelper.onClicked();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                InnerNativeSpreadAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                InnerNativeSpreadAdapter.this.onAdFailed(ydError);
                spreadViewHelper.cancelCountdown();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                if (this.isReportExposure) {
                    return;
                }
                this.isReportExposure = true;
                spreadViewHelper.startCountdown();
                InnerNativeSpreadAdapter.this.onShowEvent();
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
        nativeAd.setClickCallBackListener(new NativeClickCallbackListener() { // from class: com.fl.saas.base.inner.spread.InnerNativeSpreadAdapter.4
            @Override // com.fl.saas.api.mixNative.NativeClickCallbackListener
            public void onAdClicked(String str) {
                InnerNativeSpreadAdapter.this.onClickedEvent(str);
            }
        });
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter, com.fl.saas.base.bidding.BiddingResult
    public final /* synthetic */ void biddingResult(boolean z, int i, int i2, int i3) {
        com.fl.saas.base.inner.A2egSU.A2egSU(this, z, i, i2, i3);
    }

    @Override // com.fl.saas.base.adapter.AdViewSpreadAdapter, com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
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

    @Override // com.fl.saas.base.interfaces.AdMaterialJson
    public String getMaterialJson() {
        NativeAd nativeAd = this.mNativeAd;
        return nativeAd != null ? nativeAd.getMaterialJson() : "";
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    public NativeAd getNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        this.handler = loadNativeHandler();
        this.handler.setContext(getContext()).setAdId(getAppId(), getPosId()).setAdSource(getAdSource()).setAdParams(new AdParams.Builder(getKey()).setImageAcceptedHeight(getHeightPX()).setImageAcceptedWidth(getWidthPX()).build()).setLoadListener(new AnonymousClass1());
        this.handler.setAdStyle(NativeStyle.NATIVE);
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
