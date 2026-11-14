package com.czhj.volley;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class ResponseDeliveryRunnable implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Request f10632a;
    private final Response b;
    private final Runnable c;

    public ResponseDeliveryRunnable(Request request, Response response, Runnable runnable) {
        this.f10632a = request;
        this.b = response;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f10632a.isCanceled()) {
            this.f10632a.finish("canceled-at-delivery");
            return;
        }
        if (this.b.isSuccess()) {
            this.f10632a.deliverResponse(this.b.result);
        } else {
            this.f10632a.deliverError(this.b.error);
        }
        if (this.b.intermediate) {
            this.f10632a.addMarker("intermediate-response");
        } else {
            this.f10632a.finish("done");
        }
        Runnable runnable = this.c;
        if (runnable != null) {
            runnable.run();
        }
    }
}
