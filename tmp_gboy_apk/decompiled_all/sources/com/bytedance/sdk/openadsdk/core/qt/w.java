package com.bytedance.sdk.openadsdk.core.qt;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.p;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.xj;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements xj.hf {
    private static volatile w hf;
    private float g;
    private final ConcurrentHashMap<Integer, u> w = new ConcurrentHashMap<>();
    private final Map<String, Float> u = new ConcurrentHashMap();
    private u kd = null;
    private JSONArray c = new JSONArray();
    private final String f = "realtime_feature";
    private long d = 0;
    private long tf = 0;
    private long p = 0;

    /* renamed from: pl, reason: collision with root package name */
    private long f10393pl = 0;
    public long xj = 0;
    private Handler y = com.bytedance.sdk.component.utils.f.xj();

    private w() {
        com.bytedance.sdk.openadsdk.core.a.xj u = com.bytedance.sdk.openadsdk.core.f.zg().u();
        if (u != null) {
            u.xj(this);
        }
    }

    private Handler g() {
        return this.y;
    }

    public static w kd() {
        if (hf == null) {
            synchronized (w.class) {
                try {
                    if (hf == null) {
                        hf = new w();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public JSONArray c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.w.keySet().isEmpty()) {
            this.c = new JSONArray();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                try {
                    for (Integer num : this.w.keySet()) {
                        int intValue = num.intValue();
                        u uVar = this.w.get(num);
                        if (uVar != null && uVar.xj().length() > 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("slot_type", intValue);
                            jSONObject.put("event_cnts", uVar.xj());
                            jSONArray.put(jSONObject);
                        }
                    }
                    if (this.kd != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("slot_type", -1);
                        jSONObject2.put("event_cnts", this.kd.xj());
                        jSONArray.put(jSONObject2);
                    }
                } catch (JSONException e) {
                    pl.w(e.getMessage());
                }
            } catch (Throwable th) {
                pl.w(th.getMessage());
            }
            this.c = jSONArray;
        }
        if (pz.hf().gh()) {
            double currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            JSONObject jSONObject3 = new JSONObject();
            pl.xj("FeatureCalc", "calc result is " + this.c.toString());
            try {
                jSONObject3.put("cost", currentTimeMillis2);
                jSONObject3.put("feature_cnt", this.c.length());
            } catch (JSONException e2) {
                pl.w(e2.getMessage());
            }
            am.xj().d(jSONObject3);
        }
        return this.c;
    }

    public long d() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        if (this.xj == 0) {
            this.xj = timeInMillis;
        }
        return timeInMillis;
    }

    public void f() {
        long d = d();
        if (d != this.xj) {
            xj.xj(xj.kd);
            this.xj = d;
        }
    }

    public long p() {
        return this.tf;
    }

    public float pl() {
        if (this.g == 0.0f) {
            this.g = p.zg();
        }
        return this.g;
    }

    public long tf() {
        return this.d;
    }

    public long u() {
        if (this.f10393pl == 0) {
            this.f10393pl = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - v.kd);
        }
        return this.f10393pl;
    }

    public long w() {
        long startElapsedRealtime;
        if (this.p == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            startElapsedRealtime = Process.getStartElapsedRealtime();
            this.p = currentTimeMillis - (elapsedRealtime - startElapsedRealtime);
        }
        return this.p;
    }

    public void y() {
        w();
        u();
        xj.xj(xj.xj, 0L, 0L);
        xj.xj(xj.u);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void hf() {
        if (pz.hf().kr()) {
            g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qt.w.4
                @Override // java.lang.Runnable
                public void run() {
                    xj.xj(xj.w, xj.y(), 0L);
                    if (w.this.kd != null) {
                        w.this.kd.hf();
                    }
                    Iterator it = w.this.w.values().iterator();
                    while (it.hasNext()) {
                        ((u) it.next()).hf();
                    }
                    w.this.tf = System.currentTimeMillis();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !pz.hf().kr()) {
            return;
        }
        if (i > 0 && i <= 10) {
            u uVar = this.w.get(Integer.valueOf(i));
            if (uVar == null) {
                uVar = new u(str2);
                this.w.put(Integer.valueOf(i), uVar);
            }
            uVar.xj(str, str3);
            return;
        }
        if (this.kd == null) {
            this.kd = new u(str2);
        }
        this.kd.xj(str, str3);
    }

    public void xj(final String str, final String str2, final String str3, final JSONObject jSONObject, final String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !pz.hf().kr()) {
            return;
        }
        str.getClass();
        switch (str) {
            case "feed_over":
            case "show":
            case "skip":
            case "click":
            case "feed_continue":
            case "feed_break":
            case "feed_pause":
            case "play_start":
                g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qt.w.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String str5 = str3;
                            int i = 0;
                            if (jSONObject != null) {
                                if (TextUtils.isEmpty(str5)) {
                                    str5 = jSONObject.optString("req_id");
                                }
                                i = jSONObject.optInt("ad_slot_type", 0);
                            } else if (str4 != null) {
                                JSONObject jSONObject2 = new JSONObject(str4);
                                if (TextUtils.isEmpty(str5)) {
                                    str5 = jSONObject2.optString("req_id");
                                }
                                i = jSONObject2.optInt("ad_slot_type", 0);
                            }
                            w.this.xj(str, str2, str5, i);
                        } catch (Exception e) {
                            pl.xj(e);
                        }
                    }
                });
                break;
        }
    }

    public void xj(final String str, final ws wsVar) {
        if (!TextUtils.isEmpty(str) && pz.hf().kr() && "videoPercent30".equals(str)) {
            g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qt.w.2
                @Override // java.lang.Runnable
                public void run() {
                    ws wsVar2 = wsVar;
                    if (wsVar2 != null) {
                        String ho = wsVar2.ho();
                        if (TextUtils.isEmpty(ho)) {
                            return;
                        }
                        w.this.xj(str, ho, wsVar.zf(), wo.f(wsVar));
                    }
                }
            });
        }
    }

    public void xj(final String str, final ws wsVar, final String str2) {
        if (TextUtils.isEmpty(str) || !pz.hf().kr()) {
            return;
        }
        if ("landingStart".equals(str) || "landingFinish".equals(str) || "landingContinue".equals(str) || "landingPause".equals(str)) {
            g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qt.w.3
                @Override // java.lang.Runnable
                public void run() {
                    ws wsVar2 = wsVar;
                    if (wsVar2 != null) {
                        String ho = wsVar2.ho();
                        if (TextUtils.isEmpty(ho)) {
                            return;
                        }
                        int f = wo.f(wsVar);
                        w.this.xj(str, ho, wsVar.zf() + str2, f);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void xj() {
        if (pz.hf().kr()) {
            g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qt.w.5
                @Override // java.lang.Runnable
                public void run() {
                    w.this.g = p.zg();
                    xj.xj(xj.hf, 0L, xj.c());
                    xj.xj(xj.y);
                    w.this.d = System.currentTimeMillis();
                }
            });
        }
    }

    public void xj(ws wsVar, float f) {
        if (wsVar != null) {
            this.u.put(wo.xj(wsVar, ""), Float.valueOf(f));
        }
    }

    public float xj(String str) {
        Float f;
        if (TextUtils.isEmpty(str) || (f = this.u.get(str)) == null) {
            return 0.0f;
        }
        return f.floatValue();
    }
}
