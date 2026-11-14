package com.bytedance.msdk.core.kd.xj;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.msdk.api.u.p;
import com.bytedance.msdk.core.kd.hf.c;
import com.bytedance.msdk.core.tf.d;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.j;
import com.bytedance.msdk.hf.w;
import com.bytedance.msdk.kd.y;
import com.bytedance.msdk.w.xj.hf;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.msdk.core.kd.xj {
    private static volatile xj f;
    private final String[] xj = {MediationConstant.ADN_UNITY, "ks"};
    private final Map<String, Integer> hf = new HashMap();
    private final Map<String, Integer> w = new HashMap();
    private final Map<String, CopyOnWriteArrayList<c>> u = new ConcurrentHashMap();
    private final Map<String, tf> kd = new HashMap();
    private final Map<String, String> y = new HashMap();
    private final Map<String, Integer> c = new HashMap();
    private final Comparator<c> d = new Comparator<c>() { // from class: com.bytedance.msdk.core.kd.xj.xj.4
        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            w wVar;
            if (cVar == null || cVar2 == null || (wVar = cVar.xj) == null || cVar2.xj == null) {
                return 0;
            }
            return ((int) wVar.dq()) - ((int) cVar2.xj.dq());
        }
    };

    /* renamed from: com.bytedance.msdk.core.kd.xj.xj$xj, reason: collision with other inner class name */
    public class C0058xj implements hf {
        private long c = System.currentTimeMillis();
        private com.bytedance.msdk.w.y.hf.hf kd;
        private tf u;
        private final com.bytedance.msdk.api.xj.hf w;
        int xj;
        private d y;

        public C0058xj(com.bytedance.msdk.api.xj.hf hfVar, tf tfVar, com.bytedance.msdk.w.y.hf.hf hfVar2, d dVar, int i) {
            this.w = hfVar;
            this.u = tfVar;
            this.kd = hfVar2;
            this.xj = i;
            this.y = dVar;
        }

        @Override // com.bytedance.msdk.w.xj.hf
        public void xj(w wVar, String str) {
        }

        @Override // com.bytedance.msdk.w.xj.hf
        public void xj(List<w> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (w wVar : list) {
                if (wVar != null) {
                    tf tfVar = this.u;
                    com.bytedance.msdk.w.f.w.xj(wVar, this.w, this.kd, this.y, tfVar != null ? xj.this.xj(tfVar.yo()) : "");
                    wVar.xj(SystemClock.elapsedRealtime());
                    arrayList.add(new c(wVar, 0L, this.w));
                }
            }
            if (arrayList.size() > 0) {
                w wVar2 = ((c) arrayList.get(0)).xj;
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:show时预请求广告load成功 --- " + wVar2.lw() + ", adType: " + com.bytedance.msdk.hf.xj.xj(wVar2.ci(), wVar2.tj()) + ", adnSlotId: " + wVar2.cy() + ", ad个数: " + arrayList.size());
                xj.this.xj(wVar2.cy(), (List<c>) arrayList, false);
            }
            y.xj(list.get(0), 20000, "load success", System.currentTimeMillis() - this.c, this.w, this.xj, list.size(), 0, (String) null, -1L, -1L);
        }

        @Override // com.bytedance.msdk.w.xj.hf
        public void xj(com.bytedance.msdk.api.xj xjVar) {
            if (xjVar != null && this.u != null) {
                StringBuilder sb = new StringBuilder("--==-- 广告复用:show时预请求广告load失败 --- ");
                sb.append(this.u.e());
                sb.append(", ");
                sb.append(this.u.yo());
                sb.append(", ");
                sb.append(com.bytedance.msdk.hf.xj.xj(this.u.g(), this.u.y()));
                sb.append(", errCode: ");
                sb.append(xjVar.w);
                sb.append(",msg=");
                A2egSU.BI9f7h(sb, xjVar.u, MediationConstant.TAG);
            }
            y.xj(xjVar, this.w, this.u, this.xj, 4, 1, xj.xj().xj(this.u.yo()), System.currentTimeMillis() - this.c, (String) null, (String) null, (String) null, 0L);
        }

        @Override // com.bytedance.msdk.w.xj.hf
        public void xj(List<w> list, com.bytedance.msdk.api.xj xjVar) {
            if (list == null || list.size() <= 0) {
                return;
            }
            for (w wVar : list) {
                tf tfVar = this.u;
                com.bytedance.msdk.w.f.w.xj(wVar, this.w, this.kd, this.y, tfVar != null ? xj.this.xj(tfVar.yo()) : "");
                wVar.d(true);
            }
            w wVar2 = list.get(0);
            if (wVar2 != null) {
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:show时预请求广告cache成功 --- " + wVar2.lw() + ", adType: " + com.bytedance.msdk.hf.xj.xj(wVar2.ci(), wVar2.tj()) + ", adnSlotId: " + wVar2.cy() + ", ad个数: " + list.size());
            }
            y.xj(this.w, wVar2, this.u);
        }
    }

    private xj() {
    }

    public void hf() {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.kd.xj.xj.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2;
                String str;
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用lowMemory，start clean");
                int i3 = 0;
                int i4 = 0;
                for (Map.Entry entry : xj.this.u.entrySet()) {
                    List<c> list = (List) entry.getValue();
                    if (list != null && list.size() > 0) {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理前, 缓存总数: " + list.size());
                        int i5 = 1;
                        int i6 = 0;
                        for (c cVar : list) {
                            if (cVar != null && cVar.xj != null) {
                                if (cVar.u() != null) {
                                    str = cVar.u().ra();
                                    i2 = cVar.u().x();
                                } else {
                                    i2 = i5;
                                    str = "";
                                }
                                if (cVar.xj.tu() || !cVar.xj.ff(str)) {
                                    list.remove(cVar);
                                    i6++;
                                }
                                i5 = i2;
                            }
                        }
                        if (list.size() > i5) {
                            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理无效广告后仍需清理，缓存总数: " + list.size() + "，adCount: " + i5 + ", invalidCnt: " + i6);
                            i = 0;
                            for (c cVar2 : list) {
                                if (list.size() <= i5) {
                                    break;
                                }
                                list.remove(cVar2);
                                i++;
                            }
                        } else {
                            i = 0;
                        }
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理后，缓存总数: " + list.size() + ", adCount: " + i5 + ", invalidCnt: " + i6 + ", foceCleanCnt：" + i);
                        i3 += i6;
                        i4 += i;
                    }
                    ai.xj(i3, i4);
                }
            }
        });
    }

    public int kd(String str, String str2, int i) {
        if (i == 2) {
            return 0;
        }
        Integer num = this.hf.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public boolean u(String str, String str2, int i) {
        if (i == 2) {
            return false;
        }
        Integer num = this.hf.get(str + "_" + str2);
        return num != null && (num.intValue() == 1 || num.intValue() == 2);
    }

    public void w(String str, String str2, int i) {
        this.hf.put(CtFAbx.AlLFFp(str, "_", str2), Integer.valueOf(i));
    }

    public void y(String str, String str2, int i) {
        this.w.put(CtFAbx.AlLFFp(str, "_", str2), Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, List<c>> hf(List<w> list, String str, com.bytedance.msdk.api.xj.hf hfVar, int i, w wVar) {
        HashMap hashMap = new HashMap();
        for (w wVar2 : list) {
            if (wVar2 != null && wVar2 != wVar) {
                wVar2.xj(false);
            }
            if (wVar2 != null && wVar2 != wVar && kd(str, wVar2.cy(), i) == 2 && wVar2.ff(str) && !wVar2.tu()) {
                List list2 = (List) hashMap.get(wVar2.cy());
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new c(wVar2, 0L, hfVar));
                    hashMap.put(wVar2.cy(), arrayList);
                } else {
                    list2.add(new c(wVar2, 0L, hfVar));
                }
            }
        }
        return hashMap;
    }

    public tf kd(String str, String str2) {
        return this.kd.get(str + "_" + str2);
    }

    public void u(String str, String str2) {
        this.y.put(str, str2);
    }

    public static xj xj() {
        if (f == null) {
            synchronized (xj.class) {
                try {
                    if (f == null) {
                        f = new xj();
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public boolean w(String str, String str2) {
        Integer num = this.w.get(str + "_" + str2);
        return num != null && num.intValue() == 1;
    }

    public void xj(String str, String str2, tf tfVar, int i) {
        if (tfVar != null) {
            this.kd.put(str + "_" + str2, tfVar);
        }
        this.c.put(str2, Integer.valueOf(i));
    }

    private int hf(String str, com.bytedance.msdk.api.xj.hf hfVar, boolean z) {
        boolean z2;
        int i;
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.u.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            String ra = hfVar != null ? hfVar.ra() : "";
            ArrayList arrayList = new ArrayList();
            c cVar = null;
            boolean z3 = false;
            for (c cVar2 : copyOnWriteArrayList) {
                Integer y = cVar2.xj.y();
                int intValue = y != null ? y.intValue() : 0;
                if (intValue == 4) {
                    z2 = xj(ra, cVar2.xj);
                } else {
                    z2 = intValue != 2;
                }
                if (!z2) {
                    if (com.bytedance.msdk.core.kd.xj.xj(cVar2.u(), hfVar, cVar2.xj)) {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:复用成功：--------" + cVar2.xj.lw() + ", adSlotId: " + str);
                        z3 = true;
                    } else {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:AdSlot不符合 -------: " + cVar2.xj.lw() + ", adSlotId: " + str);
                        i = 6;
                    }
                } else {
                    copyOnWriteArrayList.remove(cVar2);
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:广告过期了 -------: " + cVar2.xj.lw() + ", adSlotId: " + str);
                    i = 5;
                }
                if (cVar == null) {
                    cVar = cVar2;
                }
                com.bytedance.msdk.core.kd.hf.xj xjVar = new com.bytedance.msdk.core.kd.hf.xj();
                xjVar.u(cVar2.xj.zd());
                xjVar.kd(cVar2.xj.kc());
                xjVar.hf(cVar2.xj.cy());
                xjVar.hf(i);
                xjVar.xj(cVar2.xj.tu() ? 1 : 0);
                arrayList.add(xjVar);
            }
            if (z3) {
                return 3;
            }
            if (z && cVar != null) {
                y.xj(hfVar, cVar.xj, xj(arrayList));
            }
            return 2;
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    public String xj(String str) {
        return this.y.get(str);
    }

    public void xj(final String str, final com.bytedance.msdk.api.xj.hf hfVar, final Map<String, Object> map, final boolean z, final p pVar, final d dVar, final Context context) {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.kd.xj.xj.2
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String str3;
                c cVar;
                List<c> list = (List) xj.this.u.get(str);
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    for (c cVar2 : list) {
                        if (cVar2 != null && cVar2.xj.tu()) {
                            list.remove(cVar2);
                            arrayList.add(cVar2);
                        }
                    }
                }
                boolean z2 = false;
                if (com.bytedance.msdk.xj.kd.w.hf()) {
                    if (arrayList.size() <= 0 || (cVar = (c) arrayList.get(0)) == null) {
                        str2 = "";
                        str3 = str2;
                    } else {
                        str3 = com.bytedance.msdk.hf.xj.xj(cVar.xj.ci(), cVar.xj.tj());
                        str2 = cVar.xj.lw();
                    }
                    StringBuilder BChYOn2 = J3FDQU.A2egSU.BChYOn("--==-- 广告复用:show时缓存移除 -----：", str2, ", ", str3, ", ");
                    BChYOn2.append(str);
                    A2egSU.BI9f7h(BChYOn2, arrayList.size() > 0 ? ", size: " + arrayList.size() : "移除广告数为0", MediationConstant.TAG);
                }
                com.bytedance.msdk.api.xj.hf hfVar2 = hfVar;
                String ra = hfVar2 != null ? hfVar2.ra() : "";
                com.bytedance.msdk.api.xj.hf hfVar3 = hfVar;
                int ht = hfVar3 != null ? hfVar3.ht() : 0;
                com.bytedance.msdk.api.xj.hf hfVar4 = hfVar;
                boolean z3 = hfVar4 == null || hfVar4.ht() == 1;
                if (!com.bytedance.msdk.core.hf.hf().xj(ra, str, ht) && z) {
                    z2 = true;
                }
                if (hfVar.dq() || !z2 || z3 || !xj.this.w(ra, str)) {
                    A2egSU.BI9f7h(new StringBuilder("--==-- 广告复用:show时预请求取消，因为：已发起waterfall预加载，或feed多广告，或未开启adn预加载，或是banner轮播 --: "), str, MediationConstant.TAG);
                } else {
                    xj.this.xj(str, hfVar, (Map<String, Object>) map, context, pVar, dVar);
                }
            }
        });
    }

    public void xj(final List<w> list, final String str, final com.bytedance.msdk.api.xj.hf hfVar, final int i, final w wVar) {
        if (list == null || list.isEmpty() || hfVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.kd.xj.xj.3
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : xj.this.hf(list, str, hfVar, i, wVar).entrySet()) {
                    String str2 = (String) entry.getKey();
                    List<c> list2 = (List) entry.getValue();
                    if (!TextUtils.isEmpty(str2) && list2 != null && list2.size() > 0) {
                        xj.this.xj(str2, list2, true);
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用，show后放回复用池：adnSlotId:" + str2 + ", 个数：" + list2.size());
                    }
                }
            }
        });
    }

    public void xj(String str, List<c> list, boolean z) {
        if (list == null || list.size() <= 0) {
            return;
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.u.get(str);
        if (copyOnWriteArrayList != null) {
            for (c cVar : list) {
                if (!xj(copyOnWriteArrayList, cVar)) {
                    copyOnWriteArrayList.add(cVar);
                }
            }
        } else {
            this.u.put(str, new CopyOnWriteArrayList<>(list));
        }
        if (z) {
            j.xj(this.u.get(str), this.d);
        }
    }

    private boolean xj(List<c> list, c cVar) {
        for (c cVar2 : list) {
            if (cVar2 != null && cVar != null && cVar2.xj == cVar.xj) {
                return true;
            }
        }
        return false;
    }

    public synchronized List<c> xj(String str, com.bytedance.msdk.api.xj.hf hfVar, int i) {
        try {
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.u.get(str);
            if (copyOnWriteArrayList == null) {
                return null;
            }
            int x = hfVar != null ? hfVar.x() : 1;
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            if (hfVar != null) {
                str2 = hfVar.ra();
            }
            int kd = kd(str2, str, i);
            if (kd == 1) {
                for (int i2 = 0; arrayList.size() < x && i2 < copyOnWriteArrayList.size(); i2++) {
                    if (!copyOnWriteArrayList.get(i2).w() && com.bytedance.msdk.core.kd.xj.xj(copyOnWriteArrayList.get(i2).u(), hfVar, copyOnWriteArrayList.get(i2).xj)) {
                        arrayList.add(copyOnWriteArrayList.get(i2));
                    }
                }
                for (int i3 = 0; arrayList.size() < x && i3 < copyOnWriteArrayList.size(); i3++) {
                    if (copyOnWriteArrayList.get(i3).w() && com.bytedance.msdk.core.kd.xj.xj(copyOnWriteArrayList.get(i3).u(), hfVar, copyOnWriteArrayList.get(i3).xj)) {
                        arrayList.add(copyOnWriteArrayList.get(i3));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).xj(true);
                }
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 复用模式1，不从复用池移除，获取缓存: " + str + ", " + arrayList.size());
            } else if (kd == 2) {
                for (c cVar : copyOnWriteArrayList) {
                    if (arrayList.size() >= x) {
                        break;
                    }
                    if (cVar.c() && cVar.xj != null) {
                        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==-- 复用模式2，广告：" + cVar.hf() + "  adnName:" + cVar.xj.gh() + " showSort:" + cVar.xj.kc() + " 暂不可用， 已经被使用中...");
                    }
                    if (com.bytedance.msdk.core.kd.xj.xj(cVar.u(), hfVar, cVar.xj) && !cVar.c()) {
                        copyOnWriteArrayList.remove(cVar);
                        arrayList.add(cVar);
                    }
                }
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 复用模式2，从复用池移除，获取缓存: " + str + ", " + arrayList.size());
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((c) it2.next()).hf(true);
            }
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int xj(String str, com.bytedance.msdk.api.xj.hf hfVar, boolean z) {
        String ra;
        if (hfVar != null) {
            try {
                ra = hfVar.ra();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            ra = "";
        }
        if (hf(ra, str) == 0) {
            return hf(str, hfVar, z);
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.u.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            c cVar = null;
            ArrayList arrayList = z ? new ArrayList() : null;
            boolean z2 = false;
            for (c cVar2 : copyOnWriteArrayList) {
                int xj = xj(cVar2, cVar2.u(), hfVar, "广告复用");
                if (xj == -1) {
                    z2 = true;
                } else {
                    if (xj != 6) {
                        copyOnWriteArrayList.remove(cVar2);
                    }
                    if (z) {
                        if (cVar == null) {
                            cVar = cVar2;
                        }
                        com.bytedance.msdk.core.kd.hf.xj xjVar = new com.bytedance.msdk.core.kd.hf.xj();
                        xjVar.u(cVar2.xj.zd());
                        xjVar.kd(cVar2.xj.kc());
                        xjVar.hf(cVar2.xj.cy());
                        xjVar.hf(xj);
                        xjVar.xj(cVar2.xj.tu() ? 1 : 0);
                        arrayList.add(xjVar);
                    }
                }
            }
            if (z2) {
                return 3;
            }
            if (z && cVar != null) {
                y.xj(hfVar, cVar.xj, xj(arrayList));
            }
            return 2;
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    private String xj(List<com.bytedance.msdk.core.kd.hf.xj> list) {
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).xj());
                if (i == list.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                return new JSONArray(sb.toString()).toString();
            } catch (JSONException e) {
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用：adCannotUseInfo json err: " + e.getMessage());
            }
        }
        return list.size() > 0 ? "json error" : "[]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, com.bytedance.msdk.api.xj.hf hfVar, Map<String, Object> map, Context context, p pVar, d dVar) {
        String xj;
        if (hfVar == null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，adSlot为空 -------: " + str);
            return;
        }
        if (context == null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，context为null -------: " + str);
            return;
        }
        tf kd = kd(hfVar.ra(), str);
        if (kd != null) {
            try {
                xj = com.bytedance.msdk.core.c.w.xj(kd.c(), com.bytedance.msdk.core.c.w.xj(kd.qt()), com.bytedance.msdk.hf.xj.xj(kd.g(), kd.y()));
            } catch (Throwable th) {
                pl.xj(th);
            }
            if (TextUtils.isEmpty(xj) && com.bytedance.msdk.core.c.w.hf(xj) && kd != null) {
                for (String str2 : this.xj) {
                    if (TextUtils.equals(str2, kd.qt())) {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，" + str2 + "为单例模式 -------: " + str);
                        return;
                    }
                }
                int intValue = this.c.get(str) != null ? this.c.get(str).intValue() : -1;
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:show时预请求开始 -------: " + str);
                com.bytedance.msdk.w.y.hf.hf xj2 = com.bytedance.msdk.w.y.hf.hf.xj(kd, (com.bytedance.msdk.w.hf.hf.xj) null);
                xj2.w(4);
                xj2.hf(1);
                com.bytedance.msdk.w.xj.xj xj3 = com.bytedance.msdk.w.f.w.xj(xj2, hfVar, new C0058xj(hfVar, kd, xj2, dVar, intValue));
                if (xj3 != null) {
                    if (!com.bytedance.msdk.core.f.p.xj().w(hfVar.ra(), kd.yo())) {
                        com.bytedance.msdk.xj.kd.w.xj("TMe", "adn 代码位预请求触发次数拦截............");
                        Pair<String, String> xj4 = com.bytedance.msdk.core.f.p.xj().xj(hfVar.ra(), kd.yo());
                        if (xj4 != null) {
                            com.bytedance.msdk.api.hf.hf hfVar2 = new com.bytedance.msdk.api.hf.hf(41041, com.bytedance.msdk.api.xj.xj(41041), (String) xj4.second, (String) xj4.first);
                            y.xj(kd, hfVar, xj().xj(kd.yo()), true, 2, intValue, 4, 1, (com.bytedance.msdk.api.xj) hfVar2, -1L, false, false);
                            y.xj(hfVar2, hfVar, kd, intValue, 4, 1, xj().xj(kd.yo()), 0L, (String) null, (String) null, (String) null, 0L);
                            return;
                        }
                        return;
                    }
                    y.xj(kd, hfVar, xj().xj(kd.yo()), xj2.kd(), 3, xj2.w(), 4, 1, (com.bytedance.msdk.api.xj) null, xj2.u(), false, false);
                    xj3.xj(context, xj2, hfVar, com.bytedance.msdk.w.f.w.xj(xj2, hfVar, map));
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 广告复用:show时预请求已发完 -------: " + str);
                    return;
                }
                y.xj(kd, hfVar, 4, 1);
                return;
            }
            StringBuilder sb = new StringBuilder("--==-- 广告复用:show时预请求取消，className或wfcBean为空, className: ");
            sb.append(xj);
            sb.append(", wfcBean: ");
            sb.append(kd);
            sb.append(", adnSlotId: ");
            A2egSU.BI9f7h(sb, str, MediationConstant.TAG);
        }
        xj = null;
        if (TextUtils.isEmpty(xj)) {
        }
        StringBuilder sb2 = new StringBuilder("--==-- 广告复用:show时预请求取消，className或wfcBean为空, className: ");
        sb2.append(xj);
        sb2.append(", wfcBean: ");
        sb2.append(kd);
        sb2.append(", adnSlotId: ");
        A2egSU.BI9f7h(sb2, str, MediationConstant.TAG);
    }
}
