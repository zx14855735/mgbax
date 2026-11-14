package com.fl.saas.config.utils.net;

import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ThreadPoolManager {
    private static final ThreadPoolManager threadPoolManager = new ThreadPoolManager();
    private final ThreadPoolExecutor mThreadPoolExecutor;
    private final LinkedBlockingQueue<Runnable> mQueue = new LinkedBlockingQueue<>();
    public Runnable coreThread = new Runnable() { // from class: com.fl.saas.config.utils.net.ThreadPoolManager.1
        Runnable run = null;

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    this.run = (Runnable) ThreadPoolManager.this.mQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ThreadPoolManager.this.mThreadPoolExecutor.execute(this.run);
            }
        }
    };
    private final ScheduledExecutorService mScheduledExecutorService = Executors.newScheduledThreadPool(2);

    static {
        GuPM();
    }

    private ThreadPoolManager() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 10, 15L, TimeUnit.SECONDS, new ArrayBlockingQueue(4), new RejectedExecutionHandler() { // from class: com.fl.saas.config.utils.net.A2egSU
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                ThreadPoolManager.this.lambda$new$0(runnable, threadPoolExecutor2);
            }
        });
        this.mThreadPoolExecutor = threadPoolExecutor;
        threadPoolExecutor.execute(this.coreThread);
    }

    private static /* synthetic */ void GuPM() {
        char[] charArray = "]QS\u0010Y_S[\u0010\\QG\u0010MV[RR\u0010tPW|LWZY[".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '>');
        }
        String str = new String(charArray);
        char[] charArray2 = "]RWPWJ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '>');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static ThreadPoolManager getInstance() {
        return threadPoolManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        addTask(runnable);
    }

    public void addTask(Runnable runnable) {
        if (runnable != null) {
            try {
                this.mQueue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getThreadActiveCount() {
        ThreadPoolExecutor threadPoolExecutor = this.mThreadPoolExecutor;
        if (threadPoolExecutor == null) {
            return 0;
        }
        return threadPoolExecutor.getActiveCount();
    }

    public int getThreadCount() {
        ThreadPoolExecutor threadPoolExecutor = this.mThreadPoolExecutor;
        if (threadPoolExecutor == null) {
            return 0;
        }
        return threadPoolExecutor.getPoolSize();
    }

    public void removeTask(Runnable runnable) {
        if (runnable == null || this.mQueue.remove(runnable)) {
            return;
        }
        this.mThreadPoolExecutor.remove(runnable);
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.mScheduledExecutorService.schedule(runnable, j, timeUnit);
    }
}
