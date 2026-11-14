package com.kwad.sdk.liteapi;

import A5SV6n.A2egSU;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class PackageManagerUtils {
    public static AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static long mLastCallTime;
    private static long packageInfoLimiter;
    private static HashMap<String, PackageInfo> sPackageInfoHashMap;

    static {
        HMZWTc();
    }

    private static /* synthetic */ void HMZWTc() {
        char[] charArray = ";75v?95=v:7!v+0=44v\u001261\u001a*1<?=".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'X');
        }
        String str = new String(charArray);
        char[] charArray2 = ";4161,".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'X');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static PackageInfo getPackageInfo(Context context, String str, int i) {
        HashMap<String, PackageInfo> hashMap;
        PackageInfo packageInfo;
        try {
            init(context);
            hashMap = sPackageInfoHashMap;
        } catch (Throwable th) {
            LiteApiLogger.printStackTraceOnly(th);
        }
        if (hashMap != null && hashMap.containsKey(str)) {
            return sPackageInfoHashMap.get(str);
        }
        if (!shouldCall()) {
            LiteApiLogger.d("PackageInfoLimiter", "调用频次过高，跳过本次调用");
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
            LiteApiLogger.printStackTraceOnly(th);
        }
        if (!shouldCall()) {
            LiteApiLogger.d("PackageInfoLimiter", "调用频次过高，跳过本次调用");
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, i);
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
        synchronized (PackageManagerUtils.class) {
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
}
