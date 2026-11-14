package com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj;

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

    public void hf() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(268015, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(int i, String str) {
        SparseArray sparseArray = new SparseArray(4);
        A2egSU.B3GDIM(i, sparseArray, 0, 1, str);
        A2egSU.B2KMhB(268013, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(268014, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
