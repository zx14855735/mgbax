package com.sigmob.sdk.archives.tar;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final int f13029a = 255;

    private f() {
    }

    public static int a(String str, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2 && i3 < str.length()) {
            bArr[i + i3] = (byte) str.charAt(i3);
            i3++;
        }
        while (i3 < i2) {
            bArr[i + i3] = 0;
            i3++;
        }
        return i + i2;
    }

    public static int b(long j, byte[] bArr, int i, int i2) {
        int i3 = i2 - 2;
        a(j, bArr, i, i3);
        bArr[i3 + i] = 32;
        bArr[(i2 - 1) + i] = 0;
        return i + i2;
    }

    public static int c(long j, byte[] bArr, int i, int i2) {
        int i3 = i2 - 1;
        a(j, bArr, i, i3);
        bArr[i3 + i] = 32;
        return i + i2;
    }

    public static int d(long j, byte[] bArr, int i, int i2) {
        int i3 = i2 - 2;
        a(j, bArr, i, i3);
        bArr[i3 + i] = 0;
        bArr[(i2 - 1) + i] = 32;
        return i + i2;
    }

    public static long a(byte[] bArr) {
        long j = 0;
        for (byte b : bArr) {
            j += b & 255;
        }
        return j;
    }

    public static String b(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2);
        int i3 = i2 + i;
        while (i < i3) {
            byte b = bArr[i];
            if (b == 0) {
                break;
            }
            stringBuffer.append((char) (b & 255));
            i++;
        }
        return stringBuffer.toString();
    }

    public static long a(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        if (i2 < 2) {
            throw new IllegalArgumentException(CtFAbx.ASJ6gh(i2, "Length ", " must be at least 2"));
        }
        int i4 = i;
        while (true) {
            long j = 0;
            if (i4 >= i3) {
                return 0L;
            }
            if (bArr[i4] != 0) {
                int i5 = i;
                while (i5 < i3 && bArr[i5] == 32) {
                    i5++;
                }
                int i6 = i3 - 1;
                byte b = bArr[i6];
                if (b != 0 && b != 32) {
                    throw new IllegalArgumentException(a(bArr, i, i2, i6, b));
                }
                int i7 = i3 - 1;
                byte b2 = bArr[i3 - 2];
                if (b2 == 0 || b2 == 32) {
                    i7 = i3 - 2;
                }
                while (i5 < i7) {
                    byte b3 = bArr[i5];
                    if (b3 < 48 || b3 > 55) {
                        throw new IllegalArgumentException(a(bArr, i, i2, i5, b3));
                    }
                    j = (j << 3) + (b3 - 48);
                    i5++;
                }
                return j;
            }
            i4++;
        }
    }

    private static String a(byte[] bArr, int i, int i2, int i3, byte b) {
        String replaceAll = new String(bArr, i, i2).replaceAll("\u0000", "{NUL}");
        StringBuilder B9tovu2 = A2egSU.B9tovu(b, "Invalid byte ", " at offset ");
        B9tovu2.append(i3 - i);
        B9tovu2.append(" in '");
        B9tovu2.append(replaceAll);
        B9tovu2.append("' len=");
        B9tovu2.append(i2);
        return B9tovu2.toString();
    }

    public static void a(long j, byte[] bArr, int i, int i2) {
        int i3;
        int i4 = i2 - 1;
        if (j == 0) {
            i3 = i2 - 2;
            bArr[i4 + i] = e.H;
        } else {
            long j2 = j;
            while (i4 >= 0 && j2 != 0) {
                bArr[i + i4] = (byte) (((byte) (7 & j2)) + e.H);
                j2 >>>= 3;
                i4--;
            }
            if (j2 != 0) {
                throw new IllegalArgumentException(j + "=" + Long.toOctalString(j) + " will not fit in octal number buffer of length " + i2);
            }
            i3 = i4;
        }
        while (i3 >= 0) {
            bArr[i + i3] = e.H;
            i3--;
        }
    }

    public static boolean a(byte[] bArr, int i) {
        return bArr[i] == 1;
    }
}
