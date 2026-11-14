package com.kuaishou.weapon.p0;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class cu {
    public static final int b = 16;
    public static final String c = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";

    /* renamed from: a, reason: collision with root package name */
    public static String f12252a = b();
    public static String d = c.b(d, 2);
    public static String d = c.b(d, 2);
    public static String e = c.b(e, 2);
    public static String e = c.b(e, 2);
    public static String f = c.b(f, 2);
    public static String f = c.b(f, 2);
    public static String g = c.b(g, 2);
    public static String g = c.b(g, 2);
    public static String h = c.b(h, 2);
    public static String h = c.b(h, 2);

    static {
        FaxYPCw();
    }

    private static /* synthetic */ void FaxYPCw() {
        char[] charArray = "àìî\u00adäâîæ\u00adáìú\u00adðëæïï\u00adÉíêÁñêçäæ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 131);
        }
        String str = new String(charArray);
        char[] charArray2 = "àïêíê÷".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 131);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean a() {
        return false;
    }

    public static String b() {
        return bn.b(a() ? "Y1dRJlUS0ggA8rDIzmTuSb18fETpsUSliIb8eUc8Cs7Tg08T72W0GoR0htlL8mwiuorXs9F6RhwIlueUNq7egw==" : "Y1dRJlUS0ggA8rDIzmTuSdNPHbegnkXofklx4RRLaYJoK5uDjDZ2N7h9QqyTv9Qg");
    }
}
