package com.baidu.mobads.sdk.internal;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static cb f9837a;
    protected static Boolean b = Boolean.FALSE;

    static {
        JePKlnk();
    }

    private static /* synthetic */ void JePKlnk() {
        char[] charArray = "û÷õ¶ÿùõý¶ú÷á¶ëðýôô¶ÒöñÚêñüÿý".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 152);
        }
        String str = new String(charArray);
        char[] charArray2 = "ûôñöñì".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 152);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void a() {
        f9837a = null;
        b = Boolean.FALSE;
    }
}
