package com.bytedance.sdk.openadsdk.core.component.reward.u;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.yy;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f extends xj {
    boolean en;
    int j;
    int z;

    public f(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity, wsVar);
        this.z = 0;
        this.j = 0;
        this.en = false;
    }

    public static boolean xj(ws wsVar) {
        return ht.w(wsVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void am() {
        super.am();
        this.xj.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int c(boolean z) {
        int i;
        if (v.p(this.hf) || (i = this.z) == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min(i, 27.0f)) - et());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public View d() {
        return com.bytedance.sdk.openadsdk.res.kd.xj(this.xj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean dq() {
        return v.u(this.hf) && ws.hf(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void f() {
        super.f();
        com.bytedance.sdk.openadsdk.core.playable.hf.xj().xj(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void gh() {
        this.yo.xj(true);
        this.d.y(8);
        if (v.xj(this.hf)) {
            nb();
        } else {
            this.yo.kd(true);
            this.yo.hf(this.hf.oz());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void hf(boolean z) {
        super.hf(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public boolean j() {
        if (a() > 0) {
            return false;
        }
        if (!v.u(this.hf) && yy.xj(this.hf) == 0) {
            return this.jk.jk();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean lw() {
        return v.u(this.hf);
    }

    public void nb() {
        int py = this.hf.py();
        if (py == 0) {
            this.d.kd(0);
            this.yo.kd(true);
            this.yo.hf(this.hf.oz());
        } else {
            if (py != 1) {
                if (py != 3) {
                    return;
                }
                this.yo.kd(false);
                this.yo.hf(false);
                this.yo.xj(false, null, null, true, true);
                return;
            }
            this.d.kd(0);
            this.yo.hf(this.hf.oz());
            if (v.u(this.hf)) {
                this.yo.kd(ws.hf(this.hf));
            } else {
                this.yo.kd(com.bytedance.sdk.openadsdk.x.tf.xj(this.hf));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int q() {
        return hf(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void qt() {
        super.qt();
        com.bytedance.sdk.openadsdk.core.playable.hf.xj().hf(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean s() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public View tf() {
        if (v.u(this.hf)) {
            this.p = new RewardJointEndCardFrameLayout(this.xj, this.hf);
        }
        return super.tf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean tu() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj, com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void w() {
        this.yo.xj(4);
        this.jk.xj();
        this.xj.v();
        if (v.p(this.hf)) {
            this.yo.hf(true);
        }
        this.z = ht.kd(this.hf);
        this.j = ht.y(this.hf);
        if (v.u(this.hf)) {
            this.xj.y();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void wa() {
        if (v.p(this.hf)) {
            return;
        }
        int et = et();
        int i = this.z;
        int i2 = i - et;
        if (et >= i) {
            this.yo.xj(false, null, null, true, true);
            if (!v.p(this.hf)) {
                this.xj.pl();
            }
        } else {
            int i3 = this.j;
            if (i3 >= i) {
                this.yo.xj(false, String.valueOf(i2), null, false, false);
            } else if (et >= i3) {
                this.yo.xj(false, String.valueOf(i2), "跳过", false, true);
            } else {
                this.yo.xj(false, String.valueOf(i2), (this.j - et) + "s后可跳过", false, false);
            }
        }
        this.xj.w(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int wo() {
        if (v.p(this.hf) || this.z == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min((this.z * this.hf.tq()) / 100.0f, 27.0f)) - et());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public boolean y() {
        return false;
    }

    public static int hf(ws wsVar) {
        return v.xj(wsVar) ? 6 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public hf.xj xj(ws wsVar, final com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar) {
        if (this.pz.kd()) {
            return new hf.xj(false, 0, "");
        }
        this.xj.ws();
        this.xj.b();
        com.bytedance.sdk.openadsdk.core.component.reward.w.f fVar = new com.bytedance.sdk.openadsdk.core.component.reward.w.f(this.xj, wsVar);
        fVar.xj(this.jk.jk());
        fVar.xj(r());
        return fVar.hf(new com.bytedance.sdk.openadsdk.core.component.reward.w.tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.f.1
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
                f.this.xj.eu();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void w(boolean z) {
        super.w(z);
    }
}
