package com.bytedance.sdk.openadsdk.u.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private final Function<SparseArray<Object>, Object> xj;

    public hf(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void hf() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(112103, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, hfVar);
        A2egSU.B2KMhB(121201, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(112102, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
