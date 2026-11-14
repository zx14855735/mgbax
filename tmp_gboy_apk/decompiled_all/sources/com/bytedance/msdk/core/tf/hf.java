package com.bytedance.msdk.core.tf;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.msdk.f.p;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {

    /* renamed from: a, reason: collision with root package name */
    private int f10128a;
    private boolean ai;
    private com.bytedance.msdk.core.f.c b;
    private long c;
    private int dc;
    private String dk;
    private long e;
    private int en;
    private int et;
    private JSONObject eu;
    private String f;
    private int ff;
    private int hf;
    private double hl;
    private int ht;

    /* renamed from: io, reason: collision with root package name */
    private long f10129io;
    private int j;
    private String jk;
    private long kd;
    private int l;
    private int pz;
    private int q;
    private int qt;
    private com.bytedance.msdk.core.f.d r;
    private int ra;
    private int tj;
    private long u;
    private String v;
    private long vm;
    private int w;
    private int wo;
    private int ws;
    private boolean x;
    private String xj;
    private long y;
    private int yo;
    private double yy;
    private double z;
    private int zg;
    private List<tf> d = new CopyOnWriteArrayList();
    private Map<Integer, List<tf>> tf = new HashMap();
    private Map<Integer, List<tf>> p = new HashMap();

    /* renamed from: pl, reason: collision with root package name */
    private List<Integer> f10130pl = new ArrayList();
    private double g = -1.0d;
    private double am = -1.0d;
    private int n = 1000;
    private int wn = 0;
    private int aq = 2;
    private int tu = 0;
    private int s = 0;
    private Map<String, Object> dq = new HashMap();

    public int a() {
        return this.hf;
    }

    public int ai() {
        return this.yo;
    }

    public int am() {
        return this.wn;
    }

    public long b() {
        return this.y;
    }

    public int c() {
        return this.tj;
    }

    public com.bytedance.msdk.core.f.c d() {
        return this.b;
    }

    public int dc() {
        return this.ff;
    }

    public double dk() {
        return this.g;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public hf clone() {
        hf hfVar = new hf();
        hfVar.xj = this.xj;
        hfVar.hf = this.hf;
        hfVar.w = this.w;
        hfVar.u = this.u;
        hfVar.kd = this.kd;
        hfVar.y = this.y;
        hfVar.c = this.c;
        hfVar.f = this.f;
        hfVar.e = this.e;
        hfVar.ra = this.ra;
        hfVar.jk = this.jk;
        hfVar.yo = this.yo;
        hfVar.v = this.v;
        hfVar.pz = this.pz;
        hfVar.ht = this.ht;
        hfVar.dk = this.dk;
        hfVar.et = this.et;
        hfVar.f10129io = this.f10129io;
        hfVar.q = this.q;
        hfVar.z = this.z;
        hfVar.l = this.l;
        hfVar.ff = this.ff;
        hfVar.f10128a = this.f10128a;
        hfVar.j = this.j;
        hfVar.en = this.en;
        hfVar.ws = this.ws;
        hfVar.b = this.b;
        hfVar.r = this.r;
        hfVar.wo = this.wo;
        hfVar.x = this.x;
        hfVar.ai = this.ai;
        hfVar.eu = this.eu;
        hfVar.g = this.g;
        hfVar.zg = this.zg;
        hfVar.d = new CopyOnWriteArrayList(this.d);
        hfVar.tf = new HashMap(this.tf);
        hfVar.qt = this.qt;
        hfVar.f10130pl = new ArrayList(this.f10130pl);
        hfVar.dq = new HashMap(this.dq);
        hfVar.p = new HashMap(this.p);
        hfVar.tj = this.tj;
        hfVar.n = this.n;
        hfVar.am = this.am;
        hfVar.vm = this.vm;
        hfVar.yy = this.yy;
        hfVar.hl = this.hl;
        hfVar.wn = this.wn;
        hfVar.aq = this.aq;
        hfVar.tu = this.tu;
        hfVar.s = this.s;
        return hfVar;
    }

    public String en() {
        return this.f;
    }

    public double et() {
        return this.am;
    }

    public int eu() {
        return this.j;
    }

    public int f() {
        int min = Math.min(this.n, 1000);
        if (min <= 0) {
            return 1000;
        }
        return min;
    }

    public String ff() {
        return this.xj;
    }

    public boolean g() {
        return this.ws == 1;
    }

    public int hf() {
        return this.dc;
    }

    public String hl() {
        return this.jk;
    }

    public int ht() {
        return this.ra;
    }

    public Map<Integer, List<tf>> io() {
        HashMap hashMap = new HashMap();
        Map<Integer, List<tf>> map = this.tf;
        if (map != null) {
            for (Map.Entry<Integer, List<tf>> entry : map.entrySet()) {
                List<tf> value = entry.getValue();
                Integer key = entry.getKey();
                key.intValue();
                hashMap.put(key, new ArrayList(value));
            }
        }
        return hashMap;
    }

    public boolean j() {
        return this.ai;
    }

    public String jk() {
        return this.dk;
    }

    public long kd() {
        return this.vm;
    }

    public List<Integer> l() {
        return this.f10130pl;
    }

    public Map<Integer, List<tf>> n() {
        return this.p;
    }

    public boolean p() {
        return this.wo == 1;
    }

    public boolean pl() {
        return this.l == 3;
    }

    public long pz() {
        return this.f10129io;
    }

    public String q() {
        return this.v;
    }

    public int qt() {
        int i = this.aq;
        if (i < 2) {
            return 2;
        }
        return i;
    }

    public long r() {
        return this.kd;
    }

    public int ra() {
        return this.zg;
    }

    public com.bytedance.msdk.core.f.d tf() {
        return this.r;
    }

    public int tj() {
        return this.en;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AdsenseRitConfig{mRitId='");
        sb.append(this.xj);
        sb.append("', mIsSpeed=");
        sb.append(pl());
        sb.append(", mHasServerbidding=");
        sb.append(this.x);
        sb.append(", mHasClientOrMultiLevel=");
        sb.append(this.ai);
        sb.append(", mRitType=");
        sb.append(this.hf);
        sb.append(", mLookType=");
        sb.append(this.w);
        sb.append(", mMinWaitTime=");
        sb.append(this.u);
        sb.append(", mLayerTimeOut=");
        sb.append(this.kd);
        sb.append(", mTotalTimeOut=");
        sb.append(this.y);
        sb.append(", mWaterFallConfigList=");
        sb.append(this.d);
        sb.append(", mWaterFallConfMap=");
        sb.append(this.tf);
        sb.append(", mLoadSortLevelList=");
        sb.append(this.f10130pl);
        sb.append(", mCurrentCommonAdMaxCpm=");
        sb.append(this.g);
        sb.append(", mTotalLoadLevelCount=");
        sb.append(this.qt);
        sb.append(", mTotalWaterFallCount=");
        sb.append(this.zg);
        sb.append(", mWaterfallAbTestParam=");
        sb.append(this.jk);
        sb.append(", mServerSideVerifyPreRequestTime=");
        sb.append(this.j);
        sb.append(", mServerSideVerifyRewardType=");
        return A2egSU.B2KMhB(sb, this.en, '}');
    }

    public double u() {
        return this.yy;
    }

    public double v() {
        return this.z;
    }

    public int vm() {
        return this.l;
    }

    public double w() {
        return this.hl;
    }

    public int wn() {
        return this.tu;
    }

    public long wo() {
        return this.u;
    }

    public long ws() {
        return this.c;
    }

    public long x() {
        return this.e;
    }

    public void xj(int i) {
        this.s = i;
    }

    public Map<String, Object> y() {
        return this.dq;
    }

    public int yo() {
        return this.f10128a;
    }

    public List<tf> yy() {
        return this.d;
    }

    public boolean z() {
        return this.x;
    }

    public hf zg() {
        List<String> xj = p.xj();
        hf hfVar = new hf();
        hfVar.xj = this.xj;
        p.xj(xj, "mRitId");
        hfVar.hf = this.hf;
        p.xj(xj, "mRitType");
        hfVar.w = this.w;
        p.xj(xj, "mLookType");
        hfVar.u = this.u;
        p.xj(xj, "mMinWaitTime");
        hfVar.kd = this.kd;
        p.xj(xj, "mLayerTimeOut");
        hfVar.y = this.y;
        p.xj(xj, "mTotalTimeOut");
        hfVar.c = this.c;
        p.xj(xj, "mCacheTimeOut");
        hfVar.f = this.f;
        p.xj(xj, "mVersion");
        hfVar.e = this.e;
        p.xj(xj, "mWaterFallId");
        hfVar.ra = this.ra;
        p.xj(xj, "reqType");
        hfVar.jk = this.jk;
        p.xj(xj, "mWaterfallAbTestParam");
        hfVar.yo = this.yo;
        p.xj(xj, "segmentId");
        hfVar.v = this.v;
        p.xj(xj, "segmentVersion");
        hfVar.pz = this.pz;
        p.xj(xj, "preLoadSortControl");
        hfVar.ht = this.ht;
        p.xj(xj, "preShowSortControl");
        hfVar.dk = this.dk;
        p.xj(xj, "waterfallExtra");
        hfVar.et = this.et;
        p.xj(xj, "mMultilevelAfterP");
        hfVar.f10129io = this.f10129io;
        p.xj(xj, "mMultilevelTimeOut");
        hfVar.q = this.q;
        p.xj(xj, "mRefreshTime");
        hfVar.z = this.z;
        p.xj(xj, "mBidFloor");
        hfVar.l = this.l;
        p.xj(xj, "mParallelType");
        hfVar.ff = this.ff;
        p.xj(xj, "mReqParallelNum");
        hfVar.f10128a = this.f10128a;
        p.xj(xj, "mAdCount");
        hfVar.j = this.j;
        p.xj(xj, "serverSideVerifyPreRequestTime");
        hfVar.en = this.en;
        p.xj(xj, "serverSideRewardType");
        hfVar.ws = this.ws;
        p.xj(xj, "mAdPrime");
        hfVar.aq = this.aq;
        p.xj(xj, "mRefreshNum");
        hfVar.wn = this.wn;
        p.xj(xj, "mIsRefresh");
        hfVar.b = this.b;
        p.xj(xj, "mIntervalFreqctlBean");
        hfVar.r = this.r;
        p.xj(xj, "mIntervalPacingBean");
        hfVar.wo = this.wo;
        p.xj(xj, "mWaterFallTimingMode");
        hfVar.vm = this.vm;
        p.xj(xj, "mReqInterval");
        hfVar.yy = this.yy;
        p.xj(xj, "mTotalTimeoutRate");
        hfVar.hl = this.hl;
        p.xj(xj, "mLayerTimeoutRate");
        hfVar.dq = new HashMap(this.dq);
        hfVar.tj = this.tj;
        hfVar.n = this.n;
        hfVar.am = this.am;
        hfVar.p = new HashMap(this.p);
        p.hf(xj, "AdsenseRitConfig");
        hfVar.tu = this.tu;
        p.xj(xj, "mBehaviorTTL");
        hfVar.s = this.s;
        p.xj(xj, "mIsSamste");
        return hfVar;
    }

    private static Long ht(int i) {
        if (i != 1) {
            if (i != 2 && i != 3) {
                if (i != 5) {
                    if (i != 7 && i != 8) {
                        return 0L;
                    }
                }
            }
            return 0L;
        }
        return 1000L;
    }

    private static Long ra(int i) {
        if (i != 1 && i != 2) {
            if (i == 3) {
                return Long.valueOf(PushUIConfig.dismissTime);
            }
            if (i != 5) {
                if (i == 7 || i == 8) {
                    return 600000L;
                }
                return Long.valueOf(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            }
        }
        return Long.valueOf(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    public void am(int i) {
        this.yo = i;
    }

    public void c(int i) {
        this.wn = i;
    }

    public void d(int i) {
        this.f10128a = i;
    }

    public void f(int i) {
        this.aq = i;
    }

    public void g(int i) {
        this.ra = i;
    }

    public void hf(int i) {
        this.dc = i;
    }

    public void jk(int i) {
        this.ff = i;
    }

    public void kd(int i) {
        this.ws = i;
    }

    public void p(int i) {
        this.q = i;
    }

    public void pl(int i) {
        this.et = i;
    }

    public void pz(int i) {
        this.tu = i;
    }

    public void qt(int i) {
        this.hf = i;
    }

    public int tf(int i) {
        if (c() == 2) {
            int xj = com.bytedance.msdk.core.d.u.xj(this.xj, i, y());
            if (this.q != 0 && xj != 0) {
                return xj;
            }
        }
        return this.q;
    }

    public void u(int i) {
        this.n = i;
    }

    public void v(int i) {
        this.l = i;
    }

    public void w(int i) {
        this.tj = i;
    }

    public int xj() {
        return this.s;
    }

    public void y(int i) {
        this.wo = i;
    }

    public void yo(int i) {
        this.en = i;
    }

    public void c(long j) {
        this.c = j;
    }

    public void hf(double d) {
        if (d < 0.01d || d > 1.0d) {
            d = 0.01d;
        }
        this.yy = d;
    }

    public void kd(double d) {
        this.am = d;
    }

    public void u(double d) {
        this.g = d;
    }

    public void w(double d) {
        this.z = d;
    }

    public void xj(double d) {
        if (d < 0.1d || d > 1.0d) {
            d = 0.1d;
        }
        this.hl = d;
    }

    public void y(long j) {
        this.y = j;
    }

    public static hf c(String str) {
        if (TextUtils.isEmpty(str)) {
            com.bytedance.msdk.xj.kd.w.xj("AdsenseRitConfig", "TMe jsonStr is null or empty");
            return null;
        }
        try {
            return xj(new JSONObject(str), true);
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    public void hf(long j) {
        this.f10129io = j;
    }

    public void kd(long j) {
        this.kd = j;
    }

    public void u(String str) {
        this.xj = str;
    }

    public void w(long j) {
        this.e = j;
    }

    public void xj(long j) {
        if (j < 1000) {
            j = 1000;
        }
        this.vm = j;
    }

    public tf y(String str) {
        List<tf> list;
        if (!TextUtils.isEmpty(str) && (list = this.d) != null && list.size() != 0) {
            for (tf tfVar : this.d) {
                if (str.equals(tfVar.yo())) {
                    return tfVar;
                }
            }
        }
        return null;
    }

    public void hf(String str) {
        this.v = str;
    }

    public void kd(String str) {
        this.jk = str;
    }

    public void u(long j) {
        this.u = j;
    }

    public void w(String str) {
        this.f = str;
    }

    public void xj(com.bytedance.msdk.core.f.c cVar) {
        this.b = cVar;
    }

    private void u(List<tf> list) {
        int i;
        List<tf> list2;
        if (list == null) {
            return;
        }
        this.p.clear();
        int i2 = -1000;
        for (int i3 = 0; i3 < list.size(); i3++) {
            tf tfVar = list.get(i3);
            if (tfVar != null) {
                if (tfVar.dk() != i2) {
                    list2 = new ArrayList<>();
                    i = tfVar.dk();
                } else {
                    i = i2;
                    list2 = this.p.get(Integer.valueOf(i2));
                }
                if (list2 != null) {
                    list2.add(tfVar);
                    this.p.put(Integer.valueOf(i), list2);
                }
                i2 = i;
            }
        }
    }

    private void w(List<tf> list) {
        int i;
        List<tf> list2;
        if (list == null) {
            return;
        }
        this.p.clear();
        int i2 = -1000;
        for (int i3 = 0; i3 < list.size(); i3++) {
            tf tfVar = list.get(i3);
            if (tfVar != null) {
                if (tfVar.v() == 0) {
                    list2 = new ArrayList<>();
                    i = tfVar.et();
                } else if (tfVar.dk() != i2) {
                    list2 = new ArrayList<>();
                    i = tfVar.dk();
                } else {
                    i = i2;
                    list2 = this.p.get(Integer.valueOf(i2));
                }
                if (list2 != null) {
                    list2.add(tfVar);
                    this.p.put(Integer.valueOf(i), list2);
                }
                i2 = i;
            }
        }
    }

    public void hf(boolean z) {
        this.ai = z;
    }

    public void xj(com.bytedance.msdk.core.f.d dVar) {
        this.r = dVar;
    }

    public void hf(List<tf> list) {
        int i;
        List<tf> list2;
        w(list);
        this.d = list;
        if (list == null) {
            return;
        }
        this.qt = 0;
        this.tf.clear();
        this.f10130pl.clear();
        this.zg = this.d.size();
        int i2 = -1000;
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            tf tfVar = list.get(i3);
            if (tfVar != null) {
                if (tfVar.v() == 0) {
                    this.qt++;
                    list2 = new ArrayList<>();
                    i = tfVar.et();
                } else if (tfVar.dk() != i2) {
                    this.qt++;
                    list2 = new ArrayList<>();
                    i = tfVar.dk();
                } else {
                    i = i2;
                    list2 = this.tf.get(Integer.valueOf(i2));
                }
                if (list2 != null) {
                    list2.add(tfVar);
                    this.tf.put(Integer.valueOf(i), list2);
                }
                i2 = i;
            }
        }
        this.f10130pl.addAll(this.tf.keySet());
    }

    public void xj(String str) {
        this.dk = str;
    }

    public void xj(boolean z) {
        this.x = z;
    }

    public void xj(List<tf> list) {
        int i;
        List<tf> list2;
        u(list);
        this.d = list;
        if (list == null) {
            return;
        }
        this.qt = 0;
        this.tf.clear();
        this.f10130pl.clear();
        this.zg = this.d.size();
        int i2 = -1000;
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            tf tfVar = list.get(i3);
            if (tfVar != null) {
                if (tfVar.dk() != i2) {
                    this.qt++;
                    list2 = new ArrayList<>();
                    i = tfVar.dk();
                } else {
                    i = i2;
                    list2 = this.tf.get(Integer.valueOf(i2));
                }
                if (list2 != null) {
                    list2.add(tfVar);
                    this.tf.put(Integer.valueOf(i), list2);
                }
                i2 = i;
            }
        }
        this.f10130pl.addAll(this.tf.keySet());
    }

    public void xj(JSONObject jSONObject) {
        this.eu = jSONObject;
    }

    public static hf xj(JSONObject jSONObject, boolean z) {
        String str;
        JSONObject jSONObject2;
        tf tfVar;
        String str2;
        int i;
        String str3;
        String str4 = null;
        if (jSONObject == null) {
            return null;
        }
        hf hfVar = new hf();
        hfVar.xj(jSONObject);
        hfVar.w(jSONObject.optDouble("bid_floor", 0.0d));
        hfVar.u(jSONObject.optString("rit_id"));
        hfVar.w(jSONObject.optString("version"));
        hfVar.w(jSONObject.optLong("waterfall_id", -1L));
        hfVar.qt(jSONObject.optInt("rit_type"));
        hfVar.zg(jSONObject.optInt("look_type", 1));
        hfVar.u(jSONObject.optLong("time_min", ht(hfVar.a()).longValue()));
        hfVar.kd(jSONObject.optLong("layer_time_out", 2000L));
        hfVar.y(jSONObject.optLong("total_time_out", ra(hfVar.a()).longValue()));
        hfVar.hf(jSONObject.optLong("multilevel_time_out", 2000L));
        hfVar.c(jSONObject.optLong("cache_time_out", 3000L));
        hfVar.g(jSONObject.optInt("req_type", 0));
        com.bytedance.msdk.core.kd.hf.u.xj().xj(hfVar.ff(), hfVar.ht());
        hfVar.am(jSONObject.optInt("segment_id"));
        hfVar.hf(jSONObject.optString("segment_version"));
        hfVar.xj(jSONObject.optString("waterfall_extra"));
        hfVar.pl(jSONObject.optInt("multilevel_after_p", 1));
        hfVar.p(jSONObject.optInt("refresh_time", 0));
        hfVar.c(jSONObject.optInt("is_refresh", 0));
        hfVar.f(jSONObject.optInt("refresh_num", 2));
        hfVar.v(jSONObject.optInt("parallel_type", 1));
        hfVar.kd(jSONObject.optInt("is_adprime", 0));
        hfVar.jk(jSONObject.optInt("req_parallel_num", 2));
        hfVar.e(jSONObject.optInt("reward_start_time", 15000));
        hfVar.yo(jSONObject.optInt("reward_callback_type"));
        hfVar.xj(jSONObject.optLong("req_interval", 1000L));
        hfVar.hf(jSONObject.optDouble("total_time_rate", 0.01d));
        hfVar.xj(jSONObject.optDouble("layer_time_rate", 0.1d));
        hfVar.hf(jSONObject.optInt("support_render_control", 0));
        hfVar.pz(jSONObject.optInt("behavior_ttl"));
        int optInt = jSONObject.optInt(PointParamKey.AD_COUNT, 0);
        if (optInt < 0) {
            optInt = 0;
        } else if (optInt > 3) {
            optInt = 3;
        }
        hfVar.d(optInt);
        hfVar.w(jSONObject.optInt("group_type"));
        hfVar.u(jSONObject.optInt("bidding_time_out", 1000));
        String optString = jSONObject.optString("waterfall_abtest");
        if (optString != null) {
            hfVar.kd(optString);
        }
        int optInt2 = jSONObject.optInt("waterfall_timing_mode");
        hfVar.y(optInt2);
        if (hfVar.p()) {
            JSONObject optJSONObject = jSONObject.optJSONObject("waterfall_show_pacing_rule");
            if (optJSONObject == null) {
                str3 = "waterfall_show_rules_version";
            } else {
                String str5 = hfVar.ff();
                String optString2 = jSONObject.optString("waterfall_show_rules_version");
                String optString3 = optJSONObject.optString("waterfall_show_pacing");
                String optString4 = optJSONObject.optString("waterfall_show_pacing_rule_id");
                str3 = "waterfall_show_rules_version";
                hfVar.xj(new com.bytedance.msdk.core.f.d(str5, "", optString2, "", optInt2, optString3, optString4));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("waterfall_show_freqctl_rules");
            hfVar.xj(new com.bytedance.msdk.core.f.c(hfVar.ff(), "", jSONObject.optString(str3), "", optInt2, optJSONArray == null ? "[]" : optJSONArray.toString()));
        }
        if (jSONObject.optInt("is_ra") == 1) {
            com.bytedance.msdk.core.admanager.reward.rewardagain.xj xjVar = new com.bytedance.msdk.core.admanager.reward.rewardagain.xj();
            xjVar.xj(jSONObject.optString("ra_id"));
            xjVar.hf(jSONObject.optInt("ra_max", 0));
            xjVar.hf(jSONObject.optDouble("ra_ecpm"));
            xjVar.xj(jSONObject.optLong("ra_in", 0L));
            xjVar.xj(jSONObject.optInt("ra_h_max", 0));
            xjVar.xj(jSONObject.optDouble("ra_ra"));
            com.bytedance.msdk.core.admanager.reward.rewardagain.w.xj(hfVar.ff(), xjVar);
        } else {
            com.bytedance.msdk.core.admanager.reward.rewardagain.w.tf(hfVar.ff());
        }
        hfVar.xj(jSONObject.optInt("is_smaste", 0));
        JSONArray optJSONArray2 = jSONObject.optJSONArray("adn_rit_conf");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray2 != null) {
            int i2 = 0;
            while (i2 < optJSONArray2.length()) {
                try {
                    jSONObject2 = optJSONArray2.getJSONObject(i2);
                    tfVar = new tf();
                    tfVar.w(jSONObject2.optString(MediationConstant.EXTRA_ADN_NAME));
                    if (com.bytedance.msdk.core.hf.hf().w(jSONObject2.optString(MediationConstant.EXTRA_ADN_NAME))) {
                        tfVar.u(jSONObject2.optString("custom_adn_name"));
                    } else {
                        tfVar.u(str4);
                    }
                    tfVar.c(hfVar.hl());
                    String optString5 = jSONObject2.optString("adn_slot_id");
                    tfVar.kd(optString5);
                    if (!z && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(hfVar.ff())) {
                        com.bytedance.msdk.w.f.u.hf.put(optString5, hfVar.ff());
                    }
                    tfVar.xj(jSONObject2.optInt("is_refresh", 0));
                    int optInt3 = jSONObject2.optInt("freqctl_timing_mode");
                    tfVar.hf(optInt3);
                    if (tfVar.u()) {
                        try {
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("show_pacing_rule");
                            if (optJSONObject2 != null) {
                                str = str4;
                                try {
                                    str2 = optString5;
                                    i = optInt3;
                                    tfVar.xj(new com.bytedance.msdk.core.f.d(hfVar.ff(), str2, "", "", i, optJSONObject2.optString("pacing"), optJSONObject2.optString("rule_id")));
                                } catch (JSONException e) {
                                    e = e;
                                    pl.xj(e);
                                    i2++;
                                    str4 = str;
                                }
                            } else {
                                str = str4;
                                str2 = optString5;
                                i = optInt3;
                            }
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray("show_freqctl_rules");
                            tfVar.xj(new com.bytedance.msdk.core.f.c(hfVar.ff(), str2, "", jSONObject2.optString("show_freqctl_rules_version"), i, optJSONArray3 == null ? "[]" : optJSONArray3.toString()));
                        } catch (JSONException e2) {
                            e = e2;
                            str = str4;
                        }
                    } else {
                        str = str4;
                    }
                    tfVar.tf(jSONObject2.optInt("req_bidding_type"));
                    tfVar.y(jSONObject2.optString("slot_cpm", Constants.FAIL));
                    tfVar.hf(jSONObject2.optString("exchange_rate"));
                    tfVar.p(jSONObject2.optInt("load_sort"));
                    tfVar.pl(jSONObject2.optInt("show_sort"));
                    tfVar.u(jSONObject2.optInt("ad_expired_time", 1800000));
                    com.bytedance.msdk.core.kd.hf.u.xj().xj(hfVar.ff(), tfVar.yo(), tfVar.f());
                    com.bytedance.msdk.core.kd.xj.xj.xj().xj(hfVar.ff(), tfVar.yo(), tfVar.f());
                    tfVar.f(jSONObject2.optInt("if_is_ready", 1));
                    com.bytedance.msdk.core.kd.hf.u.xj().hf(hfVar.ff(), tfVar.yo(), tfVar.pl());
                    com.bytedance.msdk.core.kd.xj.xj.xj().hf(hfVar.ff(), tfVar.yo(), tfVar.pl());
                    tfVar.kd(jSONObject2.optInt("if_reuse_ads", 0));
                    com.bytedance.msdk.core.kd.xj.xj.xj().w(hfVar.ff(), tfVar.yo(), tfVar.d());
                    tfVar.c(jSONObject2.optInt("if_pre_request", 0));
                    com.bytedance.msdk.core.kd.xj.xj.xj().y(hfVar.ff(), tfVar.yo(), tfVar.p());
                    tfVar.d(hfVar.a());
                    tfVar.xj("%1$s%2$sAdapter");
                    tfVar.y(jSONObject2.optInt("origin_type"));
                    tfVar.w(jSONObject2.optInt("sub_adtype"));
                    tfVar.xj(hf(jSONObject2.optJSONObject("multilevel_slot_cpm")));
                } catch (JSONException e3) {
                    e = e3;
                    str = str4;
                }
                if (tfVar.v() == 1) {
                    hfVar.hf(true);
                } else if (tfVar.v() == 2) {
                    hfVar.xj(true);
                } else {
                    if (tfVar.v() == 3) {
                        try {
                            hfVar.hf(true);
                        } catch (JSONException e4) {
                            e = e4;
                            pl.xj(e);
                            i2++;
                            str4 = str;
                        }
                    } else if (tfVar.v() != 100) {
                        if (hfVar.dk() == -1.0d || hfVar.dk() < tfVar.ra()) {
                            hfVar.u(tfVar.ra());
                        }
                        if (hfVar.et() == -1.0d || hfVar.et() > tfVar.ra()) {
                            hfVar.kd(tfVar.ra());
                        }
                    }
                    tfVar.d(jSONObject2.optString("customer_adapter_json"));
                    arrayList.add(tfVar);
                    i2++;
                    str4 = str;
                }
                tfVar.d(jSONObject2.optString("customer_adapter_json"));
                arrayList.add(tfVar);
                i2++;
                str4 = str;
            }
        }
        Collections.sort(arrayList);
        if (hfVar.pl()) {
            hfVar.hf(arrayList);
        } else {
            hfVar.xj(arrayList);
        }
        return hfVar;
    }

    private static Map<String, String> hf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            if (keys == null) {
                return null;
            }
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    hashMap.put(next, optString);
                }
            }
            if (hashMap.size() == 0) {
                return null;
            }
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public void e(int i) {
        this.j = i;
    }

    public void zg(int i) {
        this.w = i;
    }
}
