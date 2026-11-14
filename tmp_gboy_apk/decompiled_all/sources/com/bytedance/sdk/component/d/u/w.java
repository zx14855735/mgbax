package com.bytedance.sdk.component.d.u;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private hf hf;
    private xj xj;

    public interface hf {
        void xj(String str, String str2);
    }

    /* renamed from: com.bytedance.sdk.component.d.u.w$w, reason: collision with other inner class name */
    public static class C0108w {
        private static final w xj = new w();

        static {
            AGRpBR();
        }

        private static /* synthetic */ void AGRpBR() {
            char[] charArray = "¢®¬ï¦ ¬¤ï£®¸ï²©¤\u00ad\u00adï\u008b¯¨\u0083³¨¥¦¤".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 193);
            }
            String str = new String(charArray);
            char[] charArray2 = "¢\u00ad¨¯¨µ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 193);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public enum xj {
        DEBUG,
        INFO,
        ERROR,
        OFF;

        static {
            IhbIJ();
        }

        private static /* synthetic */ void IhbIJ() {
            char[] charArray = "½±³ð¹¿³»ð¼±§ð\u00ad¶»²²ð\u0094°·\u009c¬·º¹»".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 222);
            }
            String str = new String(charArray);
            char[] charArray2 = "½²·°·ª".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 222);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static void hf(String str, String str2) {
        if (C0108w.xj.xj.compareTo(xj.DEBUG) <= 0) {
            w unused = C0108w.xj;
        }
    }

    public static void xj(xj xjVar) {
        synchronized (w.class) {
            C0108w.xj.xj = xjVar;
        }
    }

    private w() {
        this.xj = xj.OFF;
        this.hf = new com.bytedance.sdk.component.d.u.hf();
    }

    public static void xj(String str, String str2) {
        if (C0108w.xj.xj.compareTo(xj.ERROR) <= 0) {
            C0108w.xj.hf.xj(str, str2);
        }
    }
}
