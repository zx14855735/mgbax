package com.bytedance.adsdk.lottie.kd;

import com.bytedance.adsdk.lottie.p;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements p {
    private static final Set<String> xj = new HashSet();

    static {
        TUCWWoD();
    }

    private static /* synthetic */ void TUCWWoD() {
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

    @Override // com.bytedance.adsdk.lottie.p
    public void hf(String str, Throwable th) {
    }

    @Override // com.bytedance.adsdk.lottie.p
    public void xj(String str) {
        xj(str, null);
    }

    @Override // com.bytedance.adsdk.lottie.p
    public void xj(String str, Throwable th) {
        Set<String> set = xj;
        if (set.contains(str)) {
            return;
        }
        pl.hf("LOTTIE", str, th);
        set.add(str);
    }
}
