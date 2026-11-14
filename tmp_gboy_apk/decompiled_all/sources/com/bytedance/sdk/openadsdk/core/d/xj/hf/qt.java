package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class qt implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "log_extra")
    private String hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    private ws w;

    @com.bytedance.sdk.component.p.hf.xj(xj = "label")
    private String xj;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        if (!xj()) {
            com.bytedance.sdk.component.utils.pl.u("UChain_ReportEventAction", "ifHasAllRequiredParam = false");
            xjVar.hf(map2);
            return false;
        }
        JSONObject xj = xj(map);
        com.bytedance.sdk.openadsdk.core.am.u.hf(this.w, wo.hf(this.w), this.xj, xj);
        xjVar.xj(map2);
        return true;
    }

    private JSONObject xj(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add("label");
            hashSet.add(MediationConstant.EXTRA_ADID);
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
        return (TextUtils.isEmpty(this.xj) || TextUtils.isEmpty(this.hf) || this.w == null) ? false : true;
    }
}
