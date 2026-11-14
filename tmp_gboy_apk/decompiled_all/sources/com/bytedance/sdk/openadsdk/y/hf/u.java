package com.bytedance.sdk.openadsdk.y.hf;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.x.d;
import com.bytedance.sdk.openadsdk.y.w.am;
import com.bytedance.sdk.openadsdk.y.w.c;
import com.bytedance.sdk.openadsdk.y.w.e;
import com.bytedance.sdk.openadsdk.y.w.f;
import com.bytedance.sdk.openadsdk.y.w.g;
import com.bytedance.sdk.openadsdk.y.w.kd;
import com.bytedance.sdk.openadsdk.y.w.p;
import com.bytedance.sdk.openadsdk.y.w.qt;
import com.bytedance.sdk.openadsdk.y.w.tf;
import com.bytedance.sdk.openadsdk.y.w.y;
import com.bytedance.sdk.openadsdk.y.w.zg;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private static final Map<com.bykv.vk.openvk.component.video.api.hf.xj, e> xj = Collections.synchronizedMap(new WeakHashMap());

    static {
        SnoxHV();
    }

    private static /* synthetic */ void SnoxHV() {
        char[] charArray = "¹µ·ô½»·¿ô¸µ£ô©²¿¶¶ô\u0090´³\u0098¨³¾½¿".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 218);
        }
        String str = new String(charArray);
        char[] charArray2 = "¹¶³´³®".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 218);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void kd(final com.bykv.vk.openvk.component.video.api.hf.xj xjVar, final e.xj xjVar2) {
        w.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.11
            @Override // java.lang.Runnable
            public void run() {
                e.xj xjVar3;
                if (com.bykv.vk.openvk.component.video.api.hf.xj.this == null || (xjVar3 = xjVar2) == null) {
                    return;
                }
                if (xjVar3.pl() <= 0) {
                    pl.xj("VideoEventManager", "Cancel log report when buffer count is 0");
                    return;
                }
                e eVar = (e) u.xj.get(com.bykv.vk.openvk.component.video.api.hf.xj.this);
                if (eVar == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.w.u u = eVar.u();
                ws kd = eVar.kd();
                if (u == null || kd == null) {
                    return;
                }
                long u2 = xjVar2.u();
                if (u2 <= 0) {
                    return;
                }
                am amVar = new am();
                amVar.xj(xjVar2.w());
                amVar.hf(u2);
                amVar.xj(xjVar2.pl());
                JSONObject xj2 = u.xj(u, eVar.hf(), eVar.w(), u.yo(), kd, SystemClock.elapsedRealtime() - eVar.xj());
                u.xj(xj2, u.kd("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.y.w.hf hfVar = new com.bytedance.sdk.openadsdk.y.w.hf(kd, wo.hf(kd), xj2, amVar);
                hfVar.xj(xjVar2.g());
                u.hf(hfVar, "play_buffer");
            }
        });
    }

    public static void u(com.bytedance.sdk.openadsdk.y.w.hf<tf> hfVar) {
        hf(hfVar, "load_video_cancel");
    }

    public static void w(com.bytedance.sdk.openadsdk.y.w.hf<p> hfVar) {
        hf(hfVar, "load_video_error");
    }

    public static void hf(com.bytedance.sdk.openadsdk.y.w.hf<g> hfVar) {
        hf(hfVar, "load_video_success");
    }

    private static boolean kd(com.bytedance.sdk.openadsdk.y.w.hf hfVar) {
        ws xj2;
        com.bytedance.sdk.openadsdk.zg.w.w.hf gh;
        if (hfVar == null || !hfVar.kd() || (xj2 = hfVar.xj()) == null || (gh = xj2.gh()) == null) {
            return false;
        }
        String ht = gh.ht();
        if (TextUtils.isEmpty(ht)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(ht);
            int length = jSONArray.length();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; i < length; i++) {
                String optString = jSONArray.getJSONObject(i).optString("name");
                if ("content_did".equalsIgnoreCase(optString)) {
                    z = true;
                } else if ("content_utmsource".equalsIgnoreCase(optString)) {
                    z2 = true;
                } else if ("content_sdk_version".equalsIgnoreCase(optString)) {
                    z3 = true;
                }
            }
            return z && z2 && z3;
        } catch (JSONException e) {
            e.getMessage();
            return false;
        }
    }

    public static void u(final com.bykv.vk.openvk.component.video.api.hf.xj xjVar, final e.xj xjVar2) {
        w.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.10
            @Override // java.lang.Runnable
            public void run() {
                e.xj xjVar3;
                com.bykv.vk.openvk.component.video.api.hf.xj xjVar4 = com.bykv.vk.openvk.component.video.api.hf.xj.this;
                if (xjVar4 == null || (xjVar3 = xjVar2) == null) {
                    return;
                }
                u.kd(xjVar4, xjVar3);
                e eVar = (e) u.xj.get(com.bykv.vk.openvk.component.video.api.hf.xj.this);
                if (eVar == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.w.u u = eVar.u();
                ws kd = eVar.kd();
                if (u == null || kd == null) {
                    return;
                }
                long hf = xjVar2.hf();
                long u2 = xjVar2.u();
                if (u2 <= 0) {
                    return;
                }
                c cVar = new c();
                cVar.hf(xjVar2.w());
                cVar.xj(u2);
                cVar.xj(xjVar2.p());
                JSONObject xj2 = u.xj(u, eVar.hf(), eVar.w(), u.yo(), kd, SystemClock.elapsedRealtime() - eVar.xj());
                u.xj(xj2, u.kd("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.y.w.hf hfVar = new com.bytedance.sdk.openadsdk.y.w.hf(kd, wo.hf(kd), xj2, cVar);
                hfVar.xj(xjVar2.g());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, hf);
                    jSONObject.put("percent", xjVar2.d());
                    com.bytedance.sdk.openadsdk.core.x.am.xj(hf, kd, u);
                    u.hf(hfVar, u.hf(kd, "feed_over"), jSONObject);
                } catch (JSONException e) {
                    pl.xj(e);
                }
                u.xj.remove(com.bykv.vk.openvk.component.video.api.hf.xj.this);
            }
        });
    }

    public static void w(final com.bykv.vk.openvk.component.video.api.hf.xj xjVar, final e.xj xjVar2) {
        w.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.8
            @Override // java.lang.Runnable
            public void run() {
                e eVar;
                if (com.bykv.vk.openvk.component.video.api.hf.xj.this == null || xjVar2 == null || (eVar = (e) u.xj.get(com.bykv.vk.openvk.component.video.api.hf.xj.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.w.u u = eVar.u();
                ws kd = eVar.kd();
                if (u == null || kd == null) {
                    return;
                }
                long hf = xjVar2.hf();
                long u2 = xjVar2.u();
                com.bytedance.sdk.openadsdk.y.w.w wVar = new com.bytedance.sdk.openadsdk.y.w.w();
                wVar.w(xjVar2.w());
                wVar.u(u2);
                wVar.hf(xjVar2.c());
                wVar.w(xjVar2.f());
                wVar.hf(d.xj(kd.ul()).hf(u));
                wVar.xj(hf);
                wVar.xj(xjVar2.d());
                JSONObject xj2 = u.xj(u, eVar.hf(), eVar.w(), u.yo(), kd, SystemClock.elapsedRealtime() - eVar.xj());
                u.xj(xj2, u.kd("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.y.w.hf hfVar = new com.bytedance.sdk.openadsdk.y.w.hf(kd, wo.hf(kd), xj2, wVar);
                hfVar.xj(xjVar2.g());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, hf);
                    jSONObject.put("percent", xjVar2.d());
                    u.hf(hfVar, "endcard_skip", jSONObject);
                } catch (JSONException e) {
                    pl.xj(e);
                }
                w.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.xj.remove(com.bykv.vk.openvk.component.video.api.hf.xj.this);
                    }
                }, 1000L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hf(ws wsVar, String str) {
        if (wsVar == null || !wo.y(wsVar) || !wo.c(wsVar)) {
            return str;
        }
        str.getClass();
        switch (str) {
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        return new File(uVar.kd(), uVar.e()).getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long w(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        if (uVar == null) {
            return 0L;
        }
        com.bykv.vk.openvk.component.video.api.w.w dk = uVar.am() ? uVar.dk() : uVar.ra();
        if (dk != null) {
            return Double.valueOf(dk.y() * 1000.0d).longValue();
        }
        return 0L;
    }

    public static JSONObject xj(com.bykv.vk.openvk.component.video.api.w.u uVar, String str, int i, int i2, ws wsVar, long j) {
        com.bykv.vk.openvk.component.video.api.w.w ra;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (com.bytedance.sdk.openadsdk.x.tf.xj(wsVar)) {
                jSONObject.put("is_audio", 1);
            }
            if (uVar != null) {
                if (uVar.am()) {
                    ra = uVar.dk();
                    jSONObject.put("codec", "h265");
                } else {
                    ra = uVar.ra();
                }
                if (ra != null) {
                    jSONObject.put("video_resolution", ra.d());
                    jSONObject.put("video_size", Long.valueOf(ra.kd()));
                    String pl2 = ra.pl();
                    jSONObject.put("video_url", pl2);
                    jSONObject.put("is_expired", wo.pl(pl2));
                    jSONObject.put("send_duration", Math.floor(System.currentTimeMillis() - (wo.pl(wsVar) * 1000.0d)));
                    jSONObject.put("start_duration", j);
                    jSONObject.put("player_type", i2);
                    jSONObject.put("play_speed_ratio", ra.f());
                    if (ra.c() > 0.0d) {
                        jSONObject.put("start", ra.c());
                    }
                }
            }
            if (wsVar != null) {
                jSONObject.put("dynamic_join_type", wsVar.uh());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void hf(final com.bykv.vk.openvk.component.video.api.hf.xj xjVar, final e.xj xjVar2) {
        w.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.6
            @Override // java.lang.Runnable
            public void run() {
                e eVar;
                if (com.bykv.vk.openvk.component.video.api.hf.xj.this == null || xjVar2 == null || (eVar = (e) u.xj.get(com.bykv.vk.openvk.component.video.api.hf.xj.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.w.u u = eVar.u();
                ws kd = eVar.kd();
                if (u == null || kd == null) {
                    return;
                }
                long hf = xjVar2.hf();
                long u2 = xjVar2.u();
                if (u2 <= 0 || hf <= 0) {
                    return;
                }
                y yVar = new y();
                yVar.xj(xjVar2.w());
                yVar.hf(u2);
                JSONObject xj2 = u.xj(u, eVar.hf(), eVar.w(), u.yo(), kd, SystemClock.elapsedRealtime() - eVar.xj());
                u.xj(xj2, u.kd("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.y.w.hf hfVar = new com.bytedance.sdk.openadsdk.y.w.hf(kd, wo.hf(kd), xj2, yVar);
                hfVar.xj(xjVar2.g());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, hf);
                    jSONObject.put("percent", xjVar2.d());
                    u.hf(hfVar, "feed_continue", jSONObject);
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(com.bytedance.sdk.openadsdk.y.w.hf hfVar, String str) {
        hf(hfVar, str, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(final com.bytedance.sdk.openadsdk.y.w.hf hfVar, String str, JSONObject jSONObject) {
        if (hfVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (hfVar.kd() && !TextUtils.isEmpty(hfVar.hf()) && !kd(hfVar)) {
            String hf = hfVar.hf();
            hf.getClass();
            switch (hf) {
                case "stream":
                case "embeded_ad":
                case "draw_ad":
                    str = "customer_".concat(String.valueOf(str));
                    break;
            }
        }
        hf.xj(str, hfVar.xj());
        com.bytedance.sdk.openadsdk.core.am.u.xj(hfVar.xj(), hfVar.hf(), str, jSONObject, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.2
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject2) {
                JSONObject w = com.bytedance.sdk.openadsdk.y.w.hf.this.w();
                if (com.bytedance.sdk.openadsdk.y.w.hf.this.u() != null) {
                    com.bytedance.sdk.openadsdk.y.w.hf.this.u().a_(w);
                }
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, w.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(final ws wsVar, final com.bykv.vk.openvk.component.video.api.w.u uVar, final e.xj xjVar) {
        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.3
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", u.w(com.bykv.vk.openvk.component.video.api.w.u.this));
                jSONObject.put("player_duration", xjVar.u());
                jSONObject.put("cache_path_type", d.u());
                jSONObject.put("url", com.bykv.vk.openvk.component.video.api.w.u.this.zg());
                jSONObject.put("path", u.u(com.bykv.vk.openvk.component.video.api.w.u.this));
                jSONObject.put("player_type", com.bykv.vk.openvk.component.video.api.w.u.this.yo());
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("pangle_video_play_state").xj(wo.f(wsVar)).hf(jSONObject.toString());
            }
        }, "pangle_video_play_state");
    }

    public static synchronized com.bykv.vk.openvk.component.video.api.w.u hf(com.bykv.vk.openvk.component.video.api.hf.xj xjVar) {
        synchronized (u.class) {
            if (xjVar == null) {
                return null;
            }
            e eVar = xj.get(xjVar);
            if (eVar == null) {
                return null;
            }
            return eVar.u();
        }
    }

    public static void xj(com.bytedance.sdk.openadsdk.y.w.hf<com.bytedance.sdk.openadsdk.y.w.pl> hfVar) {
        hf(hfVar, "load_video_start");
    }

    public static boolean xj(ws wsVar, com.bykv.vk.openvk.component.video.api.hf.xj xjVar, com.bykv.vk.openvk.component.video.api.w.u uVar) {
        int ul = wsVar.ul();
        com.bykv.vk.openvk.component.video.api.xj.hf xj2 = d.xj(ul);
        if (ul != 0) {
            if (ul == 1) {
                return xj2.xj(uVar);
            }
            return false;
        }
        long hf = xj2.hf(uVar);
        boolean g = uVar.g();
        int y = uVar.y();
        if (g) {
            y = (int) uVar.pl();
        }
        int hf2 = uVar.hf();
        if (hf2 > 0) {
            y = hf2;
        }
        return hf >= ((long) y);
    }

    public static void xj(final ws wsVar, final com.bykv.vk.openvk.component.video.api.hf.xj xjVar, final com.bykv.vk.openvk.component.video.api.w.u uVar, final boolean z) {
        w.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.1
            @Override // java.lang.Runnable
            public void run() {
                if (ws.this == null || xjVar == null || uVar == null) {
                    return;
                }
                String uuid = UUID.randomUUID().toString();
                com.bykv.vk.openvk.component.video.api.xj.hf xj2 = d.xj(ws.this.ul());
                int i = u.xj(ws.this, xjVar, uVar) ? 1 : 2;
                u.xj.put(xjVar, new e(SystemClock.elapsedRealtime(), uuid, i, uVar, ws.this));
                long hf = xj2.hf(uVar);
                zg zgVar = new zg();
                if (hf > 0) {
                    zgVar.xj(hf);
                }
                zgVar.xj(z);
                com.bytedance.sdk.openadsdk.core.x.am.xj(i, hf, ws.this, uVar);
                com.bykv.vk.openvk.component.video.api.w.u uVar2 = uVar;
                JSONObject xj3 = u.xj(uVar2, uuid, i, uVar2.yo(), ws.this, 0L);
                u.xj(xj3, uVar.kd("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.y.w.hf hfVar = new com.bytedance.sdk.openadsdk.y.w.hf(ws.this, wo.hf(ws.this), xj3, zgVar);
                hfVar.xj(uVar.yo() == -1);
                u.hf(hfVar, "play_start");
            }
        });
    }

    public static void xj(final com.bykv.vk.openvk.component.video.api.hf.xj xjVar, final e.xj xjVar2) {
        w.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.4
            @Override // java.lang.Runnable
            public void run() {
                e eVar;
                if (com.bykv.vk.openvk.component.video.api.hf.xj.this == null || xjVar2 == null || (eVar = (e) u.xj.get(com.bykv.vk.openvk.component.video.api.hf.xj.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.w.u u = eVar.u();
                ws kd = eVar.kd();
                if (u == null || kd == null) {
                    return;
                }
                if (!com.bytedance.sdk.openadsdk.x.tf.xj(kd) || v.hf(kd)) {
                    if (!xjVar2.g()) {
                        u.hf(kd, u, xjVar2);
                    }
                    com.bytedance.sdk.openadsdk.y.w.d dVar = new com.bytedance.sdk.openadsdk.y.w.d();
                    dVar.hf(xjVar2.am() ? 1 : 0);
                    dVar.xj(xjVar2.qt() ? 1 : 0);
                    dVar.hf(d.xj(kd.ul()).hf(u));
                    long elapsedRealtime = SystemClock.elapsedRealtime() - eVar.xj();
                    dVar.xj(elapsedRealtime);
                    JSONObject xj2 = u.xj(u, eVar.hf(), eVar.w(), u.yo(), kd, elapsedRealtime);
                    u.xj(xj2, u.kd("EXTRA_PLAY_START"));
                    com.bytedance.sdk.openadsdk.y.w.hf hfVar = new com.bytedance.sdk.openadsdk.y.w.hf(kd, wo.hf(kd), xj2, dVar);
                    hfVar.xj(xjVar2.g());
                    u.hf(hfVar, u.hf(kd, "feed_play"));
                }
            }
        });
    }

    public static String xj(com.bykv.vk.openvk.component.video.api.hf.xj xjVar) {
        e eVar;
        if (xjVar != null && (eVar = xj.get(xjVar)) != null) {
            String hf = eVar.hf();
            if (!TextUtils.isEmpty(hf)) {
                return hf;
            }
        }
        return "empty";
    }

    public static void xj(final com.bykv.vk.openvk.component.video.api.hf.xj xjVar, final e.xj xjVar2, final int i) {
        w.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.5
            @Override // java.lang.Runnable
            public void run() {
                e eVar;
                if (com.bykv.vk.openvk.component.video.api.hf.xj.this == null || xjVar2 == null || (eVar = (e) u.xj.get(com.bykv.vk.openvk.component.video.api.hf.xj.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.w.u u = eVar.u();
                ws kd = eVar.kd();
                if (u == null || kd == null) {
                    return;
                }
                long hf = xjVar2.hf();
                long u2 = xjVar2.u();
                if (u2 <= 0 || hf <= 0) {
                    return;
                }
                f fVar = new f();
                fVar.xj(xjVar2.w());
                fVar.hf(u2);
                fVar.xj(i);
                fVar.xj(xjVar2.zg());
                JSONObject xj2 = u.xj(u, eVar.hf(), eVar.w(), u.yo(), kd, SystemClock.elapsedRealtime() - eVar.xj());
                u.xj(xj2, u.kd("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.y.w.hf hfVar = new com.bytedance.sdk.openadsdk.y.w.hf(kd, wo.hf(kd), xj2, fVar);
                hfVar.xj(xjVar2.g());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, hf);
                    jSONObject.put("percent", xjVar2.d());
                    u.hf(hfVar, "feed_pause", jSONObject);
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        });
    }

    public static void xj(final com.bykv.vk.openvk.component.video.api.hf.xj xjVar, final e.xj xjVar2, final String str, final int i, final boolean z) {
        w.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.7
            @Override // java.lang.Runnable
            public void run() {
                e eVar;
                if (com.bykv.vk.openvk.component.video.api.hf.xj.this == null || xjVar2 == null || (eVar = (e) u.xj.get(com.bykv.vk.openvk.component.video.api.hf.xj.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.w.u u = eVar.u();
                ws kd = eVar.kd();
                if (u == null || kd == null) {
                    return;
                }
                long hf = xjVar2.hf();
                long u2 = xjVar2.u();
                if (u2 < 0) {
                    return;
                }
                qt qtVar = new qt();
                qtVar.w(xjVar2.w());
                qtVar.u(u2);
                qtVar.w(xjVar2.kd());
                qtVar.u(xjVar2.y());
                qtVar.hf(i);
                qtVar.hf(d.xj(kd.ul()).hf(u));
                qtVar.xj(str);
                JSONArray xj2 = xjVar2.xj();
                if (xj2 != null) {
                    qtVar.xj(xj2);
                }
                qtVar.xj(hf);
                qtVar.xj(xjVar2.d());
                qtVar.xj(z);
                JSONObject xj3 = u.xj(u, eVar.hf(), eVar.w(), u.yo(), kd, SystemClock.elapsedRealtime() - eVar.xj());
                u.xj(xj3, u.kd("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.y.w.hf hfVar = new com.bytedance.sdk.openadsdk.y.w.hf(kd, wo.hf(kd), xj3, qtVar);
                hfVar.xj(xjVar2.g());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, hf);
                    jSONObject.put("percent", xjVar2.d());
                    u.hf(hfVar, "play_error", jSONObject);
                } catch (JSONException e) {
                    pl.xj(e);
                }
                w.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.xj.remove(com.bykv.vk.openvk.component.video.api.hf.xj.this);
                    }
                }, 1000L);
            }
        });
    }

    public static void xj(final com.bykv.vk.openvk.component.video.api.hf.xj xjVar, final e.xj xjVar2, final Map<String, Object> map, final int i) {
        w.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.y.hf.u.9
            @Override // java.lang.Runnable
            public void run() {
                e eVar;
                if (com.bykv.vk.openvk.component.video.api.hf.xj.this == null || xjVar2 == null || (eVar = (e) u.xj.get(com.bykv.vk.openvk.component.video.api.hf.xj.this)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.w.u u = eVar.u();
                ws kd = eVar.kd();
                if (u == null || kd == null) {
                    return;
                }
                long hf = xjVar2.hf();
                long u2 = xjVar2.u();
                if (u2 <= 0) {
                    return;
                }
                kd kdVar = new kd();
                kdVar.hf(xjVar2.w());
                kdVar.xj(u2);
                kdVar.hf(xjVar2.tf());
                kdVar.w(xjVar2.p());
                kdVar.xj(i);
                JSONObject xj2 = u.xj(u, eVar.hf(), eVar.w(), u.yo(), kd, SystemClock.elapsedRealtime() - eVar.xj());
                u.xj(xj2, map);
                com.bytedance.sdk.openadsdk.y.w.hf hfVar = new com.bytedance.sdk.openadsdk.y.w.hf(kd, wo.hf(kd), xj2, kdVar);
                hfVar.xj(xjVar2.g());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, hf);
                    jSONObject.put("percent", xjVar2.d());
                    com.bytedance.sdk.openadsdk.core.x.am.xj(hf, kd, u);
                    u.hf(hfVar, u.hf(kd, "feed_break"), jSONObject);
                } catch (JSONException e) {
                    pl.xj(e);
                }
                u.xj.remove(com.bykv.vk.openvk.component.video.api.hf.xj.this);
            }
        });
    }

    public static void xj(JSONObject jSONObject, Object obj) {
        if (jSONObject == null) {
            return;
        }
        Map map = null;
        try {
            if (obj instanceof Map) {
                map = (Map) obj;
            }
        } catch (Exception unused) {
        }
        if (map != null) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
    }
}
