package com.bytedance.sdk.component.adexpress.dynamic.u;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.component.utils.pl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private double c;
    private g d;
    private String f;
    private double kd;
    private int y;
    public Map<String, w> xj = new HashMap();
    public Map<String, w> hf = new HashMap();
    public Map<String, w> w = new HashMap();
    private double u = Math.random();

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.u.hf$hf, reason: collision with other inner class name */
    public static class C0098hf {
        int hf;
        float kd;
        double u;
        int w;
        float xj;

        public static JSONObject xj(C0098hf c0098hf) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0098hf.xj);
                jSONObject.put("letterSpacing", c0098hf.hf);
                jSONObject.put("lineHeight", c0098hf.u);
                jSONObject.put("maxWidth", c0098hf.kd);
                jSONObject.put("fontWeight", c0098hf.w);
                return jSONObject;
            } catch (JSONException e) {
                pl.xj(e);
                return jSONObject;
            }
        }
    }

    public static class w {
        float hf;
        float xj;

        public w() {
        }

        public String toString() {
            return "UnitSize{width=" + this.xj + ", height=" + this.hf + '}';
        }

        public w(float f, float f2) {
            this.xj = f;
            this.hf = f2;
        }
    }

    public static class xj implements Cloneable {
        boolean hf;
        float w;
        float xj;

        public Object clone() {
            try {
                return (xj) super.clone();
            } catch (CloneNotSupportedException e) {
                pl.xj(e);
                return null;
            }
        }
    }

    public hf(double d, int i, double d2, String str, g gVar) {
        this.kd = d;
        this.y = i;
        this.c = d2;
        this.f = str;
        this.d = gVar;
    }

    private w kd(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar, float f, float f2) {
        String str = fVar.w() + "_" + f + "_" + f2;
        if (this.w.containsKey(str)) {
            return this.w.get(str);
        }
        w y = y(fVar, f, f2);
        this.w.put(str, y);
        return y;
    }

    private w y(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar, float f, float f2) {
        com.bytedance.sdk.component.adexpress.dynamic.w.y kd = fVar.tf().kd();
        float yo = kd.yo();
        int aq = kd.aq();
        double wn = kd.wn();
        int s = kd.s();
        boolean tj = kd.tj();
        boolean dq = kd.dq();
        int n = kd.n();
        C0098hf c0098hf = new C0098hf();
        c0098hf.xj = yo;
        c0098hf.hf = aq;
        c0098hf.w = s;
        c0098hf.u = wn;
        c0098hf.kd = f;
        return xj(fVar.tf().hf(), c0098hf, tj, dq, n, fVar);
    }

    public w hf(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar, float f, float f2) {
        w wVar = new w();
        if (fVar.tf().kd() == null) {
            return wVar;
        }
        w kd = kd(fVar, f, f2);
        float f3 = kd.xj;
        float f4 = kd.hf;
        wVar.xj = Math.min(f3, f);
        wVar.hf = Math.min(f4, f2);
        return wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.adexpress.dynamic.u.hf.w u(com.bytedance.sdk.component.adexpress.dynamic.w.f r22, float r23, float r24) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.u.hf.u(com.bytedance.sdk.component.adexpress.dynamic.w.f, float, float):com.bytedance.sdk.component.adexpress.dynamic.u.hf$w");
    }

    public w w(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar, float f, float f2) {
        if (fVar == null) {
            return null;
        }
        w xj2 = xj(fVar);
        if (xj2 != null && (xj2.xj != 0.0f || xj2.hf != 0.0f)) {
            return xj2;
        }
        w u = u(fVar, f, f2);
        xj(fVar, u);
        return u;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.adexpress.dynamic.u.hf.w xj(com.bytedance.sdk.component.adexpress.dynamic.w.f r13, float r14, float r15) {
        /*
            r12 = this;
            com.bytedance.sdk.component.adexpress.dynamic.w.kd r0 = r13.tf()
            java.lang.String r0 = r0.hf()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L23
            com.bytedance.sdk.component.adexpress.dynamic.w.kd r0 = r13.tf()
            com.bytedance.sdk.component.adexpress.dynamic.w.y r0 = r0.kd()
            java.lang.String r0 = r0.gy()
            if (r0 != 0) goto L23
            com.bytedance.sdk.component.adexpress.dynamic.u.hf$w r13 = new com.bytedance.sdk.component.adexpress.dynamic.u.hf$w
            r13.<init>(r1, r1)
            return r13
        L23:
            java.lang.String r0 = "creative-playable-bait"
            boolean r0 = com.bykv.vk.component.ttvideo.player.A2egSU.BNL6CD(r13, r0)
            if (r0 == 0) goto L31
            com.bytedance.sdk.component.adexpress.dynamic.u.hf$w r13 = new com.bytedance.sdk.component.adexpress.dynamic.u.hf$w
            r13.<init>(r1, r1)
            return r13
        L31:
            float r0 = r13.f()
            float r1 = r13.d()
            com.bytedance.sdk.component.adexpress.dynamic.w.kd r2 = r13.tf()
            com.bytedance.sdk.component.adexpress.dynamic.w.y r2 = r2.kd()
            java.lang.String r3 = r2.ai()
            java.lang.String r2 = r2.x()
            int r4 = r13.g()
            float r4 = (float) r4
            int r5 = r13.am()
            float r5 = (float) r5
            float r6 = r13.qt()
            float r7 = r13.zg()
            java.lang.String r8 = "fixed"
            boolean r9 = android.text.TextUtils.equals(r3, r8)
            java.lang.String r10 = "flex"
            java.lang.String r11 = "auto"
            if (r9 == 0) goto L7e
            float r14 = java.lang.Math.min(r0, r14)
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Laf
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.u.hf$w r13 = r12.hf(r13, r0, r1)
            float r13 = r13.hf
        L7b:
            float r1 = r13 + r7
            goto Laf
        L7e:
            boolean r9 = android.text.TextUtils.equals(r3, r11)
            if (r9 == 0) goto L97
            float r14 = r14 - r6
            float r0 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.u.hf$w r13 = r12.hf(r13, r14, r0)
            float r14 = r13.xj
            float r14 = r14 + r6
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Laf
            float r13 = r13.hf
            goto L7b
        L97:
            boolean r3 = android.text.TextUtils.equals(r3, r10)
            if (r3 == 0) goto Lae
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Laf
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.u.hf$w r13 = r12.hf(r13, r0, r1)
            float r13 = r13.hf
            goto L7b
        Lae:
            r14 = r0
        Laf:
            java.lang.String r13 = "scale"
            boolean r13 = android.text.TextUtils.equals(r2, r13)
            if (r13 == 0) goto Ld2
            float r13 = r14 - r4
            float r13 = r13 / r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r13 = r13 + r5
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 <= 0) goto Ld0
            float r13 = r15 - r5
            float r13 = r13 * r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r14 = r13 + r4
            goto Le6
        Ld0:
            r15 = r13
            goto Le6
        Ld2:
            boolean r13 = android.text.TextUtils.equals(r2, r8)
            if (r13 == 0) goto Lde
            float r1 = r1 + r5
            float r15 = java.lang.Math.min(r1, r15)
            goto Le6
        Lde:
            boolean r13 = android.text.TextUtils.equals(r2, r10)
            if (r13 == 0) goto Le5
            goto Le6
        Le5:
            r15 = r1
        Le6:
            com.bytedance.sdk.component.adexpress.dynamic.u.hf$w r13 = new com.bytedance.sdk.component.adexpress.dynamic.u.hf$w
            r13.<init>()
            r13.xj = r14
            r13.hf = r15
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.u.hf.xj(com.bytedance.sdk.component.adexpress.dynamic.w.f, float, float):com.bytedance.sdk.component.adexpress.dynamic.u.hf$w");
    }

    private w w(List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list, float f, float f2) {
        float f3;
        u(list);
        w wVar = new w();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.w.f fVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.w.y kd = fVar.tf().kd();
            if (kd.qd() == 1 || kd.qd() == 2) {
                arrayList.add(fVar);
            }
            if (kd.qd() != 1 && kd.qd() != 2) {
                arrayList2.add(fVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            w((com.bytedance.sdk.component.adexpress.dynamic.w.f) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return wVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(w((com.bytedance.sdk.component.adexpress.dynamic.w.f) it2.next(), f, f2).xj));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.w.f fVar2 = (com.bytedance.sdk.component.adexpress.dynamic.w.f) arrayList2.get(i);
            String ai = fVar2.tf().kd().ai();
            float f4 = fVar2.f();
            boolean equals = TextUtils.equals(ai, "flex");
            if (TextUtils.equals(ai, LiveConfigKey.AUTO)) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.w.f>> e = fVar2.e();
                if (e != null && e.size() > 0) {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.w.f>> it3 = e.iterator();
                    while (it3.hasNext()) {
                        if (hf(it3.next())) {
                            equals = true;
                            break;
                        }
                    }
                }
                equals = false;
            }
            xj xjVar = new xj();
            if (!equals) {
                f4 = ((Float) arrayList3.get(i)).floatValue();
            }
            xjVar.xj = f4;
            xjVar.hf = !equals;
            if (equals) {
                f3 = ((Float) arrayList3.get(i)).floatValue();
            }
            xjVar.w = f3;
            arrayList4.add(xjVar);
            i++;
        }
        xj(arrayList4, f, arrayList2);
        List<xj> xj2 = tf.xj(f, arrayList4);
        float f5 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f5 += xj2.get(i2).xj;
            if (((Float) arrayList3.get(i2)).floatValue() != xj2.get(i2).xj) {
                u((com.bytedance.sdk.component.adexpress.dynamic.w.f) arrayList2.get(i2));
            }
        }
        Iterator it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            i3++;
            if (!hf((com.bytedance.sdk.component.adexpress.dynamic.w.f) it4.next())) {
                z = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        f3 = z ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.bytedance.sdk.component.adexpress.dynamic.w.f fVar3 = (com.bytedance.sdk.component.adexpress.dynamic.w.f) arrayList2.get(i4);
            w w2 = w(fVar3, xj2.get(i4).xj, f2);
            if (!hf(fVar3)) {
                f3 = Math.max(f3, w2.hf);
            }
            arrayList5.add(w2);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((w) it5.next()).hf));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.bytedance.sdk.component.adexpress.dynamic.w.f fVar4 = (com.bytedance.sdk.component.adexpress.dynamic.w.f) arrayList2.get(i5);
                if (hf(fVar4) && ((Float) arrayList6.get(i5)).floatValue() != f3) {
                    u(fVar4);
                    w(fVar4, xj2.get(i5).xj, f3);
                }
            }
        }
        wVar.xj = f5;
        wVar.hf = f3;
        return wVar;
    }

    private boolean hf(List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.w.f>> e;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.w.f> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().tf().kd().ai(), "flex")) {
                return true;
            }
        }
        while (true) {
            boolean z = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.w.f fVar : list) {
                if (TextUtils.equals(fVar.tf().kd().ai(), LiveConfigKey.AUTO) && (e = fVar.e()) != null) {
                    int i = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list2 : e) {
                        i++;
                        if (!hf(list2)) {
                            break;
                        }
                        if (i == list2.size()) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
    }

    private String kd(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        return fVar.w();
    }

    private w hf(List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list, float f, float f2) {
        w xj2 = xj(list);
        if (xj2 != null && (xj2.xj != 0.0f || xj2.hf != 0.0f)) {
            return xj2;
        }
        w w2 = w(list, f, f2);
        xj(list, w2);
        return w2;
    }

    private boolean hf(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        if (fVar == null) {
            return false;
        }
        if (TextUtils.equals(fVar.tf().kd().x(), "flex")) {
            return true;
        }
        return w(fVar);
    }

    private w xj(String str, C0098hf c0098hf, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        return p.xj(str, fVar.tf().getType(), C0098hf.xj(c0098hf).toString(), z, z2, i, fVar, this.kd, this.y, this.c, this.f, this.d);
    }

    private void u(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        this.xj.remove(kd(fVar));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.w.f>> e = fVar.e();
        if (e == null || e.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.w.f>> it = e.iterator();
        while (it.hasNext()) {
            w(it.next());
        }
    }

    private void xj(List<List<com.bytedance.sdk.component.adexpress.dynamic.w.f>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.w.f>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (xj(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list2 : list) {
            xj xjVar = new xj();
            boolean xj2 = xj(list2, !z);
            xjVar.xj = xj2 ? 1.0f : hf(list2, f, f2).hf;
            xjVar.hf = !xj2;
            arrayList.add(xjVar);
        }
        List<xj> xj3 = tf.xj(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((xj) arrayList.get(i)).xj != xj3.get(i).xj) {
                List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list3 = list.get(i);
                w(list3);
                hf(list3, f, xj3.get(i).xj);
            }
        }
    }

    private String u(List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String w2 = list.get(i).w();
            if (i < list.size() - 1) {
                sb.append(w2);
                sb.append("-");
            } else {
                sb.append(w2);
            }
        }
        return sb.toString();
    }

    private boolean xj(List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list, boolean z) {
        for (com.bytedance.sdk.component.adexpress.dynamic.w.f fVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.w.y kd = fVar.tf().kd();
            String x = kd.x();
            if (TextUtils.equals(x, "flex") || (z && ((TextUtils.equals(kd.ai(), "flex") && TextUtils.equals(kd.x(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.w.kd.xj.get(fVar.tf().getType()).intValue() == 7) || TextUtils.equals(x, "flex")))) {
                return true;
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.w.f> it = list.iterator();
        while (it.hasNext()) {
            if (w(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean w(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.w.f>> e;
        if (!fVar.yo() && TextUtils.equals(fVar.tf().kd().x(), LiveConfigKey.AUTO) && (e = fVar.e()) != null && e.size() > 0) {
            if (e.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.w.f> it = e.get(0).iterator();
                while (it.hasNext()) {
                    if (!hf(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.w.f>> it2 = e.iterator();
            while (it2.hasNext()) {
                if (xj(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void xj(List<xj> list, float f, List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list2) {
        float f2 = 0.0f;
        for (xj xjVar : list) {
            if (xjVar.hf) {
                f2 += xjVar.xj;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).hf && list2.get(i2).ht()) {
                    i++;
                }
            }
            if (i > 0) {
                float ceil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    xj xjVar2 = list.get(i3);
                    if (xjVar2.hf && list2.get(i3).ht()) {
                        xjVar2.xj -= ceil;
                    }
                }
            }
        }
    }

    private void w(List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.hf.remove(u(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.w.f> it = list.iterator();
        while (it.hasNext()) {
            u(it.next());
        }
    }

    public void xj() {
        this.w.clear();
        this.xj.clear();
        this.hf.clear();
    }

    public w xj(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        return this.xj.get(kd(fVar));
    }

    public w xj(List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list) {
        return this.hf.get(u(list));
    }

    private void xj(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar, w wVar) {
        this.xj.put(kd(fVar), wVar);
    }

    private void xj(List<com.bytedance.sdk.component.adexpress.dynamic.w.f> list, w wVar) {
        this.hf.put(u(list), wVar);
    }
}
