package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class tf extends g {
    private SparseArray<Object> xj;

    private SparseArray<Object> io() {
        com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj(super.u_());
        xj.xj(160001, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Double>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.tf.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(tf.this.xj());
            }
        }));
        xj.xj(160002, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.tf.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj get() {
                return tf.this.hf();
            }
        }));
        xj.xj(160003, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.tf.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(tf.this.w());
            }
        }));
        xj.xj(160004, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.tf.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(tf.this.u());
            }
        }));
        return xj.hf();
    }

    public abstract com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj hf();

    public abstract int u();

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public SparseArray<Object> u_() {
        SparseArray<Object> sparseArray = this.xj;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> io2 = io();
        this.xj = io2;
        return io2;
    }

    public abstract int w();

    public abstract double xj();

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g, com.bytedance.sdk.openadsdk.zg.w.hf.f, java.util.function.Function
    /* renamed from: xj */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        ADYaiT2.objectValue(-99999985, Class.class);
        switch (intValue) {
            case -99999986:
                return u_();
            case 140111:
                Function AYUAbz2 = AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()));
                xj(ADYaiT2.intValue(1, 0) == 1 ? new com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.kd(AYUAbz2) : new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w(AYUAbz2));
                return null;
            case 160101:
                xj(new com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            case 160102:
                xj(new com.bytedance.sdk.openadsdk.ht.xj.hf.xj.hf(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void xj(com.bytedance.sdk.openadsdk.ht.xj.hf.xj.hf hfVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj xjVar);
}
