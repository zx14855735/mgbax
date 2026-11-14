package com.kwad.framework.a;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    public static final Boolean Nr;
    public static final Boolean Nt;
    public static final Boolean apd;
    public static final Boolean ape;
    public static final Boolean apf;
    public static final Boolean apg;
    public static final Boolean aph;
    public static final Boolean api;
    public static final Boolean apj;
    public static final Boolean ox;
    public static final Boolean oy;

    static {
        Boolean bool = Boolean.TRUE;
        apd = bool;
        Nr = bool;
        ape = bool;
        apf = bool;
        apg = bool;
        Boolean bool2 = Boolean.FALSE;
        ox = bool2;
        oy = bool2;
        Nt = bool2;
        aph = bool;
        api = bool;
        apj = bool2;
        CSgmSoA();
    }

    private static /* synthetic */ void CSgmSoA() {
        char[] charArray = "¶º¸û²´¸°û·º¬û¦½°¹¹û\u009f»¼\u0097§¼±²°".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 213);
        }
        String str = new String(charArray);
        char[] charArray2 = "¶¹¼»¼¡".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 213);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
