package io.dcloud.sdk.poly.adapter.custom.yt.utils;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ThreadUtils {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int TASK_QUEUE_MAX_COUNT = 128;
    private static final int THREAD_KEEP_LIVE_TIME = 30;
    public static Handler mMainHandler;
    private static ThreadPoolExecutor mThreadPoolExecutor;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int max = Math.max(availableProcessors, 5);
        CORE_POOL_SIZE = max;
        mThreadPoolExecutor = new ThreadPoolExecutor(max, max, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
        mMainHandler = new Handler(Looper.getMainLooper());
        jfxaNx();
    }

    private static /* synthetic */ void jfxaNx() {
        char[] charArray = "ª¦¤ç®¨¤¬ç«¦°çº¡¬¥¥ç\u0083§ \u008b» \u00ad®¬".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 201);
        }
        String str = new String(charArray);
        char[] charArray2 = "ª¥ § ½".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 201);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void runOnThreadPool(Runnable runnable) {
        mThreadPoolExecutor.execute(runnable);
    }

    public static void runOnUIThread(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            mMainHandler.post(runnable);
        }
    }

    public static void runOnUIThreadByThreadPool(final Runnable runnable) {
        mThreadPoolExecutor.execute(new Runnable() { // from class: io.dcloud.sdk.poly.adapter.custom.yt.utils.ThreadUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ThreadUtils.mMainHandler.post(runnable);
            }
        });
    }

    public static <T> Future<T> runOnThreadPool(Callable<T> callable) {
        return mThreadPoolExecutor.submit(callable);
    }
}
