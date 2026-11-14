package com.bytedance.sdk.openadsdk.mediation.xj;

import ADYaiT.BpkvW3;
import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;
import java.util.function.IntSupplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements Function<SparseArray<Object>, Object>, IntSupplier {
    public static <T> T objectValue(Object obj, Class<T> cls, T t) {
        Object obj2;
        if (obj instanceof ValueSet.ValueGetter) {
            obj = (T) ((ValueSet.ValueGetter) obj).get();
        } else if (BpkvW3.BNL6CD(obj) && !BpkvW3.BmvVmW(obj) && !(obj instanceof ValueSet)) {
            obj2 = BpkvW3.B2KMhB(obj).get();
            obj = (T) obj2;
        }
        return cls.isInstance(obj) ? (T) obj : t;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
        int intValue = AMqCpz.intValue(-99999987, 0);
        return intValue == -99999986 ? get() : applyFunction(intValue, AMqCpz, (Class) AMqCpz.objectValue(-99999985, Class.class));
    }

    public abstract <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls);

    public abstract SparseArray<Object> get();

    @Override // java.util.function.IntSupplier
    public int getAsInt() {
        return 7000;
    }
}
