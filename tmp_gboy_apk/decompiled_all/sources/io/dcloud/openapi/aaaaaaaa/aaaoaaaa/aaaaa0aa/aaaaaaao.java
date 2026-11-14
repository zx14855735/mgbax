package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa;

import ADYaiT.CtFAbx;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import org.apache.commons.codec.CharEncoding;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaao {
    static final Charset aaaaaaaa = Charset.forName(CharEncoding.US_ASCII);
    static final Charset aaaaaaa0 = Charset.forName("UTF-8");

    static {
        EpYIH();
    }

    private static /* synthetic */ void EpYIH() {
        char[] charArray = "UY[\u0018QW[S\u0018TYO\u0018E^SZZ\u0018|X_tD_RQS".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '6');
        }
        String str = new String(charArray);
        char[] charArray2 = "UZ_X_B".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '6');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String aaaaaaaa(Reader reader) {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    String stringWriter2 = stringWriter.toString();
                    reader.close();
                    return stringWriter2;
                }
                stringWriter.write(cArr, 0, read);
            }
        } catch (Throwable th) {
            reader.close();
            throw th;
        }
    }

    public static void aaaaaaaa(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    aaaaaaaa(file2);
                }
                if (!file2.delete()) {
                    throw new IOException(CtFAbx.AYUAbz(file2, "failed to delete file: "));
                }
            }
            return;
        }
        throw new IOException(CtFAbx.AYUAbz(file, "not a readable directory: "));
    }

    public static void aaaaaaaa(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
