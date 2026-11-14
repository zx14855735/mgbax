package com.bytedance.sdk.openadsdk.zg;

import ADYaiT.BpkvW3;
import IySJvm.A2egSU;
import IzHBwY.AYUAbz;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    public static PluginValueSet hf(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return AYUAbz.A4TApA().A2egSU();
        }
        Object apply = (BpkvW3.BNL6CD(function) && xj(A2egSU.A2egSU().f4098A2egSU)) ? BpkvW3.B2KMhB(function).get() : function.apply(u.xj().xj(-99999986).xj(SparseArray.class).hf());
        return apply instanceof SparseArray ? J3FDQU.A2egSU.ADYaiT((SparseArray) apply) : AYUAbz.A4TApA().A2egSU();
    }

    public static boolean xj(int i) {
        return i >= 6803 && i < 7000;
    }

    public static SparseArray<Object> xj(Function<SparseArray<Object>, Object> function) {
        Object apply;
        if (function == null) {
            return new SparseArray<>();
        }
        apply = function.apply(u.xj().xj(-99999986).xj(SparseArray.class).hf());
        return apply instanceof SparseArray ? (SparseArray) apply : new SparseArray<>();
    }
}
