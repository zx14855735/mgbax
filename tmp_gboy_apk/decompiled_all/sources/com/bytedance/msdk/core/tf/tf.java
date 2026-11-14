package com.bytedance.msdk.core.tf;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import com.bytedance.msdk.f.p;
import com.czhj.sdk.common.Constants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf implements Comparable<tf> {
    private int am;
    private int c;
    private int d;
    private com.bytedance.msdk.core.f.c dk;
    private int e;
    private int et;
    private int f;
    private int g;
    private String hf;
    private int ht;
    private int jk;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10131pl;
    private String pz;
    private int qt;
    private com.bytedance.msdk.core.f.d ra;
    private String tf;
    private Map<String, String> v;
    private String w;
    private String xj;
    private int y;
    private f yo;
    private int zg;
    private String u = "1";
    private String kd = Constants.FAIL;

    public boolean a() {
        return this.y == 0;
    }

    public f ai() {
        return this.yo;
    }

    public String am() {
        return this.u;
    }

    public String c() {
        return this.tf;
    }

    public int d() {
        return this.am;
    }

    public int dk() {
        return this.c;
    }

    public String e() {
        return TextUtils.isEmpty(this.xj) ? this.hf : this.xj;
    }

    public boolean en() {
        return this.y == 100;
    }

    public int et() {
        return this.f;
    }

    public int f() {
        return this.g;
    }

    public boolean ff() {
        return z() || j() || l();
    }

    public int g() {
        return this.d;
    }

    public com.bytedance.msdk.core.f.c hf() {
        return this.dk;
    }

    public double ht() {
        f fVar = this.yo;
        if (fVar != null && !TextUtils.isEmpty(fVar.y())) {
            try {
                return Double.valueOf(this.yo.y()).doubleValue();
            } catch (Exception e) {
                com.bytedance.msdk.xj.kd.w.u("WaterFallConfig", "getServerBiddingLoadEcpm error " + e.toString());
            }
        }
        return -1.0d;
    }

    public String io() {
        return this.p;
    }

    public boolean j() {
        return this.y == 1;
    }

    public boolean jk() {
        int i = this.y;
        return i == 0 || i == 100;
    }

    public tf kd() {
        ConcurrentHashMap concurrentHashMap;
        List<String> hf = p.hf();
        tf tfVar = new tf();
        tfVar.xj = this.xj;
        p.xj(hf, "mAdnetworkName");
        tfVar.w = this.w;
        p.xj(hf, "mAdnetwokrSlotId");
        tfVar.u = this.u;
        p.xj(hf, "mExchangeRate");
        tfVar.kd = this.kd;
        p.xj(hf, "mEcpm");
        tfVar.y = this.y;
        p.xj(hf, "mAdnetworkSlotType");
        tfVar.c = this.c;
        p.xj(hf, "mLoadSort");
        tfVar.f = this.f;
        p.xj(hf, "mShowSort");
        tfVar.d = this.d;
        p.xj(hf, "mRitType");
        tfVar.qt = this.qt;
        p.xj(hf, "originType");
        tfVar.jk = this.jk;
        p.xj(hf, "mSubAdType");
        tfVar.tf = this.tf;
        p.xj(hf, "mLoaderAdapterName");
        tfVar.p = this.p;
        p.xj(hf, "mWaterfallAbTestParam");
        tfVar.f10131pl = this.f10131pl;
        p.xj(hf, "mServerBiddingExtra");
        tfVar.g = this.g;
        p.xj(hf, "adExpiredTime");
        tfVar.am = this.am;
        p.xj(hf, "ifReuseAds");
        tfVar.zg = this.zg;
        p.xj(hf, "ifPreRequest");
        tfVar.e = this.e;
        p.xj(hf, "ifIsReady");
        tfVar.et = this.et;
        p.xj(hf, "isRefresh");
        tfVar.hf = this.hf;
        p.xj(hf, "mCustomAdnetworkName");
        Map<String, String> map = this.v;
        if (map == null || map.size() <= 0) {
            concurrentHashMap = null;
        } else {
            concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.putAll(this.v);
        }
        tfVar.v = concurrentHashMap;
        p.xj(hf, "mMultilevelSlotCpm");
        tfVar.pz = this.pz;
        p.xj(hf, "mCustomAdapterJson");
        tfVar.ht = this.ht;
        p.xj(hf, "mAdnRitTimingMode");
        tfVar.dk = this.dk;
        p.xj(hf, "mIntervalFreqctlBean");
        tfVar.ra = this.ra;
        p.xj(hf, "mIntervalPacingBean");
        p.hf(hf, "WaterFallConfig");
        return tfVar;
    }

    public boolean l() {
        return this.y == 3;
    }

    public int p() {
        return this.zg;
    }

    public int pl() {
        return this.e;
    }

    public double pz() {
        f fVar = this.yo;
        if (fVar != null && !TextUtils.isEmpty(fVar.kd())) {
            try {
                return Double.valueOf(this.yo.kd()).doubleValue();
            } catch (Exception e) {
                com.bytedance.msdk.xj.kd.w.u("WaterFallConfig", "getServerBiddingShowEcpm error " + e.toString());
            }
        }
        return -1.0d;
    }

    public Map<String, String> q() {
        return this.v;
    }

    public String qt() {
        return this.xj;
    }

    public boolean r() {
        return com.bytedance.msdk.core.hf.hf().w(this.xj);
    }

    public double ra() {
        try {
            return Double.valueOf(this.kd).doubleValue() * Double.valueOf(this.u).doubleValue();
        } catch (Exception e) {
            com.bytedance.msdk.xj.kd.w.u("WaterFallConfig", "getEcpm error " + e.toString());
            return 0.0d;
        }
    }

    public int tf() {
        return this.qt;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WaterFallConfig{mAdnetworkName='");
        sb.append(this.xj);
        sb.append("', mCustomAdnetworkName='");
        sb.append(this.hf);
        sb.append("', mAdnetwokrSlotId='");
        sb.append(this.w);
        sb.append("', mExchangeRate=");
        sb.append(this.u);
        sb.append(", mSlotEcpm=");
        sb.append(this.kd);
        sb.append(", mAdnetworkSlotType=");
        sb.append(this.y);
        sb.append(", mLoadSort=");
        sb.append(this.c);
        sb.append(", mShowSort=");
        return A2egSU.B2KMhB(sb, this.f, '}');
    }

    public boolean u() {
        return this.ht == 1;
    }

    public int v() {
        return this.y;
    }

    public com.bytedance.msdk.core.f.d w() {
        return this.ra;
    }

    public String wo() {
        return this.pz;
    }

    public String x() {
        return this.f10131pl;
    }

    public void xj(int i) {
        this.et = i;
    }

    public int y() {
        return this.jk;
    }

    public String yo() {
        return this.w;
    }

    public boolean z() {
        return this.y == 2;
    }

    public String zg() {
        return this.hf;
    }

    public void c(int i) {
        this.zg = i;
    }

    public void d(int i) {
        this.d = i;
    }

    public void f(int i) {
        this.e = i;
    }

    public void hf(int i) {
        this.ht = i;
    }

    public void p(int i) {
        this.c = i;
    }

    public void pl(int i) {
        this.f = i;
    }

    public void tf(int i) {
        this.y = i;
    }

    public void u(int i) {
        this.g = i;
    }

    public void w(int i) {
        this.jk = i;
    }

    public int xj() {
        return this.et;
    }

    public void y(int i) {
        this.qt = i;
    }

    public void c(String str) {
        this.p = str;
    }

    public void d(String str) {
        this.pz = str;
    }

    public void f(String str) {
        this.f10131pl = str;
    }

    public void hf(String str) {
        this.u = str;
    }

    public void u(String str) {
        this.hf = str;
    }

    public void w(String str) {
        this.xj = str;
    }

    public void xj(com.bytedance.msdk.core.f.c cVar) {
        this.dk = cVar;
    }

    public void y(String str) {
        if (TextUtils.isEmpty(str)) {
            str = Constants.FAIL;
        }
        this.kd = str;
    }

    public void xj(com.bytedance.msdk.core.f.d dVar) {
        this.ra = dVar;
    }

    public void xj(String str) {
        this.tf = str;
    }

    public void xj(f fVar) {
        this.yo = fVar;
    }

    public void xj(Map<String, String> map) {
        this.v = map;
    }

    @Override // java.lang.Comparable
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public int compareTo(tf tfVar) {
        if (tfVar == null || this.c > tfVar.dk()) {
            return 1;
        }
        if (this.c < tfVar.dk()) {
            return -1;
        }
        if (this.f > tfVar.et()) {
            return 1;
        }
        return this.f < tfVar.et() ? -1 : 0;
    }

    public void kd(int i) {
        this.am = i;
    }

    public void kd(String str) {
        this.w = str;
    }
}
