package com.kwad.framework.filedownloader;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class f extends com.kwad.framework.filedownloader.event.a {

    public static class a {
        private static final f aqa = new f(0);

        static {
            etceNmJ();
        }

        private static /* synthetic */ void etceNmJ() {
            char[] charArray = "°¼¾ý´²¾¶ý±¼ªý »¶¿¿ý\u0099½º\u0091¡º·´¶".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 211);
            }
            String str = new String(charArray);
            char[] charArray2 = "°¿º½º§".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 211);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ f(byte b) {
        this();
    }

    public static f yR() {
        return a.aqa;
    }

    private f() {
    }
}
