package com.baidu.mobads.sdk.api;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum AdSize {
    Banner(0),
    Square(1),
    InterstitialGame(6),
    InterstitialReader(7),
    InterstitialRefresh(9),
    InterstitialOther(10),
    InterstitialForVideoBeforePlay(12),
    InterstitialForVideoPausePlay(13),
    RewardVideo(14),
    PrerollVideoNative(15),
    FeedNative(16),
    FeedH5TemplateNative(17);

    private int value;

    static {
        BbFXI();
    }

    AdSize(int i) {
        this.value = i;
    }

    private static /* synthetic */ void BbFXI() {
        char[] charArray = "R^\\\u001fVP\\T\u001fS^H\u001fBYT]]\u001f{_XsCXUVT".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '1');
        }
        String str = new String(charArray);
        char[] charArray2 = "R]X_XE".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '1');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int getValue() {
        return this.value;
    }
}
