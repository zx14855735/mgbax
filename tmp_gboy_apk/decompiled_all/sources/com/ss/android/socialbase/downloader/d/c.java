package com.ss.android.socialbase.downloader.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    private Handler u;
    private xj w;
    private Object xj = new Object();
    private Queue<hf> hf = new ConcurrentLinkedQueue();

    public class hf {
        public long hf;
        public Runnable xj;

        public hf(Runnable runnable, long j) {
            this.xj = runnable;
            this.hf = j;
        }
    }

    public class xj extends HandlerThread {
        public xj(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (c.this.xj) {
                c.this.u = new Handler(looper);
            }
            while (!c.this.hf.isEmpty()) {
                hf hfVar = (hf) c.this.hf.poll();
                if (hfVar != null) {
                    c.this.u.postDelayed(hfVar.xj, hfVar.hf);
                }
            }
        }
    }

    public c(String str) {
        this.w = new xj(str);
    }

    public void hf() {
        this.w.quit();
    }

    public void xj() {
        this.w.start();
    }

    public void xj(Runnable runnable) {
        xj(runnable, 0L);
    }

    public void xj(Runnable runnable, long j) {
        if (this.u == null) {
            synchronized (this.xj) {
                try {
                    if (this.u == null) {
                        this.hf.add(new hf(runnable, j));
                        return;
                    }
                } finally {
                }
            }
        }
        this.u.postDelayed(runnable, j);
    }
}
