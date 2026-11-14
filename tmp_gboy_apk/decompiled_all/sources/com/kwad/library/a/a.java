package com.kwad.library.a;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    public static final Boolean oy = Boolean.FALSE;

    static {
        hFtFw();
    }

    private static /* synthetic */ void hFtFw() {
        char[] charArray = "\u0087\u008b\u0089Ê\u0083\u0085\u0089\u0081Ê\u0086\u008b\u009dÊ\u0097\u008c\u0081\u0088\u0088Ê®\u008a\u008d¦\u0096\u008d\u0080\u0083\u0081".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 228);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0087\u0088\u008d\u008a\u008d\u0090".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 228);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
