package com.bytedance.sdk.openadsdk.core.ra;

import android.os.Build;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class cy {
    public static int hf = 0;
    public static int w = 1;
    public static int xj;

    public static void xj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("ugen_image_load_config")) == null) {
            return;
        }
        xj = optJSONObject.optInt("api", 0);
        hf = optJSONObject.optInt("size_limit", 0);
        w = optJSONObject.optInt("zip_level", 1);
    }

    public static int xj(int i, int i2) {
        if (xj <= 0 || Build.VERSION.SDK_INT > xj || i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = hf;
        if (i >= i3 || i2 >= i3) {
            return Math.max(1, w);
        }
        return 1;
    }
}
