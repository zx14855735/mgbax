package okhttp3.internal.http;

import ADYaiT.CtFAbx;
import java.io.IOException;
import java.net.ProtocolException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AZOQYO implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private final boolean forWebSocket;
    private volatile okhttp3.internal.connection.AYUAbz streamAllocation;

    public AZOQYO(OkHttpClient okHttpClient, boolean z) {
        this.client = okHttpClient;
        this.forWebSocket = z;
    }

    public static boolean ARc23Z(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }

    public final void A2egSU() {
        this.canceled = true;
        okhttp3.internal.connection.AYUAbz aYUAbz = this.streamAllocation;
        if (aYUAbz != null) {
            aYUAbz.A4TApA();
        }
    }

    public final Address A4TApA(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            sSLSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00e4, code lost:
    
        if (r1.equals(com.sigmob.sdk.downloader.core.c.f13360a) == false) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Request A5SV6n(okhttp3.Route r9, okhttp3.Response r10) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.AZOQYO.A5SV6n(okhttp3.Route, okhttp3.Response):okhttp3.Request");
    }

    public final boolean ADYaiT() {
        return this.canceled;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        if (r5 == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean AMqCpz(java.io.IOException r3, okhttp3.internal.connection.AYUAbz r4, boolean r5, okhttp3.Request r6) {
        /*
            r2 = this;
            r4.AmA8tU(r3)
            okhttp3.OkHttpClient r0 = r2.client
            boolean r0 = r0.retryOnConnectionFailure()
            r1 = 0
            if (r0 != 0) goto Ld
            goto L3a
        Ld:
            if (r5 == 0) goto L12
            r6.body()
        L12:
            boolean r6 = r3 instanceof java.net.ProtocolException
            if (r6 == 0) goto L17
            return r1
        L17:
            boolean r6 = r3 instanceof java.io.InterruptedIOException
            if (r6 == 0) goto L22
            boolean r3 = r3 instanceof java.net.SocketTimeoutException
            if (r3 == 0) goto L3a
            if (r5 != 0) goto L3a
            goto L34
        L22:
            boolean r5 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r5 == 0) goto L2f
            java.lang.Throwable r5 = r3.getCause()
            boolean r5 = r5 instanceof java.security.cert.CertificateException
            if (r5 == 0) goto L2f
            goto L3a
        L2f:
            boolean r3 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r3 == 0) goto L34
            return r1
        L34:
            boolean r3 = r4.AYUAbz()
            if (r3 != 0) goto L3b
        L3a:
            return r1
        L3b:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.AZOQYO.AMqCpz(java.io.IOException, okhttp3.internal.connection.AYUAbz, boolean, okhttp3.Request):boolean");
    }

    public final void ASJ6gh(Object obj) {
        this.callStackTrace = obj;
    }

    public final okhttp3.internal.connection.AYUAbz AYUAbz() {
        return this.streamAllocation;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        Response A5SV6n2;
        Request A5SV6n3;
        Request request = chain.request();
        ASJ6gh aSJ6gh = (ASJ6gh) chain;
        Call call = aSJ6gh.call();
        EventListener A2egSU2 = aSJ6gh.A2egSU();
        okhttp3.internal.connection.AYUAbz aYUAbz = new okhttp3.internal.connection.AYUAbz(this.client.connectionPool(), A4TApA(request.url()), call, A2egSU2, this.callStackTrace);
        this.streamAllocation = aYUAbz;
        okhttp3.internal.connection.AYUAbz aYUAbz2 = aYUAbz;
        Response response = null;
        int i = 0;
        Request request2 = request;
        while (!this.canceled) {
            try {
                try {
                    try {
                        A5SV6n2 = aSJ6gh.A5SV6n(request2, aYUAbz2, null, null);
                        if (response != null) {
                            A5SV6n2 = A5SV6n2.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                        }
                        try {
                            A5SV6n3 = A5SV6n(aYUAbz2.AlLFFp(), A5SV6n2);
                        } catch (IOException e) {
                            aYUAbz2.AaHO0E();
                            throw e;
                        }
                    } catch (okhttp3.internal.connection.ARc23Z e2) {
                        if (!AMqCpz(e2.A5SV6n(), aYUAbz2, false, request2)) {
                            throw e2.A4TApA();
                        }
                    }
                } catch (IOException e3) {
                    if (!AMqCpz(e3, aYUAbz2, !(e3 instanceof okhttp3.internal.http2.A2egSU), request2)) {
                        throw e3;
                    }
                }
                if (A5SV6n3 == null) {
                    aYUAbz2.AaHO0E();
                    return A5SV6n2;
                }
                okhttp3.internal.A5SV6n.ARc23Z(A5SV6n2.body());
                int i2 = i + 1;
                if (i2 > 20) {
                    aYUAbz2.AaHO0E();
                    throw new ProtocolException(CtFAbx.ARc23Z(i2, "Too many follow-up requests: "));
                }
                A5SV6n3.body();
                if (!ARc23Z(A5SV6n2, A5SV6n3.url())) {
                    aYUAbz2.AaHO0E();
                    okhttp3.internal.connection.AYUAbz aYUAbz3 = new okhttp3.internal.connection.AYUAbz(this.client.connectionPool(), A4TApA(A5SV6n3.url()), call, A2egSU2, this.callStackTrace);
                    this.streamAllocation = aYUAbz3;
                    aYUAbz2 = aYUAbz3;
                } else if (aYUAbz2.A5SV6n() != null) {
                    throw new IllegalStateException("Closing the body of " + A5SV6n2 + " didn't close its backing stream. Bad interceptor?");
                }
                response = A5SV6n2;
                request2 = A5SV6n3;
                i = i2;
            } catch (Throwable th) {
                aYUAbz2.AmA8tU(null);
                aYUAbz2.AaHO0E();
                throw th;
            }
        }
        aYUAbz2.AaHO0E();
        throw new IOException("Canceled");
    }
}
