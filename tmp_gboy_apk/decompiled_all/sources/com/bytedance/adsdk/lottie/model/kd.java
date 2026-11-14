package com.bytedance.adsdk.lottie.model;

import com.bytedance.adsdk.lottie.am;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static final kd xj = new kd();
    private final am<String, com.bytedance.adsdk.lottie.y> hf = new am<>(20);

    static {
        UPpBhXs();
    }

    private static /* synthetic */ void UPpBhXs() {
        char[] charArray = ".\" c*, (c/\"4c>%(!!c\u0007#$\u000f?$)*(".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'M');
        }
        String str = new String(charArray);
        char[] charArray2 = ".!$#$9".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'M');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static kd xj() {
        return xj;
    }

    public com.bytedance.adsdk.lottie.y xj(String str) {
        if (str == null) {
            return null;
        }
        return this.hf.xj((am<String, com.bytedance.adsdk.lottie.y>) str);
    }

    public void xj(String str, com.bytedance.adsdk.lottie.y yVar) {
        if (str == null) {
            return;
        }
        this.hf.xj(str, yVar);
    }

    public void xj(int i) {
        this.hf.xj(i);
    }
}
