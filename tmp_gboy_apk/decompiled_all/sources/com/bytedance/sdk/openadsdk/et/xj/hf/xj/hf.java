package com.bytedance.sdk.openadsdk.et.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private final Function<SparseArray<Object>, Object> xj;

    public hf(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void hf(View view, int i) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, view);
        A2egSU.B25kr6(i, sparseArray, 1, 151102, -99999987);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(View view, int i) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, view);
        A2egSU.B25kr6(i, sparseArray, 1, 151101, -99999987);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(View view, String str, int i) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(0, view);
        sparseArray.put(1, str);
        A2egSU.B25kr6(i, sparseArray, 2, 151103, -99999987);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(View view, float f, float f2) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(0, view);
        sparseArray.put(1, Float.valueOf(f));
        sparseArray.put(2, Float.valueOf(f2));
        A2egSU.B2KMhB(151104, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
