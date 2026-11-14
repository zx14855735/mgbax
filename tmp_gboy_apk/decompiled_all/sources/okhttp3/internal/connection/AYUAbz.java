package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.connection.ASJ6gh;
import okhttp3.internal.http2.BJ7GGh;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AYUAbz {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private okhttp3.internal.http.A5SV6n codec;
    private ADYaiT connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private ASJ6gh.A2egSU routeSelection;
    private final ASJ6gh routeSelector;

    public static final class A2egSU extends WeakReference {
        public final Object callStackTrace;

        public A2egSU(AYUAbz aYUAbz, Object obj) {
            super(aYUAbz);
            this.callStackTrace = obj;
        }
    }

    public AYUAbz(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new ASJ6gh(address, okhttp3.internal.A2egSU.instance.routeDatabase(connectionPool), call, eventListener);
        this.callStackTrace = obj;
    }

    public final void A2egSU(ADYaiT aDYaiT, boolean z) {
        if (this.connection != null) {
            throw new IllegalStateException();
        }
        this.connection = aDYaiT;
        this.reportedAcquired = z;
        aDYaiT.allocations.add(new A2egSU(this, this.callStackTrace));
    }

    public final void A4TApA() {
        okhttp3.internal.http.A5SV6n a5SV6n;
        ADYaiT aDYaiT;
        synchronized (this.connectionPool) {
            this.canceled = true;
            a5SV6n = this.codec;
            aDYaiT = this.connection;
        }
        if (a5SV6n != null) {
            a5SV6n.cancel();
        } else if (aDYaiT != null) {
            aDYaiT.A5SV6n();
        }
    }

    public final okhttp3.internal.http.A5SV6n A5SV6n() {
        okhttp3.internal.http.A5SV6n a5SV6n;
        synchronized (this.connectionPool) {
            a5SV6n = this.codec;
        }
        return a5SV6n;
    }

    public final synchronized ADYaiT ADYaiT() {
        return this.connection;
    }

    public final Socket AMqCpz(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.codec = null;
        }
        if (z2) {
            this.released = true;
        }
        ADYaiT aDYaiT = this.connection;
        if (aDYaiT != null) {
            if (z) {
                aDYaiT.noNewStreams = true;
            }
            if (this.codec == null && (this.released || aDYaiT.noNewStreams)) {
                int size = aDYaiT.allocations.size();
                for (int i = 0; i < size; i++) {
                    if (aDYaiT.allocations.get(i).get() == this) {
                        aDYaiT.allocations.remove(i);
                        if (this.connection.allocations.isEmpty()) {
                            this.connection.idleAtNanos = System.nanoTime();
                            if (okhttp3.internal.A2egSU.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                                socket = this.connection.socket();
                                this.connection = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.connection = null;
                        return socket;
                    }
                }
                throw new IllegalStateException();
            }
        }
        return null;
    }

    public final ADYaiT ARc23Z(int i, int i2, int i3, int i4, boolean z) {
        ADYaiT aDYaiT;
        Socket socket;
        Socket AMqCpz;
        ADYaiT aDYaiT2;
        Route route;
        boolean z2;
        boolean z3;
        ASJ6gh.A2egSU a2egSU;
        synchronized (this.connectionPool) {
            try {
                if (this.released) {
                    throw new IllegalStateException("released");
                }
                if (this.codec != null) {
                    throw new IllegalStateException("codec != null");
                }
                if (this.canceled) {
                    throw new IOException("Canceled");
                }
                aDYaiT = this.connection;
                socket = null;
                AMqCpz = (aDYaiT == null || !aDYaiT.noNewStreams) ? null : AMqCpz(false, false, true);
                aDYaiT2 = this.connection;
                if (aDYaiT2 != null) {
                    aDYaiT = null;
                } else {
                    aDYaiT2 = null;
                }
                if (!this.reportedAcquired) {
                    aDYaiT = null;
                }
                if (aDYaiT2 == null) {
                    okhttp3.internal.A2egSU.instance.get(this.connectionPool, this.address, this, null);
                    ADYaiT aDYaiT3 = this.connection;
                    if (aDYaiT3 != null) {
                        aDYaiT2 = aDYaiT3;
                        z2 = true;
                        route = null;
                    } else {
                        route = this.route;
                    }
                } else {
                    route = null;
                }
                z2 = false;
            } finally {
            }
        }
        okhttp3.internal.A5SV6n.ASJ6gh(AMqCpz);
        if (aDYaiT != null) {
            this.eventListener.connectionReleased(this.call, aDYaiT);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, aDYaiT2);
        }
        if (aDYaiT2 != null) {
            return aDYaiT2;
        }
        if (route != null || ((a2egSU = this.routeSelection) != null && a2egSU.A4TApA())) {
            z3 = false;
        } else {
            this.routeSelection = this.routeSelector.A5SV6n();
            z3 = true;
        }
        synchronized (this.connectionPool) {
            try {
                if (this.canceled) {
                    throw new IOException("Canceled");
                }
                if (z3) {
                    ArrayList A2egSU2 = this.routeSelection.A2egSU();
                    int size = A2egSU2.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        Route route2 = (Route) A2egSU2.get(i5);
                        okhttp3.internal.A2egSU.instance.get(this.connectionPool, this.address, this, route2);
                        ADYaiT aDYaiT4 = this.connection;
                        if (aDYaiT4 != null) {
                            this.route = route2;
                            aDYaiT2 = aDYaiT4;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (route == null) {
                        route = this.routeSelection.A5SV6n();
                    }
                    this.route = route;
                    this.refusedStreamCount = 0;
                    aDYaiT2 = new ADYaiT(this.connectionPool, route);
                    A2egSU(aDYaiT2, false);
                }
            } finally {
            }
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, aDYaiT2);
            return aDYaiT2;
        }
        aDYaiT2.ADYaiT(i, i2, i3, i4, z, this.call, this.eventListener);
        okhttp3.internal.A2egSU.instance.routeDatabase(this.connectionPool).A2egSU(aDYaiT2.route());
        synchronized (this.connectionPool) {
            try {
                this.reportedAcquired = true;
                okhttp3.internal.A2egSU.instance.put(this.connectionPool, aDYaiT2);
                if (aDYaiT2.AZkASS()) {
                    socket = okhttp3.internal.A2egSU.instance.deduplicate(this.connectionPool, this.address, this);
                    aDYaiT2 = this.connection;
                }
            } finally {
            }
        }
        okhttp3.internal.A5SV6n.ASJ6gh(socket);
        this.eventListener.connectionAcquired(this.call, aDYaiT2);
        return aDYaiT2;
    }

    public final ADYaiT ASJ6gh(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        while (true) {
            ADYaiT ARc23Z2 = ARc23Z(i, i2, i3, i4, z);
            boolean z3 = z;
            int i5 = i4;
            int i6 = i3;
            int i7 = i2;
            int i8 = i;
            synchronized (this.connectionPool) {
                try {
                    if (ARc23Z2.successCount == 0) {
                        return ARc23Z2;
                    }
                    if (ARc23Z2.AZOQYO(z2)) {
                        return ARc23Z2;
                    }
                    AZkASS();
                    i = i8;
                    i2 = i7;
                    i3 = i6;
                    i4 = i5;
                    z = z3;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final boolean AYUAbz() {
        if (this.route != null) {
            return true;
        }
        ASJ6gh.A2egSU a2egSU = this.routeSelection;
        return (a2egSU != null && a2egSU.A4TApA()) || this.routeSelector.A4TApA();
    }

    public final okhttp3.internal.http.A5SV6n AZOQYO(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            okhttp3.internal.http.A5SV6n AaHO0E2 = ASJ6gh(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).AaHO0E(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = AaHO0E2;
            }
            return AaHO0E2;
        } catch (IOException e) {
            throw new ARc23Z(e);
        }
    }

    public final void AZkASS() {
        ADYaiT aDYaiT;
        Socket AMqCpz;
        synchronized (this.connectionPool) {
            aDYaiT = this.connection;
            AMqCpz = AMqCpz(true, false, false);
            if (this.connection != null) {
                aDYaiT = null;
            }
        }
        okhttp3.internal.A5SV6n.ASJ6gh(AMqCpz);
        if (aDYaiT != null) {
            this.eventListener.connectionReleased(this.call, aDYaiT);
        }
    }

    public final void AaHO0E() {
        ADYaiT aDYaiT;
        Socket AMqCpz;
        synchronized (this.connectionPool) {
            aDYaiT = this.connection;
            AMqCpz = AMqCpz(false, true, false);
            if (this.connection != null) {
                aDYaiT = null;
            }
        }
        okhttp3.internal.A5SV6n.ASJ6gh(AMqCpz);
        if (aDYaiT != null) {
            okhttp3.internal.A2egSU.instance.timeoutExit(this.call, null);
            this.eventListener.connectionReleased(this.call, aDYaiT);
            this.eventListener.callEnd(this.call);
        }
    }

    public final Socket AcNBzu(ADYaiT aDYaiT) {
        if (this.codec != null || this.connection.allocations.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<AYUAbz> reference = this.connection.allocations.get(0);
        Socket AMqCpz = AMqCpz(true, false, false);
        this.connection = aDYaiT;
        aDYaiT.allocations.add(reference);
        return AMqCpz;
    }

    public final Route AlLFFp() {
        return this.route;
    }

    public final void AmA8tU(IOException iOException) {
        ADYaiT aDYaiT;
        boolean z;
        Socket AMqCpz;
        synchronized (this.connectionPool) {
            try {
                aDYaiT = null;
                if (iOException instanceof BJ7GGh) {
                    okhttp3.internal.http2.A4TApA a4TApA = ((BJ7GGh) iOException).errorCode;
                    if (a4TApA == okhttp3.internal.http2.A4TApA.REFUSED_STREAM) {
                        int i = this.refusedStreamCount + 1;
                        this.refusedStreamCount = i;
                        if (i > 1) {
                            this.route = null;
                            z = true;
                        }
                        z = false;
                    } else {
                        if (a4TApA != okhttp3.internal.http2.A4TApA.CANCEL) {
                            this.route = null;
                            z = true;
                        }
                        z = false;
                    }
                } else {
                    ADYaiT aDYaiT2 = this.connection;
                    if (aDYaiT2 != null && (!aDYaiT2.AZkASS() || (iOException instanceof okhttp3.internal.http2.A2egSU))) {
                        if (this.connection.successCount == 0) {
                            Route route = this.route;
                            if (route != null && iOException != null) {
                                this.routeSelector.A2egSU(route, iOException);
                            }
                            this.route = null;
                        }
                        z = true;
                    }
                    z = false;
                }
                ADYaiT aDYaiT3 = this.connection;
                AMqCpz = AMqCpz(z, false, true);
                if (this.connection == null && this.reportedAcquired) {
                    aDYaiT = aDYaiT3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        okhttp3.internal.A5SV6n.ASJ6gh(AMqCpz);
        if (aDYaiT != null) {
            this.eventListener.connectionReleased(this.call, aDYaiT);
        }
    }

    public final void AzWtSf(boolean z, okhttp3.internal.http.A5SV6n a5SV6n, long j, IOException iOException) {
        ADYaiT aDYaiT;
        Socket AMqCpz;
        boolean z2;
        this.eventListener.responseBodyEnd(this.call, j);
        synchronized (this.connectionPool) {
            if (a5SV6n != null) {
                try {
                    if (a5SV6n == this.codec) {
                        if (!z) {
                            this.connection.successCount++;
                        }
                        aDYaiT = this.connection;
                        AMqCpz = AMqCpz(z, false, true);
                        if (this.connection != null) {
                            aDYaiT = null;
                        }
                        z2 = this.released;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.codec + " but was " + a5SV6n);
        }
        okhttp3.internal.A5SV6n.ASJ6gh(AMqCpz);
        if (aDYaiT != null) {
            this.eventListener.connectionReleased(this.call, aDYaiT);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, okhttp3.internal.A2egSU.instance.timeoutExit(this.call, iOException));
        } else if (z2) {
            okhttp3.internal.A2egSU.instance.timeoutExit(this.call, null);
            this.eventListener.callEnd(this.call);
        }
    }

    public final String toString() {
        ADYaiT ADYaiT2 = ADYaiT();
        return ADYaiT2 != null ? ADYaiT2.toString() : this.address.toString();
    }
}
