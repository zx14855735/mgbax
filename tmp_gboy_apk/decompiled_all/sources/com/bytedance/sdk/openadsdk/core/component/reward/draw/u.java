package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends com.bytedance.sdk.openadsdk.core.component.reward.y.hf {
    private boolean l;

    public u(Context context, ViewGroup viewGroup, ws wsVar) {
        super(context, viewGroup, wsVar, null);
        xj(false);
    }

    public void c(boolean z) {
        this.l = z;
    }

    public boolean dk() {
        return e() != null && e().am();
    }

    public boolean et() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.y.hf, com.bytedance.sdk.openadsdk.core.video.hf.xj, com.bykv.vk.openvk.component.video.api.u.w
    public void f() {
        if (this.l) {
            return;
        }
        super.f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.y.hf, com.bytedance.sdk.openadsdk.core.video.hf.xj
    public int ra() {
        return 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj, com.bykv.vk.openvk.component.video.api.u.w
    public void tf() {
        this.l = false;
        super.tf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj
    public void y(boolean z) {
        super.y(z);
    }
}
