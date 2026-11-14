package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.gh;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private static volatile boolean xj;

    public static void hf(gh ghVar, long j) {
        if (ghVar == null) {
            return;
        }
        ghVar.w(j);
    }

    public static void u(gh ghVar, long j) {
        if (ghVar != null) {
            ghVar.zg(System.currentTimeMillis() - j);
        }
    }

    public static void w(gh ghVar, long j) {
        if (ghVar == null) {
            return;
        }
        ghVar.p(j);
    }

    public static void xj(Context context, gh ghVar, ws wsVar, boolean z, long j) {
        if (context == null || wsVar == null || ghVar == null || !pz.hf().gh()) {
            return;
        }
        boolean z2 = ghVar.u() == 1;
        boolean z3 = ghVar.f() == 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("splash_load_type", ghVar.xj());
            jSONObject.put("server_load_type", ghVar.hf());
            jSONObject.put("tmax_type", ghVar.l());
            if (z) {
                jSONObject.put("splash_final_type", "cache_ad");
            } else {
                jSONObject.put("splash_final_type", "real_time_ad");
            }
            jSONObject.put("active_type", ghVar.w());
            jSONObject.put("splash_creative_type", ghVar.u());
            if (ghVar.ra() > 0) {
                if (ghVar.ra() == 22) {
                    jSONObject.put("check_cloud_error_code", ghVar.ai());
                }
                jSONObject.put("splash_get_cache_error_code", ghVar.ra());
            }
            if (z2) {
                if (z3) {
                    jSONObject.put("cache_image_duration", ghVar.c());
                } else {
                    jSONObject.put("download_image_duration", ghVar.y());
                    jSONObject.put("download_client_start_time", ghVar.zg());
                    jSONObject.put("download_net_time", ghVar.e());
                    jSONObject.put("download_client_end_time", ghVar.yo());
                    jSONObject.put("img_conttype", ghVar.x());
                    jSONObject.put("img_net_bframe_time", ghVar.q());
                    jSONObject.put("img_net_aframe_time", ghVar.z());
                }
                if (!z) {
                    jSONObject.put("client_start_time", ghVar.pl());
                    jSONObject.put("network_time", ghVar.g());
                    jSONObject.put("sever_time", ghVar.am());
                    jSONObject.put("client_end_time", ghVar.qt());
                }
                jSONObject.put("load_duration", ghVar.kd());
                jSONObject.put("image_resolution", ghVar.tf());
                jSONObject.put("image_cachetype", ghVar.f());
                jSONObject.put("image_size", ghVar.d());
            }
            if (ghVar.dk() > 0) {
                jSONObject.put("real_user_duration", j - ghVar.dk());
            }
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("switch_thread_time", ghVar.et());
            jSONObject.put("on_call_back_time", ghVar.io());
            jSONObject.put("load_suc_time", ghVar.j());
            jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.u.xj.u());
        } catch (Exception e) {
            pl.xj(e);
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, "splash_ad", "splash_ad_loadtime", j - ghVar.jk(), jSONObject);
    }

    public static void hf(ws wsVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.u uVar) {
        if (wsVar == null || uVar == null || !pz.hf().gh()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_material_duration", uVar.u());
            jSONObject.put("load_resource_duration", uVar.kd());
            jSONObject.put("render_duration", uVar.y());
            jSONObject.put("ren_seq", uVar.hf());
            jSONObject.put("real_ren_seq", uVar.w());
            jSONObject.put("final_t", uVar.f() ? "cache_ad" : "real_time_ad");
            jSONObject.put("load_t", uVar.d());
            jSONObject.put("meta_load_Optimization", wsVar.zb());
            jSONObject.put("serial_render", uVar.tf());
        } catch (Exception e) {
            pl.xj(e);
        }
        com.bytedance.sdk.openadsdk.core.am.u.w(wsVar, "splash_ad", "splash_total_duration", uVar.c(), jSONObject);
    }

    public static void xj(gh ghVar) {
        if (ghVar == null) {
            return;
        }
        ghVar.xj(System.currentTimeMillis() - ghVar.jk());
    }

    public static void xj(gh ghVar, gh ghVar2) {
        if (ghVar == null || ghVar2 == null) {
            return;
        }
        ghVar.pl(System.currentTimeMillis());
        ghVar2.pl(System.currentTimeMillis());
        if (v.w.get()) {
            ghVar.w(0);
            ghVar2.w(0);
            v.w.set(false);
        } else {
            ghVar.w(1);
            ghVar2.w(1);
        }
    }

    public static void xj(gh ghVar, long j) {
        if (ghVar == null) {
            return;
        }
        ghVar.hf(j);
    }

    public static void xj(gh ghVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar) {
        if (ghVar == null || fVar == null) {
            return;
        }
        if (fVar.kd()) {
            ghVar.u(2);
        } else {
            ghVar.u(1);
        }
    }

    public static void xj(gh ghVar, boolean z) {
        if (ghVar == null) {
            return;
        }
        if (z) {
            ghVar.kd(1);
        } else {
            ghVar.kd(2);
        }
    }

    public static void xj(gh ghVar, com.bytedance.sdk.openadsdk.core.et.xj.hf hfVar, Map<String, String> map) {
        if (hfVar == null || ghVar == null) {
            return;
        }
        int hf = hfVar.hf();
        if (ghVar.d() == 0.0d) {
            ghVar.xj(hf / 1024.0f);
        }
        Bitmap xj2 = hfVar.xj();
        if (xj2 != null && TextUtils.isEmpty(ghVar.tf())) {
            ghVar.xj(xj2.getWidth() + "X" + xj2.getHeight());
        }
        if (map == null || map.size() <= 0 || ghVar.p() != null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (Exception unused) {
                }
            }
        }
        ghVar.xj(jSONObject);
    }

    public static void xj(gh ghVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar) {
        if (ghVar == null || yVar == null) {
            return;
        }
        long y = yVar.y();
        long f = yVar.f();
        long c = yVar.c();
        long d = yVar.d();
        ghVar.u(y);
        ghVar.kd(c);
        ghVar.y(f);
        ghVar.c(d);
    }

    public static void xj(ws wsVar, gh ghVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar) {
        if (wsVar == null || ghVar == null || fVar == null || fVar.kd() || ghVar.f() == 1 || !pz.hf().gh()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("image_size", ghVar.d());
            jSONObject.put("image_resolution", ghVar.tf());
            jSONObject.put("download_client_start_time", ghVar.zg());
            jSONObject.put("download_net_time", ghVar.e());
            jSONObject.put("download_client_end_time", ghVar.yo());
        } catch (Exception e) {
            pl.xj(e);
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, "splash_ad", "download_image_duration", System.currentTimeMillis() - ghVar.v(), jSONObject);
    }

    public static void xj(gh ghVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, long j) {
        if (ghVar == null || fVar == null) {
            return;
        }
        long c = fVar.c();
        ghVar.tf(j - c);
        ghVar.jk(fVar.f() - c);
    }

    public static void xj(boolean z, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar) {
        if (hfVar == null || cVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = xj(hfVar, z ? 4 : 3, wsVar);
        if (xj2 == null) {
            return;
        }
        am.xj().w(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.y.1
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                int i;
                int i2;
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar2 = com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c.this;
                if (cVar2 != null) {
                    i = cVar2.c();
                    i2 = com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c.this.u();
                } else {
                    i = 1;
                    i2 = -1;
                }
                try {
                    jSONObject.put("if_have_cache", i);
                    jSONObject.put("if_have_rt_ads", i2);
                } catch (Throwable unused) {
                }
                return xj2.hf(jSONObject.toString());
            }
        });
    }

    private static com.bytedance.sdk.openadsdk.core.ht.xj.hf xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, int i, ws wsVar) {
        String str;
        String str2;
        String str3;
        if (wsVar != null) {
            str = wsVar.ho();
            str3 = wsVar.jf();
            str2 = wo.g(wsVar);
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = wo.f();
        }
        com.bytedance.sdk.openadsdk.core.ht.xj.hf w = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().y(str2).xj(i).w(hfVar.u());
        if (str != null) {
            w.u(str);
        }
        if (str3 != null) {
            w.f(str3);
        }
        return w;
    }

    public static void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final long j) {
        if (hfVar == null) {
            return;
        }
        am.xj().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.y.2
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("publisher_timeout_control", j);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(3).w(hfVar.u()).y(wo.f()).hf(jSONObject.toString());
            }
        });
    }

    public static void xj(gh ghVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, long j, ws wsVar) {
        if (fVar == null || ghVar == null || wsVar == null) {
            return;
        }
        if (!fVar.kd()) {
            c.xj(j, false, true, wsVar, 0L, "loadSuccess");
            if (!fVar.y()) {
                xj(ghVar, SystemClock.elapsedRealtime() - j);
                com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, "splash_ad", SystemClock.elapsedRealtime() - j);
            } else {
                hf(ghVar, SystemClock.elapsedRealtime() - j);
            }
        }
        xj(ghVar, fVar.y());
        xj(ghVar, fVar.u(), fVar.d());
        xj(ghVar, fVar, System.currentTimeMillis());
        xj(ghVar, fVar.g());
    }

    public static void xj(gh ghVar, String str) {
        if (ghVar == null) {
            return;
        }
        ghVar.hf(str);
    }

    public static void xj(boolean z, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final boolean z2, final boolean z3) {
        if (wsVar == null || hfVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = xj(hfVar, z ? 4 : 3, wsVar);
        if (xj2 == null) {
            return;
        }
        am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.y.3
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!z3) {
                        jSONObject.put("image_CacheType", z2 ? 1 : 2);
                    }
                } catch (Throwable unused) {
                }
                return xj2.hf(jSONObject.toString());
            }
        });
    }

    public static void xj(boolean z, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (wsVar == null || hfVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = xj(hfVar, z ? 4 : 3, wsVar);
        if (xj2 == null) {
            return;
        }
        am.xj().u(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.y.4
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.this;
            }
        });
    }

    public static void xj(ws wsVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.u uVar) {
        if (uVar == null || wsVar == null || !pz.hf().gh()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_control", uVar.xj());
            jSONObject.put("render_sequence", uVar.hf());
            jSONObject.put("real_render_sequence", uVar.w());
        } catch (Exception e) {
            pl.xj(e);
        }
        com.bytedance.sdk.openadsdk.core.am.u.hf(wsVar, "splash_ad", "splash_render_duration", uVar.y(), jSONObject);
    }

    public static void xj(ws wsVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.u uVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d dVar) {
        if (wsVar == null || dVar == null) {
            return;
        }
        if (hl.xj(wsVar) == 1) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "自渲染 ");
            uVar.w(99);
        } else if (dVar.hf()) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "模版兜底 ");
            uVar.w(99);
        } else {
            int hf = hl.hf(wsVar);
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "模版渲染 ".concat(String.valueOf(hf)));
            uVar.w(hf);
        }
    }

    public static void xj(gh ghVar, gh ghVar2, tj tjVar, int i, int i2) {
        if (ghVar == null || ghVar2 == null) {
            return;
        }
        ghVar.xj(i);
        ghVar.hf(i2);
        ghVar.qt(tjVar.f);
        ghVar2.xj(i);
        ghVar2.hf(i2);
        ghVar2.qt(tjVar.f);
    }

    public static void xj(gh ghVar, int i) {
        if (ghVar == null || ghVar.l() >= i) {
            return;
        }
        ghVar.c(i);
    }

    public static void xj(int i, ws wsVar, String str, int i2) {
        if (i == 2) {
            if (xj) {
                return;
            } else {
                xj = true;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_type", i);
            if (i == 1) {
                jSONObject.put("show_cnt", i2);
            }
            com.bytedance.sdk.openadsdk.core.am.u.w(wsVar, str, jSONObject);
        } catch (JSONException unused) {
        }
    }
}
