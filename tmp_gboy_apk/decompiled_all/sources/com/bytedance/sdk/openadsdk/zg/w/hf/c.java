package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class c implements Function<SparseArray<Object>, Object> {
    public abstract void hf();

    public abstract boolean w();

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            ADYaiT2.objectValue(-99999985, Class.class);
            if (intValue == -99999986) {
                return new SparseArray();
            }
            switch (intValue) {
                case 240101:
                    xj();
                    return null;
                case 240102:
                    xj(new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                    return null;
                case 240103:
                    xj((String) ADYaiT2.objectValue(0, String.class));
                    return null;
                case 240104:
                    hf();
                    return null;
                case 240105:
                    return Boolean.class.cast(Boolean.valueOf(w()));
            }
        }
        return null;
    }

    public abstract void xj();

    public abstract void xj(com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar);

    public abstract void xj(String str);
}
