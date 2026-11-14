package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class dk extends jk {
    public dk(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.bytedance.embedapplog.jk
    public String hf() {
        JSONArray optJSONArray = this.u.optJSONArray("path");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return "";
        }
        int length = optJSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                strArr[i] = optJSONArray.getString(i);
            } catch (JSONException e) {
                v.hf("__kite" + w() + "jsonArray parse error " + e.getMessage());
            }
        }
        if (v.hf()) {
            v.xj("__kite" + w() + " plist size: " + length);
        }
        try {
            return xj(strArr);
        } catch (Exception e2) {
            if (e2.getCause() != null) {
                this.w = e2.getCause().getMessage();
            } else {
                this.w = e2.getMessage();
            }
            return "";
        }
    }

    @Override // com.bytedance.embedapplog.jk
    public String w() {
        return "d_i0";
    }

    public String xj(String[] strArr) {
        try {
            int[] dI0Result = TTEncryptUtils.getDI0Result(strArr);
            if (dI0Result == null || dI0Result.length <= 0) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < dI0Result.length; i++) {
                jSONObject.put(strArr[i], dI0Result[i]);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
