package okhttp3.internal.cache;

import com.sigmob.sdk.archives.tar.e;
import com.sigmob.sdk.downloader.core.c;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.cache.ADYaiT;
import okio.Okio;
import okio.Sink;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA implements Interceptor {
    final AZkASS cache;

    public A4TApA(AZkASS aZkASS) {
        this.cache = aZkASS;
    }

    public static boolean A2egSU(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || c.h.equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static Response A4TApA(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        Sink body;
        AZkASS aZkASS = this.cache;
        Response response = aZkASS != null ? aZkASS.get(chain.request()) : null;
        ADYaiT A2egSU2 = new ADYaiT.A2egSU(System.currentTimeMillis(), chain.request(), response).A2egSU();
        Request request = A2egSU2.networkRequest;
        Response response2 = A2egSU2.cacheResponse;
        AZkASS aZkASS2 = this.cache;
        if (aZkASS2 != null) {
            aZkASS2.trackResponse(A2egSU2);
        }
        if (response != null && response2 == null) {
            okhttp3.internal.A5SV6n.ARc23Z(response.body());
        }
        if (request == null && response2 == null) {
            return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(e.E).message("Unsatisfiable Request (only-if-cached)").body(okhttp3.internal.A5SV6n.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (request == null) {
            return response2.newBuilder().cacheResponse(A4TApA(response2)).build();
        }
        try {
            Response proceed = chain.proceed(request);
            if (proceed == null && response != null) {
            }
            if (response2 != null) {
                if (proceed.code() == 304) {
                    Response.Builder newBuilder = response2.newBuilder();
                    Headers headers = response2.headers();
                    Headers headers2 = proceed.headers();
                    Headers.Builder builder = new Headers.Builder();
                    int size = headers.size();
                    for (int i = 0; i < size; i++) {
                        String name = headers.name(i);
                        String value = headers.value(i);
                        if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (c.e.equalsIgnoreCase(name) || "Content-Encoding".equalsIgnoreCase(name) || "Content-Type".equalsIgnoreCase(name) || !A2egSU(name) || headers2.get(name) == null)) {
                            okhttp3.internal.A2egSU.instance.addLenient(builder, name, value);
                        }
                    }
                    int size2 = headers2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        String name2 = headers2.name(i2);
                        if (!c.e.equalsIgnoreCase(name2) && !"Content-Encoding".equalsIgnoreCase(name2) && !"Content-Type".equalsIgnoreCase(name2) && A2egSU(name2)) {
                            okhttp3.internal.A2egSU.instance.addLenient(builder, name2, headers2.value(i2));
                        }
                    }
                    Response build = newBuilder.headers(builder.build()).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(A4TApA(response2)).networkResponse(A4TApA(proceed)).build();
                    proceed.body().close();
                    this.cache.trackConditionalCacheHit();
                    this.cache.update(response2, build);
                    return build;
                }
                okhttp3.internal.A5SV6n.ARc23Z(response2.body());
            }
            Response build2 = proceed.newBuilder().cacheResponse(A4TApA(response2)).networkResponse(A4TApA(proceed)).build();
            if (this.cache != null) {
                if (okhttp3.internal.http.AMqCpz.A4TApA(build2) && ADYaiT.A2egSU(request, build2)) {
                    A5SV6n put = this.cache.put(build2);
                    if (put == null || (body = put.body()) == null) {
                        return build2;
                    }
                    return build2.newBuilder().body(new okhttp3.internal.http.AYUAbz(build2.header("Content-Type"), build2.body().contentLength(), Okio.buffer(new A2egSU(this, build2.body().source(), put, Okio.buffer(body))))).build();
                }
                if (okhttp3.internal.http.ARc23Z.A2egSU(request.method())) {
                    try {
                        this.cache.remove(request);
                    } catch (IOException unused) {
                    }
                }
            }
            return build2;
        } finally {
            if (response != null) {
                okhttp3.internal.A5SV6n.ARc23Z(response.body());
            }
        }
    }
}
