package com.kwad.sdk.core.imageloader.core.assist;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum QueueProcessingType {
    FIFO,
    LIFO;

    static {
        QbbYC();
    }

    private static /* synthetic */ void QbbYC() {
        char[] charArray = "ßÓÑ\u0092ÛÝÑÙ\u0092ÞÓÅ\u0092ÏÔÙÐÐ\u0092öÒÕþÎÕØÛÙ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 188);
        }
        String str = new String(charArray);
        char[] charArray2 = "ßÐÕÒÕÈ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 188);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
