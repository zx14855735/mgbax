package com.bytedance.sdk.openadsdk.et.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends hf {
    private final Function<SparseArray<Object>, Object> xj;

    public xj(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void xj() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(151105, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
