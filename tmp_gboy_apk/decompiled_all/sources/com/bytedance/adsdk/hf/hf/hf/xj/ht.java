package com.bytedance.adsdk.hf.hf.hf.xj;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ht implements com.bytedance.adsdk.hf.hf.hf.xj {
    private final String xj;

    public ht(String str) {
        this.xj = str;
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public String hf() {
        return this.xj;
    }

    public String toString() {
        return CtFAbx.B25kr6(new StringBuilder("VariableNode [literals="), this.xj, "]");
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public Object xj(Map<String, JSONObject> map) {
        Object xj;
        if (map == null || map.size() <= 0 || (xj = xj(this.xj, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return xj;
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public com.bytedance.adsdk.hf.hf.u.kd xj() {
        return com.bytedance.adsdk.hf.hf.u.y.VARIABLE;
    }

    public Object xj(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return xj(str.split("\\."), 0, jSONObject);
    }

    private Object xj(String[] strArr, int i, JSONObject jSONObject) {
        Object opt;
        if (strArr != null && strArr.length > 0 && i < strArr.length && jSONObject != null) {
            String str = strArr[i];
            int indexOf = str.indexOf("[");
            int indexOf2 = str.indexOf("]");
            if (indexOf >= 0 && indexOf2 >= 0 && indexOf <= indexOf2) {
                String substring = str.substring(0, indexOf);
                try {
                    int parseInt = Integer.parseInt(str.substring(indexOf + 1, indexOf2));
                    Object opt2 = jSONObject.opt(substring);
                    opt = opt2 instanceof JSONArray ? ((JSONArray) opt2).opt(parseInt) : null;
                } catch (NumberFormatException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return null;
                }
            } else {
                opt = jSONObject.opt(str);
            }
            if (i == strArr.length - 1) {
                return opt;
            }
            if (opt instanceof String) {
                try {
                    return xj(strArr, i + 1, new JSONObject((String) opt));
                } catch (JSONException e2) {
                    com.bytedance.sdk.component.utils.pl.xj(e2);
                    return opt;
                }
            }
            if (opt instanceof JSONObject) {
                return xj(strArr, i + 1, (JSONObject) opt);
            }
        }
        return null;
    }
}
