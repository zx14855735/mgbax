package com.kwad.sdk.commercial.smallApp;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum JumpFrom {
    H5("h5"),
    AD_PAGE("ad_page");

    private final String value;

    static {
        cElXSml();
    }

    JumpFrom(String str) {
        this.value = str;
    }

    private static /* synthetic */ void cElXSml() {
        char[] charArray = "\u0081\u008d\u008fÌ\u0085\u0083\u008f\u0087Ì\u0080\u008d\u009bÌ\u0091\u008a\u0087\u008e\u008eÌ¨\u008c\u008b \u0090\u008b\u0086\u0085\u0087".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 226);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0081\u008e\u008b\u008c\u008b\u0096".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 226);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String getValue() {
        return this.value;
    }
}
