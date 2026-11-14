package com.ss.android.downloadlib.addownload.compliance;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.sigmob.sdk.base.n;
import com.ss.android.downloadlib.c.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd {
    private hf am;
    private String c;
    private int d;
    private String f;
    private String g;
    private xj hf;
    private int kd = 15;
    private long p;

    /* renamed from: pl, reason: collision with root package name */
    private String f13830pl;
    private String qt;
    private String tf;
    private int u;
    private int w;
    private boolean xj;
    private int y;

    public static class hf {
        private String hf;
        private int xj;

        public void xj(int i) {
            this.xj = i;
        }

        public void xj(String str) {
            this.hf = str;
        }
    }

    public static class xj {
        private List<C0466xj> c;
        private String d;
        private String f;
        private String hf;
        private String kd;
        private String p;

        /* renamed from: pl, reason: collision with root package name */
        private String f13831pl;
        private String tf;
        private long u;
        private long w;
        private String xj;
        private String y;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.kd$xj$xj, reason: collision with other inner class name */
        public static class C0466xj {
            private String hf;
            private String xj;

            public void hf(String str) {
                this.hf = str;
            }

            public void xj(String str) {
                this.xj = str;
            }
        }

        public void c(String str) {
            this.tf = str;
        }

        public void d(String str) {
            this.f13831pl = str;
        }

        public void f(String str) {
            this.p = str;
        }

        public void hf(String str) {
            this.hf = str;
        }

        public void kd(String str) {
            this.f = str;
        }

        public void u(String str) {
            this.y = str;
        }

        public void w(String str) {
            this.kd = str;
        }

        public void xj(String str) {
            this.xj = str;
        }

        public void y(String str) {
            this.d = str;
        }

        public void hf(long j) {
            this.u = j;
        }

        public void xj(long j) {
            this.w = j;
        }

        public void xj(List<C0466xj> list) {
            this.c = list;
        }
    }

    public static kd c(String str) {
        kd kdVar = new kd();
        try {
            JSONObject jSONObject = new JSONObject(str);
            xj xj2 = xj(jSONObject);
            hf hf2 = hf(jSONObject);
            kdVar.xj(xj2);
            kdVar.xj(hf2);
            kdVar.xj(jSONObject.optInt("show_auth", 0) == 1);
            kdVar.xj(jSONObject.optInt("download_permit"));
            kdVar.hf(jSONObject.optInt("appstore_permit"));
            kdVar.w(jSONObject.optInt("market_online_status", 15));
            kdVar.u(jSONObject.optInt("hijack_permit"));
            kdVar.xj(jSONObject.optString(n.p));
            kdVar.hf(jSONObject.optString("hijack_url"));
            kdVar.kd(jSONObject.optInt(PluginConstants.KEY_ERROR_CODE));
            kdVar.w(jSONObject.optString("message"));
            kdVar.xj(jSONObject.optLong("request_duration", 0L));
            kdVar.u(jSONObject.optString("back_web_url"));
            kdVar.kd(jSONObject.optString("hw_app_id"));
            kdVar.y(jSONObject.optString("deep_link"));
            return kdVar;
        } catch (Exception e) {
            com.ss.android.downloadlib.kd.w.xj().xj(e, "ComplianceResult fromJson");
            return kdVar;
        }
    }

    public void hf(int i) {
        this.u = i;
    }

    public void kd(int i) {
        this.d = i;
    }

    public String toString() {
        return xj(this);
    }

    public void u(int i) {
        this.y = i;
    }

    public void w(int i) {
        this.kd = i;
    }

    public void xj(boolean z) {
        this.xj = z;
    }

    public void y(String str) {
        this.g = str;
    }

    public void hf(String str) {
        this.f = str;
    }

    public void kd(String str) {
        this.f13830pl = str;
    }

    public void u(String str) {
        this.qt = str;
    }

    public void w(String str) {
        this.tf = str;
    }

    public void xj(xj xjVar) {
        this.hf = xjVar;
    }

    private static JSONArray w(xj xjVar) {
        JSONArray jSONArray = new JSONArray();
        List<xj.C0466xj> list = xjVar.c;
        if (list != null && list.size() > 0) {
            for (xj.C0466xj c0466xj : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0466xj.xj);
                jSONObject.putOpt("permission_desc", c0466xj.hf);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public String hf() {
        return this.g;
    }

    public void xj(int i) {
        this.w = i;
    }

    private static JSONObject hf(xj xjVar) {
        JSONObject jSONObject = new JSONObject();
        if (xjVar != null) {
            jSONObject.putOpt("app_name", xjVar.xj);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, xjVar.hf);
            jSONObject.putOpt("update_time", Long.valueOf(xjVar.w));
            jSONObject.putOpt("size", Long.valueOf(xjVar.u));
            jSONObject.putOpt("developer_name", xjVar.kd);
            jSONObject.putOpt("policy_url", xjVar.d);
            jSONObject.putOpt("icon_url", xjVar.tf);
            jSONObject.putOpt("download_url", xjVar.p);
            jSONObject.putOpt("permissions", w(xjVar));
            jSONObject.putOpt("permission_classify_url", xjVar.f);
            jSONObject.putOpt("desc_url", xjVar.f13831pl);
        }
        return jSONObject;
    }

    public void xj(String str) {
        this.c = str;
    }

    public int xj() {
        return this.d;
    }

    public void xj(long j) {
        this.p = j;
    }

    public void xj(hf hfVar) {
        this.am = hfVar;
    }

    public static String xj(kd kdVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(kdVar.xj ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(kdVar.w));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(kdVar.u));
            jSONObject.putOpt("market_online_status", Integer.valueOf(kdVar.kd));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(kdVar.y));
            jSONObject.putOpt(n.p, kdVar.c);
            jSONObject.putOpt("hijack_url", kdVar.f);
            jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(kdVar.d));
            jSONObject.putOpt("message", kdVar.tf);
            jSONObject.putOpt("request_duration", Long.valueOf(kdVar.p));
            jSONObject.putOpt("auth_info", hf(kdVar.hf));
            jSONObject.putOpt("status", hf(kdVar.am));
            jSONObject.putOpt("back_web_url", kdVar.qt);
            jSONObject.putOpt("hw_app_id", kdVar.f13830pl);
            jSONObject.putOpt("deep_link", kdVar.g);
        } catch (JSONException e) {
            com.ss.android.downloadlib.kd.w.xj().xj(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    private static hf hf(JSONObject jSONObject) {
        hf hfVar = new hf();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("status");
            if (optJSONObject != null) {
                hfVar.xj(optJSONObject.optInt("status"));
                hfVar.xj(optJSONObject.optString("message"));
                return hfVar;
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.kd.w.xj().xj(e, "ComplianceResult getStatus");
        }
        return hfVar;
    }

    private static JSONObject hf(hf hfVar) {
        JSONObject jSONObject = new JSONObject();
        if (hfVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(hfVar.xj));
            jSONObject.putOpt("message", hfVar.hf);
        }
        return jSONObject;
    }

    private static xj xj(JSONObject jSONObject) {
        xj xjVar = new xj();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("auth_info");
            if (optJSONObject != null) {
                xjVar.xj(optJSONObject.optString("app_name"));
                xjVar.hf(optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                xjVar.xj(g.xj(optJSONObject, "update_time"));
                xjVar.hf(g.xj(optJSONObject, "size"));
                xjVar.w(optJSONObject.optString("developer_name"));
                xjVar.u(optJSONObject.optString(n.p));
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    xj(optJSONArray, arrayList);
                    xjVar.xj(arrayList);
                }
                xjVar.kd(optJSONObject.optString("permission_classify_url"));
                xjVar.y(optJSONObject.optString("policy_url"));
                xjVar.c(optJSONObject.optString("icon_url"));
                xjVar.f(optJSONObject.optString("download_url"));
                xjVar.d(optJSONObject.optString("desc_url"));
                return xjVar;
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.kd.w.xj().xj(e, "ComplianceResult getAuthInfo");
        }
        return xjVar;
    }

    private static void xj(JSONArray jSONArray, List<xj.C0466xj> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                xj.C0466xj c0466xj = new xj.C0466xj();
                c0466xj.xj(optJSONObject.optString("permission_name"));
                c0466xj.hf(optJSONObject.optString("permission_desc"));
                list.add(c0466xj);
            }
        }
    }
}
