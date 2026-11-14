package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class yo implements eu<Integer> {
    public static final yo xj = new yo();

    static {
        ctYqAT();
    }

    private yo() {
    }

    private static /* synthetic */ void ctYqAT() {
        char[] charArray = "¿³±ò»½±¹ò¾³¥ò¯´¹°°ò\u0096²µ\u009e®µ¸»¹".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 220);
        }
        String str = new String(charArray);
        char[] charArray2 = "¿°µ²µ¨".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 220);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.adsdk.lottie.u.eu
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Integer hf(JsonReader jsonReader, float f) {
        return Integer.valueOf(Math.round(v.hf(jsonReader) * f));
    }
}
