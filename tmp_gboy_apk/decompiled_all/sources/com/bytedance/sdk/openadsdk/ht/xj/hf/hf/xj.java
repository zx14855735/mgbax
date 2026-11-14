package com.bytedance.sdk.openadsdk.ht.xj.hf.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements Function<SparseArray<Object>, Object> {
    private PluginValueSet xj;

    private PluginValueSet y() {
        return AYUAbz.A4TApA().A2egSU();
    }

    public abstract void hf();

    public abstract void hf(long j);

    public PluginValueSet kd() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet y = y();
        this.xj = y;
        return y;
    }

    public abstract void u();

    public abstract void w();

    public abstract void w(long j);

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            ADYaiT2.objectValue(-99999985, Class.class);
            if (intValue == -99999986) {
                return kd().sparseArray();
            }
            switch (intValue) {
                case 162102:
                    hf();
                    break;
                case 162103:
                    xj(ADYaiT2.longValue(0, 0L));
                    break;
                case 162104:
                    hf(ADYaiT2.longValue(0, 0L));
                    break;
                case 162105:
                    w();
                    break;
                case 162106:
                    w(ADYaiT2.longValue(0, 0L));
                    break;
                case 162107:
                    u();
                    break;
                case 162108:
                    xj(ADYaiT2.intValue(0, 0), ADYaiT2.intValue(1, 0));
                    break;
                case 162109:
                    xj(ADYaiT2.longValue(0, 0L), ADYaiT2.intValue(1, 0), ADYaiT2.intValue(2, 0));
                    break;
            }
        }
        return null;
    }

    public abstract String xj();

    public abstract void xj(int i, int i2);

    public abstract void xj(long j);

    public abstract void xj(long j, int i, int i2);
}
