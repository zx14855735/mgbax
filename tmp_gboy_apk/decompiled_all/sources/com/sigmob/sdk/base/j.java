package com.sigmob.sdk.base;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum j {
    AppSWith(1),
    AutoNextPreload(2),
    NormalRequest(3),
    SplashCloseRequest(5),
    ReloadAfterExpiration(6),
    ActiveFailureReload(7),
    OtherRequest(999);

    private final int h;

    static {
        DiIrthB();
    }

    j(int i2) {
        this.h = i2;
    }

    private static /* synthetic */ void DiIrthB() {
        char[] charArray = "Û×Õ\u0096ßÙÕÝ\u0096Ú×Á\u0096ËÐÝÔÔ\u0096òÖÑúÊÑÜßÝ".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 184);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÛÔÑÖÑÌ".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 184);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int a() {
        return this.h;
    }
}
