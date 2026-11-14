package com.bytedance.msdk.hf;

import android.text.TextUtils;
import com.bytedance.msdk.f.l;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static final String xj = l.u();
    public static boolean hf = true;

    static {
        DuXetRk();
    }

    private static /* synthetic */ void DuXetRk() {
        char[] charArray = "ôøú¹ðöúò¹õøî¹äÿòûû¹ÝùþÕåþóðò".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 151);
        }
        String str = new String(charArray);
        char[] charArray2 = "ôûþùþã".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 151);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String hf() {
        return com.bytedance.sdk.gromore.init.xj.w();
    }

    public static String u() {
        return com.bytedance.sdk.gromore.init.xj.u();
    }

    public static String w() {
        if (TextUtils.isEmpty(hf())) {
            return "";
        }
        String[] split = hf().split("\\.");
        if (split.length < 4) {
            return "";
        }
        return split[0] + "." + split[1] + "." + split[2];
    }

    public static int xj() {
        return Integer.parseInt(hf().replace(".", ""));
    }
}
