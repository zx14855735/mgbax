package com.bytedance.sdk.openadsdk.core.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private int hf;
    private boolean u;
    private int w;
    private int xj;

    public int hf() {
        return this.hf;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("expire_days", hf());
            jSONObject.put("log_level", xj());
            jSONObject.put("max_size", w());
            jSONObject.put("is_open", u());
        } catch (JSONException e) {
            pl.xj(e);
        }
        return jSONObject.toString();
    }

    public boolean u() {
        return this.u;
    }

    public int w() {
        return this.w;
    }

    public int xj() {
        return this.xj;
    }

    public void hf(int i) {
        this.hf = i;
    }

    public void w(int i) {
        this.w = i;
    }

    public void xj(int i) {
        this.xj = i;
    }

    public static hf xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return xj(new JSONObject(str));
        } catch (JSONException e) {
            pl.hf("CLogConfig", "parse failed:".concat(String.valueOf(e)));
            return null;
        }
    }

    public static hf xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hf hfVar = new hf();
        hfVar.hf(jSONObject.optInt("expire_days"));
        hfVar.xj(jSONObject.optInt("log_level"));
        hfVar.w(jSONObject.optInt("max_size"));
        hfVar.xj(jSONObject.optBoolean("is_open"));
        return hfVar;
    }

    public void xj(boolean z) {
        this.u = z;
    }
}
