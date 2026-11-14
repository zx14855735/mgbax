package com.kwad.framework.b;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    public static final Boolean oy = Boolean.FALSE;

    static {
        PBrjVO();
    }

    private static /* synthetic */ void PBrjVO() {
        char[] charArray = "-!#`)/#+`,!7`=&+\"\"`\u0004 '\f<'*)+".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'N');
        }
        String str = new String(charArray);
        char[] charArray2 = "-\"' ':".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'N');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
