package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ht {
    public Map<String, xj> xj = new HashMap();

    public static class xj {
        public String hf;
        public String u;
        public String w;
        public int xj;

        public xj(JSONObject jSONObject) {
            try {
                this.xj = jSONObject.optInt(PointParamKey.TYPE);
                this.hf = jSONObject.optString("url");
                this.w = jSONObject.optString("pid");
                this.u = jSONObject.optString("ecom_live_params");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }

        public boolean hf() {
            return 3 == this.xj ? !TextUtils.isEmpty(this.u) : !TextUtils.isEmpty(this.hf);
        }

        public JSONObject xj() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PointParamKey.TYPE, this.xj);
                jSONObject.put("url", this.hf);
                jSONObject.put("pid", this.w);
                jSONObject.put("ecom_live_params", this.u);
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ht(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("sub_convert_link");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    xj xjVar = new xj(optJSONObject.optJSONObject(next));
                    if (xjVar.hf()) {
                        this.xj.put(next, xjVar);
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public static int hf(ws wsVar, String str) {
        xj xjVar;
        ht xj2 = xj(wsVar);
        if (xj2 == null || (xjVar = xj2.xj.get(str)) == null) {
            return 0;
        }
        return xjVar.xj;
    }

    public static String kd(ws wsVar, String str) {
        xj xjVar;
        ht xj2 = xj(wsVar);
        return (xj2 == null || (xjVar = xj2.xj.get(str)) == null) ? "" : xjVar.u;
    }

    public static String u(ws wsVar, String str) {
        xj xjVar;
        ht xj2 = xj(wsVar);
        return (xj2 == null || (xjVar = xj2.xj.get(str)) == null) ? "" : xjVar.w;
    }

    public static String w(ws wsVar, String str) {
        xj xjVar;
        ht xj2 = xj(wsVar);
        return (xj2 == null || (xjVar = xj2.xj.get(str)) == null) ? "" : xjVar.hf;
    }

    public void xj(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, xj> entry : this.xj.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().xj());
            }
            jSONObject.put("sub_convert_link", jSONObject2);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    private static ht xj(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.aa();
    }

    public static boolean xj(ws wsVar, String str) {
        ht xj2 = xj(wsVar);
        return (xj2 == null || !xj2.xj.containsKey(str) || TextUtils.isEmpty(w(wsVar, str))) ? false : true;
    }
}
