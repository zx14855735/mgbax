package L2suez;

import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.base.views.r;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class B3GDIM {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final String[] f4387A2egSU = {".shader", ".glsl", ".frag"};

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Object f4388A4TApA = new Object();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final Charset f4389A5SV6n = Charset.forName("UTF-8");

    static {
        XKIpbfQ();
    }

    public static void A2egSU(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static boolean A4TApA(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    String name = file2.getName();
                    if (name == null) {
                        continue;
                    } else {
                        String lowerCase = name.toLowerCase(Locale.ROOT);
                        String[] strArr = f4387A2egSU;
                        for (int i = 0; i < 3; i++) {
                            if (lowerCase.endsWith(strArr[i])) {
                                return true;
                            }
                        }
                    }
                } else if (A4TApA(file2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean A5SV6n(Context context, File file) {
        FileOutputStream fileOutputStream;
        Throwable th;
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            file.toString();
            return false;
        }
        try {
            if (ADYaiT(context, file) >= 0) {
                if (!TextUtils.isEmpty(null)) {
                    try {
                        fileOutputStream = new FileOutputStream(new File(file, ".shader_version"));
                        try {
                            throw null;
                        } catch (Throwable th2) {
                            th = th2;
                            A2egSU(fileOutputStream);
                            throw th;
                        }
                    } catch (IOException unused) {
                    } catch (Throwable th3) {
                        fileOutputStream = null;
                        th = th3;
                    }
                }
                file.getAbsolutePath();
                return true;
            }
        } catch (Exception unused2) {
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    public static int ADYaiT(Context context, File file) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Closeable closeable;
        ZipInputStream zipInputStream = null;
        try {
            inputStream = context.getAssets().open("shader.zip");
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(inputStream);
                try {
                    String str = file.getCanonicalPath() + File.separator;
                    byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
                    int i = 0;
                    while (true) {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            A2egSU(zipInputStream2);
                            A2egSU(inputStream);
                            return i;
                        }
                        String name = nextEntry.getName();
                        if (TextUtils.isEmpty(name)) {
                            zipInputStream2.closeEntry();
                        } else {
                            if (name.startsWith("/") || name.startsWith("\\")) {
                                name = name.substring(1);
                            }
                            File file2 = new File(file, name);
                            if (file2.getCanonicalPath().startsWith(str)) {
                                if (!nextEntry.isDirectory() && !name.endsWith("/") && !name.endsWith("\\")) {
                                    if (file2.exists() && file2.isFile()) {
                                        file2.getAbsolutePath();
                                        zipInputStream2.closeEntry();
                                    } else {
                                        File parentFile = file2.getParentFile();
                                        if (parentFile == null || parentFile.exists() || parentFile.mkdirs() || parentFile.exists()) {
                                            try {
                                                fileOutputStream = new FileOutputStream(file2);
                                                while (true) {
                                                    try {
                                                        try {
                                                            int read = zipInputStream2.read(bArr);
                                                            if (read == -1) {
                                                                break;
                                                            }
                                                            fileOutputStream.write(bArr, 0, read);
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            zipInputStream = fileOutputStream;
                                                            A2egSU(zipInputStream);
                                                            throw th;
                                                        }
                                                    } catch (IOException unused) {
                                                        file2.toString();
                                                        closeable = fileOutputStream;
                                                        A2egSU(closeable);
                                                        zipInputStream2.closeEntry();
                                                    }
                                                }
                                                fileOutputStream.flush();
                                                i++;
                                                closeable = fileOutputStream;
                                            } catch (IOException unused2) {
                                                fileOutputStream = 0;
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                            A2egSU(closeable);
                                            zipInputStream2.closeEntry();
                                        } else {
                                            parentFile.toString();
                                            zipInputStream2.closeEntry();
                                        }
                                    }
                                }
                                if (!file2.exists() && !file2.mkdirs() && !file2.exists()) {
                                    file2.toString();
                                }
                                zipInputStream2.closeEntry();
                            } else {
                                nextEntry.getName();
                                zipInputStream2.closeEntry();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream = zipInputStream2;
                    A2egSU(zipInputStream);
                    A2egSU(inputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    public static boolean AMqCpz(File file) {
        File[] listFiles;
        Throwable th;
        FileInputStream fileInputStream;
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0 || !A4TApA(file)) {
            return true;
        }
        if (TextUtils.isEmpty(null)) {
            return false;
        }
        File file2 = new File(file, ".shader_version");
        if (!file2.exists()) {
            throw null;
        }
        try {
            fileInputStream = new FileInputStream(file2);
        } catch (IOException unused) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[r.b.d];
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                new String(bArr, 0, read, f4389A5SV6n);
            }
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            th = th3;
            A2egSU(fileInputStream);
            throw th;
        }
        A2egSU(fileInputStream);
        throw null;
    }

    private static /* synthetic */ void XKIpbfQ() {
        char[] charArray = "COM\u000eGAME\u000eBOY\u000eSHELL\u000ejNIbRIDGE".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ' ');
        }
        String str = new String(charArray);
        char[] charArray2 = "CLINIT".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ' ');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
