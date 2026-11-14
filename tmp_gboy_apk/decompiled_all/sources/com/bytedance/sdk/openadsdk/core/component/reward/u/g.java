package com.bytedance.sdk.openadsdk.core.component.reward.u;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class g extends xj {
    public g(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity, wsVar);
    }

    public static int hf(ws wsVar) {
        return 1;
    }

    public static boolean xj(ws wsVar) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean bl() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean dq() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void gh() {
        this.yo.hf(this.hf.oz());
        if (y()) {
            this.d.kd(8);
            this.d.y(8);
            this.yo.xj(false);
        } else {
            this.d.kd(0);
            this.d.y(0);
            this.yo.kd(true);
            this.xj.yy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean lw() {
        if (!this.am) {
            return false;
        }
        if (hl.xj(this.hf) == 2 && hl.hf(this.hf) == 3) {
            return false;
        }
        return (hl.xj(this.hf) == 2 && hl.hf(this.hf) == 7) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int q() {
        return hf(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean s() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean tu() {
        return s();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void wa() {
        if (aq.e(this.hf)) {
            boolean w = aq.w();
            boolean w2 = aq.w();
            this.xj.w(0);
            if (et() > ws() || this.qt) {
                com.bytedance.sdk.openadsdk.core.f.u.xj = 0;
                com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar = this.yo;
                boolean z = this.am;
                kdVar.xj(z, z ? "领取成功" : "", w ? "" : "跳过", w2, true);
                this.xj.hl();
                return;
            }
            int y = y(true);
            int y2 = y(false);
            com.bytedance.sdk.openadsdk.core.f.u.xj = y;
            boolean z2 = et() > this.q.w() || this.xj.vm();
            boolean z3 = !w && z2;
            boolean z4 = w2 && z2;
            com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar2 = this.yo;
            boolean z5 = this.am;
            StringBuilder sb = new StringBuilder();
            sb.append(y2);
            sb.append("s");
            sb.append(this.am ? "后可领取奖励" : "");
            kdVar2.xj(z5, sb.toString(), z3 ? "跳过" : "", z4, z2);
            hf(y);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void zg() {
        super.zg();
        this.yo.hf(this.hf.oz());
        this.yo.kd(true);
        this.d.y(0);
        this.d.kd(0);
        this.xj.yy();
    }
}
