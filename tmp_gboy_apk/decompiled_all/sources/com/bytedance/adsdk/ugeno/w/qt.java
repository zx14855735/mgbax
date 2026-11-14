package com.bytedance.adsdk.ugeno.w;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.hf.xj;
import com.bytedance.adsdk.ugeno.w.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class qt {
    private jk c;
    private d d;
    private List<String> e;
    private v f;
    private JSONObject hf;
    private p ht;
    private float jk;
    private yo kd;
    private am p;

    /* renamed from: pl, reason: collision with root package name */
    private JSONObject f10085pl;
    private float pz;
    private com.bytedance.adsdk.ugeno.kd.xj.xj qt;
    private String tf;
    private tf u;
    private y v;
    private com.bytedance.adsdk.ugeno.hf.w<View> w;
    private Context xj;
    private ht y;
    private f yo;
    private boolean zg;
    private boolean g = true;
    private boolean am = false;

    public qt(Context context) {
        this.xj = context;
    }

    private void w(com.bytedance.adsdk.ugeno.hf.w wVar) {
        try {
            if (!wVar.q() || wVar.ai() == null || wVar.ai().y() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i18n", wVar.ai().y());
            this.hf.put("xNode", jSONObject);
        } catch (Exception unused) {
        }
    }

    public com.bytedance.adsdk.ugeno.hf.w<View> hf(d.xj xjVar, com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
        List<d.xj> w;
        xj.C0026xj c0026xj = null;
        if (!d.u(xjVar)) {
            return null;
        }
        f fVar = this.yo;
        if (fVar != null) {
            fVar.hf(xjVar);
        }
        String w2 = xjVar.w();
        hf xj = u.xj(w2);
        if (xj == null) {
            this.zg = true;
            if (this.e == null) {
                this.e = new ArrayList();
            }
            this.e.add(w2);
            return null;
        }
        com.bytedance.adsdk.ugeno.hf.w xj2 = xj.xj(this.xj);
        if (xj2 == null) {
            return null;
        }
        xj2.c(com.bytedance.adsdk.ugeno.u.hf.xj(xjVar.xj(), this.hf));
        xj2.f(w2);
        xj2.w(xjVar.u());
        xj2.xj(xjVar);
        xj2.xj(this.p);
        if (wVar instanceof com.bytedance.adsdk.ugeno.hf.xj) {
            com.bytedance.adsdk.ugeno.hf.xj xjVar2 = (com.bytedance.adsdk.ugeno.hf.xj) wVar;
            xj2.xj(xjVar2);
            c0026xj = xjVar2.f();
        }
        Iterator<String> keys = xjVar.u().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String xj3 = com.bytedance.adsdk.ugeno.u.hf.xj(xjVar.u().optString(next), this.hf);
            xj2.xj(next, xj3);
            if (c0026xj != null) {
                c0026xj.xj(this.xj, next, xj3);
            }
        }
        if (xj2 instanceof com.bytedance.adsdk.ugeno.hf.xj) {
            List<d.xj> kd = xjVar.kd();
            if (kd == null || kd.size() <= 0) {
                if (TextUtils.equals(xj2.en(), "RecyclerLayout") && (w = this.d.w()) != null && w.size() > 0) {
                    Iterator<d.xj> it = w.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.hf.w<View> hf = hf(it.next(), xj2);
                        if (hf != null && hf.wo()) {
                            ((com.bytedance.adsdk.ugeno.hf.xj) xj2).xj(hf);
                        }
                    }
                }
                return xj2;
            }
            if (TextUtils.equals(xj2.en(), "Swiper") && kd.size() != 1) {
                com.bytedance.sdk.component.utils.pl.u("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<d.xj> it2 = kd.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.hf.w<View> hf2 = hf(it2.next(), xj2);
                if (hf2 != null && hf2.wo()) {
                    ((com.bytedance.adsdk.ugeno.hf.xj) xj2).xj(hf2);
                }
            }
        }
        if (c0026xj != null) {
            xj2.xj(c0026xj.xj());
        }
        this.w = xj2;
        return xj2;
    }

    public void xj(String str, am amVar) {
        this.p = amVar;
        this.tf = str;
        if (amVar != null) {
            this.hf = amVar.xj();
        }
    }

    public com.bytedance.adsdk.ugeno.hf.w<View> xj(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.hf = jSONObject2;
        ht htVar = this.y;
        if (htVar != null) {
            htVar.xj();
        }
        d dVar = new d(jSONObject, jSONObject2, jSONObject3);
        this.d = dVar;
        dVar.xj(this.jk, this.pz);
        this.qt = new com.bytedance.adsdk.ugeno.kd.xj.xj();
        yo yoVar = this.kd;
        if (yoVar instanceof com.bytedance.adsdk.ugeno.w.xj.hf) {
            ((com.bytedance.adsdk.ugeno.w.xj.hf) yoVar).xj(this.d.hf());
        }
        this.w = xj(this.d.xj(), (com.bytedance.adsdk.ugeno.hf.w<View>) null);
        p pVar = this.ht;
        if (pVar != null) {
            pVar.hf();
            if (this.ht.w()) {
                this.ht.xj(this.f);
            }
            this.ht.xj(this.y);
        }
        ht htVar2 = this.y;
        if (htVar2 != null) {
            htVar2.hf();
            this.w.xj(this.y);
            this.y.w();
        }
        hf(this.w);
        if (this.y != null) {
            pz pzVar = new pz();
            pzVar.xj(0);
            pzVar.xj(this.w);
            this.y.xj(pzVar);
        }
        return this.w;
    }

    public com.bytedance.adsdk.ugeno.hf.w<View> xj(d.xj xjVar, com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
        List<d.xj> w;
        xj.C0026xj c0026xj = null;
        if (!d.u(xjVar)) {
            return null;
        }
        f fVar = this.yo;
        if (fVar != null) {
            fVar.xj(xjVar);
        }
        String w2 = xjVar.w();
        hf xj = u.xj(w2);
        hf hfVar = xj;
        if (xj == null) {
            this.zg = true;
            if (this.e == null) {
                this.e = new ArrayList();
            }
            this.e.add(w2);
            w2 = "View";
            xjVar.xj("View");
            hf xj2 = u.xj("View");
            hfVar = xj2;
            if (xj2 == null) {
                return null;
            }
        }
        com.bytedance.adsdk.ugeno.hf.w xj3 = hfVar.xj(this.xj);
        if (xj3 == null) {
            return null;
        }
        JSONObject u = xjVar.u();
        xj3.c(com.bytedance.adsdk.ugeno.u.hf.xj(xjVar.xj(), this.hf));
        xj3.f(w2);
        xj3.w(u);
        xj3.xj(xjVar);
        xj3.hf(this.hf);
        d dVar = this.d;
        if (dVar == null) {
            xj3.w(true);
        } else {
            xj3.w(dVar.u());
        }
        xj3.xj(this.p);
        xj3.xj(this.qt);
        Iterator<String> keys = u.keys();
        if (wVar instanceof com.bytedance.adsdk.ugeno.hf.xj) {
            com.bytedance.adsdk.ugeno.hf.xj xjVar2 = (com.bytedance.adsdk.ugeno.hf.xj) wVar;
            c0026xj = xjVar2.f();
            xj3.xj(xjVar2);
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String xj4 = com.bytedance.adsdk.ugeno.u.hf.xj(u.optString(next), this.hf);
            xj3.xj(next, xj4);
            p pVar = this.ht;
            if (pVar != null) {
                pVar.xj(next, xj4);
            }
            if (c0026xj != null) {
                c0026xj.xj(this.xj, next, xj4);
            }
        }
        if (c0026xj != null) {
            xj3.xj(c0026xj.xj());
        }
        if (xj3 instanceof com.bytedance.adsdk.ugeno.hf.xj) {
            List<d.xj> kd = xjVar.kd();
            if (kd != null && kd.size() > 0) {
                if (TextUtils.equals(xj3.en(), "Swiper") && kd.size() != 1) {
                    com.bytedance.sdk.component.utils.pl.u("UGTemplateEngine", "Swiper must be only one widget");
                }
                try {
                    Collections.sort(kd, new Comparator<d.xj>() { // from class: com.bytedance.adsdk.ugeno.w.qt.1
                        @Override // java.util.Comparator
                        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                        public int compare(d.xj xjVar3, d.xj xjVar4) {
                            return xjVar3.u().optInt("order", 0) - xjVar4.u().optInt("order", 0);
                        }
                    });
                } catch (Throwable unused) {
                }
                Iterator<d.xj> it = kd.iterator();
                while (it.hasNext()) {
                    com.bytedance.adsdk.ugeno.hf.w<View> xj5 = xj(it.next(), (com.bytedance.adsdk.ugeno.hf.w<View>) xj3);
                    if (xj5 != null && !xj5.wn()) {
                        ((com.bytedance.adsdk.ugeno.hf.xj) xj3).xj(xj5, xj5.x());
                    }
                }
            } else {
                if (TextUtils.equals(xj3.en(), "RecyclerLayout") && (w = this.d.w()) != null && w.size() > 0) {
                    Iterator<d.xj> it2 = w.iterator();
                    while (it2.hasNext()) {
                        com.bytedance.adsdk.ugeno.hf.w<View> xj6 = xj(it2.next(), (com.bytedance.adsdk.ugeno.hf.w<View>) xj3);
                        if (xj6 != null && xj6.wo()) {
                            ((com.bytedance.adsdk.ugeno.hf.xj) xj3).xj(xj6);
                        }
                    }
                }
                return xj3;
            }
        }
        this.w = xj3;
        return xj3;
    }

    public void hf(JSONObject jSONObject) {
        ht htVar = this.y;
        if (htVar != null) {
            htVar.w();
        }
        this.hf = jSONObject;
        xj(this.w, jSONObject);
        hf(this.w);
        if (this.y != null) {
            pz pzVar = new pz();
            pzVar.xj(0);
            pzVar.xj(this.w);
            this.y.xj(pzVar);
        }
    }

    private void hf(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
        List<com.bytedance.adsdk.ugeno.hf.w<View>> c;
        if (wVar == null) {
            return;
        }
        JSONObject dk = wVar.dk();
        Iterator<String> keys = dk.keys();
        com.bytedance.adsdk.ugeno.hf.xj z = wVar.z();
        xj.C0026xj f = z != null ? z.f() : null;
        w(wVar);
        while (keys.hasNext()) {
            String next = keys.next();
            String xj = com.bytedance.adsdk.ugeno.u.hf.xj(dk.optString(next), this.hf);
            wVar.xj(next, xj);
            if (f != null) {
                f.xj(this.xj, next, xj);
            }
        }
        wVar.xj(this.u);
        wVar.xj(this.kd);
        wVar.xj(this.c);
        p pVar = this.ht;
        if (pVar != null) {
            wVar.xj(pVar);
        }
        y yVar = this.v;
        if (yVar != null) {
            wVar.xj(yVar);
        }
        if ((wVar instanceof com.bytedance.adsdk.ugeno.hf.xj) && (c = ((com.bytedance.adsdk.ugeno.hf.xj) wVar).c()) != null && c.size() > 0) {
            Iterator<com.bytedance.adsdk.ugeno.hf.w<View>> it = c.iterator();
            while (it.hasNext()) {
                hf(it.next());
            }
        }
        if (f != null) {
            wVar.xj(f.xj());
        }
        wVar.hf();
    }

    public List<String> hf() {
        return this.e;
    }

    public com.bytedance.adsdk.ugeno.hf.w<View> xj(JSONObject jSONObject) {
        ht htVar = this.y;
        if (htVar != null) {
            htVar.xj();
        }
        d dVar = new d(jSONObject, this.hf);
        this.d = dVar;
        yo yoVar = this.kd;
        if (yoVar instanceof com.bytedance.adsdk.ugeno.w.xj.hf) {
            ((com.bytedance.adsdk.ugeno.w.xj.hf) yoVar).xj(dVar.hf());
        }
        this.w = hf(this.d.xj(), null);
        ht htVar2 = this.y;
        if (htVar2 != null) {
            htVar2.hf();
            this.w.xj(this.y);
        }
        return this.w;
    }

    public com.bytedance.adsdk.ugeno.hf.w<View> xj(d.xj xjVar) {
        com.bytedance.adsdk.ugeno.hf.w<View> hf = hf(xjVar, null);
        this.w = hf;
        return hf;
    }

    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        List<com.bytedance.adsdk.ugeno.hf.w<View>> c;
        if (wVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.hf.xj z = wVar.z();
        if (z != null) {
            xj.C0026xj f = z.f();
            Iterator<String> keys = wVar.dk().keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String xj = com.bytedance.adsdk.ugeno.u.hf.xj(wVar.dk().optString(next), this.hf);
                wVar.xj(next, xj);
                f.xj(this.xj, next, xj);
            }
            wVar.xj(f.xj());
        }
        if (!(wVar instanceof com.bytedance.adsdk.ugeno.hf.xj) || (c = ((com.bytedance.adsdk.ugeno.hf.xj) wVar).c()) == null || c.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.hf.w<View>> it = c.iterator();
        while (it.hasNext()) {
            xj(it.next());
        }
    }

    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, JSONObject jSONObject) {
        if (wVar == null) {
            return;
        }
        if (wVar instanceof com.bytedance.adsdk.ugeno.hf.xj) {
            wVar.xj(jSONObject);
            List<com.bytedance.adsdk.ugeno.hf.w<View>> c = ((com.bytedance.adsdk.ugeno.hf.xj) wVar).c();
            if (c == null || c.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.hf.w<View>> it = c.iterator();
            while (it.hasNext()) {
                xj(it.next(), jSONObject);
            }
            return;
        }
        wVar.xj(jSONObject);
    }

    public void xj(tf tfVar) {
        this.u = tfVar;
    }

    public void xj(yo yoVar) {
        com.bytedance.adsdk.ugeno.w.xj.xj kd = com.bytedance.adsdk.ugeno.u.xj().kd();
        if (kd == null) {
            this.kd = yoVar;
            return;
        }
        com.bytedance.adsdk.ugeno.w.xj.hf xj = kd.xj(yoVar);
        if (xj == null) {
            this.kd = yoVar;
            return;
        }
        xj.xj(this.f10085pl);
        xj.xj(this.g);
        xj.hf(this.am);
        d dVar = this.d;
        if (dVar != null) {
            xj.xj(dVar.hf());
        }
        this.kd = xj;
    }

    public void xj(jk jkVar) {
        this.c = jkVar;
    }

    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.hf.w<View>> c;
        if (wVar == null) {
            return;
        }
        wVar.xj(str, objArr);
        if (!(wVar instanceof com.bytedance.adsdk.ugeno.hf.xj) || (c = ((com.bytedance.adsdk.ugeno.hf.xj) wVar).c()) == null || c.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.hf.w<View>> it = c.iterator();
        while (it.hasNext()) {
            xj(it.next(), str, objArr);
        }
    }

    public boolean xj() {
        return this.zg;
    }

    public void xj(f fVar) {
        this.yo = fVar;
    }
}
