package com.bytedance.sdk.component.w.hf.xj.kd;

import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface g {
    public static final g xj = new g() { // from class: com.bytedance.sdk.component.w.hf.xj.kd.g.1
        @Override // com.bytedance.sdk.component.w.hf.xj.kd.g
        public boolean xj(int i, List<w> list) {
            return true;
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.kd.g
        public boolean xj(int i, List<w> list, boolean z) {
            return true;
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.kd.g
        public boolean xj(int i, com.bytedance.sdk.component.w.xj.kd kdVar, int i2, boolean z) {
            kdVar.f(i2);
            return true;
        }
    };

    static {
        fZapy();
    }

    private static /* synthetic */ void fZapy() {
        char[] charArray = "\u000b\u0007\u0005F\u000f\t\u0005\rF\n\u0007\u0011F\u001b\u0000\r\u0004\u0004F\"\u0006\u0001*\u001a\u0001\f\u000f\r".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'h');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000b\u0004\u0001\u0006\u0001\u001c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'h');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    boolean xj(int i, com.bytedance.sdk.component.w.xj.kd kdVar, int i2, boolean z);

    boolean xj(int i, List<w> list);

    boolean xj(int i, List<w> list, boolean z);
}
