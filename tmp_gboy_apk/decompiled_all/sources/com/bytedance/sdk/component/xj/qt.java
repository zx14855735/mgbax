package com.bytedance.sdk.component.xj;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class qt {
    private final Map<String, Object> xj = new ConcurrentHashMap();

    private qt() {
    }

    public static qt xj() {
        return new qt();
    }

    public String hf() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.xj.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public qt xj(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.xj.put(str, obj);
        }
        return this;
    }
}
