package com.bumptech.glide;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final AZOQYO f9929AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final AZOQYO f9930AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final AZOQYO f9931AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final AZOQYO f9932AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final /* synthetic */ AZOQYO[] f9933B25kr6;

    static {
        AZOQYO azoqyo = new AZOQYO("IMMEDIATE", 0);
        f9929AcNBzu = azoqyo;
        AZOQYO azoqyo2 = new AZOQYO("HIGH", 1);
        f9930AlLFFp = azoqyo2;
        AZOQYO azoqyo3 = new AZOQYO("NORMAL", 2);
        f9931AmA8tU = azoqyo3;
        AZOQYO azoqyo4 = new AZOQYO("LOW", 3);
        f9932AzWtSf = azoqyo4;
        f9933B25kr6 = new AZOQYO[]{azoqyo, azoqyo2, azoqyo3, azoqyo4};
        mNsyvH();
    }

    private static /* synthetic */ void mNsyvH() {
        char[] charArray = "ÝÑÓ\u0090ÙßÓÛ\u0090ÜÑÇ\u0090ÍÖÛÒÒ\u0090ôÐ×üÌ×ÚÙÛ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 190);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÝÒ×Ð×Ê".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 190);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static AZOQYO valueOf(String str) {
        return (AZOQYO) Enum.valueOf(AZOQYO.class, str);
    }

    public static AZOQYO[] values() {
        return (AZOQYO[]) f9933B25kr6.clone();
    }
}
