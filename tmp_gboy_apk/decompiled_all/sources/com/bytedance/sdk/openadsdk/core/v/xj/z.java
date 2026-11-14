package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.component.xj.u;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.n;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class z extends com.bytedance.sdk.component.xj.u<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public z(com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void u() {
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, final com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("commonConvert", new u.hf() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.z.1
            @Override // com.bytedance.sdk.component.xj.u.hf
            public com.bytedance.sdk.component.xj.u xj() {
                return new z(com.bytedance.sdk.openadsdk.core.j.this);
            }
        });
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.d.xj ai;
        JSONObject hf;
        com.bytedance.sdk.openadsdk.core.f.zg().yy();
        JSONObject jSONObject2 = new JSONObject();
        try {
            WeakReference<com.bytedance.sdk.openadsdk.core.j> weakReference = this.xj;
            if (weakReference == null) {
                com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("commonConvert", "js", 1, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.hf.xj().u(null);
                return;
            }
            com.bytedance.sdk.openadsdk.core.j jVar = weakReference.get();
            if (jVar == null) {
                w();
                com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("commonConvert", "js", 2, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.hf.xj().u(null);
                return;
            }
            if (jSONObject == null) {
                com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("commonConvert", "js", 3, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.hf.xj().u(null);
                return;
            }
            ws xj = com.bytedance.sdk.openadsdk.core.xj.xj(jSONObject);
            int optInt = jSONObject.optInt("j_live_saas_param_interaction_type", -1);
            if (xj == null) {
                com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("commonConvert", "js", 4, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.hf.xj().u(xj);
                return;
            }
            xj.xj(true);
            jSONObject2.putOpt("live_interaction_type", Integer.valueOf(xj.vu()));
            jSONObject2.putOpt(n.m, xj.jf());
            if (xj.yl() == null && (ai = xj.ai()) != null && (hf = ai.hf()) != null) {
                xj.xj(com.bytedance.sdk.openadsdk.core.ra.g.xj(hf));
            }
            jVar.xj(xj, optInt);
            com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("commonConvert", "js", 0, jSONObject2);
            com.bytedance.sdk.openadsdk.core.live.hf.xj().u(xj);
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(PluginConstants.KEY_ERROR_CODE, 200);
                xj((z) jSONObject3);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj("xeasy", e.getMessage());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("commonConvert", "js", 0, jSONObject2);
            com.bytedance.sdk.openadsdk.core.live.hf.xj().u(null);
            throw th;
        }
    }
}
