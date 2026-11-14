package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.component.xj.u;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends com.bytedance.sdk.component.xj.u<JSONObject, JSONObject> {
    private ws hf;
    private com.bytedance.sdk.openadsdk.core.jk.w w;
    private WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public y(com.bytedance.sdk.openadsdk.core.j jVar, ws wsVar) {
        this.xj = new WeakReference<>(jVar);
        this.hf = wsVar;
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void u() {
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, final com.bytedance.sdk.openadsdk.core.j jVar, final ws wsVar) {
        eVar.xj("getNetworkData", new u.hf() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.y.1
            @Override // com.bytedance.sdk.component.xj.u.hf
            public com.bytedance.sdk.component.xj.u xj() {
                return new y(com.bytedance.sdk.openadsdk.core.j.this, wsVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        com.bytedance.sdk.openadsdk.core.j jVar = this.xj.get();
        if (jVar == null) {
            w();
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.w = new com.bytedance.sdk.openadsdk.core.jk.w() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.y.2
            @Override // com.bytedance.sdk.openadsdk.core.jk.w
            public void xj(boolean z, List<ws> list, boolean z2) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (z) {
                        jSONObject2.put("creatives", com.bytedance.sdk.openadsdk.core.j.xj(list));
                        jSONObject2.put(PointParamKey.IS_CACHE, z2);
                        if (z2) {
                            jSONObject2.put("prefetch_opt_time", currentTimeMillis - com.bytedance.sdk.openadsdk.core.playable.hf.xj().w(y.this.hf));
                        }
                        y.this.xj((y) jSONObject2);
                    } else {
                        y.this.xj((y) jSONObject2);
                    }
                    com.bytedance.sdk.openadsdk.core.f.zg().yy();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.w("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        };
        if (jSONObject != null && jSONObject.optBoolean("is_first_request", false) && com.bytedance.sdk.openadsdk.core.playable.hf.xj().xj(this.hf, this.w)) {
            return;
        }
        jVar.xj(jSONObject, this.w);
    }
}
