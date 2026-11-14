package com.bytedance.sdk.openadsdk.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static volatile hf xj;
    private com.bytedance.sdk.component.u.hf.w c;
    private com.bytedance.sdk.component.u.hf.w d;
    private com.bytedance.sdk.component.u.hf.w f;
    private com.bytedance.sdk.component.u.hf.w tf;
    private volatile int p = 0;

    /* renamed from: pl, reason: collision with root package name */
    private int f10274pl = 0;
    private int g = 0;
    private final Map<String, Integer> hf = new HashMap();
    private final ConcurrentHashMap<String, Integer> w = new ConcurrentHashMap<>();
    private final Map<String, Long> u = new HashMap();
    private final ConcurrentHashMap<String, Long> kd = new ConcurrentHashMap<>();
    private final long y = SystemClock.elapsedRealtime();

    private hf() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.u.hf.w c() {
        if (this.tf == null) {
            this.tf = j.xj("activity_recorder");
        }
        return this.tf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.u.hf.w kd() {
        if (this.f == null) {
            this.f = j.xj("activity_adshow_count");
        }
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.u.hf.w y() {
        if (this.d == null) {
            this.d = j.xj("activity_foreground_time");
        }
        return this.d;
    }

    public void hf(final String str) {
        com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.hf.1
            @Override // java.lang.Runnable
            public void run() {
                hf.this.u().put(str, hf.this.u().get(str, 0) + 1);
                if (hf.this.p == 0) {
                    hf hfVar = hf.this;
                    hfVar.p = hfVar.c().get("histRunningCount", 0) + 1;
                    hf.this.c().put("histRunningCount", hf.this.p);
                }
            }
        });
    }

    public void u(final String str) {
        com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.hf.3
            @Override // java.lang.Runnable
            public void run() {
                hf.this.kd().put(str, hf.this.kd().get(str, 0) + 1);
            }
        });
    }

    public void w(String str) {
        Long remove;
        if (TextUtils.isEmpty(str) || (remove = this.kd.remove(str)) == null) {
            return;
        }
        long elapsedRealtime = (SystemClock.elapsedRealtime() - remove.longValue()) / 1000;
        if (elapsedRealtime >= 0) {
            Long l = this.u.get(str);
            if (l == null || l.longValue() < 0) {
                l = 0L;
            }
            this.u.put(str, Long.valueOf(l.longValue() + elapsedRealtime));
            xj(str, elapsedRealtime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.u.hf.w u() {
        if (this.c == null) {
            this.c = j.xj("activity_resume_count");
        }
        return this.c;
    }

    public void hf() {
        if (this.kd.size() == 1) {
            for (String str : this.kd.keySet()) {
                Integer num = this.w.get(str);
                this.w.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                u(str);
            }
        }
    }

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new hf();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.hf.get(str);
        this.hf.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.kd.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        if (this.kd.size() > 1) {
            this.f10274pl++;
        }
        hf(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        try {
            Map all = u().getAll();
            if (all == null) {
                return;
            }
            Iterator it = all.values().iterator();
            int i = 0;
            while (it.hasNext()) {
                i += ((Integer) it.next()).intValue();
            }
            if (i != 0 && i % 75 == 0) {
                final JSONArray jSONArray = new JSONArray();
                for (String str : this.hf.keySet()) {
                    Integer num = this.hf.get(str);
                    Long l = this.u.get(str);
                    Integer num2 = this.w.get(str);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", str);
                        jSONObject.put("rc", num != null ? num.intValue() : 0);
                        jSONObject.put("ft", l != null ? l.longValue() : 0L);
                        jSONObject.put("asc", num2 != null ? num2.intValue() : 0);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                }
                final JSONArray jSONArray2 = new JSONArray();
                Map all2 = y().getAll();
                Map all3 = kd().getAll();
                if (all2 != null && all3 != null) {
                    for (String str2 : all.keySet()) {
                        Integer num3 = (Integer) all.get(str2);
                        Long l2 = (Long) all2.get(str2);
                        Integer num4 = (Integer) all3.get(str2);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", str2);
                            jSONObject2.put("rc", num3 != null ? num3.intValue() : 0);
                            jSONObject2.put("ft", l2 != null ? l2.longValue() : 0L);
                            jSONObject2.put("asc", num4 != null ? num4.intValue() : 0);
                            jSONArray2.put(jSONObject2);
                        } catch (JSONException e2) {
                            com.bytedance.sdk.component.utils.pl.xj(e2);
                        }
                    }
                }
                final long elapsedRealtime = (SystemClock.elapsedRealtime() - this.y) / 1000;
                com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.a.hf.4
                    @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                    public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("ara", jSONArray);
                        jSONObject3.put("hara", jSONArray2);
                        jSONObject3.put("rt", elapsedRealtime);
                        jSONObject3.put("hrc", hf.this.p);
                        jSONObject3.put("drc", hf.this.f10274pl);
                        return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("ad_activity_record").hf(jSONObject3.toString());
                    }
                }, "ad_activity_record");
            }
        } catch (Throwable unused) {
        }
    }

    public void xj(final String str, final long j) {
        com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.hf.2
            @Override // java.lang.Runnable
            public void run() {
                long j2 = hf.this.y().get(str, 0L);
                hf.this.y().put(str, (j2 >= 0 ? j2 : 0L) + j);
                hf.this.w();
                hf.this.xj(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(long j) {
        int i = this.g;
        if (i == 0) {
            try {
                Map all = y().getAll();
                if (all != null) {
                    Iterator it = all.values().iterator();
                    while (it.hasNext()) {
                        this.g = (int) (this.g + ((Long) it.next()).longValue());
                    }
                }
            } catch (Throwable unused) {
                this.g = -1;
            }
        } else {
            this.g = (int) (i + j);
        }
        dk.xj(this.g, this.p);
    }
}
