package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.s.f;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class d {
    public static void T(final AdTemplate adTemplate) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(7).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void U(final AdTemplate adTemplate) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.6
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(8).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void a(final boolean z, final long j) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(z, new RewardMonitorInfo().setLoadStatus(1).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.bjx);
            }
        });
    }

    public static void c(final boolean z, final long j) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.23
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(z, new RewardMonitorInfo().setLoadStatus(6).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.bjx);
            }
        });
    }

    public static void d(final boolean z, final AdTemplate adTemplate) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.27
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.a(z, new RewardMonitorInfo().setLoadStatus(7).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setAdTemplate(AdTemplate.this), com.kwai.adclient.kscommerciallogger.model.a.bjx);
            }
        });
    }

    public static void e(final boolean z, final AdTemplate adTemplate) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.c(z, new RewardMonitorInfo().setPageStatus(6).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void f(final boolean z, final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.c(z, new RewardMonitorInfo().setPageStatus(5).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void g(final boolean z, final AdTemplate adTemplate) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.8
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.g(new RewardWebViewInfo().setEvent("ad_show").setSceneId(z ? "ad_reward" : "ad_fullscreen").setAdTemplate(adTemplate));
            }
        });
    }

    public static void h(final boolean z, final AdTemplate adTemplate) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.15
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.c(z, new RewardMonitorInfo().setPageStatus(3).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void i(final boolean z, final AdTemplate adTemplate) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.20
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                d.j(z, adTemplate);
            }
        });
    }

    public static void j(boolean z, AdTemplate adTemplate) {
        String str;
        if (adTemplate != null) {
            if (f.aT(adTemplate.mDataCacheTraceElement)) {
                str = "data_cache";
            } else if (f.aT(adTemplate.mDataLoadTraceElement)) {
                str = "data_load";
            }
            com.kwad.sdk.commercial.c.c(z, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
        }
        str = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
        com.kwad.sdk.commercial.c.c(z, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(long j) {
        return j == -1;
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final int i, final long j) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.26
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                d.b(z, adTemplate, i, j);
            }
        });
    }

    public static void b(final boolean z, final long j) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.12
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(z, new RewardMonitorInfo().setLoadStatus(5).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.bjx);
            }
        });
    }

    public static void c(final boolean z, final AdTemplate adTemplate, final int i, final long j) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.28
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                d.d(z, adTemplate, i, j);
            }
        });
    }

    public static void d(boolean z, AdTemplate adTemplate, int i, long j) {
        adTemplate.setDownloadFinishTime(SystemClock.elapsedRealtime());
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        long loadDataTime = adTemplate.getLoadDataTime() - j;
        long downloadFinishTime = adTemplate.getDownloadFinishTime() - adTemplate.getLoadDataTime();
        long downloadFinishTime2 = adTemplate.getDownloadFinishTime() - j;
        if (a(loadDataTime, downloadFinishTime, downloadFinishTime2)) {
            loadDataTime = -1;
            downloadFinishTime = -1;
            downloadFinishTime2 = -1;
        }
        com.kwad.sdk.commercial.c.a(z, new RewardMonitorInfo().setLoadStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i).setLoadDataDuration(loadDataTime).setDownloadDuration(downloadFinishTime).setTotalDuration(downloadFinishTime2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.bjx);
    }

    public static void a(final boolean z, final int i, final String str, final long j) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.29
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(z, new RewardMonitorInfo().setLoadStatus(4).setErrorCode(i).setErrorMsg(str).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.bjt);
            }
        });
    }

    public static void b(boolean z, AdTemplate adTemplate, int i, long j) {
        long loadDataTime = (j <= 0 || adTemplate.getLoadDataTime() <= 0) ? -1L : adTemplate.getLoadDataTime() - j;
        long j2 = a(loadDataTime) ? -1L : loadDataTime;
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        com.kwad.sdk.commercial.c.a(z, new RewardMonitorInfo().setLoadStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i).setLoadDataDuration(j2).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.bjx);
    }

    public static void c(final AdTemplate adTemplate, final int i, final String str) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.7
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(9).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setErrorMsg(str).setErrorCode(i).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final String str) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.30
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.b(z, new RewardMonitorInfo().setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setErrorMsg(str).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void c(final boolean z, final AdTemplate adTemplate, final String str) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.21
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.c(z, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final long j) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.31
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                d.a(z, adTemplate, j, (AdGlobalConfigInfo) null);
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final long j, final AdGlobalConfigInfo adGlobalConfigInfo) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                d.b(z, adTemplate, j, adGlobalConfigInfo);
            }
        });
    }

    public static void a(final boolean z, final String str) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.9
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_init").setSceneId(z ? "ad_reward" : "ad_fullscreen"));
            }
        });
    }

    public static void a(final AdTemplate adTemplate, final boolean z, final String str, final String str2) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.10
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_url").setSceneId(z ? "ad_reward" : "ad_fullscreen").setUrl(str2).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final AdTemplate adTemplate, final boolean z, final String str, final String str2, final long j, final int i) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.11
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_timeout").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setTimeType(i).setUrl(str2).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final boolean z, final String str, final String str2, final long j) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.13
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_finish").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setUrl(str2));
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final a aVar, final long j, com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        final com.kwad.sdk.g.a aVar3 = null;
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.17
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                RewardMonitorInfo posId = new RewardMonitorInfo().setCallbackType(a.this.getTypeValue()).setAdTemplate(adTemplate).setPosId(j);
                com.kwad.sdk.g.a aVar4 = aVar3;
                if (aVar4 != null) {
                    aVar4.accept(posId);
                }
                com.kwad.sdk.commercial.c.e(z, posId);
            }
        });
    }

    public static void a(final boolean z, final a aVar, final AdTemplate adTemplate, final com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.18
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                d.b(z, aVar, adTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) aVar2);
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final long j, final int i, final long j2) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.19
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.f(z, new RewardMonitorInfo().setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setCurrentDuration(j).setErrorCode(i).setErrorMsg(String.valueOf(j2)).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setVideoDuration(com.kwad.sdk.core.response.b.a.N(er)).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final String str, final String str2) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.22
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.c(z, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setErrorMsg(str2).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final AdTemplate adTemplate, final int i, final int i2, final boolean z) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.24
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.h(new RewardMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setRewardType(!z ? 1 : 0).setTaskType(i).setTaskStep(i2).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setAdTemplate(AdTemplate.this));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(long... jArr) {
        for (long j : jArr) {
            if (j >= 60000) {
                return true;
            }
        }
        return false;
    }

    public static void b(boolean z, AdTemplate adTemplate, long j, AdGlobalConfigInfo adGlobalConfigInfo) {
        long loadDataTime = adTemplate.getLoadDataTime();
        long downloadFinishTime = adTemplate.getDownloadFinishTime();
        long j2 = loadDataTime > 0 ? j - loadDataTime : 0L;
        long j3 = downloadFinishTime > 0 ? j - downloadFinishTime : 0L;
        int i = (adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType == 1) ? 3 : 0;
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        com.kwad.sdk.commercial.c.c(z, new RewardMonitorInfo().setPageStatus(1).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdSceneType(i).setDataLoadInterval(j2).setDataDownloadInterval(j3).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setAdTemplate(adTemplate));
    }

    public static void d(final AdTemplate adTemplate, final int i, final int i2) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.25
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.i(new RewardMonitorInfo().setPageStatus(10).setFraudVerifyType(i).setFraudVerifyCode(i2).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void b(final boolean z, final AdTemplate adTemplate, final long j) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.14
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                long j2 = -1;
                if (!d.o(j)) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - j;
                    if (!d.a(elapsedRealtime)) {
                        j2 = elapsedRealtime;
                    }
                }
                AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
                com.kwad.sdk.commercial.c.c(z, new RewardMonitorInfo().setPageStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setRenderDuration(j2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setAdTemplate(adTemplate));
            }
        });
    }

    public static void b(final boolean z, final AdTemplate adTemplate, final String str) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.components.ad.reward.monitor.d.16
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo er = com.kwad.sdk.core.response.b.e.er(AdTemplate.this);
                com.kwad.sdk.commercial.c.c(z, new RewardMonitorInfo().setPageStatus(4).setLoadType(AdTemplate.this.isLoadFromCache() ? 2 : 1).setDownloadType(AdTemplate.this.getDownloadType()).setDownloadSize(AdTemplate.this.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setInterceptReason(str).setAdTemplate(AdTemplate.this));
            }
        });
    }

    public static void b(boolean z, a aVar, AdTemplate adTemplate, com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        if (adTemplate == null) {
            return;
        }
        RewardMonitorInfo adTemplate2 = new RewardMonitorInfo().setMaterialType(com.kwad.sdk.core.response.b.a.bf(com.kwad.sdk.core.response.b.e.er(adTemplate))).setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate);
        if (aVar2 != null) {
            aVar2.accept(adTemplate2);
        }
        com.kwad.sdk.commercial.c.d(z, adTemplate2);
    }
}
