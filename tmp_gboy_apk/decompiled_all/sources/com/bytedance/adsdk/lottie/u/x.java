package com.bytedance.adsdk.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class x implements eu<PointF> {
    public static final x xj = new x();

    static {
        Kwkwg();
    }

    private x() {
    }

    private static /* synthetic */ void Kwkwg() {
        char[] charArray = "\u0083\u008f\u008dÎ\u0087\u0081\u008d\u0085Î\u0082\u008f\u0099Î\u0093\u0088\u0085\u008c\u008cÎª\u008e\u0089¢\u0092\u0089\u0084\u0087\u0085".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 224);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0083\u008c\u0089\u008e\u0089\u0094".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 224);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.adsdk.lottie.u.eu
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public PointF hf(JsonReader jsonReader, float f) {
        return v.hf(jsonReader, f);
    }
}
