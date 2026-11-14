package com.bytedance.sdk.component.adexpress.dynamic;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static int xj;
    public static final int hf = xj() + 33554432;
    public static final int w = xj() + 33554432;
    public static final int u = xj() + 33554432;
    public static final int kd = xj() + 33554432;
    public static final int y = xj() + 33554432;
    public static final int c = xj() + 33554432;
    public static final int f = xj() + 33554432;
    public static final int d = xj() + 33554432;
    public static final int tf = xj() + 33554432;
    public static final int p = xj() + 33554432;

    /* renamed from: pl, reason: collision with root package name */
    public static final int f10185pl = xj() + 33554432;
    public static final int g = xj() + 33554432;
    public static final int am = xj() + 33554432;
    public static final int qt = xj() + 33554432;
    public static final int zg = xj() + 33554432;
    public static final int e = xj() + 33554432;
    public static final int yo = xj() + 33554432;
    public static final int v = xj() + 33554432;
    public static final int jk = xj() + 33554432;
    public static final int pz = xj() + 33554432;
    public static final int ht = xj() + 33554432;
    public static final int ra = xj() + 33554432;

    static {
        Nvnu();
    }

    private static /* synthetic */ void Nvnu() {
        char[] charArray = "gki*ceia*fk}*wlahh*NjmFvm`ca".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 4);
        }
        String str = new String(charArray);
        char[] charArray2 = "ghmjmp".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 4);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int xj() {
        int i = xj;
        xj = i + 1;
        return i;
    }
}
