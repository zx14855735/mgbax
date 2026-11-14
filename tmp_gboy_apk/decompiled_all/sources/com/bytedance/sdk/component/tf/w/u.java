package com.bytedance.sdk.component.tf.w;

import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.p;
import com.bytedance.sdk.component.utils.pl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends xj {
    private ScheduledFuture<?> xj;

    public u(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    private void kd() {
        BlockingQueue<Runnable> queue = getQueue();
        int f = p.hf.f();
        if (getCorePoolSize() == f || queue == null || queue.size() != 0) {
            return;
        }
        setCorePoolSize(f);
    }

    public static boolean u() {
        ThreadPoolExecutor d = p.hf.d();
        if (d.getQueue().size() != 0 || d.isShutdown() || d.isTerminated()) {
            return false;
        }
        int activeCount = d.getActiveCount();
        int corePoolSize = d.getCorePoolSize();
        return activeCount < corePoolSize + (-1) && com.bytedance.sdk.component.tf.xj.w.xj.get() < corePoolSize / 2;
    }

    private boolean y() {
        BlockingQueue<Runnable> queue = getQueue();
        int corePoolSize = getCorePoolSize();
        int i = corePoolSize * 2;
        int min = Math.min(corePoolSize + 4, c.xj);
        if (corePoolSize >= min || queue == null || queue.size() < i) {
            return false;
        }
        try {
            setCorePoolSize(min);
            return true;
        } catch (Exception e) {
            pl.xj("BizCoreThreadPool", e.getMessage());
            return false;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (c.kd()) {
            kd();
        }
    }

    @Override // com.bytedance.sdk.component.tf.w.xj, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (c.kd()) {
            y();
        }
        super.execute(runnable);
    }

    @Override // com.bytedance.sdk.component.tf.w.xj
    public int hf() {
        return 2;
    }

    public void w() {
        ScheduledFuture<?> scheduledFuture = this.xj;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[RETURN] */
    @Override // com.bytedance.sdk.component.tf.w.xj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(java.lang.Runnable r3, java.lang.OutOfMemoryError r4) {
        /*
            r2 = this;
            super.xj(r3, r4)
            r0 = 0
            if (r3 == 0) goto L11
            java.util.concurrent.BlockingQueue r1 = r2.getQueue()     // Catch: java.lang.Throwable -> Lf
            boolean r3 = r1.offer(r3)     // Catch: java.lang.Throwable -> Lf
            goto L15
        Lf:
            goto L1e
        L11:
            r3 = 1
            com.bytedance.sdk.component.tf.c.xj(r0)     // Catch: java.lang.Throwable -> L1c
        L15:
            r2.allowCoreThreadTimeOut(r0)     // Catch: java.lang.Throwable -> L19
            goto L1f
        L19:
            r0 = r3
            goto L1e
        L1c:
            r0 = 1
        L1e:
            r3 = r0
        L1f:
            if (r3 == 0) goto L22
            return
        L22:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tf.w.u.xj(java.lang.Runnable, java.lang.OutOfMemoryError):void");
    }

    @Override // com.bytedance.sdk.component.tf.w.xj
    public boolean xj() {
        BlockingQueue<Runnable> queue = getQueue();
        return queue != null && queue.size() > getCorePoolSize() * 2;
    }
}
