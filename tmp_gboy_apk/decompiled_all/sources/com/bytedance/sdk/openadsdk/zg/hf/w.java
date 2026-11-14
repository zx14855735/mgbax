package com.bytedance.sdk.openadsdk.zg.hf;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements Function<SparseArray<Object>, Object> {
    private final Bridge xj;

    public w(Bridge bridge) {
        this.xj = bridge;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Object apply;
        Object call;
        if (sparseArray == null || this.xj == null) {
            apply = ARc23Z.f4112ADYaiT.apply(sparseArray);
            return apply;
        }
        int intValue = ((Integer) sparseArray.get(-99999987)).intValue();
        Class cls = (Class) sparseArray.get(-99999985);
        if (intValue == -99999977) {
            Bridge bridge = this.xj;
            return (!(bridge instanceof hf) || (call = bridge.call(-99999977, ARc23Z.f4110A4TApA, Object.class)) == null) ? this.xj : call;
        }
        if (intValue != -99999986) {
            return com.bytedance.sdk.openadsdk.zg.hf.w.xj.xj(this.xj.call(intValue, com.bytedance.sdk.openadsdk.zg.hf.w.xj.hf(sparseArray), cls));
        }
        ValueSet values = this.xj.values();
        if (values == null) {
            return null;
        }
        return new xj(values);
    }
}
