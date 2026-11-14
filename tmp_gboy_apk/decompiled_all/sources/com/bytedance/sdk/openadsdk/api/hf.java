package com.bytedance.sdk.openadsdk.api;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Loader {
    private final Function<SparseArray<Object>, Void> xj;

    public hf(Function<SparseArray<Object>, Void> function) {
        this.xj = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i, ValueSet valueSet, EventListener eventListener) {
        if (this.xj != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (valueSet != null) {
                sparseArray = valueSet.sparseArray();
            }
            A2egSU.B2KMhB(i, sparseArray, -99999982, -99999985, Void.class);
            this.xj.apply(sparseArray);
        }
    }
}
