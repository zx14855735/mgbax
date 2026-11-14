package com.octopus.ad.internal.utilities;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class HaoboLogListener {

    public enum LOG_LEVEL {
        V,
        D,
        I,
        W,
        E;

        static {
            YafTA();
        }

        private static /* synthetic */ void YafTA() {
            char[] charArray = "ÈÄÆ\u0085ÌÊÆÎ\u0085ÉÄÒ\u0085ØÃÎÇÇ\u0085áÅÂéÙÂÏÌÎ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 171);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÈÇÂÅÂß".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 171);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public abstract LOG_LEVEL getLogLevel();

    public abstract void onReceiveMessage(LOG_LEVEL log_level, String str, String str2);

    public abstract void onReceiveMessage(LOG_LEVEL log_level, String str, String str2, Throwable th);
}
