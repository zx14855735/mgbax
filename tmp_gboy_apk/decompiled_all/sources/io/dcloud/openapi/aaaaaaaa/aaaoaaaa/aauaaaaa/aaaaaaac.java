package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa;

import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaac {
    private static volatile Handler aaaaaaa0;
    private static volatile HandlerThread aaaaaaaa = new HandlerThread("dcloud_thread", -19);

    static {
        aaaaaaaa.start();
        aaaaaaa0 = new Handler(aaaaaaaa.getLooper());
        JlFJLf();
    }

    private static /* synthetic */ void JlFJLf() {
        char[] charArray = "¤¨ªé ¦ª¢é¥¨¾é´¯¢««é\u008d©®\u0085µ®£ ¢".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 199);
        }
        String str = new String(charArray);
        char[] charArray2 = "¤«®©®³".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 199);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static Handler aaaaaaaa() {
        if (aaaaaaaa == null || !aaaaaaaa.isAlive()) {
            synchronized (aaaaaaac.class) {
                try {
                    if (aaaaaaaa != null) {
                        if (!aaaaaaaa.isAlive()) {
                        }
                    }
                    aaaaaaaa = new HandlerThread("dcloud_thread", -19);
                    aaaaaaaa.start();
                    aaaaaaa0 = new Handler(aaaaaaaa.getLooper());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return aaaaaaa0;
    }
}
