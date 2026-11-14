package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.w.pz;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.component.adexpress.hf.f;
import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.component.adexpress.hf.qt;
import com.bytedance.sdk.component.adexpress.hf.tf;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.utils.pl;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements tf {
    private u hf;
    private AtomicBoolean kd = new AtomicBoolean(false);
    private ScheduledFuture<?> u;
    private g w;
    private Context xj;

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
                kd.this.hf.xj(true);
                kd.this.xj(this.xj, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
            }
        }
    }

    public kd(Context context, u uVar, f fVar, g gVar) {
        this.xj = context;
        this.hf = uVar;
        this.w = gVar;
        this.hf.xj(fVar);
    }

    private void hf() {
        try {
            ScheduledFuture<?> scheduledFuture = this.u;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.u.cancel(false);
            this.u = null;
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf
    public boolean xj(final tf.xj xjVar) {
        int f = this.w.f();
        if (f < 0) {
            xj(xjVar, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
        } else {
            this.u = c.u().schedule(new xj(1, xjVar), f, TimeUnit.MILLISECONDS);
            this.hf.xj(new com.bytedance.sdk.component.adexpress.hf.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.kd.1
                @Override // com.bytedance.sdk.component.adexpress.hf.c
                public void xj(View view, am amVar) {
                    if (xjVar.w()) {
                        return;
                    }
                    pz pzVar = new pz();
                    pzVar.xj(0);
                    ((hf) kd.this.w).l().xj(pzVar);
                    kd.this.w.c().g();
                    qt hf = xjVar.hf();
                    if (hf == null) {
                        return;
                    }
                    hf.xj(kd.this.hf, amVar);
                    xjVar.xj(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.hf.c
                public void xj(int i, String str) {
                    qt hf;
                    pz pzVar = new pz();
                    pzVar.xj(i);
                    pzVar.xj(str);
                    ((hf) kd.this.w).l().xj(pzVar);
                    if (xjVar.hf(kd.this)) {
                        xjVar.xj(kd.this);
                    } else {
                        if (xjVar.w() || (hf = xjVar.hf()) == null) {
                            return;
                        }
                        hf.a_(i);
                    }
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf
    public void xj() {
        u uVar = this.hf;
        if (uVar != null) {
            uVar.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(tf.xj xjVar, int i) {
        qt hf;
        if (xjVar.w() || this.kd.get()) {
            return;
        }
        hf();
        pz pzVar = new pz();
        pzVar.xj(i);
        ((hf) this.w).l().xj(pzVar);
        if (xjVar.hf(this)) {
            xjVar.xj(this);
        } else {
            if (xjVar.w() || (hf = xjVar.hf()) == null) {
                return;
            }
            xjVar.xj(true);
            hf.a_(i);
        }
        this.kd.getAndSet(true);
    }
}
