package com.czhj.volley.toolbox;

import android.text.TextUtils;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.czhj.volley.Header;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class OkHttp3Stack extends BaseHttpStack {
    public static final String NETWORK_TIMEOUT = "NETWORK_TIMEOUT";

    /* renamed from: a, reason: collision with root package name */
    Interceptor f10659a = new Interceptor() { // from class: com.czhj.volley.toolbox.OkHttp3Stack.1
        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) {
            try {
                Request request = chain.request();
                int connectTimeoutMillis = chain.connectTimeoutMillis();
                int readTimeoutMillis = chain.readTimeoutMillis();
                int writeTimeoutMillis = chain.writeTimeoutMillis();
                String header = request.header(OkHttp3Stack.NETWORK_TIMEOUT);
                if (!TextUtils.isEmpty(header)) {
                    connectTimeoutMillis = Integer.valueOf(header).intValue();
                }
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                return chain.withConnectTimeout(connectTimeoutMillis, timeUnit).withReadTimeout(readTimeoutMillis, timeUnit).withWriteTimeout(writeTimeoutMillis, timeUnit).proceed(request);
            } catch (Throwable unused) {
                return chain.proceed(chain.request());
            }
        }
    };
    private final SSLSocketFactory b;
    private final OkHttpClient.Builder c;
    private final OkHttpClient d;

    public OkHttp3Stack() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.c = builder;
        builder.connectionPool(new ConnectionPool());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(PushUIConfig.dismissTime, timeUnit);
        builder.readTimeout(PushUIConfig.dismissTime, timeUnit);
        builder.writeTimeout(PushUIConfig.dismissTime, timeUnit);
        builder.addInterceptor(this.f10659a);
        this.b = null;
        this.d = builder.build();
    }

    private List<Header> a(Headers headers) {
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if (name != null) {
                arrayList.add(new Header(name, value));
            }
        }
        return arrayList;
    }

    @Override // com.czhj.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(com.czhj.volley.Request<?> request, Map<String, String> map) {
        Request.Builder builder = new Request.Builder();
        builder.url(request.getUrl());
        Map<String, String> headers = request.getHeaders();
        builder.addHeader(NETWORK_TIMEOUT, request.getRetryPolicy().getCurrentTimeout() + "");
        for (String str : headers.keySet()) {
            String str2 = headers.get(str);
            if (TextUtils.isEmpty(str2)) {
                builder.removeHeader(str);
            } else {
                builder.addHeader(str, str2);
            }
        }
        for (String str3 : map.keySet()) {
            String str4 = map.get(str3);
            if (TextUtils.isEmpty(str4)) {
                builder.removeHeader(str3);
            } else {
                builder.addHeader(str3, str4);
            }
        }
        a(builder, request);
        Response execute = this.d.newCall(builder.build()).execute();
        int code = execute.code();
        ResponseBody body = execute.body();
        return new HttpResponse(code, a(execute.headers()), body == null ? 0 : (int) body.contentLength(), body == null ? null : body.byteStream());
    }

    public OkHttp3Stack(SSLSocketFactory sSLSocketFactory) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.c = builder;
        builder.connectionPool(new ConnectionPool());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(PushUIConfig.dismissTime, timeUnit);
        builder.readTimeout(PushUIConfig.dismissTime, timeUnit);
        builder.writeTimeout(PushUIConfig.dismissTime, timeUnit);
        builder.addInterceptor(this.f10659a);
        this.b = sSLSocketFactory;
        this.d = builder.build();
    }

    private static RequestBody a(com.czhj.volley.Request request) {
        byte[] body = request.getBody();
        if (body == null) {
            return null;
        }
        return RequestBody.create(MediaType.parse(request.getBodyContentType()), body);
    }

    private static void a(Request.Builder builder, com.czhj.volley.Request<?> request) {
        switch (request.getMethod()) {
            case -1:
                byte[] body = request.getBody();
                if (body != null) {
                    builder.post(RequestBody.create(MediaType.parse(request.getBodyContentType()), body));
                    return;
                }
                return;
            case 0:
                builder.get();
                return;
            case 1:
                builder.post(a(request));
                return;
            case 2:
                builder.put(a(request));
                return;
            case 3:
                builder.delete(a(request));
                return;
            case 4:
                builder.head();
                return;
            case 5:
                builder.method("OPTIONS", null);
                return;
            case 6:
                builder.method("TRACE", null);
                return;
            case 7:
                builder.patch(a(request));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }
}
