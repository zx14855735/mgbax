package com.bytedance.sdk.component.y.xj;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements ThreadFactory {
    private final AtomicInteger hf = new AtomicInteger(1);
    private final ThreadGroup xj;

    public xj(String str) {
        this.xj = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.tf.u.w wVar = new com.bytedance.sdk.component.tf.u.w(this.xj, runnable, "tt_img_" + this.hf.getAndIncrement());
        if (wVar.isDaemon()) {
            wVar.setDaemon(false);
        }
        return wVar;
    }
}
