package com.baidu.mobads.sdk.internal;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class cn {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f9788a;
    public static final boolean b = false;
    public static final int c;
    public static final String d = "0.0";
    public static String e = null;
    public static final String f = "4.1.30";

    static {
        boolean booleanValue = co.c.booleanValue();
        f9788a = booleanValue;
        c = booleanValue ? 2 : 4;
        e = d;
        XUCZcI();
    }

    private static /* synthetic */ void XUCZcI() {
        char[] charArray = "©¥§ä\u00ad«§¯ä¨¥³ä¹¢¯¦¦ä\u0080¤£\u0088¸£®\u00ad¯".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 202);
        }
        String str = new String(charArray);
        char[] charArray2 = "©¦£¤£¾".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 202);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
