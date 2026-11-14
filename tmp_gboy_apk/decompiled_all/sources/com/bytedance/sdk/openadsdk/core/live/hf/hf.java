package com.bytedance.sdk.openadsdk.core.live.hf;

import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf implements Function<SparseArray<Object>, Object> {
    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null || ((Integer) sparseArray.get(-99999987)).intValue() != 1) {
            return null;
        }
        xj(sparseArray.get(0, Object.class));
        return null;
    }

    public abstract void xj(Object obj);
}
