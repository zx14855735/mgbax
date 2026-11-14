package com.bytedance.sdk.component.tf.u;

import com.bytedance.sdk.component.tf.p;
import com.bytedance.sdk.component.tf.xj.c;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends Thread {
    private c proxy;

    public w() {
    }

    @Override // java.lang.Thread
    public void interrupt() {
        c cVar = this.proxy;
        if (cVar != null) {
            cVar.interrupt();
        } else {
            super.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        c cVar = this.proxy;
        return cVar != null ? cVar.isInterrupted() : super.isInterrupted();
    }

    public boolean isProxyEnable() {
        return p.hf.hf(1);
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            try {
                if (!isProxyEnable()) {
                    super.start();
                    return;
                }
                if (this.proxy == null) {
                    this.proxy = new c(this);
                }
                this.proxy.start();
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.tf.u.xj.xj("PThread");
                p pVar = p.hf;
                pVar.pl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tf.u.w.1
                    @Override // java.lang.Runnable
                    public void run() {
                        w.super.start();
                    }
                }, pVar.u(), TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public w(Runnable runnable) {
        super(runnable);
    }

    public w(String str) {
        super(str);
    }

    public w(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public w(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public w(Runnable runnable, String str) {
        super(runnable, str);
    }

    public w(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public w(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        super(threadGroup, runnable, str, j);
    }
}
