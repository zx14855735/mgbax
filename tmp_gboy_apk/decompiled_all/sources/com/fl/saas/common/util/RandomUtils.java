package com.fl.saas.common.util;

import java.lang.reflect.Method;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RandomUtils {
    private static final Random random = new Random();

    static {
        noqwf();
    }

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public static double getRandomDouble(double d, double d2) {
        return ((d2 - d) * random.nextDouble()) + d;
    }

    public static int getRandomInt(int i) {
        if (i <= 0) {
            return 0;
        }
        return random.nextInt(i);
    }

    private static /* synthetic */ void noqwf() {
        char[] charArray = " ¬®í¤¢®¦í¡¬ºí°«¦¯¯í\u0089\u00adª\u0081±ª§¤¦".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 195);
        }
        String str = new String(charArray);
        char[] charArray2 = " ¯ª\u00adª·".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 195);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int getRandomInt(int i, int i2) {
        int i3 = (i2 - i) + 1;
        return i3 <= 0 ? i : random.nextInt(i3) + i;
    }
}
