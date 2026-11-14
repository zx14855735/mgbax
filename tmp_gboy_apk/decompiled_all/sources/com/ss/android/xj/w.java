package com.ss.android.xj;

import com.bytedance.sdk.component.utils.pl;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w {
    private static final char[] xj = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static class xj {
        private int hf;
        private String kd;
        private long u;
        private int w;
        private int xj;

        private xj() {
        }
    }

    private static String hf(File file, int i, long j) {
        return xj(new com.ss.android.xj.xj(file), i, j);
    }

    public static String xj(File file) {
        return xj(file, 9, 8192L);
    }

    private static long hf(String str) {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static String xj(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return hf(file, i, j);
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return "";
    }

    public static int xj(String str, File file) {
        return xj(str, file, (hf) null);
    }

    public static int xj(String str, File file, hf hfVar) {
        int i;
        long j;
        String str2;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (hfVar != null) {
                if (hfVar.xj() <= 0) {
                    try {
                        hfVar.hf();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                xj xj2 = xj(str);
                if (xj2 == null) {
                    i = -1;
                    j = -1;
                } else {
                    if (xj2.xj > 1) {
                        return 3;
                    }
                    i = xj2.w;
                    j = xj2.u;
                }
                xj xjVar = null;
                try {
                    if (hfVar != null) {
                        str2 = xj(hfVar, i, j);
                    } else {
                        str2 = hf(file, i, j);
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    if (xj2 != null && (xj2.xj != 1 || xj2.hf != 1)) {
                        if (xj2.kd != null) {
                            try {
                                xjVar = xj(str2);
                            } catch (Throwable unused2) {
                            }
                            if (xjVar != null && xj2.w == xjVar.w && xj2.u == xjVar.u && xj2.kd.equals(xjVar.kd)) {
                                return 0;
                            }
                        }
                    }
                    return str2.equals(str) ? 0 : 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(6:13|14|(3:16|(1:18)|19)|(1:21)|22|(4:31|33|34|35)(3:26|27|28))|38|14|(0)|(0)|22|(1:24)|31|33|34|35) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[Catch: all -> 0x002c, TryCatch #2 {all -> 0x002c, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x0030, B:16:0x003e, B:18:0x004b, B:21:0x005a, B:22:0x0061, B:31:0x0073), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[Catch: all -> 0x002c, TryCatch #2 {all -> 0x002c, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x0030, B:16:0x003e, B:18:0x004b, B:21:0x005a, B:22:0x0061, B:31:0x0073), top: B:5:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String xj(com.ss.android.xj.hf r16, int r17, long r18) {
        /*
            r0 = r17
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r1)
            if (r3 != 0) goto Ld
            java.lang.String r0 = ""
            return r0
        Ld:
            long r9 = r16.xj()     // Catch: java.lang.Throwable -> L2c
            r11 = 0
            r1 = 1
            if (r0 <= 0) goto L2e
            int r2 = (r18 > r11 ? 1 : (r18 == r11 ? 0 : -1))
            if (r2 <= 0) goto L2e
            long r4 = (long) r0     // Catch: java.lang.Throwable -> L2c
            long r4 = r4 * r18
            r6 = 8
            long r6 = r6 * r9
            r13 = 10
            long r6 = r6 / r13
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L29
            goto L2e
        L29:
            r7 = r18
            goto L30
        L2c:
            r0 = move-exception
            goto L8f
        L2e:
            r7 = r9
            r0 = 1
        L30:
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r2]     // Catch: java.lang.Throwable -> L2c
            r5 = 0
            r2 = r16
            xj(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L2c
            r2 = 2
            if (r0 <= r2) goto L58
            long r5 = (long) r0     // Catch: java.lang.Throwable -> L2c
            long r5 = r5 * r7
            long r5 = r9 - r5
            int r13 = r0 + (-1)
            long r14 = (long) r13     // Catch: java.lang.Throwable -> L2c
            long r14 = r5 / r14
            r2 = 1
        L49:
            if (r2 >= r13) goto L58
            long r5 = r7 + r14
            long r5 = r5 + r11
            r11 = r2
            r2 = r16
            xj(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L2c
            int r2 = r11 + 1
            r11 = r5
            goto L49
        L58:
            if (r0 <= r1) goto L61
            long r5 = r9 - r7
            r2 = r16
            xj(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L2c
        L61:
            byte[] r2 = r3.digest()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = xj(r2)     // Catch: java.lang.Throwable -> L2c
            if (r0 != r1) goto L73
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 != 0) goto L73
            r16.hf()     // Catch: java.lang.Throwable -> L72
        L72:
            return r2
        L73:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2c
            r1.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = xj(r0, r7)     // Catch: java.lang.Throwable -> L2c
            r1.append(r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = ";"
            r1.append(r0)     // Catch: java.lang.Throwable -> L2c
            r1.append(r2)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L2c
            r16.hf()     // Catch: java.lang.Throwable -> L8e
        L8e:
            return r0
        L8f:
            r16.hf()     // Catch: java.lang.Throwable -> L92
        L92:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.xj.w.xj(com.ss.android.xj.hf, int, long):java.lang.String");
    }

    private static void xj(hf hfVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) {
        hfVar.xj(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int xj2 = hfVar.xj(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (xj2 > 0) {
                messageDigest.update(bArr, 0, xj2);
                j3 += xj2;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + xj2 + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
        }
    }

    private static String xj(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length * 2;
            char[] cArr = new char[length];
            int i = 0;
            for (byte b : bArr) {
                int i2 = i + 1;
                char[] cArr2 = xj;
                cArr[i] = cArr2[(b & 255) >> 4];
                i += 2;
                cArr[i2] = cArr2[b & 15];
            }
            return new String(cArr, 0, length);
        }
        throw new NullPointerException("bytes is null");
    }

    private static String xj(int i, long j) {
        return "ttmd5:1:1:" + xj(i) + "g" + xj(j);
    }

    private static xj xj(String str) {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] split = str.split(";");
        String[] split2 = split[0].split(":");
        xj xjVar = new xj();
        xjVar.xj = Integer.parseInt(split2[1]);
        if (xjVar.xj > 1) {
            return xjVar;
        }
        xjVar.hf = Integer.parseInt(split2[2]);
        String[] split3 = split2[3].split("g");
        xjVar.w = (int) hf(split3[0]);
        xjVar.u = hf(split3[1]);
        xjVar.kd = split[1];
        return xjVar;
    }

    private static String xj(long j) {
        return Long.toHexString((j << 4) + 31);
    }
}
