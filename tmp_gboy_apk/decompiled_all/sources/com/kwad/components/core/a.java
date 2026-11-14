package com.kwad.components.core;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    public static final Boolean Nr = Boolean.TRUE;
    public static final Boolean Ns;
    public static final Boolean Nt;
    public static final Boolean Nu;
    public static final Boolean Nv;
    public static final Boolean oy;

    static {
        Boolean bool = Boolean.FALSE;
        Ns = bool;
        oy = bool;
        Nt = bool;
        Nu = bool;
        Nv = bool;
        isVg();
    }

    private static /* synthetic */ void isVg() {
        char[] charArray = "ÀÌÎ\u008dÄÂÎÆ\u008dÁÌÚ\u008dÐËÆÏÏ\u008déÍÊáÑÊÇÄÆ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 163);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÀÏÊÍÊ×".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 163);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
