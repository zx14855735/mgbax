package com.bytedance.sdk.openadsdk.zg;

import IySJvm.A2egSU;
import android.util.SparseArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private final SparseArray<Object> xj;

    private u() {
        this.xj = new SparseArray<>();
    }

    public static u xj() {
        return new u();
    }

    public SparseArray<Object> hf() {
        return this.xj;
    }

    public static u xj(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        return new u(sparseArray);
    }

    public u(SparseArray<Object> sparseArray) {
        this.xj = A2egSU.A2egSU().f4098A2egSU < 6803 ? new hf(sparseArray) : sparseArray;
    }

    public u xj(int i) {
        this.xj.put(-99999987, Integer.valueOf(i));
        return this;
    }

    public u xj(Class<?> cls) {
        this.xj.put(-99999985, cls);
        return this;
    }

    public u xj(int i, Object obj) {
        this.xj.put(i, obj);
        return this;
    }
}
