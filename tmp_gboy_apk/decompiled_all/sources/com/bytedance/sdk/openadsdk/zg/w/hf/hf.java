package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf extends f {
    private PluginValueSet xj;

    private PluginValueSet f() {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        A4TApA2.ARc23Z(110001, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.hf.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public View get() {
                return hf.this.hf();
            }
        }));
        A4TApA2.ARc23Z(110003, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.hf.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public View get() {
                return hf.this.w();
            }
        }));
        A4TApA2.ARc23Z(110004, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.hf.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(hf.this.u());
            }
        }));
        A4TApA2.ARc23Z(110005, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.hf.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return hf.this.kd();
            }
        }));
        return A4TApA2.A2egSU();
    }

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.c c();

    public abstract View hf();

    public abstract Map<String, Object> kd();

    public abstract int u();

    public abstract View w();

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f, java.util.function.Function
    /* renamed from: xj */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        ADYaiT2.objectValue(-99999985, Class.class);
        switch (intValue) {
            case -99999986:
                return xj().sparseArray();
            case 110101:
                y();
                return null;
            case 110102:
                xj(new com.bytedance.sdk.openadsdk.zg.w.xj.w(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 110103:
                xj(new com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 110106:
                xj(new com.bytedance.sdk.openadsdk.u.xj.hf.xj.hf(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 110108:
                xj((ViewGroup) ADYaiT2.objectValue(0, ViewGroup.class));
                return null;
            case 110109:
                xj((ViewGroup) ADYaiT2.objectValue(0, ViewGroup.class), (Activity) ADYaiT2.objectValue(1, Activity.class));
                return null;
            case 110110:
                return c();
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void xj(ViewGroup viewGroup);

    public abstract void xj(ViewGroup viewGroup, Activity activity);

    public abstract void xj(com.bytedance.sdk.openadsdk.u.xj.hf.xj.hf hfVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj xjVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar);

    public abstract void y();

    public PluginValueSet xj() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet f = f();
        this.xj = f;
        return f;
    }
}
