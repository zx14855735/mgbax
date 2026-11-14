package com.bytedance.sdk.openadsdk.api.plugin;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private static StringBuffer xj = new StringBuffer();

    static {
        CfnPi();
    }

    private static /* synthetic */ void CfnPi() {
        char[] charArray = "VZX\u001bRTXP\u001bWZL\u001bF]PYY\u001b\u007f[\\wG\\QRP".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '5');
        }
        String str = new String(charArray);
        char[] charArray2 = "VY\\[\\A".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '5');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(String str, String str2) {
    }

    public static String xj() {
        StringBuffer stringBuffer = xj;
        String stringBuffer2 = stringBuffer != null ? stringBuffer.toString() : "";
        xj = null;
        return stringBuffer2;
    }
}
