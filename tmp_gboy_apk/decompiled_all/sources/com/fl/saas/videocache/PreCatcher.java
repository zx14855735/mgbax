package com.fl.saas.videocache;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PreCatcher {
    private Map<String, PreCacheCallable> mCacheCallableMap;
    private ExecutorService preCacheExecutor;

    public static class InstanceHolder {
        private static PreCatcher mInstance = new PreCatcher();

        static {
            DaqSa();
        }

        private static /* synthetic */ void DaqSa() {
            char[] charArray = "ÉÅÇ\u0084ÍËÇÏ\u0084ÈÅÓ\u0084ÙÂÏÆÆ\u0084àÄÃèØÃÎÍÏ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 170);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÉÆÃÄÃÞ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 170);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public class PreCacheCallable implements Callable<Boolean> {
        int mCacheSize;
        HttpUrlSource mSource;
        String mUrl;
        boolean mStoped = false;
        private final Object mStopLock = new Object();

        public PreCacheCallable(String str, int i) {
            this.mCacheSize = Integer.MAX_VALUE;
            this.mUrl = str;
            if (i > 0) {
                this.mCacheSize = i;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(6:41|42|(2:43|44)|45|46|47) */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private boolean connectToPoxyServer(java.lang.String r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.mStopLock
                monitor-enter(r0)
                boolean r1 = r6.isStoped()     // Catch: java.lang.Throwable -> Lc
                r2 = 0
                if (r1 == 0) goto Lf
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc
                return r2
            Lc:
                r7 = move-exception
                goto L82
            Lf:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc
                com.fl.saas.videocache.HttpUrlSource r0 = new com.fl.saas.videocache.HttpUrlSource
                r0.<init>(r7)
                r6.mSource = r0
                r3 = 0
                r0.open(r3)     // Catch: java.lang.Throwable -> L3e com.fl.saas.videocache.ProxyCacheException -> L40
                r0 = 8192(0x2000, float:1.14794E-41)
                byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L3e com.fl.saas.videocache.ProxyCacheException -> L40
                r1 = 0
            L21:
                com.fl.saas.videocache.HttpUrlSource r3 = r6.mSource     // Catch: java.lang.Throwable -> L3e com.fl.saas.videocache.ProxyCacheException -> L40
                int r3 = r3.read(r0)     // Catch: java.lang.Throwable -> L3e com.fl.saas.videocache.ProxyCacheException -> L40
                r4 = -1
                if (r3 == r4) goto L44
                java.lang.Object r4 = r6.mStopLock     // Catch: java.lang.Throwable -> L3e com.fl.saas.videocache.ProxyCacheException -> L40
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L3e com.fl.saas.videocache.ProxyCacheException -> L40
                boolean r5 = r6.isStoped()     // Catch: java.lang.Throwable -> L35
                if (r5 == 0) goto L37
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L35
                goto L44
            L35:
                r0 = move-exception
                goto L42
            L37:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L35
                int r1 = r1 + r3
                int r3 = r6.mCacheSize     // Catch: java.lang.Throwable -> L3e com.fl.saas.videocache.ProxyCacheException -> L40
                if (r1 < r3) goto L21
                goto L44
            L3e:
                r0 = move-exception
                goto L72
            L40:
                r0 = move-exception
                goto L55
            L42:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L35
                throw r0     // Catch: java.lang.Throwable -> L3e com.fl.saas.videocache.ProxyCacheException -> L40
            L44:
                com.fl.saas.videocache.HttpUrlSource r0 = r6.mSource     // Catch: com.fl.saas.videocache.ProxyCacheException -> L4f
                r0.close()     // Catch: com.fl.saas.videocache.ProxyCacheException -> L4f
                com.fl.saas.videocache.PreCatcher r0 = com.fl.saas.videocache.PreCatcher.this     // Catch: com.fl.saas.videocache.ProxyCacheException -> L4f
                com.fl.saas.videocache.PreCatcher.access$100(r0, r7)     // Catch: com.fl.saas.videocache.ProxyCacheException -> L4f
                goto L53
            L4f:
                r7 = move-exception
                r7.printStackTrace()
            L53:
                r7 = 1
                return r7
            L55:
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L3e
                com.fl.saas.videocache.HttpUrlSource r0 = r6.mSource     // Catch: java.lang.Throwable -> L3e com.fl.saas.videocache.ProxyCacheException -> L5e
                r0.close()     // Catch: java.lang.Throwable -> L3e com.fl.saas.videocache.ProxyCacheException -> L5e
                goto L62
            L5e:
                r0 = move-exception
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L3e
            L62:
                com.fl.saas.videocache.HttpUrlSource r0 = r6.mSource     // Catch: com.fl.saas.videocache.ProxyCacheException -> L6d
                r0.close()     // Catch: com.fl.saas.videocache.ProxyCacheException -> L6d
                com.fl.saas.videocache.PreCatcher r0 = com.fl.saas.videocache.PreCatcher.this     // Catch: com.fl.saas.videocache.ProxyCacheException -> L6d
                com.fl.saas.videocache.PreCatcher.access$100(r0, r7)     // Catch: com.fl.saas.videocache.ProxyCacheException -> L6d
                goto L71
            L6d:
                r7 = move-exception
                r7.printStackTrace()
            L71:
                return r2
            L72:
                com.fl.saas.videocache.HttpUrlSource r1 = r6.mSource     // Catch: com.fl.saas.videocache.ProxyCacheException -> L7d
                r1.close()     // Catch: com.fl.saas.videocache.ProxyCacheException -> L7d
                com.fl.saas.videocache.PreCatcher r1 = com.fl.saas.videocache.PreCatcher.this     // Catch: com.fl.saas.videocache.ProxyCacheException -> L7d
                com.fl.saas.videocache.PreCatcher.access$100(r1, r7)     // Catch: com.fl.saas.videocache.ProxyCacheException -> L7d
                goto L81
            L7d:
                r7 = move-exception
                r7.printStackTrace()
            L81:
                throw r0
            L82:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.videocache.PreCatcher.PreCacheCallable.connectToPoxyServer(java.lang.String):boolean");
        }

        private boolean isStoped() {
            return this.mStoped;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(connectToPoxyServer(this.mUrl));
        }

        public void stop() {
            synchronized (this.mStopLock) {
                this.mStoped = true;
            }
        }
    }

    private PreCatcher() {
        this.preCacheExecutor = Executors.newFixedThreadPool(5);
        this.mCacheCallableMap = new HashMap();
    }

    public static PreCatcher getInstance() {
        return InstanceHolder.mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removePreCacheCallable(String str) {
        if (this.mCacheCallableMap.get(str) == null) {
            return false;
        }
        this.mCacheCallableMap.remove(str);
        return true;
    }

    public synchronized boolean startCache(String str, int i) {
        if (this.mCacheCallableMap.containsKey(str)) {
            return false;
        }
        PreCacheCallable preCacheCallable = new PreCacheCallable(str, i);
        this.mCacheCallableMap.put(str, preCacheCallable);
        this.preCacheExecutor.submit(preCacheCallable);
        return true;
    }

    public void stopAll() {
        Iterator<PreCacheCallable> it = this.mCacheCallableMap.values().iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        this.mCacheCallableMap.clear();
    }

    public synchronized void stopCache(String str) {
        PreCacheCallable preCacheCallable = this.mCacheCallableMap.get(str);
        if (preCacheCallable != null) {
            preCacheCallable.stop();
            this.mCacheCallableMap.remove(str);
        }
    }
}
