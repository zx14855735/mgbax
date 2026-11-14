package com.bytedance.sdk.component.hf.xj;

import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum g {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String kd;

    static {
        ZYhVJE();
    }

    g(String str) {
        this.kd = str;
    }

    private static /* synthetic */ void ZYhVJE() {
        char[] charArray = "JFD\u0007NHDL\u0007KFP\u0007ZALEE\u0007cG@k[@MNL".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ')');
        }
        String str = new String(charArray);
        char[] charArray2 = "JE@G@]".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ')');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static g xj(String str) {
        g gVar = HTTP_1_0;
        if (str.equals(gVar.kd)) {
            return gVar;
        }
        g gVar2 = HTTP_1_1;
        if (str.equals(gVar2.kd)) {
            return gVar2;
        }
        g gVar3 = HTTP_2;
        if (str.equals(gVar3.kd)) {
            return gVar3;
        }
        g gVar4 = SPDY_3;
        if (str.equals(gVar4.kd)) {
            return gVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.kd;
    }
}
