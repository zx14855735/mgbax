package com.ss.android.socialbase.downloader.constants;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum EnqueueType {
    ENQUEUE_NONE,
    ENQUEUE_HEAD,
    ENQUEUE_TAIL;

    static {
        gCoYib();
    }

    private static /* synthetic */ void gCoYib() {
        char[] charArray = "\u001b\u0017\u0015V\u001f\u0019\u0015\u001dV\u001a\u0017\u0001V\u000b\u0010\u001d\u0014\u0014V2\u0016\u0011:\n\u0011\u001c\u001f\u001d".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'x');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001b\u0014\u0011\u0016\u0011\f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'x');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
