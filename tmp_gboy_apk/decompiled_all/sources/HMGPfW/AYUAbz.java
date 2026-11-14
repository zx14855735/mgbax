package HMGPfW;

import ADYaiT.CtFAbx;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import org.apache.commons.codec.CharEncoding;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Charset f3413A2egSU = Charset.forName(CharEncoding.US_ASCII);

    static {
        Charset.forName("UTF-8");
        bntsxP();
    }

    public static void A2egSU(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException(CtFAbx.AYUAbz(file, "not a readable directory: "));
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                A2egSU(file2);
            }
            if (!file2.delete()) {
                throw new IOException(CtFAbx.AYUAbz(file2, "failed to delete file: "));
            }
        }
    }

    private static /* synthetic */ void bntsxP() {
        char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 216);
        }
        String str = new String(charArray);
        char[] charArray2 = "»´±¶±¬".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 216);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
