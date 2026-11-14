package okhttp3.internal.http;

import com.sigmob.sdk.base.e;
import com.sigmob.sdk.downloader.core.c;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.GzipSource;
import okio.Okio;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU implements Interceptor {
    private final CookieJar cookieJar;

    public A2egSU(CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        boolean z;
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header(c.e, Long.toString(contentLength));
                newBuilder.removeHeader(c.h);
            } else {
                newBuilder.header(c.h, "chunked");
                newBuilder.removeHeader(c.e);
            }
        }
        if (request.header("Host") == null) {
            newBuilder.header("Host", okhttp3.internal.A5SV6n.AlLFFp(request.url(), false));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null && request.header(c.b) == null) {
            newBuilder.header("Accept-Encoding", "gzip");
            z = true;
        } else {
            z = false;
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = loadForRequest.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append("; ");
                }
                Cookie cookie = loadForRequest.get(i);
                sb.append(cookie.name());
                sb.append('=');
                sb.append(cookie.value());
            }
            newBuilder.header(e.f13172a, sb.toString());
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", "okhttp/3.12.0");
        }
        Response proceed = chain.proceed(newBuilder.build());
        CookieJar cookieJar = this.cookieJar;
        HttpUrl url = request.url();
        Headers headers = proceed.headers();
        int i2 = AMqCpz.f14071A2egSU;
        if (cookieJar != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.parseAll(url, headers);
            if (!parseAll.isEmpty()) {
                cookieJar.saveFromResponse(url, parseAll);
            }
        }
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z && "gzip".equalsIgnoreCase(proceed.header("Content-Encoding")) && AMqCpz.A4TApA(proceed)) {
            GzipSource gzipSource = new GzipSource(proceed.body().source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll(c.e).build());
            request2.body(new AYUAbz(proceed.header("Content-Type"), -1L, Okio.buffer(gzipSource)));
        }
        return request2.build();
    }
}
