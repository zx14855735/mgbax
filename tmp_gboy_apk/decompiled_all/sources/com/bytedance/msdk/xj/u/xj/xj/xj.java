package com.bytedance.msdk.xj.u.xj.xj;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.zg.w;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.msdk.api.u.xj.c.xj {
    public xj(Function<SparseArray<Object>, Object> function) {
        PluginValueSet hf;
        if (function == null || (hf = w.hf(function)) == null) {
            return;
        }
        u(hf.stringValue(8505));
        kd(hf.stringValue(8506));
        xj(hf.longValue(8507));
        y(hf.stringValue(8508));
        xj((Map<String, String>) hf.objectValue(8509, Map.class));
        c(hf.stringValue(8510));
        f(hf.stringValue(8511));
        hf((Map<String, Object>) hf.objectValue(8512, Map.class));
        w(hf.stringValue(8551));
    }
}
