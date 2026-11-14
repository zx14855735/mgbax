package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hl {
    private ss c;
    private JSONObject f;
    private int hf;
    private int kd;
    private int u;
    private int w;
    private int xj;
    private nb y;

    public hl(JSONObject jSONObject, String str, tj tjVar) {
        this.xj = 2;
        this.hf = 0;
        this.w = 1;
        this.u = 0;
        this.kd = 100;
        if (jSONObject == null) {
            return;
        }
        this.xj = jSONObject.optInt("render_control", tjVar != null ? tjVar.y : 1);
        JSONObject optJSONObject = jSONObject.optJSONObject("render");
        if (optJSONObject != null) {
            this.hf = optJSONObject.optInt("render_sequence", 0);
            this.w = optJSONObject.optInt("backup_render_control", 1);
            this.u = optJSONObject.optInt("render_thread", 0);
            this.kd = optJSONObject.optInt("reserve_time", 100);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("tpl_info");
        if (optJSONObject2 != null) {
            nb nbVar = new nb();
            nbVar.hf(optJSONObject2.optString(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a));
            nbVar.w(optJSONObject2.optString(TKDownloadReason.KSAD_TK_MD5));
            nbVar.u(optJSONObject2.optString("url"));
            nbVar.kd(optJSONObject2.optString(PointParamKey.DATA));
            nbVar.y(optJSONObject2.optString("diff_data"));
            nbVar.c(optJSONObject2.optString("dynamic_creative"));
            nbVar.xj(optJSONObject2.optString("version"));
            nbVar.f(optJSONObject2.optString("material_type"));
            nbVar.d(optJSONObject2.optString("ugen_url"));
            nbVar.tf(optJSONObject2.optString("ugen_md5"));
            nbVar.pl(optJSONObject2.optString("express_gesture_priority"));
            nbVar.p(optJSONObject2.optString("engine_version"));
            this.y = nbVar;
            com.bytedance.sdk.component.adexpress.xj.w.u xj = xj(str);
            if (xj != null) {
                com.bytedance.sdk.component.adexpress.xj.hf.hf.xj(xj);
            }
            com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(nbVar.d(), nbVar.tf(), (com.bytedance.sdk.openadsdk.core.ugeno.w) null);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("tpl_info_v3");
        if (optJSONObject3 != null) {
            ss xj2 = ss.xj(optJSONObject3);
            this.c = xj2;
            com.bytedance.sdk.openadsdk.core.nativeexpress.xj.hf.xj().xj(xj2, str, ClickCommon.CLICK_SCENE_AD);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("dynamic_creative");
        if (optJSONObject4 != null) {
            this.f = optJSONObject4;
        }
    }

    public static ss c(ws wsVar) {
        hl g = g(wsVar);
        if (g == null) {
            return null;
        }
        return g.c;
    }

    public static com.bytedance.sdk.component.adexpress.xj.w.u d(ws wsVar) {
        hl g = g(wsVar);
        if (g == null) {
            return null;
        }
        return g.xj(String.valueOf(com.bytedance.sdk.openadsdk.core.a.wo.d(wsVar)));
    }

    public static boolean f(ws wsVar) {
        hl g = g(wsVar);
        if (g == null) {
            return false;
        }
        nb nbVar = g.y;
        if (nbVar != null) {
            return !TextUtils.isEmpty(nbVar.p());
        }
        int i = g.hf;
        return i == 9 || i == 10;
    }

    private static hl g(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.dc();
    }

    public static int hf(ws wsVar) {
        hl g = g(wsVar);
        if (g == null) {
            return 0;
        }
        return g.hf;
    }

    public static int kd(ws wsVar) {
        hl g = g(wsVar);
        if (g == null) {
            return 100;
        }
        return g.kd;
    }

    public static boolean p(ws wsVar) {
        return wsVar != null && hf(wsVar) == 3;
    }

    public static boolean pl(ws wsVar) {
        return wsVar != null && hf(wsVar) == 10;
    }

    public static boolean tf(ws wsVar) {
        return wsVar != null && hf(wsVar) == 7;
    }

    public static int u(ws wsVar) {
        hl g = g(wsVar);
        if (g == null) {
            return 0;
        }
        return g.u;
    }

    public static int w(ws wsVar) {
        hl g = g(wsVar);
        if (g == null) {
            return 1;
        }
        return g.w;
    }

    public static void xj(ws wsVar, int i) {
        hl g = g(wsVar);
        if (g == null) {
            return;
        }
        g.xj = i;
    }

    public static nb y(ws wsVar) {
        hl g = g(wsVar);
        if (g == null) {
            return null;
        }
        return g.y;
    }

    public void xj(JSONObject jSONObject) {
        try {
            jSONObject.put("render_control", this.xj);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("render_sequence", this.hf);
            jSONObject2.put("backup_render_control", this.w);
            jSONObject2.put("render_thread", this.u);
            jSONObject2.put("reserve_time", this.kd);
            jSONObject.put("render", jSONObject2);
            if (this.y != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, this.y.hf());
                jSONObject3.put(TKDownloadReason.KSAD_TK_MD5, this.y.w());
                jSONObject3.put("url", this.y.u());
                jSONObject3.put(PointParamKey.DATA, this.y.kd());
                jSONObject3.put("diff_data", this.y.y());
                jSONObject3.put("version", this.y.xj());
                jSONObject3.put("dynamic_creative", this.y.c());
                jSONObject3.put("material_type", this.y.f());
                jSONObject3.put("ugen_url", this.y.d());
                jSONObject3.put("ugen_md5", this.y.tf());
                jSONObject3.put("engine_version", this.y.p());
                jSONObject3.put("express_gesture_priority", this.y.pl());
                jSONObject.put("tpl_info", jSONObject3);
            }
            jSONObject.put("dynamic_creative", this.f);
            ss ssVar = this.c;
            if (ssVar != null) {
                jSONObject.put("tpl_info_v3", ssVar.d());
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    private com.bytedance.sdk.component.adexpress.xj.w.u xj(String str) {
        nb nbVar = this.y;
        if (nbVar == null) {
            return null;
        }
        String hf = nbVar.hf();
        String u = this.y.u();
        String w = this.y.w();
        String kd = this.y.kd();
        return com.bytedance.sdk.component.adexpress.xj.w.u.xj().xj(hf).hf(w).w(u).u(kd).kd(this.y.xj()).y(String.valueOf(str));
    }

    public static int xj(ws wsVar) {
        hl g = g(wsVar);
        if (g == null) {
            return 2;
        }
        return g.xj;
    }
}
