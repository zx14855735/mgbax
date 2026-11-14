package com.bytedance.sdk.component.tf.w;

import com.bytedance.sdk.component.tf.p;
import com.bytedance.sdk.component.utils.pl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends xj {
    private AtomicInteger xj;

    public hf(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new SynchronousQueue(), threadFactory);
        this.xj = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        Runnable poll;
        super.afterExecute(runnable, th);
        BlockingQueue<Runnable> queue = p.hf.d().getQueue();
        if (queue.size() == 0) {
            return;
        }
        int maximumPoolSize = getMaximumPoolSize();
        if (this.xj.get() >= Math.max(getCorePoolSize(), maximumPoolSize / 4)) {
            return;
        }
        try {
            this.xj.getAndIncrement();
            int activeCount = getActiveCount();
            while (activeCount < maximumPoolSize / 2 && !isShutdown() && !isTerminated() && !isTerminating() && (poll = queue.poll()) != null) {
                if (poll instanceof com.bytedance.sdk.component.tf.xj.w) {
                    com.bytedance.sdk.component.tf.xj.w wVar = (com.bytedance.sdk.component.tf.xj.w) poll;
                    wVar.xj(hf());
                    wVar.hf();
                }
                poll.run();
                activeCount = getActiveCount();
            }
        } finally {
            this.xj.getAndDecrement();
        }
    }

    @Override // com.bytedance.sdk.component.tf.w.xj, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable instanceof w) {
            super.execute(runnable);
            return;
        }
        if (xj(runnable)) {
            return;
        }
        if (!xj()) {
            super.execute(runnable);
            return;
        }
        if (runnable instanceof com.bytedance.sdk.component.tf.xj.w) {
            ((com.bytedance.sdk.component.tf.xj.w) runnable).xj(false);
        } else {
            runnable = new w(runnable);
        }
        p.hf.d().execute(runnable);
    }

    @Override // com.bytedance.sdk.component.tf.w.xj
    public int hf() {
        return 1;
    }

    @Override // com.bytedance.sdk.component.tf.w.xj
    public void xj(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        super.xj(runnable, outOfMemoryError);
        if (runnable != null) {
            if (runnable instanceof com.bytedance.sdk.component.tf.xj.w) {
                ((com.bytedance.sdk.component.tf.xj.w) runnable).xj(false);
            } else {
                runnable = new w(runnable);
            }
            p.hf.d().execute(runnable);
        }
        try {
            allowCoreThreadTimeOut(false);
        } catch (Exception e) {
            pl.w("BigThreadPool", e);
        }
    }

    @Override // com.bytedance.sdk.component.tf.w.xj
    public boolean xj() {
        return getActiveCount() >= getMaximumPoolSize();
    }

    private boolean xj(Runnable runnable) {
        com.bytedance.sdk.component.tf.xj.w wVar;
        if (!u.u()) {
            return false;
        }
        if (runnable instanceof com.bytedance.sdk.component.tf.xj.w) {
            wVar = (com.bytedance.sdk.component.tf.xj.w) runnable;
            if (!wVar.w()) {
                return false;
            }
        } else {
            wVar = new w(runnable);
        }
        com.bytedance.sdk.component.tf.xj.w.xj.incrementAndGet();
        wVar.xj(false);
        p.hf.d().execute(wVar);
        return true;
    }
}
