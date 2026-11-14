package com.bytedance.sdk.openadsdk.zg.w;

import ADYaiT.BpkvW3;
import IySJvm.A2egSU;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    public static boolean hf(int i) {
        return i >= 7000;
    }

    public static boolean xj(int i) {
        return i >= 6803 && i < 7000;
    }

    public static <T> Object xj(final Supplier<T> supplier) {
        return xj(A2egSU.A2egSU().f4098A2egSU) ? new ValueSet.ValueGetter<Object>() { // from class: com.bytedance.sdk.openadsdk.zg.w.u.1
            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            public T get() {
                ?? r0;
                r0 = supplier.get();
                return r0;
            }
        } : supplier;
    }

    public static Object xj(SparseArray<Object> sparseArray) {
        return xj(A2egSU.A2egSU().f4098A2egSU) ? com.bykv.vk.component.ttvideo.player.A2egSU.AMqCpz(sparseArray) : sparseArray;
    }

    public static PluginValueSet xj(int i, PluginValueSet pluginValueSet) {
        if (xj(A2egSU.A2egSU().f4098A2egSU)) {
            return J3FDQU.A2egSU.ADYaiT(((ValueSet) pluginValueSet.objectValue(i, ValueSet.class)).sparseArray());
        }
        return J3FDQU.A2egSU.ADYaiT((SparseArray) pluginValueSet.objectValue(i, SparseArray.class));
    }

    public static Object xj(Object obj) {
        return (A2egSU.A2egSU().f4098A2egSU < 6803 || A2egSU.A2egSU().f4098A2egSU >= 6900 || !BpkvW3.BmvVmW(obj)) ? obj : new com.bytedance.sdk.openadsdk.zg.hf.xj.xj(AaHO0E.AYUAbz(obj));
    }
}
