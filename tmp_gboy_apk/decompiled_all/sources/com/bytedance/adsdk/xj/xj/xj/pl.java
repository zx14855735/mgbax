package com.bytedance.adsdk.xj.xj.xj;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class pl extends kd {
    static final int xj = kd.xj("IHDR");
    byte[] f = new byte[5];
    int hf;
    int w;

    static {
        invpkyO();
    }

    private static /* synthetic */ void invpkyO() {
        char[] charArray = "ãïí®çáíå®âïù®óèåìì®ÊîéÂòéäçå".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 128);
        }
        String str = new String(charArray);
        char[] charArray2 = "ãìéîéô".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 128);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.adsdk.xj.xj.xj.kd
    public void xj(com.bytedance.adsdk.xj.xj.hf.xj xjVar) {
        this.hf = xjVar.hf();
        this.w = xjVar.hf();
        byte[] bArr = this.f;
        xjVar.xj(bArr, 0, bArr.length);
    }
}
