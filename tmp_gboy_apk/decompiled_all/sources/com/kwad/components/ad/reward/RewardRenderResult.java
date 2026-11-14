package com.kwad.components.ad.reward;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum RewardRenderResult {
    DEFAULT,
    NEO_TK,
    LIVE_TK,
    FULLSCREEN_TK,
    TK_IMAGE;

    static {
        chhhquF();
    }

    private static /* synthetic */ void chhhquF() {
        char[] charArray = "®¢ ãª¬ ¨ã¯¢´ã¾¥¨¡¡ã\u0087£¤\u008f¿¤©ª¨".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 205);
        }
        String str = new String(charArray);
        char[] charArray2 = "®¡¤£¤¹".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 205);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
