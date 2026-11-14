package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class w implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> xj;

    private SparseArray<Object> p() {
        com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj();
        xj.xj(250001, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.w.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return w.this.xj();
            }
        }));
        xj.xj(250002, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.w.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return w.this.hf();
            }
        }));
        xj.xj(250003, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.w.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return w.this.w();
            }
        }));
        xj.xj(250004, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.w.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return w.this.u();
            }
        }));
        xj.xj(250006, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<Map<String, String>>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.w.5
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return w.this.kd();
            }
        }));
        xj.xj(250005, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.w.6
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return w.this.y();
            }
        }));
        xj.xj(250007, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.w.7
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return w.this.c();
            }
        }));
        xj.xj(250008, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.w.8
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return w.this.d();
            }
        }));
        xj.xj(250009, com.bytedance.sdk.openadsdk.zg.w.u.xj((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.w.hf.w.9
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return w.this.f();
            }
        }));
        return xj.hf();
    }

    public abstract String c();

    public abstract String d();

    public abstract String f();

    public abstract String hf();

    public abstract Map<String, String> kd();

    public SparseArray<Object> tf() {
        SparseArray<Object> sparseArray = this.xj;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> p = p();
        this.xj = p;
        return p;
    }

    public abstract String u();

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
        return tf();
    }

    public abstract String xj();

    public abstract String y();
}
