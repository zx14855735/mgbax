package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl implements eu<Float> {
    public static final pl xj = new pl();

    static {
        kMguAOc();
    }

    private pl() {
    }

    private static /* synthetic */ void kMguAOc() {
        char[] charArray = "^RP\u0013Z\\PX\u0013_RD\u0013NUXQQ\u0013wST\u007fOTYZX".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '=');
        }
        String str = new String(charArray);
        char[] charArray2 = "^QTSTI".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '=');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.adsdk.lottie.u.eu
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Float hf(JsonReader jsonReader, float f) {
        return Float.valueOf(v.hf(jsonReader) * f);
    }
}
