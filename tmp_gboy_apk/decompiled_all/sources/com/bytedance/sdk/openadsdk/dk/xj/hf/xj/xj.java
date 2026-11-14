package com.bytedance.sdk.openadsdk.dk.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.zg.w.hf.g;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private final Function<SparseArray<Object>, Object> xj;

    public xj(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void hf(View view, g gVar) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, view);
        sparseArray.put(1, gVar);
        A2egSU.B2KMhB(141102, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(View view, g gVar) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, view);
        sparseArray.put(1, gVar);
        A2egSU.B2KMhB(141101, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(g gVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, gVar);
        A2egSU.B2KMhB(141103, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
