package com.bytedance.sdk.component.c.w.xj;

import ADYaiT.CtFAbx;
import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    public static String xj = "com.bytedance.openadsdk";
    public static String hf = CtFAbx.B25kr6(new StringBuilder("content://"), xj, ".TTMultiProvider");

    static {
        xj();
        ekoNEm();
    }

    private static /* synthetic */ void ekoNEm() {
        char[] charArray = ">20s:<08s?2$s.5811s\u001734\u001f/49:8".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ']');
        }
        String str = new String(charArray);
        char[] charArray2 = ">1434)".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ']');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj() {
        Context context = hf.getContext();
        if (context != null) {
            xj = context.getPackageName();
            hf = CtFAbx.B25kr6(new StringBuilder("content://"), xj, ".TTMultiProvider");
        }
    }
}
