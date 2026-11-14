package com.bytedance.sdk.openadsdk.core.kd.hf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.db.a;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private String c;
    private kd f;

    /* renamed from: pl, reason: collision with root package name */
    private final int f10369pl;
    private final AtomicBoolean kd = new AtomicBoolean(false);
    private final AtomicBoolean y = new AtomicBoolean(false);
    List<ws> xj = new ArrayList();
    List<ws> hf = new ArrayList();
    List<ws> w = new ArrayList();
    List<String> u = new ArrayList();
    private long d = -1;
    private long tf = -1;
    private long p = -1;
    private final Runnable g = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kd.hf.xj.1
        @Override // java.lang.Runnable
        public void run() {
            if (xj.this.y.get()) {
                return;
            }
            xj.this.kd.set(true);
            Iterator<ws> it = xj.this.w.iterator();
            while (it.hasNext()) {
                it.next().d(100003L);
            }
            xj xjVar = xj.this;
            xjVar.hf(xjVar.xj);
        }
    };

    public xj(int i) {
        this.f10369pl = i;
    }

    private void u(List<ws> list) {
        list.size();
        Iterator<ws> it = list.iterator();
        while (it.hasNext()) {
            hf(it.next());
        }
        kd kdVar = this.f;
        if (kdVar != null) {
            kdVar.hf(list);
        }
        xj();
    }

    private void w(long j) {
        this.p = j;
    }

    private void w(List<ws> list) {
        list.size();
        Iterator<ws> it = list.iterator();
        while (it.hasNext()) {
            hf(it.next());
        }
        kd kdVar = this.f;
        if (kdVar != null) {
            kdVar.xj(list);
        }
        xj();
    }

    public void hf(long j) {
        this.tf = j;
    }

    private JSONObject hf(int i, List<ws> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<ws> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(xj(it.next()));
            }
            jSONObject.put(a.f13169a, jSONArray);
            jSONObject.put("check_type", i);
            return jSONObject;
        } catch (JSONException e) {
            e.getMessage();
            return jSONObject;
        }
    }

    public void xj() {
        this.f = null;
        f.w().removeCallbacks(this.g);
    }

    public void xj(long j) {
        this.d = j;
    }

    public void xj(List<ws> list, kd kdVar) {
        this.f = kdVar;
        xj(list);
    }

    private void xj(List<ws> list) {
        boolean z;
        this.xj = list;
        this.hf.clear();
        this.w.clear();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        for (ws wsVar : list) {
            this.u.add(wsVar.qa());
            JSONObject m7if = wsVar.m7if();
            if (m7if == null) {
                wsVar.f(-1L);
                this.hf.add(wsVar);
            } else {
                int optInt = m7if.optInt("cache_correct_type", i);
                int optInt2 = m7if.optInt("is_need_cache_correct", i);
                int optInt3 = m7if.optInt("is_need_cache_check", i);
                boolean z4 = optInt == 1;
                boolean z5 = optInt2 == 1;
                boolean z6 = optInt3 == 1;
                if (!z4) {
                    this.hf.add(wsVar);
                    wsVar.f(0L);
                } else if (z5 || z6) {
                    if (!z5) {
                        this.w.add(wsVar);
                        wsVar.f(3L);
                    } else {
                        long optLong = m7if.optLong("creative_check_duration", 0L);
                        if (optLong > 0) {
                            z = z2;
                            if (Math.abs((System.currentTimeMillis() / 1000) - wo.pl(wsVar)) <= optLong) {
                                if (!z6) {
                                    this.hf.add(wsVar);
                                    wsVar.f(4L);
                                    wsVar.d(100002L);
                                    z2 = z;
                                    i = 0;
                                } else {
                                    this.w.add(wsVar);
                                    wsVar.f(6L);
                                    i = 0;
                                }
                            }
                        } else {
                            z = z2;
                        }
                        if (!z6) {
                            this.w.add(wsVar);
                            wsVar.f(5L);
                            z2 = z;
                            i = 0;
                        } else {
                            this.w.add(wsVar);
                            wsVar.f(7L);
                            i = 0;
                            z2 = true;
                        }
                        z3 = true;
                    }
                    z2 = true;
                } else {
                    this.hf.add(wsVar);
                    wsVar.f(2L);
                    wsVar.d(100002L);
                }
            }
            z = z2;
            z2 = z;
            i = 0;
        }
        boolean z7 = z2;
        if (!this.w.isEmpty() && (z7 || z3)) {
            xj((z7 && z3) ? 3 : z7 ? 1 : z3 ? 2 : 0, this.w);
        } else {
            w(this.hf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(List<ws> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : this.u) {
            for (ws wsVar : list) {
                if (str.equals(wsVar.qa())) {
                    arrayList.add(wsVar);
                }
            }
        }
        u(arrayList);
    }

    private void hf(ws wsVar) {
        w(System.currentTimeMillis());
        if (wsVar.ps() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String hf = wo.hf(this.f10369pl);
            long j = this.tf;
            long j2 = this.d;
            jSONObject.put("cache_get_duration", j - j2 < 0 ? -1L : j - j2);
            long j3 = this.p;
            long j4 = this.tf;
            jSONObject.put("network_check_duration", j3 - j4 < 0 ? -1L : j3 - j4);
            long j5 = this.p;
            long j6 = this.d;
            jSONObject.put("cache_total_duration", j5 - j6 < 0 ? -1L : j5 - j6);
            jSONObject.put("cache_loss_reason", this.c);
            jSONObject.put("correct_action_code", wsVar.ps());
            jSONObject.put("correct_result_code", wsVar.js());
            jSONObject.put("creative_check_duration", wsVar.m7if() != null ? wsVar.m7if().optLong("creative_check_duration", 0L) : -1L);
            com.bytedance.sdk.openadsdk.core.am.u.hf(wsVar, hf, jSONObject);
        } catch (Exception unused) {
        }
    }

    private void xj(final int i, final List<ws> list) {
        Iterator<ws> it = list.iterator();
        long j = 2147483647L;
        while (it.hasNext()) {
            JSONObject m7if = it.next().m7if();
            long optLong = m7if == null ? 0L : m7if.optLong("correct_interface_timeout", 0L);
            if (optLong > 0) {
                j = Math.min(j, optLong);
            }
        }
        if (j == 2147483647L) {
            j = 0;
        }
        if (j > 0) {
            f.w().postDelayed(this.g, j);
        }
        pz.xj().xj(hf(i, list), new hf<u>() { // from class: com.bytedance.sdk.openadsdk.core.kd.hf.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.kd.hf.hf
            public void xj(u uVar, long j2, long j3) {
                try {
                    xj.this.xj(i, list, uVar, j2);
                } catch (Exception e) {
                    pl.xj(e);
                    e.getMessage();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, List<ws> list, u uVar, long j) {
        if (this.kd.get()) {
            return;
        }
        this.y.set(true);
        if (uVar == null || uVar.xj()) {
            u(Collections.EMPTY_LIST);
            return;
        }
        if (j != 20000) {
            Iterator<ws> it = list.iterator();
            while (it.hasNext()) {
                it.next().d(100001L);
            }
            hf(this.xj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<String, JSONObject> map = uVar.hf;
        for (ws wsVar : list) {
            String xj = u.xj(wsVar.ho(), wsVar.zf());
            JSONObject jSONObject = TextUtils.isEmpty(xj) ? null : map.get(xj);
            if (jSONObject == null) {
                wsVar.d(100004L);
                arrayList.add(wsVar);
            } else {
                if (jSONObject.has("is_valid")) {
                    if (jSONObject.optBoolean("is_valid")) {
                        if (i == 2 || i == 3) {
                            String optString = jSONObject.optString(n.m);
                            String optString2 = jSONObject.optString("media_ext");
                            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                                wsVar.ht(optString);
                                wsVar.xj(xj(new JSONObject(optString2), wsVar.pu()));
                            } else {
                                wsVar.d(100006L);
                                arrayList.add(wsVar);
                            }
                        }
                        wsVar.d(100000L);
                        arrayList.add(wsVar);
                    } else {
                        arrayList2.add(wsVar);
                        this.c = jSONObject.optString(MediationConstant.KEY_REASON);
                        wsVar.d(100007L);
                    }
                } else {
                    wsVar.d(100005L);
                    arrayList.add(wsVar);
                }
                arrayList.addAll(this.hf);
                hf(arrayList);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    hf((ws) it2.next());
                }
                kd kdVar = this.f;
                if (kdVar != null) {
                    kdVar.w(arrayList2);
                }
            }
        }
    }

    public static Map<String, Object> xj(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject == null) {
            return map;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    private JSONObject xj(ws wsVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            String ho = wsVar.ho();
            String jf = wsVar.jf();
            Map<String, Object> pu = wsVar.pu();
            String str = "";
            if (pu != null) {
                JSONObject jSONObject2 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = pu.entrySet();
                if (!entrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                if (jSONObject2.length() > 0) {
                    str = jSONObject2.toString();
                }
            }
            xj(ho, jf, str, wsVar.zf(), jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void xj(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        StringBuilder sb = new StringBuilder("id=");
        sb.append(str);
        sb.append("&timestamp=");
        sb.append(currentTimeMillis);
        sb.append("&ext=");
        A2egSU.BIYEnU(sb, str2, "&media_ext=", str3, "&req_id=");
        sb.append(str4);
        String upperCase = com.bytedance.sdk.component.utils.kd.hf(sb.toString()).toUpperCase();
        jSONObject.put(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, str);
        jSONObject.put("timestamp", currentTimeMillis);
        jSONObject.put(n.m, str2);
        jSONObject.put("media_ext", str3);
        jSONObject.put("req_id", str4);
        jSONObject.put("sign", upperCase);
    }
}
