package com.bytedance.sdk.openadsdk.jk.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.zg.w.hf.p;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private final Function<SparseArray<Object>, Object> xj;

    public u(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void hf(p pVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, pVar);
        A2egSU.B2KMhB(132103, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(int i, String str) {
        SparseArray sparseArray = new SparseArray(4);
        A2egSU.B3GDIM(i, sparseArray, 0, 1, str);
        A2egSU.B2KMhB(132101, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(p pVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, pVar);
        A2egSU.B2KMhB(132102, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(132104, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
