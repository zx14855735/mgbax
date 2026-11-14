package com.bytedance.sdk.openadsdk.core.am;

import B4ZgIw.AYUAbz;
import J3FDQU.A2egSU;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.openadsdk.core.a.dk;
import com.bytedance.sdk.openadsdk.core.a.io;
import com.bytedance.sdk.openadsdk.core.a.p;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.am.xj;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.dc;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ne;
import com.bytedance.sdk.openadsdk.core.ra.s;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.zg;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.core.x.pl;
import com.bytedance.sdk.openadsdk.core.yo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    public static int xj;

    public static void c(ws wsVar, String str, String str2, Map<String, Object> map) {
        xj(wsVar, str, str2, map);
    }

    public static void f(ws wsVar, String str, String str2, Map<String, Object> map) {
        ne kt = wsVar.kt();
        if (map == null) {
            map = new HashMap<>();
        }
        if (kt != null) {
            map.put("wc_type", Integer.valueOf(kt.kd()));
        }
        map.put("rom_new_version", io.qt());
        map.put("is_background", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.f.zg().xj()));
        map.put("interaction_type", Integer.valueOf(wsVar.vw()));
        xj(wsVar, str, str2, map);
    }

    public static void hf(final ws wsVar, final String str, final Map<String, Object> map, final Double d) {
        if (wsVar == null) {
            return;
        }
        x.hf();
        final float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - wo.pl(wsVar)).floatValue();
        final String xj2 = dk.xj(str, p.hf(), wo.d(wsVar), com.bytedance.sdk.openadsdk.core.multipro.hf.w());
        wsVar.rz().w();
        xj++;
        xj(wsVar, str, "show", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.36
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.w.xj.xj(pz.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.f.xj(str)).toString());
                jSONObject2.put(PointParamKey.IS_CACHE, wsVar.ha() ? 1 : 0);
                jSONObject2.put("cache_type", wsVar.oe());
                jSONObject2.put("correct_action_code", wsVar.ps());
                jSONObject2.put("correct_result_code", wsVar.js());
                Map map2 = map;
                if (map2 != null) {
                    if (!map2.containsKey("show_send_type")) {
                        map.put("show_send_type", 0);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - v.kd);
                jSONObject2.put("start_type", !v.hf.get() ? 1 : 0);
                jSONObject2.put("show_count", u.xj);
                String y = com.bytedance.sdk.openadsdk.core.f.zg().y();
                if (!TextUtils.isEmpty(y)) {
                    jSONObject2.put("can_use_sensor", y);
                }
                if (!com.bytedance.sdk.openadsdk.core.f.zg().p()) {
                    jSONObject2.put("mcod", Constants.FAIL);
                }
                if (!com.bytedance.sdk.openadsdk.core.f.zg().f()) {
                    jSONObject2.put("od", Constants.FAIL);
                }
                jSONObject2.put("is_shake_ads", com.bytedance.sdk.openadsdk.core.f.zg().yo());
                jSONObject2.put("direction", com.bytedance.sdk.openadsdk.core.q.xj.xj().y());
                u.kd(wsVar, str, jSONObject2);
                String str2 = xj2;
                if (str2 != null) {
                    r.xj(jSONObject2, str2);
                }
                jSONObject2.put("live_sdk_status", com.bytedance.sdk.openadsdk.core.live.hf.xj().w());
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                jSONObject2.put("shakeLiSize", com.bytedance.sdk.component.utils.pz.xj(pz.getContext()).xj());
                u.xj(jSONObject2);
                wsVar.rz().xj(jSONObject2);
                pl.xj(wsVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                float f = floatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
                com.bytedance.sdk.openadsdk.core.qt.w.kd().xj(wsVar, floatValue);
                String co = wsVar.co();
                if (!TextUtils.isEmpty(co)) {
                    try {
                        double parseDouble = Double.parseDouble(co);
                        if (parseDouble <= 0.0d) {
                            jSONObject.put("ttdsp_price", 0);
                            return;
                        } else {
                            if (ai.w < 4400) {
                                parseDouble *= 100000.0d;
                            }
                            jSONObject.put("ttdsp_price", parseDouble);
                        }
                    } catch (Throwable th) {
                        jSONObject.put("ttdsp_price", 0);
                        com.bytedance.sdk.component.utils.pl.xj(th);
                    }
                }
                xj(wsVar, d, jSONObject);
            }

            public void xj(ws wsVar2, Double d2, JSONObject jSONObject) {
                Object obj;
                Object obj2;
                try {
                    Map<String, Object> pu = wsVar2.pu();
                    if (pu == null || (obj = pu.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) {
                        return;
                    }
                    if (d2 != null) {
                        jSONObject.put("ttdsp_price", d2);
                    } else if (wsVar2.xk() && (obj2 = pu.get("price")) != null) {
                        jSONObject.put("ttdsp_price", Double.parseDouble(obj2.toString()));
                    }
                } catch (Throwable unused) {
                }
            }
        });
        String w = yo.w();
        List<String> ew = wsVar.ew();
        if (!TextUtils.isEmpty(w)) {
            HashMap hashMap = new HashMap();
            hashMap.put("aid", wsVar.jq());
            hashMap.put("cid", wsVar.ho());
            hashMap.put("req_id", wsVar.zf());
            hashMap.put("customer_id", wo.p(wsVar));
            com.bytedance.sdk.openadsdk.core.ht.hf.xj(w, ew, true, hashMap, xj(wsVar, str, "show"));
        } else if (ew != null && ew.size() != 0) {
            xj(wsVar, ew, str, "no did", "show");
        }
        if (xj % 5 == 0 && com.bytedance.sdk.openadsdk.xj.xj.xj.xj() != null) {
            com.bytedance.sdk.openadsdk.xj.xj.xj.xj().hf("AdShow" + System.currentTimeMillis());
        }
        if (com.bytedance.sdk.openadsdk.core.live.hf.xj().y(wsVar)) {
            com.bytedance.sdk.openadsdk.core.video.w.xj.xj("tobsdk_livesdk_live_show", wsVar, 0L);
        }
        wo.w();
        com.bytedance.sdk.openadsdk.qt.hf.w();
        com.bytedance.sdk.openadsdk.core.live.hf.xj().u();
        com.bytedance.sdk.openadsdk.core.f.zg().u().u();
        dk.xj(xj, 1);
        com.bytedance.sdk.openadsdk.core.u.xj().w(wsVar.og());
        com.bytedance.sdk.openadsdk.core.pl.xj.xj(wsVar);
        com.bytedance.sdk.openadsdk.core.qt.w.kd().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void kd(ws wsVar, String str, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.zg.w.w.hf gh;
        if (ai.c() && (gh = wsVar.gh()) != null) {
            String g = gh.g();
            if (TextUtils.isEmpty(g)) {
                return;
            }
            jSONObject.putOpt("media_extra", g);
        }
    }

    public static void w(ws wsVar, String str, String str2, Map<String, Object> map) {
        xj(wsVar, str, str2, map);
    }

    public static void xj(ws wsVar) {
    }

    public static void y(ws wsVar, String str, String str2, Map<String, Object> map) {
        xj(wsVar, str, str2, map);
    }

    public static void u(ws wsVar, String str, String str2, Map<String, Object> map) {
        xj(wsVar, str, str2, map);
    }

    public static void w(final ws wsVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (wsVar == null) {
            return;
        }
        xj(wsVar, str, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.11
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject, wsVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void xj(String str, String str2, String str3, String str4, com.bytedance.sdk.openadsdk.y.xj.xj xjVar) {
        new xj.C0138xj().kd(str3).u(str4).xj(str).hf(str2).xj(xjVar);
    }

    public static void u(ws wsVar, String str, final long j) {
        xj(wsVar, str, "render_live_picture_success", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.20
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, new JSONObject().toString());
            }
        });
    }

    public static void w(ws wsVar, String str, String str2) {
        xj(wsVar, str, str2, (com.bytedance.sdk.openadsdk.y.xj.xj) null);
    }

    public static void w(ws wsVar, String str, String str2, JSONObject jSONObject) {
        if (wsVar == null) {
            return;
        }
        new xj.C0138xj().kd(wsVar.ho()).u(wsVar.jf()).xj(str).hf(str2).xj(jSONObject).xj((com.bytedance.sdk.openadsdk.y.xj.xj) null);
    }

    public static void kd(ws wsVar, String str, String str2, Map<String, Object> map) {
        xj(wsVar, str, str2, map);
    }

    public static void xj(ws wsVar, String str, String str2, com.bytedance.sdk.openadsdk.y.xj.xj xjVar) {
        if (wsVar == null) {
            return;
        }
        new xj.C0138xj().kd(wsVar.ho()).u(wsVar.jf()).xj(str).hf(str2).c(wsVar.zf()).xj(xjVar);
    }

    public static void w(final ws wsVar, String str, final long j) {
        xj(wsVar, str, "load", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.19
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, ws.this);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                jSONObject.put(MediationConstant.EXTRA_DURATION, Math.min(j, 600000L));
            }
        });
    }

    public static void w(ws wsVar, String str, final JSONObject jSONObject) {
        if (wsVar == null || jSONObject == null) {
            return;
        }
        xj(wsVar, str, "splash_ad_showstat", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.34
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void w(final ws wsVar, String str) {
        xj(wsVar, str, "cache_ana_upload", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.35
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                ws.this.rz().xj(jSONObject2);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    public static void xj(ws wsVar, String str, String str2, JSONObject jSONObject, com.bytedance.sdk.openadsdk.y.xj.xj xjVar) {
        if (wsVar == null) {
            return;
        }
        new xj.C0138xj().kd(wsVar.ho()).u(wsVar.jf()).xj(str).hf(str2).xj(jSONObject).c(wsVar.zf()).xj(xjVar);
    }

    public static void xj(final ws wsVar, String str, String str2, final JSONObject jSONObject) {
        xj(wsVar, str, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.1
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject3, wsVar);
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                }
            }
        });
    }

    public static void xj(final ws wsVar, String str, String str2, final Map<String, Object> map) {
        xj(wsVar, str, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.12
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            }
        });
    }

    public static void xj(final ws wsVar, final String str, final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.x.c.xj((Runnable) new com.bytedance.sdk.component.tf.d("repost_show_check") { // from class: com.bytedance.sdk.openadsdk.core.am.u.22
            @Override // java.lang.Runnable
            public void run() {
                if (wsVar == null) {
                    return;
                }
                final float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - wo.pl(wsVar)).floatValue();
                u.xj(wsVar, str, "show_check", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.22.1
                    @Override // com.bytedance.sdk.openadsdk.y.xj.xj
                    public void xj(JSONObject jSONObject) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.w.xj.xj(pz.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.f.xj(str)).toString());
                        jSONObject2.put(PointParamKey.IS_CACHE, wsVar.ha() ? 1 : 0);
                        jSONObject2.put("cache_type", wsVar.oe());
                        jSONObject2.put("correct_action_code", wsVar.ps());
                        jSONObject2.put("correct_result_code", wsVar.js());
                        Map map2 = map;
                        if (map2 != null) {
                            for (Map.Entry entry : map2.entrySet()) {
                                jSONObject2.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - v.kd);
                        jSONObject2.put("start_type", !v.hf.get() ? 1 : 0);
                        jSONObject2.put("show_count", u.xj);
                        jSONObject2.put("can_use_sensor", com.bytedance.sdk.openadsdk.core.f.zg().y());
                        jSONObject2.put("is_shake_ads", com.bytedance.sdk.openadsdk.core.f.zg().yo());
                        jSONObject2.put("direction", com.bytedance.sdk.openadsdk.core.q.xj.xj().y());
                        AnonymousClass22 anonymousClass22 = AnonymousClass22.this;
                        u.kd(wsVar, str, jSONObject2);
                        com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                        jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                        float f = floatValue;
                        if (f <= 0.0f) {
                            f = 0.0f;
                        }
                        jSONObject.putOpt("show_time", Float.valueOf(f));
                    }
                });
            }
        });
    }

    public static void xj(final ws wsVar, final String str, final Map<String, Object> map, final Double d) {
        com.bytedance.sdk.openadsdk.x.c.xj(new com.bytedance.sdk.component.tf.d("report_show") { // from class: com.bytedance.sdk.openadsdk.core.am.u.33
            @Override // java.lang.Runnable
            public void run() {
                u.hf(wsVar, str, (Map<String, Object>) map, d);
            }
        });
    }

    private static void xj(ws wsVar, List<String> list, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("track_type", str3);
            jSONObject.put("error_msg", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i));
                if (i == size - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            jSONObject.put("url", sb.toString());
            jSONObject.put("urls_size", size);
        } catch (Exception unused) {
        }
        xj(str, wsVar.ho(), wsVar.jf(), jSONObject);
    }

    public static void hf(ws wsVar, String str, String str2, Map<String, Object> map) {
        xj(wsVar, str, str2, map);
    }

    public static void hf(ws wsVar, String str) {
        if (wsVar != null) {
            com.bytedance.sdk.openadsdk.core.dislike.w.w wVar = new com.bytedance.sdk.openadsdk.core.dislike.w.w();
            wVar.xj("0:00");
            wVar.hf(str);
            com.bytedance.sdk.openadsdk.core.qt.w.kd().xj("skip", wsVar.ho(), wsVar.zf(), wsVar.jb(), (String) null);
            xj(wsVar.xl(), wVar);
        }
    }

    public static void hf(ws wsVar, String str, String str2, final long j) {
        if (wsVar == null) {
            return;
        }
        xj(wsVar, str, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.9
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                jSONObject.put("timestamp", j);
            }
        });
    }

    public static void hf(final ws wsVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (wsVar == null || jSONObject == null) {
            return;
        }
        xj(wsVar, str, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.10
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject, wsVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void hf(ws wsVar, String str, String str2) {
        xj(wsVar, str, str2, (com.bytedance.sdk.openadsdk.y.xj.xj) null);
    }

    public static void xj(final ws wsVar, final String str, final long j) {
        xj(wsVar, str, "download_creative_duration", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.37
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.w.xj.xj(pz.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.f.xj(str)).toString());
                jSONObject2.put("download_creative_duration", j);
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void hf(ws wsVar, String str, String str2, JSONObject jSONObject) {
        xj(wsVar, str, str2, jSONObject);
    }

    public static void xj(final String str, ws wsVar, String str2, final int i) {
        if (wsVar == null) {
            return;
        }
        xj(wsVar, str2, "ad_show_time", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.38
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(n.l, Integer.valueOf(i));
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                jSONObject.put(MediationConstant.EXTRA_DURATION, str);
            }
        });
    }

    public static void hf(ws wsVar, String str, long j) {
        String str2;
        if (pz.hf().gh()) {
            final long currentTimeMillis = System.currentTimeMillis() - j;
            str.getClass();
            switch (str) {
                case "banner_ad":
                    str2 = "banner_ad_loadtime";
                    break;
                case "rewarded_video":
                    str2 = "rewarded_video_loadtime";
                    break;
                case "stream":
                    str2 = "stream_loadtime";
                    break;
                case "fullscreen_interstitial_ad":
                    str2 = "fullscreen_interstitial_ad_loadtime";
                    break;
                case "embeded_ad":
                    str2 = "embeded_ad_loadtime";
                    break;
                case "interaction":
                    str2 = "interaction_loadtime";
                    break;
                case "draw_ad":
                    str2 = "draw_ad_loadtime";
                    break;
                default:
                    str2 = "";
                    break;
            }
            xj(wsVar, str, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.13
                @Override // com.bytedance.sdk.openadsdk.y.xj.xj
                public void xj(JSONObject jSONObject) {
                    jSONObject.put(MediationConstant.EXTRA_DURATION, currentTimeMillis);
                }
            });
        }
    }

    public static long xj(long j, boolean z, ws wsVar, String str, int i) {
        if (z) {
            return System.currentTimeMillis();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() - j);
        xj(sb.toString(), wsVar, str, i);
        return 0L;
    }

    public static long xj(long j, ws wsVar, String str, int i) {
        if (j <= 0) {
            return j;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() - j);
        xj(sb.toString(), wsVar, str, i);
        return 0L;
    }

    public static void xj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("tag");
        String optString2 = jSONObject.optString(MediationConstant.EXTRA_ADID);
        String optString3 = jSONObject.optString("log_extra");
        if (TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString)) {
            return;
        }
        xj(optString, optString2, optString3, jSONObject2);
    }

    public static void xj(String str, String str2, String str3, final JSONObject jSONObject) {
        xj(str, "show_url", str2, str3, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.39
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
                }
            }
        });
    }

    public static void hf(final ws wsVar, String str, String str2, final String str3) {
        xj(wsVar, str, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.16
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scheme", str3);
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void xj(final ws wsVar, final String str) {
        String hf;
        if (wsVar == null || str == null || (hf = wo.hf(wsVar)) == null) {
            return;
        }
        xj(wsVar, hf, "page_on_create", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.40
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("page_name", str);
                r.xj(jSONObject2, "");
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    public static void hf(final ws wsVar) {
        xj(wsVar, "landingpage", "open_url_h5", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.18
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, ws.this);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    public static void hf(final ws wsVar, String str, final int i) {
        xj(wsVar, str, "qpon_apply", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.28
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("qpon_apply_status", i);
                    com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        });
    }

    public static void xj(String str, final ws wsVar, final com.bytedance.sdk.openadsdk.core.ra.d dVar, final String str2, final boolean z, final Map<String, Object> map, final int i, boolean z2) {
        if (wsVar == null || z2) {
            return;
        }
        final float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - wo.pl(wsVar)).floatValue();
        xj(wsVar, str2, str, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.2
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.core.ra.d dVar2 = com.bytedance.sdk.openadsdk.core.ra.d.this;
                if (dVar2 != null) {
                    JSONObject xj2 = dVar2.xj();
                    xj2.put("device", com.bytedance.sdk.openadsdk.core.w.xj.xj(pz.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.f.xj(str2)).toString());
                    xj2.put("is_valid", z);
                    int i2 = i;
                    if (i2 > 0 && i2 <= 2) {
                        xj2.put("user_behavior_type", i2);
                    }
                    r.xj(xj2, "");
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            xj2.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    u.kd(wsVar, str2, xj2);
                    xj2.putOpt("obm_convert", jk.w(wsVar));
                    xj2.put("can_use_sensor", com.bytedance.sdk.openadsdk.core.f.zg().y());
                    if (!com.bytedance.sdk.openadsdk.core.f.zg().p()) {
                        xj2.put("mcod", Constants.FAIL);
                    }
                    if (!com.bytedance.sdk.openadsdk.core.f.zg().f()) {
                        xj2.put("od", Constants.FAIL);
                    }
                    xj2.put("is_shake_ads", com.bytedance.sdk.openadsdk.core.f.zg().yo());
                    xj2.put("live_sdk_config", com.bytedance.sdk.openadsdk.core.live.hf.xj().f());
                    xj2.put("direction", com.bytedance.sdk.openadsdk.core.q.xj.xj().y());
                    xj2.put(PointParamKey.IS_CACHE, wsVar.ha() ? 1 : 0);
                    xj2.put("cache_type", wsVar.oe());
                    xj2.put("correct_action_code", wsVar.ps());
                    xj2.put("correct_result_code", wsVar.js());
                    com.bytedance.sdk.openadsdk.kd.xj.xj(xj2, wsVar);
                    u.xj(xj2);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, xj2.toString());
                }
                float f = floatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
            }
        });
        String w = yo.w();
        List<String> qf = wsVar.qf();
        if (!TextUtils.isEmpty(w) && "click".equals(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("aid", wsVar.jq());
            hashMap.put("cid", wsVar.ho());
            hashMap.put("req_id", wsVar.zf());
            hashMap.put("customer_id", wo.p(wsVar));
            com.bytedance.sdk.openadsdk.core.ht.hf.xj(w, qf, true, hashMap, xj(wsVar, str2, "click"));
        } else if (qf != null && qf.size() != 0 && "click".equals(str)) {
            xj(wsVar, qf, str2, "no did", "click");
        }
        if (str == "click") {
            if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
                com.bytedance.sdk.openadsdk.core.video.w.xj.xj("tobsdk_livesdk_rec_live_play", wsVar, 0L);
            }
            com.bytedance.sdk.openadsdk.core.live.hf.xj().u(wsVar);
        }
        dk.xj(1, 2);
        if (com.bytedance.sdk.component.utils.pl.w()) {
            StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, " ");
            A5SV6n2.append(wsVar.ho());
            com.bytedance.sdk.component.utils.pl.xj("AdEvent", A5SV6n2.toString());
        }
    }

    public static void hf(ws wsVar, String str, final JSONObject jSONObject) {
        if (wsVar == null || jSONObject == null) {
            return;
        }
        xj(wsVar, str, "cache_correct_details", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.29
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void hf(long j, final ws wsVar) {
        if (wsVar != null && ws.hf(wsVar)) {
            final long currentTimeMillis = j > 0 ? System.currentTimeMillis() - j : 0L;
            xj(wsVar, "splash_ad", "play_duration_sum", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.30
                @Override // com.bytedance.sdk.openadsdk.y.xj.xj
                public void xj(JSONObject jSONObject) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("skip_duration", currentTimeMillis);
                    com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            });
        }
    }

    public static JSONObject xj(ws wsVar, String str, String str2) {
        return xj(wsVar.jf(), wsVar.ho(), wsVar.zf(), str, str2);
    }

    public static JSONObject xj(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_extra", str);
            jSONObject.put(MediationConstant.EXTRA_ADID, str2);
            jSONObject.put("req_id", str3);
            jSONObject.put("tag", str4);
            jSONObject.put("track_type", str5);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void xj(final ws wsVar, String str, String str2, final long j) {
        if (wsVar == null) {
            return;
        }
        xj(wsVar, str, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.3
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                jSONObject2.put("rom_new_version", io.qt());
                jSONObject2.put("is_background", com.bytedance.sdk.openadsdk.core.f.zg().xj());
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void xj(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar, com.bytedance.sdk.openadsdk.zg.w.hf.y yVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(yVar);
        pz.xj().xj(hfVar, arrayList);
        if (com.bytedance.sdk.component.utils.pl.w()) {
            com.bytedance.sdk.component.utils.pl.xj("AdEvent", "tt_dislike_icon " + hfVar.w());
        }
    }

    public static void xj(Context context, ws wsVar, String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2) || wsVar == null || jSONObject == null) {
            return;
        }
        Object opt = jSONObject.opt("value");
        if (opt == null) {
            opt = wsVar.ho();
        }
        String optString = jSONObject.optString(PointParamKey.CATEGORY);
        if (TextUtils.isEmpty(optString)) {
            optString = "app_union";
        }
        Object opt2 = jSONObject.opt("log_extra");
        if (opt2 == null) {
            opt2 = wsVar.jf();
        }
        try {
            jSONObject.putOpt("nt", Integer.valueOf(am.w(context)));
            jSONObject.putOpt("scene_tag", "csj_sdk");
            jSONObject.putOpt("tag", "7.1.3.2");
            jSONObject.putOpt("subtag", str);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.w(e.getMessage());
        }
        String str3 = "";
        String obj = opt == null ? "" : opt.toString();
        if (opt2 != null) {
            str3 = opt2.toString();
        }
        new xj.C0138xj().kd(obj).w(optString).u(str3).xj(str).xj(jSONObject).hf(str2).xj(new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.4
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
            }
        });
    }

    public static void xj(final long j, final ws wsVar) {
        if (wsVar == null) {
            return;
        }
        xj(wsVar, "splash_ad", "skip", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.5
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j);
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void xj(final ws wsVar, String str, final JSONObject jSONObject) {
        xj(wsVar, wo.hf(wsVar), str, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.6
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject3, wsVar);
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            }
        });
    }

    public static void xj(final ws wsVar, String str, String str2, final long j, final int i, final Map<String, Object> map) {
        xj(wsVar, str, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.7
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                jSONObject.put("percent", i);
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            }
        });
    }

    public static void xj(final ws wsVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (wsVar == null || jSONObject == null) {
            return;
        }
        xj(wsVar, str, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.8
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject, wsVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void xj(String str, String str2, String str3, String str4) {
        new xj.C0138xj().xj(str3).hf(str4).kd(str).u(str2).xj((com.bytedance.sdk.openadsdk.y.xj.xj) null);
        if (com.bytedance.sdk.component.utils.pl.w()) {
            StringBuilder BChYOn2 = A2egSU.BChYOn("tag: ", str3, "label: ", str4, " ");
            BChYOn2.append(str);
            com.bytedance.sdk.component.utils.pl.xj("AdEvent", BChYOn2.toString());
        }
    }

    public static void xj(ws wsVar, String str, String str2, Throwable th) {
        ne kt = wsVar.kt();
        JSONObject jSONObject = null;
        if (kt != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("wc_type", kt.kd());
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject2;
            } catch (Throwable unused2) {
            }
        }
        if (th != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("throwable", th.getMessage());
            } catch (Exception unused3) {
            }
        }
        xj(wsVar, str, str2, jSONObject);
    }

    public static void xj(ws wsVar, String str, String str2, String str3) {
        final JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("refer", str3);
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject, wsVar);
            }
        } catch (Throwable unused) {
        }
        xj(wsVar, str, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.14
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
            }
        });
    }

    public static void xj(String str, final String str2, final String str3, long j, long j2, JSONObject jSONObject) {
        final float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - wo.y(jSONObject.optString("log_extra"))).floatValue();
        new xj.C0138xj().xj(str2).hf(str3).w(str).kd(String.valueOf(j)).y(String.valueOf(j2)).xj(jSONObject).xj(new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.15
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                JSONObject jSONObject3 = new JSONObject();
                String optString = jSONObject2.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, null);
                if (optString != null) {
                    jSONObject3 = new JSONObject(optString);
                }
                jSONObject3.put("device", com.bytedance.sdk.openadsdk.core.w.xj.xj(pz.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.f.xj(str2)).toString());
                jSONObject3.put("js_event", 1);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
                jSONObject2.put("tag", str2);
                if ("click".equals(str3)) {
                    float f = floatValue;
                    if (f <= 0.0f) {
                        f = 0.0f;
                    }
                    jSONObject2.putOpt("show_time", Float.valueOf(f));
                }
            }
        });
        if (com.bytedance.sdk.component.utils.pl.w()) {
            com.bytedance.sdk.component.utils.pl.xj("AdEvent", "sendJsAdEvent");
        }
    }

    public static void xj(final long j, String str, String str2) {
        ws wsVar;
        try {
            wsVar = com.bytedance.sdk.openadsdk.core.xj.xj(new JSONObject(str2));
        } catch (Throwable unused) {
            wsVar = null;
        }
        if (wsVar == null) {
            return;
        }
        xj(wsVar, str, "open_appback", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.17
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
            }
        });
        com.bytedance.sdk.component.u.hf.w xj2 = com.bytedance.sdk.openadsdk.core.hf.xj();
        xj2.put("save_jump_success_time", 0L);
        xj2.put("save_jump_success_ad_tag", "");
    }

    public static void xj(ws wsVar, String str, final int i, final String str2) {
        xj(wsVar, str, "render_live_picture_fail", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.21
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void xj(ws wsVar, String str, final long j, final String str2) {
        xj(wsVar, str, "live_play_success", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.23
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("session_id", str2);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void xj(ws wsVar, String str, final int i, final String str2, final String str3) {
        xj(wsVar, str, "live_play_fail", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.24
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject2.putOpt("session_id", str3);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void xj(ws wsVar, String str, final long j, final JSONObject jSONObject, final String str2) {
        xj(wsVar, str, "live_play_close", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.25
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject3.putOpt("session_id", str2);
                    jSONObject2.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                }
                jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
            }
        });
    }

    public static void xj(final ws wsVar, String str, final int i, final int i2, final int i3, final boolean z) {
        if (wsVar != null && wsVar.kn() == 1) {
            xj(wsVar, str, "open_live", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.26
                @Override // com.bytedance.sdk.openadsdk.y.xj.xj
                public void xj(JSONObject jSONObject) {
                    JSONObject jSONObject2 = new JSONObject();
                    int i4 = i3;
                    int vu = wsVar.vu();
                    jSONObject2.put("live_interaction_type", vu);
                    jSONObject2.put("client_live_interaction_type", i);
                    jSONObject2.put("real_live_interaction_type", i2);
                    jSONObject2.put("reward_live_type", dc.hf(wsVar));
                    jSONObject2.put("is_inner", z);
                    s cc = wsVar.cc();
                    if (cc != null) {
                        jSONObject2.putOpt("saas_info", cc.xj());
                    }
                    zg yt = wsVar.yt();
                    if (yt != null) {
                        String hf = yt.hf();
                        if (hf.length() > 500) {
                            hf = hf.substring(0, 500);
                        }
                        jSONObject2.put("deep_link", hf);
                        if (!hf.startsWith("snssdk1128") && !hf.startsWith("snssdk2329") && vu == 1 && i4 != 0) {
                            i4 = 2;
                        }
                    }
                    jSONObject2.put("live_interaction_status", i4);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            });
        }
    }

    public static void xj(final ws wsVar, String str, final int i) {
        xj(wsVar, str, "qpon_join", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.27
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("join_status", i);
                    com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, wsVar);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        });
    }

    public static void xj(final int i, String str, final ws wsVar) {
        if (wsVar == null) {
            return;
        }
        xj(wsVar, str, "saas_auth", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.31
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("saas_auth_status", i);
                s cc = wsVar.cc();
                if (cc != null) {
                    jSONObject2.put("saas_auth_type", cc.hf());
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void xj(String str, ws wsVar) {
        if (wsVar == null) {
            return;
        }
        xj(wsVar, str, "ec_mall_task", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.u.32
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mall_reward_callback", 1);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void xj(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isCanUseLocation", com.bytedance.sdk.openadsdk.core.f.zg().e().xj());
            jSONObject2.put("isCanUsePhoneState", com.bytedance.sdk.openadsdk.core.f.zg().e().w());
            jSONObject2.put("isCanUseWifiState", com.bytedance.sdk.openadsdk.core.f.zg().e().u());
            jSONObject2.put("isCanUseWriteExternal", com.bytedance.sdk.openadsdk.core.f.zg().e().kd());
            jSONObject2.put("alist", com.bytedance.sdk.openadsdk.core.f.zg().e().hf());
            jSONObject2.put("isCanUseAndroidId", com.bytedance.sdk.openadsdk.core.f.zg().e().y());
            jSONObject2.put("isCanUsePermissionRecordAudio", com.bytedance.sdk.openadsdk.core.f.zg().e().c());
            if (com.bytedance.sdk.openadsdk.core.f.zg().e().qt() != null && !com.bytedance.sdk.openadsdk.core.f.zg().e().qt().isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry<String, Object> entry : com.bytedance.sdk.openadsdk.core.f.zg().e().qt().entrySet()) {
                    jSONObject3.put(entry.getKey(), entry.getValue());
                }
                jSONObject2.put("update_privacyConfig", jSONObject3);
            }
            jSONObject.put("regulation_data", jSONObject2);
        } catch (JSONException unused) {
        }
    }
}
