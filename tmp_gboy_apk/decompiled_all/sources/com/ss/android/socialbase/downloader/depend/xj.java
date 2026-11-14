package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class xj extends AbsDownloadListener implements v {
    private static final String xj = "xj";

    public void xj(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.w.xj.xj() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.w.xj.hf(xj, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
