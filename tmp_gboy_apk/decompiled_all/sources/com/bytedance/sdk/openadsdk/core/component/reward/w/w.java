package com.bytedance.sdk.openadsdk.core.component.reward.w;

import ADYaiT.CtFAbx;
import android.app.Activity;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.widget.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends xj {
    private com.bytedance.sdk.openadsdk.core.widget.y e;

    public w(Activity activity, ws wsVar) {
        super(activity, wsVar);
        this.e = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.xj, com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj hf(final tf tfVar) {
        hf.xj hf = super.hf(tfVar);
        if (hf.w()) {
            return hf;
        }
        final com.bytedance.sdk.openadsdk.core.widget.y yVar = new com.bytedance.sdk.openadsdk.core.widget.y(this.f);
        this.e = yVar;
        yVar.xj(jk.w(this.f, "tt_retain_gift")).xj(d()).w("继续观看").u("坚持退出");
        this.e.xj(com.bytedance.sdk.openadsdk.res.kd.d(this.f));
        this.e.xj(new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.w.1
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
                yVar.dismiss();
                tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.xj();
                }
            }
        });
        this.e.show();
        return new hf.xj(true, 0, "", this.e);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public void w() {
        com.bytedance.sdk.openadsdk.core.widget.y yVar = this.e;
        if (yVar != null) {
            yVar.dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public String xj() {
        if (this.xj > 0 && this.kd) {
            return CtFAbx.AZkASS("s，并点击一下广告可领取奖励", this.xj, new StringBuilder("再看"));
        }
        if (this.kd) {
            return "忘记点击广告领取奖励啦～";
        }
        return CtFAbx.AZkASS("s可领取奖励", this.xj, new StringBuilder("再看"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public boolean hf() {
        com.bytedance.sdk.openadsdk.core.widget.y yVar = this.e;
        return yVar != null && yVar.isShowing();
    }
}
