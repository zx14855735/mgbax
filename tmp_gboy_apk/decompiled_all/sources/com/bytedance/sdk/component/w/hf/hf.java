package com.bytedance.sdk.component.w.hf;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface hf {
    public static final hf xj = new hf() { // from class: com.bytedance.sdk.component.w.hf.hf.1
        @Override // com.bytedance.sdk.component.w.hf.hf
        public io xj(j jVar, q qVar) {
            return null;
        }
    };

    static {
        wuHwCC();
    }

    private static /* synthetic */ void wuHwCC() {
        char[] charArray = "\u001a\u0016\u0014W\u001e\u0018\u0014\u001cW\u001b\u0016\u0000W\n\u0011\u001c\u0015\u0015W3\u0017\u0010;\u000b\u0010\u001d\u001e\u001c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'y');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001a\u0015\u0010\u0017\u0010\r".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    io xj(j jVar, q qVar);
}
