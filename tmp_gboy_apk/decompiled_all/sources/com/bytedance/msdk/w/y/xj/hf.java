package com.bytedance.msdk.w.y.xj;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.api.u.p;
import com.bytedance.msdk.core.kd.hf.u;
import com.bytedance.msdk.core.tf.d;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.f.am;
import com.bytedance.msdk.f.q;
import com.bytedance.msdk.hf.w;
import com.bytedance.msdk.xj.kd.kd;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private xj am;
    private com.bytedance.msdk.core.tf.hf g;
    private com.bytedance.msdk.api.xj.hf p;

    /* renamed from: pl, reason: collision with root package name */
    private p f10169pl;
    private Handler pz;
    private long q;
    private String qt;
    private u.w x;
    protected SoftReference<Context> xj;
    protected w y;
    private com.bytedance.msdk.w.hf.xj.xj zg;
    protected CopyOnWriteArrayList<w> hf = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<w> w = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<w> u = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<w> kd = new CopyOnWriteArrayList<>();
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final AtomicBoolean yo = new AtomicBoolean(false);
    private final AtomicBoolean v = new AtomicBoolean(false);
    private volatile boolean jk = false;
    protected Map<String, com.bytedance.msdk.w.xj.xj> c = new ConcurrentHashMap();
    protected long f = 0;
    private long ht = 0;
    private AtomicBoolean ra = new AtomicBoolean(false);
    private boolean dk = false;
    private boolean et = false;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10168io = false;
    private final AtomicInteger ai = new AtomicInteger(0);
    protected Map<String, Object> d = new ConcurrentHashMap();
    protected d tf = new d();
    private int z = 0;
    private ConcurrentHashMap<String, com.bytedance.msdk.api.hf> j = new ConcurrentHashMap<>();

    private hf() {
    }

    private int b() {
        List<tf> list;
        com.bytedance.msdk.core.tf.hf hfVar = this.g;
        int i = 0;
        if (hfVar == null) {
            return 0;
        }
        Map<Integer, List<tf>> io2 = hfVar.io();
        if (io2 != null && io2.size() != 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(io2.keySet());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (this.am.w(num.intValue()) && (list = io2.get(num)) != null) {
                    i = list.size() + i;
                }
            }
        }
        return i;
    }

    private boolean eu() {
        if (c() != null) {
            Iterator<w> it = c().iterator();
            while (it.hasNext()) {
                if (it.next().qf()) {
                    return true;
                }
            }
        }
        if (tf() != null) {
            Iterator<w> it2 = tf().iterator();
            while (it2.hasNext()) {
                if (it2.next().qf()) {
                    return true;
                }
            }
        }
        if (f() == null) {
            return false;
        }
        Iterator<w> it3 = f().iterator();
        while (it3.hasNext()) {
            if (it3.next().qf()) {
                return true;
            }
        }
        return false;
    }

    private boolean r() {
        return !this.g.z() || this.am.kd(0) || this.am.c();
    }

    private void ws() {
        if (ra() || hf() || w() || !xj()) {
            return;
        }
        if (eu()) {
            kd();
        } else {
            final long xj = com.bytedance.msdk.core.hf.hf().xj(this.p.ht(), this.p.ra());
            y.xj(new Runnable() { // from class: com.bytedance.msdk.w.y.xj.hf.7
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.msdk.xj.kd.w.w(MediationConstant.TAG, kd.xj(hf.this.g) + "m-sdk----设置 cacheTimeout 已到时间【" + xj + "】，给外部invokeAdVideoCache ...");
                    hf.this.kd();
                }
            }, xj);
        }
    }

    public String a() {
        return this.qt;
    }

    public long ai() {
        return this.q;
    }

    public boolean am() {
        int size = this.kd.size();
        com.bytedance.msdk.api.xj.hf hfVar = this.p;
        return size >= (hfVar != null ? hfVar.x() : 1);
    }

    public CopyOnWriteArrayList<w> d() {
        return this.w;
    }

    public ConcurrentHashMap<String, com.bytedance.msdk.api.hf> dk() {
        return this.j;
    }

    public boolean e() {
        return !this.g.j() || this.am.kd(-100) || this.am.y();
    }

    public long en() {
        return this.ht;
    }

    public List<com.bytedance.msdk.api.hf> et() {
        com.bytedance.msdk.api.hf value;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, com.bytedance.msdk.api.hf> entry : dk().entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !TextUtils.equals("广告加载成功", value.y()) && !TextUtils.equals("广告请求中", value.y())) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public d ff() {
        return this.tf;
    }

    public xj g() {
        return this.am;
    }

    public Context getContext() {
        return this.xj.get();
    }

    public boolean ht() {
        return this.f10168io;
    }

    public int io() {
        return this.ai.get();
    }

    public long j() {
        return this.f;
    }

    public List<w> jk() {
        ArrayList arrayList = new ArrayList();
        if (!q.xj(this.hf)) {
            arrayList.addAll(this.hf);
        }
        if (!q.xj(this.u)) {
            arrayList.addAll(this.u);
        }
        com.bytedance.msdk.core.c.w.xj(arrayList, com.bytedance.msdk.core.c.w.xj());
        if (!q.xj(this.kd)) {
            com.bytedance.msdk.core.c.w.xj(this.kd, (Comparator<w>) null);
            arrayList.addAll(0, this.kd);
        }
        return arrayList;
    }

    public boolean l() {
        return this.ra.get();
    }

    public w p() {
        return this.y;
    }

    public com.bytedance.msdk.core.tf.hf pl() {
        return this.g;
    }

    public Map<String, com.bytedance.msdk.w.xj.xj> pz() {
        return this.c;
    }

    public Map<String, Object> q() {
        return this.d;
    }

    public boolean qt() {
        int size = this.hf.size() + this.kd.size();
        com.bytedance.msdk.api.xj.hf hfVar = this.p;
        return size >= (hfVar != null ? hfVar.x() : 1);
    }

    public boolean ra() {
        return this.dk;
    }

    public CopyOnWriteArrayList<w> tf() {
        return this.u;
    }

    public com.bytedance.msdk.api.xj.hf v() {
        return this.p;
    }

    public void wo() {
        y.xj(new Runnable() { // from class: com.bytedance.msdk.w.y.xj.hf.6
            @Override // java.lang.Runnable
            public void run() {
                hf.this.jk = true;
                CopyOnWriteArrayList<w> copyOnWriteArrayList = hf.this.hf;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.clear();
                }
                CopyOnWriteArrayList<w> copyOnWriteArrayList2 = hf.this.w;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.clear();
                }
                CopyOnWriteArrayList<w> copyOnWriteArrayList3 = hf.this.u;
                if (copyOnWriteArrayList3 != null) {
                    copyOnWriteArrayList3.clear();
                }
                CopyOnWriteArrayList<w> copyOnWriteArrayList4 = hf.this.kd;
                if (copyOnWriteArrayList4 != null) {
                    copyOnWriteArrayList4.clear();
                }
                if (hf.this.pz != null) {
                    hf.this.pz.removeCallbacksAndMessages(null);
                }
                hf.this.am.pl();
                hf.this.f10169pl = null;
                if (hf.this.yo.get() || hf.this.e.get()) {
                    return;
                }
                hf.this.xj(new com.bytedance.msdk.api.hf.xj(41044, com.bytedance.msdk.api.xj.xj(41044)));
            }
        });
    }

    public void x() {
        this.ai.incrementAndGet();
    }

    public boolean yo() {
        return e() && r();
    }

    public p z() {
        return this.f10169pl;
    }

    public boolean zg() {
        int size = this.u.size() + this.hf.size() + this.kd.size();
        com.bytedance.msdk.api.xj.hf hfVar = this.p;
        return size >= (hfVar != null ? hfVar.x() : 1);
    }

    public CopyOnWriteArrayList<w> c() {
        return this.kd;
    }

    public CopyOnWriteArrayList<w> f() {
        return this.hf;
    }

    public boolean hf() {
        return this.yo.get();
    }

    public void kd() {
        if (ra() || hf() || w() || !xj()) {
            return;
        }
        com.bytedance.msdk.api.xj.hf hfVar = this.p;
        if (hfVar != null && (hfVar.ht() == 7 || this.p.ht() == 8 || this.p.ht() == 10)) {
            com.bytedance.msdk.xj.kd.w.w(MediationConstant.TAG, kd.xj(this.g) + "广告缓存成功！给外部回调：invokeAdVideoCacheOnMainUI........");
            com.bytedance.msdk.kd.y.xj(this.p, p(), SystemClock.elapsedRealtime() - en());
        }
        this.v.set(true);
        y.w(new Runnable() { // from class: com.bytedance.msdk.w.y.xj.hf.4
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.zg != null) {
                    hf.this.zg.f();
                }
            }
        });
    }

    public void u() {
        ArrayList arrayList;
        ArrayList arrayList2;
        Map<String, Object> map;
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, kd.xj(this.g) + " v2 load done..........s:" + xj() + "  f:" + hf() + "     p.size" + c().size() + "   bidding.size:" + tf().size() + "   normal.size:" + f().size() + "   underNormal.size:" + d().size());
        if (xj() || hf()) {
            return;
        }
        this.e.set(true);
        Handler handler = this.pz;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        List<w> jk = jk();
        if ((ra() || (!ra() && !this.et)) && this.g != null && !this.p.dq() && (this.g.z() || this.g.j())) {
            w wVar = jk.size() > 0 ? jk.get(0) : null;
            int x = this.p.x();
            if (x > 1) {
                arrayList = new ArrayList();
                for (int i = 1; i < x; i++) {
                    if (i < jk.size()) {
                        arrayList.add(jk.get(i));
                    }
                }
                if (jk.size() > x) {
                    arrayList2 = new ArrayList();
                    while (x < jk.size()) {
                        w wVar2 = jk.get(x);
                        if (wVar2 != null && wVar2.si()) {
                            arrayList2.add(wVar2);
                        }
                        x++;
                    }
                } else {
                    arrayList2 = null;
                }
            } else {
                arrayList = null;
                arrayList2 = null;
            }
            com.bytedance.msdk.kd.y.xj(wVar, this.p, arrayList, arrayList2);
        }
        if (!this.p.dq() && !this.et) {
            com.bytedance.msdk.core.d.u.xj(this.g, !q.hf(jk) ? jk.get(0).da() : 0.0d, this.p.ra(), this.p.ht());
        }
        if (ra()) {
            kd(true);
            return;
        }
        int x2 = jk.size() > this.p.x() ? this.p.x() : jk.size();
        com.bytedance.msdk.core.tf.hf hfVar = this.g;
        if (hfVar != null) {
            Map<String, Object> y = hfVar.y();
            y.put("has_serverBidding", Boolean.valueOf(this.g.z()));
            map = y;
        } else {
            map = null;
        }
        if (!ht()) {
            com.bytedance.msdk.api.xj.hf hfVar2 = this.p;
            w wVar3 = this.y;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f;
            int b = b();
            int hf = hf(this.am.p());
            com.bytedance.msdk.core.tf.hf hfVar3 = this.g;
            com.bytedance.msdk.kd.y.xj(map, hfVar2, wVar3, elapsedRealtime, b, hf, 0, hfVar3 != null ? hfVar3.hl() : null, x2, this.z, this.g);
        }
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, kd.xj(this.g) + "广告加载成功！给外部回调：invokeAdLoadSuccessOnMainUI........P.size:" + c().size() + "   bidding.size:" + tf().size() + "   normal.size:" + f().size());
        y.w(new Runnable() { // from class: com.bytedance.msdk.w.y.xj.hf.2
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.zg != null) {
                    hf.this.zg.c();
                }
            }
        });
        ws();
    }

    public boolean w() {
        return this.v.get();
    }

    public boolean y() {
        return this.jk;
    }

    public void hf(boolean z) {
        this.dk = z;
    }

    public void w(boolean z) {
        this.et = z;
    }

    public static hf xj(SoftReference<Context> softReference, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.w.hf.xj.xj xjVar) {
        hf hfVar2 = new hf();
        com.bytedance.msdk.core.tf.hf xj = com.bytedance.msdk.core.hf.hf().xj(hfVar.ra(), hfVar.ht(), 100);
        hfVar.xj(xj);
        hfVar2.p = hfVar;
        hfVar2.g = xj;
        if (xj != null) {
            hfVar2.d.put("render_control", Integer.valueOf(xj.hf()));
        }
        hfVar2.p.u(com.bytedance.msdk.core.hf.hf().tj());
        hfVar2.p.hf(com.bytedance.msdk.core.hf.hf().d());
        hfVar2.p.xj(com.bytedance.msdk.core.c.w.u());
        hfVar2.p.xj(com.bytedance.msdk.core.c.w.w());
        hfVar2.p.w(u.xj().hf(hfVar2.p.ra(), com.bytedance.msdk.core.hf.hf().tj()));
        hfVar2.tf.w = com.bytedance.msdk.core.hf.hf().d();
        hfVar2.xj = softReference;
        hfVar2.zg = xjVar;
        hfVar2.am = new xj();
        return hfVar2;
    }

    public void hf(long j) {
        this.f = j;
    }

    public void w(long j) {
        this.ht = j;
    }

    public void hf(String str) {
        this.qt = str;
    }

    public int hf(int i) {
        if (this.am.xj() == null) {
            return -1;
        }
        return this.am.xj().indexOf(Integer.valueOf(i)) + 1;
    }

    private void kd(final boolean z) {
        y.xj(new Runnable() { // from class: com.bytedance.msdk.w.y.xj.hf.8
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.x != null) {
                    hf.this.x.xj(hf.this.p.ra(), z, 0, null);
                }
            }
        });
    }

    public void xj(int i) {
        this.z = i;
    }

    public boolean xj() {
        return this.e.get();
    }

    public void xj(final String str) {
        y.u(new Runnable() { // from class: com.bytedance.msdk.w.y.xj.hf.1
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.zg != null) {
                    hf.this.zg.xj(str);
                }
            }
        });
    }

    public void xj(com.bytedance.msdk.api.xj xjVar) {
        Handler handler;
        if (xjVar == null) {
            xjVar = new com.bytedance.msdk.api.xj(20005, com.bytedance.msdk.api.xj.xj(20005));
        }
        if ((!com.bytedance.msdk.f.hf.xj.xj(this.g) || xjVar.xj != 10003) && (handler = this.pz) != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (xj() || hf()) {
            return;
        }
        this.yo.set(true);
        ff().kd = true;
        if (!ht()) {
            com.bytedance.msdk.kd.y.xj(this.p, xjVar, this.tf.xj);
        }
        if (ra()) {
            kd(false);
            return;
        }
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, kd.xj(this.g) + "广告加载失败！给外部回调：invokeAdLoadFailCallbackOnMainUI...... error Code = " + xjVar.xj + " error Message = " + xjVar.hf);
        final com.bytedance.msdk.api.xj xj = am.xj(this.p, xjVar, et());
        y.w(new Runnable() { // from class: com.bytedance.msdk.w.y.xj.hf.3
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.zg != null) {
                    hf.this.zg.hf(xj);
                }
            }
        });
    }

    public void xj(final List<w> list, final com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.core.tf.hf hfVar = this.g;
        if (hfVar == null || !hfVar.g()) {
            return;
        }
        if (y()) {
            xjVar = new com.bytedance.msdk.api.xj(41044, com.bytedance.msdk.api.xj.xj(41044));
            list = null;
        }
        if (ra()) {
            return;
        }
        if (!q.xj(list)) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, kd.xj(this.g) + "单个广告加载完成！给外部回调：invokeSingleAdLoadCallbackUI......");
            for (w wVar : list) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, kd.xj(this.p.ra(), "fill") + "AdNetWorkName[" + wVar.lw() + "] AdUnitId[" + wVar.cy() + "]  请求成功 (loadSort=" + wVar.zd() + ",showSort=" + wVar.kc() + ")");
            }
        }
        if (xjVar != null) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, kd.xj(this.g) + "单个广告加载失败！给外部回调：invokeSingleAdLoadCallbackUI...... errorCode:" + xjVar.xj + "  errorMsg:" + xjVar.hf);
        }
        y.w(new Runnable() { // from class: com.bytedance.msdk.w.y.xj.hf.5
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.zg != null) {
                    hf.this.zg.xj(list, xjVar);
                }
            }
        });
    }

    public void u(boolean z) {
        this.ra.set(z);
    }

    public void xj(w wVar) {
        this.y = wVar;
    }

    public void xj(com.bytedance.msdk.core.tf.hf hfVar) {
        this.g = hfVar;
    }

    public void xj(List<w> list) {
        w wVar;
        if (q.xj(list) || (wVar = list.get(0)) == null) {
            return;
        }
        if (wVar.no()) {
            this.kd.addAll(list);
            return;
        }
        if (wVar.cu()) {
            this.hf.addAll(list);
        } else if (wVar.si() || wVar.lm() || wVar.vi()) {
            this.u.addAll(list);
        }
    }

    public void xj(boolean z) {
        this.f10168io = z;
    }

    public void xj(ConcurrentHashMap<String, com.bytedance.msdk.api.hf> concurrentHashMap) {
        this.j = concurrentHashMap;
    }

    public void xj(u.w wVar) {
        this.x = wVar;
    }

    public void xj(long j) {
        this.q = j;
    }

    public void xj(p pVar) {
        this.f10169pl = pVar;
    }

    public void xj(Handler handler) {
        this.pz = handler;
    }

    public void xj(d dVar) {
        this.tf = dVar;
    }
}
