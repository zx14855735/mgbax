package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.component.xj.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c extends com.bytedance.sdk.component.xj.u<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public c(com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void u() {
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, final com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("newClickEvent", new u.hf() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.c.1
            @Override // com.bytedance.sdk.component.xj.u.hf
            public com.bytedance.sdk.component.xj.u xj() {
                return new c(com.bytedance.sdk.openadsdk.core.j.this);
            }
        });
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        com.bytedance.sdk.openadsdk.core.j jVar = this.xj.get();
        if (jVar == null) {
            w();
        } else {
            jVar.d(jSONObject);
        }
    }
}
