package com.bytedance.sdk.component.tf.u;

import com.bytedance.sdk.component.tf.p;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends ScheduledThreadPoolExecutor {
    private final ConcurrentHashMap xj;

    public kd(int i, ThreadFactory threadFactory) {
        super(i, new com.bytedance.sdk.component.tf.xj.u(threadFactory, 8));
        this.xj = new ConcurrentHashMap();
        xj();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z) {
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public RunnableScheduledFuture decorateTask(Runnable runnable, RunnableScheduledFuture runnableScheduledFuture) {
        if (!p.hf.kd()) {
            return super.decorateTask(runnable, runnableScheduledFuture);
        }
        RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.xj.get(runnable);
        if (runnableScheduledFuture2 != null) {
            return runnableScheduledFuture2;
        }
        RunnableScheduledFuture decorateTask = super.decorateTask(runnable, runnableScheduledFuture);
        this.xj.put(runnable, decorateTask);
        return decorateTask;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j, final TimeUnit timeUnit) {
        if (!p.hf.kd()) {
            return super.schedule(runnable, j, timeUnit);
        }
        try {
            ScheduledFuture<?> schedule = super.schedule(runnable, j, timeUnit);
            this.xj.remove(runnable);
            return schedule;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.tf.u.xj.xj("PThreadScheduledThreadPoolExecutor");
            p pVar = p.hf;
            pVar.pl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tf.u.kd.1
                @Override // java.lang.Runnable
                public void run() {
                    kd.super.schedule(runnable, j, timeUnit);
                    kd.this.xj.remove(runnable);
                }
            }, pVar.u(), TimeUnit.MILLISECONDS);
            return (ScheduledFuture) this.xj.get(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        if (!p.hf.kd()) {
            return super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
            this.xj.remove(runnable);
            return scheduleAtFixedRate;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.tf.u.xj.xj("PThreadScheduledThreadPoolExecutor");
            p pVar = p.hf;
            pVar.pl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tf.u.kd.2
                @Override // java.lang.Runnable
                public void run() {
                    kd.super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
                    kd.this.xj.remove(runnable);
                }
            }, pVar.u(), TimeUnit.MILLISECONDS);
            return (ScheduledFuture) this.xj.get(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        if (!p.hf.kd()) {
            return super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
        }
        try {
            ScheduledFuture<?> scheduleWithFixedDelay = super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
            this.xj.remove(runnable);
            return scheduleWithFixedDelay;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.tf.u.xj.xj("PThreadScheduledThreadPoolExecutor");
            p pVar = p.hf;
            pVar.pl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tf.u.kd.3
                @Override // java.lang.Runnable
                public void run() {
                    kd.super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
                    kd.this.xj.remove(runnable);
                }
            }, pVar.u(), TimeUnit.MILLISECONDS);
            return (ScheduledFuture) this.xj.get(runnable);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.tf.xj.u(threadFactory, 8));
    }

    private void xj() {
        if (!p.hf.kd() || allowsCoreThreadTimeOut()) {
            return;
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        super.setKeepAliveTime(Math.max(10L, getKeepAliveTime(timeUnit)), timeUnit);
        super.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public RunnableScheduledFuture decorateTask(Callable callable, RunnableScheduledFuture runnableScheduledFuture) {
        if (p.hf.kd()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.xj.get(callable);
            if (runnableScheduledFuture2 != null) {
                return runnableScheduledFuture2;
            }
            RunnableScheduledFuture decorateTask = super.decorateTask(callable, runnableScheduledFuture);
            this.xj.put(callable, decorateTask);
            return decorateTask;
        }
        return super.decorateTask(callable, runnableScheduledFuture);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j, final TimeUnit timeUnit) {
        if (p.hf.kd()) {
            try {
                ScheduledFuture schedule = super.schedule(callable, j, timeUnit);
                this.xj.remove(callable);
                return schedule;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.tf.u.xj.xj("PThreadScheduledThreadPoolExecutor");
                p pVar = p.hf;
                pVar.pl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tf.u.kd.4
                    @Override // java.lang.Runnable
                    public void run() {
                        kd.super.schedule(callable, j, timeUnit);
                        kd.this.xj.remove(callable);
                    }
                }, pVar.u(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.xj.get(callable);
            }
        }
        return super.schedule(callable, j, timeUnit);
    }
}
