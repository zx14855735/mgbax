package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class i {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static volatile String f12964A2egSU;

    public static synchronized String a(String str) {
        synchronized (i.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return str;
                }
                String str2 = f12964A2egSU;
                if (TextUtils.isEmpty(str2)) {
                    return str;
                }
                boolean endsWith = str2.endsWith("_");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(endsWith ? "" : "_");
                sb.append(d.a(str2));
                return sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized String a(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        String processName;
        synchronized (i.class) {
            if (!TextUtils.isEmpty(f12964A2egSU)) {
                return f12964A2egSU;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                f12964A2egSU = processName;
                return f12964A2egSU;
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    try {
                        next = it.next();
                    } catch (Exception unused) {
                    }
                    if (next.pid == myPid) {
                        f12964A2egSU = next.processName;
                        return f12964A2egSU;
                    }
                    continue;
                }
            }
            return null;
        }
    }
}
