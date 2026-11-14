package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.sigmob.sdk.base.views.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class ey {

    public static class xj implements Runnable {
        private final String hf;
        private final String w = Log.getStackTraceString(new RuntimeException("origin stacktrace"));
        private final Runnable xj;

        public xj(Runnable runnable, String str) {
            this.xj = runnable;
            this.hf = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.xj.run();
            } catch (Exception e) {
                cu.w("Thread:" + this.hf + " exception\n" + this.w, e);
            }
        }
    }

    public static boolean xj(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, r.b.d) != null;
    }

    public static boolean xj(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
            return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
        }
        return true;
    }

    public static void xj(String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new com.bytedance.sdk.component.tf.u.w(new xj(runnable, str), str).start();
    }
}
