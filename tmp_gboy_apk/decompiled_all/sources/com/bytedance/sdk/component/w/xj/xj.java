package com.bytedance.sdk.component.w.xj;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends jk {
    private static final long hf;
    private static final long u;
    static xj xj;
    private long c;
    private boolean kd;
    private xj y;

    /* renamed from: com.bytedance.sdk.component.w.xj.xj$xj, reason: collision with other inner class name */
    public static final class C0125xj extends com.bytedance.sdk.component.tf.u.w {
        public C0125xj() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0017, code lost:
        
            r1.m_();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.bytedance.sdk.component.w.xj.xj> r0 = com.bytedance.sdk.component.w.xj.xj.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1d
                com.bytedance.sdk.component.w.xj.xj r1 = com.bytedance.sdk.component.w.xj.xj.u()     // Catch: java.lang.Throwable -> Lb
                if (r1 != 0) goto Ld
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                goto L0
            Lb:
                r1 = move-exception
                goto L1b
            Ld:
                com.bytedance.sdk.component.w.xj.xj r2 = com.bytedance.sdk.component.w.xj.xj.xj     // Catch: java.lang.Throwable -> Lb
                if (r1 != r2) goto L16
                r1 = 0
                com.bytedance.sdk.component.w.xj.xj.xj = r1     // Catch: java.lang.Throwable -> Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                goto L1d
            L16:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                r1.m_()     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1d
                goto L0
            L1b:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                throw r1     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1d
            L1d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.xj.xj.C0125xj.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        hf = millis;
        u = TimeUnit.MILLISECONDS.toNanos(millis);
        jAXsdDn();
    }

    private static /* synthetic */ void jAXsdDn() {
        char[] charArray = "\f\u0000\u0002A\b\u000e\u0002\nA\r\u0000\u0016A\u001c\u0007\n\u0003\u0003A%\u0001\u0006-\u001d\u0006\u000b\b\n".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'o');
        }
        String str = new String(charArray);
        char[] charArray2 = "\f\u0003\u0006\u0001\u0006\u001b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'o');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static xj u() {
        xj xjVar = xj.y;
        if (xjVar == null) {
            long nanoTime = System.nanoTime();
            xj.class.wait(hf);
            if (xj.y != null || System.nanoTime() - nanoTime < u) {
                return null;
            }
            return xj;
        }
        long hf2 = xjVar.hf(System.nanoTime());
        if (hf2 > 0) {
            long j = hf2 / C.MICROS_PER_SECOND;
            xj.class.wait(j, (int) (hf2 - (C.MICROS_PER_SECOND * j)));
            return null;
        }
        xj.y = xjVar.y;
        xjVar.y = null;
        return xjVar;
    }

    public final boolean hf() {
        if (!this.kd) {
            return false;
        }
        this.kd = false;
        return xj(this);
    }

    public void m_() {
    }

    public final void xj() {
        if (this.kd) {
            return;
        }
        long n_ = n_();
        boolean w = w();
        if (n_ != 0 || w) {
            this.kd = true;
            xj(this, n_, w);
        }
    }

    private long hf(long j) {
        return this.c - j;
    }

    public IOException hf(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static synchronized void xj(xj xjVar, long j, boolean z) {
        synchronized (xj.class) {
            if (xj == null) {
                xj = new xj();
                C0125xj c0125xj = new C0125xj();
                c0125xj.setName("csj_watch_dog");
                try {
                    c0125xj.start();
                } catch (Throwable unused) {
                }
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                xjVar.c = Math.min(j, xjVar.o_() - nanoTime) + nanoTime;
            } else if (j != 0) {
                xjVar.c = j + nanoTime;
            } else if (z) {
                xjVar.c = xjVar.o_();
            } else {
                throw new AssertionError();
            }
            long hf2 = xjVar.hf(nanoTime);
            xj xjVar2 = xj;
            while (true) {
                xj xjVar3 = xjVar2.y;
                if (xjVar3 == null || hf2 < xjVar3.hf(nanoTime)) {
                    break;
                } else {
                    xjVar2 = xjVar2.y;
                }
            }
            xjVar.y = xjVar2.y;
            xjVar2.y = xjVar;
            if (xjVar2 == xj) {
                xj.class.notify();
            }
        }
    }

    private static synchronized boolean xj(xj xjVar) {
        synchronized (xj.class) {
            xj xjVar2 = xj;
            while (xjVar2 != null) {
                xj xjVar3 = xjVar2.y;
                if (xjVar3 == xjVar) {
                    xjVar2.y = xjVar.y;
                    xjVar.y = null;
                    return false;
                }
                xjVar2 = xjVar3;
            }
            return true;
        }
    }

    public final yo xj(final yo yoVar) {
        return new yo() { // from class: com.bytedance.sdk.component.w.xj.xj.1
            @Override // com.bytedance.sdk.component.w.xj.yo
            public void a_(w wVar, long j) {
                try {
                    pz.xj(wVar.hf, 0L, j);
                    long j2 = j;
                    while (true) {
                        long j3 = 0;
                        if (j2 <= 0) {
                            return;
                        }
                        qt qtVar = wVar.xj;
                        while (true) {
                            if (j3 >= 65536) {
                                break;
                            }
                            j3 += qtVar.w - qtVar.hf;
                            if (j3 >= j2) {
                                j3 = j2;
                                break;
                            }
                            qtVar = qtVar.y;
                        }
                        xj.this.xj();
                        try {
                            try {
                                yoVar.a_(wVar, j3);
                                j2 -= j3;
                                xj.this.xj(true);
                            } catch (IOException e) {
                                throw xj.this.xj(e);
                            }
                        } catch (Throwable th) {
                            xj.this.xj(false);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    throw new IOException(e2);
                }
            }

            @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                xj.this.xj();
                try {
                    try {
                        yoVar.close();
                        xj.this.xj(true);
                    } catch (IOException e) {
                        throw xj.this.xj(e);
                    }
                } catch (Throwable th) {
                    xj.this.xj(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Flushable
            public void flush() {
                xj.this.xj();
                try {
                    try {
                        yoVar.flush();
                        xj.this.xj(true);
                    } catch (IOException e) {
                        throw xj.this.xj(e);
                    }
                } catch (Throwable th) {
                    xj.this.xj(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + yoVar + ")";
            }

            @Override // com.bytedance.sdk.component.w.xj.yo
            public jk xj() {
                return xj.this;
            }
        };
    }

    public final v xj(final v vVar) {
        return new v() { // from class: com.bytedance.sdk.component.w.xj.xj.2
            @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                xj.this.xj();
                try {
                    try {
                        vVar.close();
                        xj.this.xj(true);
                    } catch (IOException e) {
                        throw xj.this.xj(e);
                    }
                } catch (Throwable th) {
                    xj.this.xj(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + vVar + ")";
            }

            @Override // com.bytedance.sdk.component.w.xj.v
            public long xj(w wVar, long j) {
                xj.this.xj();
                try {
                    try {
                        long xj2 = vVar.xj(wVar, j);
                        xj.this.xj(true);
                        return xj2;
                    } catch (IOException e) {
                        throw xj.this.xj(e);
                    }
                } catch (Throwable th) {
                    xj.this.xj(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.w.xj.v
            public jk xj() {
                return xj.this;
            }
        };
    }

    public final void xj(boolean z) {
        if (hf() && z) {
            throw hf((IOException) null);
        }
    }

    public final IOException xj(IOException iOException) {
        return !hf() ? iOException : hf(iOException);
    }
}
