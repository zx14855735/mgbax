package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bp {
    private static final SimpleDateFormat bfJ;
    private static final SimpleDateFormat bfK;
    private static final SimpleDateFormat bfL;
    private static final SimpleDateFormat bfM;
    private static final SimpleDateFormat bfN;
    private static final SimpleDateFormat bfO;
    private static final SimpleDateFormat bfP;

    static {
        Locale locale = Locale.US;
        bfJ = new SimpleDateFormat("MM/dd", locale);
        bfK = new SimpleDateFormat("yyyy/MM/dd", locale);
        bfL = new SimpleDateFormat("MM月dd日", locale);
        bfM = new SimpleDateFormat("yyyy年MM月dd日", locale);
        bfN = new SimpleDateFormat("HH:mm", locale);
        bfO = new SimpleDateFormat("MM-dd", locale);
        bfP = new SimpleDateFormat("yyyy-MM-dd", locale);
        jIySB();
    }

    public static boolean hG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }

    private static /* synthetic */ void jIySB() {
        char[] charArray = "\u0007\u000b\tJ\u0003\u0005\t\u0001J\u0006\u000b\u001dJ\u0017\f\u0001\b\bJ.\n\r&\u0016\r\u0000\u0003\u0001".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'd');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0007\b\r\n\r\u0010".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'd');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
