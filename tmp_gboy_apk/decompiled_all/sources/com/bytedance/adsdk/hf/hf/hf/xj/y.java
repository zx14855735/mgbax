package com.bytedance.adsdk.hf.hf.hf.xj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends e {
    public y() {
        super(com.bytedance.adsdk.hf.hf.u.w.GT);
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public Object xj(Map<String, JSONObject> map) {
        Object xj;
        Object xj2 = this.xj.xj(map);
        if (xj2 == null || (xj = this.hf.xj(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.hf.hf.kd.xj.w.xj(xj2, (Number) xj);
    }
}
