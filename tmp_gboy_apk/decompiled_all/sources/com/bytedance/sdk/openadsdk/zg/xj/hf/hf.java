package com.bytedance.sdk.openadsdk.zg.xj.hf;

import IzHBwY.ADYaiT;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements Function<SparseArray<Object>, Object> {
    private final TTAdInteractionListener xj;

    public hf(TTAdInteractionListener tTAdInteractionListener) {
        this.xj = tTAdInteractionListener;
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xj != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            if (AMqCpz.intValue(-99999987, 0) == 100101) {
                this.xj.onAdEvent(AMqCpz.intValue(0, 0), (Map) AMqCpz.objectValue(1, Map.class));
                return null;
            }
        }
        return null;
    }
}
