package com.tencent.mm.opensdk.diffdev;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum OAuthErrCode {
    WechatAuth_Err_OK(0),
    WechatAuth_Err_NormalErr(-1),
    WechatAuth_Err_NetworkErr(-2),
    WechatAuth_Err_JsonDecodeErr(-3),
    WechatAuth_Err_Cancel(-4),
    WechatAuth_Err_Timeout(-5),
    WechatAuth_Err_Auth_Stopped(-6);

    private int code;

    static {
        mYFt();
    }

    OAuthErrCode(int i) {
        this.code = i;
    }

    private static /* synthetic */ void mYFt() {
        char[] charArray = "\u0010\u001c\u001e]\u0014\u0012\u001e\u0016]\u0011\u001c\n]\u0000\u001b\u0016\u001f\u001f]9\u001d\u001a1\u0001\u001a\u0017\u0014\u0016".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 's');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0010\u001f\u001a\u001d\u001a\u0007".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 's');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "OAuthErrCode:" + this.code;
    }
}
