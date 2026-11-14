package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.kwad.components.core.request.h;
import com.kwad.components.core.s.t;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.DynamicInstallReceiver;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.BaseProxyFragmentActivity;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.p;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class l {
    private long acP;
    private volatile boolean awC;
    private volatile boolean awD;
    private volatile boolean awE;
    private volatile Boolean awF;
    private String awG;
    private int awH;
    private boolean awI;
    private KsLoadManager awJ;
    private long awK;
    private long awL;
    private f awM;
    private f awN;
    private f awO;
    private f awP;
    private volatile boolean awQ;
    private boolean awR;
    private boolean awS;
    private String awT;

    public static class a {
        private static final l awY = new l(0);

        static {
            EPZLDtz();
        }

        private static /* synthetic */ void EPZLDtz() {
            char[] charArray = "\r\u0001\u0003@\t\u000f\u0003\u000b@\f\u0001\u0017@\u001d\u0006\u000b\u0002\u0002@$\u0000\u0007,\u001c\u0007\n\t\u000b".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'n');
            }
            String str = new String(charArray);
            char[] charArray2 = "\r\u0002\u0007\u0000\u0007\u001a".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'n');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ l(byte b) {
        this();
    }

    public static l DP() {
        return a.awY;
    }

    private synchronized boolean DR() {
        return n.bc(getContext());
    }

    private void DS() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.acP = elapsedRealtime;
        com.kwad.sdk.service.c.init();
        j.CN();
        Ee();
        Ef();
        boolean DQ = DQ();
        if (this.awM == null) {
            this.awM = f.ad(this.awK);
        }
        if (!DQ) {
            this.awM.report();
        }
        DV();
        Ei();
        Ej();
        Ep();
        Eb();
        if (!DQ) {
            DT();
            e((com.kwad.sdk.g.a) null);
        }
        DX();
        DZ();
        Ea();
        Eg();
        En();
        El();
        com.kwad.sdk.o.l.LD();
        DW();
        com.kwad.sdk.core.h.a.LD();
        if (!DQ) {
            com.kwad.sdk.a.a.c.EG().EI();
            com.kwad.components.core.o.a.tz().tA();
        }
        if (com.kwad.framework.a.a.ox.booleanValue()) {
            try {
                com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class);
            } catch (Exception unused) {
            }
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.sdk.core.d.c.d("KSAdSDK", "KSAdSDK init time:" + elapsedRealtime2);
        com.kwad.sdk.core.d.c.i("KSAdSDK", "SDK_VERSION_NAME: 4.9.20.1 TK_VERSION_CODE: 6.1.8 BRIDGE_VERSION: 1.3");
        if (this.awN == null) {
            this.awN = f.ae(elapsedRealtime2);
        }
        if (!DQ) {
            this.awN.report();
        }
        if (DP().awL > 0) {
            m.al(SystemClock.elapsedRealtime() - DP().awL);
        }
        a(ServiceProvider.getSDKConfig());
        this.awC = true;
    }

    private void DT() {
        com.kwad.sdk.mobileid.a.init(getContext());
    }

    private void DU() {
        try {
            com.kwad.sdk.commercial.c.a(new c.a() { // from class: com.kwad.sdk.l.6
                @Override // com.kwad.sdk.commercial.c.a
                public final boolean Es() {
                    return com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aDK);
                }

                @Override // com.kwad.sdk.commercial.c.a
                public final boolean Et() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aDJ);
                }

                @Override // com.kwad.sdk.commercial.c.a
                public final JSONObject Eu() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aDV);
                }

                @Override // com.kwad.sdk.commercial.c.a
                public final JSONObject Ev() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aDW);
                }

                @Override // com.kwad.sdk.commercial.c.a
                public final String Ew() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGl);
                }

                @Override // com.kwad.sdk.commercial.c.a
                public final void j(String str, String str2, boolean z) {
                    com.kwad.components.core.o.a.tz().e(str, str2, false);
                }
            }, this.awI);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void DV() {
        try {
            com.kwad.sdk.components.c.init(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void DW() {
        try {
            com.kwad.components.core.proxy.launchdialog.e.tx().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void DX() {
        try {
            com.kwad.components.core.d.a.initAsync(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void DY() {
        try {
            com.kwad.components.core.d.a.am(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void DZ() {
        try {
            com.kwad.sdk.components.d.init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void Ea() {
        try {
            com.kwad.components.core.offline.b.b.init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void Eb() {
        ag.al(ServiceProvider.getContext(), this.awT);
        this.awT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ec() {
        try {
            Map<String, String> parseJSON2MapString = ab.parseJSON2MapString(com.kwad.sdk.core.config.c.aFO.getValue());
            for (String str : parseJSON2MapString.keySet()) {
                GlobalThreadPools.r(str, Integer.parseInt((String) requireNonNull(parseJSON2MapString.get(str))));
            }
            GlobalThreadPools.Ld();
            com.kwad.sdk.core.config.c.aGH.getValue().getClass();
            GlobalThreadPools.Lb();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void Ed() {
        GlobalThreadPools.Lq().execute(new Runnable() { // from class: com.kwad.sdk.l.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.components.core.c.a.om().oo();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.w("KSAdSDK", Log.getStackTraceString(e));
                }
            }
        });
    }

    private static void Ee() {
        try {
            com.kwad.sdk.core.d.c.init(ServiceProvider.getSDKConfig().enableDebug);
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Ef() {
        try {
            com.kwad.sdk.o.f.UK().init();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Eg() {
        try {
            com.kwad.sdk.core.c.b.Ji().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void Eh() {
        try {
            com.kwad.sdk.core.webview.b.a.MN().init(getContext());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void Ei() {
        try {
            com.kwad.sdk.core.network.idc.a.Jz().init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Ej() {
        try {
            com.kwad.sdk.core.download.a.bE(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void Ek() {
        try {
            com.kwad.sdk.core.diskcache.a.bD(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void El() {
        try {
            t.uI().init();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Em() {
        com.kwad.components.core.p.b.tT();
        com.kwad.components.core.p.b.f(com.kwad.sdk.core.config.e.GT(), com.kwad.sdk.core.config.e.GU());
    }

    private void En() {
        try {
            bd.init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Eo() {
        try {
            com.kwad.sdk.app.b.Fi().init();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void Ep() {
        try {
            com.kwad.library.solder.lib.i.a(new i.a() { // from class: com.kwad.sdk.l.4
                @Override // com.kwad.library.solder.lib.i.a
                public final boolean Bz() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aEV);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final void b(String str, File file) {
                    com.kwad.sdk.core.download.a.a(str, file, true);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final void f(String str, Throwable th) {
                    if (th instanceof Exception) {
                        com.kwad.sdk.core.network.idc.a.Jz().h(str, th);
                    }
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getCorePoolSize() {
                    return com.kwad.sdk.core.config.e.GW();
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getMaxRetryCount() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aEW);
                }
            });
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static boolean aY(Context context) {
        String processName = ay.getProcessName(context);
        return !TextUtils.isEmpty(processName) && processName.endsWith("kssdk_remote");
    }

    public static String cw(String str) {
        return com.kwad.sdk.core.a.d.av(str);
    }

    public static String cx(String str) {
        return com.kwad.sdk.core.a.d.getResponseData(str);
    }

    public static void deleteCache() {
        com.kwad.sdk.core.diskcache.b.a.IJ().delete();
    }

    private void e(final com.kwad.sdk.g.a aVar) {
        try {
            com.kwad.components.core.request.h.a(new h.b() { // from class: com.kwad.sdk.l.11
                @Override // com.kwad.components.core.request.h.a
                public final void d(SdkConfigData sdkConfigData) {
                    com.kwad.sdk.core.d.c.i("KSAdSDK", "onConfigRefresh()");
                    try {
                        l.this.e(sdkConfigData);
                        com.kwad.sdk.g.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.accept(null);
                        }
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.h.a
                public final void tN() {
                    com.kwad.sdk.core.d.c.i("KSAdSDK", "onCacheLoaded()");
                    l.this.Ec();
                }

                @Override // com.kwad.components.core.request.h.b
                public final void tO() {
                    try {
                        com.kwad.sdk.g.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.accept(null);
                        }
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }
            });
        } catch (Throwable th) {
            n.l(th);
        }
    }

    public static void f(Map<String, String> map) {
        com.kwad.sdk.core.a.d.h(map);
    }

    public static String getAppId() {
        return ServiceProvider.getSDKConfig().appId;
    }

    public static JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.a.KA();
    }

    public static String getAppName() {
        return ServiceProvider.getSDKConfig().appName;
    }

    public static Context getContext() {
        return ServiceProvider.getContext();
    }

    public static JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.b.KC().toJson();
    }

    public static String getDid() {
        return bd.getDeviceId();
    }

    public static JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.d.KF().toJson();
    }

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static SdkConfig getSdkConfig() {
        return ServiceProvider.getSDKConfig();
    }

    public static boolean isDebugLogEnable() {
        return ServiceProvider.getSDKConfig().enableDebug;
    }

    public static void k(Throwable th) {
        ServiceProvider.reportSdkCaughtException(th);
    }

    public static <T> T newInstance(Class<T> cls) {
        try {
            return (T) com.kwad.sdk.service.c.h(cls).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void pauseCurrentPlayer() {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    private static <T> T requireNonNull(T t) {
        t.getClass();
        return t;
    }

    public static void resumeCurrentPlayer() {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimation(boolean z, int i) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimationColor(boolean z, int i) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void setThemeMode(int i) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public final boolean CT() {
        return this.awI;
    }

    public final boolean CU() {
        return this.awQ;
    }

    public final boolean CV() {
        return this.awR;
    }

    public final boolean CW() {
        return this.awC;
    }

    public final synchronized boolean DQ() {
        try {
        } finally {
            return this.awE;
        }
        if (DR()) {
            return false;
        }
        if (this.awF == null) {
            this.awF = Boolean.valueOf(com.kwad.sdk.core.config.e.DQ());
        }
        if (!this.awF.booleanValue()) {
            return false;
        }
        if (this.awE) {
            return true;
        }
        this.awE = IKsAdSDK.class.getDeclaredMethod("start", new Class[0]) != null;
        return this.awE;
    }

    public final boolean Eq() {
        return !DQ() ? this.awC : this.awC && this.awD;
    }

    public final long Er() {
        return this.acP;
    }

    public final KsLoadManager getAdManager() {
        if (this.awJ == null) {
            this.awJ = new com.kwad.components.core.b();
        }
        return this.awJ;
    }

    public final String getApiVersion() {
        return this.awG;
    }

    public final int getApiVersionCode() {
        return this.awH;
    }

    public final synchronized void init(Context context, SdkConfig sdkConfig) {
        if (context != null && sdkConfig != null) {
            try {
            } finally {
                return;
            }
            if (!TextUtils.isEmpty(sdkConfig.appId)) {
                if (this.awC) {
                    com.kwad.sdk.service.b.holderSdkConfig(sdkConfig);
                    return;
                }
                com.kwad.sdk.service.b.holderSdkConfig(sdkConfig);
                ServiceProvider.cx(context);
                if (aY(context)) {
                    ServiceProvider.Rd();
                    j.CN();
                    Ee();
                    this.awC = true;
                } else {
                    try {
                        n.Ez();
                        DS();
                        n.bb(context);
                    } catch (Throwable th) {
                        String stackTraceString = Log.getStackTraceString(th);
                        n.a(th, stackTraceString);
                        a(sdkConfig, new e(AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, stackTraceString));
                        return;
                    }
                }
                return;
            }
        }
        a(sdkConfig, e.awi);
    }

    public final <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        try {
            Class g = com.kwad.sdk.service.c.g(cls);
            if (g == null) {
                if (obj instanceof BaseProxyActivity) {
                    g = com.kwad.components.core.proxy.d.class;
                } else if (obj instanceof BaseProxyFragmentActivity) {
                    g = com.kwad.components.core.proxy.e.class;
                }
                com.kwad.components.core.d.a.reportSdkCaughtException(new RuntimeException("--getIsExternal:" + CT() + "--mIsSdkInit:" + CW() + "--componentClass" + cls));
            }
            return (T) g.newInstance();
        } catch (Exception e) {
            com.kwad.components.core.d.a.reportSdkCaughtException(e);
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return null;
        }
    }

    public final void setAdxEnable(boolean z) {
        this.awS = z;
    }

    public final void setApiVersion(String str) {
        this.awG = str;
    }

    public final void setApiVersionCode(int i) {
        this.awH = i;
    }

    public final void setAppTag(String str) {
        if (this.awC) {
            ag.al(ServiceProvider.getContext(), this.awT);
        } else {
            this.awT = str;
        }
    }

    public final void setInitStartTime(long j) {
        this.awL = j;
        p.setInitStartTime(System.currentTimeMillis());
    }

    public final void setIsExternal(boolean z) {
        this.awI = z;
    }

    public final void setLaunchTime(long j) {
        this.awK = j;
        p.setLaunchTime(j);
    }

    public final void setPersonalRecommend(boolean z) {
        this.awQ = z;
    }

    public final void setProgrammaticRecommend(boolean z) {
        this.awR = z;
    }

    public final synchronized void start() {
        boolean z;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.awO == null) {
                this.awO = f.af(this.awK);
            }
            this.awO.report();
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (DQ()) {
                z = false;
            } else {
                b(sDKConfig);
                z = true;
            }
            if (!this.awC) {
                b(sDKConfig, e.awj);
                z = true;
            }
            if (this.awD) {
                b(sDKConfig);
                z = true;
            }
            if (!z) {
                DT();
                e(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.l.1
                    @Override // com.kwad.sdk.g.a
                    public final void accept(Object obj) {
                    }
                });
                com.kwad.sdk.a.a.c.EG().EI();
                com.kwad.components.core.o.a.tz().tA();
                f fVar = this.awM;
                if (fVar != null) {
                    fVar.report();
                }
                f fVar2 = this.awN;
                if (fVar2 != null) {
                    fVar2.report();
                }
                this.awD = true;
                b(sDKConfig);
            }
            com.kwad.sdk.utils.h.schedule(new Runnable() { // from class: com.kwad.sdk.l.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.kwad.sdk.core.config.e.HP()) {
                        com.kwad.sdk.resourceCache.b.cw(l.getContext());
                    }
                }
            }, com.kwad.sdk.core.config.e.HQ(), TimeUnit.SECONDS);
            if (this.awP == null) {
                this.awP = f.ag(SystemClock.elapsedRealtime() - elapsedRealtime);
            }
            this.awO.report();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    public final void unInit() {
        com.kwad.sdk.core.download.b.IL().bG(getContext());
    }

    private l() {
        this.awC = false;
        this.awD = false;
        this.awE = false;
        this.awF = null;
        this.awG = "";
        this.awQ = true;
        this.awR = true;
        this.awS = false;
    }

    private static void b(SdkConfig sdkConfig, final e eVar) {
        final KsInitCallback ksInitCallback;
        try {
            String str = eVar.msg;
            if (sdkConfig == null || (ksInitCallback = sdkConfig.ksStartCallback) == null) {
                return;
            }
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.l.9
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        KsInitCallback ksInitCallback2 = KsInitCallback.this;
                        e eVar2 = eVar;
                        ksInitCallback2.onFail(eVar2.code, eVar2.msg);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static Object f(String str, Object... objArr) {
        try {
            if ("autoRT".equals(str)) {
                return -1;
            }
            if ("getAutoRevertTime".equals(str)) {
                return 10000;
            }
            boolean z = false;
            if ("TRANSFORM_API_HOST".equals(str)) {
                return com.kwad.sdk.core.network.idc.a.Jz().Z(objArr[0].toString(), "api");
            }
            if ("reportDynamicUpdate".equals(str)) {
                com.kwad.sdk.commercial.c.h((JSONObject) objArr[0]);
                return Boolean.TRUE;
            }
            if (!"enableDynamic".equals(str) || ServiceProvider.Re() == null) {
                return null;
            }
            if (ay.isInMainProcess(ServiceProvider.Re()) && com.kwad.framework.a.a.apf.booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Throwable unused) {
            }
            return null;
        }
    }

    private static void a(SdkConfig sdkConfig, final e eVar) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.l.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                KsInitCallback ksInitCallback2 = KsInitCallback.this;
                                e eVar2 = eVar;
                                ksInitCallback2.onFail(eVar2.code, eVar2.msg);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SdkConfigData sdkConfigData) {
        try {
            DY();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("KSAdSDK", Log.getStackTraceString(th));
        }
        DU();
        Eh();
        com.kwad.sdk.core.config.e.CR();
        if ((com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aDI) && ay.isInMainProcess(ServiceProvider.Re())) || com.kwad.framework.a.a.oy.booleanValue()) {
            DynamicInstallReceiver.registerToApp(ServiceProvider.Re());
        }
        if (com.kwad.sdk.core.config.e.HE()) {
            com.kwad.sdk.b.a.init(com.kwad.sdk.o.m.US());
        }
        Em();
        bh.init(getContext());
        com.kwad.components.core.a.a.oi().at();
        com.kwad.sdk.utils.g.a(getContext(), 30000L, new com.kwad.sdk.collector.h() { // from class: com.kwad.sdk.l.12
            @Override // com.kwad.sdk.collector.h
            public final void c(JSONArray jSONArray) {
                com.kwad.components.core.o.a.tz().c(jSONArray);
            }
        });
        com.kwad.sdk.core.network.idc.a.Jz().a(com.kwad.sdk.core.config.e.HF(), com.kwad.sdk.core.config.e.HG());
        com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
        bt.a(com.kwad.sdk.core.config.e.HH(), com.kwad.sdk.core.config.e.HI(), ServiceProvider.getContext());
        Eo();
        Ek();
        com.kwad.components.core.i.a.qD().at(getContext());
        com.kwad.sdk.crash.online.monitor.a.df(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aFB));
        ImageLoaderPerfUtil.report();
        com.kwad.sdk.n.f.df(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aFJ));
        ar.SN().df(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aFL));
        com.kwad.sdk.core.threads.c.df(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aFN));
        com.kwad.sdk.j.a.Py();
        com.kwad.sdk.o.m.C(getContext(), ((Boolean) sdkConfigData.getAppConfigData(Boolean.FALSE, new com.kwad.sdk.g.b<JSONObject, Boolean>() { // from class: com.kwad.sdk.l.2
            private static Boolean g(JSONObject jSONObject) {
                return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(JSONObject jSONObject) {
                return g(jSONObject);
            }
        })).booleanValue());
        com.kwad.sdk.kgeo.a.es(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGf));
        try {
            com.kwad.components.core.webview.tachikoma.g.wq().init();
        } catch (Throwable th2) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th2);
        }
        Ed();
        try {
            com.kwad.sdk.f.a.a.Og().init(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aFK));
        } catch (Throwable th3) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th3);
        }
    }

    private static void a(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bw.b(new Runnable() { // from class: com.kwad.sdk.l.8
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (l.DP().awL > 0) {
                                    m.am(SystemClock.elapsedRealtime() - l.DP().awL);
                                }
                                KsInitCallback.this.onSuccess();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void b(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksStartCallback;
                if (ksInitCallback != null) {
                    bw.b(new Runnable() { // from class: com.kwad.sdk.l.10
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                KsInitCallback.this.onSuccess();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(String str, Map<String, String> map, String str2) {
        com.kwad.sdk.core.a.d.a(str, map, str2);
    }
}
