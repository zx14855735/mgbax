package com.bytedance.sdk.component.adexpress.hf;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.hf.tf;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class zg implements tf {
    private com.bytedance.sdk.component.adexpress.kd.xj hf;
    private ScheduledFuture<?> kd;
    private g u;
    private f w;
    private Context xj;
    private AtomicBoolean y = new AtomicBoolean(false);

    public class xj implements Runnable {
        private int w;
        tf.xj xj;

        public xj(int i, tf.xj xjVar) {
            this.w = i;
            this.xj = xjVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.w == 1) {
                zg.this.hf.xj(true);
                zg.this.xj(this.xj, 107, null);
            }
        }
    }

    public zg(Context context, g gVar, com.bytedance.sdk.component.adexpress.kd.xj xjVar, f fVar) {
        this.xj = context;
        this.u = gVar;
        this.w = fVar;
        this.hf = xjVar;
        xjVar.xj(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        try {
            ScheduledFuture<?> scheduledFuture = this.kd;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.kd.cancel(false);
            this.kd = null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public com.bytedance.sdk.component.adexpress.kd.xj hf() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf
    public boolean xj(final tf.xj xjVar) {
        int f = this.u.f();
        if (f < 0) {
            xj(xjVar, 107, "time is ".concat(String.valueOf(f)));
        } else {
            this.kd = com.bytedance.sdk.component.adexpress.u.kd.xj(new xj(1, xjVar), f, TimeUnit.MILLISECONDS);
            this.hf.xj(new c() { // from class: com.bytedance.sdk.component.adexpress.hf.zg.1
                @Override // com.bytedance.sdk.component.adexpress.hf.c
                public void xj(View view, am amVar) {
                    qt hf;
                    zg.this.w();
                    if (xjVar.w() || (hf = xjVar.hf()) == null) {
                        return;
                    }
                    hf.xj(zg.this.hf, amVar);
                    xjVar.xj(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.hf.c
                public void xj(int i, String str) {
                    zg.this.xj(xjVar, i, str);
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf
    public void xj() {
        this.hf.u();
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(tf.xj xjVar, int i, String str) {
        qt hf;
        if (xjVar.w() || this.y.get()) {
            return;
        }
        w();
        this.u.c().xj(i, str);
        if (xjVar.hf(this)) {
            xjVar.xj(this);
        } else {
            if (xjVar.w() || (hf = xjVar.hf()) == null) {
                return;
            }
            xjVar.xj(true);
            hf.a_(i);
        }
        this.y.getAndSet(true);
    }
}
