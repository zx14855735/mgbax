package com.bytedance.msdk.w.u;

import J3FDQU.A2egSU;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.msdk.f.am;
import com.bytedance.msdk.f.dk;
import com.bytedance.msdk.f.e;
import com.bytedance.msdk.f.pz;
import com.bytedance.msdk.f.q;
import com.bytedance.msdk.f.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.model.AdnName;
import java.lang.ref.SoftReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf implements com.bytedance.msdk.w.hf.xj.xj {
    protected com.bytedance.sdk.openadsdk.zg.w.xj.hf am;
    protected com.bytedance.msdk.core.tf.hf c;
    protected com.bytedance.msdk.xj.hf.y d;
    protected SoftReference<Context> f;
    protected com.bytedance.msdk.api.u.xj.hf g;
    protected String kd;
    protected com.bytedance.msdk.hf.w u;
    protected com.bytedance.msdk.w.y.xj.hf w;
    protected com.bytedance.msdk.api.xj.hf y;
    protected boolean tf = false;
    protected int p = 0;

    /* renamed from: pl, reason: collision with root package name */
    protected volatile boolean f10153pl = false;
    private final Comparator<com.bytedance.msdk.core.tf.tf> xj = new Comparator<com.bytedance.msdk.core.tf.tf>() { // from class: com.bytedance.msdk.w.u.hf.1
        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.msdk.core.tf.tf tfVar, com.bytedance.msdk.core.tf.tf tfVar2) {
            int dk;
            int dk2;
            if (tfVar.dk() == tfVar2.dk()) {
                dk = tfVar.et();
                dk2 = tfVar2.et();
            } else {
                dk = tfVar.dk();
                dk2 = tfVar2.dk();
            }
            return dk - dk2;
        }
    };
    protected final Comparator<com.bytedance.msdk.core.tf.tf> qt = new Comparator<com.bytedance.msdk.core.tf.tf>() { // from class: com.bytedance.msdk.w.u.hf.2
        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.msdk.core.tf.tf tfVar, com.bytedance.msdk.core.tf.tf tfVar2) {
            if (tfVar.ra() > tfVar2.ra()) {
                return -1;
            }
            return tfVar.ra() < tfVar2.ra() ? 1 : 0;
        }
    };

    public hf(Context context) {
        this.f = new SoftReference<>(context);
    }

    private void u(com.bytedance.msdk.hf.w wVar) {
        HashMap hashMap;
        if (wVar == null || this.y == null) {
            return;
        }
        if (TextUtils.equals(wVar.gh(), MediationConstant.ADN_XIAOMI)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("ecpm", Long.valueOf((long) wVar.da()));
            wVar.hf(hashMap2);
            return;
        }
        if (this.y.wo()) {
            if (wVar.vi() || wVar.lm() || wVar.si()) {
                if (TextUtils.equals(wVar.gh(), "baidu")) {
                    hashMap = new HashMap();
                    if (com.bytedance.msdk.core.hf.hf().bl()) {
                        com.bytedance.msdk.hf.w w = w(wVar);
                        A2egSU.BNL6CD(w != null ? (int) w.da() : 0, hashMap, "ecpm", 10, SplashAd.KEY_BIDFAIL_ADN);
                        hashMap.put("ad_t", 7);
                        hashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        hashMap.put("bid_t", 3);
                    } else if (com.bytedance.msdk.core.hf.hf().lw()) {
                        com.bytedance.msdk.hf.w w2 = w(wVar);
                        int da = w2 != null ? (int) w2.da() : 0;
                        int da2 = (int) wVar.da();
                        int nextInt = new SecureRandom().nextInt(21) + 10;
                        StringBuilder B7CMnp2 = A2egSU.B7CMnp(da2, da, "-------baidu_bid_win firstAdEcpm = ", " secondAdEcpm =", " randomNumber = ");
                        B7CMnp2.append(nextInt);
                        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, B7CMnp2.toString());
                        hashMap.put("ecpm", Integer.valueOf(Math.max(da2 - nextInt, da)));
                        hashMap.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                        hashMap.put("ad_t", 7);
                        hashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        hashMap.put("bid_t", 4);
                    } else {
                        A2egSU.BNL6CD(0, hashMap, "ecpm", 10, SplashAd.KEY_BIDFAIL_ADN);
                        hashMap.put("ad_t", 7);
                        hashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        hashMap.put("bid_t", 4);
                    }
                } else if (TextUtils.equals(wVar.gh(), "ks")) {
                    hashMap = new HashMap();
                    if (com.bytedance.msdk.core.hf.hf().wa()) {
                        com.bytedance.msdk.hf.w w3 = w(wVar);
                        hashMap.put("bidEcpm", Double.valueOf(wVar.da()));
                        hashMap.put("lossBidEcpm", Double.valueOf(w3 != null ? w3.da() : 0.0d));
                    } else {
                        A2egSU.BNL6CD(0, hashMap, "bidEcpm", 0, "lossBidEcpm");
                    }
                } else {
                    hashMap = null;
                }
                wVar.hf(hashMap);
            }
        }
    }

    private com.bytedance.msdk.hf.w w(com.bytedance.msdk.hf.w wVar) {
        LinkedList<com.bytedance.msdk.hf.w> linkedList = new LinkedList();
        com.bytedance.msdk.w.y.xj.hf hfVar = this.w;
        if (hfVar != null) {
            if (hfVar.tf() != null && this.w.tf().size() != 0) {
                linkedList.addAll(this.w.tf());
            }
            if (this.w.f() != null && this.w.f().size() != 0) {
                linkedList.addAll(this.w.f());
            }
            if (this.w.c() != null && this.w.c().size() != 0) {
                linkedList.addAll(this.w.c());
            }
        }
        com.bytedance.msdk.hf.w wVar2 = null;
        if (linkedList.size() != 0 && wVar != null) {
            double d = Double.MIN_NORMAL;
            for (com.bytedance.msdk.hf.w wVar3 : linkedList) {
                if (wVar3.da() < wVar.da() && wVar3.da() > d) {
                    d = wVar3.da();
                    wVar2 = wVar3;
                }
            }
        }
        return wVar2;
    }

    public List<com.bytedance.msdk.core.tf.tf> am() {
        com.bytedance.msdk.core.tf.hf hfVar = this.c;
        if (hfVar == null || hfVar.yy() == null || this.c.yy().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.core.tf.tf tfVar : this.c.yy()) {
            if (tfVar != null && tfVar.v() == 100) {
                arrayList.add(tfVar);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.msdk.w.hf.xj.xj
    public void c() {
    }

    public com.bytedance.msdk.w.w.xj.c d() {
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "ad load start.....");
        if (com.bytedance.msdk.core.hf.hf().j()) {
            com.bytedance.msdk.kd.y.xj((com.bytedance.msdk.hf.w) null, this.w.v(), v.xj(), 3);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bytedance.msdk.w.w.xj.p());
        arrayList.add(new com.bytedance.msdk.w.w.xj.pl());
        arrayList.add(new com.bytedance.msdk.w.w.xj.kd());
        arrayList.add(new com.bytedance.msdk.w.w.xj.w());
        arrayList.add(new com.bytedance.msdk.w.w.xj.g());
        arrayList.add(new com.bytedance.msdk.w.w.xj.y());
        arrayList.add(new com.bytedance.msdk.w.w.xj.f());
        arrayList.add(new com.bytedance.msdk.w.w.xj.hf());
        arrayList.add(new com.bytedance.msdk.w.w.xj.u());
        com.bytedance.msdk.w.w.xj.c cVar = new com.bytedance.msdk.w.w.xj.c(arrayList);
        cVar.xj(this.w);
        return cVar;
    }

    public int e() {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            return wVar.nb();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.w.hf.xj.xj
    public void f() {
    }

    public boolean g() {
        boolean w = dk.w(com.bytedance.msdk.core.hf.getContext());
        boolean hf = dk.hf(com.bytedance.msdk.core.hf.getContext());
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.kd) + "setting 下发是否为弱网执行：" + com.bytedance.msdk.core.hf.hf().pl() + "，当前网络环境：2G-type=" + w + ",3G-type=" + hf);
        if (com.bytedance.msdk.core.hf.hf().pl()) {
            return w || hf;
        }
        return false;
    }

    @Override // com.bytedance.msdk.w.hf.xj.xj
    public void hf(com.bytedance.msdk.api.xj xjVar) {
    }

    public com.bytedance.msdk.api.xj.hf jk() {
        return this.y;
    }

    public List<com.bytedance.msdk.api.w> p() {
        if (!com.bytedance.msdk.core.hf.hf().dk()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<com.bytedance.msdk.hf.w> it = this.w.tf().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.hf.w next = it.next();
            if (next != null) {
                arrayList.add(am.xj(this.y, next, false));
            }
        }
        return arrayList;
    }

    public List<com.bytedance.msdk.api.w> pl() {
        if (!com.bytedance.msdk.core.hf.hf().dk()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.hf.w wVar : this.w.jk()) {
            if (wVar != null) {
                arrayList.add(am.xj(this.y, wVar, false));
            }
        }
        return arrayList;
    }

    public com.bytedance.msdk.api.w qt() {
        if (this.u == null || e.xj()) {
            return null;
        }
        return am.xj(this.y, this.u, true);
    }

    public List<com.bytedance.msdk.api.hf> tf() {
        return this.w.et();
    }

    public int v() {
        com.bytedance.msdk.api.xj.hf hfVar = this.y;
        if (hfVar != null) {
            return hfVar.kd();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.w.hf.xj.xj
    public void xj(String str) {
    }

    public Map<String, Object> yo() {
        com.bytedance.msdk.hf.w wVar = this.u;
        Map<String, Object> q = wVar != null ? wVar.q() : null;
        if (q == null) {
            q = w(this.kd);
        }
        com.bytedance.msdk.hf.w wVar2 = this.u;
        if (wVar2 != null && wVar2.dc() != null) {
            q.putAll(this.u.dc());
        }
        if (e.xj()) {
            String xj = e.xj(am.xj(this.y, this.u, true));
            if (!TextUtils.isEmpty(xj)) {
                q.put("get_show_ecpm_info", xj);
            }
        }
        return q;
    }

    public com.bytedance.msdk.api.w zg() {
        List<com.bytedance.msdk.hf.w> jk;
        com.bytedance.msdk.api.xj.hf hfVar = this.y;
        if ((hfVar != null && !hfVar.dq() && !com.bytedance.msdk.core.hf.hf().dk()) || (jk = this.w.jk()) == null || jk.size() == 0) {
            return null;
        }
        return am.xj(this.y, jk.get(0), false);
    }

    public static int hf(String str) {
        if (!com.bytedance.msdk.core.f.g.xj().f(str)) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--: 命中展示频次");
            return 840041;
        }
        if (com.bytedance.msdk.core.f.g.xj().w(str)) {
            return 0;
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--: 命中展示间隔");
        return 840042;
    }

    @Override // com.bytedance.msdk.w.hf.xj.xj
    public void xj(List<com.bytedance.msdk.hf.w> list, com.bytedance.msdk.api.xj xjVar) {
    }

    public void xj(com.bytedance.msdk.api.xj.hf hfVar) {
        com.bytedance.msdk.w.y.xj.hf xj = com.bytedance.msdk.w.y.xj.hf.xj(this.f, hfVar, this);
        this.w = xj;
        com.bytedance.msdk.api.xj.hf v = xj.v();
        this.y = v;
        this.kd = v.ra();
        this.w.q().put("allow_show_close_btn", Boolean.valueOf(hfVar.yo()));
        this.c = this.w.pl();
    }

    public HashMap<String, com.bytedance.msdk.hf.w> hf(List<com.bytedance.msdk.hf.w> list) {
        HashMap<String, com.bytedance.msdk.hf.w> hashMap = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (com.bytedance.msdk.hf.w wVar : list) {
                if (wVar != null) {
                    hashMap.put(wVar.cy(), wVar);
                }
            }
        }
        return hashMap;
    }

    public void xj() {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            wVar.yo();
        }
        this.w.wo();
        this.d = null;
    }

    public void hf(com.bytedance.msdk.hf.w wVar) {
        com.bytedance.msdk.api.xj.hf hfVar = this.y;
        int f = wVar.f(hfVar != null ? hfVar.xj() : null);
        wVar.d(3);
        wVar.tf(f);
    }

    public void xj(com.bytedance.msdk.hf.w wVar) {
        if (com.bytedance.msdk.core.hf.hf().j()) {
            com.bytedance.msdk.kd.y.xj(wVar, this.y, v.xj(), 2);
        }
    }

    private com.bytedance.msdk.hf.w w(List<com.bytedance.msdk.hf.w> list) {
        com.bytedance.msdk.hf.w wVar = null;
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                return list.get(0);
            }
            double d = Double.MIN_NORMAL;
            for (com.bytedance.msdk.hf.w wVar2 : list) {
                if (wVar2.da() > d) {
                    d = wVar2.da();
                    wVar = wVar2;
                }
            }
        }
        return wVar;
    }

    public List<com.bytedance.msdk.core.tf.tf> hf() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.w.y.xj.hf hfVar = this.w;
        if (hfVar == null || this.c == null || hfVar.y()) {
            return arrayList;
        }
        Map<Integer, List<com.bytedance.msdk.core.tf.tf>> io2 = this.c.io();
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : io2.keySet()) {
            if (num != null) {
                arrayList2.add(num);
            }
        }
        com.bytedance.msdk.core.c.hf.xj(arrayList2);
        int i = 0;
        if (arrayList2.size() > 0) {
            int i2 = 0;
            z = false;
            while (i < arrayList2.size()) {
                Integer num2 = (Integer) arrayList2.get(i);
                if (num2 != null) {
                    int intValue = num2.intValue();
                    if (intValue == -100) {
                        i2 = 1;
                    }
                    if (intValue < -100) {
                        z = true;
                    }
                    if (io2.get(num2) != null) {
                        arrayList.addAll(io2.get(num2));
                    }
                }
                i++;
            }
            i = i2;
        } else {
            z = false;
        }
        if (i == 0 && this.c.j() && !q.hf(this.w.tf())) {
            Iterator<com.bytedance.msdk.hf.w> it = this.w.tf().iterator();
            while (it.hasNext()) {
                com.bytedance.msdk.hf.w next = it.next();
                if (this.c != null && (next.vi() || next.lm())) {
                    com.bytedance.msdk.core.tf.tf y = this.c.y(next.cy());
                    if (y != null) {
                        arrayList.add(y);
                    }
                }
            }
        }
        if (!z) {
            List<com.bytedance.msdk.core.tf.tf> am = am();
            if (!q.xj(am)) {
                arrayList.addAll(am);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (((com.bytedance.msdk.core.tf.tf) it2.next()) == null) {
                it2.remove();
            }
        }
        if (!this.c.z() && !this.c.j()) {
            Collections.sort(arrayList, this.xj);
            return arrayList;
        }
        return u(arrayList);
    }

    public void xj(List<com.bytedance.msdk.hf.w> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.msdk.core.u.xj.xj(this.y, this.c, list, this.w.tf());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            u((com.bytedance.msdk.hf.w) it.next());
        }
        if (this.w.tf().size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.w.tf());
        com.bytedance.msdk.hf.w w = w(list);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            com.bytedance.msdk.hf.w wVar = (com.bytedance.msdk.hf.w) it2.next();
            Iterator<com.bytedance.msdk.hf.w> it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    xj(w, wVar, 1);
                    break;
                }
                com.bytedance.msdk.hf.w next = it3.next();
                if (next == null || wVar == null || next != wVar) {
                }
            }
        }
    }

    public static Map<String, Object> w(String str) {
        pz pzVar = new pz();
        pzVar.put(MediationConstant.KEY_GM_PRIME_RIT, str);
        return pzVar;
    }

    public void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.hf.w wVar2, int i) {
        if (wVar2 == null || this.y == null || i <= 0) {
            return;
        }
        if (TextUtils.equals(wVar2.gh(), MediationConstant.ADN_XIAOMI)) {
            HashMap hashMap = new HashMap();
            hashMap.put("ecpm", Long.valueOf(wVar != null ? (long) wVar.da() : 0L));
            hashMap.put(MediationConstant.KEY_REASON, "其他");
            hashMap.put("adn_id", 1);
            wVar2.xj((Map<String, Object>) hashMap);
            return;
        }
        if (this.y.wo()) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(MediationConstant.BIDDING_LOSE_REASON, com.bytedance.sdk.openadsdk.core.wo.xj.hf.xj(i));
            hashMap2.put("bidding_lose_reason_NUM", Integer.valueOf(i));
            if (TextUtils.equals(wVar2.gh(), "baidu")) {
                if (com.bytedance.msdk.core.hf.hf().bl()) {
                    A2egSU.BNL6CD(wVar != null ? (int) wVar.da() : 0, hashMap2, "ecpm", 10, SplashAd.KEY_BIDFAIL_ADN);
                    hashMap2.put("ad_t", 7);
                    hashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    hashMap2.put("bid_t", 3);
                    A2egSU.BNL6CD(203, hashMap2, MediationConstant.KEY_REASON, 1, "is_s");
                    hashMap2.put("is_c", 2);
                } else if (com.bytedance.msdk.core.hf.hf().lw()) {
                    A2egSU.BNL6CD(wVar != null ? (int) wVar.da() : 0, hashMap2, "ecpm", 10, SplashAd.KEY_BIDFAIL_ADN);
                    hashMap2.put("ad_t", 7);
                    hashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    hashMap2.put("bid_t", 4);
                    A2egSU.BNL6CD(203, hashMap2, MediationConstant.KEY_REASON, 1, "is_s");
                    hashMap2.put("is_c", 2);
                } else {
                    A2egSU.BNL6CD(0, hashMap2, "ecpm", 10, SplashAd.KEY_BIDFAIL_ADN);
                    hashMap2.put("ad_t", 7);
                    hashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    hashMap2.put("bid_t", 4);
                    A2egSU.BNL6CD(203, hashMap2, MediationConstant.KEY_REASON, 1, "is_s");
                    hashMap2.put("is_c", 2);
                }
            } else if (TextUtils.equals(wVar2.gh(), "ks")) {
                if (com.bytedance.msdk.core.hf.hf().wa()) {
                    hashMap2.put("failureCode", 2);
                    hashMap2.put("bidEcpm", Double.valueOf(wVar != null ? wVar.da() : 0.0d));
                    hashMap2.put("adType", 2);
                    hashMap2.put(MediationConstant.KEY_ADN_NAME, AdnName.OTHER);
                } else {
                    A2egSU.BNL6CD(0, hashMap2, "failureCode", 0, "bidEcpm");
                    hashMap2.put("adType", 2);
                    hashMap2.put(MediationConstant.KEY_ADN_NAME, AdnName.OTHER);
                }
            }
            wVar2.xj((Map<String, Object>) hashMap2);
        }
    }

    private List<com.bytedance.msdk.core.tf.tf> u(List<com.bytedance.msdk.core.tf.tf> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.bytedance.msdk.core.tf.tf> it = list.iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.core.tf.tf next = it.next();
            if (next.en()) {
                it.remove();
                arrayList2.add(next);
            } else if (next.z() || next.l() || next.j()) {
                it.remove();
                com.bytedance.msdk.core.tf.tf tfVar = new com.bytedance.msdk.core.tf.tf();
                tfVar.kd(next.yo());
                tfVar.tf(next.v());
                tfVar.w(next.qt());
                tfVar.u(next.f());
                tfVar.xj(next.c());
                tfVar.p(next.dk());
                tfVar.pl(next.et());
                tfVar.d(next.g());
                StringBuilder sb = new StringBuilder();
                sb.append(next.ra());
                tfVar.y(sb.toString());
                tfVar.hf(next.am());
                tfVar.c(next.io());
                tfVar.f(next.x());
                tfVar.xj(next.ai());
                com.bytedance.msdk.hf.w xj = xj(tfVar);
                if (xj != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(xj.zb());
                    tfVar.y(sb2.toString());
                }
                arrayList.add(tfVar);
            }
        }
        list.addAll(arrayList);
        Collections.sort(list, this.qt);
        Collections.sort(arrayList2, this.xj);
        list.addAll(0, arrayList2);
        return list;
    }

    private com.bytedance.msdk.hf.w xj(com.bytedance.msdk.core.tf.tf tfVar) {
        if (tfVar == null) {
            return null;
        }
        String yo = tfVar.yo();
        String w = tfVar.ai() != null ? tfVar.ai().w() : null;
        if (TextUtils.isEmpty(yo)) {
            return null;
        }
        Iterator<com.bytedance.msdk.hf.w> it = this.w.c().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.hf.w next = it.next();
            if (next != null && yo.equals(next.cy())) {
                return next;
            }
        }
        Iterator<com.bytedance.msdk.hf.w> it2 = this.w.f().iterator();
        while (it2.hasNext()) {
            com.bytedance.msdk.hf.w next2 = it2.next();
            if (next2 != null && yo.equals(next2.cy())) {
                return next2;
            }
        }
        Iterator<com.bytedance.msdk.hf.w> it3 = this.w.tf().iterator();
        while (it3.hasNext()) {
            com.bytedance.msdk.hf.w next3 = it3.next();
            if (next3 != null) {
                if (next3.si() && !TextUtils.isEmpty(w) && !TextUtils.isEmpty(next3.b())) {
                    if (yo.equals(next3.cy()) && w.equals(next3.b())) {
                        return next3;
                    }
                } else if (yo.equals(next3.cy())) {
                    return next3;
                }
            }
        }
        return null;
    }

    public void xj(com.bytedance.msdk.api.u.xj.hf hfVar) {
        this.g = hfVar;
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        this.am = hfVar;
    }
}
