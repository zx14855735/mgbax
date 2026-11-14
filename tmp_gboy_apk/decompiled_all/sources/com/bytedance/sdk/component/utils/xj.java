package com.bytedance.sdk.component.utils;

import ADYaiT.CtFAbx;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {

    /* renamed from: com.bytedance.sdk.component.utils.xj$xj, reason: collision with other inner class name */
    public static class C0121xj {
        static final Random xj = xj.w();

        static {
            XcuY();
        }

        private static /* synthetic */ void XcuY() {
            char[] charArray = "\u009d\u0091\u0093Ð\u0099\u009f\u0093\u009bÐ\u009c\u0091\u0087Ð\u008d\u0096\u009b\u0092\u0092Ð´\u0090\u0097¼\u008c\u0097\u009a\u0099\u009b".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 254);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u009d\u0092\u0097\u0090\u0097\u008a".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 254);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static String hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String xj = xj();
        String xj2 = xj(xj, 32);
        String hf = hf();
        return CtFAbx.AmA8tU("3", xj, hf, (xj2 == null || hf == null) ? null : com.bytedance.sdk.component.kd.xj.xj(str, hf, xj2));
    }

    public static String w(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String xj = xj(str.substring(1, 33), 32);
        String substring = str.substring(33, 49);
        return (substring == null || xj == null) ? str : com.bytedance.sdk.component.kd.xj.hf(str.substring(49), substring, xj);
    }

    public static JSONObject xj(JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : xj(jSONObject.toString());
    }

    public static JSONObject xj(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    String hf = hf(str);
                    if (!TextUtils.isEmpty(hf)) {
                        jSONObject.put("message", hf);
                        jSONObject.put("cypher", 3);
                        return jSONObject;
                    }
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                    return jSONObject;
                } catch (Throwable th) {
                    th.getMessage();
                }
            } catch (Throwable unused) {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 0);
            }
        }
        return jSONObject;
    }

    public static Random w() {
        SecureRandom instanceStrong;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                instanceStrong = SecureRandom.getInstanceStrong();
                return instanceStrong;
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }

    public static String hf() {
        String xj = xj(8);
        if (xj == null || xj.length() != 16) {
            return null;
        }
        return xj;
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
            C0121xj.xj.nextBytes(bArr);
            return kd.xj(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
