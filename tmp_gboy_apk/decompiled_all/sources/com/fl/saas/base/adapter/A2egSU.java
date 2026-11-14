package com.fl.saas.base.adapter;

import android.view.View;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.base.interfaces.AdViewBannerListener;
import com.fl.saas.base.interfaces.AdViewDrawVideoListener;
import com.fl.saas.base.interfaces.AdViewNativeListener;
import com.fl.saas.base.interfaces.AdViewTemplateListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10711A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f10712A4TApA;

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f10711A2egSU = i;
        this.f10712A4TApA = obj;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f10711A2egSU) {
            case 0:
                ((AdViewBannerAdapter) this.f10712A4TApA).lambda$showAd$0((AdViewBannerListener) obj);
                break;
            case 1:
                ((AdViewDrawVideoAdapter) this.f10712A4TApA).lambda$showAd$0((AdViewDrawVideoListener) obj);
                break;
            case 2:
                ((AdViewMixNativeAdapter) this.f10712A4TApA).lambda$showAd$1((NativeAd) obj);
                break;
            case 3:
                ((AdViewNativeAdapter) this.f10712A4TApA).lambda$showAd$0((AdViewNativeListener) obj);
                break;
            case 4:
                ((AdViewSpreadAdapter) this.f10712A4TApA).lambda$showAd$0((SpreadLoadListener) obj);
                break;
            case 5:
                ((AdViewTemplateAdapter) this.f10712A4TApA).lambda$showAd$0((AdViewTemplateListener) obj);
                break;
            case 6:
                ((AdViewTemplateListener) obj).onClosed((View) this.f10712A4TApA);
                break;
            default:
                ((NativeLoadListener) obj).onAdFailed((YdError) this.f10712A4TApA);
                break;
        }
    }
}
