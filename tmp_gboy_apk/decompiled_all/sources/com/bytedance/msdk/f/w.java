package com.bytedance.msdk.f;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static Random xj = new SecureRandom();

    static {
        JNzkkB();
    }

    private static /* synthetic */ void JNzkkB() {
        char[] charArray = "ïãá¢ëíáé¢îãõ¢ÿäéàà¢ÆâåÎþåèëé".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 140);
        }
        String str = new String(charArray);
        char[] charArray2 = "ïàåâåø".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 140);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String hf() {
        String xj2 = xj(8);
        if (xj2 == null || xj2.length() != 16) {
            return null;
        }
        return xj2;
    }

    public static JSONObject xj(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                try {
                    String xj2 = xj(jSONObject.toString());
                    if (TextUtils.isEmpty(xj2)) {
                        jSONObject2.put("message", jSONObject.toString());
                        jSONObject2.put("cypher", 0);
                        return jSONObject2;
                    }
                    jSONObject2.put("message", xj2);
                    jSONObject2.put("cypher", 3);
                    return jSONObject2;
                } catch (Throwable th) {
                    com.bytedance.msdk.xj.kd.w.xj(th.getMessage());
                }
            } catch (Throwable unused) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        }
        return jSONObject2;
    }

    public static String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String xj2 = xj();
        String xj3 = xj(xj2, 32);
        String hf = hf();
        return CtFAbx.AmA8tU("3", xj2, hf, (xj3 == null || hf == null) ? null : xj.xj(str, hf, xj3));
    }

    public static String xj() {
        String xj2 = xj(16);
        if (xj2 == null || xj2.length() != 32) {
            return null;
        }
        return xj2;
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
            xj.nextBytes(bArr);
            return g.xj(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
