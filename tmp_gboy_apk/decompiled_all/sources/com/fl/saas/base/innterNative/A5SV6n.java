package com.fl.saas.base.innterNative;

import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.common.util.feature.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A5SV6n implements Supplier, AmA8tU.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ BaseNativeAd f10784AcNBzu;

    public /* synthetic */ A5SV6n(BaseNativeAd baseNativeAd) {
        this.f10784AcNBzu = baseNativeAd;
    }

    @Override // AmA8tU.A2egSU
    public Object apply(Object obj) {
        return this.f10784AcNBzu.createNativeMaterial(obj);
    }

    @Override // com.fl.saas.common.util.feature.Supplier
    public Object get() {
        NativeMaterial lambda$getAdMaterial$1;
        lambda$getAdMaterial$1 = this.f10784AcNBzu.lambda$getAdMaterial$1();
        return lambda$getAdMaterial$1;
    }
}
