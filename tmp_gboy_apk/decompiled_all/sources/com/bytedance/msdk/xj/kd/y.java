package com.bytedance.msdk.xj.kd;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private static final int c;
    private static final ThreadPoolExecutor d;
    private static final int f;
    private static final Object hf = new Object();
    private static HandlerThread kd = null;
    private static final Executor tf;
    private static Handler u = null;
    private static boolean w = false;
    static final /* synthetic */ boolean xj = true;
    private static Handler y;

    static {
        xj();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        c = availableProcessors;
        f = Math.min(availableProcessors, 4);
        d = d();
        tf = tf();
        DsqB();
    }

    private static /* synthetic */ void DsqB() {
        char[] charArray = "¥©«è¡§«£è¤©¿èµ®£ªªè\u008c¨¯\u0084´¯¢¡£".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 198);
        }
        String str = new String(charArray);
        char[] charArray2 = "¥ª¯¨¯²".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 198);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static Executor c() {
        return tf;
    }

    private static ThreadPoolExecutor d() {
        int i = f;
        com.bytedance.sdk.component.tf.u.u uVar = new com.bytedance.sdk.component.tf.u.u(i, i, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(1024), xj("gm_t_executor:"), new ThreadPoolExecutor.DiscardOldestPolicy() { // from class: com.bytedance.msdk.xj.kd.y.2
            @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                super.rejectedExecution(runnable, threadPoolExecutor);
                com.bytedance.msdk.c.hf.xj.xj().w();
            }
        });
        try {
            uVar.allowCoreThreadTimeOut(true);
            return uVar;
        } catch (Exception e) {
            pl.w("ThreadHelper", "stackerror:", e);
            return uVar;
        } catch (NoSuchMethodError e2) {
            pl.xj(e2);
            return uVar;
        }
    }

    private static boolean f() {
        HandlerThread handlerThread = kd;
        return (handlerThread == null || !handlerThread.isAlive() || y == null) ? false : true;
    }

    public static Looper hf() {
        if (f()) {
            return kd.getLooper();
        }
        return null;
    }

    public static boolean kd() {
        return u().getLooper() == Looper.myLooper();
    }

    private static Executor tf() {
        return new com.bytedance.sdk.component.tf.u.u(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), xj("gm_t_log_upload:"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static Handler u() {
        Handler handler;
        synchronized (hf) {
            try {
                if (u == null) {
                    if (w) {
                        throw new RuntimeException("Did not yet override the UI thread");
                    }
                    u = new Handler(Looper.getMainLooper());
                }
                handler = u;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public static boolean w() {
        return f() && kd.getLooper() == Looper.myLooper();
    }

    public static void xj() {
        try {
            HandlerThread handlerThread = new HandlerThread("gm_t_main", -19);
            kd = handlerThread;
            handlerThread.start();
            y = new Handler(kd.getLooper());
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public static Executor y() {
        return d;
    }

    public static void hf(Runnable runnable) {
        if (kd()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        xj(futureTask);
        try {
            futureTask.get();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured while waiting for runnable", e);
        }
    }

    public static void w(Runnable runnable) {
        if (kd()) {
            runnable.run();
        } else {
            u().post(runnable);
        }
    }

    public static void xj(Runnable runnable) {
        if (f()) {
            if (w()) {
                runnable.run();
                return;
            } else {
                y.post(runnable);
                return;
            }
        }
        xj();
    }

    public static void u(Runnable runnable) {
        xj(d, runnable);
    }

    public static void hf(Runnable runnable, long j) {
        u().postDelayed(runnable, j);
    }

    public static void xj(Runnable runnable, long j) {
        if (f()) {
            y.postDelayed(runnable, j);
        } else {
            xj();
        }
    }

    public static ThreadFactory xj(final String str) {
        return new ThreadFactory() { // from class: com.bytedance.msdk.xj.kd.y.1
            private final AtomicInteger hf = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new com.bytedance.sdk.component.tf.u.w(runnable, str + " # " + this.hf.getAndIncrement());
            }
        };
    }

    public static <T> FutureTask<T> xj(FutureTask<T> futureTask) {
        u().post(futureTask);
        return futureTask;
    }

    public static ExecutorService xj(String str, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        return new com.bytedance.sdk.component.tf.u.u(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(i), xj("gm_t_single_".concat(String.valueOf(str))), rejectedExecutionHandler);
    }

    public static <T> Future<T> xj(Callable<T> callable) {
        try {
            return d.submit(callable);
        } catch (Exception e) {
            pl.w("ThreadHelper", "stackerror:", e);
            return null;
        }
    }

    private static boolean xj(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
            return true;
        } catch (Exception e) {
            pl.w("ThreadHelper", "stackerror:", e);
            return false;
        }
    }
}
