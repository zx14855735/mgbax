package com.bytedance.sdk.component.tf;

import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static final u xj = new u();
    private final List<WeakReference<ThreadPoolExecutor>> hf = new ArrayList();
    private xj u;
    private hf w;

    public interface hf {
    }

    public interface xj {
    }

    static {
        RBsm();
    }

    private u() {
        hf().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tf.u.4
            @Override // java.lang.Runnable
            public void run() {
            }
        }, 1L, TimeUnit.MINUTES);
    }

    private static /* synthetic */ void RBsm() {
        char[] charArray = "©¥§ä\u00ad«§¯ä¨¥³ä¹¢¯¦¦ä\u0080¤£\u0088¸£®\u00ad¯".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 202);
        }
        String str = new String(charArray);
        char[] charArray2 = "©¦£¤£¾".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 202);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private ScheduledExecutorService hf() {
        return p.hf.pl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        List<ThreadPoolExecutor> xj2 = xj(null, false, false);
        if (xj2 == null || xj2.size() == 0) {
            return;
        }
        if (this.w != null) {
            kd.xj();
        }
        HashMap hashMap = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : xj2) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof tf) {
                    hashMap.put(((tf) threadFactory).xj + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.tf.xj.u) {
                    hashMap.put(((com.bytedance.sdk.component.tf.xj.u) threadFactory).xj() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    hashMap.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
                xj(threadPoolExecutor);
            }
        }
        if (this.w != null) {
            kd.xj();
        }
    }

    public synchronized void hf(com.bytedance.sdk.component.tf.u.u uVar) {
        Iterator<WeakReference<ThreadPoolExecutor>> it = this.hf.iterator();
        while (it.hasNext()) {
            if (it.next().get() == uVar) {
                it.remove();
            }
        }
    }

    public synchronized void xj(com.bytedance.sdk.component.tf.u.u uVar) {
        hf(uVar);
        this.hf.add(new WeakReference<>(uVar));
    }

    public String xj(BlockingQueue blockingQueue) {
        if (blockingQueue instanceof com.bytedance.sdk.component.tf.xj.xj) {
            return ((com.bytedance.sdk.component.tf.xj.xj) blockingQueue).xj();
        }
        return blockingQueue.getClass().getName();
    }

    public ThreadPoolExecutor xj(String str, String str2) {
        List<ThreadPoolExecutor> xj2 = xj(str2, false, true);
        xj(xj2, str);
        ThreadPoolExecutor threadPoolExecutor = xj2.size() > 0 ? xj2.get(0) : null;
        xj();
        return threadPoolExecutor;
    }

    private synchronized List<ThreadPoolExecutor> xj(String str, boolean z, boolean z2) {
        ArrayList arrayList;
        ThreadPoolExecutor threadPoolExecutor;
        boolean z3;
        try {
            arrayList = new ArrayList();
            for (WeakReference<ThreadPoolExecutor> weakReference : this.hf) {
                if (weakReference != null && (threadPoolExecutor = weakReference.get()) != null) {
                    BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                    if (queue instanceof com.bytedance.sdk.component.tf.xj.xj) {
                        z3 = ((com.bytedance.sdk.component.tf.xj.xj) queue).hf() instanceof PriorityBlockingQueue;
                    } else {
                        z3 = queue instanceof PriorityBlockingQueue;
                    }
                    if (!threadPoolExecutor.isShutdown() && !threadPoolExecutor.isTerminated() && !threadPoolExecutor.isTerminating() && threadPoolExecutor.getQueue().isEmpty() && (str == null || !z3)) {
                        if (threadPoolExecutor.getActiveCount() < threadPoolExecutor.getPoolSize()) {
                            arrayList.add(threadPoolExecutor);
                            if (z) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (z2 && !z) {
                try {
                    Collections.sort(arrayList, new Comparator<ThreadPoolExecutor>() { // from class: com.bytedance.sdk.component.tf.u.1
                        @Override // java.util.Comparator
                        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                        public int compare(ThreadPoolExecutor threadPoolExecutor2, ThreadPoolExecutor threadPoolExecutor3) {
                            int poolSize = threadPoolExecutor2.getPoolSize() - threadPoolExecutor2.getActiveCount();
                            int poolSize2 = threadPoolExecutor3.getPoolSize() - threadPoolExecutor3.getActiveCount();
                            if (poolSize2 > poolSize) {
                                return 1;
                            }
                            return poolSize > poolSize2 ? -1 : 0;
                        }
                    });
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
            arrayList.size();
            this.hf.size();
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public void xj() {
        if (p.hf.xj()) {
            hf().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tf.u.2
                @Override // java.lang.Runnable
                public void run() {
                    u.this.w();
                }
            }, 100L, TimeUnit.MILLISECONDS);
        }
    }

    private void xj(final ThreadPoolExecutor threadPoolExecutor) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        final long keepAliveTime = threadPoolExecutor.getKeepAliveTime(timeUnit);
        final boolean allowsCoreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();
        threadPoolExecutor.setKeepAliveTime(1L, timeUnit);
        if (allowsCoreThreadTimeOut) {
            threadPoolExecutor.allowCoreThreadTimeOut(false);
        }
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        hf().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tf.u.3
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                long j = keepAliveTime;
                if (j == 0) {
                    j = 60;
                }
                threadPoolExecutor2.setKeepAliveTime(j, TimeUnit.NANOSECONDS);
                threadPoolExecutor.allowCoreThreadTimeOut(allowsCoreThreadTimeOut);
            }
        }, 10L, TimeUnit.MILLISECONDS);
    }

    private void xj(List<ThreadPoolExecutor> list, String str) {
        if (list == null || list.size() == 0 || this.u == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : list) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof tf) {
                    hashMap.put(((tf) threadFactory).xj + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.tf.xj.u) {
                    hashMap.put(((com.bytedance.sdk.component.tf.xj.u) threadFactory).xj() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    hashMap.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        ThreadGroup hf2 = kd.hf();
        int activeCount = hf2.activeCount();
        Thread[] threadArr = new Thread[(activeCount / 2) + activeCount];
        int enumerate = hf2.enumerate(threadArr);
        for (int i = 0; i < enumerate; i++) {
            Thread thread = threadArr[i];
            Thread.State state = thread.getState();
            if (state == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) {
                String replaceAll = thread.getName().replaceAll("[0-9]", "");
                Integer num = (Integer) hashMap2.get(replaceAll);
                hashMap2.put(replaceAll, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            }
        }
    }

    public void xj(String str) {
        List<ThreadPoolExecutor> xj2 = xj(null, false, true);
        if (xj2 == null || xj2.size() == 0) {
            return;
        }
        xj(xj2, str);
        xj2.size();
        ThreadPoolExecutor threadPoolExecutor = xj2.get(0);
        if (threadPoolExecutor != null) {
            xj(threadPoolExecutor);
        }
        xj();
    }
}
