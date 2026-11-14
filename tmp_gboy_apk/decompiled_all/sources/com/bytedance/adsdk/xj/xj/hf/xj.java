package com.bytedance.adsdk.xj.xj.hf;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends kd {
    private static ThreadLocal<byte[]> hf = new ThreadLocal<>();

    static {
        mVobpcW();
    }

    public xj(y yVar) {
        super(yVar);
    }

    private static /* synthetic */ void mVobpcW() {
        char[] charArray = "846u<:6>u94\"u(3>77u\u001152\u0019)2?<>".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '[');
        }
        String str = new String(charArray);
        char[] charArray2 = "87252/".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '[');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static byte[] xj() {
        byte[] bArr = hf.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        hf.set(bArr2);
        return bArr2;
    }

    public short a_() {
        byte[] xj = xj();
        xj(xj, 0, 2);
        return (short) (((xj[0] & 255) << 8) | (xj[1] & 255));
    }

    public int b_() {
        byte[] xj = xj();
        xj(xj, 0, 4);
        return ((xj[3] & 255) << 24) | (xj[0] & 255) | ((xj[1] & 255) << 8) | ((xj[2] & 255) << 16);
    }

    public int hf() {
        byte[] xj = xj();
        xj(xj, 0, 4);
        return ((xj[0] & 255) << 24) | (xj[3] & 255) | ((xj[2] & 255) << 8) | ((xj[1] & 255) << 16);
    }

    public boolean xj(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int b_ = b_();
        for (int i = 0; i < 4; i++) {
            if (((b_ >> (i * 8)) & 255) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
