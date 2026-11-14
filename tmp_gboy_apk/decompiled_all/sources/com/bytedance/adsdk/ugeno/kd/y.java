package com.bytedance.adsdk.ugeno.kd;

import io.dcloud.openapi.core.util.Const;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private List<xj> hf;
    private xj xj;

    public static class xj {
        private String hf;
        private Map<String, String> kd;
        private String u;
        private String w = Const.PROVIDER_TYPE_GLOBAL;
        private String xj;
        private Map<String, Object> y;

        public String hf() {
            return this.u;
        }

        public String kd() {
            return this.hf;
        }

        public String toString() {
            return "Action{scheme='" + this.w + "', name='" + this.u + "', params=" + this.kd + ", host='" + this.hf + "', origin='" + this.xj + "', extra=" + this.y + '}';
        }

        public String u() {
            return this.xj;
        }

        public Map<String, String> w() {
            return this.kd;
        }

        public String xj() {
            return this.w;
        }

        public void hf(String str) {
            this.u = str;
        }

        public void u(String str) {
            this.hf = str;
        }

        public void w(String str) {
            this.xj = str;
        }

        public void xj(String str) {
            this.w = str;
        }

        public void xj(Map<String, String> map) {
            this.kd = map;
        }
    }

    public List<xj> hf() {
        return this.hf;
    }

    public xj xj() {
        return this.xj;
    }

    public static y xj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        y yVar = new y();
        String optString = jSONObject.optString("on");
        JSONArray optJSONArray = jSONObject.optJSONArray("handlers");
        yVar.xj = pl.xj(optString, jSONObject2);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            xj xj2 = pl.xj(optJSONArray.optString(i), jSONObject2);
            if (xj2 != null) {
                arrayList.add(xj2);
            }
        }
        yVar.hf = arrayList;
        return yVar;
    }
}
