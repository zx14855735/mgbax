package com.bytedance.msdk.xj.w;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cn;
import com.bytedance.msdk.api.u.tf;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.w.hf;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static long hf(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get(MediationConstant.EXTRA_ADID) != null) {
                return ((Long) map.get(MediationConstant.EXTRA_ADID)).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            pl.xj(th);
            return 0L;
        }
    }

    public static String w(Map<String, Object> map) {
        if (map == null || map.get(PointParamKey.REQUEST_ID) == null) {
            return null;
        }
        return (String) map.get(PointParamKey.REQUEST_ID);
    }

    public static boolean xj(String str) {
        String w = w();
        return (TextUtils.isEmpty(w) || TextUtils.isEmpty(str) || w.compareTo(str) < 0) ? false : true;
    }

    public static JSONArray w(String str) {
        JSONArray jSONArray;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(str);
            }
        } catch (Exception e) {
            pl.xj(e);
            jSONArray = null;
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static void hf(String str) {
        tf.hf(str);
    }

    public static String xj(String str, String str2, String str3) {
        JSONArray jSONArray;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONArray = new JSONArray(str);
                    } catch (JSONException unused) {
                        jSONArray = new JSONArray();
                    }
                } else {
                    jSONArray = new JSONArray();
                }
                int i = 0;
                while (true) {
                    if (i < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null && str2.equals(optJSONObject.getString("name"))) {
                            optJSONObject.put("value", str3);
                            break;
                        }
                        i++;
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", str2);
                        jSONObject.put("value", str3);
                        jSONArray.put(jSONObject);
                        break;
                    }
                }
                return jSONArray.toString();
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        return str;
    }

    private static Map<String, String> hf() {
        return tf.f();
    }

    private static JSONArray hf(com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar) {
        if (xjVar == null || TextUtils.isEmpty(xjVar.ht())) {
            return null;
        }
        try {
            return new JSONArray(xjVar.ht());
        } catch (Throwable th) {
            pl.xj(th);
            return null;
        }
    }

    private static String w() {
        try {
            return com.bytedance.sdk.gromore.init.xj.w();
        } catch (Throwable unused) {
            return cn.d;
        }
    }

    public static double xj(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Float) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        try {
            if (obj instanceof String) {
                return Double.valueOf((String) obj).doubleValue();
            }
            return 0.0d;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static long xj(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get("creative_id") != null) {
                return ((Long) map.get("creative_id")).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            pl.xj(th);
            return 0L;
        }
    }

    public static String xj() {
        return tf.c();
    }

    public static JSONArray xj(com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar) {
        JSONArray w = w(xj());
        try {
            Map<String, String> hf = hf();
            if (hf != null && hf.size() > 0) {
                for (String str : hf.keySet()) {
                    String str2 = hf.get(str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("name", str);
                        jSONObject.putOpt("value", str2);
                        w.put(jSONObject);
                    }
                }
            }
            JSONArray hf2 = hf(xjVar);
            if (hf2 != null) {
                for (int i = 0; i < hf2.length(); i++) {
                    JSONObject optJSONObject = hf2.optJSONObject(i);
                    if (optJSONObject != null && !TextUtils.equals("personal_ads_type", optJSONObject.optString("name"))) {
                        w.put(optJSONObject);
                    }
                }
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        return w;
    }

    private static void xj(hf.xj xjVar, String str, String str2, boolean z, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar2) {
        JSONObject jSONObject;
        JSONArray xj = xj(xjVar2);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("name", "mediation_sdk_version");
            jSONObject2.putOpt("value", com.bytedance.msdk.hf.hf.hf());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("name", "mediation_req_type");
            jSONObject3.putOpt("value", "1");
            if (TextUtils.isEmpty(str)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                jSONObject.putOpt("name", "waterfall_abtest");
                jSONObject.putOpt("value", str);
            }
            xj.put(jSONObject3);
            xj.put(jSONObject2);
            if (jSONObject != null) {
                xj.put(jSONObject);
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("name", "m_req_id");
                jSONObject4.putOpt("value", str2);
                xj.put(jSONObject4);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        if (!z) {
            xj(xjVar);
        }
        com.bytedance.sdk.gromore.init.xj.xj(tf.y());
        if (xjVar != null) {
            xjVar.d(xj.toString());
        }
    }

    public static void xj(hf.xj xjVar) {
        if (xjVar != null && tf.d()) {
            try {
                String w = tf.w("tt_pangle_preview_ad_id");
                String w2 = tf.w("tt_pangle_preview_creative_id");
                String w3 = tf.w("tt_pangle_preview_ext");
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "pangle preview adId:" + w + " creativeId:" + w2 + " ext" + w3);
                if (!TextUtils.isEmpty(w) && !TextUtils.isEmpty(w2)) {
                    xjVar.xj(w).hf(w2);
                }
                if (TextUtils.isEmpty(w3)) {
                    return;
                }
                xjVar.w(w3);
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
    }

    public static hf.xj xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.w.y.hf.hf hfVar2, boolean z) {
        return xj(hfVar, hfVar2.pl(), hfVar2.zg(), hfVar2.e(), hfVar2.et(), z);
    }

    public static hf.xj xj(com.bytedance.msdk.api.xj.hf hfVar, String str, String str2, String str3, String str4, boolean z) {
        com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar;
        hf.xj w = new hf.xj().u(str).w(1);
        if (hfVar != null) {
            w.y(hfVar.hf()).c(hfVar.ra()).hf(hfVar.ai());
            xjVar = hfVar.pz();
            if (xjVar != null) {
                w.y(xjVar.am()).xj(xjVar.kd()).u(xjVar.io()).xj(xjVar.xj()).hf(xjVar.hf()).u(xjVar.qt()).xj(xjVar.ra()).kd(xjVar.g()).w(xjVar.w());
                String v = xjVar.v();
                if (!TextUtils.isEmpty(v)) {
                    w.c(v);
                }
                if (xjVar.yo() != 0) {
                    w.y(xjVar.yo());
                }
            }
            int[] xj = xj(hfVar, xjVar);
            if (xj != null && xj.length > 0) {
                w.xj(xj);
            }
            if (5 == hfVar.ht() || 9 == hfVar.ht()) {
                w.w(hfVar.x());
            }
        } else {
            xjVar = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            w.f(str4);
        }
        xj(w, str2, str3, z, xjVar);
        return w;
    }

    private static int[] xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar) {
        if (xjVar != null && xjVar.e() != null && xjVar.e().length > 0) {
            return xjVar.e();
        }
        try {
            Map<String, Object> r = hfVar.r();
            if (r != null) {
                return (int[]) r.get(MediationConstant.PANGLE_VID);
            }
            return null;
        } catch (Throwable th) {
            pl.xj(th);
            return null;
        }
    }

    public static boolean xj(com.bytedance.msdk.api.xj.hf hfVar) {
        if (hfVar != null && hfVar.r() != null) {
            Object obj = hfVar.r().get(MediationConstant.BANNER_AUTO_HEIGHT);
            try {
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
