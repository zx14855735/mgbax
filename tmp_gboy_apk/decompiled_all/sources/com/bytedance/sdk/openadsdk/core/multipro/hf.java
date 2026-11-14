package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.a.j;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public static boolean hf;
    public static boolean xj;

    public static class xj {
        static final com.bytedance.sdk.component.u.hf.w xj = j.xj("sp_multi_info");

        static {
            RXAiPAK();
        }

        private static /* synthetic */ void RXAiPAK() {
            char[] charArray = "=13p9?3;p<1'p-6;22p\u001407\u001c,7:9;".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '^');
            }
            String str = new String(charArray);
            char[] charArray2 = "=2707*".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '^');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static void hf() {
        if (hf) {
            xj.xj.put("is_support_multi_process", false);
        }
        xj = false;
    }

    public static boolean w() {
        if (!hf) {
            xj = xj.xj.get("is_support_multi_process", false);
            hf = true;
        }
        return xj;
    }

    public static void xj() {
        if (!hf) {
            xj.xj.put("is_support_multi_process", true);
        }
        xj = true;
        hf = true;
    }
}
