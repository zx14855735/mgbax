package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends aaaaaoaa {
    private static final long aaaaaaav;
    private static final long aaaaaaeo;
    static aaaaaaaa aaaeaaaa;
    private long aaaaaaae;
    private aaaaaaaa aaaaaaan;
    private boolean aaaaaaau;

    public class aaaaaaa0 implements aaaaoaaa {
        final /* synthetic */ aaaaoaaa aaaaaaaa;

        public aaaaaaa0(aaaaoaaa aaaaoaaaVar) {
            this.aaaaaaaa = aaaaoaaaVar;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public aaaaaoaa aaaaaaa0() {
            return aaaaaaaa.this;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public long aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            aaaaaaaa.this.aaaaaaav();
            try {
                try {
                    long aaaaaaaa = this.aaaaaaaa.aaaaaaaa(aaaaaaaoVar, j);
                    aaaaaaaa.this.aaaaaaaa(true);
                    return aaaaaaaa;
                } catch (IOException e) {
                    throw aaaaaaaa.this.aaaaaaaa(e);
                }
            } catch (Throwable th) {
                aaaaaaaa.this.aaaaaaaa(false);
                throw th;
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            aaaaaaaa.this.aaaaaaav();
            try {
                try {
                    this.aaaaaaaa.close();
                    aaaaaaaa.this.aaaaaaaa(true);
                } catch (IOException e) {
                    throw aaaaaaaa.this.aaaaaaaa(e);
                }
            } catch (Throwable th) {
                aaaaaaaa.this.aaaaaaaa(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.aaaaaaaa + ")";
        }
    }

    public static final class aaaaaaao extends Thread {
        public aaaaaaao() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        
            r1.aaaeaaaa();
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
                java.lang.Class<io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa> r0 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa r1 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa.aaaaaaae()     // Catch: java.lang.Throwable -> Lb
                if (r1 != 0) goto Ld
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                goto L0
            Lb:
                r1 = move-exception
                goto L1b
            Ld:
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa r2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa.aaaeaaaa     // Catch: java.lang.Throwable -> Lb
                if (r1 != r2) goto L16
                r1 = 0
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa.aaaeaaaa = r1     // Catch: java.lang.Throwable -> Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                return
            L16:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                r1.aaaeaaaa()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L1b:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa.aaaaaaao.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        aaaaaaav = millis;
        aaaaaaeo = TimeUnit.MILLISECONDS.toNanos(millis);
        xIqL();
    }

    private long aaaaaaa0(long j) {
        return this.aaaaaaae - j;
    }

    private static synchronized void aaaaaaaa(aaaaaaaa aaaaaaaaVar, long j, boolean z) {
        synchronized (aaaaaaaa.class) {
            try {
                if (aaaeaaaa == null) {
                    aaaeaaaa = new aaaaaaaa();
                    new aaaaaaao().start();
                }
                long nanoTime = System.nanoTime();
                if (j != 0 && z) {
                    aaaaaaaaVar.aaaaaaae = Math.min(j, aaaaaaaaVar.aaaaaaao() - nanoTime) + nanoTime;
                } else if (j != 0) {
                    aaaaaaaaVar.aaaaaaae = j + nanoTime;
                } else {
                    if (!z) {
                        throw new AssertionError();
                    }
                    aaaaaaaaVar.aaaaaaae = aaaaaaaaVar.aaaaaaao();
                }
                long aaaaaaa02 = aaaaaaaaVar.aaaaaaa0(nanoTime);
                aaaaaaaa aaaaaaaaVar2 = aaaeaaaa;
                while (true) {
                    aaaaaaaa aaaaaaaaVar3 = aaaaaaaaVar2.aaaaaaan;
                    if (aaaaaaaaVar3 == null || aaaaaaa02 < aaaaaaaaVar3.aaaaaaa0(nanoTime)) {
                        break;
                    } else {
                        aaaaaaaaVar2 = aaaaaaaaVar2.aaaaaaan;
                    }
                }
                aaaaaaaaVar.aaaaaaan = aaaaaaaaVar2.aaaaaaan;
                aaaaaaaaVar2.aaaaaaan = aaaaaaaaVar;
                if (aaaaaaaaVar2 == aaaeaaaa) {
                    aaaaaaaa.class.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static aaaaaaaa aaaaaaae() {
        aaaaaaaa aaaaaaaaVar = aaaeaaaa.aaaaaaan;
        if (aaaaaaaaVar == null) {
            long nanoTime = System.nanoTime();
            aaaaaaaa.class.wait(aaaaaaav);
            if (aaaeaaaa.aaaaaaan != null || System.nanoTime() - nanoTime < aaaaaaeo) {
                return null;
            }
            return aaaeaaaa;
        }
        long aaaaaaa02 = aaaaaaaaVar.aaaaaaa0(System.nanoTime());
        if (aaaaaaa02 > 0) {
            long j = aaaaaaa02 / C.MICROS_PER_SECOND;
            aaaaaaaa.class.wait(j, (int) (aaaaaaa02 - (C.MICROS_PER_SECOND * j)));
            return null;
        }
        aaaeaaaa.aaaaaaan = aaaaaaaaVar.aaaaaaan;
        aaaaaaaaVar.aaaaaaan = null;
        return aaaaaaaaVar;
    }

    private static /* synthetic */ void xIqL() {
        char[] charArray = "p|~=tr~v=q|j=`{v\u007f\u007f=Y}zQazwtv".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 19);
        }
        String str = new String(charArray);
        char[] charArray2 = "p\u007fz}zg".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 19);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void aaaaaaav() {
        if (this.aaaaaaau) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long aaaaaaan = aaaaaaan();
        boolean aaaaaaac = aaaaaaac();
        if (aaaaaaan != 0 || aaaaaaac) {
            this.aaaaaaau = true;
            aaaaaaaa(this, aaaaaaan, aaaaaaac);
        }
    }

    public final boolean aaaaaaeo() {
        if (!this.aaaaaaau) {
            return false;
        }
        this.aaaaaaau = false;
        return aaaaaaaa(this);
    }

    public void aaaeaaaa() {
    }

    public IOException aaaaaaa0(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class C0526aaaaaaaa implements aaaoaaaa {
        final /* synthetic */ aaaoaaaa aaaaaaaa;

        public C0526aaaaaaaa(aaaoaaaa aaaoaaaaVar) {
            this.aaaaaaaa = aaaoaaaaVar;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
        public void aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            aaaaaaoa.aaaaaaaa(aaaaaaaoVar.aaaaaaa0, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                aeaaaaaa aeaaaaaaVar = aaaaaaaoVar.aaaaaaaa;
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += aeaaaaaaVar.aaaaaaao - aeaaaaaaVar.aaaaaaa0;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    aeaaaaaaVar = aeaaaaaaVar.aaaaaaan;
                }
                aaaaaaaa.this.aaaaaaav();
                try {
                    try {
                        this.aaaaaaaa.aaaaaaa0(aaaaaaaoVar, j2);
                        j -= j2;
                        aaaaaaaa.this.aaaaaaaa(true);
                    } catch (IOException e) {
                        throw aaaaaaaa.this.aaaaaaaa(e);
                    }
                } catch (Throwable th) {
                    aaaaaaaa.this.aaaaaaaa(false);
                    throw th;
                }
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            aaaaaaaa.this.aaaaaaav();
            try {
                try {
                    this.aaaaaaaa.close();
                    aaaaaaaa.this.aaaaaaaa(true);
                } catch (IOException e) {
                    throw aaaaaaaa.this.aaaaaaaa(e);
                }
            } catch (Throwable th) {
                aaaaaaaa.this.aaaaaaaa(false);
                throw th;
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Flushable
        public void flush() {
            aaaaaaaa.this.aaaaaaav();
            try {
                try {
                    this.aaaaaaaa.flush();
                    aaaaaaaa.this.aaaaaaaa(true);
                } catch (IOException e) {
                    throw aaaaaaaa.this.aaaaaaaa(e);
                }
            } catch (Throwable th) {
                aaaaaaaa.this.aaaaaaaa(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.aaaaaaaa + ")";
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
        public aaaaaoaa aaaaaaa0() {
            return aaaaaaaa.this;
        }
    }

    private static synchronized boolean aaaaaaaa(aaaaaaaa aaaaaaaaVar) {
        synchronized (aaaaaaaa.class) {
            aaaaaaaa aaaaaaaaVar2 = aaaeaaaa;
            while (aaaaaaaaVar2 != null) {
                aaaaaaaa aaaaaaaaVar3 = aaaaaaaaVar2.aaaaaaan;
                if (aaaaaaaaVar3 == aaaaaaaaVar) {
                    aaaaaaaaVar2.aaaaaaan = aaaaaaaaVar.aaaaaaan;
                    aaaaaaaaVar.aaaaaaan = null;
                    return false;
                }
                aaaaaaaaVar2 = aaaaaaaaVar3;
            }
            return true;
        }
    }

    public final aaaoaaaa aaaaaaaa(aaaoaaaa aaaoaaaaVar) {
        return new C0526aaaaaaaa(aaaoaaaaVar);
    }

    public final aaaaoaaa aaaaaaaa(aaaaoaaa aaaaoaaaVar) {
        return new aaaaaaa0(aaaaoaaaVar);
    }

    public final void aaaaaaaa(boolean z) {
        if (aaaaaaeo() && z) {
            throw aaaaaaa0((IOException) null);
        }
    }

    public final IOException aaaaaaaa(IOException iOException) {
        return !aaaaaaeo() ? iOException : aaaaaaa0(iOException);
    }
}
