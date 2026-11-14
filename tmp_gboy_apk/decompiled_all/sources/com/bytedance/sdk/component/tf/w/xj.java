package com.bytedance.sdk.component.tf.w;

import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.p;
import com.bytedance.sdk.component.utils.pl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj extends ThreadPoolExecutor {
    public xj(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, com.bytedance.sdk.component.tf.u.xj.xj);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        xj(runnable);
    }

    public int hf() {
        return 0;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i) {
        try {
            super.setCorePoolSize(i);
        } catch (Exception e) {
            pl.xj("BaseThreadPool", e.getMessage());
        } catch (OutOfMemoryError e2) {
            xj(null, e2);
        }
    }

    public boolean xj() {
        return false;
    }

    public xj(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    private void xj(Runnable runnable) {
        try {
            com.bytedance.sdk.component.tf.xj.w wVar = runnable instanceof com.bytedance.sdk.component.tf.xj.w ? (com.bytedance.sdk.component.tf.xj.w) runnable : new com.bytedance.sdk.component.tf.xj.w(runnable);
            wVar.hf();
            p pVar = p.hf;
            if (pVar.am() && (getCorePoolSize() <= getActiveCount() || getQueue().size() > 0)) {
                pl.hf("BaseThreadPool", "crashing drop task :".concat(String.valueOf(runnable)));
                wVar.xj(3);
                pVar.pl().submit(wVar);
                return;
            }
            wVar.xj(hf());
            super.execute(wVar);
        } catch (OutOfMemoryError e) {
            if (p.hf.hf()) {
                c.xj(false);
            }
            xj(runnable, e);
        }
    }

    public void xj(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        com.bytedance.sdk.component.tf.xj.w.hf = true;
    }
}
