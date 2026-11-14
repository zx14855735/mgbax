package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.sigmob.sdk.downloader.f;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class y {
    private static long mLastCallTime;
    private static long packageInfoLimiter;
    private static HashMap<String, PackageInfo> sPackageInfoHashMap;
    public static String[] requestedPermissions = new String[0];
    public static AtomicBoolean mHasInit = new AtomicBoolean(false);

    static {
        ystynx();
    }

    public static boolean cV(Context context) {
        boolean canRequestPackageInstalls;
        try {
            init(context);
            canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
            return canRequestPackageInstalls;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    public static String[] cW(Context context) {
        String[] strArr = requestedPermissions;
        if (strArr != null && strArr.length > 0) {
            return strArr;
        }
        try {
            PackageInfo packageInfo = getPackageInfo(context, context.getPackageName(), f.a.c);
            if (packageInfo == null) {
                return null;
            }
            String[] strArr2 = packageInfo.requestedPermissions;
            requestedPermissions = strArr2;
            return strArr2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static PackageInfo getPackageInfo(Context context, String str, int i) {
        HashMap<String, PackageInfo> hashMap;
        PackageInfo packageInfo;
        try {
            init(context);
            hashMap = sPackageInfoHashMap;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        if (hashMap != null && hashMap.containsKey(str)) {
            return sPackageInfoHashMap.get(str);
        }
        if (!shouldCall()) {
            com.kwad.sdk.core.d.c.d("PackageInfoLimiter", "调用频次过高，跳过本次调用");
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, i);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        HashMap<String, PackageInfo> hashMap2 = sPackageInfoHashMap;
        if (hashMap2 != null) {
            hashMap2.put(str, packageInfo);
        }
        return packageInfo;
    }

    public static PackageInfo getPackageInfoNoCache(Context context, String str, int i) {
        PackageInfo packageInfo;
        try {
            init(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        if (!shouldCall()) {
            com.kwad.sdk.core.d.c.d("PackageInfoLimiter", "调用频次过高，跳过本次调用");
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        HashMap<String, PackageInfo> hashMap = sPackageInfoHashMap;
        if (hashMap != null) {
            hashMap.put(str, packageInfo);
        }
        return packageInfo;
    }

    private static void init(Context context) {
        if (mHasInit.compareAndSet(false, true)) {
            long j = context.getSharedPreferences("ksadsdk_config", 0).getLong("packageInfoLimiter", 0L);
            packageInfoLimiter = j;
            if (j > 0) {
                sPackageInfoHashMap = new HashMap<>();
            }
        }
    }

    private static synchronized boolean shouldCall() {
        synchronized (y.class) {
            if (packageInfoLimiter <= 0) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - mLastCallTime <= packageInfoLimiter) {
                return false;
            }
            mLastCallTime = currentTimeMillis;
            return true;
        }
    }

    private static /* synthetic */ void ystynx() {
        char[] charArray = "þòð³úüðø³ÿòä³îõøññ³×óôßïôùúø".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 157);
        }
        String str = new String(charArray);
        char[] charArray2 = "þñôóôé".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 157);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
