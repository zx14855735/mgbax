package okhttp3.internal;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.AMqCpz;
import okhttp3.internal.connection.AYUAbz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class A2egSU {
    public static A2egSU instance;

    public static void initializeInstanceForTests() {
        new OkHttpClient();
    }

    public abstract void addLenient(Headers.Builder builder, String str);

    public abstract void addLenient(Headers.Builder builder, String str, String str2);

    public abstract void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z);

    public abstract int code(Response.Builder builder);

    public abstract boolean connectionBecameIdle(ConnectionPool connectionPool, okhttp3.internal.connection.ADYaiT aDYaiT);

    public abstract Socket deduplicate(ConnectionPool connectionPool, Address address, AYUAbz aYUAbz);

    public abstract boolean equalsNonHost(Address address, Address address2);

    public abstract okhttp3.internal.connection.ADYaiT get(ConnectionPool connectionPool, Address address, AYUAbz aYUAbz, Route route);

    public abstract Call newWebSocketCall(OkHttpClient okHttpClient, Request request);

    public abstract void put(ConnectionPool connectionPool, okhttp3.internal.connection.ADYaiT aDYaiT);

    public abstract AMqCpz routeDatabase(ConnectionPool connectionPool);

    public abstract AYUAbz streamAllocation(Call call);

    public abstract IOException timeoutExit(Call call, IOException iOException);
}
