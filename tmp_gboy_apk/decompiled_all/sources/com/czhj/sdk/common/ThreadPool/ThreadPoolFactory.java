package com.czhj.sdk.common.ThreadPool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ThreadPoolFactory {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10554a;
    private static final TimeUnit b;
    private static final Handler c;
    private static Handler d;
    private static final ExecutorService e;
    private static HandlerThread f;

    public static class BackgroundThreadPool {
        private static volatile BackgroundThreadPool d;

        /* renamed from: a, reason: collision with root package name */
        final int f10555a = 2;
        final BlockingQueue<Runnable> b = new LinkedBlockingQueue();
        final ExecutorService c = ThreadPoolFactory.e;

        public BackgroundThreadPool() {
            HandlerThread unused = ThreadPoolFactory.f = new HandlerThread("ioThread");
            ThreadPoolFactory.f.start();
            Handler unused2 = ThreadPoolFactory.d = new Handler(ThreadPoolFactory.f.getLooper());
        }

        public static BackgroundThreadPool getInstance() {
            if (d == null) {
                synchronized (BackgroundThreadPool.class) {
                    try {
                        if (d == null) {
                            d = new BackgroundThreadPool();
                        }
                    } finally {
                    }
                }
            }
            return d;
        }

        public ExecutorService getExecutorService() {
            return this.c;
        }

        public Handler getIOHandler() {
            return ThreadPoolFactory.d;
        }

        public Looper getIOLooper() {
            return ThreadPoolFactory.f.getLooper();
        }

        public void submit(Runnable runnable) {
            try {
                this.c.submit(runnable);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f10554a = availableProcessors;
        b = TimeUnit.SECONDS;
        c = new Handler(Looper.getMainLooper());
        e = Executors.newFixedThreadPool(availableProcessors + 1, new BackgroundThreadFactory());
        IlFtu();
    }

    private static /* synthetic */ void IlFtu() {
        char[] charArray = "³¿½þ·±½µþ²¿©þ£¸µ¼¼þ\u009a¾¹\u0092¢¹´·µ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 208);
        }
        String str = new String(charArray);
        char[] charArray2 = "³¼¹¾¹¤".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 208);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void MainThreadRun(Runnable runnable) {
        c.post(runnable);
    }

    public static ExecutorService getFixIOExecutor() {
        return e;
    }
}
