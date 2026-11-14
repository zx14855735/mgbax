package com.bytedance.sdk.component.hf.xj.xj.hf;

import com.bytedance.sdk.component.hf.xj.xj.hf.xj;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends com.bytedance.sdk.component.hf.xj.u {
    private ExecutorService xj;
    private final Deque<xj.C0114xj> hf = new ArrayDeque();
    private final Deque<xj.C0114xj> w = new ArrayDeque();
    private final Deque<xj> u = new ArrayDeque();
    private AtomicInteger kd = new AtomicInteger(64);

    public u() {
        if (this.xj == null) {
            this.xj = new com.bytedance.sdk.component.tf.u.u(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.component.hf.xj.xj.hf.u.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.bytedance.sdk.component.tf.u.w wVar = new com.bytedance.sdk.component.tf.u.w(runnable, "systemHttp Dispatcher");
                    wVar.setDaemon(false);
                    wVar.setPriority(10);
                    return wVar;
                }
            });
        }
    }

    private void w() {
        if (this.w.size() < xj() && !this.hf.isEmpty()) {
            Iterator<xj.C0114xj> it = this.hf.iterator();
            while (it.hasNext()) {
                xj.C0114xj next = it.next();
                it.remove();
                this.w.add(next);
                if (next != null) {
                    next.xj();
                }
                hf().submit(next);
                if (this.w.size() >= xj()) {
                    return;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.u
    public void hf(int i) {
    }

    @Override // com.bytedance.sdk.component.hf.xj.u
    public void xj(int i) {
        this.kd.set(i);
    }

    @Override // com.bytedance.sdk.component.hf.xj.u
    public ExecutorService hf() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.hf.xj.u
    public int xj() {
        return this.kd.get();
    }

    public void hf(xj.C0114xj c0114xj) {
        xj(this.w, c0114xj, true);
    }

    public synchronized void xj(xj.C0114xj c0114xj) {
        try {
            if (this.w.size() < xj()) {
                this.w.add(c0114xj);
                if (c0114xj != null) {
                    c0114xj.xj();
                }
                hf().submit(c0114xj);
                return;
            }
            this.hf.add(c0114xj);
        } catch (Throwable unused) {
        }
    }

    public void hf(xj xjVar) {
        xj(this.u, xjVar, false);
    }

    public synchronized void xj(xj xjVar) {
        this.u.add(xjVar);
    }

    private <T> void xj(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            try {
                deque.remove(t);
                if (z) {
                    w();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
