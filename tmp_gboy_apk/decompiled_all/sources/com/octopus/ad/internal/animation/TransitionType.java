package com.octopus.ad.internal.animation;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum TransitionType {
    NONE,
    RANDOM,
    FADE,
    PUSH,
    MOVEIN,
    REVEAL;

    static {
        trSK();
    }

    public static TransitionType getTypeForInt(int i) {
        for (TransitionType transitionType : values()) {
            if (transitionType.ordinal() == i) {
                return transitionType;
            }
        }
        return NONE;
    }

    private static /* synthetic */ void trSK() {
        char[] charArray = "kge&oiem&jgq&{`mdd&BfaJzalom".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\b');
        }
        String str = new String(charArray);
        char[] charArray2 = "kdafa|".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\b');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
