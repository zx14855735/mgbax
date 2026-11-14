package com.bytedance.sdk.openadsdk.api;

import ADYaiT.BpkvW3;
import IzHBwY.ARc23Z;
import P8ccfD.AaHO0E;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements Manager {
    private final Function<SparseArray<Object>, Object> xj;

    public w(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? ARc23Z.f4112ADYaiT : function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-998000, context);
        sparseArray.put(-99999985, AaHO0E.ARc23Z());
        apply = this.xj.apply(sparseArray);
        return new hf(AaHO0E.AYUAbz(apply));
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public ValueSet values() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        apply = this.xj.apply(sparseArray);
        if (apply instanceof SparseArray) {
            return A2egSU.AMqCpz((SparseArray) apply);
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> xj(int i) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        if (i == 1) {
            i = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i));
        apply = this.xj.apply(sparseArray);
        if (BpkvW3.BmvVmW(apply)) {
            return AaHO0E.AYUAbz(apply);
        }
        return null;
    }
}
