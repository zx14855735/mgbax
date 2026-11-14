package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ht extends ra {
    public ht(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        super(context, wsVar, hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ra, com.bytedance.sdk.openadsdk.core.nativeexpress.pz
    public void xj(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        this.u = "draw_ad";
        NativeExpressDrawVideoView nativeExpressDrawVideoView = new NativeExpressDrawVideoView(context, wsVar, hfVar, "draw_ad");
        ((pz) this).xj = nativeExpressDrawVideoView;
        xj(nativeExpressDrawVideoView, this.w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(boolean z) {
        NativeExpressView nativeExpressView = ((pz) this).xj;
        if (nativeExpressView != null) {
            ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z);
        }
    }
}
