package com.sigmob.sdk.nativead;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum j {
    PREVIEW,
    DETAIL_PAGE,
    DETAIL_PAGE_END;

    static {
        fDHNS();
    }

    private static /* synthetic */ void fDHNS() {
        char[] charArray = "%)+h!'+#h$)?h5.#**h\f(/\u00044/\"!#".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'F');
        }
        String str = new String(charArray);
        char[] charArray2 = "%*/(/2".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'F');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
