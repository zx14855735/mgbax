package com.bytedance.sdk.component.tf;

import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class kd {
    public static ThreadGroup hf() {
        try {
            Field declaredField = ThreadGroup.class.getDeclaredField("systemThreadGroup");
            declaredField.setAccessible(true);
            return (ThreadGroup) declaredField.get(ThreadGroup.class);
        } catch (Exception e) {
            xj(e);
            return null;
        }
    }

    private static void xj(Throwable th) {
        th.getMessage();
    }

    public static int xj() {
        ThreadGroup hf = hf();
        if (hf == null) {
            return 0;
        }
        int activeCount = hf.activeCount();
        try {
            return hf.enumerate(new Thread[(activeCount / 2) + activeCount]);
        } catch (Throwable unused) {
            return activeCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            xj(e);
        }
        BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
        while (true) {
            if (queue != null) {
                try {
                    if (queue.size() > 0) {
                        while (true) {
                            Runnable poll = queue.poll(0L, TimeUnit.MILLISECONDS);
                            if (poll == null) {
                                break;
                            } else {
                                poll.run();
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (threadPoolExecutor.getActiveCount() == 0) {
                threadPoolExecutor.shutdown();
                return;
            }
            Thread.sleep(1000L);
        }
    }

    public static void xj(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            try {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                threadPoolExecutor.setKeepAliveTime(2L, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                xj(e);
            }
            executorService.execute(new Runnable() { // from class: com.bytedance.sdk.component.tf.kd.1
                @Override // java.lang.Runnable
                public void run() {
                    kd.hf(threadPoolExecutor);
                }
            });
        }
    }
}
