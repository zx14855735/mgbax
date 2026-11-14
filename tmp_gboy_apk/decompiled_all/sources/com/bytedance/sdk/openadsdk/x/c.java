package com.bytedance.sdk.openadsdk.x;

import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    public static void hf(com.bytedance.sdk.component.tf.d dVar) {
        com.bytedance.sdk.component.tf.c.w(dVar);
    }

    public static void u(Runnable runnable) {
        xj(runnable, (ScheduledExecutorService) null);
    }

    public static void w(Runnable runnable) {
        if (pz.hf().qa()) {
            com.bytedance.sdk.component.utils.f.w().post(runnable);
        } else {
            runnable.run();
        }
    }

    public static boolean xj() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void hf(Runnable runnable) {
        if (pz.hf().nu() || Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            v.y().post(runnable);
        }
    }

    public static void xj(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            v.y().post(runnable);
        }
    }

    public static void xj(Runnable runnable, long j) {
        v.y().postDelayed(runnable, j);
    }

    public static Looper hf() {
        return pz.hf().qa() ? com.bytedance.sdk.component.utils.f.w().getLooper() : Looper.getMainLooper();
    }

    public static void xj(com.bytedance.sdk.component.tf.d dVar) {
        com.bytedance.sdk.component.tf.c.hf(dVar);
    }

    public static void xj(final Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        if (!xj()) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(runnable);
        } else {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("") { // from class: com.bytedance.sdk.openadsdk.x.c.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
        }
    }
}
