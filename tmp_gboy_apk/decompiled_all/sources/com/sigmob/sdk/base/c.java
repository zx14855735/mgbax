package com.sigmob.sdk.base;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum c {
    ImageTypeUnknow(0),
    ImageTypeJPEG(1),
    ImageTypePNG(2),
    ImageTypeGIF(3),
    SMImageTypeWEBP(4),
    ImageTypeMP4(5);

    private final int g;

    static {
        GRlKeKd();
    }

    c(int i) {
        this.g = i;
    }

    private static /* synthetic */ void GRlKeKd() {
        char[] charArray = "\u0018\u0014\u0016U\u001c\u001a\u0016\u001eU\u0019\u0014\u0002U\b\u0013\u001e\u0017\u0017U1\u0015\u00129\t\u0012\u001f\u001c\u001e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '{');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0018\u0017\u0012\u0015\u0012\u000f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '{');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int a() {
        return this.g;
    }
}
