package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class g implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "convert_from_downloader")
    private boolean c;

    @com.bytedance.sdk.component.p.hf.xj(xj = "download_adapter")
    private com.bytedance.sdk.openadsdk.core.pl.hf.w d;

    @com.bytedance.sdk.component.p.hf.xj(xj = "is_market_covert")
    private boolean f;

    @com.bytedance.sdk.component.p.hf.xj(xj = "context")
    private Context hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "app_info")
    private JSONObject kd;

    @com.bytedance.sdk.component.p.hf.xj(xj = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.hf.hf p;

    @com.bytedance.sdk.component.p.hf.xj(xj = "convert_tag")
    private String tf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "deep_link")
    private JSONObject u;

    @com.bytedance.sdk.component.p.hf.xj(xj = "event_tag")
    private String w;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    private ws xj;

    @com.bytedance.sdk.component.p.hf.xj(xj = "convert_from_landing_page")
    private boolean y;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.c cVar = new com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.c(com.bytedance.sdk.openadsdk.core.xj.hf(this.kd), this.hf);
        cVar.xj(this.xj);
        cVar.xj(this.w);
        com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.w wVar = new com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.w(cVar, this.xj, this.w, new com.bytedance.sdk.openadsdk.core.ra.zg(this.u), this.hf);
        wVar.hf(this.c);
        wVar.xj(this.y);
        wVar.w(this.f);
        wVar.xj(this.d);
        wVar.xj(this.tf);
        wVar.xj(this.p);
        if (wVar.xj(map2)) {
            xjVar.xj(map2);
            return true;
        }
        xjVar.hf(map2);
        return true;
    }
}
