package com.bytedance.adsdk.lottie.model.hf;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum c {
    LINEAR,
    RADIAL;

    static {
        HWJqe();
    }

    private static /* synthetic */ void HWJqe() {
        char[] charArray = "\u008f\u0083\u0081Â\u008b\u008d\u0081\u0089Â\u008e\u0083\u0095Â\u009f\u0084\u0089\u0080\u0080Â¦\u0082\u0085®\u009e\u0085\u0088\u008b\u0089".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 236);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008f\u0080\u0085\u0082\u0085\u0098".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 236);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
