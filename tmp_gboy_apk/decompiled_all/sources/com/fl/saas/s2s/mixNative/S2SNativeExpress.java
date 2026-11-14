package com.fl.saas.s2s.mixNative;

import android.content.Context;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.base.bean.MediaReturnMaterialBean;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.json.Yson;
import com.fl.saas.s2s.sdk.ad.S2STemplateViewHelper;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class S2SNativeExpress extends BaseNativeAd<S2SNative> implements BiddingResult, AdChangeCacheData {
    private int clickType;
    private final S2STemplateViewHelper helper;
    private final AdInfoPoJo mPoJo;
    private final NativeAdView nativeAdView;

    public S2SNativeExpress(Context context, S2SNative s2SNative, int i, int i2) {
        super(context, s2SNative);
        AdInfoPoJo adInfoPoJo = s2SNative.getNativeAdOpt().get();
        this.mPoJo = adInfoPoJo;
        int dip2px = DeviceUtil.dip2px(adInfoPoJo.left_right_margin);
        int dip2px2 = DeviceUtil.dip2px(adInfoPoJo.top_bottom_margin);
        NativeAdView nativeAdView = new NativeAdView(getContext());
        this.nativeAdView = nativeAdView;
        nativeAdView.setLayoutParams(ViewHelper.getWrapParent());
        S2STemplateViewHelper s2STemplateViewHelper = new S2STemplateViewHelper(context, S2STemplateViewHelper.Type.parse(adInfoPoJo.template_type_id));
        this.helper = s2STemplateViewHelper;
        NativeMaterial adMaterial = s2SNative.getAdMaterial();
        s2STemplateViewHelper.setTitle(adMaterial.getTitle()).setDes(adMaterial.getDescription()).setAction(adMaterial.getCallToAction()).setSize(i, i2).setMedia(adInfoPoJo).setPadding(dip2px, dip2px2).setAdLogo(adMaterial.getAdLogo()).setLogo(adMaterial.getIconUrl()).addCloseView().setOnClosedListener(new Runnable() { // from class: com.fl.saas.s2s.mixNative.AZkASS
            @Override // java.lang.Runnable
            public final void run() {
                S2SNativeExpress.this.onAdCloseEvent();
            }
        });
    }

    private boolean isOnlyButton() {
        int i;
        int i2 = this.clickType;
        if (i2 == 1 && ((i = this.mPoJo.creative.ctype) == 1 || i == 3)) {
            return true;
        }
        if (i2 == 2 && this.mPoJo.creative.ctype == 2) {
            return true;
        }
        if (i2 != 3) {
            return false;
        }
        int i3 = this.mPoJo.creative.ctype;
        return i3 > 3 || i3 < 1;
    }

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(final boolean z, final int i, final int i2, final int i3) {
        getNativeAdOpt().ifPresent(new Consumer() { // from class: com.fl.saas.s2s.mixNative.AZOQYO
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((S2SNative) obj).biddingResult(z, i, i2, i3);
            }
        });
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    public NativeMaterial createNativeMaterial(S2SNative s2SNative) {
        return S2SMixNativeHandler.adInfoToNativeMaterial(this.mPoJo, this.nativeAdView);
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd, com.fl.saas.api.mixNative.NativeAd
    public void destroy() {
        super.destroy();
        if (getNativeAd() != null) {
            getNativeAd().destroy();
        }
        S2STemplateViewHelper s2STemplateViewHelper = this.helper;
        if (s2STemplateViewHelper != null) {
            s2STemplateViewHelper.destroy();
        }
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd, com.fl.saas.ydsdk.api.MediaExtraInfo
    public String getMaterialJson() {
        if (this.mPoJo == null) {
            return "";
        }
        MediaReturnMaterialBean mediaReturnMaterialBean = new MediaReturnMaterialBean();
        mediaReturnMaterialBean.setImageUrl(this.mPoJo.img_url);
        mediaReturnMaterialBean.setVideoUrl(this.mPoJo.video_url);
        mediaReturnMaterialBean.setWidth(this.mPoJo.width);
        mediaReturnMaterialBean.setHeight(this.mPoJo.height);
        mediaReturnMaterialBean.setIcon(this.mPoJo.logo_icon);
        mediaReturnMaterialBean.setTitle(this.mPoJo.title);
        mediaReturnMaterialBean.setDesc(this.mPoJo.description);
        mediaReturnMaterialBean.setDeeplinkUrl(this.mPoJo.deep_url);
        mediaReturnMaterialBean.setLandingPageUrl(this.mPoJo.click_url);
        mediaReturnMaterialBean.setDownloadUrl(this.mPoJo.download_url);
        return new Yson().toJson(mediaReturnMaterialBean);
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    public void init(S2SNative s2SNative) {
        s2SNative.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.s2s.mixNative.S2SNativeExpress.1
            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                S2SNativeExpress.this.onAdClickedEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                S2SNativeExpress.this.onAdFailedEvent(ydError);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                S2SNativeExpress.this.onAdImpressedEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
                S2SNativeExpress.this.onAdVideoEndEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
                S2SNativeExpress.this.onAdVideoProgress(j);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
                S2SNativeExpress.this.onAdVideoStartEvent();
            }
        });
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public boolean isNativeExpress() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x005e  */
    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    /* renamed from: render, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void lambda$prepare$0(com.fl.saas.s2s.mixNative.S2SNative r5, com.fl.saas.api.mixNative.NativePrepareInfo r6) {
        /*
            r4 = this;
            r0 = 0
            com.fl.saas.s2s.sdk.ad.S2STemplateViewHelper r1 = r4.helper
            android.view.View r1 = r1.load()
            if (r1 == 0) goto L17
            android.view.ViewParent r2 = r1.getParent()
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L17
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r2.removeView(r1)
            goto L38
        L17:
            com.fl.saas.s2s.sdk.helper.AdInfoPoJo r2 = r4.mPoJo
            int r2 = r2.getHotType()
            r3 = 8
            if (r2 != r3) goto L2d
            com.fl.saas.s2s.sdk.ad.S2STemplateViewHelper r2 = r4.helper
            com.fl.saas.base.innterNative.ActionView$Type r3 = com.fl.saas.base.innterNative.ActionView.Type.Template
            android.view.View r3 = r5.bindActionView(r3)
            r2.addFillActionView(r3)
            goto L38
        L2d:
            com.fl.saas.s2s.sdk.ad.S2STemplateViewHelper r2 = r4.helper
            com.fl.saas.base.innterNative.ActionView$Type r3 = com.fl.saas.base.innterNative.ActionView.Type.Template
            android.view.View r3 = r5.bindActionView(r3)
            r2.addActionView(r3)
        L38:
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = -2
            r2.<init>(r3, r3)
            r3 = 17
            r2.gravity = r3
            com.fl.saas.api.mixNative.NativeAdView r3 = r4.nativeAdView
            r3.addView(r1, r2)
            com.fl.saas.api.mixNative.NativeAdView r2 = r4.nativeAdView
            r5.renderAdContainer(r2, r1)
            com.fl.saas.api.mixNative.NativePrepareInfo r2 = new com.fl.saas.api.mixNative.NativePrepareInfo
            r2.<init>()
            android.app.Activity r3 = r6.getActivity()
            r2.setActivity(r3)
            boolean r3 = r4.isOnlyButton()
            if (r3 != 0) goto L66
            r3 = 1
            android.view.View[] r3 = new android.view.View[r3]
            r3[r0] = r1
            r2.setClickView(r3)
        L66:
            java.util.List r6 = r6.getCtaViewList()
            android.view.View[] r0 = new android.view.View[r0]
            java.lang.Object[] r6 = r6.toArray(r0)
            android.view.View[] r6 = (android.view.View[]) r6
            r2.setCtaView(r6)
            r5.prepare(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.s2s.mixNative.S2SNativeExpress.lambda$prepare$0(com.fl.saas.s2s.mixNative.S2SNative, com.fl.saas.api.mixNative.NativePrepareInfo):void");
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        AdInfoPoJo adInfoPoJo = this.mPoJo;
        if (adInfoPoJo != null) {
            adInfoPoJo.trackId = str;
            String str2 = adSource.place_id;
            adInfoPoJo.place_id = str2;
            adInfoPoJo.global_group_id = adSource.group_id;
            adInfoPoJo.global_place_id = str2;
            adInfoPoJo.global_test_id = adSource.test_id;
        }
    }

    public S2SNativeExpress setClickType(int i) {
        this.clickType = i;
        return this;
    }
}
