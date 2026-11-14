package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {
    private static hf c;
    private static hf f = new hf(null);
    private static hf hf;
    private static hf kd;
    private static hf u;
    private static hf w;
    private static hf xj;
    private static hf y;

    public static class hf {
        private int am;
        private int c;
        private w d;
        private int f;
        private int g;
        private int hf;
        private int kd;
        private boolean p;

        /* renamed from: pl, reason: collision with root package name */
        private xj f10402pl;
        private int tf;
        private int u;
        private int w;
        private int xj;
        private boolean y;

        public hf(JSONObject jSONObject) {
            this.p = false;
            this.g = 1;
            this.am = 0;
            if (jSONObject != null) {
                this.xj = jSONObject.optInt("get_type", 1);
                this.hf = jSONObject.optInt("max_count", 1);
                this.w = jSONObject.optInt("strategy_type", -1);
                this.u = jSONObject.optInt("store_type", 1);
                this.kd = jSONObject.optInt("online_timeout", 10000);
                this.y = jSONObject.optBoolean("enable", false);
                this.c = jSONObject.optInt("load_type", -1);
                this.f = jSONObject.optInt("trans_cache", 0);
                this.d = new w(jSONObject.optJSONObject("score_config"));
                this.tf = jSONObject.optInt("cache_check_type", 0);
                this.p = jSONObject.optBoolean("disable_sdk_bidding", false);
                this.f10402pl = new xj(jSONObject.optJSONObject("control_el"));
                this.g = jSONObject.optInt("ad_count_max", 1);
                this.am = jSONObject.optInt("ad_count_complement", 0);
            }
        }

        public boolean c() {
            return this.y;
        }

        public int d() {
            return this.f;
        }

        public int f() {
            return this.c;
        }

        public int hf() {
            return this.xj;
        }

        public int kd() {
            return this.u;
        }

        public int p() {
            return Math.max(this.g, 1);
        }

        public w tf() {
            return this.d;
        }

        public int u() {
            return this.w;
        }

        public int w() {
            if (this.hf <= 0) {
                this.hf = 1;
            }
            return this.hf;
        }

        public int y() {
            return this.kd;
        }

        public String xj() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("get_type", this.xj);
                jSONObject.put("max_count", this.hf);
                jSONObject.put("strategy_type", this.w);
                jSONObject.put("store_type", this.u);
                jSONObject.put("online_timeout", this.kd);
                jSONObject.put("enable", this.y);
                jSONObject.put("load_type", this.c);
                jSONObject.put("trans_cache", this.f);
                jSONObject.put("cache_check_type", this.tf);
                jSONObject.put("score_config", this.d.xj());
                jSONObject.put("disable_sdk_bidding", this.p);
                jSONObject.put("control_el", this.f10402pl.xj());
                jSONObject.put("ad_count_max", this.g);
                jSONObject.put("ad_count_complement", this.am);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        public boolean xj(ws wsVar) {
            Map<String, Object> pu;
            Object obj;
            return (!this.p || wsVar == null || (pu = wsVar.pu()) == null || pu.isEmpty() || (obj = pu.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) ? false : true;
        }

        public boolean xj(String str, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar) {
            xj xjVar = this.f10402pl;
            if (xjVar == null) {
                return false;
            }
            return xjVar.xj(str, hfVar, wsVar);
        }
    }

    public static class w {
        private int c;
        private int d;
        private int f;
        private int hf;
        private int kd;
        private int p;
        private int tf;
        private int u;
        private int w;
        private int xj;
        private LinkedHashMap<Integer, Integer> y;

        public w(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.xj = jSONObject.optInt("device_score_threshold", 0);
                this.hf = jSONObject.optInt("net_type_threshold", 0);
                this.w = jSONObject.optInt("base_score", 60);
                this.u = jSONObject.optInt("score_threshold", 60);
                this.kd = jSONObject.optInt("backup_score_threshold", 0);
                LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("last_cache_score");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        int optInt = optJSONArray2.optInt(0);
                        int optInt2 = optJSONArray2.optInt(1);
                        if (optInt > 0) {
                            linkedHashMap.put(Integer.valueOf(optInt), Integer.valueOf(optInt2));
                        }
                    }
                }
                this.y = linkedHashMap;
                this.c = jSONObject.optInt("freq_send_score", 0);
                this.f = jSONObject.optInt("freq_send_duration", 0);
                this.d = jSONObject.optInt("continuous_send_score", 0);
                this.tf = jSONObject.optInt("continuous_send_count", 0);
                this.p = jSONObject.optInt("show_score", 0);
            }
        }

        public int c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public int f() {
            return this.tf;
        }

        public int hf() {
            return this.xj;
        }

        public int kd() {
            return this.kd;
        }

        public int p() {
            return this.w;
        }

        public LinkedHashMap<Integer, Integer> pl() {
            return this.y;
        }

        public int tf() {
            return this.p;
        }

        public int u() {
            return this.u;
        }

        public int w() {
            return this.hf;
        }

        public JSONObject xj() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_score_threshold", this.xj);
                jSONObject.put("net_type_threshold", this.hf);
                jSONObject.put("base_score", this.w);
                jSONObject.put("score_threshold", this.u);
                jSONObject.put("backup_score_threshold", this.kd);
                JSONArray jSONArray = new JSONArray();
                LinkedHashMap<Integer, Integer> linkedHashMap = this.y;
                if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                    for (Integer num : this.y.keySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(num);
                        jSONArray2.put(this.y.get(num));
                        jSONArray.put(jSONArray2);
                    }
                }
                jSONObject.put("last_cache_score", jSONArray);
                jSONObject.put("freq_send_score", this.c);
                jSONObject.put("freq_send_duration", this.f);
                jSONObject.put("continuous_send_score", this.d);
                jSONObject.put("continuous_send_count", this.tf);
                jSONObject.put("show_score", this.p);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int y() {
            return this.f;
        }
    }

    public static class xj {
        private String hf;
        private String u;
        private String w;
        JSONObject xj;

        public xj(JSONObject jSONObject) {
            this.xj = jSONObject;
            if (jSONObject != null) {
                this.hf = jSONObject.optString("mix_ad");
                this.w = jSONObject.optString("disable_trans_cache");
                this.u = jSONObject.optString("delete_on_load");
            }
        }

        private boolean hf(String str, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar) {
            String str2;
            str.getClass();
            String str3 = null;
            switch (str) {
                case "delete_on_load":
                    str2 = this.u;
                    break;
                case "mix_ad":
                    if (!TextUtils.isEmpty(this.hf)) {
                        str2 = this.hf;
                        break;
                    } else {
                        str2 = "${(meta.group_info.group_id != null) || (meta.insert_ad_control == 1) || (meta.refresh_ad_control == 1) || (meta.force_refresh_ad_control == 1) || (meta.refresh_control == 1)}";
                        break;
                    }
                case "disable_trans_cache":
                    str2 = this.w;
                    break;
                default:
                    str2 = null;
                    break;
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            System.currentTimeMillis();
            try {
                str3 = com.bytedance.adsdk.ugeno.u.hf.xj(str2, xj(hfVar, wsVar, null, null));
            } catch (Exception unused) {
            }
            return TextUtils.equals(str3, "true");
        }

        public JSONObject xj() {
            return this.xj;
        }

        private JSONObject xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar, JSONObject jSONObject, JSONObject jSONObject2) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("adSlot", hfVar);
                if (wsVar != null) {
                    jSONObject3.put("meta", wsVar.ac());
                }
                jSONObject3.put("cache", jSONObject);
                jSONObject3.put("env", jSONObject2);
                return jSONObject3;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean xj(String str, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar) {
            return hf(str, hfVar, wsVar);
        }
    }

    static {
        LoKjoC();
    }

    private static /* synthetic */ void LoKjoC() {
        char[] charArray = "2><\u007f60<4\u007f3>(\u007f\"94==\u007f\u001b?8\u0013#8564".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Q');
        }
        String str = new String(charArray);
        char[] charArray2 = "2=8?8%".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Q');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static hf c() {
        hf hfVar = c;
        return hfVar == null ? new hf(new JSONObject()) : hfVar;
    }

    public static void hf(com.bytedance.sdk.component.u.hf.w wVar) {
        hf hfVar = xj;
        if (hfVar != null) {
            wVar.put("cache_strategy_reward", hfVar.xj());
        }
        hf hfVar2 = hf;
        if (hfVar2 != null) {
            wVar.put("cache_strategy_full", hfVar2.xj());
        }
        hf hfVar3 = u;
        if (hfVar3 != null) {
            wVar.put("cache_strategy_banner", hfVar3.xj());
        }
        hf hfVar4 = kd;
        if (hfVar4 != null) {
            wVar.put("cache_strategy_feed", hfVar4.xj());
        }
        hf hfVar5 = y;
        if (hfVar5 != null) {
            wVar.put("cache_strategy_draw", hfVar5.xj());
        }
        hf hfVar6 = c;
        if (hfVar6 != null) {
            wVar.put("cache_strategy_stream", hfVar6.xj());
        }
        if (w != null) {
            com.bytedance.sdk.openadsdk.core.w.u.xj().hf("cache_strategy_splash", w.xj());
        }
    }

    private static hf kd() {
        hf hfVar = kd;
        return hfVar == null ? new hf(new JSONObject()) : hfVar;
    }

    private static hf u() {
        hf hfVar = u;
        return hfVar == null ? new hf(new JSONObject()) : hfVar;
    }

    private static hf w() {
        hf hfVar = hf;
        return hfVar == null ? new hf(new JSONObject()) : hfVar;
    }

    public static void xj(com.bytedance.sdk.component.u.hf.w wVar) {
        try {
            xj = new hf(new JSONObject(wVar.get("cache_strategy_reward", "")));
        } catch (JSONException unused) {
        }
        try {
            hf = new hf(new JSONObject(wVar.get("cache_strategy_full", "")));
        } catch (JSONException unused2) {
        }
        try {
            u = new hf(new JSONObject(wVar.get("cache_strategy_banner", "")));
        } catch (JSONException unused3) {
        }
        try {
            kd = new hf(new JSONObject(wVar.get("cache_strategy_feed", "")));
        } catch (JSONException unused4) {
        }
        try {
            y = new hf(new JSONObject(wVar.get("cache_strategy_draw", "")));
        } catch (JSONException unused5) {
        }
        try {
            c = new hf(new JSONObject(wVar.get("cache_strategy_stream", "")));
        } catch (JSONException unused6) {
        }
    }

    private static hf y() {
        hf hfVar = y;
        return hfVar == null ? new hf(new JSONObject()) : hfVar;
    }

    public static hf xj() {
        if (w == null) {
            String w2 = com.bytedance.sdk.openadsdk.core.w.u.xj().w("cache_strategy_splash", (String) null);
            try {
                if (TextUtils.isEmpty(w2)) {
                    hf hfVar = new hf(new JSONObject());
                    w = hfVar;
                    hfVar.u = 0;
                } else {
                    w = new hf(new JSONObject(w2));
                }
            } catch (JSONException unused) {
            }
        }
        return w;
    }

    private static hf hf() {
        hf hfVar = xj;
        return hfVar == null ? new hf(new JSONObject()) : hfVar;
    }

    public static void xj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            try {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("cache_strategy_reward");
                if (optJSONObject2 != null) {
                    xj = new hf(optJSONObject2);
                }
            } catch (Exception unused) {
            }
            try {
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("cache_strategy_full");
                if (optJSONObject3 != null) {
                    hf = new hf(optJSONObject3);
                }
            } catch (Exception unused2) {
            }
            try {
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("cache_strategy_banner");
                if (optJSONObject4 != null) {
                    u = new hf(optJSONObject4);
                }
            } catch (Exception unused3) {
            }
            try {
                JSONObject optJSONObject5 = optJSONObject.optJSONObject("cache_strategy_feed");
                if (optJSONObject5 != null) {
                    kd = new hf(optJSONObject5);
                }
            } catch (Exception unused4) {
            }
            try {
                JSONObject optJSONObject6 = optJSONObject.optJSONObject("cache_strategy_draw");
                if (optJSONObject6 != null) {
                    y = new hf(optJSONObject6);
                }
            } catch (Exception unused5) {
            }
            try {
                JSONObject optJSONObject7 = optJSONObject.optJSONObject("cache_strategy_splash");
                if (optJSONObject7 != null) {
                    w = new hf(optJSONObject7);
                }
            } catch (Exception unused6) {
            }
            try {
                JSONObject optJSONObject8 = optJSONObject.optJSONObject("cache_strategy_stream");
                if (optJSONObject8 != null) {
                    c = new hf(optJSONObject8);
                }
            } catch (Exception unused7) {
            }
        }
    }

    public static hf xj(int i) {
        switch (i) {
            case 1:
                return u();
            case 2:
            default:
                return f;
            case 3:
            case 4:
                return xj();
            case 5:
                return kd();
            case 6:
                return c();
            case 7:
                return hf();
            case 8:
                return w();
            case 9:
                return y();
        }
    }
}
