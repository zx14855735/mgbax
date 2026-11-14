package com.bykv.vk.component.ttvideo.utils;

import com.bytedance.sdk.component.tf.tf;
import com.bytedance.sdk.component.tf.u.u;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class LiveThreadPool {
    private static final String TAG = "LiveThreadPool";
    private static final int THREADPOOL_MAX_RUNNING_TASK_SIZE = 5;
    private static volatile ThreadPoolExecutor mExecutorInstance;
    private static Deque<AsyncRunnable> mReadyRunnables = new ArrayDeque();
    private static Deque<AsyncRunnable> mRunningRunnables = new ArrayDeque();

    public static class AsyncRunnable implements Runnable {
        private Runnable mRunnable;

        public AsyncRunnable(Runnable runnable) {
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRunnable.run();
            LiveThreadPool._finished(this);
        }
    }

    static {
        yVqSM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void _finished(AsyncRunnable asyncRunnable) {
        synchronized (LiveThreadPool.class) {
            mRunningRunnables.remove(asyncRunnable);
            _promoteRunnable();
        }
    }

    private static void _promoteRunnable() {
        if (mReadyRunnables.size() > 0) {
            Iterator<AsyncRunnable> it = mReadyRunnables.iterator();
            if (it.hasNext()) {
                AsyncRunnable next = it.next();
                it.remove();
                mRunningRunnables.add(next);
                mExecutorInstance.execute(next);
            }
        }
    }

    public static synchronized Future addExecuteTask(Runnable runnable) {
        synchronized (LiveThreadPool.class) {
            if (runnable == null) {
                return null;
            }
            try {
                if (mExecutorInstance == null) {
                    getExecutorInstance();
                }
                getPoolSize();
                AsyncRunnable asyncRunnable = new AsyncRunnable(runnable);
                if (mRunningRunnables.size() >= 5) {
                    mReadyRunnables.add(asyncRunnable);
                    return null;
                }
                mRunningRunnables.add(asyncRunnable);
                return mExecutorInstance.submit(asyncRunnable);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ThreadPoolExecutor getExecutorInstance() {
        if (mExecutorInstance == null) {
            synchronized (LiveThreadPool.class) {
                try {
                    if (mExecutorInstance == null) {
                        mExecutorInstance = new u(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new tf("iveThreadPool"));
                    }
                } finally {
                }
            }
        }
        return mExecutorInstance;
    }

    public static int getPoolSize() {
        if (mExecutorInstance == null) {
            getExecutorInstance();
        }
        return mExecutorInstance.getPoolSize();
    }

    public static void setExecutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (LiveThreadPool.class) {
            mExecutorInstance = threadPoolExecutor;
        }
    }

    public static void shutdown() {
        if (mExecutorInstance != null) {
            mExecutorInstance.shutdown();
        }
    }

    private static /* synthetic */ void yVqSM() {
        char[] charArray = "\u009a\u0096\u0094×\u009e\u0098\u0094\u009c×\u009b\u0096\u0080×\u008a\u0091\u009c\u0095\u0095×³\u0097\u0090»\u008b\u0090\u009d\u009e\u009c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 249);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009a\u0095\u0090\u0097\u0090\u008d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 249);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
