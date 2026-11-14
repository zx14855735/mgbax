package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ay {
    private static String bfh = "";
    private static volatile Boolean bfi;

    private static String SY() {
        String processName;
        if (Build.VERSION.SDK_INT < 28) {
            return "";
        }
        processName = Application.getProcessName();
        return processName;
    }

    private static String SZ() {
        try {
            Object callStaticMethod = z.callStaticMethod(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return callStaticMethod instanceof String ? (String) callStaticMethod : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String dy(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
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
        return "";
    }

    public static String getProcessName(Context context) {
        if (!TextUtils.isEmpty(bfh)) {
            return bfh;
        }
        String SY = SY();
        bfh = SY;
        if (!TextUtils.isEmpty(SY)) {
            return bfh;
        }
        String SZ = SZ();
        bfh = SZ;
        if (!TextUtils.isEmpty(SZ)) {
            return bfh;
        }
        String dy = dy(context);
        bfh = dy;
        return dy;
    }

    public static boolean isInMainProcess(Context context) {
        if (bfi == null) {
            String processName = getProcessName(context);
            bfi = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return bfi.booleanValue();
    }
}
