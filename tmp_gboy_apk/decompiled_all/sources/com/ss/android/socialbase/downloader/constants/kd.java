package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd {
    public static long c = 31457280;
    public static final JSONObject d = new JSONObject();
    public static long f = 10485760;
    public static volatile String hf = "";
    public static long kd = 50;
    public static long u = 512000;
    public static volatile String w = "";
    public static volatile String xj = "";
    public static long y = 5242880;

    static {
        HWrbDs();
    }

    private static /* synthetic */ void HWrbDs() {
        char[] charArray = "£¯\u00adî§¡\u00ad¥î¢¯¹î³¨¥¬¬î\u008a®©\u0082²©¤§¥".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 192);
        }
        String str = new String(charArray);
        char[] charArray2 = "£¬©®©´".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 192);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        xj = str;
    }
}
