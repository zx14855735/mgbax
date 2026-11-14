package com.octopus.ad.utils;

import android.os.Handler;
import android.os.Looper;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ThreadUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadPoolExecutor f12660a;
    private static final ThreadPoolExecutor b;
    public static Handler mMainHandler;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f12660a = new ThreadPoolExecutor(5, 20, 2L, timeUnit, new LinkedBlockingQueue(r.b.d));
        b = new ThreadPoolExecutor(5, 20, 2L, timeUnit, new LinkedBlockingQueue(r.b.d));
        mMainHandler = new Handler(Looper.getMainLooper());
        LAZyBeR();
    }

    private static /* synthetic */ void LAZyBeR() {
        char[] charArray = "mac iock law }fkbb D`gL|gjik".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 14);
        }
        String str = new String(charArray);
        char[] charArray2 = "mbg`gz".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 14);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void runOnLogThreadPool(Runnable runnable) {
        try {
            ThreadPoolExecutor threadPoolExecutor = b;
            if (threadPoolExecutor.isShutdown()) {
                return;
            }
            threadPoolExecutor.execute(runnable);
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public static void runOnThreadPool(Runnable runnable) {
        try {
            ThreadPoolExecutor threadPoolExecutor = f12660a;
            if (threadPoolExecutor.isShutdown()) {
                return;
            }
            threadPoolExecutor.execute(runnable);
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public static void runOnUIThread(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            mMainHandler.post(runnable);
        }
    }

    public static void runOnUIThreadByThreadPool(final Runnable runnable) {
        f12660a.execute(new Runnable() { // from class: com.octopus.ad.utils.ThreadUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ThreadUtils.mMainHandler.post(runnable);
            }
        });
    }

    public static <T> Future<T> runOnThreadPool(Callable<T> callable) {
        return f12660a.submit(callable);
    }
}
