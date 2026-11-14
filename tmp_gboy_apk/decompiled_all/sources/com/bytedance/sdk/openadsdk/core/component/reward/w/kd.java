package com.bytedance.sdk.openadsdk.core.component.reward.w;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.widget.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends xj {
    private com.bytedance.sdk.openadsdk.core.widget.y e;

    public kd(Activity activity, ws wsVar) {
        super(activity, wsVar);
        this.e = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.xj, com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj hf(final tf tfVar) {
        final com.bytedance.sdk.openadsdk.core.widget.y yVar = new com.bytedance.sdk.openadsdk.core.widget.y(this.f);
        this.e = yVar;
        yVar.xj(jk.w(this.f, "tt_retain_gift")).xj(d()).w("继续观看").u("坚持退出");
        yVar.xj(com.bytedance.sdk.openadsdk.res.kd.g(this.f));
        this.e.xj(new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.kd.1
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
        this.e.xj(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.kd.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                yVar.dismiss();
                tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.w();
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
        return CtFAbx.AZkASS("秒可获得奖励\n确定要退出吗？", this.xj, new StringBuilder("继续观看"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public boolean hf() {
        com.bytedance.sdk.openadsdk.core.widget.y yVar = this.e;
        return yVar != null && yVar.isShowing();
    }
}
