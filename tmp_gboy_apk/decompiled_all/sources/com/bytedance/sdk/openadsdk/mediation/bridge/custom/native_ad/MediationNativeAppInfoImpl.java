package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.xj.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationNativeAppInfoImpl extends xj {
    private SparseArray<Object> hf = new SparseArray<>();
    private MediationNativeAdAppInfo xj;

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.xj = mediationNativeAdAppInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xj.xj
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) values();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xj.xj
    public SparseArray<Object> get() {
        SparseArray<Object> values = values();
        if (values != null) {
            return values;
        }
        return null;
    }

    public SparseArray<Object> values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.xj;
        if (mediationNativeAdAppInfo != null) {
            this.hf.put(8505, mediationNativeAdAppInfo.getAppName());
            this.hf.put(8506, this.xj.getAuthorName());
            this.hf.put(8507, Long.valueOf(this.xj.getPackageSizeBytes()));
            this.hf.put(8508, this.xj.getPermissionsUrl());
            this.hf.put(8509, this.xj.getPermissionsMap());
            this.hf.put(8510, this.xj.getPrivacyAgreement());
            this.hf.put(8511, this.xj.getVersionName());
            this.hf.put(8512, this.xj.getAppInfoExtra());
        }
        return this.hf;
    }
}
