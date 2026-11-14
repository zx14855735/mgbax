package com.bytedance.adsdk.hf.hf.hf.xj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c implements com.bytedance.adsdk.hf.hf.hf.xj {
    private final Object xj;

    public c(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.xj = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.xj = Boolean.FALSE;
        } else {
            if (!str.equalsIgnoreCase("null")) {
                throw new IllegalArgumentException();
            }
            this.xj = null;
        }
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public String hf() {
        Object obj = this.xj;
        return obj != null ? obj.toString() : "NULL";
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.xj + "]";
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public Object xj(Map<String, JSONObject> map) {
        return this.xj;
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public com.bytedance.adsdk.hf.hf.u.kd xj() {
        return com.bytedance.adsdk.hf.hf.u.y.CONSTANT;
    }
}
