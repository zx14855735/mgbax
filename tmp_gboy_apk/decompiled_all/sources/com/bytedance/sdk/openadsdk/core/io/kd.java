package com.bytedance.sdk.openadsdk.core.io;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.io;
import com.bytedance.sdk.openadsdk.core.pz;
import com.sigmob.sdk.downloader.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private static volatile kd kd = null;
    private static final String xj = "kd";
    private final CopyOnWriteArraySet<String> hf = new CopyOnWriteArraySet<>();
    private final List<WeakReference<y>> w = new ArrayList(1);
    private final List<y> u = new ArrayList(1);

    private kd() {
        hf();
    }

    private void hf() {
        w();
    }

    private void w() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = pz.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, f.a.c)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.hf.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static kd xj() {
        if (kd == null) {
            synchronized (kd.class) {
                try {
                    if (kd == null) {
                        kd = new kd();
                    }
                } finally {
                }
            }
        }
        return kd;
    }

    public boolean hf(Context context, String str) {
        if (context == null) {
            return false;
        }
        return io.zg() ? w.xj(context, str) && hf.xj(context, str) == 0 : hf.xj(context, str) == 0;
    }

    private void hf(Activity activity, String[] strArr, y yVar) {
        boolean xj2;
        for (String str : strArr) {
            if (yVar != null) {
                try {
                    if (!this.hf.contains(str)) {
                        xj2 = yVar.xj(str, u.NOT_FOUND);
                    } else if (hf.xj(activity, str) != 0) {
                        xj2 = yVar.xj(str, u.DENIED);
                    } else {
                        xj2 = yVar.xj(str, u.GRANTED);
                    }
                    if (xj2) {
                        break;
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        }
        xj(yVar);
    }

    private synchronized void xj(String[] strArr, y yVar) {
        if (yVar == null) {
            return;
        }
        yVar.xj(strArr);
        this.u.add(yVar);
        this.w.add(new WeakReference<>(yVar));
    }

    private List<String> w(Activity activity, String[] strArr, y yVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.hf.contains(str)) {
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

    private synchronized void xj(y yVar) {
        try {
            Iterator<WeakReference<y>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<y> next = it.next();
                if (next.get() != yVar && next.get() != null) {
                }
                it.remove();
            }
            Iterator<y> it2 = this.u.iterator();
            while (it2.hasNext()) {
                if (it2.next() == yVar) {
                    it2.remove();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean xj(Context context, String str) {
        if (context == null) {
            return false;
        }
        return io.zg() ? w.xj(context, str) && hf.xj(context, str) == 0 : hf.xj(context, str) == 0;
    }

    public synchronized void xj(Activity activity, String[] strArr, y yVar) {
        if (activity == null) {
            return;
        }
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
                hf.requestPermissions(activity, (String[]) w.toArray(new String[w.size()]), 1);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public synchronized void xj(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if (iArr[i] != -1) {
                    if (io.zg() && !w.xj(activity, str)) {
                    }
                }
                if (iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            xj(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private void xj(String[] strArr, int[] iArr, String[] strArr2) {
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
            Iterator<y> it2 = this.u.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }
}
