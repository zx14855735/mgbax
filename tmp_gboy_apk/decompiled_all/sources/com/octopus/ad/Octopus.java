package com.octopus.ad;

import android.content.Context;
import com.octopus.ad.internal.q;
import com.octopus.ad.utils.b.g;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class Octopus {

    /* renamed from: a, reason: collision with root package name */
    private static OctopusAdSdkController f12336a;
    private static boolean b;

    public static OctopusAdSdkController getCustomController() {
        return f12336a;
    }

    public static String getOaid(Context context) {
        return g.a(context);
    }

    public static String getSdkVersion() {
        return "2.5.10.5";
    }

    public static void init(Context context, String str) {
        q.a().a(context, str);
    }

    public static boolean isHttpsEnabled() {
        return q.a().c;
    }

    public static boolean isLimitPersonalAds() {
        return b;
    }

    public static void logTagInfo(String str, boolean z) {
        q.a().a(str, z);
    }

    public static void setAppMuted(boolean z) {
        q.a().a(z);
    }

    public static void setAppVolume(float f) {
        q.a().a(f);
    }

    public static void setCustomController(OctopusAdSdkController octopusAdSdkController) {
        f12336a = octopusAdSdkController;
    }

    public static void setIsDownloadDirect(boolean z) {
        q.a().c(z);
    }

    public static void setLimitPersonalAds(boolean z) {
        b = z;
    }

    public static void setTimeout(int i) {
        q.a().b(i);
    }

    public static void useHttps(boolean z) {
        q.a().c = z;
    }

    public static void init(Context context, String str, OctopusAdSdkController octopusAdSdkController) {
        if (f12336a == null) {
            f12336a = octopusAdSdkController;
        }
        q.a().a(context, str);
        q.a().b(str);
    }

    public static void init(Context context, String str, OctopusAdSdkController octopusAdSdkController, String str2) {
        if (f12336a == null) {
            f12336a = octopusAdSdkController;
        }
        q.a().a(context, str);
        if ("OctopusGroup".equals(str2)) {
            q.a().a(str);
        } else {
            q.a().b(str);
        }
    }
}
