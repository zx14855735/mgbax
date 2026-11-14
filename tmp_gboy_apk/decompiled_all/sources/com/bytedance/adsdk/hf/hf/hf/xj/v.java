package com.bytedance.adsdk.hf.hf.hf.xj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class v implements com.bytedance.adsdk.hf.hf.hf.hf {
    private com.bytedance.adsdk.hf.hf.hf.xj hf;
    private com.bytedance.adsdk.hf.hf.hf.xj w;
    private com.bytedance.adsdk.hf.hf.hf.xj xj;

    @Override // com.bytedance.adsdk.hf.hf.hf.hf
    public void hf(com.bytedance.adsdk.hf.hf.hf.xj xjVar) {
        this.hf = xjVar;
    }

    public String toString() {
        return hf();
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.hf
    public void w(com.bytedance.adsdk.hf.hf.hf.xj xjVar) {
        this.w = xjVar;
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public Object xj(Map<String, JSONObject> map) {
        Object xj = this.xj.xj(map);
        if (xj == null) {
            return null;
        }
        return ((Boolean) xj).booleanValue() ? this.hf.xj(map) : this.w.xj(map);
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public String hf() {
        return this.xj.hf() + "?" + this.hf.hf() + ":" + this.w.hf();
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public com.bytedance.adsdk.hf.hf.u.kd xj() {
        return com.bytedance.adsdk.hf.hf.u.y.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.hf
    public void xj(com.bytedance.adsdk.hf.hf.hf.xj xjVar) {
        this.xj = xjVar;
    }
}
