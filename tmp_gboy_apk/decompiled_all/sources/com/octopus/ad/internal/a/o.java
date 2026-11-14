package com.octopus.ad.internal.a;

import ADYaiT.CtFAbx;
import com.octopus.ad.internal.utilities.HaoboLog;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class o {

    /* renamed from: a, reason: collision with root package name */
    private final r f12401a;
    private final com.octopus.ad.internal.a.a b;
    private volatile Thread f;
    private volatile boolean g;
    private final Object c = new Object();
    private final Object d = new Object();
    private volatile int h = -1;
    private final AtomicInteger e = new AtomicInteger();

    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.e();
        }
    }

    public o(r rVar, com.octopus.ad.internal.a.a aVar) {
        this.f12401a = (r) n.a(rVar);
        this.b = (com.octopus.ad.internal.a.a) n.a(aVar);
    }

    private void b() {
        int i = this.e.get();
        if (i < 1) {
            return;
        }
        this.e.set(0);
        throw new p(CtFAbx.ASJ6gh(i, "Error reading source ", " times"));
    }

    private synchronized void c() {
        try {
            boolean z = (this.f == null || this.f.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.g && !this.b.d() && !z) {
                this.f = new Thread(new a(), "Source reader for " + this.f12401a);
                this.f.start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void d() {
        synchronized (this.c) {
            try {
                try {
                    this.c.wait(1000L);
                } catch (InterruptedException e) {
                    throw new p("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
    
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.octopus.ad.internal.a.a r4 = r8.b     // Catch: java.lang.Throwable -> L41
            long r2 = r4.a()     // Catch: java.lang.Throwable -> L41
            com.octopus.ad.internal.a.r r4 = r8.f12401a     // Catch: java.lang.Throwable -> L41
            r4.a(r2)     // Catch: java.lang.Throwable -> L41
            com.octopus.ad.internal.a.r r4 = r8.f12401a     // Catch: java.lang.Throwable -> L41
            long r0 = r4.a()     // Catch: java.lang.Throwable -> L41
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L41
        L19:
            com.octopus.ad.internal.a.r r5 = r8.f12401a     // Catch: java.lang.Throwable -> L41
            int r5 = r5.a(r4)     // Catch: java.lang.Throwable -> L41
            r6 = -1
            if (r5 == r6) goto L45
            java.lang.Object r6 = r8.d     // Catch: java.lang.Throwable -> L41
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L41
            boolean r7 = r8.h()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L35
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
        L2c:
            r8.i()
            r8.b(r2, r0)
            return
        L33:
            r4 = move-exception
            goto L43
        L35:
            com.octopus.ad.internal.a.a r7 = r8.b     // Catch: java.lang.Throwable -> L33
            r7.a(r4, r5)     // Catch: java.lang.Throwable -> L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.b(r2, r0)     // Catch: java.lang.Throwable -> L41
            goto L19
        L41:
            r4 = move-exception
            goto L4c
        L43:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            throw r4     // Catch: java.lang.Throwable -> L41
        L45:
            r8.g()     // Catch: java.lang.Throwable -> L41
            r8.f()     // Catch: java.lang.Throwable -> L41
            goto L2c
        L4c:
            java.util.concurrent.atomic.AtomicInteger r5 = r8.e     // Catch: java.lang.Throwable -> L5b
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L5b
            r8.a(r4)     // Catch: java.lang.Throwable -> L5b
            r8.i()
            r8.b(r2, r0)
            return
        L5b:
            r4 = move-exception
            r8.i()
            r8.b(r2, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.internal.a.o.e():void");
    }

    private void f() {
        this.h = 100;
        a(this.h);
    }

    private void g() {
        synchronized (this.d) {
            try {
                if (!h() && this.b.a() == this.f12401a.a()) {
                    this.b.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.g;
    }

    private void i() {
        try {
            this.f12401a.b();
        } catch (p e) {
            a(new p("Error closing source " + this.f12401a, e));
        }
    }

    public void a(int i) {
    }

    public int a(byte[] bArr, long j, int i) {
        q.a(bArr, j, i);
        while (!this.b.d() && this.b.a() < i + j && !this.g) {
            c();
            d();
            b();
        }
        int a2 = this.b.a(bArr, j, i);
        a(this.h);
        if (this.b.d() && this.h != 100) {
            this.h = 100;
            a(100);
        }
        return a2;
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    public void a() {
        synchronized (this.d) {
            try {
                HaoboLog.d(HaoboLog.proxyCacheLogTag, "Shutdown proxy for " + this.f12401a);
                try {
                    this.g = true;
                    if (this.f != null) {
                        this.f.interrupt();
                    }
                    this.b.b();
                } catch (p e) {
                    a(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(long j, long j2) {
        int i = j2 == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.h;
        if (j2 >= 0 && z) {
            a(i);
        }
        this.h = i;
    }

    public final void a(Throwable th) {
        if (th instanceof l) {
            HaoboLog.d(HaoboLog.proxyCacheLogTag, "ProxyCache is interrupted");
        } else {
            HaoboLog.e(HaoboLog.proxyCacheLogTag, "ProxyCache error", th);
        }
    }
}
