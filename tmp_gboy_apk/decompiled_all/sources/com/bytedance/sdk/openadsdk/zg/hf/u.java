package com.bytedance.sdk.openadsdk.zg.hf;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements Function<SparseArray<Object>, Object> {
    private EventListener xj;

    public u(EventListener eventListener) {
        this.xj = eventListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null || this.xj == null) {
            return null;
        }
        return this.xj.onEvent(((Integer) sparseArray.get(-99999987)).intValue(), com.bytedance.sdk.openadsdk.zg.hf.w.xj.xj((SparseArray<Object>) sparseArray.get(-99999979)));
    }
}
