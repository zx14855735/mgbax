package com.bytedance.sdk.openadsdk.zg.hf;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Bridge {
    private final Function<SparseArray<Object>, Object> xj;

    public hf(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Object apply;
        Object apply2;
        Object apply3;
        if (i == -99999977) {
            if (this.xj instanceof w) {
                apply3 = this.xj.apply(A2egSU.ARc23Z(-99999977, Bridge.class));
                T t = (T) apply3;
                if (t instanceof Bridge) {
                    return t;
                }
            }
            return (T) this.xj;
        }
        if (this.xj == null) {
            return null;
        }
        xj xjVar = new xj(valueSet);
        xjVar.put(-99999987, Integer.valueOf(i));
        xjVar.put(-99999985, cls);
        apply = this.xj.apply(xjVar);
        T t2 = (T) com.bytedance.sdk.openadsdk.zg.hf.w.xj.hf(apply);
        if (t2 != null) {
            return t2;
        }
        apply2 = ARc23Z.f4112ADYaiT.apply(xjVar);
        return (T) apply2;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        Function<SparseArray<Object>, Object> function = this.xj;
        if (function != null) {
            return com.bytedance.sdk.openadsdk.zg.hf.w.xj.hf(com.bytedance.sdk.openadsdk.zg.hf.w.xj.xj(function));
        }
        return null;
    }
}
