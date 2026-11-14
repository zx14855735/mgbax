package com.bytedance.sdk.openadsdk.core.j;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.web.MultiWebview;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.a.dk;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.a.io;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.a.x;
import com.bytedance.sdk.openadsdk.core.nativeexpress.v;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ai;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.b;
import com.bytedance.sdk.openadsdk.core.ra.cy;
import com.bytedance.sdk.openadsdk.core.ra.ff;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.yo;
import com.bytedance.sdk.openadsdk.core.w.kd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf implements kd {
    private static final String uj = null;
    private boolean ac;
    private JSONObject ah;
    private boolean ap;
    private y az;
    private long b;
    private int bh;
    private int bi;
    private int ci;
    private volatile boolean cm;
    private JSONObject co;
    private JSONObject ct;
    private float cu;
    private int da;
    private float db;
    private volatile int dj;
    private boolean dx;
    private boolean dz;
    private int eb;
    private boolean ee;
    private String eq;
    private JSONObject ew;
    private int ey;
    private int ez;
    private int fc;
    private String ff;
    private int fh;
    private int fs;
    private int ft;
    private int ha;
    private String he;
    private com.bytedance.sdk.openadsdk.core.e.xj.xj hl;
    private int ho;
    private boolean hq;
    private boolean hx;
    private int i;
    private int ic;
    private volatile SharedPreferences ie;

    /* renamed from: if, reason: not valid java name */
    private int f0if;
    private int ir;
    private hf it;
    private Boolean iy;
    private int jb;
    private JSONObject jf;
    private int jq;
    private String js;
    private boolean jv;
    private SharedPreferences jw;
    private int k;
    private String ka;
    private String kc;
    public int kd;
    private boolean kf;
    private volatile int kn;
    private int kr;
    private Boolean kt;
    private c ky;
    private String l;
    private String le;
    private float lm;
    private long lp;
    private boolean lt;
    private Map<String, Object> lv;
    private int lx;
    private JSONObject m;
    private boolean mg;
    private int mq;
    private float my;
    private String n;
    private boolean nn;
    private float no;
    private int nt;
    private String nu;
    private boolean o;
    private int oa;
    private int ob;
    private int oe;
    private JSONObject og;
    private volatile com.bytedance.sdk.component.u.hf.w ol;
    private List<Integer> oz;
    private long pn;
    private String ps;
    private int pu;
    private boolean py;
    private int qa;
    private boolean qe;
    private boolean qf;
    private boolean qi;
    private JSONObject r;
    private final String rg;
    private String rq;
    private boolean rs;
    private int rx;
    private final int se;
    private int si;
    private int su;
    private String sv;
    private b t;
    private int ta;
    private String tq;
    public volatile com.bytedance.sdk.component.u.hf.w u;
    private int ua;
    private float uf;
    private JSONObject uh;
    private boolean ul;
    private int uo;
    private String ut;
    private int vh;
    private boolean vi;
    private int vo;
    private boolean vu;
    private volatile boolean vw;
    public volatile com.bytedance.sdk.component.u.hf.w w;
    private v wf;
    private volatile int wr;
    private String ws;
    private JSONObject wx;
    private int xe;
    private volatile SharedPreferences xk;
    private int xl;
    private Object xw;
    private int yl;
    private boolean yq;
    private JSONObject yt;
    private ff yy;
    private String zb;
    private String zd;
    private String zf;
    private String zm;
    private static final int[] fa = {1, 3, 5};
    private static volatile boolean cc = false;
    private static volatile boolean iz = true;
    private int y = Integer.MAX_VALUE;
    private Set<String> c = Collections.synchronizedSet(new HashSet());
    private int f = Integer.MAX_VALUE;
    private int d = Integer.MAX_VALUE;
    private int tf = Integer.MAX_VALUE;
    private int p = Integer.MAX_VALUE;

    /* renamed from: pl, reason: collision with root package name */
    private String f10365pl = null;
    private int g = Integer.MAX_VALUE;
    private int am = Integer.MAX_VALUE;
    private int qt = Integer.MAX_VALUE;
    private int zg = Integer.MIN_VALUE;
    private int e = Integer.MIN_VALUE;
    private int yo = Integer.MIN_VALUE;
    private int v = Integer.MAX_VALUE;
    private int jk = Integer.MAX_VALUE;
    private int pz = -1;
    private int ht = Integer.MIN_VALUE;
    private String ra = null;
    public int xj = 0;
    private int dk = Integer.MIN_VALUE;
    private int et = Integer.MAX_VALUE;
    public int hf = 10;

    /* renamed from: io, reason: collision with root package name */
    private int f10364io = Integer.MAX_VALUE;
    private com.bytedance.sdk.openadsdk.core.c.hf x = null;
    private com.bytedance.sdk.openadsdk.core.dislike.u ai = null;
    private boolean q = false;
    private int z = Integer.MAX_VALUE;
    private final Map<String, xj> j = new ConcurrentHashMap();
    private Map<String, com.bytedance.sdk.component.adexpress.xj.w.u> en = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f10363a = Collections.synchronizedSet(new HashSet());
    private final List<Object> wo = new CopyOnWriteArrayList();
    private JSONObject eu = null;
    private String tj = "";
    private int vm = Integer.MAX_VALUE;
    private int dc = Integer.MAX_VALUE;
    private long wn = 0;
    private Set<String> aq = new ConcurrentSkipListSet();
    private Set<String> tu = new ConcurrentSkipListSet();
    private Set<String> s = new ConcurrentSkipListSet();
    private int dq = Integer.MAX_VALUE;
    private int qd = Integer.MAX_VALUE;
    private long bl = 2147483647L;
    private int lw = Integer.MAX_VALUE;
    private int wa = Integer.MAX_VALUE;
    private int gh = Integer.MAX_VALUE;
    private int op = Integer.MAX_VALUE;
    private int gy = Integer.MAX_VALUE;
    private int nb = 0;
    private long ss = 0;
    private int gj = 0;
    private long cy = 0;
    private int xv = Integer.MAX_VALUE;
    private JSONObject vl = null;
    private JSONObject h = null;
    private int ne = 3;

    static {
        iJGXE();
    }

    public tf() {
        int w = com.bytedance.sdk.openadsdk.xj.hf.hf.w();
        this.se = w;
        this.ft = w;
        this.rg = "live_sdk_conf";
        this.k = Integer.MAX_VALUE;
        this.da = Integer.MAX_VALUE;
        this.zb = null;
        this.le = null;
        this.oa = Integer.MAX_VALUE;
        this.i = Integer.MAX_VALUE;
        this.ua = Integer.MAX_VALUE;
        this.si = 0;
        this.my = 0.0f;
        this.lm = 0.0f;
        this.vi = false;
        this.cu = 8.5f;
        this.no = 7.3f;
        this.ut = null;
        this.he = null;
        this.zm = "apps.bytesfield.com";
        this.ey = Integer.MAX_VALUE;
        this.nt = Integer.MAX_VALUE;
        this.ic = 0;
        this.ci = 2;
        this.vw = false;
        this.uf = -1.0f;
        this.db = 2.14748365E9f;
        this.m = null;
        this.ir = Integer.MAX_VALUE;
        this.lx = 2;
        this.ah = null;
        this.ew = null;
        this.qf = false;
        this.kr = 3;
        this.bh = 0;
        this.ho = 1;
        this.vh = Integer.MAX_VALUE;
        this.uh = null;
        this.mq = 0;
        this.zf = null;
        this.jq = 0;
        this.jb = 0;
        this.ka = null;
        this.rx = 1;
        this.o = true;
        this.hx = false;
        this.ct = null;
        this.ha = 1;
        this.nu = "跳过";
        this.qa = 0;
        this.az = new y();
        this.fc = 0;
        this.oe = 0;
        this.ps = "";
        this.js = "21ea2d6d4f321553dd684e6b864bf0b7";
        this.rq = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20103/uchain_dsl.bin";
        this.pu = -1;
        this.pn = -1L;
        this.f0if = 0;
        this.lp = 2147483647L;
        this.su = Integer.MAX_VALUE;
        this.ta = Integer.MAX_VALUE;
        this.xe = Integer.MAX_VALUE;
        this.eb = Integer.MAX_VALUE;
        this.fh = Integer.MAX_VALUE;
        this.dj = Integer.MAX_VALUE;
        this.ie = null;
        this.co = null;
        this.xk = null;
        this.xw = new Object();
        this.w = null;
        this.og = null;
        this.rs = false;
        this.yq = false;
        this.lt = false;
        this.ap = false;
        this.oz = new ArrayList();
        this.ee = false;
        this.kd = 0;
        this.ky = new c();
        this.qe = true;
        this.nn = false;
        this.uo = 0;
        this.fs = Integer.MAX_VALUE;
        this.hq = false;
        this.py = false;
        this.kf = false;
        this.ob = 0;
        this.lv = new HashMap();
        this.eq = "";
        this.iy = null;
        this.kt = null;
        this.jv = false;
        this.dz = false;
        this.ul = false;
        this.dx = false;
        this.ez = Integer.MAX_VALUE;
        this.cm = true;
        this.wr = Integer.MAX_VALUE;
        this.kn = Integer.MAX_VALUE;
        this.vu = true;
        this.vo = 0;
    }

    public static void f() {
        tf hf = pz.hf();
        if (hf != null) {
            boolean nb = hf.nb();
            if (com.bytedance.sdk.openadsdk.zg.w.hf(com.bytedance.sdk.openadsdk.core.f.zg().r()).booleanValue(1) != nb) {
                com.bytedance.sdk.openadsdk.core.f.zg().r().apply(A2egSU.AZOQYO(10, Void.class).xj(0, new en().xj("downloadPath", com.bytedance.sdk.openadsdk.core.pl.d.xj(nb))).hf());
            }
            if (hf.o && hf.t != null) {
                com.bytedance.sdk.openadsdk.core.live.hf.xj().hf();
            }
            com.bytedance.sdk.openadsdk.core.en.w();
            com.bytedance.sdk.openadsdk.core.r.xj.xj().xj(pz.getContext());
        }
    }

    private static boolean g(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    private static /* synthetic */ void iJGXE() {
        char[] charArray = "-!#`)/#+`,!7`=&+\"\"`\u0004 '\f<'*)+".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'N');
        }
        String str = new String(charArray);
        char[] charArray2 = "-\"' ':".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'N');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private String jk(String str) {
        return "ad_slot_conf_".concat(String.valueOf(str));
    }

    public static String kd() {
        return com.bytedance.sdk.openadsdk.core.u.xj.c() ? "tt_sdk_settings_slot_bst" : "tt_sdk_settings_slot";
    }

    private com.bytedance.sdk.component.u.hf.w ky() {
        if (this.u == null) {
            this.u = j.xj(u());
        }
        return this.u;
    }

    private void nn() {
        hf();
        this.w.put("url_stats", this.kc);
        if (!"https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".equals(this.zd) && !TextUtils.isEmpty(this.zd)) {
            this.w.put("img_bucket", this.zd);
        }
        SharedPreferences.Editor edit = uo().edit();
        edit.putString("url_stats", this.kc);
        this.w.put("url_alog", this.le);
        edit.putString("url_alog", this.le);
        this.w.put("xpath", this.ws);
        if (this.r != null) {
            this.w.put("digest", this.r.toString());
        }
        this.w.put("data_time", this.b);
        this.w.put("fetch_template", this.da);
        this.w.put("pyload_h5", this.n);
        com.bytedance.sdk.component.u.hf.w wVar = this.w;
        ff ffVar = this.yy;
        wVar.put("insert_js_config", ffVar != null ? ffVar.toString() : "");
        com.bytedance.sdk.component.u.hf.w wVar2 = this.w;
        com.bytedance.sdk.openadsdk.core.e.xj.xj xjVar = this.hl;
        wVar2.put("white_check_config", xjVar != null ? xjVar.toString() : "");
        this.w.put("splash_check_type", this.vm);
        this.w.put("if_both_open", this.dq);
        this.w.put("adlog_exception_batch", this.wa);
        this.w.put("adlog_interval", this.bl);
        this.w.put("enable_kite", this.qt);
        this.w.put("adlog_batch", this.lw);
        this.w.put("adlog_debug", this.gh);
        this.w.put("adlog_monitor", this.op);
        this.w.put("enable_ttvideo", this.pz);
        this.w.put("enable_zaid", this.ht);
        this.w.put("enable_cdn_opt", this.v);
        this.w.put("download_button_effect", this.jk);
        this.w.put("ext_use_type", this.cy);
        this.w.put("enable_glgpu", 0);
        this.w.put("enable_dl_ext", this.gj);
        this.w.put("download_receiver_enable", this.f10364io);
        this.w.put("launch_strategy", this.xj);
        this.w.put("dl_popup_duration", this.dk);
        this.w.put("switch_audio_focus", this.xv);
        this.w.put("opt_show_check", this.et);
        if (this.vl != null) {
            this.w.put("pitaya_general_settings", this.vl.toString());
        }
        if (this.wx != null) {
            this.w.put("live_stream_cof", this.wx.toString());
        }
        if (this.yt != null) {
            this.w.put("dl_notification", this.yt.toString());
        }
        this.w.put("disable_show_url", this.vh);
        if (this.uh != null) {
            this.w.put("sensor_direction", this.uh.toString());
        }
        if (this.jf != null) {
            this.w.put("pitaya_business_conf", this.jf.toString());
        }
        com.bytedance.sdk.component.u.hf.w wVar3 = this.w;
        JSONObject jSONObject = this.h;
        wVar3.put("http_drop", jSONObject == null ? "" : jSONObject.toString());
        this.w.put("stats_batch", this.ne);
        this.w.put("event_switch", this.ft);
        this.w.put("pre_fetch_cnt", this.hf);
        this.w.put("web_upload_enable", this.y);
        this.w.put("web_upload_content_type", this.c);
        this.w.put("web_upload_send_restowv", this.f);
        this.w.put("web_upload_max_retry", this.am);
        this.w.put("web_upload_max_single_file", this.d);
        this.w.put("web_upload_max_zip_file", this.tf);
        this.w.put("web_upload_report_url", this.f10365pl);
        this.w.put("web_upload_storage_type", this.g);
        this.w.put("web_upload_report_only_wifi", this.p);
        this.w.put("app_list_control", this.dc);
        this.w.put("max_tpl_cnts", this.oa);
        this.w.put("fetch_tpl_timeout_ctrl", this.i);
        this.w.put("interact_show_after_time", this.ua);
        this.w.put("fetch_tpl_timeout_ctrl_bad_device", this.si);
        this.w.put("tpl_render_error_rate_h5", this.my);
        this.w.put("tpl_render_error_rate_native", this.lm);
        this.w.put("mid_value", this.cu);
        this.w.put("low_value", this.no);
        this.w.put("tpl_enable_render_timeout_opt", this.vi);
        this.w.put("open_single_abi", this.qi);
        com.bytedance.sdk.component.u.hf.w wVar4 = this.w;
        int i = this.ez;
        if (i == Integer.MAX_VALUE) {
            i = 0;
        }
        wVar4.put("show_callback_mult", i);
        this.w.put("webview_cache_count", this.nt);
        this.w.put("webview_cache_count_v3", this.ic);
        this.w.put("webview_render_concurrent_count", this.ci);
        this.w.put("enable_apm_pv", this.mg);
        this.w.put("hit_app_list_time", this.wn);
        this.w.put("hit_app_list_data", this.aq);
        this.w.put("scheme_list_data", this.tu);
        this.w.put("top_scheme_list_data", this.s);
        this.w.put("policy_url", this.sv);
        com.bytedance.sdk.component.u.hf.w wVar5 = this.w;
        Boolean bool = this.iy;
        wVar5.put("use_mediation_map", bool != null ? bool.booleanValue() : false);
        this.w.put("apm_pv_config", this.ra);
        this.w.put("dyn_draw_engine_url", this.ut);
        this.w.put("play_component_ugen_engine_url", this.he);
        this.w.put("ad_pkg_info_url", this.zm);
        this.w.put("sp_key_if_sp_cache", this.ey);
        this.w.put("download_sdk_config", this.tj);
        com.bytedance.sdk.component.u.hf.w wVar6 = this.w;
        JSONObject jSONObject2 = this.ew;
        wVar6.put("thread_config", jSONObject2 != null ? jSONObject2.toString() : "");
        this.w.put("npth_enable_type", this.kd);
        this.w.put("is_sp_send_meta", this.qe);
        this.w.put("opt_config", this.ky.toString());
        this.w.put("kv_config", this.az.toString());
        this.w.put("is_first_plugin_resources", this.nn);
        this.w.put("vbtt", this.k);
        this.w.put("preload_switch", this.hq);
        this.w.put("cache_ana_lru_switch", this.py);
        this.w.put("cache_ana_expire_switch", this.kf);
        this.w.put("preload_time_point", this.ob);
        this.w.put("app_info_cache_switch", this.ac);
        this.w.put("is_adapt_density", this.jv);
        this.w.put("disable_easy_playable", this.cm);
        this.w.put("enable_target_34", this.wr);
        this.w.put("enable_xm_market", this.kn);
        this.w.put("disable_repeat_render", this.vu);
        this.w.put("status_bar_adapt", this.vo);
        this.w.put("template_pull_timeout", this.yl);
        this.w.put("template_pull_type", this.bi);
        if (!TextUtils.isEmpty(this.ff)) {
            this.w.put("template_ids", this.ff);
        }
        if (!TextUtils.isEmpty(this.l)) {
            this.w.put("tpl_infos", this.l);
        }
        com.bytedance.sdk.component.u.hf.w wVar7 = this.w;
        v vVar = this.wf;
        wVar7.put("tpl_timeout_ctrl", vVar != null ? vVar.toString() : "");
        this.w.put("call_stack_rate", this.uf);
        this.w.put("gnd_prefetch_cache_ttl", this.pn);
        this.w.put("gnd_prefetch_cache_size", this.pu);
        this.w.put("global_rate", this.db);
        this.w.put("read_video_from_cache", this.ir);
        this.w.put("brand_video_cache_count", this.lx);
        this.w.put("enable_bw_screen_detection", this.qf);
        this.w.put("splash_card_show_max_count", this.kr);
        com.bytedance.sdk.component.u.hf.w wVar8 = this.w;
        com.bytedance.sdk.openadsdk.core.c.hf hfVar = this.x;
        wVar8.put("clog_config", hfVar != null ? hfVar.toString() : "");
        com.bytedance.sdk.component.u.hf.w wVar9 = this.w;
        com.bytedance.sdk.openadsdk.core.dislike.u uVar = this.ai;
        wVar9.put("clog_config", uVar != null ? uVar.toString() : "");
        this.w.put("check_live_room", this.q);
        this.w.put("can_init_live", this.o);
        this.w.put("new_app_list", this.hx);
        com.bytedance.sdk.component.u.hf.w wVar10 = this.w;
        hf hfVar2 = this.it;
        wVar10.put("app_live_config", hfVar2 != null ? hfVar2.toString() : "");
        com.bytedance.sdk.component.u.hf.w wVar11 = this.w;
        JSONObject jSONObject3 = this.ct;
        wVar11.put("plugin_update_state", jSONObject3 != null ? jSONObject3.toString() : "");
        com.bytedance.sdk.component.u.hf.w wVar12 = this.w;
        JSONObject jSONObject4 = this.co;
        wVar12.put("antispam_autoclick_detect", jSONObject4 != null ? jSONObject4.toString() : "");
        this.w.put("pglam_main_enable", this.jq);
        this.w.put("pglam_dns_check_enable", this.jb);
        this.w.put("pglam_clazz_check", this.ka);
        this.w.put("ud_enable", this.rx);
        this.w.put("is_open_isw", this.ha);
        edit.putInt("is_kv_cache_type", this.qa);
        edit.putInt("kv_init_type", this.fc);
        edit.putString(TKDownloadReason.KSAD_TK_MD5, this.js);
        edit.putString("url", this.rq);
        edit.apply();
        this.w.put("lp_url_sw", this.oe);
        if (this.oe == 1) {
            if (com.bytedance.sdk.openadsdk.core.w.w.xj().d()) {
                ky().put("lp_list", this.ps);
            } else if (!com.bytedance.sdk.openadsdk.core.f.zg().z()) {
                ky().put("lp_list", this.ps);
            }
        }
        if (this.t != null) {
            this.w.put("live_sdk_conf", this.t.toString());
        }
        this.w.put("open_dl_type", this.uo);
        this.w.put("app_dl_scheme_list", this.tq);
        this.w.put("scheme_get_type", this.bh);
        this.w.put("scheme_get_num", this.ho);
        this.w.put("if_query_all_package", this.mq);
        if (this.ah != null) {
            this.w.put("video_cache_config", this.ah.toString());
        }
        if (this.m != null) {
            this.w.put("log_rate_conf", this.m.toString());
        }
        this.w.put("splash_close_text", this.nu);
        this.w.put("network_module", this.z);
        this.w.put("m_vids_join", this.fs);
        this.w.put("mini_event_upload_version", this.f0if);
        this.w.put("bg_web_readd_t", this.lp);
        this.w.put("title_priority", this.su);
        this.w.put("splash_video_opt_enable", this.ta);
        this.w.put("gesture_through_enable", this.xe);
        this.w.put("refresh_req_num", this.eb);
        this.w.put("refresh_max_times", this.fh);
        this.w.put("shake_trigger_control", this.xl);
        this.w.put("net_rating", this.rs);
        this.w.put("device_rating", this.yq);
        this.w.put("bytebench_rating", this.lt);
        com.bytedance.sdk.component.u.hf.w wVar13 = this.w;
        JSONObject jSONObject5 = this.og;
        wVar13.put("net_rating_config", jSONObject5 != null ? jSONObject5.toString() : "");
        this.w.put("express_gesture_enable", this.zg);
        this.w.put("enable_download_proto", this.yo);
        this.w.put("app_express_gesture_priority", this.e);
        this.w.put("ad_slot_conf_block", this.eq);
        this.w.put("view_check_by_window", this.dz);
        this.w.put("shake_twist_bind_show", this.ul);
        this.w.put("view_check_by_click", this.dx);
        this.w.put("enable", this.ap);
        this.w.put("session_enable", this.ee);
        com.bytedance.sdk.openadsdk.core.ra.en.xj(this.w);
        aq.xj(this.w);
        com.bytedance.sdk.openadsdk.core.ra.f.hf(this.w);
        yo.xj(this.w);
        ai.hf(this.w);
        com.bytedance.sdk.openadsdk.core.ra.j.hf(this.w);
    }

    private void pl(int i) {
        if (i <= 0) {
            i = 1;
        }
        com.bytedance.adsdk.lottie.c.xj(i);
    }

    private void qe() {
        com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("") { // from class: com.bytedance.sdk.openadsdk.core.j.tf.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.x.hf.xj.xj();
            }
        });
    }

    public static String u() {
        return com.bytedance.sdk.openadsdk.core.u.xj.c() ? "tt_sdk_lp_w_list_bst" : "tt_sdk_lp_w_list";
    }

    private SharedPreferences uo() {
        if (this.jw == null) {
            this.jw = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext(), w(), 0);
        }
        return this.jw;
    }

    public static String w() {
        return "tt_sdk_settings_other_bst";
    }

    public static String y() {
        return com.bytedance.sdk.openadsdk.core.u.xj.c() ? "tt_sdk_settings_slot_splash_bst" : "tt_sdk_settings_slot_splash";
    }

    public int a() {
        if (this.wa == Integer.MAX_VALUE) {
            this.wa = hf().get("adlog_exception_batch", 100);
        }
        return this.wa;
    }

    public float ah() {
        if (this.my == 0.0f) {
            this.my = hf().get("tpl_render_error_rate_h5", 4.5f);
        }
        return this.my;
    }

    public boolean ai() {
        if (this.xv == Integer.MAX_VALUE) {
            this.xv = hf().get("switch_audio_focus", 0);
        }
        return this.xv == 1;
    }

    public int am() {
        if (this.e == Integer.MIN_VALUE) {
            this.e = hf().get("app_express_gesture_priority", -1);
        }
        return this.e;
    }

    public boolean ap() {
        return this.dz;
    }

    public String aq() {
        if (TextUtils.equals(this.f10365pl, "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/")) {
            this.f10365pl = hf().get("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
        }
        return this.f10365pl;
    }

    public c az() {
        return this.ky;
    }

    public JSONObject b() {
        if (this.r == null) {
            String str = hf().get("digest", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.r = new JSONObject(str);
                } catch (Exception unused) {
                }
            }
        }
        return this.r;
    }

    public int bh() {
        if (this.nt == Integer.MAX_VALUE) {
            this.nt = hf().get("webview_cache_count", 0);
        }
        int i = this.nt;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public JSONObject bl() {
        return this.ew;
    }

    public com.bytedance.sdk.component.u.hf.w c() {
        if (this.ol == null) {
            this.ol = j.xj(kd());
        }
        if (j.hf() != 1) {
            return null;
        }
        return this.ol;
    }

    public List<String> ci() {
        if (this.wn + bn.e < System.currentTimeMillis()) {
            return null;
        }
        Map<String, Boolean> hf = x.hf(86400000L);
        ArrayList arrayList = new ArrayList();
        synchronized (this.tu) {
            try {
                for (String str : this.tu) {
                    if (!hf.containsKey(str.replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""))) {
                        arrayList.add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Collections.sort(arrayList, new Comparator<String>() { // from class: com.bytedance.sdk.openadsdk.core.j.tf.3
            @Override // java.util.Comparator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public int compare(String str2, String str3) {
                try {
                    return Integer.parseInt(Uri.parse(str2).getQueryParameter("tt_csj_scheme_priority")) - Integer.parseInt(Uri.parse(str3).getQueryParameter("tt_csj_scheme_priority"));
                } catch (Throwable unused) {
                    return 0;
                }
            }
        });
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.set(i, ((String) arrayList.get(i)).replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""));
        }
        return arrayList;
    }

    public boolean co() {
        return this.py;
    }

    public int ct() {
        int i = hf().get("npth_enable_type", 0);
        this.kd = i;
        return i;
    }

    public boolean cu() {
        return Build.VERSION.SDK_INT < this.f0if;
    }

    public JSONObject cy() {
        return this.wx;
    }

    public boolean d() {
        return this.xl == 1;
    }

    public String da() {
        if (TextUtils.isEmpty(this.nu)) {
            this.nu = hf().get("splash_close_text", "跳过");
        }
        if (TextUtils.isEmpty(this.nu)) {
            this.nu = "跳过";
        }
        return this.nu;
    }

    public boolean db() {
        if (this.ez == Integer.MAX_VALUE) {
            this.ez = hf().get("show_callback_mult", 0);
        }
        return this.ez == 1;
    }

    public int dc() {
        if (this.am == Integer.MAX_VALUE) {
            this.am = hf().get("web_upload_max_retry", 0);
        }
        return this.am;
    }

    public String dj() {
        if (TextUtils.isEmpty(this.rq)) {
            this.rq = uo().getString("url", "");
        }
        return this.rq;
    }

    public int dk() {
        if (this.lw == Integer.MAX_VALUE) {
            this.lw = hf().get("adlog_batch", 10);
        }
        return this.lw;
    }

    public com.bytedance.sdk.openadsdk.core.e.xj.xj dq() {
        if (this.hl == null) {
            this.hl = com.bytedance.sdk.openadsdk.core.e.xj.xj.xj(hf().get("white_check_config", ""));
        }
        return this.hl;
    }

    public boolean e() {
        boolean z = hf().get("enable_apm_pv", false);
        this.mg = z;
        return z;
    }

    public int eb() {
        if (this.fc == 0) {
            this.fc = uo().getInt("kv_init_type", 0);
        }
        return this.fc;
    }

    public boolean ee() {
        return this.dx;
    }

    public boolean en() {
        if (this.gy == Integer.MAX_VALUE) {
            this.gy = hf().get("enable_glgpu", 0);
        }
        return this.gy == 1;
    }

    public boolean et() {
        if (this.gj == this.nb) {
            this.gj = hf().get("enable_dl_ext", this.nb);
        }
        return this.gj == 1;
    }

    public float eu() {
        if (this.uf < 0.0f) {
            this.uf = hf().get("call_stack_rate", 0.0f);
        }
        return this.uf;
    }

    public float ew() {
        if (this.lm == 0.0f) {
            this.lm = hf().get("tpl_render_error_rate_native", 1.0f);
        }
        return this.lm;
    }

    public List<String> ey() {
        if (this.wn + bn.e < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.aq.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public boolean fa() {
        return this.jv;
    }

    public y fc() {
        return this.az;
    }

    public boolean ff() {
        if (this.et == Integer.MAX_VALUE) {
            this.et = hf().get("opt_show_check", 0);
        }
        return this.et == 1;
    }

    public String fh() {
        if (this.oe != 1) {
            return "";
        }
        if (!TextUtils.isEmpty(this.ps)) {
            return this.ps;
        }
        String str = ky().get("lp_list", this.ps);
        this.ps = str;
        return str;
    }

    public boolean ft() {
        if (this.vh == Integer.MAX_VALUE) {
            this.vh = this.w.get("disable_show_url", 0);
        }
        return this.vh == 1;
    }

    public boolean gh() {
        if (this.db == 2.14748365E9f) {
            this.db = hf().get("global_rate", 1.0f);
        }
        return ((float) ((int) this.db)) == 1.0f;
    }

    public JSONObject gj() {
        if (this.h == null) {
            String str = hf().get("http_drop", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.h = new JSONObject(str);
                } catch (Exception e) {
                    pl.xj(e);
                }
            }
        }
        return this.h;
    }

    public JSONObject gy() {
        if (this.m == null) {
            try {
                this.m = new JSONObject(hf().get("log_rate_conf", ""));
            } catch (Exception unused) {
            }
        }
        return this.m;
    }

    public JSONObject h() {
        return this.jf;
    }

    public boolean ha() {
        return this.qe;
    }

    public String he() {
        if (TextUtils.isEmpty(this.sv)) {
            this.sv = hf().get("policy_url", uj);
        }
        return this.sv;
    }

    public com.bytedance.sdk.component.u.hf.w hf() {
        if (this.w == null) {
            this.w = j.xj(w());
        }
        return this.w;
    }

    public int hl() {
        if (this.d == Integer.MAX_VALUE) {
            this.d = hf().get("web_upload_max_single_file", 2);
        }
        return this.d;
    }

    public int ho() {
        if (this.ic == Integer.MAX_VALUE) {
            this.ic = hf().get("webview_cache_count_v3", 0);
        }
        int i = this.ic;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public long ht() {
        if (this.bl == 2147483647L) {
            this.bl = hf().get("adlog_interval", PushUIConfig.dismissTime);
        }
        return this.bl;
    }

    public int hx() {
        return this.kr;
    }

    public int i() {
        if (this.jk == Integer.MAX_VALUE) {
            this.jk = hf().getInt("download_button_effect", 0);
        }
        return this.jk;
    }

    public JSONObject ic() {
        if (this.ah == null) {
            try {
                String str = hf().get("video_cache_config", "");
                if (!TextUtils.isEmpty(str)) {
                    this.ah = new JSONObject(str);
                }
            } catch (Throwable th) {
                pl.hf("TTSdkSettings", th.getMessage());
            }
        }
        return this.ah;
    }

    public boolean ie() {
        return this.hq;
    }

    /* renamed from: if, reason: not valid java name */
    public JSONObject m6if() {
        return this.ct;
    }

    public int io() {
        if (this.ne == 3) {
            this.ne = hf().get("stats_batch", 5);
        }
        int i = this.ne;
        if (i <= 0 || i > 100) {
            return 5;
        }
        return i;
    }

    public int ir() {
        if (this.si == 0) {
            this.si = hf().get("fetch_tpl_timeout_ctrl_bad_device", 300);
        }
        return this.si;
    }

    public int it() {
        return this.lx;
    }

    public long j() {
        if (this.cy == this.ss) {
            this.cy = hf().get("ext_use_type", this.ss);
        }
        return this.cy;
    }

    public int jb() {
        return this.vo;
    }

    public int jf() {
        if (this.pu == -1) {
            this.pu = hf().get("gnd_prefetch_cache_size", 5);
        }
        return this.pu;
    }

    public boolean jq() {
        return this.vu;
    }

    public int js() {
        return this.jb;
    }

    public boolean jw() {
        return this.qi;
    }

    public String k() {
        if (TextUtils.isEmpty(this.zm)) {
            this.zm = hf().get("ad_pkg_info_url", "apps.bytesfield.com");
        }
        if (TextUtils.isEmpty(this.zm)) {
            this.zm = "apps.bytesfield.com";
        }
        return this.zm;
    }

    public int ka() {
        return this.yl;
    }

    public boolean kc() {
        if (this.ta == Integer.MAX_VALUE) {
            this.ta = hf().get("splash_video_opt_enable", 0);
        }
        return this.ta == 1;
    }

    public boolean kr() {
        if (!this.ap) {
            this.ap = hf().get("enable", true);
        }
        return this.ap;
    }

    public boolean l() {
        if (this.xj == 0) {
            this.xj = hf().get("launch_strategy", 0);
        }
        return this.xj == 1;
    }

    public boolean le() {
        int zb = zb();
        com.bytedance.sdk.component.u.xj hf = dk.hf();
        return (zb == 40001 || zb == 40002 || zb == 4) && hf != null && hf.getArmorLoadStatus();
    }

    public boolean lm() {
        return this.mq == 1;
    }

    public hf lp() {
        return this.it;
    }

    public boolean lt() {
        return this.ac;
    }

    public int lw() {
        if (this.vm == Integer.MAX_VALUE) {
            this.vm = hf().get("splash_check_type", 1);
        }
        return this.vm;
    }

    public boolean lx() {
        if (!this.vi) {
            this.vi = hf().get("tpl_enable_render_timeout_opt", false);
        }
        return this.vi;
    }

    public int m() {
        if (this.ua == Integer.MAX_VALUE) {
            this.ua = hf().get("interact_show_after_time", 500);
        }
        return this.ua;
    }

    public int mg() {
        if (this.eb == Integer.MAX_VALUE) {
            this.eb = hf().get("refresh_req_num", 2);
        }
        if (this.eb <= 0) {
            this.eb = 2;
        }
        return this.eb;
    }

    public int mq() {
        if (this.wr == Integer.MAX_VALUE) {
            this.wr = hf().get("enable_target_34", 1);
        }
        return this.wr;
    }

    public int my() {
        int i = this.ho;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public Set<String> n() {
        Set<String> set;
        if (this.c.isEmpty() && (set = hf().get("web_upload_content_type", Collections.synchronizedSet(new HashSet()))) != null && set.size() != 0) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                this.c.add(it.next());
            }
        }
        return this.c;
    }

    public boolean nb() {
        return com.bytedance.sdk.openadsdk.core.w.kd.xj().f();
    }

    public b ne() {
        return this.t;
    }

    public long no() {
        if (this.lp == 2147483647L) {
            this.lp = hf().get("bg_web_readd_t", 3000L);
        }
        return this.lp;
    }

    public int nt() {
        if (this.ey == Integer.MAX_VALUE) {
            this.ey = hf().get("sp_key_if_sp_cache", 1);
        }
        return this.ey;
    }

    public boolean nu() {
        return this.ky.w;
    }

    public boolean o() {
        if (this.ir == Integer.MAX_VALUE) {
            this.ir = hf().get("read_video_from_cache", 1);
        }
        return this.ir == 1;
    }

    public boolean oa() {
        if (this.v == Integer.MAX_VALUE) {
            this.v = hf().getInt("enable_cdn_opt", 0);
        }
        return this.v == 1;
    }

    public synchronized boolean oe() {
        try {
            if (!cc) {
                iz = hf().get("disable_easy_playable", true);
                cc = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return iz;
    }

    public boolean og() {
        if (this.rx == 1) {
            this.rx = hf().get("ud_enable", 1);
        }
        return this.rx == 1;
    }

    public int ol() {
        if (this.oa == Integer.MAX_VALUE) {
            this.oa = hf().get("max_tpl_cnts", 100);
        }
        return this.oa;
    }

    public String op() {
        if (TextUtils.isEmpty(this.ra)) {
            this.ra = hf().get("apm_pv_config", "");
        }
        return this.ra;
    }

    public boolean oz() {
        return this.ul;
    }

    public boolean p() {
        if (this.pz == -1) {
            this.pz = hf().get("enable_ttvideo", -1);
        }
        int i = this.pz;
        if (i == 0) {
            return false;
        }
        return (i == 1 && (io.v() || io.yo())) ? false : true;
    }

    public boolean pn() {
        return this.hx;
    }

    public boolean ps() {
        return this.q;
    }

    public boolean pu() {
        return this.o;
    }

    public boolean pz() {
        if (this.op == Integer.MAX_VALUE) {
            this.op = hf().get("adlog_monitor", 1);
        }
        return this.op != 0;
    }

    public boolean q() {
        if (this.ft == this.se) {
            this.ft = hf().get("event_switch", this.se);
        }
        return this.ft == 1;
    }

    public boolean qa() {
        return this.ky.xj;
    }

    public JSONObject qd() {
        if (this.eu == null) {
            String str = hf().get("download_sdk_config", "");
            this.tj = str;
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.eu = new JSONObject(this.tj);
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        }
        return this.eu;
    }

    public float qf() {
        if (this.no == 0.0f) {
            this.no = hf().get("low_value", 7.3f);
        }
        return this.no;
    }

    public boolean qi() {
        if (this.su == Integer.MAX_VALUE) {
            this.su = hf().get("title_priority", 0);
        }
        return this.su == 1;
    }

    public String qt() {
        if (TextUtils.isEmpty(this.kc)) {
            String str = hf().get("url_stats", "api-access.pangolin-sdk-toutiao1.com");
            this.kc = str;
            if (TextUtils.isEmpty(str)) {
                this.kc = "api-access.pangolin-sdk-toutiao1.com";
            }
        }
        return this.kc;
    }

    public String r() {
        if (TextUtils.isEmpty(this.ws)) {
            this.ws = hf().get("xpath", "");
        }
        return this.ws;
    }

    public boolean ra() {
        if (this.qt == Integer.MAX_VALUE) {
            this.qt = hf().get("enable_kite", 0);
        }
        return this.qt == 1;
    }

    public String rg() {
        if (TextUtils.isEmpty(this.ut)) {
            this.ut = hf().get("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        }
        return this.ut;
    }

    public String[] rq() {
        String str = this.ka;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return this.ka.split("//");
    }

    public boolean rs() {
        return this.yq;
    }

    public int rx() {
        return this.bi;
    }

    public ff s() {
        if (this.yy == null) {
            this.yy = ff.xj(hf().get("insert_js_config", ""));
        }
        return this.yy;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.u se() {
        return this.ai;
    }

    public boolean si() {
        return this.bh != 1;
    }

    public JSONObject ss() {
        return this.vl;
    }

    public boolean su() {
        return com.bytedance.sdk.openadsdk.core.ai.c() && this.ha == 1;
    }

    public boolean sv() {
        if (!this.ee) {
            this.ee = hf().get("session_enable", false);
        }
        return this.ee;
    }

    public String t() {
        if (TextUtils.isEmpty(this.he)) {
            this.he = hf().get("play_component_ugen_engine_url", "");
        }
        return this.he;
    }

    public int ta() {
        if (this.qa == 0) {
            this.qa = uo().getInt("is_kv_cache_type", 0);
        }
        return this.qa;
    }

    public String tf() {
        if (TextUtils.isEmpty(this.zb)) {
            this.zb = com.bytedance.sdk.openadsdk.core.w.w.xj().u();
        }
        return this.zb;
    }

    public int tj() {
        if (this.y == Integer.MAX_VALUE) {
            this.y = hf().get("web_upload_enable", 0);
        }
        return this.y;
    }

    public int tu() {
        if (this.g == Integer.MAX_VALUE) {
            this.g = hf().get("web_upload_storage_type", 0);
        }
        return this.g;
    }

    public boolean ua() {
        if (this.dj == Integer.MAX_VALUE) {
            this.dj = hf().get("settings_open", 1);
        }
        return this.dj == 1;
    }

    public boolean uf() {
        if (this.dc == Integer.MAX_VALUE) {
            this.dc = hf().get("app_list_control", 0);
        }
        return this.dc == 1;
    }

    public long uh() {
        if (this.pn == -1) {
            this.pn = hf().get("gnd_prefetch_cache_ttl", 0L);
        }
        return this.pn;
    }

    public List<Integer> uj() {
        return new ArrayList(this.oz);
    }

    public int ut() {
        if (this.fh == Integer.MAX_VALUE) {
            this.fh = hf().get("refresh_max_times", 1);
        }
        if (this.fh < 0) {
            this.fh = 1;
        }
        return this.fh;
    }

    public String v() {
        if (TextUtils.isEmpty(this.le)) {
            String str = hf().get("url_alog", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
            this.le = str;
            if (TextUtils.isEmpty(str)) {
                this.le = "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
            }
        }
        return this.le;
    }

    public int vh() {
        if (this.k == Integer.MAX_VALUE) {
            this.k = hf().get("vbtt", 5);
        }
        return this.k;
    }

    public int vi() {
        if (this.fs == Integer.MAX_VALUE) {
            this.fs = hf().get("m_vids_join", 0);
        }
        int i = this.fs;
        if (i == Integer.MAX_VALUE) {
            return 0;
        }
        return i;
    }

    public JSONObject vl() {
        return this.uh;
    }

    public int vm() {
        if (this.tf == Integer.MAX_VALUE) {
            this.tf = hf().get("web_upload_max_zip_file", 5);
        }
        return this.tf;
    }

    public Set<String> vw() {
        if (this.s.size() == 0) {
            return null;
        }
        return this.s;
    }

    public boolean wa() {
        return lw() == 1;
    }

    public int wn() {
        if (this.p == Integer.MAX_VALUE) {
            this.p = hf().get("web_upload_report_only_wifi", 0);
        }
        return this.p;
    }

    public boolean wo() {
        if (this.qd == Integer.MAX_VALUE) {
            this.qd = 1;
        }
        return this.qd == 1;
    }

    public long ws() {
        if (this.b == 0) {
            this.b = hf().get("data_time", 0L);
        }
        return this.b;
    }

    public void wx() {
        if (this.xk == null) {
            synchronized (this.xw) {
                try {
                    if (this.xk == null) {
                        this.xk = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext(), y(), 0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public boolean x() {
        if (this.f10364io == Integer.MAX_VALUE) {
            this.f10364io = hf().get("download_receiver_enable", 1);
        }
        return this.f10364io != 0;
    }

    public int xe() {
        return this.qa;
    }

    @Override // com.bytedance.sdk.openadsdk.core.j.kd
    public synchronized void xj() {
        hf();
        this.vw = true;
        this.wa = this.w.get("adlog_exception_batch", 100);
        this.kc = this.w.get("url_stats", "api-access.pangolin-sdk-toutiao1.com");
        this.zd = this.w.get("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
        this.mg = this.w.get("enable_apm_pv", false);
        this.le = this.w.get("url_alog", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
        this.ws = this.w.get("xpath", "");
        this.b = this.w.get("data_time", 0L);
        this.da = this.w.get("fetch_template", SdkConfigData.DEFAULT_REQUEST_INTERVAL);
        this.k = this.w.get("vbtt", 5);
        this.ff = this.w.get("template_ids", this.zf);
        this.n = this.w.get("pyload_h5", this.zf);
        this.yy = ff.xj(this.w.get("insert_js_config", this.zf));
        this.vm = this.w.get("splash_check_type", 1);
        this.gh = this.w.get("adlog_debug", 0);
        this.lw = this.w.get("adlog_batch", 10);
        this.bl = this.w.get("adlog_interval", PushUIConfig.dismissTime);
        this.qt = this.w.get("enable_kite", 0);
        this.wa = this.w.get("adlog_exception_batch", 100);
        this.op = this.w.get("adlog_monitor", 1);
        this.pz = this.w.get("enable_ttvideo", -1);
        this.ht = this.w.get("enable_zaid", 0);
        this.v = this.w.get("enable_cdn_opt", 0);
        this.jk = this.w.get("download_button_effect", 0);
        this.gj = this.w.get("enable_dl_ext", this.nb);
        this.cy = this.w.get("ext_use_type", this.ss);
        this.gy = this.w.get("enable_glgpu", 0);
        this.xj = this.w.get("launch_strategy", 0);
        this.dk = this.w.get("dl_popup_duration", 1000);
        this.et = this.w.get("opt_show_check", 0);
        this.wf = v.w(this.w.get("tpl_timeout_ctrl", ""));
        MultiWebview.setMaxWebViewCount(this.w.get("open_webview_count", 0));
        String str = this.w.get("digest", "");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.r = new JSONObject(str);
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        String str2 = this.w.get("pitaya_general_settings", "");
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.vl = new JSONObject(str2);
            } catch (Exception e2) {
                pl.xj(e2);
            }
        }
        String str3 = this.w.get("dl_notification", "");
        if (!TextUtils.isEmpty(str3)) {
            try {
                this.yt = new JSONObject(str3);
            } catch (Exception unused) {
            }
        }
        String str4 = this.w.get("live_stream_cof", "");
        if (!TextUtils.isEmpty(str4)) {
            try {
                this.wx = new JSONObject(str4);
            } catch (Exception e3) {
                pl.u("parse exception", "e:" + e3.getMessage());
            }
        }
        this.vh = this.w.get("disable_show_url", 0);
        String str5 = this.w.get("sensor_direction", "");
        if (!TextUtils.isEmpty(str5)) {
            try {
                this.uh = new JSONObject(str5);
            } catch (Exception e4) {
                pl.u("parse ex", "e:" + e4.getMessage());
            }
        }
        String str6 = this.w.get("pitaya_business_conf", "");
        if (!TextUtils.isEmpty(str6)) {
            try {
                this.jf = new JSONObject(str6);
            } catch (Exception e5) {
                pl.u("parse exception", "e:" + e5.getMessage());
            }
        }
        String str7 = this.w.get("http_drop", "");
        if (!TextUtils.isEmpty(str7)) {
            try {
                this.h = new JSONObject(str7);
            } catch (Exception e6) {
                pl.xj(e6);
            }
        }
        this.ne = this.w.get("stats_batch", 5);
        this.xv = this.w.get("switch_audio_focus", 0);
        this.f10364io = this.w.get("download_receiver_enable", 1);
        this.ft = this.w.get("event_switch", this.se);
        this.hf = this.w.get("pre_fetch_cnt", 10);
        this.dq = this.w.get("if_both_open", 0);
        this.l = this.w.get("tpl_infos", this.zf);
        this.pn = this.w.get("gnd_prefetch_cache_ttl", 0L);
        this.pu = this.w.get("gnd_prefetch_cache_size", 5);
        this.db = this.w.get("global_rate", 1.0f);
        this.dc = this.w.get("app_list_control", 0);
        this.oa = this.w.get("max_tpl_cnts", 100);
        this.i = this.w.get("fetch_tpl_timeout_ctrl", 5000);
        this.ua = this.w.get("interact_show_after_time", 500);
        this.si = this.w.get("fetch_tpl_timeout_ctrl_bad_device", 300);
        this.my = this.w.get("tpl_render_error_rate_h5", 4.5f);
        this.vi = this.w.get("tpl_enable_render_timeout_opt", false);
        this.lm = this.w.get("tpl_render_error_rate_native", 1.0f);
        this.lt = this.w.get("enable", false);
        this.cu = this.w.get("mid_value", 8.5f);
        this.no = this.w.get("low_value", 7.3f);
        this.qi = this.w.get("open_single_abi", false);
        this.ez = this.w.get("show_callback_mult", 0);
        this.nt = this.w.get("webview_cache_count", 0);
        this.ic = this.w.get("webview_cache_count_v3", 0);
        this.ci = this.w.get("webview_render_concurrent_count", 2);
        this.sv = this.w.get("policy_url", uj);
        this.iy = Boolean.valueOf(this.w.get("use_mediation_map", false));
        this.wn = this.w.get("hit_app_list_time", 0L);
        this.aq.clear();
        this.ra = this.w.get("apm_pv_config", "");
        this.ut = this.w.get("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        this.he = this.w.get("play_component_ugen_engine_url", "");
        this.zm = this.w.get("ad_pkg_info_url", "apps.bytesfield.com");
        this.ey = this.w.get("sp_key_if_sp_cache", 1);
        this.zg = this.w.get("express_gesture_enable", 0);
        this.yo = this.w.get("enable_download_proto", 1);
        this.e = this.w.get("app_express_gesture_priority", -1);
        this.nu = this.w.get("splash_close_text", "跳过");
        this.z = this.w.get("network_module", 1);
        com.bytedance.sdk.component.hf.xj.xj.xj.xj().xj(this.z != 2);
        this.y = this.w.get("web_upload_enable", 0);
        Set<String> set = this.w.get("web_upload_content_type", Collections.synchronizedSet(new HashSet()));
        this.c.clear();
        if (set != null && set.size() != 0) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                this.c.add(it.next());
            }
        }
        this.f = this.w.get("web_upload_send_restowv", 0);
        this.d = this.w.get("web_upload_max_single_file", 2);
        this.tf = this.w.get("web_upload_max_zip_file", 5);
        this.am = this.w.get("web_upload_max_retry", 0);
        this.f10365pl = this.w.get("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
        this.g = this.w.get("web_upload_storage_type", 0);
        this.p = this.w.get("web_upload_report_only_wifi", 0);
        Set<String> set2 = this.w.get("hit_app_list_data", Collections.synchronizedSet(new HashSet()));
        if (set2 != null && !set2.isEmpty()) {
            Iterator<String> it2 = set2.iterator();
            while (it2.hasNext()) {
                this.aq.add(it2.next());
            }
        }
        synchronized (this.tu) {
            try {
                this.tu.clear();
                Set<String> set3 = this.w.get("scheme_list_data", Collections.synchronizedSet(new HashSet()));
                if (set3 != null && !set3.isEmpty()) {
                    Iterator<String> it3 = set3.iterator();
                    while (it3.hasNext()) {
                        this.tu.add(it3.next());
                    }
                }
            } finally {
            }
        }
        synchronized (this.s) {
            try {
                this.s.clear();
                Set<String> set4 = this.w.get("top_scheme_list_data", Collections.synchronizedSet(new HashSet()));
                if (set4 != null && !set4.isEmpty()) {
                    Iterator<String> it4 = set4.iterator();
                    while (it4.hasNext()) {
                        this.s.add(it4.next());
                    }
                }
            } finally {
            }
        }
        String str8 = this.w.get("download_sdk_config", "");
        this.tj = str8;
        if (!TextUtils.isEmpty(str8)) {
            try {
                this.eu = new JSONObject(this.tj);
            } catch (JSONException e7) {
                pl.w("TTSdkSettings", e7);
            }
        }
        String str9 = this.w.get("thread_config", "");
        if (!TextUtils.isEmpty(str9)) {
            try {
                this.ew = new JSONObject(str9);
                com.bytedance.sdk.openadsdk.core.en.xj.hf();
            } catch (JSONException e8) {
                pl.w("TTSdkSettings", e8);
            }
        }
        this.uf = this.w.get("call_stack_rate", 0.0f);
        this.ir = this.w.get("read_video_from_cache", 1);
        this.lx = this.w.get("brand_video_cache_count", 2);
        this.qf = this.w.get("enable_bw_screen_detection", false);
        this.kr = this.w.get("splash_card_show_max_count", 3);
        this.x = com.bytedance.sdk.openadsdk.core.c.hf.xj(this.w.get("clog_config", this.zf));
        this.ai = com.bytedance.sdk.openadsdk.core.dislike.u.xj(this.w.get("oncall_upload", ""));
        this.q = this.w.get("check_live_room", false);
        this.o = this.w.get("can_init_live", true);
        this.hx = this.w.get("new_app_list", false);
        String str10 = this.w.get("plugin_update_state", "");
        if (!TextUtils.isEmpty(str10)) {
            try {
                this.ct = new JSONObject(str10);
            } catch (JSONException e9) {
                pl.xj(e9);
            }
        }
        String str11 = this.w.get("antispam_autoclick_detect", "");
        if (!TextUtils.isEmpty(str11)) {
            try {
                this.co = new JSONObject(str11);
                com.bytedance.sdk.component.u.xj hf = dk.hf();
                if (hf != null) {
                    hf.updateHARSettings(this.co);
                }
            } catch (JSONException e10) {
                pl.xj(e10);
            }
        }
        String str12 = this.w.get("app_live_config", "");
        if (!TextUtils.isEmpty(str12)) {
            try {
                this.it = hf.xj(new JSONObject(str12));
            } catch (JSONException unused2) {
            }
        }
        this.jq = this.w.get("pglam_main_enable", 0);
        this.jb = this.w.get("pglam_dns_check_enable", 0);
        this.ka = this.w.get("pglam_clazz_check", "");
        this.rx = this.w.get("ud_enable", 1);
        this.qa = uo().getInt("is_kv_cache_type", 0);
        this.fc = uo().getInt("kv_init_type", 0);
        this.uo = this.w.get("open_dl_type", 0);
        this.tq = this.w.get("app_dl_scheme_list", "");
        int i = this.w.get("lp_url_sw", 0);
        this.oe = i;
        if (i == 1) {
            this.ps = ky().get("lp_list", "");
        }
        this.js = uo().getString(TKDownloadReason.KSAD_TK_MD5, "");
        String string = uo().getString("url", "");
        this.rq = string;
        com.bytedance.sdk.openadsdk.core.d.xj.u.xj.xj(this.js, string);
        this.ha = this.w.get("is_open_isw", 1);
        String str13 = this.w.get("live_sdk_conf", this.zf);
        if (!TextUtils.isEmpty(str13)) {
            this.t = b.xj(str13);
        }
        this.kd = this.w.get("npth_enable_type", 0);
        this.bh = this.w.get("scheme_get_type", 0);
        this.ho = this.w.get("scheme_get_num", 1);
        this.mq = this.w.get("if_query_all_package", 0);
        this.qe = this.w.get("is_sp_send_meta", true);
        this.ky = c.xj(this.w.get("opt_config", ""));
        this.az = y.xj(this.w.get("kv_config", ""));
        this.nn = this.w.get("is_first_plugin_resources", false);
        this.fs = this.w.get("m_vids_join", 0);
        this.f0if = this.w.get("mini_event_upload_version", 0);
        this.lp = this.w.get("bg_web_readd_t", 3000L);
        this.su = this.w.get("title_priority", 0);
        this.ta = this.w.get("splash_video_opt_enable", 0);
        this.xe = this.w.get("gesture_through_enable", 0);
        this.eb = this.w.get("refresh_req_num", 2);
        this.fh = this.w.get("refresh_max_times", 1);
        this.dj = this.w.get("settings_open", 1);
        this.xl = this.w.get("shake_trigger_control", 0);
        this.hq = this.w.get("preload_switch", false);
        this.py = this.w.get("cache_ana_lru_switch", false);
        this.kf = this.w.get("cache_ana_expire_switch", false);
        this.ob = this.w.get("preload_time_point", 0);
        this.jv = this.w.get("is_adapt_density", false);
        this.ac = this.w.get("app_info_cache_switch", false);
        this.cm = this.w.get("disable_easy_playable", true);
        this.wr = this.w.get("enable_target_34", 1);
        this.kn = this.w.get("enable_xm_market", 1);
        this.vu = this.w.get("disable_repeat_render", true);
        this.vo = this.w.get("status_bar_adapt", 1);
        this.yl = this.w.get("template_pull_timeout", -1);
        this.bi = this.w.get("template_pull_type", 0);
        this.dz = this.w.get("view_check_by_window", false);
        this.ul = this.w.get("shake_twist_bind_show", false);
        this.dx = this.w.get("view_check_by_click", false);
        this.ap = this.w.get("enable", true);
        this.ee = this.w.get("session_enable", false);
        pl(this.w.get("lottie_composition_cache_size", 20));
        com.bytedance.sdk.openadsdk.core.ra.en.hf(this.w);
        aq.hf(this.w);
        com.bytedance.sdk.openadsdk.core.ra.f.xj(this.w);
        yo.hf(this.w);
        ai.xj(this.w);
        com.bytedance.sdk.openadsdk.core.ra.j.xj(this.w);
        String str14 = this.w.get("video_cache_config", "");
        if (!TextUtils.isEmpty(str14)) {
            try {
                JSONObject jSONObject = new JSONObject(str14);
                this.ah = jSONObject;
                com.bykv.vk.openvk.component.video.xj.xj.xj(jSONObject);
            } catch (JSONException e11) {
                pl.xj(e11);
            }
        }
        String str15 = this.w.get("log_rate_conf", "");
        if (!TextUtils.isEmpty(str15)) {
            try {
                this.m = new JSONObject(str15);
            } catch (Exception unused3) {
            }
        }
        try {
            this.eq = this.w.get("ad_slot_conf_block", "");
            JSONObject jSONObject2 = new JSONObject(this.eq);
            if (jSONObject2.length() > 0) {
                this.lv.clear();
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.lv.put(next, jSONObject2.opt(next));
                }
            }
        } catch (Exception unused4) {
        }
        f();
    }

    public boolean xk() {
        return this.kf;
    }

    public String xl() {
        if (TextUtils.isEmpty(this.js)) {
            this.js = uo().getString(TKDownloadReason.KSAD_TK_MD5, "");
        }
        return this.js;
    }

    public JSONObject xv() {
        return this.yt;
    }

    public int xw() {
        return this.ob;
    }

    public void yo() {
        this.zb = "api-access.pangolin-sdk-toutiao-b.com";
    }

    public boolean yq() {
        return this.lt;
    }

    public boolean yt() {
        return this.vw;
    }

    public int yy() {
        if (this.f == Integer.MAX_VALUE) {
            this.f = hf().get("web_upload_send_restowv", 0);
        }
        return this.f;
    }

    public int z() {
        if (this.hf == 10) {
            this.hf = hf().get("pre_fetch_cnt", 10);
        }
        return this.hf;
    }

    public int zb() {
        return com.bytedance.sdk.openadsdk.core.w.kd.xj().d();
    }

    public boolean zd() {
        if (this.xe == Integer.MAX_VALUE) {
            this.xe = hf().get("gesture_through_enable", 0);
        }
        return this.xe == 1;
    }

    public int zf() {
        if (this.kn == Integer.MAX_VALUE) {
            this.kn = hf().get("enable_xm_market", 1);
        }
        return this.kn;
    }

    public String zg() {
        if (TextUtils.isEmpty(this.zd)) {
            this.zd = hf().get("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
        }
        return this.zd;
    }

    public boolean zm() {
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.ai.u) && com.bytedance.sdk.openadsdk.core.ai.u.compareTo(com.bytedance.sdk.openadsdk.core.ai.d) < 0) {
            return false;
        }
        Boolean bool = this.kt;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this.iy == null) {
            this.iy = Boolean.valueOf(hf().get("use_mediation_map", false));
        }
        Boolean bool2 = this.iy;
        this.kt = bool2;
        return bool2.booleanValue();
    }

    private static xj w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("code_id");
        boolean xj = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "enable_bidding_cache", false);
        long xj2 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "bidding_cache_skip_time", 0L);
        boolean xj3 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "enable_bidding_pre_fetch", false);
        int xj4 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "auto_play", 1);
        int xj5 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "voice_control", 1);
        int xj6 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "voice_control", 0);
        int xj7 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "rv_preload", 2);
        int xj8 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "nv_preload", 1);
        int xj9 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "sp_preload", 0);
        int xj10 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "skip_time_displayed", 0);
        int xj11 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "reg_creative_control", 1);
        int xj12 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "rv_skip_time", 0);
        int xj13 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "iv_skip_time", 0);
        int xj14 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "if_show_win", 1);
        int xj15 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "stop_time", TTAdConstant.STYLE_SIZE_RADIO_3_2);
        boolean xj16 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "close_on_click", false);
        int xj17 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "splash_load_type", 2);
        int xj18 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "splash_buffer_time", 100);
        int xj19 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "time_out_control", 2000);
        int xj20 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "time_out_control_type", 0);
        int xj21 = com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "slot_type", -1);
        return xj.xj().xj(optString).d(xj4).tf(!g(xj5) ? 1 : xj5).p(xj7).pl(xj8).g(xj10).am(xj11).c(xj12).y(g(xj6) ? xj6 : 0).qt(xj14).u(xj9).kd(xj15).w(xj19).zg(xj17).e(xj18).f(xj13).w(xj16).yo(xj20).xj(xj2).hf(xj).xj(xj3).hf(xj21).xj(com.bytedance.sdk.openadsdk.core.a.ai.xj(jSONObject, "refresh_rit_sw", 0));
    }

    public int d(String str) {
        return str == null ? TTAdConstant.STYLE_SIZE_RADIO_3_2 : pz.hf().yo(str).am;
    }

    public xj e(String str) {
        if (str == null) {
            return w(new JSONObject());
        }
        xj xjVar = this.j.get(str);
        if (xjVar == null) {
            xjVar = pz(str);
        }
        if (xjVar != null) {
            return xjVar;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code_id", str);
            return w(jSONObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean g() {
        if (this.zg == Integer.MIN_VALUE) {
            this.zg = hf().get("express_gesture_enable", 0);
        }
        return this.zg == 1;
    }

    public boolean jk() {
        if (this.gh == Integer.MAX_VALUE) {
            this.gh = hf().get("adlog_debug", 0);
        }
        return this.gh == 1;
    }

    public boolean pl() {
        if (this.ht == Integer.MIN_VALUE) {
            this.ht = hf().get("enable_zaid", 0);
        }
        return this.ht != 0;
    }

    public xj yo(String str) {
        if (str == null) {
            return w(new JSONObject());
        }
        xj xjVar = this.j.get(str);
        if (xjVar == null) {
            xjVar = ht(str);
        }
        if (xjVar != null) {
            return xjVar;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code_id", str);
            return w(jSONObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private xj ht(String str) {
        String str2;
        com.bytedance.sdk.component.u.hf.w c = c();
        xj xjVar = null;
        try {
            if (c != null) {
                str2 = c.get(jk(str), "");
            } else {
                if (this.ie == null) {
                    this.ie = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext(), kd(), 0);
                }
                str2 = this.ie.getString(jk(str), "");
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            xjVar = w(new JSONObject(str2));
            this.j.put(str, xjVar);
            return xjVar;
        } catch (Throwable th) {
            pl.hf("TTSdkSetting", "buildSlot failed:" + th.getMessage());
            return xjVar;
        }
    }

    private int kd(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("splash_check_type", 1);
        this.vm = optInt;
        if (optInt == 0 || optInt == 1) {
            return optInt;
        }
        return 1;
    }

    private xj pz(String str) {
        xj xjVar = null;
        try {
            wx();
            String string = this.xk.getString(jk(str), null);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            xjVar = w(new JSONObject(string));
            this.j.put(str, xjVar);
            return xjVar;
        } catch (Throwable th) {
            pl.hf("TTSdkSetting", "buildSlot failed:" + th.getMessage());
            return xjVar;
        }
    }

    private boolean ra(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(this.tq)) {
            this.tq = hf().get("app_dl_scheme_list", "");
        }
        if (TextUtils.isEmpty(this.tq)) {
            return false;
        }
        String[] split = this.tq.split(",");
        if (split.length == 0) {
            return false;
        }
        for (String str2 : split) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private void u(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.y = jSONObject.optInt("enable", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("content_type");
            this.c.clear();
            if (optJSONArray != null && optJSONArray.length() != 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        this.c.add(optString);
                    }
                }
            }
            this.f = jSONObject.optInt("send_response_to_webview", 0);
            this.d = jSONObject.optInt("max_report_size_single", 2);
            this.tf = jSONObject.optInt("max_report_size_total", 5);
            this.am = jSONObject.optInt("max_report_times", 0);
            this.f10365pl = jSONObject.optString("report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
            this.g = jSONObject.optInt("storage_type", 0);
            this.p = jSONObject.optInt("report_only_wifi_enable", 0);
            return;
        }
        this.y = 0;
        this.c.clear();
        this.f = 0;
        this.d = 2;
        this.tf = 5;
        this.am = 0;
        this.f10365pl = "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/";
        this.g = 0;
        this.p = 0;
    }

    private void y(JSONObject jSONObject) {
        int length;
        SharedPreferences.Editor editor;
        JSONArray optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return;
        }
        this.j.clear();
        wx();
        com.bytedance.sdk.component.u.hf.w c = c();
        SharedPreferences.Editor editor2 = null;
        if (c == null) {
            if (this.ie == null) {
                this.ie = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext(), kd(), 0);
            }
            editor = this.ie.edit();
        } else {
            editor = null;
        }
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            xj w = w(optJSONObject);
            if (w != null) {
                this.j.put(w.xj, w);
                if (com.bytedance.sdk.openadsdk.core.w.u.xj().c(w.w())) {
                    if (editor2 == null && this.xk != null) {
                        editor2 = this.xk.edit();
                    }
                    if (editor2 != null) {
                        editor2.putString(jk(w.xj), optJSONObject.toString());
                    }
                }
                if (c != null) {
                    c.put(jk(w.xj), optJSONObject.toString());
                } else if (editor != null) {
                    editor.putString(jk(w.xj), optJSONObject.toString());
                }
                com.bytedance.sdk.openadsdk.tools.hf.xj(w.xj, optJSONObject);
            }
        }
        if (editor2 != null) {
            try {
                editor2.commit();
            } catch (Throwable th) {
                pl.hf("TTSdkSetting", "saveSlotConfig failed:" + th.getMessage());
                return;
            }
        }
        if (editor != null) {
            editor.commit();
        }
    }

    public int am(String str) {
        int xj;
        if (this.wf == null) {
            return 5000;
        }
        str.getClass();
        switch (str) {
            case "banner_ad":
                xj = this.wf.xj("banner");
                break;
            case "rewarded_video":
                xj = this.wf.xj("rewarded");
                break;
            case "fullscreen_interstitial_ad":
                xj = this.wf.xj("fullscreen");
                break;
            case "embeded_ad":
                xj = this.wf.xj("feed");
                break;
            case "draw_ad":
                xj = this.wf.xj(MediationConstant.RIT_TYPE_DRAW);
                break;
            default:
                xj = 5000;
                break;
        }
        if (xj <= 0) {
            return 5000;
        }
        return xj;
    }

    public int d(int i) {
        int i2 = e(String.valueOf(i)).yo;
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            return i2;
        }
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.j.kd
    public void hf(final JSONObject jSONObject) {
        this.ut = jSONObject.optString("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        this.he = jSONObject.optString("play_component_ugen_engine_url", "");
        this.zb = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
        this.le = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
        this.ws = jSONObject.optString("xpath");
        this.r = jSONObject.optJSONObject("digest");
        this.b = jSONObject.optLong("data_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("feq_policy");
        kd.hf hfVar = new kd.hf();
        if (optJSONObject != null) {
            hfVar.xj(optJSONObject.optLong(MediationConstant.EXTRA_DURATION) * 1000);
            hfVar.xj(optJSONObject.optInt("max"));
            hfVar.xj((float) optJSONObject.optDouble("agg_multiple"));
        }
        this.k = jSONObject.optInt("vbtt", 5);
        this.da = jSONObject.optInt("fetch_tpl_interval", SdkConfigData.DEFAULT_REQUEST_INTERVAL);
        this.sv = jSONObject.optString("privacy_url", uj);
        this.iy = Boolean.valueOf(jSONObject.optBoolean("use_mediation_map"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("abtest");
        if (optJSONObject2 != null) {
            hfVar.xj(optJSONObject2.optString("version"));
            hfVar.hf(optJSONObject2.optString("param"));
        } else {
            com.bytedance.sdk.openadsdk.core.w.kd.xj().c();
        }
        this.ir = jSONObject.optInt("read_video_from_cache", 1);
        this.qf = jSONObject.optBoolean("enable_bw_screen_detection", false);
        u(jSONObject.optJSONObject("web_upload"));
        JSONObject optJSONObject3 = jSONObject.optJSONObject("log_rate_conf");
        this.m = optJSONObject3;
        if (optJSONObject3 != null) {
            this.db = (float) optJSONObject3.optDouble("global_rate", 1.0d);
            if (this.m.has("call_stack_rate")) {
                this.uf = (float) this.m.optDouble("call_stack_rate");
            } else {
                this.uf = this.db;
            }
        } else {
            this.db = 1.0f;
        }
        this.n = jSONObject.optString("pyload_h5");
        this.yy = ff.xj(jSONObject.optJSONObject("insert_js_config"));
        this.vm = kd(jSONObject);
        pl.u("splashLoad", "setting-》mSplashCheckType=" + this.vm);
        this.dq = jSONObject.optInt("if_both_open", 0);
        this.qd = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
        this.dc = jSONObject.optInt("al", 1);
        this.oa = jSONObject.optInt("max_tpl_cnts", 100);
        com.bytedance.sdk.openadsdk.core.w.w.xj().xj(jSONObject);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject4 != null) {
            this.kc = optJSONObject4.optString("stats_url", "api-access.pangolin-sdk-toutiao1.com");
            this.zd = optJSONObject4.optString("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
            this.mg = optJSONObject4.optBoolean("enable_apm_pv", false);
            this.qi = optJSONObject4.optBoolean("open_single_abi", false);
            this.ez = optJSONObject4.optBoolean("show_callback_mult", false) ? 1 : 0;
            this.i = optJSONObject4.optInt("fetch_tpl_timeout_ctrl", 5000);
            this.ua = optJSONObject4.optInt("interact_show_after_time", 500);
            this.si = optJSONObject4.optInt("fetch_tpl_timeout_ctrl_bad_device", 300);
            this.my = (float) optJSONObject4.optDouble("tpl_render_error_rate_h5", 4.5d);
            this.lm = (float) optJSONObject4.optDouble("tpl_render_error_rate_native", 1.0d);
            this.vi = optJSONObject4.optBoolean("tpl_enable_render_timeout_opt", false);
            String optString = optJSONObject4.optString("tpl_timeout_ctrl");
            if (!TextUtils.isEmpty(optString)) {
                this.wf = v.w(optString);
            }
            this.ey = optJSONObject4.optInt("if_sp_cache", 1);
            hfVar.xj(optJSONObject4.optBoolean("is_spl_cache_remove_change", false));
            this.zg = optJSONObject4.optInt("express_gesture_enable", 0);
            this.yo = optJSONObject4.optInt("enable_download_proto", 1);
            this.e = optJSONObject4.optInt("app_express_gesture_priority", -1);
            this.nt = optJSONObject4.optInt("webview_cache_count", 0);
            this.ic = optJSONObject4.optInt("webview_cache_count_v3", 0);
            this.ci = optJSONObject4.optInt("webview_render_concurrent_count", 2);
            this.zm = optJSONObject4.optString("ad_pkg_info_url", "apps.bytesfield.com");
            this.nu = optJSONObject4.optString("splash_close_text", "跳过");
            this.z = optJSONObject4.optInt("network_module", 1);
            hfVar.hf(optJSONObject4.optInt("cypher_version", 40001));
            com.bytedance.sdk.component.hf.xj.xj.xj.xj().xj(this.z != 2);
            this.gh = optJSONObject4.optInt("adlog_debug", 0);
            this.lw = optJSONObject4.optInt("adlog_batch", 10);
            this.bl = optJSONObject4.optLong("adlog_interval", PushUIConfig.dismissTime);
            this.qt = optJSONObject4.optInt("enable_kite", 0);
            this.wa = optJSONObject4.optInt("adlog_exception_batch", 100);
            this.op = optJSONObject4.optInt("adlog_monitor", 1);
            this.pz = optJSONObject4.optInt("enable_ttvideo", -1);
            this.ht = optJSONObject4.optInt("enable_zaid", 0);
            this.v = optJSONObject4.optInt("enable_cdn_opt", 0);
            this.jk = optJSONObject4.optInt("download_button_effect", 0);
            this.cy = optJSONObject4.optLong("ext_use_type", this.ss);
            this.gy = optJSONObject4.optInt("enable_glgpu", 0);
            this.gj = optJSONObject4.optInt("enable_dl_ext", this.nb);
            this.f10364io = optJSONObject4.optInt("download_receiver_enable", 1);
            this.xj = optJSONObject4.optInt("launch_strategy", 0);
            this.dk = optJSONObject4.optInt("dl_popup_duration", 1000);
            this.et = optJSONObject4.optInt("opt_show_check", 0);
            this.xl = optJSONObject4.optInt("shake_trigger_control", 0);
            this.vl = optJSONObject4.optJSONObject("pitaya_general_settings");
            this.h = optJSONObject4.optJSONObject("http_drop");
            this.ne = optJSONObject4.optInt("stats_batch", 5);
            this.wx = optJSONObject4.optJSONObject("live_stream_cof");
            this.yt = optJSONObject4.optJSONObject("dl_notification");
            this.vh = optJSONObject4.optInt("disable_show_url", 0);
            this.uh = optJSONObject4.optJSONObject("sensor_direction");
            this.jf = optJSONObject4.optJSONObject("pitaya_business_conf");
            hfVar.w(optJSONObject4.optInt("spl_cache_conf", 14));
            hfVar.u(optJSONObject4.optInt("spl_thread_conf", 1));
            hfVar.kd(optJSONObject4.optInt("spl_common_conf", 0));
            hfVar.y(optJSONObject4.optInt("spl_cache_expired", 0));
            hfVar.w(optJSONObject4.optString("drop_cache_black_conf", ""));
            hfVar.xj(this.jf);
            hfVar.c(optJSONObject4.optInt("splash_render_timeout_backup", 100));
            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("client_intelligence_conf");
            if (optJSONObject5 != null) {
                this.rs = optJSONObject5.optBoolean("net_rating");
                this.og = optJSONObject5.optJSONObject("net_rating_config");
                this.yq = optJSONObject5.optBoolean("device_rating");
            }
            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("bytebench_rating");
            if (optJSONObject6 != null) {
                this.lt = optJSONObject6.optBoolean("enable");
                this.cu = (float) optJSONObject6.optDouble("mid_value");
                this.no = (float) optJSONObject6.optDouble("low_value");
            }
            this.ap = true;
            this.oz.add(1);
            this.oz.add(3);
            this.oz.add(5);
            this.ee = true;
            JSONObject optJSONObject7 = optJSONObject4.optJSONObject("realtime_feature");
            if (optJSONObject7 != null) {
                this.ap = optJSONObject7.optBoolean("enable", true);
                JSONArray optJSONArray = optJSONObject7.optJSONArray("time_window");
                this.oz.clear();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.oz.add(Integer.valueOf(optJSONArray.optInt(i)));
                    }
                } else {
                    this.oz.add(1);
                    this.oz.add(3);
                    this.oz.add(5);
                }
                this.ee = optJSONObject7.optBoolean("session_enable", false);
            }
            this.ft = optJSONObject4.optInt("event_switch", this.se);
            this.xv = optJSONObject4.optInt("switch_audio_focus", 0);
            this.ra = optJSONObject4.optString("apm_pv_config", "");
            this.kr = optJSONObject4.optInt("splash_card_show_max_count", 3);
            this.hf = optJSONObject4.optInt("pre_fetch_cnt", 10);
            this.pu = optJSONObject4.optInt("gnd_prefetch_cache_size", 5);
            this.pn = optJSONObject4.optLong("gnd_prefetch_cache_ttl", 0L);
            this.hl = com.bytedance.sdk.openadsdk.core.e.xj.xj.xj(optJSONObject4.optJSONObject("white_check_config"));
            this.bh = optJSONObject4.optInt("scheme_get_type", 0);
            this.ho = optJSONObject4.optInt("scheme_get_num", 1);
            this.mq = optJSONObject4.optInt("if_query_all_package", 0);
            this.x = com.bytedance.sdk.openadsdk.core.c.hf.xj(optJSONObject4.optJSONObject("clog_config"));
            this.ai = com.bytedance.sdk.openadsdk.core.dislike.u.xj(optJSONObject4.optJSONObject("oncall_upload"));
            this.q = optJSONObject4.optBoolean("check_live_room", false);
            JSONObject optJSONObject8 = optJSONObject4.optJSONObject("pglam");
            if (optJSONObject8 != null) {
                this.jq = optJSONObject8.optInt("pglam_main_enable", 0);
                this.jb = optJSONObject8.optInt("pglam_dns_check_enable", 0);
                this.ka = optJSONObject8.optString("pglam_clazz_check", "");
            }
            this.rx = optJSONObject4.optInt("ud_enable", 1);
            this.ew = optJSONObject4.optJSONObject("thread_config");
            com.bytedance.sdk.openadsdk.core.en.xj.hf();
            this.hx = optJSONObject4.optBoolean("new_app_list", false);
            this.it = hf.xj(optJSONObject4.optJSONObject("app_live_config"));
            this.ct = optJSONObject4.optJSONObject("plugin_update_state");
            this.co = optJSONObject4.optJSONObject("antispam_autoclick_detect");
            com.bytedance.sdk.component.u.xj hf = dk.hf();
            if (hf != null) {
                hf.updateHARSettings(this.co);
            }
            this.ha = optJSONObject4.optInt("is_open_isw", 1);
            this.qa = optJSONObject4.optInt("is_kv_cache_type", 0);
            this.fc = optJSONObject4.optInt("kv_init_type", 0);
            this.uo = optJSONObject4.optInt("open_dl_type", 0);
            this.tq = optJSONObject4.optString("app_dl_scheme_list", "");
            int optInt = optJSONObject4.optInt("lp_url_sw", 0);
            this.oe = optInt;
            if (optInt == 1) {
                this.ps = optJSONObject4.optString("lp_list", "");
            }
            JSONObject optJSONObject9 = optJSONObject4.optJSONObject("uchain");
            if (optJSONObject9 != null) {
                String optString2 = optJSONObject9.optString(TKDownloadReason.KSAD_TK_MD5, "");
                String optString3 = optJSONObject9.optString("url", "");
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    this.js = optString2;
                    this.rq = optString3;
                }
            }
            com.bytedance.sdk.openadsdk.core.d.xj.u.xj.xj(this.js, this.rq);
            this.fs = optJSONObject4.optInt("m_vids_join", 0);
            this.f0if = optJSONObject4.optInt("mini_event_upload_version", 0);
            this.lp = optJSONObject4.optLong("bg_web_readd_t", 3000L);
            this.su = optJSONObject4.optInt("title_priority", 0);
            this.ta = optJSONObject4.optInt("splash_video_opt_enable", 0);
            this.xe = optJSONObject4.optInt("gesture_through_enable", 0);
            this.eb = optJSONObject4.optInt("refresh_req_num", 2);
            this.fh = optJSONObject4.optInt("refresh_max_times", 1);
            uo().edit().putBoolean("_use_pl_", optJSONObject4.optBoolean("_use_pl_", false)).apply();
            this.kd = optJSONObject4.optInt("npth_enable_type", 0);
            this.qe = optJSONObject4.optBoolean("is_sp_send_meta", true);
            this.ky = c.xj(optJSONObject4.optString("opt_config"));
            this.az = y.xj(optJSONObject4.optString("kv_config"));
            this.hq = optJSONObject4.optBoolean("preload_switch", false);
            this.py = optJSONObject4.optBoolean("cache_ana_lru_switch", false);
            this.kf = optJSONObject4.optBoolean("cache_ana_expire_switch", false);
            this.ob = optJSONObject4.optInt("preload_time_point", 0);
            this.jv = optJSONObject4.optBoolean("is_adapt_density", false);
            this.cm = optJSONObject4.optBoolean("disable_easy_playable", true);
            this.wr = optJSONObject4.optInt("enable_target_34", 1);
            this.kn = optJSONObject4.optInt("enable_xm_market", 1);
            this.ac = optJSONObject4.optBoolean("app_info_cache_switch", false);
            this.vu = optJSONObject4.optBoolean("disable_repeat_render", true);
            this.vo = optJSONObject4.optInt("status_bar_adapt", 1);
            this.yl = optJSONObject4.optInt("template_pull_timeout", -1);
            this.bi = optJSONObject4.optInt("template_pull_type", 0);
            JSONObject optJSONObject10 = optJSONObject4.optJSONObject("view_report_opt");
            if (optJSONObject10 != null) {
                this.dz = optJSONObject10.optBoolean("view_check_by_window", false);
                this.ul = optJSONObject10.optBoolean("shake_twist_bind_show", false);
                this.dx = optJSONObject10.optBoolean("view_check_by_click", false);
            }
            com.bytedance.sdk.openadsdk.core.a.ff.xj();
            this.nn = optJSONObject4.optBoolean("is_first_plugin_resources", false);
            int optInt2 = optJSONObject4.optInt("open_webview_count");
            MultiWebview.setMaxWebViewCount(optInt2);
            hf().put("open_webview_count", optInt2);
            new com.bytedance.sdk.openadsdk.core.j.xj.hf().xj(optJSONObject4);
            int optInt3 = optJSONObject4.optInt("lottie_composition_cache_size", 20);
            pl(optInt3);
            hf().put("lottie_composition_cache_size", optInt3);
        }
        JSONObject optJSONObject11 = jSONObject.optJSONObject("download_config");
        if (optJSONObject11 != null) {
            hfVar.f(optJSONObject11.optInt("if_storage_internal", 1));
        }
        hfVar.xj();
        com.bytedance.sdk.openadsdk.core.ra.en.hf(jSONObject);
        aq.xj(jSONObject);
        com.bytedance.sdk.openadsdk.core.ra.j.xj(jSONObject);
        com.bytedance.sdk.openadsdk.core.ra.f.xj(jSONObject);
        yo.xj(jSONObject);
        new com.bytedance.sdk.openadsdk.core.u.hf("h5_resource_sync").hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.tf.1
            @Override // java.lang.Runnable
            public void run() {
                ai.xj(jSONObject, new ai.xj() { // from class: com.bytedance.sdk.openadsdk.core.j.tf.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.ra.ai.xj
                    public void hf(ai.w wVar) {
                        ai.hf(tf.this.w, wVar);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ra.ai.xj
                    public void xj(ai.w wVar) {
                        ai.xj(tf.this.w, wVar);
                    }
                });
            }
        });
        cy.xj(jSONObject);
        this.wn = System.currentTimeMillis();
        this.aq.clear();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("spam_app_list");
        if (optJSONArray2 != null) {
            int length = optJSONArray2.length();
            for (int i2 = 0; i2 < length; i2++) {
                String optString4 = optJSONArray2.optString(i2);
                if (!TextUtils.isEmpty(optString4)) {
                    this.aq.add(optString4);
                }
            }
        }
        synchronized (this.tu) {
            try {
                this.tu.clear();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("scheme_check_list");
                if (optJSONArray3 != null) {
                    int length2 = optJSONArray3.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        String optString5 = optJSONArray3.optString(i3);
                        if (!TextUtils.isEmpty(optString5)) {
                            this.tu.add(optString5);
                        }
                    }
                }
            } finally {
            }
        }
        synchronized (this.s) {
            try {
                this.s.clear();
                JSONArray optJSONArray4 = jSONObject.optJSONArray("top_scheme_list");
                if (optJSONArray4 != null) {
                    int length3 = optJSONArray4.length();
                    for (int i4 = 0; i4 < length3; i4++) {
                        String optString6 = optJSONArray4.optString(i4);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.s.add(optString6);
                        }
                    }
                }
            } finally {
            }
        }
        JSONObject optJSONObject12 = jSONObject.optJSONObject("download_sdk_config");
        if (optJSONObject12 != null) {
            this.tj = optJSONObject12.toString();
        } else {
            this.tj = "";
        }
        this.eu = optJSONObject12;
        try {
            JSONObject optJSONObject13 = jSONObject.optJSONObject("ad_slot_conf_block");
            if (optJSONObject13 != null) {
                this.eq = optJSONObject13.toString();
                this.lv.clear();
                Iterator<String> keys = optJSONObject13.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.lv.put(next, optJSONObject13.opt(next));
                }
            }
        } catch (Exception unused) {
        }
        if (com.bytedance.sdk.openadsdk.core.w.w.xj().d()) {
            y(jSONObject);
        } else if (!com.bytedance.sdk.openadsdk.core.f.zg().z()) {
            y(jSONObject);
        }
        com.bytedance.sdk.openadsdk.tools.hf.w(15, this.zb);
        if (com.bytedance.sdk.openadsdk.tools.hf.xj()) {
            JSONObject optJSONObject14 = optJSONObject4 != null ? optJSONObject4.optJSONObject("test_tool_urls") : null;
            if (optJSONObject14 != null) {
                if (optJSONObject14.has("qa_tool_host")) {
                    try {
                        String host = new URL(optJSONObject14.optString("qa_tool_host")).getHost();
                        if (!TextUtils.isEmpty(host)) {
                            com.bytedance.sdk.openadsdk.core.f.zg().p(host);
                        }
                    } catch (MalformedURLException unused2) {
                    }
                }
                if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.f.zg().gh())) {
                    if (optJSONObject14.has("ad_preview_url")) {
                        com.bytedance.sdk.openadsdk.core.f.zg().pl(optJSONObject14.optString("ad_preview_url"));
                    }
                    if (optJSONObject14.has("basic_info_url")) {
                        com.bytedance.sdk.openadsdk.core.f.zg().g(optJSONObject14.optString("basic_info_url"));
                    }
                }
            }
        }
        this.lx = jSONObject.optInt("pre_cache_brand_count", this.lx);
        JSONObject optJSONObject15 = jSONObject.optJSONObject("video_cache_config");
        this.ah = optJSONObject15;
        if (optJSONObject15 != null) {
            com.bykv.vk.openvk.component.video.xj.xj.xj(optJSONObject15);
        }
        f();
        nn();
        com.bytedance.sdk.openadsdk.core.c.w.xj(this.x);
        qe();
    }

    public boolean tf(String str) {
        try {
            xj yo = pz.hf().yo(String.valueOf(str));
            if (yo != null) {
                return yo.e != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean zg(String str) {
        return yo(str).hf() == 1;
    }

    public boolean c(String str) {
        return str == null || pz.hf().yo(str).f10366pl == 1;
    }

    public int g(String str) {
        int hf;
        if (this.wf == null) {
            return 5000;
        }
        str.getClass();
        switch (str) {
            case "banner_ad":
                hf = this.wf.hf("banner");
                break;
            case "rewarded_video":
                hf = this.wf.hf("rewarded");
                break;
            case "fullscreen_interstitial_ad":
                hf = this.wf.hf("fullscreen");
                break;
            case "embeded_ad":
                hf = this.wf.hf("feed");
                break;
            case "draw_ad":
                hf = this.wf.hf(MediationConstant.RIT_TYPE_DRAW);
                break;
            default:
                hf = 5000;
                break;
        }
        if (hf <= 0) {
            return 5000;
        }
        return hf;
    }

    public boolean kd(String str) {
        return yo(String.valueOf(str)).y == 1;
    }

    public boolean p(String str) {
        try {
            xj e = pz.hf().e(String.valueOf(str));
            if (e != null) {
                return e.e != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public int pl(String str) {
        return yo(str).f;
    }

    public int qt(String str) {
        return e(String.valueOf(str)).jk;
    }

    public int tf(int i) {
        return e(String.valueOf(i)).v;
    }

    public boolean v(String str) {
        if (TextUtils.isEmpty(str) || str.equals(Constants.HTTP) || str.equals("https")) {
            return false;
        }
        if (this.uo == 0) {
            this.uo = hf().get("open_dl_type", 0);
        }
        int i = this.uo;
        if (i == 0) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        return ra(str);
    }

    public int c(int i) {
        int i2 = yo(String.valueOf(i)).hf;
        if (i2 <= 0 || i2 > 5) {
            return 1;
        }
        return i2;
    }

    public int kd(int i) {
        return Math.max(yo(String.valueOf(i)).d, 0);
    }

    public boolean p(int i) {
        return yo(String.valueOf(i)).zg;
    }

    public boolean f(String str) {
        return str == null || pz.hf().e(str).g == 0;
    }

    public int f(int i) {
        return yo(String.valueOf(i)).c;
    }

    public int y(String str) {
        return e(str).qt;
    }

    public int y(int i) {
        return Math.max(yo(String.valueOf(i)).tf, 0);
    }

    public boolean u(int i) {
        return yo(String.valueOf(i)).w == 1;
    }

    public boolean u(String str) {
        int i = pz.hf().yo(String.valueOf(str)).kd;
        if (i != 1) {
            return i == 2 && am.w(pz.getContext()) != 0;
        }
        return am.u(pz.getContext());
    }

    public long w(String str) {
        return yo(str).ra;
    }

    public void w(int i) {
        if (this.dj != i) {
            this.dj = i;
            hf().put("settings_open", this.dj);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.j.kd
    public void xj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject2 != null) {
            this.o = optJSONObject2.optBoolean("can_init_live", true);
        }
        if (!this.o || (optJSONObject = jSONObject.optJSONObject("live_sdk_conf")) == null) {
            return;
        }
        this.t = b.xj(optJSONObject);
        com.bytedance.sdk.openadsdk.core.live.hf.xj().hf();
    }

    public <T> T xj(String str, T t) {
        try {
            if (this.lv.containsKey(str)) {
                T t2 = (T) this.lv.get(str);
                if (t2 != null) {
                    return t2;
                }
            }
        } catch (Exception unused) {
        }
        return t;
    }

    public void xj(int i) {
        this.qd = i;
    }

    public boolean xj(String str) {
        return yo(str).pz;
    }

    public boolean xj(ws wsVar, int i) {
        xj yo = pz.hf().yo(String.valueOf(i));
        return com.bytedance.sdk.openadsdk.core.component.reward.u.u.xj(wsVar) == 4 ? yo.w == 1 : yo.p == 1;
    }

    public int xj(String str, int i) {
        if (i != 0 && i != 9) {
            return g(str);
        }
        return am(str);
    }

    public boolean hf(int i) {
        return d(i) != 0;
    }

    public boolean hf(String str) {
        return yo(str).ht;
    }
}
