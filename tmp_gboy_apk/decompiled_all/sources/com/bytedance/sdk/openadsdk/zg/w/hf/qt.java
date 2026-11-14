package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class qt extends f {
    private PluginValueSet xj;

    private PluginValueSet y() {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        A4TApA2.ARc23Z(120001, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.qt.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(qt.this.xj());
            }
        }));
        A4TApA2.ARc23Z(120002, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.qt.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return qt.this.hf();
            }
        }));
        A4TApA2.ARc23Z(120003, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.qt.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(qt.this.w());
            }
        }));
        A4TApA2.ARc23Z(120004, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Long>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.qt.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(qt.this.u());
            }
        }));
        return A4TApA2.A2egSU();
    }

    public PluginValueSet f() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet y = y();
        this.xj = y;
        return y;
    }

    public abstract Map<String, Object> hf();

    public abstract void hf(com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar);

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.y kd();

    public abstract long u();

    public abstract int w();

    public abstract int xj();

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f, java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        ADYaiT2.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return f().sparseArray();
        }
        if (intValue == 121109) {
            return kd();
        }
        switch (intValue) {
            case 120101:
                xj(new com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 120102:
                hf(new com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 120103:
                xj(new com.bytedance.sdk.openadsdk.io.xj.hf.xj.hf(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 120104:
                xj(new com.bytedance.sdk.openadsdk.zg.w.xj.w(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 120105:
                xj((Activity) ADYaiT2.objectValue(0, Activity.class));
                return null;
            case 120106:
                xj((Activity) ADYaiT2.objectValue(0, Activity.class), ADYaiT2.objectValue(1, Object.class), (String) ADYaiT2.objectValue(2, String.class));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void xj(Activity activity);

    public abstract void xj(Activity activity, Object obj, String str);

    public abstract void xj(com.bytedance.sdk.openadsdk.io.xj.hf.xj.hf hfVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar);
}
