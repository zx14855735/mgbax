package com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf implements Function<SparseArray<Object>, Object> {
    private PluginValueSet xj;

    private PluginValueSet qt() {
        return AYUAbz.A4TApA().A2egSU();
    }

    public abstract Map<String, Integer> am();

    public abstract int c();

    public abstract int d();

    public abstract int f();

    public abstract int g();

    public abstract int hf();

    public abstract int kd();

    public abstract int p();

    public abstract int pl();

    public abstract int tf();

    public abstract int u();

    public abstract int w();

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
        if (intValue == -99999986) {
            PluginValueSet pluginValueSet = this.xj;
            if (pluginValueSet != null) {
                return pluginValueSet.sparseArray();
            }
            PluginValueSet qt = qt();
            this.xj = qt;
            return qt.sparseArray();
        }
        switch (intValue) {
            case 271021:
                return Integer.class.cast(Integer.valueOf(xj()));
            case 271022:
                return Integer.class.cast(Integer.valueOf(hf()));
            case 271023:
                return Integer.class.cast(Integer.valueOf(w()));
            case 271024:
                return Integer.class.cast(Integer.valueOf(u()));
            case 271025:
                return Integer.class.cast(Integer.valueOf(kd()));
            case 271026:
                return Integer.class.cast(Integer.valueOf(y()));
            case 271027:
                return Integer.class.cast(Integer.valueOf(c()));
            case 271028:
                return Integer.class.cast(Integer.valueOf(f()));
            case 271029:
                return Integer.class.cast(Integer.valueOf(d()));
            case 271030:
                return Integer.class.cast(Integer.valueOf(tf()));
            case 271031:
                return Integer.class.cast(Integer.valueOf(p()));
            case 271032:
                return Integer.class.cast(Integer.valueOf(pl()));
            case 271033:
                return Integer.class.cast(Integer.valueOf(g()));
            case 271034:
                return am();
            default:
                return null;
        }
    }

    public abstract int y();
}
