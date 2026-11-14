package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private String c;
    private String d;
    private float f;
    private JSONObject g;
    private String hf;
    private String kd;
    private JSONArray p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10416pl;
    private String tf;
    private List<xj> u;
    private String w;
    private String xj;
    private String y;

    public static class xj {
        private final String hf;
        private final String xj;

        public xj(JSONObject jSONObject) {
            this.xj = jSONObject.optString("permission_name");
            this.hf = jSONObject.optString("permission_desc");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject xj() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("permission_desc", this.hf);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
            try {
                jSONObject.put("permission_name", this.xj);
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.pl.xj(e2);
            }
            return jSONObject;
        }
    }

    public u(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("package");
            this.xj = optJSONObject.optString("app_name");
            this.hf = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            this.w = optJSONObject.optString("developer_name");
            this.u = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.u.add(new xj(optJSONArray.optJSONObject(i)));
                }
            }
            this.kd = optJSONObject.optString("policy_url");
            String optString = optJSONObject.optString("package");
            this.y = optString;
            if (TextUtils.isEmpty(optString)) {
                this.y = optJSONObject.optString(com.sigmob.sdk.base.n.p);
            }
            this.c = optJSONObject.optString("icon_url");
            this.d = optJSONObject.optString("desc_url");
            this.tf = optJSONObject.optString("reg_number");
            this.f10416pl = optJSONObject.optString("reg_url");
            this.g = optJSONObject.optJSONObject("reg_info");
        } catch (Throwable unused) {
        }
    }

    public String hf() {
        return this.w;
    }

    public boolean kd() {
        List<xj> list;
        return (TextUtils.isEmpty(this.xj) || TextUtils.isEmpty(this.hf) || TextUtils.isEmpty(hf()) || (list = this.u) == null || list.size() == 0 || TextUtils.isEmpty(this.kd) || TextUtils.isEmpty(this.d)) ? false : true;
    }

    public String u() {
        return this.d;
    }

    public String w() {
        return this.c;
    }

    public String xj() {
        return this.xj;
    }

    public String y() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", this.xj);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        try {
            jSONObject.put(com.sigmob.sdk.base.n.r, this.hf);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
        }
        try {
            jSONObject.put("developer_name", this.w);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.pl.xj(e3);
        }
        try {
            jSONObject.put(com.sigmob.sdk.base.n.p, this.y);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.pl.xj(e4);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<xj> it = this.u.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().xj());
        }
        try {
            jSONObject.put("permissions", jSONArray);
        } catch (JSONException e5) {
            com.bytedance.sdk.component.utils.pl.xj(e5);
        }
        try {
            jSONObject.put("privacy_policy_url", this.kd);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.pl.xj(e6);
        }
        try {
            jSONObject.put("score", this.f);
        } catch (JSONException e7) {
            com.bytedance.sdk.component.utils.pl.xj(e7);
        }
        try {
            jSONObject.put("creative_tags", this.p);
        } catch (JSONException e8) {
            com.bytedance.sdk.component.utils.pl.xj(e8);
        }
        try {
            jSONObject.put("desc_url", this.d);
        } catch (JSONException e9) {
            com.bytedance.sdk.component.utils.pl.xj(e9);
        }
        try {
            jSONObject.put("reg_number", this.tf);
        } catch (JSONException e10) {
            com.bytedance.sdk.component.utils.pl.xj(e10);
        }
        try {
            jSONObject.put("icon_url", this.c);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.pl.xj(e11);
        }
        try {
            jSONObject.put("reg_url", this.f10416pl);
        } catch (JSONException e12) {
            com.bytedance.sdk.component.utils.pl.xj(e12);
        }
        try {
            jSONObject.put("reg_info", this.g);
        } catch (JSONException e13) {
            com.bytedance.sdk.component.utils.pl.xj(e13);
        }
        return jSONObject.toString();
    }

    public void xj(float f) {
        this.f = f;
    }

    public void xj(JSONArray jSONArray) {
        this.p = jSONArray;
    }
}
