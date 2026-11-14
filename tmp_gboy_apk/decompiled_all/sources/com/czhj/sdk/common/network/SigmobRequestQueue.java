package com.czhj.sdk.common.network;

import android.os.Handler;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.volley.ExecutorsDelivery;
import com.czhj.volley.Network;
import com.czhj.volley.Request;
import com.czhj.volley.RequestQueue;
import com.czhj.volley.ResponseDelivery;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SigmobRequestQueue extends RequestQueue {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10579a = 10;
    private final Map<Request<?>, DelayedRequestHelper> b;

    public class DelayedRequestHelper {

        /* renamed from: a, reason: collision with root package name */
        final int f10583a;
        final Handler b;
        final Runnable c;

        public DelayedRequestHelper(SigmobRequestQueue sigmobRequestQueue, Request<?> request, int i) {
            this(request, i, new Handler());
        }

        public void a() {
            this.b.postDelayed(this.c, this.f10583a);
        }

        public void b() {
            this.b.removeCallbacks(this.c);
        }

        public DelayedRequestHelper(final Request<?> request, int i, Handler handler) {
            this.f10583a = i;
            this.b = handler;
            this.c = new Runnable() { // from class: com.czhj.sdk.common.network.SigmobRequestQueue.DelayedRequestHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    SigmobRequestQueue.this.b.remove(request);
                    SigmobRequestQueue.this.add(request);
                }
            };
        }
    }

    public SigmobRequestQueue(Network network) {
        super(network);
        this.b = new HashMap(10);
    }

    private void b(final Request<?> request) {
        cancelAll(new RequestQueue.RequestFilter() { // from class: com.czhj.sdk.common.network.SigmobRequestQueue.3
            @Override // com.czhj.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request2) {
                return request == request2;
            }
        });
    }

    @Deprecated
    public Map<Request<?>, DelayedRequestHelper> a() {
        return this.b;
    }

    public void addDelayedRequest(Request<?> request, int i) {
        a(request, new DelayedRequestHelper(this, request, i));
    }

    public void cancelAll() {
        cancelAll(new RequestQueue.RequestFilter() { // from class: com.czhj.sdk.common.network.SigmobRequestQueue.1
            @Override // com.czhj.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request) {
                return true;
            }
        });
    }

    public SigmobRequestQueue(Network network, int i, int i2) {
        this(network, i, i2, new ExecutorsDelivery(ThreadPoolFactory.getFixIOExecutor()));
    }

    @Override // com.czhj.volley.RequestQueue
    public void cancelAll(RequestQueue.RequestFilter requestFilter) {
        super.cancelAll(requestFilter);
        Iterator<Map.Entry<Request<?>, DelayedRequestHelper>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Request<?>, DelayedRequestHelper> next = it.next();
            if (requestFilter.apply(next.getKey())) {
                next.getKey().cancel();
                next.getValue().b();
                it.remove();
            }
        }
    }

    public SigmobRequestQueue(Network network, int i, int i2, ResponseDelivery responseDelivery) {
        super(network, i, i2, responseDelivery);
        this.b = new HashMap(10);
    }

    private void a(Request<?> request, DelayedRequestHelper delayedRequestHelper) {
        if (this.b.containsKey(request)) {
            b(request);
        }
        delayedRequestHelper.a();
        this.b.put(request, delayedRequestHelper);
    }

    @Override // com.czhj.volley.RequestQueue
    public void cancelAll(final Object obj) {
        super.cancelAll(obj);
        cancelAll(new RequestQueue.RequestFilter() { // from class: com.czhj.sdk.common.network.SigmobRequestQueue.2
            @Override // com.czhj.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request) {
                return request.getTag() == obj;
            }
        });
    }
}
