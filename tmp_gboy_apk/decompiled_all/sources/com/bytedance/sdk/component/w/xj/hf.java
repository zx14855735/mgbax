package com.bytedance.sdk.component.w.xj;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.CharEncoding;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class hf {
    private static final byte[] xj = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, com.sigmob.sdk.archives.tar.e.P, 77, 78, 79, 80, 81, 82, com.sigmob.sdk.archives.tar.e.Q, 84, 85, 86, 87, com.sigmob.sdk.archives.tar.e.S, 89, 90, 97, 98, 99, 100, 101, 102, com.sigmob.sdk.archives.tar.e.T, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, com.sigmob.sdk.archives.tar.e.R, 121, 122, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.N, com.sigmob.sdk.archives.tar.e.O, 56, 57, 43, 47};
    private static final byte[] hf = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, com.sigmob.sdk.archives.tar.e.P, 77, 78, 79, 80, 81, 82, com.sigmob.sdk.archives.tar.e.Q, 84, 85, 86, 87, com.sigmob.sdk.archives.tar.e.S, 89, 90, 97, 98, 99, 100, 101, 102, com.sigmob.sdk.archives.tar.e.T, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, com.sigmob.sdk.archives.tar.e.R, 121, 122, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.N, com.sigmob.sdk.archives.tar.e.O, 56, 57, 45, 95};

    public static String xj(byte[] bArr) {
        return xj(bArr, xj);
    }

    private static String xj(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
            int i3 = i2 + 1;
            bArr3[i + 1] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i3] & 255) >> 4)];
            int i4 = i + 3;
            int i5 = (bArr[i3] & 15) << 2;
            int i6 = i2 + 2;
            bArr3[i + 2] = bArr2[i5 | ((bArr[i6] & 255) >> 6)];
            i += 4;
            bArr3[i4] = bArr2[bArr[i6] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            bArr3[i + 1] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i + 2] = 61;
            bArr3[i + 3] = 61;
        } else if (length2 == 2) {
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i7 = (bArr[length] & 3) << 4;
            int i8 = length + 1;
            bArr3[i + 1] = bArr2[((bArr[i8] & 255) >> 4) | i7];
            bArr3[i + 2] = bArr2[(bArr[i8] & 15) << 2];
            bArr3[i + 3] = 61;
        }
        try {
            return new String(bArr3, CharEncoding.US_ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
