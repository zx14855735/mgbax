package com.bytedance.sdk.openadsdk.api;

import P8ccfD.AaHO0E;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements Initializer {
    Function<SparseArray<Object>, Object> xj;

    public u(Function<SparseArray<Object>, Object> function) {
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
        apply = this.xj.apply(sparseArray);
        return new w(AaHO0E.AYUAbz(apply));
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        if (this.xj == null || valueSet == null || context == null) {
            return;
        }
        SparseArray<Object> sparseArray = valueSet.sparseArray();
        sparseArray.put(-99999987, -999001);
        sparseArray.put(-998000, context);
        this.xj.apply(sparseArray);
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -999002);
        Function<SparseArray<Object>, Object> function = this.xj;
        if (function == null) {
            return false;
        }
        apply = function.apply(sparseArray);
        if (apply instanceof Boolean) {
            return ((Boolean) apply).booleanValue();
        }
        return false;
    }
}
