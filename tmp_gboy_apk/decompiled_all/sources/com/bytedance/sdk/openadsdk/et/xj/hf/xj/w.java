package com.bytedance.sdk.openadsdk.et.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private final Function<SparseArray<Object>, Object> xj;

    public w(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void hf() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(152103, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void kd() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(152107, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void u() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(152105, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void w() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(152104, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(152101, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(int i, int i2) {
        SparseArray sparseArray = new SparseArray(4);
        A2egSU.B25kr6(i, sparseArray, 0, i2, 1);
        A2egSU.B2KMhB(152102, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(long j, long j2) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Long.valueOf(j2));
        sparseArray.put(-99999987, 152106);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
