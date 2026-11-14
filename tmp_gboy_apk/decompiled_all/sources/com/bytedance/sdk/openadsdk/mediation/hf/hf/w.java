package com.bytedance.sdk.openadsdk.mediation.hf.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class w implements Function<SparseArray<Object>, Object> {
    private PluginValueSet xj;

    private PluginValueSet u() {
        return AYUAbz.A4TApA().A2egSU();
    }

    public abstract void hf();

    public PluginValueSet w() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet u = u();
        this.xj = u;
        return u;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            ADYaiT2.objectValue(-99999985, Class.class);
            if (intValue == -99999986) {
                return w().sparseArray();
            }
            switch (intValue) {
                case 268013:
                    xj(ADYaiT2.intValue(0, 0), (String) ADYaiT2.objectValue(1, String.class));
                    break;
                case 268014:
                    xj();
                    break;
                case 268015:
                    hf();
                    break;
            }
        }
        return null;
    }

    public abstract void xj();

    public abstract void xj(int i, String str);
}
