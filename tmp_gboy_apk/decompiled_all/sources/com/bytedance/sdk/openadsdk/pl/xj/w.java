package com.bytedance.sdk.openadsdk.pl.xj;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.hf.xj.tf;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.bytedance.sdk.openadsdk.pl.xj.xj;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends xj {
    private String f;

    public w(com.bytedance.sdk.openadsdk.pl.xj xjVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(xjVar, str, str2, jSONObject, str3, str4);
        this.f = "inspect_data";
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void hf(Context context, String str, com.bytedance.sdk.openadsdk.pl.hf hfVar, WebResourceResponse webResourceResponse, tf tfVar, Map<String, Object> map) {
    }

    public JSONObject kd() {
        int i;
        JSONArray optJSONArray;
        try {
            i = this.xj.hf().get();
            optJSONArray = this.y.optJSONArray(this.f);
        } catch (Exception e) {
            pl.xj(e);
        }
        if (optJSONArray == null) {
            return null;
        }
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = optJSONArray.getJSONObject(i2);
            int optInt = jSONObject.optInt("jump_number", -1);
            if (optInt != -1 && optInt == i) {
                return jSONObject;
            }
        }
        return null;
    }

    public void u() {
        JSONObject jSONObject = this.y;
        if (jSONObject == null) {
            return;
        }
        am.xj().w(jSONObject.toString(), this.y.optString("req_id"));
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void w() {
        this.xj.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pl.xj.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.u();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj(Context context, String str, com.bytedance.sdk.openadsdk.pl.hf hfVar, WebResourceResponse webResourceResponse, tf tfVar, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj(String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj(JSONObject jSONObject, String str, tf tfVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public boolean xj(WebView webView) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public boolean xj(tf tfVar) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj() {
        try {
            this.y.putOpt("req_id", this.w);
            this.y.put(this.f, new JSONArray());
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj(String str) {
        int i = this.xj.hf().get();
        JSONArray optJSONArray = this.y.optJSONArray(this.f);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jump_number", i);
            jSONObject.put("jump_url", str);
            optJSONArray.put(jSONObject);
            this.y.put("inspect_data", optJSONArray);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj(com.bytedance.sdk.openadsdk.pl.hf hfVar, WebResourceResponse webResourceResponse, tf tfVar, xj.InterfaceC0203xj interfaceC0203xj) {
        Uri xj = hfVar.xj();
        if (xj != null) {
            try {
                String uri = xj.toString();
                String str = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
                if (tfVar != null && tfVar.hf() != null) {
                    str = tfVar.hf().trim().toLowerCase();
                }
                JSONObject kd = kd();
                if (kd == null) {
                    pl.u("weblp", "error pageCountJson is null");
                } else {
                    JSONArray optJSONArray = kd.optJSONArray(str);
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    optJSONArray.put(uri);
                    kd.putOpt(str, optJSONArray);
                }
            } catch (Exception e) {
                pl.xj(e);
                pl.w("weblp", "error", e);
            }
        }
        interfaceC0203xj.xj(false, null);
    }
}
