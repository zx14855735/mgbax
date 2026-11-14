package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    private static long c = -1;
    private static volatile hf f = null;
    private static final String hf = "hf";
    public static volatile boolean xj;
    private long y;
    private final p w = p.xj();
    private final AtomicInteger u = new AtomicInteger();
    private final xj kd = new xj(com.ss.android.socialbase.downloader.d.kd.xj());

    public class xj extends Handler {
        public xj(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            hf.this.y();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void hf() {
            removeMessages(1);
        }

        public void xj() {
            sendEmptyMessage(1);
        }
    }

    private hf() {
    }

    public static void kd() {
        xj = com.ss.android.socialbase.downloader.tf.y.hf(com.ss.android.socialbase.downloader.downloader.w.tj());
    }

    public static long u() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static hf xj() {
        if (f == null) {
            synchronized (hf.class) {
                try {
                    if (f == null) {
                        f = new hf();
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public void c() {
        y();
        c = -1L;
    }

    public void hf() {
        try {
            com.ss.android.socialbase.downloader.w.xj.w(hf, "startSampling: mSamplingCounter = " + this.u);
            if (this.u.getAndIncrement() == 0) {
                this.kd.xj();
                this.y = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void w() {
        try {
            com.ss.android.socialbase.downloader.w.xj.w(hf, "stopSampling: mSamplingCounter = " + this.u);
            if (this.u.decrementAndGet() == 0) {
                this.kd.hf();
                c();
            }
        } catch (Throwable unused) {
        }
    }

    public void y() {
        try {
            kd();
            long u = xj ? u() : TrafficStats.getMobileRxBytes();
            long j = c;
            long j2 = u - j;
            if (j >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.w.xj(j2, uptimeMillis - this.y);
                    this.y = uptimeMillis;
                }
            }
            c = u;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }
}
