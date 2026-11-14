package com.bytedance.sdk.openadsdk.core.component.reward.u;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends xj {
    public y(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity, wsVar);
    }

    public static int hf(ws wsVar) {
        return 4;
    }

    private boolean nb() {
        return ws.hf(this.hf);
    }

    private boolean ss() {
        return com.bytedance.sdk.openadsdk.x.tf.xj(this.hf);
    }

    public static boolean xj(ws wsVar) {
        return (wsVar == null || wsVar.yq() == 100.0f) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public View d() {
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.hf)) {
            return com.bytedance.sdk.openadsdk.res.kd.ra(this.xj);
        }
        int i = (int) (this.u * 1000.0f);
        return this.w == 1 ? i != 666 ? i != 1000 ? i != 1500 ? i != 1777 ? com.bytedance.sdk.openadsdk.res.kd.ai(this.xj) : com.bytedance.sdk.openadsdk.res.kd.x(this.xj) : com.bytedance.sdk.openadsdk.res.kd.et(this.xj) : com.bytedance.sdk.openadsdk.res.kd.io(this.xj) : com.bytedance.sdk.openadsdk.res.kd.dk(this.xj) : i != 562 ? i != 666 ? i != 1000 ? i != 1500 ? com.bytedance.sdk.openadsdk.res.kd.en(this.xj) : com.bytedance.sdk.openadsdk.res.kd.z(this.xj) : com.bytedance.sdk.openadsdk.res.kd.io(this.xj) : com.bytedance.sdk.openadsdk.res.kd.q(this.xj) : com.bytedance.sdk.openadsdk.res.kd.j(this.xj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean dq() {
        return nb() || ss();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void f() {
        super.f();
        eu();
        try {
            final View decorView = this.xj.getWindow().getDecorView();
            if (decorView != null) {
                decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.y.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int p = (int) (r.p((Context) y.this.xj) / 2.0f);
                        int paddingLeft = decorView.getPaddingLeft();
                        int paddingRight = decorView.getPaddingRight();
                        int paddingTop = decorView.getPaddingTop();
                        int paddingBottom = decorView.getPaddingBottom();
                        if (y.this.w == 1 && !r.hf()) {
                            paddingTop += p;
                            paddingBottom += p;
                        }
                        if (y.this.w == 2 && !r.hf()) {
                            paddingLeft += p;
                            paddingRight += p;
                        }
                        decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void gh() {
        this.d.kd(8);
        this.d.y(8);
        if (y()) {
            this.yo.xj(false);
            return;
        }
        this.yo.hf(this.hf.oz());
        this.yo.kd(nb() || ss());
        if (nb()) {
            return;
        }
        this.yo.xj(false, null, null, true, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void op() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.kd kdVar = this.ht;
        if (kdVar != null) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj((Object) this.xj);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar = this.ra;
        if (uVar != null) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) uVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj((Object) this.xj);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int q() {
        return hf(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean s() {
        return nb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public boolean tj() {
        return this.w == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean tu() {
        return s() && hl.xj(this.hf) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void u(boolean z) {
        if (this.w == 1) {
            this.d.u(z ? 0 : 8);
        } else {
            this.d.u(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void w(boolean z) {
        super.w(z);
        if (pz.hf().p(wo.d(this.hf)) || this.am) {
            if (com.bytedance.sdk.openadsdk.core.pl.w.w.y.w && com.bytedance.sdk.openadsdk.core.pl.w.w.y.hf && w(this.hf)) {
                com.bytedance.sdk.openadsdk.core.pl.w.w.y.hf = false;
                com.bytedance.sdk.openadsdk.core.pl.w.w.y.w = false;
                this.xj.finish();
            } else if (z && !com.bytedance.sdk.openadsdk.core.pl.w.w.y.w) {
                this.xj.finish();
            } else {
                if (!this.jk.z() || com.bytedance.sdk.openadsdk.core.pl.w.w.y.w) {
                    return;
                }
                this.xj.finish();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void zg() {
        super.zg();
        this.yo.hf(this.hf.oz());
        if (nb() || ss()) {
            this.yo.kd(true);
        }
        if (!nb()) {
            this.yo.xj(false, null, null, true, true);
        }
        if (!nb()) {
            this.d.y(8);
            this.d.kd(8);
        } else {
            this.d.y(0);
            this.d.kd(0);
            this.d.w(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.hf xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.c cVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.c(this.xj, this.hf, z);
        this.d = cVar;
        return cVar;
    }

    private boolean w(ws wsVar) {
        return (wsVar.vw() == 4) && !TextUtils.isEmpty(wsVar.lp());
    }
}
