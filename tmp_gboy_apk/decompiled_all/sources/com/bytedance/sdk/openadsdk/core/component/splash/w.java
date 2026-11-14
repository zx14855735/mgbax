package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.component.splash.f;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
abstract class w {
    protected ViewGroup hf;
    protected f.xj u;
    protected ws w;
    protected Context xj;

    public void hf() {
        f.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.hf();
        }
    }

    public abstract String xj();

    public abstract void xj(com.bytedance.sdk.openadsdk.core.hf.xj xjVar);

    public void xj(boolean z) {
    }

    public void xj(Context context, ViewGroup viewGroup, ws wsVar) {
        this.xj = context;
        this.hf = viewGroup;
        this.w = wsVar;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.video.nativevideo.u uVar, f.xj xjVar) {
        com.bytedance.sdk.openadsdk.core.am.u.w(this.w, "splash_ad", xj());
        this.hf.setVisibility(0);
        this.u = xjVar;
    }
}
