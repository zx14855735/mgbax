package com.czhj.volley;

import android.net.TrafficStats;
import android.os.SystemClock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NetworkDispatcher implements Comparable, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Network f10627a;
    private final ResponseDelivery b;
    private final Request c;
    private volatile boolean d = false;

    public NetworkDispatcher(Network network, Request request, ResponseDelivery responseDelivery) {
        this.c = request;
        this.f10627a = network;
        this.b = responseDelivery;
    }

    private void a(Request<?> request) {
        TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return (obj == null && hashCode() == obj.hashCode()) ? 0 : 1;
    }

    public void processRequest(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            request.addMarker("network-queue-take");
            if (request.isCanceled()) {
                request.finish("network-discard-cancelled");
            } else {
                a(request);
                NetworkResponse performRequest = this.f10627a.performRequest(request);
                request.addMarker("network-http-complete");
                if (!performRequest.notModified || !request.hasHadResponseDelivered()) {
                    Response<?> parseNetworkResponse = request.parseNetworkResponse(performRequest);
                    request.addMarker("network-parse-complete");
                    request.markDelivered();
                    this.b.postResponse(request, parseNetworkResponse);
                    request.notifyListenerResponseReceived(parseNetworkResponse);
                    return;
                }
                request.finish("not-modified");
            }
            request.notifyListenerResponseNotUsable();
        } catch (VolleyError e) {
            e.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            a(request, e);
            request.notifyListenerResponseNotUsable();
        } catch (Throwable th) {
            VolleyLog.e(th, "Unhandled exception %s", th.toString());
            VolleyError volleyError = new VolleyError(th);
            volleyError.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.b.postError(request, volleyError);
            request.notifyListenerResponseNotUsable();
        }
    }

    public void quit() {
        this.d = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        processRequest(this.c);
    }

    private void a(Request<?> request, VolleyError volleyError) {
        this.b.postError(request, request.parseNetworkError(volleyError));
    }
}
