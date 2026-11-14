package com.bytedance.sdk.openadsdk.dk.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private final Function<SparseArray<Object>, Object> xj;

    public w(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void xj(View view, float f, float f2, boolean z) {
        SparseArray sparseArray = new SparseArray(6);
        sparseArray.put(0, view);
        sparseArray.put(1, Float.valueOf(f));
        sparseArray.put(2, Float.valueOf(f2));
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(-99999987, 142101);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
