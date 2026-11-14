package com.bytedance.pangle;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    public static String hf = "_d";
    public static final String kd = MediationConstant.ADN_PANGLE.toUpperCase() + "_PLUGIN_";
    public static String u = "pangle_p";
    public static String w = "_p";
    public static String xj = "_i";

    static {
        UPIq();
    }

    private static /* synthetic */ void UPIq() {
        char[] charArray = "ÞÒÐ\u0093ÚÜÐØ\u0093ßÒÄ\u0093ÎÕØÑÑ\u0093÷ÓÔÿÏÔÙÚØ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 189);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÞÑÔÓÔÉ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 189);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
