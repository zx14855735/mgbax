package com.bytedance.msdk.f.u;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static Function<SparseArray<Object>, Object> xj;

    private static void hf(com.bytedance.msdk.kd.xj xjVar, boolean z) {
        if (xj != null) {
            com.bytedance.sdk.openadsdk.zg.u xj2 = com.bytedance.sdk.openadsdk.zg.u.xj();
            if (z) {
                xj2.xj(AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS).xj(Void.class);
                xj2.xj(20003, xjVar.w());
                xj.apply(xj2.hf());
            } else {
                xj2.xj(AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS).xj(Void.class);
                xj2.xj(20002, xjVar.w());
                xj.apply(xj2.hf());
            }
        }
    }

    public static void xj(Function<SparseArray<Object>, Object> function) {
        xj = function;
    }

    public static void xj(com.bytedance.msdk.kd.xj xjVar, boolean z) {
        if (xjVar != null && com.bytedance.msdk.core.xj.p().jk()) {
            hf(xjVar, z);
        }
    }
}
