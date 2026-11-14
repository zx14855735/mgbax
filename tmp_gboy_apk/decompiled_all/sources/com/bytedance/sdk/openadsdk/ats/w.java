package com.bytedance.sdk.openadsdk.ats;

import ADYaiT.BpkvW3;
import P8ccfD.AaHO0E;
import com.bytedance.sdk.openadsdk.core.ai;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class w implements Function<Object, Object> {
    private int w = ai.xj;
    private static List<Function> xj = new ArrayList();
    private static final xj hf = new xj();

    static {
        qrFlKIm();
    }

    private static /* synthetic */ void qrFlKIm() {
        char[] charArray = "ØÔÖ\u0095ÜÚÖÞ\u0095ÙÔÂ\u0095ÈÓÞ××\u0095ñÕÒùÉÒßÜÞ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 187);
        }
        String str = new String(charArray);
        char[] charArray2 = "Ø×ÒÕÒÏ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 187);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static <T> T xj(String str) {
        Object apply;
        T t = (T) hf.xj(str);
        if (t == null && xj.size() > 0) {
            Iterator<Function> it = xj.iterator();
            while (it.hasNext()) {
                apply = AaHO0E.AYUAbz(it.next()).apply(str);
                if (apply != null) {
                    return (T) hf.xj(str, apply);
                }
            }
        }
        return t;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (obj == null) {
            return Collections.unmodifiableMap(hf.xj());
        }
        if (BpkvW3.BmvVmW(obj)) {
            xj(AaHO0E.AYUAbz(obj));
            return null;
        }
        if (obj instanceof String) {
            return hf.xj(String.valueOf(obj));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(this.w);
        }
        return null;
    }

    private void xj(Function function) {
        Object apply;
        Object apply2;
        xj.add(function);
        apply = function.apply(null);
        if (apply instanceof Map) {
            apply2 = function.apply(0);
            int intValue = apply2 instanceof Integer ? ((Integer) apply2).intValue() : 0;
            for (Map.Entry entry : ((Map) apply).entrySet()) {
                hf.xj((String) entry.getKey(), entry.getValue(), intValue);
            }
        }
    }
}
