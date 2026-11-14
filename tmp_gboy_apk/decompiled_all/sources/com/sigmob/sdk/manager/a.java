package com.sigmob.sdk.manager;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntityActive;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13437a = "AppStatusManager";
    private static volatile a b;
    private volatile boolean c;
    private volatile long d;
    private Timer e;
    private String f;
    private long g;
    private boolean h;

    private a() {
        a(3L);
    }

    private synchronized void e() {
        SigmobLogger.d(f13437a, "cancelTimer", new Object[0]);
        Timer timer = this.e;
        if (timer == null) {
            return;
        }
        timer.cancel();
        this.e = null;
    }

    public synchronized void d() {
        SigmobLogger.d(f13437a, "stopAppStatusCheck: running = " + this.c, new Object[0]);
        if (this.c) {
            e();
            this.c = false;
        }
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = new a();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public static boolean b() {
        Context e = com.sigmob.sdk.b.e();
        if (e == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) e.getSystemService(TTDownloadField.TT_ACTIVITY);
        String packageName = e.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo.importance == 100;
    }

    public synchronized void a(long j) {
        if (j <= 0) {
            SigmobLogger.e(f13437a, "startAppStatusCheck: interval is unavailable.", new Object[0]);
            return;
        }
        boolean z = j == this.d;
        SigmobLogger.d(f13437a, "startAppStatusCheck: status = " + this.c + ", interval = " + j + ", result = " + z, new Object[0]);
        if (this.c && z) {
            return;
        }
        e();
        long j2 = j * 1000;
        Timer timer = new Timer();
        this.e = timer;
        timer.schedule(new TimerTask() { // from class: com.sigmob.sdk.manager.a.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean c = a.c();
                if (a.this.h == c) {
                    return;
                }
                if (c) {
                    a.this.g = System.currentTimeMillis();
                    a.this.f = UUID.randomUUID().toString();
                    PointEntityActive.ActiveTracking(PointCategory.SESSION_START, a.this.f, Constants.FAIL, String.valueOf(a.this.g));
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    PointEntityActive.ActiveTracking(PointCategory.SESSION_END, a.this.f, String.valueOf((currentTimeMillis - a.this.g) / 1000), String.valueOf(currentTimeMillis));
                }
                a.this.h = c;
            }
        }, j2, j2);
        this.c = true;
        this.d = j;
        SigmobLogger.d(f13437a, "startAppStatusCheck: status = " + this.c, new Object[0]);
    }
}
