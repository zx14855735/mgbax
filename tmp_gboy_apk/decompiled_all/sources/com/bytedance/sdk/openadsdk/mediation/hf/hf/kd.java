package com.bytedance.sdk.openadsdk.mediation.hf.hf;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private Function<SparseArray<Object>, Object> xj;

    public kd(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public xj hf() {
        Object apply;
        apply = this.xj.apply(A2egSU.AZOQYO(271045, SparseArray.class).hf());
        if (apply instanceof SparseArray) {
            return new xj((SparseArray) apply);
        }
        return null;
    }

    public List<String> w() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(271046, sparseArray, -99999987, -99999985, List.class);
        apply = this.xj.apply(sparseArray);
        return (List) apply;
    }

    public int xj() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271044);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }
}
