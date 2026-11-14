package com.bytedance.sdk.openadsdk.mediation.ad.xj.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends MediationNativeAdAppInfo {
    private final Function<SparseArray<Object>, Object> xj;

    public w(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? ARc23Z.f4112ADYaiT : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, Object> getAppInfoExtra() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(271042, sparseArray, -99999987, -99999985, Map.class);
        apply = this.xj.apply(sparseArray);
        return (Map) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAppName() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(271035, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAuthorName() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(271036, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getFunctionDescUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(271047, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public long getPackageSizeBytes() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271037);
        sparseArray.put(-99999985, Long.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, String> getPermissionsMap() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(271039, sparseArray, -99999987, -99999985, Map.class);
        apply = this.xj.apply(sparseArray);
        return (Map) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPermissionsUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(271038, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPrivacyAgreement() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(271040, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getRegUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(271051, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getVersionName() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(271041, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }
}
