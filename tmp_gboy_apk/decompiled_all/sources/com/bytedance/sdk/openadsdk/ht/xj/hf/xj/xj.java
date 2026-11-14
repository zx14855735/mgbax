package com.bytedance.sdk.openadsdk.ht.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.zg.w.hf.tf;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private final Function<SparseArray<Object>, Object> xj;

    public xj(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void hf(tf tfVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, tfVar);
        A2egSU.B2KMhB(161104, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void kd(tf tfVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, tfVar);
        A2egSU.B2KMhB(161107, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void u(tf tfVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, tfVar);
        A2egSU.B2KMhB(161105, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void w(tf tfVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, tfVar);
        A2egSU.B2KMhB(161103, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(tf tfVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, tfVar);
        A2egSU.B2KMhB(161101, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(int i, int i2) {
        SparseArray sparseArray = new SparseArray(4);
        A2egSU.B25kr6(i, sparseArray, 0, i2, 1);
        A2egSU.B2KMhB(161102, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(long j, long j2) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Long.valueOf(j2));
        sparseArray.put(-99999987, 161106);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
