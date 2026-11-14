package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends u {
    public w(Context context, ViewGroup viewGroup, ws wsVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, wsVar, str, z, z2, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.u
    public com.bykv.vk.openvk.component.video.api.renderview.hf ra() {
        y yVar = this.kd;
        if (yVar != null) {
            return yVar.e();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.u
    public void xj(int i, int i2) {
        super.xj(i, i2);
        y yVar = this.kd;
        if (yVar == null || i <= 0 || i2 <= 0) {
            return;
        }
        yVar.w(i, i2);
        this.kd.xj(i, i2);
        hf(-1, -1);
    }
}
