package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class f implements Function<SparseArray<Object>, Object> {
    public abstract void hf(Double d);

    @Override // java.util.function.Function
    /* renamed from: xj */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            ADYaiT2.objectValue(-99999985, Class.class);
            if (intValue == -99999986) {
                return new SparseArray();
            }
            switch (intValue) {
                case 210101:
                    xj(Double.valueOf(ADYaiT2.doubleValue(0)));
                    break;
                case 210102:
                    xj(Double.valueOf(ADYaiT2.doubleValue(0)), (String) ADYaiT2.objectValue(1, String.class), (String) ADYaiT2.objectValue(2, String.class));
                    break;
                case 210103:
                    hf(Double.valueOf(ADYaiT2.doubleValue(0)));
                    break;
                case 210104:
                    xj(new com.bytedance.sdk.openadsdk.zg.w.xj.hf(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                    break;
            }
        }
        return null;
    }

    public abstract void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar);

    public abstract void xj(Double d);

    public abstract void xj(Double d, String str, String str2);
}
