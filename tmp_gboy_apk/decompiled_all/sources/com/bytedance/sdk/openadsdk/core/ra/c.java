package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    private List<String> hf;
    private String xj;

    public c(Map<String, Object> map) {
        this.xj = "";
        this.hf = new ArrayList();
        try {
            this.xj = (String) map.get("auto_test_param");
            String str = (String) map.get("auto_test_hosts");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.hf = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.hf.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public List<String> hf() {
        return this.hf;
    }

    public String xj() {
        return this.xj;
    }
}
