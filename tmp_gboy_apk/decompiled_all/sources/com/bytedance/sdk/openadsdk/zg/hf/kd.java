package com.bytedance.sdk.openadsdk.zg.hf;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements EventListener {
    private Function<SparseArray<Object>, Object> xj;

    public kd(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        Object apply;
        if (this.xj != null) {
            apply = this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(i).xj(-99999979, result != null ? com.bytedance.sdk.openadsdk.zg.kd.xj().xj(result.code()).xj(result.isSuccess()).xj(result.message()).xj(new xj(result.values())).hf() : null).xj(SparseArray.class).hf());
            if (apply instanceof SparseArray) {
                return com.bytedance.sdk.openadsdk.zg.hf.w.xj.hf((SparseArray<Object>) apply);
            }
        }
        return null;
    }
}
