package com.ss.android.socialbase.downloader.d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj implements ThreadFactory {
    private final AtomicInteger hf;
    private final boolean w;
    private final String xj;

    public xj(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.tf.u.w wVar = new com.bytedance.sdk.component.tf.u.w(runnable, this.xj + "-" + this.hf.incrementAndGet());
        if (!this.w) {
            if (wVar.isDaemon()) {
                wVar.setDaemon(false);
            }
            if (wVar.getPriority() != 5) {
                wVar.setPriority(5);
            }
        }
        return wVar;
    }

    public xj(String str, boolean z) {
        this.hf = new AtomicInteger();
        this.xj = str;
        this.w = z;
    }
}
