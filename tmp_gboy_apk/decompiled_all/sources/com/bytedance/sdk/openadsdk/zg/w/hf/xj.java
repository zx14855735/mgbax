package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements Function<SparseArray<Object>, Object> {
    private PluginValueSet xj;

    private PluginValueSet u() {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        A4TApA2.ARc23Z(263001, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Object>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.xj.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(xj.this.xj());
            }
        }));
        A4TApA2.ARc23Z(263002, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.xj.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return xj.this.hf();
            }
        }));
        return A4TApA2.A2egSU();
    }

    public abstract String hf();

    public PluginValueSet w() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet u = u();
        this.xj = u;
        return u;
    }

    public abstract int xj();

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        ADYaiT2.objectValue(-99999985, Class.class);
        if (intValue != -99999986) {
            return null;
        }
        return w().sparseArray();
    }
}
