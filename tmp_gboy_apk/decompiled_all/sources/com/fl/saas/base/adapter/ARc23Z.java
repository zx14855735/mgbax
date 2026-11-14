package com.fl.saas.base.adapter;

import com.fl.saas.base.adapter.base.BaseAdAdapter;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.util.feature.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ARc23Z implements Supplier, BaseNativeAd.WinAdInfoMapper {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ BaseAdAdapter f10721AcNBzu;

    public /* synthetic */ ARc23Z(BaseAdAdapter baseAdAdapter) {
        this.f10721AcNBzu = baseAdAdapter;
    }

    @Override // com.fl.saas.common.util.feature.Supplier
    public Object get() {
        int i = AdViewInterstitialAdapter.f10729A2egSU;
        return ((AdViewInterstitialAdapter) this.f10721AcNBzu).getActivityValid();
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd.WinAdInfoMapper
    public WinAdInfo getAdInfo() {
        return ((AdViewMixNativeAdapter) this.f10721AcNBzu).getWinInfo();
    }
}
