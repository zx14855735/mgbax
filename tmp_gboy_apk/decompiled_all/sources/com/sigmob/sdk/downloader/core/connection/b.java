package com.sigmob.sdk.downloader.core.connection;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.j;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements com.sigmob.sdk.downloader.core.connection.a, a.InterfaceC0451a {
    final OkHttpClient b;
    Response c;
    private final Request.Builder d;
    private Request e;

    public static class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        private OkHttpClient.Builder f13365a;
        private volatile OkHttpClient b;

        @Override // com.sigmob.sdk.downloader.core.connection.a.b
        public com.sigmob.sdk.downloader.core.connection.a a(String str) {
            if (this.b == null) {
                synchronized (a.class) {
                    try {
                        if (this.b == null) {
                            OkHttpClient.Builder builder = this.f13365a;
                            this.b = builder != null ? builder.build() : new OkHttpClient();
                            this.f13365a = null;
                        }
                    } finally {
                    }
                }
            }
            return new b(this.b, str);
        }

        public a a(OkHttpClient.Builder builder) {
            this.f13365a = builder;
            return this;
        }

        public OkHttpClient.Builder a() {
            if (this.f13365a == null) {
                this.f13365a = new OkHttpClient.Builder();
            }
            return this.f13365a;
        }
    }

    public b(OkHttpClient okHttpClient, String str) {
        this(okHttpClient, new Request.Builder().url(str));
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public a.InterfaceC0451a a() {
        Request build = this.d.build();
        this.e = build;
        this.c = this.b.newCall(build).execute();
        return this;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public String b(String str) {
        Request request = this.e;
        return request != null ? request.header(str) : this.d.build().header(str);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0451a
    public String c(String str) {
        Response response = this.c;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0451a
    public int d() {
        Response response = this.c;
        if (response != null) {
            return response.code();
        }
        throw new IOException("Please invoke execute first!");
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0451a
    public InputStream e() {
        Response response = this.c;
        if (response == null) {
            throw new IOException("Please invoke execute first!");
        }
        ResponseBody body = response.body();
        if (body != null) {
            return body.byteStream();
        }
        throw new IOException("no body found on response!");
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0451a
    public Map<String, List<String>> f() {
        Response response = this.c;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0451a
    public String g() {
        Response priorResponse = this.c.priorResponse();
        if (priorResponse != null && this.c.isSuccessful() && j.a(priorResponse.code())) {
            return this.c.request().url().toString();
        }
        return null;
    }

    public b(OkHttpClient okHttpClient, Request.Builder builder) {
        this.b = okHttpClient;
        this.d = builder;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void a(String str, String str2) {
        this.d.addHeader(str, str2);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void b() {
        this.e = null;
        Response response = this.c;
        if (response != null) {
            response.close();
        }
        this.c = null;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public Map<String, List<String>> c() {
        Request request = this.e;
        if (request == null) {
            request = this.d.build();
        }
        return request.headers().toMultimap();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public boolean a(String str) {
        this.d.method(str, null);
        return true;
    }
}
