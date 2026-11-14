package com.fl.saas.common.saas.bean;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum Orientation {
    VERTICAL(0),
    HORIZONTAL(1),
    ENVELOPE(2);

    private final int value;

    static {
        vkZR();
    }

    Orientation(int i) {
        this.value = i;
    }

    public static Orientation create(int i) {
        for (Orientation orientation : values()) {
            if (orientation.getValue() == i) {
                return orientation;
            }
        }
        return VERTICAL;
    }

    private static /* synthetic */ void vkZR() {
        char[] charArray = "ëçå¦ïéåí¦êçñ¦ûàíää¦ÂæáÊúáìïí".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 136);
        }
        String str = new String(charArray);
        char[] charArray2 = "ëäáæáü".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 136);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int getValue() {
        return this.value;
    }
}
