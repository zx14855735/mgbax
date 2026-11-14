package com.bytedance.msdk.kd;

import android.text.TextUtils;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.dk;
import com.bytedance.msdk.f.l;
import com.bytedance.msdk.f.ra;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bytedance.sdk.component.f.hf.u.xj.hf {
    public static final String w = UUID.randomUUID().toString();
    public final JSONObject hf;
    public final String xj;

    static {
        SeAbnQ();
    }

    public xj(String str, JSONObject jSONObject) {
        this.xj = str;
        this.hf = jSONObject;
    }

    private static /* synthetic */ void SeAbnQ() {
        char[] charArray = "ðüþ½ôòþö½ñüê½àûöÿÿ½ÙýúÑáú÷ôö".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 147);
        }
        String str = new String(charArray);
        char[] charArray2 = "ðÿúýúç".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 147);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void w(JSONObject jSONObject, u uVar) {
        if (jSONObject == null || uVar == null) {
            return;
        }
        if ("media_fill_fail".equals(uVar.xj) || "media_fill".equals(uVar.xj) || "bidding_adm_load".equals(uVar.xj) || "bidding_adm_load_fail".equals(uVar.xj) || "mediation_fill".equals(uVar.xj) || "mediation_request_end".equals(uVar.xj) || "mediation_video_cached".equals(uVar.xj) || "get_config_final".equals(uVar.xj) || "sdk_init_end".equals(uVar.xj) || "sdk_backstage".equals(uVar.xj) || "mediation_request".equals(uVar.xj) || "rit_map_query".equals(uVar.xj) || "return_bidding_result".equals(uVar.xj)) {
            jSONObject.putOpt(MediationConstant.EXTRA_DURATION, Long.valueOf(uVar.yo));
        }
    }

    @Override // com.bytedance.sdk.component.f.hf.u.xj.hf
    public long hf() {
        JSONObject jSONObject = this.hf;
        if (jSONObject == null) {
            return 0L;
        }
        JSONObject optJSONObject = jSONObject.has("params") ? this.hf.optJSONObject("params") : this.hf;
        if (optJSONObject == null) {
            return 0L;
        }
        String optString = optJSONObject.optString("event_extra");
        if (TextUtils.isEmpty(optString)) {
            return 0L;
        }
        try {
            return new JSONObject(optString).optLong("eventIndex");
        } catch (JSONException unused) {
            return 0L;
        }
    }

    public String toString() {
        return "AdEvent{localId='" + this.xj + "', event=" + this.hf + '}';
    }

    @Override // com.bytedance.sdk.component.f.hf.u.xj.hf
    public JSONObject xj(String str) {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.f.hf.u.xj.hf
    public long xj() {
        JSONObject jSONObject = this.hf;
        if (jSONObject == null) {
            return 0L;
        }
        JSONObject optJSONObject = jSONObject.has("params") ? this.hf.optJSONObject("params") : this.hf;
        if (optJSONObject != null) {
            return optJSONObject.optLong("timestamp");
        }
        return 0L;
    }

    public static JSONObject xj(u uVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("device_info", ra.xj());
            if (uVar != null) {
                jSONObject2.putOpt(PointParamKey.TYPE, uVar.xj);
                jSONObject2.putOpt("link_id", uVar.hf);
                jSONObject2.putOpt(MediationConstant.EXTRA_ADN_NAME, uVar.w);
                jSONObject2.putOpt("ad_sdk_version", uVar.u);
                jSONObject2.putOpt("rit_cpm", uVar.c);
                jSONObject2.putOpt("mediation_rit", uVar.y);
                jSONObject2.putOpt("adtype", Integer.valueOf(uVar.e));
                jSONObject2.putOpt("error_msg", uVar.p);
                jSONObject2.putOpt("error_code", Integer.valueOf(uVar.am));
                jSONObject2.putOpt("creative_id", uVar.f10147pl);
                jSONObject2.putOpt("exchange_rate", uVar.pz);
                jSONObject2.putOpt("msdk_session_id", w);
                jSONObject2.putOpt("is_trusteeship_monetize", Integer.valueOf(com.bytedance.msdk.core.hf.hf().xj()));
                String hf = com.bytedance.msdk.core.p.xj.xj().hf(com.bytedance.msdk.core.hf.hf().g());
                if (hf != null) {
                    jSONObject2.putOpt("app_abtest", hf);
                }
                xj(jSONObject2, uVar);
                w(jSONObject2, uVar);
                hf(uVar, jSONObject);
                if (!"total_load_fail".equalsIgnoreCase(uVar.xj) && !"adapter_request_fail".equalsIgnoreCase(uVar.xj)) {
                    jSONObject2.putOpt("req_id", TextUtils.isEmpty(uVar.kd) ? uVar.hf + "_" + uVar.y : uVar.kd);
                }
                jSONObject2.putOpt("country", com.bytedance.msdk.core.hf.hf().f());
                com.bytedance.msdk.core.tf.xj xj = com.bytedance.msdk.core.hf.hf().xj(MediationConstant.ADN_PANGLE);
                if (xj != null) {
                    jSONObject2.putOpt(PluginConstants.KEY_APP_ID, xj.hf());
                } else {
                    jSONObject2.putOpt(PluginConstants.KEY_APP_ID, com.bytedance.msdk.core.xj.p().pl());
                }
                long j = uVar.d;
                if (j != 0) {
                    jSONObject2.putOpt("waterfall_id", Long.valueOf(j));
                }
                if (!TextUtils.isEmpty(uVar.tf)) {
                    jSONObject2.putOpt("version", uVar.tf);
                }
                Map<String, Object> map = uVar.ht;
                if (map != null && map.size() > 0) {
                    for (String str : uVar.ht.keySet()) {
                        Object obj = uVar.ht.get(str);
                        if (!TextUtils.isEmpty(str) && obj != null) {
                            jSONObject2.putOpt(str, obj);
                        }
                    }
                }
            }
            jSONObject2.putOpt("event_extra", jSONObject != null ? jSONObject.toString() : null);
            jSONObject2.putOpt(n.r, l.w());
            jSONObject2.putOpt("conn_type", Integer.valueOf(dk.kd()));
            hf(jSONObject2, uVar);
            jSONObject2.putOpt("mediation_sdk_version", com.bytedance.msdk.hf.hf.hf());
            jSONObject2.putOpt(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.hf.hf.u());
            try {
                jSONObject2.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.x.xj.xj().xj("DeviceRate", "bytebench_value")));
                return jSONObject2;
            } catch (NumberFormatException unused) {
                jSONObject2.put("device_score", -1);
                return jSONObject2;
            }
        } catch (Throwable th) {
            try {
                xj(jSONObject2, th, uVar);
            } catch (Throwable unused2) {
            }
        }
    }

    private static void hf(JSONObject jSONObject, u uVar) {
        if (jSONObject == null || uVar == null) {
            jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            return;
        }
        if (TextUtils.equals(uVar.xj, "sdk_init")) {
            jSONObject.putOpt("timestamp", Long.valueOf(com.bytedance.msdk.api.u.tf.hf()));
            return;
        }
        if (TextUtils.equals(uVar.xj, "start_up")) {
            jSONObject.putOpt("timestamp", Long.valueOf(com.bytedance.msdk.api.u.tf.w()));
        } else if (uVar.xj() != -1) {
            jSONObject.putOpt("timestamp", Long.valueOf(uVar.xj()));
        } else {
            jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        }
    }

    public String w() {
        if (TextUtils.isEmpty(this.xj) || this.hf == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("localId", this.xj);
            jSONObject.putOpt("event", this.hf);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    private static void hf(u uVar, JSONObject jSONObject) {
        if (uVar != null) {
            if ("media_request".equals(uVar.xj) || "media_fill".equals(uVar.xj) || "media_fill_fail".equals(uVar.xj) || "get_bidding_adm_to_adn".equals(uVar.xj) || "bidding_adm_load".equals(uVar.xj) || "bidding_adm_load_fail".equals(uVar.xj) || "bidding_win_event".equals(uVar.xj) || "media_show_is_ready".equals(uVar.xj) || "media_will_show".equals(uVar.xj) || "media_show".equals(uVar.xj) || "media_show_fail".equals(uVar.xj) || "media_show_listen".equals(uVar.xj) || "media_show_fail_listen".equals(uVar.xj) || "media_click_listen".equals(uVar.xj) || "sdk_init".equals(uVar.xj) || "sdk_init_end".equals(uVar.xj) || "get_config_start".equals(uVar.xj) || "get_config_final".equals(uVar.xj) || "mediation_request".equals(uVar.xj) || "mediation_fill".equals(uVar.xj) || "mediation_request_end".equals(uVar.xj) || "total_load_fail".equals(uVar.xj)) {
                uVar.xj("grouping_params", com.bytedance.msdk.core.am.hf.hf());
                JSONObject w2 = com.bytedance.msdk.core.am.hf.w();
                if (w2 != null) {
                    uVar.xj("user_defined_grouping_params", w2.toString());
                } else {
                    uVar.xj("user_defined_grouping_params", null);
                }
                com.bytedance.msdk.core.d.u.xj(uVar.f, uVar.xj, uVar.e, jSONObject);
            }
        }
    }

    private static void xj(JSONObject jSONObject, u uVar) {
        if (jSONObject == null || uVar == null) {
            return;
        }
        int i = uVar.v;
        if (i != -1) {
            jSONObject.putOpt("result", Integer.valueOf(i));
        }
        int i2 = uVar.jk;
        if (i2 != -1) {
            jSONObject.putOpt("status_code", Integer.valueOf(i2));
        }
        String str = uVar.zg;
        if (str != null) {
            jSONObject.putOpt("show_sort", str);
        }
        String str2 = uVar.qt;
        if (str2 != null) {
            jSONObject.putOpt("load_sort", str2);
        }
        String str3 = uVar.g;
        if (str3 != null) {
            jSONObject.putOpt("req_bidding_type", str3);
        }
        jSONObject.putOpt(MediationConstant.KEY_GM_PRIME_RIT, uVar.f);
    }

    private static void xj(JSONObject jSONObject, Throwable th, u uVar) {
        if (jSONObject != null && th != null) {
            String optString = jSONObject.optString("event_extra");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                jSONObject2.putOpt("err_msg_comm", th.toString());
                jSONObject.putOpt("event_extra", jSONObject2.toString());
            }
        }
        if (uVar == null || th == null) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.putOpt("comm_eventId", uVar.ht.get("event_id"));
        jSONObject3.putOpt("err_msg_comm", th.toString());
        ai.xj(jSONObject3);
    }
}
