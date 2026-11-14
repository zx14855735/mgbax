package com.bytedance.sdk.openadsdk.ht.xj.hf.xj;

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

    public void xj(int i) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B25kr6(i, sparseArray, 0, 163101, -99999987);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
