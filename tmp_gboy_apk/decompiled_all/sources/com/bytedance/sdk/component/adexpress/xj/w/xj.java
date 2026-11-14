package com.bytedance.sdk.component.adexpress.xj.w;

import android.text.TextUtils;
import android.util.Pair;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private String hf;
    private hf kd;
    private List<C0107xj> u;
    private String w;
    private String xj;
    private Map<String, xj> y = new ConcurrentHashMap();

    public static class hf {
        private String hf;
        private List<Pair<String, String>> w;
        private String xj;

        public void hf(String str) {
            this.hf = str;
        }

        public String xj() {
            return this.xj;
        }

        public List<Pair<String, String>> hf() {
            return this.w;
        }

        public void xj(String str) {
            this.xj = str;
        }

        public void xj(List<Pair<String, String>> list) {
            this.w = list;
        }
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.xj.w.xj$xj, reason: collision with other inner class name */
    public static class C0107xj {
        private String hf;
        private int w;
        private String xj;

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0107xj)) {
                return super.equals(obj);
            }
            String str2 = this.xj;
            if (str2 != null) {
                C0107xj c0107xj = (C0107xj) obj;
                if (str2.equals(c0107xj.xj()) && (str = this.hf) != null && str.equals(c0107xj.hf())) {
                    return true;
                }
            }
            return false;
        }

        public String hf() {
            return this.hf;
        }

        public int w() {
            return this.w;
        }

        public String xj() {
            return this.xj;
        }

        public void hf(String str) {
            this.hf = str;
        }

        public void xj(String str) {
            this.xj = str;
        }

        public void xj(int i) {
            this.w = i;
        }
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", hf());
            jSONObject.putOpt("version", w());
            jSONObject.putOpt("main", u());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0107xj c0107xj : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0107xj.xj());
                    jSONObject2.putOpt(TKDownloadReason.KSAD_TK_MD5, c0107xj.hf());
                    jSONObject2.putOpt("level", Integer.valueOf(c0107xj.w()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.y.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.y.keySet()) {
                    xj xjVar = this.y.get(str);
                    if (xjVar != null) {
                        jSONObject3.put(str, xjVar.c());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            hf kd = kd();
            if (kd != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", kd.xj);
                jSONObject4.put(TKDownloadReason.KSAD_TK_MD5, kd.hf);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> hf2 = kd.hf();
                if (hf2 != null) {
                    for (Pair<String, String> pair : hf2) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String f() {
        JSONObject c;
        if (!y() || (c = c()) == null) {
            return null;
        }
        return c.toString();
    }

    public List<C0107xj> getResources() {
        if (this.u == null) {
            this.u = new ArrayList();
        }
        return this.u;
    }

    public String hf() {
        return this.xj;
    }

    public hf kd() {
        return this.kd;
    }

    public String u() {
        return this.w;
    }

    public String w() {
        return this.hf;
    }

    public Map<String, xj> xj() {
        return this.y;
    }

    public boolean y() {
        return (TextUtils.isEmpty(u()) || TextUtils.isEmpty(w()) || TextUtils.isEmpty(hf())) ? false : true;
    }

    public static xj u(String str) {
        if (str == null) {
            return null;
        }
        try {
            return xj(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public void hf(String str) {
        this.hf = str;
    }

    public void w(String str) {
        this.w = str;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public void xj(hf hfVar) {
        this.kd = hfVar;
    }

    public void xj(List<C0107xj> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.u = list;
    }

    public static xj xj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        xj xjVar = new xj();
        xjVar.xj(jSONObject.optString("name"));
        xjVar.hf(jSONObject.optString("version"));
        xjVar.w(jSONObject.optString("main"));
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                C0107xj c0107xj = new C0107xj();
                c0107xj.xj(optJSONObject2.optString("url"));
                c0107xj.hf(optJSONObject2.optString(TKDownloadReason.KSAD_TK_MD5));
                c0107xj.xj(optJSONObject2.optInt("level"));
                arrayList.add(c0107xj);
            }
        }
        xjVar.xj(arrayList);
        try {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("engines");
            if (optJSONObject3 != null) {
                Iterator<String> keys = optJSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    xj xj = xj(optJSONObject3.optJSONObject(next));
                    if (xj != null) {
                        xjVar.xj().put(next, xj);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (optJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            hf hfVar = new hf();
            hfVar.xj(optJSONObject.optString("url"));
            hfVar.hf(optJSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("map");
            if (optJSONObject4 != null) {
                Iterator<String> keys2 = optJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    arrayList2.add(new Pair(next2, optJSONObject4.optString(next2)));
                }
                hfVar.xj(arrayList2);
            }
            xjVar.xj(hfVar);
        }
        if (xjVar.y()) {
            return xjVar;
        }
        return null;
    }
}
