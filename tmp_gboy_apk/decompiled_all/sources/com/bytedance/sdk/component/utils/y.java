package com.bytedance.sdk.component.utils;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {

    /* renamed from: com.bytedance.sdk.component.utils.y$1, reason: invalid class name */
    public static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long lastModified = file2.lastModified() - file.lastModified();
            if (lastModified == 0) {
                return 0;
            }
            return lastModified < 0 ? -1 : 1;
        }
    }

    public static final class xj implements Comparator<File> {
        private xj() {
        }

        private int xj(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        public /* synthetic */ xj(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return xj(file.lastModified(), file2.lastModified());
        }
    }

    public static File hf(Context context, boolean z, String str, String str2) {
        String w = w(context);
        if (z) {
            str = xj(context) + "-" + str;
        }
        if (w != null) {
            String str3 = File.separator;
            if (!w.endsWith(str3)) {
                w = CtFAbx.AcNBzu(w, str3);
            }
        }
        String AcNBzu2 = CtFAbx.AcNBzu(w, str);
        File file = new File(AcNBzu2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(AcNBzu2, str2);
    }

    private static void kd(File file) {
        RandomAccessFile randomAccessFile;
        long length = file.length();
        if (length == 0) {
            y(file);
            return;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            long j = length - 1;
            try {
                randomAccessFile.seek(j);
                byte readByte = randomAccessFile.readByte();
                randomAccessFile.seek(j);
                randomAccessFile.write(readByte);
                randomAccessFile.close();
            } catch (Throwable unused) {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r4 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] u(java.io.File r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L4a
            boolean r1 = r7.isFile()
            if (r1 == 0) goto L4a
            boolean r1 = r7.exists()
            if (r1 == 0) goto L4a
            boolean r1 = r7.canRead()
            if (r1 == 0) goto L4a
            long r1 = r7.length()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L4a
            long r1 = r7.length()     // Catch: java.lang.Throwable -> L45
            java.lang.Long r3 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L45
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L45
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L45
            int r7 = r3.intValue()     // Catch: java.lang.Throwable -> L43
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L43
            int r3 = r4.read(r7)     // Catch: java.lang.Throwable -> L43
            long r5 = (long) r3
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 != 0) goto L3f
            r4.close()     // Catch: java.lang.Throwable -> L3e
        L3e:
            return r7
        L3f:
            r4.close()     // Catch: java.lang.Throwable -> L4a
            goto L4a
        L43:
            goto L47
        L45:
            r4 = r0
        L47:
            if (r4 == 0) goto L4a
            goto L3f
        L4a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.y.u(java.io.File):byte[]");
    }

    private static String w(Context context) {
        File hf;
        if (context == null || (hf = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context)) == null) {
            return null;
        }
        return hf.getPath();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File xj(android.content.Context r1, boolean r2, java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = hf(r1)
            if (r2 == 0) goto L1f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = xj(r1)
            r2.append(r1)
            java.lang.String r1 = "-"
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            goto L29
        L1f:
            java.lang.String r1 = java.lang.String.valueOf(r3)
            java.lang.String r2 = "/"
            java.lang.String r1 = r2.concat(r1)
        L29:
            if (r0 == 0) goto L38
            java.lang.String r2 = java.io.File.separator
            boolean r3 = r0.endsWith(r2)
            if (r3 != 0) goto L38
            java.lang.String r2 = ADYaiT.CtFAbx.AcNBzu(r0, r2)
            goto L3a
        L38:
            java.lang.String r2 = ""
        L3a:
            java.lang.String r1 = ADYaiT.CtFAbx.AcNBzu(r2, r1)
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L4c
            r2.mkdirs()
        L4c:
            java.io.File r2 = new java.io.File
            r2.<init>(r1, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.y.xj(android.content.Context, boolean, java.lang.String, java.lang.String):java.io.File");
    }

    private static void y(File file) {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }

    public static void w(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        w(file2);
                    } else {
                        try {
                            file2.delete();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            file.delete();
        } catch (Throwable unused2) {
        }
    }

    public static File hf(Context context, boolean z, String str) {
        String absolutePath = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context).getAbsolutePath();
        if (z) {
            str = xj(context) + "-" + str;
        }
        if (absolutePath != null) {
            String str2 = File.separator;
            if (!absolutePath.endsWith(str2)) {
                absolutePath = CtFAbx.AcNBzu(absolutePath, str2);
            }
        }
        File file = new File(CtFAbx.AcNBzu(absolutePath, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File xj(android.content.Context r1, boolean r2, java.lang.String r3) {
        /*
            java.lang.String r0 = hf(r1)
            if (r2 == 0) goto L1e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = xj(r1)
            r2.append(r1)
            java.lang.String r1 = "-"
            r2.append(r1)
            r2.append(r3)
            java.lang.String r3 = r2.toString()
        L1e:
            if (r0 == 0) goto L2d
            java.lang.String r1 = java.io.File.separator
            boolean r2 = r0.endsWith(r1)
            if (r2 != 0) goto L2d
            java.lang.String r1 = ADYaiT.CtFAbx.AcNBzu(r0, r1)
            goto L2f
        L2d:
            java.lang.String r1 = ""
        L2f:
            java.lang.String r1 = ADYaiT.CtFAbx.AcNBzu(r1, r3)
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 != 0) goto L41
            r2.mkdirs()
        L41:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.y.xj(android.content.Context, boolean, java.lang.String):java.io.File");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (android.os.Environment.isExternalStorageRemovable() == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String hf(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            r1 = 0
            java.lang.String r2 = "mounted"
            java.lang.String r3 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Throwable -> L18
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L18
            if (r2 != 0) goto L1a
            boolean r2 = android.os.Environment.isExternalStorageRemovable()     // Catch: java.lang.Throwable -> L18
            if (r2 != 0) goto L1f
            goto L1a
        L18:
            r2 = move-exception
            goto L1c
        L1a:
            r1 = 1
            goto L1f
        L1c:
            com.bytedance.sdk.component.utils.pl.xj(r2)
        L1f:
            if (r1 == 0) goto L29
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.hf.w(r4)     // Catch: java.lang.Throwable -> L26
            goto L2a
        L26:
            r1 = r0
            goto L32
        L29:
            r1 = r0
        L2a:
            if (r1 != 0) goto L32
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(r4)     // Catch: java.lang.Throwable -> L31
            goto L32
        L31:
        L32:
            if (r1 != 0) goto L35
            return r0
        L35:
            java.lang.String r4 = r1.getPath()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.y.hf(android.content.Context):java.lang.String");
    }

    public static List<File> xj(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new xj(null));
        return asList;
    }

    public static void hf(File file) {
        if (file.exists()) {
            pl.u("splashLoadAd", "update file modify time");
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            kd(file);
            if (file.lastModified() < currentTimeMillis) {
                pl.hf("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }

    public static String xj(Context context) {
        String xj2 = yo.xj(context);
        return (TextUtils.isEmpty(xj2) || !xj2.contains(":")) ? xj2 : xj2.replace(":", "-");
    }
}
