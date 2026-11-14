package com.czhj.volley;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ClientError extends ServerError {

    /* renamed from: a, reason: collision with root package name */
    private String f10621a;

    public ClientError() {
    }

    public String getRequest_id() {
        return this.f10621a;
    }

    public ClientError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ClientError(String str, String str2) {
        super(str);
        this.f10621a = str2;
    }
}
