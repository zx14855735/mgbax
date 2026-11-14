package com.kwad.components.ad.feed.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.l;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static d hq = new d("feedAdClickGuideSwitch", false);
    public static l hr = new l("feedNativeRenderSwitch", 0);

    static {
        TXVvBzt();
    }

    private static /* synthetic */ void TXVvBzt() {
        char[] charArray = "IEG\u0004MKGO\u0004HES\u0004YBOFF\u0004`DChXCNMO".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '*');
        }
        String str = new String(charArray);
        char[] charArray2 = "IFCDC^".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '*');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }
}
