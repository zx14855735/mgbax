package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    private static volatile boolean hf;
    private static AtomicInteger w = new AtomicInteger(0);
    private static volatile d xj;

    static {
        wZiaeA();
    }

    private d() {
    }

    public static boolean hf() {
        return hf;
    }

    public static int w() {
        return w.get();
    }

    private static /* synthetic */ void wZiaeA() {
        char[] charArray = "6:8{2480{7:,{&=099{\u001f;<\u0017'<120".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'U');
        }
        String str = new String(charArray);
        char[] charArray2 = "69<;<!".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'U');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static d xj() {
        if (xj == null) {
            synchronized (d.class) {
                try {
                    if (xj == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            com.bytedance.sdk.openadsdk.x.y.xj("panglearmor");
                            hf = true;
                            w.set(1);
                        } catch (Throwable unused) {
                            hf = false;
                            w.set(2);
                        }
                        xj = new d();
                        long currentTimeMillis2 = System.currentTimeMillis();
                        f c = y.c();
                        if (c != null) {
                            c.xj(currentTimeMillis2 - currentTimeMillis, hf);
                        }
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public byte[] hf(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && hf) {
            try {
                return SoftDecTool.bc(AVMDLDataLoader.KeyIsGetCostLog, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public byte[] xj(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && hf) {
            try {
                return SoftDecTool.bc(1010, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public String xj(String str) {
        if (str != null && str.length() != 0 && hf) {
            try {
                byte[] hf2 = hf(Base64.decode(str, 0));
                if (hf2 != null) {
                    return new String(hf2);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
