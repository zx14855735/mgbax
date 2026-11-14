package com.bytedance.embedapplog;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class v {
    private static hf hf = xj.xj();
    private static int xj = 6;

    public static abstract class hf {
        public void hf(String str, String str2) {
        }

        public void w(String str, String str2) {
        }

        public void xj(String str, String str2) {
        }

        public void xj(String str, String str2, Throwable th) {
        }

        public boolean xj(int i) {
            return v.xj() <= i;
        }
    }

    public static final class xj extends hf {

        /* renamed from: com.bytedance.embedapplog.v$xj$xj, reason: collision with other inner class name */
        public static class C0048xj {
            private static final xj xj = new xj();

            static {
                IergCWY();
            }

            private static /* synthetic */ void IergCWY() {
                char[] charArray = "\u0093\u009f\u009dÞ\u0097\u0091\u009d\u0095Þ\u0092\u009f\u0089Þ\u0083\u0098\u0095\u009c\u009cÞº\u009e\u0099²\u0082\u0099\u0094\u0097\u0095".toCharArray();
                int length = charArray.length;
                for (int i = 0; i < length; i++) {
                    charArray[i] = (char) (charArray[i] ^ 240);
                }
                String str = new String(charArray);
                char[] charArray2 = "\u0093\u009c\u0099\u009e\u0099\u0084".toCharArray();
                int length2 = charArray2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    charArray2[i2] = (char) (charArray2[i2] ^ 240);
                }
                Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[0]);
            }
        }

        public static xj xj() {
            return C0048xj.xj;
        }

        @Override // com.bytedance.embedapplog.v.hf
        public void hf(String str, String str2) {
            com.bytedance.sdk.component.utils.pl.u(str, str2);
        }

        @Override // com.bytedance.embedapplog.v.hf
        public void w(String str, String str2) {
            com.bytedance.sdk.component.utils.pl.hf(str, str2);
        }

        private xj() {
        }

        @Override // com.bytedance.embedapplog.v.hf
        public void xj(String str, String str2) {
            com.bytedance.sdk.component.utils.pl.xj(str, str2);
        }

        @Override // com.bytedance.embedapplog.v.hf
        public void xj(String str, String str2, Throwable th) {
            com.bytedance.sdk.component.utils.pl.w(str, str2, th);
        }
    }

    static {
        KigQl();
    }

    private static /* synthetic */ void KigQl() {
        char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 216);
        }
        String str = new String(charArray);
        char[] charArray2 = "»´±¶±¬".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 216);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean hf() {
        return xj <= 3;
    }

    public static void u(String str, String str2) {
        if (str2 != null && hf.xj(6)) {
            hf.hf(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (str2 != null && hf.xj(5)) {
            hf.w(str, str2);
        }
    }

    public static int xj() {
        return xj;
    }

    public static void hf(String str, String str2) {
        if (str2 != null && hf.xj(4)) {
            hf.xj(str, str2);
        }
    }

    public static void xj(String str) {
        xj("Logger", str);
    }

    public static void xj(String str, String str2) {
        if (str2 == null) {
            return;
        }
        hf.xj(3);
    }

    public static void hf(String str) {
        u("Logger", str);
    }

    public static void xj(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && hf.xj(6)) {
            hf.xj(str, str2, th);
        }
    }
}
