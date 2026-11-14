package com.bytedance.sdk.openadsdk.u.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private final Function<SparseArray<Object>, Object> xj;

    public xj(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void hf(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, hfVar);
        A2egSU.B2KMhB(111102, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, hfVar);
        A2egSU.B2KMhB(111101, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar, int i) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, hfVar);
        A2egSU.B25kr6(i, sparseArray, 1, 111103, -99999987);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
