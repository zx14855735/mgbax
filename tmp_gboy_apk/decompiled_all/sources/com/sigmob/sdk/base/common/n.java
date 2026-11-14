package com.sigmob.sdk.base.common;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum n {
    CreativeTypeVideo_Tar(1),
    CreativeTypeImage(3),
    CreativeTypeVideo_Html_Snippet(4),
    CreativeTypeVideo_Tar_Companion(5),
    CreativeTypeVideo_transparent_html(6),
    CreativeTypeVideo_EndCardURL(7),
    CreativeTypeSplashVideo(8),
    CreativeTypeMRAID(9),
    CreativeTypeMRAIDTWO(10),
    CreativeTypeKiteX(11),
    CreativeTypeNewInterstitial(16);

    private final int l;

    static {
        QgJhWjY();
    }

    n(int i) {
        this.l = i;
    }

    private static /* synthetic */ void QgJhWjY() {
        char[] charArray = "\u001d\u0011\u0013P\u0019\u001f\u0013\u001bP\u001c\u0011\u0007P\r\u0016\u001b\u0012\u0012P4\u0010\u0017<\f\u0017\u001a\u0019\u001b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '~');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001d\u0012\u0017\u0010\u0017\n".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '~');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int a() {
        return this.l;
    }
}
