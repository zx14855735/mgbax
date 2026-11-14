package com.bytedance.sdk.openadsdk.y.w;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.y.w.u;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf<T extends u> {
    private String hf;
    private boolean kd = false;
    private T u;
    private JSONObject w;
    private ws xj;

    public hf(ws wsVar, String str, JSONObject jSONObject, T t) {
        this.xj = wsVar;
        this.hf = str;
        this.w = jSONObject;
        this.u = t;
    }

    public String hf() {
        return this.hf;
    }

    public boolean kd() {
        return this.kd;
    }

    public T u() {
        return this.u;
    }

    public JSONObject w() {
        if (this.w == null) {
            this.w = new JSONObject();
        }
        return this.w;
    }

    public ws xj() {
        return this.xj;
    }

    public void xj(boolean z) {
        this.kd = z;
    }
}
