package okhttp3.internal.http1;

import ADYaiT.CtFAbx;
import com.sigmob.sdk.downloader.core.c;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.AYUAbz;
import okhttp3.internal.http.AZkASS;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA implements okhttp3.internal.http.A5SV6n {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    final OkHttpClient client;
    final BufferedSink sink;
    final BufferedSource source;
    final AYUAbz streamAllocation;
    int state = 0;
    private long headerLimit = 262144;

    public abstract class A2egSU implements Source {
        protected long bytesRead;
        protected boolean closed;
        protected final ForwardingTimeout timeout;

        private A2egSU() {
            this.timeout = new ForwardingTimeout(A4TApA.this.source.timeout());
            this.bytesRead = 0L;
        }

        public final void A2egSU(boolean z, IOException iOException) {
            int i = A4TApA.this.state;
            if (i == 6) {
                return;
            }
            if (i != 5) {
                throw new IllegalStateException("state: " + A4TApA.this.state);
            }
            ForwardingTimeout forwardingTimeout = this.timeout;
            Timeout delegate = forwardingTimeout.delegate();
            forwardingTimeout.setDelegate(Timeout.NONE);
            delegate.clearDeadline();
            delegate.clearTimeout();
            A4TApA a4TApA = A4TApA.this;
            a4TApA.state = 6;
            AYUAbz aYUAbz = a4TApA.streamAllocation;
            if (aYUAbz != null) {
                aYUAbz.AzWtSf(!z, a4TApA, this.bytesRead, iOException);
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) {
            try {
                long read = A4TApA.this.source.read(buffer, j);
                if (read <= 0) {
                    return read;
                }
                this.bytesRead += read;
                return read;
            } catch (IOException e) {
                A2egSU(false, e);
                throw e;
            }
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.timeout;
        }
    }

    /* renamed from: okhttp3.internal.http1.A4TApA$A4TApA, reason: collision with other inner class name */
    public final class C0555A4TApA implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        public C0555A4TApA() {
            this.timeout = new ForwardingTimeout(A4TApA.this.sink.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            A4TApA.this.sink.writeUtf8("0\r\n\r\n");
            A4TApA a4TApA = A4TApA.this;
            ForwardingTimeout forwardingTimeout = this.timeout;
            a4TApA.getClass();
            Timeout delegate = forwardingTimeout.delegate();
            forwardingTimeout.setDelegate(Timeout.NONE);
            delegate.clearDeadline();
            delegate.clearTimeout();
            A4TApA.this.state = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public final synchronized void flush() {
            if (this.closed) {
                return;
            }
            A4TApA.this.sink.flush();
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public final void write(Buffer buffer, long j) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            A4TApA.this.sink.writeHexadecimalUnsignedLong(j);
            A4TApA.this.sink.writeUtf8("\r\n");
            A4TApA.this.sink.write(buffer, j);
            A4TApA.this.sink.writeUtf8("\r\n");
        }
    }

    public class A5SV6n extends A2egSU {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpUrl url;

        public A5SV6n(HttpUrl httpUrl) {
            super();
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
            this.url = httpUrl;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            boolean z;
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                try {
                    z = okhttp3.internal.A5SV6n.B4ZgIw(100, this);
                } catch (IOException unused) {
                    z = false;
                }
                if (!z) {
                    A2egSU(false, null);
                }
            }
            this.closed = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x008b, code lost:
        
            if (r10.hasMoreChunks == false) goto L37;
         */
        @Override // okhttp3.internal.http1.A4TApA.A2egSU, okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final long read(okio.Buffer r11, long r12) {
            /*
                Method dump skipped, instructions count: 231
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http1.A4TApA.A5SV6n.read(okio.Buffer, long):long");
        }
    }

    public final class ADYaiT implements Sink {
        private long bytesRemaining;
        private boolean closed;
        private final ForwardingTimeout timeout;

        public ADYaiT(long j) {
            this.timeout = new ForwardingTimeout(A4TApA.this.sink.timeout());
            this.bytesRemaining = j;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.bytesRemaining > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            A4TApA a4TApA = A4TApA.this;
            ForwardingTimeout forwardingTimeout = this.timeout;
            a4TApA.getClass();
            Timeout delegate = forwardingTimeout.delegate();
            forwardingTimeout.setDelegate(Timeout.NONE);
            delegate.clearDeadline();
            delegate.clearTimeout();
            A4TApA.this.state = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() {
            if (this.closed) {
                return;
            }
            A4TApA.this.sink.flush();
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public final void write(Buffer buffer, long j) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long size = buffer.size();
            byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
            if (j < 0 || 0 > size || size < j) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (j <= this.bytesRemaining) {
                A4TApA.this.sink.write(buffer, j);
                this.bytesRemaining -= j;
            } else {
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
            }
        }
    }

    public class AMqCpz extends A2egSU {
        private long bytesRemaining;

        public AMqCpz(long j) {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                A2egSU(true, null);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            boolean z;
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                try {
                    z = okhttp3.internal.A5SV6n.B4ZgIw(100, this);
                } catch (IOException unused) {
                    z = false;
                }
                if (!z) {
                    A2egSU(false, null);
                }
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.A4TApA.A2egSU, okio.Source
        public final long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.bytesRemaining;
            if (j2 == 0) {
                return -1L;
            }
            long read = super.read(buffer, Math.min(j2, j));
            if (read == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                A2egSU(false, protocolException);
                throw protocolException;
            }
            long j3 = this.bytesRemaining - read;
            this.bytesRemaining = j3;
            if (j3 == 0) {
                A2egSU(true, null);
            }
            return read;
        }
    }

    public class ARc23Z extends A2egSU {
        private boolean inputExhausted;

        public ARc23Z() {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                A2egSU(false, null);
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.A4TApA.A2egSU, okio.Source
        public final long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long read = super.read(buffer, j);
            if (read != -1) {
                return read;
            }
            this.inputExhausted = true;
            A2egSU(true, null);
            return -1L;
        }
    }

    public A4TApA(OkHttpClient okHttpClient, AYUAbz aYUAbz, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.client = okHttpClient;
        this.streamAllocation = aYUAbz;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final void A2egSU() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final void A4TApA(Request request) {
        Proxy.Type type = this.streamAllocation.ADYaiT().route().proxy().type();
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        if (request.isHttps() || type != Proxy.Type.HTTP) {
            HttpUrl url = request.url();
            String encodedPath = url.encodedPath();
            String encodedQuery = url.encodedQuery();
            if (encodedQuery != null) {
                encodedPath = encodedPath + '?' + encodedQuery;
            }
            sb.append(encodedPath);
        } else {
            sb.append(request.url());
        }
        sb.append(" HTTP/1.1");
        AZOQYO(request.headers(), sb.toString());
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final okhttp3.internal.http.AYUAbz A5SV6n(Response response) {
        AYUAbz aYUAbz = this.streamAllocation;
        aYUAbz.eventListener.responseBodyStart(aYUAbz.call);
        String header = response.header("Content-Type");
        if (!okhttp3.internal.http.AMqCpz.A4TApA(response)) {
            return new okhttp3.internal.http.AYUAbz(header, 0L, Okio.buffer(ASJ6gh(0L)));
        }
        if ("chunked".equalsIgnoreCase(response.header(c.h))) {
            HttpUrl url = response.request().url();
            if (this.state == 4) {
                this.state = 5;
                return new okhttp3.internal.http.AYUAbz(header, -1L, Okio.buffer(new A5SV6n(url)));
            }
            throw new IllegalStateException("state: " + this.state);
        }
        long A2egSU2 = okhttp3.internal.http.AMqCpz.A2egSU(response);
        if (A2egSU2 != -1) {
            return new okhttp3.internal.http.AYUAbz(header, A2egSU2, Okio.buffer(ASJ6gh(A2egSU2)));
        }
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        AYUAbz aYUAbz2 = this.streamAllocation;
        if (aYUAbz2 == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.state = 5;
        aYUAbz2.AZkASS();
        return new okhttp3.internal.http.AYUAbz(header, -1L, Okio.buffer(new ARc23Z()));
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final Response.Builder ADYaiT(boolean z) {
        int i = this.state;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.state);
        }
        try {
            String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
            this.headerLimit -= readUtf8LineStrict.length();
            AZkASS A2egSU2 = AZkASS.A2egSU(readUtf8LineStrict);
            Response.Builder message = new Response.Builder().protocol(A2egSU2.protocol).code(A2egSU2.code).message(A2egSU2.message);
            Headers.Builder builder = new Headers.Builder();
            while (true) {
                String readUtf8LineStrict2 = this.source.readUtf8LineStrict(this.headerLimit);
                this.headerLimit -= readUtf8LineStrict2.length();
                if (readUtf8LineStrict2.length() == 0) {
                    break;
                }
                okhttp3.internal.A2egSU.instance.addLenient(builder, readUtf8LineStrict2);
            }
            Response.Builder headers = message.headers(builder.build());
            if (z && A2egSU2.code == 100) {
                return null;
            }
            if (A2egSU2.code == 100) {
                this.state = 3;
                return headers;
            }
            this.state = 4;
            return headers;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.streamAllocation);
            iOException.initCause(e);
            throw iOException;
        }
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final void AMqCpz() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final Sink ARc23Z(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header(c.h))) {
            if (this.state == 1) {
                this.state = 2;
                return new C0555A4TApA();
            }
            throw new IllegalStateException("state: " + this.state);
        }
        if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.state == 1) {
            this.state = 2;
            return new ADYaiT(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final AMqCpz ASJ6gh(long j) {
        if (this.state == 4) {
            this.state = 5;
            return new AMqCpz(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final Headers AYUAbz() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
            this.headerLimit -= readUtf8LineStrict.length();
            if (readUtf8LineStrict.length() == 0) {
                return builder.build();
            }
            okhttp3.internal.A2egSU.instance.addLenient(builder, readUtf8LineStrict);
        }
    }

    public final void AZOQYO(Headers headers, String str) {
        if (this.state != 0) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.sink.writeUtf8(str).writeUtf8("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final void cancel() {
        okhttp3.internal.connection.ADYaiT ADYaiT2 = this.streamAllocation.ADYaiT();
        if (ADYaiT2 != null) {
            ADYaiT2.A5SV6n();
        }
    }
}
