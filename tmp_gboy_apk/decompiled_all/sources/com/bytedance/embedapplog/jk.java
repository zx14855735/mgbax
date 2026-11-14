package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class jk {
    protected JSONObject u;
    protected Context xj;
    protected String w = "";
    protected final q hf = new q();

    public jk(Context context, JSONObject jSONObject) {
        this.xj = context;
        this.u = jSONObject;
    }

    private String u() {
        return this.w;
    }

    public abstract String hf();

    public abstract String w();

    public q xj() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String hf = hf();
            long currentTimeMillis2 = System.currentTimeMillis();
            this.hf.hf(hf);
            this.hf.xj(w());
            this.hf.xj(currentTimeMillis2 - currentTimeMillis);
            this.hf.w(u());
            this.hf.w();
            if (this.u.has("index")) {
                this.hf.xj(this.u.optInt("index"));
            }
            return this.hf;
        } catch (Exception e) {
            v.hf("__kite" + w() + " doLoad# error " + e.getMessage());
            return this.hf;
        }
    }
}
