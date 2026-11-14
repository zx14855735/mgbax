package com.czhj.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ExecutorDelivery implements ResponseDelivery {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f10623a;

    public ExecutorDelivery(final Handler handler) {
        this.f10623a = new Executor() { // from class: com.czhj.volley.ExecutorDelivery.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postError(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.f10623a.execute(new ResponseDeliveryRunnable(request, Response.error(volleyError), null));
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response) {
        postResponse(request, response, null);
    }

    public ExecutorDelivery(Executor executor) {
        this.f10623a = executor;
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f10623a.execute(new ResponseDeliveryRunnable(request, response, runnable));
    }
}
