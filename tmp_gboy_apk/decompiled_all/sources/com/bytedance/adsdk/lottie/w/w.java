package com.bytedance.adsdk.lottie.w;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum w {
    JSON(".json"),
    ZIP(".zip");

    public final String w;

    static {
        XUWcK();
    }

    w(String str) {
        this.w = str;
    }

    private static /* synthetic */ void XUWcK() {
        char[] charArray = "ÌÀÂ\u0081ÈÎÂÊ\u0081ÍÀÖ\u0081ÜÇÊÃÃ\u0081åÁÆíÝÆËÈÊ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 175);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÌÃÆÁÆÛ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 175);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.w;
    }

    public String xj() {
        return ".temp" + this.w;
    }
}
