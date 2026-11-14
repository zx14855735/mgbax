package io.dcloud.openapi.core.util;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class MainHandlerUtil {
    private static volatile Handler aaaaaaaa = new Handler(Looper.getMainLooper());

    static {
        mxPsXX();
    }

    public static Handler getMainHandler() {
        if (aaaaaaaa == null) {
            synchronized (MainHandlerUtil.class) {
                try {
                    if (aaaaaaaa == null) {
                        aaaaaaaa = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return aaaaaaaa;
    }

    private static /* synthetic */ void mxPsXX() {
        char[] charArray = "¯£¡â«\u00ad¡©â®£µâ¿¤©  â\u0086¢¥\u008e¾¥¨«©".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 204);
        }
        String str = new String(charArray);
        char[] charArray2 = "¯ ¥¢¥¸".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 204);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
