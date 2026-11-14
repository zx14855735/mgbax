package com.bytedance.adsdk.ugeno.w;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private static Map<String, hf> xj = new HashMap();

    static {
        wvGk();
    }

    private static /* synthetic */ void wvGk() {
        char[] charArray = "\u001d\u0011\u0013P\u0019\u001f\u0013\u001bP\u001c\u0011\u0007P\r\u0016\u001b\u0012\u0012P4\u0010\u0017<\f\u0017\u001a\u0019\u001b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '~');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001d\u0012\u0017\u0010\u0017\n".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '~');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(List<hf> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (hf hfVar : list) {
            if (hfVar != null) {
                xj.put(hfVar.xj(), hfVar);
            }
        }
    }

    public static hf xj(String str) {
        return xj.get(str);
    }
}
