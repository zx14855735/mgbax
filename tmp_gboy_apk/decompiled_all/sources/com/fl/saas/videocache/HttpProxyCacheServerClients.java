package com.fl.saas.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.fl.saas.videocache.file.FileCache;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class HttpProxyCacheServerClients {
    private final AtomicInteger clientsCount = new AtomicInteger(0);
    private final Config config;
    private final List<CacheListener> listeners;
    private volatile HttpProxyCache proxyCache;
    private final CacheListener uiCacheListener;
    private final String url;

    public static final class UiListenerHandler extends Handler implements CacheListener {
        private final List<CacheListener> listeners;
        private final String url;

        public UiListenerHandler(String str, List<CacheListener> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.listeners = list;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<CacheListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onCacheAvailable((File) message.obj, this.url, message.arg1);
            }
        }

        @Override // com.fl.saas.videocache.CacheListener
        public void onCacheAvailable(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }
    }

    public HttpProxyCacheServerClients(String str, Config config) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.listeners = copyOnWriteArrayList;
        this.url = (String) Preconditions.checkNotNull(str);
        this.config = (Config) Preconditions.checkNotNull(config);
        this.uiCacheListener = new UiListenerHandler(str, copyOnWriteArrayList);
    }

    private synchronized void finishProcessRequest() {
        if (this.clientsCount.decrementAndGet() <= 0) {
            this.proxyCache.shutdown();
            this.proxyCache = null;
        }
    }

    private HttpProxyCache newHttpProxyCache() {
        String str = this.url;
        Config config = this.config;
        HttpProxyCache httpProxyCache = new HttpProxyCache(new HttpUrlSource(str, config.sourceInfoStorage, config.headerInjector), new FileCache(this.config.generateCacheFile(this.url), this.config.diskUsage));
        httpProxyCache.registerCacheListener(this.uiCacheListener);
        return httpProxyCache;
    }

    private synchronized void startProcessRequest() {
        try {
            this.proxyCache = this.proxyCache == null ? newHttpProxyCache() : this.proxyCache;
        } catch (Throwable th) {
            throw th;
        }
    }

    public int getClientsCount() {
        return this.clientsCount.get();
    }

    public void processRequest(GetRequest getRequest, Socket socket) {
        startProcessRequest();
        try {
            this.clientsCount.incrementAndGet();
            this.proxyCache.processRequest(getRequest, socket);
        } finally {
            finishProcessRequest();
        }
    }

    public void registerCacheListener(CacheListener cacheListener) {
        this.listeners.add(cacheListener);
    }

    public void shutdown() {
        this.listeners.clear();
        if (this.proxyCache != null) {
            this.proxyCache.registerCacheListener(null);
            this.proxyCache.shutdown();
            this.proxyCache = null;
        }
        this.clientsCount.set(0);
    }

    public void unregisterCacheListener(CacheListener cacheListener) {
        this.listeners.remove(cacheListener);
    }
}
