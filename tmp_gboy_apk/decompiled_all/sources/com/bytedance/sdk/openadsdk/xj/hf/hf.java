package com.bytedance.sdk.openadsdk.xj.hf;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public static final xj xj = new w();

    static {
        TRfhoL();
    }

    private static /* synthetic */ void TRfhoL() {
        char[] charArray = ":64w>84<w;6 w*1<55w\u001370\u001b+0=><".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Y');
        }
        String str = new String(charArray);
        char[] charArray2 = ":5070-".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void hf(Context context) {
    }

    public static void kd() {
    }

    public static void u() {
    }

    public static void w(Context context) {
        xj.xj(context);
    }

    public static void xj(Context context) {
    }

    public static void hf() {
        xj.hf();
    }

    public static int w() {
        return xj.w();
    }

    public static void xj(boolean z) {
    }

    public static void xj() {
        xj.xj();
    }
}
