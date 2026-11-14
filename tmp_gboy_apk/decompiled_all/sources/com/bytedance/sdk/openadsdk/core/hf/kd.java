package com.bytedance.sdk.openadsdk.core.hf;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class kd extends xj {
    public kd(Context context, ws wsVar, String str, int i) {
        super(context, wsVar, str, i);
    }

    public abstract void hf(View view, tf tfVar);

    @Override // com.bytedance.sdk.openadsdk.core.hf.hf, com.bytedance.sdk.openadsdk.core.hf.u
    public void xj(View view, tf tfVar) {
        if (ws.kd(this.xj)) {
            return;
        }
        super.xj(view, tfVar);
        com.bytedance.sdk.openadsdk.core.hf.xj.hf hfVar = (com.bytedance.sdk.openadsdk.core.hf.xj.hf) this.f.xj(com.bytedance.sdk.openadsdk.core.hf.xj.hf.class);
        if (hfVar == null || !hfVar.hf(view)) {
            return;
        }
        hf(view, tfVar);
    }
}
