package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class zg implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "log_extra")
    private String hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    private ws w;

    @com.bytedance.sdk.component.p.hf.xj(xj = PointParamKey.TYPE)
    private String xj;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        if (!xj()) {
            com.bytedance.sdk.component.utils.pl.u("UChain_ReportStatsAction", "ifHasAllRequiredParam = false");
            xjVar.hf(map2);
            return false;
        }
        final JSONObject xj = xj(map);
        final int f = wo.f(this.w);
        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.zg.1
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(zg.this.xj).f(zg.this.hf).xj(f).hf(xj.toString());
            }
        }, this.xj);
        xjVar.xj(map2);
        return true;
    }

    private JSONObject xj(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add(PointParamKey.TYPE);
            hashSet.add("log_extra");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!hashSet.contains(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private boolean xj() {
        return (TextUtils.isEmpty(this.xj) || TextUtils.isEmpty(this.hf)) ? false : true;
    }
}
