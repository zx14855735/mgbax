package com.kwad.components.ad.reward.model;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum EcOrderCardStyle {
    SPIKE_AND_COUPON(1),
    SPIKE(2),
    COUPON(3),
    NO_SPIKE_AND_NO_COUPON(4),
    DEFAULT(5);

    private int value;

    static {
        CMyue();
    }

    EcOrderCardStyle(int i) {
        this.value = i;
    }

    private static /* synthetic */ void CMyue() {
        char[] charArray = "\u0007\u000b\tJ\u0003\u0005\t\u0001J\u0006\u000b\u001dJ\u0017\f\u0001\b\bJ.\n\r&\u0016\r\u0000\u0003\u0001".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'd');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0007\b\r\n\r\u0010".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'd');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static EcOrderCardStyle createFromAdInfo(AdInfo adInfo) {
        if (!com.kwad.components.ad.reward.a.b.k(adInfo) && !com.kwad.components.ad.reward.a.b.j(adInfo)) {
            return null;
        }
        AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(adInfo);
        boolean hasSpike = cW.hasSpike();
        boolean hasCoupon = cW.hasCoupon();
        return (hasSpike && hasCoupon) ? SPIKE_AND_COUPON : hasSpike ? SPIKE : hasCoupon ? COUPON : cW.hasOriginalPrice() ? NO_SPIKE_AND_NO_COUPON : DEFAULT;
    }

    public final int getValue() {
        return this.value;
    }
}
