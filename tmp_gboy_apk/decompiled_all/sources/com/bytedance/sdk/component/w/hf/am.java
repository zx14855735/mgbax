package com.bytedance.sdk.component.w.hf;

import com.bytedance.sdk.component.w.hf.et;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class am {
    private ExecutorService kd;
    private String u;
    private Runnable w;
    private int xj = 64;
    private int hf = 5;
    private final Deque<et.xj> y = new ArrayDeque();
    private final Deque<et.xj> c = new ArrayDeque();
    private final Deque<et> f = new ArrayDeque();

    public am() {
    }

    private void w() {
        if (this.c.size() < this.xj && !this.y.isEmpty()) {
            Iterator<et.xj> it = this.y.iterator();
            while (it.hasNext()) {
                et.xj next = it.next();
                if (w(next) < this.hf) {
                    it.remove();
                    this.c.add(next);
                    if (next != null) {
                        next.hf();
                    }
                    xj().execute(next);
                }
                if (this.c.size() >= this.xj) {
                    return;
                }
            }
        }
    }

    public synchronized void hf(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
        this.hf = i;
        w();
    }

    public synchronized ExecutorService xj() {
        String str;
        try {
            if (this.kd == null) {
                String str2 = this.u;
                if (str2 != null && str2.length() != 0) {
                    str = this.u;
                    this.kd = new com.bytedance.sdk.component.tf.u.u(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.w.hf.xj.w.xj(str, false));
                }
                str = TKDownloadReason.KSAD_TK_NET;
                this.kd = new com.bytedance.sdk.component.tf.u.u(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.w.hf.xj.w.xj(str, false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.kd;
    }

    public void hf(et.xj xjVar) {
        xj(this.c, xjVar, true);
    }

    public synchronized void xj(int i) {
        if (i > 0) {
            this.xj = i;
            w();
        } else {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
    }

    public am(String str) {
        this.u = str;
    }

    public void hf(et etVar) {
        xj(this.f, etVar, false);
    }

    public synchronized int hf() {
        return this.c.size() + this.f.size();
    }

    private int w(et.xj xjVar) {
        Iterator<et.xj> it = this.c.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().xj().equals(xjVar.xj())) {
                i++;
            }
        }
        return i;
    }

    public synchronized void xj(et.xj xjVar) {
        try {
            if (this.c.size() < this.xj && w(xjVar) < this.hf) {
                this.c.add(xjVar);
                if (xjVar != null) {
                    xjVar.hf();
                }
                xj().execute(xjVar);
                return;
            }
            this.y.add(xjVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void xj(et etVar) {
        this.f.add(etVar);
    }

    private <T> void xj(Deque<T> deque, T t, boolean z) {
        int hf;
        Runnable runnable;
        synchronized (this) {
            try {
                if (deque.remove(t)) {
                    if (z) {
                        w();
                    }
                    hf = hf();
                    runnable = this.w;
                } else {
                    throw new AssertionError("Call wasn't in-flight!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (hf != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }
}
