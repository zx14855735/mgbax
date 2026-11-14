package com.bytedance.sdk.openadsdk.core.wo;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class u implements Function<SparseArray<Object>, Object> {
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        return applyFunction(ADYaiT2.intValue(-99999987, 0), ADYaiT2, (Class) ADYaiT2.objectValue(-99999985, Class.class));
    }

    public abstract <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls);
}
