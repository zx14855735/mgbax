package com.bytedance.adsdk.hf.hf.u;

import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum xj implements kd {
    TRUE,
    FALSE,
    NULL;

    private static final Map<String, xj> u = new HashMap(r.b.d);

    static {
        for (xj xjVar : values()) {
            u.put(xjVar.name().toLowerCase(), xjVar);
        }
        HpKu();
    }

    private static /* synthetic */ void HpKu() {
        char[] charArray = "ÇËÉ\u008aÃÅÉÁ\u008aÆËÝ\u008a×ÌÁÈÈ\u008aîÊÍæÖÍÀÃÁ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 164);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÇÈÍÊÍÐ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 164);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static xj xj(String str) {
        return u.get(str.toLowerCase());
    }
}
