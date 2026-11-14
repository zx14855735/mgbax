package com.baidu.mobads.sdk.internal;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class co {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9789a = "9.35";
    public static final String b = "";
    public static final Boolean c;
    public static final Boolean d;
    public static final String e = "9.35";
    public static final int f = 5000;
    public static final Boolean g;
    public static String h;

    static {
        Boolean bool = Boolean.FALSE;
        c = bool;
        d = Boolean.TRUE;
        g = bool;
        h = "adserv_0";
        IKsM();
    }

    private static /* synthetic */ void IKsM() {
        char[] charArray = "=13p9?3;p<1'p-6;22p\u001407\u001c,7:9;".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '^');
        }
        String str = new String(charArray);
        char[] charArray2 = "=2707*".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '^');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String a() {
        return h;
    }

    public static double b() {
        try {
            return Double.parseDouble("9.35");
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static double c() {
        try {
            return Double.parseDouble("9.35");
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static int d() {
        try {
            return Integer.valueOf("9.35".split("\\.")[0]).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
