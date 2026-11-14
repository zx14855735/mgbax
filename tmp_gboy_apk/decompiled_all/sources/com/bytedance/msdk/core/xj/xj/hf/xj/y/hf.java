package com.bytedance.msdk.core.xj.xj.hf.xj.y;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private Function<SparseArray<Object>, Object> xj;

    public hf(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    public String hf() {
        Object apply;
        if (this.xj == null) {
            return "adn no msg";
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40006, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    public int xj() {
        Object apply;
        if (this.xj == null) {
            return -998;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(40005, sparseArray, -99999987, -99999985, Integer.class);
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }
}
