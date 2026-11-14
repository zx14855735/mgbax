package com.bytedance.sdk.openadsdk.d.xj;

import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.xj.e;
import com.bytedance.sdk.component.xj.u;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.j;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.sdk.component.xj.u<JSONObject, JSONObject> {
    private WeakReference<j> xj;

    public xj(j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void u() {
    }

    public static void xj(e eVar, final j jVar) {
        eVar.xj("interstitial_webview_close", new u.hf() { // from class: com.bytedance.sdk.openadsdk.d.xj.xj.1
            @Override // com.bytedance.sdk.component.xj.u.hf
            public com.bytedance.sdk.component.xj.u xj() {
                return new xj(j.this);
            }
        });
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        f.zg().yy();
        pl.u("DoInterstitialWebViewCloseMethod", "DoInterstitialWebViewCloseMethod invoke ");
        j jVar = this.xj.get();
        if (jVar == null) {
            pl.u("DoInterstitialWebViewCloseMethod", "invoke error");
            w();
        } else {
            jVar.qt();
        }
    }
}
