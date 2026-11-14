package com.bytedance.sdk.component.p.w;

import com.baidu.mobads.sdk.internal.cb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private String hf;
    private int w;
    private String xj;
    private final Map<String, String> u = new HashMap();
    private List<C0116xj> kd = new ArrayList();
    private final List<C0116xj> y = new ArrayList();
    private final List<C0116xj> c = new ArrayList();

    /* renamed from: com.bytedance.sdk.component.p.w.xj$xj, reason: collision with other inner class name */
    public static class C0116xj {
        private String hf;
        private String xj;

        public C0116xj(String str, String str2) {
            this.xj = str;
            this.hf = str2;
        }

        public String hf() {
            return this.hf;
        }

        public String xj() {
            return this.xj;
        }
    }

    public xj(JSONObject jSONObject) {
        xj(jSONObject);
    }

    public String hf() {
        return this.hf;
    }

    public List<C0116xj> kd() {
        return this.y;
    }

    public List<C0116xj> u() {
        return this.kd;
    }

    public Map<String, String> w() {
        return this.u;
    }

    public String xj() {
        return this.xj;
    }

    public List<C0116xj> y() {
        return this.c;
    }

    public void xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.xj = jSONObject.optString("name");
        this.w = jSONObject.optInt("index");
        this.hf = jSONObject.optString("scheme");
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.u.put(next, optJSONObject.optString(next));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("next");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    this.kd.add(new C0116xj(optJSONObject2.optString("name"), optJSONObject2.optString("condition")));
                }
            }
        } else {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("next");
            if (optJSONObject3 != null) {
                this.kd.add(new C0116xj(optJSONObject3.optString("name"), optJSONObject3.optString("condition")));
            }
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("callback");
        if (optJSONObject4 == null) {
            optJSONObject4 = new JSONObject();
        }
        JSONArray optJSONArray2 = optJSONObject4.optJSONArray(cb.o);
        if (optJSONArray2 == null) {
            optJSONArray2 = new JSONArray();
        }
        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
            JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i2);
            if (optJSONObject5 != null) {
                this.y.add(new C0116xj(optJSONObject5.optString("name"), optJSONObject5.optString("condition")));
            }
        }
        JSONArray optJSONArray3 = optJSONObject4.optJSONArray("fail");
        if (optJSONArray3 == null) {
            optJSONArray3 = new JSONArray();
        }
        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
            JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i3);
            if (optJSONObject6 != null) {
                this.c.add(new C0116xj(optJSONObject6.optString("name"), optJSONObject6.optString("condition")));
            }
        }
    }
}
