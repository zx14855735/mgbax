package com.bytedance.msdk.core.kd.hf;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.api.u.g;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.f.ai;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends com.bytedance.msdk.core.kd.xj {
    private static volatile u xj;
    private int g;
    private List<String> p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10126pl;
    private final Map<String, Integer> hf = new HashMap();
    private final Map<String, Long> w = new HashMap();
    private final Map<String, com.bytedance.msdk.api.xj.hf> u = new HashMap();
    private final Map<String, ConcurrentHashMap<String, List<c>>> kd = new HashMap();
    private final Map<String, Map<String, com.bytedance.msdk.api.xj>> y = new HashMap();
    private final Map<String, Boolean> c = new HashMap();
    private final Map<String, com.bytedance.msdk.core.kd.hf.hf> f = new HashMap();
    private boolean d = false;
    private int tf = 20;

    public interface hf {
        void xj(boolean z);
    }

    public interface w {
        void xj(String str, boolean z, int i, List<com.bytedance.msdk.hf.w> list);
    }

    public class xj {
        private int c;
        private int f;
        private final Activity hf;
        private final List<g> kd;
        private final int u;
        private final int w;
        private final hf y;

        public xj(Activity activity, List<g> list, int i, int i2, hf hfVar) {
            this.hf = activity;
            this.kd = list;
            this.w = i;
            this.u = i2;
            this.y = hfVar;
            this.c = list.size();
            this.f = list.size();
        }

        public static /* synthetic */ int hf(xj xjVar) {
            int i = xjVar.c;
            xjVar.c = i - 1;
            return i;
        }

        public static /* synthetic */ int w(xj xjVar) {
            int i = xjVar.f;
            xjVar.f = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj() {
            g remove;
            for (int i = 0; i < this.w; i++) {
                if (this.kd.size() > 0 && (remove = this.kd.remove(0)) != null) {
                    com.bytedance.msdk.api.xj.hf xj = remove.xj();
                    String str = remove.hf().get(0);
                    if (xj == null) {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为空，广告位：".concat(String.valueOf(str)));
                    } else if (xj.ht() == 1) {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为banner类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                    } else if (xj.ht() == 2) {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为插屏类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                    } else if (xj.ht() == 9) {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为Draw类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                    } else {
                        u.this.xj(str, xj);
                        xj.u(str);
                        com.bytedance.msdk.core.tf.hf xj2 = com.bytedance.msdk.c.xj.w.xj().xj(str, 0, 101);
                        if (xj2 != null) {
                            xj.d(xj2.a());
                        } else if (xj.ht() == 8) {
                            xj.d(10);
                        }
                        u.this.xj(this.hf, str, 5, 0, new w() { // from class: com.bytedance.msdk.core.kd.hf.u.xj.1
                            @Override // com.bytedance.msdk.core.kd.hf.u.w
                            public void xj(String str2, boolean z, int i2, List<com.bytedance.msdk.hf.w> list) {
                                xj.hf(xj.this);
                                if (!z) {
                                    xj.w(xj.this);
                                }
                                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- pendingLoadNum: " + xj.this.c);
                                if (xj.this.c > 0 || xj.this.y == null) {
                                    return;
                                }
                                xj.this.y.xj(xj.this.f <= 0);
                            }
                        });
                    }
                }
            }
            if (this.kd.size() > 0) {
                com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.kd.hf.u.xj.2
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.xj();
                    }
                }, this.u * 1000);
            }
        }
    }

    private u() {
    }

    public static long kd(String str) {
        String hf2 = ai.xj((String) null, com.bytedance.msdk.core.hf.getContext()).hf("preload_rit_ts");
        try {
            if (!TextUtils.isEmpty(hf2)) {
                return new JSONObject(hf2).optLong(str, -1L);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        return -1L;
    }

    private static void y(String str) {
        ai xj2 = ai.xj((String) null, com.bytedance.msdk.core.hf.getContext());
        String hf2 = xj2.hf("preload_rit_ts");
        try {
            JSONObject jSONObject = TextUtils.isEmpty(hf2) ? new JSONObject() : new JSONObject(hf2);
            jSONObject.put(str, System.currentTimeMillis());
            xj2.xj("preload_rit_ts", jSONObject.toString());
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public List<c> u(String str) {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, List<c>> concurrentHashMap = this.kd.get(str);
        if (concurrentHashMap != null) {
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                List<c> list = concurrentHashMap.get(it.next());
                if (list != null && list.size() > 0) {
                    arrayList.addAll(list);
                }
            }
        }
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        Map<String, com.bytedance.msdk.api.xj> map = this.y.get(str);
        if (map != null) {
            map.clear();
        }
        return arrayList;
    }

    public boolean w(String str, int i) {
        int hf2 = hf(str, i);
        return hf2 == 2 || hf2 == 3 || hf2 == 4;
    }

    public com.bytedance.msdk.core.kd.hf.hf w(String str) {
        return this.f.get(str);
    }

    private void w(String str, com.bytedance.msdk.api.xj.hf hfVar) {
        ConcurrentHashMap<String, List<c>> concurrentHashMap = this.kd.get(str);
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                List<c> list = concurrentHashMap.get(str2);
                if (list != null && list.size() > 0 && list.get(0) != null) {
                    c cVar = list.get(0);
                    if (xj(cVar, cVar.u(), hfVar, "聚合预缓存") != -1) {
                        concurrentHashMap.remove(str2);
                    }
                }
            }
        }
    }

    public int hf(String str, int i) {
        Integer num;
        if (i == 2 || (num = this.hf.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public static u xj() {
        if (xj == null) {
            synchronized (u.class) {
                try {
                    if (xj == null) {
                        xj = new u();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public com.bytedance.msdk.api.xj.hf hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.u.get(str);
    }

    public double hf(String str, com.bytedance.msdk.api.xj.hf hfVar) {
        String key;
        List<c> list;
        ConcurrentHashMap<String, List<c>> concurrentHashMap = this.kd.get(str);
        double d = -1.0d;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry<String, List<c>> entry : concurrentHashMap.entrySet()) {
                if (entry != null && (key = entry.getKey()) != null && (list = concurrentHashMap.get(key)) != null && list.size() > 0) {
                    for (c cVar : list) {
                        if (cVar != null && xj(cVar, cVar.u(), hfVar, "聚合预缓存-ra") == -1 && cVar.xj.da() > d) {
                            d = cVar.xj.da();
                        }
                    }
                }
            }
        }
        return d;
    }

    public int u() {
        return this.g;
    }

    public int w() {
        return this.f10126pl;
    }

    public void xj(String str, int i) {
        this.hf.put(str, Integer.valueOf(i));
    }

    public void xj(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.w.put(str, Long.valueOf(j));
    }

    public Long xj(String str) {
        return this.w.get(str);
    }

    public void xj(String str, com.bytedance.msdk.api.xj.hf hfVar) {
        if (hfVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.u.put(str, hfVar);
    }

    public void hf(final Context context, final String str, final int i) {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.kd.hf.u.2
            @Override // java.lang.Runnable
            public void run() {
                u.this.xj(context, str, 4, i, (w) null);
            }
        });
    }

    public void xj(String str, c cVar) {
        if (xj(str) == null || xj(str).longValue() == cVar.xj()) {
            ConcurrentHashMap<String, List<c>> concurrentHashMap = this.kd.get(str);
            String cy = cVar.xj.cy();
            if (TextUtils.isEmpty(cy)) {
                return;
            }
            if (concurrentHashMap == null) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(cVar);
                ConcurrentHashMap<String, List<c>> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(cy, copyOnWriteArrayList);
                this.kd.put(str, concurrentHashMap2);
                return;
            }
            List<c> list = concurrentHashMap.get(cy);
            if (list == null) {
                CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                copyOnWriteArrayList2.add(cVar);
                concurrentHashMap.put(cy, copyOnWriteArrayList2);
                return;
            }
            list.add(cVar);
        }
    }

    public List<String> hf() {
        return this.p;
    }

    public boolean xj(String str, com.bytedance.msdk.api.xj.hf hfVar, String str2) {
        boolean z;
        this.c.put(str, Boolean.FALSE);
        com.bytedance.msdk.core.kd.hf.hf hfVar2 = this.f.get(str);
        if (hfVar2 == null) {
            return false;
        }
        List<tf> hf2 = hfVar2.hf();
        if (com.bytedance.msdk.xj.kd.w.hf()) {
            for (tf tfVar : hf2) {
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(str) + "waterfall: " + tfVar.qt() + ", loadSort: " + tfVar.dk() + ", showSort: " + tfVar.et() + ", eCpm: " + tfVar.ra());
            }
        }
        boolean[] zArr = {true};
        String xj2 = xj(hf2, str, hfVar, hfVar2, zArr);
        w(str, hfVar);
        ConcurrentHashMap<String, List<c>> concurrentHashMap = this.kd.get(str);
        if (concurrentHashMap != null) {
            for (int i = 0; i < hf2.size(); i++) {
                List<c> list = concurrentHashMap.get(hf2.get(i).yo());
                if (list != null && list.size() > 0) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (xj2 != null) {
            if (z) {
                com.bytedance.msdk.kd.y.xj(this.u.get(str), xj2);
                return z;
            }
            hfVar.hf(3);
            if (zArr[0]) {
                hfVar.hf(1);
            }
            com.bytedance.msdk.kd.y.xj(hfVar, xj2);
        }
        return z;
    }

    private String xj(List<tf> list, String str, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.core.kd.hf.hf hfVar2, boolean[] zArr) {
        List<c> list2;
        if (list.size() <= 0) {
            return null;
        }
        ConcurrentHashMap<String, List<c>> concurrentHashMap = this.kd.get(str);
        if (concurrentHashMap != null && (list2 = concurrentHashMap.get(list.get(0).yo())) != null && list2.size() > 0 && list2.get(0) != null) {
            c cVar = list2.get(0);
            if (xj(cVar, cVar.u(), hfVar, "聚合预请求") == -1) {
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(str) + "--==-- 命中最优广告： " + cVar.xj.lw() + ", loadSort: " + cVar.xj.zd() + ", showSort: " + cVar.xj.kc());
                return null;
            }
        }
        List<com.bytedance.msdk.core.kd.hf.xj> xj2 = xj(list, str, concurrentHashMap, hfVar, hfVar2, zArr);
        if (xj2.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < xj2.size(); i++) {
                sb.append(xj2.get(i).xj());
                if (i == xj2.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                String jSONArray = new JSONArray(sb.toString()).toString();
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(str) + "adCannotUseInfo: " + jSONArray);
                return jSONArray;
            } catch (JSONException e) {
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(str) + "adCannotUseInfo json err: " + e.getMessage());
            }
        }
        return null;
    }

    private List<com.bytedance.msdk.core.kd.hf.xj> xj(List<tf> list, String str, Map<String, List<c>> map, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.core.kd.hf.hf hfVar2, boolean[] zArr) {
        com.bytedance.msdk.hf.w wVar;
        List<c> list2;
        ArrayList arrayList = new ArrayList();
        int e_ = hfVar2.e_();
        for (int i = 0; i < list.size() && i < e_; i++) {
            String yo = list.get(i).yo();
            com.bytedance.msdk.core.kd.hf.xj xjVar = new com.bytedance.msdk.core.kd.hf.xj();
            xjVar.hf(yo);
            xjVar.kd(list.get(i).et());
            xjVar.u(list.get(i).dk());
            c cVar = (map == null || (list2 = map.get(yo)) == null || list2.size() <= 0) ? null : list2.get(0);
            if (cVar != null && (wVar = cVar.xj) != null) {
                xjVar.xj(wVar.tu() ? 1 : 0);
                zArr[0] = false;
                int xj2 = xj(cVar, this.u.get(str), hfVar, "预缓存");
                if (xj2 != -1) {
                    xjVar.hf(xj2);
                    arrayList.add(xjVar);
                }
            } else {
                Map<String, com.bytedance.msdk.api.xj> map2 = this.y.get(str);
                com.bytedance.msdk.api.xj xjVar2 = map2 != null ? map2.get(yo) : null;
                if (xjVar2 != null) {
                    xjVar.hf(3);
                    xjVar.w(xjVar2.w);
                    xjVar.xj(xjVar2.u);
                } else {
                    xjVar.hf(4);
                }
                arrayList.add(xjVar);
            }
        }
        return arrayList;
    }

    public void xj(final Context context, final String str, final int i) {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.kd.hf.u.1
            @Override // java.lang.Runnable
            public void run() {
                u.this.xj(context, str, 2, i, (w) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Context context, String str, int i, int i2, w wVar) {
        int hf2 = hf(str, i2);
        if (!w(str, i2)) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(str) + "--==-- 配置未开启预加载缓存，req_type: " + hf2);
            if (wVar != null) {
                wVar.xj(str, false, 0, null);
                return;
            }
            return;
        }
        Boolean bool = this.c.get(str);
        if (bool != null && bool.booleanValue()) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(str) + "--==-- 已发起过预缓存，还未使用掉，此次不发起");
            if (wVar != null) {
                wVar.xj(str, true, 0, null);
                return;
            }
            return;
        }
        com.bytedance.msdk.api.xj.hf hfVar = this.u.get(str);
        if (hfVar == null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(str) + "--==-- 预缓存取消，adslot为null，rit：" + str);
            return;
        }
        com.bytedance.msdk.api.xj.hf hfVar2 = new com.bytedance.msdk.api.xj.hf(hfVar);
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(str) + "--==-- 预缓存开始请求, req_type: " + hf2);
        com.bytedance.msdk.core.kd.hf.hf xj2 = kd.xj(context, str, hfVar2.ht());
        this.f.put(str, xj2);
        this.c.put(str, Boolean.TRUE);
        hfVar2.u(str);
        hfVar2.hf(i);
        hfVar2.y(3);
        xj2.xj(context, hfVar2, wVar);
        y(str);
    }

    public void xj(int i) {
        this.tf = i;
    }

    public void xj(final Activity activity, final List<g> list, final int i, final int i2) {
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.core.kd.hf.u.3
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.d) {
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "注意：预加载preload只能调用一次");
                    return;
                }
                if (activity == null) {
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "预加载preload传入的activity不能是null");
                    return;
                }
                List list2 = list;
                if (list2 == null || list2.size() <= 0) {
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "预加载preload传入的requestInfos不能是null或者size为0");
                    return;
                }
                u.this.d = true;
                u.this.f10126pl = i;
                u.this.g = i2;
                u.this.p = new ArrayList();
                for (g gVar : list) {
                    if (gVar != null && gVar.hf() != null) {
                        u.this.p.addAll(gVar.hf());
                    }
                }
                int i3 = i;
                int i4 = (i3 <= 0 || i3 > 20) ? 2 : i3;
                int i5 = i2;
                int i6 = (i5 <= 0 || i5 > 10) ? 2 : i5;
                List xj2 = u.this.xj((List<g>) list);
                if (xj2.isEmpty()) {
                    return;
                }
                u.this.new xj(activity, xj2, i4, i6, new hf() { // from class: com.bytedance.msdk.core.kd.hf.u.3.1
                    @Override // com.bytedance.msdk.core.kd.hf.u.hf
                    public void xj(boolean z) {
                        if (z) {
                            return;
                        }
                        com.bytedance.msdk.core.d.kd.u().xj(u.this.kd);
                    }
                }).xj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<g> xj(List<g> list) {
        ArrayList arrayList = new ArrayList();
        int i = this.tf;
        HashSet hashSet = new HashSet();
        for (g gVar : list) {
            if (arrayList.size() >= i) {
                break;
            }
            if (gVar != null && gVar.hf() != null) {
                for (String str : gVar.hf()) {
                    if (arrayList.size() < i) {
                        if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                            hashSet.add(str);
                            ArrayList arrayList2 = new ArrayList(1);
                            arrayList2.add(str);
                            arrayList.add(new g(gVar.xj(), arrayList2));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void xj(Context context, String str, int i, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.hf.w wVar, w wVar2) {
        com.bytedance.msdk.core.kd.hf.w xj2 = y.xj(i, context, str, hfVar == null ? 0 : hfVar.ht());
        if (xj2 != null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 预缓存补充请求发起 reqType: " + i);
            xj2.xj(hfVar, wVar, wVar2);
        }
    }
}
