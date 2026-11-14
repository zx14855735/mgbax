package com.bytedance.sdk.openadsdk.mediation.hf.hf.xj;

import IzHBwY.AYUAbz;
import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj {
    private final Function<SparseArray<Object>, Object> xj;

    public hf(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void c() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(131108, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void f() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(131109, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(int i, String str) {
        SparseArray sparseArray = new SparseArray(4);
        A2egSU.B3GDIM(i, sparseArray, 0, 1, str);
        A2egSU.B2KMhB(131106, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void y() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(131107, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(Bundle bundle) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, bundle);
        A2egSU.B2KMhB(131110, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
