package com.bytedance.sdk.component.w.hf.xj.kd;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum hf {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);

    public final int c;

    static {
        nISMU();
    }

    hf(int i) {
        this.c = i;
    }

    private static /* synthetic */ void nISMU() {
        char[] charArray = "\u0010\u001c\u001e]\u0014\u0012\u001e\u0016]\u0011\u001c\n]\u0000\u001b\u0016\u001f\u001f]9\u001d\u001a1\u0001\u001a\u0017\u0014\u0016".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 's');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0010\u001f\u001a\u001d\u001a\u0007".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 's');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static hf xj(int i) {
        try {
            for (hf hfVar : values()) {
                if (hfVar.c == i) {
                    return hfVar;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
