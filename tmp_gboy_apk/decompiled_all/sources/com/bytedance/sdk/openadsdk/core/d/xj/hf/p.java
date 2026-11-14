package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.HashMap;
import java.util.Map;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class p implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "handle_chain_data")
    private Map<String, Object> c;

    @com.bytedance.sdk.component.p.hf.xj(xj = "context")
    private Context hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "live_saas_interaction_type")
    private int kd = -1;

    @com.bytedance.sdk.component.p.hf.xj(xj = "dpa_tag")
    private String u;

    @com.bytedance.sdk.component.p.hf.xj(xj = "event_tag")
    private String w;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    private ws xj;

    @com.bytedance.sdk.component.p.hf.xj(xj = "view")
    private View y;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        if (!xj()) {
            xjVar.hf(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.y yVar = new com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.y(this.xj, this.hf, this.w, this.u);
        int i = this.kd;
        if (i != -1) {
            yVar.hf(i);
        }
        yVar.xj(this.y);
        yVar.hf(this.c);
        if (new com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.hf(new com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.kd(yVar, this.xj, xjVar, map2, this.w), this.hf, this.xj, this.w, map2, xjVar).xj(new HashMap())) {
            xjVar.xj(map2);
            return false;
        }
        xjVar.hf(map2);
        return false;
    }

    private boolean xj() {
        return (this.xj == null || this.hf == null) ? false : true;
    }
}
