package com.bytedance.sdk.openadsdk.mediation.bridge.custom.banner;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class MediationCustomBannerLoader extends MediationCustomAdBaseLoader {
    public final void callBannerAdClick() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(1009, sparseArray, -99999987, -99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callBannerAdClosed() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(1014, sparseArray, -99999987, -99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callBannerAdShow() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(1008, sparseArray, -99999987, -99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callLoadSuccess() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8107, sparseArray, -99999987, -99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8113) {
            y.w(MediationConstant.TAG, "MediationCustomBannerLoader showAd");
            return (T) getAdView();
        }
        if (i != 8121) {
            return null;
        }
        y.w(MediationConstant.TAG, "MediationCustomBaseLoader isReadyCondition");
        return (T) xj(isReadyCondition());
    }

    public abstract View getAdView();

    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public final void callLoadSuccess(double d) {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8107, sparseArray, -99999987, -99999985, String.class);
            sparseArray.put(8409, Double.valueOf(d));
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callLoadSuccess(Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8107, sparseArray, -99999987, -99999985, String.class);
            sparseArray.put(8075, map);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callLoadSuccess(double d, Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8107, sparseArray, -99999987, -99999985, String.class);
            sparseArray.put(8409, Double.valueOf(d));
            sparseArray.put(8075, map);
            this.mGmAdLoader.apply(sparseArray);
        }
    }
}
