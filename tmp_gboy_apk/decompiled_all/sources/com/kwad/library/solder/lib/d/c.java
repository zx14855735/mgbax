package com.kwad.library.solder.lib.d;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.utils.w;
import com.sigmob.sdk.downloader.f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c {
    public static File a(File file, String str, File file2) {
        String Cd = a.Cd();
        if (!TextUtils.isEmpty(Cd)) {
            StringBuilder sb = new StringBuilder("lib");
            String str2 = File.separator;
            File file3 = new File(file, A2egSU.AzWtSf(sb, str2, Cd, str2, str));
            if (file3.exists()) {
                File file4 = new File(file2, str);
                if (!file3.renameTo(file4)) {
                    throw new IOException("Rename soLib fail.");
                }
                file3.getAbsolutePath();
                file4.getAbsolutePath();
                return file4;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static Set<String> b(File file, File file2) {
        ZipFile zipFile;
        OutputStream outputStream;
        ZipFile zipFile2;
        ZipFile zipFile3;
        ?? r7;
        if (file == null || !file.exists()) {
            throw new IOException("Apk file not found.");
        }
        HashSet hashSet = new HashSet(4);
        w.Y(file2);
        file2.getAbsolutePath();
        file.getName();
        ZipFile zipFile4 = null;
        try {
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                outputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        String name = nextElement.getName();
                        if (name != null && !name.contains("../")) {
                            if (!name.startsWith("lib" + File.separator)) {
                                continue;
                            } else if (nextElement.isDirectory()) {
                                File file3 = new File(file2, name);
                                file3.getAbsolutePath();
                                w.Y(file3);
                            } else {
                                File file4 = new File(file2, name);
                                file4.getAbsolutePath();
                                w.Z(file4);
                                byte[] bArr = new byte[f.a.c];
                                FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                try {
                                    FileDescriptor fd = fileOutputStream.getFD();
                                    OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                    try {
                                        r7 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                        while (true) {
                                            try {
                                                int read = r7.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, read);
                                            } catch (IOException e) {
                                                e = e;
                                                zipFile4 = zipFile;
                                                outputStream = bufferedOutputStream;
                                                zipFile2 = r7;
                                                try {
                                                    com.kwad.library.solder.lib.a.e("plugin.so", e);
                                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipFile = zipFile4;
                                                    zipFile4 = zipFile2;
                                                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) zipFile4);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                zipFile4 = r7;
                                                outputStream = bufferedOutputStream;
                                                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) zipFile4);
                                                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                                                com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                throw th;
                                            }
                                        }
                                        bufferedOutputStream.flush();
                                        fd.sync();
                                        com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r7);
                                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                                        hashSet.add(file4.getName());
                                        zipFile4 = r7;
                                        outputStream = bufferedOutputStream;
                                    } catch (IOException e2) {
                                        e = e2;
                                        r7 = zipFile4;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    outputStream = fileOutputStream;
                                    zipFile3 = zipFile4;
                                    zipFile4 = zipFile;
                                    zipFile2 = zipFile3;
                                    com.kwad.library.solder.lib.a.e("plugin.so", e);
                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                } catch (Throwable th4) {
                                    th = th4;
                                    outputStream = fileOutputStream;
                                }
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) zipFile4);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                return hashSet;
            } catch (IOException e5) {
                e = e5;
                outputStream = null;
                zipFile3 = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
            }
        } catch (IOException e6) {
            e = e6;
            outputStream = null;
            zipFile2 = null;
        } catch (Throwable th7) {
            th = th7;
            zipFile = null;
            outputStream = null;
        }
    }
}
