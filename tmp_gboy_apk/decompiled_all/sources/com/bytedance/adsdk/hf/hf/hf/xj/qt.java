package com.bytedance.adsdk.hf.hf.hf.xj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class qt implements com.bytedance.adsdk.hf.hf.hf.xj {
    private Number xj;

    public qt(String str) {
        if (str.indexOf(46) < 0) {
            try {
                this.xj = Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                this.xj = Long.valueOf(str);
            }
        } else {
            Float valueOf = Float.valueOf(str);
            this.xj = valueOf;
            if (Float.isInfinite(valueOf.floatValue())) {
                this.xj = Double.valueOf(str);
            }
        }
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public String hf() {
        return this.xj.toString();
    }

    public String toString() {
        return hf();
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public Object xj(Map<String, JSONObject> map) {
        return this.xj;
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public com.bytedance.adsdk.hf.hf.u.kd xj() {
        return com.bytedance.adsdk.hf.hf.u.y.NUMBER;
    }
}
