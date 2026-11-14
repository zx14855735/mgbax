package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class MediationCustomNativeLoader extends MediationCustomAdBaseLoader {
    public final void callLoadSuccess(List<? extends MediationCustomNativeAd> list) {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8107, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(8303, list);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public final boolean isExpressRender() {
        Object apply;
        if (this.mGmAdLoader == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(8222, sparseArray, -99999987, -99999985, Boolean.class);
        apply = this.mGmAdLoader.apply(sparseArray);
        Boolean bool = (Boolean) apply;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isNativeAd() {
        Object apply;
        if (this.mGmAdLoader == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(8223, sparseArray, -99999987, -99999985, Boolean.class);
        apply = this.mGmAdLoader.apply(sparseArray);
        Boolean bool = (Boolean) apply;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
