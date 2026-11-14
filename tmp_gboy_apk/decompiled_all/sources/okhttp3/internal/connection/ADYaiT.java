package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Route;
import okhttp3.internal.http2.AmA8tU;
import okhttp3.internal.http2.B4ZgIw;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Timeout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ADYaiT extends AmA8tU.A4TApA implements Connection {
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private final ConnectionPool connectionPool;
    private Handshake handshake;
    private AmA8tU http2Connection;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    public int successCount;
    public int allocationLimit = 1;
    public final List<Reference<AYUAbz>> allocations = new ArrayList();
    public long idleAtNanos = Long.MAX_VALUE;

    public ADYaiT(ConnectionPool connectionPool, Route route) {
        this.connectionPool = connectionPool;
        this.route = route;
    }

    @Override // okhttp3.internal.http2.AmA8tU.A4TApA
    public final void A2egSU(AmA8tU amA8tU) {
        synchronized (this.connectionPool) {
            this.allocationLimit = amA8tU.ASJ6gh();
        }
    }

    @Override // okhttp3.internal.http2.AmA8tU.A4TApA
    public final void A4TApA(B4ZgIw b4ZgIw) {
        b4ZgIw.ADYaiT(okhttp3.internal.http2.A4TApA.REFUSED_STREAM);
    }

    public final void A5SV6n() {
        okhttp3.internal.A5SV6n.ASJ6gh(this.rawSocket);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e9 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ADYaiT(int r13, int r14, int r15, int r16, boolean r17, okhttp3.Call r18, okhttp3.EventListener r19) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ADYaiT.ADYaiT(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    public final void AMqCpz(int i, int i2, Call call, EventListener eventListener) {
        Proxy proxy = this.route.proxy();
        this.rawSocket = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? this.route.address().socketFactory().createSocket() : new Socket(proxy);
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        this.rawSocket.setSoTimeout(i2);
        try {
            okhttp3.internal.platform.ARc23Z.AZOQYO().AYUAbz(this.rawSocket, this.route.socketAddress(), i);
            try {
                this.source = Okio.buffer(Okio.source(this.rawSocket));
                this.sink = Okio.buffer(Okio.sink(this.rawSocket));
            } catch (NullPointerException e) {
                if (NPE_THROW_WITH_NULL.equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x017b, code lost:
    
        if (r4 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x017e, code lost:
    
        okhttp3.internal.A5SV6n.ASJ6gh(r19.rawSocket);
        r6 = false;
        r19.rawSocket = null;
        r19.sink = null;
        r19.source = null;
        r24.connectEnd(r23, r19.route.socketAddress(), r19.route.proxy(), null);
        r12 = r18 + 1;
        r9 = r16;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x01a8, code lost:
    
        return;
     */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2, types: [okhttp3.OkHttpClient, okhttp3.internal.connection.AYUAbz] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ARc23Z(int r20, int r21, int r22, okhttp3.Call r23, okhttp3.EventListener r24) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ADYaiT.ARc23Z(int, int, int, okhttp3.Call, okhttp3.EventListener):void");
    }

    public final void ASJ6gh(A4TApA a4TApA, int i, Call call, EventListener eventListener) {
        SSLSocket sSLSocket;
        if (this.route.address().sslSocketFactory() == null) {
            List<Protocol> protocols = this.route.address().protocols();
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!protocols.contains(protocol)) {
                this.socket = this.rawSocket;
                this.protocol = Protocol.HTTP_1_1;
                return;
            } else {
                this.socket = this.rawSocket;
                this.protocol = protocol;
                AlLFFp(i);
                return;
            }
        }
        eventListener.secureConnectStart(call);
        Address address = this.route.address();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            ConnectionSpec A2egSU2 = a4TApA.A2egSU(sSLSocket);
            if (A2egSU2.supportsTlsExtensions()) {
                okhttp3.internal.platform.ARc23Z.AZOQYO().ASJ6gh(sSLSocket, address.url().host(), address.protocols());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            Handshake handshake = Handshake.get(session);
            if (!address.hostnameVerifier().verify(address.url().host(), session)) {
                X509Certificate x509Certificate = (X509Certificate) handshake.peerCertificates().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + RpxDSP.ADYaiT.A2egSU(x509Certificate));
            }
            address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
            String AaHO0E2 = A2egSU2.supportsTlsExtensions() ? okhttp3.internal.platform.ARc23Z.AZOQYO().AaHO0E(sSLSocket) : null;
            this.socket = sSLSocket;
            this.source = Okio.buffer(Okio.source(sSLSocket));
            this.sink = Okio.buffer(Okio.sink(this.socket));
            this.handshake = handshake;
            this.protocol = AaHO0E2 != null ? Protocol.get(AaHO0E2) : Protocol.HTTP_1_1;
            okhttp3.internal.platform.ARc23Z.AZOQYO().A2egSU(sSLSocket);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol == Protocol.HTTP_2) {
                AlLFFp(i);
            }
        } catch (AssertionError e2) {
            e = e2;
            if (!okhttp3.internal.A5SV6n.B2KMhB(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                okhttp3.internal.platform.ARc23Z.AZOQYO().A2egSU(sSLSocket2);
            }
            okhttp3.internal.A5SV6n.ASJ6gh(sSLSocket2);
            throw th;
        }
    }

    public final boolean AYUAbz(Address address, Route route) {
        if (this.allocations.size() >= this.allocationLimit || this.noNewStreams || !okhttp3.internal.A2egSU.instance.equalsNonHost(this.route.address(), address)) {
            return false;
        }
        if (address.url().host().equals(this.route.address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || route == null) {
            return false;
        }
        Proxy.Type type = route.proxy().type();
        Proxy.Type type2 = Proxy.Type.DIRECT;
        if (type != type2 || this.route.proxy().type() != type2 || !this.route.socketAddress().equals(route.socketAddress()) || route.address().hostnameVerifier() != RpxDSP.ADYaiT.INSTANCE || !AmA8tU(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), this.handshake.peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean AZOQYO(boolean z) {
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        if (this.http2Connection != null) {
            return !r0.isShutdown();
        }
        if (z) {
            try {
                int soTimeout = this.socket.getSoTimeout();
                try {
                    this.socket.setSoTimeout(1);
                    return !this.source.exhausted();
                } finally {
                    this.socket.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public final boolean AZkASS() {
        return this.http2Connection != null;
    }

    public final okhttp3.internal.http.A5SV6n AaHO0E(OkHttpClient okHttpClient, Interceptor.Chain chain, AYUAbz aYUAbz) {
        if (this.http2Connection != null) {
            return new okhttp3.internal.http2.ASJ6gh(okHttpClient, chain, aYUAbz, this.http2Connection);
        }
        this.socket.setSoTimeout(chain.readTimeoutMillis());
        Timeout timeout = this.source.timeout();
        long readTimeoutMillis = chain.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(readTimeoutMillis, timeUnit);
        this.sink.timeout().timeout(chain.writeTimeoutMillis(), timeUnit);
        return new okhttp3.internal.http1.A4TApA(okHttpClient, aYUAbz, this.source, this.sink);
    }

    public final A5SV6n AcNBzu(AYUAbz aYUAbz) {
        return new A5SV6n(this, true, this.source, this.sink, aYUAbz);
    }

    public final void AlLFFp(int i) {
        this.socket.setSoTimeout(0);
        AmA8tU.A2egSU a2egSU = new AmA8tU.A2egSU(true);
        a2egSU.A5SV6n(this.socket, this.route.address().url().host(), this.source, this.sink);
        a2egSU.A2egSU(this);
        a2egSU.A4TApA(i);
        AmA8tU amA8tU = new AmA8tU(a2egSU);
        this.http2Connection = amA8tU;
        amA8tU.AaHO0E();
    }

    public final boolean AmA8tU(HttpUrl httpUrl) {
        if (httpUrl.port() == this.route.address().url().port()) {
            if (httpUrl.host().equals(this.route.address().url().host())) {
                return true;
            }
            if (this.handshake != null) {
                RpxDSP.ADYaiT aDYaiT = RpxDSP.ADYaiT.INSTANCE;
                String host = httpUrl.host();
                X509Certificate x509Certificate = (X509Certificate) this.handshake.peerCertificates().get(0);
                aDYaiT.getClass();
                if (RpxDSP.ADYaiT.A5SV6n(host, x509Certificate)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // okhttp3.Connection
    public final Handshake handshake() {
        return this.handshake;
    }

    @Override // okhttp3.Connection
    public final Protocol protocol() {
        return this.protocol;
    }

    @Override // okhttp3.Connection
    public final Route route() {
        return this.route;
    }

    @Override // okhttp3.Connection
    public final Socket socket() {
        return this.socket;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.route.address().url().host());
        sb.append(":");
        sb.append(this.route.address().url().port());
        sb.append(", proxy=");
        sb.append(this.route.proxy());
        sb.append(" hostAddress=");
        sb.append(this.route.socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        sb.append(handshake != null ? handshake.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
