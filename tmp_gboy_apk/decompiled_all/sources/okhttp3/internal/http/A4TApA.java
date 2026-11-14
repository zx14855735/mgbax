package okhttp3.internal.http;

import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA implements Interceptor {
    private final boolean forWebSocket;

    public static final class A2egSU extends ForwardingSink {
        long successfulCount;

        public A2egSU(Sink sink) {
            super(sink);
        }

        @Override // okio.ForwardingSink, okio.Sink
        public final void write(Buffer buffer, long j) {
            super.write(buffer, j);
            this.successfulCount += j;
        }
    }

    public A4TApA(boolean z) {
        this.forWebSocket = z;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        ASJ6gh aSJ6gh = (ASJ6gh) chain;
        A5SV6n A4TApA2 = aSJ6gh.A4TApA();
        okhttp3.internal.connection.AYUAbz ADYaiT2 = aSJ6gh.ADYaiT();
        okhttp3.internal.connection.ADYaiT aDYaiT = (okhttp3.internal.connection.ADYaiT) aSJ6gh.connection();
        Request request = aSJ6gh.request();
        long currentTimeMillis = System.currentTimeMillis();
        aSJ6gh.A2egSU().requestHeadersStart(aSJ6gh.call());
        A4TApA2.A4TApA(request);
        aSJ6gh.A2egSU().requestHeadersEnd(aSJ6gh.call(), request);
        Response.Builder builder = null;
        if (ARc23Z.A4TApA(request.method()) && request.body() != null) {
            if ("100-continue".equalsIgnoreCase(request.header("Expect"))) {
                A4TApA2.AMqCpz();
                aSJ6gh.A2egSU().responseHeadersStart(aSJ6gh.call());
                builder = A4TApA2.ADYaiT(true);
            }
            if (builder == null) {
                aSJ6gh.A2egSU().requestBodyStart(aSJ6gh.call());
                A2egSU a2egSU = new A2egSU(A4TApA2.ARc23Z(request, request.body().contentLength()));
                BufferedSink buffer = Okio.buffer(a2egSU);
                request.body().writeTo(buffer);
                buffer.close();
                aSJ6gh.A2egSU().requestBodyEnd(aSJ6gh.call(), a2egSU.successfulCount);
            } else if (!aDYaiT.AZkASS()) {
                ADYaiT2.AZkASS();
            }
        }
        A4TApA2.A2egSU();
        if (builder == null) {
            aSJ6gh.A2egSU().responseHeadersStart(aSJ6gh.call());
            builder = A4TApA2.ADYaiT(false);
        }
        Response build = builder.request(request).handshake(ADYaiT2.ADYaiT().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int code = build.code();
        if (code == 100) {
            build = A4TApA2.ADYaiT(false).request(request).handshake(ADYaiT2.ADYaiT().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build.code();
        }
        aSJ6gh.A2egSU().responseHeadersEnd(aSJ6gh.call(), build);
        Response build2 = (this.forWebSocket && code == 101) ? build.newBuilder().body(okhttp3.internal.A5SV6n.EMPTY_RESPONSE).build() : build.newBuilder().body(A4TApA2.A5SV6n(build)).build();
        if ("close".equalsIgnoreCase(build2.request().header("Connection")) || "close".equalsIgnoreCase(build2.header("Connection"))) {
            ADYaiT2.AZkASS();
        }
        if ((code != 204 && code != 205) || build2.body().contentLength() <= 0) {
            return build2;
        }
        StringBuilder B9tovu2 = J3FDQU.A2egSU.B9tovu(code, "HTTP ", " had non-zero Content-Length: ");
        B9tovu2.append(build2.body().contentLength());
        throw new ProtocolException(B9tovu2.toString());
    }
}
