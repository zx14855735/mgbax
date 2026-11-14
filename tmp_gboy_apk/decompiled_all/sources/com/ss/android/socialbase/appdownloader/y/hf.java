package com.ss.android.socialbase.appdownloader.y;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    private static void hf(final DownloadInfo downloadInfo) {
        final Context tj = com.ss.android.socialbase.downloader.downloader.w.tj();
        final int xj = (((!downloadInfo.isAutoResumed() || downloadInfo.isShowNotificationForNetworkResumed()) && !com.ss.android.socialbase.appdownloader.w.hf(downloadInfo.getExtra()) && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK)) || com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("auto_install_when_resume", 0) == 1) ? com.ss.android.socialbase.appdownloader.w.xj(tj, downloadInfo.getId(), false) : 2;
        com.ss.android.socialbase.downloader.downloader.w.pl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.y.hf.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.w.kd w = com.ss.android.socialbase.appdownloader.u.p().w();
                io downloadNotificationEventListener = Downloader.getInstance(tj).getDownloadNotificationEventListener(downloadInfo.getId());
                if (w == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo xj2 = com.ss.android.socialbase.appdownloader.w.xj(downloadInfo, file);
                        if (xj2 != null) {
                            String packageName = (xj == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? xj2.packageName : downloadInfo.getPackageName();
                            if (w != null) {
                                w.xj(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.xj(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception e) {
                        pl.xj(e);
                    }
                }
            }
        });
    }

    public static void xj(DownloadInfo downloadInfo) {
        hf(downloadInfo);
    }
}
