package com.bytedance.adsdk.ugeno.w;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am {
    private JSONObject hf;
    private Map<String, Object> u;
    private JSONObject w;
    private Context xj;

    public Context getContext() {
        return this.xj;
    }

    public void hf(JSONObject jSONObject) {
        this.w = jSONObject;
    }

    public void xj(Context context) {
        this.xj = context;
    }

    public Map<String, Object> hf() {
        return this.u;
    }

    public void xj(JSONObject jSONObject) {
        this.hf = jSONObject;
    }

    public JSONObject xj() {
        return this.w;
    }

    public void xj(Map<String, Object> map) {
        this.u = map;
    }
}
