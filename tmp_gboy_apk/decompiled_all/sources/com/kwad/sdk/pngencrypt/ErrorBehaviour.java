package com.kwad.sdk.pngencrypt;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum ErrorBehaviour {
    STRICT(0),
    LENIENT1_CRC(1),
    LENIENT2_ANCILLARY(3),
    SUPER_LENIENT(5);

    final int c;

    static {
        fkYecDx();
    }

    ErrorBehaviour(int i) {
        this.c = i;
    }

    private static /* synthetic */ void fkYecDx() {
        char[] charArray = "\u0005\t\u000bH\u0001\u0007\u000b\u0003H\u0004\t\u001fH\u0015\u000e\u0003\n\nH,\b\u000f$\u0014\u000f\u0002\u0001\u0003".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'f');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0005\n\u000f\b\u000f\u0012".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'f');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
