package com.bytedance.sdk.openadsdk.io.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.os.Bundle;
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
        A2egSU.B2KMhB(121102, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void kd() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(121105, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void u() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(121104, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void w() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(121103, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(121101, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void y() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(121108, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(boolean z, int i, String str, int i2, String str2) {
        SparseArray sparseArray = new SparseArray(7);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, str);
        sparseArray.put(3, Integer.valueOf(i2));
        sparseArray.put(4, str2);
        sparseArray.put(-99999987, 121106);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(boolean z, int i, Bundle bundle) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, bundle);
        sparseArray.put(-99999987, 121107);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
