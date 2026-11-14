package com.bytedance.msdk.kd.w;

import J3FDQU.A2egSU;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.api.xj.hf;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.f.q;
import com.bytedance.msdk.f.v;
import com.bytedance.msdk.kd.f;
import com.bytedance.msdk.kd.u;
import com.bytedance.msdk.kd.y;
import com.bytedance.msdk.y.w;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile xj xj;

    private static void hf(u uVar) {
        uVar.xj("block_pacing", "-1");
        uVar.xj("rit_adn_show_rule_id", "-1");
        uVar.xj("block_show_count", "-1");
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(u uVar, hf hfVar, String str, boolean z, String str2, int i, Map<String, Object> map) {
        String str3;
        if (i > 0) {
            str3 = com.bytedance.msdk.api.xj.xj(i);
        } else {
            str3 = "";
            i = 0;
        }
        uVar.xj("mediation_request").xj("server_bidding_extra", str2).xj("mediation_req_type", Integer.valueOf(i != 0 ? z ? 2 : 3 : !z ? 1 : 0)).xj(PointParamKey.AD_COUNT, Integer.valueOf(hfVar != null ? hfVar.x() : 0)).hf(i).tf(str3);
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        if (hfVar != null && hfVar.w() == 5) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("parallel_num", com.bytedance.msdk.core.kd.hf.u.xj().w());
                jSONObject.put("interval", com.bytedance.msdk.core.kd.hf.u.xj().u());
                jSONObject.put("primerit_list", com.bytedance.msdk.core.kd.hf.u.xj().hf());
                hashMap.put("preload_info", jSONObject);
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        if (hfVar != null && hfVar.ht() == 3) {
            if (com.bytedance.msdk.c.hf.xj.xj().p()) {
                hashMap.put("init_splash_request_duration", Long.valueOf(com.bytedance.msdk.c.hf.xj.xj().d()));
            } else if (com.bytedance.msdk.c.hf.xj.xj().pl()) {
                hashMap.put("init_splash_request_duration", Long.valueOf(com.bytedance.msdk.c.hf.xj.xj().d()));
            }
        }
        hashMap.put("csj_plugin_version", w.w());
        y.xj(uVar, hfVar, (tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, com.bytedance.msdk.hf.w wVar, hf hfVar, com.bytedance.msdk.core.tf.hf hfVar2, long j, String str, boolean z, int i, boolean z2, boolean z3) {
        uVar.xj("mediation_fill").xj(j).xj("server_bidding_extra", str).xj("mediation_req_type", Integer.valueOf(!z ? 1 : 0)).xj(PointParamKey.AD_COUNT, Integer.valueOf(i)).hf(0).tf("");
        HashMap hashMap = new HashMap();
        if (hfVar != null && hfVar.ht() == 3) {
            if (com.bytedance.msdk.c.hf.xj.xj().p()) {
                com.bytedance.msdk.c.hf.xj.xj().xj(com.bytedance.msdk.kd.xj.w);
                hashMap.put("init_splash_fill_duration", Long.valueOf(com.bytedance.msdk.c.hf.xj.xj().tf()));
            } else if (com.bytedance.msdk.c.hf.xj.xj().pl()) {
                hashMap.put("init_splash_fill_duration", Long.valueOf(com.bytedance.msdk.c.hf.xj.xj().tf()));
            }
        }
        y.xj(uVar, hfVar, (tf) null, wVar, hashMap);
        hashMap.put("timeout_req", Integer.valueOf(z2 ? 1 : 0));
        hashMap.put("is_callback", Integer.valueOf(z3 ? 1 : 0));
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, hf hfVar, com.bytedance.msdk.hf.w wVar, long j, int i, int i2, int i3, String str, int i4, int i5, com.bytedance.msdk.core.tf.hf hfVar2, JSONObject jSONObject) {
        JSONObject tf;
        uVar.xj("mediation_request_end").xj(j).xj(PointParamKey.AD_COUNT, Integer.valueOf(i4)).xj(MediationConstant.KEY_REASON, Integer.valueOf(i5)).hf(i3);
        HashMap hashMap = new HashMap();
        y.xj(uVar, hfVar, (tf) null, wVar, hashMap);
        A2egSU.BNL6CD(i, hashMap, "requested_adn_count", i2, "requested_level_count");
        if (jSONObject != null) {
            hashMap.put("auto_detail", jSONObject);
        }
        if (hfVar2 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("layer_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(hfVar2.w())));
                jSONObject2.putOpt("req_interval", Long.valueOf(hfVar2.kd()));
                jSONObject2.putOpt("total_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(hfVar2.u())));
                hashMap.put("preload_req", jSONObject2);
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        if (hfVar != null && (tf = hfVar.tf()) != null) {
            hashMap.put("behavior", tf);
        }
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, hf hfVar, com.bytedance.msdk.api.xj xjVar, String str) {
        JSONObject tf;
        uVar.xj("total_load_fail").xj("server_bidding_extra", str);
        int i = xjVar.xj;
        if (i == 10003) {
            uVar.hf(10010).tf("延长瀑布流总超时时长或者缩短层超时并添加兜底代码位");
            xj(uVar);
        } else if (i == 810085) {
            uVar.hf(i).tf(xjVar.hf);
            xj(uVar);
        } else if (xjVar instanceof com.bytedance.msdk.api.hf.w) {
            com.bytedance.msdk.api.hf.w wVar = (com.bytedance.msdk.api.hf.w) xjVar;
            uVar.hf(i).tf(xjVar.hf);
            uVar.xj("block_pacing", wVar.xj());
            uVar.xj("waterfall_show_rule_id", wVar.hf());
        } else if (xjVar instanceof com.bytedance.msdk.api.hf.hf) {
            com.bytedance.msdk.api.hf.hf hfVar2 = (com.bytedance.msdk.api.hf.hf) xjVar;
            uVar.hf(i).tf(xjVar.hf);
            uVar.xj("block_show_count", hfVar2.xj());
            uVar.xj("waterfall_show_rule_id", hfVar2.hf());
        } else if (xjVar instanceof com.bytedance.msdk.api.hf.xj) {
            uVar.hf(i).tf(xjVar.hf);
            xj(uVar);
        } else {
            uVar.hf(10086).tf("Ad load fail all loadsorts! ");
            xj(uVar);
        }
        HashMap hashMap = new HashMap();
        if (hfVar != null && (tf = hfVar.tf()) != null) {
            hashMap.put("behavior", tf);
        }
        uVar.xj(PointParamKey.AD_COUNT, Integer.valueOf(hfVar != null ? hfVar.x() : 0));
        y.xj(uVar, hfVar, (tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, tf tfVar, hf hfVar, String str, boolean z, int i, int i2, int i3, int i4, com.bytedance.msdk.api.xj xjVar, long j, boolean z2, boolean z3, String str2) {
        int hf;
        if ((xjVar instanceof com.bytedance.msdk.api.hf.w) || (xjVar instanceof com.bytedance.msdk.api.hf.hf) || (xjVar instanceof com.bytedance.msdk.api.hf.xj)) {
            uVar.hf(xjVar.xj).tf(xjVar.hf);
        }
        uVar.xj("media_request").y(str).xj(PointParamKey.AD_COUNT, Integer.valueOf(hfVar != null ? hfVar.x() : 0)).xj("adn_count", Integer.valueOf(i2)).xj("mediationrit_req_type", Integer.valueOf(i3)).xj("mediationrit_req_type_src", Integer.valueOf(i4)).xj("mediation_req_type", Integer.valueOf(!z ? 1 : 0)).xj("media_req_type", Integer.valueOf(i));
        HashMap hashMap = new HashMap();
        A2egSU.BNL6CD(z2 ? 1 : 0, hashMap, "timeout_req", z3 ? 1 : 0, "is_callback");
        if (hfVar != null && hfVar.dq() && !TextUtils.isEmpty(str2)) {
            hashMap.put("origin_link_id", str2);
        }
        if (hfVar != null && hfVar.ws() != null && tfVar != null && MediationConstant.ADN_PANGLE.equals(tfVar.qt()) && tfVar.g() == 5 && (hf = hfVar.ws().hf()) == 1) {
            hashMap.put("support_render_control", Integer.valueOf(hf));
        }
        if (j != -1) {
            hashMap.put("start_time", Long.valueOf(SystemClock.elapsedRealtime() - j));
        }
        y.xj(uVar, hfVar, tfVar, (com.bytedance.msdk.hf.w) null, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, com.bytedance.msdk.hf.w wVar, int i, String str, long j, hf hfVar, int i2, int i3, int i4, String str2, long j2, long j3) {
        uVar.xj("media_fill").xj(j).hf(i).tf(str).xj("adn_count", Integer.valueOf(i2)).xj("adn_preload", Integer.valueOf((wVar == null || !wVar.eu()) ? 0 : 1)).xj(PointParamKey.AD_COUNT, Integer.valueOf(i3));
        uVar.xj("fill_type", Integer.valueOf(i4));
        if (str2 != null) {
            uVar.xj("sub_adn_name", str2);
        }
        HashMap hashMap = new HashMap();
        boolean z = j2 >= 0;
        if (wVar != null && wVar.sv()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(v.w()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j2));
            }
        }
        if (j3 != -1) {
            hashMap.put("end_time", Long.valueOf(j3));
        }
        if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw()) && wVar.ci() == 5 && wVar.et() == 1) {
            hashMap.put("if_to_express", Integer.valueOf(wVar.et()));
        }
        if (com.bytedance.msdk.core.hf.hf().yy() && wVar != null && 5 == wVar.ci()) {
            uVar.xj("ex_info", f.xj().xj(wVar));
        }
        y.xj(uVar, hfVar, (tf) null, wVar, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, com.bytedance.msdk.api.xj xjVar, hf hfVar, tf tfVar, int i, int i2, int i3, String str, long j, String str2, String str3, String str4, long j2) {
        if (xjVar instanceof com.bytedance.msdk.api.hf.w) {
            com.bytedance.msdk.api.hf.w wVar = (com.bytedance.msdk.api.hf.w) xjVar;
            uVar.hf(xjVar.xj).tf(xjVar.hf);
            uVar.xj("block_pacing", wVar.xj());
            uVar.xj("adn_rit_show_rule_id", wVar.hf());
        } else if (xjVar instanceof com.bytedance.msdk.api.hf.hf) {
            com.bytedance.msdk.api.hf.hf hfVar2 = (com.bytedance.msdk.api.hf.hf) xjVar;
            uVar.hf(xjVar.xj).tf(xjVar.hf);
            uVar.xj("block_show_count", hfVar2.xj());
            uVar.xj("adn_rit_show_rule_id", hfVar2.hf());
        } else if (xjVar instanceof com.bytedance.msdk.api.hf.xj) {
            uVar.hf(xjVar.xj);
            uVar.tf(xjVar.hf);
            hf(uVar);
        } else {
            uVar.hf(xjVar != null ? xjVar.w : -1).tf(xjVar != null ? xjVar.u : "unknown error");
            hf(uVar);
        }
        uVar.xj("media_fill_fail").xj(j).y(str).xj("adn_count", Integer.valueOf(i)).xj("adn_preload", 0).xj("mediationrit_req_type", Integer.valueOf(i2)).xj("mediationrit_req_type_src", Integer.valueOf(i3));
        HashMap hashMap = new HashMap();
        boolean z = j2 >= 0;
        if (tfVar != null && tfVar.r()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(v.w()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j2));
            }
        }
        y.xj(uVar, hfVar, tfVar, (com.bytedance.msdk.hf.w) null, hashMap);
        if (!TextUtils.isEmpty(str2)) {
            uVar.d(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            uVar.xj("level_tag", str3);
        }
        if (str4 != null) {
            uVar.xj("sub_adn_name", str4);
        }
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, tf tfVar, hf hfVar, int i, int i2) {
        uVar.xj("adapter_request_fail").xj(0L).y((String) null).hf(-99999).tf("adapter create fail !").xj("mediationrit_req_type", Integer.valueOf(i)).xj("mediationrit_req_type_src", Integer.valueOf(i2));
        HashMap hashMap = new HashMap();
        y.xj(uVar, hfVar, tfVar, (com.bytedance.msdk.hf.w) null, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, hf hfVar, int i) {
        uVar.xj("get_config_error").hf(i);
        HashMap hashMap = new HashMap();
        y.xj(uVar, hfVar, (tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, com.bytedance.msdk.hf.w wVar, hf hfVar, List<com.bytedance.msdk.hf.w> list, List<com.bytedance.msdk.hf.w> list2) {
        Iterator<com.bytedance.msdk.hf.w> it;
        HashMap hashMap;
        uVar.xj("bidding_win_event");
        HashMap hashMap2 = new HashMap();
        y.xj(uVar, hfVar, (tf) null, wVar, hashMap2);
        JSONArray jSONArray = new JSONArray();
        if (!q.xj(list)) {
            for (com.bytedance.msdk.hf.w wVar2 : list) {
                if (wVar2 != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        hashMap = hashMap2;
                        try {
                            jSONObject.putOpt("mediation_rit", wVar2.cy());
                            jSONObject.putOpt(MediationConstant.EXTRA_ADN_NAME, wVar2.lw());
                            jSONObject.putOpt("load_sort", Integer.valueOf(wVar2.zd()));
                            jSONObject.putOpt("show_sort", Integer.valueOf(wVar2.kc()));
                            jSONObject.putOpt("exchange_rate", wVar2.bl());
                            jSONObject.putOpt("rit_cpm", Double.valueOf(wVar2.da()));
                            jSONObject.putOpt("m_aid", wVar2.b());
                            jSONObject.putOpt("req_bidding_type", Integer.valueOf(wVar2.qi()));
                            jSONObject.putOpt("win_state", 1);
                            jSONObject.putOpt("ad_extra", wVar2.ws());
                            jSONObject.putOpt("win_callback", wVar2.wo());
                            jSONObject.putOpt("loss_callback", wVar2.r());
                            if (wVar2.si()) {
                                jSONObject.putOpt("pricing_type", Integer.valueOf(wVar2.ff()));
                            }
                            jSONArray.put(jSONObject);
                        } catch (Exception unused) {
                            hashMap2 = hashMap;
                        }
                    } catch (Exception unused2) {
                        hashMap = hashMap2;
                    }
                } else {
                    hashMap = hashMap2;
                }
                hashMap2 = hashMap;
            }
        }
        HashMap hashMap3 = hashMap2;
        if (!q.xj(list2)) {
            Iterator<com.bytedance.msdk.hf.w> it2 = list2.iterator();
            while (it2.hasNext()) {
                com.bytedance.msdk.hf.w next = it2.next();
                if (next != null) {
                    it = it2;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("mediation_rit", next.cy());
                        jSONObject2.putOpt(MediationConstant.EXTRA_ADN_NAME, next.lw());
                        jSONObject2.putOpt("load_sort", Integer.valueOf(next.zd()));
                        jSONObject2.putOpt("show_sort", Integer.valueOf(next.kc()));
                        jSONObject2.putOpt("exchange_rate", next.bl());
                        jSONObject2.putOpt("rit_cpm", Double.valueOf(next.da()));
                        jSONObject2.putOpt("m_aid", next.b());
                        jSONObject2.putOpt("req_bidding_type", Integer.valueOf(next.qi()));
                        jSONObject2.putOpt("win_state", 0);
                        jSONObject2.putOpt("ad_extra", next.ws());
                        jSONObject2.putOpt("win_callback", next.wo());
                        jSONObject2.putOpt("loss_callback", next.r());
                        if (next.si()) {
                            jSONObject2.putOpt("pricing_type", Integer.valueOf(next.ff()));
                        }
                        jSONArray.put(jSONObject2);
                    } catch (Exception unused3) {
                    }
                } else {
                    it = it2;
                }
                it2 = it;
            }
        }
        hashMap3.put("others", jSONArray);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap3);
    }

    public void xj(u uVar, hf hfVar, JSONObject jSONObject) {
        uVar.xj("start_bidding_request").xj(2).xj(PointParamKey.AD_COUNT, Integer.valueOf(hfVar != null ? hfVar.x() : 0));
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            hashMap.put("token_time", jSONObject);
        }
        y.xj(uVar, hfVar, (tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, hf hfVar, com.bytedance.msdk.core.u.hf hfVar2, int i) {
        if (hfVar2 == null) {
            return;
        }
        u result = uVar.xj("return_bidding_result").xj(hfVar2.c).setResult(hfVar2.y);
        com.bytedance.msdk.api.xj xjVar = hfVar2.f;
        u hf = result.hf(xjVar == null ? 0 : xjVar.xj);
        com.bytedance.msdk.api.xj xjVar2 = hfVar2.f;
        hf.tf(xjVar2 == null ? "" : xjVar2.hf).xj(2).xj("fill_type", Integer.valueOf(i)).xj("server_bidding_extra", hfVar2.u).xj(PointParamKey.AD_COUNT, Integer.valueOf(hfVar2.d));
        HashMap hashMap = new HashMap();
        com.bytedance.msdk.core.d.u.xj(hfVar2.tf, hfVar2.xj, hashMap);
        JSONObject jSONObject = hfVar2.p;
        if (jSONObject != null) {
            hashMap.put("token_time", jSONObject);
        }
        y.xj(uVar, hfVar, (tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, tf tfVar, hf hfVar, String str) {
        uVar.xj("get_bidding_adm_to_adn").y(str);
        HashMap hashMap = new HashMap();
        y.xj(uVar, hfVar, tfVar, (com.bytedance.msdk.hf.w) null, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, com.bytedance.msdk.hf.w wVar, hf hfVar, tf tfVar, long j) {
        uVar.xj("bidding_adm_load").xj(j);
        HashMap hashMap = new HashMap();
        if (com.bytedance.msdk.core.hf.hf().yy() && wVar != null && 5 == wVar.ci()) {
            uVar.xj("ex_info", f.xj().xj(wVar));
        }
        y.xj(uVar, hfVar, tfVar, wVar, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, com.bytedance.msdk.hf.w wVar, hf hfVar, tf tfVar) {
        uVar.xj("bidding_adm_cache");
        HashMap hashMap = new HashMap();
        y.xj(uVar, hfVar, tfVar, wVar, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, hf hfVar, com.bytedance.msdk.hf.w wVar, tf tfVar) {
        uVar.xj("media_cache_success");
        HashMap hashMap = new HashMap();
        y.xj(uVar, hfVar, tfVar, wVar, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    public void xj(u uVar, hf hfVar, com.bytedance.msdk.hf.w wVar, long j) {
        uVar.xj("mediation_video_cached").xj(j);
        HashMap hashMap = new HashMap();
        y.xj(uVar, hfVar, (tf) null, wVar, hashMap);
        com.bytedance.msdk.kd.w.xj(com.bytedance.msdk.core.hf.getContext(), uVar, hashMap);
    }

    private static void xj(u uVar) {
        uVar.xj("block_pacing", "-1");
        uVar.xj("waterfall_show_rule_id", "-1");
        uVar.xj("block_show_count", "-1");
    }
}
