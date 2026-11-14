package com.bytedance.sdk.component.xj;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum ra {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    static {
        bOLZXyg();
    }

    private static /* synthetic */ void bOLZXyg() {
        char[] charArray = "\u0003\u000f\rN\u0007\u0001\r\u0005N\u0002\u000f\u0019N\u0013\b\u0005\f\fN*\u000e\t\"\u0012\t\u0004\u0007\u0005".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '`');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0003\f\t\u000e\t\u0014".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '`');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static ra xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return PUBLIC;
        }
        String lowerCase = str.toLowerCase();
        return TextUtils.equals("protected", lowerCase) ? PROTECTED : TextUtils.equals("private", lowerCase) ? PRIVATE : PUBLIC;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == PRIVATE ? "private" : this == PROTECTED ? "protected" : "public";
    }
}
