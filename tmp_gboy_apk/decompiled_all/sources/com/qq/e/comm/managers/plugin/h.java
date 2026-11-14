package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import com.sigmob.sdk.downloader.f;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class h {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final String f12962A2egSU = i.a("e_qq_com_plugin");

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final String f12963A4TApA = i.a("e_qq_com_dex");

    static {
        dXyglpn();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static String A2egSU(File file) {
        ?? r4;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                            }
                            return sb2;
                        } catch (IOException e) {
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        r4 = 0;
                        if (r4 != 0) {
                            try {
                                r4.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r4 = file;
            }
        }
        return null;
    }

    public static void A4TApA(Context context) {
        try {
            File ARc23Z2 = ARc23Z(context);
            if (new File(ARc23Z2, "disdoat").exists()) {
                return;
            }
            ADYaiT(context.getDir(f12963A4TApA, 0), false);
            ADYaiT(new File(ARc23Z2, "oat"), false);
        } catch (Throwable th) {
            GDTLogger.w(th.getMessage(), th);
        }
    }

    public static void A5SV6n(File file, String str) {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        OutputStreamWriter outputStreamWriter = null;
        try {
            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            try {
                outputStreamWriter2.write(str);
                a(outputStreamWriter2);
            } catch (Throwable th) {
                th = th;
                outputStreamWriter = outputStreamWriter2;
                a(outputStreamWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void ADYaiT(File file, boolean z) {
        File[] listFiles;
        if (file == null || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                ADYaiT(file2, true);
            } else {
                file2.delete();
            }
        }
        if (z) {
            file.delete();
        }
    }

    public static boolean AMqCpz(Context context, File file) {
        if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34) {
            return true;
        }
        return file.setReadOnly();
    }

    public static File ARc23Z(Context context) {
        return context.getDir(f12962A2egSU, 0);
    }

    public static File ASJ6gh(Context context) {
        return new File(ARc23Z(context), "gdt_plugin.jar");
    }

    public static boolean a(InputStream inputStream, File file) {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                GDTLogger.e("parent dir not exists " + parentFile.getAbsolutePath());
                return false;
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[f.a.d];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        a(inputStream);
                        a(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    GDTLogger.e("Exception while copy from InputStream to File", th);
                    throw th;
                } finally {
                    a(inputStream);
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b(Context context) {
        try {
            File file = new File(ARc23Z(context), "stub_ver");
            if (TextUtils.equals(A2egSU(file), SDKStatus.getSDKVersion())) {
                return;
            }
            A5SV6n(file, SDKStatus.getSDKVersion());
            A4TApA(context);
        } catch (Throwable th) {
            GDTLogger.w(th.getMessage(), th);
        }
    }

    private static /* synthetic */ void dXyglpn() {
        char[] charArray = "¸´¶õ¼º¶¾õ¹´¢õ¨³¾··õ\u0091µ²\u0099©²¿¼¾".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 219);
        }
        String str = new String(charArray);
        char[] charArray2 = "¸·²µ²¯".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 219);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean a(File file, File file2, Context context, boolean z) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            if (z) {
                return AMqCpz(context, file2);
            }
            return true;
        }
        try {
            boolean a2 = a(new FileInputStream(file), file2);
            if (!z) {
                return a2;
            }
            if (a2) {
                if (AMqCpz(context, file2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
