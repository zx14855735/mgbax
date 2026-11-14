package com.kwad.sdk.core.threads.a;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a extends ScheduledThreadPoolExecutor implements c {
    public static volatile boolean aOF;
    private final ConcurrentHashMap<Runnable, Long> aOG;
    private long aOH;
    private int aOI;

    public a(int i, ThreadFactory threadFactory) {
        super(1, threadFactory);
        this.aOG = new ConcurrentHashMap<>();
        this.aOH = 0L;
        this.aOI = 0;
    }

    @Override // com.kwad.sdk.core.threads.a.c
    public final long LC() {
        return this.aOH;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (aOF && this.aOG.containsKey(runnable) && this.aOG.get(runnable) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.aOG.get(runnable).longValue();
            if (elapsedRealtime >= 0 && elapsedRealtime < 1800000) {
                long j = this.aOH;
                int i = this.aOI;
                this.aOH = ((j * i) + elapsedRealtime) / (i + 1);
                this.aOI = i + 1;
            }
            this.aOG.remove(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (aOF) {
            this.aOG.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }
}
