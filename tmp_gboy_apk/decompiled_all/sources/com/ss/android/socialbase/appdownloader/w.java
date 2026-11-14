package com.ss.android.socialbase.appdownloader;

import ADYaiT.CtFAbx;
import JMFfuZ.A2egSU;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.utils.pl;
import com.game.boy.activity.ADYaiT;
import com.sigmob.sdk.downloader.f;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.w.p;
import com.ss.android.socialbase.appdownloader.w.tf;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w {
    private static NotificationChannel hf;
    private static int xj;

    /* JADX INFO: Access modifiers changed from: private */
    public static int u(Context context, int i, boolean z) {
        if (com.ss.android.socialbase.downloader.f.xj.xj(i).hf("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.hf.xj().y(i);
        }
        xj((Activity) f.xj().hf());
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("install_queue_enable", 0) == 1 ? f.xj().xj(context, i, z) : hf(context, i, z);
    }

    public static String hf(long j) {
        long[] jArr = {1099511627776L, 1073741824, BaseConstants.MB_VALUE, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return xj(j, j2, strArr[i]);
            }
        }
        return null;
    }

    public static boolean w(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return hf(context, downloadInfo, xj(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    private static String xj(long j, long j2, String str, boolean z) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d) + " " + str;
        }
        return new DecimalFormat("#").format(d) + " " + str;
    }

    public static boolean w(String str) {
        return !TextUtils.isEmpty(str) && str.equals(AdBaseConstants.MIME_APK);
    }

    public static String xj(long j) {
        return xj(j, true);
    }

    public static List<String> w() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(AdBaseConstants.MIME_APK);
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static String xj(long j, boolean z) {
        long[] jArr = {1099511627776L, 1073741824, BaseConstants.MB_VALUE, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return xj(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    public static int hf(final Context context, final int i, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.w.hf(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.w.2
                    @Override // java.lang.Runnable
                    public void run() {
                        u.p().pl();
                        int xj2 = w.xj(context, i, z, downloadInfo, file);
                        if (xj2 == 1 && u.p().yo() != null) {
                            u.p().yo().xj(downloadInfo, null);
                        }
                        w.hf(downloadInfo, z, xj2);
                    }
                });
                return 1;
            }
        }
        hf(downloadInfo, z, 2);
        return 2;
    }

    private static JSONObject u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String xj(long j, long j2, String str) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d) + str;
        }
        return new DecimalFormat("#.##").format(d) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e) {
            pl.xj(e);
        }
        com.ss.android.socialbase.downloader.downloader.w.yy().xj(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    public static int xj(final Context context, final int i, final boolean z) {
        p f = u.p().f();
        if (f == null) {
            return u(context, i, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        xj = 1;
        f.xj(downloadInfo, new tf() { // from class: com.ss.android.socialbase.appdownloader.w.1
            @Override // com.ss.android.socialbase.appdownloader.w.tf
            public void xj() {
                int unused = w.xj = w.u(context, i, z);
            }
        });
        return xj;
    }

    public static boolean hf(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return xj(context, downloadInfo, packageInfo, false);
    }

    public static int hf(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo xj2 = xj(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (xj2 != null) {
                    int i = xj2.versionCode;
                    downloadInfo.setAppVersionCode(i);
                    return i;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static int xj(Context context, int i, boolean z, DownloadInfo downloadInfo, File file) {
        Process process;
        PackageInfo packageInfo;
        Intent xj2;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                process = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
                try {
                    process.waitFor();
                } catch (Throwable th) {
                    th = th;
                    try {
                        pl.xj(th);
                    } finally {
                        if (process != null) {
                            process.destroy();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                process = null;
            }
        }
        try {
            packageInfo = xj(downloadInfo, file);
            if (packageInfo != null) {
                try {
                    downloadInfo.setFilePackageName(packageInfo.packageName);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            th = null;
        } catch (Throwable th4) {
            th = th4;
            packageInfo = null;
        }
        if (u.p().u() != null) {
            if (packageInfo == null) {
                BaseException baseException = new BaseException(2001, th);
                u.p().u().xj(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                u.p().u().xj(downloadInfo, null, 11);
            }
        }
        if (xj(context, downloadInfo, packageInfo)) {
            return 2;
        }
        if (packageInfo != null && com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfo.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfo.versionCode));
        }
        int[] iArr = new int[1];
        if (hf(context, downloadInfo, packageInfo)) {
            xj2 = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
        } else {
            if (!z && xj(context, i, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            }
            xj2 = xj(context, downloadInfo, file, z, iArr);
        }
        if (xj2 == null) {
            return iArr[0] == 1 ? 2 : 0;
        }
        xj2.addFlags(C.ENCODING_PCM_MU_LAW);
        if (downloadInfo.getLinkMode() > 0 && com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("app_install_return_result", 0) == 1) {
            xj2.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 && hf.xj(context, downloadInfo, xj2, z)) {
            return 1;
        }
        return xj(context, xj2);
    }

    public static String hf() {
        return com.ss.android.socialbase.downloader.tf.y.kd();
    }

    public static boolean hf(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            pl.xj(e);
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(26)
    public static String hf(Context context) {
        try {
            if (hf == null) {
                A2egSU.AaHO0E();
                NotificationChannel BmvVmW2 = ADYaiT.BmvVmW();
                hf = BmvVmW2;
                BmvVmW2.setSound(null, null);
                hf.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(hf);
                return "111111";
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        return "111111";
    }

    public static int xj(Context context, Intent intent) {
        try {
            if (u.p().e() != null) {
                if (u.p().e().xj(intent)) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean xj(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.w.kd w = u.p().w();
        if (w != null) {
            w.xj(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (w.xj()) {
                return true;
            }
        }
        io downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.xj(8, downloadInfo, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.w.u hf2 = u.p().hf();
        return (hf2 instanceof com.ss.android.socialbase.appdownloader.w.xj) && ((com.ss.android.socialbase.appdownloader.w.xj) hf2).hf();
    }

    public static boolean xj(Context context, int i, File file) {
        if (com.ss.android.socialbase.downloader.f.xj.xj(i).xj("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.y.kd.g() || com.ss.android.socialbase.appdownloader.y.kd.am()) && com.ss.android.socialbase.downloader.tf.tf.xj(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        return false;
    }

    public static int xj() {
        if (u.p().c()) {
            return f.a.d;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.net.Uri xj(int r1, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.getUriForFile(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.u r2 = com.ss.android.socialbase.appdownloader.u.p()
            com.ss.android.socialbase.appdownloader.w.c r2 = r2.y()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.xj(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L3c
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L32
            r0 = 24
            if (r2 < r0) goto L34
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L34
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L32
            goto L3c
        L32:
            r2 = move-exception
            goto L39
        L34:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L32
            goto L3c
        L39:
            com.bytedance.sdk.component.utils.pl.xj(r2)
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.w.xj(int, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent xj(Context context, DownloadInfo downloadInfo, File file, boolean z, int[] iArr) {
        Uri xj2 = xj(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, u.p().kd(), file);
        if (xj2 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(xj2, AdBaseConstants.MIME_APK);
        com.ss.android.socialbase.appdownloader.w.kd w = u.p().w();
        int xj3 = w != null ? w.xj(downloadInfo.getId(), z) : 0;
        io downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        int i = xj3;
        if (downloadNotificationEventListener != null) {
            i = downloadNotificationEventListener.xj(z);
        }
        iArr[0] = i;
        if (i != 0) {
            return null;
        }
        return intent;
    }

    public static boolean xj(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && xj(com.ss.android.socialbase.downloader.downloader.w.tj(), downloadInfo, str);
        }
        return true;
    }

    public static boolean xj(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                pl.u("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo xj2 = xj(downloadInfo, file);
                if (xj2 == null || !xj2.packageName.equals(str)) {
                    return false;
                }
                int i = xj2.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, xj());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("install_callback_error")) {
                    return false;
                }
                String xj3 = com.ss.android.socialbase.downloader.tf.y.xj(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                int xj4 = com.ss.android.socialbase.downloader.tf.y.xj(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (xj3 == null || TextUtils.isEmpty(xj3) || !xj3.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, xj());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || xj4 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            pl.xj(e);
            return false;
        }
    }

    public static boolean xj(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, xj());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        return z ? i < i2 : (downloadInfo == null || com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("install_with_same_version_code", 0) != 1) ? i <= i2 : i < i2;
    }

    public static boolean xj(Context context, DownloadInfo downloadInfo) {
        return xj(context, downloadInfo, true);
    }

    public static boolean xj(Context context, DownloadInfo downloadInfo, boolean z) {
        PackageInfo packageInfo;
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z) {
            return w(context, downloadInfo);
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, xj());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        return com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    public static PackageInfo xj(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        pl.u("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return xj(downloadInfo, file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String xj(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r0 = "default.apk"
            java.lang.String r2 = ".."
            if (r6 == 0) goto L34
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L5a
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = r4.contains(r2)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            goto L5a
        L32:
            r4 = r0
            goto L5a
        L34:
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L4c
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L4c
            java.lang.String r1 = r3.getLastPathSegment()
        L4c:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L59
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L32
            goto L5a
        L59:
            r4 = r1
        L5a:
            boolean r3 = w(r5)
            if (r3 == 0) goto L6d
            java.lang.String r3 = ".apk"
            boolean r5 = r4.endsWith(r3)
            if (r5 != 0) goto L6d
            java.lang.String r3 = r4.concat(r3)
            return r3
        L6d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.w.xj(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static String xj(String str, com.ss.android.socialbase.downloader.f.xj xjVar) {
        JSONObject u;
        if (xjVar != null && (u = xjVar.u("download_dir")) != null) {
            String optString = u.optString("dir_name");
            if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
                optString = optString.substring(1);
            }
            if (TextUtils.isEmpty(optString)) {
                return optString;
            }
            if (!optString.contains("%s")) {
                optString = CtFAbx.AcNBzu(optString, str);
            } else {
                try {
                    optString = String.format(optString, str);
                } catch (Throwable unused) {
                }
            }
            return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
        }
        return "";
    }

    public static boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e) {
            pl.xj(e);
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static int xj(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i) || i == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i) ? 3 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        if (r4 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean xj(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            int r1 = com.ss.android.socialbase.appdownloader.kd.hf()     // Catch: java.lang.Throwable -> L35
            android.content.res.Resources r2 = r4.getResources()     // Catch: java.lang.Throwable -> L35
            int r1 = r2.getColor(r1)     // Catch: java.lang.Throwable -> L35
            int r2 = com.ss.android.socialbase.appdownloader.kd.w()     // Catch: java.lang.Throwable -> L35
            int r3 = com.ss.android.socialbase.appdownloader.kd.u()     // Catch: java.lang.Throwable -> L35
            int[] r2 = new int[]{r2, r3}     // Catch: java.lang.Throwable -> L35
            int r3 = com.ss.android.socialbase.appdownloader.kd.kd()     // Catch: java.lang.Throwable -> L35
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r3, r2)     // Catch: java.lang.Throwable -> L35
            int r2 = r4.getColor(r0, r0)     // Catch: java.lang.Throwable -> L33
            if (r1 != r2) goto L2f
            r4.recycle()     // Catch: java.lang.Throwable -> L2d
        L2d:
            r4 = 1
            return r4
        L2f:
            r4.recycle()     // Catch: java.lang.Throwable -> L39
            goto L39
        L33:
            goto L36
        L35:
            r4 = 0
        L36:
            if (r4 == 0) goto L39
            goto L2f
        L39:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.w.xj(android.content.Context):boolean");
    }

    public static void xj(DownloadInfo downloadInfo, boolean z, boolean z2) {
        u.p().xj(new y(com.ss.android.socialbase.downloader.downloader.w.tj(), downloadInfo.getUrl()).xj(downloadInfo.getTitle()).hf(downloadInfo.getName()).w(downloadInfo.getSavePath()).xj(downloadInfo.isShowNotification()).hf(downloadInfo.isAutoInstallWithoutNotification()).w(downloadInfo.isOnlyWifi() || z2).kd(downloadInfo.getExtra()).y(downloadInfo.getMimeType()).xj(downloadInfo.getExtraHeaders()).kd(true).hf(downloadInfo.getRetryCount()).w(downloadInfo.getBackUpUrlRetryCount()).hf(downloadInfo.getBackUpUrls()).u(downloadInfo.getMinProgressTimeMsInterval()).kd(downloadInfo.getMaxProgressCount()).y(z).u(downloadInfo.isNeedHttpsToHttpRetry()).c(downloadInfo.getPackageName()).f(downloadInfo.getMd5()).xj(downloadInfo.getExpectFileLength()).d(downloadInfo.isNeedDefaultHttpServiceBackUp()).tf(downloadInfo.isNeedReuseFirstConnection()).pl(downloadInfo.isNeedIndependentProcess()).xj(downloadInfo.getEnqueueType()).am(downloadInfo.isForce()).g(downloadInfo.isHeadConnectionAvailable()).c(downloadInfo.isNeedRetryDelay()).d(downloadInfo.getRetryDelayTimeArray()).xj(u(downloadInfo.getDownloadSettingString())).p(downloadInfo.getIconUrl()).y(downloadInfo.getExecutorGroup()).zg(downloadInfo.isAutoInstall()));
    }

    public static void xj(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e) {
                pl.xj(e);
            }
        }
    }

    public static PackageInfo xj(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.y.xj.kd.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), file, xj());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo xj2 = com.ss.android.socialbase.appdownloader.y.xj.kd.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), file, xj());
        downloadInfo.setPackageInfo(xj2);
        return xj2;
    }

    public static int xj(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
