package com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class w implements Function<SparseArray<Object>, Object> {
    private PluginValueSet xj;

    private PluginValueSet w() {
        return AYUAbz.A4TApA().A2egSU();
    }

    public PluginValueSet hf() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet w = w();
        this.xj = w;
        return w;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            ADYaiT2.objectValue(-99999985, Class.class);
            switch (intValue) {
                case -99999986:
                    break;
                case 270032:
                    xj();
                    break;
                case 270033:
                    xj(new com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                    break;
            }
        }
        return null;
    }

    public abstract void xj();

    public abstract void xj(com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.xj xjVar);
}
