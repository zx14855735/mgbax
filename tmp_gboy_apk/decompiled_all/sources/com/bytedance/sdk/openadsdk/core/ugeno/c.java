package com.bytedance.sdk.openadsdk.core.ugeno;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.j;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class c {
    private static volatile c xj;
    private com.bytedance.sdk.component.u.hf.w hf = j.xj("ugeno_template_file");

    private c() {
    }

    public static c xj() {
        if (xj == null) {
            synchronized (c.class) {
                try {
                    if (xj == null) {
                        xj = new c();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public boolean hf(String str, String str2) {
        return xj(str, str2) != null;
    }

    public void xj(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.hf.put("ugeno_".concat(String.valueOf(str)), str3);
        this.hf.put("ugeno__md5_".concat(String.valueOf(str)), str2);
    }

    public JSONObject xj(String str, String str2) {
        String str3 = this.hf.get("ugeno_".concat(String.valueOf(str)), "");
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String str4 = this.hf.get("ugeno__md5_".concat(String.valueOf(str)), "");
        if (!TextUtils.isEmpty(str4) && TextUtils.equals(str4, str2)) {
            try {
                return new JSONObject(str3);
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        return null;
    }
}
