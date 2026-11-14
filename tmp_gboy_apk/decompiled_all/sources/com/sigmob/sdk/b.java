package com.sigmob.sdk;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.location.Location;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.AdLifecycleManager;
import com.czhj.sdk.common.utils.RomUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.BaseAdActivity;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.v;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntityActive;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.network.g;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.utils.k;
import com.sigmob.sdk.base.utils.q;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<Activity> f13031a;
    private static Context b;
    private static a c;
    private static WeakReference<Activity> d;
    private static boolean e;
    private static DeviceContext f;
    private static Handler g;
    private static C0447b h;

    public static class a implements AdLifecycleManager.LifecycleListener {

        /* renamed from: a, reason: collision with root package name */
        private String f13032a;
        private long b;
        private String d;
        private int e;
        private boolean i;
        private final BroadcastReceiver k;
        private final Map<String, String> c = new HashMap();
        private boolean f = true;
        private boolean g = false;
        private boolean h = false;
        private int j = 0;

        public a() {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.sigmob.sdk.b.a.1
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
                
                    if (r7.equals(com.sigmob.sdk.base.n.M) == false) goto L7;
                 */
                @Override // android.content.BroadcastReceiver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onReceive(android.content.Context r6, android.content.Intent r7) {
                    /*
                        r5 = this;
                        r6 = 1
                        r0 = 0
                        r1 = 2
                        java.lang.String r7 = r7.getAction()
                        boolean r2 = com.sigmob.sdk.base.utils.o.a(r7)
                        if (r2 == 0) goto Le
                        goto L45
                    Le:
                        byte[] r7 = r7.getBytes()
                        java.lang.String r7 = android.util.Base64.encodeToString(r7, r1)
                        r7.getClass()
                        r2 = 0
                        r3 = -1
                        int r4 = r7.hashCode()
                        switch(r4) {
                            case -252353173: goto L38;
                            case 1349729289: goto L2d;
                            case 1349784159: goto L24;
                            default: goto L22;
                        }
                    L22:
                        r1 = -1
                        goto L42
                    L24:
                        java.lang.String r4 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlNDUkVFTl9PTg=="
                        boolean r7 = r7.equals(r4)
                        if (r7 != 0) goto L42
                        goto L22
                    L2d:
                        java.lang.String r1 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlNDUkVFTl9PRkY="
                        boolean r7 = r7.equals(r1)
                        if (r7 != 0) goto L36
                        goto L22
                    L36:
                        r1 = 1
                        goto L42
                    L38:
                        java.lang.String r1 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlVTRVJfUFJFU0VOVA=="
                        boolean r7 = r7.equals(r1)
                        if (r7 != 0) goto L41
                        goto L22
                    L41:
                        r1 = 0
                    L42:
                        switch(r1) {
                            case 0: goto L60;
                            case 1: goto L51;
                            case 2: goto L46;
                            default: goto L45;
                        }
                    L45:
                        return
                    L46:
                        java.lang.String r6 = "screen on"
                        com.czhj.sdk.logger.SigmobLog.d(r6)
                        java.lang.String r6 = "screen_on"
                    L4d:
                        com.sigmob.sdk.base.common.ae.b(r6, r2, r2)
                        return
                    L51:
                        java.lang.String r7 = "screen off"
                        com.czhj.sdk.logger.SigmobLog.d(r7)
                        com.sigmob.sdk.manager.d r7 = com.sigmob.sdk.manager.d.a()
                        r7.a(r6)
                        java.lang.String r6 = "locked"
                        goto L4d
                    L60:
                        java.lang.String r6 = "screen user present"
                        com.czhj.sdk.logger.SigmobLog.d(r6)
                        com.sigmob.sdk.manager.d r6 = com.sigmob.sdk.manager.d.a()
                        r6.a(r0)
                        java.lang.String r6 = "unlock"
                        goto L4d
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.b.a.AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
                }
            };
            this.k = broadcastReceiver;
            AdLifecycleManager.getInstance().initialize(b.h());
            this.b = System.currentTimeMillis();
            this.f13032a = UUID.randomUUID().toString();
            SigmobLog.i("session_start: " + this.b + ":" + this.f13032a);
            PointEntityActive.ActiveTracking(PointCategory.SESSION_START, this.f13032a, Constants.FAIL, String.valueOf(this.b));
            AdLifecycleManager.getInstance().addLifecycleListener(this);
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(new String(Base64.decode(n.M, 2)));
                intentFilter.addAction(new String(Base64.decode(n.N, 2)));
                intentFilter.addAction(new String(Base64.decode(n.O, 2)));
                v.a(b.b, broadcastReceiver, intentFilter);
            } catch (Throwable th) {
                com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("register screen status receiver error"));
            }
        }

        public int a() {
            return this.e;
        }

        public void b(Activity activity) {
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onCreate(Activity activity) {
            String simpleName = activity.getClass().getSimpleName();
            this.d = simpleName;
            this.c.put(simpleName, simpleName);
            this.f = true;
            this.g = false;
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onDestroy(Activity activity) {
            if (activity instanceof AdActivity) {
                this.i = false;
            }
            this.c.remove(activity.getClass().getSimpleName());
            if (this.c.isEmpty() && this.f) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = (currentTimeMillis - this.b) / 1000;
                StringBuilder B2KMhB2 = CtFAbx.B2KMhB("onActivityDestroyed session_end: ", currentTimeMillis, ":");
                B2KMhB2.append(this.f13032a);
                B2KMhB2.append(":");
                B2KMhB2.append(j);
                SigmobLog.i(B2KMhB2.toString());
                PointEntityActive.ActiveTracking(PointCategory.SESSION_END, this.f13032a, String.valueOf(j), String.valueOf(currentTimeMillis));
                this.b = System.currentTimeMillis();
                this.f = false;
            }
            if (this.c.isEmpty()) {
                this.h = true;
            }
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onPause(Activity activity) {
            if (!RomUtils.isHuawei()) {
                this.j = 3;
                return;
            }
            int i = this.j;
            if (i == 0) {
                this.j = 1;
                return;
            }
            if (i == 2) {
                this.j = 3;
            } else if (i != 3) {
                this.j = 0;
            } else {
                b.g.removeCallbacksAndMessages(null);
            }
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onResume(Activity activity) {
            if (activity instanceof AdActivity) {
                this.i = true;
            } else if (!this.i) {
                WeakReference unused = b.d = new WeakReference(activity);
            }
            if (RomUtils.isHuawei()) {
                int i = this.j;
                if (i == 1) {
                    this.j = 2;
                } else if (i == 3) {
                    b.g.postDelayed(new ADYaiT(0, activity), 500L);
                }
            } else {
                b.c(activity);
            }
            this.g = !activity.getClass().getSimpleName().equals(this.d);
            this.d = activity.getClass().getSimpleName();
            if (this.g) {
                WeakReference unused2 = b.f13031a = new WeakReference(activity);
            }
            if (!this.f || this.h) {
                this.h = false;
                this.f13032a = UUID.randomUUID().toString();
                this.b = System.currentTimeMillis();
                this.f = true;
                SigmobLog.i("onActivityResumed session_start: " + this.b + ":" + this.f13032a);
                PointEntityActive.ActiveTracking(PointCategory.SESSION_START, this.f13032a, Constants.FAIL, String.valueOf(this.b));
            }
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onStart(Activity activity) {
            this.j = 0;
            this.e++;
        }

        @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
        public void onStop(Activity activity) {
            this.e--;
            b.g.removeCallbacksAndMessages(null);
            Activity i = b.i();
            String simpleName = activity.getClass().getSimpleName();
            if (simpleName.equals(this.d) || (q.b(i) && simpleName.equals(i.getClass().getSimpleName()))) {
                b.j();
                if (!this.g || this.c.size() == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = (currentTimeMillis - this.b) / 1000;
                    StringBuilder B2KMhB2 = CtFAbx.B2KMhB("onActivityStopped session_end: ", currentTimeMillis, ":");
                    B2KMhB2.append(this.f13032a);
                    B2KMhB2.append(":");
                    B2KMhB2.append(j);
                    SigmobLog.i(B2KMhB2.toString());
                    PointEntityActive.ActiveTracking(PointCategory.SESSION_END, this.f13032a, String.valueOf(j), String.valueOf(currentTimeMillis));
                    this.b = System.currentTimeMillis();
                    this.f = false;
                }
            }
        }

        public void a(Activity activity) {
        }

        public void a(Activity activity, int i, int i2, Intent intent) {
        }
    }

    /* renamed from: com.sigmob.sdk.b$b, reason: collision with other inner class name */
    public static class C0447b implements SensorEventListener {

        /* renamed from: a, reason: collision with root package name */
        private static final int f13034a = 1000;
        private volatile Boolean b = null;

        public C0447b() {
            b();
            c();
        }

        private void b() {
            if (b.b == null) {
                return;
            }
            ag.a(b.b).a(this);
        }

        private void c() {
            ThreadPoolFactory.BackgroundThreadPool.getInstance().getIOHandler().postDelayed(new ADYaiT(1, this), 1000L);
        }

        private void d() {
            if (b.b == null) {
                return;
            }
            ag.a(b.b).b(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (this.b == null) {
                this.b = Boolean.FALSE;
            }
        }

        public Boolean a() {
            return this.b == null ? Boolean.TRUE : this.b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            this.b = Boolean.TRUE;
            d();
        }
    }

    public static String a() {
        return "";
    }

    public static DeviceContext b() {
        DeviceContext deviceContext = f;
        if (deviceContext != null || b == null) {
            return deviceContext;
        }
        DeviceContext deviceContext2 = new DeviceContext() { // from class: com.sigmob.sdk.b.1
            private WindCustomController a() {
                return WindAds.sharedAds().getOptions().getCustomController();
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public String getAndroidId() {
                WindCustomController a2 = a();
                if ((a2 == null || a2.isCanUseAndroidId()) && b.e && WindAds.sharedAds().isPersonalizedAdvertisingOn()) {
                    return ClientMetadata.getInstance().getAndroidId();
                }
                if (a2 == null || a2.isCanUseAndroidId()) {
                    return null;
                }
                return a2.getAndroidId();
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public String getCarrier() {
                if (o.a().j()) {
                    return null;
                }
                WindCustomController a2 = a();
                if (a2 != null && !a2.isCanUseSimOperator()) {
                    return a2.getDevSimOperatorCode();
                }
                String networkOperatorForUrl = ClientMetadata.getInstance().getNetworkOperatorForUrl();
                SigmobLog.d("SDKContext: simOperator = " + networkOperatorForUrl);
                return networkOperatorForUrl;
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public String getCarrierName() {
                if (o.a().j()) {
                    return null;
                }
                WindCustomController a2 = a();
                if (a2 != null && !a2.isCanUseSimOperator()) {
                    return a2.getDevSimOperatorName();
                }
                String networkOperatorName = ClientMetadata.getInstance().getNetworkOperatorName();
                SigmobLog.d("SDKContext: carrierName = " + networkOperatorName);
                return networkOperatorName;
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public String getImei() {
                WindCustomController a2 = a();
                if (((a2 == null || a2.isCanUsePhoneState()) && b.e && WindAds.sharedAds().isPersonalizedAdvertisingOn()) || a2 == null || a2.isCanUsePhoneState()) {
                    return null;
                }
                return a2.getDevImei();
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public String getImei1() {
                WindCustomController a2 = a();
                if (((a2 == null || a2.isCanUsePhoneState()) && b.e && WindAds.sharedAds().isPersonalizedAdvertisingOn()) || a2 == null || a2.isCanUsePhoneState()) {
                    return null;
                }
                return a2.getDevImei();
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public String getImei2() {
                WindCustomController a2 = a();
                if (((a2 == null || a2.isCanUsePhoneState()) && b.e && WindAds.sharedAds().isPersonalizedAdvertisingOn()) || a2 == null || a2.isCanUsePhoneState()) {
                    return null;
                }
                return a2.getDevImei();
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public Location getLocation() {
                if (o.a().S()) {
                    return null;
                }
                WindCustomController a2 = a();
                return (a2 == null || a2.isCanUseLocation()) ? ClientMetadata.getInstance().getLocation() : a2.getLocation();
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public String getOaid() {
                WindCustomController a2 = a();
                return (a2 == null || a2.isCanUseOaid()) ? ClientMetadata.getInstance().getOAID() : a2.getDevOaid();
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public boolean isCustomAndroidId() {
                WindCustomController a2 = a();
                return a2 == null || a2.isCanUseAndroidId();
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public boolean isCustomOaId() {
                WindCustomController a2 = a();
                return (a2 == null || a2.isCanUseOaid()) ? false : true;
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public boolean isCustomOperatorCode() {
                WindCustomController a2 = a();
                return (a2 == null || a2.isCanUseSimOperator() || com.sigmob.sdk.base.utils.o.a((CharSequence) a2.getDevSimOperatorCode())) ? false : true;
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public boolean isCustomOperatorName() {
                WindCustomController a2 = a();
                return (a2 == null || a2.isCanUseSimOperator() || com.sigmob.sdk.base.utils.o.a((CharSequence) a2.getDevSimOperatorName())) ? false : true;
            }

            @Override // com.czhj.sdk.common.mta.DeviceContext
            public boolean isCustomPhoneState() {
                WindCustomController a2 = a();
                return a2 == null || a2.isCanUsePhoneState();
            }
        };
        f = deviceContext2;
        return deviceContext2;
    }

    public static Activity c() {
        WeakReference<Activity> weakReference = d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static void d() {
        if (c == null) {
            c = new a();
        }
    }

    public static Context e() {
        return b;
    }

    public static boolean f() {
        if (h == null) {
            h = new C0447b();
        }
        return h.a().booleanValue();
    }

    public static boolean g() {
        AudioManager audioManager;
        return (b == null || (audioManager = (AudioManager) e().getSystemService(MediaFormat.KEY_AUDIO)) == null || audioManager.getStreamVolume(3) != 0) ? false : true;
    }

    public static Application h() {
        Context context = b;
        if (context instanceof Application) {
            return (Application) context;
        }
        return null;
    }

    public static Activity i() {
        WeakReference<Activity> weakReference = f13031a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static void j() {
        o();
        p();
    }

    private static void n() {
        WindAdOptions options;
        WindCustomController customController;
        List<PackageInfo> installPackageInfoList;
        if (o.a().T() || (options = WindAds.sharedAds().getOptions()) == null || (customController = options.getCustomController()) == null || customController.isCanUseAppList() || (installPackageInfoList = customController.getInstallPackageInfoList()) == null || installPackageInfoList.isEmpty()) {
            return;
        }
        Iterator<PackageInfo> it = installPackageInfoList.iterator();
        while (it.hasNext()) {
            ae.a(it.next(), 2);
        }
    }

    private static void o() {
        BaseAdUnit f2 = h.f();
        if (f2 == null) {
            return;
        }
        h.c((BaseAdUnit) null);
        g.a(f2, "open_pkg");
        ae.a("open_pkg", "1", f2);
    }

    private static void p() {
        BaseAdUnit m = h.m();
        if (m == null) {
            return;
        }
        h.d((BaseAdUnit) null);
        m.getClickCommon().isDeeplink = "1";
        Uri deeplinkUri = m.getDeeplinkUri();
        com.sigmob.sdk.manager.b.b(m, com.sigmob.sdk.base.common.a.G, deeplinkUri == null ? m.getDeeplinkUrl() : deeplinkUri.toString());
    }

    private static void q() {
        BaseAdUnit f2 = h.f();
        if (f2 == null) {
            return;
        }
        h.c((BaseAdUnit) null);
        ae.a("open_pkg", Constants.FAIL, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Activity activity) {
        q();
        d(activity);
    }

    private static void d(Activity activity) {
        Uri parse;
        BaseAdUnit m = h.m();
        if (m == null || activity == null) {
            return;
        }
        h.d((BaseAdUnit) null);
        m.getClickCommon().isDeeplink = Constants.FAIL;
        com.sigmob.sdk.manager.b.b(m, com.sigmob.sdk.base.common.a.H, null);
        String landing_page = m.getLanding_page();
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) landing_page) || (parse = Uri.parse(landing_page)) == null) {
            return;
        }
        if (!m.isSkipSigmobBrowser()) {
            h.a(m);
            BaseAdActivity.a(activity, (Class<? extends BaseAdActivity>) AdActivity.class, m.getUuid());
        } else {
            try {
                v.a(activity, parse);
            } catch (Throwable th) {
                SigmobLog.e("can't open load ", th);
            }
        }
    }

    public static void a(Activity activity) {
        if (activity == null) {
            return;
        }
        f13031a = new WeakReference<>(activity);
    }

    public static /* synthetic */ void b(Activity activity) {
        c(activity);
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (b == null) {
                Context applicationContext = context.getApplicationContext();
                b = applicationContext;
                k.a(applicationContext, n.o);
                o.a().e();
                b(b);
                com.sigmob.sdk.base.db.a.a(b);
                ClientMetadata.getInstance().initialize(b);
                n();
                g = new Handler(Looper.getMainLooper());
            }
        }
    }

    private static void b(Context context) {
        Networking.AddSigmobServerURL(o.c());
        Networking.AddSigmobServerURL(o.a().t());
        Networking.AddSigmobServerURL(o.a().u());
        Networking.AddSigmobServerURL(o.a().r());
        Networking.initializeV2(context);
        Networking.initializeSigRequestQueue(context);
    }

    public static void a(boolean z) {
        e = z;
    }
}
