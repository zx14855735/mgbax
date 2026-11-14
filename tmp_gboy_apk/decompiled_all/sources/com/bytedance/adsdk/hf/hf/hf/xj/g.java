package com.bytedance.adsdk.hf.hf.hf.xj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g extends e {
    public g() {
        super(com.bytedance.adsdk.hf.hf.u.w.MULTI);
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public Object xj(Map<String, JSONObject> map) {
        Object xj;
        Object xj2 = this.xj.xj(map);
        if (xj2 == null || (xj = this.hf.xj(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.hf.hf.kd.xj.c.xj((Number) xj2, (Number) xj);
    }
}
