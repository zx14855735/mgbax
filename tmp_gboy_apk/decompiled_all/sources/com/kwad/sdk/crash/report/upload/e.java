package com.kwad.sdk.crash.report.upload;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    public static e aVA = new e(-11, "Please init.");
    public static e aVB = new e(-12, "error when zip_file");
    public static e aVC = new e(-13, "There is no valid network.");
    public static e aVD = new e(-14, "Token is invalid.");
    public static e aVE = new e(-15, "upload task execute frequence exceed.");
    public static e aVF = new e(-16, "process request fail.");
    public static e aVG = new e(-17, "sever response error http code");
    public static e aVH = new e(-18, "sever response error result code");
    public static e aVI = new e(-19, "server bad response.");
    private final int aVJ;
    private final String aVK;

    static {
        xaoerV();
    }

    private e(int i, String str) {
        this.aVJ = i;
        this.aVK = str;
    }

    private static /* synthetic */ void xaoerV() {
        char[] charArray = "ÇËÉ\u008aÃÅÉÁ\u008aÆËÝ\u008a×ÌÁÈÈ\u008aîÊÍæÖÍÀÃÁ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 164);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÇÈÍÊÍÐ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 164);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String AF() {
        return this.aVK;
    }
}
