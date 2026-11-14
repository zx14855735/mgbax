package com.bytedance.sdk.openadsdk.api.plugin.w;

import ADYaiT.CtFAbx;
import android.os.Build;
import android.text.TextUtils;
import java.security.SecureRandom;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public static String hf(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String xj = xj(str.substring(1, 33), 32);
        String substring = str.substring(33, 49);
        return (substring == null || xj == null) ? str : xj.hf(str.substring(49), substring, xj);
    }

    private static SecureRandom w() {
        SecureRandom instanceStrong;
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
            return instanceStrong;
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public static String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String xj = xj();
        String xj2 = xj(xj, 32);
        String hf = hf();
        return CtFAbx.AmA8tU("3", xj, hf, (xj2 == null || hf == null) ? null : xj.xj(str, hf, xj2));
    }

    public static String hf() {
        String xj = xj(8);
        if (xj == null || xj.length() != 16) {
            return null;
        }
        return xj;
    }

    public static JSONObject xj(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                try {
                    String xj = xj(jSONObject.toString());
                    if (!TextUtils.isEmpty(xj)) {
                        jSONObject2.put("message", xj);
                        jSONObject2.put("cypher", 3);
                        return jSONObject2;
                    }
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                    return jSONObject2;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        }
        return jSONObject2;
    }

    public static String xj() {
        String xj = xj(16);
        if (xj == null || xj.length() != 32) {
            return null;
        }
        return xj;
    }

    public static String xj(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String xj(int i) {
        try {
            byte[] bArr = new byte[i];
            w().nextBytes(bArr);
            return u.xj(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
