package com.bytedance.sdk.openadsdk.core.ugeno.y;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.xj.w.xj;
import com.bytedance.sdk.component.utils.pl;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends com.bytedance.sdk.component.adexpress.xj.w.xj {
    public hf() {
    }

    public static hf hf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hf hfVar = new hf();
        hfVar.xj(jSONObject.optString("name"));
        hfVar.hf(jSONObject.optString("version"));
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    xj.C0107xj c0107xj = new xj.C0107xj();
                    c0107xj.xj(optJSONObject.optString("url"));
                    c0107xj.hf(optJSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
                    c0107xj.xj(optJSONObject.optInt("level"));
                    arrayList.add(c0107xj);
                }
            }
        }
        hfVar.xj(arrayList);
        if (hfVar.y()) {
            return hfVar;
        }
        return null;
    }

    public static hf kd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return hf(new JSONObject(str));
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xj.w.xj
    public String f() {
        if (!y()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", hf());
            jSONObject.putOpt("version", w());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (xj.C0107xj c0107xj : getResources()) {
                    if (c0107xj != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("url", c0107xj.xj());
                        jSONObject2.putOpt(TKDownloadReason.KSAD_TK_MD5, c0107xj.hf());
                        jSONObject2.putOpt("level", Integer.valueOf(c0107xj.w()));
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xj.w.xj
    public boolean y() {
        return (TextUtils.isEmpty(w()) || TextUtils.isEmpty(hf())) ? false : true;
    }

    public hf(com.bytedance.sdk.component.adexpress.xj.w.xj xjVar) {
        if (xjVar != null) {
            xj(xjVar.hf());
            hf(xjVar.w());
            xj(xjVar.getResources());
        }
    }
}
