package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.core.ra.wa;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwad.sdk.api.model.AdnName;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ws {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10422a;
    private String ac;
    private String ai;
    private j ap;
    private wo aq;
    private int az;
    private am bh;
    private int bl;
    private String co;
    private int ct;
    private String cu;
    private int cy;
    private JSONObject d;
    private String da;
    private int db;
    private aq dc;
    private JSONObject dj;
    private int dk;
    private com.bytedance.sdk.openadsdk.zg.w.w.hf dq;
    private com.bytedance.sdk.openadsdk.core.ugeno.y.xj dz;
    private String e;
    private String eb;
    private int en;
    private boolean eq;
    private String et;
    private lw ew;
    private n ey;
    private String f;
    private x fa;
    private p fc;
    private int ff;
    private dk fh;
    private int fs;
    private wa ft;
    private JSONObject gj;
    private int ha;
    public String hf;
    private jk hl;
    private String ho;
    private int hq;
    private pz ht;
    private y hx;
    private String i;
    private a ic;

    /* renamed from: if, reason: not valid java name */
    private int f1if;

    /* renamed from: io, reason: collision with root package name */
    private String f10423io;
    private int ir;
    private String it;
    private int iy;
    private int j;
    private bl jb;
    private gy jf;
    private v jq;
    private boolean js;
    private int jv;
    private int jw;
    private long k;
    private l ka;
    private z kd;
    private int kf;
    private String kr;
    private int kt;
    private boolean ky;
    private h l;
    private boolean le;
    private boolean lm;
    private String lp;
    private JSONObject lt;
    private int m;
    private hl mq;
    private String my;
    private JSONObject nb;
    private int ne;
    private int no;
    private dc nt;
    private String nu;
    private ht o;
    private String oa;
    private boolean ob;
    private int og;
    private int ol;
    private eu oz;

    /* renamed from: pl, reason: collision with root package name */
    private String f10424pl;
    private String pn;
    private JSONObject ps;
    private String pu;
    private int py;
    private kd pz;
    private long q;
    private int qd;
    private int qf;
    private String qt;
    private zg ra;
    private JSONObject rs;
    private en rx;
    private int se;
    private long si;
    private String su;
    private int sv;
    private boolean ta;
    private JSONObject tf;
    private e tq;
    private int u;
    private String ua;
    private op uf;
    private long uh;
    private int uj;
    private com.bytedance.sdk.openadsdk.core.ugeno.d.xj ul;
    private io uo;
    private g vh;
    private String vi;
    private Map<String, Object> vm;
    private com.bytedance.sdk.openadsdk.core.dislike.w.hf w;
    private String wa;
    private int wf;
    private vm wn;
    private boolean wo;
    private r wx;
    private JSONObject x;
    private volatile JSONObject xe;
    public ne xj;
    private String xk;
    private et xl;
    private int xw;
    private String y;
    private String yo;
    private JSONObject yq;
    private s yt;
    private boolean yy;
    private long z;
    private String zb;
    private String zd;
    private yy zf;
    private long zg;
    private int c = -1;
    private List<z> p = new ArrayList();
    private List<String> g = new ArrayList();
    private List<String> am = new ArrayList();
    private String v = Constants.FAIL;
    private String jk = Constants.FAIL;
    private int r = -1;
    private long b = -1;
    private long ws = -1;
    private long eu = System.currentTimeMillis();
    private String tj = UUID.randomUUID().toString();
    private String n = "";
    private int tu = IOfflineCompo.Priority.HIGHEST;
    private int s = 0;
    private int lw = 1;
    private int gh = 0;
    private int op = 0;
    private int gy = 0;
    private int ss = 1;
    private int xv = 0;
    private int vl = 0;
    private int h = 0;
    private int rg = 1;
    private boolean t = false;
    private int qi = 1;
    private float kc = 100.0f;
    private int mg = 0;
    private int ut = 2;
    private int he = 0;
    private int zm = 100;
    private int ci = 2;
    private int vw = 2;
    private float lx = 0.07f;
    private float ah = 0.0f;
    private long qa = 0;
    private boolean oe = true;
    private int rq = -1;
    private int ie = 0;
    private int ee = 0;
    private long qe = 0;
    private int nn = 0;
    private List<q> lv = new ArrayList();

    private float hm() {
        if (this.ft == null) {
            return 5.0f;
        }
        return r0.qt();
    }

    public long a() {
        return this.si;
    }

    public ht aa() {
        return this.o;
    }

    public JSONObject ac() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s_sig_ts", lt());
            jSONObject.put("ad_rec_stamp", fa());
            jSONObject.put("interaction_type", vw());
            jSONObject.put(PointCategory.TARGET_URL, ol());
            jSONObject.put("use_media_video_player", eu());
            jSONObject.put("landing_scroll_percentage", jw());
            jSONObject.put("gecko_id", db());
            jSONObject.put("extension", m());
            jSONObject.put("overlay", ir());
            jSONObject.put(MediationConstant.EXTRA_ADID, ho());
            jSONObject.put(com.sigmob.sdk.base.n.l, ci());
            jSONObject.put(com.sigmob.sdk.base.n.p, fh());
            jSONObject.put("screenshot", ct());
            jSONObject.put("play_bar_style", wa());
            jSONObject.put("play_bar_show_time", nb());
            jSONObject.put("if_block_lp", yy());
            jSONObject.put("cache_sort", ss());
            jSONObject.put("if_sp_cache", gj());
            jSONObject.put("splash_timeout_stage", cy());
            jSONObject.put("is_from_local_cache", ha());
            jSONObject.put("is_from_cache_type", oe());
            jSONObject.put("correct_action_code", ps());
            jSONObject.put("correct_result_code", js());
            jSONObject.put("meta_hashcode", kd());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cta", b());
            jSONObject2.put(AdnName.OTHER, r());
            jSONObject.put("set_click_type", jSONObject2);
            z uf = uf();
            if (uf != null && !TextUtils.isEmpty(uf.xj())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", uf.xj());
                jSONObject3.put(MediaFormat.KEY_HEIGHT, uf.w());
                jSONObject3.put(MediaFormat.KEY_WIDTH, uf.hf());
                jSONObject.put("icon", jSONObject3);
            }
            Object pn = pn();
            if (pn != null) {
                jSONObject.put("session_params", pn);
            }
            Object m7if = m7if();
            if (m7if != null) {
                jSONObject.put("cache_control", m7if);
            }
            com.bytedance.sdk.openadsdk.zg.w.w.hf gh = gh();
            if (gh != null) {
                jSONObject.put("adslot", com.bytedance.sdk.openadsdk.core.a.ai.xj(gh));
            }
            List<z> lx = lx();
            if (lx != null) {
                JSONArray jSONArray = new JSONArray();
                for (z zVar : lx) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("url", zVar.xj());
                    jSONObject4.put(MediaFormat.KEY_HEIGHT, zVar.w());
                    jSONObject4.put(MediaFormat.KEY_WIDTH, zVar.hf());
                    jSONObject4.put("image_preview", zVar.y());
                    jSONObject4.put("image_key", zVar.c());
                    jSONArray.put(jSONObject4);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> ew = ew();
            if (ew != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = ew.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> qf = qf();
            if (qf != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it2 = qf.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONObject.put("click_url", jSONArray3);
            }
            jSONObject.put("phone_num", ah());
            jSONObject.put("title", kr());
            jSONObject.put("download_num", sv());
            jSONObject.put("description", uj());
            jSONObject.put(com.sigmob.sdk.base.n.m, jf());
            jSONObject.put("req_id", zf());
            jSONObject.put("image_mode", rx());
            jSONObject.put("intercept_flag", op());
            jSONObject.put("web_inspector", gy());
            jSONObject.put("button_text", bh());
            jSONObject.put("ad_logo", lw());
            jSONObject.put("video_adaptation", bl());
            jSONObject.put("feed_video_opentype", dq());
            jSONObject.put("feed_reward_type", qd());
            jSONObject.put("orientation", rs());
            jSONObject.put("aspect_ratio", yq());
            jSONObject.put("aspect_margin", eq());
            jSONObject.put("corner_radius", iy());
            kd vh = vh();
            if (vh != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("app_name", vh.w());
                jSONObject5.put(com.sigmob.sdk.base.n.p, vh.u());
                jSONObject5.put("download_url", vh.hf());
                jSONObject5.put("score", vh.kd());
                jSONObject5.put("comment_num", vh.y());
                jSONObject5.put("quick_app_url", vh.xj());
                jSONObject5.put("app_size", vh.c());
                jSONObject.put(PointCategory.APP, jSONObject5);
            }
            pz wx = wx();
            if (wx != null) {
                jSONObject.put("download_sdk_conf", wx.w());
            }
            if (tj() != null) {
                tj().hf(jSONObject);
            }
            if (ao() != null) {
                ao().xj(jSONObject);
            }
            if (yt() != null) {
                yt().xj(jSONObject);
            }
            if (xl() != null) {
                xl().xj(jSONObject);
            }
            if (dc() != null) {
                dc().xj(jSONObject);
            }
            if (vm() != null) {
                vm().xj(jSONObject);
            }
            if (tu() != null) {
                tu().xj(jSONObject);
            }
            if (dj() != null) {
                dj().xj(jSONObject);
            }
            if (s() != null) {
                s().xj(jSONObject);
            }
            if (ie() != null) {
                ie().xj(jSONObject);
            }
            if (ob() != null) {
                ob().xj(jSONObject);
            }
            if (n() != null) {
                n().hf(jSONObject);
            }
            jSONObject.put("count_down", it());
            jSONObject.put("expiration_time", o());
            jSONObject.put("client_expiration_time", o());
            jSONObject.put("_child_metas", mi());
            jSONObject.put("_meta_life_record", rz().xj());
            jSONObject.put("src_req_id", az());
            jSONObject.put("player_type", ul());
            jSONObject.put("video_encode_type", ic());
            jSONObject.put("feed_video_finish_type", ws());
            if (nt() != null) {
                nt().xj(jSONObject);
            }
            if (kc() != null) {
                kc().xj(jSONObject);
            }
            jSONObject.put("if_both_open", su());
            jSONObject.put("if_double_deeplink", eb());
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("splash_clickarea", xv());
            jSONObject6.put("splash_clicktext", vl());
            jSONObject6.put("area_height", ne());
            jSONObject6.put("area_width", se());
            jSONObject6.put("area_blank_height", ft());
            jSONObject6.put("half_blank_height", rg());
            jSONObject6.put("splash_style_id", t());
            jSONObject6.put("btn_background_dest_color", k());
            jSONObject6.put("top_splash_clicktext", da());
            jSONObject6.put("splash_load_time_optimization", zb());
            jSONObject6.put("text_config", i() != null ? i().xj() : null);
            jSONObject6.put("top_text_config", ua() != null ? ua().xj() : null);
            jSONObject6.put("sliding_distance", hm());
            jSONObject6.put("slide_area", si() != null ? si().kd() : null);
            jSONObject.put("splash_control", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("position", my());
            jSONObject7.put("left_or_right_margin", lm());
            jSONObject7.put("top_or_bottom_margin", vi());
            op opVar = this.uf;
            jSONObject7.put("skip_style", opVar == null ? 1 : opVar.u());
            op opVar2 = this.uf;
            jSONObject7.put("hide_native_skip_logo", opVar2 == null ? 0 : opVar2.kd());
            jSONObject.put("skip_control", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("show_type", cu());
            jSONObject8.put("blank", no());
            jSONObject8.put("half_blank", qi());
            jSONObject.put("splash_compliance_bar", jSONObject8);
            if (pu() != null) {
                JSONObject jSONObject9 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = pu().entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        jSONObject9.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject9);
            }
            jSONObject.put("isDirectDownload", qt());
            jSONObject.put("page_render_type", io());
            jSONObject.put("promotion_type", wo());
            jSONObject.put("if_lpua_package", this.og);
            jSONObject.put("click_freq", this.ee);
            com.bytedance.sdk.openadsdk.core.ugeno.y.xj x = x();
            if (x != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, x.xj());
                jSONObject10.put(TKDownloadReason.KSAD_TK_MD5, x.hf());
                jSONObject10.put("url", x.w());
                jSONObject10.put("scene", x.u());
                jSONObject.put("ugeno", jSONObject10);
            }
            com.bytedance.sdk.openadsdk.core.ugeno.d.xj ai = ai();
            if (ai != null) {
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("product_infos", ai.xj());
                jSONObject11.put("coupon", ai.hf());
                jSONObject11.put("render_config", ai.w());
                jSONObject11.put("live_room_data", ai.u());
                jSONObject11.putOpt("ec_mall_conf", ai.kd());
                jSONObject.put("dylite_info", jSONObject11);
            }
            jSONObject.put("native_lp_data", e());
            jSONObject.put("native_lp_tpl_id", yo());
            jSONObject.put("native_lp_ugen_url", v());
            jSONObject.put("native_lp_ugen_md5", jk());
            jSONObject.put("download_url", zg());
            jSONObject.put("native_lp_is_preload", pz());
            if (pz()) {
                jSONObject.put("native_lp_content", ht());
            }
            jSONObject.put("market_url", lp());
            jSONObject.put("close_on_dislike", iz());
            y ut = ut();
            if (ut != null) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("developer_name", ut.c());
                jSONObject12.put(com.sigmob.sdk.base.n.r, ut.kd());
                jSONObject12.put("permissions", ut.pl());
                jSONObject12.put("privacy_policy_url", ut.f());
                jSONObject12.put(com.sigmob.sdk.base.n.p, ut.g());
                jSONObject12.put("app_name", ut.am());
                jSONObject12.put("score", ut.w());
                jSONObject12.put("creative_tags", ut.u());
                jSONObject12.put("permissions_url", ut.hf());
                jSONObject12.put("desc_url", ut.d());
                jSONObject12.put("reg_number", ut.tf());
                jSONObject12.put("reg_url", ut.p());
                jSONObject.put("app_manage", jSONObject12);
            }
            dk wf = wf();
            if (wf != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("ugen_dialog_url", wf.hf());
                jSONObject13.put("ugen_dialog_md5", wf.w());
                jSONObject13.put("dialog_style", wf.xj());
                jSONObject.put("easy_dl_dialog", jSONObject13);
            }
            if (fs() != null) {
                jSONObject.put("easy_pl_material", fs());
            }
            jSONObject.put("app_manage_type", zm());
            jSONObject.put("lp_down_rule", ey() == 1 ? 1 : 0);
            jSONObject.put("auction_price", co());
            jSONObject.put("price", ff());
            jSONObject.put("ad_info", og());
            jSONObject.put("adx_name", nn());
            jSONObject.put("no_default_ttdsp_price", xw());
            jSONObject.put("endcard_close_time", uo());
            jSONObject.put("proportion_watching", tq());
            jSONObject.put("video_skip_result", rh());
            jSONObject.put("shake_value", ee());
            jSONObject.put("deep_shake_value", pw());
            jSONObject.put("rotation_angle", ky());
            jSONObject.put("calculation_method", le());
            jSONObject.put("calculation_method_twist", oa());
            jSONObject.put("show_poll_time", cm());
            jSONObject.put("dynamic_join_type", uh());
            jSONObject.put("dynamic_join_duration", mq());
            jSONObject.put("cache_ext", dk());
            jSONObject.put("cache_time", ra());
            jSONObject.put("req_id", q());
            jSONObject.put(PointParamKey.IS_CACHE, z());
            jSONObject.put("log_ext", j());
            jSONObject.put("material_key", en());
            jSONObject.put("need_get_materials", l());
            jSONObject.put("s_send_ts", a());
            jSONObject.put("parse_material_ts", et());
            ne neVar = this.xj;
            if (neVar != null) {
                jSONObject.put("wc_miniapp_info", neVar.d());
            }
            p mj = mj();
            if (mj != null) {
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("click_trigger_type", mj.xj());
                jSONObject14.put("shake_start_time", mj.hf());
                jSONObject14.put("shake_end_time", mj.w());
                jSONObject.put("click_trigger_config", jSONObject14);
            }
            jSONObject.put("web_monitor_rate", hf());
        } catch (Exception unused) {
        }
        if (cp() != null) {
            cp().xj(jSONObject);
        }
        try {
            jSONObject.put("live_room_id", wr());
            jSONObject.put("ad_type", kn());
            jSONObject.put("live_interaction_type", vu());
            jSONObject.put("ec_schema", wn());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        try {
            jSONObject.put("ecom_live_params", vo());
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
        }
        en xx = xx();
        if (xx != null) {
            xx.xj(jSONObject);
        }
        ht aa = aa();
        if (aa != null) {
            aa.xj(jSONObject);
        }
        a lv = lv();
        if (lv != null) {
            try {
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("reward_live_deep_link_user_id", lv.xj());
                jSONObject15.put("reward_live_deep_link_request_id", lv.y());
                jSONObject15.put("reward_live_deep_link_room_id", lv.hf());
                jSONObject15.put("reward_live_last_time", lv.kd());
                jSONObject15.put("reawrd_live_short_touch_params", lv.w());
                jSONObject15.put("reawrd_live_extra_pangle_scheme_params", lv.u());
                jSONObject.put("reward_live_deep_link_params", jSONObject15);
            } catch (Exception unused2) {
            }
        }
        am fj = fj();
        if (fj != null) {
            try {
                JSONObject jSONObject16 = new JSONObject();
                jSONObject16.put("style_type", fj.xj());
                jSONObject16.put("image_url", fj.hf());
                jSONObject16.put("position", fj.w());
                jSONObject16.put("image_height", fj.u());
                jSONObject16.put("image_scale_rate", fj.y());
                jSONObject16.put("image_gif_url", fj.kd());
                jSONObject16.put("image_gif_aspect_ratio", fj.c());
                jSONObject.put("dynamic_join_coupon_style", jSONObject16);
            } catch (Exception unused3) {
            }
        }
        g yl = yl();
        if (yl != null) {
            try {
                jSONObject.put("coupon", yl.xj());
            } catch (JSONException e3) {
                com.bytedance.sdk.component.utils.pl.xj(e3);
            }
        }
        r bi = bi();
        if (bi != null) {
            try {
                jSONObject.put("live_info", bi.xj());
            } catch (JSONException unused4) {
            }
        }
        s cc = cc();
        if (cc != null) {
            try {
                jSONObject.put("saas_info", cc.xj());
            } catch (JSONException unused5) {
            }
        }
        Object zd = zd();
        if (zd != null) {
            try {
                jSONObject.put("group_info", zd);
            } catch (Exception unused6) {
            }
        }
        gy xf = xf();
        if (xf != null) {
            try {
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put("video_adapter_type", xf.xj());
                jSONObject17.put("video_mute_type", xf.hf());
                jSONObject.put("video_config", jSONObject17);
            } catch (Exception unused7) {
            }
        }
        try {
            jSONObject.put("not_valid_download_url", dz());
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.pl.xj(e4);
        }
        try {
            jSONObject.put("dynamic_configs", jv());
            String an = an();
            if (!TextUtils.isEmpty(an)) {
                jSONObject.put("gnd_prefetch_cache_key", an);
                jSONObject.put("gnd_prefetch_timing", vr());
            }
        } catch (JSONException e5) {
            com.bytedance.sdk.component.utils.pl.xj(e5);
        }
        try {
            jSONObject.put("twist_config", ki());
            jSONObject.put("shake_interact_conf", ya());
            jSONObject.put("twist_interact_conf", eg());
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.pl.xj(e6);
        }
        try {
            x xVar = this.fa;
            if (xVar != null) {
                xVar.hf(jSONObject);
            }
        } catch (Throwable unused8) {
        }
        try {
            j jVar = this.ap;
            if (jVar != null) {
                jVar.hf(jSONObject);
            }
        } catch (Throwable unused9) {
        }
        e am = am();
        if (am != null) {
            try {
                JSONObject jSONObject18 = new JSONObject();
                jSONObject18.put("lottie_tmp_url", am.w());
                JSONArray jSONArray4 = new JSONArray();
                List<z> xj = am.xj();
                if (xj != null) {
                    for (z zVar2 : xj) {
                        if (zVar2 != null) {
                            JSONObject jSONObject19 = new JSONObject();
                            jSONObject19.put(MediaFormat.KEY_WIDTH, zVar2.hf());
                            jSONObject19.put(MediaFormat.KEY_HEIGHT, zVar2.w());
                            jSONObject19.put("url", zVar2.xj());
                            jSONArray4.put(jSONObject19);
                        }
                    }
                }
                JSONArray jSONArray5 = new JSONArray();
                List<com.bykv.vk.openvk.component.video.api.w.w> hf = am.hf();
                if (hf != null) {
                    for (com.bykv.vk.openvk.component.video.api.w.w wVar : hf) {
                        if (wVar != null) {
                            JSONObject jSONObject20 = new JSONObject();
                            jSONObject20.put("file_hash", wVar.qt());
                            jSONObject20.put("resolution", wVar.d());
                            jSONObject20.put("video_duration", wVar.y());
                            jSONObject20.put("video_url", wVar.pl());
                            jSONArray5.put(jSONObject20);
                        }
                    }
                }
                JSONObject jSONObject21 = new JSONObject();
                jSONObject21.put("bg_anim_img_android", jSONArray4);
                jSONObject21.put("bg_videos", jSONArray5);
                JSONObject jSONObject22 = new JSONObject();
                jSONObject22.put("sdk_template_info", jSONObject18);
                jSONObject22.put("aigc", jSONObject21);
                jSONObject.put("sdk_derive_info", jSONObject22);
            } catch (JSONException unused10) {
            }
        }
        try {
            jSONObject.put("disable_video_join", y());
            jSONObject.put("disable_top_bar", tf());
            jSONObject.put("disable_rtn_button", pl());
            jSONObject.put("disable_safe_area", u());
            jSONObject.put("disable_slide_return", f());
        } catch (Throwable unused11) {
        }
        return jSONObject;
    }

    public String ah() {
        return this.f10424pl;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.d.xj ai() {
        return this.ul;
    }

    public e am() {
        return this.tq;
    }

    public String an() {
        return this.co;
    }

    public vm ao() {
        return this.wn;
    }

    public boolean ap() {
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this)) {
            return true;
        }
        if (this.p.isEmpty()) {
            return false;
        }
        if (this.dk == 4 && this.p.size() < 3) {
            return false;
        }
        Iterator<z> it = this.p.iterator();
        while (it.hasNext()) {
            if (!it.next().kd()) {
                return false;
            }
        }
        return true;
    }

    public int aq() {
        return this.xw;
    }

    public String az() {
        return this.n;
    }

    public int b() {
        return this.ci;
    }

    public String bh() {
        return this.yo;
    }

    public r bi() {
        return this.wx;
    }

    public int bl() {
        return this.op;
    }

    public s cc() {
        return this.yt;
    }

    public String ci() {
        return this.et;
    }

    public int cm() {
        return this.qf;
    }

    public String co() {
        return this.cu;
    }

    public wo cp() {
        return this.aq;
    }

    public boolean ct() {
        return this.f10422a;
    }

    public int cu() {
        lw lwVar = this.ew;
        if (lwVar == null) {
            return 0;
        }
        return lwVar.xj();
    }

    public int cy() {
        return this.rg;
    }

    public boolean d() {
        return this.wf == 1;
    }

    public String da() {
        wa waVar = this.ft;
        return waVar == null ? "点击查看" : waVar.p();
    }

    public String db() {
        return this.f;
    }

    public hl dc() {
        return this.mq;
    }

    public n dj() {
        return this.ey;
    }

    public String dk() {
        return this.da;
    }

    public int dq() {
        return this.gy;
    }

    public op dx() {
        return this.uf;
    }

    public boolean dz() {
        return this.js;
    }

    public String e() {
        return this.pn;
    }

    public int eb() {
        return this.vl;
    }

    public int ee() {
        return this.ol;
    }

    public JSONObject eg() {
        return this.lt;
    }

    public String en() {
        return this.my;
    }

    public float eq() {
        float f = this.lx;
        if (f < 0.07f || f > 0.175f) {
            this.lx = 0.07f;
        }
        return this.lx;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ws wsVar = (ws) obj;
            if (this.v.equals(wsVar.v) && this.f10423io.equals(wsVar.f10423io)) {
                return true;
            }
        }
        return false;
    }

    public long et() {
        return this.uh;
    }

    public int eu() {
        return this.h;
    }

    public List<String> ew() {
        return this.g;
    }

    public int ey() {
        return this.ha;
    }

    public lw ez() {
        return this.ew;
    }

    public long fa() {
        return this.qa;
    }

    public boolean fc() {
        return (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.a.wo.tf(this)) || TextUtils.isEmpty(this.n) || com.bytedance.sdk.openadsdk.core.a.wo.tf(this).contains(this.n)) ? false : true;
    }

    public String ff() {
        return this.ua;
    }

    public String fh() {
        return this.hf;
    }

    public am fj() {
        return this.bh;
    }

    public JSONObject fs() {
        return this.dj;
    }

    public int ft() {
        wa waVar = this.ft;
        if (waVar == null) {
            return 82;
        }
        return waVar.y();
    }

    public boolean g() {
        return pl() == 1;
    }

    public com.bytedance.sdk.openadsdk.zg.w.w.hf gh() {
        return this.dq;
    }

    public int gj() {
        return this.cy;
    }

    public int gy() {
        return this.bl;
    }

    public boolean h() {
        wa waVar = this.ft;
        return waVar == null || waVar.w();
    }

    public boolean ha() {
        return this.wo;
    }

    public int hashCode() {
        return this.f10423io.hashCode() + (this.v.hashCode() * 31);
    }

    public String he() {
        return this.it;
    }

    public int hf() {
        return this.kf;
    }

    public boolean hl() {
        return this.gh == 1;
    }

    public String ho() {
        return this.v;
    }

    public et hq() {
        return this.xl;
    }

    public JSONObject ht() {
        return this.xe;
    }

    public long hx() {
        return this.z;
    }

    public wa.hf i() {
        wa waVar = this.ft;
        if (waVar != null) {
            return waVar.pl();
        }
        return null;
    }

    public int ic() {
        return this.ff;
    }

    public l ie() {
        return this.ka;
    }

    /* renamed from: if, reason: not valid java name */
    public JSONObject m7if() {
        return this.gj;
    }

    public int io() {
        if (v.u(this)) {
            return 0;
        }
        return this.jv;
    }

    public JSONObject ir() {
        return this.tf;
    }

    public int it() {
        return this.j;
    }

    public float iy() {
        float f = this.ah;
        if (f < 0.0f || f > 50.0f) {
            this.ah = 0.0f;
        }
        return this.ah;
    }

    public boolean iz() {
        return this.t;
    }

    public String j() {
        return this.oa;
    }

    public JSONObject jb() {
        if (this.x == null) {
            try {
                if (!TextUtils.isEmpty(this.f10423io)) {
                    this.x = new JSONObject(this.f10423io);
                }
            } catch (JSONException unused) {
            }
        }
        return this.x;
    }

    public String jf() {
        return this.f10423io;
    }

    public String jk() {
        return this.su;
    }

    public String jq() {
        return this.jk;
    }

    public long js() {
        return this.ws;
    }

    public String jv() {
        return this.pu;
    }

    public int jw() {
        return this.c;
    }

    public String k() {
        wa waVar = this.ft;
        return waVar == null ? "#008DEA" : waVar.tf();
    }

    public String ka() {
        try {
            return jb().optString("convert_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public jk kc() {
        return this.hl;
    }

    public int kd() {
        return this.kt;
    }

    public String ke() {
        JSONObject jSONObject = this.nb;
        String optString = jSONObject != null ? jSONObject.optString("session_id") : "";
        return TextUtils.isEmpty(optString) ? ko() : optString;
    }

    public int kf() {
        JSONObject jSONObject = this.d;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    public JSONObject ki() {
        return this.rs;
    }

    public int kn() {
        return this.sv;
    }

    public String ko() {
        return hashCode() + zf() + et();
    }

    public String kr() {
        return this.qt;
    }

    public ne kt() {
        return this.xj;
    }

    public int ky() {
        return this.jw;
    }

    public boolean l() {
        return this.lm;
    }

    public int le() {
        return this.m;
    }

    public int lm() {
        op opVar = this.uf;
        if (opVar == null) {
            return 16;
        }
        return opVar.hf();
    }

    public String lp() {
        return this.wa;
    }

    public x lq() {
        return this.fa;
    }

    public String lt() {
        return this.nu;
    }

    public a lv() {
        return this.ic;
    }

    public int lw() {
        return this.lw;
    }

    public List<z> lx() {
        return this.p;
    }

    public JSONObject m() {
        return this.d;
    }

    public wa mg() {
        return this.ft;
    }

    public String mi() {
        return this.ac;
    }

    public p mj() {
        return this.fc;
    }

    public int mq() {
        return this.se;
    }

    public int my() {
        op opVar = this.uf;
        if (opVar == null) {
            return 2;
        }
        return opVar.xj();
    }

    public j n() {
        return this.ap;
    }

    public int nb() {
        return this.tu;
    }

    public int ne() {
        wa waVar = this.ft;
        if (waVar == null) {
            return 50;
        }
        return waVar.u();
    }

    public String nn() {
        if (!TextUtils.isEmpty(this.zd)) {
            this.zd = this.zd.trim();
        }
        return this.zd;
    }

    public int no() {
        lw lwVar = this.ew;
        if (lwVar == null) {
            return 90;
        }
        return lwVar.hf();
    }

    public io nq() {
        return this.uo;
    }

    public h nt() {
        return this.l;
    }

    public long nu() {
        return this.eu;
    }

    public long o() {
        return this.q;
    }

    public int oa() {
        return this.ir;
    }

    public dc ob() {
        return this.nt;
    }

    public int oe() {
        return this.r;
    }

    public String og() {
        return this.vi;
    }

    public String ol() {
        return this.y;
    }

    public int op() {
        return this.qd;
    }

    public boolean oz() {
        if (xl() != null) {
            return xl().kd();
        }
        return false;
    }

    public boolean p() {
        return tf() == 1;
    }

    public int pl() {
        return this.py;
    }

    public JSONObject pn() {
        return this.nb;
    }

    public boolean pq() {
        return this.oe;
    }

    public long ps() {
        return this.b;
    }

    public Map<String, Object> pu() {
        return this.vm;
    }

    public int pw() {
        if (this.u == 4 && TextUtils.isEmpty(this.wa)) {
            return this.db;
        }
        return 0;
    }

    public int py() {
        return v.f(this);
    }

    public boolean pz() {
        return this.ta;
    }

    public String q() {
        return this.zb;
    }

    public String qa() {
        return this.tj;
    }

    public int qd() {
        return this.rq;
    }

    public boolean qe() {
        int am = com.bytedance.sdk.openadsdk.core.a.wo.am(this);
        return am == 3 || am == 6;
    }

    public List<String> qf() {
        return this.am;
    }

    public int qi() {
        lw lwVar = this.ew;
        if (lwVar == null) {
            return 90;
        }
        return lwVar.w();
    }

    public boolean qt() {
        return this.ky;
    }

    public int r() {
        return this.vw;
    }

    public long ra() {
        return this.k;
    }

    public int rg() {
        wa waVar = this.ft;
        if (waVar == null) {
            return 56;
        }
        return waVar.c();
    }

    public int rh() {
        return this.ut;
    }

    public boolean rq() {
        return this.yy;
    }

    public int rs() {
        if (this.qi != 2) {
            this.qi = 1;
        }
        return this.qi;
    }

    public int rx() {
        return this.dk;
    }

    public eu rz() {
        if (this.oz == null) {
            this.oz = new eu(this);
        }
        return this.oz;
    }

    public bl s() {
        return this.jb;
    }

    public int se() {
        wa waVar = this.ft;
        if (waVar == null) {
            return 236;
        }
        return waVar.kd();
    }

    public wa.xj si() {
        wa waVar = this.ft;
        if (waVar != null) {
            return waVar.am();
        }
        return null;
    }

    public int ss() {
        return this.ss;
    }

    public int su() {
        return this.xv;
    }

    public long sv() {
        return this.zg;
    }

    public int t() {
        wa waVar = this.ft;
        if (waVar == null) {
            return 0;
        }
        return waVar.d();
    }

    public boolean ta() {
        return su() == 1;
    }

    public int tf() {
        return this.hq;
    }

    public aq tj() {
        return this.dc;
    }

    public int tq() {
        return this.zm;
    }

    public v tu() {
        return this.jq;
    }

    public boolean u() {
        return this.eq && p();
    }

    public wa.hf ua() {
        wa waVar = this.ft;
        if (waVar != null) {
            return waVar.g();
        }
        return null;
    }

    public z uf() {
        return this.kd;
    }

    public int uh() {
        return this.ne;
    }

    public String uj() {
        return this.e;
    }

    public int ul() {
        return this.he;
    }

    public int uo() {
        return this.mg;
    }

    public y ut() {
        return this.hx;
    }

    public String v() {
        return this.lp;
    }

    public kd vh() {
        return this.pz;
    }

    public int vi() {
        op opVar = this.uf;
        if (opVar == null) {
            return 30;
        }
        return opVar.w();
    }

    public String vl() {
        wa waVar = this.ft;
        return waVar == null ? "" : waVar.hf();
    }

    public yy vm() {
        return this.zf;
    }

    public String vo() {
        return this.ho;
    }

    public int vr() {
        return this.ie;
    }

    public int vu() {
        return this.uj;
    }

    public int vw() {
        return this.u;
    }

    public int w() {
        return this.iy;
    }

    public int wa() {
        if (yq() != 100.0f || hl.xj(this) == 2) {
            return 0;
        }
        return this.s;
    }

    public dk wf() {
        return this.fh;
    }

    public String wn() {
        return this.xk;
    }

    public int wo() {
        return this.az;
    }

    public String wr() {
        return this.kr;
    }

    public int ws() {
        return this.en;
    }

    public pz wx() {
        return this.ht;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.y.xj x() {
        return this.dz;
    }

    public boolean xe() {
        return eb() == 1;
    }

    public gy xf() {
        return this.jf;
    }

    public void xj(q qVar) {
        if (qVar == null) {
            return;
        }
        if (this.lv == null) {
            this.lv = new ArrayList();
        }
        this.lv.add(qVar);
    }

    public boolean xk() {
        return xw() != 1;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.w.hf xl() {
        com.bytedance.sdk.openadsdk.core.dislike.hf.xj();
        return this.w;
    }

    public int xv() {
        wa waVar = this.ft;
        if (waVar == null) {
            return 1;
        }
        return waVar.xj();
    }

    public int xw() {
        return this.no;
    }

    public en xx() {
        return this.rx;
    }

    public int y() {
        return this.fs;
    }

    public JSONObject ya() {
        return this.yq;
    }

    public g yl() {
        return this.vh;
    }

    public int yo() {
        return this.f1if;
    }

    public float yq() {
        if (this.kc <= 0.0f) {
            this.kc = 100.0f;
        }
        return (this.kc * 1000.0f) / 1000.0f;
    }

    public zg yt() {
        return this.ra;
    }

    public int yy() {
        return this.gh;
    }

    public boolean z() {
        return this.le;
    }

    public int zb() {
        wa waVar = this.ft;
        if (waVar == null) {
            return 0;
        }
        return waVar.f();
    }

    public JSONObject zd() {
        return this.ps;
    }

    public String zf() {
        return this.ai;
    }

    public String zg() {
        return this.eb;
    }

    public int zm() {
        return this.ct;
    }

    public void a(int i) {
        this.dk = i;
    }

    public void ai(int i) {
        this.ct = i;
    }

    public void am(int i) {
        this.xw = i;
    }

    public void aq(int i) {
        this.sv = i;
    }

    public void b(int i) {
        this.xv = i;
    }

    public void bl(int i) {
        this.ee = i;
    }

    public boolean c() {
        return y() == 1;
    }

    public void d(int i) {
        this.jv = i;
    }

    public void dc(int i) {
        this.he = i;
    }

    public void dk(int i) {
        this.cy = i;
    }

    public void dq(int i) {
        this.db = i;
    }

    public void e(int i) {
        this.op = i;
    }

    public void en(int i) {
        this.c = i;
    }

    public void et(int i) {
        this.rg = i;
    }

    public void eu(int i) {
        this.no = i;
    }

    public int f() {
        return this.wf;
    }

    public void ff(int i) {
        this.se = Math.max(0, i);
    }

    public void g(int i) {
        this.gh = i;
    }

    public void hf(int i) {
        this.iy = i;
    }

    public void hl(int i) {
        this.mg = i;
    }

    public void ht(int i) {
        this.tu = i;
    }

    public void j(int i) {
        this.u = i;
    }

    public void jk(int i) {
        this.qd = i;
    }

    public void kd(int i) {
        this.wf = i;
    }

    public void l(int i) {
        this.ne = i;
    }

    public void lw(int i) {
        this.og = i;
    }

    public void n(int i) {
        if (i < 12) {
            i = 12;
        }
        if (i > 20) {
            i = 20;
        }
        this.ol = i;
    }

    public void p(String str) {
        this.i = str;
    }

    public void pl(int i) {
        this.h = i;
    }

    public void pz(int i) {
        this.bl = i;
    }

    public void q(int i) {
        if (i != 1) {
            i = 0;
        }
        this.ha = i;
    }

    public void qd(int i) {
        this.ie = i;
    }

    public void qt(int i) {
        this.gy = i;
    }

    public void r(int i) {
        this.r = i;
    }

    public void ra(int i) {
        this.ss = i;
    }

    public void s(int i) {
        if (i <= 0 || i > 9) {
            this.ut = 3;
        } else {
            this.ut = i;
        }
    }

    public void tf(String str) {
        this.ua = str;
    }

    public void tj(int i) {
        this.qi = i;
    }

    public void tu(int i) {
        this.uj = i;
    }

    public void u(int i) {
        if (this.kt == 0) {
            this.kt = i;
        }
    }

    public void v(int i) {
        this.s = i;
    }

    public void vm(int i) {
        if (i < 0 || i > 100) {
            return;
        }
        this.zm = i;
    }

    public void w(int i) {
        this.fs = i;
    }

    public void wn(int i) {
        int i2 = 500;
        if (i == Integer.MIN_VALUE) {
            i = com.bytedance.sdk.openadsdk.core.a.wo.f(this) == 3 ? 500 : 1000;
        }
        if (i >= 500) {
            i2 = 3000;
            if (i <= 3000) {
                i2 = i;
            }
        }
        this.qf = i2;
    }

    public void wo(int i) {
        this.j = i;
    }

    public void ws(int i) {
        this.vl = i;
    }

    public void x(int i) {
        this.ir = i;
    }

    public void y(int i) {
        this.hq = i;
    }

    public void yo(int i) {
        this.lw = i;
    }

    public void yy(int i) {
        if (i < 0 || i > 180) {
            this.jw = 50;
        } else {
            this.jw = i;
        }
    }

    public void z(int i) {
        this.ff = i;
    }

    public void zg(int i) {
        this.rq = i;
    }

    public void a(String str) {
        this.ho = str;
    }

    public void ai(String str) {
        this.hf = str;
    }

    public void am(String str) {
        this.et = str;
    }

    public void c(int i) {
        this.py = i;
    }

    public void d(String str) {
        this.my = str;
    }

    public void dk(String str) {
        this.jk = str;
    }

    public void e(String str) {
        this.f10424pl = str;
    }

    public void en(String str) {
        this.zd = str;
    }

    public void et(String str) {
        this.tj = str;
    }

    public void f(int i) {
        this.f1if = i;
    }

    public void ff(String str) {
        this.kr = str;
    }

    public void g(String str) {
        this.it = str;
    }

    public void hf(boolean z) {
        this.eq = z;
    }

    public void ht(String str) {
        this.f10423io = str;
    }

    public void io(int i) {
        this.m = i;
    }

    public void j(String str) {
        this.nu = str;
    }

    public void jk(String str) {
        this.yo = str;
    }

    public void kd(String str) {
        this.su = str;
    }

    public void l(String str) {
        this.pu = str;
    }

    public void p(int i) {
        this.en = i;
    }

    public void pl(String str) {
        this.xk = str;
    }

    public void pz(String str) {
        this.v = str;
    }

    public void q(String str) {
        this.cu = str;
    }

    public void qt(String str) {
        this.y = str;
    }

    public void r(String str) {
        this.co = str;
    }

    public void ra(String str) {
        this.ai = str;
    }

    public void tf(int i) {
        this.az = i;
    }

    public void v(String str) {
        this.e = str;
    }

    public void w(boolean z) {
        this.ky = z;
    }

    public void wo(String str) {
        this.ac = str;
    }

    public void x(String str) {
        this.wa = str;
    }

    public void y(String str) {
        this.da = str;
    }

    public void yo(String str) {
        this.qt = str;
    }

    public void z(String str) {
        this.vi = str;
    }

    public void zg(String str) {
        this.f = str;
    }

    public void c(String str) {
        this.zb = str;
    }

    public void d(long j) {
        this.ws = j;
    }

    public void f(String str) {
        this.oa = str;
    }

    public void hf(String str) {
        this.eb = str;
    }

    public void io(String str) {
        this.n = str;
    }

    public void kd(boolean z) {
        this.le = z;
    }

    public void p(boolean z) {
        this.t = z;
    }

    public void pl(boolean z) {
        this.oe = z;
    }

    public void tf(long j) {
        if (j != 0) {
            this.qa = j;
        } else {
            this.qa = System.currentTimeMillis() / 1000;
        }
    }

    public void u(String str) {
        this.lp = str;
    }

    public void w(String str) {
        this.pn = str;
    }

    public q xj(String str) {
        List<q> list = this.lv;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.lv.size(); i++) {
                q qVar = this.lv.get(i);
                if (qVar != null) {
                    String xj = qVar.xj();
                    if (!TextUtils.isEmpty(xj) && xj.equals(str)) {
                        return qVar;
                    }
                }
            }
        }
        return null;
    }

    public void y(boolean z) {
        this.lm = z;
    }

    public static boolean w(ws wsVar) {
        try {
            if (wsVar.pn() != null) {
                if (wsVar.pn().optInt("parent_type") == 1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void c(boolean z) {
        this.f10422a = z;
    }

    public void d(boolean z) {
        this.yy = z;
    }

    public void f(boolean z) {
        this.wo = z;
    }

    public void hf(JSONObject jSONObject) {
        this.xe = jSONObject;
    }

    public void kd(JSONObject jSONObject) {
        this.tf = jSONObject;
    }

    public void p(JSONObject jSONObject) {
        this.lt = jSONObject;
    }

    public void pl(JSONObject jSONObject) {
        this.oz = new eu(this, jSONObject);
    }

    public void u(boolean z) {
        this.ta = z;
    }

    public void y(long j) {
        this.z = j;
    }

    public static boolean hf(ws wsVar) {
        if (wsVar == null) {
            return false;
        }
        return wsVar.rx() == 5 || wsVar.rx() == 15 || wsVar.rx() == 166;
    }

    public void c(long j) {
        this.eu = j;
    }

    public void d(JSONObject jSONObject) {
        this.rs = jSONObject;
    }

    public void f(long j) {
        this.b = j;
    }

    public void kd(long j) {
        this.q = j;
    }

    public void tf(boolean z) {
        this.js = z;
    }

    public void u(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public void w(long j) {
        this.si = j;
    }

    public void y(JSONObject jSONObject) {
        this.nb = jSONObject;
    }

    public static boolean kd(ws wsVar) {
        if (wsVar == null || wsVar.qe <= 0 || wsVar.ee <= 0) {
            return false;
        }
        boolean z = System.currentTimeMillis() - wsVar.qe < ((long) wsVar.ee);
        if (z) {
            wsVar.nn++;
            com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ra.ws.1
                @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("count", ws.this.nn);
                    jSONObject.put("click_freq", ws.this.ee);
                    return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("click_intercept").f(ws.this.jf()).hf(jSONObject.toString());
                }
            }, "click_intercept");
        }
        return z;
    }

    public static void y(ws wsVar) {
        if (wsVar == null) {
            return;
        }
        wsVar.qe = System.currentTimeMillis();
    }

    public void c(JSONObject jSONObject) {
        this.gj = jSONObject;
    }

    public void f(JSONObject jSONObject) {
        this.dj = jSONObject;
    }

    public void tf(JSONObject jSONObject) {
        this.yq = jSONObject;
    }

    public void u(long j) {
        this.zg = j;
    }

    public void w(JSONObject jSONObject) {
        this.ps = jSONObject;
    }

    public static boolean u(ws wsVar) {
        return wsVar != null && wsVar.og == 1;
    }

    public void w(float f) {
        this.ah = f;
    }

    public void hf(long j) {
        this.uh = j;
    }

    public boolean xj() {
        return this.ob;
    }

    public void hf(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.ci = 2;
        } else {
            this.ci = (int) d;
        }
    }

    public void xj(boolean z) {
        this.ob = z;
    }

    public void xj(int i) {
        this.kf = i;
    }

    public void hf(z zVar) {
        this.p.add(zVar);
    }

    public void xj(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.tq = new e();
            JSONObject optJSONObject = jSONObject.optJSONObject("sdk_template_info");
            if (optJSONObject != null) {
                this.tq.xj(optJSONObject.optString("lottie_tmp_url"));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("aigc");
            if (optJSONObject2 != null) {
                JSONArray optJSONArray = optJSONObject2.optJSONArray("bg_anim_img_android");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    this.tq.xj(arrayList);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                        if (optJSONObject3 != null) {
                            z zVar = new z();
                            zVar.xj(optJSONObject3.optInt(MediaFormat.KEY_WIDTH));
                            zVar.hf(optJSONObject3.optInt(MediaFormat.KEY_HEIGHT));
                            zVar.xj(optJSONObject3.optString("url"));
                            arrayList.add(zVar);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("bg_videos");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    this.tq.hf(arrayList2);
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject4 != null) {
                            com.bykv.vk.openvk.component.video.api.w.w wVar = new com.bykv.vk.openvk.component.video.api.w.w();
                            wVar.kd(optJSONObject4.optString("file_hash"));
                            wVar.xj(optJSONObject4.optString("resolution"));
                            wVar.xj(optJSONObject4.optDouble("video_duration"));
                            wVar.w(optJSONObject4.optString("video_url"));
                            arrayList2.add(wVar);
                        }
                    }
                }
            }
        }
    }

    public void hf(float f) {
        this.lx = f;
    }

    public static boolean xj(ws wsVar) {
        return wsVar != null && wsVar.eu() == 1;
    }

    public void xj(long j) {
        this.k = j;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.y.xj xjVar) {
        this.dz = xjVar;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.d.xj xjVar) {
        this.ul = xjVar;
    }

    public void xj(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.vw = 2;
        } else {
            this.vw = (int) d;
        }
    }

    public void xj(aq aqVar) {
        this.dc = aqVar;
    }

    public void xj(j jVar) {
        this.ap = jVar;
    }

    public void xj(yy yyVar) {
        this.zf = yyVar;
    }

    public void xj(hl hlVar) {
        this.mq = hlVar;
    }

    public void xj(v vVar) {
        this.jq = vVar;
    }

    public void xj(bl blVar) {
        this.jb = blVar;
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (hfVar == null) {
            com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar2 = this.dq;
            if (hfVar2 != null) {
                this.dq = new w(hfVar2);
                return;
            }
            return;
        }
        this.dq = hfVar;
    }

    public void xj(jk jkVar) {
        this.hl = jkVar;
    }

    public void xj(wa waVar) {
        this.ft = waVar;
    }

    public void xj(y yVar) {
        this.hx = yVar;
    }

    public void xj(h hVar) {
        this.l = hVar;
    }

    public void xj(z zVar) {
        this.kd = zVar;
    }

    public void xj(kd kdVar) {
        this.pz = kdVar;
    }

    public void xj(pz pzVar) {
        this.ht = pzVar;
    }

    public void xj(zg zgVar) {
        this.ra = zgVar;
    }

    public void xj(Map<String, Object> map) {
        this.vm = map;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar) {
        this.w = hfVar;
    }

    public void xj(n nVar) {
        this.ey = nVar;
    }

    public void xj(l lVar) {
        this.ka = lVar;
    }

    public void xj(float f) {
        this.kc = f;
    }

    public void xj(dk dkVar) {
        this.fh = dkVar;
        if (dkVar != null) {
            String hf = dkVar.hf();
            String w = this.fh.w();
            if (TextUtils.isEmpty(hf)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(hf, w, (com.bytedance.sdk.openadsdk.core.ugeno.w) null);
        }
    }

    public void xj(et etVar) {
        this.xl = etVar;
    }

    public void xj(dc dcVar) {
        this.nt = dcVar;
    }

    public void xj(a aVar) {
        this.ic = aVar;
    }

    public void xj(ne neVar) {
        this.xj = neVar;
    }

    public void xj(op opVar) {
        this.uf = opVar;
    }

    public void xj(lw lwVar) {
        this.ew = lwVar;
    }

    public void xj(vm vmVar) {
        this.wn = vmVar;
    }

    public void xj(g gVar) {
        this.vh = gVar;
    }

    public void xj(r rVar) {
        this.wx = rVar;
    }

    public void xj(s sVar) {
        this.yt = sVar;
    }

    public void xj(am amVar) {
        this.bh = amVar;
    }

    public void xj(gy gyVar) {
        this.jf = gyVar;
    }

    public void xj(p pVar) {
        this.fc = pVar;
    }

    public void xj(wo woVar) {
        this.aq = woVar;
    }

    public void xj(com.bykv.vk.openvk.component.video.api.w.w wVar) {
        if (this.l == null) {
            this.l = new h();
        }
        this.l.xj(wVar);
    }

    public void xj(en enVar) {
        this.rx = enVar;
    }

    public void xj(ht htVar) {
        this.o = htVar;
    }

    public void xj(x xVar) {
        this.fa = xVar;
    }

    public void xj(io ioVar) {
        this.uo = ioVar;
    }
}
