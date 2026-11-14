package com.bytedance.sdk.component.f.hf.xj.xj;

import ADYaiT.CtFAbx;
import com.bytedance.sdk.component.f.xj.kd;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private static String xj = "com.bytedance.openadsdk";
    private static String hf = CtFAbx.B25kr6(new StringBuilder("content://"), xj, ".TTMultiProvider");

    static {
        kOimp();
    }

    private static /* synthetic */ void kOimp() {
        char[] charArray = "°¼¾ý´²¾¶ý±¼ªý »¶¿¿ý\u0099½º\u0091¡º·´¶".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 211);
        }
        String str = new String(charArray);
        char[] charArray2 = "°¿º½º§".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 211);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String xj(kd kdVar) {
        if (kdVar.getContext() != null) {
            xj = kdVar.getContext().getPackageName();
            hf = CtFAbx.B25kr6(new StringBuilder("content://"), xj, ".TTMultiProvider");
        }
        return hf;
    }
}
