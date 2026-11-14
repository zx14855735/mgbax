package com.bytedance.sdk.openadsdk.core.component.reward.w;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.yy;
import com.bytedance.sdk.openadsdk.core.widget.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f extends xj {
    private com.bytedance.sdk.openadsdk.core.widget.y e;
    private String yo;

    public f(Activity activity, ws wsVar) {
        super(activity, wsVar);
        this.e = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.xj, com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj hf(final tf tfVar) {
        final com.bytedance.sdk.openadsdk.core.widget.y yVar = new com.bytedance.sdk.openadsdk.core.widget.y(this.f);
        this.e = yVar;
        xj(yVar, this.u);
        this.e.xj(new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.f.1
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
        return this.yo;
    }

    private void xj(com.bytedance.sdk.openadsdk.core.widget.y yVar, boolean z) {
        if (ht.hf(this.c)) {
            int py = this.c.py();
            int xj = yy.xj(this.c);
            if (py == 0) {
                String str = "试玩时长达标才能领取奖励";
                if (xj != 1 && !z && !this.w) {
                    str = "试玩后才能领取奖励";
                }
                this.yo = str;
                yVar.xj(jk.w(this.f, "tt_retain_gift")).xj(d()).w("继续试玩").u("坚持退出");
                yVar.xj(com.bytedance.sdk.openadsdk.res.kd.d(this.f));
                return;
            }
            if (py != 1) {
                if (py != 3) {
                    return;
                }
                this.yo = "确定退出吗?";
                Activity activity = this.f;
                if (activity != null) {
                    Intent intent = activity.getIntent();
                    this.yo = CtFAbx.ASJ6gh(intent != null ? intent.getIntExtra("remainTime", 0) : 0, "再看", "秒可得奖励");
                }
                xj(yVar, d(), "继续观看", "坚持退出");
                yVar.xj(Color.parseColor("#FC1D56"));
                return;
            }
            boolean w = v.w(this.c);
            if (xj != 0 || w) {
                this.yo = CtFAbx.ASJ6gh(this.xj, "再看", "秒可得奖励");
            } else {
                this.yo = "未满足奖励要求，需要继续浏览";
            }
            if (w) {
                yVar.hf("确定退出吗?");
                xj(yVar, d(), "继续观看", "坚持退出");
            } else {
                yVar.xj(jk.w(this.f, "tt_reward_coin")).xj(Color.parseColor("#FC1D56")).xj(d()).w("继续观看").u("坚持退出");
                yVar.xj(com.bytedance.sdk.openadsdk.res.kd.d(this.f));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public boolean hf() {
        com.bytedance.sdk.openadsdk.core.widget.y yVar = this.e;
        return yVar != null && yVar.isShowing();
    }

    private void xj(com.bytedance.sdk.openadsdk.core.widget.y yVar, String str, String str2, String str3) {
        yVar.xj(jk.w(this.f, "tt_reward_browse_multi_icon")).xj(str).w(str2).u(str3);
        yVar.xj(com.bytedance.sdk.openadsdk.res.kd.l(this.f));
    }
}
