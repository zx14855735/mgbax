package com.bytedance.msdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends xj {
    private static volatile hf u;
    protected final Map<String, String> w;

    private hf() {
        super("label_v_v_s_3");
        this.w = new ConcurrentHashMap();
        hf();
    }

    public static hf u() {
        if (u == null) {
            synchronized (hf.class) {
                try {
                    if (u == null) {
                        u = new hf();
                    }
                } finally {
                }
            }
        }
        return u;
    }

    @Override // com.bytedance.msdk.core.d.xj
    public boolean hf(String str, JSONObject jSONObject, Map<String, Object> map) {
        try {
            Object obj = map.get("user_label_value");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", xj(obj != null ? (com.bytedance.msdk.core.tf.w) obj : null));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.hf.hf().dc()));
            jSONObject2.putOpt("rule_id", map.get("rule_id"));
            jSONObject2.putOpt("group_type", map.get("group_type"));
            jSONObject2.putOpt("rule_in_use", map.get("rule_in_use"));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("ecpm", map.get("ecpm"));
            jSONObject3.putOpt("timestamp", String.valueOf(System.currentTimeMillis()));
            jSONObject2.putOpt("ecpm_info", jSONObject3);
            jSONObject2.putOpt("refresh_time", map.get("refresh_time"));
            return true;
        } catch (JSONException e) {
            pl.xj(e);
            return false;
        }
    }

    public void w(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.bytedance.msdk.core.hf.hf().vm() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.putOpt("rule_id", map.get("rule_id"));
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    public void xj(String str, int i, double d) {
        if (!com.bytedance.msdk.core.hf.hf().vm() || TextUtils.isEmpty(str)) {
            return;
        }
        xj(3, str, i, d);
    }

    @Override // com.bytedance.msdk.core.d.xj
    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf("DynamicLabelValueManagerAbs", "readCacheFromSp-SP_NAME_V3，cpmKey:" + str + "，type_value_timestamp:" + str2);
        if (str.startsWith("cpm_key_")) {
            this.w.put(str, str2);
        }
    }

    @Override // com.bytedance.msdk.core.d.xj
    public Map<String, String> xj() {
        return this.w;
    }

    @Override // com.bytedance.msdk.core.d.xj
    public void xj(String str, int i, String str2) {
        if (i == 3) {
            this.w.put(str, str2);
        }
    }

    @Override // com.bytedance.msdk.core.d.xj
    public JSONObject xj(com.bytedance.msdk.core.tf.w wVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", wVar != null ? wVar.xj() : "-1");
            jSONObject.putOpt("label_id", wVar != null ? Integer.valueOf(wVar.w()) : "-1");
            jSONObject.putOpt("label_version", wVar != null ? wVar.u() : "-1");
            return jSONObject;
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }
}
