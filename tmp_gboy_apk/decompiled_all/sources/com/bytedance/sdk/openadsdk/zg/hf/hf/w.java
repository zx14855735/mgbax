package com.bytedance.sdk.openadsdk.zg.hf.hf;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements Loader {
    private Function<SparseArray<Object>, Object> xj;

    public w(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i, ValueSet valueSet, EventListener eventListener) {
        if (valueSet == null || this.xj == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.zg.hf.xj xjVar = new com.bytedance.sdk.openadsdk.zg.hf.xj(valueSet);
        xjVar.put(-99999987, Integer.valueOf(i));
        xjVar.put(-99999982, Integer.valueOf(i));
        this.xj.apply(xjVar);
    }
}
