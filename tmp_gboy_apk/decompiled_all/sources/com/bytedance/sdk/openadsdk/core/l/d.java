package com.bytedance.sdk.openadsdk.core.l;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d {
    private final String hf;
    private String kd;
    private final String u;
    private final JSONObject w;
    private final Map<String, List<String>> xj;
    private String y;

    public d(String str, String str2, Map<String, List<String>> map, JSONObject jSONObject) {
        this.hf = str;
        this.u = str2;
        this.xj = map;
        this.w = jSONObject;
    }

    public String hf() {
        return this.hf;
    }

    public String u() {
        return this.u;
    }

    public String w() {
        try {
            String optString = this.w.optString("expandParams");
            String str = "apppackage=" + this.kd + "|appsign=" + this.y;
            if (!TextUtils.isEmpty(optString)) {
                str = optString + "|" + str;
            }
            this.w.put("expandParams", str);
        } catch (Exception e) {
            pl.xj(e);
        }
        JSONObject jSONObject = this.w;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        List<String> list = this.xj.get(str);
        if (list != null) {
            list.add(str2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        this.xj.put(str, arrayList);
    }

    public void hf(String str) {
        this.y = str;
    }

    public Map<String, List<String>> xj() {
        return this.xj;
    }

    public void xj(String str) {
        this.kd = str;
    }
}
