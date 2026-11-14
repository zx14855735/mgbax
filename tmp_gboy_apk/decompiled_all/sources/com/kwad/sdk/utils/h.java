package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h {
    private static volatile ExecutorService bdD;
    private static volatile ScheduledExecutorService bdE;

    public static void execute(Runnable runnable) {
        if (bdD == null) {
            synchronized (h.class) {
                try {
                    if (bdD == null) {
                        bdD = GlobalThreadPools.Lq();
                    }
                } finally {
                }
            }
        }
        if (bdD == null || bdD.isShutdown() || bdD.isTerminated()) {
            return;
        }
        bdD.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (bdE == null) {
            synchronized (h.class) {
                try {
                    if (bdE == null) {
                        bdE = GlobalThreadPools.Lr();
                    }
                } finally {
                }
            }
        }
        bdE.schedule(runnable, j, timeUnit);
    }
}
