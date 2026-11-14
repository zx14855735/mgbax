package com.kwad.sdk.utils;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class w {
    public static final BigInteger bec;
    public static final BigInteger bed;
    public static final BigInteger bee;
    public static final BigInteger bef;
    public static final BigInteger beg;
    public static final BigInteger beh;
    public static final char bei;
    public static final BigInteger bej;
    public static final BigInteger bek;
    public static final File[] bel;
    public static final String bem;
    private static final char ben;

    static {
        BigInteger valueOf = BigInteger.valueOf(ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        bec = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        bed = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        bee = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        bef = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        beg = multiply4;
        beh = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS).multiply(BigInteger.valueOf(1152921504606846976L));
        bej = multiply5;
        bek = valueOf.multiply(multiply5);
        bel = new File[0];
        bem = Character.toString('.');
        ben = File.separatorChar;
        if (RQ()) {
            bei = '/';
        } else {
            bei = '\\';
            bdhs();
        }
    }

    private static void M(File file) {
        if (file.exists()) {
            if (!aa(file)) {
                N(file);
            }
            if (!file.delete()) {
                throw new IOException(A2egSU.AlLFFp("Unable to delete directory ", file, "."));
            }
        }
    }

    public static void N(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException(CtFAbx.AYUAbz(file, "Failed to list contents of "));
        }
        IOException e = null;
        for (File file2 : listFiles) {
            try {
                X(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static boolean O(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static boolean P(File file) {
        return file.exists();
    }

    private static FileInputStream Q(File file) {
        if (!file.exists()) {
            throw new FileNotFoundException(A2egSU.AlLFFp("File '", file, "' does not exist"));
        }
        if (file.isDirectory()) {
            throw new IOException(A2egSU.AlLFFp("File '", file, "' exists but is a directory"));
        }
        if (file.canRead()) {
            return new FileInputStream(file);
        }
        throw new IOException(A2egSU.AlLFFp("File '", file, "' cannot be read"));
    }

    private static FileOutputStream R(File file) {
        return a(file, false);
    }

    private static boolean RQ() {
        return ben == '\\';
    }

    public static void S(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException(A2egSU.AlLFFp("File '", file, "' exists but is a directory"));
            }
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            throw new IOException("Could not find parent directory");
        }
        if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException(A2egSU.AlLFFp("Directory '", parentFile, "' could not be created"));
        }
        file.createNewFile();
    }

    public static boolean T(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                N(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean U(File file) {
        return T(file);
    }

    public static byte[] V(File file) {
        return W(file).getBytes();
    }

    public static String W(File file) {
        return a(file, Charset.defaultCharset());
    }

    private static void X(File file) {
        if (file.isDirectory()) {
            M(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException(CtFAbx.AYUAbz(file, "File does not exist: "));
        }
        throw new IOException(CtFAbx.AYUAbz(file, "Unable to delete file: "));
    }

    public static void Y(File file) {
        if (file == null) {
            throw new IOException("Dir is null.");
        }
        if (!file.exists()) {
            file.mkdirs();
        } else {
            if (file.isDirectory()) {
                return;
            }
            if (!T(file)) {
                throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
            }
            file.mkdir();
        }
        if (file.exists() && file.isDirectory()) {
            return;
        }
        throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
    }

    public static void Z(File file) {
        T(file);
        s(file);
        if (!file.exists()) {
            throw new IOException("Create file fail");
        }
    }

    public static FileOutputStream a(File file, boolean z) {
        S(file);
        return new FileOutputStream(file, z);
    }

    private static boolean aa(File file) {
        ax.checkNotNull(file);
        if (RQ()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static boolean ab(File file) {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        e(file, file2);
        return T(file2);
    }

    private static void b(File file, File file2, boolean z) {
        ax.g(file, "Source");
        ax.g(file2, "Destination");
        if (!file.exists()) {
            throw new FileNotFoundException(A2egSU.AlLFFp("Source '", file, "' does not exist"));
        }
        if (file.isDirectory()) {
            throw new IOException(A2egSU.AlLFFp("Source '", file, "' exists but is a directory"));
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException(A2egSU.AlLFFp("Destination '", parentFile, "' directory cannot be created"));
        }
        if (file2.exists() && !file2.canWrite()) {
            throw new IOException(A2egSU.AlLFFp("Destination '", file2, "' exists but is read-only"));
        }
        c(file, file2, true);
    }

    private static /* synthetic */ void bdhs() {
        char[] charArray = "¡\u00ad¯ì¥£¯§ì \u00ad»ì±ª§®®ì\u0088¬«\u0080°«¦¥§".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 194);
        }
        String str = new String(charArray);
        char[] charArray2 = "¡®«¬«¶".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 194);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void c(File file, File file2, boolean z) {
        Throwable th;
        FileInputStream fileInputStream;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileChannel fileChannel3;
        long j;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException(A2egSU.AlLFFp("Destination '", file2, "' exists but is a directory"));
        }
        FileChannel fileChannel4 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileChannel2 = fileInputStream.getChannel();
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        try {
                            long size = fileChannel2.size();
                            for (long j2 = 0; j2 < size; j2 += channel.transferFrom(fileChannel2, j2, j)) {
                                j = size - j2;
                                if (j > 31457280) {
                                    j = 31457280;
                                }
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(channel);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                            if (file.length() != file2.length()) {
                                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                            }
                            if (z) {
                                file2.setLastModified(file.lastModified());
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileChannel4 = channel;
                            fileChannel3 = fileOutputStream;
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel4);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel3);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileChannel3 = fileOutputStream;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileChannel2 = null;
                    fileChannel3 = fileOutputStream;
                }
            } catch (Throwable th5) {
                th = th5;
                fileChannel = null;
                fileChannel2 = fileChannel;
                fileChannel3 = fileChannel;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel4);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel3);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
            fileChannel = null;
        }
    }

    private static void d(File file, File file2, boolean z) {
        a(file, file2, (FileFilter) null, true);
    }

    public static boolean delete(String str) {
        return T(new File(str));
    }

    public static void deleteContents(File file) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                file2.delete();
            }
        }
    }

    private static boolean e(File file, File file2) {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            f(file, file2);
            try {
                file.delete();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
            return false;
        }
    }

    public static void f(File file, File file2) {
        b(file, file2, true);
    }

    public static void g(File file, File file2) {
        d(file, file2, true);
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int hj = hj(str);
        return hj == -1 ? "" : str.substring(hj + 1);
    }

    public static BufferedInputStream hf(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        return new BufferedInputStream(fileInputStream);
    }

    public static boolean hg(String str) {
        return !TextUtils.isEmpty(str) && A2egSU.BPw6Q8(str);
    }

    public static boolean hh(String str) {
        return !TextUtils.isEmpty(str) && O(new File(str));
    }

    private static int hi(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    private static int hj(String str) {
        int lastIndexOf;
        if (str != null && hi(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    private static void s(File file) {
        if (!file.exists()) {
            com.kwad.sdk.crash.utils.b.closeQuietly(R(file));
        }
        if (!file.setLastModified(System.currentTimeMillis())) {
            throw new IOException(CtFAbx.AYUAbz(file, "Unable to set the last modification time for "));
        }
    }

    public static String R(Context context, String str) {
        return "/data/data/" + context.getPackageName() + "/" + str + "/";
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z) {
        ArrayList arrayList;
        File[] listFiles;
        ax.g(file, "Source");
        ax.g(file2, "Destination");
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath()) || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(listFiles.length);
                        for (File file3 : listFiles) {
                            arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                        }
                    }
                    a(file, file2, null, z, arrayList);
                    return;
                }
                throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
            }
            throw new IOException(A2egSU.AlLFFp("Source '", file, "' exists but is not a directory"));
        }
        throw new FileNotFoundException(A2egSU.AlLFFp("Source '", file, "' does not exist"));
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles != null) {
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    throw new IOException(A2egSU.AlLFFp("Destination '", file2, "' exists but is not a directory"));
                }
            } else if (!file2.mkdirs() && !file2.isDirectory()) {
                throw new IOException(A2egSU.AlLFFp("Destination '", file2, "' directory cannot be created"));
            }
            if (file2.canWrite()) {
                for (File file3 : listFiles) {
                    File file4 = new File(file2, file3.getName());
                    if (list == null || !list.contains(file3.getCanonicalPath())) {
                        if (file3.isDirectory()) {
                            a(file3, file4, fileFilter, z, list);
                        } else {
                            c(file3, file4, z);
                        }
                    }
                }
                if (z) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            throw new IOException(A2egSU.AlLFFp("Destination '", file2, "' cannot be written to"));
        }
        throw new IOException(CtFAbx.AYUAbz(file, "Failed to list contents of "));
    }

    private static void b(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = R(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            com.kwad.sdk.crash.utils.h.e(inputStream, fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            throw th;
        }
    }

    public static void a(Context context, String str, File file) {
        if (!TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                b(inputStream, file);
                return;
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }
        throw new IllegalArgumentException("Asset path is empty.");
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = Q(file);
            try {
                String a2 = com.kwad.sdk.crash.utils.h.a(fileInputStream, com.kwad.sdk.crash.utils.a.a(charset));
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                return a2;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = a(file, false);
            try {
                com.kwad.sdk.crash.utils.h.a(str, fileOutputStream, charset);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }
}
