package com.baidu.mobads.sdk.internal;

import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class bf {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9756a = "ThreadPoolFactory";
    private static final int b = 2;
    private static final int c = 60;
    private static ThreadPoolExecutor d;
    private static LinkedBlockingQueue<Runnable> e;
    private static final ThreadFactory f = new bg();
    private static final RejectedExecutionHandler g = new bi();

    static {
        LTkwFUY();
    }

    private static /* synthetic */ void LTkwFUY() {
        char[] charArray = "ýñó°ùÿóû°üñç°íöûòò°Ôð÷Üì÷úùû".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 158);
        }
        String str = new String(charArray);
        char[] charArray2 = "ýò÷ð÷ê".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 158);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static ThreadPoolExecutor a(int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f);
        threadPoolExecutor.setRejectedExecutionHandler(g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor a(int i) {
        return new ScheduledThreadPoolExecutor(i, f);
    }
}
