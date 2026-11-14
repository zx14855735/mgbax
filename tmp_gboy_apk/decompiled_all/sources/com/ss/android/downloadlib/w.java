package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.downloadlib.c.p;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.xj.xj;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w implements com.ss.android.socialbase.appdownloader.w.d {
    private static String xj = "w";
    private Handler hf = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.w.d
    public void xj(DownloadInfo downloadInfo, BaseException baseException, int i) {
        BaseException baseException2;
        final DownloadModel xj2;
        if (downloadInfo == null) {
            return;
        }
        if (i == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.c.y.w(downloadInfo, jSONObject);
            xj.xj(jSONObject, downloadInfo);
            p.xj(PointCategory.DOWNLOAD_FAILED, jSONObject.toString());
        }
        com.ss.android.downloadad.api.xj.hf xj3 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo);
        if (xj3 == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    xj.xj(downloadInfo, xj3);
                    return;
                }
                if (i == 2001) {
                    xj.xj().xj(downloadInfo, xj3, 2001);
                    return;
                } else {
                    if (i == 11) {
                        xj.xj().xj(downloadInfo, xj3, 2000);
                        if (xj3.vm()) {
                            return;
                        }
                        xj(downloadInfo, xj3);
                        return;
                    }
                    return;
                }
            }
            if (baseException != null) {
                if (com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.hf.post(new Runnable() { // from class: com.ss.android.downloadlib.w.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pl.w().xj(5, pl.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.tf.y.f(baseException)) {
                    if (pl.g() != null) {
                        pl.g();
                        xj3.hf();
                    }
                    com.ss.android.downloadlib.u.xj.xj().xj("download_failed_for_space", xj3);
                    if (!xj3.yy()) {
                        com.ss.android.downloadlib.u.xj.xj().xj("download_can_restart", xj3);
                        xj(downloadInfo);
                    }
                    if ((pl.g() == null || !pl.g().w()) && (xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(xj3.hf())) != null && xj2.isShowToast()) {
                        final com.ss.android.socialbase.downloader.f.xj xj4 = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId());
                        if (xj4.xj("show_no_enough_space_toast", 0) == 1) {
                            this.hf.post(new Runnable() { // from class: com.ss.android.downloadlib.w.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    pl.w().xj(2, pl.getContext(), xj2, xj4.xj("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), g.xj(baseException.getMessage(), pl.d().optInt("exception_msg_length", 500)));
            } else {
                baseException2 = null;
            }
            com.ss.android.downloadlib.u.xj.xj().hf(downloadInfo, baseException2);
            f.xj().xj(downloadInfo, baseException, "");
        } catch (Exception e) {
            pl.jk().xj(e, "onAppDownloadMonitorSend");
        }
    }

    private void xj(final DownloadInfo downloadInfo, final com.ss.android.downloadad.api.xj.hf hfVar) {
        final long xj2 = g.xj(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, g.xj(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d = (totalBytes * 2.5d) + min;
        if (xj2 > -1 && totalBytes > -1) {
            double d2 = xj2;
            if (d2 < d && d - d2 > com.ss.android.downloadlib.addownload.u.hf()) {
                com.ss.android.downloadlib.addownload.u.xj(downloadInfo.getId());
            }
        }
        com.ss.android.socialbase.downloader.xj.xj.xj().xj(new xj.InterfaceC0510xj() { // from class: com.ss.android.downloadlib.w.3
            @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
            public void hf() {
                if (g.hf(hfVar)) {
                    com.ss.android.socialbase.downloader.xj.xj.xj().hf(this);
                    return;
                }
                long j = xj2;
                if (j <= -1 || totalBytes <= -1 || j >= d) {
                    return;
                }
                com.ss.android.downloadlib.u.xj.xj().xj("clean_space_install", com.ss.android.downloadlib.addownload.u.xj("install_no_enough_space"), hfVar);
                if (com.ss.android.downloadlib.addownload.u.xj(downloadInfo, ((long) d) - xj2)) {
                    com.ss.android.socialbase.downloader.xj.xj.xj().hf(this);
                    hfVar.c(true);
                }
            }

            @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
            public void w() {
            }
        });
    }

    private void xj(DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.c.kd.y(downloadInfo.getId())) {
            kd.xj().hf(new com.ss.android.downloadlib.addownload.w.hf(downloadInfo));
        }
    }
}
