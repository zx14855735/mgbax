package okhttp3.internal.http2;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http2.B4ZgIw;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ASJ6gh implements okhttp3.internal.http.A5SV6n {
    private final Interceptor.Chain chain;
    private final AmA8tU connection;
    private final Protocol protocol;
    private B4ZgIw stream;
    final okhttp3.internal.connection.AYUAbz streamAllocation;
    private static final String CONNECTION = "connection";
    private static final String HOST = "host";
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String ENCODING = "encoding";
    private static final String UPGRADE = "upgrade";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = okhttp3.internal.A5SV6n.AzWtSf(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, ADYaiT.TARGET_METHOD_UTF8, ADYaiT.TARGET_PATH_UTF8, ADYaiT.TARGET_SCHEME_UTF8, ADYaiT.TARGET_AUTHORITY_UTF8);
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = okhttp3.internal.A5SV6n.AzWtSf(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);

    public class A2egSU extends ForwardingSource {
        long bytesRead;
        boolean completed;

        public A2egSU(Source source) {
            super(source);
            this.completed = false;
            this.bytesRead = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            super.close();
            if (this.completed) {
                return;
            }
            this.completed = true;
            ASJ6gh aSJ6gh = ASJ6gh.this;
            aSJ6gh.streamAllocation.AzWtSf(false, aSJ6gh, this.bytesRead, null);
        }

        @Override // okio.ForwardingSource, okio.Source
        public final long read(Buffer buffer, long j) {
            try {
                long read = delegate().read(buffer, j);
                if (read <= 0) {
                    return read;
                }
                this.bytesRead += read;
                return read;
            } catch (IOException e) {
                if (this.completed) {
                    throw e;
                }
                this.completed = true;
                ASJ6gh aSJ6gh = ASJ6gh.this;
                aSJ6gh.streamAllocation.AzWtSf(false, aSJ6gh, this.bytesRead, e);
                throw e;
            }
        }
    }

    static {
        LWhzNe();
    }

    public ASJ6gh(OkHttpClient okHttpClient, Interceptor.Chain chain, okhttp3.internal.connection.AYUAbz aYUAbz, AmA8tU amA8tU) {
        this.chain = chain;
        this.streamAllocation = aYUAbz;
        this.connection = amA8tU;
        List<Protocol> protocols = okHttpClient.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = protocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    private static /* synthetic */ void LWhzNe() {
        char[] charArray = "oca\"kmai\"ncu\"\u007fdi``\"FbeN~ehki".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\f');
        }
        String str = new String(charArray);
        char[] charArray2 = "o`ebex".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\f');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final void A2egSU() {
        this.stream.ARc23Z().close();
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final void A4TApA(Request request) {
        int i;
        B4ZgIw b4ZgIw;
        if (this.stream != null) {
            return;
        }
        boolean z = true;
        boolean z2 = request.body() != null;
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new ADYaiT(ADYaiT.TARGET_METHOD, request.method()));
        ByteString byteString = ADYaiT.TARGET_PATH;
        HttpUrl url = request.url();
        String encodedPath = url.encodedPath();
        String encodedQuery = url.encodedQuery();
        if (encodedQuery != null) {
            encodedPath = encodedPath + '?' + encodedQuery;
        }
        arrayList.add(new ADYaiT(byteString, encodedPath));
        String header = request.header("Host");
        if (header != null) {
            arrayList.add(new ADYaiT(ADYaiT.TARGET_AUTHORITY, header));
        }
        arrayList.add(new ADYaiT(ADYaiT.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i2).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8.utf8())) {
                arrayList.add(new ADYaiT(encodeUtf8, headers.value(i2)));
            }
        }
        AmA8tU amA8tU = this.connection;
        boolean z3 = !z2;
        synchronized (amA8tU.writer) {
            synchronized (amA8tU) {
                try {
                    if (amA8tU.nextStreamId > 1073741823) {
                        amA8tU.AZkASS(A4TApA.REFUSED_STREAM);
                    }
                    if (amA8tU.shutdown) {
                        throw new okhttp3.internal.http2.A2egSU();
                    }
                    i = amA8tU.nextStreamId;
                    amA8tU.nextStreamId = i + 2;
                    b4ZgIw = new B4ZgIw(i, amA8tU, z3, false, null);
                    if (z2 && amA8tU.bytesLeftInWriteWindow != 0 && b4ZgIw.bytesLeftInWriteWindow != 0) {
                        z = false;
                    }
                    if (b4ZgIw.AZOQYO()) {
                        amA8tU.streams.put(Integer.valueOf(i), b4ZgIw);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            amA8tU.writer.AaHO0E(i, arrayList, z3);
        }
        if (z) {
            amA8tU.writer.flush();
        }
        this.stream = b4ZgIw;
        B4ZgIw.A5SV6n a5SV6n = b4ZgIw.readTimeout;
        long readTimeoutMillis = this.chain.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a5SV6n.timeout(readTimeoutMillis, timeUnit);
        this.stream.writeTimeout.timeout(this.chain.writeTimeoutMillis(), timeUnit);
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final okhttp3.internal.http.AYUAbz A5SV6n(Response response) {
        okhttp3.internal.connection.AYUAbz aYUAbz = this.streamAllocation;
        aYUAbz.eventListener.responseBodyStart(aYUAbz.call);
        return new okhttp3.internal.http.AYUAbz(response.header("Content-Type"), okhttp3.internal.http.AMqCpz.A2egSU(response), Okio.buffer(new A2egSU(this.stream.ASJ6gh())));
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final Response.Builder ADYaiT(boolean z) {
        Headers AmA8tU2 = this.stream.AmA8tU();
        Protocol protocol = this.protocol;
        Headers.Builder builder = new Headers.Builder();
        int size = AmA8tU2.size();
        okhttp3.internal.http.AZkASS aZkASS = null;
        for (int i = 0; i < size; i++) {
            String name = AmA8tU2.name(i);
            String value = AmA8tU2.value(i);
            if (name.equals(ADYaiT.RESPONSE_STATUS_UTF8)) {
                aZkASS = okhttp3.internal.http.AZkASS.A2egSU("HTTP/1.1 " + value);
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                okhttp3.internal.A2egSU.instance.addLenient(builder, name, value);
            }
        }
        if (aZkASS == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        Response.Builder headers = new Response.Builder().protocol(protocol).code(aZkASS.code).message(aZkASS.message).headers(builder.build());
        if (z && okhttp3.internal.A2egSU.instance.code(headers) == 100) {
            return null;
        }
        return headers;
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final void AMqCpz() {
        this.connection.writer.flush();
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final Sink ARc23Z(Request request, long j) {
        return this.stream.ARc23Z();
    }

    @Override // okhttp3.internal.http.A5SV6n
    public final void cancel() {
        B4ZgIw b4ZgIw = this.stream;
        if (b4ZgIw != null) {
            A4TApA a4TApA = A4TApA.CANCEL;
            if (b4ZgIw.AMqCpz(a4TApA)) {
                b4ZgIw.connection.AzWtSf(b4ZgIw.id, a4TApA);
            }
        }
    }
}
