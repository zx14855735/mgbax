package okhttp3;

import RmWSka.A4TApA;
import com.baidu.mobads.sdk.internal.an;
import com.sigmob.sdk.downloader.core.c;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.cache.A5SV6n;
import okhttp3.internal.cache.ADYaiT;
import okhttp3.internal.cache.AMqCpz;
import okhttp3.internal.cache.ASJ6gh;
import okhttp3.internal.cache.AZkASS;
import okhttp3.internal.http.ARc23Z;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final AMqCpz cache;
    private int hitCount;
    final AZkASS internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    public final class CacheRequestImpl implements A5SV6n {
        private Sink body;
        private Sink cacheOut;
        boolean done;
        private final AMqCpz.A4TApA editor;

        public CacheRequestImpl(final AMqCpz.A4TApA a4TApA) {
            this.editor = a4TApA;
            Sink ADYaiT2 = a4TApA.ADYaiT(1);
            this.cacheOut = ADYaiT2;
            this.body = new ForwardingSink(ADYaiT2) { // from class: okhttp3.Cache.CacheRequestImpl.1
                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (Cache.this) {
                        try {
                            CacheRequestImpl cacheRequestImpl = CacheRequestImpl.this;
                            if (cacheRequestImpl.done) {
                                return;
                            }
                            cacheRequestImpl.done = true;
                            Cache.this.writeSuccessCount++;
                            super.close();
                            a4TApA.A4TApA();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.A5SV6n
        public void abort() {
            synchronized (Cache.this) {
                try {
                    if (this.done) {
                        return;
                    }
                    this.done = true;
                    Cache.this.writeAbortCount++;
                    okhttp3.internal.A5SV6n.ARc23Z(this.cacheOut);
                    try {
                        this.editor.A2egSU();
                    } catch (IOException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okhttp3.internal.cache.A5SV6n
        public Sink body() {
            return this.body;
        }
    }

    public static class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;

        @Nullable
        private final String contentLength;

        @Nullable
        private final String contentType;
        final AMqCpz.ADYaiT snapshot;

        public CacheResponseBody(final AMqCpz.ADYaiT aDYaiT, String str, String str2) {
            this.snapshot = aDYaiT;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.buffer(new ForwardingSource(aDYaiT.A5SV6n(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    aDYaiT.close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            try {
                String str = this.contentLength;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    public Cache(File file, long j) {
        this(file, j, A4TApA.SYSTEM);
    }

    private void abortQuietly(@Nullable AMqCpz.A4TApA a4TApA) {
        if (a4TApA != null) {
            try {
                a4TApA.A2egSU();
            } catch (IOException unused) {
            }
        }
    }

    public static String key(HttpUrl httpUrl) {
        return ByteString.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    public static int readInt(BufferedSource bufferedSource) {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cache.close();
    }

    public void delete() {
        this.cache.delete();
    }

    public File directory() {
        return this.cache.ARc23Z();
    }

    public void evictAll() {
        this.cache.ADYaiT();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.cache.flush();
    }

    @Nullable
    public Response get(Request request) {
        try {
            AMqCpz.ADYaiT AMqCpz = this.cache.AMqCpz(key(request.url()));
            if (AMqCpz != null) {
                try {
                    Entry entry = new Entry(AMqCpz.A5SV6n(0));
                    Response response = entry.response(AMqCpz);
                    if (entry.matches(request, response)) {
                        return response;
                    }
                    okhttp3.internal.A5SV6n.ARc23Z(response.body());
                    return null;
                } catch (IOException unused) {
                    okhttp3.internal.A5SV6n.ARc23Z(AMqCpz);
                }
            }
        } catch (IOException unused2) {
        }
        return null;
    }

    public synchronized int hitCount() {
        return this.hitCount;
    }

    public void initialize() {
        this.cache.AYUAbz();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public long maxSize() {
        return this.cache.ASJ6gh();
    }

    public synchronized int networkCount() {
        return this.networkCount;
    }

    @Nullable
    public A5SV6n put(Response response) {
        AMqCpz.A4TApA a4TApA;
        String method = response.request().method();
        if (ARc23Z.A2egSU(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!method.equals(an.c)) {
            return null;
        }
        int i = okhttp3.internal.http.AMqCpz.f14071A2egSU;
        if (okhttp3.internal.http.AMqCpz.AZOQYO(response.headers()).contains("*")) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            a4TApA = this.cache.A5SV6n(key(response.request().url()), -1L);
            if (a4TApA == null) {
                return null;
            }
            try {
                entry.writeTo(a4TApA);
                return new CacheRequestImpl(a4TApA);
            } catch (IOException unused2) {
                abortQuietly(a4TApA);
                return null;
            }
        } catch (IOException unused3) {
            a4TApA = null;
        }
    }

    public void remove(Request request) {
        this.cache.AzWtSf(key(request.url()));
    }

    public synchronized int requestCount() {
        return this.requestCount;
    }

    public long size() {
        return this.cache.B2KMhB();
    }

    public synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    public synchronized void trackResponse(ADYaiT aDYaiT) {
        try {
            this.requestCount++;
            if (aDYaiT.networkRequest != null) {
                this.networkCount++;
            } else if (aDYaiT.cacheResponse != null) {
                this.hitCount++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void update(Response response, Response response2) {
        AMqCpz.A4TApA a4TApA;
        Entry entry = new Entry(response2);
        try {
            a4TApA = ((CacheResponseBody) response.body()).snapshot.A4TApA();
            if (a4TApA != null) {
                try {
                    entry.writeTo(a4TApA);
                    a4TApA.A4TApA();
                } catch (IOException unused) {
                    abortQuietly(a4TApA);
                }
            }
        } catch (IOException unused2) {
            a4TApA = null;
        }
    }

    public Iterator<String> urls() {
        return new Iterator<String>() { // from class: okhttp3.Cache.2
            boolean canRemove;
            final Iterator<AMqCpz.ADYaiT> delegate;

            @Nullable
            String nextUrl;

            {
                ASJ6gh aSJ6gh;
                AMqCpz aMqCpz = Cache.this.cache;
                synchronized (aMqCpz) {
                    aMqCpz.AYUAbz();
                    aSJ6gh = new ASJ6gh(aMqCpz);
                }
                this.delegate = aSJ6gh;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextUrl != null) {
                    return true;
                }
                this.canRemove = false;
                while (this.delegate.hasNext()) {
                    AMqCpz.ADYaiT next = this.delegate.next();
                    try {
                        this.nextUrl = Okio.buffer(next.A5SV6n(0)).readUtf8LineStrict();
                        return true;
                    } catch (IOException unused) {
                    } finally {
                        next.close();
                    }
                }
                return false;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (!this.canRemove) {
                    throw new IllegalStateException("remove() before next()");
                }
                this.delegate.remove();
            }

            @Override // java.util.Iterator
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String str = this.nextUrl;
                this.nextUrl = null;
                this.canRemove = true;
                return str;
            }
        };
    }

    public synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public Cache(File file, long j, A4TApA a4TApA) {
        this.internalCache = new AZkASS() { // from class: okhttp3.Cache.1
            @Override // okhttp3.internal.cache.AZkASS
            public Response get(Request request) {
                return Cache.this.get(request);
            }

            @Override // okhttp3.internal.cache.AZkASS
            public A5SV6n put(Response response) {
                return Cache.this.put(response);
            }

            @Override // okhttp3.internal.cache.AZkASS
            public void remove(Request request) {
                Cache.this.remove(request);
            }

            @Override // okhttp3.internal.cache.AZkASS
            public void trackConditionalCacheHit() {
                Cache.this.trackConditionalCacheHit();
            }

            @Override // okhttp3.internal.cache.AZkASS
            public void trackResponse(ADYaiT aDYaiT) {
                Cache.this.trackResponse(aDYaiT);
            }

            @Override // okhttp3.internal.cache.AZkASS
            public void update(Response response, Response response2) {
                Cache.this.update(response, response2);
            }
        };
        int i = AMqCpz.f14070AcNBzu;
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
        this.cache = new AMqCpz(a4TApA, file, VERSION, 2, j, new ThreadPoolExecutor(0, 1, 60L, timeUnit, linkedBlockingQueue, new okhttp3.internal.ADYaiT("OkHttp DiskLruCache", true)));
    }

    public static final class Entry {
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;

        @Nullable
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        static {
            okhttp3.internal.platform.ARc23Z.AZOQYO().getClass();
            SENT_MILLIS = "OkHttp-Sent-Millis";
            okhttp3.internal.platform.ARc23Z.AZOQYO().getClass();
            RECEIVED_MILLIS = "OkHttp-Received-Millis";
            kmKCizF();
        }

        public Entry(Source source) {
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.url = buffer.readUtf8LineStrict();
                this.requestMethod = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int readInt = Cache.readInt(buffer);
                for (int i = 0; i < readInt; i++) {
                    builder.addLenient(buffer.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                okhttp3.internal.http.AZkASS A2egSU2 = okhttp3.internal.http.AZkASS.A2egSU(buffer.readUtf8LineStrict());
                this.protocol = A2egSU2.protocol;
                this.code = A2egSU2.code;
                this.message = A2egSU2.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt2 = Cache.readInt(buffer);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    builder2.addLenient(buffer.readUtf8LineStrict());
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                    this.handshake = Handshake.get(!buffer.exhausted() ? TlsVersion.forJavaName(buffer.readUtf8LineStrict()) : TlsVersion.SSL_3_0, CipherSuite.forJavaName(buffer.readUtf8LineStrict()), readCertificateList(buffer), readCertificateList(buffer));
                } else {
                    this.handshake = null;
                }
                source.close();
            } catch (Throwable th) {
                source.close();
                throw th;
            }
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private static /* synthetic */ void kmKCizF() {
            char[] charArray = "\u008e\u0082\u0080Ã\u008a\u008c\u0080\u0088Ã\u008f\u0082\u0094Ã\u009e\u0085\u0088\u0081\u0081Ã§\u0083\u0084¯\u009f\u0084\u0089\u008a\u0088".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 237);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u008e\u0081\u0084\u0083\u0084\u0099".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 237);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        private List<Certificate> readCertificateList(BufferedSource bufferedSource) {
            int readInt = Cache.readInt(bufferedSource);
            if (readInt == -1) {
                return Collections.EMPTY_LIST;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void writeCertList(BufferedSink bufferedSink, List<Certificate> list) {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(ByteString.of(list.get(i).getEncoded()).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean matches(Request request, Response response) {
            if (!this.url.equals(request.url().toString()) || !this.requestMethod.equals(request.method())) {
                return false;
            }
            Headers headers = this.varyHeaders;
            int i = okhttp3.internal.http.AMqCpz.f14071A2egSU;
            for (String str : okhttp3.internal.http.AMqCpz.AZOQYO(response.headers())) {
                if (!okhttp3.internal.A5SV6n.AcNBzu(headers.values(str), request.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        public Response response(AMqCpz.ADYaiT aDYaiT) {
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get(c.e);
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(aDYaiT, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public void writeTo(AMqCpz.A4TApA a4TApA) {
            BufferedSink buffer = Okio.buffer(a4TApA.ADYaiT(0));
            buffer.writeUtf8(this.url).writeByte(10);
            buffer.writeUtf8(this.requestMethod).writeByte(10);
            buffer.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
            int size = this.varyHeaders.size();
            for (int i = 0; i < size; i++) {
                buffer.writeUtf8(this.varyHeaders.name(i)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i)).writeByte(10);
            }
            buffer.writeUtf8(new okhttp3.internal.http.AZkASS(this.protocol, this.code, this.message).toString()).writeByte(10);
            buffer.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
            int size2 = this.responseHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                buffer.writeUtf8(this.responseHeaders.name(i2)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i2)).writeByte(10);
            }
            buffer.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
            buffer.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
            if (isHttps()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.handshake.cipherSuite().javaName()).writeByte(10);
                writeCertList(buffer, this.handshake.peerCertificates());
                writeCertList(buffer, this.handshake.localCertificates());
                buffer.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
            }
            buffer.close();
        }

        public Entry(Response response) {
            Headers build;
            this.url = response.request().url().toString();
            int i = okhttp3.internal.http.AMqCpz.f14071A2egSU;
            Headers headers = response.networkResponse().request().headers();
            Set AZOQYO2 = okhttp3.internal.http.AMqCpz.AZOQYO(response.headers());
            if (AZOQYO2.isEmpty()) {
                build = new Headers.Builder().build();
            } else {
                Headers.Builder builder = new Headers.Builder();
                int size = headers.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String name = headers.name(i2);
                    if (AZOQYO2.contains(name)) {
                        builder.add(name, headers.value(i2));
                    }
                }
                build = builder.build();
            }
            this.varyHeaders = build;
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
