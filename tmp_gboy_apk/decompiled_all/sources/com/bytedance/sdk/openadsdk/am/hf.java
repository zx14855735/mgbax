package com.bytedance.sdk.openadsdk.am;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private f hf;
    private int u;
    private ScheduledExecutorService xj = null;
    private long w = 0;

    public hf(f fVar, int i) {
        this.hf = fVar;
        this.u = i;
    }

    public boolean hf() {
        ScheduledExecutorService scheduledExecutorService = this.xj;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }

    public void xj(long j) {
        this.w = j;
    }

    public void xj(int i) {
        ScheduledExecutorService xj = com.bytedance.sdk.component.tf.w.xj(1, new com.bytedance.sdk.component.tf.tf("/CrashMonitor"));
        this.xj = xj;
        xj.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.am.hf.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (System.currentTimeMillis() - hf.this.w > hf.this.u) {
                    hf.this.xj.shutdown();
                    if (hf.this.hf != null) {
                        hf.this.hf.hf(0, "自动检测卡死");
                    }
                }
            }
        }, 0L, i, TimeUnit.MILLISECONDS);
    }

    public void xj() {
        ScheduledExecutorService scheduledExecutorService = this.xj;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }
}
