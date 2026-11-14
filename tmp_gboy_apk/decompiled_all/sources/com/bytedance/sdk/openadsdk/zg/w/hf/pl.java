package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class pl implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> xj;

    private SparseArray<Object> c() {
        com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj();
        xj.xj(230002, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.pl.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(pl.this.xj());
            }
        }));
        xj.xj(230001, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.pl.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(pl.this.hf());
            }
        }));
        xj.xj(230003, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.pl.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pl.this.w();
            }
        }));
        xj.xj(230004, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Double>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.pl.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(pl.this.u());
            }
        }));
        xj.xj(230005, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.pl.5
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(pl.this.kd());
            }
        }));
        return xj.hf();
    }

    public abstract int hf();

    public abstract boolean kd();

    public abstract double u();

    public abstract String w();

    public abstract int xj();

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null && new AYUAbz(sparseArray).A2egSU().intValue(-99999987, 0) == -99999986) {
            return y();
        }
        return null;
    }

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
