package okhttp3.internal.http2;

import ADYaiT.CtFAbx;
import com.sigmob.sdk.downloader.f;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;
import okio.BufferedSource;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AmA8tU implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService listenerExecutor;
    private boolean awaitingPong;
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests;
    final String hostname;
    int lastGoodStreamId;
    final A4TApA listener;
    int nextStreamId;
    final BIYEnU peerSettings;
    private final ExecutorService pushExecutor;
    final BI9f7h pushObserver;
    final ADYaiT readerRunnable;
    boolean receivedInitialPeerSettings;
    boolean shutdown;
    final Socket socket;
    final B7CMnp writer;
    private final ScheduledExecutorService writerExecutor;
    final Map<Integer, B4ZgIw> streams = new LinkedHashMap();
    long unacknowledgedBytesRead = 0;
    BIYEnU okHttpSettings = new BIYEnU();

    public static class A2egSU {
        boolean client;
        String hostname;
        int pingIntervalMillis;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;
        A4TApA listener = A4TApA.REFUSE_INCOMING_STREAMS;
        BI9f7h pushObserver = BI9f7h.CANCEL;

        public A2egSU(boolean z) {
            this.client = z;
        }

        public final void A2egSU(okhttp3.internal.connection.ADYaiT aDYaiT) {
            this.listener = aDYaiT;
        }

        public final void A4TApA(int i) {
            this.pingIntervalMillis = i;
        }

        public final void A5SV6n(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    public static abstract class A4TApA {
        public static final A4TApA REFUSE_INCOMING_STREAMS = new A2egSU();

        public class A2egSU extends A4TApA {
            @Override // okhttp3.internal.http2.AmA8tU.A4TApA
            public final void A4TApA(B4ZgIw b4ZgIw) {
                b4ZgIw.ADYaiT(okhttp3.internal.http2.A4TApA.REFUSED_STREAM);
            }
        }

        static {
            vSBaup();
        }

        private static /* synthetic */ void vSBaup() {
            char[] charArray = "&*(k\"$( k'*<k6- ))k\u000f+,\u00077,!\" ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'E');
            }
            String str = new String(charArray);
            char[] charArray2 = "&),+,1".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'E');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public void A2egSU(AmA8tU amA8tU) {
        }

        public abstract void A4TApA(B4ZgIw b4ZgIw);
    }

    public final class A5SV6n extends okhttp3.internal.A4TApA {
        final int payload1;
        final int payload2;
        final boolean reply;

        public A5SV6n(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", AmA8tU.this.hostname, Integer.valueOf(i), Integer.valueOf(i2));
            this.reply = z;
            this.payload1 = i;
            this.payload2 = i2;
        }

        @Override // okhttp3.internal.A4TApA
        public final void execute() {
            AmA8tU.this.AmA8tU(this.payload1, this.payload2, this.reply);
        }
    }

    public class ADYaiT extends okhttp3.internal.A4TApA {
        final B3GDIM reader;

        public ADYaiT(B3GDIM b3gdim) {
            super("OkHttp %s", AmA8tU.this.hostname);
            this.reader = b3gdim;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // okhttp3.internal.A4TApA
        public final void execute() {
            okhttp3.internal.http2.A4TApA a4TApA;
            okhttp3.internal.http2.A4TApA a4TApA2 = okhttp3.internal.http2.A4TApA.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.reader.A5SV6n(this);
                        while (this.reader.A4TApA(false, this)) {
                        }
                        okhttp3.internal.http2.A4TApA a4TApA3 = okhttp3.internal.http2.A4TApA.NO_ERROR;
                        try {
                            a4TApA2 = okhttp3.internal.http2.A4TApA.CANCEL;
                            AmA8tU.this.ADYaiT(a4TApA3, a4TApA2);
                            a4TApA = a4TApA3;
                        } catch (IOException unused) {
                            a4TApA2 = okhttp3.internal.http2.A4TApA.PROTOCOL_ERROR;
                            AmA8tU amA8tU = AmA8tU.this;
                            amA8tU.ADYaiT(a4TApA2, a4TApA2);
                            a4TApA = amA8tU;
                            okhttp3.internal.A5SV6n.ARc23Z(this.reader);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            AmA8tU.this.ADYaiT(a4TApA, a4TApA2);
                        } catch (IOException unused2) {
                        }
                        okhttp3.internal.A5SV6n.ARc23Z(this.reader);
                        throw th;
                    }
                } catch (IOException unused3) {
                } catch (Throwable th2) {
                    th = th2;
                    a4TApA = a4TApA2;
                    AmA8tU.this.ADYaiT(a4TApA, a4TApA2);
                    okhttp3.internal.A5SV6n.ARc23Z(this.reader);
                    throw th;
                }
            } catch (IOException unused4) {
            }
            okhttp3.internal.A5SV6n.ARc23Z(this.reader);
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
        listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new okhttp3.internal.ADYaiT("OkHttp Http2Connection", true));
        qlyyT();
    }

    public AmA8tU(A2egSU a2egSU) {
        BIYEnU bIYEnU = new BIYEnU();
        this.peerSettings = bIYEnU;
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        this.pushObserver = a2egSU.pushObserver;
        boolean z = a2egSU.client;
        this.client = z;
        this.listener = a2egSU.listener;
        int i = z ? 1 : 2;
        this.nextStreamId = i;
        if (z) {
            this.nextStreamId = i + 2;
        }
        if (z) {
            this.okHttpSettings.AYUAbz(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        String str = a2egSU.hostname;
        this.hostname = str;
        byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
        Locale locale = Locale.US;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new okhttp3.internal.ADYaiT(CtFAbx.BI9f7h("OkHttp ", str, " Writer"), false));
        this.writerExecutor = scheduledThreadPoolExecutor;
        if (a2egSU.pingIntervalMillis != 0) {
            A5SV6n a5SV6n = new A5SV6n(false, 0, 0);
            long j = a2egSU.pingIntervalMillis;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(a5SV6n, j, j, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new okhttp3.internal.ADYaiT(CtFAbx.BI9f7h("OkHttp ", str, " Push Observer"), true));
        bIYEnU.AYUAbz(7, 65535);
        bIYEnU.AYUAbz(5, f.a.d);
        this.bytesLeftInWriteWindow = bIYEnU.A5SV6n();
        this.socket = a2egSU.socket;
        this.writer = new B7CMnp(a2egSU.sink, z);
        this.readerRunnable = new ADYaiT(new B3GDIM(a2egSU.source, z));
    }

    private static /* synthetic */ void qlyyT() {
        char[] charArray = "ÉÅÇ\u0084ÍËÇÏ\u0084ÈÅÓ\u0084ÙÂÏÆÆ\u0084àÄÃèØÃÎÍÏ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 170);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÉÆÃÄÃÞ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 170);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void ADYaiT(okhttp3.internal.http2.A4TApA a4TApA, okhttp3.internal.http2.A4TApA a4TApA2) {
        B4ZgIw[] b4ZgIwArr = null;
        try {
            AZkASS(a4TApA);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            try {
                if (!this.streams.isEmpty()) {
                    b4ZgIwArr = (B4ZgIw[]) this.streams.values().toArray(new B4ZgIw[this.streams.size()]);
                    this.streams.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (b4ZgIwArr != null) {
            for (B4ZgIw b4ZgIw : b4ZgIwArr) {
                try {
                    b4ZgIw.ADYaiT(a4TApA2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public final void AMqCpz() {
        try {
            okhttp3.internal.http2.A4TApA a4TApA = okhttp3.internal.http2.A4TApA.PROTOCOL_ERROR;
            ADYaiT(a4TApA, a4TApA);
        } catch (IOException unused) {
        }
    }

    public final synchronized B4ZgIw ARc23Z(int i) {
        return this.streams.get(Integer.valueOf(i));
    }

    public final synchronized int ASJ6gh() {
        return this.peerSettings.ADYaiT();
    }

    public final synchronized void AYUAbz(okhttp3.internal.A4TApA a4TApA) {
        if (!isShutdown()) {
            this.pushExecutor.execute(a4TApA);
        }
    }

    public final synchronized B4ZgIw AZOQYO(int i) {
        B4ZgIw remove;
        remove = this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public final void AZkASS(okhttp3.internal.http2.A4TApA a4TApA) {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                this.writer.AMqCpz(this.lastGoodStreamId, a4TApA, okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public final void AaHO0E() {
        this.writer.A4TApA();
        this.writer.AZkASS(this.okHttpSettings);
        if (this.okHttpSettings.A5SV6n() != 65535) {
            this.writer.AcNBzu(0, r0 - 65535);
        }
        new Thread(this.readerRunnable).start();
    }

    public final synchronized void AcNBzu(long j) {
        long j2 = this.unacknowledgedBytesRead + j;
        this.unacknowledgedBytesRead = j2;
        if (j2 >= this.okHttpSettings.A5SV6n() / 2) {
            B25kr6(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.writer.ASJ6gh());
        r6 = r3;
        r8.bytesLeftInWriteWindow -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AlLFFp(int r9, boolean r10, okio.Buffer r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            okhttp3.internal.http2.B7CMnp r12 = r8.writer
            r12.A5SV6n(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r3 = r8.bytesLeftInWriteWindow     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L32
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.B4ZgIw> r3 = r8.streams     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L65
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L28
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L28
            okhttp3.internal.http2.B7CMnp r3 = r8.writer     // Catch: java.lang.Throwable -> L28
            int r3 = r3.ASJ6gh()     // Catch: java.lang.Throwable -> L28
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.bytesLeftInWriteWindow     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.bytesLeftInWriteWindow = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            okhttp3.internal.http2.B7CMnp r4 = r8.writer
            if (r10 == 0) goto L53
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = 0
        L54:
            r4.A5SV6n(r5, r9, r11, r3)
            goto Ld
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L28
            r9.interrupt()     // Catch: java.lang.Throwable -> L28
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.AmA8tU.AlLFFp(int, boolean, okio.Buffer, long):void");
    }

    public final void AmA8tU(int i, int i2, boolean z) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.awaitingPong;
                this.awaitingPong = true;
            }
            if (z2) {
                AMqCpz();
                return;
            }
        }
        try {
            this.writer.AYUAbz(i, i2, z);
        } catch (IOException unused) {
            AMqCpz();
        }
    }

    public final void AzWtSf(int i, okhttp3.internal.http2.A4TApA a4TApA) {
        try {
            this.writerExecutor.execute(new AYUAbz(this, "OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}, i, a4TApA));
        } catch (RejectedExecutionException unused) {
        }
    }

    public final void B25kr6(int i, long j) {
        try {
            this.writerExecutor.execute(new AZOQYO(this, "OkHttp Window Update %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ADYaiT(okhttp3.internal.http2.A4TApA.NO_ERROR, okhttp3.internal.http2.A4TApA.CANCEL);
    }

    public final synchronized boolean isShutdown() {
        return this.shutdown;
    }
}
