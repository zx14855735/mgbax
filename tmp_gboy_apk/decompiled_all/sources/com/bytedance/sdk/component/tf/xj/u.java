package com.bytedance.sdk.component.tf.xj;

import com.bytedance.sdk.component.tf.p;
import com.bytedance.sdk.component.tf.tf;
import java.util.concurrent.ThreadFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements ThreadFactory {
    private final int hf;
    private final ThreadFactory xj;

    public u(ThreadFactory threadFactory, int i) {
        if (threadFactory == null) {
            this.xj = new tf("default");
        } else {
            this.xj = threadFactory;
        }
        this.hf = i;
    }

    public boolean hf() {
        return p.hf.hf(this.hf);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.xj.newThread(runnable);
        return hf() ? new c(newThread) : newThread;
    }

    public final String xj() {
        return this.xj.getClass().getName();
    }
}
