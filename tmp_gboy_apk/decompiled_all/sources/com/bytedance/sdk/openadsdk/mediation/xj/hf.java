package com.bytedance.sdk.openadsdk.mediation.xj;

import ADYaiT.BpkvW3;
import IzHBwY.ARc23Z;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends xj {
    private final Bridge xj;

    public hf(Bridge bridge) {
        this.xj = bridge == null ? ARc23Z.f4111A5SV6n : bridge;
    }

    public static Function<SparseArray<Object>, Object> xj(Object obj) {
        if (BpkvW3.BmvVmW(obj)) {
            return AaHO0E.AYUAbz(obj);
        }
        if (obj instanceof Bridge) {
            return new hf((Bridge) obj);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xj.xj
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        return (T) this.xj.call(i, valueSet, cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xj.xj
    public SparseArray<Object> get() {
        if (this.xj.values() == null) {
            return null;
        }
        SparseArray<Object> sparseArray = this.xj.values().sparseArray();
        return sparseArray == null ? new SparseArray<>() : sparseArray;
    }
}
