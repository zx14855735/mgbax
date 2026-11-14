package com.bytedance.adsdk.ugeno.yoga;

import java.lang.reflect.Method;

@com.bytedance.adsdk.ugeno.yoga.xj.xj
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum YogaLogLevel {
    ERROR(0),
    WARN(1),
    INFO(2),
    DEBUG(3),
    VERBOSE(4),
    FATAL(5);

    private final int c;

    static {
        Jfngzz();
    }

    YogaLogLevel(int i) {
        this.c = i;
    }

    private static /* synthetic */ void Jfngzz() {
        char[] charArray = "%)+h!'+#h$)?h5.#**h\f(/\u00044/\"!#".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'F');
        }
        String str = new String(charArray);
        char[] charArray2 = "%*/(/2".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'F');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @com.bytedance.adsdk.ugeno.yoga.xj.xj
    public static YogaLogLevel fromInt(int i) {
        if (i == 0) {
            return ERROR;
        }
        if (i == 1) {
            return WARN;
        }
        if (i == 2) {
            return INFO;
        }
        if (i == 3) {
            return DEBUG;
        }
        if (i == 4) {
            return VERBOSE;
        }
        if (i == 5) {
            return FATAL;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
