package com.alliance.ssp.ad.event;

import A5SV6n.A2egSU;
import java.lang.reflect.Method;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum AdnTypeEnum {
    YT_NON_BIDDING,
    YT_BIDDING,
    OTHER_ADN,
    DIRECT_ADVERTISER,
    OTHER;

    static {
        RoDSAFQ();
    }

    private static /* synthetic */ void RoDSAFQ() {
        char[] charArray = "s\u007f}>wq}u>r\u007fi>cxu||>Z~yRbytwu".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 16);
        }
        String str = new String(charArray);
        char[] charArray2 = "s|y~yd".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 16);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
