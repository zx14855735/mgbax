package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class B4ZgIw {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final AmA8tU connection;
    okhttp3.internal.http2.A4TApA errorCode;
    private boolean hasResponseHeaders;
    private okhttp3.internal.http2.A5SV6n headersListener;
    private final Deque<Headers> headersQueue;
    final int id;
    final A5SV6n readTimeout;
    final A2egSU sink;
    private final A4TApA source;
    long unacknowledgedBytesRead = 0;
    final A5SV6n writeTimeout;

    public final class A2egSU implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final Buffer sendBuffer = new Buffer();

        public A2egSU() {
        }

        public final void A2egSU(boolean z) {
            B4ZgIw b4ZgIw;
            long min;
            B4ZgIw b4ZgIw2;
            synchronized (B4ZgIw.this) {
                B4ZgIw.this.writeTimeout.enter();
                while (true) {
                    try {
                        b4ZgIw = B4ZgIw.this;
                        if (b4ZgIw.bytesLeftInWriteWindow > 0 || this.finished || this.closed || b4ZgIw.errorCode != null) {
                            break;
                        } else {
                            b4ZgIw.AzWtSf();
                        }
                    } finally {
                        B4ZgIw.this.writeTimeout.A2egSU();
                    }
                }
                b4ZgIw.writeTimeout.A2egSU();
                B4ZgIw.this.A5SV6n();
                min = Math.min(B4ZgIw.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                b4ZgIw2 = B4ZgIw.this;
                b4ZgIw2.bytesLeftInWriteWindow -= min;
            }
            b4ZgIw2.writeTimeout.enter();
            try {
                B4ZgIw b4ZgIw3 = B4ZgIw.this;
                b4ZgIw3.connection.AlLFFp(b4ZgIw3.id, z && min == this.sendBuffer.size(), this.sendBuffer, min);
                B4ZgIw.this.writeTimeout.A2egSU();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            synchronized (B4ZgIw.this) {
                try {
                    if (this.closed) {
                        return;
                    }
                    if (!B4ZgIw.this.sink.finished) {
                        if (this.sendBuffer.size() > 0) {
                            while (this.sendBuffer.size() > 0) {
                                A2egSU(true);
                            }
                        } else {
                            B4ZgIw b4ZgIw = B4ZgIw.this;
                            b4ZgIw.connection.AlLFFp(b4ZgIw.id, true, null, 0L);
                        }
                    }
                    synchronized (B4ZgIw.this) {
                        this.closed = true;
                    }
                    B4ZgIw.this.connection.writer.flush();
                    B4ZgIw.this.A4TApA();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() {
            synchronized (B4ZgIw.this) {
                B4ZgIw.this.A5SV6n();
            }
            while (this.sendBuffer.size() > 0) {
                A2egSU(false);
                B4ZgIw.this.connection.writer.flush();
            }
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return B4ZgIw.this.writeTimeout;
        }

        @Override // okio.Sink
        public final void write(Buffer buffer, long j) {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.size() >= EMIT_BUFFER_SIZE) {
                A2egSU(false);
            }
        }
    }

    public final class A4TApA implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        private final Buffer receiveBuffer = new Buffer();
        private final Buffer readBuffer = new Buffer();

        public A4TApA(long j) {
            this.maxByteCount = j;
        }

        public final void A2egSU(BufferedSource bufferedSource, long j) {
            boolean z;
            boolean z2;
            while (j > 0) {
                synchronized (B4ZgIw.this) {
                    z = this.finished;
                    z2 = this.readBuffer.size() + j > this.maxByteCount;
                }
                if (z2) {
                    bufferedSource.skip(j);
                    B4ZgIw b4ZgIw = B4ZgIw.this;
                    okhttp3.internal.http2.A4TApA a4TApA = okhttp3.internal.http2.A4TApA.FLOW_CONTROL_ERROR;
                    if (b4ZgIw.AMqCpz(a4TApA)) {
                        b4ZgIw.connection.AzWtSf(b4ZgIw.id, a4TApA);
                        return;
                    }
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long read = bufferedSource.read(this.receiveBuffer, j);
                if (read == -1) {
                    throw new EOFException();
                }
                j -= read;
                synchronized (B4ZgIw.this) {
                    try {
                        boolean z3 = this.readBuffer.size() == 0;
                        this.readBuffer.writeAll(this.receiveBuffer);
                        if (z3) {
                            B4ZgIw.this.notifyAll();
                        }
                    } finally {
                    }
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            long size;
            synchronized (B4ZgIw.this) {
                try {
                    this.closed = true;
                    size = this.readBuffer.size();
                    this.readBuffer.clear();
                    if (!B4ZgIw.this.headersQueue.isEmpty()) {
                        B4ZgIw.this.getClass();
                    }
                    B4ZgIw.this.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (size > 0) {
                B4ZgIw.this.connection.AcNBzu(size);
            }
            B4ZgIw.this.A4TApA();
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
        
            r12 = -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
        
            r11.this$0.readTimeout.A2egSU();
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final long read(okio.Buffer r12, long r13) {
            /*
                r11 = this;
                r0 = 0
                int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
                if (r2 < 0) goto Lb7
            L6:
                okhttp3.internal.http2.B4ZgIw r2 = okhttp3.internal.http2.B4ZgIw.this
                monitor-enter(r2)
                okhttp3.internal.http2.B4ZgIw r3 = okhttp3.internal.http2.B4ZgIw.this     // Catch: java.lang.Throwable -> L85
                okhttp3.internal.http2.B4ZgIw$A5SV6n r3 = r3.readTimeout     // Catch: java.lang.Throwable -> L85
                r3.enter()     // Catch: java.lang.Throwable -> L85
                okhttp3.internal.http2.B4ZgIw r3 = okhttp3.internal.http2.B4ZgIw.this     // Catch: java.lang.Throwable -> L2c
                okhttp3.internal.http2.A4TApA r4 = r3.errorCode     // Catch: java.lang.Throwable -> L2c
                if (r4 == 0) goto L17
                goto L18
            L17:
                r4 = 0
            L18:
                boolean r5 = r11.closed     // Catch: java.lang.Throwable -> L2c
                if (r5 != 0) goto La5
                java.util.Deque r3 = okhttp3.internal.http2.B4ZgIw.A2egSU(r3)     // Catch: java.lang.Throwable -> L2c
                boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L2c
                if (r3 != 0) goto L2f
                okhttp3.internal.http2.B4ZgIw r3 = okhttp3.internal.http2.B4ZgIw.this     // Catch: java.lang.Throwable -> L2c
                r3.getClass()     // Catch: java.lang.Throwable -> L2c
                goto L2f
            L2c:
                r12 = move-exception
                goto Lad
            L2f:
                okio.Buffer r3 = r11.readBuffer     // Catch: java.lang.Throwable -> L2c
                long r5 = r3.size()     // Catch: java.lang.Throwable -> L2c
                r7 = -1
                int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r3 <= 0) goto L71
                okio.Buffer r3 = r11.readBuffer     // Catch: java.lang.Throwable -> L2c
                long r5 = r3.size()     // Catch: java.lang.Throwable -> L2c
                long r13 = java.lang.Math.min(r13, r5)     // Catch: java.lang.Throwable -> L2c
                long r12 = r3.read(r12, r13)     // Catch: java.lang.Throwable -> L2c
                okhttp3.internal.http2.B4ZgIw r14 = okhttp3.internal.http2.B4ZgIw.this     // Catch: java.lang.Throwable -> L2c
                long r5 = r14.unacknowledgedBytesRead     // Catch: java.lang.Throwable -> L2c
                long r5 = r5 + r12
                r14.unacknowledgedBytesRead = r5     // Catch: java.lang.Throwable -> L2c
                if (r4 != 0) goto L88
                okhttp3.internal.http2.AmA8tU r14 = r14.connection     // Catch: java.lang.Throwable -> L2c
                okhttp3.internal.http2.BIYEnU r14 = r14.okHttpSettings     // Catch: java.lang.Throwable -> L2c
                int r14 = r14.A5SV6n()     // Catch: java.lang.Throwable -> L2c
                int r14 = r14 / 2
                long r9 = (long) r14     // Catch: java.lang.Throwable -> L2c
                int r14 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                if (r14 < 0) goto L88
                okhttp3.internal.http2.B4ZgIw r14 = okhttp3.internal.http2.B4ZgIw.this     // Catch: java.lang.Throwable -> L2c
                okhttp3.internal.http2.AmA8tU r3 = r14.connection     // Catch: java.lang.Throwable -> L2c
                int r5 = r14.id     // Catch: java.lang.Throwable -> L2c
                long r9 = r14.unacknowledgedBytesRead     // Catch: java.lang.Throwable -> L2c
                r3.B25kr6(r5, r9)     // Catch: java.lang.Throwable -> L2c
                okhttp3.internal.http2.B4ZgIw r14 = okhttp3.internal.http2.B4ZgIw.this     // Catch: java.lang.Throwable -> L2c
                r14.unacknowledgedBytesRead = r0     // Catch: java.lang.Throwable -> L2c
                goto L88
            L71:
                boolean r3 = r11.finished     // Catch: java.lang.Throwable -> L2c
                if (r3 != 0) goto L87
                if (r4 != 0) goto L87
                okhttp3.internal.http2.B4ZgIw r3 = okhttp3.internal.http2.B4ZgIw.this     // Catch: java.lang.Throwable -> L2c
                r3.AzWtSf()     // Catch: java.lang.Throwable -> L2c
                okhttp3.internal.http2.B4ZgIw r3 = okhttp3.internal.http2.B4ZgIw.this     // Catch: java.lang.Throwable -> L85
                okhttp3.internal.http2.B4ZgIw$A5SV6n r3 = r3.readTimeout     // Catch: java.lang.Throwable -> L85
                r3.A2egSU()     // Catch: java.lang.Throwable -> L85
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L85
                goto L6
            L85:
                r12 = move-exception
                goto Lb5
            L87:
                r12 = r7
            L88:
                okhttp3.internal.http2.B4ZgIw r14 = okhttp3.internal.http2.B4ZgIw.this     // Catch: java.lang.Throwable -> L85
                okhttp3.internal.http2.B4ZgIw$A5SV6n r14 = r14.readTimeout     // Catch: java.lang.Throwable -> L85
                r14.A2egSU()     // Catch: java.lang.Throwable -> L85
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L85
                int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
                if (r14 == 0) goto L9c
                okhttp3.internal.http2.B4ZgIw r14 = okhttp3.internal.http2.B4ZgIw.this
                okhttp3.internal.http2.AmA8tU r14 = r14.connection
                r14.AcNBzu(r12)
                return r12
            L9c:
                if (r4 != 0) goto L9f
                return r7
            L9f:
                okhttp3.internal.http2.BJ7GGh r12 = new okhttp3.internal.http2.BJ7GGh
                r12.<init>(r4)
                throw r12
            La5:
                java.io.IOException r12 = new java.io.IOException     // Catch: java.lang.Throwable -> L2c
                java.lang.String r13 = "stream closed"
                r12.<init>(r13)     // Catch: java.lang.Throwable -> L2c
                throw r12     // Catch: java.lang.Throwable -> L2c
            Lad:
                okhttp3.internal.http2.B4ZgIw r13 = okhttp3.internal.http2.B4ZgIw.this     // Catch: java.lang.Throwable -> L85
                okhttp3.internal.http2.B4ZgIw$A5SV6n r13 = r13.readTimeout     // Catch: java.lang.Throwable -> L85
                r13.A2egSU()     // Catch: java.lang.Throwable -> L85
                throw r12     // Catch: java.lang.Throwable -> L85
            Lb5:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L85
                throw r12
            Lb7:
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "byteCount < 0: "
                java.lang.String r13 = ADYaiT.CtFAbx.AaHO0E(r0, r13)
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.B4ZgIw.A4TApA.read(okio.Buffer, long):long");
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return B4ZgIw.this.readTimeout;
        }
    }

    public class A5SV6n extends AsyncTimeout {
        public A5SV6n() {
        }

        public final void A2egSU() {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        public final IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        public final void timedOut() {
            B4ZgIw b4ZgIw = B4ZgIw.this;
            okhttp3.internal.http2.A4TApA a4TApA = okhttp3.internal.http2.A4TApA.CANCEL;
            if (b4ZgIw.AMqCpz(a4TApA)) {
                b4ZgIw.connection.AzWtSf(b4ZgIw.id, a4TApA);
            }
        }
    }

    public B4ZgIw(int i, AmA8tU amA8tU, boolean z, boolean z2, @Nullable Headers headers) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.readTimeout = new A5SV6n();
        this.writeTimeout = new A5SV6n();
        this.errorCode = null;
        if (amA8tU == null) {
            throw new NullPointerException("connection == null");
        }
        this.id = i;
        this.connection = amA8tU;
        this.bytesLeftInWriteWindow = amA8tU.peerSettings.A5SV6n();
        A4TApA a4TApA = new A4TApA(amA8tU.okHttpSettings.A5SV6n());
        this.source = a4TApA;
        A2egSU a2egSU = new A2egSU();
        this.sink = a2egSU;
        a4TApA.finished = z2;
        a2egSU.finished = z;
        if (headers != null) {
            arrayDeque.add(headers);
        }
        if (AYUAbz() && headers != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!AYUAbz() && headers == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    public final void A4TApA() {
        boolean z;
        boolean AZOQYO2;
        synchronized (this) {
            try {
                A4TApA a4TApA = this.source;
                if (!a4TApA.finished && a4TApA.closed) {
                    A2egSU a2egSU = this.sink;
                    if (!a2egSU.finished) {
                        if (a2egSU.closed) {
                        }
                    }
                    z = true;
                    AZOQYO2 = AZOQYO();
                }
                z = false;
                AZOQYO2 = AZOQYO();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            ADYaiT(okhttp3.internal.http2.A4TApA.CANCEL);
        } else {
            if (AZOQYO2) {
                return;
            }
            this.connection.AZOQYO(this.id);
        }
    }

    public final void A5SV6n() {
        A2egSU a2egSU = this.sink;
        if (a2egSU.closed) {
            throw new IOException("stream closed");
        }
        if (a2egSU.finished) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            throw new BJ7GGh(this.errorCode);
        }
    }

    public final void ADYaiT(okhttp3.internal.http2.A4TApA a4TApA) {
        if (AMqCpz(a4TApA)) {
            AmA8tU amA8tU = this.connection;
            amA8tU.writer.AZOQYO(this.id, a4TApA);
        }
    }

    public final boolean AMqCpz(okhttp3.internal.http2.A4TApA a4TApA) {
        synchronized (this) {
            try {
                if (this.errorCode != null) {
                    return false;
                }
                if (this.source.finished && this.sink.finished) {
                    return false;
                }
                this.errorCode = a4TApA;
                notifyAll();
                this.connection.AZOQYO(this.id);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final A2egSU ARc23Z() {
        synchronized (this) {
            try {
                if (!this.hasResponseHeaders && !AYUAbz()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.sink;
    }

    public final A4TApA ASJ6gh() {
        return this.source;
    }

    public final boolean AYUAbz() {
        return this.connection.client == ((this.id & 1) == 1);
    }

    public final synchronized boolean AZOQYO() {
        try {
            if (this.errorCode != null) {
                return false;
            }
            A4TApA a4TApA = this.source;
            if (!a4TApA.finished) {
                if (a4TApA.closed) {
                }
                return true;
            }
            A2egSU a2egSU = this.sink;
            if (a2egSU.finished || a2egSU.closed) {
                if (this.hasResponseHeaders) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void AZkASS(BufferedSource bufferedSource, int i) {
        this.source.A2egSU(bufferedSource, i);
    }

    public final void AaHO0E() {
        boolean AZOQYO2;
        synchronized (this) {
            this.source.finished = true;
            AZOQYO2 = AZOQYO();
            notifyAll();
        }
        if (AZOQYO2) {
            return;
        }
        this.connection.AZOQYO(this.id);
    }

    public final void AcNBzu(ArrayList arrayList) {
        boolean AZOQYO2;
        synchronized (this) {
            this.hasResponseHeaders = true;
            this.headersQueue.add(okhttp3.internal.A5SV6n.BChYOn(arrayList));
            AZOQYO2 = AZOQYO();
            notifyAll();
        }
        if (AZOQYO2) {
            return;
        }
        this.connection.AZOQYO(this.id);
    }

    public final synchronized void AlLFFp(okhttp3.internal.http2.A4TApA a4TApA) {
        if (this.errorCode == null) {
            this.errorCode = a4TApA;
            notifyAll();
        }
    }

    public final synchronized Headers AmA8tU() {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                AzWtSf();
            } catch (Throwable th) {
                this.readTimeout.A2egSU();
                throw th;
            }
        }
        this.readTimeout.A2egSU();
        if (this.headersQueue.isEmpty()) {
            throw new BJ7GGh(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    public final void AzWtSf() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
