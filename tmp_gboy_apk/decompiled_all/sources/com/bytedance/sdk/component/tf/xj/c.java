package com.bytedance.sdk.component.tf.xj;

import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.tf.p;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c extends Thread {
    private volatile boolean hf;
    private final Thread w;
    private volatile Thread xj;

    public c(Thread thread) {
        this.w = thread;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        if (this.xj != null) {
            this.xj.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        if (this.xj != null) {
            return this.xj.isInterrupted();
        }
        return true;
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        if (this.hf) {
            return;
        }
        this.hf = true;
        p.hf.tf().execute(new com.bytedance.sdk.component.tf.w.w(new d(this.w.getName()) { // from class: com.bytedance.sdk.component.tf.xj.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (p.hf.qt()) {
                    c.this.xj();
                } else {
                    c.this.hf();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf() {
        Thread currentThread = Thread.currentThread();
        this.xj = currentThread;
        currentThread.setPriority(this.w.getPriority());
        this.w.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj() {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        try {
            hf w = p.hf.w();
            String name2 = this.w.getName();
            if (w != null) {
                name2 = w.xj(name2);
            }
            currentThread.setName(name2);
            this.xj = currentThread;
            currentThread.setPriority(this.w.getPriority());
            this.w.run();
            currentThread.setName(name);
        } catch (Throwable th) {
            currentThread.setName(name);
            throw th;
        }
    }
}
