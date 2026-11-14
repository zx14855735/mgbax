package com.bytedance.sdk.component.hf.xj;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class qt {
    private String hf;
    public byte[] kd;
    public String u;
    public tf w;
    private String xj;
    public xj y;

    public enum xj {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE;

        static {
            IoBVvav();
        }

        private static /* synthetic */ void IoBVvav() {
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

    public qt() {
    }

    public String hf() {
        return this.hf;
    }

    public String xj() {
        return this.xj;
    }

    public qt(tf tfVar, String str, xj xjVar) {
        this.w = tfVar;
        this.u = str;
        this.y = xjVar;
    }

    public static qt xj(tf tfVar, String str) {
        return new qt(tfVar, str, xj.STRING_TYPE);
    }

    public static qt xj(tf tfVar, byte[] bArr) {
        return new qt(tfVar, bArr, xj.BYTE_ARRAY_TYPE);
    }

    public static qt xj(tf tfVar, byte[] bArr, String str, String str2) {
        return new qt(tfVar, bArr, str, str2, xj.FILE_TYPE);
    }

    public qt(tf tfVar, byte[] bArr, String str, String str2, xj xjVar) {
        this.w = tfVar;
        this.kd = bArr;
        this.hf = str;
        this.xj = str2;
        this.y = xjVar;
    }

    public qt(tf tfVar, byte[] bArr, xj xjVar) {
        this.w = tfVar;
        this.kd = bArr;
        this.y = xjVar;
    }
}
