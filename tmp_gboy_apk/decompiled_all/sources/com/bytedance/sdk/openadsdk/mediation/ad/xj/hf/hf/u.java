package com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class u implements Function<SparseArray<Object>, Object> {
    private PluginValueSet xj;

    public abstract String c();

    public abstract String d();

    public abstract String f();

    public abstract String hf();

    public abstract Map<String, String> kd();

    public PluginValueSet p() {
        return AYUAbz.A4TApA().A2egSU();
    }

    public abstract Map<String, Object> tf();

    public abstract String u();

    public abstract long w();

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        ADYaiT2.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            PluginValueSet pluginValueSet = this.xj;
            if (pluginValueSet != null) {
                return pluginValueSet.sparseArray();
            }
            PluginValueSet p = p();
            this.xj = p;
            return p.sparseArray();
        }
        if (intValue == 271047) {
            return f();
        }
        if (intValue == 271051) {
            return d();
        }
        switch (intValue) {
            case 271035:
                return xj();
            case 271036:
                return hf();
            case 271037:
                return Long.class.cast(Long.valueOf(w()));
            case 271038:
                return u();
            case 271039:
                return kd();
            case 271040:
                return y();
            case 271041:
                return c();
            case 271042:
                return tf();
            default:
                return null;
        }
    }

    public abstract String xj();

    public abstract String y();
}
