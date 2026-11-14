package com.bytedance.msdk.y.hf;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends com.bytedance.sdk.openadsdk.core.wo.u implements Supplier<SparseArray<Object>> {
    private com.bytedance.sdk.openadsdk.zg.w.w.w xj;

    public y(com.bytedance.sdk.openadsdk.zg.w.w.w wVar) {
        this.xj = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) xj().sparseArray();
        }
        return null;
    }

    @Override // java.util.function.Supplier
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public SparseArray<Object> get() {
        PluginValueSet xj = xj();
        if (xj != null) {
            return xj.sparseArray();
        }
        return null;
    }

    public PluginValueSet xj() {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        com.bytedance.sdk.openadsdk.zg.w.w.w wVar = this.xj;
        Double valueOf = Double.valueOf(wVar != null ? wVar.xj() : 0.0d);
        SparseArray sparseArray = A4TApA2.f4119A2egSU;
        sparseArray.put(8481, valueOf);
        com.bytedance.sdk.openadsdk.zg.w.w.w wVar2 = this.xj;
        sparseArray.put(8482, Double.valueOf(wVar2 != null ? wVar2.hf() : 0.0d));
        return A4TApA2.A2egSU();
    }
}
