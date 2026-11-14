package com.bytedance.sdk.openadsdk.core.playable;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class w extends com.bytedance.sdk.openadsdk.core.video.hf.xj {
    private boolean l;

    public w(Context context, ViewGroup viewGroup, ws wsVar, com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        super(context, viewGroup, wsVar, xjVar);
        this.l = true;
        xj(false);
    }

    public void c(boolean z) {
        this.l = z;
    }

    public void dk() {
        dc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj
    public int ra() {
        return 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj
    public boolean v_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj
    public void y(boolean z) {
        super.y(z);
        if (this.l) {
            if (!tf.xj(this.y) || kd()) {
                hf();
            }
        }
    }
}
