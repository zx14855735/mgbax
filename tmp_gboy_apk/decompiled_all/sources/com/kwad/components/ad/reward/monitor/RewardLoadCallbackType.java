package com.kwad.components.ad.reward.monitor;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum RewardLoadCallbackType implements a {
    LOAD_SUCCESS_BEFORE("load_success_before"),
    LOAD_SUCCESS(com.sigmob.sdk.base.common.a.x),
    LOAD_ERROR("load_error"),
    LOAD_CACHE_SUCCESS_BEFORE("load_cache_success_before"),
    LOAD_CACHE_SUCCESS("load_cache_success");

    private String typeValue;

    static {
        rMpuJE();
    }

    RewardLoadCallbackType(String str) {
        this.typeValue = str;
    }

    private static /* synthetic */ void rMpuJE() {
        char[] charArray = "åéë¨áçëã¨äéÿ¨õîãêê¨ÌèïÄôïâáã".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 134);
        }
        String str = new String(charArray);
        char[] charArray2 = "åêïèïò".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 134);
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
