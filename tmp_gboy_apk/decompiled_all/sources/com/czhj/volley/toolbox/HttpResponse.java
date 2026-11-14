package com.czhj.volley.toolbox;

import com.czhj.volley.Header;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class HttpResponse {

    /* renamed from: a, reason: collision with root package name */
    private final int f10645a;
    private final List<Header> b;
    private final int c;
    private final InputStream d;

    public HttpResponse(int i, List<Header> list) {
        this(i, list, -1, null);
    }

    public final InputStream getContent() {
        return this.d;
    }

    public final int getContentLength() {
        return this.c;
    }

    public final List<Header> getHeaders() {
        return Collections.unmodifiableList(this.b);
    }

    public final int getStatusCode() {
        return this.f10645a;
    }

    public HttpResponse(int i, List<Header> list, int i2, InputStream inputStream) {
        this.f10645a = i;
        this.b = list;
        this.c = i2;
        this.d = inputStream;
    }
}
