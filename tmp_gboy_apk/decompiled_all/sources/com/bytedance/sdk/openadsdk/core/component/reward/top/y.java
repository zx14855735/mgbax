package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.u.d;
import com.bytedance.sdk.openadsdk.core.component.reward.w.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends w {
    public y(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar, boolean z) {
        super(tTBaseVideoActivity, wsVar, hfVar, kdVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void c(View view) {
        super.c(view);
        this.y.gh();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void hf(View view) {
        super.hf(view);
        if (this.y.aq() instanceof d) {
            this.y.a();
        }
        this.y.ff();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void w(View view) {
        super.w(view);
        this.y.w("video_player");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void xj(View view) {
        super.xj(view);
        if (xj()) {
            return;
        }
        this.y.wn().xj();
        if (this.y.aq().wn()) {
            hf();
        } else {
            w();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void y(View view) {
        super.y(view);
        xj(view);
    }

    private void w() {
        tf tfVar = new tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.y.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void hf() {
                y.this.y.w();
            }
        };
        if (xj(tfVar)) {
            return;
        }
        tfVar.hf();
    }

    private void hf() {
        tf tfVar = new tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.y.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void hf() {
                y.this.y.am();
                y.this.y.wo().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.y.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        y.this.y.hf();
                    }
                }, 100L);
            }
        };
        int i = 2;
        int kd = this.y.kd(2);
        if (this.hf.rh() == 7) {
            if (pz.hf().c(String.valueOf(wo.d(this.hf))) && !this.y.tu()) {
                i = 1;
            }
            kd = i;
        }
        if (kd == 1) {
            if (xj(tfVar)) {
                return;
            }
            tfVar.hf();
            return;
        }
        this.y.w();
    }
}
