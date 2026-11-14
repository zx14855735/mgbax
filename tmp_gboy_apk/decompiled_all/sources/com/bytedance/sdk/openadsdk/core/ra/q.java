package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class q {
    private String hf;
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj.hf> w = new ArrayList();
    private String xj;

    public q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.xj = jSONObject.optString(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a);
        this.hf = jSONObject.optString("url");
        w();
    }

    private void w() {
        String xj = xj(this.xj);
        if (!TextUtils.isEmpty(xj)) {
            hf(xj);
            return;
        }
        com.bytedance.sdk.component.d.hf.w w = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().w();
        if (w == null || TextUtils.isEmpty(this.hf)) {
            return;
        }
        w.xj(this.hf);
        w.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ra.q.1
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                if (hfVar != null) {
                    try {
                        if (!hfVar.f() || hfVar.u() == null) {
                            return;
                        }
                        com.bytedance.sdk.component.u.hf.w xj2 = com.bytedance.sdk.openadsdk.core.hf.xj();
                        String u = hfVar.u();
                        xj2.put(q.this.xj, u);
                        q.this.hf(u);
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj.hf> hf() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("pattern");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.w.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj.hf(jSONArray.getJSONObject(i)));
            }
        } catch (Exception unused) {
        }
    }

    public String xj() {
        return this.xj;
    }

    private String xj(String str) {
        com.bytedance.sdk.component.u.hf.w xj;
        if (TextUtils.isEmpty(str) || (xj = com.bytedance.sdk.openadsdk.core.hf.xj()) == null) {
            return null;
        }
        return xj.get(str, "");
    }

    public q(String str, JSONArray jSONArray) {
        this.xj = str;
        xj(jSONArray);
    }

    private void xj(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.w.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj.hf(jSONArray.getJSONObject(i)));
            } catch (Exception unused) {
                return;
            }
        }
    }
}
