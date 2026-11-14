package io.dcloud.openapi.core.util;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.models.ClickCommon;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum AdType {
    AD_FULLSCREEN("full_screen_video"),
    AD_REWARD("rewarded"),
    AD_NONE(""),
    AD_SPLASH(MediationConstant.RIT_TYPE_SPLASH),
    AD_INTERSTITIAL(MediationConstant.RIT_TYPE_INTERSTITIAL),
    AD_DRAW("draw_flow"),
    AD_CONTENT_PAGE("content_page"),
    AD_TEMPLATE(ClickCommon.CLICK_SCENE_TEMPLATE);

    private String aaaaaaaa;

    static {
        XTRkFU();
    }

    AdType(String str) {
        this.aaaaaaaa = str;
    }

    private static /* synthetic */ void XTRkFU() {
        char[] charArray = "\u0016\u001a\u0018[\u0012\u0014\u0018\u0010[\u0017\u001a\f[\u0006\u001d\u0010\u0019\u0019[?\u001b\u001c7\u0007\u001c\u0011\u0012\u0010".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'u');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0016\u0019\u001c\u001b\u001c\u0001".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'u');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static AdType getAdType(String str) {
        for (AdType adType : values()) {
            if (adType.aaaaaaaa.equals(str)) {
                return adType;
            }
        }
        return AD_NONE;
    }

    public String getType() {
        return this.aaaaaaaa;
    }
}
