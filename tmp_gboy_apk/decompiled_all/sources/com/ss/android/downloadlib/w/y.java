package com.ss.android.downloadlib.w;

import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y implements com.ss.android.socialbase.appdownloader.w.kd {
    private Context xj;

    public y(Context context) {
        this.xj = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.w.kd
    public void xj(Context context, String str) {
        com.ss.android.downloadlib.xj.xj().xj(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.w.kd
    public void xj(int i, int i2, String str, int i3, long j) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.xj.hf xj;
        Context context = this.xj;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() == 0 || (xj = com.ss.android.downloadlib.addownload.hf.y.xj().xj(downloadInfo)) == null) {
            return;
        }
        if (i2 == 1) {
            com.ss.android.downloadlib.xj.xj(downloadInfo, xj);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.xj.xj().xj(downloadInfo, xj.hf(), xj.pl(), xj.kd(), downloadInfo.getTitle(), xj.u(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i2 == 3) {
            com.ss.android.downloadlib.u.xj.xj().xj("download_notification", "download_notification_install", com.ss.android.downloadlib.xj.hf(new JSONObject(), downloadInfo), xj);
            return;
        }
        if (i2 == 5) {
            com.ss.android.downloadlib.u.xj.xj().xj("download_notification", "download_notification_pause", xj);
        } else if (i2 == 6) {
            com.ss.android.downloadlib.u.xj.xj().xj("download_notification", "download_notification_continue", xj);
        } else {
            if (i2 != 7) {
                return;
            }
            com.ss.android.downloadlib.u.xj.xj().xj("download_notification", "download_notification_click", xj);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.w.kd
    public boolean xj(int i, boolean z) {
        if (pl.qt() != null) {
            return pl.qt().xj(z);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.w.kd
    public void xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.f.xj().xj(downloadInfo);
        if (com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.u.xj.xj().xj(downloadInfo, new BaseException(1012, ""));
        } else {
            com.ss.android.downloadlib.u.xj.xj().hf(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.w.kd
    public void xj(int i, int i2, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.xj;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.hf.xj().xj(this.xj, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.w.kd
    public boolean xj() {
        return com.ss.android.downloadlib.addownload.hf.xj().hf();
    }
}
