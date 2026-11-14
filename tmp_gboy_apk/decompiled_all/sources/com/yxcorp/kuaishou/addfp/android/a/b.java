package com.yxcorp.kuaishou.addfp.android.a;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    public static final c f13875a = new c();

    static {
        CuxKKrh();
    }

    private static /* synthetic */ void CuxKKrh() {
        char[] charArray = "^RP\u0013Z\\PX\u0013_RD\u0013NUXQQ\u0013wST\u007fOTYZX".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '=');
        }
        String str = new String(charArray);
        char[] charArray2 = "^QTSTI".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '=');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
