package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.t;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b {
    private static final Handler iK = new Handler(Looper.getMainLooper());

    public static class a {
        private volatile boolean Fx;

        private a() {
            this.Fx = false;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$b, reason: collision with other inner class name */
    public static class C0266b {
        private volatile boolean Fy;

        private C0266b() {
            this.Fy = false;
        }

        public static /* synthetic */ boolean a(C0266b c0266b, boolean z) {
            c0266b.Fy = true;
            return true;
        }

        public /* synthetic */ C0266b(byte b) {
            this();
        }
    }

    static {
        qFWxm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(C0266b c0266b, AdTemplate adTemplate, long j, long j2, Runnable runnable) {
        if (!c0266b.Fy) {
            iK.removeCallbacks(runnable);
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 7, j, j2);
        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
        return true;
    }

    public static void loadSplashScreenAd(KsScene ksScene, final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(covert);
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.u(covert.getPosId());
        boolean b = t.uI().b(covert, "loadSplashScreenAd");
        covert.setAdStyle(4);
        covert.setAdNum(1);
        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        byte b2 = 0;
        final a aVar = new a(b2);
        aVar.Fx = false;
        final long elapsedRealtime2 = SystemClock.elapsedRealtime();
        final ImpInfo impInfo = new ImpInfo(covert);
        final C0266b c0266b = new C0266b(b2);
        com.kwad.components.core.o.a.tz().tB();
        Handler handler = iK;
        handler.postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.a(ImpInfo.this);
            }
        }, 15000L);
        final bg bgVar = new bg() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                C0266b.a(C0266b.this, true);
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aJe;
                splashScreenAdListener2.onError(eVar.errorCode, eVar.msg);
                com.kwad.components.ad.splashscreen.monitor.b.mk();
                com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aJe;
                com.kwad.components.ad.splashscreen.monitor.b.c(false, eVar2.errorCode, eVar2.msg, covert.getPosId());
                com.kwad.components.core.o.a.tz().bk(4);
            }
        };
        int a2 = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Gj);
        if (a2 < 0) {
            a2 = 5000;
        }
        handler.postDelayed(bgVar, a2);
        final long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.f(covert.getPosId(), elapsedRealtime3);
        SplashPreloadManager.lO().a(covert.getPosId(), 2);
        List<String> lP = SplashPreloadManager.lO().lP();
        List<Integer> i = SplashPreloadManager.lO().i(lP);
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.a(covert.getPosId(), lP, i);
        KsAdLoadManager.M().a(new a.C0312a().e(impInfo).aP(true).aQ(b).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final int i2, final String str, boolean z) {
                if (C0266b.this.Fy) {
                    return;
                }
                b.iK.removeCallbacks(bgVar);
                if (!aVar.Fx && i2 != com.kwad.sdk.core.network.e.aJc.errorCode) {
                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                    com.kwad.components.ad.splashscreen.monitor.b.b(z, i2, str, covert.getPosId());
                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                    com.kwad.components.ad.splashscreen.monitor.b.c(z, i2, str, covert.getPosId());
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        splashScreenAdListener.onError(i2, str);
                        if (i2 == com.kwad.sdk.core.network.e.aJf.errorCode) {
                            com.kwad.components.core.o.a.tz().bk(0);
                        } else {
                            com.kwad.components.core.o.a.tz().bk(3);
                        }
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final AdResultData adResultData, boolean z) {
                boolean z2;
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                            com.kwad.components.ad.splashscreen.monitor.a.mi().t(covert.getPosId());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    z2 = z;
                } catch (Throwable th) {
                    th = th;
                    z2 = z;
                }
                try {
                    if (b.a(adResultData, aVar, this, z2, covert.posId)) {
                        return;
                    }
                    AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                    adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    adTemplate.requestStartTime = elapsedRealtime;
                    adTemplate.notNetworkRequest = z2;
                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                    com.kwad.components.ad.splashscreen.monitor.b.e(adTemplate, elapsedRealtime3);
                    com.kwad.sdk.commercial.d.d.a(covert, 1);
                    long elapsedRealtime4 = SystemClock.elapsedRealtime();
                    KsSplashScreenAdControl ksSplashScreenAdControl = new KsSplashScreenAdControl(covert, adResultData);
                    if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Gn)) {
                        SplashPreloadManager.lO();
                        if (SplashPreloadManager.i(adResultData)) {
                            if (b.a(C0266b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bgVar)) {
                                return;
                            }
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            if (SplashPreloadManager.lO().h(adResultData)) {
                                com.kwad.components.ad.splashscreen.monitor.b.mk();
                                com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                com.kwad.components.core.o.a.tz().bk(1);
                                adTemplate.splashAdLoadType = 2;
                                return;
                            }
                            if (SplashPreloadManager.lO().a(adResultData, true, 1) > 0) {
                                com.kwad.components.ad.splashscreen.monitor.b.mk();
                                com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                                com.kwad.components.core.o.a.tz().bk(2);
                                adTemplate.splashAdLoadType = 1;
                                return;
                            }
                            com.kwad.components.ad.splashscreen.monitor.b.mk();
                            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                            return;
                        }
                    }
                    SplashPreloadManager.lO();
                    if (!SplashPreloadManager.i(adResultData)) {
                        SplashPreloadManager.lO();
                        if (!SplashPreloadManager.j(adResultData)) {
                            if (b.a(C0266b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bgVar)) {
                                return;
                            }
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.mk();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 8, elapsedRealtime4, elapsedRealtime3);
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd live no cache returned");
                            com.kwad.components.core.o.a.tz().bk(5);
                            return;
                        }
                    }
                    boolean h = SplashPreloadManager.lO().h(adResultData);
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + h);
                    if (h) {
                        if (b.a(C0266b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bgVar)) {
                            return;
                        }
                        b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.mk();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                        com.kwad.components.core.o.a.tz().bk(1);
                        adTemplate.splashAdLoadType = 2;
                        return;
                    }
                    SplashPreloadManager.lO();
                    if (!SplashPreloadManager.i(adResultData)) {
                        if (!C0266b.this.Fy) {
                            b.iK.removeCallbacks(bgVar);
                            com.kwad.components.ad.splashscreen.monitor.b.mk();
                            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 5, elapsedRealtime4, elapsedRealtime3);
                            aVar.Fx = true;
                            a(com.kwad.sdk.core.network.e.aJd.errorCode, "请求成功，但缓存未命中", z2);
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                            com.kwad.components.core.o.a.tz().bk(3);
                            return;
                        }
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                        return;
                    }
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                    int a3 = SplashPreloadManager.lO().a(adResultData, true, 1);
                    if (b.a(C0266b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bgVar)) {
                        return;
                    }
                    if (a3 > 0) {
                        b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.mk();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.components.core.o.a.tz().bk(2);
                        adTemplate.splashAdLoadType = 1;
                        return;
                    }
                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                    com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                    aVar.Fx = true;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aJf;
                    a(eVar.errorCode, eVar.msg, z2);
                } catch (Throwable th2) {
                    th = th2;
                    ServiceProvider.reportSdkCaughtException(th);
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aJh;
                    a(eVar2.errorCode, eVar2.msg, z2);
                }
            }
        }).tR());
    }

    private static /* synthetic */ void qFWxm() {
        char[] charArray = "*&$g.($,g+&0g:!,%%g\u0003' \u000b; -.,".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'I');
        }
        String str = new String(charArray);
        char[] charArray2 = "*% ' =".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'I');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.SplashScreenAdListener splashScreenAdListener, final KsSplashScreenAd ksSplashScreenAd, final AdTemplate adTemplate) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    KsAdLoadManager.M().a((KsAdLoadManager) KsSplashScreenAd.this);
                    splashScreenAdListener.onSplashScreenAdLoad(KsSplashScreenAd.this);
                    com.kwad.components.ad.splashscreen.monitor.a.mi().ai(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(AdResultData adResultData, a aVar, com.kwad.components.core.request.d dVar, boolean z, long j) {
        if (adResultData.getAdTemplateList().size() != 0) {
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.c(z, com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aJc.msg : adResultData.testErrorMsg, j);
        aVar.Fx = true;
        dVar.a(com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aJc.msg : adResultData.testErrorMsg, z);
        com.kwad.components.core.o.a.tz().bk(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ImpInfo impInfo) {
        final SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.o.a.tz().tC();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.mk();
            com.kwad.components.ad.splashscreen.monitor.b.v(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.M().a(new a.C0312a().e(impInfo2).aQ(false).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.5
                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void b(AdResultData adResultData) {
                    try {
                        if (adResultData.getAdTemplateList().size() > 0) {
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.lO().a(adResultData, false, 2));
                            com.kwad.components.ad.splashscreen.monitor.b.mk();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                            com.kwad.components.core.o.a.tz().bl(adResultData.getAdTemplateList().size());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void onError(int i, String str) {
                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                    com.kwad.components.ad.splashscreen.monitor.b.b(i, str, SceneImpl.this.getPosId());
                }
            }).tR());
        }
    }
}
