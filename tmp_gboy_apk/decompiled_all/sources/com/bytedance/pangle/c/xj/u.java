package com.bytedance.pangle.c.xj;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.c;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static kd xj(File file) {
        ZipFile zipFile;
        xj xjVar;
        PackageInfo packageInfo;
        int hf;
        int i;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                c.xj((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    c.xj(zipFile2);
                    return null;
                }
                xjVar = new xj();
                try {
                    xjVar.xj(zipFile2.getInputStream(entry));
                    do {
                        hf = xjVar.hf();
                        if (hf == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                xjVar.xj();
                            } catch (Throwable unused) {
                            }
                            c.xj(zipFile2);
                            return null;
                        }
                    } while (hf != 2);
                    int w = xjVar.w();
                    String str = null;
                    String str2 = null;
                    for (int i2 = 0; i2 != w; i2++) {
                        if ("versionCode".equals(xjVar.xj(i2))) {
                            str = xj(xjVar, i2);
                        } else if ("package".equals(xjVar.xj(i2))) {
                            str2 = xj(xjVar, i2);
                        }
                    }
                    try {
                        i = Integer.parseInt(str);
                    } catch (Throwable unused2) {
                        i = -1;
                    }
                    if (i == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(str)));
                        try {
                            xjVar.xj();
                        } catch (Throwable unused3) {
                        }
                        c.xj(zipFile2);
                        return null;
                    }
                    kd kdVar = new kd(str2, i);
                    try {
                        xjVar.xj();
                    } catch (Throwable unused4) {
                    }
                    c.xj(zipFile2);
                    return kdVar;
                } catch (Throwable th) {
                    zipFile = zipFile2;
                    th = th;
                    try {
                        packageInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                    } catch (Throwable unused5) {
                        packageInfo = null;
                    }
                    try {
                        if (packageInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            return null;
                        }
                        kd kdVar2 = new kd(packageInfo.packageName, packageInfo.versionCode);
                        if (xjVar != null) {
                            try {
                                xjVar.xj();
                            } catch (Throwable unused6) {
                            }
                        }
                        c.xj(zipFile);
                        return kdVar2;
                    } finally {
                        if (xjVar != null) {
                            try {
                                xjVar.xj();
                            } catch (Throwable unused7) {
                            }
                        }
                        c.xj(zipFile);
                    }
                }
            } catch (Throwable th2) {
                zipFile = zipFile2;
                th = th2;
                xjVar = null;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            xjVar = null;
        }
    }

    private static String xj(int i) {
        if ((i >>> 24) == 1) {
            return "android:";
        }
        return "";
    }

    private static String xj(xj xjVar, int i) {
        int hf = xjVar.hf(i);
        int w = xjVar.w(i);
        if (hf == 3) {
            return xjVar.u(i);
        }
        return hf == 2 ? String.format("?%s%08X", xj(w), Integer.valueOf(w)) : (hf < 16 || hf > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(w), Integer.valueOf(hf)) : String.valueOf(w);
    }
}
