package com.kwad.components.ad.splashscreen.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.l;
import com.kwad.sdk.core.config.item.s;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static l Gj = new l("splashTimeOutMilliSecond", 5000);
    public static s Gk = new s("splashTimerTips", "");
    public static s Gl = new s("splashBtnText", "点击跳转详情页或第三方应用");
    public static d Gm = new d("splashCropNewSwitch", true);
    public static d Gn = new d("splashAdLoadProcessChange", false);
    public static l Go = new l("splashMaterialDownloadTimeMs", 500);

    static {
        GkOT();
    }

    private static /* synthetic */ void GkOT() {
        char[] charArray = "íáã éïãë ìá÷ ýæëââ ÄàçÌüçêéë".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 142);
        }
        String str = new String(charArray);
        char[] charArray2 = "íâçàçú".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 142);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }
}
