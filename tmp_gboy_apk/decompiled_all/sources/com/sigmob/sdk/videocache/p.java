package com.sigmob.sdk.videocache;

import ADYaiT.CtFAbx;
import com.czhj.sdk.logger.SigmobLog;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class p {

    /* renamed from: a, reason: collision with root package name */
    private static final int f13739a = 1;
    private final u b;
    private final c c;
    private volatile Thread g;
    private volatile boolean h;
    private final Object d = new Object();
    private final Object e = new Object();
    private volatile int i = -1;
    private final AtomicInteger f = new AtomicInteger();

    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.e();
        }
    }

    public p(u uVar, c cVar) {
        this.b = (u) o.a(uVar);
        this.c = (c) o.a(cVar);
    }

    private void b() {
        int i = this.f.get();
        if (i < 1) {
            return;
        }
        this.f.set(0);
        throw new q(CtFAbx.ASJ6gh(i, "Error reading source ", " times"));
    }

    private synchronized void c() {
        try {
            boolean z = (this.g == null || this.g.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.h && !this.c.d() && !z) {
                SigmobLog.d("Thread create ,current thread num :" + Thread.activeCount());
                this.g = new Thread(new a(), "Source reader for " + this.b);
                this.g.start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void d() {
        synchronized (this.d) {
            try {
                try {
                    this.d.wait(1000L);
                } catch (InterruptedException e) {
                    throw new q("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        long j = -1;
        long j2 = 0;
        try {
            j2 = this.c.a();
            this.b.a(j2);
            j = this.b.a();
            byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
            while (true) {
                int a2 = this.b.a(bArr);
                if (a2 == -1) {
                    g();
                    f();
                    i();
                    b(j2, j);
                    synchronized (this.d) {
                        this.d.notifyAll();
                    }
                    return;
                }
                synchronized (this.e) {
                    if (h()) {
                        SigmobLog.d("SourceReaderRunnable停止从服务器下载视频数据");
                        i();
                        b(j2, j);
                        synchronized (this.d) {
                            this.d.notifyAll();
                        }
                        return;
                    }
                    this.c.a(bArr, a2);
                }
                j2 += a2;
                b(j2, j);
            }
        } catch (Throwable th) {
            try {
                this.f.incrementAndGet();
                b(th);
                c(th);
                i();
                b(j2, j);
                synchronized (this.d) {
                    this.d.notifyAll();
                }
            } catch (Throwable th2) {
                i();
                b(j2, j);
                synchronized (this.d) {
                    this.d.notifyAll();
                    throw th2;
                }
            }
        }
    }

    private void f() {
        this.i = 100;
        a(this.i);
    }

    private void g() {
        synchronized (this.e) {
            try {
                if (!h() && this.c.a() == this.b.a()) {
                    this.c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.h;
    }

    private void i() {
        try {
            this.b.b();
        } catch (q e) {
            b(new q("Error closing source " + this.b, e));
        }
    }

    public int a(byte[] bArr, long j, int i) {
        r.a(bArr, j, i);
        while (!this.c.d() && this.c.a() < i + j && !this.h) {
            c();
            d();
            b();
        }
        int a2 = this.c.a(bArr, j, i);
        if (this.c.d() && this.i != 100) {
            this.i = 100;
            a(100);
        }
        return a2;
    }

    private void c(Throwable th) {
        a(th);
    }

    public void a() {
        synchronized (this.e) {
            try {
                SigmobLog.d("Shutdown proxy for " + this.b);
                try {
                    this.h = true;
                    if (this.g != null) {
                        this.g.interrupt();
                    }
                    this.c.b();
                } catch (q e) {
                    b(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i) {
    }

    public void a(long j, long j2) {
        int i = j2 == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.i;
        if (j2 >= 0 && z) {
            a(i);
        }
        this.i = i;
    }

    public void a(Throwable th) {
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }

    public final void b(Throwable th) {
        if (th instanceof l) {
            SigmobLog.d("ProxyCache is interrupted");
        } else {
            SigmobLog.e("ProxyCache error", th);
        }
    }
}
