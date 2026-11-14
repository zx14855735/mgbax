package com.bytedance.sdk.component.adexpress.dynamic.w;

import com.bytedance.sdk.component.utils.pl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public String hf;
    public String u;
    public String w;
    public List<xj> xj;

    public static class xj {
        public JSONObject hf;
        public int xj;
    }

    public static u xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        String optString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    xj xjVar = new xj();
                    xjVar.xj = optJSONObject.optInt(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a);
                    xjVar.hf = new JSONObject(optJSONObject.optString("componentLayout"));
                    arrayList.add(xjVar);
                }
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        uVar.xj = arrayList;
        uVar.hf = jSONObject.optString("diff_data");
        uVar.w = jSONObject.optString("style_diff");
        uVar.u = jSONObject.optString("tag_diff");
        return uVar;
    }
}
