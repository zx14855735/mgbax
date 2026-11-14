package com.bytedance.sdk.openadsdk.zg.hf.hf;

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
public class u implements Bridge, Manager {
    private final Function<SparseArray<Object>, Object> xj;

    public u(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Object apply;
        Object apply2;
        if (this.xj == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.zg.hf.xj xjVar = new com.bytedance.sdk.openadsdk.zg.hf.xj(valueSet);
        xjVar.put(-99999987, Integer.valueOf(i));
        xjVar.put(-99999985, cls);
        apply = this.xj.apply(xjVar);
        T t = (T) com.bytedance.sdk.openadsdk.zg.hf.w.xj.hf(apply);
        if (t != null) {
            return t;
        }
        apply2 = ARc23Z.f4112ADYaiT.apply(xjVar);
        return (T) apply2;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-99999985, AaHO0E.ARc23Z());
        sparseArray.put(-998000, context);
        apply = this.xj.apply(sparseArray);
        if (BpkvW3.BmvVmW(apply)) {
            return new w(AaHO0E.AYUAbz(apply));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i) {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        if (i == 1) {
            i = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(-99999985, AaHO0E.ARc23Z());
        apply = this.xj.apply(sparseArray);
        if (BpkvW3.BmvVmW(apply)) {
            return new com.bytedance.sdk.openadsdk.zg.hf.hf(AaHO0E.AYUAbz(apply));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(-99999986, sparseArray, -99999987, -99999985, SparseArray.class);
        apply = this.xj.apply(sparseArray);
        if (apply instanceof SparseArray) {
            return com.bytedance.sdk.openadsdk.zg.hf.w.xj.hf((SparseArray<Object>) apply);
        }
        return null;
    }
}
