package com.fl.saas.common.saas.bean;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum CloseButtonPosition {
    FLOAT_TOP_RIGHT(0),
    IMAGE_BOTTOM_CENTER(1),
    IMAGE_TOP_RIGHT(2);

    private final int value;

    static {
        vAaL();
    }

    CloseButtonPosition(int i) {
        this.value = i;
    }

    public static CloseButtonPosition create(int i) {
        for (CloseButtonPosition closeButtonPosition : values()) {
            if (closeButtonPosition.getValue() == i) {
                return closeButtonPosition;
            }
        }
        return FLOAT_TOP_RIGHT;
    }

    private static /* synthetic */ void vAaL() {
        char[] charArray = "\u009d\u0091\u0093Ð\u0099\u009f\u0093\u009bÐ\u009c\u0091\u0087Ð\u008d\u0096\u009b\u0092\u0092Ð´\u0090\u0097¼\u008c\u0097\u009a\u0099\u009b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 254);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009d\u0092\u0097\u0090\u0097\u008a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 254);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int getValue() {
        return this.value;
    }
}
