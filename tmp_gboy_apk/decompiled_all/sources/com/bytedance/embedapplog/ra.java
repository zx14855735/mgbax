package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ra extends jk {
    public ra(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.bytedance.embedapplog.jk
    public String hf() {
        JSONArray optJSONArray = this.u.optJSONArray("path");
        if (optJSONArray == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                String string = optJSONArray.getString(i);
                jSONObject.put(string, xj(string));
            } catch (Exception e) {
                if (e.getCause() != null) {
                    this.w = e.getCause().getMessage();
                } else {
                    this.w = e.getMessage();
                }
            }
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.embedapplog.jk
    public String w() {
        return "d_a0";
    }

    public String xj(String str) {
        try {
            String dA0Result = TTEncryptUtils.getDA0Result(str);
            if (v.hf()) {
                v.xj("__kite", "p：" + str + " r:" + dA0Result);
            }
            return !TextUtils.isEmpty(dA0Result) ? dA0Result : "";
        } catch (Exception unused) {
            return "";
        }
    }
}
