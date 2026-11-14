package com.bykv.vk.component.ttvideo.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.hf;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class HardWareInfo {
    private static final int ATOM = 1;
    public static final int CPU_FAMILY_ARM = 1;
    public static final int CPU_FAMILY_MIPS = 3;
    public static final int CPU_FAMILY_UNKNOWN = 0;
    public static final int CPU_FAMILY_X86 = 2;
    private static final int NEON = 0;
    private static int[] mArmArchitecture = new int[3];
    private static int mCpuType;

    static {
        XdgReP();
    }

    private static /* synthetic */ void XdgReP() {
        char[] charArray = "&*(k\"$( k'*<k6- ))k\u000f+,\u00077,!\" ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'E');
        }
        String str = new String(charArray);
        char[] charArray2 = "&),+,1".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'E');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static long getAvailableStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryAvailableSize(hf.xj(context).getParent());
    }

    public static int[] getCpuArchitecture() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/cpuinfo");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.replace("\t", "").split(":");
                    if (split.length == 2) {
                        String trim = split[0].trim();
                        String trim2 = split[1].trim();
                        if (trim.compareTo("Processor") == 0) {
                            StringBuilder sb = new StringBuilder();
                            for (int indexOf = trim2.indexOf("ARMv") + 4; indexOf < trim2.length(); indexOf++) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(trim2.charAt(indexOf));
                                String sb3 = sb2.toString();
                                if (!sb3.matches("\\d")) {
                                    break;
                                }
                                sb.append(sb3);
                            }
                            int[] iArr = mArmArchitecture;
                            iArr[0] = 1;
                            iArr[1] = Integer.parseInt(sb.toString());
                        } else if (trim.compareToIgnoreCase("Features") == 0) {
                            if (trim2.contains("neon")) {
                                mArmArchitecture[2] = 0;
                            }
                        } else if (trim.compareToIgnoreCase("model name") == 0) {
                            if (trim2.contains("Intel")) {
                                int[] iArr2 = mArmArchitecture;
                                iArr2[0] = 2;
                                iArr2[2] = 1;
                            }
                        } else if (trim.compareToIgnoreCase("cpu family") == 0) {
                            mArmArchitecture[1] = Integer.parseInt(trim2);
                        }
                    }
                } catch (Throwable th) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    throw th;
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (Exception e) {
            pl.xj(e);
        }
        return mArmArchitecture;
    }

    public static int getCpuFamily() {
        if (mCpuType == 0) {
            getCpuInfo();
            mCpuType = mArmArchitecture[0];
        }
        return mCpuType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x006d, code lost:
    
        com.bykv.vk.component.ttvideo.utils.HardWareInfo.mArmArchitecture[0] = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] getCpuInfo() {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Exception -> Ld7
            java.lang.String r1 = "/proc/cpuinfo"
            r0.<init>(r1)     // Catch: java.lang.Exception -> Ld7
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> Ld7
            r1.<init>(r0)     // Catch: java.lang.Exception -> Ld7
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Exception -> Ld7
            r2.<init>(r1)     // Catch: java.lang.Exception -> Ld7
            java.lang.String r3 = "processor"
            java.lang.String r4 = "features"
            java.lang.String r5 = "model name"
        L17:
            java.lang.String r6 = r2.readLine()     // Catch: java.lang.Throwable -> L6b
            if (r6 == 0) goto Lc3
            java.lang.String r7 = "\t"
            java.lang.String r8 = ""
            java.lang.String r6 = r6.replaceAll(r7, r8)     // Catch: java.lang.Throwable -> L6b
            java.util.Locale r7 = java.util.Locale.US     // Catch: java.lang.Throwable -> L6b
            java.lang.String r6 = r6.toLowerCase(r7)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r7 = ":"
            java.lang.String[] r6 = r6.split(r7)     // Catch: java.lang.Throwable -> L6b
            int r7 = r6.length     // Catch: java.lang.Throwable -> L6b
            r8 = 2
            if (r7 != r8) goto L17
            r7 = 0
            r9 = r6[r7]     // Catch: java.lang.Throwable -> L6b
            java.lang.String r9 = r9.trim()     // Catch: java.lang.Throwable -> L6b
            r10 = 1
            r6 = r6[r10]     // Catch: java.lang.Throwable -> L6b
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L6b
            if (r6 == 0) goto L17
            if (r9 == 0) goto L17
            int r11 = r9.compareTo(r3)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r12 = "intel"
            if (r11 != 0) goto L72
            java.lang.String r9 = "armv"
            boolean r9 = r6.contains(r9)     // Catch: java.lang.Throwable -> L6b
            if (r9 != 0) goto L6d
            java.lang.String r9 = "aarch64"
            boolean r9 = r6.contains(r9)     // Catch: java.lang.Throwable -> L6b
            if (r9 == 0) goto L60
            goto L6d
        L60:
            boolean r6 = r6.contains(r12)     // Catch: java.lang.Throwable -> L6b
            if (r6 == 0) goto L17
            int[] r3 = com.bykv.vk.component.ttvideo.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> L6b
            r3[r7] = r8     // Catch: java.lang.Throwable -> L6b
            goto Lc3
        L6b:
            r3 = move-exception
            goto Lcd
        L6d:
            int[] r3 = com.bykv.vk.component.ttvideo.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> L6b
            r3[r7] = r10     // Catch: java.lang.Throwable -> L6b
            goto Lc3
        L72:
            int r11 = r9.compareToIgnoreCase(r4)     // Catch: java.lang.Throwable -> L6b
            if (r11 != 0) goto La6
            java.lang.String r8 = "neon"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> L6b
            if (r8 != 0) goto La0
            java.lang.String r8 = "thumb"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> L6b
            if (r8 != 0) goto La0
            java.lang.String r8 = "vfpv"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> L6b
            if (r8 != 0) goto La0
            java.lang.String r8 = "asimd"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> L6b
            if (r8 != 0) goto La0
            java.lang.String r8 = "simd"
            boolean r6 = r6.contains(r8)     // Catch: java.lang.Throwable -> L6b
            if (r6 == 0) goto L17
        La0:
            int[] r6 = com.bykv.vk.component.ttvideo.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> L6b
            r6[r7] = r10     // Catch: java.lang.Throwable -> L6b
            goto L17
        La6:
            int r9 = r9.compareToIgnoreCase(r5)     // Catch: java.lang.Throwable -> L6b
            if (r9 != 0) goto L17
            boolean r9 = r6.contains(r12)     // Catch: java.lang.Throwable -> L6b
            if (r9 == 0) goto Lb7
            int[] r3 = com.bykv.vk.component.ttvideo.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> L6b
            r3[r7] = r8     // Catch: java.lang.Throwable -> L6b
            goto Lc3
        Lb7:
            java.lang.String r8 = "arm"
            boolean r6 = r6.contains(r8)     // Catch: java.lang.Throwable -> L6b
            if (r6 == 0) goto L17
            int[] r3 = com.bykv.vk.component.ttvideo.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> L6b
            r3[r7] = r10     // Catch: java.lang.Throwable -> L6b
        Lc3:
            r2.close()     // Catch: java.lang.Exception -> Ld7
            r1.close()     // Catch: java.lang.Exception -> Ld7
            r0.close()     // Catch: java.lang.Exception -> Ld7
            goto Ldb
        Lcd:
            r2.close()     // Catch: java.lang.Exception -> Ld7
            r1.close()     // Catch: java.lang.Exception -> Ld7
            r0.close()     // Catch: java.lang.Exception -> Ld7
            throw r3     // Catch: java.lang.Exception -> Ld7
        Ld7:
            r0 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r0)
        Ldb:
            int[] r0 = com.bykv.vk.component.ttvideo.utils.HardWareInfo.mArmArchitecture
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.utils.HardWareInfo.getCpuInfo():int[]");
    }

    private static long getDirectoryAvailableSize(String str) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(str);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private static long getDirectoryTotalSize(String str) {
        long blockSize;
        long blockCount;
        try {
            StatFs statFs = new StatFs(str);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockSize * blockCount;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    public static long getProcessCpuInfo() {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            try {
                String readLine = bufferedReader2.readLine();
                bufferedReader2.close();
                String[] split = readLine.split(" ");
                try {
                    bufferedReader2.close();
                } catch (Exception e) {
                    pl.xj(e);
                }
                try {
                    return Long.parseLong(split[13]) + Long.parseLong(split[14]) + Long.parseLong(split[15]) + Long.parseLong(split[16]);
                } catch (ArrayIndexOutOfBoundsException unused) {
                    return 0L;
                }
            } catch (IOException unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                        pl.xj(e2);
                    }
                }
                return 0L;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                        pl.xj(e3);
                    }
                }
                throw th;
            }
        } catch (IOException unused3) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long[] getSDCardSize(Context context) {
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            long availableStorageSize = getAvailableStorageSize(context);
            jArr[0] = getTotalStorageSize(context);
            jArr[1] = availableStorageSize;
        }
        return jArr;
    }

    private static long getTotalStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryTotalSize(hf.xj(context).getParent());
    }

    private static boolean isAndroidJB2() {
        return true;
    }
}
