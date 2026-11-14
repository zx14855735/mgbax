package com.czhj.volley;

import android.os.Process;
import com.czhj.volley.Cache;
import com.czhj.volley.Request;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CacheDispatcher extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f10618a = VolleyLog.DEBUG;
    private final BlockingQueue<Request<?>> b;
    private final BlockingQueue<Request<?>> c;
    private final Cache d;
    private final ResponseDelivery e;
    private volatile boolean g = false;
    private final WaitingRequestManager f = new WaitingRequestManager(this);

    public static class WaitingRequestManager implements Request.NetworkRequestCompleteListener {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, List<Request<?>>> f10620a = new HashMap();
        private final CacheDispatcher b;

        public WaitingRequestManager(CacheDispatcher cacheDispatcher) {
            this.b = cacheDispatcher;
        }

        @Override // com.czhj.volley.Request.NetworkRequestCompleteListener
        public synchronized void onNoUsableResponseReceived(Request<?> request) {
            try {
                String cacheKey = request.getCacheKey();
                List<Request<?>> remove = this.f10620a.remove(cacheKey);
                if (remove != null && !remove.isEmpty()) {
                    if (VolleyLog.DEBUG) {
                        VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                    }
                    Request<?> remove2 = remove.remove(0);
                    this.f10620a.put(cacheKey, remove);
                    remove2.setNetworkRequestCompleteListener(this);
                    try {
                        this.b.c.put(remove2);
                    } catch (InterruptedException e) {
                        VolleyLog.e("Couldn't add request to queue. %s", e.toString());
                        Thread.currentThread().interrupt();
                        this.b.quit();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // com.czhj.volley.Request.NetworkRequestCompleteListener
        public void onResponseReceived(Request<?> request, Response<?> response) {
            List<Request<?>> remove;
            Cache.Entry entry = response.cacheEntry;
            if (entry == null || entry.isExpired()) {
                onNoUsableResponseReceived(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                remove = this.f10620a.remove(cacheKey);
            }
            if (remove != null) {
                if (VolleyLog.DEBUG) {
                    VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                }
                Iterator<Request<?>> it = remove.iterator();
                while (it.hasNext()) {
                    this.b.e.postResponse(it.next(), response);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(Request<?> request) {
            try {
                String cacheKey = request.getCacheKey();
                if (!this.f10620a.containsKey(cacheKey)) {
                    this.f10620a.put(cacheKey, null);
                    request.setNetworkRequestCompleteListener(this);
                    if (VolleyLog.DEBUG) {
                        VolleyLog.d("new request, sending to network %s", cacheKey);
                    }
                    return false;
                }
                List<Request<?>> list = this.f10620a.get(cacheKey);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.addMarker("waiting-for-response");
                list.add(request);
                this.f10620a.put(cacheKey, list);
                if (VolleyLog.DEBUG) {
                    VolleyLog.d("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static {
        OyeyN();
    }

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = cache;
        this.e = responseDelivery;
    }

    private static /* synthetic */ void OyeyN() {
        char[] charArray = "¢®¬ï¦ ¬¤ï£®¸ï²©¤\u00ad\u00adï\u008b¯¨\u0083³¨¥¦¤".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 193);
        }
        String str = new String(charArray);
        char[] charArray2 = "¢\u00ad¨¯¨µ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 193);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void processRequest(final Request<?> request) {
        request.addMarker("cache-queue-take");
        if (request.isCanceled()) {
            request.finish("cache-discard-canceled");
            return;
        }
        Cache.Entry entry = this.d.get(request.getCacheKey());
        if (entry == null) {
            request.addMarker("cache-miss");
            if (this.f.a(request)) {
                return;
            }
            this.c.put(request);
            return;
        }
        if (entry.isExpired()) {
            request.addMarker("cache-hit-expired");
            request.setCacheEntry(entry);
            if (this.f.a(request)) {
                return;
            }
            this.c.put(request);
            return;
        }
        request.addMarker("cache-hit");
        Response<?> parseNetworkResponse = request.parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
        request.addMarker("cache-hit-parsed");
        if (!entry.refreshNeeded()) {
            this.e.postResponse(request, parseNetworkResponse);
            return;
        }
        request.addMarker("cache-hit-refresh-needed");
        request.setCacheEntry(entry);
        parseNetworkResponse.intermediate = true;
        if (this.f.a(request)) {
            this.e.postResponse(request, parseNetworkResponse);
        } else {
            this.e.postResponse(request, parseNetworkResponse, new Runnable() { // from class: com.czhj.volley.CacheDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        CacheDispatcher.this.c.put(request);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
    }

    public void quit() {
        this.g = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f10618a) {
            VolleyLog.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.initialize();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.g) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void a() {
        processRequest(this.b.take());
    }
}
