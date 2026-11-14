package com.kwad.components.ad.reward.monitor;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum RewardInteractionCallbackType implements a {
    AD_CLICK("ad_click"),
    PAGE_DISMISS("page_close"),
    VIDEO_PLAY_ERROR("play_error"),
    VIDEO_PLAY_END("play_end"),
    VIDEO_SKIP_TO_END("skip_to_end"),
    VIDEO_PLAY_START("play_start"),
    REWARD_VERIFY(MediationConstant.REWARD_VERIFY),
    REWARD_STEP_VERIFY("reward_step_verify"),
    EXTRA_REWARD_VERIFY("extra_reward_verify");

    private String typeValue;

    static {
        vXal();
    }

    RewardInteractionCallbackType(String str) {
        this.typeValue = str;
    }

    private static /* synthetic */ void vXal() {
        char[] charArray = "ËÇÅ\u0086ÏÉÅÍ\u0086ÊÇÑ\u0086ÛÀÍÄÄ\u0086âÆÁêÚÁÌÏÍ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 168);
        }
        String str = new String(charArray);
        char[] charArray2 = "ËÄÁÆÁÜ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 168);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.kwad.components.ad.reward.monitor.a
    public final String getTypeValue() {
        return this.typeValue;
    }
}
