package com.octopus.ad.internal.animation;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum TransitionDirection {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    static {
        kfaGbi();
    }

    public static TransitionDirection getDirectionForInt(int i) {
        for (TransitionDirection transitionDirection : values()) {
            if (transitionDirection.ordinal() == i) {
                return transitionDirection;
            }
        }
        return UP;
    }

    private static /* synthetic */ void kfaGbi() {
        char[] charArray = "@LN\rDBNF\rALZ\rPKFOO\riMJaQJGDF".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '#');
        }
        String str = new String(charArray);
        char[] charArray2 = "@OJMJW".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '#');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
