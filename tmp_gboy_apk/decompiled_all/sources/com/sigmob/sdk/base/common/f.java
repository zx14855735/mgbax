package com.sigmob.sdk.base.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.czhj.sdk.common.mta.PointEntitySuper;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.AppInfo;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.downloader.f;
import com.sigmob.windad.WindAdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f13127a;

    public static String[] a() {
        Context e = com.sigmob.sdk.b.e();
        if (e == null) {
            return null;
        }
        try {
            return e.getPackageManager().getPackageInfo(e.getPackageName(), f.a.c).requestedPermissions;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static WindAdError b() {
        Context e = com.sigmob.sdk.b.e();
        try {
            SigmobLog.d("checkActivity: ".concat(AdActivity.class.getName()));
            e.getPackageManager().getActivityInfo(new ComponentName(e, (Class<?>) AdActivity.class), r.b.d);
        } catch (PackageManager.NameNotFoundException e2) {
            SigmobLog.e("checkActivity: " + e2.getMessage());
            return WindAdError.ERROR_LOAD_FILTER_FOR_ACTIVITY_ERROR;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (!Ad.class.getName().endsWith("base.models.rtb.Ad")) {
                SigmobLog.e("checkProguard Ad: ".concat(Ad.class.getName()));
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (!MaterialMeta.class.getName().endsWith("base.models.rtb.MaterialMeta")) {
                SigmobLog.e("checkProguard Strategy: ".concat(MaterialMeta.class.getName()));
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (!AppInfo.class.getName().endsWith("base.models.AppInfo")) {
                SigmobLog.e("checkProguard AppInfo: ".concat(AppInfo.class.getName()));
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (PointEntitySuper.class.getName().endsWith("common.mta.PointEntitySuper")) {
                return null;
            }
            SigmobLog.e("checkProguard PointCategory: ".concat(PointEntitySuper.class.getName()));
            return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
        } catch (Throwable th2) {
            com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th2, new StringBuilder("checkProguard: "));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0093, code lost:
    
        r4 = r1.getPackageManager().getProviderInfo(new android.content.ComponentName(r1, r8.name), com.sigmob.sdk.base.views.r.b.d).metaData;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a6, code lost:
    
        if (r4 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
    
        r4 = r4.getInt("android.support.FILE_PROVIDER_PATHS");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized boolean c() {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.f.c():boolean");
    }

    public static boolean d() {
        String[] a2 = a();
        if (a2 == null) {
            return false;
        }
        for (String str : a2) {
            if (str.equals("android.permission.QUERY_ALL_PACKAGES")) {
                return true;
            }
        }
        return false;
    }
}
