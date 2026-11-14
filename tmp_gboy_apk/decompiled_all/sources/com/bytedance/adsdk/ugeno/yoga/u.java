package com.bytedance.adsdk.ugeno.yoga;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum u {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5),
    HORIZONTAL(6),
    VERTICAL(7),
    ALL(8);

    private final int tf;

    static {
        Kebm();
    }

    u(int i) {
        this.tf = i;
    }

    private static /* synthetic */ void Kebm() {
        char[] charArray = "bnl/f`ld/cnx/ridmm/KohCshefd".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 1);
        }
        String str = new String(charArray);
        char[] charArray2 = "bmhohu".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 1);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int xj() {
        return this.tf;
    }
}
