package com.kwad.components.ad.interstitial.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.l;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static l lL = new l("interstitialAdSkipCloseType", 0);
    public static l lM = new l("interstitialAdSkipCloseArea", 0);
    public static l lN = new l("interstitialAdFullClick", 1);
    public static l lO = new l("interstitialAdBackPressSwitch", 0);
    public static l lP = new l("interstitialPlayableTime", 999);
    public static l lQ = new l("interstitialAdClickShutDown", 0);
    public static d lR = new d("interstitialAutoStartSwitch", false);
    public static l lS = new l("ecInterstitialAdOrderSwitch", 0);
    public static l lT = new l("interstitialCycleAggregateMaxCount", 3);

    static {
        ueBquXR();
    }

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }

    private static /* synthetic */ void ueBquXR() {
        char[] charArray = "ÞÒÐ\u0093ÚÜÐØ\u0093ßÒÄ\u0093ÎÕØÑÑ\u0093÷ÓÔÿÏÔÙÚØ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 189);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÞÑÔÓÔÉ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 189);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
