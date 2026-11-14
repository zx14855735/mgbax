package com.fl.saas.videocache;

import ADYaiT.CtFAbx;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class ProxyCache {
    private static final int MAX_READ_SOURCE_ATTEMPTS = 1;
    private final Cache cache;
    private final Source source;
    private volatile Thread sourceReaderThread;
    private volatile boolean stopped;
    private final Object wc = new Object();
    private final Object stopLock = new Object();
    private volatile int percentsAvailable = -1;
    private final AtomicInteger readSourceErrorsCount = new AtomicInteger();

    public class SourceReaderRunnable implements Runnable {
        private SourceReaderRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProxyCache.this.readSource();
        }
    }

    public ProxyCache(Source source, Cache cache) {
        this.source = (Source) Preconditions.checkNotNull(source);
        this.cache = (Cache) Preconditions.checkNotNull(cache);
    }

    private void checkReadSourceErrorsCount() {
        int i = this.readSourceErrorsCount.get();
        if (i < 1) {
            return;
        }
        this.readSourceErrorsCount.set(0);
        throw new ProxyCacheException(CtFAbx.ASJ6gh(i, "Error reading source ", " times"));
    }

    private void closeSource() {
        try {
            this.source.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.source, e));
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.stopped;
    }

    private void notifyNewCacheDataAvailable(long j, long j2) {
        onCacheAvailable(j, j2);
        synchronized (this.wc) {
            this.wc.notifyAll();
        }
    }

    private void onSourceRead() {
        this.percentsAvailable = 100;
        onCachePercentsAvailableChanged(this.percentsAvailable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
    
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void readSource() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.fl.saas.videocache.Cache r4 = r8.cache     // Catch: java.lang.Throwable -> L41
            long r2 = r4.available()     // Catch: java.lang.Throwable -> L41
            com.fl.saas.videocache.Source r4 = r8.source     // Catch: java.lang.Throwable -> L41
            r4.open(r2)     // Catch: java.lang.Throwable -> L41
            com.fl.saas.videocache.Source r4 = r8.source     // Catch: java.lang.Throwable -> L41
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L41
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L41
        L19:
            com.fl.saas.videocache.Source r5 = r8.source     // Catch: java.lang.Throwable -> L41
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L41
            r6 = -1
            if (r5 == r6) goto L45
            java.lang.Object r6 = r8.stopLock     // Catch: java.lang.Throwable -> L41
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L41
            boolean r7 = r8.isStopped()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L35
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
        L2c:
            r8.closeSource()
            r8.notifyNewCacheDataAvailable(r2, r0)
            return
        L33:
            r4 = move-exception
            goto L43
        L35:
            com.fl.saas.videocache.Cache r7 = r8.cache     // Catch: java.lang.Throwable -> L33
            r7.append(r4, r5)     // Catch: java.lang.Throwable -> L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.notifyNewCacheDataAvailable(r2, r0)     // Catch: java.lang.Throwable -> L41
            goto L19
        L41:
            r4 = move-exception
            goto L4c
        L43:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            throw r4     // Catch: java.lang.Throwable -> L41
        L45:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L41
            r8.onSourceRead()     // Catch: java.lang.Throwable -> L41
            goto L2c
        L4c:
            java.util.concurrent.atomic.AtomicInteger r5 = r8.readSourceErrorsCount     // Catch: java.lang.Throwable -> L5b
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L5b
            r8.onError(r4)     // Catch: java.lang.Throwable -> L5b
            r8.closeSource()
            r8.notifyNewCacheDataAvailable(r2, r0)
            return
        L5b:
            r4 = move-exception
            r8.closeSource()
            r8.notifyNewCacheDataAvailable(r2, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.videocache.ProxyCache.readSource():void");
    }

    private synchronized void readSourceAsync() {
        try {
            boolean z = (this.sourceReaderThread == null || this.sourceReaderThread.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.stopped && !this.cache.isCompleted() && !z) {
                this.sourceReaderThread = new Thread(new SourceReaderRunnable(), "Source reader for " + this.source);
                this.sourceReaderThread.start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void tryComplete() {
        synchronized (this.stopLock) {
            try {
                if (!isStopped() && this.cache.available() == this.source.length()) {
                    this.cache.complete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void waitForSourceData() {
        synchronized (this.wc) {
            try {
                try {
                    this.wc.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onCacheAvailable(long j, long j2) {
        int i = j2 == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.percentsAvailable;
        if (j2 >= 0 && z) {
            onCachePercentsAvailableChanged(i);
        }
        this.percentsAvailable = i;
    }

    public void onCachePercentsAvailableChanged(int i) {
    }

    public final void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            LogcatUtil.d("ProxyCache is interrupted");
            return;
        }
        LogcatUtil.e("ProxyCache error" + th.getMessage());
    }

    public int read(byte[] bArr, long j, int i) {
        ProxyCacheUtils.assertBuffer(bArr, j, i);
        while (!this.cache.isCompleted() && this.cache.available() < i + j && !this.stopped) {
            readSourceAsync();
            waitForSourceData();
            checkReadSourceErrorsCount();
        }
        int read = this.cache.read(bArr, j, i);
        if (this.cache.isCompleted() && this.percentsAvailable != 100) {
            this.percentsAvailable = 100;
            onCachePercentsAvailableChanged(100);
        }
        return read;
    }

    public void shutdown() {
        synchronized (this.stopLock) {
            try {
                LogcatUtil.d("Shutdown proxy for " + this.source);
                try {
                    this.stopped = true;
                    if (this.sourceReaderThread != null) {
                        this.sourceReaderThread.interrupt();
                    }
                    this.cache.close();
                } catch (ProxyCacheException e) {
                    onError(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
