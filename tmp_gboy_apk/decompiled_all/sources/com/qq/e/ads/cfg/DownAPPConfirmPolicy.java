package com.qq.e.ads.cfg;

import java.lang.reflect.Method;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum DownAPPConfirmPolicy {
    Default(0),
    NOConfirm(2);


    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f12756AcNBzu;

    static {
        KxxCD();
    }

    DownAPPConfirmPolicy(int i) {
        this.f12756AcNBzu = i;
    }

    private static /* synthetic */ void KxxCD() {
        char[] charArray = "oca\"kmai\"ncu\"\u007fdi``\"FbeN~ehki".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\f');
        }
        String str = new String(charArray);
        char[] charArray2 = "o`ebex".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\f');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int value() {
        return this.f12756AcNBzu;
    }
}
