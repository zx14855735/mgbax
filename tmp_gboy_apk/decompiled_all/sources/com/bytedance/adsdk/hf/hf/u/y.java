package com.bytedance.adsdk.hf.hf.u;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum y implements kd {
    OPERATOR_RESULT,
    BRACKET,
    VARIABLE,
    PROPERTY,
    METHOD,
    STRING,
    NUMBER,
    TYPE,
    TYPE_ENUM,
    ENUM,
    CONSTANT;

    static {
        rfYoik();
    }

    private static /* synthetic */ void rfYoik() {
        char[] charArray = "s\u007f}>wq}u>r\u007fi>cxu||>Z~yRbytwu".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 16);
        }
        String str = new String(charArray);
        char[] charArray2 = "s|y~yd".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 16);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
