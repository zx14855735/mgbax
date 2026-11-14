package com.bytedance.sdk.openadsdk.upie.xj;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.utils.f;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static final Handler xj = new Handler(Looper.getMainLooper());

    static {
        UNIoV();
    }

    private static /* synthetic */ void UNIoV() {
        char[] charArray = "@LN\rDBNF\rALZ\rPKFOO\riMJaQJGDF".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '#');
        }
        String str = new String(charArray);
        char[] charArray2 = "@OJMJW".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '#');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void hf(Runnable runnable) {
        xj.post(runnable);
    }

    public static void w(Runnable runnable) {
        f.w().post(runnable);
    }

    public static void xj(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            xj.post(runnable);
        }
    }
}
