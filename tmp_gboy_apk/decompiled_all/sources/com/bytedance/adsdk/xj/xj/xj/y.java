package com.bytedance.adsdk.xj.xj.xj;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class y extends kd {
    static final int xj = kd.xj("fcTL");
    byte am;
    int d;
    int f;
    byte g;
    int hf;
    short p;

    /* renamed from: pl, reason: collision with root package name */
    short f10098pl;
    int tf;
    int w;

    static {
        CILmjfm();
    }

    private static /* synthetic */ void CILmjfm() {
        char[] charArray = "ïãá¢ëíáé¢îãõ¢ÿäéàà¢ÆâåÎþåèëé".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 140);
        }
        String str = new String(charArray);
        char[] charArray2 = "ïàåâåø".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 140);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.kd
    public void xj(com.bytedance.adsdk.xj.xj.hf.xj xjVar) {
        this.hf = xjVar.hf();
        this.w = xjVar.hf();
        this.f = xjVar.hf();
        this.d = xjVar.hf();
        this.tf = xjVar.hf();
        this.p = xjVar.a_();
        this.f10098pl = xjVar.a_();
        this.g = xjVar.c_();
        this.am = xjVar.c_();
    }
}
