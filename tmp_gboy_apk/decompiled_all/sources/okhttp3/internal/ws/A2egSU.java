package okhttp3.internal.ws;

import ADYaiT.CtFAbx;
import com.baidu.mobads.sdk.internal.an;
import com.sigmob.sdk.base.mta.PointType;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU implements WebSocket, okhttp3.internal.ws.ADYaiT {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    final WebSocketListener listener;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private long queueSize;
    private final Random random;
    private okhttp3.internal.ws.AMqCpz reader;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private ARc23Z streams;
    private okhttp3.internal.ws.ARc23Z writer;
    private final Runnable writerRunnable;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private int receivedCloseCode = -1;

    /* renamed from: okhttp3.internal.ws.A2egSU$A2egSU, reason: collision with other inner class name */
    public class RunnableC0557A2egSU implements Runnable {
        public RunnableC0557A2egSU() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            do {
                try {
                } catch (IOException e) {
                    A2egSU.this.A5SV6n(e, null);
                    return;
                }
            } while (A2egSU.this.AZkASS());
        }
    }

    public final class A4TApA implements Runnable {
        public A4TApA() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            A2egSU.this.cancel();
        }
    }

    public static final class A5SV6n {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        public A5SV6n(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }
    }

    public static final class ADYaiT {
        final ByteString data;
        final int formatOpcode;

        public ADYaiT(int i, ByteString byteString) {
            this.formatOpcode = i;
            this.data = byteString;
        }
    }

    public final class AMqCpz implements Runnable {
        public AMqCpz() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            A2egSU.this.AaHO0E();
        }
    }

    public static abstract class ARc23Z implements Closeable {
        public final boolean client;
        public final BufferedSink sink;
        public final BufferedSource source;

        public ARc23Z(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    static {
        QCqhyV();
    }

    public A2egSU(Request request, WebSocketListener webSocketListener, Random random, long j) {
        if (!an.c.equals(request.method())) {
            throw new IllegalArgumentException("Request must be GET: " + request.method());
        }
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random;
        this.pingIntervalMillis = j;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = ByteString.of(bArr).base64();
        this.writerRunnable = new RunnableC0557A2egSU();
    }

    private static /* synthetic */ void QCqhyV() {
        char[] charArray = "\u000e\u0002\u0000C\n\f\u0000\bC\u000f\u0002\u0014C\u001e\u0005\b\u0001\u0001C'\u0003\u0004/\u001f\u0004\t\n\b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'm');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000e\u0001\u0004\u0003\u0004\u0019".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'm');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(Response response) {
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
        }
        String header = response.header("Connection");
        if (!"Upgrade".equalsIgnoreCase(header)) {
            throw new ProtocolException(CtFAbx.BI9f7h("Expected 'Connection' header value 'Upgrade' but was '", header, "'"));
        }
        String header2 = response.header("Upgrade");
        if (!"websocket".equalsIgnoreCase(header2)) {
            throw new ProtocolException(CtFAbx.BI9f7h("Expected 'Upgrade' header value 'websocket' but was '", header2, "'"));
        }
        String header3 = response.header("Sec-WebSocket-Accept");
        String base64 = ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (base64.equals(header3)) {
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header3 + "'");
    }

    public final void A4TApA(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", PointType.SIGMOB_REPORT_TRACKING).build();
        Call newWebSocketCall = okhttp3.internal.A2egSU.instance.newWebSocketCall(build, build2);
        this.call = newWebSocketCall;
        newWebSocketCall.timeout().clearTimeout();
        this.call.enqueue(new okhttp3.internal.ws.A4TApA(this, build2));
    }

    public final void A5SV6n(Exception exc, Response response) {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                this.failed = true;
                ARc23Z aRc23Z = this.streams;
                this.streams = null;
                ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledExecutorService scheduledExecutorService = this.executor;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdown();
                }
                try {
                    this.listener.onFailure(this, exc, response);
                } finally {
                    okhttp3.internal.A5SV6n.ARc23Z(aRc23Z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void ADYaiT(String str, okhttp3.internal.connection.A5SV6n a5SV6n) {
        ScheduledExecutorService scheduledExecutorService;
        synchronized (this) {
            try {
                this.streams = a5SV6n;
                this.writer = new okhttp3.internal.ws.ARc23Z(a5SV6n.client, a5SV6n.sink, this.random);
                byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new okhttp3.internal.ADYaiT(str, false));
                this.executor = scheduledThreadPoolExecutor;
                if (this.pingIntervalMillis != 0) {
                    AMqCpz aMqCpz = new AMqCpz();
                    long j = this.pingIntervalMillis;
                    scheduledThreadPoolExecutor.scheduleAtFixedRate(aMqCpz, j, j, TimeUnit.MILLISECONDS);
                }
                if (!this.messageAndCloseQueue.isEmpty() && (scheduledExecutorService = this.executor) != null) {
                    scheduledExecutorService.execute(this.writerRunnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.reader = new okhttp3.internal.ws.AMqCpz(a5SV6n.client, a5SV6n.source, this);
    }

    public final void AMqCpz() {
        while (this.receivedCloseCode == -1) {
            this.reader.A2egSU();
        }
    }

    public final void ARc23Z(int i, String str) {
        ARc23Z aRc23Z;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            try {
                if (this.receivedCloseCode != -1) {
                    throw new IllegalStateException("already closed");
                }
                this.receivedCloseCode = i;
                this.receivedCloseReason = str;
                aRc23Z = null;
                if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                    ARc23Z aRc23Z2 = this.streams;
                    this.streams = null;
                    ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.executor.shutdown();
                    aRc23Z = aRc23Z2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            this.listener.onClosing(this, i, str);
            if (aRc23Z != null) {
                this.listener.onClosed(this, i, str);
            }
        } finally {
            okhttp3.internal.A5SV6n.ARc23Z(aRc23Z);
        }
    }

    public final synchronized void ASJ6gh(ByteString byteString) {
        try {
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(byteString);
                ScheduledExecutorService scheduledExecutorService = this.executor;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.execute(this.writerRunnable);
                }
                this.receivedPingCount++;
            }
        } finally {
        }
    }

    public final synchronized void AYUAbz() {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean AZOQYO(int i, ByteString byteString) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + byteString.size() > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += byteString.size();
            this.messageAndCloseQueue.add(new ADYaiT(i, byteString));
            ScheduledExecutorService scheduledExecutorService = this.executor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.execute(this.writerRunnable);
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[Catch: all -> 0x009d, TryCatch #3 {all -> 0x009d, blocks: (B:21:0x005c, B:24:0x0061, B:26:0x0065, B:28:0x0077, B:29:0x008d, B:37:0x009c, B:38:0x009f, B:39:0x00a6, B:40:0x00a7, B:42:0x00ab, B:48:0x00df, B:50:0x00e3, B:53:0x00ed, B:54:0x00ef, B:56:0x00bc, B:59:0x00c3, B:60:0x00c8, B:61:0x00c9, B:63:0x00d3, B:64:0x00d6, B:65:0x00f0, B:66:0x00f5, B:31:0x008e, B:32:0x0098, B:47:0x00dc), top: B:18:0x0058, inners: #1, #2 }] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean AZkASS() {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.A2egSU.AZkASS():boolean");
    }

    public final void AaHO0E() {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                okhttp3.internal.ws.ARc23Z aRc23Z = this.writer;
                int i = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
                if (i != -1) {
                    StringBuilder sb = new StringBuilder("sent ping but didn't receive pong within ");
                    sb.append(this.pingIntervalMillis);
                    sb.append("ms (after ");
                    A5SV6n(new SocketTimeoutException(CtFAbx.AZkASS(" successful ping/pongs)", i - 1, sb)), null);
                    return;
                }
                try {
                    aRc23Z.A2egSU(9, ByteString.EMPTY);
                } catch (IOException e) {
                    A5SV6n(e, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // okhttp3.WebSocket
    public final void cancel() {
        this.call.cancel();
    }

    @Override // okhttp3.WebSocket
    public final boolean close(int i, String str) {
        ByteString byteString;
        synchronized (this) {
            try {
                String A2egSU2 = okhttp3.internal.ws.A5SV6n.A2egSU(i);
                if (A2egSU2 != null) {
                    throw new IllegalArgumentException(A2egSU2);
                }
                if (str != null) {
                    byteString = ByteString.encodeUtf8(str);
                    if (byteString.size() > 123) {
                        throw new IllegalArgumentException("reason.size() > 123: ".concat(str));
                    }
                } else {
                    byteString = null;
                }
                if (!this.failed && !this.enqueuedClose) {
                    this.enqueuedClose = true;
                    this.messageAndCloseQueue.add(new A5SV6n(i, byteString, 60000L));
                    ScheduledExecutorService scheduledExecutorService = this.executor;
                    if (scheduledExecutorService != null) {
                        scheduledExecutorService.execute(this.writerRunnable);
                    }
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // okhttp3.WebSocket
    public final synchronized long queueSize() {
        return this.queueSize;
    }

    @Override // okhttp3.WebSocket
    public final Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public final boolean send(String str) {
        if (str != null) {
            return AZOQYO(1, ByteString.encodeUtf8(str));
        }
        throw new NullPointerException("text == null");
    }

    @Override // okhttp3.WebSocket
    public final boolean send(ByteString byteString) {
        if (byteString != null) {
            return AZOQYO(2, byteString);
        }
        throw new NullPointerException("bytes == null");
    }
}
