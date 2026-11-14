package com.bytedance.sdk.component.p.kd;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static Map<String, Map<String, Object>> hf = new HashMap();
    private static volatile xj xj;

    static {
        hoijvEg();
    }

    private xj() {
    }

    private static /* synthetic */ void hoijvEg() {
        char[] charArray = "l`b!hnbj!m`v!|gjcc!EafM}fkhj".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 15);
        }
        String str = new String(charArray);
        char[] charArray2 = "lcfaf{".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 15);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static xj xj() {
        if (xj != null) {
            return xj;
        }
        synchronized (xj.class) {
            try {
                if (xj != null) {
                    return xj;
                }
                xj xjVar = new xj();
                xj = xjVar;
                return xjVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Map<String, Object> xj(String str) {
        Map<String, Object> map = hf.get(str);
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        hf.put(str, hashMap);
        return hashMap;
    }
}
