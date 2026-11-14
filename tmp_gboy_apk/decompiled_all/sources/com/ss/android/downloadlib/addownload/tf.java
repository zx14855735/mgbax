package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.model.DownloadShortInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class tf {
    public static int xj(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !xj(i)) ? i2 : (int) (Math.sqrt(i2) * 10.0d);
    }

    public static long xj(int i, long j, long j2) {
        if (xj(i)) {
            if (j <= 0) {
                return 0L;
            }
            if (j2 > 0) {
                return (j2 * xj(i, (int) ((j * 100) / j2))) / 100;
            }
        }
        return j;
    }

    public static DownloadShortInfo xj(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && xj((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = xj((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean xj(int i) {
        return com.ss.android.socialbase.downloader.f.xj.xj(i).xj("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.ss.android.socialbase.downloader.f.xj.xj(i).xj("pause_optimise_switch", 0) == 1;
    }
}
