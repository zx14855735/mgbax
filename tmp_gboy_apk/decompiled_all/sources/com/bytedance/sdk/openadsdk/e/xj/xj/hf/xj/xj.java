package com.bytedance.sdk.openadsdk.e.xj.xj.hf.xj;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements Function<SparseArray<Object>, Object> {
    private PluginValueSet xj;

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            ADYaiT2.objectValue(-99999985, Class.class);
            if (intValue == -99999986) {
                PluginValueSet pluginValueSet = this.xj;
                if (pluginValueSet != null) {
                    return pluginValueSet.sparseArray();
                }
                PluginValueSet xj = xj();
                this.xj = xj;
                return xj.sparseArray();
            }
            if (intValue == 123101) {
                xj((Bundle) ADYaiT2.objectValue(0, Bundle.class));
                return null;
            }
        }
        return null;
    }

    public abstract void xj(Bundle bundle);

    private PluginValueSet xj() {
        return AYUAbz.A4TApA().A2egSU();
    }
}
