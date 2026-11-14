package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {

    public static class xj {
        private boolean c;
        private String hf;
        private String kd;
        private String u;
        private Drawable w;
        private String xj;
        private int y;

        public xj(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            hf(str2);
            xj(drawable);
            xj(str);
            w(str3);
            u(str4);
            xj(i);
            xj(z);
        }

        public String c() {
            return this.kd;
        }

        public boolean hf() {
            return this.c;
        }

        public String kd() {
            return this.u;
        }

        public String toString() {
            return "{\n  pkg name: " + w() + "\n  app icon: " + xj() + "\n  app name: " + u() + "\n  app path: " + kd() + "\n  app v name: " + c() + "\n  app v code: " + y() + "\n  is system: " + hf() + "}";
        }

        public String u() {
            return this.hf;
        }

        public String w() {
            return this.xj;
        }

        public Drawable xj() {
            return this.w;
        }

        public int y() {
            return this.y;
        }

        public void hf(String str) {
            this.hf = str;
        }

        public void u(String str) {
            this.kd = str;
        }

        public void w(String str) {
            this.u = str;
        }

        public void xj(Drawable drawable) {
            this.w = drawable;
        }

        public void xj(boolean z) {
            this.c = z;
        }

        public void xj(String str) {
            this.xj = str;
        }

        public void xj(int i) {
            this.y = i;
        }
    }

    public static xj hf(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.w.tj().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return xj(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            com.ss.android.socialbase.downloader.w.xj.kd("AppUtils", "getAppInfo:" + e.getMessage());
            return null;
        }
    }

    private static boolean w(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int xj(String str) {
        if (w(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.w.tj().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.ss.android.socialbase.downloader.w.xj.kd("AppUtils", "getAppVersionCode:" + e.getMessage());
            return -1;
        }
    }

    private static xj xj(PackageManager packageManager, PackageInfo packageInfo) {
        String str;
        Drawable drawable = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str2 = packageInfo.packageName;
        if (applicationInfo != null && applicationInfo.loadLabel(packageManager) != null) {
            str = applicationInfo.loadLabel(packageManager).toString();
        } else {
            str = "";
        }
        String str3 = str;
        try {
            drawable = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new xj(str2, str3, drawable, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
