package com.bytedance.adsdk.xj.xj.xj;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class p extends kd {
    static final int xj = kd.xj("IEND");

    static {
        pmkH();
    }

    private static /* synthetic */ void pmkH() {
        char[] charArray = "nb`#jl`h#obt#~ehaa#GcdO\u007fdijh".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\r');
        }
        String str = new String(charArray);
        char[] charArray2 = "nadcdy".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\r');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
