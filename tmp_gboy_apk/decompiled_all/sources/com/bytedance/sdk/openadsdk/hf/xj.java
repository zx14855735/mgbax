package com.bytedance.sdk.openadsdk.hf;

import com.bytedance.sdk.component.utils.pl;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private String hf;
    private long kd;
    private long u;
    private String w;
    private long xj;

    public xj(JSONObject jSONObject) {
        this.xj = jSONObject.optLong("cid");
        this.hf = jSONObject.optString("url");
        this.w = jSONObject.optString("file_hash");
        this.u = jSONObject.optLong("effective_time");
        this.kd = jSONObject.optLong("expiration_time");
    }

    public String hf() {
        return this.w;
    }

    public JSONObject kd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.xj);
            jSONObject.put("url", this.hf);
            jSONObject.put("file_hash", this.w);
            jSONObject.put("effective_time", this.u);
            jSONObject.put("expiration_time", this.kd);
            return jSONObject;
        } catch (Exception e) {
            pl.hf("BrandVideo", e.getMessage());
            return jSONObject;
        }
    }

    public boolean u() {
        return System.currentTimeMillis() >= this.kd;
    }

    public long w() {
        return this.u;
    }

    public String xj() {
        return this.hf;
    }

    public boolean hf(String str) {
        File file = new File(str, this.w);
        if (!file.exists()) {
            return false;
        }
        try {
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }

    public long xj(String str) {
        File file = new File(str, this.w);
        return file.exists() ? file.lastModified() : System.currentTimeMillis();
    }
}
