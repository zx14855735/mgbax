package com.czhj.volley;

import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ExecutorsDelivery implements ResponseDelivery {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f10625a;

    public ExecutorsDelivery(ExecutorService executorService) {
        this.f10625a = executorService;
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postError(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.f10625a.execute(new ResponseDeliveryRunnable(request, Response.error(volleyError), null));
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response) {
        postResponse(request, response, null);
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f10625a.execute(new ResponseDeliveryRunnable(request, response, runnable));
    }
}
