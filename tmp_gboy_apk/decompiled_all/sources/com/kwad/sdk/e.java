package com.kwad.sdk;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class e {
    public static final e awh = new e(10000, "其他异常");
    public static final e awi = new e(10001, "初始化参数异常");
    public static final e awj = new e(11001, "SDK未调用init方法");
    public int code;
    public String msg;

    static {
        bjEq();
    }

    public e(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    private static /* synthetic */ void bjEq() {
        char[] charArray = "ñýÿ¼õóÿ÷¼ðýë¼áú÷þþ¼ØüûÐàûöõ÷".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 146);
        }
        String str = new String(charArray);
        char[] charArray2 = "ñþûüûæ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 146);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
