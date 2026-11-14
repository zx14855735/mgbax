package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.w.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends w {
    public u(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar, boolean z) {
        super(tTBaseVideoActivity, wsVar, hfVar, kdVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void hf(View view) {
        super.hf(view);
        this.y.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void w(View view) {
        super.w(view);
        this.y.w(this.u.a());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w, com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void xj(View view) {
        super.xj(view);
        if (xj()) {
            return;
        }
        this.y.wn().hf();
        if (this.u.r()) {
            this.y.hf();
        } else if (this.y.aq().wn()) {
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

    private void hf() {
        tf tfVar = new tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.u.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void hf() {
                u.this.y.hf();
            }
        };
        if (xj(tfVar)) {
            this.c--;
        } else {
            tfVar.hf();
        }
    }

    private void w() {
        this.y.hf();
    }
}
