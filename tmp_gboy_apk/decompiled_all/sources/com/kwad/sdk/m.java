package com.kwad.sdk;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.utils.bg;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class m {
    private static int awZ;

    public static void a(final com.kwai.adclient.kscommerciallogger.model.d dVar, final String str) {
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.7
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.ERROR_LOG, com.kwai.adclient.kscommerciallogger.model.d.this, new SDKInitMsg().setInitCount(m.awZ).setErrorReason(str).setInitStatus(2));
            }
        });
    }

    public static void aj(long j) {
        final long currentTimeMillis = j > 0 ? System.currentTimeMillis() - j : -1L;
        awZ++;
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bjv, new SDKInitMsg().setLaunchIntervalTime(currentTimeMillis).setInitCount(m.awZ).setInitStatus(0));
            }
        });
    }

    public static void ak(final long j) {
        if (j > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            j = -1;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bjv, new SDKInitMsg().setTotalDurationTime(j).setInitCount(m.awZ).setInitStatus(1));
            }
        });
    }

    public static void al(final long j) {
        if (j > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            j = -1;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bjv, new SDKInitMsg().setTotalDurationTime(j).setInitCount(m.awZ).setInitStatus(6));
            }
        });
    }

    public static void am(final long j) {
        if (j > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            j = -1;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bjv, new SDKInitMsg().setTotalDurationTime(j).setInitCount(m.awZ).setInitStatus(3));
            }
        });
    }

    public static void an(final long j) {
        if (j > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            j = -1;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bjv, new SDKInitMsg().setTotalDurationTime(j).setInitCount(m.awZ).setInitStatus(4));
            }
        });
    }

    public static void ao(final long j) {
        if (j > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            j = -1;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.m.6
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.bjv, new SDKInitMsg().setTotalDurationTime(j).setInitCount(m.awZ).setInitStatus(5));
            }
        });
    }
}
