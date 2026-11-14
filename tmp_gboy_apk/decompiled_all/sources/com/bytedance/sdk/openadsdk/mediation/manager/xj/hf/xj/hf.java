package com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> xj;

    private SparseArray<Object> c() {
        com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj();
        xj.xj(271001, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.hf.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hf.this.xj();
            }
        }));
        xj.xj(271002, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.hf.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hf.this.hf();
            }
        }));
        xj.xj(271003, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.hf.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hf.this.w();
            }
        }));
        xj.xj(271004, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.hf.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(hf.this.u());
            }
        }));
        xj.xj(271005, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.hf.5
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return hf.this.kd();
            }
        }));
        return xj.hf();
    }

    public abstract String hf();

    public abstract String kd();

    public abstract int u();

    public abstract String w();

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
        return y();
    }

    public abstract String xj();

    public SparseArray<Object> y() {
        SparseArray<Object> sparseArray = this.xj;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> c = c();
        this.xj = c;
        return c;
    }
}
