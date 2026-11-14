package com.kwad.components.ad.fullscreen.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.l;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static l jy = new l("fullscreenSkipType", 0);
    public static l jz = new l("fullscreenSkipShowTime", 5);
    public static l jA = new l("fullScreenShakeMaxCount", 0);

    static {
        ngtE();
    }

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }

    private static /* synthetic */ void ngtE() {
        char[] charArray = "\u000e\u0002\u0000C\n\f\u0000\bC\u000f\u0002\u0014C\u001e\u0005\b\u0001\u0001C'\u0003\u0004/\u001f\u0004\t\n\b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'm');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000e\u0001\u0004\u0003\u0004\u0019".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'm');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
