package com.bytedance.msdk.y.hf;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends com.bytedance.sdk.openadsdk.core.wo.u implements Supplier<SparseArray<Object>> {
    private com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.hf xj;

    public c(com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.hf hfVar) {
        this.xj = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) w().sparseArray();
        }
        return null;
    }

    @Override // java.util.function.Supplier
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SparseArray<Object> get() {
        PluginValueSet w = w();
        if (w != null) {
            return w.sparseArray();
        }
        return null;
    }

    public boolean hf() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.kd();
        }
        return true;
    }

    public List<String> kd() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.hf();
        }
        return null;
    }

    public List<String> u() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.xj();
        }
        return null;
    }

    public PluginValueSet w() {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        A4TApA2.ARc23Z(8476, u());
        A4TApA2.ARc23Z(8477, kd());
        A4TApA2.AYUAbz(8478, y());
        A4TApA2.AYUAbz(8027, xj());
        A4TApA2.AYUAbz(8028, hf());
        return A4TApA2.A2egSU();
    }

    public boolean xj() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.u();
        }
        return false;
    }

    public boolean y() {
        com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.w();
        }
        return true;
    }
}
