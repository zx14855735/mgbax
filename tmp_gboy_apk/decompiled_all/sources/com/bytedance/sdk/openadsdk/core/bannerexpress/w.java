package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends hf {
    public w(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        super(context, wsVar, hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf
    public com.bytedance.sdk.openadsdk.core.multipro.hf.xj p() {
        WeakReference<BannerExpressBackupView> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            return this.c.get().getVideoModel();
        }
        xj xjVar = ((hf) this).xj;
        if (xjVar != null) {
            return ((BannerExpressVideoView) xjVar).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.hf
    public void xj(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (context == null) {
            return;
        }
        ((hf) this).xj = new BannerExpressVideoView(context, wsVar, hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar) {
        xj xjVar = ((hf) this).xj;
        if (xjVar != null) {
            xjVar.setVideoAdListener(wVar);
        }
    }
}
