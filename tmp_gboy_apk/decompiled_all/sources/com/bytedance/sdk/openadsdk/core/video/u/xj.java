package com.bytedance.sdk.openadsdk.core.video.u;

import com.bytedance.sdk.openadsdk.zg.w.hf.am;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class xj {
    static final Map<Integer, WeakReference<am>> xj = new HashMap();

    static {
        rkEYpo();
    }

    private static /* synthetic */ void rkEYpo() {
        char[] charArray = "846u<:6>u94\"u(3>77u\u001152\u0019)2?<>".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '[');
        }
        String str = new String(charArray);
        char[] charArray2 = "87252/".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '[');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(Integer num, am amVar) {
        xj.put(num, new WeakReference<>(amVar));
    }

    public static am xj(Integer num) {
        WeakReference<am> weakReference = xj.get(num);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
