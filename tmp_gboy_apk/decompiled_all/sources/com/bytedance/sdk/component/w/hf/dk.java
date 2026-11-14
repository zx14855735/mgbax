package com.bytedance.sdk.component.w.hf;

import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum dk {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String kd;

    static {
        yNBsQwd();
    }

    dk(String str) {
        this.kd = str;
    }

    public static dk xj(String str) {
        dk dkVar = HTTP_1_0;
        if (str.equals(dkVar.kd)) {
            return dkVar;
        }
        dk dkVar2 = HTTP_1_1;
        if (str.equals(dkVar2.kd)) {
            return dkVar2;
        }
        dk dkVar3 = HTTP_2;
        if (str.equals(dkVar3.kd)) {
            return dkVar3;
        }
        dk dkVar4 = SPDY_3;
        if (str.equals(dkVar4.kd)) {
            return dkVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    private static /* synthetic */ void yNBsQwd() {
        char[] charArray = "\u0017\u001b\u0019Z\u0013\u0015\u0019\u0011Z\u0016\u001b\rZ\u0007\u001c\u0011\u0018\u0018Z>\u001a\u001d6\u0006\u001d\u0010\u0013\u0011".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 't');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0017\u0018\u001d\u001a\u001d\u0000".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 't');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.kd;
    }
}
