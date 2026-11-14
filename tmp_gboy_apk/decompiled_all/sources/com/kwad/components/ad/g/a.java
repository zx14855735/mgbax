package com.kwad.components.ad.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.y;
import com.sigmob.sdk.base.views.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static Map<String, AppPackageInfo> P(Context context) {
        ActivityInfo activityInfo;
        HashMap hashMap = new HashMap();
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            if (bc.readInstalledPackagesDisable()) {
                try {
                    List<String> devInstalledPackages = bc.getDevInstalledPackages();
                    if (devInstalledPackages != null && !devInstalledPackages.isEmpty()) {
                        Iterator it = new ArrayList(devInstalledPackages).iterator();
                        while (it.hasNext()) {
                            try {
                                PackageInfo packageInfo = y.getPackageInfo(context, (String) it.next(), 0);
                                if (packageInfo != null) {
                                    AppPackageInfo a2 = a(packageInfo, packageManager);
                                    a2.reportMethod = 3;
                                    hashMap.put(a2.packageName, a2);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            } else {
                h hVar = (h) ServiceProvider.get(h.class);
                if (hVar != null && s.RL()) {
                    try {
                        List<String> eo = br.eo(context);
                        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                        intent.addCategory("android.intent.category.LAUNCHER");
                        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                            if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && !TextUtils.isEmpty(activityInfo.packageName)) {
                                String str = resolveInfo.activityInfo.packageName;
                                if (eo != null && !eo.isEmpty()) {
                                    eo.remove(str);
                                }
                                PackageInfo packageInfo2 = y.getPackageInfo(context, str, 0);
                                if (packageInfo2 != null) {
                                    AppPackageInfo a3 = a(packageInfo2, packageManager);
                                    a3.reportMethod = 1;
                                    hashMap.put(a3.packageName, a3);
                                }
                            }
                        }
                        if (eo != null && !eo.isEmpty()) {
                            Iterator<String> it2 = eo.iterator();
                            while (it2.hasNext()) {
                                try {
                                    PackageInfo packageInfo3 = y.getPackageInfo(context, it2.next(), 0);
                                    if (packageInfo3 != null) {
                                        AppPackageInfo a4 = a(packageInfo3, packageManager);
                                        a4.reportMethod = 2;
                                        hashMap.put(a4.packageName, a4);
                                    }
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    } catch (Exception unused4) {
                    }
                    hashMap.putAll(c(context, hVar.Dk()));
                }
            }
        }
        return hashMap;
    }

    public static AppPackageInfo a(PackageInfo packageInfo, PackageManager packageManager) {
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = packageInfo.packageName;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo != null) {
            appPackageInfo.isSystemApp = a(applicationInfo) || b(packageInfo.applicationInfo);
        }
        appPackageInfo.versionName = packageInfo.versionName;
        appPackageInfo.firstInstallTime = packageInfo.firstInstallTime;
        appPackageInfo.lastUpdateTime = packageInfo.lastUpdateTime;
        if (packageManager != null && packageInfo.applicationInfo != null && as.as(ServiceProvider.getContext(), packageInfo.packageName)) {
            try {
                appPackageInfo.appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                return appPackageInfo;
            } catch (Throwable th) {
                c.printStackTraceOnly(th);
            }
        }
        return appPackageInfo;
    }

    public static JSONArray[] b(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        h hVar = (h) ServiceProvider.get(h.class);
        if (context != null && list != null && !list.isEmpty() && hVar != null && s.RL()) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (String str : list) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = y.getPackageInfo(context, str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo a2 = a(packageInfo, packageManager);
                        hashMap.put(a2.packageName, a2);
                    } else {
                        AppPackageInfo appPackageInfo = new AppPackageInfo();
                        appPackageInfo.packageName = str;
                        hashMap2.put(str, appPackageInfo);
                    }
                } catch (Exception unused) {
                    AppPackageInfo appPackageInfo2 = new AppPackageInfo();
                    appPackageInfo2.packageName = str;
                    hashMap2.put(str, appPackageInfo2);
                }
            }
            jSONArrayArr[0] = c(hashMap);
            jSONArrayArr[1] = c(hashMap2);
        }
        return jSONArrayArr;
    }

    private static Map<String, AppPackageInfo> c(Context context, List<String> list) {
        HashMap hashMap = new HashMap();
        if (context != null && list != null) {
            for (String str : list) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = y.getPackageInfo(context, str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo a2 = a(packageInfo, packageManager);
                        hashMap.put(a2.packageName, a2);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return hashMap;
    }

    public static JSONArray c(Map<String, AppPackageInfo> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                AppPackageInfo appPackageInfo = map.get(it.next());
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    aa.a(jSONArray, a(appPackageInfo));
                }
            }
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return jSONArray;
    }

    public static void a(final Context context, final com.kwad.sdk.g.a<JSONArray> aVar) {
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.ad.g.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                aVar.accept(a.c(a.P(context)));
            }
        });
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "pkgName", appPackageInfo.packageName);
        aa.putValue(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        aa.putValue(jSONObject, "appVersion", appPackageInfo.versionName);
        aa.putValue(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        aa.putValue(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        aa.putValue(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        aa.putValue(jSONObject, "appName", appPackageInfo.appName);
        return jSONObject;
    }

    private static boolean b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & r.b.d) != 0;
    }

    private static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }
}
