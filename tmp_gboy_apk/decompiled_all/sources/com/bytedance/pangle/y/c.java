package com.bytedance.pangle.y;

import ADYaiT.CtFAbx;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {

    public static class xj extends File {
        public xj(File file, String str) {
            super(file, str);
        }
    }

    private static int hf(String str, int i) {
        return xj(CtFAbx.AcNBzu(str + "-" + i, ".dex.number"));
    }

    public static void xj(File file, String str, int i) {
        String str2 = ".dex";
        String str3 = "classes";
        if (!file.exists() || str == null) {
            throw new IOException("Could not check apk info " + file.getAbsolutePath());
        }
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ArrayList arrayList = new ArrayList();
                File file2 = new File(com.bytedance.pangle.kd.w.d(str, i));
                xj(file2);
                int i2 = 1;
                int i3 = 1;
                while (true) {
                    StringBuilder sb = new StringBuilder(str3);
                    Object obj = "";
                    sb.append(i3 == i2 ? "" : Integer.valueOf(i3));
                    sb.append(str2);
                    ZipEntry entry = zipFile2.getEntry(sb.toString());
                    if (entry == null) {
                        xj(str, i, file.getName(), arrayList);
                        com.bytedance.pangle.util.c.xj(zipFile2);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str3);
                    if (i3 != i2) {
                        obj = Integer.valueOf(i3);
                    }
                    sb2.append(obj);
                    sb2.append(str2);
                    xj xjVar = new xj(file2, sb2.toString());
                    int i4 = 0;
                    boolean z = false;
                    while (i4 < 3 && !z) {
                        try {
                            xj(zipFile2, entry, xjVar, str3);
                            z = true;
                        } catch (IOException e) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + xjVar.getAbsolutePath(), e);
                        }
                        i4++;
                        StringBuilder sb3 = new StringBuilder("Plugin-MultiDex Extraction ");
                        sb3.append(z ? "succeeded" : "failed");
                        sb3.append(" '");
                        sb3.append(xjVar.getAbsolutePath());
                        sb3.append("': length ");
                        String str4 = str2;
                        String str5 = str3;
                        sb3.append(xjVar.length());
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb3.toString());
                        if (!z) {
                            xjVar.delete();
                            if (xjVar.exists()) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + xjVar.getPath() + "'");
                            }
                        }
                        str2 = str4;
                        str3 = str5;
                    }
                    String str6 = str2;
                    String str7 = str3;
                    if (!z) {
                        throw new IOException("Could not create zip file " + xjVar.getAbsolutePath() + " for secondary dex (" + i3 + ")");
                    }
                    arrayList.add(xjVar);
                    i3++;
                    str2 = str6;
                    str3 = str7;
                    i2 = 1;
                }
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                com.bytedance.pangle.util.c.xj(zipFile);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String xj(String str, int i) {
        String ASJ6gh2;
        int hf = hf(str, i);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 <= hf; i2++) {
            if (i2 == 1) {
                ASJ6gh2 = "classes.dex";
            } else {
                ASJ6gh2 = CtFAbx.ASJ6gh(i2, "classes", ".dex");
            }
            sb.append(new xj(new File(com.bytedance.pangle.kd.w.d(str, i)), ASJ6gh2).getAbsolutePath());
            sb.append(":");
        }
        if (sb.length() != 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    private static void xj(ZipFile zipFile, ZipEntry zipEntry, xj xjVar, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), ".dex", xjVar.getParentFile());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(createTempFile));
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                if (createTempFile.setReadOnly()) {
                    if (createTempFile.renameTo(xjVar)) {
                        xj(inputStream);
                        createTempFile.delete();
                        return;
                    }
                    throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + xjVar.getAbsolutePath() + "\"");
                }
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + xjVar.getAbsolutePath() + "\")");
            } catch (Throwable th) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            xj(inputStream);
            createTempFile.delete();
            throw th2;
        }
    }

    private static void xj(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e);
        }
    }

    private static void xj(File file) {
        File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete old file " + file2.getPath());
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    private static void xj(String str, int i, String str2, List<xj> list) {
        String str3 = str + "-" + i;
        SharedPreferences.Editor edit = xj().edit();
        edit.putInt(CtFAbx.AcNBzu(str3, ".dex.number"), list.size());
        edit.commit();
    }

    private static SharedPreferences xj() {
        return Zeus.getAppApplication().getSharedPreferences("plugin-multidex.version", 0);
    }

    private static int xj(String str) {
        return xj().getInt(str, 0);
    }
}
