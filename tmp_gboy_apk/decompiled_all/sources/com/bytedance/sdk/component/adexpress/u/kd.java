package com.bytedance.sdk.component.adexpress.u;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    public static void hf(com.bytedance.sdk.component.tf.d dVar, int i) {
        if (dVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.xj.xj.w w = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w();
        ExecutorService g = w != null ? w.g() : null;
        if (g == null) {
            com.bytedance.sdk.component.tf.c.xj(dVar);
        } else {
            dVar.setPriority(i);
            g.execute(dVar);
        }
    }

    public static void xj(com.bytedance.sdk.component.tf.d dVar, int i) {
        if (dVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.xj.xj.w w = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w();
        ExecutorService am = w != null ? w.am() : null;
        if (am == null) {
            com.bytedance.sdk.component.tf.c.xj(dVar, i);
        } else {
            dVar.setPriority(i);
            am.execute(dVar);
        }
    }

    public static ScheduledFuture xj(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.tf.c.u().schedule(runnable, j, timeUnit);
    }
}
