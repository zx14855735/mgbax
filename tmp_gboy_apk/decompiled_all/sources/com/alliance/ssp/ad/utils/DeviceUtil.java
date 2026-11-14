package com.alliance.ssp.ad.utils;

import A5SV6n.A2egSU;
import ADYaiT.CtFAbx;
import GJee0v.AZOQYO;
import JrXYwF.A4TApA;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.content.FileProvider;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DeviceUtil {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static String f9708A2egSU = "";

    /* renamed from: A4TApA, reason: collision with root package name */
    public static String f9709A4TApA = "";

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static String f9710A5SV6n = "";

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static String f9711ADYaiT = "";
    public static String AMqCpz = "";

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static String f9712ARc23Z = "";

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static String f9713ASJ6gh = "";

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static String f9714AYUAbz = "";

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static String f9715AZOQYO = "";

    /* renamed from: AZkASS, reason: collision with root package name */
    public static String f9716AZkASS = "";

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static String f9717AaHO0E = "";

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static String f9718AcNBzu = "";

    public static String A2egSU(Context context) {
        String str = new String[]{f9717AaHO0E}[0];
        if (str != null && !str.isEmpty()) {
            return f9717AaHO0E;
        }
        if (context == null) {
            return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
        }
        String packageName = context.getPackageName();
        f9717AaHO0E = packageName;
        return packageName;
    }

    public static String A4TApA(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo(str, 0) : null;
            if (packageInfo == null) {
                return null;
            }
            return String.valueOf(packageInfo.versionCode);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void A5SV6n(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || context == null) {
            return;
        }
        File file = new File(str, str2);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".NMSSPFileProvider", file), AdBaseConstants.MIME_APK);
        } else {
            intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
        }
        context.startActivity(intent);
    }

    public static boolean ADYaiT(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static String AMqCpz(Context context) {
        String str;
        PackageInfo packageInfo;
        PackageInfo packageInfo2;
        PackageInfo packageInfo3;
        String str2 = f9714AYUAbz;
        if (str2 != null && !str2.isEmpty()) {
            return f9714AYUAbz;
        }
        if (context == null || (str = Build.MANUFACTURER) == null || str.isEmpty()) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if ((str.toLowerCase().contains("huawei") || str.toLowerCase().contains("wiko") || str.toLowerCase().contains("cmdc")) && (packageInfo = packageManager.getPackageInfo("com.huawei.appmarket", 0)) != null) {
                f9714AYUAbz = packageInfo.versionName;
            }
            if (str.toLowerCase().contains("honor") && (packageInfo3 = packageManager.getPackageInfo("com.hihonor.appmarket", 0)) != null) {
                f9714AYUAbz = packageInfo3.versionName;
            }
            if ((str.toLowerCase().contains(MediationConstant.ADN_XIAOMI) || str.toLowerCase().contains("redmi")) && (packageInfo2 = packageManager.getPackageInfo("com.xiaomi.market", 0)) != null) {
                f9714AYUAbz = packageInfo2.versionName;
            }
            if (str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme")) {
                PackageInfo packageInfo4 = packageManager.getPackageInfo("com.heytap.market", 0);
                if (packageInfo4 == null) {
                    packageInfo4 = packageManager.getPackageInfo("com.oppo.market", 0);
                }
                if (packageInfo4 != null) {
                    f9714AYUAbz = "" + packageInfo4.versionCode;
                }
            }
            if (str.toLowerCase().contains("vivo")) {
                PackageInfo packageInfo5 = packageManager.getPackageInfo("com.bbk.appstore", 0);
                if (packageInfo5 == null && (packageInfo5 = packageManager.getPackageInfo("com.heytap.market", 0)) == null) {
                    packageInfo5 = packageManager.getPackageInfo("com.oppo.market", 0);
                }
                if (packageInfo5 != null) {
                    f9714AYUAbz = "" + packageInfo5.versionCode;
                }
            }
            if (str.toLowerCase().contains("oneplus")) {
                PackageInfo packageInfo6 = packageManager.getPackageInfo("com.oneplus.market", 0);
                if (packageInfo6 == null && (packageInfo6 = packageManager.getPackageInfo("com.heytap.market", 0)) == null) {
                    packageInfo6 = packageManager.getPackageInfo("com.oppo.market", 0);
                }
                if (packageInfo6 != null) {
                    f9714AYUAbz = "" + packageInfo6.versionCode;
                }
            }
        } catch (Exception e) {
            e.getMessage();
            int i = AZOQYO.f3039AcNBzu;
        }
        return f9714AYUAbz;
    }

    public static String ARc23Z(Context context) {
        try {
            String str = f9709A4TApA;
            if (str != null && str.length() > 0) {
                return f9709A4TApA;
            }
            if (context == null) {
                f9709A4TApA = "null";
                return "";
            }
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str2 = packageInfo != null ? packageInfo.versionName : "";
            f9709A4TApA = str2;
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        r6 = new java.io.BufferedReader(new java.io.InputStreamReader(r3.getInputStream(r2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        r2 = r6.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
    
        if (r2 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        r1.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        r6.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0074 -> B:30:0x0077). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String ASJ6gh(android.content.Context r6) {
        /*
            java.lang.String r0 = com.alliance.ssp.ad.utils.DeviceUtil.f9713ASJ6gh
            if (r0 == 0) goto Ld
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Ld
            java.lang.String r6 = com.alliance.ssp.ad.utils.DeviceUtil.f9713ASJ6gh
            return r6
        Ld:
            java.lang.String r0 = "dev"
            if (r6 != 0) goto L14
            com.alliance.ssp.ad.utils.DeviceUtil.f9713ASJ6gh = r0
            return r0
        L14:
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo()
            java.lang.String r6 = r6.sourceDir
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 0
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L6a
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L6a
            java.util.Enumeration r6 = r3.entries()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
        L29:
            boolean r2 = r6.hasMoreElements()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            if (r2 == 0) goto L60
            java.lang.Object r2 = r6.nextElement()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.lang.String r4 = r2.getName()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.lang.String r5 = "META-INF/config_channel.txt"
            boolean r4 = r5.equals(r4)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            if (r4 == 0) goto L29
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.io.InputStream r2 = r3.getInputStream(r2)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
        L4f:
            java.lang.String r2 = r6.readLine()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            if (r2 == 0) goto L5d
            r1.append(r2)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            goto L4f
        L59:
            r6 = move-exception
            goto L9b
        L5b:
            r6 = move-exception
            goto L66
        L5d:
            r6.close()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
        L60:
            r3.close()     // Catch: java.io.IOException -> L64
            goto L77
        L64:
            r6 = move-exception
            goto L74
        L66:
            r2 = r3
            goto L6b
        L68:
            r6 = move-exception
            goto L9a
        L6a:
            r6 = move-exception
        L6b:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L68
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.io.IOException -> L64
            goto L77
        L74:
            r6.printStackTrace()
        L77:
            java.lang.String r6 = r1.toString()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L97
            com.google.gson.Gson r6 = new com.google.gson.Gson
            r6.<init>()
            java.lang.String r0 = r1.toString()
            java.lang.Class<com.alliance.ssp.ad.utils.ChannelEntity> r1 = com.alliance.ssp.ad.utils.ChannelEntity.class
            java.lang.Object r6 = r6.fromJson(r0, r1)
            com.alliance.ssp.ad.utils.ChannelEntity r6 = (com.alliance.ssp.ad.utils.ChannelEntity) r6
            java.lang.String r6 = r6.CHANNEL_ID
            com.alliance.ssp.ad.utils.DeviceUtil.f9713ASJ6gh = r6
            return r6
        L97:
            com.alliance.ssp.ad.utils.DeviceUtil.f9713ASJ6gh = r0
            return r0
        L9a:
            r3 = r2
        L9b:
            if (r3 == 0) goto La5
            r3.close()     // Catch: java.io.IOException -> La1
            goto La5
        La1:
            r0 = move-exception
            r0.printStackTrace()
        La5:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.utils.DeviceUtil.ASJ6gh(android.content.Context):java.lang.String");
    }

    public static String AYUAbz() {
        return "3.14.9";
    }

    public static String AZOQYO(Context context) {
        String str = f9711ADYaiT;
        if (str != null && !str.isEmpty()) {
            return f9711ADYaiT;
        }
        if (context == null) {
            return f9711ADYaiT;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("adalliancesdk", 0);
        String string = sharedPreferences.getString("cookieid", "");
        f9711ADYaiT = string;
        if (string == null || string.isEmpty()) {
            String replace = UUID.randomUUID().toString().replace("-", "");
            StringBuilder AMqCpz2 = A4TApA.AMqCpz("");
            AMqCpz2.append(System.currentTimeMillis());
            f9711ADYaiT = CtFAbx.AlLFFp(replace, "_", AMqCpz2.toString());
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("cookieid", f9711ADYaiT);
            edit.apply();
        }
        String str2 = f9711ADYaiT;
        int i = AZOQYO.f3039AcNBzu;
        return str2;
    }

    public static String AZkASS(Context context) {
        String str = new String[]{f9718AcNBzu}[0];
        if (str != null && !str.isEmpty()) {
            return f9718AcNBzu;
        }
        if (context == null) {
            return "";
        }
        try {
            f9718AcNBzu = Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
        } catch (Exception unused) {
        }
        return f9718AcNBzu;
    }

    public static String AaHO0E(Context context) {
        String str = f9716AZkASS;
        if (str != null && !str.isEmpty()) {
            return f9716AZkASS;
        }
        if (context == null) {
            return "";
        }
        String A4TApA2 = A4TApA(context, "com.huawei.appmarket");
        f9716AZkASS = A4TApA2;
        return A4TApA2;
    }

    public static String AcNBzu(Context context) {
        String str = f9715AZOQYO;
        if (str != null && !str.isEmpty()) {
            return f9715AZOQYO;
        }
        if (context == null) {
            return "";
        }
        String A4TApA2 = A4TApA(context, "com.huawei.hwid");
        f9715AZOQYO = A4TApA2;
        return A4TApA2;
    }

    public static String AlLFFp(Context context) {
        String str = f9712ARc23Z;
        if (str != null && !str.isEmpty()) {
            return f9712ARc23Z;
        }
        if (context == null) {
            return f9712ARc23Z;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("adalliancesdk", 0);
        String string = sharedPreferences.getString("onetime", "");
        f9712ARc23Z = string;
        if (string == null || string.isEmpty()) {
            StringBuilder AMqCpz2 = A4TApA.AMqCpz("");
            AMqCpz2.append(System.currentTimeMillis());
            f9712ARc23Z = AMqCpz2.toString();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("onetime", f9712ARc23Z);
            edit.apply();
        }
        String str2 = f9712ARc23Z;
        int i = AZOQYO.f3039AcNBzu;
        return str2;
    }

    public static String AmA8tU(Context context) {
        try {
            String str = f9710A5SV6n;
            if (str != null && str.length() > 0) {
                return f9710A5SV6n;
            }
            if (context == null) {
                return f9710A5SV6n;
            }
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            f9710A5SV6n = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean AzWtSf(Activity activity) {
        int i;
        try {
            i = activity.getResources().getConfiguration().orientation;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i == 2 || i != 1;
    }

    public static int B25kr6(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            long parseLong = Long.parseLong(AlLFFp(context));
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(parseLong);
            Calendar calendar2 = Calendar.getInstance();
            if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2)) {
                if (calendar.get(5) == calendar2.get(5)) {
                    return 1;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @A2egSU
    public static String getLgid() {
        String str = AMqCpz;
        if (str != null && !str.isEmpty()) {
            return AMqCpz;
        }
        String replace = UUID.randomUUID().toString().replace("-", "");
        AMqCpz = replace;
        int i = AZOQYO.f3039AcNBzu;
        return replace;
    }
}
