package com.ss.android.downloadlib.addownload.hf;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.pl;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    private static volatile u xj;
    private final LinkedList<xj> hf = new LinkedList<>();
    private static final String[] w = {"com", "android", "ss"};
    private static final int[] u = {3101, 3102, 3103, 3201, 3202, 3203};

    public static class xj {
        public final int hf;
        public final long kd;
        public final String u;
        public final String w;
        public final String xj;

        private xj(String str, int i, String str2, String str3, long j) {
            this.xj = str;
            this.hf = i;
            this.w = str2 != null ? str2.toLowerCase() : null;
            this.u = str3 != null ? str3.toLowerCase() : null;
            this.kd = j;
        }
    }

    private u() {
    }

    private xj w(String str) {
        try {
            PackageManager packageManager = pl.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new xj(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return null;
        }
    }

    public static u xj() {
        if (xj == null) {
            synchronized (u.class) {
                try {
                    if (xj == null) {
                        xj = new u();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void hf(String str) {
        hf();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.hf) {
            try {
                Iterator<xj> it = this.hf.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().xj)) {
                        it.remove();
                        return;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xj(String str) {
        xj w2;
        hf();
        if (TextUtils.isEmpty(str) || (w2 = w(str)) == null) {
            return;
        }
        synchronized (this.hf) {
            this.hf.add(w2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0099, code lost:
    
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.hf.u.xj, java.lang.Integer> hf(com.ss.android.downloadad.api.xj.hf r19) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.hf.u.hf(com.ss.android.downloadad.api.xj.hf):android.util.Pair");
    }

    public xj xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        if (hfVar == null) {
            return null;
        }
        hf();
        synchronized (this.hf) {
            try {
                Iterator<xj> it = this.hf.iterator();
                while (it.hasNext()) {
                    xj next = it.next();
                    if (next.kd > hfVar.q()) {
                        return next;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean xj(String str, String str2) {
        String[] split;
        String[] split2;
        boolean z;
        try {
            split = str.split("\\.");
            split2 = str2.split("\\.");
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
        if (split.length != 0 && split2.length != 0) {
            int i = 0;
            int i2 = 0;
            for (String str3 : split) {
                String[] strArr = w;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    String str4 = strArr[i3];
                    if (str4.equals(str3)) {
                        if (i < split2.length && str4.equals(split2[i])) {
                            i++;
                        }
                        z = true;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    int i4 = i2;
                    int i5 = i;
                    while (i < split2.length) {
                        if (str3.equals(split2[i])) {
                            if (i == i5) {
                                i5++;
                            }
                            i4++;
                            if (i4 >= 2) {
                                return true;
                            }
                        }
                        i++;
                    }
                    i = i5;
                    i2 = i4;
                }
            }
            return false;
        }
        return false;
    }

    private void hf() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.hf) {
            try {
                Iterator<xj> it = this.hf.iterator();
                while (it.hasNext() && currentTimeMillis - it.next().kd > 1800000) {
                    it.remove();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
