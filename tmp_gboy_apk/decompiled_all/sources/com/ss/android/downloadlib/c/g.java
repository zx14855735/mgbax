package com.ss.android.downloadlib.c;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.zg;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {
    private static Object[] hf = new Object[0];
    private static Object[] w = new Object[73];
    static final char[] xj = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String u = null;

    public static Intent c(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(C.ENCODING_PCM_MU_LAW);
        return launchIntentForPackage;
    }

    public static Signature[] d(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return null;
        }
    }

    public static Signature[] f(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return null;
        }
    }

    public static boolean hf(String str) {
        return !TextUtils.isEmpty(str) && A2egSU.BPw6Q8(str);
    }

    public static boolean kd(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.pl.getContext();
        }
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static File tf(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        File file = new File(CtFAbx.B25kr6(AYUAbz.A4TApA(parentFile != null ? parentFile.getParent() : null), File.separator, str));
        com.ss.android.socialbase.downloader.w.xj.hf("ToolUtils", "getExtDir: file.toString()-->" + file.toString());
        return file;
    }

    public static Drawable u(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String w(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return A2egSU.BPw6Q8(str);
    }

    public static boolean y(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i <= packageInfo.versionCode;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    public static int hf(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        if (r3 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
    
        if (r1 > 29) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean w(java.lang.String r7) {
        /*
            android.content.Context r0 = com.ss.android.downloadlib.addownload.pl.getContext()
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            r2 = 0
            if (r1 == 0) goto Ld
            goto L89
        Ld:
            boolean r1 = kd(r0, r7)
            if (r1 != 0) goto L15
            goto L89
        L15:
            android.content.pm.ApplicationInfo r1 = r0.getApplicationInfo()
            int r1 = r1.targetSdkVersion
            org.json.JSONObject r3 = com.ss.android.downloadlib.addownload.pl.d()
            java.lang.String r4 = "get_ext_dir_mode"
            int r3 = r3.optInt(r4)
            r5 = 1
            r6 = 29
            if (r3 != 0) goto L39
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r6) goto L39
            if (r1 != r6) goto L36
            boolean r3 = DaOi9o.COJEAR.BIYEnU()
            if (r3 == 0) goto L88
        L36:
            if (r1 <= r6) goto L39
            goto L88
        L39:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L54
            if (r1 < r6) goto L56
            android.content.pm.ApplicationInfo r1 = r0.getApplicationInfo()     // Catch: java.lang.Exception -> L54
            int r1 = r1.targetSdkVersion     // Catch: java.lang.Exception -> L54
            if (r1 < r6) goto L56
            org.json.JSONObject r1 = com.ss.android.downloadlib.addownload.pl.d()     // Catch: java.lang.Exception -> L54
            int r1 = r1.optInt(r4)     // Catch: java.lang.Exception -> L54
            if (r1 != r5) goto L56
            java.io.File r1 = tf(r0, r7)     // Catch: java.lang.Exception -> L54
            goto L6d
        L54:
            r7 = move-exception
            goto L8a
        L56:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L54
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Exception -> L54
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Exception -> L54
            java.lang.String r4 = "android/data/"
            java.lang.String r6 = java.lang.String.valueOf(r7)     // Catch: java.lang.Exception -> L54
            java.lang.String r4 = r4.concat(r6)     // Catch: java.lang.Exception -> L54
            r1.<init>(r3, r4)     // Catch: java.lang.Exception -> L54
        L6d:
            boolean r3 = r1.exists()     // Catch: java.lang.Exception -> L54
            if (r3 != 0) goto L74
            goto L89
        L74:
            long r3 = com.ss.android.downloadlib.c.c.xj(r1)     // Catch: java.lang.Exception -> L54
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> L54
            android.content.pm.PackageInfo r7 = r0.getPackageInfo(r7, r2)     // Catch: java.lang.Exception -> L54
            if (r7 == 0) goto L89
            long r0 = r7.lastUpdateTime     // Catch: java.lang.Exception -> L54
            int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r7 >= 0) goto L89
        L88:
            return r5
        L89:
            return r2
        L8a:
            com.bytedance.sdk.component.utils.pl.xj(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.c.g.w(java.lang.String):boolean");
    }

    public static long xj(JSONObject jSONObject, String str) {
        return com.ss.android.download.api.w.hf.xj(jSONObject, str);
    }

    public static JSONObject xj(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.download.api.w.hf.xj(jSONObject, jSONObject2);
    }

    public static JSONObject xj(JSONObject jSONObject) {
        return com.ss.android.download.api.w.hf.xj(jSONObject);
    }

    public static JSONObject xj(JSONObject... jSONObjectArr) {
        return com.ss.android.download.api.w.hf.xj(jSONObjectArr);
    }

    public static boolean hf(com.ss.android.downloadad.api.xj.hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        return xj(hfVar.kd(), hfVar.a(), hfVar.wo()).xj();
    }

    public static boolean xj(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                if (!queryIntentActivities.isEmpty()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean hf(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.pl.getContext();
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static String xj(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j >= 1073741824) {
            return (j / 1073741824) + "G";
        }
        if (j >= BaseConstants.MB_VALUE) {
            return (j / BaseConstants.MB_VALUE) + "M";
        }
        return decimalFormat.format(j / 1048576.0f) + "M";
    }

    public static long hf(long j) {
        try {
            return xj(Environment.getExternalStorageDirectory(), j);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return j;
        }
    }

    public static boolean hf() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static HashMap<String, String> hf(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
        return hashMap;
    }

    public static PackageInfo xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        DownloadInfo downloadInfo;
        if (hfVar == null || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.pl.getContext()).getDownloadInfo(hfVar.v())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.w.xj(com.ss.android.downloadlib.addownload.pl.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable xj(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static void w() {
        ComponentName componentName;
        try {
            if (com.ss.android.downloadlib.addownload.pl.kd().xj(com.ss.android.downloadlib.addownload.pl.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.pl.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    String packageName = com.ss.android.downloadlib.addownload.pl.getContext().getPackageName();
                    componentName = runningTaskInfo.topActivity;
                    if (packageName.equals(componentName.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public static com.ss.android.downloadlib.addownload.hf.w xj(String str, int i, String str2) {
        com.ss.android.downloadlib.addownload.hf.w wVar = new com.ss.android.downloadlib.addownload.hf.w();
        if (!TextUtils.isEmpty(str)) {
            try {
                PackageInfo packageInfo = com.ss.android.downloadlib.addownload.pl.getContext().getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    wVar.hf(packageInfo.versionCode);
                    wVar.xj(com.ss.android.downloadlib.addownload.hf.w.hf);
                    zg c = com.ss.android.downloadlib.addownload.pl.c();
                    if (c != null && c.xj() && !xj(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                        wVar.xj(com.ss.android.downloadlib.addownload.hf.w.w);
                        return wVar;
                    }
                }
            } catch (Exception e) {
                com.ss.android.socialbase.downloader.w.xj.kd("ToolUtils", "getInstalledAppInfo:" + e.getMessage());
            }
        }
        return wVar;
    }

    private static boolean xj(int i, int i2, String str, String str2) {
        if (i2 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i2 > 0 && i >= i2) || xj(str, str2) >= 0;
    }

    public static boolean xj(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return xj(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).xj();
    }

    public static boolean xj(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                return false;
            }
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i == packageInfo.versionCode;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    public static boolean xj(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i = 0; i < signatureArr.length; i++) {
            Signature signature = signatureArr[i];
            if ((signature == null && signatureArr2[i] != null) || (signature != null && !signature.equals(signatureArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static int xj(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String xj(String str, int i) {
        if (i == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static int xj(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int min = Math.min(split.length, split2.length);
                int i = 0;
                int i2 = 0;
                while (i < min) {
                    i2 = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
                    if (i2 != 0) {
                        break;
                    }
                    i++;
                }
                if (i2 != 0) {
                    return i2 > 0 ? 1 : -1;
                }
                for (int i3 = i; i3 < split.length; i3++) {
                    if (Integer.parseInt(split[i3]) > 0) {
                        return 1;
                    }
                }
                while (i < split2.length) {
                    if (Integer.parseInt(split2[i]) > 0) {
                        return -1;
                    }
                    i++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String xj(String... strArr) {
        return com.ss.android.download.api.w.hf.xj(strArr);
    }

    public static <T> T xj(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    public static boolean xj() {
        try {
            if (com.ss.android.downloadlib.addownload.pl.getContext().getPackageManager().getPackageInfo(com.ss.android.downloadlib.addownload.pl.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion >= 33) {
                if (Build.VERSION.SDK_INT >= 33) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    public static long xj(File file, long j) {
        if (file != null) {
            try {
                return com.ss.android.socialbase.downloader.tf.y.u(file.getAbsolutePath());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
        return j;
    }

    public static long xj(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            return new StatFs(file.getAbsolutePath()).getTotalBytes();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return -1L;
        }
    }

    public static void xj(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }
}
