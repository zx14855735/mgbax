package com.bytedance.adsdk.hf.hf.hf.xj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends e {
    public f() {
        super(com.bytedance.adsdk.hf.hf.u.w.LT_EQ);
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public Object xj(Map<String, JSONObject> map) {
        Object xj;
        if (this.xj.xj(map) == null || (xj = this.hf.xj(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.hf.hf.kd.xj.w.xj(r0, (Number) xj)).booleanValue());
    }
}
