package com.bytedance.sdk.component.tf;

import ADYaiT.CtFAbx;
import com.kuaishou.weapon.p0.t;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf implements ThreadFactory {
    private final ThreadGroup hf;
    private final AtomicInteger u;
    private int w;
    public final String xj;

    public tf(String str) {
        this(5, str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread xj = xj(this.hf, runnable, this.xj + "_" + this.u.getAndIncrement());
        if (xj.isDaemon()) {
            xj.setDaemon(false);
        }
        int i = this.w;
        if (i > 10) {
            this.w = 10;
        } else if (i <= 0) {
            this.w = 1;
        }
        xj.setPriority(this.w);
        return xj;
    }

    public Thread xj(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new com.bytedance.sdk.component.tf.u.w(threadGroup, runnable, str);
    }

    public tf(int i, String str) {
        this.u = new AtomicInteger(1);
        this.w = i;
        this.hf = new ThreadGroup(CtFAbx.BChYOn("csj_g_", str));
        this.xj = CtFAbx.B25kr6(new StringBuilder("csj_"), p.hf.y() ? t.b : "", str);
    }
}
