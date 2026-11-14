package com.bytedance.sdk.openadsdk.core.x;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.en;
import com.bytedance.sdk.openadsdk.core.pz;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class p {
    public static boolean hf() {
        JSONObject h = pz.hf().h();
        return h != null && h.optInt("pre_drop", 0) == 1;
    }

    public static boolean w() {
        return com.bytedance.sdk.openadsdk.core.w.kd.xj().qt() == 1;
    }

    public static boolean xj() {
        JSONObject h = pz.hf().h();
        return h != null && h.optInt("video_cache", 0) == 1;
    }

    public static void xj(final Function<SparseArray<Object>, Object> function) {
        Object apply;
        Object apply2;
        w wVar;
        Function<SparseArray<Object>, Object> aq = com.bytedance.sdk.openadsdk.core.f.zg().aq();
        if (pz.hf().et()) {
            apply = aq.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6).xj(Boolean.class).xj(0, "com.byted.csj.ext").hf());
            if (apply != null ? ((Boolean) apply).booleanValue() : false) {
                apply2 = aq.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(7).xj(Boolean.class).xj(0, "com.byted.csj.ext").hf());
                if (((apply2 != null ? ((Boolean) apply2).booleanValue() : false) || en.xj().xj(aq, false)) && (wVar = (w) com.bytedance.sdk.openadsdk.ats.w.xj("pitaya")) != null) {
                    wVar.init(pz.getContext(), new com.bytedance.sdk.openadsdk.core.wo.u() { // from class: com.bytedance.sdk.openadsdk.core.x.p.1
                        @Override // com.bytedance.sdk.openadsdk.core.wo.u
                        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                            if (function == null) {
                                return null;
                            }
                            function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(i).xj(Void.class).xj(-99999979, (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).hf());
                            return null;
                        }
                    });
                }
            }
        }
    }
}
