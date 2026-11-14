package com.ss.android.socialbase.downloader.tf;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    public static boolean hf(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).hf("optimize_save_path") == 1;
    }

    public static boolean xj(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).hf("optimize_head_request") == 1;
    }
}
