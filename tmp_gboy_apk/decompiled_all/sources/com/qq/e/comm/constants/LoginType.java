package com.qq.e.comm.constants;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);


    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f12920AcNBzu;

    static {
        jxvtV();
    }

    LoginType(int i) {
        this.f12920AcNBzu = i;
        ordinal();
    }

    private static /* synthetic */ void jxvtV() {
        char[] charArray = "ýñó°ùÿóû°üñç°íöûòò°Ôð÷Üì÷úùû".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 158);
        }
        String str = new String(charArray);
        char[] charArray2 = "ýò÷ð÷ê".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 158);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int getValue() {
        return this.f12920AcNBzu;
    }
}
