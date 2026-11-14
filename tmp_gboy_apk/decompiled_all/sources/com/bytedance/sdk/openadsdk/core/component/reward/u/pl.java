package com.bytedance.sdk.openadsdk.core.component.reward.u;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pl extends xj {
    private com.bytedance.sdk.openadsdk.core.am.y en;
    int j;
    int z;

    public pl(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity, wsVar);
        this.z = 0;
        this.j = 0;
        com.bytedance.sdk.openadsdk.core.am.y yVar = new com.bytedance.sdk.openadsdk.core.am.y(wsVar);
        this.en = yVar;
        yVar.xj(true);
    }

    public static boolean xj(ws wsVar) {
        return wsVar.io() == 1 && v.xj(wsVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void am() {
        super.am();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int c(boolean z) {
        if ((this.jk.l() && v.xj(this.hf)) || this.z == 0) {
            return 0;
        }
        return (com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.hf) || com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.hf)) ? Math.max(this.z - et(), 0) : Math.max(Math.min(this.z, 27) - et(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public View d() {
        FrameLayout frameLayout = new FrameLayout(this.xj);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean dq() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void f() {
        JSONObject w;
        super.f();
        com.bytedance.sdk.openadsdk.core.playable.hf.xj().xj(this.hf);
        if (com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.hf) || com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.hf)) {
            com.bytedance.sdk.openadsdk.core.ugeno.d.xj ai = this.hf.ai();
            this.z = 30;
            if (ai != null && (w = ai.w()) != null) {
                this.z = w.optInt("reward_time", 30);
            }
        } else {
            this.z = ht.kd(this.hf);
        }
        this.j = ht.y(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void gh() {
        this.d.kd(0);
        this.yo.xj(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.hf)) {
            this.yo.kd(true);
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.hf) || com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.hf)) {
            this.yo.hf(false);
        } else {
            this.yo.hf(this.hf.oz());
        }
        if (!com.bytedance.sdk.openadsdk.core.ugeno.tf.w(this.hf)) {
            this.yo.kd(false);
            this.yo.xj(false, null, null, true, true);
            return;
        }
        this.yo.w(true);
        this.yo.kd(true);
        com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar = this.yo;
        boolean z = this.am;
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append("s");
        sb.append(this.am ? "后可领取奖励" : "");
        kdVar.xj(z, sb.toString(), null, true, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void hf(boolean z) {
        super.hf(z);
        this.en.w();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.hf hfVar = this.d;
        if (hfVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) hfVar).d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void ht() {
        if (com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.hf) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) this.d).w()) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) this.d).xj(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public boolean j() {
        if (a() > 0) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.hf)) {
            return true;
        }
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) this.d).xj(0);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void kd(boolean z) {
        super.kd(z);
        if (com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.hf)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) this.d).hf(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int q() {
        return hf(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void qt() {
        super.qt();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.hf hfVar = this.d;
        if ((hfVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) hfVar).y()) {
            this.en.u();
        }
        this.d.tf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean s() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean tu() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void w(boolean z) {
        super.w(z);
        com.bytedance.sdk.openadsdk.core.component.reward.layout.hf hfVar = this.d;
        if (hfVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) {
            if (((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) hfVar).y()) {
                this.en.xj(((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) this.d).kd().get());
            }
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) this.d).f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void wa() {
        int et = et();
        int max = Math.max(0, this.z - et);
        if (!this.jk.l()) {
            int i = this.z;
            if (et >= i) {
                if (com.bytedance.sdk.openadsdk.core.ugeno.tf.w(this.hf)) {
                    com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar = this.yo;
                    boolean z = this.am;
                    kdVar.xj(z, z ? "领取成功" : "", null, true, true);
                } else {
                    this.yo.xj(false, null, null, true, true);
                }
                this.xj.pl();
            } else if (this.j >= i) {
                this.yo.xj(false, String.valueOf(max), null, false, false);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.tf.w(this.hf)) {
                com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar2 = this.yo;
                boolean z2 = this.am;
                StringBuilder sb = new StringBuilder();
                sb.append(max);
                sb.append("s");
                sb.append(this.am ? "后可领取奖励" : "");
                kdVar2.xj(z2, sb.toString(), null, this.j <= et, true);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.hf) || com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.hf)) {
                if (et >= this.j) {
                    this.yo.xj(false, null, null, true, true);
                }
            } else if (et >= this.j) {
                this.yo.xj(false, String.valueOf(max), "跳过", false, true);
            } else {
                this.yo.xj(false, String.valueOf(max), (this.j - et) + "s后可跳过", false, false);
            }
        }
        this.xj.w(0);
        if (com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.hf)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) this.d).xj(max);
        }
        if (max == 0) {
            com.bytedance.sdk.openadsdk.core.component.reward.layout.hf hfVar = this.d;
            if (hfVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) {
                ((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) hfVar).c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int wo() {
        if ((this.jk.l() && v.xj(this.hf)) || this.z == 0) {
            return 0;
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.hf) || com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.hf)) {
            return Math.max(this.z - et(), 0);
        }
        return Math.max(((int) Math.min((this.z * this.hf.tq()) / 100.0f, 27.0f)) - et(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public boolean y() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.hf xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xj xjVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.xj(this.xj, this.hf, z, this.en, this.yo);
        this.d = xjVar;
        return xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public hf.xj xj(final ws wsVar, final com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar) {
        this.xj.ws();
        this.xj.b();
        com.bytedance.sdk.openadsdk.core.component.reward.w.f fVar = new com.bytedance.sdk.openadsdk.core.component.reward.w.f(this.xj, wsVar);
        fVar.xj(this.jk.jk());
        fVar.xj(r());
        return fVar.hf(new com.bytedance.sdk.openadsdk.core.component.reward.w.tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.pl.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void hf() {
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.hf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void xj() {
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.xj();
                }
                if (com.bytedance.sdk.openadsdk.core.ugeno.tf.u(wsVar) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) pl.this.d).u()) {
                    return;
                }
                pl.this.xj.eu();
            }
        });
    }

    public static int hf(ws wsVar) {
        return com.bytedance.sdk.openadsdk.core.ugeno.tf.w(wsVar) ? 6 : 7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj, com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void w() {
        this.yo.xj(4);
        this.d.w(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.hf) || com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.hf)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.xj) this.d).xj(Math.max(0, this.z - et()));
        }
        this.xj.hf(true, true);
    }
}
