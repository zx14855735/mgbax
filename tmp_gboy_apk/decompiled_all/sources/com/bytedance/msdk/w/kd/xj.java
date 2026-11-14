package com.bytedance.msdk.w.kd;

import android.text.TextUtils;
import com.bytedance.msdk.api.xj.hf;
import com.bytedance.msdk.core.kd.hf.c;
import com.bytedance.msdk.f.j;
import com.bytedance.msdk.hf.w;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.w.hf;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile xj hf;
    private final Map<Integer, CopyOnWriteArrayList<c>> xj = new ConcurrentHashMap();
    private final Comparator<c> w = new Comparator<c>() { // from class: com.bytedance.msdk.w.kd.xj.1
        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            w wVar;
            if (cVar != null && cVar2 != null && (wVar = cVar.xj) != null && cVar2.xj != null) {
                if (wVar.da() > cVar2.xj.da()) {
                    return -1;
                }
                if (cVar.xj.da() < cVar2.xj.da()) {
                    return 1;
                }
                if (cVar.xj.da() == cVar2.xj.da() && cVar.xj.gj() == 1) {
                    return -1;
                }
            }
            return 0;
        }
    };

    private xj() {
    }

    private static boolean hf(List<w> list, w wVar) {
        for (w wVar2 : list) {
            if (wVar != null && wVar2 == wVar) {
                return true;
            }
        }
        return false;
    }

    public static xj xj() {
        if (hf == null) {
            synchronized (com.bytedance.msdk.core.kd.xj.xj.class) {
                try {
                    if (hf == null) {
                        hf = new xj();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public synchronized void xj(hf hfVar, List<w> list) {
        try {
            if (com.bytedance.msdk.core.hf.hf().y()) {
                if (hfVar == null) {
                    return;
                }
                if (hfVar.dq()) {
                    return;
                }
                StringBuilder sb = new StringBuilder("广告位：");
                sb.append(hfVar.ra());
                sb.append("  type:");
                sb.append(hfVar.ht());
                sb.append(" show后把二价广告放入公共缓存池 数量：");
                sb.append(list == null ? "没有二价" : Integer.valueOf(list.size()));
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, sb.toString());
                if (list != null && !list.isEmpty()) {
                    CopyOnWriteArrayList<c> copyOnWriteArrayList = this.xj.get(Integer.valueOf(hfVar.ht()));
                    if (copyOnWriteArrayList == null) {
                        copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    }
                    for (w wVar : list) {
                        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "广告位：" + hfVar.ra() + "  代码位：" + wVar.cy() + "   adnName:" + wVar.gh() + "  loadSort:" + wVar.zd() + "  showSort:" + wVar.kc() + "  ecpm:" + wVar.da());
                        if (!xj(copyOnWriteArrayList, wVar)) {
                            copyOnWriteArrayList.add(new c(wVar, 0L, hfVar));
                        }
                    }
                    Iterator<c> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        if (!next.kd()) {
                            copyOnWriteArrayList.remove(next);
                        }
                    }
                    j.xj(copyOnWriteArrayList, this.w);
                    while (3 < copyOnWriteArrayList.size()) {
                        copyOnWriteArrayList.remove(3);
                    }
                    com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "广告位：" + hfVar.ra() + "  type:" + hfVar.ht() + "  公共缓存池二价广告的数量：" + copyOnWriteArrayList.size());
                    this.xj.put(Integer.valueOf(hfVar.ht()), copyOnWriteArrayList);
                }
            }
        } finally {
        }
    }

    public synchronized List<c> xj(hf hfVar) {
        if (hfVar == null) {
            return null;
        }
        try {
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.xj.get(Integer.valueOf(hfVar.ht()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                int x = hfVar.ht() == 5 ? hfVar.x() : 1;
                ArrayList arrayList = new ArrayList();
                for (c cVar : copyOnWriteArrayList) {
                    if (arrayList.size() >= x) {
                        break;
                    }
                    if (cVar.c() && cVar.xj != null) {
                        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==-- 公共缓存池，广告：" + cVar.hf() + "  adnName:" + cVar.xj.gh() + " showSort:" + cVar.xj.kc() + " 暂不可用， 已经被使用中...");
                    }
                    if (xj(hfVar, cVar.u()) && cVar.kd() && !cVar.c()) {
                        arrayList.add(cVar);
                        copyOnWriteArrayList.remove(cVar);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).hf(true);
                }
                return arrayList;
            }
            return null;
        } finally {
        }
    }

    public static List<w> xj(hf hfVar, List<w> list, List<w> list2) {
        if (!com.bytedance.msdk.core.hf.hf().y() || hfVar == null || list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }
        int x = hfVar.ht() == 5 ? hfVar.x() : 1;
        ArrayList arrayList = new ArrayList();
        for (w wVar : list2) {
            if (!hf(list, wVar)) {
                if (arrayList.size() >= x) {
                    break;
                }
                if (!wVar.sv() && !wVar.si() && (!wVar.cu() || wVar.da() > 0.0d)) {
                    arrayList.add(wVar);
                }
            }
        }
        return arrayList;
    }

    private boolean xj(List<c> list, w wVar) {
        for (c cVar : list) {
            if (cVar != null && wVar != null && cVar.xj == wVar) {
                return true;
            }
        }
        return false;
    }

    private boolean xj(hf hfVar, hf hfVar2) {
        if (hfVar == null || hfVar2 == null || hfVar.ht() != hfVar2.ht()) {
            return false;
        }
        if ((hfVar.ht() == 7 || hfVar.ht() == 10) && hfVar.l() == hfVar2.l()) {
            return true;
        }
        return (hfVar.ht() == 1 || hfVar.ht() == 5) && hfVar.et() == hfVar2.et() && hfVar.io() == hfVar2.io();
    }

    public static void xj(hf hfVar, String str) {
        if (TextUtils.isEmpty(str) || hfVar == null) {
            return;
        }
        if (TextUtils.isEmpty(hfVar.pl())) {
            hfVar.w(hfVar.ra());
        }
        if (str.equals(hfVar.ra())) {
            return;
        }
        hf.xj xjVar = new hf.xj(new com.bytedance.sdk.openadsdk.zg.w.w.hf(hfVar.b()));
        xjVar.u(str);
        hfVar.xj(com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj(xjVar.xj()));
    }
}
