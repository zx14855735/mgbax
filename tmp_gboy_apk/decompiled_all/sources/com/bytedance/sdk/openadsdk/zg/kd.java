package com.bytedance.sdk.openadsdk.zg;

import android.util.SparseArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private final SparseArray<Object> xj = new SparseArray<>();

    private kd() {
    }

    public static kd xj() {
        return new kd();
    }

    public SparseArray<Object> hf() {
        return this.xj;
    }

    public kd xj(int i) {
        this.xj.put(-999900, Integer.valueOf(i));
        return this;
    }

    public kd xj(String str) {
        this.xj.put(-999901, str);
        return this;
    }

    public kd xj(boolean z) {
        this.xj.put(-999903, Boolean.valueOf(z));
        return this;
    }

    public kd xj(SparseArray<Object> sparseArray) {
        this.xj.put(-999902, sparseArray);
        return this;
    }
}
