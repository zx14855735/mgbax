package com.bytedance.sdk.openadsdk.core.pz;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum xj {
    USE_KWS(0),
    USE_ALOG(1),
    USE_PITAYA(2),
    USE_OTHER(3);

    private long kd;
    private long y;

    static {
        YmBdXk();
    }

    xj(int i) {
        if (i < 0 || i > 63) {
            throw new IllegalArgumentException("bit argument illegal exception,range [0,63]");
        }
        this.kd = 1 << i;
        this.y = i;
    }

    private static /* synthetic */ void YmBdXk() {
        char[] charArray = "²¾¼ÿ¶°¼´ÿ³¾¨ÿ¢¹´½½ÿ\u009b¿¸\u0093£¸µ¶´".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 209);
        }
        String str = new String(charArray);
        char[] charArray2 = "²½¸¿¸¥".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 209);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public long xj() {
        return this.kd;
    }
}
