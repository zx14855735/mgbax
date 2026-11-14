package com.octopus.ad.internal;

import KpHwm4.ADYaiT;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.Octopus;
import com.octopus.ad.TransparentActivity;
import com.octopus.ad.internal.a.h;
import com.octopus.ad.internal.activity.BrowserAdActivity;
import com.octopus.ad.internal.k;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.utilities.SPUtils;
import com.octopus.ad.model.c;
import com.octopus.ad.utils.OctUtil;
import com.octopus.ad.utils.ThreadUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class q {
    private static boolean O = false;
    public static String k = null;
    public static String l = "";
    public static String m = "";
    public static int q = 1000;
    public static int r = 1000;
    public static long s = 7200000;
    private static q t;
    private static boolean w;
    private float F;
    private DisplayMetrics H;
    private com.octopus.ad.internal.a.h M;
    private long N;

    /* renamed from: a, reason: collision with root package name */
    public int f12512a;
    public String e;
    public String f;
    public String i;
    public Context n;
    public float o;
    public float p;
    private String u;
    private String v;
    private Boolean y;
    private int x = 0;
    public boolean b = true;
    public boolean c = false;
    public boolean d = false;
    public ConcurrentHashMap<String, com.octopus.ad.model.a> g = new ConcurrentHashMap<>();
    public boolean h = false;
    public HashMap<String, String> j = new HashMap<>();
    private HashSet<String> z = new HashSet<>();
    private HashSet<String> A = new HashSet<>();
    private HashSet<String> B = new HashSet<>();
    private HashSet<String> C = new HashSet<>();
    private HashSet<String> D = new HashSet<>();
    private HashSet<String> E = new HashSet<>();
    private boolean G = true;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;

    public static /* synthetic */ int b(q qVar) {
        int i = qVar.x;
        qVar.x = i - 1;
        return i;
    }

    private com.octopus.ad.internal.a.h t() {
        Context context = this.n;
        if (context == null) {
            return null;
        }
        try {
            return new h.a(context).a(536870912L).a();
        } catch (Exception unused) {
            return null;
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private void u() {
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Throwable unused) {
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, boolean z) {
    }

    public boolean d() {
        return this.L;
    }

    public float e() {
        return this.F;
    }

    public boolean f() {
        return this.G;
    }

    public String g() {
        return this.u;
    }

    public String h() {
        return this.v;
    }

    public String i() {
        return k;
    }

    public Context j() {
        return this.n;
    }

    public synchronized String k() {
        if (TextUtils.isEmpty(this.i)) {
            try {
                this.i = WebSettings.getDefaultUserAgent(this.n);
            } catch (Exception e) {
                com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
            }
            if (TextUtils.isEmpty(this.i)) {
                this.i = "Mozilla/5.0 (Linux; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + " Build/UP1A.231005.007; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/116.0.0.0 Mobile Safari/537.36";
            }
        }
        return this.i;
    }

    public String l() {
        if (!TextUtils.isEmpty(this.e)) {
            return this.e;
        }
        String replace = this.c ? "http://sdk.zhangyuyidong.cn".replace("http:", "https:") : "http://sdk.zhangyuyidong.cn";
        return this.d ? replace.replace("sdk.", "sdk6.") : replace;
    }

    public String m() {
        if (!TextUtils.isEmpty(this.f)) {
            return this.f;
        }
        String replace = this.c ? "http://sdklog.zhangyuyidong.cn".replace("http:", "https:") : "http://sdklog.zhangyuyidong.cn";
        return this.d ? replace.replace("sdklog.", "sdklog6.") : replace;
    }

    public float n() {
        return this.o;
    }

    public float o() {
        return this.p;
    }

    public float p() {
        return Math.max(this.o, this.p);
    }

    public DisplayMetrics q() {
        return this.H;
    }

    public HashSet<String> r() {
        return this.E;
    }

    public boolean s() {
        return O;
    }

    public static /* synthetic */ int a(q qVar) {
        int i = qVar.x;
        qVar.x = i + 1;
        return i;
    }

    public void c() {
        if (this.J) {
            return;
        }
        this.J = true;
        try {
            OctUtil.a().init(this.n);
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        } catch (Throwable th) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    public com.octopus.ad.internal.a.h b() {
        if (this.n == null) {
            return null;
        }
        com.octopus.ad.internal.a.h hVar = this.M;
        if (hVar != null) {
            return hVar;
        }
        com.octopus.ad.internal.a.h t2 = t();
        this.M = t2;
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.octopus.ad.model.a aVar) {
        if (aVar != null) {
            o.a(new l("DPFORBID", aVar.l(), aVar.a(), System.currentTimeMillis() - aVar.h(), aVar.k()));
        }
    }

    public static q a() {
        q qVar;
        synchronized (q.class) {
            try {
                if (t == null) {
                    t = new q();
                }
                qVar = t;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("track=oct")) {
                str = str + "&opt=13&result=0&wait=" + (com.octopus.ad.utils.b.i.c() - this.N);
            }
            new i(str).execute();
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void b(String str) {
        this.v = str;
    }

    public String b(boolean z) {
        String str;
        Boolean bool = this.y;
        if (bool == null || bool.booleanValue()) {
            if (z) {
                str = "/api/zysdksd?isEncrypt=2";
            } else {
                str = "/api/zysdk?isEncrypt=2";
            }
        } else if (z) {
            str = "/api/zysdksd?isEncrypt=0";
        } else {
            str = "/api/zysdk?isEncrypt=0";
        }
        return l() + str;
    }

    public void a(Context context, String str) {
        synchronized (q.class) {
            try {
                if (context != null) {
                    try {
                        this.n = context.getApplicationContext();
                        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.octopus.ad.internal.q.1
                            @Override // java.lang.Runnable
                            public void run() {
                                q.this.k();
                            }
                        });
                        HaoboLog.setErrorContext(this.n);
                        k = str;
                        DisplayMetrics displayMetrics = this.n.getResources().getDisplayMetrics();
                        this.H = displayMetrics;
                        int i = displayMetrics.widthPixels;
                        int i2 = displayMetrics.heightPixels;
                        if (i < i2) {
                            this.o = i / 720.0f;
                            this.p = i2 / 1280.0f;
                        } else {
                            this.o = i2 / 720.0f;
                            this.p = i / 1280.0f;
                        }
                        this.L = com.octopus.ad.utils.b.i.b("com.octopus.ad.utils.OctUtil$C");
                        this.b = SPUtils.getBoolean(this.n, "getBootId");
                        this.d = SPUtils.getBoolean(this.n, "ipv6");
                        this.c = SPUtils.getBoolean(this.n, "ssl");
                        this.e = SPUtils.getString(this.n, bn.g);
                        this.f = SPUtils.getString(this.n, "sdklog");
                        this.y = (Boolean) SPUtils.getFromGroupSdk(this.n, "encrypt", Boolean.TRUE);
                        if (ADYaiT.f4280ADYaiT == null) {
                            ADYaiT.f4280ADYaiT = new ADYaiT();
                        }
                        ADYaiT aDYaiT = ADYaiT.f4280ADYaiT;
                        Context context2 = this.n;
                        aDYaiT.getClass();
                        aDYaiT.f4283A5SV6n = context2.getApplicationContext();
                        aDYaiT.f4282A4TApA = Thread.getDefaultUncaughtExceptionHandler();
                        Thread.setDefaultUncaughtExceptionHandler(aDYaiT);
                        if (ADYaiT.f4280ADYaiT == null) {
                            ADYaiT.f4280ADYaiT = new ADYaiT();
                        }
                        ADYaiT.f4280ADYaiT.A4TApA();
                        ThreadUtils.runOnThreadPool(new com.octopus.ad.utils.b.b(this.n));
                        Long l2 = (Long) SPUtils.get(this.n, MediationConstant.EXTRA_DURATION, 86400L);
                        String str2 = (String) SPUtils.get(this.n, "version", "1686041703212");
                        Long l3 = (Long) SPUtils.get(this.n, "lastReqTime", 0L);
                        if (l2 != null && str2 != null && l3 != null && com.octopus.ad.utils.b.i.c() - l3.longValue() > l2.longValue()) {
                            new m(l() + "/sdk/config?version=" + str2 + "&appId=" + str + "&os=android").execute();
                        }
                        ((Application) this.n).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.octopus.ad.internal.q.2
                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityCreated(Activity activity, Bundle bundle) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityDestroyed(Activity activity) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityPaused(Activity activity) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityResumed(Activity activity) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityStarted(Activity activity) {
                                q.a(q.this);
                                if ((activity instanceof BrowserAdActivity) || (activity instanceof TransparentActivity)) {
                                    return;
                                }
                                k.a().a("AppSelfForeground");
                            }

                            @Override // android.app.Application.ActivityLifecycleCallbacks
                            public void onActivityStopped(Activity activity) {
                                q.b(q.this);
                                if (q.this.x < 0) {
                                    q.this.x = 0;
                                }
                                if (q.this.x == 0) {
                                    k.a().a("AppBackground");
                                }
                            }
                        });
                        if (Octopus.getCustomController() == null || Octopus.getCustomController().isCanUseOaid()) {
                            com.octopus.ad.utils.a.b.a((Application) this.n);
                        }
                        if (!this.I) {
                            com.octopus.ad.utils.g.a(this.n).a(new com.octopus.ad.utils.f() { // from class: com.octopus.ad.internal.q.3
                                @Override // com.octopus.ad.utils.f
                                public void a(long j, long j2) {
                                    com.octopus.ad.utils.b.f.a("OctopusAd", "在线时长:" + (j2 - j));
                                    SPUtils.put(q.this.n, "startTime", Long.valueOf(j));
                                    SPUtils.put(q.this.n, "endTime", Long.valueOf(j2));
                                }

                                @Override // com.octopus.ad.utils.f
                                public void a() {
                                    com.octopus.ad.utils.b.f.a("OctopusAd", "上报活跃量");
                                }
                            });
                        }
                        this.I = true;
                        if (Build.VERSION.SDK_INT >= 28) {
                            u();
                        }
                        o.a(new l("INIT", str, 1));
                    } catch (Exception e) {
                        o.a(new l("INIT", str, 0));
                        com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
                    }
                } else {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(boolean z) {
        O = z;
    }

    public void b(int i) {
        q = i;
        r = i;
    }

    public void a(final int i) {
        if (this.K || !this.L) {
            return;
        }
        this.K = true;
        ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.internal.q.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OctUtil.a().call(new OctUtil.C() { // from class: com.octopus.ad.internal.q.4.1
                        @Override // com.octopus.ad.utils.OctUtil.C
                        public String e(String str) {
                            Map.Entry<String, com.octopus.ad.model.a> next;
                            com.octopus.ad.model.a value;
                            try {
                                com.octopus.ad.utils.b.f.a("OctopusAd", "scheme:" + str);
                                ConcurrentHashMap<String, com.octopus.ad.model.a> concurrentHashMap = q.a().g;
                                if (concurrentHashMap.isEmpty() || TextUtils.isEmpty(str)) {
                                    return null;
                                }
                                Iterator<Map.Entry<String, com.octopus.ad.model.a>> it = concurrentHashMap.entrySet().iterator();
                                while (it.hasNext() && (value = (next = it.next()).getValue()) != null) {
                                    if (!TextUtils.isEmpty(value.k())) {
                                        for (String str2 : value.k().split(",")) {
                                            if (str.equals(str2)) {
                                                q.this.b(value);
                                                return "";
                                            }
                                        }
                                    } else if (str.equals(next.getKey()) || "octdpopen".equals(next.getKey())) {
                                        String c = value.c();
                                        if (!TextUtils.isEmpty(c)) {
                                            q.this.a(value);
                                            concurrentHashMap.remove(next.getKey());
                                            if (!value.e() || TextUtils.isEmpty(value.d())) {
                                                return c;
                                            }
                                            return c + ";;;" + value.d();
                                        }
                                    }
                                }
                                return null;
                            } catch (Exception e) {
                                com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
                                return null;
                            }
                        }
                    }, i);
                } catch (Throwable th) {
                    com.octopus.ad.utils.b.f.a("OctopusAd", "A Throwable Caught", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.octopus.ad.model.a aVar) {
        final List<c.i> i;
        if (aVar == null || (i = aVar.i()) == null) {
            return;
        }
        for (int i2 = 0; i2 < i.size(); i2++) {
            c.i iVar = i.get(i2);
            if (iVar != null && !TextUtils.isEmpty(iVar.a())) {
                String a2 = iVar.a();
                if (a2.contains("track=oct")) {
                    a2 = a2.concat("&opt=13");
                }
                new i(a2).execute();
            }
        }
        com.octopus.ad.utils.e.a(new Runnable() { // from class: com.octopus.ad.internal.q.5
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < i.size(); i3++) {
                    try {
                        c.i iVar2 = (c.i) i.get(i3);
                        if (iVar2 != null && !TextUtils.isEmpty(iVar2.b())) {
                            String b = iVar2.b();
                            if (b.contains("track=oct")) {
                                b = b + "&opt=13";
                            }
                            new i(b).execute();
                        }
                        if (iVar2 != null && !TextUtils.isEmpty(iVar2.c())) {
                            final String c = iVar2.c();
                            q.this.N = com.octopus.ad.utils.b.i.c();
                            k.a().a(new k.a() { // from class: com.octopus.ad.internal.q.5.1
                                @Override // com.octopus.ad.internal.k.a
                                public void a(String str) {
                                    if ("AppBackground".equals(str)) {
                                        q.this.c(c);
                                        k.a().b(this);
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        com.octopus.ad.utils.b.f.a("OctopusAd", "A Throwable Caught", th);
                        return;
                    }
                }
            }
        }, aVar.g());
    }

    public void a(float f) {
        w.a(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        w.a(k, (Object) "Octopus.initialize() must be called prior to setting the app volume.");
        this.F = f;
    }

    public void a(boolean z) {
        w.a(k, (Object) "Octopus.initialize() must be called prior to setting the app volume.");
        this.G = z;
    }

    public void a(String str) {
        this.u = str;
    }
}
