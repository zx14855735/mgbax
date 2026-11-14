package KpHwm4;

import android.os.Environment;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final File f4293A2egSU = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "GBoy");

    static {
        RvQFLfG();
    }

    public static File A2egSU(String str) {
        File file = new File(f4293A2egSU, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static /* synthetic */ void RvQFLfG() {
        char[] charArray = "°¼¾ý´²¾¶ý±¼ªý »¶¿¿ý\u0099½º\u0091¡º·´¶".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 211);
        }
        String str = new String(charArray);
        char[] charArray2 = "°¿º½º§".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 211);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
