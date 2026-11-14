package com.bytedance.sdk.openadsdk.core.dislike.w;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.zg.w.hf.y;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends y {
    private String hf;
    private List<y> u;
    private boolean w;
    private String xj;

    public w(String str, String str2) {
        super(null);
        this.xj = str;
        this.hf = str2;
    }

    public JSONObject c() {
        try {
            if (!kd()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f.f13353a, xj());
            jSONObject.put("name", hf());
            jSONObject.put("is_selected", w());
            if (y()) {
                JSONArray jSONArray = new JSONArray();
                for (y yVar : u()) {
                    if (yVar instanceof w) {
                        jSONArray.put(((w) yVar).c());
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("options", jSONArray);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.y
    public String hf() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.y
    public boolean kd() {
        return (TextUtils.isEmpty(this.xj) || TextUtils.isEmpty(this.hf)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.y
    public List<y> u() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.y
    public boolean w() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.y
    public String xj() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.y
    public boolean y() {
        List<y> list = this.u;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void hf(String str) {
        this.hf = str;
    }

    public void xj(String str) {
        this.xj = str;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.y
    public void xj(boolean z) {
        this.w = z;
    }

    public w() {
        super(null);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.y
    public void xj(y yVar) {
        if (yVar == null) {
            return;
        }
        if (this.u == null) {
            this.u = new ArrayList();
        }
        this.u.add(yVar);
    }

    public static w xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            w wVar = new w();
            wVar.xj(jSONObject.optString(f.f13353a));
            wVar.hf(jSONObject.optString("name"));
            wVar.xj(jSONObject.optBoolean("is_selected"));
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    w xj = xj(optJSONArray.optJSONObject(i));
                    if (xj != null && xj.kd()) {
                        wVar.xj(xj);
                    }
                }
            }
            return wVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
