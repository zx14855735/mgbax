package com.bytedance.embedapplog;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class vi {
    private static final lm xj = new lm();
    private static final Map<String, String> hf = new ConcurrentHashMap();

    static {
        ItUcRZl();
    }

    private static /* synthetic */ void ItUcRZl() {
        char[] charArray = "ÁÍÏ\u008cÅÃÏÇ\u008cÀÍÛ\u008cÑÊÇÎÎ\u008cèÌËàÐËÆÅÇ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 162);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÁÎËÌËÖ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 162);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String xj(String str) {
        Map<String, String> map = hf;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String xj2 = xj.xj(str);
        if (xj2 != null) {
            map.put(str, xj2);
        }
        return xj2;
    }
}
