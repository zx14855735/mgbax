package com.bytedance.sdk.openadsdk.core.d.xj.u;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.p.u.kd;
import com.bytedance.sdk.component.p.u.u;
import com.bytedance.sdk.component.p.u.w;
import com.bytedance.sdk.component.p.xj.hf;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.hf;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.j.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.w.y;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static String c;
    private static String f;
    private static long kd;
    private static long y;
    private static AtomicInteger xj = new AtomicInteger(0);
    private static SharedPreferences hf = hf.hf(pz.getContext(), "uchain_data", 0);
    private static int w = -1;
    private static int u = -1;

    /* renamed from: com.bytedance.sdk.openadsdk.core.d.xj.u.xj$3, reason: invalid class name */
    public static class AnonymousClass3 implements w {
        final /* synthetic */ JSONArray xj;

        public AnonymousClass3(JSONArray jSONArray) {
            this.xj = jSONArray;
        }

        @Override // com.bytedance.sdk.component.p.u.w
        public void xj(com.bytedance.sdk.component.p.xj.xj xjVar) {
            xjVar.xj(new u() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.u.xj.3.1
                @Override // com.bytedance.sdk.component.p.u.u
                public kd hf() {
                    return new kd() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.u.xj.3.1.1
                        @Override // com.bytedance.sdk.component.p.u.kd
                        public void hf(com.bytedance.sdk.component.p.xj.xj xjVar2, Map<String, Object> map) {
                            try {
                                String xj = xjVar2.c().xj();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("event", xj);
                                jSONObject.put("status", false);
                                AnonymousClass3.this.xj.put(jSONObject);
                            } catch (JSONException e) {
                                pl.xj(e);
                            }
                        }

                        @Override // com.bytedance.sdk.component.p.u.kd
                        public void xj(com.bytedance.sdk.component.p.xj.xj xjVar2, Map<String, Object> map) {
                            try {
                                String xj = xjVar2.c().xj();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("event", xj);
                                jSONObject.put("status", true);
                                AnonymousClass3.this.xj.put(jSONObject);
                            } catch (JSONException e) {
                                pl.xj(e);
                            }
                        }
                    };
                }
            });
        }
    }

    static {
        JQjgGlX();
    }

    private static /* synthetic */ void JQjgGlX() {
        char[] charArray = "\u009f\u0093\u0091Ò\u009b\u009d\u0091\u0099Ò\u009e\u0093\u0085Ò\u008f\u0094\u0099\u0090\u0090Ò¶\u0092\u0095¾\u008e\u0095\u0098\u009b\u0099".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 252);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009f\u0090\u0095\u0092\u0095\u0088".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 252);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void p() {
        String xl;
        String dj;
        JSONObject hf2;
        w = -1;
        tf hf3 = pz.hf();
        if (hf3 != null && (hf2 = hf((xl = hf3.xl()), (dj = hf3.dj()))) != null && hf2.length() > 0) {
            u = 2;
            c = xl;
            f = dj;
            long currentTimeMillis = System.currentTimeMillis() - y;
            kd = currentTimeMillis;
            hf(w, u, currentTimeMillis);
            hf(hf2);
            return;
        }
        JSONObject xj2 = xj();
        if (xj2 == null || xj2.length() <= 0) {
            xj.set(3);
            hf(w, u, kd);
            return;
        }
        u = 0;
        f = "uc_dsl/uc_dsl.bin";
        long currentTimeMillis2 = System.currentTimeMillis() - y;
        kd = currentTimeMillis2;
        hf(w, u, currentTimeMillis2);
        hf(xj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tf() {
        w = 100008;
        long currentTimeMillis = System.currentTimeMillis() - y;
        kd = currentTimeMillis;
        hf(w, u, currentTimeMillis);
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            jSONObject = xj();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("event_template");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                com.bytedance.sdk.component.p.w.hf.INSTANCE.xj(optJSONObject);
                xj.set(2);
                return;
            } else {
                xj.set(3);
                return;
            }
        }
        xj.set(3);
    }

    public static void xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = "21ea2d6d4f321553dd684e6b864bf0b7";
            str2 = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20103/uchain_dsl.bin";
        }
        c = str;
        f = str2;
        y = System.currentTimeMillis();
        JSONObject hf2 = hf(c, f);
        if (hf2 != null && hf2.length() > 0) {
            u = 2;
            long currentTimeMillis = System.currentTimeMillis() - y;
            kd = currentTimeMillis;
            hf(w, u, currentTimeMillis);
            hf(hf2);
            return;
        }
        com.bytedance.sdk.component.d.hf.xj kd2 = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().kd();
        if (kd2 == null) {
            xj.set(3);
            return;
        }
        kd2.xj(f);
        final String str3 = c;
        final String str4 = f;
        kd2.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.u.xj.1
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                int unused = xj.u = 1;
                String unused2 = xj.c = str3;
                String unused3 = xj.f = str4;
                if (hfVar != null) {
                    try {
                        if (hfVar.f()) {
                            JSONObject xj2 = y.xj(hfVar.tf(), "uchain_dsl");
                            long unused4 = xj.kd = System.currentTimeMillis() - xj.y;
                            if (xj2 != null && xj2.length() > 0) {
                                xj.hf(xj.w, xj.u, xj.kd);
                                xj.hf(xj2);
                                xj.hf.edit().putString(str3, com.bytedance.sdk.component.utils.xj.hf(xj2.toString())).apply();
                                return;
                            }
                            xj.hf(xj.w, xj.u, xj.kd);
                            xj.tf();
                            return;
                        }
                    } catch (Throwable unused5) {
                        xj.tf();
                        return;
                    }
                }
                xj.tf();
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                int unused = xj.u = 1;
                xj.tf();
            }
        });
    }

    public static JSONObject hf(String str, String str2) {
        if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String string = hf.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            String w2 = com.bytedance.sdk.component.utils.xj.w(string);
            u = 2;
            c = str;
            f = str2;
            return new JSONObject(w2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(final int i, final int i2, final long j) {
        com.bytedance.sdk.openadsdk.core.ht.hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.u.xj.2
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                try {
                    int i3 = i;
                    if (i3 != -1) {
                        jSONObject.put("dsl_error_code", i3);
                    }
                    jSONObject.put("dsl_url", xj.f);
                    jSONObject.put("dsl_md5", xj.c);
                    jSONObject.put("dsl_load_type", i2);
                    jSONObject.put("dsl_load_time", j);
                    jSONObject.put("dsl_stats_id", UUID.randomUUID());
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("uchain_stats_tracker").hf(jSONObject.toString());
            }
        }, "uchain_stats_tracker", false);
    }

    public static void xj(ws wsVar, Map<String, Object> map, String str, HashMap<String, Object> hashMap, String str2, HashMap<String, Object> hashMap2) {
        if (xj.get() != 2) {
            y = System.currentTimeMillis();
            p();
        }
        if (wsVar == null) {
            return;
        }
        JSONObject ac = wsVar.ac();
        try {
            for (Map.Entry<String, Object> entry : hashMap2.entrySet()) {
                ac.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        JSONArray jSONArray = new JSONArray();
        new hf.xj(str).xj(ac).xj(hashMap).xj(new AnonymousClass3(jSONArray)).xj().xj();
        JSONObject jSONObject = new JSONObject();
        UUID randomUUID = UUID.randomUUID();
        if (map != null) {
            map.put("uchain_event_id", randomUUID);
        }
        try {
            jSONObject.put("uchain_event_id", randomUUID);
            jSONObject.put(str, jSONArray);
            jSONObject.put("slot_type", wo.f(wsVar));
            com.bytedance.sdk.openadsdk.core.am.u.hf(wsVar, str2, "uchain_event_tracker", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static boolean xj(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("is_feed_register_direct_download");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static JSONObject xj() {
        try {
            return new JSONObject("{\"template_info\":{\"version\":\"2.1.3\"},\"event_template\":{\"clickEvent\":{\"main\":\"open_sass_live\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_sass_live\",\"scheme\":\"uchain://open_sass_live?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&coupon=${coupon}&ec_schema=${ec_schema}&ecom_live_params=${ecom_live_params}&live_interaction_type=${live_interaction_type}&live_room_id=${live_room_id}&deep_link=${deep_link}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"name\":\"open_miniapp\"}]}},{\"name\":\"open_miniapp\",\"scheme\":\"uchain://open_miniapp?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&wc_miniapp_info=${wc_miniapp_info}&target_url=${target_url}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(is_video_lp==true||if_both_open==1)&&deep_link==null&&ulink==null}\",\"name\":\"open_landing_page\"},{\"condition\":\"${deep_link!=null||ulink!=null||(is_video_lp!=true&&if_both_open==0)}\",\"name\":\"open_scheme\"}]}},{\"name\":\"open_landing_page\",\"scheme\":\"uchain://open_landing_page?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&title=${title!=null?title:'广告'}&url=${target_url}&button_text=${button_text!=null?button_text:'立即下载'}&gecko_id=${gecko_id}&block_auto_open=${block_auto_open}&ugeno=${ugeno}&page_render_type=${page_render_type}&session_params=${session_params}&dylite_info=${dylite_info}&filter_words=${filter_words}&video=${video}&app_info=${app}&use_media_video_player=${use_media_video_player}&source=${source}&title=${title}&image_mode=${image_mode}&landing_page_conf=${landing_page_conf}&image=${image}&landing_scroll_percentage=${landing_scroll_percentage}&sdk_derive_info=${sdk_derive_info}&dynamic_join_type=${dynamic_join_type}&audio=${audio}&disable_video_join=${disable_video_join}&disable_top_bar=${disable_top_bar}&disable_rtn_button=${disable_rtn_button}&disable_safe_area=${disable_safe_area}&gnd_prefetch_timing=${gnd_prefetch_timing}&gnd_prefetch_cache_key=${gnd_prefetch_cache_key}&direct_landing_page_info=${direct_landing_page_info}&reward_browse_type=${reward_browse_type}&voice_control=${voice_control}\",\"params\":{},\"next\":[{\"condition\":\"${if_both_open==1&&(is_video_lp!=true||app.appleid==null||app.appleid=='0')}\",\"name\":\"download\"}],\"callback\":{\"success\":[],\"fail\":[]}},{\"name\":\"open_scheme\",\"scheme\":\"uchain://open_scheme?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&deep_link=${deep_link}&ulink=${ulink}&ulink_priority=${ulink_priority}&sub_convert_link=${sub_convert_link}&app_info=${app}&block_auto_open=${block_auto_open}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==1)||(deep_link==null&&(interaction_type==3||ext.interaction_type==3))}\",\"name\":\"open_landing_page\"},{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==2)||(deep_link==null&&(interaction_type==4||ext.interaction_type==4))}\",\"name\":\"download\"}]}},{\"name\":\"download\",\"scheme\":\"uchain://download?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&app_info=${app}&download_conf=${download_conf}&appstore_jump_type=${appstore_jump_type}&market_url=${market_url}&download_sdk_conf=${download_sdk_conf}&icon=${icon}&interaction_type=${interaction_type}&skan=${skan}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${if_both_open==0}\",\"name\":\"open_landing_page\"}]}}]},\"ugen_view_visibility_tracker\":{\"main\":\"report_event\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"report_event\",\"scheme\":\"uchain://report_event?label=ugen_view_visibility&ad_id=${ad_id}&log_extra=${ext}&ugen_id=${ugen_event_params.ugen_id}&visibility=${ugen_event_params.visibility}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_rate\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=rate&identifier=${ad_info}&rate=1.0\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_pause\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=pause&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_play\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=play&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_replay\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=replay&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"openPolicy\":{\"main\":\"open_policy\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_policy\",\"scheme\":\"uchain://open_policy?ad_info=${ad_info}&adx_name=${adx_name}&filter_words=${filter_words}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"continue_watch\":{\"main\":\"reward_continue\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_continue\",\"scheme\":\"uchain://reward_continue\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"exit_watch\":{\"main\":\"close_reward\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"close_reward\",\"scheme\":\"uchain://close_reward\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"reward_again\":{\"main\":\"reward_again\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_again\",\"scheme\":\"uchain://reward_again?pression_sessions=${play_again.pression_sessions}&play_again_rit=${play_again.play_again_rit}&log_extra=${ext}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]}}}");
        } catch (Exception unused) {
            return null;
        }
    }
}
