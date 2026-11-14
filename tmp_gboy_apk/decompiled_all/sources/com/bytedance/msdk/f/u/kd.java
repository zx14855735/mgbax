package com.bytedance.msdk.f.u;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.PrintStream;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    public static void xj(com.bytedance.sdk.gromore.xj.hf.xj xjVar) {
        Object apply;
        Object apply2;
        if (xjVar == null) {
            return;
        }
        Function<SparseArray<Object>, Object> et = xjVar.et();
        if (et != null) {
            apply2 = et.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(10001).xj(Boolean.class).hf());
            if (apply2 instanceof Boolean) {
                xj.xj(((Boolean) apply2).booleanValue());
            }
        }
        if (xjVar.x() != null) {
            apply = et.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB).xj(Map.class).hf());
            if (apply instanceof Map) {
                PrintStream printStream = System.out;
                apply.toString();
                printStream.getClass();
                w.xj((Map) apply);
            }
        }
        hf.xj(xjVar.io());
        u.xj(xjVar.ai());
    }
}
