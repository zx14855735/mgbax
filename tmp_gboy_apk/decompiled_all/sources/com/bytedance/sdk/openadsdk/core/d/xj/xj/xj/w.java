package com.bytedance.sdk.openadsdk.core.d.xj.xj.xj;

import J3FDQU.A2egSU;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.hf;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.xj;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.ff;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ra.a;
import com.bytedance.sdk.openadsdk.core.ra.dc;
import com.bytedance.sdk.openadsdk.core.ra.ht;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.zg;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements com.bytedance.sdk.openadsdk.core.d.xj.xj.xj {
    private boolean d;
    private com.bytedance.sdk.openadsdk.core.video.hf.hf g;
    private ws hf;
    private zg kd;
    private com.bytedance.sdk.openadsdk.core.pl.hf.w p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10348pl;
    private boolean tf;
    private Context u;
    private String w;
    private com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xj;
    private boolean y = false;
    private boolean c = false;
    private Function<SparseArray<Object>, Object> f = com.bytedance.sdk.openadsdk.core.f.zg().r();

    public w(com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar, ws wsVar, String str, zg zgVar, Context context) {
        this.xj = xjVar;
        this.hf = wsVar;
        this.w = str;
        this.u = context;
        this.kd = zgVar;
    }

    public void hf(boolean z) {
        this.c = z;
    }

    public void w(boolean z) {
        this.d = z;
    }

    private boolean hf() {
        String w = ht.w(this.hf, this.f10348pl);
        ws wsVar = this.hf;
        Context context = this.u;
        String str = this.w;
        com.bytedance.sdk.openadsdk.core.d.xj.xj.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.d.xj.xj.hf.xj(wsVar, context, str, wo.hf(str));
        xjVar.w(true);
        xjVar.xj(w);
        xjVar.xj(this.g);
        return xjVar.xj((Map<String, Object>) new HashMap());
    }

    private String w(String str) {
        ws wsVar;
        a lv;
        if (!TextUtils.isEmpty(str) && (wsVar = this.hf) != null && dc.xj(wsVar) && (lv = this.hf.lv()) != null) {
            try {
                String w = lv.w();
                String u = lv.u();
                Map<String, String> xj = b.xj(str);
                xj.put("live_short_touch_params", w);
                xj.put("extra_pangle_scheme_params", u);
                String xj2 = b.xj(str, xj);
                com.bytedance.sdk.openadsdk.core.hf.xj().put("is_reward_deep_link_to_live", true);
                return xj2;
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.video.hf.hf hfVar) {
        this.g = hfVar;
    }

    public void xj(boolean z) {
        this.y = z;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.pl.hf.w wVar) {
        this.p = wVar;
    }

    public void xj(String str) {
        this.f10348pl = str;
    }

    private zg xj() {
        zg zgVar = this.kd;
        return zgVar == null ? new zg() : zgVar;
    }

    public String hf(String str) {
        Uri parse;
        return (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) ? "" : parse.getScheme().toLowerCase(Locale.US);
    }

    public Boolean xj(Map<String, Object> map, String str, JSONObject jSONObject) {
        String w = w(str);
        if (TextUtils.isEmpty(w)) {
            return null;
        }
        zg.xj((String) null);
        Uri parse = Uri.parse(w);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        if (this.y) {
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.hf, this.w, "lp_open_dpl", hf(w));
        }
        boolean hf = wo.hf(this.u);
        try {
            jSONObject.putOpt("is_lp", Boolean.valueOf(this.y));
            jSONObject.putOpt("can_qry_pkg", Boolean.valueOf(hf));
        } catch (Exception unused) {
        }
        if (hf) {
            boolean xj = wo.xj(this.u, intent);
            try {
                jSONObject.putOpt("installed", Boolean.valueOf(xj));
            } catch (Exception unused2) {
            }
            if (xj) {
                return xj(map, intent, true, jSONObject);
            }
            xj(map, true, (Throwable) null);
            xj(1);
            return null;
        }
        try {
            jSONObject.putOpt("installed_douyin", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.live.kd.xj.xj(w)));
            String dk = wo.dk(this.hf);
            if (dk != null && dk.length() > 0) {
                jSONObject.putOpt("installed_other", Boolean.valueOf(wo.xj(dk)));
            }
            jSONObject.putOpt("pkg", dk);
        } catch (Throwable unused3) {
        }
        return xj(map, intent, false, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(final Intent intent) {
        String str;
        String concat;
        ws wsVar = this.hf;
        if (wsVar == null || this.u == null || intent == null) {
            return;
        }
        if (wsVar.vh() != null) {
            str = this.hf.vh().w();
        } else {
            str = "";
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            concat = "是否立即打开应用";
        } else {
            concat = "是否立即打开".concat(String.valueOf(str2));
        }
        String str3 = concat;
        com.bytedance.sdk.openadsdk.core.a.y.xj(this.u, this.hf.ho(), str2, str3, "立即打开", "退出", new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.w.3
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                com.bytedance.sdk.openadsdk.core.am.u.f(w.this.hf, w.this.w, "open_url_app", A2egSU.BI9f7h(n.l, "DeepLinkConverter"));
                com.bytedance.sdk.component.utils.hf.xj(w.this.u, intent, new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.w.3.1
                    @Override // com.bytedance.sdk.component.utils.hf.xj
                    public void xj() {
                        com.bytedance.sdk.openadsdk.core.am.c.xj().xj(w.this.hf, w.this.w, false);
                        com.bytedance.sdk.openadsdk.core.am.u.xj(w.this.hf, w.this.w, "deeplink_success_realtime", (Throwable) null);
                    }

                    @Override // com.bytedance.sdk.component.utils.hf.xj
                    public void xj(Throwable th) {
                        com.bytedance.sdk.openadsdk.core.am.u.xj(w.this.hf, w.this.w, "deeplink_fail_realtime", th);
                    }
                }, TextUtils.equals("main", "internal"));
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
            }
        });
    }

    private Boolean xj(JSONObject jSONObject) {
        Boolean valueOf;
        try {
            jSONObject.putOpt("tag", this.f10348pl);
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(this.f10348pl) || !ht.xj(this.hf, this.f10348pl)) {
            return null;
        }
        int hf = ht.hf(this.hf, this.f10348pl);
        if (hf != 1) {
            valueOf = xj(new HashMap(), ht.w(this.hf, this.f10348pl), jSONObject);
        } else {
            valueOf = Boolean.valueOf(hf());
        }
        try {
            jSONObject.putOpt("convert_type", Integer.valueOf(hf));
            jSONObject.putOpt("dpl_result", valueOf);
        } catch (JSONException unused2) {
        }
        return valueOf;
    }

    private Boolean xj(final Map<String, Object> map, Intent intent, final boolean z, JSONObject jSONObject) {
        wo.hf(intent);
        xj(intent);
        HashMap hashMap = new HashMap();
        hashMap.put(n.l, "DeepLinkConverter");
        if (this.c) {
            boolean xj = xj(this.w, "open_fallback_url", this.hf, map);
            if (!xj) {
                com.bytedance.sdk.openadsdk.core.am.u.f(this.hf, this.w, "open_url_app", hashMap);
            }
            try {
                jSONObject.putOpt("intercept", Boolean.valueOf(xj));
            } catch (JSONException unused) {
            }
        } else {
            com.bytedance.sdk.openadsdk.core.am.u.f(this.hf, this.w, "open_url_app", hashMap);
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.hf.xj(this.u, intent, new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.w.1
            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj() {
                atomicBoolean.set(true);
                if (w.this.y) {
                    com.bytedance.sdk.openadsdk.core.am.u.xj(w.this.hf, w.this.w, "lp_openurl", (Throwable) null);
                    com.bytedance.sdk.openadsdk.core.am.u.xj(w.this.hf, w.this.w, "lp_deeplink_success_realtime", (Throwable) null);
                } else {
                    com.bytedance.sdk.openadsdk.core.am.u.xj(w.this.hf, w.this.w, "deeplink_success_realtime", (Throwable) null);
                }
                com.bytedance.sdk.openadsdk.core.am.c.xj().xj(w.this.hf, w.this.w, w.this.y);
                w.this.xj(0);
            }

            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj(Throwable th) {
                atomicBoolean.set(false);
                w.this.xj((Map<String, Object>) map, z, th);
                w.this.xj(3);
            }
        }, TextUtils.equals("main", "internal"));
        return Boolean.valueOf(atomicBoolean.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i) {
        ws wsVar = this.hf;
        if (wsVar == null || wsVar.kn() != 1) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.hf, this.w, 1, 1, i, ai.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(java.util.Map<java.lang.String, java.lang.Object> r4, boolean r5, java.lang.Throwable r6) {
        /*
            r3 = this;
            boolean r0 = r3.c
            if (r0 == 0) goto Lf
            if (r5 != 0) goto Lf
            com.bytedance.sdk.openadsdk.core.ra.ws r5 = r3.hf
            java.lang.String r0 = r3.w
            java.lang.String r1 = "open_fallback_download"
            com.bytedance.sdk.openadsdk.core.am.u.w(r5, r0, r1)
        Lf:
            boolean r5 = r3.c
            java.lang.String r0 = "open_fallback_url"
            if (r5 == 0) goto L2f
            com.bytedance.sdk.openadsdk.core.ra.ws r5 = r3.hf
            java.lang.String r1 = r3.w
            java.lang.String r2 = "lp_openurl_failed"
            com.bytedance.sdk.openadsdk.core.am.u.w(r5, r1, r2)
            boolean r5 = r3.tf
            if (r5 != 0) goto L37
            java.lang.String r5 = r3.w
            com.bytedance.sdk.openadsdk.core.ra.ws r1 = r3.hf
            boolean r4 = r3.xj(r5, r0, r1, r4)
            if (r4 != 0) goto L37
            r4 = 1
            r3.tf = r4
        L2f:
            com.bytedance.sdk.openadsdk.core.ra.ws r4 = r3.hf
            java.lang.String r5 = r3.w
            r1 = 0
            com.bytedance.sdk.openadsdk.core.am.u.f(r4, r5, r0, r1)
        L37:
            boolean r4 = r3.d
            if (r4 == 0) goto L3c
            return
        L3c:
            boolean r4 = r3.c
            if (r4 == 0) goto L47
            boolean r4 = r3.y
            if (r4 == 0) goto L47
            java.lang.String r4 = "lp_deeplink_fail_realtime"
            goto L49
        L47:
            java.lang.String r4 = "deeplink_fail_realtime"
        L49:
            com.bytedance.sdk.openadsdk.core.ra.ws r5 = r3.hf
            java.lang.String r0 = r3.w
            com.bytedance.sdk.openadsdk.core.am.u.xj(r5, r0, r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.w.xj(java.util.Map, boolean, java.lang.Throwable):void");
    }

    private boolean xj(String str, String str2, ws wsVar, Map<String, Object> map) {
        Object apply;
        if (this.f != null) {
            apply = this.f.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(2).xj(Boolean.class).xj(0, new en().xj("tagIntercept", str).xj("label", str2).xj("hashCode", Integer.valueOf(xj.w(map))).xj("meta", wsVar.ac().toString())).hf());
            if (apply != null && ((Boolean) apply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public void xj(final Intent intent) {
        final com.bytedance.sdk.openadsdk.core.a.xj u;
        final long currentTimeMillis = System.currentTimeMillis();
        ws wsVar = this.hf;
        if (wsVar == null || intent == null || this.u == null) {
            return;
        }
        zg yt = wsVar.yt();
        if (yt != null && yt.w() == 2 && !yt.xj() && com.bytedance.sdk.openadsdk.core.hf.xj().get("dpl_reject_by_dialog", false)) {
            ff.xj(this.hf, this.w);
        } else if (this.hf.xe() && (u = com.bytedance.sdk.openadsdk.core.f.zg().u()) != null) {
            u.xj(new xj.InterfaceC0134xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.w.2
                @Override // com.bytedance.sdk.openadsdk.core.a.xj.InterfaceC0134xj
                public void xj() {
                    if (System.currentTimeMillis() - currentTimeMillis <= 3000) {
                        w.this.hf(intent);
                    }
                    com.bytedance.sdk.openadsdk.core.a.xj xjVar = u;
                    if (xjVar != null) {
                        xjVar.w();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj
    public boolean xj(Map<String, Object> map) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean xj = xj(jSONObject);
            try {
                if (xj != null && xj.booleanValue()) {
                    try {
                        jSONObject.putOpt("dpa_sub", Boolean.TRUE);
                    } catch (Exception unused) {
                    }
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.hf.vu()));
                    jSONObject.putOpt("req_id", this.hf.zf());
                    valueOf = Boolean.valueOf(this.hf.xj());
                } else {
                    zg xj2 = xj();
                    if (xj2 == null) {
                        xj2 = this.hf.yt();
                    }
                    if (xj2 != null && !TextUtils.isEmpty(xj2.hf())) {
                        String hf = xj2.hf();
                        Boolean xj3 = xj(map, hf, jSONObject);
                        try {
                            jSONObject.putOpt("dpl_result", xj3);
                            jSONObject.putOpt("url", hf);
                        } catch (Exception unused2) {
                        }
                        if (xj2.kd() == 2 && this.p != null && !this.c && (xj3 == null || !xj3.booleanValue())) {
                            this.p.u(false);
                            this.p.xj(this.hf, com.bytedance.sdk.openadsdk.core.d.xj.u.xj.xj(map));
                            jSONObject.putOpt("uchain", Boolean.TRUE);
                            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.hf.vu()));
                            jSONObject.putOpt("req_id", this.hf.zf());
                            valueOf = Boolean.valueOf(this.hf.xj());
                        } else {
                            if (xj3 != null && !this.c) {
                                return xj3.booleanValue();
                            }
                            if (this.c && (xj3 == null || !xj3.booleanValue())) {
                                try {
                                    jSONObject.putOpt("uchain", Boolean.TRUE);
                                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.hf.vu()));
                                    jSONObject.putOpt("req_id", this.hf.zf());
                                    jSONObject.putOpt("web_meta", Boolean.valueOf(this.hf.xj()));
                                } catch (Exception unused3) {
                                }
                                am.xj().xj("open_detail_page", "native", 0, jSONObject);
                                com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar = this.xj;
                                return xjVar != null && xjVar.xj(map);
                            }
                            try {
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.hf.vu()));
                                jSONObject.putOpt("req_id", this.hf.zf());
                                jSONObject.putOpt("web_meta", Boolean.valueOf(this.hf.xj()));
                            } catch (Exception unused4) {
                            }
                            am.xj().xj("open_detail_page", "native", 0, jSONObject);
                            return false;
                        }
                    }
                    try {
                        jSONObject.putOpt("dpl_null", Boolean.TRUE);
                    } catch (Exception unused5) {
                    }
                    com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar2 = this.xj;
                    r9 = xjVar2 != null && xjVar2.xj(map);
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.hf.vu()));
                    jSONObject.putOpt("req_id", this.hf.zf());
                    valueOf = Boolean.valueOf(this.hf.xj());
                }
                jSONObject.putOpt("web_meta", valueOf);
            } catch (Exception unused6) {
            }
            am.xj().xj("open_detail_page", "native", 0, jSONObject);
            return r9;
        } finally {
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.hf.vu()));
                jSONObject.putOpt("req_id", this.hf.zf());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.hf.xj()));
            } catch (Exception unused7) {
            }
            am.xj().xj("open_detail_page", "native", 0, jSONObject);
        }
    }
}
