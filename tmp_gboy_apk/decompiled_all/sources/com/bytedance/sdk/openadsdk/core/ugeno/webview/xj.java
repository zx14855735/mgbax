package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import com.bytedance.adsdk.ugeno.hf.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends w<PageWebView> {
    private String xj;

    public xj(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public PageWebView xj() {
        return new PageWebView(this.hf);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        ((PageWebView) this.kd).setMeta(com.bytedance.sdk.openadsdk.core.xj.xj(tf()));
        ((PageWebView) this.kd).hf(tf());
        ((PageWebView) this.kd).setUGenContext(this.d);
        ((PageWebView) this.kd).xj();
        ((PageWebView) this.kd).xj(this.xj);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        if (str.equals("src")) {
            this.xj = str2;
        }
    }
}
