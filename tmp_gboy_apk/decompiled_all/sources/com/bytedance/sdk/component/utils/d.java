package com.bytedance.sdk.component.utils;

import com.fl.saas.common.util.FileTypeUtils;
import com.kwad.sdk.api.model.AdnName;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    private static final int c;
    private static final byte[] hf;
    private static final byte[] kd;
    private static final byte[] u;
    private static final byte[] w;
    private static final byte[] xj;
    private static final byte[] y;

    static {
        byte[] bArr = {-1, -40, -1};
        xj = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        hf = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        w = bArr3;
        byte[] xj2 = xj("BM");
        u = xj2;
        kd = xj("GIF87a");
        y = xj("GIF89a");
        c = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(xj2.length), 6))).intValue();
    }

    private static boolean hf(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = xj;
        return length >= bArr2.length && xj(bArr, bArr2);
    }

    private static boolean kd(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = u;
        return length >= bArr2.length && xj(bArr, bArr2);
    }

    private static boolean u(byte[] bArr) {
        return (bArr.length >= 6 && xj(bArr, kd)) || xj(bArr, y);
    }

    private static boolean w(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = hf;
        return length >= bArr2.length && xj(bArr, bArr2);
    }

    public static int xj() {
        return c;
    }

    private static boolean y(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = w;
        return length >= bArr2.length && xj(bArr, bArr2);
    }

    public static final String xj(byte[] bArr) {
        return hf(bArr) ? "jpeg" : w(bArr) ? FileTypeUtils.FILE_TYPE_PNG : u(bArr) ? "gif" : kd(bArr) ? FileTypeUtils.FILE_TYPE_BMP : y(bArr) ? "ico" : AdnName.OTHER;
    }

    private static boolean xj(byte[] bArr, byte[] bArr2) {
        return xj(bArr, bArr2, 0);
    }

    private static boolean xj(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] xj(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }
}
