package com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj;

import android.app.Activity;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.component.reward.w.tf;
import com.bytedance.sdk.openadsdk.core.ra.n;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.widget.y;
import com.bytedance.sdk.openadsdk.res.kd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends xj {
    private y hf;

    public hf(Activity activity, ws wsVar) {
        super(activity, wsVar);
        this.hf = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public boolean hf() {
        y yVar = this.hf;
        return yVar != null && yVar.isShowing();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public void kd() {
        y yVar = this.hf;
        if (yVar != null) {
            yVar.hf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public void u() {
        y yVar = this.hf;
        if (yVar != null) {
            yVar.xj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public void w() {
        y yVar = this.hf;
        if (yVar != null) {
            yVar.dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.xj, com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj xj(final tf tfVar) {
        hf.xj xj = super.xj(tfVar);
        if (xj.w()) {
            return xj;
        }
        final y yVar = new y(this.f);
        this.hf = yVar;
        yVar.xj(jk.w(this.f, "tt_retain_gift")).xj(xj()).w(n.xj(this.c, this.p, this.f10325pl)).u("坚持退出");
        yVar.xj(kd.d(this.f));
        this.hf.xj(new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.hf.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.y.xj
            public void hf() {
                yVar.dismiss();
                tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.hf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.y.xj
            public void xj() {
                tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.xj();
                }
            }
        });
        this.hf.show();
        return new hf.xj(true, 0, "", this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public String xj() {
        return "恭喜您已经获得奖励，是否要继续观看视频，再得超值奖励";
    }
}
