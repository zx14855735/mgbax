package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.ra.ne;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pl implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "context")
    private Context hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "wc_miniapp_info")
    private JSONObject kd;

    @com.bytedance.sdk.component.p.hf.xj(xj = "event_tag")
    private String u;

    @com.bytedance.sdk.component.p.hf.xj(xj = "convert_from_landing_page")
    private boolean w;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    private ws xj;

    @com.bytedance.sdk.component.p.hf.xj(xj = n.l)
    private int y;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        if (!xj()) {
            xjVar.hf(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.f fVar = new com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.f(ne.xj(this.kd), this.hf, this.w, this.u, map2, xjVar, this.y);
        fVar.xj(this.xj);
        if (fVar.xj(new HashMap())) {
            xjVar.xj(map2);
        } else {
            xjVar.hf(map2);
        }
        return true;
    }

    private boolean xj() {
        return (this.xj == null || this.hf == null || this.kd == null) ? false : true;
    }
}
