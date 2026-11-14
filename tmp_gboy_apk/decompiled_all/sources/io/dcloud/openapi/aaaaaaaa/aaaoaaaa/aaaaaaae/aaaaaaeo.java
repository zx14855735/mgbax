package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaao;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaeo {
    static final /* synthetic */ boolean aaaaaeaa = true;
    long aaaaaaa0;
    long aaaaaaaa = 0;
    final aaaaaaae aaaaaaac;
    private final aaaaaaa0 aaaaaaae;
    private boolean aaaaaaan;
    final int aaaaaaao;
    private final Deque aaaaaaau;
    final aaaaaaaa aaaaaaav;
    final aaaaaaao aaaaaaeo;
    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaeaaa;
    final aaaaaaao aaaeaaaa;

    public class aaaaaaao extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa {
        public aaaaaaao() {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa
        public IOException aaaaaaa0(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void aaaaeaaa() {
            if (aaaaaaeo()) {
                throw aaaaaaa0((IOException) null);
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa
        public void aaaeaaaa() {
            aaaaaaeo.this.aaaaaaao(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.CANCEL);
            aaaaaaeo.this.aaaaaaac.aaaaaeaa();
        }
    }

    public aaaaaaeo(int i, aaaaaaae aaaaaaaeVar, boolean z, boolean z2, aaaoaaaa aaaoaaaaVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.aaaaaaau = arrayDeque;
        this.aaaaaaeo = new aaaaaaao();
        this.aaaeaaaa = new aaaaaaao();
        this.aaaaeaaa = null;
        if (aaaaaaaeVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.aaaaaaao = i;
        this.aaaaaaac = aaaaaaaeVar;
        this.aaaaaaa0 = aaaaaaaeVar.aaaaaaoa.aaaaaaao();
        aaaaaaa0 aaaaaaa0Var = new aaaaaaa0(aaaaaaaeVar.aaaaaoaa.aaaaaaao());
        this.aaaaaaae = aaaaaaa0Var;
        aaaaaaaa aaaaaaaaVar = new aaaaaaaa();
        this.aaaaaaav = aaaaaaaaVar;
        aaaaaaa0Var.aaaaaaau = z2;
        aaaaaaaaVar.aaaaaaao = z;
        if (aaaoaaaaVar != null) {
            arrayDeque.add(aaaoaaaaVar);
        }
        if (aaaaaaan() && aaaoaaaaVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!aaaaaaan() && aaaoaaaaVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    public static /* synthetic */ aaaaaaao.aaaaaaaa aaaaaaa0(aaaaaaeo aaaaaaeoVar) {
        aaaaaaeoVar.getClass();
        return null;
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa aaaaaaac() {
        synchronized (this) {
            try {
                if (!this.aaaaaaan && !aaaaaaan()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.aaaaaaav;
    }

    public synchronized boolean aaaaaaae() {
        try {
            if (this.aaaaeaaa != null) {
                return false;
            }
            aaaaaaa0 aaaaaaa0Var = this.aaaaaaae;
            if (!aaaaaaa0Var.aaaaaaau) {
                if (aaaaaaa0Var.aaaaaaac) {
                }
                return true;
            }
            aaaaaaaa aaaaaaaaVar = this.aaaaaaav;
            if (aaaaaaaaVar.aaaaaaao || aaaaaaaaVar.aaaaaaa0) {
                if (this.aaaaaaan) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean aaaaaaan() {
        return this.aaaaaaac.aaaaaaaa == ((this.aaaaaaao & 1) == 1);
    }

    public int aaaaaaao() {
        return this.aaaaaaao;
    }

    public aaaaoaaa aaaaaaau() {
        return this.aaaaaaae;
    }

    public aaaaaoaa aaaaaaav() {
        return this.aaaaaaeo;
    }

    public void aaaaaaeo() {
        boolean aaaaaaae;
        if (!aaaaaeaa && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.aaaaaaae.aaaaaaau = true;
            aaaaaaae = aaaaaaae();
            notifyAll();
        }
        if (aaaaaaae) {
            return;
        }
        this.aaaaaaac.aaaaaaao(this.aaaaaaao);
    }

    public aaaaaoaa aaaaaeaa() {
        return this.aaaeaaaa;
    }

    public void aaaaeaaa() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public synchronized aaaoaaaa aaaeaaaa() {
        this.aaaaaaeo.aaaaaaav();
        while (this.aaaaaaau.isEmpty() && this.aaaaeaaa == null) {
            try {
                aaaaeaaa();
            } catch (Throwable th) {
                this.aaaaaaeo.aaaaeaaa();
                throw th;
            }
        }
        this.aaaaaaeo.aaaaeaaa();
        if (this.aaaaaaau.isEmpty()) {
            throw new eaaaaaaa(this.aaaaeaaa);
        }
        return (aaaoaaaa) this.aaaaaaau.removeFirst();
    }

    private boolean aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var) {
        if (!aaaaaeaa && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                if (this.aaaaeaaa != null) {
                    return false;
                }
                if (this.aaaaaaae.aaaaaaau && this.aaaaaaav.aaaaaaao) {
                    return false;
                }
                this.aaaaeaaa = aaaaaaa0Var;
                notifyAll();
                this.aaaaaaac.aaaaaaao(this.aaaaaaao);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var) {
        if (aaaaaaa0(aaaaaaa0Var)) {
            this.aaaaaaac.aaaaaaa0(this.aaaaaaao, aaaaaaa0Var);
        }
    }

    public void aaaaaaao(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var) {
        if (aaaaaaa0(aaaaaaa0Var)) {
            this.aaaaaaac.aaaaaaao(this.aaaaaaao, aaaaaaa0Var);
        }
    }

    public final class aaaaaaaa implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa {
        static final /* synthetic */ boolean aaaaaaau = true;
        boolean aaaaaaa0;
        private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaa = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();
        boolean aaaaaaao;

        public aaaaaaaa() {
        }

        private void aaaaaaaa(boolean z) {
            aaaaaaeo aaaaaaeoVar;
            long min;
            aaaaaaeo aaaaaaeoVar2;
            synchronized (aaaaaaeo.this) {
                aaaaaaeo.this.aaaeaaaa.aaaaaaav();
                while (true) {
                    try {
                        aaaaaaeoVar = aaaaaaeo.this;
                        if (aaaaaaeoVar.aaaaaaa0 > 0 || this.aaaaaaao || this.aaaaaaa0 || aaaaaaeoVar.aaaaeaaa != null) {
                            break;
                        } else {
                            aaaaaaeoVar.aaaaeaaa();
                        }
                    } finally {
                        aaaaaaeo.this.aaaeaaaa.aaaaeaaa();
                    }
                }
                aaaaaaeoVar.aaaeaaaa.aaaaeaaa();
                aaaaaaeo.this.aaaaaaa0();
                min = Math.min(aaaaaaeo.this.aaaaaaa0, this.aaaaaaaa.size());
                aaaaaaeoVar2 = aaaaaaeo.this;
                aaaaaaeoVar2.aaaaaaa0 -= min;
            }
            aaaaaaeoVar2.aaaeaaaa.aaaaaaav();
            try {
                aaaaaaeo aaaaaaeoVar3 = aaaaaaeo.this;
                aaaaaaeoVar3.aaaaaaac.aaaaaaaa(aaaaaaeoVar3.aaaaaaao, z && min == this.aaaaaaaa.size(), this.aaaaaaaa, min);
                aaaaaaeo.this.aaaeaaaa.aaaaeaaa();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
        public void aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            if (!aaaaaaau && Thread.holdsLock(aaaaaaeo.this)) {
                throw new AssertionError();
            }
            this.aaaaaaaa.aaaaaaa0(aaaaaaaoVar, j);
            while (this.aaaaaaaa.size() >= 16384) {
                aaaaaaaa(false);
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!aaaaaaau && Thread.holdsLock(aaaaaaeo.this)) {
                throw new AssertionError();
            }
            synchronized (aaaaaaeo.this) {
                try {
                    if (this.aaaaaaa0) {
                        return;
                    }
                    if (!aaaaaaeo.this.aaaaaaav.aaaaaaao) {
                        if (this.aaaaaaaa.size() > 0) {
                            while (this.aaaaaaaa.size() > 0) {
                                aaaaaaaa(true);
                            }
                        } else {
                            aaaaaaeo aaaaaaeoVar = aaaaaaeo.this;
                            aaaaaaeoVar.aaaaaaac.aaaaaaaa(aaaaaaeoVar.aaaaaaao, true, (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao) null, 0L);
                        }
                    }
                    synchronized (aaaaaaeo.this) {
                        this.aaaaaaa0 = true;
                    }
                    aaaaaaeo.this.aaaaaaac.flush();
                    aaaaaaeo.this.aaaaaaaa();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Flushable
        public void flush() {
            if (!aaaaaaau && Thread.holdsLock(aaaaaaeo.this)) {
                throw new AssertionError();
            }
            synchronized (aaaaaaeo.this) {
                aaaaaaeo.this.aaaaaaa0();
            }
            while (this.aaaaaaaa.size() > 0) {
                aaaaaaaa(false);
                aaaaaaeo.this.aaaaaaac.flush();
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
        public aaaaaoaa aaaaaaa0() {
            return aaaaaaeo.this.aaaeaaaa;
        }
    }

    public void aaaaaaaa(List list) {
        boolean aaaaaaae;
        if (!aaaaaeaa && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.aaaaaaan = true;
            this.aaaaaaau.add(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaa0(list));
            aaaaaaae = aaaaaaae();
            notifyAll();
        }
        if (aaaaaaae) {
            return;
        }
        this.aaaaaaac.aaaaaaao(this.aaaaaaao);
    }

    public synchronized void aaaaaaac(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var) {
        if (this.aaaaeaaa == null) {
            this.aaaaeaaa = aaaaaaa0Var;
            notifyAll();
        }
    }

    public void aaaaaaa0() {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaav;
        if (!aaaaaaaaVar.aaaaaaa0) {
            if (!aaaaaaaaVar.aaaaaaao) {
                if (this.aaaaeaaa != null) {
                    throw new eaaaaaaa(this.aaaaeaaa);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar, int i) {
        if (!aaaaaeaa && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.aaaaaaae.aaaaaaaa(aaaaaaauVar, i);
    }

    public void aaaaaaaa() {
        boolean z;
        boolean aaaaaaae;
        if (!aaaaaeaa && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                aaaaaaa0 aaaaaaa0Var = this.aaaaaaae;
                if (!aaaaaaa0Var.aaaaaaau && aaaaaaa0Var.aaaaaaac) {
                    aaaaaaaa aaaaaaaaVar = this.aaaaaaav;
                    if (!aaaaaaaaVar.aaaaaaao) {
                        if (aaaaaaaaVar.aaaaaaa0) {
                        }
                    }
                    z = true;
                    aaaaaaae = aaaaaaae();
                }
                z = false;
                aaaaaaae = aaaaaaae();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.CANCEL);
        } else {
            if (aaaaaaae) {
                return;
            }
            this.aaaaaaac.aaaaaaao(this.aaaaaaao);
        }
    }

    public void aaaaaaaa(long j) {
        this.aaaaaaa0 += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public final class aaaaaaa0 implements aaaaoaaa {
        static final /* synthetic */ boolean aaaaaaae = true;
        boolean aaaaaaac;
        private final long aaaaaaao;
        boolean aaaaaaau;
        private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaa = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();
        private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaa0 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();

        public aaaaaaa0(long j) {
            this.aaaaaaao = j;
        }

        private void aaaaaaan(long j) {
            if (!aaaaaaae && Thread.holdsLock(aaaaaaeo.this)) {
                throw new AssertionError();
            }
            aaaaaaeo.this.aaaaaaac.aaaaaaae(j);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public aaaaaoaa aaaaaaa0() {
            return aaaaaaeo.this.aaaaaaeo;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
        
            r12 = -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
        
            r11.aaaaaaan.aaaaaaeo.aaaaeaaa();
         */
        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao r12, long r13) {
            /*
                r11 = this;
                r0 = 0
                int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
                if (r2 < 0) goto Lb3
            L6:
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.this
                monitor-enter(r2)
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.this     // Catch: java.lang.Throwable -> L85
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo$aaaaaaao r3 = r3.aaaaaaeo     // Catch: java.lang.Throwable -> L85
                r3.aaaaaaav()     // Catch: java.lang.Throwable -> L85
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.this     // Catch: java.lang.Throwable -> L2c
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 r4 = r3.aaaaeaaa     // Catch: java.lang.Throwable -> L2c
                if (r4 == 0) goto L17
                goto L18
            L17:
                r4 = 0
            L18:
                boolean r5 = r11.aaaaaaac     // Catch: java.lang.Throwable -> L2c
                if (r5 != 0) goto La1
                java.util.Deque r3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.aaaaaaaa(r3)     // Catch: java.lang.Throwable -> L2c
                boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L2c
                if (r3 != 0) goto L2f
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.this     // Catch: java.lang.Throwable -> L2c
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.aaaaaaa0(r3)     // Catch: java.lang.Throwable -> L2c
                goto L2f
            L2c:
                r12 = move-exception
                goto La9
            L2f:
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao r3 = r11.aaaaaaa0     // Catch: java.lang.Throwable -> L2c
                long r5 = r3.size()     // Catch: java.lang.Throwable -> L2c
                r7 = -1
                int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r3 <= 0) goto L71
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao r3 = r11.aaaaaaa0     // Catch: java.lang.Throwable -> L2c
                long r5 = r3.size()     // Catch: java.lang.Throwable -> L2c
                long r13 = java.lang.Math.min(r13, r5)     // Catch: java.lang.Throwable -> L2c
                long r12 = r3.aaaaaaaa(r12, r13)     // Catch: java.lang.Throwable -> L2c
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r14 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.this     // Catch: java.lang.Throwable -> L2c
                long r5 = r14.aaaaaaaa     // Catch: java.lang.Throwable -> L2c
                long r5 = r5 + r12
                r14.aaaaaaaa = r5     // Catch: java.lang.Throwable -> L2c
                if (r4 != 0) goto L88
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae r14 = r14.aaaaaaac     // Catch: java.lang.Throwable -> L2c
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaea r14 = r14.aaaaaoaa     // Catch: java.lang.Throwable -> L2c
                int r14 = r14.aaaaaaao()     // Catch: java.lang.Throwable -> L2c
                int r14 = r14 / 2
                long r9 = (long) r14     // Catch: java.lang.Throwable -> L2c
                int r14 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                if (r14 < 0) goto L88
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r14 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.this     // Catch: java.lang.Throwable -> L2c
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae r3 = r14.aaaaaaac     // Catch: java.lang.Throwable -> L2c
                int r5 = r14.aaaaaaao     // Catch: java.lang.Throwable -> L2c
                long r9 = r14.aaaaaaaa     // Catch: java.lang.Throwable -> L2c
                r3.aaaaaaaa(r5, r9)     // Catch: java.lang.Throwable -> L2c
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r14 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.this     // Catch: java.lang.Throwable -> L2c
                r14.aaaaaaaa = r0     // Catch: java.lang.Throwable -> L2c
                goto L88
            L71:
                boolean r3 = r11.aaaaaaau     // Catch: java.lang.Throwable -> L2c
                if (r3 != 0) goto L87
                if (r4 != 0) goto L87
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.this     // Catch: java.lang.Throwable -> L2c
                r3.aaaaeaaa()     // Catch: java.lang.Throwable -> L2c
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.this     // Catch: java.lang.Throwable -> L85
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo$aaaaaaao r3 = r3.aaaaaaeo     // Catch: java.lang.Throwable -> L85
                r3.aaaaeaaa()     // Catch: java.lang.Throwable -> L85
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L85
                goto L6
            L85:
                r12 = move-exception
                goto Lb1
            L87:
                r12 = r7
            L88:
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r14 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.this     // Catch: java.lang.Throwable -> L85
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo$aaaaaaao r14 = r14.aaaaaaeo     // Catch: java.lang.Throwable -> L85
                r14.aaaaeaaa()     // Catch: java.lang.Throwable -> L85
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L85
                int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
                if (r14 == 0) goto L98
                r11.aaaaaaan(r12)
                return r12
            L98:
                if (r4 != 0) goto L9b
                return r7
            L9b:
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.eaaaaaaa r12 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.eaaaaaaa
                r12.<init>(r4)
                throw r12
            La1:
                java.io.IOException r12 = new java.io.IOException     // Catch: java.lang.Throwable -> L2c
                java.lang.String r13 = "stream closed"
                r12.<init>(r13)     // Catch: java.lang.Throwable -> L2c
                throw r12     // Catch: java.lang.Throwable -> L2c
            La9:
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r13 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.this     // Catch: java.lang.Throwable -> L85
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo$aaaaaaao r13 = r13.aaaaaaeo     // Catch: java.lang.Throwable -> L85
                r13.aaaaeaaa()     // Catch: java.lang.Throwable -> L85
                throw r12     // Catch: java.lang.Throwable -> L85
            Lb1:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L85
                throw r12
            Lb3:
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "byteCount < 0: "
                java.lang.String r13 = ADYaiT.CtFAbx.AaHO0E(r0, r13)
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo.aaaaaaa0.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao, long):long");
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            synchronized (aaaaaaeo.this) {
                try {
                    this.aaaaaaac = true;
                    size = this.aaaaaaa0.size();
                    this.aaaaaaa0.aaaaaaeo();
                    if (!aaaaaaeo.this.aaaaaaau.isEmpty()) {
                        aaaaaaeo.aaaaaaa0(aaaaaaeo.this);
                    }
                    aaaaaaeo.this.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (size > 0) {
                aaaaaaan(size);
            }
            aaaaaaeo.this.aaaaaaaa();
        }

        public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar, long j) {
            boolean z;
            boolean z2;
            long j2;
            if (!aaaaaaae && Thread.holdsLock(aaaaaaeo.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (aaaaaaeo.this) {
                    z = this.aaaaaaau;
                    z2 = this.aaaaaaa0.size() + j > this.aaaaaaao;
                }
                if (z2) {
                    aaaaaaauVar.skip(j);
                    aaaaaaeo.this.aaaaaaao(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    aaaaaaauVar.skip(j);
                    return;
                }
                long aaaaaaaa = aaaaaaauVar.aaaaaaaa(this.aaaaaaaa, j);
                if (aaaaaaaa != -1) {
                    j -= aaaaaaaa;
                    synchronized (aaaaaaeo.this) {
                        try {
                            if (this.aaaaaaac) {
                                j2 = this.aaaaaaaa.size();
                                this.aaaaaaaa.aaaaaaeo();
                            } else {
                                boolean z3 = this.aaaaaaa0.size() == 0;
                                this.aaaaaaa0.aaaaaaaa(this.aaaaaaaa);
                                if (z3) {
                                    aaaaaaeo.this.notifyAll();
                                }
                                j2 = 0;
                            }
                        } finally {
                        }
                    }
                    if (j2 > 0) {
                        aaaaaaan(j2);
                    }
                } else {
                    throw new EOFException();
                }
            }
        }
    }
}
