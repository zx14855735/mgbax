package com.bytedance.sdk.component.tf.u;

import com.bytedance.sdk.component.tf.p;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends xj {
    public u(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new com.bytedance.sdk.component.tf.xj.xj(blockingQueue), new com.bytedance.sdk.component.tf.xj.u(threadFactory, 2));
        xj();
    }

    private ExecutorService hf() {
        com.bytedance.sdk.component.tf.u uVar = com.bytedance.sdk.component.tf.u.xj;
        return uVar.xj("PThreadPoolExecutor", uVar.xj(getQueue()));
    }

    private void xj() {
        if (p.hf.kd()) {
            if (!allowsCoreThreadTimeOut()) {
                setKeepAliveTime(xj(20L), TimeUnit.SECONDS);
                try {
                    super.allowCoreThreadTimeOut(true);
                } catch (Throwable unused) {
                }
            }
            com.bytedance.sdk.component.tf.u.xj.xj(this);
        }
    }

    @Override // com.bytedance.sdk.component.tf.u.xj, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public void allowCoreThreadTimeOut(boolean z) {
    }

    @Override // com.bytedance.sdk.component.tf.u.xj, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.tf.hf
    public void execute(Runnable runnable) {
        if (!p.hf.kd()) {
            super.execute(runnable);
            return;
        }
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError e) {
            ExecutorService hf = hf();
            if (hf == null) {
                throw e;
            }
            hf.execute(runnable);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void finalize() {
        super.finalize();
        shutdown();
        com.bytedance.sdk.component.tf.u.xj.hf(this);
    }

    @Override // com.bytedance.sdk.component.tf.u.xj, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.tf.xj.u(threadFactory, 2));
    }

    @Override // com.bytedance.sdk.component.tf.u.xj, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public void shutdown() {
        super.shutdown();
        com.bytedance.sdk.component.tf.u.xj.hf(this);
    }

    @Override // com.bytedance.sdk.component.tf.u.xj, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public List shutdownNow() {
        com.bytedance.sdk.component.tf.u.xj.hf(this);
        return super.shutdownNow();
    }

    @Override // com.bytedance.sdk.component.tf.u.xj, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public <T> Future<T> submit(Callable<T> callable) {
        if (!p.hf.kd()) {
            return super.submit(callable);
        }
        try {
            return super.submit(callable);
        } catch (OutOfMemoryError e) {
            ExecutorService hf = hf();
            if (hf != null) {
                return hf.submit(callable);
            }
            throw e;
        }
    }

    public u(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, new com.bytedance.sdk.component.tf.xj.xj(blockingQueue), new com.bytedance.sdk.component.tf.xj.u(threadFactory, 2), rejectedExecutionHandler);
        xj();
    }

    private long xj(long j) {
        long min = Math.min(j, getKeepAliveTime(TimeUnit.SECONDS));
        if (min > 1) {
            return min;
        }
        return 1L;
    }

    @Override // com.bytedance.sdk.component.tf.u.xj, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (p.hf.kd()) {
            try {
                return super.submit(runnable, t);
            } catch (OutOfMemoryError e) {
                ExecutorService hf = hf();
                if (hf != null) {
                    return hf.submit(runnable, t);
                }
                throw e;
            }
        }
        return super.submit(runnable, t);
    }

    @Override // com.bytedance.sdk.component.tf.u.xj, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public Future submit(Runnable runnable) {
        if (p.hf.kd()) {
            try {
                return super.submit(runnable);
            } catch (OutOfMemoryError e) {
                ExecutorService hf = hf();
                if (hf != null) {
                    return hf.submit(runnable);
                }
                throw e;
            }
        }
        return super.submit(runnable);
    }
}
