package com.bytedance.sdk.component.w.hf;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class zg {
    public static final zg xj = new zg() { // from class: com.bytedance.sdk.component.w.hf.zg.1
    };

    public interface xj {
        zg xj(kd kdVar);
    }

    static {
        UgmpoXd();
    }

    private static /* synthetic */ void UgmpoXd() {
        char[] charArray = "ÙÕ×\u0094ÝÛ×ß\u0094ØÕÃ\u0094ÉÒßÖÖ\u0094ðÔÓøÈÓÞÝß".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 186);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÙÖÓÔÓÎ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 186);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void xj(kd kdVar, IOException iOException) {
    }

    public void xj(kd kdVar, InetSocketAddress inetSocketAddress, Proxy proxy, dk dkVar, IOException iOException) {
    }

    public static xj xj(zg zgVar) {
        return new xj() { // from class: com.bytedance.sdk.component.w.hf.zg.2
            @Override // com.bytedance.sdk.component.w.hf.zg.xj
            public zg xj(kd kdVar) {
                return zg.this;
            }
        };
    }
}
