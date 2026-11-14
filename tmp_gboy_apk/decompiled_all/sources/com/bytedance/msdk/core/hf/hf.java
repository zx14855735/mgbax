package com.bytedance.msdk.core.hf;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import com.bytedance.msdk.f.pz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private final Map<String, Float> hf = new ConcurrentHashMap();
    private final Map<String, u> w = new ConcurrentHashMap();
    private int xj;

    public hf(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            this.xj = jSONObject.optInt("lt_days");
            JSONObject optJSONObject = jSONObject.optJSONObject("estimate");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.hf.put(next, Float.valueOf((float) optJSONObject.optDouble(next)));
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rule_excs");
            if (optJSONObject2 == null || optJSONObject2.length() == 0) {
                return;
            }
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next2);
                if (optJSONObject3 != null && (optJSONArray = optJSONObject3.optJSONArray("prime_rits")) != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        this.w.put(optString, new u(next2, optString, optJSONObject3));
                    }
                }
            }
        }
    }

    public u hf(String str) {
        return this.w.get(str);
    }

    public String w(String str) {
        u hf;
        if (str == null || (hf = hf(str)) == null) {
            return null;
        }
        return hf.xj();
    }

    public JSONObject xj(String str, pz pzVar) {
        kd kdVar;
        if (!com.bytedance.msdk.core.hf.hf().wo() || str == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        float xj = xj(str);
        u uVar = this.w.get(str);
        if (uVar != null) {
            Map<String, kd> kd = uVar.kd();
            String[] w = uVar.w();
            if (kd != null && !kd.isEmpty() && w != null && w.length > 0) {
                for (String str2 : w) {
                    if (!TextUtils.isEmpty(str2) && (kdVar = kd.get(str2)) != null) {
                        try {
                            jSONObject.putOpt(str2, Integer.valueOf(kdVar.xj(xj)));
                        } catch (Exception e) {
                            StringBuilder BChYOn2 = A2egSU.BChYOn("calculateRangeByScore计算异常：(tableName：", str2, ",primeRit:", str, "），");
                            BChYOn2.append(e.getMessage());
                            com.bytedance.msdk.xj.kd.w.u("", BChYOn2.toString());
                        }
                    }
                }
            }
        }
        pzVar.put(MediationConstant.KEY_GM_POLICY, jSONObject);
        pzVar.put("adl_scr", Float.valueOf(xj));
        com.bytedance.msdk.core.xj.p().xj(str, xj);
        return jSONObject;
    }

    public float xj(String str) {
        u uVar = this.w.get(str);
        float f = -1.0f;
        if (uVar != null) {
            Map<String, Float> hf = uVar.hf();
            String u = uVar.u();
            if (hf != null) {
                if (hf.containsKey("lt_x_times")) {
                    Float f2 = hf.get("lt_x_times");
                    int hf2 = xj.hf();
                    if (f2 != null) {
                        f = xj(u, f2.floatValue() * hf2, -1.0f);
                    }
                }
                if (hf.containsKey("active_duration")) {
                    Float f3 = hf.get("active_duration");
                    long y = xj.y();
                    if (f3 != null) {
                        f = xj(u, f3.floatValue() * y, f);
                    }
                }
                if (hf.containsKey("active_count")) {
                    Float f4 = hf.get("active_count");
                    int u2 = xj.u();
                    if (f4 != null) {
                        f = xj(u, f4.floatValue() * u2, f);
                    }
                }
                if (hf.containsKey("show_period")) {
                    Float f5 = hf.get("show_period");
                    long f6 = xj.f(str);
                    if (f5 != null) {
                        f = xj(u, f5.floatValue() * f6, f);
                    }
                }
                if (hf.containsKey("show_count")) {
                    Float f7 = hf.get("show_count");
                    int u3 = xj.u(str);
                    if (f7 != null) {
                        f = xj(u, f7.floatValue() * u3, f);
                    }
                }
                if (hf.containsKey("dislike_count")) {
                    Float f8 = hf.get("dislike_count");
                    int hf3 = xj.hf(str);
                    if (f8 != null) {
                        f = xj(u, f8.floatValue() * hf3, f);
                    }
                }
                if (hf.containsKey("click_count")) {
                    Float f9 = hf.get("click_count");
                    int y2 = xj.y(str);
                    if (f9 != null) {
                        f = xj(u, f9.floatValue() * y2, f);
                    }
                }
                if (hf.containsKey("install_days")) {
                    Float f10 = hf.get("install_days");
                    int kd = xj.kd();
                    if (f10 != null) {
                        f = xj(u, f10.floatValue() * kd, f);
                    }
                }
                if (!this.hf.isEmpty()) {
                    for (Map.Entry<String, Float> entry : this.hf.entrySet()) {
                        if (entry != null) {
                            String key = entry.getKey();
                            float floatValue = entry.getValue().floatValue();
                            Float f11 = hf.get(key);
                            if (f11 != null) {
                                f = xj(u, f11.floatValue() * floatValue, f);
                            }
                        }
                    }
                }
            }
        }
        return f;
    }

    private float xj(String str, float f, float f2) {
        if (f2 == -1.0f) {
            return f;
        }
        str.getClass();
        switch (str) {
            case "*":
                return f2 * f;
            case "+":
                return f2 + f;
            case "max":
                return Math.max(f, f2);
            case "min":
                return Math.min(f, f2);
            default:
                return f2;
        }
    }

    public int xj() {
        return this.xj;
    }
}
