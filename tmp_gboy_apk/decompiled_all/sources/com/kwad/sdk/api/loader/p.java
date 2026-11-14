package com.kwad.sdk.api.loader;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class p {
    public static int a(String str, InputStream inputStream, String str2) {
        try {
            boolean a2 = a(str, o.decrypt(str2.getBytes("UTF-8"), a(inputStream)));
            boolean a3 = a(inputStream, str, true);
            if (a2 && a3) {
                return 1;
            }
            return a2 ? -104 : -103;
        } catch (UnsupportedEncodingException unused) {
            return -102;
        }
    }

    public static String bk(Context context) {
        q Fb = r.Fb();
        if (Fb != null) {
            return Fb.getAESKey(context);
        }
        return null;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static int f(byte[] bArr) {
        int i = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
        PrintStream printStream = System.out;
        Integer.toHexString(i);
        printStream.getClass();
        return i;
    }

    private static byte[] a(InputStream inputStream) {
        try {
            byte[] bArr = new byte[4];
            inputStream.read(bArr, 0, 4);
            int f = f(bArr);
            byte[] bArr2 = new byte[f];
            if (inputStream.read(bArr2, 0, f) > 0) {
                System.out.getClass();
                return bArr2;
            }
            System.out.getClass();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                file.setWritable(true);
                file.setReadable(true);
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            fileOutputStream.write(bArr);
            System.out.getClass();
            closeQuietly(fileOutputStream);
            return true;
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            closeQuietly(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            closeQuietly(fileOutputStream2);
            throw th;
        }
    }

    private static boolean a(InputStream inputStream, String str, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str, true);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    System.out.getClass();
                    closeQuietly(fileOutputStream);
                    return true;
                }
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            closeQuietly(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            closeQuietly(fileOutputStream2);
            throw th;
        }
    }
}
