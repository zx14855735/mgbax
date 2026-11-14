package KpHwm4;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AcNBzu {
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0031: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:50), block:B:75:0x0031 */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Properties A2egSU(java.io.ByteArrayInputStream r11, java.lang.String r12) {
        /*
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            r1 = 0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            r3 = 2048(0x800, float:2.87E-42)
            r2.<init>(r11, r3)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            r11 = 256(0x100, float:3.59E-43)
            byte[] r3 = new byte[r11]     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r4 = 0
            r5 = 0
            r6 = 0
        L14:
            int r7 = r2.read()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r8 = 1
            r9 = -1
            r10 = 35
            if (r7 == r9) goto L74
            r9 = 10
            if (r7 == r9) goto L38
            r9 = 13
            if (r7 != r9) goto L27
            goto L38
        L27:
            if (r5 >= r11) goto L36
            int r8 = r5 + 1
            byte r7 = (byte) r7     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r3[r5] = r7     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r5 = r8
            goto L14
        L30:
            r11 = move-exception
            r1 = r2
            goto L92
        L34:
            r11 = move-exception
            goto L89
        L36:
            r5 = 0
            goto L14
        L38:
            if (r5 <= 0) goto L36
            r7 = r3[r4]     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r9 = 91
            if (r7 != r9) goto L6a
            r7 = 2
            if (r5 <= r7) goto L36
            int r7 = r5 + (-1)
            r7 = r3[r7]     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r9 = 93
            if (r7 != r9) goto L36
            if (r6 == 0) goto L4e
            goto L74
        L4e:
            int r6 = r12.length()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            int r7 = r6 + 2
            if (r5 == r7) goto L58
        L56:
            r8 = 0
            goto L68
        L58:
            r5 = 0
        L59:
            if (r5 >= r6) goto L68
            int r7 = r5 + 1
            r9 = r3[r7]     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            char r5 = r12.charAt(r5)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            if (r9 == r5) goto L66
            goto L56
        L66:
            r5 = r7
            goto L59
        L68:
            r6 = r8
            goto L36
        L6a:
            if (r6 == 0) goto L36
            if (r7 == r10) goto L36
            if (r5 <= r8) goto L36
            A4TApA(r0, r3, r5)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            goto L36
        L74:
            if (r5 <= 0) goto L81
            if (r6 == 0) goto L81
            r11 = r3[r4]     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            if (r11 == r10) goto L81
            if (r5 <= r8) goto L81
            A4TApA(r0, r3, r5)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
        L81:
            r2.close()     // Catch: java.io.IOException -> L84
        L84:
            return r0
        L85:
            r11 = move-exception
            goto L92
        L87:
            r11 = move-exception
            r2 = r1
        L89:
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L30
            if (r2 == 0) goto L91
            r2.close()     // Catch: java.io.IOException -> L91
        L91:
            return r1
        L92:
            if (r1 == 0) goto L97
            r1.close()     // Catch: java.io.IOException -> L97
        L97:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: KpHwm4.AcNBzu.A2egSU(java.io.ByteArrayInputStream, java.lang.String):java.util.Properties");
    }

    public static void A4TApA(Properties properties, byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= i) {
                i4 = -1;
                break;
            } else if (bArr[i4] == 61) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 <= 0 || i4 == i - 1) {
            return;
        }
        while (i3 < i4 && bArr[i3] == 32) {
            i3++;
        }
        int i5 = i4 - 1;
        while (i5 >= i3 && bArr[i5] == 32) {
            i5--;
        }
        do {
            i4++;
            if (i4 >= i) {
                break;
            }
        } while (bArr[i4] == 32);
        while (i2 >= i4 && bArr[i2] == 32) {
            i2--;
        }
        if (i3 > i5 || i4 > i2) {
            return;
        }
        Charset charset = StandardCharsets.US_ASCII;
        properties.setProperty(new String(bArr, i3, (i5 - i3) + 1, charset), new String(bArr, i4, (i2 - i4) + 1, charset));
    }
}
