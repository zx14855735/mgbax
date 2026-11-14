package com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj;

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

    public View xj(com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj xjVar) {
        Object apply;
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, xjVar);
        A2egSU.B2KMhB(266013, sparseArray, -99999987, -99999985, View.class);
        apply = this.xj.apply(sparseArray);
        return (View) apply;
    }
}
