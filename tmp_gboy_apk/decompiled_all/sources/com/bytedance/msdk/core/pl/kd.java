package com.bytedance.msdk.core.pl;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.f.x;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.downloader.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static kd u;
    private final Set<String> xj = new HashSet(1);
    private final List<y> hf = new ArrayList(1);
    private final List<WeakReference<y>> w = new ArrayList(1);

    private kd() {
        hf();
    }

    private void hf() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = com.bytedance.msdk.core.hf.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, f.a.c)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.xj.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private List<String> w(Activity activity, String[] strArr, y yVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.xj.contains(str)) {
                if (!xj(activity, str)) {
                    arrayList.add(str);
                } else if (yVar != null) {
                    yVar.xj(str, u.GRANTED);
                }
            } else if (yVar != null) {
                yVar.xj(str, u.NOT_FOUND);
            }
        }
        return arrayList;
    }

    public static kd xj() {
        if (u == null) {
            u = new kd();
        }
        return u;
    }

    private synchronized void xj(String[] strArr, y yVar) {
        if (yVar != null) {
            yVar.xj(strArr);
            this.hf.add(yVar);
            this.w.add(new WeakReference<>(yVar));
        }
    }

    private synchronized void xj(y yVar) {
        try {
            Iterator<WeakReference<y>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<y> next = it.next();
                if (next.get() != yVar && next.get() != null) {
                }
                it.remove();
            }
            Iterator<y> it2 = this.hf.iterator();
            while (it2.hasNext()) {
                if (it2.next() == yVar) {
                    it2.remove();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void hf(Activity activity, String[] strArr, y yVar) {
        boolean xj;
        for (String str : strArr) {
            if (yVar != null) {
                try {
                    if (!this.xj.contains(str)) {
                        xj = yVar.xj(str, u.NOT_FOUND);
                    } else if (w.xj(activity, str) != 0) {
                        xj = yVar.xj(str, u.DENIED);
                    } else {
                        xj = yVar.xj(str, u.GRANTED);
                    }
                    if (xj) {
                        break;
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        }
        xj(yVar);
    }

    public synchronized boolean xj(Context context, String str) {
        if (context != null) {
            return x.kd() ? hf.xj(context, str) && (w.xj(context, str) == 0 || !this.xj.contains(str)) : w.xj(context, str) == 0 || !this.xj.contains(str);
        }
        return false;
    }

    public synchronized void xj(Activity activity, String[] strArr, y yVar) {
        if (activity != null) {
            try {
                xj(strArr, yVar);
                if (Build.VERSION.SDK_INT < 23) {
                    hf(activity, strArr, yVar);
                    return;
                }
                List<String> w = w(activity, strArr, yVar);
                if (w.isEmpty()) {
                    xj(yVar);
                } else {
                    w.requestPermissions(activity, (String[]) w.toArray(new String[w.size()]), 1);
                }
            } finally {
            }
        }
    }

    public synchronized void xj(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if (iArr[i] != -1) {
                    if (x.kd() && !hf.xj(activity, str)) {
                    }
                }
                if (iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            xj(strArr, iArr);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private void xj(String[] strArr, int[] iArr) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<y>> it = this.w.iterator();
            while (it.hasNext()) {
                y yVar = it.next().get();
                while (i < length) {
                    i = (yVar == null || yVar.xj(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<y> it2 = this.hf.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }
}
