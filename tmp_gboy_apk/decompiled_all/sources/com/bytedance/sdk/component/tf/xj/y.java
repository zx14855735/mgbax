package com.bytedance.sdk.component.tf.xj;

import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.tf.p;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements com.bytedance.sdk.component.tf.hf {
    private volatile RejectedExecutionHandler c;
    private volatile int d;
    private volatile long f;
    private ThreadPoolExecutor g;
    private final BlockingQueue<Runnable> hf;
    private int kd;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private volatile int f10220pl;
    private final ThreadPoolExecutor tf;
    private final Condition u;
    private final ReentrantLock w;
    private final AtomicInteger xj = new AtomicInteger(xj(-536870912, 0));
    private volatile ThreadFactory y;

    public y(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ThreadPoolExecutor threadPoolExecutor) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.w = reentrantLock;
        this.u = reentrantLock.newCondition();
        if (i < 0 || i2 <= 0 || i2 < i || j < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue == null || threadFactory == null || rejectedExecutionHandler == null) {
            throw null;
        }
        this.d = i;
        this.f10220pl = i2;
        this.hf = blockingQueue;
        this.f = timeUnit.toNanos(j);
        this.y = threadFactory;
        this.c = rejectedExecutionHandler;
        this.tf = threadPoolExecutor;
    }

    private boolean c(int i) {
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return com.bytedance.sdk.component.tf.w.u.u();
        }
        return false;
    }

    private static int hf(int i) {
        return i & 536870911;
    }

    private boolean kd(int i) {
        return this.xj.compareAndSet(i, i - 1);
    }

    private boolean u(int i) {
        return this.xj.compareAndSet(i, i + 1);
    }

    private static boolean w(int i) {
        return i < 0;
    }

    private static int xj(int i) {
        return i & (-536870912);
    }

    private void y(int i) {
        int i2;
        do {
            i2 = this.xj.get();
            if (w(i2, i)) {
                return;
            }
        } while (!this.xj.compareAndSet(i2, xj(i, hf(i2))));
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public void allowCoreThreadTimeOut(boolean z) {
        this.p = true;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public boolean allowsCoreThreadTimeOut() {
        return this.p;
    }

    @Override // com.bytedance.sdk.component.tf.hf, java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.w;
        reentrantLock.lock();
        while (!w(this.xj.get(), 1610612736)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.u.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    @Override // com.bytedance.sdk.component.tf.hf, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        w wVar;
        if (runnable == null) {
            return;
        }
        if (runnable instanceof w) {
            wVar = (w) runnable;
            wVar.xj(this);
        } else {
            wVar = new w(runnable, this);
        }
        xj(wVar);
    }

    public void finalize() {
        shutdown();
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public int getActiveCount() {
        return hf(this.xj.get());
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public long getCompletedTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public int getCorePoolSize() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.f, TimeUnit.NANOSECONDS);
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public int getLargestPoolSize() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public int getMaximumPoolSize() {
        return this.f10220pl;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public int getPoolSize() {
        if (w(this.xj.get(), 1073741824)) {
            return 0;
        }
        return hf(this.xj.get());
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public BlockingQueue<Runnable> getQueue() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public long getTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public ThreadFactory getThreadFactory() {
        return this.y;
    }

    @Override // com.bytedance.sdk.component.tf.hf, java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return !w(this.xj.get());
    }

    @Override // com.bytedance.sdk.component.tf.hf, java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return w(this.xj.get(), 1610612736);
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public boolean isTerminating() {
        int i = this.xj.get();
        return !w(i) && hf(i, 1610612736);
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public int prestartAllCoreThreads() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public boolean prestartCoreThread() {
        return false;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public void purge() {
        BlockingQueue<Runnable> blockingQueue = this.hf;
        try {
            Iterator<Runnable> it = blockingQueue.iterator();
            while (it.hasNext()) {
                Runnable next = it.next();
                if ((next instanceof Future) && ((Future) next).isCancelled()) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException unused) {
            for (Object obj : blockingQueue.toArray()) {
                if ((obj instanceof Future) && ((Future) obj).isCancelled()) {
                    blockingQueue.remove(obj);
                }
            }
        }
        hf();
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public boolean remove(Runnable runnable) {
        boolean remove = this.hf.remove(runnable);
        hf();
        return remove;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public void setCorePoolSize(int i) {
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        this.f = timeUnit.toNanos(j);
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public void setMaximumPoolSize(int i) {
        if (i <= 0 || i < this.d) {
            throw new IllegalArgumentException();
        }
        this.f10220pl = i;
        this.xj.get();
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        rejectedExecutionHandler.getClass();
        this.c = rejectedExecutionHandler;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.y = threadFactory;
    }

    @Override // com.bytedance.sdk.component.tf.hf, java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock reentrantLock = this.w;
        reentrantLock.lock();
        try {
            y(0);
            reentrantLock.unlock();
            hf();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.tf.hf, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.w;
        reentrantLock.lock();
        try {
            y(C.ENCODING_PCM_A_LAW);
            List<Runnable> u = u();
            reentrantLock.unlock();
            hf();
            return u;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.tf.hf, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.bytedance.sdk.component.tf.hf
    public String toString() {
        int i = this.xj.get();
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "[" + (hf(i, 0) ? "Running" : w(i, 1610612736) ? "Terminated" : "Shutting down") + ", runnable name = , core size = " + this.d + ", max size = " + this.f10220pl + ", worker count = " + hf(i) + ", queued tasks = " + this.hf.size() + "]";
    }

    private static boolean hf(int i, int i2) {
        return i < i2;
    }

    private void kd() {
        ReentrantLock reentrantLock = this.w;
        reentrantLock.lock();
        try {
            w();
            hf();
        } finally {
            reentrantLock.unlock();
        }
    }

    private List<Runnable> u() {
        BlockingQueue<Runnable> blockingQueue = this.hf;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    if (runnable instanceof w) {
                        arrayList.add(((w) runnable).w);
                    } else {
                        arrayList.add(runnable);
                    }
                }
            }
        }
        return arrayList;
    }

    private static boolean w(int i, int i2) {
        return i >= i2;
    }

    private static int xj(int i, int i2) {
        return i | i2;
    }

    private void w() {
        while (!kd(this.xj.get())) {
        }
    }

    public final void hf() {
        while (true) {
            int i = this.xj.get();
            if (w(i) || w(i, 1073741824)) {
                return;
            }
            if ((xj(i) == 0 && !this.hf.isEmpty()) || hf(i) != 0) {
                return;
            }
            ReentrantLock reentrantLock = this.w;
            reentrantLock.lock();
            try {
                if (this.xj.compareAndSet(i, xj(1073741824, 0))) {
                    this.xj.set(xj(1610612736, 0));
                    this.u.signalAll();
                    return;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.bytedance.sdk.component.tf.hf, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        if (callable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    public ThreadPoolExecutor xj() {
        if (this.g == null) {
            this.g = p.hf.tf();
        }
        return this.g;
    }

    @Override // com.bytedance.sdk.component.tf.hf, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, t);
        execute(futureTask);
        return futureTask;
    }

    public final void xj(Runnable runnable) {
        this.c.rejectedExecution(runnable, this.tf);
    }

    private void xj(w wVar) {
        int i = this.xj.get();
        if (hf(i) < this.d) {
            if (hf((Runnable) wVar, true)) {
                p.hf.c();
                return;
            }
            i = this.xj.get();
        }
        if (hf(i) == 0) {
            if (hf((Runnable) wVar, false)) {
                p.hf.c();
                return;
            }
            i = this.xj.get();
        }
        if (w(i) && this.hf.offer(wVar)) {
            if (!w(this.xj.get()) && remove(wVar)) {
                xj(wVar.xj());
                p.hf.c();
                return;
            } else {
                p.hf.c();
                return;
            }
        }
        if (hf(i) < this.f10220pl && hf((Runnable) wVar, false)) {
            p.hf.c();
        } else {
            xj(wVar.xj());
            p.hf.c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean hf(java.lang.Runnable r6, boolean r7) {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicInteger r0 = r5.xj
            int r0 = r0.get()
            int r1 = xj(r0)
            r2 = 0
            if (r1 < 0) goto L1a
            if (r1 != 0) goto L19
            if (r6 != 0) goto L19
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r3 = r5.hf
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L1a
        L19:
            return r2
        L1a:
            int r3 = hf(r0)
            r4 = 536870911(0x1fffffff, float:1.0842021E-19)
            if (r3 >= r4) goto L83
            if (r7 == 0) goto L28
            int r4 = r5.d
            goto L2a
        L28:
            int r4 = r5.f10220pl
        L2a:
            if (r3 < r4) goto L2d
            goto L83
        L2d:
            boolean r0 = r5.u(r0)
            if (r0 != 0) goto L40
            java.util.concurrent.atomic.AtomicInteger r0 = r5.xj
            int r0 = r0.get()
            int r3 = xj(r0)
            if (r3 != r1) goto L0
            goto L1a
        L40:
            java.util.concurrent.locks.ReentrantLock r7 = r5.w     // Catch: java.lang.Throwable -> L79
            r7.lock()     // Catch: java.lang.Throwable -> L79
            java.util.concurrent.atomic.AtomicInteger r0 = r5.xj     // Catch: java.lang.Throwable -> L6d
            int r0 = r0.get()     // Catch: java.lang.Throwable -> L6d
            int r0 = xj(r0)     // Catch: java.lang.Throwable -> L6d
            if (r0 < 0) goto L55
            if (r0 != 0) goto L70
            if (r6 != 0) goto L70
        L55:
            java.util.concurrent.ThreadPoolExecutor r0 = r5.xj()     // Catch: java.lang.Throwable -> L6d
            r0.execute(r6)     // Catch: java.lang.Throwable -> L6d
            java.util.concurrent.atomic.AtomicInteger r6 = r5.xj     // Catch: java.lang.Throwable -> L6d
            int r6 = r6.get()     // Catch: java.lang.Throwable -> L6d
            int r6 = hf(r6)     // Catch: java.lang.Throwable -> L6d
            int r0 = r5.kd     // Catch: java.lang.Throwable -> L6d
            if (r6 <= r0) goto L6f
            r5.kd = r6     // Catch: java.lang.Throwable -> L6d
            goto L6f
        L6d:
            r6 = move-exception
            goto L7b
        L6f:
            r2 = 1
        L70:
            r7.unlock()     // Catch: java.lang.Throwable -> L79
            if (r2 != 0) goto L78
            r5.kd()
        L78:
            return r2
        L79:
            r6 = move-exception
            goto L7f
        L7b:
            r7.unlock()     // Catch: java.lang.Throwable -> L79
            throw r6     // Catch: java.lang.Throwable -> L79
        L7f:
            r5.kd()
            throw r6
        L83:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tf.xj.y.hf(java.lang.Runnable, boolean):boolean");
    }

    public void xj(Runnable runnable, boolean z) {
        int i = this.xj.get();
        int hf = hf(runnable);
        if (hf(i, C.ENCODING_PCM_A_LAW)) {
            do {
                Runnable poll = this.hf.poll();
                if (poll != null) {
                    if (c(hf) && (poll instanceof w)) {
                        w wVar = (w) poll;
                        wVar.hf();
                        wVar.xj(hf);
                        wVar.xj((y) null);
                        poll.run();
                    } else {
                        xj().execute(poll);
                        return;
                    }
                } else {
                    w();
                    return;
                }
            } while (hf(i, C.ENCODING_PCM_A_LAW));
            hf();
            return;
        }
        hf();
    }

    private int hf(Runnable runnable) {
        if (runnable instanceof w) {
            return ((w) runnable).u();
        }
        return 0;
    }
}
