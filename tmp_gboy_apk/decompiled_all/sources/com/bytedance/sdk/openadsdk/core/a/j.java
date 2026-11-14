package com.bytedance.sdk.openadsdk.core.a;

import B4ZgIw.AYUAbz;
import android.annotation.SuppressLint;
import com.bytedance.sdk.component.c.u;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class j {
    private static volatile boolean xj;

    public static class xj {

        @SuppressLint({"StaticFieldLeak"})
        static final u.xj xj = j.u();

        static {
            pcSSr();
        }

        private static /* synthetic */ void pcSSr() {
            char[] charArray = "¼°²ñ¸¾²ºñ½°¦ñ¬·º³³ñ\u0095±¶\u009d\u00ad¶»¸º".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 223);
            }
            String str = new String(charArray);
            char[] charArray2 = "¼³¶±¶«".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 223);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static int hf() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static u.xj u() {
        com.bytedance.sdk.openadsdk.core.j.tf hf = com.bytedance.sdk.openadsdk.core.pz.hf();
        hf.ta();
        return new u.xj().xj(com.bytedance.sdk.openadsdk.core.pz.getContext()).xj(1).hf(hf.eb()).xj(xj);
    }

    public static com.bytedance.sdk.component.u.hf.w xj(String str) {
        return xj.xj.xj(hf(str)).xj();
    }

    private static String hf(String str) {
        if (xj || com.bytedance.sdk.component.utils.e.xj(com.bytedance.sdk.openadsdk.core.pz.getContext())) {
            return str;
        }
        StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
        A4TApA2.append(com.bytedance.sdk.component.utils.e.hf(com.bytedance.sdk.openadsdk.core.pz.getContext()));
        return A4TApA2.toString();
    }

    public static void xj() {
        xj = true;
    }
}
