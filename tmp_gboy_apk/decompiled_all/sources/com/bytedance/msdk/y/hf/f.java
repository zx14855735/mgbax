package com.bytedance.msdk.y.hf;

import IzHBwY.AYUAbz;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends com.bytedance.sdk.openadsdk.core.wo.u {
    private com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w xj;

    public f(com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w wVar) {
        this.xj = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) xj().sparseArray();
        }
        return null;
    }

    public PluginValueSet xj() {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w wVar = this.xj;
        A4TApA2.ARc23Z(8468, wVar != null ? wVar.xj() : new HashMap<>());
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w wVar2 = this.xj;
        A4TApA2.AMqCpz(8469, wVar2 != null ? wVar2.kd() : 0);
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w wVar3 = this.xj;
        A4TApA2.ASJ6gh(8470, wVar3 != null ? wVar3.w() : "");
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w wVar4 = this.xj;
        A4TApA2.ASJ6gh(8471, wVar4 != null ? wVar4.u() : "");
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w wVar5 = this.xj;
        A4TApA2.ASJ6gh(8472, wVar5 != null ? wVar5.hf() : "");
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w wVar6 = this.xj;
        A4TApA2.ASJ6gh(8473, wVar6 != null ? wVar6.y() : "");
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w wVar7 = this.xj;
        A4TApA2.ASJ6gh(8474, wVar7 != null ? wVar7.c() : "");
        return A4TApA2.A2egSU();
    }
}
