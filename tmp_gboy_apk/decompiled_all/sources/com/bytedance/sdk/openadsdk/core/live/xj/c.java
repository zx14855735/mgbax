package com.bytedance.sdk.openadsdk.core.live.xj;

import ADYaiT.CtFAbx;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.aw;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.a.ra;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.am.xj;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.ht;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.j.tf;
import com.bytedance.sdk.openadsdk.core.live.xj.y;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.b;
import com.bytedance.sdk.openadsdk.core.ra.r;
import com.bytedance.sdk.openadsdk.core.ra.s;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.p;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c extends y {
    private volatile Set<String> tf;
    private final AtomicBoolean f = new AtomicBoolean(false);
    public volatile com.bytedance.sdk.openadsdk.qt.u c = null;
    private volatile int d = -5;
    private volatile boolean p = false;

    /* renamed from: pl, reason: collision with root package name */
    private final long f10373pl = System.currentTimeMillis();
    private volatile boolean g = false;
    private long am = -1;
    private long qt = -1;
    private long zg = -1;
    private boolean e = false;

    public c() {
        if (com.bytedance.sdk.openadsdk.x.c.xj()) {
            com.bytedance.sdk.openadsdk.x.c.w(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.xj.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.d();
                }
            });
        } else {
            d();
        }
    }

    private void am() {
        Function<SparseArray<Object>, Object> aq = f.zg().aq();
        if (aq == null) {
            return;
        }
        a_((String) xj(aq, 8, String.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        am();
        f.zg().xj("com.byted.live.lite", w(p.hf("com.byted.live.lite")), this.kd, null);
        if (pz.hf().pu()) {
            tf();
            this.am = com.bytedance.sdk.openadsdk.core.hf.xj().get("live_last_init_time", 0L);
        } else {
            this.d = -4;
            pl.hf("TTLiveSDkBridge", "forbiddom init live");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Object hf = hf("getLiveSdkConfig");
        if (hf == null || !(hf instanceof JSONObject)) {
            return;
        }
        this.w = (JSONObject) hf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        pl.xj("TTLiveSDkBridge", "doInitLive");
        this.zg = SystemClock.elapsedRealtime();
        if (this.xj == null) {
            this.xj = f.zg().y(2);
        }
        if (this.xj != null) {
            this.xj.apply(A2egSU.AZOQYO(9, Void.class).xj(0, new com.bytedance.sdk.openadsdk.core.live.hf.xj(this)).hf());
        } else {
            pl.hf("TTLiveSDkBridge", "No bridge for live");
        }
        if ((f.zg().aq() != null ? p.c("com.byted.live.lite") : false) && this.d != 2) {
            this.d = 1;
        }
        int hf = hf();
        String str = Constants.FAIL;
        com.bytedance.sdk.openadsdk.tools.hf.w(21, hf > 0 ? "1" : Constants.FAIL);
        if (hf() == 2) {
            str = "1";
        }
        com.bytedance.sdk.openadsdk.tools.hf.w(20, str);
    }

    private long p() {
        com.bytedance.sdk.openadsdk.core.j.hf lp = pz.hf().lp();
        long j = com.bytedance.sdk.openadsdk.core.j.u.xj;
        if (lp != null) {
            j = lp.hf();
        }
        if (System.currentTimeMillis() - this.f10373pl > j) {
            return 0L;
        }
        return j;
    }

    private boolean pl() {
        if (f.zg().tf() && this.c == null) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.j.hf lp = pz.hf().lp();
        if (lp != null) {
            if (lp.kd()) {
                return this.p;
            }
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.j.u.hf) {
            return this.p;
        }
        return true;
    }

    private boolean qt() {
        try {
            if (ai.w >= 7000) {
                int parseInt = Integer.parseInt(this.kd.replaceAll("\\.", ""));
                if (parseInt == 0) {
                    parseInt = p.w("com.byted.live.lite");
                }
                if (parseInt <= 211413) {
                    return false;
                }
            }
        } catch (Exception unused) {
        }
        tf hf = pz.hf();
        b ne = hf.ne();
        int hf2 = f.zg().et().hf();
        return (ne == null || !ne.kd() || !hf.pu() || hf2 == 4 || hf2 == 5) ? false : true;
    }

    private void tf() {
        if (this.g) {
            pl.xj("TTLiveSDkBridge", "tryLoad saas hasLoaded");
            return;
        }
        if (pl()) {
            this.g = true;
            com.bytedance.sdk.component.utils.f.w().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.xj.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.g();
                }
            }, p());
        } else {
            pl.xj("TTLiveSDkBridge", "tryLoad saas failed mHasSaasMetaClicked = " + this.p);
        }
    }

    private Map zg() {
        String hf;
        HashMap hashMap = new HashMap();
        hashMap.put("app_name", pz.getContext().getPackageName());
        b ne = pz.hf().ne();
        if (ne != null) {
            hashMap.put("partner", ne.w());
            hashMap.put("p_secret", ne.u());
            hashMap.put("g_appid", String.valueOf(ne.hf()));
        }
        hashMap.put("channel", "csj_channel");
        hashMap.put(aw.f9748a, Boolean.valueOf(pl.w()));
        hashMap.put("ec_host_appid", "1371");
        HashMap hashMap2 = new HashMap();
        if (!f.zg().f()) {
            hashMap2.put("enable_init_oaid", "false");
        }
        if (!f.zg().kd()) {
            hashMap2.put("can_use_sensor", "false");
        }
        if (f.zg().tf()) {
            String w = com.bytedance.sdk.openadsdk.core.a.tf.w(false);
            if (!com.bytedance.sdk.openadsdk.core.u.xj.w() || TextUtils.isEmpty(w)) {
                hf = ra.hf(this.c);
            } else {
                hashMap2.remove("enable_init_oaid");
                hf = ra.hf(w);
            }
            if (!TextUtils.isEmpty(hf)) {
                hashMap2.put("oaid_object", hf);
            }
        }
        com.bytedance.sdk.openadsdk.core.j.hf lp = pz.hf().lp();
        if (lp != null) {
            boolean xj = lp.xj();
            pl.xj("TTLiveSDkBridge", "INIT_SUB_PROCESS=", Boolean.valueOf(xj));
            hashMap.put("sub_process", Boolean.valueOf(xj));
        }
        hashMap.put("c_control", f.zg().e());
        com.bytedance.sdk.openadsdk.core.j.hf lp2 = pz.hf().lp();
        if (lp2 == null) {
            xj(hashMap, hashMap2);
            return hashMap;
        }
        JSONObject w2 = lp2.w();
        if (w2 == null) {
            xj(hashMap, hashMap2);
            return hashMap;
        }
        Iterator<String> keys = w2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap2.put(next, String.valueOf(w2.opt(next)));
        }
        hashMap.put("live_tob_init_extra", hashMap2);
        return hashMap;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public JSONObject f() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int kd() {
        Object hf;
        return (this.xj == null || !y() || (hf = hf("hasAuthenticated")) == null || !(hf instanceof Boolean)) ? false : ((Boolean) hf).booleanValue() ? 2 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public void u() {
        if (this.xj == null || !y()) {
            return;
        }
        hf("warmingUpBeforeEnter");
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public boolean y() {
        return this.d == 2;
    }

    private String w(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public int hf() {
        return this.d;
    }

    private Object hf(String str) {
        Object apply;
        if (this.d != 2) {
            StringBuilder B3GDIM2 = CtFAbx.B3GDIM("callSimpleExpandMethod ", str, " failed for plugin state = ");
            B3GDIM2.append(this.d);
            pl.hf("TTLiveSDkBridge", B3GDIM2.toString());
            return null;
        }
        HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("expand_method_name", str);
        if (this.xj == null) {
            return null;
        }
        apply = this.xj.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(7).xj(Void.class).xj(0, BI9f7h2).hf());
        return apply;
    }

    private <T> T xj(Function<SparseArray<Object>, Object> function, int i, Class<T> cls) {
        Object apply;
        apply = function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(i).xj((Class<?>) cls).xj(0, "com.byted.live.lite").hf());
        T t = (T) apply;
        if (t != null) {
            return t;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.xj, com.bytedance.sdk.openadsdk.core.live.xj.u
    public void u(ws wsVar) {
        if (wsVar == null || this.p || !kd(wsVar)) {
            return;
        }
        this.p = true;
        d();
    }

    private boolean kd(ws wsVar) {
        JSONObject jb = wsVar.jb();
        if (jb == null) {
            return false;
        }
        if (jb.optInt("landing_type", 0) != 4 && TextUtils.isEmpty(wsVar.wr())) {
            return com.bytedance.sdk.openadsdk.core.live.kd.xj.xj(wsVar);
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.xj, com.bytedance.sdk.openadsdk.core.live.xj.u
    public void xj() {
        if (this.f.get()) {
            pl.hf("TTLiveSDkBridge", "already init!");
            return;
        }
        if (this.d != 5) {
            pl.hf("TTLiveSDkBridge", "plugin not Load! " + this.d);
            return;
        }
        if (this.d == 2) {
            pl.hf("TTLiveSDkBridge", "init started or successed:" + this.d);
            return;
        }
        if (!qt()) {
            pl.hf("TTLiveSDkBridge", "init live failed！ not valid env！");
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.live.kd.hf.w(this.kd)) {
            com.bytedance.sdk.openadsdk.core.live.kd.hf.u(this.kd);
            return;
        }
        this.e = p.c("com.byted.live.lite");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("has_install", Boolean.valueOf(this.e));
        } catch (JSONException unused) {
        }
        am.xj().w(jSONObject);
        this.qt = SystemClock.elapsedRealtime();
        this.f.set(true);
        com.bytedance.sdk.openadsdk.core.live.kd.hf.xj(this.kd);
        this.d = 4;
        if (this.xj != null) {
            pl.xj("TTLiveSDkBridge", "liveSDkBridge init invoke 5500");
            this.xj.apply(A2egSU.AZOQYO(5, Void.class).xj(0, zg()).hf());
        }
        com.bytedance.sdk.openadsdk.core.live.kd.hf.hf(this.kd);
    }

    private boolean w(String str) {
        if (str.startsWith("csj_saas")) {
            return true;
        }
        if (this.tf == null) {
            this.tf = new HashSet(11);
            this.tf.add("saas_easyplayable");
            this.tf.add("real_auth_status");
            this.tf.add("live_panel");
            this.tf.add("live_exit");
            this.tf.add("mnpl_user_close");
            this.tf.add("clickarea");
            this.tf.add("enterSection");
            this.tf.add("mini_playable_real_show");
            this.tf.add("mnpl_user_close");
            this.tf.add("mnpl_sdk_lifecycle_status");
        }
        return this.tf.contains(str);
    }

    private void hf(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(br.c, str);
            jSONObject.putOpt("has_install", Boolean.valueOf(this.e));
            jSONObject.putOpt("fake_init", Boolean.valueOf(z));
            long elapsedRealtime = SystemClock.elapsedRealtime();
            jSONObject.putOpt("init_cost", Long.valueOf(elapsedRealtime - this.qt));
            jSONObject.putOpt("cost", Long.valueOf(elapsedRealtime - this.zg));
            jSONObject.putOpt(cb.o, Boolean.FALSE);
        } catch (JSONException unused) {
        }
        am.xj().u(jSONObject);
    }

    public void w(Map<String, String> map) {
        com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar = (com.bytedance.sdk.openadsdk.zg.w.xj.hf) ht.xj(this.u, com.bytedance.sdk.openadsdk.zg.w.xj.hf.class);
        if (hfVar == null) {
            return;
        }
        hfVar.xj(4, map);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.xj, com.bytedance.sdk.openadsdk.core.live.xj.u
    public long w() {
        return this.am;
    }

    private JSONObject hf(int i, String str) {
        r bi;
        JSONArray f;
        if (this.y != null && this.y.get() != null) {
            ws wsVar = this.y.get();
            if (TextUtils.equals(wsVar.ke(), str) && (bi = wsVar.bi()) != null && (f = bi.f()) != null && f.length() != 0) {
                int length = f.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = f.optJSONObject(i2);
                    if (optJSONObject.optInt(PointParamKey.TYPE) == i) {
                        return optJSONObject;
                    }
                }
            }
        }
        return null;
    }

    private void xj(Map map, Map<String, Object> map2) {
        map2.put("allow_apm_init", com.bytedance.sdk.openadsdk.core.j.u.w);
        map2.put("allow_npth_init", com.bytedance.sdk.openadsdk.core.j.u.u);
        map2.put("allow_vlog_init", com.bytedance.sdk.openadsdk.core.j.u.kd);
        map2.put("sec_init_use_thread", com.bytedance.sdk.openadsdk.core.j.u.y);
        map.put("live_tob_init_extra", map2);
    }

    public void hf(Map<String, String> map) {
        com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar;
        if (map == null || map.size() == 0) {
            return;
        }
        String str = map.get(PointParamKey.TYPE);
        String str2 = map.get("status");
        String str3 = map.get("open_uid");
        String str4 = map.get("task_key");
        if ("1".equals(str2) && !TextUtils.isEmpty(str)) {
            try {
                JSONObject optJSONObject = hf(Integer.parseInt(str), str4).optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
                if (optJSONObject == null) {
                    return;
                }
                String optString = optJSONObject.optString("callback");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(optString);
                if (!TextUtils.isEmpty(jSONObject.optString("name")) && (hfVar = (com.bytedance.sdk.openadsdk.zg.w.xj.hf) ht.xj(this.u, com.bytedance.sdk.openadsdk.zg.w.xj.hf.class)) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("open_uid", str3);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.opt(next));
                    }
                    hfVar.xj(3, hashMap);
                    return;
                }
                return;
            } catch (Exception e) {
                pl.hf("TTLiveSDkBridge", "onTaskFinish parse extra error", e);
                return;
            }
        }
        pl.hf("TTLiveSDkBridge", "onTaskFinish status is :" + str2);
    }

    public void xj(int i, String str, boolean z, boolean z2) {
        int i2 = this.d;
        this.d = i;
        if (i == -3) {
            if (z || this.d == i2) {
                return;
            }
            hf(str, z2);
            return;
        }
        if (i == 1) {
            com.bytedance.sdk.openadsdk.tools.hf.w(21, "1");
            return;
        }
        if (i != 2) {
            return;
        }
        this.am = SystemClock.elapsedRealtime();
        if (!z && this.d != i2) {
            hf(str, z2);
        }
        com.bytedance.sdk.openadsdk.tools.hf.w(21, "1");
        com.bytedance.sdk.openadsdk.tools.hf.w(20, "1");
        am();
        e();
        com.bytedance.sdk.openadsdk.core.hf.xj().put("live_last_init_time", this.am);
    }

    public void xj(boolean z, String str) {
        String str2;
        com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar;
        com.bytedance.sdk.openadsdk.x.c.xj(new d("getLiveSdk") { // from class: com.bytedance.sdk.openadsdk.core.live.xj.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.e();
            }
        });
        if (this.y != null && this.y.get() != null) {
            com.bytedance.sdk.openadsdk.core.am.u.xj(z ? 2 : 1, this.hf != null ? this.hf : "", this.y.get());
        }
        if (!z || (str2 = this.u) == null || (hfVar = (com.bytedance.sdk.openadsdk.zg.w.xj.hf) ht.xj(str2, com.bytedance.sdk.openadsdk.zg.w.xj.hf.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("open_uid", str);
        hfVar.xj(1, hashMap);
        xj(AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, this.u);
    }

    private JSONObject xj(int i, String str) {
        JSONObject hf = hf(i, str);
        if (hf != null) {
            try {
                hf.putOpt("status", 1);
            } catch (JSONException unused) {
            }
            ws wsVar = this.y.get();
            if (wsVar != null) {
                com.bytedance.sdk.openadsdk.core.live.u.xj.xj(str, wsVar.ho() + "_" + i);
            }
        }
        return hf;
    }

    public void xj(Map<String, String> map) {
        String str = map.get("label");
        final String str2 = map.get("req_id");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!w(str)) {
            pl.hf("TTLiveSDkBridge", "not valid label " + str);
            return;
        }
        ws wsVar = this.y != null ? this.y.get() : null;
        final String str3 = map.get(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        com.bytedance.sdk.openadsdk.y.xj.xj xjVar = new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.live.xj.c.4
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(str3);
                jSONObject2.put("req_id", str2);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        };
        if (wsVar != null) {
            com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, this.hf, str, xjVar);
            String zf = wsVar.zf();
            if (TextUtils.equals(zf, str2)) {
                return;
            }
            xj(str2, str, CtFAbx.BChYOn("mate req is ", zf));
            return;
        }
        new xj.C0138xj().xj(this.hf).hf(str).xj(xjVar);
        xj(str2, str, TTAdConstant.MATE_IS_NULL_MSG);
    }

    private void xj(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("req_id", str);
            jSONObject.putOpt("label", str2);
            jSONObject.putOpt("mesage", str3);
        } catch (JSONException unused) {
        }
        am.xj().xj("reportPangleEvent", jSONObject, (Throwable) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.y, com.bytedance.sdk.openadsdk.core.live.xj.u
    public int xj(final ws wsVar, final w wVar, final String str) {
        if (wsVar == null) {
            return 0;
        }
        final String wn = wsVar.wn();
        if (TextUtils.isEmpty(wn)) {
            return 0;
        }
        if (this.d != 2) {
            return -1;
        }
        this.hf = str;
        this.y = new SoftReference<>(wsVar);
        s cc = wsVar.cc();
        if (2 != kd() && cc != null) {
            final boolean z = cc.u() == 1;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final long currentTimeMillis = System.currentTimeMillis();
            if (xj(wsVar, new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.live.xj.c.5
                @Override // com.bytedance.sdk.openadsdk.core.live.xj.y.xj
                public void xj(boolean z2) {
                    boolean z3;
                    if (atomicBoolean.compareAndSet(false, true)) {
                        c.this.xj(wsVar, wVar, wn, z2, z, str, 1);
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    am.xj().xj(wsVar, System.currentTimeMillis() - currentTimeMillis, z2, z3);
                }
            }, true)) {
                long kd = cc.kd();
                if (kd > 0) {
                    com.bytedance.sdk.component.utils.f.hf().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.xj.c.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                c.this.xj(wsVar, wVar, wn, false, z, str, 2);
                            }
                        }
                    }, kd);
                }
                return 2;
            }
        }
        int xj = xj(wn);
        xj(xj, wsVar, false, 0);
        return xj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(ws wsVar, w wVar, String str, boolean z, boolean z2, String str2, int i) {
        int xj = xj(str);
        pl.xj("TTLiveSDkBridge", "auth result:" + z + ", schema handle:" + xj);
        xj(xj, wsVar, z, i);
        if (xj != 1) {
            if (wVar != null) {
                wVar.xj(xj);
            }
        } else {
            if (z || !z2) {
                return;
            }
            new com.bytedance.sdk.openadsdk.core.live.w.xj().xj(str2).xj(pz.getContext(), wsVar);
        }
    }

    private void xj(int i, ws wsVar, boolean z, int i2) {
        if (wsVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("handle_result", Integer.valueOf(i));
            jSONObject.put("req_id", wsVar.zf());
            jSONObject.put("auth", z);
            s cc = wsVar.cc();
            if (cc != null) {
                jSONObject.put("saas_info", cc.xj());
            }
            jSONObject.put("status", i2);
            jSONObject.put(n.m, wsVar.jf());
        } catch (Exception unused) {
        }
        am.xj().hf(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public void xj(com.bytedance.sdk.openadsdk.qt.u uVar) {
        this.c = uVar;
        d();
    }
}
