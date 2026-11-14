package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.hf.hf am;

    @com.bytedance.sdk.component.p.hf.xj(xj = "is_click_button")
    private volatile boolean d;

    @com.bytedance.sdk.component.p.hf.xj(xj = "is_open_oppo_market_auto_download")
    private volatile boolean f;

    @com.bytedance.sdk.component.p.hf.xj(xj = "dialog_to_landing_page_convert")
    private com.bytedance.sdk.openadsdk.core.d.xj.xj.xj g;

    @com.bytedance.sdk.component.p.hf.xj(xj = "context")
    protected Context hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "download_status_listener")
    protected DownloadStatusChangeListener kd;

    @com.bytedance.sdk.component.p.hf.xj(xj = "download_conf")
    private JSONObject p;

    /* renamed from: pl, reason: collision with root package name */
    @com.bytedance.sdk.component.p.hf.xj(xj = "app_info")
    private JSONObject f10343pl;

    @com.bytedance.sdk.component.p.hf.xj(xj = "download_url")
    private String tf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "event_tag")
    protected String u;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    protected ws xj;

    @com.bytedance.sdk.component.p.hf.xj(xj = "download_popup_manager")
    protected com.bytedance.sdk.openadsdk.core.pl.w.w.w y;

    @com.bytedance.sdk.component.p.hf.xj(xj = "convert_from_landing_page")
    protected volatile boolean w = false;

    @com.bytedance.sdk.component.p.hf.xj(xj = "need_check_compliance")
    private int c = 0;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        if (!xj()) {
            xjVar.hf(map2);
            return true;
        }
        int w = com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.xj.w(map2);
        com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.u uVar = new com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.u(this.xj, this.hf, this.u, this.y, this.tf);
        uVar.hf(this.d);
        uVar.xj(this.f, w);
        uVar.xj(this.kd);
        uVar.xj(this.w);
        uVar.xj(this.c);
        uVar.xj(this.g);
        uVar.xj(new jk(this.p));
        if (new com.bytedance.sdk.openadsdk.core.d.xj.xj.hf.hf(uVar, this.am).xj(map2)) {
            xjVar.xj(map2);
        } else {
            xjVar.hf(map2);
        }
        return true;
    }

    private boolean xj() {
        if (this.xj == null || this.hf == null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.tf)) {
            return (TextUtils.isEmpty(this.u) || this.y == null) ? false : true;
        }
        com.bytedance.sdk.openadsdk.core.ra.kd hf = com.bytedance.sdk.openadsdk.core.xj.hf(this.f10343pl);
        if (hf != null) {
            this.tf = hf.hf();
        }
        return false;
    }
}
