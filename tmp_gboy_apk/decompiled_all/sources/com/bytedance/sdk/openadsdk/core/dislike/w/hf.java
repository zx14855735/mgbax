package com.bytedance.sdk.openadsdk.core.dislike.w;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.hf.y;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private String c;
    private final List<y> hf = new ArrayList();
    private final String kd;
    private final boolean u;
    private String w;
    private final int xj;
    private final String y;

    public hf(JSONObject jSONObject, w wVar) {
        int i = 0;
        this.xj = jSONObject.optInt("dislike_control", 0);
        this.u = jSONObject.optBoolean("close_on_dislike", false);
        String xj = wVar != null ? wVar.xj() : "";
        JSONArray optJSONArray = jSONObject.optJSONArray("filter_words");
        if (optJSONArray != null) {
            boolean z = false;
            while (i < optJSONArray.length()) {
                w xj2 = w.xj(optJSONArray.optJSONObject(i));
                if (xj2 != null && xj2.kd()) {
                    this.hf.add(xj2);
                    if (!z) {
                        z = TextUtils.equals(xj2.xj(), xj);
                    }
                }
                i++;
            }
            i = z ? 1 : 0;
        }
        if (wVar != null && i == 0) {
            this.hf.add(wVar);
        }
        this.kd = jSONObject.optString(MediationConstant.EXTRA_ADID);
        this.y = jSONObject.optString(n.m);
    }

    public String c() {
        return this.c;
    }

    public boolean f() {
        return this.u;
    }

    public String hf() {
        return this.w;
    }

    public boolean kd() {
        return this.xj == 1;
    }

    public String u() {
        return this.y;
    }

    public String w() {
        return this.kd;
    }

    public void xj(JSONObject jSONObject) {
        jSONObject.put("dislike_control", this.xj);
        jSONObject.put("filter_words", y());
        jSONObject.put("close_on_dislike", f());
    }

    public JSONArray y() {
        JSONObject c;
        JSONArray jSONArray = new JSONArray();
        List<y> list = this.hf;
        if (list != null) {
            for (y yVar : list) {
                if ((yVar instanceof w) && (c = ((w) yVar).c()) != null) {
                    jSONArray.put(c);
                }
            }
        }
        return jSONArray;
    }

    public void hf(String str) {
        this.c = str;
    }

    public List<y> xj() {
        return this.hf;
    }

    public void xj(String str) {
        this.w = str;
    }
}
