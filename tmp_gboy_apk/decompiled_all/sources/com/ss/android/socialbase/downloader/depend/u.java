package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class u extends AbsDownloadListener implements v {
    private void hf(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.xj kd = com.ss.android.socialbase.downloader.notification.hf.xj().kd(downloadInfo.getId());
        if (kd != null) {
            kd.xj(downloadInfo);
        } else {
            com.ss.android.socialbase.downloader.notification.hf.xj().xj(xj());
        }
    }

    private void w(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            com.ss.android.socialbase.downloader.notification.xj kd = com.ss.android.socialbase.downloader.notification.hf.xj().kd(downloadInfo.getId());
            if (kd == null) {
                kd = xj();
            }
            kd.xj(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    private void xj(int i, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.xj kd = com.ss.android.socialbase.downloader.notification.hf.xj().kd(downloadInfo.getId());
        if (kd == null) {
            kd = xj();
        }
        kd.hf(downloadInfo.getTotalBytes());
        if (i == -3) {
            kd.xj(downloadInfo.getTotalBytes());
        } else {
            kd.xj(downloadInfo.getCurBytes());
        }
        kd.xj(i, baseException, z);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        xj(-1, downloadInfo, baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        xj(-2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        hf(downloadInfo);
        xj(1, downloadInfo, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        w(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        xj(2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        xj(-3, downloadInfo, null, false);
    }

    public abstract com.ss.android.socialbase.downloader.notification.xj xj();

    @Override // com.ss.android.socialbase.downloader.depend.v
    public void xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        xj(11, downloadInfo, null, true);
    }
}
