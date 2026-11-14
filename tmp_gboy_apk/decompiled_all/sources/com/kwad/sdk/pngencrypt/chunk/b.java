package com.kwad.sdk.pngencrypt.chunk;

import com.sigmob.sdk.downloader.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    public static final byte[] baF = gO("IHDR");
    public static final byte[] baG = gO("PLTE");
    public static final byte[] baH = gO("IDAT");
    public static final byte[] baI = gO("IEND");
    private static byte[] baJ = new byte[f.a.c];
    public static Pattern baK = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    static {
        QFxr();
    }

    private static /* synthetic */ void QFxr() {
        char[] charArray = "\u000e\u0002\u0000C\n\f\u0000\bC\u000f\u0002\u0014C\u001e\u0005\b\u0001\u0001C'\u0003\u0004/\u001f\u0004\t\n\b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'm');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000e\u0001\u0004\u0003\u0004\u0019".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'm');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static List<PngChunk> a(List<PngChunk> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (cVar.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    public static byte[] b(byte[] bArr, int i, int i2, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream3;
        InflaterInputStream inflaterInputStream;
        InflaterInputStream inflaterInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (Exception unused) {
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = null;
                }
            } catch (Exception unused2) {
                byteArrayOutputStream3 = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            }
            try {
                g(inflaterInputStream, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream);
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                return byteArray;
            } catch (Exception unused3) {
                inflaterInputStream2 = inflaterInputStream;
                byteArrayOutputStream3 = byteArrayOutputStream2;
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream2);
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream3);
                return new byte[0];
            } catch (Throwable th3) {
                th = th3;
                inflaterInputStream2 = inflaterInputStream;
                byteArrayOutputStream = byteArrayOutputStream2;
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream2);
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception unused4) {
            byteArrayOutputStream3 = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        }
    }

    public static String c(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.ban);
    }

    public static String d(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.bao);
    }

    private static void g(InputStream inputStream, OutputStream outputStream) {
        synchronized (baJ) {
            while (true) {
                try {
                    int read = inputStream.read(baJ);
                    if (read > 0) {
                        outputStream.write(baJ, 0, read);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static byte[] gO(String str) {
        return str.getBytes(com.kwad.sdk.pngencrypt.n.ban);
    }

    public static boolean gP(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static boolean gQ(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean gR(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }

    public static String h(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.ban);
    }

    public static String i(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.bao);
    }

    public static String i(byte[] bArr, int i) {
        return (bArr == null || bArr.length < 8) ? "?" : c(bArr, 4, 4);
    }
}
