package com.kwad.components.ad.reward.page;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum BackPressHandleResult {
    NOT_HANDLED(1),
    HANDLED(2),
    HANDLED_CLOSE(3);

    private int value;

    static {
        MnSAF();
    }

    BackPressHandleResult(int i) {
        this.value = i;
    }

    private static /* synthetic */ void MnSAF() {
        char[] charArray = "\u0006\n\bK\u0002\u0004\b\u0000K\u0007\n\u001cK\u0016\r\u0000\t\tK/\u000b\f'\u0017\f\u0001\u0002\u0000".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'e');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0006\t\f\u000b\f\u0011".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'e');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
