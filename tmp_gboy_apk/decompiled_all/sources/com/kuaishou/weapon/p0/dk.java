package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class dk {
    public static JSONObject a() {
        try {
            String str = System.getenv("LD_PRELOAD");
            String str2 = System.getenv("LD_LIBRARY_PATH");
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(Constants.FAIL, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("1", str2);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b() {
        try {
            String a2 = bk.a();
            if (TextUtils.isEmpty(a2) || a2.contains("arm64")) {
                return 0;
            }
            return !a2.contains("64") ? 1 : 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
