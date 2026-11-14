package com.fl.saas.base.adapter;

import android.app.Activity;
import com.fl.saas.base.adapter.base.BaseAdAdapter;
import com.fl.saas.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.base.base.builder.InnerNativeBuilder;
import com.fl.saas.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.base.base.builder.InnerTemplateBuilder;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.base.manager.AdViewVideoManager;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.feature.Predicate;
import com.fl.saas.common.util.feature.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class AZOQYO implements AmA8tU.A2egSU, Predicate, PreloadDoneCallback, Supplier {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10725AcNBzu;

    public /* synthetic */ AZOQYO(int i) {
        this.f10725AcNBzu = i;
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return KfamK9.A4TApA.A2egSU(this, predicate);
    }

    @Override // AmA8tU.A2egSU
    public Object apply(Object obj) {
        String lambda$createAdView$5;
        String lambda$new$1;
        Boolean lambda$isServerVerify$0;
        String str;
        switch (this.f10725AcNBzu) {
            case 0:
                return Integer.valueOf(((InnerNativeBuilder) obj).getAdCount());
            case 1:
                return Boolean.valueOf(((InnerNativeBuilder) obj).isManualReport());
            case 2:
                return Boolean.valueOf(((InnerNativeBuilder) obj).isSoundEnable());
            case 3:
                return Boolean.valueOf(((InnerNativeBuilder) obj).isStreamAd());
            case 4:
                return Boolean.valueOf(((InnerNativeBuilder) obj).isShowLogo());
            case 5:
                return Float.valueOf(((InnerSpreadBuilder) obj).getScreenPercentage());
            case 6:
                return ((InnerSpreadBuilder) obj).getContainer();
            case 7:
                return Integer.valueOf(((InnerSpreadBuilder) obj).getHeight());
            case 8:
                return ((InnerSpreadBuilder) obj).getSpreadLoadListener();
            case 9:
                return Integer.valueOf(((InnerTemplateBuilder) obj).getAdCount());
            case 10:
                return Integer.valueOf(((InnerTemplateBuilder) obj).getWidth());
            case 11:
                return Integer.valueOf(((InnerTemplateBuilder) obj).getHeight());
            case 12:
            case 13:
            case 14:
            case 17:
            default:
                str = ((AdSource) obj).req_id;
                return str;
            case 15:
                return ((InnerInterstitialBuilder) obj).getLocationMap();
            case 16:
                return ((InnerSpreadBuilder) obj).getLocationMap();
            case 18:
                return ((InnerNativeCustomView) obj).getCATView();
            case 19:
                lambda$createAdView$5 = InterstitialViewHelper.lambda$createAdView$5((Integer) obj);
                return lambda$createAdView$5;
            case 20:
                lambda$new$1 = InterstitialViewHelper.lambda$new$1((Integer) obj);
                return lambda$new$1;
            case 21:
                return ((YdNativePojo) obj).getVideoEventListener();
            case 22:
                return Integer.valueOf(((BaseNativeAd.EcpmMapper) obj).getECPM());
            case 23:
                return Boolean.valueOf(((AdViewFullVideoAdapter) obj).isVideoReady());
            case 24:
                return Boolean.valueOf(((AdViewInterstitialAdapter) obj).isIntersReady());
            case 25:
                return ((AdViewNativeAdapter) obj).loadBottomNativeAd();
            case 26:
                return ((AdViewSpreadAdapter) obj).getSplashEyeAd();
            case 27:
                return ((AdViewSpreadAdapter) obj).loadSpreadAd();
            case 28:
                lambda$isServerVerify$0 = AdViewVideoManager.lambda$isServerVerify$0((AdPlace) obj);
                return lambda$isServerVerify$0;
        }
    }

    @Override // com.fl.saas.common.util.feature.Supplier
    public Object get() {
        String lambda$render$8;
        lambda$render$8 = InterstitialViewHelper.lambda$render$8();
        return lambda$render$8;
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate negate() {
        return KfamK9.A4TApA.A4TApA(this);
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return KfamK9.A4TApA.A5SV6n(this, predicate);
    }

    @Override // com.fl.saas.base.interfaces.PreloadDoneCallback
    public void preloadDone() {
        switch (this.f10725AcNBzu) {
            case 13:
                AdCacheManager.lambda$loadCacheAd$2();
                break;
            default:
                AdCacheManager.lambda$loadCacheAd$3();
                break;
        }
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public boolean test(Object obj) {
        boolean lambda$getActivityValid$0;
        lambda$getActivityValid$0 = BaseAdAdapter.lambda$getActivityValid$0((Activity) obj);
        return lambda$getActivityValid$0;
    }
}
