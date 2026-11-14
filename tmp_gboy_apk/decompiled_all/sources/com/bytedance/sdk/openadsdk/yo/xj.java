package com.bytedance.sdk.openadsdk.yo;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.openadsdk.api.y;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class xj {
    private static volatile xj xj;
    private volatile ThreadPoolExecutor hf = null;
    private final Handler w;

    private xj() {
        HandlerThread handlerThread = new HandlerThread("csj_api_main");
        handlerThread.start();
        this.w = new Handler(handlerThread.getLooper());
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                xj = new xj();
            }
        }
        return xj;
    }

    public Handler hf() {
        return this.w;
    }

    public ExecutorService w() {
        if (this.hf == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 1000L, TimeUnit.MILLISECONDS, new SynchronousQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.hf = threadPoolExecutor;
        }
        return this.hf;
    }

    public void xj(Runnable runnable) {
        if (runnable != null) {
            try {
                this.w.post(runnable);
            } catch (Throwable th) {
                y.xj(th);
            }
        }
    }

    public void xj(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            if (this.hf != null) {
                y.hf("ApiThread", "setPluginExecutor: 释放掉api层的线程池");
                xj(threadPoolExecutor, this.hf);
            }
            this.hf = threadPoolExecutor;
        }
    }

    private void xj(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        executorService.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.yo.xj.1
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                if (threadPoolExecutor2 == null) {
                    return;
                }
                try {
                    threadPoolExecutor2.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    while (true) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                        if (threadPoolExecutor.getQueue().size() <= 0 && threadPoolExecutor.getActiveCount() == 0) {
                            threadPoolExecutor.shutdown();
                            return;
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
