package com.czhj.wire.okio;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AsyncTimeout extends Timeout {

    /* renamed from: a, reason: collision with root package name */
    static AsyncTimeout f10677a = null;
    private static final int b = 65536;
    private static final long c;
    private static final long d;
    private boolean e;
    private AsyncTimeout f;
    private long g;

    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0017, code lost:
        
            r1.timedOut();
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
                java.lang.Class<com.czhj.wire.okio.AsyncTimeout> r0 = com.czhj.wire.okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                com.czhj.wire.okio.AsyncTimeout r1 = com.czhj.wire.okio.AsyncTimeout.a()     // Catch: java.lang.Throwable -> Lb
                if (r1 != 0) goto Ld
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                goto L0
            Lb:
                r1 = move-exception
                goto L1b
            Ld:
                com.czhj.wire.okio.AsyncTimeout r2 = com.czhj.wire.okio.AsyncTimeout.f10677a     // Catch: java.lang.Throwable -> Lb
                if (r1 != r2) goto L16
                r1 = 0
                com.czhj.wire.okio.AsyncTimeout.f10677a = r1     // Catch: java.lang.Throwable -> Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                return
            L16:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                r1.timedOut()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L1b:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        c = millis;
        d = TimeUnit.MILLISECONDS.toNanos(millis);
        QFjrQy();
    }

    private static /* synthetic */ void QFjrQy() {
        char[] charArray = "¶º¸û²´¸°û·º¬û¦½°¹¹û\u009f»¼\u0097§¼±²°".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 213);
        }
        String str = new String(charArray);
        char[] charArray2 = "¶¹¼»¼¡".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 213);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private long a(long j) {
        return this.g - j;
    }

    public final void enter() {
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.e = true;
            a(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        return a(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        return new Sink() { // from class: com.czhj.wire.okio.AsyncTimeout.1
            @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.close();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // com.czhj.wire.okio.Sink, java.io.Flushable
            public void flush() {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.flush();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // com.czhj.wire.okio.Sink
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }

            @Override // com.czhj.wire.okio.Sink
            public void write(Buffer buffer, long j) {
                Util.checkOffsetAndCount(buffer.c, 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j <= 0) {
                        return;
                    }
                    Segment segment = buffer.b;
                    while (true) {
                        if (j2 >= 65536) {
                            break;
                        }
                        j2 += segment.e - segment.d;
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        segment = segment.h;
                    }
                    AsyncTimeout.this.enter();
                    try {
                        try {
                            sink.write(buffer, j2);
                            j -= j2;
                            AsyncTimeout.this.a(true);
                        } catch (IOException e) {
                            throw AsyncTimeout.this.a(e);
                        }
                    } catch (Throwable th) {
                        AsyncTimeout.this.a(false);
                        throw th;
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        return new Source() { // from class: com.czhj.wire.okio.AsyncTimeout.2
            @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout.this.enter();
                try {
                    try {
                        source.close();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // com.czhj.wire.okio.Source
            public long read(Buffer buffer, long j) {
                AsyncTimeout.this.enter();
                try {
                    try {
                        long read = source.read(buffer, j);
                        AsyncTimeout.this.a(true);
                        return read;
                    } catch (IOException e) {
                        throw AsyncTimeout.this.a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.a(false);
                    throw th;
                }
            }

            @Override // com.czhj.wire.okio.Source
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }

    public void timedOut() {
    }

    public static AsyncTimeout a() {
        AsyncTimeout asyncTimeout = f10677a.f;
        long nanoTime = System.nanoTime();
        if (asyncTimeout == null) {
            AsyncTimeout.class.wait(c);
            if (f10677a.f != null || System.nanoTime() - nanoTime < d) {
                return null;
            }
            return f10677a;
        }
        long a2 = asyncTimeout.a(nanoTime);
        if (a2 > 0) {
            long j = a2 / C.MICROS_PER_SECOND;
            AsyncTimeout.class.wait(j, (int) (a2 - (C.MICROS_PER_SECOND * j)));
            return null;
        }
        f10677a.f = asyncTimeout.f;
        asyncTimeout.f = null;
        return asyncTimeout;
    }

    public final IOException a(IOException iOException) {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0019, B:10:0x0025, B:11:0x002e, B:12:0x003d, B:13:0x0043, B:15:0x0047, B:17:0x0050, B:20:0x0053, B:22:0x005d, B:30:0x0037, B:31:0x0064, B:32:0x0069), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized void a(com.czhj.wire.okio.AsyncTimeout r6, long r7, boolean r9) {
        /*
            java.lang.Class<com.czhj.wire.okio.AsyncTimeout> r0 = com.czhj.wire.okio.AsyncTimeout.class
            monitor-enter(r0)
            com.czhj.wire.okio.AsyncTimeout r1 = com.czhj.wire.okio.AsyncTimeout.f10677a     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L19
            com.czhj.wire.okio.AsyncTimeout r1 = new com.czhj.wire.okio.AsyncTimeout     // Catch: java.lang.Throwable -> L17
            r1.<init>()     // Catch: java.lang.Throwable -> L17
            com.czhj.wire.okio.AsyncTimeout.f10677a = r1     // Catch: java.lang.Throwable -> L17
            com.czhj.wire.okio.AsyncTimeout$Watchdog r1 = new com.czhj.wire.okio.AsyncTimeout$Watchdog     // Catch: java.lang.Throwable -> L17
            r1.<init>()     // Catch: java.lang.Throwable -> L17
            r1.start()     // Catch: java.lang.Throwable -> L17
            goto L19
        L17:
            r6 = move-exception
            goto L6a
        L19:
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L17
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L32
            if (r9 == 0) goto L32
            long r3 = r6.deadlineNanoTime()     // Catch: java.lang.Throwable -> L17
            long r3 = r3 - r1
            long r7 = java.lang.Math.min(r7, r3)     // Catch: java.lang.Throwable -> L17
        L2e:
            long r7 = r7 + r1
            r6.g = r7     // Catch: java.lang.Throwable -> L17
            goto L3d
        L32:
            if (r5 == 0) goto L35
            goto L2e
        L35:
            if (r9 == 0) goto L64
            long r7 = r6.deadlineNanoTime()     // Catch: java.lang.Throwable -> L17
            r6.g = r7     // Catch: java.lang.Throwable -> L17
        L3d:
            long r7 = r6.a(r1)     // Catch: java.lang.Throwable -> L17
            com.czhj.wire.okio.AsyncTimeout r9 = com.czhj.wire.okio.AsyncTimeout.f10677a     // Catch: java.lang.Throwable -> L17
        L43:
            com.czhj.wire.okio.AsyncTimeout r3 = r9.f     // Catch: java.lang.Throwable -> L17
            if (r3 == 0) goto L53
            long r3 = r3.a(r1)     // Catch: java.lang.Throwable -> L17
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L50
            goto L53
        L50:
            com.czhj.wire.okio.AsyncTimeout r9 = r9.f     // Catch: java.lang.Throwable -> L17
            goto L43
        L53:
            com.czhj.wire.okio.AsyncTimeout r7 = r9.f     // Catch: java.lang.Throwable -> L17
            r6.f = r7     // Catch: java.lang.Throwable -> L17
            r9.f = r6     // Catch: java.lang.Throwable -> L17
            com.czhj.wire.okio.AsyncTimeout r6 = com.czhj.wire.okio.AsyncTimeout.f10677a     // Catch: java.lang.Throwable -> L17
            if (r9 != r6) goto L62
            java.lang.Class<com.czhj.wire.okio.AsyncTimeout> r6 = com.czhj.wire.okio.AsyncTimeout.class
            r6.notify()     // Catch: java.lang.Throwable -> L17
        L62:
            monitor-exit(r0)
            return
        L64:
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L17
            r6.<init>()     // Catch: java.lang.Throwable -> L17
            throw r6     // Catch: java.lang.Throwable -> L17
        L6a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.AsyncTimeout.a(com.czhj.wire.okio.AsyncTimeout, long, boolean):void");
    }

    public final void a(boolean z) {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    private static synchronized boolean a(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = f10677a;
            while (asyncTimeout2 != null) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.f;
                if (asyncTimeout3 == asyncTimeout) {
                    asyncTimeout2.f = asyncTimeout.f;
                    asyncTimeout.f = null;
                    return false;
                }
                asyncTimeout2 = asyncTimeout3;
            }
            return true;
        }
    }
}
