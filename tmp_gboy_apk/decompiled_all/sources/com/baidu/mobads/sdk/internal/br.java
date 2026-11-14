package com.baidu.mobads.sdk.internal;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum br {
    INTERFACE_USE_PROBLEM(1010001, "接口使用问题"),
    SHOW_STANDARD_UNFIT(3040001, "容器大小不达标");

    public static final String c = "msg";
    private int d;
    private String e;

    static {
        dKSM();
    }

    br(int i, String str) {
        this.d = i;
        this.e = str;
    }

    private static /* synthetic */ void dKSM() {
        char[] charArray = "&*(k\"$( k'*<k6- ))k\u000f+,\u00077,!\" ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'E');
        }
        String str = new String(charArray);
        char[] charArray2 = "&),+,1".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'E');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }
}
