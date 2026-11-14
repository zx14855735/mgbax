package com.ss.android.downloadlib.c;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {

    /* renamed from: com.ss.android.downloadlib.c.xj$xj, reason: collision with other inner class name */
    public static class C0469xj implements InvocationHandler {
        private Object xj;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                if ("startActivity".contains(method.getName())) {
                    xj.xj(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.xj, objArr);
        }

        private C0469xj(Object obj) {
            this.xj = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w() {
        try {
            Field declaredField = Build.VERSION.SDK_INT < 26 ? Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault") : Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return;
            }
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new C0469xj(obj2)));
        } catch (Throwable unused) {
        }
    }

    public static String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.xj.w.xj(new File(str));
    }

    public static String hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.pl.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int xj(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.ss.android.xj.w.xj(str, new File(str2));
    }

    public static void xj() {
        if (com.ss.android.downloadlib.addownload.pl.d().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.c.xj.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.y.kd.f();
                xj.w();
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    public static void xj(Object[] objArr) {
        if (com.ss.android.downloadlib.addownload.pl.d().optInt("hook", 0) == 1 && (objArr[1] instanceof String)) {
            Object obj = objArr[2];
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                if ("android.intent.action.VIEW".equals(intent.getAction()) && com.ss.android.socialbase.downloader.constants.kd.xj.equals(intent.getType())) {
                    if (com.ss.android.socialbase.appdownloader.y.kd.u()) {
                        String optString = com.ss.android.downloadlib.addownload.pl.d().optString("hook_vivo_arg", "com.android.settings");
                        if ("null".equals(optString)) {
                            return;
                        }
                        objArr[1] = optString;
                        return;
                    }
                    if (com.ss.android.socialbase.appdownloader.y.kd.kd()) {
                        String optString2 = com.ss.android.downloadlib.addownload.pl.d().optString("hook_kllk_arg1", "com." + com.ss.android.socialbase.downloader.constants.kd.w + ".market");
                        if (!"null".equals(optString2)) {
                            objArr[1] = optString2;
                        }
                        String optString3 = com.ss.android.downloadlib.addownload.pl.d().optString("hook_kllk_arg2", BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO);
                        String optString4 = com.ss.android.downloadlib.addownload.pl.d().optString("hook_kllk_arg3", "m.store." + com.ss.android.socialbase.downloader.constants.kd.w + "mobile.com");
                        intent.putExtra(com.ss.android.socialbase.downloader.constants.kd.w + "_extra_pkg_name", optString3);
                        intent.putExtra("refererHost", optString4);
                        if (com.ss.android.downloadlib.addownload.pl.d().optInt("hook_kllk_arg4", 0) == 1) {
                            Intent intent2 = new Intent();
                            intent2.putExtra(com.ss.android.socialbase.downloader.constants.kd.w + "_extra_pkg_name", optString3);
                            intent2.putExtra("refererHost", optString4);
                            intent.putExtra("android.intent.extra.INTENT", intent2);
                            return;
                        }
                        return;
                    }
                    if (com.ss.android.socialbase.appdownloader.y.kd.xj()) {
                        String optString5 = com.ss.android.downloadlib.addownload.pl.d().optString("hook_huawei_arg1", "com.huawei.appmarket");
                        if (!"null".equals(optString5)) {
                            objArr[1] = optString5;
                        }
                        intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.pl.d().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                    }
                }
            }
        }
    }
}
