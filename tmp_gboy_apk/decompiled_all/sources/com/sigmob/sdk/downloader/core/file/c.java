package com.sigmob.sdk.downloader.core.file;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13401a = "FileLock";
    private static final long d = TimeUnit.MILLISECONDS.toNanos(100);
    private final Map<String, AtomicInteger> b;
    private final Map<String, Thread> c;

    static {
        oCDG();
    }

    public c() {
        this(new HashMap(), new HashMap());
    }

    private static /* synthetic */ void oCDG() {
        char[] charArray = "}qs0y\u007fs{0|qg0mv{rr0Tpw\\lwzy{".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 30);
        }
        String str = new String(charArray);
        char[] charArray2 = "}rwpwj".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 30);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void a() {
        LockSupport.park(Long.valueOf(d));
    }

    public void b(String str) {
        AtomicInteger atomicInteger;
        Thread thread;
        synchronized (this.b) {
            atomicInteger = this.b.get(str);
        }
        if (atomicInteger == null || atomicInteger.decrementAndGet() != 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.b(f13401a, "decreaseLock decrease lock-count to 0 " + str);
        synchronized (this.c) {
            try {
                thread = this.c.get(str);
                if (thread != null) {
                    this.c.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (thread != null) {
            com.sigmob.sdk.downloader.core.c.b(f13401a, "decreaseLock " + str + " unpark locked thread " + atomicInteger);
            a(thread);
        }
        synchronized (this.b) {
            this.b.remove(str);
        }
    }

    public void c(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.b) {
            atomicInteger = this.b.get(str);
        }
        if (atomicInteger == null || atomicInteger.get() <= 0) {
            return;
        }
        synchronized (this.c) {
            this.c.put(str, Thread.currentThread());
        }
        com.sigmob.sdk.downloader.core.c.b(f13401a, "waitForRelease start " + str);
        while (!a(atomicInteger)) {
            a();
        }
        com.sigmob.sdk.downloader.core.c.b(f13401a, "waitForRelease finish " + str);
    }

    public c(Map<String, AtomicInteger> map, Map<String, Thread> map2) {
        this.b = map;
        this.c = map2;
    }

    public void a(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.b) {
            atomicInteger = this.b.get(str);
        }
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            synchronized (this.b) {
                this.b.put(str, atomicInteger);
            }
        }
        com.sigmob.sdk.downloader.core.c.b(f13401a, "increaseLock increase lock-count to " + atomicInteger.incrementAndGet() + str);
    }

    public void a(Thread thread) {
        LockSupport.unpark(thread);
    }

    public boolean a(AtomicInteger atomicInteger) {
        return atomicInteger.get() <= 0;
    }
}
