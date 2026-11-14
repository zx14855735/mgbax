package com.fl.saas.base.inner.interstitial;

import android.app.Activity;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.inner.InnerNativeAdapter;
import com.fl.saas.base.inner.YdAdTempHelper;
import com.fl.saas.base.inner.interstitial.InnerNativeInterstitialAdapter;
import com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView;
import com.fl.saas.base.innterNative.ActionView;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class InnerNativeInterstitialAdapter extends AdViewInterstitialAdapter implements InnerNativeAdapter, AdChangeCacheData {
    private final String TAG = CommConstant.getObjTag(this);
    private MixNativeHandler handler;
    private NativeInterstitialView interstitialHelper;
    private NativeAd mNativeAd;

    /* renamed from: com.fl.saas.base.inner.interstitial.InnerNativeInterstitialAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(com.fl.saas.base.bidding.A4TApA.A2egSU(nativeAd, InnerNativeInterstitialAdapter.this.handler));
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            InnerNativeInterstitialAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeInterstitialAdapter.this.bindC2SBidECPM(new Supplier() { // from class: com.fl.saas.base.inner.interstitial.A4TApA
                @Override // com.fl.saas.common.util.feature.Supplier
                public final Object get() {
                    Integer lambda$onNativeAdLoaded$0;
                    lambda$onNativeAdLoaded$0 = InnerNativeInterstitialAdapter.AnonymousClass1.this.lambda$onNativeAdLoaded$0(nativeAd);
                    return lambda$onNativeAdLoaded$0;
                }
            });
            InnerNativeInterstitialAdapter.this.mNativeAd = nativeAd;
            InnerNativeInterstitialAdapter.this.render(nativeAd);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0093, code lost:
    
        if (com.fl.saas.common.util.StringUtils.containsField(r3, r4 + "") != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkStyle() {
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
            java.lang.String r5 = "interstitialValue4"
            long r6 = r4.getLong(r5)
            com.fl.saas.config.utils.SPUtil r4 = com.fl.saas.config.utils.SPUtil.getInstance()
            java.lang.String r8 = "interstitialValue5"
            int r4 = r4.getInt(r8)
            com.fl.saas.config.utils.SPUtil r9 = com.fl.saas.config.utils.SPUtil.getInstance()
            java.lang.String r10 = "interstitialValue6"
            int r9 = r9.getInt(r10)
            com.fl.saas.config.utils.SPUtil r11 = com.fl.saas.config.utils.SPUtil.getInstance()
            java.lang.String r12 = "interstitialValue7"
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
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.inner.interstitial.InnerNativeInterstitialAdapter.checkStyle():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInterstitial$0(Activity activity) {
        NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
        nativePrepareInfo.setActivity(activity);
        nativePrepareInfo.setCtaView(this.interstitialHelper.getCATView());
        nativePrepareInfo.setClickView(this.interstitialHelper.getClicks());
        this.mNativeAd.prepare(nativePrepareInfo);
        if (this.interstitialHelper.showDialog(activity)) {
            return;
        }
        onAdFailed(YdError.create(ErrorCodeConstant.RENDER_ERROR, "Interstitial show Failed"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(NativeAd nativeAd) {
        InterstitialViewHelper interstitialViewHelper = new InterstitialViewHelper(getContext(), isFullScreenInterstitial(), nativeAd.getAdMaterial(), getAdSource().getInterstitialStyle(), new InterstitialViewEvent() { // from class: com.fl.saas.base.inner.interstitial.InnerNativeInterstitialAdapter.2
            @Override // com.fl.saas.base.inner.InnerViewLoaderEvent
            public void onAdFailed(YdError ydError) {
                InnerNativeInterstitialAdapter.this.disposeError(ydError);
            }

            @Override // com.fl.saas.base.inner.interstitial.InterstitialViewEvent
            public void onDismiss() {
                InnerNativeInterstitialAdapter.this.onClosedEvent();
                if (InnerNativeInterstitialAdapter.this.mNativeAd != null) {
                    InnerNativeInterstitialAdapter.this.mNativeAd.destroy();
                }
            }

            @Override // com.fl.saas.base.inner.InnerViewLoaderEvent
            public void onLoaded(NativeInterstitialView nativeInterstitialView) {
                InnerNativeInterstitialAdapter.this.onLoadedEvent();
            }
        });
        this.interstitialHelper = interstitialViewHelper;
        nativeAd.renderAdContainer(interstitialViewHelper.getNativeAdView(), this.interstitialHelper.getSelfView());
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.base.inner.interstitial.InnerNativeInterstitialAdapter.3
            private boolean isReportExposure = false;

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                if (InnerNativeInterstitialAdapter.this.changeReRequestCount()) {
                    InnerNativeInterstitialAdapter.this.closeTopCountDownView();
                    InnerNativeInterstitialAdapter.this.reRequest();
                } else {
                    if (!InnerNativeInterstitialAdapter.this.getAdSource().isAutoClose() || InnerNativeInterstitialAdapter.this.getAdSource().isDownLoad) {
                        InnerNativeInterstitialAdapter.this.interstitialHelper.click();
                        InnerNativeInterstitialAdapter.this.onClickedEvent();
                    }
                    InnerNativeInterstitialAdapter.this.closeTopCountDownView();
                }
                InnerNativeInterstitialAdapter.this.interstitialHelper.closeDialog();
                InnerNativeInterstitialAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                InnerNativeInterstitialAdapter.this.onAdFailed(ydError);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                if (this.isReportExposure) {
                    return;
                }
                this.isReportExposure = true;
                InnerNativeInterstitialAdapter.this.onShowEvent();
                InnerNativeInterstitialAdapter.this.interstitialHelper.startCountdown();
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
        this.interstitialHelper.setRainView(getAdSource().isRedPackageRain()).setClosePos(getAdSource().getCloseButtonPos()).setCloseViewSize(getAdSource().button_size).setCountDown(true ^ getAdSource().isCloseButtonShow(), getAdSource().count_down).setAutoClose(getAdSource().isAutoClose()).setClickType(getAdSource().only_button).setShakeType(getAdSource().isHotSpot() && getAdSource().hotspot_type == 2).setSpeed(getAdSource().sensitivity).setAnimalTime(getAdSource().animate_time).setAnimalStartTime(getAdSource().animate_start_time).setAdType(getClass().getName().contains("S2SInterstitialAdapter"));
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter, com.fl.saas.base.bidding.BiddingResult
    public final /* synthetic */ void biddingResult(boolean z, int i, int i2, int i3) {
        com.fl.saas.base.inner.A2egSU.A2egSU(this, z, i, i2, i3);
    }

    @Override // com.fl.saas.base.adapter.AdViewInterstitialAdapter, com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (!isCache()) {
            innerDestroy(this.handler, this.mNativeAd);
        }
        NativeInterstitialView nativeInterstitialView = this.interstitialHelper;
        if (nativeInterstitialView != null) {
            nativeInterstitialView.destroy();
        }
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
        CNPG0E.A4TApA interstitialSize = InterstitialViewHelper.getInterstitialSize();
        this.handler.setContext(getContext()).setAdId(getAppId(), getPosId()).setAdSource(getAdSource()).setAdParams(new AdParams.Builder(getKey()).setImageAcceptedHeight(((Integer) interstitialSize.f1611A4TApA).intValue()).setImageAcceptedWidth(((Integer) interstitialSize.f1610A2egSU).intValue()).build()).setLoadListener(new AnonymousClass1());
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

    @Override // com.fl.saas.base.adapter.AdViewInterstitialAdapter
    public boolean selfCloseInterstitialAd() {
        NativeInterstitialView nativeInterstitialView = this.interstitialHelper;
        if (nativeInterstitialView == null) {
            return false;
        }
        nativeInterstitialView.closeDialog();
        return true;
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, adSource);
        }
    }

    @Override // com.fl.saas.base.adapter.AdViewInterstitialAdapter
    public void showInterstitial(Activity activity) {
        NativeInterstitialView nativeInterstitialView = this.interstitialHelper;
        if (nativeInterstitialView != null) {
            nativeInterstitialView.setViewType(checkStyle(), getAdSource().resp_area_ratio);
            NativeAd nativeAd = this.mNativeAd;
            if (nativeAd instanceof ActionView) {
                this.interstitialHelper.addActionView(((ActionView) nativeAd).bindActionView(ActionView.Type.Interstitial));
            }
            String str = getAdSource().req_id;
            YdAdTempHelper.getInstance().addListener(str, new YdAdTempHelper.InterstitialActivityLoadListener() { // from class: com.fl.saas.base.inner.interstitial.A2egSU
                @Override // com.fl.saas.base.inner.YdAdTempHelper.InterstitialActivityLoadListener
                public final void onActivityCreate(Activity activity2) {
                    InnerNativeInterstitialAdapter.this.lambda$showInterstitial$0(activity2);
                }
            });
            YdInterstitialActivity.startMe(activity, str);
        }
    }
}
