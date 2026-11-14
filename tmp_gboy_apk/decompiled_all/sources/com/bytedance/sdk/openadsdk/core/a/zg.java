package com.bytedance.sdk.openadsdk.core.a;

import com.sigmob.sdk.base.mta.PointCategory;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class zg {
    public static boolean hf() {
        JSONObject gj = com.bytedance.sdk.openadsdk.core.pz.hf().gj();
        return gj != null && xj() && gj.optInt("force_drop", 0) == 1;
    }

    public static boolean xj() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject gj = com.bytedance.sdk.openadsdk.core.pz.hf().gj();
        if (gj == null) {
            return false;
        }
        return currentTimeMillis >= gj.optLong("start", 1707480000000L) && currentTimeMillis <= gj.optLong(PointCategory.END, 1707498000000L);
    }
}
