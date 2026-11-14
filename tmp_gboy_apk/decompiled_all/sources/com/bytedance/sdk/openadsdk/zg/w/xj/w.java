package com.bytedance.sdk.openadsdk.zg.w.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private final Function<SparseArray<Object>, Object> xj;

    public w(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void hf(long j, long j2, String str, String str2) {
        SparseArray sparseArray = new SparseArray(6);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Long.valueOf(j2));
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        sparseArray.put(-99999987, 221103);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void w(long j, long j2, String str, String str2) {
        SparseArray sparseArray = new SparseArray(6);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Long.valueOf(j2));
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        sparseArray.put(-99999987, 221104);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(221101, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(long j, long j2, String str, String str2) {
        SparseArray sparseArray = new SparseArray(6);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Long.valueOf(j2));
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        sparseArray.put(-99999987, 221102);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(long j, String str, String str2) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(-99999987, 221105);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(String str, String str2) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, str);
        sparseArray.put(1, str2);
        A2egSU.B2KMhB(221106, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
