package com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w {
    private final Function<SparseArray<Object>, Object> xj;

    public kd(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void hf() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(142104, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(View view, String str, int i) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(0, view);
        sparseArray.put(1, str);
        A2egSU.B25kr6(i, sparseArray, 2, 142102, -99999987);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(142103, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
