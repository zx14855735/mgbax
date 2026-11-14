package com.bytedance.msdk.f;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class jk {
    private static Map<Integer, Integer> xj = new ConcurrentHashMap();

    static {
        LsHLueB();
    }

    private static /* synthetic */ void LsHLueB() {
        char[] charArray = "\u008c\u0080\u0082Á\u0088\u008e\u0082\u008aÁ\u008d\u0080\u0096Á\u009c\u0087\u008a\u0083\u0083Á¥\u0081\u0086\u00ad\u009d\u0086\u008b\u0088\u008a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 239);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008c\u0083\u0086\u0081\u0086\u009b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 239);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static Integer xj(int i) {
        Integer num = xj.get(Integer.valueOf(i));
        if (num != null) {
            return num;
        }
        Integer valueOf = Integer.valueOf(i);
        xj.put(Integer.valueOf(i), valueOf);
        return valueOf;
    }
}
