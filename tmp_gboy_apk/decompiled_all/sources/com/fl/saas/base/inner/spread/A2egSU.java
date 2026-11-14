package com.fl.saas.base.inner.spread;

import android.view.ViewGroup;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
import com.fl.saas.base.inner.spread.InnerNativeSpreadAdapter;
import com.fl.saas.base.inner.spread.coustomView.NativeSpreadView;
import com.fl.saas.common.util.feature.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Supplier, AdViewSpreadAdapter.AdViewLoadListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ Object f10771AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f10772AlLFFp;

    public /* synthetic */ A2egSU(Object obj, Object obj2) {
        this.f10771AcNBzu = obj;
        this.f10772AlLFFp = obj2;
    }

    @Override // com.fl.saas.base.adapter.AdViewSpreadAdapter.AdViewLoadListener
    public void AdViewLoad(ViewGroup viewGroup) {
        ((InnerNativeSpreadAdapter.AnonymousClass2) this.f10771AcNBzu).lambda$onLoaded$0((NativeSpreadView) this.f10772AlLFFp, viewGroup);
    }

    @Override // com.fl.saas.common.util.feature.Supplier
    public Object get() {
        Integer lambda$onNativeAdLoaded$0;
        lambda$onNativeAdLoaded$0 = ((InnerNativeSpreadAdapter.AnonymousClass1) this.f10771AcNBzu).lambda$onNativeAdLoaded$0((NativeAd) this.f10772AlLFFp);
        return lambda$onNativeAdLoaded$0;
    }
}
