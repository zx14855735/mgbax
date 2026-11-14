package com.bytedance.sdk.openadsdk.core.multipro;

import ADYaiT.CtFAbx;
import com.bytedance.sdk.openadsdk.core.pz;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    public static String xj = "com.bytedance.openadsdk";
    public static String hf = CtFAbx.B25kr6(new StringBuilder("content://"), xj, ".TTMultiProvider");

    static {
        xj();
        DJiDZK();
    }

    private static /* synthetic */ void DJiDZK() {
        char[] charArray = "{wu6\u007fyu}6zwa6kp}tt6RvqZjq|\u007f}".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 24);
        }
        String str = new String(charArray);
        char[] charArray2 = "{tqvql".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 24);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj() {
        if (pz.getContext() != null) {
            xj = pz.getContext().getPackageName();
            hf = CtFAbx.B25kr6(new StringBuilder("content://"), xj, ".TTMultiProvider");
        }
    }
}
