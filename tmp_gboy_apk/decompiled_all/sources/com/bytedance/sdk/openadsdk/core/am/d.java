package com.bytedance.sdk.openadsdk.core.am;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ss;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d implements com.bytedance.sdk.openadsdk.y.xj {
    private volatile boolean am;
    private JSONArray c;
    private boolean d;
    private JSONArray f;
    private volatile int g;
    private ws hf;
    private Boolean kd;
    private AtomicLong p;

    /* renamed from: pl, reason: collision with root package name */
    private JSONObject f10290pl;
    private int tf;
    private Boolean u;
    private Boolean w;
    private String xj;
    private JSONObject y;

    public d(String str, ws wsVar, JSONObject jSONObject) {
        this.xj = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.w = bool;
        this.u = bool;
        this.kd = bool;
        this.d = false;
        this.p = new AtomicLong();
        this.g = 0;
        this.am = false;
        this.xj = str;
        this.hf = wsVar;
        this.y = jSONObject;
        this.c = new JSONArray();
        this.f = new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        if (this.kd.booleanValue()) {
            return true;
        }
        return this.u.booleanValue() && this.w.booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.w
    public void am() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.22
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "render_failed", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.hf
    public void g() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.21
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "no_native_render", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    public void p() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.15
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d.this.xj(jSONObject, PointParamKey.TYPE, "native_enterBackground");
                    d dVar = d.this;
                    dVar.xj(dVar.c, jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    public void pl() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.16
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d.this.xj(jSONObject, PointParamKey.TYPE, "native_enterForeground");
                    d dVar = d.this;
                    dVar.xj(dVar.c, jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.xj
    public void qt() {
        this.w = Boolean.TRUE;
    }

    public void tf() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.14
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "native_endcard_close", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.xj
    public void zg() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.25
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.e() && !d.this.d) {
                        if (d.this.c != null && d.this.c.length() != 0) {
                            try {
                                d.this.y.put("native_switchBackgroundAndForeground", d.this.c);
                            } catch (Exception unused) {
                            }
                        }
                        if (d.this.f != null && d.this.f.length() != 0) {
                            try {
                                d.this.y.put("intercept_source", d.this.f);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("webview_time_track", d.this.y);
                        com.bytedance.sdk.openadsdk.core.f.zg().yy();
                        u.c(d.this.hf, d.this.xj, "webview_time_track", hashMap);
                        d.this.d = true;
                    }
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.u
    public void c() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.10
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "webview_load_success", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    public void d() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.13
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "native_endcard_show", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.u
    public void f() {
        hf((JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.w
    public void hf() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.12
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "render_success", jSONObject);
                    if (d.this.xj.equals("splash_ad") || d.this.xj.equals("cache_splash_ad")) {
                        return;
                    }
                    if (d.this.y.optInt("webview_source", -1) == 2) {
                        pl.xj(d.this.xj, "no count ENDCARD_SOURCE");
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.x.xj.xj().xj("ugen_render", "h5_render_success", String.valueOf(currentTimeMillis) + Constants.FAIL);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.xj
    public void kd(final String str) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.3
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, str, jSONObject);
                    if (d.this.xj.equals("splash_ad") || d.this.xj.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.x.xj.xj().xj("ugen_render", "native_render_success", String.valueOf(currentTimeMillis) + Constants.FAIL);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.xj
    public void u(final String str) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.2
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.hf
    public void w() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.27
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "native_render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.u
    public void y() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.9
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "webview_load_start", (Object) jSONObject, false);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.u
    public void c(final String str) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.20
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d.this.xj(jSONObject, "jsb", str);
                    d dVar = d.this;
                    dVar.xj(dVar.y, "webview_jsb_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.xj
    public void hf(final String str) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.29
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.hf
    public void kd() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.8
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "native_render_end", jSONObject);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    JSONObject jSONObject2 = new JSONObject();
                    d.this.xj(jSONObject2, "ts", Long.valueOf(currentTimeMillis2));
                    d dVar2 = d.this;
                    dVar2.xj(dVar2.y, "render_success", jSONObject2);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    public void u() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.7
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "native_render_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.xj
    public void w(final String str) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.30
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, str, jSONObject);
                    if (d.this.xj.equals("splash_ad") || d.this.xj.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.x.xj.xj().xj("ugen_render", "native_render_success", String.valueOf(currentTimeMillis) + Constants.FAIL);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.u
    public void y(final String str) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.19
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d.this.xj(jSONObject, "jsb", str);
                    d dVar = d.this;
                    dVar.xj(dVar.y, "webview_jsb_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.xj
    public void hf(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.31
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d.this.xj(jSONObject, PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
                    d dVar = d.this;
                    dVar.xj(dVar.y, str, jSONObject);
                    if (d.this.xj.equals("splash_ad") || d.this.xj.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.x.xj.xj().xj("ugen_render", "native_render_fail", String.valueOf(currentTimeMillis) + "1");
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.xj
    public void u(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.24
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    if (d.this.y == null || (jSONObject2 = jSONObject) == null) {
                        return;
                    }
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        d dVar = d.this;
                        dVar.xj(dVar.y, next, jSONObject.opt(next));
                    }
                    d.this.u = Boolean.TRUE;
                    d.this.zg();
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.xj
    public void w(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.4
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d.this.xj(jSONObject, PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
                    d dVar = d.this;
                    dVar.xj(dVar.y, str, jSONObject);
                    if (d.this.xj.equals("splash_ad") || d.this.xj.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.x.xj.xj().xj("ugen_render", "native_render_fail", String.valueOf(currentTimeMillis) + "1");
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.w
    public void xj() {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.p.set(System.currentTimeMillis());
                    JSONObject jSONObject = new JSONObject();
                    d dVar = d.this;
                    dVar.xj(jSONObject, "ts", Long.valueOf(dVar.p.get()));
                    d dVar2 = d.this;
                    dVar2.xj(jSONObject, "render_sequence", Integer.valueOf(hl.hf(dVar2.hf)));
                    d dVar3 = d.this;
                    dVar3.xj(jSONObject, "render_timeout", Integer.valueOf(dVar3.tf));
                    d.this.xj(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.kd.kd.xj().kd()));
                    d.this.xj(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.kd.kd.xj().w()));
                    ss c = hl.c(d.this.hf);
                    if (c != null) {
                        d.this.xj(jSONObject, "rule_id", c.f());
                    } else {
                        d.this.xj(jSONObject, "rule_id", Constants.FAIL);
                    }
                    d dVar4 = d.this;
                    dVar4.xj(dVar4.y, "render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    public void hf(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.11
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    d.this.xj(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "webview_load_error", jSONObject2);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.w
    public void w(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.23
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    d.this.xj(jSONObject2, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "render_did_finish", jSONObject2);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.w
    public void xj(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.26
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d.this.xj(jSONObject, PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
                    String str2 = str;
                    if (str2 != null) {
                        d.this.xj(jSONObject, MediationConstant.KEY_REASON, str2);
                    }
                    d dVar = d.this;
                    dVar.xj(dVar.y, "render_error", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.u
    public void hf(final String str, final long j, final long j2, final int i) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.18
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "start_ts", Long.valueOf(j));
                    d.this.xj(jSONObject, "end_ts", Long.valueOf(j2));
                    d.this.xj(jSONObject, "intercept_type", Integer.valueOf(i));
                    d.this.xj(jSONObject, PointParamKey.TYPE, "intercept_js");
                    d.this.xj(jSONObject, "url", str);
                    d.this.xj(jSONObject, MediationConstant.EXTRA_DURATION, Long.valueOf(j2 - j));
                    d dVar = d.this;
                    dVar.xj(dVar.f, jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.xj
    public void xj(final String str) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.28
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d dVar = d.this;
                    dVar.xj(dVar.y, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.xj
    public void hf(boolean z) {
        try {
            if (!this.am && this.hf != null) {
                this.am = true;
                if (hl.hf(this.hf) == 0 && this.g != 0) {
                    if (this.f10290pl == null) {
                        this.f10290pl = new JSONObject();
                    }
                    this.f10290pl.put("render_sequence", hl.hf(this.hf));
                    this.f10290pl.put("render_control", hl.xj(this.hf));
                    this.f10290pl.put("fetch_tpl_time_out", pz.hf().xj(this.xj, hl.hf(this.hf)));
                    this.f10290pl.put("req_id", this.hf.zf());
                    this.f10290pl.put(MediationConstant.EXTRA_ADID, this.hf.ho());
                    this.f10290pl.put("ad_slot_type", wo.f(this.hf));
                    if (z) {
                        this.f10290pl.put("webview_time_cost", System.currentTimeMillis() - this.p.get());
                        this.f10290pl.put("webview_result", 2);
                    }
                    am.xj().xj(this.f10290pl);
                }
            }
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.xj
    public void xj(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.xj(jSONObject, "ts", Long.valueOf(System.currentTimeMillis()));
                    d dVar = d.this;
                    dVar.xj(dVar.y, "render_exception", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.u
    public void xj(final int i) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.6
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    d.this.xj(jSONObject, "isWebViewCache", Integer.valueOf(i));
                    if (d.this.hf != null) {
                        if (hl.f(d.this.hf)) {
                            d.this.xj(jSONObject, "engine_version", "v3");
                        } else {
                            d.this.xj(jSONObject, "engine_version", "v1");
                        }
                    }
                    d dVar = d.this;
                    dVar.xj(dVar.y, "before_webview_request", jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    public d() {
        this.xj = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.w = bool;
        this.u = bool;
        this.kd = bool;
        this.d = false;
        this.p = new AtomicLong();
        this.g = 0;
        this.am = false;
    }

    @Override // com.bytedance.sdk.openadsdk.y.u.u
    public void xj(final String str, final long j, final long j2, final int i) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.d.17
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    d.this.xj(jSONObject, "start_ts", Long.valueOf(j));
                    d.this.xj(jSONObject, "end_ts", Long.valueOf(j2));
                    d.this.xj(jSONObject, "intercept_type", Integer.valueOf(i));
                    d.this.xj(jSONObject, PointParamKey.TYPE, "intercept_html");
                    d.this.xj(jSONObject, "url", str);
                    d.this.xj(jSONObject, MediationConstant.EXTRA_DURATION, Long.valueOf(j2 - j));
                    d dVar = d.this;
                    dVar.xj(dVar.f, jSONObject);
                }
            });
        } catch (Throwable th) {
            pl.hf("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.xj
    public void xj(boolean z) {
        this.kd = Boolean.valueOf(z);
    }

    @Override // com.bytedance.sdk.openadsdk.y.xj
    public void xj(boolean z, int i) {
        try {
            if (this.f10290pl == null) {
                this.f10290pl = new JSONObject();
            }
            this.f10290pl.put("error_code", i);
            this.f10290pl.put("webview_time_cost", System.currentTimeMillis() - this.p.get());
            this.f10290pl.put("webview_result", !z ? 1 : 0);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.y.xj
    public void xj(int i, int i2, String str) {
        try {
            this.g = i;
            if (this.f10290pl == null) {
                this.f10290pl = new JSONObject();
            }
            this.f10290pl.put("render_type", i);
            this.f10290pl.put("error_code", i2);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public void hf(int i) {
        this.tf = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception e) {
                pl.hf("WebviewTimeTrack", e.getMessage());
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    public void xj(JSONObject jSONObject, String str, Object obj) {
        xj(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception e) {
            pl.hf("WebviewTimeTrack", e.getMessage());
        }
    }
}
