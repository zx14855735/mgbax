package com.bytedance.msdk.core.hf;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, Map<String, Object> map) {
        if (com.bytedance.msdk.core.hf.hf().wo()) {
            String ra = hfVar != null ? hfVar.ra() : null;
            hf b = com.bytedance.msdk.core.hf.hf().b();
            if (b != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("lt_days", Integer.valueOf(b.xj()));
                    jSONObject.putOpt("rule_id", b.w(ra));
                } catch (Exception e) {
                    com.bytedance.msdk.xj.kd.w.u("AdLoadEventManager", "put 元素 异常：" + e.getMessage());
                }
                try {
                    jSONObject.putOpt("score", Float.valueOf(com.bytedance.msdk.core.xj.p().xj(ra)));
                } catch (Exception e2) {
                    com.bytedance.msdk.xj.kd.w.u("AdLoadEventManager", "put 元素异常：" + e2.getMessage());
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("dis_c", Integer.valueOf(xj.hf(ra)));
                    jSONObject2.putOpt("ins_d", Integer.valueOf(xj.kd()));
                    jSONObject2.putOpt("act_d", Integer.valueOf(xj.hf()));
                    jSONObject2.putOpt("act_times", Integer.valueOf(xj.u()));
                    jSONObject.putOpt("active_target", jSONObject2);
                } catch (Exception e3) {
                    com.bytedance.msdk.xj.kd.w.u("AdLoadEventManager", "put 元素异常：" + e3.getMessage());
                }
                if (hfVar != null && hfVar.r() != null) {
                    Map<String, Object> r = hfVar.r();
                    if (r.containsKey(MediationConstant.KEY_USE_POLICY)) {
                        try {
                            jSONObject.putOpt("user_enter", r.get(MediationConstant.KEY_USE_POLICY));
                        } catch (Exception e4) {
                            com.bytedance.msdk.xj.kd.w.u("AdLoadEventManager", "put 元素异常：" + e4.getMessage());
                        }
                    }
                }
                map.put("dynamic_policy", jSONObject);
            }
        }
    }
}
