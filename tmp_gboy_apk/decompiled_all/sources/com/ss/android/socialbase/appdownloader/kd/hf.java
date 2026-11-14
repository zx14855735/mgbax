package com.ss.android.socialbase.appdownloader.kd;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf extends com.ss.android.socialbase.downloader.depend.u {
    private com.ss.android.socialbase.downloader.notification.xj c;
    private int hf;
    private String kd;
    private String u;
    private String w;
    private Context xj;
    private String y;

    public hf(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.xj = context.getApplicationContext();
        } else {
            this.xj = com.ss.android.socialbase.downloader.downloader.w.tj();
        }
        this.hf = i;
        this.w = str;
        this.u = str2;
        this.kd = str3;
        this.y = str4;
    }

    @Override // com.ss.android.socialbase.downloader.depend.u, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.xj == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.ss.android.socialbase.downloader.depend.u, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.u, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.u, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.u, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.u, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.xj == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.ss.android.socialbase.appdownloader.y.hf.xj(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.u
    public com.ss.android.socialbase.downloader.notification.xj xj() {
        Context context;
        com.ss.android.socialbase.downloader.notification.xj xjVar = this.c;
        return (xjVar != null || (context = this.xj) == null) ? xjVar : new xj(context, this.hf, this.w, this.u, this.kd, this.y);
    }

    public hf(com.ss.android.socialbase.downloader.notification.xj xjVar) {
        this.xj = com.ss.android.socialbase.downloader.downloader.w.tj();
        this.c = xjVar;
    }
}
