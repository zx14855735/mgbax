package com.bytedance.msdk.core.am;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.api.u.zg;
import com.bytedance.msdk.core.f.am;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.core.tf.u;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.dk;
import com.bytedance.msdk.f.l;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.msdk.y.hf.kd;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements xj {
    private String b;
    private String c;
    private String d;
    private int dc;
    private long e;
    private int eu;
    private String f;
    private int g;
    private com.bytedance.msdk.core.y.hf gh;
    private long kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10124pl;
    private int q;
    private int r;
    private int tf;
    private com.bytedance.msdk.core.hf.hf tj;
    private long u;
    private String w;
    private boolean wa;
    private com.bytedance.msdk.core.w.hf wn;
    private int ws;
    private String y;
    private long yo;
    private int xj = 259200000;
    private final List<Object> hf = new CopyOnWriteArrayList();
    private String am = null;
    private int qt = 0;
    private String zg = "log-api.pangolin-sdk-toutiao.com/service/2/app_log/";
    private int v = Integer.MAX_VALUE;
    private final List<zg> jk = new CopyOnWriteArrayList();
    private Map<String, Boolean> pz = new HashMap();
    private final AtomicBoolean ht = new AtomicBoolean(false);
    private final AtomicBoolean ra = new AtomicBoolean(false);
    private int dk = 0;
    private Map<String, String> et = new ConcurrentHashMap();

    /* renamed from: io, reason: collision with root package name */
    private Map<String, List<String>> f10123io = new ConcurrentHashMap();
    private double x = 0.0d;
    private boolean ai = false;
    private Map<String, com.bytedance.msdk.core.tf.w> z = new ConcurrentHashMap();
    private int j = 0;
    private final Map<String, List<com.bytedance.msdk.core.tf.w>> en = new ConcurrentHashMap();
    private final Map<String, u> l = new ConcurrentHashMap();
    private final Map<String, Integer> ff = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Integer> f10122a = new ConcurrentHashMap();
    private int wo = 0;
    private int n = 0;
    private int yy = 0;
    private int hl = 0;
    private int vm = 0;
    private int aq = 0;
    private int tu = 0;
    private boolean s = false;
    private boolean dq = false;
    private boolean qd = false;
    private boolean bl = false;
    private int lw = 0;

    private boolean gh() {
        Boolean bool = this.pz.get("active_control");
        return bool == null || !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op() {
        com.bytedance.msdk.core.p.xj.xj().kd();
        if (q()) {
            Iterator<zg> it = this.jk.iterator();
            while (it.hasNext()) {
                it.next().xj();
            }
            this.jk.clear();
        }
    }

    public Map<String, Integer> aq() {
        return this.ff;
    }

    public com.bytedance.msdk.core.hf.hf b() {
        return this.tj;
    }

    public boolean bl() {
        return this.hl == 1 && this.vm == 1;
    }

    public int dc() {
        return this.xj;
    }

    public int dq() {
        return this.yy;
    }

    public boolean eu() {
        return this.q == 1;
    }

    public String hl() {
        return this.b;
    }

    public boolean lw() {
        return this.hl == 1 && this.vm == 2;
    }

    public Map<String, com.bytedance.msdk.core.tf.w> n() {
        return this.z;
    }

    public boolean qd() {
        com.bytedance.msdk.xj.kd.w.hf("TMe", "enable_bid_result_return = " + this.hl);
        com.bytedance.msdk.xj.kd.w.hf("TMe", "enable_bid_result_return_for_baidu = " + this.vm);
        return bl() || lw();
    }

    public boolean r() {
        return this.dc == 1;
    }

    public int s() {
        return this.n;
    }

    public int tj() {
        return this.q;
    }

    public Map<String, Integer> tu() {
        return this.f10122a;
    }

    public boolean vm() {
        return this.j == 1;
    }

    public boolean wa() {
        com.bytedance.msdk.xj.kd.w.hf("TMe", "enable_bid_result_return = " + this.hl);
        com.bytedance.msdk.xj.kd.w.hf("TMe", "enable_bid_result_return_for_ks = " + this.aq);
        return this.hl == 1 && this.aq == 1;
    }

    public int wn() {
        com.bytedance.msdk.core.hf.hf hfVar = this.tj;
        if (hfVar != null) {
            return hfVar.xj();
        }
        return 0;
    }

    public boolean wo() {
        return this.eu == 1;
    }

    public com.bytedance.msdk.core.w.hf ws() {
        if (r()) {
            return this.wn;
        }
        return null;
    }

    public boolean yy() {
        return this.r == 1;
    }

    private void p(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f10122a.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.f10122a.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    private void tf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.ff.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.ff.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    public boolean a() {
        return this.ws == 1;
    }

    public boolean ai() {
        return (com.bytedance.msdk.c.xj.w.xj().w() || com.bytedance.msdk.c.xj.hf.xj().u()) ? false : true;
    }

    public boolean am() {
        if (!gh()) {
            return false;
        }
        Boolean bool = this.pz.get("ad_event_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean c() {
        return this.ht.get();
    }

    public String d() {
        return this.d;
    }

    public boolean dk() {
        try {
            return Integer.valueOf(this.p).intValue() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean e() {
        if (!gh()) {
            return false;
        }
        Boolean bool = this.pz.get("type_interactionfull_control");
        return bool == null || !bool.booleanValue();
    }

    public Map<String, String> en() {
        return this.et;
    }

    public boolean et() {
        return Integer.valueOf(this.p).intValue() > 1;
    }

    public String f() {
        return this.f;
    }

    public double ff() {
        return this.x;
    }

    public String g() {
        return this.am;
    }

    public boolean hf() {
        return this.s;
    }

    public boolean ht() {
        if (!gh()) {
            return false;
        }
        Boolean bool = this.pz.get("type_native_control");
        return bool == null || !bool.booleanValue();
    }

    public int io() {
        return com.bytedance.msdk.c.xj.xj.xj().hf();
    }

    public boolean j() {
        return this.dk == 1;
    }

    public boolean jk() {
        if (!gh()) {
            return false;
        }
        Boolean bool = this.pz.get("type_reward_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean kd() {
        return this.bl;
    }

    public Map<String, List<String>> l() {
        return this.f10123io;
    }

    public boolean pl() {
        return this.g == 1;
    }

    public boolean pz() {
        if (!gh()) {
            return false;
        }
        Boolean bool = this.pz.get("type_full_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean q() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.xj.p().pl())) {
            return false;
        }
        com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit: " + c());
        if (com.bytedance.msdk.c.xj.w.xj().w() || !c()) {
            com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 2");
            return false;
        }
        com.bytedance.msdk.xj.kd.w.hf("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 1");
        return true;
    }

    public boolean qt() {
        if (!gh()) {
            return false;
        }
        Boolean bool = this.pz.get("type_banner_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean ra() {
        return this.tf > 0;
    }

    public boolean u() {
        return this.qd;
    }

    public boolean v() {
        if (!gh()) {
            return false;
        }
        Boolean bool = this.pz.get("type_feed_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean w() {
        return this.dq;
    }

    public long x() {
        return com.bytedance.msdk.c.xj.xj.xj().w();
    }

    public int xj() {
        return this.tu;
    }

    public boolean y() {
        return this.lw == 1;
    }

    public boolean yo() {
        if (!gh()) {
            return false;
        }
        Boolean bool = this.pz.get("type_splash_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean z() {
        if (this.v == Integer.MAX_VALUE) {
            this.v = 1;
        }
        return this.v == 1;
    }

    public boolean zg() {
        if (!gh()) {
            return false;
        }
        Boolean bool = this.pz.get("type_interaction_control");
        return bool == null || !bool.booleanValue();
    }

    private void c(String str) {
        try {
            com.bytedance.msdk.core.admanager.reward.rewardagain.w.xj(new JSONArray(str));
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    private String d(JSONObject jSONObject) {
        this.pz.clear();
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.optBoolean("ad_event_control")) {
                this.pz.put("ad_event_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_banner_control")) {
                this.pz.put("type_banner_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interaction_control")) {
                this.pz.put("type_interaction_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interactionfull_control")) {
                this.pz.put("type_interactionfull_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_splash_control")) {
                this.pz.put("type_splash_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_feed_control")) {
                this.pz.put("type_feed_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_reward_control")) {
                this.pz.put("type_reward_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_full_control")) {
                this.pz.put("type_full_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_native_control")) {
                this.pz.put("type_native_control", Boolean.TRUE);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private void f(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(new JSONObject(str).optString("app_ab_params")).optJSONObject("mediation_settings");
            if (optJSONObject != null) {
                this.wo = optJSONObject.optInt("ad_request_optmize");
                this.s = optJSONObject.optInt("applog_cypher") == 2;
                this.dq = optJSONObject.optInt("reward_cypher") == 2;
                this.qd = optJSONObject.optInt("config_cypher") == 2;
                this.bl = optJSONObject.optInt("exchange_cypher") == 2;
            }
        } catch (Throwable unused) {
        }
    }

    private String kd(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.z.put(next, com.bytedance.msdk.core.tf.w.xj(next, jSONObject.optJSONObject(next)));
        }
        return jSONObject.toString();
    }

    private String u(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(com.bytedance.msdk.core.tf.w.xj(next, jSONArray.optJSONObject(i)));
                        }
                        this.en.put(next, arrayList);
                    }
                } catch (Exception e) {
                    pl.xj(e);
                }
            }
            return jSONObject.toString();
        }
        return "";
    }

    private String y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.g = jSONObject.optInt("fetch_ad_type", 0);
        return jSONObject.toString();
    }

    public void hf(boolean z) {
        this.qd = z;
    }

    public boolean w(String str) {
        return com.bytedance.msdk.c.xj.hf.xj().hf(str);
    }

    public com.bytedance.msdk.core.tf.hf xj(String str, int i, int i2) {
        return com.bytedance.msdk.c.xj.w.xj().xj(str, i, i2);
    }

    private String w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.wn = new com.bytedance.msdk.core.w.hf(jSONObject);
        return jSONObject.toString();
    }

    public com.bytedance.msdk.core.tf.xj hf(String str) {
        return com.bytedance.msdk.c.xj.hf.xj().xj(str);
    }

    public long xj(int i, String str) {
        com.bytedance.msdk.core.tf.hf xj = xj(str, i, 101);
        if (xj != null) {
            return xj.ws();
        }
        return 3000L;
    }

    private String hf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.tj = new com.bytedance.msdk.core.hf.hf(jSONObject);
        return jSONObject.toString();
    }

    public List<com.bytedance.msdk.core.tf.w> y(String str) {
        return this.en.get(str);
    }

    private void c(JSONObject jSONObject) {
        this.et.clear();
        this.dk = 0;
        if (jSONObject == null) {
            return;
        }
        this.dk = jSONObject.optInt("if_sample", 0);
        JSONObject optJSONObject = jSONObject.optJSONObject("call_stack_path");
        if (optJSONObject != null) {
            try {
                Iterator<String> keys = optJSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = optJSONObject.optString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                            this.et.put(next, optString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private String w(JSONArray jSONArray) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (jSONArray != null) {
            ConcurrentHashMap<String, List<com.bytedance.msdk.core.f.hf>> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(MediationConstant.EXTRA_ADN_NAME);
                    if (!TextUtils.isEmpty(optString) && (optJSONArray = optJSONObject.optJSONArray("break_request_error_code")) != null && (optJSONArray2 = optJSONObject.optJSONArray("rit_list")) != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList.add(optJSONArray.optString(i2));
                        }
                        com.bytedance.msdk.core.f.hf hfVar = new com.bytedance.msdk.core.f.hf();
                        hfVar.xj(optJSONObject.optLong("break_request_duration"));
                        hfVar.xj(arrayList);
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            arrayList2.add(optJSONArray2.optString(i3));
                        }
                        hfVar.hf(arrayList2);
                        List<com.bytedance.msdk.core.f.hf> list = concurrentHashMap.get(optString);
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(hfVar);
                        concurrentHashMap.put(optString, list);
                    }
                }
            }
            am.xj().xj(concurrentHashMap);
            return jSONArray.toString();
        }
        am.xj().xj(null);
        return null;
    }

    public com.bytedance.msdk.core.tf.xj xj(String str) {
        return com.bytedance.msdk.c.xj.hf.xj().xj(str);
    }

    public boolean hf(String str, int i) {
        return (com.bytedance.msdk.c.xj.hf.xj().u() || com.bytedance.msdk.c.xj.w.xj().w() || com.bytedance.msdk.c.xj.w.xj().xj(str, i, 101) == null) ? false : true;
    }

    public boolean xj(String str, String str2, int i) {
        List<tf> yy;
        com.bytedance.msdk.core.tf.hf xj = com.bytedance.msdk.c.xj.w.xj().xj(str, i, 101);
        if (xj == null || (yy = xj.yy()) == null) {
            return false;
        }
        for (tf tfVar : yy) {
            if (tfVar != null && TextUtils.equals(tfVar.yo(), str2)) {
                return tfVar.r();
            }
        }
        return false;
    }

    public String p() {
        return this.zg;
    }

    public String tf() {
        if (this.w == null) {
            this.w = com.bytedance.msdk.c.xj.xj().hf(f.c);
        }
        return this.w;
    }

    private String hf(JSONArray jSONArray) {
        JSONArray optJSONArray;
        if (jSONArray != null) {
            ConcurrentHashMap<String, com.bytedance.msdk.core.f.hf> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("break_request_error_code")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        arrayList.add(optJSONArray.optString(i2));
                    }
                    com.bytedance.msdk.core.f.hf hfVar = new com.bytedance.msdk.core.f.hf();
                    hfVar.xj(optJSONObject.optLong("break_request_duration"));
                    hfVar.xj(arrayList);
                    concurrentHashMap.put(optJSONObject.optString(MediationConstant.EXTRA_ADN_NAME), hfVar);
                }
            }
            com.bytedance.msdk.core.f.w.xj().xj(concurrentHashMap);
            return jSONArray.toString();
        }
        com.bytedance.msdk.core.f.w.xj().xj(null);
        return null;
    }

    public u kd(String str) {
        return this.l.get(str);
    }

    private void f(JSONObject jSONObject) {
        this.f10123io.clear();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        ArrayList arrayList = new ArrayList();
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                if (optJSONArray.get(i) != null) {
                                    arrayList.add(optJSONArray.get(i).toString());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(next) && !arrayList.isEmpty()) {
                            this.f10123io.put(next, arrayList);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean xj(String str, int i) {
        com.bytedance.msdk.core.tf.hf xj;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.bytedance.msdk.c.xj.w.xj().w() || (xj = com.bytedance.msdk.c.xj.w.xj().xj(str, i, 101)) == null || xj.a() == i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.bytedance.msdk.core.y.hf, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v71 */
    @Override // com.bytedance.msdk.core.am.xj
    public void xj(JSONObject jSONObject, final boolean z) {
        ?? r4;
        if (jSONObject == null) {
            return;
        }
        boolean z2 = false;
        try {
            String optString = jSONObject.optString("app_abtest");
            this.am = optString;
            f(optString);
            this.tu = jSONObject.optInt("is_trusteeship_monetize");
            this.lw = jSONObject.optInt("share_cache_enable");
            this.w = jSONObject.optString(f.c);
            this.u = jSONObject.optLong("max_age");
            this.kd = System.currentTimeMillis() + this.u;
            this.y = jSONObject.optString("ab_version");
            this.c = jSONObject.optString("ab_params");
            this.f = jSONObject.optString("country");
            this.d = jSONObject.optString("transparent_params");
            this.q = jSONObject.optInt("if_test");
            this.tf = jSONObject.optInt("if_get_detail_return");
            this.p = jSONObject.optString("ecpm_precision_level");
            this.f10124pl = jSONObject.optString("fetch_primerit_level");
            final String optString2 = jSONObject.optString("url");
            this.qt = jSONObject.optInt("innerLog", 0);
            this.zg = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.e = jSONObject.optLong("break_request_times", 0L);
            this.yo = jSONObject.optLong("break_request_hold_time", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            this.r = jSONObject.optInt("ex_info", 0);
            this.b = jSONObject.optString("ex_");
            this.j = jSONObject.optInt("if_enable_label", 0);
            this.xj = jSONObject.optInt("ecpm_ttl", 259200000);
            int optInt = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
            this.v = optInt;
            if (optInt != 0 && optInt != 1) {
                this.v = 1;
            }
            this.x = jSONObject.optDouble("custom_adn_sample_ratio", 0.0d);
            int optInt2 = jSONObject.optInt("enable_label_return", 0);
            this.ws = optInt2;
            if (optInt2 != 0 && optInt2 != 1) {
                this.ws = 0;
            }
            this.eu = jSONObject.optInt("dynamic_policy_enable", 0);
            com.bytedance.msdk.xj.kd.w.hf("DynamicPolicy", "mDynamicPolicyEnable=" + this.eu);
            int i = this.eu;
            if (i != 0 && i != 1) {
                this.eu = 0;
            }
            int i2 = this.n;
            int i3 = this.yy;
            JSONObject optJSONObject = jSONObject.optJSONObject("p_c");
            if (optJSONObject != null) {
                this.n = optJSONObject.optInt("l_p_a", 0);
                this.yy = optJSONObject.optInt("l_p_r", 0);
            } else {
                this.n = 0;
                this.yy = 0;
            }
            if (i2 != this.n || i3 != this.yy) {
                kd.xj();
            }
            com.bytedance.msdk.core.c.xj.xj().xj(this.e, this.yo);
            this.hl = jSONObject.optInt("enable_bid_result_return", 0);
            this.vm = jSONObject.optInt("enable_bid_result_return_for_baidu", 0);
            this.aq = jSONObject.optInt("enable_bid_result_return_for_ks", 0);
            final JSONObject optJSONObject2 = jSONObject.optJSONObject("supervisor_feature");
            if (optJSONObject2 != null) {
                com.bytedance.msdk.f.zg.xj(true);
                com.bytedance.msdk.f.zg.xj(optJSONObject2);
            } else {
                com.bytedance.msdk.f.zg.xj(false);
            }
            final JSONArray optJSONArray = jSONObject.optJSONArray("ra_info");
            if (optJSONArray != null) {
                com.bytedance.msdk.core.admanager.reward.rewardagain.w.xj(optJSONArray);
            }
            com.bytedance.msdk.c.xj.xj.xj().xj(jSONObject.optJSONObject("app_common_config"));
            com.bytedance.msdk.c.xj.hf.xj().xj(jSONObject.optJSONObject("adn_init_conf"));
            final String hf = hf(jSONObject.optJSONArray("adn_control_conf"));
            final String w = w(jSONObject.optJSONArray("rit_adn_control_conf"));
            final String y = y(jSONObject.optJSONObject("poor_network_config"));
            com.bytedance.msdk.c.xj.w.xj().xj(jSONObject.optJSONArray("rit_conf"));
            final String d = d(jSONObject.optJSONObject("module_disable_control"));
            final JSONObject optJSONObject3 = jSONObject.optJSONObject("call_stack_conf");
            c(optJSONObject3);
            final JSONObject optJSONObject4 = jSONObject.optJSONObject("custom_adn_feature");
            f(optJSONObject4);
            final JSONObject optJSONObject5 = jSONObject.optJSONObject("timeout_req");
            tf(optJSONObject5);
            final JSONObject optJSONObject6 = jSONObject.optJSONObject("is_callback");
            p(optJSONObject6);
            final String kd = kd(jSONObject.optJSONObject("label_outputs"));
            final String u = u(jSONObject.optJSONObject("label_group_infos"));
            try {
                final String xj = xj(jSONObject.optJSONArray("dynamic_rules"));
                final String hf2 = hf(jSONObject.optJSONObject("dynamic_policy"));
                z2 = false;
                this.dc = jSONObject.optInt("behavior_policy_enable", 0);
                com.bytedance.msdk.xj.kd.w.hf("BehaviorPolicy", "mBehaviorPolicyConfigEnable=" + this.dc);
                final String w2 = w(jSONObject.optJSONObject("behavior_policy"));
                JSONObject optJSONObject7 = jSONObject.optJSONObject("inter_full_refresh_cfg");
                String jSONObject2 = optJSONObject7 != null ? optJSONObject7.toString() : null;
                com.bytedance.msdk.core.admanager.xj.xj(jSONObject2);
                com.bytedance.msdk.w.f.u.xj(jSONObject.optJSONObject("csj_code_mapping_conf"));
                final JSONArray optJSONArray2 = jSONObject.optJSONArray("gm_req_sr");
                com.bytedance.msdk.w.f.kd.xj(optJSONArray2);
                r4 = 0;
                try {
                    final String str = jSONObject2;
                    y.u(new Runnable() { // from class: com.bytedance.msdk.core.am.w.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String xj2;
                            String xj3;
                            String xj4;
                            String xj5;
                            String xj6;
                            String xj7;
                            String xj8;
                            String xj9;
                            String xj10;
                            ai xj11 = com.bytedance.msdk.c.xj.xj();
                            xj11.xj("is_trusteeship_monetize", w.this.tu);
                            xj11.xj("share_cache_enable", w.this.lw);
                            xj11.xj(f.c, w.this.w);
                            xj11.xj("max_age", w.this.u);
                            xj11.xj("max_expire_time", w.this.kd);
                            xj11.xj("ab_version", w.this.y);
                            xj11.xj("ab_params", w.this.c);
                            xj11.xj("country", w.this.f);
                            xj11.xj("transparent_params", w.this.d);
                            xj11.xj("if_test", w.this.q);
                            xj11.xj("network_permission", w.this.tf);
                            xj11.xj("ecpm_precision_level", w.this.p);
                            xj11.xj("fetch_primerit_level", w.this.f10124pl);
                            xj11.xj("app_abtest", w.this.am);
                            xj11.xj("module_control", d);
                            xj11.xj("tt_app_log_url", w.this.zg);
                            xj11.xj("break_request_times", w.this.e);
                            xj11.xj("break_request_hold_time", w.this.yo);
                            xj11.xj("ex_info", w.this.r);
                            xj11.xj("if_enable_label", w.this.j);
                            xj11.xj("cpm_expire_time", w.this.xj);
                            JSONObject jSONObject3 = optJSONObject2;
                            xj11.xj("key_supervisor_feature", jSONObject3 != null ? jSONObject3.toString() : "");
                            xj11.xj("custom_adn_sample_ratio", (float) w.this.x);
                            xj11.xj("enable_label_return", w.this.ws);
                            xj11.xj("dynamic_policy_enable", w.this.eu);
                            xj11.xj("behavior_policy_enable", w.this.dc);
                            xj11.xj("limit_p_a", w.this.n);
                            xj11.xj("limit_p_r", w.this.yy);
                            xj11.xj("enable_bid_result_return", w.this.hl);
                            xj11.xj("enable_bid_result_return_for_baidu", w.this.vm);
                            xj11.xj("enable_bid_result_return_for_ks", w.this.aq);
                            JSONObject jSONObject4 = optJSONObject3;
                            if (jSONObject4 != null) {
                                xj11.xj("call_stack", jSONObject4.toString());
                            } else {
                                xj11.xj("call_stack", "");
                            }
                            JSONObject jSONObject5 = optJSONObject4;
                            if (jSONObject5 != null) {
                                xj11.xj("custom_adn_feature", jSONObject5.toString());
                            } else {
                                xj11.xj("custom_adn_feature", "");
                            }
                            JSONObject jSONObject6 = optJSONObject5;
                            if (jSONObject6 != null) {
                                xj11.xj("timeout_req", jSONObject6.toString());
                            } else {
                                xj11.xj("timeout_req", "");
                            }
                            JSONObject jSONObject7 = optJSONObject6;
                            if (jSONObject7 != null) {
                                xj11.xj("is_callback", jSONObject7.toString());
                            } else {
                                xj11.xj("is_callback", "");
                            }
                            String str2 = optString2;
                            if (str2 == null || TextUtils.isEmpty(str2)) {
                                xj11.y("server_dist_host");
                            } else {
                                String xj12 = com.bytedance.msdk.f.xj.xj(optString2, com.bytedance.msdk.f.hf.xj());
                                if (xj12 != null) {
                                    xj11.xj("server_dist_host", xj12);
                                }
                            }
                            String str3 = hf;
                            if (str3 != null && (xj10 = com.bytedance.msdk.f.xj.xj(str3, com.bytedance.msdk.f.hf.xj())) != null) {
                                xj11.xj("adn_control_conf", xj10);
                            }
                            if (TextUtils.isEmpty(w)) {
                                xj11.y("rit_adn_control_conf");
                            } else {
                                xj11.xj("rit_adn_control_conf", w);
                            }
                            String str4 = y;
                            if (str4 != null) {
                                xj11.xj("network_conf", str4);
                            }
                            if (!TextUtils.isEmpty(kd) && (xj9 = com.bytedance.msdk.f.xj.xj(kd, com.bytedance.msdk.f.hf.xj())) != null) {
                                xj11.xj("label_outputs", xj9);
                            }
                            if (!TextUtils.isEmpty(u) && (xj8 = com.bytedance.msdk.f.xj.xj(u, com.bytedance.msdk.f.hf.xj())) != null) {
                                xj11.xj("label_group_infos", xj8);
                            }
                            if (!TextUtils.isEmpty(xj) && (xj7 = com.bytedance.msdk.f.xj.xj(xj, com.bytedance.msdk.f.hf.xj())) != null) {
                                xj11.xj("dynamic_rules", xj7);
                            }
                            if (!TextUtils.isEmpty(w.this.b) && (xj6 = com.bytedance.msdk.f.xj.xj(w.this.b, com.bytedance.msdk.f.hf.xj())) != null) {
                                xj11.xj("ex_", xj6);
                            }
                            JSONArray jSONArray = optJSONArray;
                            if (jSONArray != null) {
                                String jSONArray2 = jSONArray.toString();
                                if (!TextUtils.isEmpty(jSONArray2) && (xj5 = com.bytedance.msdk.f.xj.xj(jSONArray2, com.bytedance.msdk.f.hf.xj())) != null) {
                                    xj11.xj("reward_again_styles", xj5);
                                }
                            }
                            if (!TextUtils.isEmpty(hf2) && (xj4 = com.bytedance.msdk.f.xj.xj(hf2, com.bytedance.msdk.f.hf.xj())) != null) {
                                xj11.xj("dynamic_policy", xj4);
                            }
                            if (!TextUtils.isEmpty(w2) && (xj3 = com.bytedance.msdk.f.xj.xj(w2, com.bytedance.msdk.f.hf.xj())) != null) {
                                xj11.xj("behavior_policy", xj3);
                            }
                            if (!TextUtils.isEmpty(str) && (xj2 = com.bytedance.msdk.f.xj.xj(str, com.bytedance.msdk.f.hf.xj())) != null) {
                                xj11.xj("inter_full_refresh_cfg", xj2);
                            }
                            JSONArray jSONArray3 = optJSONArray2;
                            if (jSONArray3 == null || jSONArray3.length() <= 0) {
                                xj11.y("gm_req_sr");
                            } else {
                                String xj13 = com.bytedance.msdk.f.xj.xj(optJSONArray2.toString(), com.bytedance.msdk.f.hf.xj());
                                if (xj13 != null) {
                                    xj11.xj("gm_req_sr", xj13);
                                }
                            }
                            xj11.xj("is_config_from_assert", z);
                            xj11.xj("has_config_in_sp", true);
                        }
                    });
                    xj(false, (JSONObject) null, (com.bytedance.msdk.core.y.hf) null);
                } catch (Throwable th) {
                    th = th;
                    z2 = false;
                    try {
                        pl.xj(th);
                    } finally {
                        xj(z2, (JSONObject) r4, (com.bytedance.msdk.core.y.hf) r4);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                z2 = false;
                r4 = 0;
                pl.xj(th);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void u(String str) {
        try {
            ai xj = com.bytedance.msdk.c.xj.xj();
            if ("2".equals(str)) {
                this.pz.put("active_control", Boolean.TRUE);
                xj.xj("all_active_control", true);
            } else {
                this.pz.put("active_control", Boolean.FALSE);
                xj.xj("all_active_control", false);
            }
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public void hf(int i) {
        this.v = i;
    }

    public void w(int i) {
        this.q = i;
    }

    private String xj(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                u.xj(jSONArray.optJSONObject(i), this.l);
            } catch (Exception e) {
                com.bytedance.msdk.xj.kd.w.w(MediationConstant.TAG, "maybe some rit parse dynamic rules fail .....");
                pl.xj(e);
            }
        }
        return jSONArray.toString();
    }

    public void xj(com.bytedance.msdk.core.y.hf hfVar) {
        this.gh = hfVar;
    }

    public void xj(final boolean z, final JSONObject jSONObject, com.bytedance.msdk.core.y.hf hfVar) {
        if (hfVar != null) {
            this.gh = hfVar;
        }
        final boolean ai = ai();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.msdk.y.hf.xj.hf().xj(com.bytedance.msdk.core.hf.getContext(), z, ai, new com.bytedance.msdk.core.y.hf() { // from class: com.bytedance.msdk.core.am.w.2
            @Override // com.bytedance.msdk.core.y.hf
            public void xj() {
                com.bytedance.msdk.xj.kd.w.u("TTMediationSDK_SDK_Init", "MSDK init finish.........hasConfig:" + ai);
                if (ai) {
                    w.this.ht.set(true);
                    w.this.op();
                    if (w.this.gh != null) {
                        w.this.gh.xj();
                    }
                    y.u(new Runnable() { // from class: com.bytedance.msdk.core.am.w.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!w.this.ra.get()) {
                                w.this.ra.set(true);
                                int xj = com.bytedance.msdk.y.hf.xj.xj();
                                long elapsedRealtime2 = SystemClock.elapsedRealtime() - com.bytedance.msdk.y.w.xj();
                                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                long j = elapsedRealtime3 - elapsedRealtime;
                                try {
                                    JSONObject jSONObject2 = jSONObject;
                                    if (jSONObject2 != null) {
                                        jSONObject2.put("adn_time", j);
                                    }
                                } catch (Throwable unused) {
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("csj_init_time", Long.valueOf(com.bytedance.sdk.gromore.init.kd.u - com.bytedance.sdk.gromore.init.kd.xj));
                                if (w.this.wa) {
                                    hashMap.put("is_import_cfg", Boolean.valueOf(w.this.wa));
                                }
                                if (com.bytedance.msdk.y.u.xj()) {
                                    com.bytedance.msdk.xj.kd.w.xj("TMe", "-----==---- 正常上报sdk_init_end");
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    com.bytedance.msdk.y.u.xj(elapsedRealtime2, xj, z ? 1 : 0, -1L, jSONObject, hashMap);
                                } else {
                                    com.bytedance.msdk.xj.kd.w.xj("TMe", "-----==---- 延时上报sdk_init_end");
                                    AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                                    com.bytedance.msdk.y.u.xj(elapsedRealtime2, xj, z ? 1 : 0, jSONObject, hashMap);
                                }
                                com.bytedance.msdk.core.hf.xj.xj();
                                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "sdk init end, duration: " + elapsedRealtime2 + ", initAdnCount: " + xj + ", isFromLocalConfig: " + z);
                            }
                            hf.xj(com.bytedance.msdk.core.hf.hf()).xj(new com.bytedance.msdk.api.u.kd() { // from class: com.bytedance.msdk.core.am.w.2.1.1
                                @Override // com.bytedance.msdk.api.u.kd
                                public void xj(List<String> list) {
                                    com.bytedance.msdk.xj.kd.w.xj("TMe", "初始化更新pangle配置成功");
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    @Override // com.bytedance.msdk.core.am.xj
    public void xj(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("state_code") != 30004) {
            return;
        }
        ai xj = com.bytedance.msdk.c.xj.xj();
        this.u = jSONObject.optLong("max_age");
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.u;
        this.kd = currentTimeMillis + j;
        xj.xj("max_age", j);
        xj.xj("max_expire_time", this.kd);
    }

    @Override // com.bytedance.msdk.core.am.xj
    public void xj(boolean z) {
        ai xj;
        JSONObject q;
        JSONObject jSONObject;
        int optInt;
        try {
            xj = com.bytedance.msdk.c.xj.xj();
        } catch (Throwable unused) {
            if (!z) {
                xj(true, (JSONObject) null, (com.bytedance.msdk.core.y.hf) null);
            }
            if (!com.bytedance.msdk.c.xj.w.xj().w() || dk.xj(com.bytedance.msdk.core.hf.getContext())) {
                return;
            }
        }
        if (!xj.kd("has_config_in_sp") && (q = com.bytedance.msdk.core.xj.p().q()) != null) {
            this.wa = true;
            int optInt2 = q.optInt("cypher", -1);
            if (optInt2 == 2) {
                String xj2 = l.xj(q.optString("message"));
                if (!TextUtils.isEmpty(xj2)) {
                    try {
                        jSONObject = new JSONObject(xj2);
                        q = jSONObject;
                    } catch (Throwable th) {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, ">>>>> setting data error: " + th.toString());
                    }
                }
                optInt = q.optInt("state_code");
                String optString = q.optString("message");
                if (optInt != 20000 && !TextUtils.isEmpty(q.toString())) {
                    q.optJSONObject("adn_init_conf");
                    if (q.optString(PluginConstants.KEY_APP_ID).equals(com.bytedance.msdk.core.xj.p().pl())) {
                        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "本地配置解析成功");
                        xj(q, true);
                        com.bytedance.msdk.core.p.xj.xj().y();
                        com.bytedance.msdk.core.xj.p().xj((JSONObject) null);
                        if (!z) {
                            xj(true, (JSONObject) null, (com.bytedance.msdk.core.y.hf) null);
                        }
                        if (!com.bytedance.msdk.c.xj.w.xj().w() || dk.xj(com.bytedance.msdk.core.hf.getContext())) {
                            return;
                        }
                        com.bytedance.msdk.core.p.xj.xj().xj(-2, "本地没有配置/当前网络不可用");
                    }
                    com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "本地配置appid或appkey非法");
                } else {
                    com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, " 解密错误或者解析错误：stateCode=" + optInt + "，msg=" + optString);
                }
            } else {
                if (optInt2 == 1) {
                    String hf = com.bytedance.msdk.f.xj.hf(q.optString("message"), com.bytedance.msdk.f.hf.xj());
                    if (!TextUtils.isEmpty(hf)) {
                        try {
                            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "setting data : " + hf.toString());
                            jSONObject = new JSONObject(hf);
                            q = jSONObject;
                        } catch (Throwable th2) {
                            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "setting data error: ", th2);
                        }
                    }
                } else if (optInt2 == 0) {
                    q = new JSONObject(q.optString("message"));
                }
                optInt = q.optInt("state_code");
                String optString2 = q.optString("message");
                if (optInt != 20000) {
                }
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, " 解密错误或者解析错误：stateCode=" + optInt + "，msg=" + optString2);
            }
        }
        com.bytedance.msdk.core.xj.p().xj((JSONObject) null);
        this.tu = xj.w("is_trusteeship_monetize");
        this.lw = xj.w("share_cache_enable");
        this.w = xj.hf(f.c);
        this.u = xj.u("max_age");
        this.kd = xj.u("max_expire_time");
        this.y = xj.hf("ab_version");
        this.c = xj.hf("ab_params");
        this.f = xj.hf("country");
        this.d = xj.hf("transparent_params");
        this.q = xj.w("if_test");
        this.tf = xj.w("network_permission");
        this.p = xj.hf("ecpm_precision_level");
        this.f10124pl = xj.hf("fetch_primerit_level");
        this.zg = xj.hf("tt_app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
        this.e = xj.hf("break_request_times", 0L);
        this.yo = xj.hf("break_request_hold_time", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        this.r = xj.hf("ex_info", 0);
        this.j = xj.hf("if_enable_label", 0);
        this.xj = xj.hf("cpm_expire_time", 259200000);
        this.x = xj.hf("custom_adn_sample_ratio", 0.0f);
        this.ws = xj.hf("enable_label_return", 0);
        this.eu = xj.hf("dynamic_policy_enable", 0);
        this.dc = xj.hf("behavior_policy_enable", 0);
        this.n = xj.hf("limit_p_a", 0);
        this.yy = xj.hf("limit_p_r", 0);
        this.hl = xj.hf("enable_bid_result_return", 0);
        this.vm = xj.hf("enable_bid_result_return_for_baidu", 0);
        this.aq = xj.hf("enable_bid_result_return_for_ks", 0);
        com.bytedance.msdk.core.c.xj.xj().xj(this.e, this.yo);
        String hf2 = xj.hf("network_conf");
        if (!TextUtils.isEmpty(hf2)) {
            y(new JSONObject(hf2));
        }
        String hf3 = xj.hf("reward_again_styles");
        if (!TextUtils.isEmpty(hf3)) {
            c(com.bytedance.msdk.f.xj.hf(hf3, com.bytedance.msdk.f.hf.xj()));
        }
        String hf4 = xj.hf("adn_control_conf");
        if (!TextUtils.isEmpty(hf4)) {
            if (!hf4.startsWith("[") && !hf4.startsWith("{")) {
                hf4 = com.bytedance.msdk.f.xj.hf(hf4, com.bytedance.msdk.f.hf.xj());
            }
            hf(new JSONArray(hf4));
        }
        String hf5 = xj.hf("rit_adn_control_conf");
        if (!TextUtils.isEmpty(hf5)) {
            w(new JSONArray(hf5));
        }
        String hf6 = xj.hf("module_control");
        if (!TextUtils.isEmpty(hf6)) {
            d(new JSONObject(hf6));
        }
        boolean kd = xj.kd("all_active_control");
        if (kd) {
            this.pz.put("active_control", Boolean.valueOf(kd));
        }
        String hf7 = xj.hf("call_stack");
        if (!TextUtils.isEmpty(hf7)) {
            c(new JSONObject(hf7));
        }
        String hf8 = xj.hf("custom_adn_feature");
        if (!TextUtils.isEmpty(hf8)) {
            f(new JSONObject(hf8));
        }
        String hf9 = xj.hf("timeout_req");
        if (!TextUtils.isEmpty(hf9)) {
            tf(new JSONObject(hf9));
        }
        String hf10 = xj.hf("is_callback");
        if (!TextUtils.isEmpty(hf10)) {
            p(new JSONObject(hf10));
        }
        String hf11 = xj.hf("key_supervisor_feature");
        if (!TextUtils.isEmpty(hf11)) {
            com.bytedance.msdk.f.zg.xj(true);
            com.bytedance.msdk.f.zg.xj(new JSONObject(hf11));
        } else {
            com.bytedance.msdk.f.zg.xj(false);
        }
        String hf12 = xj.hf("label_outputs");
        if (!TextUtils.isEmpty(hf12)) {
            if (!hf12.startsWith("[") && !hf12.startsWith("{")) {
                hf12 = com.bytedance.msdk.f.xj.hf(hf12, com.bytedance.msdk.f.hf.xj());
            }
            if (!TextUtils.isEmpty(hf12)) {
                kd(new JSONObject(hf12));
            }
        }
        String hf13 = xj.hf("label_group_infos");
        if (!TextUtils.isEmpty(hf13)) {
            if (!hf13.startsWith("[") && !hf13.startsWith("{")) {
                hf13 = com.bytedance.msdk.f.xj.hf(hf13, com.bytedance.msdk.f.hf.xj());
            }
            if (!TextUtils.isEmpty(hf13)) {
                u(new JSONObject(hf13));
            }
        }
        String hf14 = xj.hf("dynamic_rules");
        if (!TextUtils.isEmpty(hf14)) {
            if (!hf14.startsWith("[") && !hf14.startsWith("{")) {
                hf14 = com.bytedance.msdk.f.xj.hf(hf14, com.bytedance.msdk.f.hf.xj());
            }
            if (!TextUtils.isEmpty(hf14)) {
                xj(new JSONArray(hf14));
            }
        }
        String hf15 = xj.hf("dynamic_policy");
        if (!TextUtils.isEmpty(hf15)) {
            if (!hf15.startsWith("[") && !hf15.startsWith("{")) {
                hf15 = com.bytedance.msdk.f.xj.hf(hf15, com.bytedance.msdk.f.hf.xj());
            }
            if (!TextUtils.isEmpty(hf15)) {
                hf(new JSONObject(hf15));
            }
        }
        String hf16 = xj.hf("behavior_policy");
        if (!TextUtils.isEmpty(hf16)) {
            if (!hf16.startsWith("[") && !hf16.startsWith("{")) {
                hf16 = com.bytedance.msdk.f.xj.hf(hf16, com.bytedance.msdk.f.hf.xj());
            }
            if (!TextUtils.isEmpty(hf16)) {
                w(new JSONObject(hf16));
            }
        }
        String hf17 = xj.hf("inter_full_refresh_cfg");
        if (!TextUtils.isEmpty(hf17)) {
            String hf18 = com.bytedance.msdk.f.xj.hf(hf17, com.bytedance.msdk.f.hf.xj());
            if (!TextUtils.isEmpty(hf18)) {
                com.bytedance.msdk.core.admanager.xj.xj(hf18);
            }
        }
        String hf19 = xj.hf("gm_req_sr");
        if (!TextUtils.isEmpty(hf19)) {
            String hf20 = com.bytedance.msdk.f.xj.hf(hf19, com.bytedance.msdk.f.hf.xj());
            if (!TextUtils.isEmpty(hf20)) {
                try {
                    com.bytedance.msdk.w.f.kd.xj(new JSONArray(hf20));
                } catch (Throwable th3) {
                    pl.xj(th3);
                }
            }
        }
        String hf21 = xj.hf("ex_");
        if (!TextUtils.isEmpty(hf21) && !hf21.startsWith("[") && !hf21.startsWith("{")) {
            this.b = com.bytedance.msdk.f.xj.hf(hf21, com.bytedance.msdk.f.hf.xj());
        }
        if (!TextUtils.isEmpty(xj.hf("app_abtest"))) {
            String hf22 = xj.hf("app_abtest");
            this.am = hf22;
            f(hf22);
        }
        if (!z) {
            xj(true, (JSONObject) null, (com.bytedance.msdk.core.y.hf) null);
        }
        if (!com.bytedance.msdk.c.xj.w.xj().w() || dk.xj(com.bytedance.msdk.core.hf.getContext())) {
            return;
        }
        com.bytedance.msdk.core.p.xj.xj().xj(-2, "本地没有配置/当前网络不可用");
    }

    public boolean xj(int i) {
        if (!gh()) {
            return false;
        }
        if (i == 1) {
            return qt();
        }
        if (i == 2) {
            return zg();
        }
        if (i == 3) {
            return yo();
        }
        if (i == 5) {
            return v() && ht();
        }
        if (i == 10) {
            return e();
        }
        if (i == 7) {
            return jk();
        }
        if (i != 8) {
            return true;
        }
        return pz();
    }

    public List<String> xj(List<String> list) {
        if (list != null && list.size() > 0) {
            if (com.bytedance.msdk.c.xj.w.xj().w()) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (com.bytedance.msdk.c.xj.w.xj().xj(str, 0, 101) == null) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    public void xj(zg zgVar) {
        if (zgVar == null) {
            return;
        }
        if (q()) {
            zgVar.xj();
            return;
        }
        synchronized (this.jk) {
            try {
                if (!this.jk.contains(zgVar)) {
                    this.jk.add(zgVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean xj(long j) {
        return j < ((long) this.xj);
    }
}
