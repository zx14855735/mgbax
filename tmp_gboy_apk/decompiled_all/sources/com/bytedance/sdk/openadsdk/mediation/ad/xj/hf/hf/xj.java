package com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.app.Activity;
import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.zg.w.hf.c;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements Function<SparseArray<Object>, Object> {
    private PluginValueSet xj;

    private PluginValueSet qt() {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        A4TApA2.ARc23Z(268101, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<u>() { // from class: com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public u get() {
                return xj.this.p();
            }
        }));
        return A4TApA2.A2egSU();
    }

    public PluginValueSet am() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet qt = qt();
        this.xj = qt;
        return qt;
    }

    public abstract List<String> c();

    public abstract int d();

    public abstract String f();

    public abstract com.bytedance.sdk.openadsdk.zg.w.hf.u g();

    public abstract c hf(Activity activity);

    public abstract c hf(Dialog dialog, Integer[] numArr);

    public abstract String hf();

    public abstract String kd();

    public abstract u p();

    public abstract boolean pl();

    public abstract int tf();

    public abstract String u();

    public abstract String w();

    public abstract w xj(Activity activity);

    public abstract w xj(Activity activity, Map<String, Object> map);

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            ADYaiT2.objectValue(-99999985, Class.class);
            if (intValue == -99999986) {
                return am().sparseArray();
            }
            switch (intValue) {
                case 268001:
                    return xj();
                case 268002:
                    return hf();
                case 268003:
                    return w();
                case 268004:
                    return u();
                case 268005:
                    return kd();
                case 268006:
                    return Double.class.cast(Double.valueOf(y()));
                case 268007:
                    return c();
                case 268008:
                    return f();
                case 268009:
                    return Integer.class.cast(Integer.valueOf(d()));
                case 268010:
                    return Integer.class.cast(Integer.valueOf(tf()));
                case 268011:
                    xj((Activity) ADYaiT2.objectValue(0, Activity.class), (ViewGroup) ADYaiT2.objectValue(1, ViewGroup.class), (List) ADYaiT2.objectValue(2, List.class), (List) ADYaiT2.objectValue(3, List.class), (List) ADYaiT2.objectValue(4, List.class), new com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.u(AaHO0E.AYUAbz(ADYaiT2.objectValue(5, AaHO0E.ARc23Z()))));
                    return null;
                case 268012:
                    return Boolean.class.cast(Boolean.valueOf(pl()));
                default:
                    switch (intValue) {
                        case 268016:
                            xj((Activity) ADYaiT2.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(1, AaHO0E.ARc23Z()))));
                            return null;
                        case 268017:
                            xj((Dialog) ADYaiT2.objectValue(0, Dialog.class), (Integer[]) ADYaiT2.arrayValue(1, Integer.class));
                            return null;
                        case 268018:
                            return hf((Activity) ADYaiT2.objectValue(0, Activity.class));
                        case 268019:
                            return hf((Dialog) ADYaiT2.objectValue(0, Dialog.class), (Integer[]) ADYaiT2.arrayValue(1, Integer.class));
                        case 268020:
                            return g();
                        default:
                            switch (intValue) {
                                case 268102:
                                    return xj((Activity) ADYaiT2.objectValue(0, Activity.class));
                                case 268103:
                                    return xj((Activity) ADYaiT2.objectValue(0, Activity.class), (Map<String, Object>) ADYaiT2.objectValue(1, Map.class));
                            }
                    }
            }
        }
        return null;
    }

    public abstract String xj();

    public abstract void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.u uVar);

    public abstract void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar);

    public abstract void xj(Dialog dialog, Integer[] numArr);

    public abstract double y();
}
