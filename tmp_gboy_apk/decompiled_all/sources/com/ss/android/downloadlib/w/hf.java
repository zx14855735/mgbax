package com.ss.android.downloadlib.w;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements g {
    @Override // com.ss.android.socialbase.downloader.depend.g
    public boolean hf(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.c.kd.hf() && downloadInfo.getPackageInfo() == null;
    }

    @Override // com.ss.android.socialbase.downloader.depend.g
    public void xj(DownloadInfo downloadInfo) {
        PackageInfo xj = com.ss.android.socialbase.appdownloader.w.xj(pl.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (xj != null) {
            downloadInfo.setAppVersionCode(xj.versionCode);
        }
    }
}
