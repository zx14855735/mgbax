package com.bytedance.adsdk.hf.hf.hf.xj;

import ADYaiT.CtFAbx;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class jk implements com.bytedance.adsdk.hf.hf.hf.xj {
    private final String xj;

    public jk(String str) {
        this.xj = str;
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public String hf() {
        return CtFAbx.B25kr6(new StringBuilder("'"), this.xj, "'");
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
        return com.bytedance.adsdk.hf.hf.u.y.STRING;
    }
}
