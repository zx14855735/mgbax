package com.bytedance.sdk.openadsdk.zg.hf.xj;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements EventListener {
    private final Function<SparseArray<Object>, Object> xj;

    public xj(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, Integer.valueOf(i));
        if (result != null) {
            sparseArray.put(-999900, Integer.valueOf(result.code()));
            sparseArray.put(-999903, Boolean.valueOf(result.isSuccess()));
            sparseArray.put(-999901, result.message());
            sparseArray.put(-999902, result.values() != null ? result.values().sparseArray() : new SparseArray<>());
        }
        apply = this.xj.apply(sparseArray);
        if (apply instanceof SparseArray) {
            return A2egSU.AMqCpz((SparseArray) apply);
        }
        return null;
    }
}
