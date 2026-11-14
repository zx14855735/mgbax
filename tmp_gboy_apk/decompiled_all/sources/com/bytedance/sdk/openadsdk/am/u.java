package com.bytedance.sdk.openadsdk.am;

import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum u {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI("wifi"),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN(MediationConfigUserInfoForSegment.GENDER_UNKNOWN);

    private String f;

    static {
        ZOQj();
    }

    u(String str) {
        this.f = str;
    }

    private static /* synthetic */ void ZOQj() {
        char[] charArray = "S_]\u001eWQ]U\u001eR_I\u001eCXU\\\\\u001ez^YrBYTWU".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '0');
        }
        String str = new String(charArray);
        char[] charArray2 = "S\\Y^YD".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '0');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f;
    }
}
