package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.tf;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    private static final Object kd = new Object();
    private static volatile hf w;
    private final long xj = 1000;
    private final Map<Integer, Long> hf = new HashMap();
    private final Set<String> u = new HashSet();
    private final SparseArray<xj> y = new SparseArray<>();

    static {
        ntJWuCe();
    }

    private hf() {
    }

    public static boolean hf(int i) {
        return i == 1 || i == 3;
    }

    private static /* synthetic */ void ntJWuCe() {
        char[] charArray = "ÓßÝ\u009e×ÑÝÕ\u009eÒßÉ\u009eÃØÕÜÜ\u009eúÞÙòÂÙÔ×Õ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 176);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÓÜÙÞÙÄ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 176);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean w(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && hf(downloadInfo.getNotificationVisibility());
    }

    public static hf xj() {
        if (w == null) {
            synchronized (hf.class) {
                try {
                    if (w == null) {
                        w = new hf();
                    }
                } finally {
                }
            }
        }
        return w;
    }

    public xj kd(int i) {
        xj xjVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.y) {
            xjVar = this.y.get(i);
        }
        return xjVar;
    }

    public xj u(int i) {
        xj xjVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.y) {
            try {
                xjVar = this.y.get(i);
                if (xjVar != null) {
                    this.y.remove(i);
                    com.ss.android.socialbase.downloader.w.xj.xj("removeNotificationId ".concat(String.valueOf(i)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xjVar;
    }

    public void y(int i) {
        u(i);
        if (i != 0) {
            xj().w(i);
        }
    }

    public void hf(DownloadInfo downloadInfo) {
        if (w(downloadInfo)) {
            y(downloadInfo.getId());
        }
    }

    public void w(int i) {
        Context tj = w.tj();
        if (tj == null || i == 0) {
            return;
        }
        Intent intent = new Intent(tj, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            if (com.ss.android.socialbase.downloader.f.xj.w().hf("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.c.xj.xj().xj(intent);
            } else {
                tj.startService(intent);
            }
        } catch (Throwable th) {
            pl.xj(th);
            if (com.ss.android.socialbase.downloader.f.xj.w().hf("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.c.xj.xj().xj(intent);
            }
        }
    }

    public SparseArray<xj> hf() {
        SparseArray<xj> sparseArray;
        synchronized (this.y) {
            sparseArray = this.y;
        }
        return sparseArray;
    }

    public void xj(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(w.tj()).getDownloadInfo(i);
        if (downloadInfo == null) {
            return;
        }
        xj(downloadInfo);
        hf(downloadInfo);
    }

    public void xj(DownloadInfo downloadInfo) {
        tf et = w.et();
        if (et != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                et.xj(downloadInfo);
            } catch (SQLiteException e) {
                pl.xj(e);
            }
        }
    }

    public void xj(int i, int i2, Notification notification) {
        Context tj = w.tj();
        if (tj == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.hf) {
                try {
                    Long l = this.hf.get(Integer.valueOf(i));
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l != null && Math.abs(currentTimeMillis - l.longValue()) < 1000) {
                        return;
                    } else {
                        this.hf.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                    }
                } finally {
                }
            }
        }
        Intent intent = new Intent(tj, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            if (com.ss.android.socialbase.downloader.f.xj.w().hf("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.c.xj.xj().xj(intent);
            } else {
                tj.startService(intent);
            }
        } catch (Throwable th) {
            pl.xj(th);
            if (com.ss.android.socialbase.downloader.f.xj.w().hf("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.c.xj.xj().xj(intent);
            }
        }
    }

    public void xj(xj xjVar) {
        if (xjVar == null) {
            return;
        }
        synchronized (this.y) {
            this.y.put(xjVar.xj(), xjVar);
        }
    }
}
