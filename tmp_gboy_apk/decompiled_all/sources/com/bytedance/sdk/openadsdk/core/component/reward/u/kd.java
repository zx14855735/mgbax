package com.bytedance.sdk.openadsdk.core.component.reward.u;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.czhj.sdk.common.Constants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends xj {
    public kd(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity, wsVar);
    }

    public static int hf(ws wsVar) {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean bl() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public View d() {
        if (this.w == 2) {
            int rx = this.hf.rx();
            return rx != 3 ? rx != 33 ? com.bytedance.sdk.openadsdk.res.kd.v(this.xj) : com.bytedance.sdk.openadsdk.res.kd.yo(this.xj) : com.bytedance.sdk.openadsdk.res.kd.e(this.xj);
        }
        int rx2 = this.hf.rx();
        return rx2 != 3 ? rx2 != 33 ? com.bytedance.sdk.openadsdk.res.kd.ht(this.xj) : com.bytedance.sdk.openadsdk.res.kd.pz(this.xj) : com.bytedance.sdk.openadsdk.res.kd.jk(this.xj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean dq() {
        if (this.tf.y()) {
            return this.tf.tf();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void gh() {
        this.d.kd(8);
        this.d.y(8);
        this.yo.kd(com.bytedance.sdk.openadsdk.x.tf.xj(this.hf));
        this.yo.hf(this.hf.oz());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean lw() {
        return true;
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
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void wa() {
        super.wa();
        if (aq.e(this.hf)) {
            this.xj.w(0);
            int et = et();
            if (et > ws() || this.qt) {
                com.bytedance.sdk.openadsdk.core.f.u.xj = 0;
                com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar = this.yo;
                boolean z = this.am;
                kdVar.xj(z, z ? "领取成功" : "", null, true, true);
                this.xj.hl();
                if (this.tf == null || ra() != 7) {
                    return;
                }
                this.tf.xj(Constants.FAIL, et, 0, false);
                return;
            }
            int y = y(true);
            int y2 = y(false);
            com.bytedance.sdk.openadsdk.core.f.u.xj = y;
            boolean z2 = et > this.q.w() || this.xj.vm();
            com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar2 = this.yo;
            boolean z3 = this.am;
            StringBuilder sb = new StringBuilder();
            sb.append(y2);
            sb.append("s");
            sb.append(this.am ? "后可领取奖励" : "");
            kdVar2.xj(z3, sb.toString(), null, z2, z2);
            hf(y);
            if (this.tf == null || ra() != 7) {
                return;
            }
            this.tf.xj(String.valueOf(y2), et, 0, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.hf xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.y yVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.y(this.xj, this.hf, z);
        this.d = yVar;
        return yVar;
    }

    public static boolean xj(ws wsVar) {
        return (wsVar == null || ws.hf(wsVar)) ? false : true;
    }
}
