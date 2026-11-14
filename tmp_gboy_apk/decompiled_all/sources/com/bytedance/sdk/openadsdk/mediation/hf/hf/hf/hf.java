package com.bytedance.sdk.openadsdk.mediation.hf.hf.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf implements Function<SparseArray<Object>, Object> {
    private PluginValueSet xj;

    private PluginValueSet hf() {
        return AYUAbz.A4TApA().A2egSU();
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            ADYaiT2.objectValue(-99999985, Class.class);
            if (intValue == -99999986) {
                return xj().sparseArray();
            }
            if (intValue == 270028) {
                xj((String) ADYaiT2.objectValue(0, String.class), new w(AaHO0E.AYUAbz(ADYaiT2.objectValue(1, AaHO0E.ARc23Z()))));
                return null;
            }
        }
        return null;
    }

    public abstract void xj(String str, w wVar);

    public PluginValueSet xj() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet hf = hf();
        this.xj = hf;
        return hf;
    }
}
