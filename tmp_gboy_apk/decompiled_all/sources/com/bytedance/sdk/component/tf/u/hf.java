package com.bytedance.sdk.component.tf.u;

import android.os.AsyncTask;
import com.bytedance.sdk.component.tf.tf;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public static Executor xj = new u(0, 20, 3, TimeUnit.MILLISECONDS, new SynchronousQueue(), new tf("PAsyncTask"));

    static {
        YQgPu();
    }

    private static /* synthetic */ void YQgPu() {
        char[] charArray = "{wu6\u007fyu}6zwa6kp}tt6RvqZjq|\u007f}".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 24);
        }
        String str = new String(charArray);
        char[] charArray2 = "{tqvql".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 24);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public AsyncTask<Params, Progress, Result> xj(Params... paramsArr) {
        return executeOnExecutor(xj, paramsArr);
    }
}
