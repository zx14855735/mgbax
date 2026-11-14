package okhttp3.internal.http;

import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ASJ6gh implements Interceptor.Chain {
    private final Call call;
    private int calls;
    private final int connectTimeout;
    private final okhttp3.internal.connection.ADYaiT connection;
    private final EventListener eventListener;
    private final A5SV6n httpCodec;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeout;
    private final Request request;
    private final okhttp3.internal.connection.AYUAbz streamAllocation;
    private final int writeTimeout;

    public ASJ6gh(List<Interceptor> list, okhttp3.internal.connection.AYUAbz aYUAbz, A5SV6n a5SV6n, okhttp3.internal.connection.ADYaiT aDYaiT, int i, Request request, Call call, EventListener eventListener, int i2, int i3, int i4) {
        this.interceptors = list;
        this.connection = aDYaiT;
        this.streamAllocation = aYUAbz;
        this.httpCodec = a5SV6n;
        this.index = i;
        this.request = request;
        this.call = call;
        this.eventListener = eventListener;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    public final EventListener A2egSU() {
        return this.eventListener;
    }

    public final A5SV6n A4TApA() {
        return this.httpCodec;
    }

    public final Response A5SV6n(Request request, okhttp3.internal.connection.AYUAbz aYUAbz, A5SV6n a5SV6n, okhttp3.internal.connection.ADYaiT aDYaiT) {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        this.calls++;
        if (this.httpCodec != null && !this.connection.AmA8tU(request.url())) {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
        }
        if (this.httpCodec != null && this.calls > 1) {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
        }
        ASJ6gh aSJ6gh = new ASJ6gh(this.interceptors, aYUAbz, a5SV6n, aDYaiT, this.index + 1, request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
        Interceptor interceptor = this.interceptors.get(this.index);
        Response intercept = interceptor.intercept(aSJ6gh);
        if (a5SV6n != null && this.index + 1 < this.interceptors.size() && aSJ6gh.calls != 1) {
            throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
        }
        if (intercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (intercept.body() != null) {
            return intercept;
        }
        throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
    }

    public final okhttp3.internal.connection.AYUAbz ADYaiT() {
        return this.streamAllocation;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public final int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Connection connection() {
        return this.connection;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Response proceed(Request request) {
        return A5SV6n(request, this.streamAllocation, this.httpCodec, this.connection);
    }

    @Override // okhttp3.Interceptor.Chain
    public final int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new ASJ6gh(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, okhttp3.internal.A5SV6n.AMqCpz("timeout", i, timeUnit), this.readTimeout, this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public final Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new ASJ6gh(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, okhttp3.internal.A5SV6n.AMqCpz("timeout", i, timeUnit), this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public final Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new ASJ6gh(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, okhttp3.internal.A5SV6n.AMqCpz("timeout", i, timeUnit));
    }

    @Override // okhttp3.Interceptor.Chain
    public final int writeTimeoutMillis() {
        return this.writeTimeout;
    }
}
