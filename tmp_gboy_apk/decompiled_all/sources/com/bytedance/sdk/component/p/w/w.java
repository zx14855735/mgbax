package com.bytedance.sdk.component.p.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.p.w.xj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private String hf;
    private xj kd;
    private final Map<String, xj> u = new HashMap();
    private boolean w;
    private String xj;
    private JSONObject y;

    public w(JSONObject jSONObject) {
        this.w = false;
        String next = jSONObject.keys().next();
        this.hf = next;
        JSONObject optJSONObject = jSONObject.optJSONObject(next);
        this.xj = optJSONObject.optString("version");
        boolean optBoolean = optJSONObject.optBoolean("lazyLoad");
        this.w = optBoolean;
        if (optBoolean) {
            this.y = optJSONObject;
        } else {
            xj(optJSONObject);
        }
    }

    private void xj(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("events");
        for (int i = 0; i < optJSONArray.length(); i++) {
            xj xjVar = new xj(optJSONArray.optJSONObject(i));
            this.u.put(xjVar.xj(), xjVar);
            if (xjVar.xj().equals(jSONObject.optString("main"))) {
                this.kd = xjVar;
            }
        }
    }

    public String hf() {
        return this.hf;
    }

    public List<xj> w(xj xjVar, JSONObject jSONObject, Map<String, Object> map) {
        List<xj.C0116xj> u = xjVar.u();
        ArrayList arrayList = new ArrayList();
        for (xj.C0116xj c0116xj : u) {
            if (c0116xj != null && xj(c0116xj.hf(), jSONObject, map)) {
                arrayList.add(xj(c0116xj.xj()));
            }
        }
        return arrayList;
    }

    public List<xj> hf(xj xjVar, JSONObject jSONObject, Map<String, Object> map) {
        return xj(jSONObject, map, xjVar.y());
    }

    public xj xj(String str) {
        if (this.w) {
            xj(this.y);
        }
        return this.u.get(str);
    }

    public xj xj() {
        if (this.w) {
            xj(this.y);
        }
        return this.kd;
    }

    public List<xj> xj(xj xjVar, JSONObject jSONObject, Map<String, Object> map) {
        return xj(jSONObject, map, xjVar.kd());
    }

    private List<xj> xj(JSONObject jSONObject, Map<String, Object> map, List<xj.C0116xj> list) {
        xj xj;
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            for (xj.C0116xj c0116xj : list) {
                if (c0116xj != null && (xj = xj(c0116xj.xj())) != null && xj(c0116xj.hf(), jSONObject, map)) {
                    arrayList.add(xj);
                }
            }
        }
        return arrayList;
    }

    private static boolean xj(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return true;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject.put(key, entry.getValue());
                }
            }
            if (str.startsWith("${") && str.endsWith("}")) {
                return Boolean.parseBoolean(com.bytedance.adsdk.hf.hf.xj.xj(str.substring(2, str.length() - 1)).xj(jSONObject).toString());
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
