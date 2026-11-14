package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "download_url")
    private String c;

    @com.bytedance.sdk.component.p.hf.xj(xj = "is_show_download_dialog")
    private boolean d = true;

    @com.bytedance.sdk.component.p.hf.xj(xj = "start_download_listener")
    private com.bytedance.sdk.openadsdk.core.pl.w.xj.hf f;

    @com.bytedance.sdk.component.p.hf.xj(xj = "download_dialog_listener")
    private com.bytedance.sdk.openadsdk.core.pl.w.xj.xj g;

    @com.bytedance.sdk.component.p.hf.xj(xj = "context")
    private Context hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "app_manage_model")
    private com.bytedance.sdk.openadsdk.core.ra.u kd;

    @com.bytedance.sdk.component.p.hf.xj(xj = "dynamic_download_dialog_type")
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    @com.bytedance.sdk.component.p.hf.xj(xj = "is_direct_download")
    private boolean f10347pl;

    @com.bytedance.sdk.component.p.hf.xj(xj = "is_from_new_click_event")
    private boolean tf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "is_app_market_convert")
    private boolean u;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    private ws w;

    @com.bytedance.sdk.component.p.hf.xj(xj = "convert_from_landing_page")
    protected boolean xj;

    @com.bytedance.sdk.component.p.hf.xj(xj = "event_tag")
    private String y;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        com.bytedance.sdk.openadsdk.core.pl.w.w.w wVar = new com.bytedance.sdk.openadsdk.core.pl.w.w.w(this.hf, this.w);
        wVar.w(this.f10347pl);
        wVar.xj(this.d);
        wVar.xj(this.p);
        wVar.hf(this.tf);
        wVar.xj(this.g);
        wVar.xj(xj());
        if (!wVar.u(false)) {
            xjVar.hf(map2);
            return true;
        }
        wVar.xj(this.kd, this.y, this.c, this.f);
        xjVar.xj(map2);
        return true;
    }

    private com.bytedance.sdk.openadsdk.core.pl.w.w.xj xj() {
        if (this.u) {
            return new com.bytedance.sdk.openadsdk.core.pl.w.w.kd();
        }
        if (this.xj) {
            return new com.bytedance.sdk.openadsdk.core.pl.w.w.u();
        }
        return new com.bytedance.sdk.openadsdk.core.pl.w.w.hf();
    }
}
