package com.bytedance.msdk.f.u;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private static Function<SparseArray<Object>, Object> xj;

    public static String hf() {
        Object apply;
        Function<SparseArray<Object>, Object> function = xj;
        if (function == null) {
            return null;
        }
        apply = function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2).xj(String.class).hf());
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    public static String w() {
        Object apply;
        Function<SparseArray<Object>, Object> function = xj;
        if (function == null) {
            return null;
        }
        apply = function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(AVMDLDataLoader.KeyIsStoMaxIdleTimeSec).xj(String.class).hf());
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    public static void xj(Function<SparseArray<Object>, Object> function) {
        xj = function;
    }

    public static String xj() {
        Object apply;
        Function<SparseArray<Object>, Object> function = xj;
        if (function == null) {
            return null;
        }
        apply = function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1).xj(String.class).hf());
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }
}
