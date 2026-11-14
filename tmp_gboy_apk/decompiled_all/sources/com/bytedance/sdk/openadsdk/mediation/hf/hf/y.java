package com.bytedance.sdk.openadsdk.mediation.hf.hf;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private final Function<SparseArray<Object>, Object> xj;

    public y(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void xj() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(270032, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(w wVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, wVar);
        A2egSU.B2KMhB(270033, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
