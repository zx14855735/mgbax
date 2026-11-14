package com.bytedance.sdk.openadsdk.zg;

import android.util.SparseArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf<E> extends SparseArray<E> {
    private final SparseArray<Object> xj;

    public hf(SparseArray<Object> sparseArray) {
        this.xj = sparseArray;
    }

    @Override // android.util.SparseArray
    public boolean contains(int i) {
        if (super.contains(i)) {
            return true;
        }
        SparseArray<Object> sparseArray = this.xj;
        return sparseArray != null && sparseArray.indexOfKey(i) >= 0;
    }

    @Override // android.util.SparseArray
    public E get(int i, E e) {
        Object obj;
        E e2 = (E) super.get(i, null);
        if (e2 != null) {
            return e2;
        }
        SparseArray<Object> sparseArray = this.xj;
        if (sparseArray != null && (obj = sparseArray.get(i, null)) != null) {
            e2 = (E) obj;
        }
        return e2 != null ? e2 : e;
    }

    public SparseArray<Object> xj() {
        return this.xj;
    }
}
