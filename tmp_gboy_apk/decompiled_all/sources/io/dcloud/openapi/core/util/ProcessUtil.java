package io.dcloud.openapi.core.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ProcessUtil {
    private static String aaaaaaaa;

    public static String getCurrentProcessName(Context context) {
        if (!TextUtils.isEmpty(aaaaaaaa)) {
            return aaaaaaaa;
        }
        String currentProcessNameByApplication = getCurrentProcessNameByApplication();
        aaaaaaaa = currentProcessNameByApplication;
        if (!TextUtils.isEmpty(currentProcessNameByApplication)) {
            return aaaaaaaa;
        }
        String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
        aaaaaaaa = currentProcessNameByActivityThread;
        if (!TextUtils.isEmpty(currentProcessNameByActivityThread)) {
            return aaaaaaaa;
        }
        String currentProcessNameByActivityManager = getCurrentProcessNameByActivityManager(context);
        aaaaaaaa = currentProcessNameByActivityManager;
        return currentProcessNameByActivityManager;
    }

    public static String getCurrentProcessNameByActivityManager(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    public static String getCurrentProcessNameByActivityThread() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getCurrentProcessNameByApplication() {
        String processName;
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        processName = Application.getProcessName();
        return processName;
    }

    public static boolean isMainProcess(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageName().equals(getCurrentProcessName(context));
        } catch (Exception unused) {
            return false;
        }
    }
}
