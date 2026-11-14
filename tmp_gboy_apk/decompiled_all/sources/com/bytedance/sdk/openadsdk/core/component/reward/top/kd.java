package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends w {
    public kd(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar, boolean z) {
        super(tTBaseVideoActivity, wsVar, hfVar, kdVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void hf(View view) {
        super.hf(view);
        if (v.u(this.hf)) {
            this.y.ff();
        } else {
            this.y.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void w(View view) {
        super.w(view);
        this.y.w("playable");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void xj(View view) {
        super.xj(view);
        if (xj()) {
            return;
        }
        this.y.wn().xj();
        if (v.p(this.hf) || tf.kd(this.hf) || tf.u(this.hf)) {
            this.y.tf();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar = new com.bytedance.sdk.openadsdk.core.component.reward.w.tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.kd.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void hf() {
                kd.this.y.am();
                kd.this.y.hf();
            }
        };
        if (xj(tfVar)) {
            this.c--;
        } else {
            tfVar.hf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void y(View view) {
        super.y(view);
        if (tf.kd(this.hf) || tf.u(this.hf)) {
            this.y.tf();
        } else {
            xj();
        }
    }
}
