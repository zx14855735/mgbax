package com.bytedance.sdk.openadsdk.core.x;

import android.util.SparseArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d {
    private com.bytedance.sdk.openadsdk.zg.xj hf;
    private SparseArray<Object> w;
    private int xj;

    public d(SparseArray<Object> sparseArray, int i) {
        this.xj = i;
        this.w = sparseArray != null ? sparseArray : new SparseArray<>();
        this.hf = new com.bytedance.sdk.openadsdk.zg.xj(sparseArray);
    }

    public int getType() {
        return this.xj;
    }

    public void setResult(SparseArray<Object> sparseArray) {
        this.hf = new com.bytedance.sdk.openadsdk.zg.xj(sparseArray);
    }

    public SparseArray<Object> u() {
        return this.w;
    }

    public com.bytedance.sdk.openadsdk.zg.xj w() {
        return this.hf;
    }
}
