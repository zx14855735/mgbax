package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.app.Activity;
import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Supplier;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class am extends f {
    private PluginValueSet xj;

    private PluginValueSet tf() {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        A4TApA2.ARc23Z(150001, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.am.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public View get() {
                return am.this.xj();
            }
        }));
        A4TApA2.ARc23Z(150002, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.am.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(am.this.hf());
            }
        }));
        A4TApA2.ARc23Z(150003, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<u>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.am.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public u get() {
                return am.this.y();
            }
        }));
        A4TApA2.ARc23Z(150004, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.am.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(am.this.w());
            }
        }));
        A4TApA2.ARc23Z(150005, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.am.5
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return am.this.f();
            }
        }));
        return A4TApA2.A2egSU();
    }

    public abstract void c();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd d();

    public abstract Map<String, Object> f();

    public abstract int hf();

    public abstract void kd();

    public PluginValueSet pl() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet tf = tf();
        this.xj = tf;
        return tf;
    }

    public abstract void u();

    public abstract int w();

    public abstract View xj();

    public abstract c xj(Activity activity);

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f, java.util.function.Function
    /* renamed from: xj */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        ADYaiT2.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return pl().sparseArray();
        }
        switch (intValue) {
            case 150101:
                xj(new com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 150102:
                xj(new com.bytedance.sdk.openadsdk.et.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 150103:
                xj(new com.bytedance.sdk.openadsdk.zg.w.xj.w(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 150104:
                u();
                return null;
            case 150105:
                kd();
                return null;
            case 150106:
                xj((Activity) ADYaiT2.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(1, AaHO0E.ARc23Z()))));
                return null;
            case 150107:
                Dialog dialog = (Dialog) ADYaiT2.objectValue(0, Dialog.class);
                Integer[] numArr = (Integer[]) ADYaiT2.arrayValue(1, Integer.class);
                if (numArr == null) {
                    numArr = new Integer[0];
                }
                xj(dialog, numArr);
                return null;
            case 150108:
                return xj((Activity) ADYaiT2.objectValue(0, Activity.class));
            case 150109:
                ADYaiT2.objectValue(0, Activity.class);
                return null;
            case 150110:
                xj(ADYaiT2.intValue(0, 0));
                return null;
            case 150111:
                xj(new com.bytedance.sdk.openadsdk.et.xj.hf.xj.w(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 150112:
                xj(ADYaiT2.booleanValue(0, false));
                return null;
            case 150113:
                return d();
            case 150114:
                xj((String) ADYaiT2.objectValue(0, String.class));
                return null;
            case 150115:
                xj((JSONObject) ADYaiT2.objectValue(0, JSONObject.class));
                return null;
            case 150116:
                c();
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void xj(int i);

    public abstract void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar);

    public abstract void xj(Dialog dialog, Integer[] numArr);

    public abstract void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.xj xjVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar);

    public abstract void xj(String str);

    public abstract void xj(JSONObject jSONObject);

    public abstract void xj(boolean z);

    public abstract u y();
}
