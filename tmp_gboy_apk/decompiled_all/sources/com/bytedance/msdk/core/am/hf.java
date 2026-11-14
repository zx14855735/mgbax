package com.bytedance.msdk.core.am;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.br;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.msdk.api.u.kd;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.dk;
import com.bytedance.msdk.f.ht;
import com.bytedance.msdk.f.io;
import com.bytedance.msdk.f.l;
import com.bytedance.msdk.f.qt;
import com.bytedance.msdk.xj.kd.f;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.msdk.y.u;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.n;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements f.xj {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile hf u;
    private static volatile boolean xj;
    private final f f;
    private final com.bytedance.msdk.core.am.xj hf;
    private final Context w;
    private final AtomicInteger kd = new AtomicInteger(0);
    private final AtomicBoolean y = new AtomicBoolean(false);
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private int tf = -1;

    /* renamed from: com.bytedance.msdk.core.am.hf$hf, reason: collision with other inner class name */
    public class RunnableC0055hf implements Runnable {
        private final kd hf;
        private int w;

        public RunnableC0055hf(kd kdVar, int i) {
            this.hf = kdVar;
            this.w = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!dk.xj(hf.this.w)) {
                try {
                    hf.this.hf.xj(false);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            hf.this.y.set(true);
            boolean ai = com.bytedance.msdk.core.hf.hf().ai();
            if (!hf.xj) {
                boolean unused2 = hf.xj = true;
                u.xj(ai);
            }
            if (com.bytedance.msdk.f.u.xj.xj()) {
                return;
            }
            hf.this.xj(ai, this.hf, this.w);
        }
    }

    public class w extends BroadcastReceiver {
        private w() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || com.bytedance.sdk.openadsdk.core.f.zg().z()) {
                return;
            }
            com.bytedance.msdk.xj.kd.w.xj("SdkSettingsHelper", "--==-- settings receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (TextUtils.equals(intent.getStringExtra("b_msg_process_name"), io.hf(hf.this.w))) {
                        com.bytedance.msdk.xj.kd.w.xj("SdkSettingsHelper", "--==-- settings receiver, same process, return");
                    } else if (hf.this.hf != null) {
                        com.bytedance.msdk.xj.kd.w.xj("SdkSettingsHelper", "--==-- settings receiver loadData");
                        hf.this.hf.xj(false);
                        com.bytedance.msdk.c.xj.w.xj().hf();
                        com.bytedance.msdk.xj.kd.w.xj("SdkSettingsHelper", "--==-- settings receiver loadData end");
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        }
    }

    public interface xj {
        public static final String xj = l.xj() + ".openadsdk.permission.TT_PANGOLIN";

        static {
            vpmIh();
        }

        private static /* synthetic */ void vpmIh() {
            char[] charArray = "\u0015\u0019\u001bX\u0011\u0017\u001b\u0013X\u0014\u0019\u000fX\u0005\u001e\u0013\u001a\u001aX<\u0018\u001f4\u0004\u001f\u0012\u0011\u0013".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'v');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0015\u001a\u001f\u0018\u001f\u0002".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'v');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private hf(com.bytedance.msdk.core.am.xj xjVar) {
        this.hf = xjVar == null ? com.bytedance.msdk.core.hf.hf() : xjVar;
        Context context = com.bytedance.msdk.core.hf.getContext();
        this.w = context;
        this.f = new f(Looper.getMainLooper(), this);
        if (com.bytedance.msdk.core.xj.p().g()) {
            try {
                context.registerReceiver(new w(), new IntentFilter("com.bytedance.msdk.core.setting.SettingsReceiver"), xj.xj, null);
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.y.hf.hf.xj();
        List<String> f = f();
        if (f != null) {
            for (String str : f) {
                com.bytedance.msdk.xj.xj.u xj2 = com.bytedance.msdk.y.hf.hf.xj().xj(str);
                if (xj2 != null) {
                    try {
                        jSONObject.put(str, xj2.hf());
                    } catch (JSONException e) {
                        pl.xj(e);
                    }
                }
            }
        }
        return jSONObject;
    }

    private static List<String> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MediationConstant.ADN_PANGLE);
        arrayList.add("gdt");
        arrayList.add(MediationConstant.ADN_ADMOB);
        arrayList.add(MediationConstant.ADN_UNITY);
        arrayList.add("baidu");
        arrayList.add("sigmob");
        arrayList.add(MediationConstant.ADN_MINTEGRAL);
        arrayList.add("ks");
        arrayList.add(MediationConstant.ADN_KLEVIN);
        arrayList.add(MediationConstant.ADN_XIAOMI);
        return arrayList;
    }

    private static void kd() {
        if (com.bytedance.sdk.openadsdk.core.f.zg().z() || com.bytedance.msdk.core.hf.getContext() == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setPackage(l.xj());
            intent.setAction("com.bytedance.msdk.core.setting.SettingsReceiver");
            intent.putExtra("b_msg_id", 1);
            intent.putExtra("b_msg_process_name", io.hf(com.bytedance.msdk.core.hf.getContext()));
            com.bytedance.msdk.core.hf.getContext().sendBroadcast(intent, xj.xj);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private boolean y() {
        long hf = com.bytedance.msdk.c.xj.xj().hf("max_expire_time", 0L);
        if (this.c.get() && System.currentTimeMillis() > hf) {
            com.bytedance.msdk.xj.kd.w.hf("SdkSettingsHelper", "setting 缓存过期，再次发起请求...");
            this.c.set(false);
            xj();
        }
        return System.currentTimeMillis() > hf;
    }

    public void hf(int i) {
        if (this.d.get()) {
            com.bytedance.msdk.xj.kd.w.u("SdkSettingsHelper", "setting 正在尝试拉取配置中...");
            return;
        }
        com.bytedance.msdk.xj.kd.w.u("SdkSettingsHelper", "setting 尝试拉取配置...");
        xj();
        w(i);
    }

    public void w(int i) {
        dk.xj();
        try {
            if (!y()) {
                com.bytedance.msdk.xj.kd.w.hf("SdkSettingsHelper", "setting 缓存未过期，无需再次发起请求...");
            } else if (this.y.get()) {
                com.bytedance.msdk.xj.kd.w.hf("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                y.u(new RunnableC0055hf(null, i));
            }
        } catch (Throwable th) {
            com.bytedance.msdk.xj.kd.w.xj("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public static hf xj(com.bytedance.msdk.core.am.xj xjVar) {
        if (u == null) {
            synchronized (hf.class) {
                try {
                    if (u == null) {
                        u = new hf(xjVar);
                    }
                } finally {
                }
            }
        }
        return u;
    }

    private JSONObject hf(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ts", System.currentTimeMillis());
            jSONObject2.put("media_sdk_version", com.bytedance.msdk.hf.hf.hf());
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.hf.hf.u());
            jSONObject2.put("is_fusion", 1);
            jSONObject2.put(PluginConstants.KEY_APP_ID, com.bytedance.msdk.core.xj.p().pl());
            jSONObject2.put(n.p, l.xj());
            jSONObject2.put(n.r, l.w());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("android_id", dk.u());
            jSONObject3.put("imei", dk.pz());
            jSONObject3.put("imei_md5", ht.xj(dk.pz()));
            jSONObject3.put("oaid", dk.hf());
            jSONObject3.put("gaid", com.bytedance.msdk.f.f.xj().hf());
            jSONObject3.put("applog_did", dk.xj());
            jSONObject3.put("publisher_did", com.bytedance.msdk.core.xj.p().e());
            jSONObject3.put("conn_type", dk.kd());
            jSONObject3.put("os", dk.g());
            jSONObject3.put("os_version", dk.am());
            jSONObject3.put("vendor", dk.e());
            jSONObject3.put("device_model", dk.c());
            jSONObject3.put("mcc", dk.p());
            jSONObject3.put("mnc", dk.pl());
            jSONObject3.put("time_zone", dk.yo());
            jSONObject3.put("ip", dk.ht());
            jSONObject3.put("locale_language", dk.tf());
            jSONObject3.put("total_space", dk.zg());
            jSONObject3.put("carrier_name", dk.jk());
            jSONObject3.put("device_name", dk.f());
            jSONObject3.put("pb", "");
            jSONObject3.put("boot", dk.v());
            jSONObject3.put("country_code", com.bytedance.msdk.core.hf.hf().f());
            jSONObject3.put("total_mem", dk.qt());
            jSONObject3.put("device_type", dk.c());
            jSONObject3.put(MediaFormat.KEY_LANGUAGE, dk.d());
            jSONObject3.put("android_os_version_int", Build.VERSION.SDK_INT);
            jSONObject2.put("device", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("init_time", com.bytedance.msdk.core.xj.p().w());
            jSONObject2.put(PointCategory.APP, jSONObject4);
            jSONObject2.put("grouping_params", hf());
            JSONObject w2 = w();
            if (w2 != null) {
                jSONObject2.put("user_defined_grouping_params", w2);
            }
            if (!com.bytedance.msdk.core.xj.p().c()) {
                jSONObject2.put(com.sigmob.sdk.downloader.core.breakpoint.f.c, com.bytedance.msdk.core.hf.hf().tf());
            }
            if (com.bytedance.msdk.f.y.xj(this.w) != null) {
                jSONObject2.put("latitude", r1.xj);
                jSONObject2.put("longitude", r1.hf);
            }
            jSONObject2.put("adn_version_list", c());
            com.bytedance.msdk.core.d.kd.u().xj(jSONObject2, jSONObject);
            com.bytedance.msdk.core.d.kd.u().xj(jSONObject2);
            List<String> x = com.bytedance.msdk.core.xj.p().x();
            if (x != null && x.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = x.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("primerit_list", jSONArray);
            }
            if (!qt.xj()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("err_type", 1);
                jSONObject5.put("err_msg", "applog so加载失败");
                jSONObject2.put("monitor_alarm", jSONObject5);
                return jSONObject2;
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        return jSONObject2;
    }

    public static JSONObject w() {
        Map<String, String> xj2;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.api.u.y ht = com.bytedance.msdk.core.xj.p().ht();
        if (ht != null && (xj2 = ht.xj()) != null) {
            try {
                for (String str : xj2.keySet()) {
                    jSONObject.put(str, xj2.get(str));
                }
                return jSONObject;
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        return null;
    }

    public hf xj() {
        com.bytedance.msdk.xj.kd.w.u("SdkSettingsHelper", "setting resetRetryCount...");
        this.kd.set(0);
        this.d.set(false);
        f fVar = this.f;
        if (fVar != null) {
            fVar.removeCallbacksAndMessages(null);
        }
        return this;
    }

    private String w(JSONObject jSONObject) {
        JSONObject xj2 = l.xj(jSONObject);
        if (xj2 != null) {
            return xj2.toString();
        }
        return null;
    }

    public void xj(int i) {
        try {
            if (this.y.get()) {
                this.tf = i;
                com.bytedance.msdk.xj.kd.w.hf("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                y.u(new RunnableC0055hf(null, i));
            }
        } catch (Throwable th) {
            com.bytedance.msdk.xj.kd.w.xj("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    private void xj(kd kdVar, com.bytedance.msdk.api.xj xjVar, int i) {
        long j;
        com.bytedance.msdk.c.xj.xj().y("server_dist_host");
        xj(kdVar, xjVar);
        com.bytedance.msdk.y.w.kd();
        com.bytedance.msdk.xj.kd.w.u("SdkSettingsHelper", "setting 配置拉取失败，尝试再次拉取... mLoadingSuccess:" + this.c.get() + " mRetryCount:" + (this.kd.get() + 1));
        this.y.set(false);
        if (this.c.get()) {
            this.d.set(false);
            this.f.removeCallbacksAndMessages(null);
            return;
        }
        if (this.kd.get() > 3) {
            com.bytedance.msdk.xj.kd.w.u("SdkSettingsHelper", "setting 最多尝试四次拉取... ");
            return;
        }
        this.d.set(true);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = this.kd.get();
        obtain.arg2 = i;
        int i2 = this.kd.get();
        if (i2 < 3) {
            long j2 = 1;
            for (int i3 = 0; i3 <= i2; i3++) {
                j2 *= 3;
            }
            j = j2 * 1000;
        } else {
            j = 120000;
        }
        this.kd.incrementAndGet();
        this.f.removeCallbacksAndMessages(null);
        this.f.sendMessageDelayed(obtain, j);
        com.bytedance.msdk.xj.kd.w.hf("SdkSettingsHelper", "setting 重试次数:" + (i2 + 1) + "  重试间隔：" + j);
    }

    private Map<String, String> xj(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str.toLowerCase(), map.get(str));
            }
        }
        return hashMap;
    }

    private void xj(final kd kdVar, final com.bytedance.msdk.api.xj xjVar) {
        y.w(new Runnable() { // from class: com.bytedance.msdk.core.am.hf.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public void xj(final kd kdVar) {
        int i = this.tf;
        if (i == 2 || i == 3) {
            this.tf = -1;
            xj(i);
        }
        if (kdVar != null) {
            final List<String> x = com.bytedance.msdk.core.xj.p().x();
            y.w(new Runnable() { // from class: com.bytedance.msdk.core.am.hf.2
                @Override // java.lang.Runnable
                public void run() {
                    kdVar.xj(com.bytedance.msdk.core.hf.hf().xj(x));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final boolean z, final kd kdVar, final int i) {
        final int[] iArr = {0};
        final int[] iArr2 = new int[1];
        final long currentTimeMillis = System.currentTimeMillis();
        Map<String, JSONObject> hf = com.bytedance.msdk.core.d.kd.u().hf(i);
        final JSONObject jSONObject = hf.get("event_label_value_root");
        JSONObject jSONObject2 = hf.get("config_req_label_value_root");
        com.bytedance.sdk.component.d.hf.kd hf2 = com.bytedance.msdk.u.hf.xj().hf().hf();
        hf2.xj(com.bytedance.msdk.core.w.xj());
        String f = com.bytedance.msdk.core.xj.p().f();
        if (!TextUtils.isEmpty(f)) {
            hf2.hf("X-Tt-Env", f);
            hf2.hf("x-use-ppe", "1");
        }
        hf2.hf("User-Agent", com.bytedance.msdk.hf.hf.xj);
        try {
            JSONObject hf3 = hf(jSONObject2);
            boolean u2 = com.bytedance.msdk.core.hf.hf().u();
            final boolean z2 = !u2;
            if (!u2) {
                hf2.hf("x-pglcypher", "4");
                hf2.xj("application/octet-stream", l.hf(hf3.toString()));
            } else {
                hf2.w(w(hf3));
            }
            hf2.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.msdk.core.am.hf.3
                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, final com.bytedance.sdk.component.d.hf hfVar) {
                    y.xj(new Runnable() { // from class: com.bytedance.msdk.core.am.hf.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str;
                            JSONObject jSONObject3;
                            String str2;
                            JSONObject jSONObject4;
                            JSONObject jSONObject5 = new JSONObject();
                            int[] iArr3 = {-1};
                            com.bytedance.sdk.component.d.hf hfVar2 = hfVar;
                            if (hfVar2 != null) {
                                iArr2[0] = hfVar2.xj();
                                if (l.xj(hfVar)) {
                                    long elapsedRealtime = SystemClock.elapsedRealtime();
                                    String xj2 = l.xj(hfVar.tf());
                                    try {
                                        jSONObject5.put("decrypt_time", SystemClock.elapsedRealtime() - elapsedRealtime);
                                    } catch (JSONException unused) {
                                    }
                                    if (TextUtils.isEmpty(xj2)) {
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        iArr2[0] = 81015;
                                        hf.this.xj(kdVar, i, 81015, "response body is null", z2);
                                    } else {
                                        try {
                                            JSONObject jSONObject6 = new JSONObject(xj2);
                                            AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                            hf.this.xj(iArr2, iArr, hfVar, jSONObject6, xj2, iArr3, kdVar, jSONObject5, i, z2, currentTimeMillis);
                                        } catch (Throwable th) {
                                            AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                                            iArr2[0] = 81014;
                                            hf.this.xj(kdVar, i, 81014, th.getMessage(), z2);
                                        }
                                    }
                                } else if (hfVar.u() != null) {
                                    try {
                                        JSONObject jSONObject7 = new JSONObject(hfVar.u());
                                        int optInt = jSONObject7.optInt("cypher", -1);
                                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                        if (optInt == 2) {
                                            str = l.xj(jSONObject7.optString("message"));
                                            if (!TextUtils.isEmpty(str)) {
                                                try {
                                                    jSONObject3 = new JSONObject(str);
                                                    str2 = str;
                                                    jSONObject4 = jSONObject3;
                                                } catch (Throwable th2) {
                                                    com.bytedance.msdk.xj.kd.w.xj("SdkSettingsHelper", ">>>>> setting data error: " + th2.toString());
                                                }
                                            }
                                            str2 = str;
                                            jSONObject4 = jSONObject7;
                                        } else {
                                            if (optInt == 1) {
                                                str = com.bytedance.msdk.f.xj.hf(jSONObject7.optString("message"), com.bytedance.msdk.f.hf.xj());
                                                if (!TextUtils.isEmpty(str)) {
                                                    try {
                                                        com.bytedance.msdk.xj.kd.w.xj("SdkSettingsHelper", "setting data : " + str.toString());
                                                        jSONObject3 = new JSONObject(str);
                                                        str2 = str;
                                                        jSONObject4 = jSONObject3;
                                                    } catch (Throwable th3) {
                                                        com.bytedance.msdk.xj.kd.w.xj("SdkSettingsHelper", "setting data error: ", th3);
                                                    }
                                                }
                                            } else if (optInt == 0) {
                                                str = jSONObject7.optString("message");
                                                jSONObject7 = new JSONObject(str);
                                            } else {
                                                str = null;
                                            }
                                            str2 = str;
                                            jSONObject4 = jSONObject7;
                                        }
                                        jSONObject5.put("decrypt_time", SystemClock.elapsedRealtime() - elapsedRealtime2);
                                        AnonymousClass3 anonymousClass34 = AnonymousClass3.this;
                                        hf.this.xj(iArr2, iArr, hfVar, jSONObject4, str2, iArr3, kdVar, jSONObject5, i, z2, currentTimeMillis);
                                    } catch (Throwable th4) {
                                        AnonymousClass3 anonymousClass35 = AnonymousClass3.this;
                                        iArr2[0] = 81006;
                                        hf.this.xj(kdVar, i, 81006, th4.getMessage(), z2);
                                    }
                                } else {
                                    AnonymousClass3 anonymousClass36 = AnonymousClass3.this;
                                    iArr2[0] = 81013;
                                    hf.this.xj(kdVar, i, 81013, "response body is null", z2);
                                }
                            } else {
                                AnonymousClass3 anonymousClass37 = AnonymousClass3.this;
                                iArr2[0] = 81007;
                                hf.this.xj(kdVar, i, 81007, "response is null", z2);
                            }
                            AnonymousClass3 anonymousClass38 = AnonymousClass3.this;
                            int i2 = iArr[0];
                            int i3 = iArr2[0];
                            long currentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass3 anonymousClass39 = AnonymousClass3.this;
                            u.xj(i2, i3, currentTimeMillis2 - currentTimeMillis, z, i == 0, jSONObject, iArr3[0], jSONObject5);
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, final IOException iOException) {
                    y.xj(new Runnable() { // from class: com.bytedance.msdk.core.am.hf.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.msdk.xj.kd.w.u("SdkSettingsHelper", "----网络错误，服务器无响应，稍后会尝试重新拉取配置----，setting request failed..." + iOException.getMessage());
                            hf.this.y.set(false);
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            iArr[0] = 0;
                            iArr2[0] = -2;
                            hf.this.xj(kdVar, i, -2, "request fail：" + iOException.getMessage(), z2);
                            AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                            int i2 = iArr[0];
                            int i3 = iArr2[0];
                            long currentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                            u.xj(i2, i3, currentTimeMillis2 - currentTimeMillis, z, i == 0, jSONObject, -1L, null);
                        }
                    });
                }
            });
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
            com.bytedance.msdk.core.p.xj.xj().xj(81017, "GM接口请求异常");
        }
    }

    public static JSONObject hf() {
        String hf;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.api.u.y ht = com.bytedance.msdk.core.xj.p().ht();
        if (ht != null) {
            try {
                hf = ht.hf();
            } catch (JSONException e) {
                pl.xj(e);
                return jSONObject;
            }
        } else {
            hf = "";
        }
        jSONObject.put("user_id", hf);
        jSONObject.put("channel", ht != null ? ht.w() : "");
        jSONObject.put("sub_channel", ht != null ? ht.u() : "");
        jSONObject.put("age", ht != null ? ht.kd() : 0);
        jSONObject.put("gender", ht != null ? ht.y() : "");
        jSONObject.put("user_value_group", ht != null ? ht.c() : "");
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int[] iArr, int[] iArr2, com.bytedance.sdk.component.d.hf hfVar, JSONObject jSONObject, String str, int[] iArr3, kd kdVar, JSONObject jSONObject2, int i, boolean z, long j) {
        String str2;
        String str3;
        String str4;
        long currentTimeMillis = System.currentTimeMillis() - j;
        Map<String, String> xj2 = xj(hfVar.w());
        if (xj2 != null) {
            str3 = xj2.get("active-control");
            str4 = xj2.get("ts");
            str2 = xj2.get(t.s);
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        String xj3 = ht.xj(str + str3 + str4);
        if (!TextUtils.isEmpty(xj3) && xj3.equalsIgnoreCase(str2)) {
            com.bytedance.msdk.core.hf.hf().u(str3);
        }
        xj(jSONObject);
        int optInt = jSONObject.optInt("state_code", -80000);
        String optString = jSONObject.optString("message");
        if (optInt == 20000) {
            iArr[0] = 20000;
        }
        if (optInt == 30004) {
            iArr[0] = 30004;
            this.y.set(false);
            this.d.set(false);
            this.f.removeCallbacksAndMessages(null);
            this.hf.xj(jSONObject);
            xj(kdVar);
            com.bytedance.msdk.y.w.u();
            xj(z, currentTimeMillis);
            return;
        }
        if (optInt == 20000 && !TextUtils.isEmpty(jSONObject.toString())) {
            iArr2[0] = 1;
            iArr[0] = 20000;
            String u2 = hfVar.u();
            if (u2 != null) {
                iArr3[0] = u2.length();
            }
            this.d.set(false);
            this.f.removeCallbacksAndMessages(null);
            this.c.set(true);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.hf.xj(jSONObject, false);
            jSONObject2.put("parse_save_time", SystemClock.elapsedRealtime() - elapsedRealtime);
            this.y.set(false);
            xj(kdVar);
            com.bytedance.msdk.y.w.u();
            if (com.bytedance.msdk.core.xj.p().g()) {
                kd();
            }
            xj(z, currentTimeMillis);
            return;
        }
        if (optInt != -80000) {
            iArr[0] = optInt;
        }
        if (TextUtils.isEmpty(optString) && !TextUtils.isEmpty(jSONObject.optString(br.c))) {
            optString = jSONObject.optString(br.c);
        }
        xj(kdVar, i, iArr[0], optString, z);
    }

    private void xj(boolean z, long j) {
        ai.xj(z ? "v4Enc_config" : "v2Enc_config", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(kd kdVar, int i, int i2, String str, boolean z) {
        if (z) {
            try {
                com.bytedance.msdk.core.hf.hf().hf(true);
            } catch (Throwable th) {
                pl.xj(th);
                return;
            }
        }
        ai.xj(z ? "v4Enc_config" : "v2Enc_config", false, 0L, "code = " + i2 + "，msg = " + str);
        com.bytedance.msdk.xj.kd.w.u("SdkSettingsHelper", "----拉取配置失败: " + i2 + " msg = " + str);
        xj(kdVar, new com.bytedance.msdk.api.xj(i2, str), i);
        if (com.bytedance.msdk.core.hf.hf().ai()) {
            return;
        }
        com.bytedance.msdk.core.p.xj.xj().xj(i2, "聚合config请求失败 code = " + i2 + " msg = " + str);
    }

    public static String xj(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            try {
                th.printStackTrace(printWriter);
                String stringWriter2 = stringWriter.toString();
                try {
                    stringWriter.close();
                } catch (IOException unused) {
                }
                printWriter.close();
                return stringWriter2;
            } catch (IOException unused2) {
                printWriter.close();
                return null;
            }
        } catch (Exception unused3) {
            stringWriter.close();
            printWriter.close();
            return null;
        } catch (Throwable th2) {
            try {
                stringWriter.close();
            } catch (IOException unused4) {
            }
            printWriter.close();
            throw th2;
        }
    }

    private void xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optBoolean("remote_log_enabled")) {
                com.bytedance.msdk.xj.kd.w.xj();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.msdk.xj.kd.f.xj
    public void xj(Message message) {
        if (message.what != 1) {
            return;
        }
        int i = message.arg1;
        int i2 = message.arg2;
        if (i == 3) {
            this.d.set(false);
        }
        com.bytedance.msdk.xj.kd.w.u("SdkSettingsHelper", "setting 发起尝试拉取配置请求... mLoadingSuccess:" + this.c.get() + "tryCount:" + (i + 1));
        try {
            if (this.c.get()) {
                return;
            }
            w(i2);
        } catch (Throwable unused) {
        }
    }
}
