package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class u implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> xj;

    private SparseArray<Object> w() {
        com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj();
        xj.xj(243001, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<List<y>>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.u.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public List<y> get() {
                return u.this.xj();
            }
        }));
        return xj.hf();
    }

    public SparseArray<Object> hf() {
        SparseArray<Object> sparseArray = this.xj;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> w = w();
        this.xj = w;
        return w;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        ADYaiT2.objectValue(-99999985, Class.class);
        if (intValue != -99999986) {
            return null;
        }
        return hf();
    }

    public abstract List<y> xj();
}
