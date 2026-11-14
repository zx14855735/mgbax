package com.bytedance.adsdk.hf.hf.hf.xj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am extends e {
    public am() {
        super(com.bytedance.adsdk.hf.hf.u.w.NOT_EQ);
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public Object xj(Map<String, JSONObject> map) {
        Object xj = this.xj.xj(map);
        Object xj2 = this.hf.xj(map);
        return (xj == null && xj2 == null) ? Boolean.FALSE : (xj != null || xj2 == null) ? (xj == null || xj2 != null) ? ((xj instanceof Number) && (xj2 instanceof Number)) ? Boolean.valueOf(!com.bytedance.adsdk.hf.hf.kd.xj.hf.xj((Number) xj, (Number) xj2)) : Boolean.valueOf(!xj.equals(xj2)) : Boolean.TRUE : Boolean.TRUE;
    }
}
