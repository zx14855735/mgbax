package com.bytedance.sdk.openadsdk.mediation.manager.xj.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements MediationAdLoadInfo {
    private ValueSet hf;
    private final Function<SparseArray<Object>, Object> xj;

    public hf(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.hf = ARc23Z.f4110A4TApA;
        function = function == null ? ARc23Z.f4112ADYaiT : function;
        this.xj = function;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(-99999986, sparseArray, -99999987, -99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.hf = A2egSU.AMqCpz((SparseArray) apply);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdType() {
        return this.hf.stringValue(271003);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdnName() {
        return this.hf.stringValue(271002);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public int getErrCode() {
        return this.hf.intValue(271004);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getErrMsg() {
        return this.hf.stringValue(271005);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getMediationRit() {
        return this.hf.stringValue(271001);
    }
}
