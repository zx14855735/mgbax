package com.bytedance.sdk.openadsdk.zg.hf.hf;

import ADYaiT.BpkvW3;
import P8ccfD.AaHO0E;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Initializer {
    private final Function<SparseArray<Object>, Object> xj;

    public hf(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -999000);
        sparseArray.put(-99999985, AaHO0E.ARc23Z());
        apply = this.xj.apply(sparseArray);
        if (BpkvW3.BmvVmW(apply)) {
            return new u(AaHO0E.AYUAbz(apply));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        com.bytedance.sdk.openadsdk.zg.hf.xj xjVar = new com.bytedance.sdk.openadsdk.zg.hf.xj(valueSet);
        xjVar.put(-99999987, -999001);
        xjVar.put(-99999985, Void.class);
        xjVar.put(-998000, context);
        Function<SparseArray<Object>, Object> function = this.xj;
        if (function != null) {
            function.apply(xjVar);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        Object apply;
        if (this.xj == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -999002);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return apply != null && ((Boolean) apply).booleanValue();
    }
}
