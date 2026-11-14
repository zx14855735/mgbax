package com.kwad.components.ad.reward.monitor;

import com.bykv.vk.component.ttvideo.player.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b {
    private static String TAG = "LivePlayMonitor";

    public static void a(int i, String str, String str2, Long l, int i2, String str3) {
        if (l == null) {
            l = -1L;
        }
        com.kwad.sdk.commercial.c.b("ad_sdk_live_video_error_monitor", new LivePlayMonitorInfo().setScene(2).setAppId(str).setAuthorId(str2).setUserId(l).setErrorCode(i2).setErrorMsg(str3));
        String str4 = TAG;
        StringBuilder sb = new StringBuilder("reportAdLiveMonitorError, status:");
        sb.append(i2);
        sb.append(" scene:2 errMsg:");
        sb.append(str3);
        sb.append(" appId:");
        A2egSU.BIYEnU(sb, str, " authorId", str2, " userId");
        sb.append(l);
        com.kwad.sdk.core.d.c.d(str4, sb.toString());
    }
}
