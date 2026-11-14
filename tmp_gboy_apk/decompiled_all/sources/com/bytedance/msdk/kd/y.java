package com.bytedance.msdk.kd;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.v;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private static int hf;
    private static int w;
    private static int xj;

    public static void hf(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, int i, String str, long j, boolean z) {
        hf(wVar, hfVar, i, str, j, null, z);
    }

    public static void w(com.bytedance.msdk.api.xj.hf hfVar, int i) {
        u hf2 = u.hf();
        hf2.xj("mt_ra_c").hf(i);
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, int i, String str, long j, int i2, int i3, String str2) {
        com.bytedance.msdk.core.am.w hf2;
        com.bytedance.msdk.core.tf.hf xj2;
        u hf3 = u.hf();
        hf3.xj("media_reward_verify").xj("adn_preload", Integer.valueOf((wVar == null || !wVar.eu()) ? 0 : 1)).xj(MediationConstant.KEY_REASON, Integer.valueOf(i2)).xj("play_again", Integer.valueOf(i));
        if (i3 != 0 && i3 != 20000) {
            hf3.hf(i3).tf(str2);
        }
        HashMap hashMap = new HashMap();
        boolean z = j >= 0;
        if (wVar != null && wVar.sv()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(v.w()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        if (hfVar != null && (hf2 = com.bytedance.msdk.core.hf.hf()) != null && (xj2 = hf2.xj(hfVar.ra(), hfVar.ht(), 101)) != null) {
            hashMap.put("reward_callback_type", Integer.valueOf(xj2.tj()));
            hashMap.put("reward_start_time", Integer.valueOf(xj2.eu()));
        }
        if (str != null) {
            hf3.xj("sub_adn_name", str);
        }
        xj(hf3, hfVar, (com.bytedance.msdk.core.tf.tf) null, wVar, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf3, hashMap);
    }

    public static void hf(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, int i, String str, long j, String str2, boolean z) {
        u hf2 = u.hf();
        hf2.xj("media_click_listen").xj("adn_preload", Integer.valueOf((wVar == null || !wVar.eu()) ? 0 : 1)).xj("play_again", Integer.valueOf(i)).xj("is_repeat", Integer.valueOf(z ? 1 : 0));
        if (str != null) {
            hf2.xj("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hf2.xj("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        boolean z2 = j >= 0;
        if (wVar != null && wVar.sv()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(v.w()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
            if (z2) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, wVar, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void hf(final com.bytedance.msdk.api.xj.hf hfVar, final int i) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, hfVar, i);
            }
        });
    }

    public static void hf() {
        u hf2 = u.hf();
        hf2.xj("start_up");
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, (Map<String, Object>) null);
    }

    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, int i, String str, long j, boolean z) {
        xj(wVar, hfVar, i, str, j, (String) null, z);
    }

    public static void xj() {
        u hf2 = u.hf();
        hf2.xj("mediation_sdk_init");
        HashMap hashMap = new HashMap();
        hashMap.put("call_init_time", Long.valueOf(com.bytedance.sdk.gromore.init.kd.xj));
        hashMap.put("call_init_csj_start_time", Long.valueOf(com.bytedance.sdk.gromore.init.kd.hf));
        hashMap.put("call_init_csj_end_time", Long.valueOf(com.bytedance.sdk.gromore.init.kd.w));
        hashMap.put("call_init_csj_duration", Long.valueOf(com.bytedance.sdk.gromore.init.kd.hf - com.bytedance.sdk.gromore.init.kd.xj));
        hashMap.put("init_csj_duration", Long.valueOf(com.bytedance.sdk.gromore.init.kd.w - com.bytedance.sdk.gromore.init.kd.hf));
        hashMap.put("call_init_gromore_start_time", Long.valueOf(com.bytedance.sdk.gromore.init.kd.u));
        hashMap.put("call_init_gromore_end_time", Long.valueOf(com.bytedance.sdk.gromore.init.kd.kd));
        hashMap.put("call_init_gromore_duration", Long.valueOf(com.bytedance.sdk.gromore.init.kd.u - com.bytedance.sdk.gromore.init.kd.xj));
        hashMap.put("init_gromore_duration", Long.valueOf(com.bytedance.sdk.gromore.init.kd.kd - com.bytedance.sdk.gromore.init.kd.u));
        hashMap.put("init_total_duration", Long.valueOf(com.bytedance.sdk.gromore.init.kd.kd - com.bytedance.sdk.gromore.init.kd.xj));
        try {
            xj(hf2, (com.bytedance.msdk.api.xj.hf) null, (com.bytedance.msdk.core.tf.tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
            w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public static void hf(long j) {
        u hf2 = u.hf();
        hf2.xj("sdk_backstage").xj(j);
        HashMap hashMap = new HashMap();
        if (com.bytedance.msdk.c.hf.xj.xj().p()) {
            if (com.bytedance.msdk.c.hf.xj.xj().f() > 0) {
                com.bytedance.msdk.c.hf.xj.xj().xj(xj.w);
                hashMap.put("call_init_method_duration", Long.valueOf(com.bytedance.msdk.c.hf.xj.xj().f()));
            }
        } else if (com.bytedance.msdk.c.hf.xj.xj().pl()) {
            hashMap.put("call_init_method_duration", Long.valueOf(com.bytedance.msdk.c.hf.xj.xj().f()));
        }
        hashMap.put("v3", ai.c("v3"));
        hashMap.put("v1", ai.c("v1"));
        hashMap.put("v2Enc_config", ai.c("v2Enc_config"));
        hashMap.put("v4Enc_config", ai.c("v4Enc_config"));
        hashMap.put("v2Enc_exchange", ai.c("v2Enc_exchange"));
        hashMap.put("v4Enc_exchange", ai.c("v4Enc_exchange"));
        hashMap.put("v2Enc_reward", ai.c("v2Enc_reward"));
        hashMap.put("v4Enc_reward", ai.c("v4Enc_reward"));
        hashMap.put("enable_label_return", Integer.valueOf(com.bytedance.msdk.core.hf.hf().a() ? 1 : 0));
        hashMap.put("if_labelapi_call", Integer.valueOf(com.bytedance.msdk.core.xj.p().xj() ? 1 : 0));
        hashMap.put("adn_init_duration", com.bytedance.msdk.y.hf.kd.hf());
        com.bytedance.msdk.core.xj.xj.kd.xj(hashMap);
        JSONArray u = ai.u();
        if (u != null) {
            u.length();
            hashMap.put("sp_v3_bug", u);
        }
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, int i, String str, long j, String str2, boolean z) {
        u hf2 = u.hf();
        hf2.xj("media_show_listen").xj("adn_preload", Integer.valueOf((wVar == null || !wVar.eu()) ? 0 : 1)).xj("play_again", Integer.valueOf(i)).xj("is_repeat", Integer.valueOf(z ? 1 : 0));
        if (str != null) {
            hf2.xj("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hf2.xj("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("enable_label_return", Integer.valueOf(com.bytedance.msdk.core.hf.hf().a() ? 1 : 0));
        hashMap.put("if_labelapi_call", Integer.valueOf(com.bytedance.msdk.core.xj.p().xj() ? 1 : 0));
        com.bytedance.msdk.core.hf.w.xj(wVar, hfVar, hashMap);
        boolean z2 = j >= 0;
        if (wVar != null && wVar.sv()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(v.w()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
            if (z2) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, wVar, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void hf(com.bytedance.msdk.api.xj.hf hfVar) {
        u hf2 = u.hf();
        hf2.xj("mt_ra_cc");
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, String str) {
        u hf2 = u.hf();
        hf2.xj("media_show_dislike").tf(str);
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, wVar, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, boolean z, int i) {
        xj(wVar, hfVar, z, i, (Map<String, Object>) null);
    }

    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, boolean z, int i, Map<String, Object> map) {
        u hf2 = u.hf();
        hf2.xj("media_show").xj("adn_preload", Integer.valueOf((wVar == null || !wVar.eu()) ? 0 : 1)).xj("play_again", Integer.valueOf(i)).xj("is_repeat", Integer.valueOf(z ? 1 : 0));
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, wVar, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(List<com.bytedance.msdk.hf.w> list, List<com.bytedance.msdk.hf.w> list2, List<com.bytedance.msdk.hf.w> list3, com.bytedance.msdk.api.xj.hf hfVar, int i) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        if (list3 != null && list3.size() > 0) {
            arrayList.addAll(list3);
        }
        int i2 = 0;
        com.bytedance.msdk.hf.w wVar = arrayList.size() > 0 ? (com.bytedance.msdk.hf.w) arrayList.get(0) : null;
        u hf2 = u.hf();
        hf2.xj("media_show_is_ready");
        if (i == 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList.iterator();
                loop0: while (true) {
                    z = false;
                    while (it.hasNext()) {
                        com.bytedance.msdk.hf.w wVar2 = (com.bytedance.msdk.hf.w) it.next();
                        if (wVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(SplashAd.KEY_BIDFAIL_ADN, wVar2.lw());
                            jSONObject.put(PointParamKey.TYPE, com.bytedance.msdk.hf.xj.xj(wVar2.ci(), wVar2.tj()));
                            jSONObject.put("adnSlotId", wVar2.cy());
                            jSONObject.put("loadSort", wVar2.zd());
                            jSONObject.put("showSort", wVar2.kc());
                            if (hfVar != null) {
                                jSONObject.put("isReady", wVar2.ff(hfVar.ra()) ? 1 : 0);
                            }
                            jSONObject.put("hasShown", wVar2.tu() ? 1 : 0);
                            if (wVar2.ew()) {
                                jSONObject.put("is_video_cache_success", wVar2.qf() ? 1 : 0);
                            }
                            jSONObject.put("mediationrit_req_type", wVar2.f(hfVar != null ? hfVar.xj() : null));
                            jSONObject.put("mediationrit_req_type_src", wVar2.d(hfVar != null ? hfVar.xj() : null));
                            jSONArray.put(jSONObject);
                            if (!z && hfVar != null) {
                                if (hfVar.ht() == 5) {
                                    z = wVar2.ff(hfVar.ra());
                                } else if (wVar2.ff(hfVar.ra()) && !wVar2.tu()) {
                                    z = true;
                                }
                            }
                        }
                    }
                    break loop0;
                }
                if (!z) {
                    i2 = -1;
                }
                hf2.hf(i2);
                hf2.tf(jSONArray.toString());
            } catch (JSONException e) {
                pl.xj(e);
            }
        } else {
            hf2.hf(2);
            hf2.tf(com.bytedance.msdk.api.xj.xj(i));
        }
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, wVar, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(List<com.bytedance.msdk.hf.w> list, com.bytedance.msdk.api.xj.hf hfVar, int i) {
        com.bytedance.msdk.hf.w wVar = (list == null || list.size() <= 0) ? null : list.get(0);
        u hf2 = u.hf();
        hf2.xj("media_show_fail");
        if (i == 0) {
            hf2.hf(40052);
            if (wVar != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (com.bytedance.msdk.hf.w wVar2 : list) {
                        if (wVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(SplashAd.KEY_BIDFAIL_ADN, wVar2.lw());
                            jSONObject.put(PointParamKey.TYPE, com.bytedance.msdk.hf.xj.xj(wVar2.ci(), wVar2.tj()));
                            jSONObject.put("adnSlotId", wVar2.cy());
                            jSONObject.put("loadSort", wVar2.zd());
                            jSONObject.put("showSort", wVar2.kc());
                            if (hfVar != null) {
                                jSONObject.put("isReady", wVar2.ff(hfVar.ra()) ? 1 : 0);
                            }
                            jSONObject.put("hasShown", wVar2.tu() ? 1 : 0);
                            jSONArray.put(jSONObject);
                        }
                    }
                    hf2.tf(jSONArray.toString());
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        } else {
            hf2.hf(i);
            hf2.tf(com.bytedance.msdk.api.xj.xj(i));
        }
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, wVar, hashMap);
        hf2.xj("is_video_cache_success", 0);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(com.bytedance.msdk.api.xj.hf hfVar, int i) {
        u hf2 = u.hf();
        hf2.xj("media_carousel_fail").hf(i).tf(com.bytedance.msdk.api.xj.xj(i));
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
        hf2.xj("is_video_cache_success", 0);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(final int i, final int i2, final long j, final String str, final String str2) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.1
            @Override // java.lang.Runnable
            public void run() {
                u.this.xj("rit_map_query").setResult(i2).xj(j).kd(i);
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str)) {
                    u.this.f(str);
                    hashMap.put("origin_rit", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    u.this.hf(str2);
                    hashMap.put(MediationConstant.KEY_GM_PRIME_RIT, str2);
                }
                w.xj(com.bytedance.msdk.core.hf.getContext(), u.this, hashMap);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.core.tf.tf tfVar, final com.bytedance.msdk.api.xj.hf hfVar, final String str, final boolean z, final int i, final int i2, final int i3, final int i4, final com.bytedance.msdk.api.xj xjVar, final long j, final boolean z2, final boolean z3) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.12
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, tfVar, hfVar, str, z, i, i2, i3, i4, xjVar, j, z2, z3, null);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.core.tf.tf tfVar, final com.bytedance.msdk.api.xj.hf hfVar, final String str, final boolean z, final int i, final int i2, final int i3, final int i4, final com.bytedance.msdk.api.xj xjVar, final long j, final boolean z2, final boolean z3, final String str2) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.16
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, tfVar, hfVar, str, z, i, i2, i3, i4, xjVar, j, z2, z3, str2);
            }
        });
    }

    public static void xj(com.bytedance.msdk.core.tf.tf tfVar, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.hf.w wVar, int i, String str) {
        u hf2 = u.hf();
        u xj2 = hf2.xj("bidding_info_invalid").hf(i).tf(str).xj(PointParamKey.AD_COUNT, Integer.valueOf(hfVar != null ? hfVar.x() : 0));
        com.bytedance.msdk.core.am.hf.xj(com.bytedance.msdk.core.hf.hf());
        xj2.xj("grouping_params", com.bytedance.msdk.core.am.hf.hf()).xj("log_source", 2);
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, tfVar, wVar, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(final com.bytedance.msdk.hf.w wVar, final int i, final String str, final long j, final com.bytedance.msdk.api.xj.hf hfVar, final int i2, final int i3, final int i4, final String str2, final long j2, final long j3) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.17
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, wVar, i, str, j, hfVar, i2, i3, i4, str2, j2, j3);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.api.xj xjVar, final com.bytedance.msdk.api.xj.hf hfVar, final com.bytedance.msdk.core.tf.tf tfVar, final int i, final int i2, final int i3, final String str, final long j, final String str2, final String str3, final String str4, final long j2) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.18
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, xjVar, hfVar, tfVar, i, i2, i3, str, j, str2, str3, str4, j2);
            }
        });
    }

    public static void xj(com.bytedance.msdk.api.xj xjVar, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.core.tf.tf tfVar, int i, int i2, int i3, String str, long j) {
        u hf2 = u.hf();
        hf2.xj("bidding_adm_load_fail").xj(j).y(str).hf(xjVar != null ? xjVar.w : -1).tf(xjVar != null ? xjVar.u : "unknown error").xj("adn_count", Integer.valueOf(i)).xj("adn_preload", 0).xj("mediationrit_req_type", Integer.valueOf(i2)).xj("mediationrit_req_type_src", Integer.valueOf(i3));
        if (xjVar instanceof com.bytedance.msdk.api.hf.xj) {
            hf2.am = xjVar.xj;
            hf2.p = xjVar.hf;
        }
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, tfVar, (com.bytedance.msdk.hf.w) null, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(final com.bytedance.msdk.api.xj.hf hfVar, final com.bytedance.msdk.api.xj xjVar, final String str) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.19
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, hfVar, xjVar, str);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.core.tf.tf tfVar, final com.bytedance.msdk.api.xj.hf hfVar, final int i, final int i2) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.20
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, tfVar, hfVar, i, i2);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.api.xj.hf hfVar, final String str, final boolean z, final String str2, final int i, final Map<String, Object> map) {
        if (hfVar != null) {
            com.bytedance.sdk.gromore.hf.xj.xj().xj(hfVar.xj(), xj.w);
        }
        final u w2 = u.w();
        final long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.21
            @Override // java.lang.Runnable
            public void run() {
                u.this.xj(System.currentTimeMillis() - currentTimeMillis);
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, hfVar, str, z, str2, i, map);
            }
        });
    }

    public static void xj(Map<String, Object> map, final com.bytedance.msdk.api.xj.hf hfVar, final com.bytedance.msdk.hf.w wVar, final long j, final int i, final int i2, final int i3, final String str, final int i4, final int i5, final com.bytedance.msdk.core.tf.hf hfVar2) {
        JSONObject jSONObject;
        int i6;
        final u w2 = u.w();
        if (map != null) {
            int intValue = map.get("group_type") instanceof Integer ? ((Integer) map.get("group_type")).intValue() : 0;
            double doubleValue = map.get("ecpm") instanceof Double ? ((Double) map.get("ecpm")).doubleValue() : 0.0d;
            jSONObject = new JSONObject();
            try {
                jSONObject.put("price_from", map.get("price_from"));
                jSONObject.put("grout_type", intValue);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("target_ecpm_origin", doubleValue);
                jSONObject2.put("target_ecpm_upper", map.get("upper_cpm_x"));
                jSONObject.put("price", jSONObject2);
                if (map.get("price_source") != null) {
                    jSONObject.put("price_source", map.get("price_source"));
                }
                int intValue2 = map.get("rule_in_use") instanceof Integer ? ((Integer) map.get("rule_in_use")).intValue() : 0;
                boolean booleanValue = map.get("has_serverBidding") instanceof Boolean ? ((Boolean) map.get("has_serverBidding")).booleanValue() : false;
                if (intValue != 3 && intValue != 4) {
                    i6 = 0;
                } else if (!booleanValue) {
                    i6 = 1;
                } else if (doubleValue == 0.0d) {
                    i6 = 2;
                } else if (intValue2 == 0) {
                    i6 = 5;
                } else {
                    i6 = (intValue != 4 || (map.get("serverBidding_timeout") instanceof Boolean ? ((Boolean) map.get("serverBidding_timeout")).booleanValue() : false)) ? 4 : 3;
                }
                jSONObject.put("pos_state", i6);
                jSONObject.put("rule_id", map.get("rule_id"));
                jSONObject.put("rule_inuse", intValue2);
            } catch (JSONException unused) {
            }
        } else {
            jSONObject = null;
        }
        final JSONObject jSONObject3 = jSONObject;
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.22
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, hfVar, wVar, j, i, i2, i3, str, i4, i5, hfVar2, jSONObject3);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.api.xj.hf hfVar, final com.bytedance.msdk.hf.w wVar, final long j) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, hfVar, wVar, j);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.api.xj.hf hfVar, final com.bytedance.msdk.hf.w wVar, final com.bytedance.msdk.core.tf.tf tfVar) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, hfVar, wVar, tfVar);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.hf.w wVar, final com.bytedance.msdk.api.xj.hf hfVar, final com.bytedance.msdk.core.tf.hf hfVar2, final long j, final String str, final boolean z, final int i, final boolean z2, final boolean z3) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, wVar, hfVar, hfVar2, j, str, z, i, z2, z3);
            }
        });
    }

    public static void xj(final boolean z) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.6
            @Override // java.lang.Runnable
            public void run() {
                w2.xj("get_config_start").xj(MediationConstant.KEY_REASON, Integer.valueOf(z ? com.bytedance.msdk.c.xj.xj().kd("is_config_from_assert") ? 2 : 1 : 0));
                w.xj(com.bytedance.msdk.core.hf.getContext(), w2, (Map<String, Object>) null);
            }
        });
    }

    public static void xj(long j) {
        String str;
        u hf2 = u.hf();
        hf2.xj("sdk_init").w(j);
        ai y = com.bytedance.msdk.c.xj.y();
        boolean kd = y.kd("check_unity3d");
        long u = y.u("check_unity3d_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (kd && currentTimeMillis - u > 2592000000L) {
            try {
                Class.forName("com.unity3d.player.UnityPlayer");
                str = "unity_pure";
                try {
                    Class.forName("com.bytedance.android.NativeAdManager");
                    str = MediationConstant.ADN_UNITY;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = null;
            }
            if (str != null) {
                hf2.xj("develop_type", str);
            }
            y.xj("check_unity3d", true);
            y.xj("check_unity3d_time", currentTimeMillis);
        }
        HashMap hashMap = new HashMap();
        int u2 = com.bytedance.msdk.c.hf.xj.xj().u();
        if (u2 > 0) {
            com.bytedance.msdk.c.hf.xj.xj().kd();
            hashMap.put("discard_num", Integer.valueOf(u2));
        }
        hashMap.put("csj_plugin_version", com.bytedance.msdk.y.w.w());
        JSONObject kd2 = ai.kd();
        if (kd2 != null) {
            hashMap.put("init_time", kd2);
        }
        ai.xj(hashMap);
        ai.hf(hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.7
            @Override // java.lang.Runnable
            public void run() {
                u.this.xj("callstack_dynamic");
                u.this.xj("callstack_message", str);
                u.this.xj("callstack_report_time", 1);
                w.xj(com.bytedance.msdk.core.hf.getContext(), u.this, (Map<String, Object>) null);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.hf.w wVar, final com.bytedance.msdk.api.xj.hf hfVar, final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.8
            @Override // java.lang.Runnable
            public void run() {
                u.this.xj("callstack_static").xj("callstack_message", str).xj("callstack_report_time", Integer.valueOf(i));
                HashMap hashMap = new HashMap();
                y.xj(u.this, hfVar, (com.bytedance.msdk.core.tf.tf) null, wVar, hashMap);
                w.xj(com.bytedance.msdk.core.hf.getContext(), u.this, hashMap);
            }
        });
    }

    public static void xj(long j, int i, int i2, long j2, JSONObject jSONObject, Map<String, Object> map) {
        u hf2 = u.hf();
        hf2.xj("sdk_init_end");
        hf2.xj(j);
        hf2.w(j2);
        hf2.xj("adn_count", Integer.valueOf(i));
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put("is_from_local_config", Integer.valueOf(i2));
        hashMap.put("adapter_version_list", com.bytedance.msdk.f.c.xj());
        if (jSONObject != null) {
            hashMap.put("local_init_time", jSONObject);
        }
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(int i, int i2, long j, boolean z, boolean z2, JSONObject jSONObject, long j2, JSONObject jSONObject2) {
        u hf2 = u.hf();
        boolean kd = com.bytedance.msdk.c.xj.xj().kd("is_config_from_assert");
        if (i != 1) {
            i = (z || (i == 0 && kd)) ? 2 : 0;
        }
        hf2.setResult(i).xj(j).xj("get_config_final").y(i2).hf(i2).xj("transparent_params", com.bytedance.msdk.core.hf.hf().d());
        HashMap hashMap = new HashMap();
        com.bytedance.msdk.core.d.u.xj(z2, hf2, jSONObject, hashMap);
        if (jSONObject2 != null) {
            hashMap.put("cfg_handle_time", jSONObject2);
        }
        hashMap.put("config_size", Long.valueOf(j2));
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(final com.bytedance.msdk.api.xj.hf hfVar, final JSONObject jSONObject) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.9
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, hfVar, jSONObject);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.api.xj.hf hfVar, final com.bytedance.msdk.core.u.hf hfVar2, final int i) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.10
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, hfVar, hfVar2, i);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.hf.w wVar, final com.bytedance.msdk.api.xj.hf hfVar, final List<com.bytedance.msdk.hf.w> list, final List<com.bytedance.msdk.hf.w> list2) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.11
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, wVar, hfVar, list, list2);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.core.tf.tf tfVar, final com.bytedance.msdk.api.xj.hf hfVar, final String str) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.13
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, tfVar, hfVar, str);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.hf.w wVar, final com.bytedance.msdk.api.xj.hf hfVar, final com.bytedance.msdk.core.tf.tf tfVar, final long j) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.14
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, wVar, hfVar, tfVar, j);
            }
        });
    }

    public static void xj(final com.bytedance.msdk.hf.w wVar, final com.bytedance.msdk.api.xj.hf hfVar, final com.bytedance.msdk.core.tf.tf tfVar) {
        final u w2 = u.w();
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.kd.y.15
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.kd.w.xj.xj().xj(u.this, wVar, hfVar, tfVar);
            }
        });
    }

    public static void xj(com.bytedance.msdk.api.xj.hf hfVar, String str) {
        u hf2 = u.hf();
        hf2.xj("cache_cannot_use").xj("cache_invalid_info", str);
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.hf.w wVar, String str) {
        u hf2 = u.hf();
        hf2.xj("rit_cache_cannot_use").xj("cache_invalid_info", str);
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, wVar, hashMap);
        hf2.xj("mediationrit_req_type", 2);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(com.bytedance.msdk.api.xj.hf hfVar) {
        u hf2 = u.hf();
        hf2.xj("media_will_show");
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.xj xjVar, int i, int i2, String str, long j) {
        xj(wVar, hfVar, xjVar, i, i2, str, j, (String) null);
    }

    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.xj xjVar, int i, int i2, String str, long j, String str2) {
        u hf2 = u.hf();
        hf2.setResult(i).hf(xjVar != null ? xjVar.w : 0).tf(xjVar != null ? xjVar.u : null).xj("media_show_fail_listen").xj("play_again", Integer.valueOf(i2));
        if (str != null) {
            hf2.xj("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hf2.xj("callstack_message", str2);
        }
        HashMap hashMap = new HashMap();
        boolean z = j >= 0;
        if (wVar != null && wVar.sv()) {
            hashMap.put("custom_adn_sample_ratio", Double.valueOf(v.w()));
            hashMap.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                hashMap.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, wVar, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, int i, int i2, int i3, String str) {
        u hf2 = u.hf();
        hf2.setResult(i2).xj("media_show_after").xj("play_again", Integer.valueOf(i3)).xj(MediationConstant.KEY_REASON, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hf2.xj("callstack_message", str);
        }
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, wVar, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(String str, com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.core.tf.tf tfVar, com.bytedance.msdk.api.xj xjVar) {
        u hf2 = u.hf();
        u tf = hf2.hf(xjVar != null ? xjVar.xj : 0).tf(xjVar != null ? xjVar.hf : null);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        tf.kd(str).xj("custom_adn_init_fail");
        HashMap hashMap = new HashMap();
        xj(hf2, hfVar, tfVar, wVar, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    public static void xj(com.bytedance.msdk.api.xj.hf hfVar, int i, int i2) {
        u hf2 = u.hf();
        hf2.xj("mt_ra_s").hf(i);
        HashMap hashMap = new HashMap();
        hashMap.put("pre_req", Integer.valueOf(i2));
        xj(hf2, hfVar, (com.bytedance.msdk.core.tf.tf) null, (com.bytedance.msdk.hf.w) null, hashMap);
        w.xj(com.bytedance.msdk.core.hf.getContext(), hf2, hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void xj(com.bytedance.msdk.kd.u r14, com.bytedance.msdk.api.xj.hf r15, com.bytedance.msdk.core.tf.tf r16, com.bytedance.msdk.hf.w r17, java.util.Map<java.lang.String, java.lang.Object> r18) {
        /*
            Method dump skipped, instructions count: 1269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.kd.y.xj(com.bytedance.msdk.kd.u, com.bytedance.msdk.api.xj.hf, com.bytedance.msdk.core.tf.tf, com.bytedance.msdk.hf.w, java.util.Map):void");
    }
}
