package com.bytedance.adsdk.ugeno.kd;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf {
    private static Map<String, c> xj = new HashMap();

    static {
        gxeE();
    }

    private static /* synthetic */ void gxeE() {
        char[] charArray = "\f\u0000\u0002A\b\u000e\u0002\nA\r\u0000\u0016A\u001c\u0007\n\u0003\u0003A%\u0001\u0006-\u001d\u0006\u000b\b\n".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'o');
        }
        String str = new String(charArray);
        char[] charArray2 = "\f\u0003\u0006\u0001\u0006\u001b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'o');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(List<c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (c cVar : list) {
            if (cVar != null) {
                xj.put(cVar.xj(), cVar);
            }
        }
    }

    public static c xj(String str) {
        return xj.get(str);
    }
}
