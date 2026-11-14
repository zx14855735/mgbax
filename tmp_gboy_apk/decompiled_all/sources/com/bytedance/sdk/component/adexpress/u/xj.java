package com.bytedance.sdk.component.adexpress.u;

import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.archives.tar.e;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static final byte[] xj = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] hf = {97, 99, 84, e.P};

    public static boolean xj(byte[] bArr) {
        try {
        } catch (Throwable th) {
            pl.xj(th);
        }
        if (!xj(bArr, xj)) {
            return false;
        }
        int i = 8;
        while (i >= 0) {
            if (i + 12 > bArr.length) {
                break;
            }
            int xj2 = xj(bArr, i);
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i + 4, bArr2, 0, 4);
            int i2 = i + 8;
            if (Arrays.equals(bArr2, hf)) {
                return true;
            }
            i = i2 + xj2 + 4;
        }
        return false;
    }

    private static boolean xj(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int xj(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
