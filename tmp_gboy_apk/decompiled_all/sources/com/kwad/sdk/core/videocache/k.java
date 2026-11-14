package com.kwad.sdk.core.videocache;

import ADYaiT.CtFAbx;
import com.kwad.sdk.utils.ax;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class k {
    private final m aQi;
    private final com.kwad.sdk.core.videocache.a aQj;
    private volatile Thread aQn;
    private volatile boolean nf;
    private final Object aQk = new Object();
    private final Object aQl = new Object();
    private volatile int aQo = -1;
    private final AtomicInteger aQm = new AtomicInteger();

    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.Ms();
        }

        public /* synthetic */ a(k kVar, byte b) {
            this();
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.aQi = (m) ax.checkNotNull(mVar);
        this.aQj = (com.kwad.sdk.core.videocache.a) ax.checkNotNull(aVar);
    }

    private void Mp() {
        int i = this.aQm.get();
        if (i <= 0) {
            return;
        }
        this.aQm.set(0);
        throw new ProxyCacheException(CtFAbx.ASJ6gh(i, "Error reading source ", " times"));
    }

    private synchronized void Mq() {
        try {
            byte b = 0;
            boolean z = (this.aQn == null || this.aQn.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.nf && !this.aQj.isCompleted() && !z) {
                this.aQn = new Thread(new a(this, b), "Source reader for " + this.aQi);
                this.aQn.start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void Mr() {
        synchronized (this.aQk) {
            try {
                try {
                    this.aQk.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
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
    public void Ms() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.kwad.sdk.core.videocache.a r4 = r8.aQj     // Catch: java.lang.Throwable -> L41
            long r2 = r4.Md()     // Catch: java.lang.Throwable -> L41
            com.kwad.sdk.core.videocache.m r4 = r8.aQi     // Catch: java.lang.Throwable -> L41
            r4.aK(r2)     // Catch: java.lang.Throwable -> L41
            com.kwad.sdk.core.videocache.m r4 = r8.aQi     // Catch: java.lang.Throwable -> L41
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L41
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L41
        L19:
            com.kwad.sdk.core.videocache.m r5 = r8.aQi     // Catch: java.lang.Throwable -> L41
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L41
            r6 = -1
            if (r5 == r6) goto L45
            java.lang.Object r6 = r8.aQl     // Catch: java.lang.Throwable -> L41
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L41
            boolean r7 = r8.isStopped()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L35
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
        L2c:
            r8.Mu()
            r8.j(r2, r0)
            return
        L33:
            r4 = move-exception
            goto L43
        L35:
            com.kwad.sdk.core.videocache.a r7 = r8.aQj     // Catch: java.lang.Throwable -> L33
            r7.d(r4, r5)     // Catch: java.lang.Throwable -> L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.j(r2, r0)     // Catch: java.lang.Throwable -> L41
            goto L19
        L41:
            r4 = move-exception
            goto L4c
        L43:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            throw r4     // Catch: java.lang.Throwable -> L41
        L45:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L41
            r8.Mt()     // Catch: java.lang.Throwable -> L41
            goto L2c
        L4c:
            java.util.concurrent.atomic.AtomicInteger r5 = r8.aQm     // Catch: java.lang.Throwable -> L55
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L55
            onError(r4)     // Catch: java.lang.Throwable -> L55
            goto L2c
        L55:
            r4 = move-exception
            r8.Mu()
            r8.j(r2, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.k.Ms():void");
    }

    private void Mt() {
        this.aQo = 100;
        ee(this.aQo);
    }

    private void Mu() {
        try {
            this.aQi.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.aQi, e));
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.nf;
    }

    private void j(long j, long j2) {
        k(j, j2);
        synchronized (this.aQk) {
            this.aQk.notifyAll();
        }
    }

    private void k(long j, long j2) {
        int i = j2 == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.aQo;
        if (j2 >= 0 && z) {
            ee(i);
        }
        this.aQo = i;
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.c.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.c.e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.aQl) {
            try {
                if (!isStopped() && this.aQj.Md() == this.aQi.length()) {
                    this.aQj.complete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void ee(int i) {
    }

    public final void shutdown() {
        synchronized (this.aQl) {
            try {
                com.kwad.sdk.core.d.c.d("ProxyCache", "Shutdown proxy for " + this.aQi);
                try {
                    this.nf = true;
                    if (this.aQn != null) {
                        this.aQn.interrupt();
                    }
                    this.aQj.close();
                } catch (ProxyCacheException e) {
                    onError(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int a(byte[] bArr, long j, int i) {
        l.b(bArr, j, 1024);
        while (!this.aQj.isCompleted() && this.aQj.Md() < ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS + j && !this.nf) {
            Mq();
            Mr();
            Mp();
        }
        int a2 = this.aQj.a(bArr, j, 1024);
        if (this.aQj.isCompleted() && this.aQo != 100) {
            this.aQo = 100;
            ee(100);
        }
        return a2;
    }
}
