package com.kwad.components.ad.reward.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.h;
import com.kwad.sdk.core.config.item.l;
import com.kwad.sdk.core.config.item.s;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static l tv = new l("rewardSkipType", 0);
    public static l tw = new l("rewardActiveAppTaskMinSecond", 15);
    public static l tx = new l("rewardContentDetainType", 0);
    public static d ty = new d("forceGetAudioFocus", false);
    public static s tz = new s("rewardSkipTips", "");
    public static s tA = new s("fullscreenSkipTips", "");
    public static l tB = new l("ecRewardAdOrderSwitch", 0);
    public static l tC = new l("ecRewardAdFanSwitch", 0);
    public static l tD = new l("ecRewardAdKwaishopStyle", 0);
    public static l tE = new l("xdtCouponShowDuration", 3000);
    public static l tF = new l("jinniuCloseDialogStyle", 1);
    public static h tG = new h("interactionTimeInRewardedVideo", 0.0f);
    public static d tH = new d("autoJumpInRewardedVideo", false);
    public static l tI = new l("advanceJumpDirectDeliveryMaxCount", 0);
    public static d tJ = new d("advanceJumpDirectDeliverySwitch", false);
    public static l tK = new l("shortVideoFollowRewardPlayStyle", 0);
    public static d tL = new d("enableRewardLayoutOptimise", false);
    public static d tM = new d("enableFullscreenLayoutOptimise", false);

    static {
        iAjV();
    }

    private static /* synthetic */ void iAjV() {
        char[] charArray = "¹µ·ô½»·¿ô¸µ£ô©²¿¶¶ô\u0090´³\u0098¨³¾½¿".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 218);
        }
        String str = new String(charArray);
        char[] charArray2 = "¹¶³´³®".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 218);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }
}
