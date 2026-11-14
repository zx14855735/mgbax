package com.bytedance.adsdk.hf;

import com.bytedance.adsdk.ugeno.u.xj;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements com.bytedance.adsdk.ugeno.u.xj {

    public static class xj implements xj.InterfaceC0028xj {
        private String hf;
        private com.bytedance.adsdk.hf.hf.xj xj;

        private xj(String str) {
            this.hf = str;
            this.xj = com.bytedance.adsdk.hf.hf.xj.xj(str);
        }

        public static xj xj(String str) {
            return new xj(str);
        }

        @Override // com.bytedance.adsdk.ugeno.u.xj.InterfaceC0028xj
        public Object xj(JSONObject jSONObject) {
            com.bytedance.adsdk.hf.hf.xj xjVar = this.xj;
            if (xjVar == null) {
                return this.hf;
            }
            Object xj = xjVar.xj(jSONObject);
            return xj instanceof String ? xj : xj instanceof com.bytedance.adsdk.hf.hf.xj.xj ? String.valueOf(p.xj((com.bytedance.adsdk.hf.hf.xj.xj) xj)) : String.valueOf(xj);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.u.xj
    public xj.InterfaceC0028xj xj(String str) {
        return xj.xj(str);
    }
}
