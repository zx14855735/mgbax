package com.bytedance.sdk.openadsdk.dk.xj.hf.xj;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private final Function<SparseArray<Object>, Object> xj;

    public hf(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? AYUAbz.f4118ADYaiT : function;
    }

    public void hf(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(144103, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.xj.apply(sparseArray);
    }

    public void w(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(144104, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.xj.apply(sparseArray);
    }

    public void xj(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(144101, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.xj.apply(sparseArray);
    }

    public void hf() {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(144105, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public JSONObject xj() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(144101, sparseArray, -99999987, -99999985, JSONObject.class);
        apply = this.xj.apply(sparseArray);
        return (JSONObject) apply;
    }
}
