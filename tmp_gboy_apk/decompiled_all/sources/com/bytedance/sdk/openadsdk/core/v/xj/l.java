package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.component.xj.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class l extends com.bytedance.sdk.component.xj.u<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public l(com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void u() {
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, final com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("showAppDetailOrPrivacyDialog", new u.hf() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.l.1
            @Override // com.bytedance.sdk.component.xj.u.hf
            public com.bytedance.sdk.component.xj.u xj() {
                return new l(com.bytedance.sdk.openadsdk.core.j.this);
            }
        });
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        com.bytedance.sdk.openadsdk.core.f.zg().yy();
        WeakReference<com.bytedance.sdk.openadsdk.core.j> weakReference = this.xj;
        if (weakReference == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.j jVar = weakReference.get();
        if (jVar == null) {
            w();
            return;
        }
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("show_dialog_style");
        if (optInt == 1) {
            jVar.dk();
        } else if (optInt == 2) {
            jVar.ra();
        }
    }
}
