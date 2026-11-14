package com.game.boy;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class R$styleable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int[] f10881A2egSU = {2130969811};

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int[] f10882A4TApA = {2130968666, 2130968673, 2130968677, 2130968678};

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final int[] f10883A5SV6n = {2130969193, 2130969194, 2130969195, 2130969196};

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final int[] f10884ADYaiT = {2130969013, 2130969838};
    public static final int[] AMqCpz = {2130969938, 2130969941, 2130969942, 2130970109};

    static {
        yQPV();
    }

    private static /* synthetic */ void yQPV() {
        char[] charArray = "óÿý¾÷ñýõ¾òÿé¾ãøõüü¾ÚþùÒâùô÷õ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 144);
        }
        String str = new String(charArray);
        char[] charArray2 = "óüùþùä".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 144);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
