package com.kwad.framework.filedownloader.f;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class b {
    private static volatile ThreadPoolExecutor atI;

    public static class a implements ThreadFactory {
        private static final AtomicInteger atJ = new AtomicInteger(1);
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        static {
            KhKT();
        }

        public a(String str) {
            this.namePrefix = f.bS(str);
        }

        private static /* synthetic */ void KhKT() {
            char[] charArray = "\u0012\u001e\u001c_\u0016\u0010\u001c\u0014_\u0013\u001e\b_\u0002\u0019\u0014\u001d\u001d_;\u001f\u00183\u0003\u0018\u0015\u0016\u0014".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'q');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0012\u001d\u0018\u001f\u0018\u0005".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'q');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, "ksad-" + this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    private static boolean Bb() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.Bb();
        }
        return false;
    }

    private static ThreadPoolExecutor Bc() {
        if (atI == null) {
            synchronized (b.class) {
                try {
                    if (atI == null) {
                        com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(""));
                        atI = bVar;
                        com.kwad.sdk.core.threads.c.a(bVar, "ksad-filedownload-default");
                    }
                } finally {
                }
            }
        }
        return atI;
    }

    @Deprecated
    public static ThreadPoolExecutor a(int i, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        if (Bb()) {
            return Bc();
        }
        com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(i, i, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        bVar.allowCoreThreadTimeOut(true);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor bM(String str) {
        if (Bb()) {
            return Bc();
        }
        com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor u(int i, String str) {
        return Bb() ? Bc() : a(i, new LinkedBlockingQueue(), str);
    }
}
