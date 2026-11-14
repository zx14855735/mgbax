package com.octopus.ad.utils.b;

import ADYaiT.CtFAbx;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.octopus.ad.internal.utilities.SPUtils;
import com.octopus.ad.utils.OctUtil;
import com.sigmob.sdk.base.views.r;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f12701a;

    public static long a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return 0L;
        }
    }

    public static String b(Context context) {
        String string = SPUtils.getString(context, "codeList");
        return string == null ? "" : string;
    }

    public static long c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return 0L;
        }
    }

    public static String d(Context context) {
        return context.getPackageName();
    }

    public static String e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String f(Context context) {
        String string = SPUtils.getString(context, "__GROUPVERSION__");
        return string == null ? "" : string;
    }

    public static int g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String h(Context context) {
        String str;
        try {
            str = (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            str = "";
        }
        return TextUtils.isEmpty(str) ? d(context) : str;
    }

    public static String i(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().widthPixels);
    }

    public static String j(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().heightPixels);
    }

    public static String k(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? "2" : "1";
    }

    public static String l(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem + "";
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
            return null;
        }
    }

    public static String m(Context context) {
        String a2 = a(context, "com.huawei.appmarket");
        return a2 == null ? "" : a2;
    }

    public static String n(Context context) {
        String a2 = a(context, "com.huawei.hwid");
        return a2 == null ? "" : a2;
    }

    public static String o(Context context) {
        if (!e()) {
            return null;
        }
        String a2 = a(context, "com.bbk.appstore");
        return a2 == null ? "" : a2;
    }

    public static String p(Context context) {
        if (!e()) {
            return null;
        }
        String a2 = a(context, "com.vivo.browser");
        return a2 == null ? "" : a2;
    }

    public static String q(Context context) {
        if (!e()) {
            return null;
        }
        String a2 = a(context, "com.kaixinkan.ugc.video.atom");
        return a2 == null ? "" : a2;
    }

    public static String r(Context context) {
        if (!e()) {
            return null;
        }
        String a2 = a(context, "com.vivo.minigamecenter");
        return a2 == null ? "" : a2;
    }

    public static String s(Context context) {
        if (!e()) {
            return null;
        }
        String a2 = a(context, "com.android.bbkmusic");
        return a2 == null ? "" : a2;
    }

    public static void t(Context context) {
        try {
            if (f12701a == null) {
                f12701a = new ArrayList();
                if (context == null) {
                    return;
                }
                String info = OctUtil.a().getInfo(context, 1002);
                if (TextUtils.isEmpty(info)) {
                    return;
                }
                try {
                    JSONArray jSONArray = new JSONArray(new String(a(Base64.decode(info, 0), "Ots0kza9lq")));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        f12701a.add(jSONArray.getString(i));
                    }
                } catch (Exception e) {
                    f.a("OctopusAd", "An Exception Caught", e);
                }
            }
        } catch (Throwable th) {
            f.a("OctopusAd", "An Exception Caught", th);
        }
    }

    public static boolean u(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
    }

    public static boolean d(Context context, String str) {
        List<String> list;
        t(context);
        if (TextUtils.isEmpty(str) || (list = f12701a) == null) {
            return false;
        }
        return list.contains(str);
    }

    private static String g() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.vivo.os.name").getInputStream()), 1024);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
                return readLine;
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
                return readLine;
            }
        } catch (Exception unused2) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e2) {
                    f.a("OctopusAd", "An Exception Caught", e2);
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e3) {
                    f.a("OctopusAd", "An Exception Caught", e3);
                }
            }
            throw th;
        }
    }

    public static String b() {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            return (statFs.getBlockCount() * blockSize) + "";
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
            return null;
        }
    }

    public static boolean e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        List<String> list = f12701a;
        if (list != null && !list.isEmpty()) {
            return f12701a.contains(str);
        }
        if (a(str)) {
            return true;
        }
        return c(context, str);
    }

    public static boolean f() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if ("tun0".equals(nextElement.getName()) || "ppp0".equals(nextElement.getName())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return false;
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
            return false;
        }
    }

    public static String a() {
        if (A2egSU.BPw6Q8("/system/bin/su") && c("/system/bin/su")) {
            return "yes";
        }
        if (A2egSU.BPw6Q8("/system/xbin/su") && c("/system/xbin/su")) {
            return "yes";
        }
        return "no";
    }

    private static boolean c(String str) {
        Process process = null;
        try {
            try {
                process = Runtime.getRuntime().exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        process.destroy();
                        return true;
                    }
                }
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
                if (process == null) {
                    return false;
                }
            }
            process.destroy();
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    public static String d() {
        if (!e()) {
            return null;
        }
        return g() + h();
    }

    private static String h() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.vivo.os.version").getInputStream()), 1024);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
                return readLine;
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
                return readLine;
            }
        } catch (Exception unused2) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e2) {
                    f.a("OctopusAd", "An Exception Caught", e2);
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e3) {
                    f.a("OctopusAd", "An Exception Caught", e3);
                }
            }
            throw th;
        }
    }

    public static boolean e() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith("vivo");
    }

    public static PackageInfo b(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, r.b.d);
                }
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
            }
        }
        return null;
    }

    public static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static long c() {
        return System.currentTimeMillis() / 1000;
    }

    public static boolean c(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || str == null || str.isEmpty()) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static String a(Context context, String str) {
        try {
            PackageInfo b = b(context, str);
            if (b == null) {
                return null;
            }
            return String.valueOf(b.versionCode);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(CtFAbx.BChYOn("data/data/", str)).exists();
    }

    public static byte[] a(byte[] bArr, String str) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ str.charAt(i % str.length()));
        }
        return bArr2;
    }
}
