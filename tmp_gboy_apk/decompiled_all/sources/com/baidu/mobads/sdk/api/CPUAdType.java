package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum CPUAdType {
    FEED("feed"),
    INTERSTITIAL(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL),
    REWARDVIDEO(IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO),
    OTHER(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);

    private final String value;

    static {
        LGTDLHz();
    }

    CPUAdType(String str) {
        this.value = str;
    }

    private static /* synthetic */ void LGTDLHz() {
        char[] charArray = "§«©ê£¥©¡ê¦«½ê·¬¡¨¨ê\u008eª\u00ad\u0086¶\u00ad £¡".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 196);
        }
        String str = new String(charArray);
        char[] charArray2 = "§¨\u00adª\u00ad°".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 196);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static CPUAdType parse(String str) {
        for (CPUAdType cPUAdType : values()) {
            if (cPUAdType.value.equalsIgnoreCase(str)) {
                return cPUAdType;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }
}
