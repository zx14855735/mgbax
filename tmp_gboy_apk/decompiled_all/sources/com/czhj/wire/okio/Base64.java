package com.czhj.wire.okio;

import com.sigmob.sdk.archives.tar.e;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.CharEncoding;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class Base64 {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f10680a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, e.P, 77, 78, 79, 80, 81, 82, e.Q, 84, 85, 86, 87, e.S, 89, 90, 97, 98, 99, 100, 101, 102, e.T, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, e.R, 121, 122, e.H, e.I, e.J, e.K, e.L, e.M, e.N, e.O, 56, 57, 43, 47};
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, e.P, 77, 78, 79, 80, 81, 82, e.Q, 84, 85, 86, 87, e.S, 89, 90, 97, 98, 99, 100, 101, 102, e.T, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, e.R, 121, 122, e.H, e.I, e.J, e.K, e.L, e.M, e.N, e.O, 56, 57, 45, 95};

    private Base64() {
    }

    private static String a(byte[] bArr, byte[] bArr2) {
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

    public static byte[] decode(String str) {
        int i;
        char charAt;
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i2 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt2 = str.charAt(i6);
            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                i = charAt2 - 'A';
            } else if (charAt2 >= 'a' && charAt2 <= 'z') {
                i = charAt2 - 'G';
            } else if (charAt2 >= '0' && charAt2 <= '9') {
                i = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i = 63;
            } else {
                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                    return null;
                }
            }
            i4 = (i4 << 6) | ((byte) i);
            i3++;
            if (i3 % 4 == 0) {
                bArr[i5] = (byte) (i4 >> 16);
                int i7 = i5 + 2;
                bArr[i5 + 1] = (byte) (i4 >> 8);
                i5 += 3;
                bArr[i7] = (byte) i4;
            }
        }
        int i8 = i3 % 4;
        if (i8 == 1) {
            return null;
        }
        if (i8 == 2) {
            bArr[i5] = (byte) ((i4 << 12) >> 16);
            i5++;
        } else if (i8 == 3) {
            int i9 = i4 << 6;
            int i10 = i5 + 1;
            bArr[i5] = (byte) (i9 >> 16);
            i5 += 2;
            bArr[i10] = (byte) (i9 >> 8);
        }
        if (i5 == i2) {
            return bArr;
        }
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, 0, bArr2, 0, i5);
        return bArr2;
    }

    public static String encode(byte[] bArr) {
        return a(bArr, f10680a);
    }

    public static String encodeUrl(byte[] bArr) {
        return a(bArr, b);
    }
}
