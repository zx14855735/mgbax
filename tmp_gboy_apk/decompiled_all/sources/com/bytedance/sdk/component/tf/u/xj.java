package com.bytedance.sdk.component.tf.u;

import com.bytedance.sdk.component.tf.p;
import com.bytedance.sdk.component.tf.xj.y;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends ThreadPoolExecutor implements com.bytedance.sdk.component.tf.hf {
    public static final RejectedExecutionHandler xj = new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.tf.u.xj.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor != null && (threadPoolExecutor instanceof ScheduledThreadPoolExecutor) && threadPoolExecutor.getCorePoolSize() == 1) {
                p pVar = p.hf;
                ScheduledExecutorService pl2 = pVar.pl();
                if (pl2.isShutdown() || pl2.isTerminated()) {
                    pVar.d().execute(runnable);
                } else {
                    pl2.execute(runnable);
                }
            } else {
                p.hf.d().execute(runnable);
            }
            p.hf.c();
        }
    };
    private com.bytedance.sdk.component.tf.hf hf;

    static {
        wPzEYzN();
    }

    public xj(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, xj);
    }

    private static /* synthetic */ void wPzEYzN() {
        char[] charArray = "òþü¿öðüô¿óþè¿âùôýý¿ÛÿøÓãøõöô".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 145);
        }
        String str = new String(charArray);
        char[] charArray2 = "òýøÿøå".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 145);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public void allowCoreThreadTimeOut(boolean z) {
        this.hf.allowCoreThreadTimeOut(z);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public boolean allowsCoreThreadTimeOut() {
        return this.hf.allowsCoreThreadTimeOut();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.hf.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.tf.hf
    public void execute(Runnable runnable) {
        this.hf.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public int getActiveCount() {
        return this.hf.getActiveCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public long getCompletedTaskCount() {
        return this.hf.getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public int getCorePoolSize() {
        return this.hf.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return this.hf.getKeepAliveTime(timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public int getLargestPoolSize() {
        return this.hf.getLargestPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public int getMaximumPoolSize() {
        return this.hf.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public int getPoolSize() {
        return this.hf.getPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public BlockingQueue<Runnable> getQueue() {
        return this.hf.getQueue();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.hf.getRejectedExecutionHandler();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public long getTaskCount() {
        return this.hf.getTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public ThreadFactory getThreadFactory() {
        return this.hf.getThreadFactory();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public boolean isShutdown() {
        return this.hf.isShutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public boolean isTerminated() {
        return this.hf.isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public boolean isTerminating() {
        return this.hf.isTerminating();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public int prestartAllCoreThreads() {
        return this.hf.prestartAllCoreThreads();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public boolean prestartCoreThread() {
        return this.hf.prestartCoreThread();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public void purge() {
        this.hf.purge();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public boolean remove(Runnable runnable) {
        return this.hf.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public void setCorePoolSize(int i) {
        this.hf.setCorePoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        this.hf.setKeepAliveTime(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public void setMaximumPoolSize(int i) {
        this.hf.setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        this.hf.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.hf.setThreadFactory(threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public void shutdown() {
        com.bytedance.sdk.component.tf.hf hfVar = this.hf;
        if (hfVar != null) {
            hfVar.shutdown();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public List<Runnable> shutdownNow() {
        return this.hf.shutdownNow();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public Future<?> submit(Runnable runnable) {
        return this.hf.submit(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tf.hf
    public String toString() {
        com.bytedance.sdk.component.tf.hf hfVar = this.hf;
        return hfVar != null ? hfVar.toString() : super.toString();
    }

    public xj(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.hf = new y(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler, this);
        p.hf.c();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public <T> Future<T> submit(Callable<T> callable) {
        return this.hf.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tf.hf
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.hf.submit(runnable, t);
    }
}
