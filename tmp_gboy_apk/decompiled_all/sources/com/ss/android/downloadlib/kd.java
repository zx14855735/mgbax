package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd {
    private ExecutorService hf;
    private ExecutorService u;
    private ScheduledExecutorService w;
    private ExecutorService xj;

    public static class xj {
        private static kd xj = new kd();

        static {
            XwWk();
        }

        private static /* synthetic */ void XwWk() {
            char[] charArray = "¥©«è¡§«£è¤©¿èµ®£ªªè\u008c¨¯\u0084´¯¢¡£".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 198);
            }
            String str = new String(charArray);
            char[] charArray2 = "¥ª¯¨¯²".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 198);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static kd xj() {
        return xj.xj;
    }

    public void hf(Runnable runnable) {
        hf(runnable, false);
    }

    public ExecutorService kd() {
        if (this.u == null) {
            synchronized (kd.class) {
                try {
                    if (this.u == null) {
                        this.u = new com.bytedance.sdk.component.tf.u.u(5, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.d.xj(tf.class.getName().concat("-InstallFinishCheckCPUThreadPool")));
                    }
                } finally {
                }
            }
        }
        return this.u;
    }

    public ScheduledExecutorService u() {
        if (this.w == null) {
            synchronized (kd.class) {
                try {
                    if (this.w == null) {
                        this.w = new com.bytedance.sdk.component.tf.u.kd(0, new com.ss.android.socialbase.downloader.d.xj(tf.class.getName().concat("-ScheduledThreadPool")));
                    }
                } finally {
                }
            }
        }
        return this.w;
    }

    public void w(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        kd().execute(runnable);
    }

    public void y() {
        xj(new Runnable() { // from class: com.ss.android.downloadlib.kd.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.downloader.tf et;
                synchronized (kd.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i = 0; i < 13; i++) {
                            SharedPreferences xj2 = com.bytedance.sdk.openadsdk.ats.u.xj(pl.getContext(), strArr[i], 0);
                            if (xj2 != null) {
                                xj2.edit().clear().apply();
                            }
                        }
                        et = com.ss.android.socialbase.downloader.downloader.w.et();
                    } catch (Throwable unused) {
                    }
                    if (et instanceof com.ss.android.socialbase.downloader.impls.u) {
                        SparseArray<DownloadInfo> xj3 = ((com.ss.android.socialbase.downloader.impls.u) et).xj().xj();
                        for (int size = xj3.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = xj3.get(xj3.keyAt(size));
                            if (downloadInfo != null) {
                                Downloader.getInstance(pl.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    }
                }
            }
        });
    }

    private kd() {
    }

    public void hf(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || g.hf()) {
            w().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public ExecutorService w() {
        if (this.hf == null) {
            synchronized (kd.class) {
                try {
                    if (this.hf == null) {
                        this.hf = new com.bytedance.sdk.component.tf.u.u(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.d.xj(tf.class.getName().concat("-IOThreadPool")));
                    }
                } finally {
                }
            }
        }
        return this.hf;
    }

    public void xj(Runnable runnable) {
        xj(runnable, false);
    }

    public void xj(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !g.hf()) {
            runnable.run();
        } else {
            hf().execute(runnable);
        }
    }

    public ExecutorService hf() {
        if (this.xj == null) {
            synchronized (kd.class) {
                try {
                    if (this.xj == null) {
                        this.xj = new com.bytedance.sdk.component.tf.u.u(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.d.xj(tf.class.getName().concat("-CPUThreadPool")));
                    }
                } finally {
                }
            }
        }
        return this.xj;
    }

    public void xj(Runnable runnable, long j) {
        try {
            u().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }
}
