package com.bytedance.adsdk.ugeno.kd;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private static Map<String, hf> xj = new HashMap();

    static {
        Wghm();
    }

    private static /* synthetic */ void Wghm() {
        char[] charArray = "`ln-dbnf-alz-pkfoo-ImjAqjgdf".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 3);
        }
        String str = new String(charArray);
        char[] charArray2 = "`ojmjw".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 3);
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
