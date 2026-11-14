package com.kwad.components.ad.reward.monitor;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum LivePlayMonitorType {
    AD_LIVE_IMPL_LOAD_ERROR(1),
    LIVE_PLAY_MODULE_RELEASE_INNER_EXCEPTION(9);

    private int type;

    static {
        VfpJ();
    }

    LivePlayMonitorType(int i) {
        this.type = i;
    }

    private static /* synthetic */ void VfpJ() {
        char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 216);
        }
        String str = new String(charArray);
        char[] charArray2 = "»´±¶±¬".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 216);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final int getValue() {
        return this.type;
    }
}
