package com.sigmob.windad;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum WindAdBiddingLossReason {
    LOSS_REASON_LOW_PRICE(2, "出价过低"),
    LOSS_REASON_RETURN_TIMEOUT(2000, "返回超时"),
    LOSS_REASON_RETURN_ERROR(2001, "广告素材格式错误");


    /* renamed from: a, reason: collision with root package name */
    private final int f13780a;
    private final String message;

    static {
        qiviFvU();
    }

    WindAdBiddingLossReason(int i, String str) {
        this.f13780a = i;
        this.message = str;
    }

    private static /* synthetic */ void qiviFvU() {
        char[] charArray = "zvt7~xt|7{v`7jq|uu7Swp[kp}~|".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 25);
        }
        String str = new String(charArray);
        char[] charArray2 = "zupwpm".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 25);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int getCode() {
        return this.f13780a;
    }

    public String getMessage() {
        return this.message;
    }
}
